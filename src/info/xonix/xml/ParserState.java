package info.xonix.xml;

/**
 * User: gubarkov
 * Date: 21.08.12
 * Time: 18:30
 */
public enum ParserState {
    OUTER,
    TAG_OPEN, // <
    ENDING_TAG_OPEN, // </
    TAG_OPEN_AFTER_TAGNAME, // <aaa
    TAG_OPEN_AFTER_EQUAL, // <aaa bbb=
    TAG_OPEN_QUOTE_OPEN,
    COMMENT, // <aaa bbb="
}
