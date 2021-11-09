package info.xonix.xml;

/**
 * User: gubarkov
 * Date: 19.08.12
 * Time: 0:28
 */
public enum LexerState {
    OUTER,
    INSIDE_TAG,
    INSIDE_ATTR_VALUE,
    TAG_ATTR_NAME, COMMENT,
}
