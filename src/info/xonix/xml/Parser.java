package info.xonix.xml;

import info.xonix.xml.elem.Tag;
import info.xonix.xml.elem.Text;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static info.xonix.xml.ParserState.*;

/**
 * User: gubarkov
 * Date: 21.08.12
 * Time: 17:57
 */
public class Parser {
    private Deque<Tag> tagStack = new ArrayDeque<>();
    private ParserState state = OUTER;

    public Tag parse(List<Token> tokens) {
        String attrName = null;
//        String tagName = null;

        final Tag documentTag = new Tag();
        documentTag.setName("#DOCUMENT");
        tagStack.add(documentTag);

        for (Token token : tokens) {
            switch (token.type) {
                case TAG_OPEN: {
                    if (state == OUTER) {
                        changeState(TAG_OPEN);

                        Tag tag = new Tag();
                        tagStack.addLast(tag);
                    }

                    break;
                }

                case TAG_OPEN_SLASH: {
                    changeState(ENDING_TAG_OPEN);
                    break;
                }

                case TEXT: {
                    if (state == TAG_OPEN) {
                        String text = token.text();
                        if (text.startsWith(" ") || text.length() == 0) {
                            throw error("");
                        }

                        currentTag().setName(text);
                        changeState(TAG_OPEN_AFTER_TAGNAME);
                    } else if (state == ENDING_TAG_OPEN) {
                        String text = token.text();

                        if (text.startsWith(" ") || text.length() == 0) {
                            throw error("");
                        }

                        final String openTagname = currentTag().getName();
                        if (!text.equals(openTagname)) {
                            throw error("openTag:" + openTagname + " != closeTag:" + text);
                        }

                    } else if (state == TAG_OPEN_AFTER_TAGNAME) {
                        String text = token.text().trim();
                        if (text.length() > 0) {
                            attrName = text;
                        }
                    } else if (state == TAG_OPEN_QUOTE_OPEN) {
                        currentTag().getAttributes().put(attrName, token.text());
                        attrName = null;
                    } else if (state == OUTER) {
                        currentTag().getNodes().add(new Text(token.text()));
                    } else if (state == COMMENT) {
                        // TBD
                    } else if (!"".equals(token.text().trim())) {
                        throw error("");
                    }

                    break;
                }

                case EQUAL: {
                    if (state == TAG_OPEN_AFTER_TAGNAME
                            || attrName != null) {
                        changeState(TAG_OPEN_AFTER_EQUAL);
                    } else {
                        throw error("");
                    }

                    break;
                }

                case QUOTE_BEGIN: {
                    if (state == TAG_OPEN_AFTER_EQUAL) {
                        changeState(TAG_OPEN_QUOTE_OPEN);
                    } else {
                        throw error("");
                    }

                    break;
                }

                case QUOTE_END: {
                    if (state == TAG_OPEN_QUOTE_OPEN) {
                        changeState(TAG_OPEN_AFTER_TAGNAME);
                    } else {
                        throw error("");
                    }

                    break;
                }

                case COMMENT_OPEN: {
                    changeState(COMMENT);
                    break;
                }

                case COMMENT_CLOSE: {
                    changeState(OUTER);
                    break;
                }

                case TAG_CLOSE: {
                    if (state == TAG_OPEN_AFTER_TAGNAME ||
                            state == ENDING_TAG_OPEN) {
                        if (state == ENDING_TAG_OPEN) {
                            moveLastTagToPrelast();
                        }

                        changeState(OUTER);
                    } else {
                        throw error("");
                    }

                    break;
                }

                case TAG_SLASH_CLOSE: {
                    if (state == TAG_OPEN_AFTER_TAGNAME) {
                        changeState(OUTER);
                        moveLastTagToPrelast();
                    } else {
                        throw error("");
                    }

                    break;
                }
            }
        }

        return tagStack.getFirst();
    }

    private void moveLastTagToPrelast() {
        if (tagStack.size() > 1) {
            Tag lastTag = tagStack.removeLast();
            currentTag().getNodes().add(lastTag);
        }
    }

    private Tag currentTag() {
        return tagStack.getLast();
    }

    private ParserException error(String s) {
        System.out.println("stack: " + tagStack);
        return new ParserException(s);
    }

    private void changeState(ParserState newState) {
        log("pstate " + state + " --> " + newState);
        state = newState;
    }

    private void log(String s) {
        System.out.println(s);
    }
}
