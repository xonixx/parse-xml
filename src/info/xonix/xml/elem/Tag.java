package info.xonix.xml.elem;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * User: gubarkov
 * Date: 21.08.12
 * Time: 17:50
 */
public class Tag implements Node {
    private LinkedHashMap<String, String> attributes = new LinkedHashMap<>();
    private String name;
    private List<Node> nodes = new LinkedList<>();

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public NodeType getType() {
        return NodeType.TAG;
    }

    @Override
    public String getValue() {
        return null;
    }

    public LinkedHashMap<String, String> getAttributes() {
        return attributes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(name);

        if (!attributes.isEmpty()){
            sb.append(' ');
        }

        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append(entry.getKey())
                    .append('=')
                    .append('"')
                    .append(entry.getValue())
                    .append("\" ");
        }

        if (nodes.isEmpty()) {
            sb.append("/>");
        } else {
            sb.append(">\n");

            for (Node node : nodes) {
                sb.append(node.toString());
            }

            sb.append("\n</")
                    .append(name)
                    .append('>');

        }
        return sb.toString();
    }
}
