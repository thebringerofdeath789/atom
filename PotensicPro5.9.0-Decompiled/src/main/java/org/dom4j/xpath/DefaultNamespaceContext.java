package org.dom4j.xpath;

import java.io.Serializable;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.jaxen.NamespaceContext;

/* loaded from: classes5.dex */
public class DefaultNamespaceContext implements NamespaceContext, Serializable {
    private final Element element;

    public DefaultNamespaceContext(Element element) {
        this.element = element;
    }

    public static DefaultNamespaceContext create(Object obj) {
        Element parent;
        if (obj instanceof Element) {
            parent = (Element) obj;
        } else if (obj instanceof Document) {
            parent = ((Document) obj).getRootElement();
        } else {
            parent = obj instanceof Node ? ((Node) obj).getParent() : null;
        }
        if (parent != null) {
            return new DefaultNamespaceContext(parent);
        }
        return null;
    }

    public String translateNamespacePrefixToUri(String str) {
        Namespace namespaceForPrefix;
        if (str == null || str.length() <= 0 || (namespaceForPrefix = this.element.getNamespaceForPrefix(str)) == null) {
            return null;
        }
        return namespaceForPrefix.getURI();
    }
}
