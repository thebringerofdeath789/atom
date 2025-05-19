package org.dom4j;

import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.dom4j.tree.AbstractNode;
import org.dom4j.tree.DefaultNamespace;
import org.dom4j.tree.NamespaceCache;

/* loaded from: classes5.dex */
public class Namespace extends AbstractNode {
    protected static final NamespaceCache CACHE;
    public static final Namespace NO_NAMESPACE;
    public static final Namespace XML_NAMESPACE;
    private int hashCode;
    private String prefix;
    private String uri;

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public short getNodeType() {
        return (short) 13;
    }

    static {
        NamespaceCache namespaceCache = new NamespaceCache();
        CACHE = namespaceCache;
        XML_NAMESPACE = namespaceCache.get("xml", "http://www.w3.org/XML/1998/namespace");
        NO_NAMESPACE = namespaceCache.get("", "");
    }

    public Namespace(String str, String str2) {
        this.prefix = str == null ? "" : str;
        this.uri = str2 == null ? "" : str2;
    }

    public static Namespace get(String str, String str2) {
        return CACHE.get(str, str2);
    }

    public static Namespace get(String str) {
        return CACHE.get(str);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = createHashCode();
        }
        return this.hashCode;
    }

    protected int createHashCode() {
        int hashCode = this.uri.hashCode() ^ this.prefix.hashCode();
        if (hashCode == 0) {
            return 47806;
        }
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Namespace) {
            Namespace namespace = (Namespace) obj;
            if (hashCode() == namespace.hashCode()) {
                return this.uri.equals(namespace.getURI()) && this.prefix.equals(namespace.getPrefix());
            }
        }
        return false;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.uri;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getStringValue() {
        return this.uri;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getURI() {
        return this.uri;
    }

    public String getXPathNameStep() {
        String str = this.prefix;
        return (str == null || "".equals(str)) ? "namespace::*[name()='']" : new StringBuffer().append("namespace::").append(this.prefix).toString();
    }

    @Override // org.dom4j.Node
    public String getPath(Element element) {
        StringBuffer stringBuffer = new StringBuffer(10);
        Element parent = getParent();
        if (parent != null && parent != element) {
            stringBuffer.append(parent.getPath(element));
            stringBuffer.append('/');
        }
        stringBuffer.append(getXPathNameStep());
        return stringBuffer.toString();
    }

    @Override // org.dom4j.Node
    public String getUniquePath(Element element) {
        StringBuffer stringBuffer = new StringBuffer(10);
        Element parent = getParent();
        if (parent != null && parent != element) {
            stringBuffer.append(parent.getUniquePath(element));
            stringBuffer.append('/');
        }
        stringBuffer.append(getXPathNameStep());
        return stringBuffer.toString();
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append(" [Namespace: prefix ").append(getPrefix()).append(" mapped to URI \"").append(getURI()).append("\"]").toString();
    }

    @Override // org.dom4j.Node
    public String asXML() {
        StringBuffer stringBuffer = new StringBuffer(10);
        String prefix = getPrefix();
        if (prefix != null && prefix.length() > 0) {
            stringBuffer.append(Sax2Dom.XMLNS_STRING);
            stringBuffer.append(prefix);
            stringBuffer.append("=\"");
        } else {
            stringBuffer.append("xmlns=\"");
        }
        stringBuffer.append(getURI());
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    @Override // org.dom4j.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override // org.dom4j.tree.AbstractNode
    protected Node createXPathResult(Element element) {
        return new DefaultNamespace(element, getPrefix(), getURI());
    }
}
