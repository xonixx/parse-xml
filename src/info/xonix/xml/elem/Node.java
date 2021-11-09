package info.xonix.xml.elem;

/**
 * User: gubarkov
 * Date: 21.08.12
 * Time: 17:53
 */
public interface Node {
    String getName();
    NodeType getType();
    String getValue();
}
