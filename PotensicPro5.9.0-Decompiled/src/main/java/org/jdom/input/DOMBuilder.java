package org.jdom.input;

import org.jdom.DefaultJDOMFactory;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMFactory;
import org.jdom.Namespace;
import org.w3c.dom.Attr;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class DOMBuilder {
    private static final String CVS_ID = "@(#) $RCSfile: DOMBuilder.java,v $ $Revision: 1.59 $ $Date: 2004/09/03 06:03:41 $ $Name: jdom_1_0 $";
    private String adapterClass;
    private JDOMFactory factory = new DefaultJDOMFactory();

    public DOMBuilder() {
    }

    public DOMBuilder(String str) {
        this.adapterClass = str;
    }

    public void setFactory(JDOMFactory jDOMFactory) {
        this.factory = jDOMFactory;
    }

    public JDOMFactory getFactory() {
        return this.factory;
    }

    public Document build(org.w3c.dom.Document document) {
        Document document2 = this.factory.document(null);
        buildTree(document, document2, null, true);
        return document2;
    }

    public Element build(org.w3c.dom.Element element) {
        Document document = this.factory.document(null);
        buildTree(element, document, null, true);
        return document.getRootElement();
    }

    private void buildTree(Node node, Document document, Element element, boolean z) {
        String str;
        Namespace namespace;
        String str2;
        Namespace namespace2;
        switch (node.getNodeType()) {
            case 1:
                String nodeName = node.getNodeName();
                int indexOf = nodeName.indexOf(58);
                if (indexOf >= 0) {
                    str = nodeName.substring(0, indexOf);
                    nodeName = nodeName.substring(indexOf + 1);
                } else {
                    str = "";
                }
                String namespaceURI = node.getNamespaceURI();
                if (namespaceURI != null) {
                    namespace = Namespace.getNamespace(str, namespaceURI);
                } else if (element == null) {
                    namespace = Namespace.NO_NAMESPACE;
                } else {
                    namespace = element.getNamespace(str);
                }
                Element element2 = this.factory.element(nodeName, namespace);
                if (z) {
                    document.setRootElement(element2);
                } else {
                    this.factory.addContent(element, element2);
                }
                NamedNodeMap attributes = node.getAttributes();
                int length = attributes.getLength();
                for (int i = 0; i < length; i++) {
                    Attr attr = (Attr) attributes.item(i);
                    String name = attr.getName();
                    if (name.startsWith("xmlns")) {
                        int indexOf2 = name.indexOf(58);
                        String substring = indexOf2 >= 0 ? name.substring(indexOf2 + 1) : "";
                        Namespace namespace3 = Namespace.getNamespace(substring, attr.getValue());
                        if (str.equals(substring)) {
                            element2.setNamespace(namespace3);
                        } else {
                            this.factory.addNamespaceDeclaration(element2, namespace3);
                        }
                    }
                }
                for (int i2 = 0; i2 < length; i2++) {
                    Attr attr2 = (Attr) attributes.item(i2);
                    String name2 = attr2.getName();
                    if (!name2.startsWith("xmlns")) {
                        int indexOf3 = name2.indexOf(58);
                        if (indexOf3 >= 0) {
                            str2 = name2.substring(0, indexOf3);
                            name2 = name2.substring(indexOf3 + 1);
                        } else {
                            str2 = "";
                        }
                        String value = attr2.getValue();
                        if ("".equals(str2)) {
                            namespace2 = Namespace.NO_NAMESPACE;
                        } else {
                            namespace2 = element2.getNamespace(str2);
                        }
                        this.factory.setAttribute(element2, this.factory.attribute(name2, value, namespace2));
                    }
                }
                NodeList childNodes = node.getChildNodes();
                if (childNodes != null) {
                    int length2 = childNodes.getLength();
                    for (int i3 = 0; i3 < length2; i3++) {
                        Node item = childNodes.item(i3);
                        if (item != null) {
                            buildTree(item, document, element2, false);
                        }
                    }
                    break;
                }
                break;
            case 3:
                String nodeValue = node.getNodeValue();
                JDOMFactory jDOMFactory = this.factory;
                jDOMFactory.addContent(element, jDOMFactory.text(nodeValue));
                break;
            case 4:
                String nodeValue2 = node.getNodeValue();
                JDOMFactory jDOMFactory2 = this.factory;
                jDOMFactory2.addContent(element, jDOMFactory2.cdata(nodeValue2));
                break;
            case 5:
                this.factory.addContent(element, this.factory.entityRef(node.getNodeName()));
                break;
            case 7:
                if (z) {
                    JDOMFactory jDOMFactory3 = this.factory;
                    jDOMFactory3.addContent(document, jDOMFactory3.processingInstruction(node.getNodeName(), node.getNodeValue()));
                    break;
                } else {
                    JDOMFactory jDOMFactory4 = this.factory;
                    jDOMFactory4.addContent(element, jDOMFactory4.processingInstruction(node.getNodeName(), node.getNodeValue()));
                    break;
                }
            case 8:
                if (z) {
                    JDOMFactory jDOMFactory5 = this.factory;
                    jDOMFactory5.addContent(document, jDOMFactory5.comment(node.getNodeValue()));
                    break;
                } else {
                    JDOMFactory jDOMFactory6 = this.factory;
                    jDOMFactory6.addContent(element, jDOMFactory6.comment(node.getNodeValue()));
                    break;
                }
            case 9:
                NodeList childNodes2 = node.getChildNodes();
                int length3 = childNodes2.getLength();
                for (int i4 = 0; i4 < length3; i4++) {
                    buildTree(childNodes2.item(i4), document, element, true);
                }
                break;
            case 10:
                DocumentType documentType = (DocumentType) node;
                String publicId = documentType.getPublicId();
                String systemId = documentType.getSystemId();
                String internalSubset = documentType.getInternalSubset();
                DocType docType = this.factory.docType(documentType.getName());
                docType.setPublicID(publicId);
                docType.setSystemID(systemId);
                docType.setInternalSubset(internalSubset);
                this.factory.addContent(document, docType);
                break;
        }
    }
}
