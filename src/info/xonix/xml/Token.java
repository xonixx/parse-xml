package info.xonix.xml;

/**
 * User: gubarkov
 * Date: 19.08.12
 * Time: 0:26
 */
public class Token {
    char[] xml;
    int begin;
    int len;

    TokenType type;

    public Token(char[] xml, int begin, int len, TokenType type) {
        this.xml = xml;
        this.begin = begin;
        this.len = len;
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toString() + "(" + text() + ")";
    }

    public String text() {
        return new String(xml, begin, len);
    }
}
