package javax.xml.transform.dom;

import javax.xml.transform.Source;
import org.w3c.dom.Node;

/* loaded from: classes4.dex */
public class DOMSource implements Source {
    public static final String FEATURE = "http://javax.xml.transform.dom.DOMSource/feature";
    String baseID;
    private Node node;

    public DOMSource() {
    }

    public DOMSource(Node node) {
        setNode(node);
    }

    public DOMSource(Node node, String str) {
        setNode(node);
        setSystemId(str);
    }

    public Node getNode() {
        return this.node;
    }

    @Override // javax.xml.transform.Source
    public String getSystemId() {
        return this.baseID;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override // javax.xml.transform.Source
    public void setSystemId(String str) {
        this.baseID = str;
    }
}
