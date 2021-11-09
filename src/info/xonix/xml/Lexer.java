package info.xonix.xml;

import java.util.ArrayList;
import java.util.List;

import static info.xonix.xml.LexerState.*;

/**
 * User: gubarkov
 * Date: 19.08.12
 * Time: 0:25
 */
public class Lexer {
    private char[] chars;
    private List<Token> tokens = new ArrayList<>();
    private int currPos = -1;
    private LexerState state = OUTER;
//    private LexerState prevState = null;

    private int tokenStart = 0;
    private int tokenLen = 0;

    public List<Token> lex(String xml) {
        chars = xml.toCharArray();

        lex();

        return tokens;
    }

    private void log(String s) {
        System.out.println(s);
    }

    private void lex() {
        char c;
        Character lastQuote = null;

        while ((c = next()) > 0) {
            switch (c) {
                case ' ':
                case '\n':
                case '\t': {
                    if (state == INSIDE_ATTR_VALUE) {
                        addTokenChar();
                    } else if (state == TAG_ATTR_NAME) {
                        produceToken(TokenType.TEXT);
                        addTokenChar();
                        changeState(INSIDE_TAG);
                    } else {
                        addTokenChar();
                    }
                    break;
                }
                case '<': {
                    if (state == OUTER) {
                        produceTextIfNecessarry();

                        changeState(INSIDE_TAG);

                        addTokenChar();
                        if (seeNext('/')) {
                            nextAndAddTokenChar();
                            produceToken(TokenType.TAG_OPEN_SLASH);
                        } else if (seeNext('!', '-', '-')) {
                            nextAndAddTokenChar();
                            nextAndAddTokenChar();
                            nextAndAddTokenChar();
                            produceToken(TokenType.COMMENT_OPEN);
                            changeState(COMMENT);
                        } else {
                            produceToken(TokenType.TAG_OPEN);
                        }
                    } else if (state == COMMENT) {
                        addTokenChar();
                    } else {
                        throw error();
                    }
                    break;
                }
                case '-': {
                    if (state == COMMENT) {
                        if (seeNext('-', '>')) {
                            produceTextIfNecessarry();

                            addTokenChar();
                            nextAndAddTokenChar();
                            nextAndAddTokenChar();
                            produceToken(TokenType.COMMENT_CLOSE);
                            changeState(OUTER);
                        } else {
                            addTokenChar();
                        }
                    } else {
                        addTokenChar();
                    }

                    break;
                }
                case '>': {
                    if (state == INSIDE_TAG ||
                            state == TAG_ATTR_NAME) {
                        produceTextIfNecessarry();
                        changeState(OUTER);
                        addTokenChar();
                        produceToken(TokenType.TAG_CLOSE);
                    } else if (state == COMMENT) {
                        addTokenChar();
                    } else {
                        throw error();
                    }
                    break;
                }
                case '/': {
                    if (state == INSIDE_TAG ||
                            state == TAG_ATTR_NAME) {

                        produceTextIfNecessarry();
                        addTokenChar();

                        if (seeNext('>')) {
                            nextAndAddTokenChar();
                            produceToken(TokenType.TAG_SLASH_CLOSE);
                            changeState(OUTER);
                        } else {
                            throw error();
                        }
                    } else {
                        addTokenChar();
                    }

                    break;
                }
                case '=': {
                    produceTextIfNecessarry();

                    addTokenChar();
                    if (state == INSIDE_TAG ||
                            state == TAG_ATTR_NAME) {
                        produceToken(TokenType.EQUAL);
                        changeState(INSIDE_TAG);
                    }

                    break;
                }
                case '\'':
                case '"': {
                    if (state == INSIDE_TAG) {
                        produceTextIfNecessarry();
                        addTokenChar();
                        produceToken(TokenType.QUOTE_BEGIN);
                        changeState(INSIDE_ATTR_VALUE);
                        lastQuote = c;
                    } else if (state == INSIDE_ATTR_VALUE &&
                            lastQuote.equals(c)) {
                        produceToken(TokenType.TEXT);
                        addTokenChar();
                        produceToken(TokenType.QUOTE_END);
                        changeState(INSIDE_TAG);
                        lastQuote = null;
                    } else {
                        addTokenChar();
                    }

                    break;
                }
                default:
                    addTokenChar();
                    if (isAlphaNumeric(c)) {
                        if (state == OUTER) {
                            //
                        } else if (state == INSIDE_TAG || state == TAG_ATTR_NAME) {
                            changeState(TAG_ATTR_NAME);
                        }
                    }
            }
        }
    }

    private void nextAndAddTokenChar() {
        next();
        addTokenChar();
    }

    private void produceTextIfNecessarry() {
        if (tokenLen > 0) {
            produceToken(TokenType.TEXT);
        }
    }

    private boolean isAlphaNumeric(char c) {
        // TODO
        return c >= '0' && c <= '9' || c >= 'A' && c <= 'z';
    }

    private LexerException error() {
        return new LexerException("Wrong char after: {" + new String(chars, 0, currPos) + "}");
    }

    private void addTokenChar() {
        tokenLen++;
        log("addTokenChar, tokenLen=" + tokenLen);
    }

    private void produceToken(TokenType tokenType) {
        log("producing token: " + tokenType + " : {" + new String(chars, tokenStart, tokenLen) + "}");
        tokens.add(new Token(chars, tokenStart, tokenLen, tokenType));
        startToken(tokenStart + tokenLen);
    }

    private void startToken(int newStart) {
        tokenStart = newStart;
        tokenLen = 0;
        log("startToken, tokenStart = " + tokenStart);
    }

    private void changeState(LexerState newState) {
        if (state != newState) {
            log("state " + state + " --> " + newState);
//            prevState = state;
            state = newState;
        }
    }

    char next() {
        currPos++;
        char c = charAt(currPos);
        log("next char={" + c + "}, currPos=" + currPos);
        return c;
    }

    char charAt(int pos) {
        char c;
        if (pos < chars.length) {
            c = chars[pos];
        } else {
            c = 0; // end
        }
        return c;
    }

    boolean seeNext(char... chars) {
        int i = currPos + 1;
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (c != charAt(i + j)) {
                return false;
            }
        }
        return true;
    }
}
