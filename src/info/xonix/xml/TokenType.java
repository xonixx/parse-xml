package info.xonix.xml;

/**
 * User: gubarkov
 * Date: 19.08.12
 * Time: 0:28
 */
public enum TokenType {
    TAG_OPEN, // <
    TAG_CLOSE, // >
//    SLASH, // /

    COMMENT_OPEN, // <!--
    COMMENT_CLOSE, // -->

    TAG_OPEN_SLASH, // </
    TAG_SLASH_CLOSE, // />

    QUOTE_BEGIN, // "
    QUOTE_END, // "
    EQUAL, // =
    TEXT,
}
