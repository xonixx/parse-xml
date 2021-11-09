package info.xonix.xml.elem;

/**
 * User: gubarkov
 * Date: 21.08.12
 * Time: 17:55
 */
public class Text implements Node {
    private String value;

    public Text(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public NodeType getType() {
        return NodeType.TEXT;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
