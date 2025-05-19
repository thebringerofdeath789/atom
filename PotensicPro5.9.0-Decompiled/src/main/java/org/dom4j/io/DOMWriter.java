package org.dom4j.io;

import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.CDATA;
import org.dom4j.Comment;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.Namespace;
import org.dom4j.ProcessingInstruction;
import org.dom4j.Text;
import org.dom4j.tree.NamespaceStack;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class DOMWriter {
    private static final String[] DEFAULT_DOM_DOCUMENT_CLASSES = {"org.apache.xerces.dom.DocumentImpl", "gnu.xml.dom.DomDocument", "org.apache.crimson.tree.XmlDocument", "com.sun.xml.tree.XmlDocument", "oracle.xml.parser.v2.XMLDocument", "oracle.xml.parser.XMLDocument", "org.dom4j.dom.DOMDocument"};
    static /* synthetic */ Class class$org$dom4j$io$DOMWriter = null;
    private static boolean loggedWarning = false;
    private Class domDocumentClass;
    private NamespaceStack namespaceStack = new NamespaceStack();

    public DOMWriter() {
    }

    public DOMWriter(Class cls) {
        this.domDocumentClass = cls;
    }

    public Class getDomDocumentClass() throws DocumentException {
        Class<?> cls = this.domDocumentClass;
        if (cls == null) {
            int length = DEFAULT_DOM_DOCUMENT_CLASSES.length;
            for (int i = 0; i < length; i++) {
                try {
                    String str = DEFAULT_DOM_DOCUMENT_CLASSES[i];
                    Class cls2 = class$org$dom4j$io$DOMWriter;
                    if (cls2 == null) {
                        cls2 = class$("org.dom4j.io.DOMWriter");
                        class$org$dom4j$io$DOMWriter = cls2;
                    }
                    cls = Class.forName(str, true, cls2.getClassLoader());
                } catch (Exception unused) {
                }
                if (cls != null) {
                    break;
                }
            }
        }
        return cls;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void setDomDocumentClass(Class cls) {
        this.domDocumentClass = cls;
    }

    public void setDomDocumentClassName(String str) throws DocumentException {
        try {
            Class cls = class$org$dom4j$io$DOMWriter;
            if (cls == null) {
                cls = class$("org.dom4j.io.DOMWriter");
                class$org$dom4j$io$DOMWriter = cls;
            }
            this.domDocumentClass = Class.forName(str, true, cls.getClassLoader());
        } catch (Exception e) {
            throw new DocumentException(new StringBuffer().append("Could not load the DOM Document class: ").append(str).toString(), e);
        }
    }

    public Document write(org.dom4j.Document document) throws DocumentException {
        if (document instanceof Document) {
            return (Document) document;
        }
        resetNamespaceStack();
        Document createDomDocument = createDomDocument(document);
        appendDOMTree(createDomDocument, createDomDocument, document.content());
        this.namespaceStack.clear();
        return createDomDocument;
    }

    public Document write(org.dom4j.Document document, DOMImplementation dOMImplementation) throws DocumentException {
        if (document instanceof Document) {
            return (Document) document;
        }
        resetNamespaceStack();
        Document createDomDocument = createDomDocument(document, dOMImplementation);
        appendDOMTree(createDomDocument, createDomDocument, document.content());
        this.namespaceStack.clear();
        return createDomDocument;
    }

    protected void appendDOMTree(Document document, Node node, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj instanceof Element) {
                appendDOMTree(document, node, (Element) obj);
            } else if (obj instanceof String) {
                appendDOMTree(document, node, (String) obj);
            } else if (obj instanceof Text) {
                appendDOMTree(document, node, ((Text) obj).getText());
            } else if (obj instanceof CDATA) {
                appendDOMTree(document, node, (CDATA) obj);
            } else if (obj instanceof Comment) {
                appendDOMTree(document, node, (Comment) obj);
            } else if (obj instanceof Entity) {
                appendDOMTree(document, node, (Entity) obj);
            } else if (obj instanceof ProcessingInstruction) {
                appendDOMTree(document, node, (ProcessingInstruction) obj);
            }
        }
    }

    protected void appendDOMTree(Document document, Node node, Element element) {
        org.w3c.dom.Element createElementNS = document.createElementNS(element.getNamespaceURI(), element.getQualifiedName());
        int size = this.namespaceStack.size();
        Namespace namespace = element.getNamespace();
        if (isNamespaceDeclaration(namespace)) {
            this.namespaceStack.push(namespace);
            writeNamespace(createElementNS, namespace);
        }
        List declaredNamespaces = element.declaredNamespaces();
        int size2 = declaredNamespaces.size();
        for (int i = 0; i < size2; i++) {
            Namespace namespace2 = (Namespace) declaredNamespaces.get(i);
            if (isNamespaceDeclaration(namespace2)) {
                this.namespaceStack.push(namespace2);
                writeNamespace(createElementNS, namespace2);
            }
        }
        int attributeCount = element.attributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            Attribute attribute = element.attribute(i2);
            createElementNS.setAttributeNS(attribute.getNamespaceURI(), attribute.getQualifiedName(), attribute.getValue());
        }
        appendDOMTree(document, createElementNS, element.content());
        node.appendChild(createElementNS);
        while (this.namespaceStack.size() > size) {
            this.namespaceStack.pop();
        }
    }

    protected void appendDOMTree(Document document, Node node, CDATA cdata) {
        node.appendChild(document.createCDATASection(cdata.getText()));
    }

    protected void appendDOMTree(Document document, Node node, Comment comment) {
        node.appendChild(document.createComment(comment.getText()));
    }

    protected void appendDOMTree(Document document, Node node, String str) {
        node.appendChild(document.createTextNode(str));
    }

    protected void appendDOMTree(Document document, Node node, Entity entity) {
        node.appendChild(document.createEntityReference(entity.getName()));
    }

    protected void appendDOMTree(Document document, Node node, ProcessingInstruction processingInstruction) {
        node.appendChild(document.createProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getText()));
    }

    protected void writeNamespace(org.w3c.dom.Element element, Namespace namespace) {
        element.setAttribute(attributeNameForNamespace(namespace), namespace.getURI());
    }

    protected String attributeNameForNamespace(Namespace namespace) {
        String prefix = namespace.getPrefix();
        return prefix.length() > 0 ? new StringBuffer().append("xmlns").append(":").append(prefix).toString() : "xmlns";
    }

    protected Document createDomDocument(org.dom4j.Document document) throws DocumentException {
        Class cls = this.domDocumentClass;
        if (cls != null) {
            try {
                return (Document) cls.newInstance();
            } catch (Exception e) {
                throw new DocumentException(new StringBuffer().append("Could not instantiate an instance of DOM Document with class: ").append(this.domDocumentClass.getName()).toString(), e);
            }
        }
        Document createDomDocumentViaJAXP = createDomDocumentViaJAXP();
        if (createDomDocumentViaJAXP != null) {
            return createDomDocumentViaJAXP;
        }
        Class domDocumentClass = getDomDocumentClass();
        try {
            return (Document) domDocumentClass.newInstance();
        } catch (Exception e2) {
            throw new DocumentException(new StringBuffer().append("Could not instantiate an instance of DOM Document with class: ").append(domDocumentClass.getName()).toString(), e2);
        }
    }

    protected Document createDomDocumentViaJAXP() throws DocumentException {
        try {
            return JAXPHelper.createDocument(false, true);
        } catch (Throwable th) {
            if (loggedWarning) {
                return null;
            }
            loggedWarning = true;
            if (SAXHelper.isVerboseErrorReporting()) {
                System.out.println("Warning: Caught exception attempting to use JAXP to create a W3C DOM document");
                System.out.println(new StringBuffer().append("Warning: Exception was: ").append(th).toString());
                th.printStackTrace();
                return null;
            }
            System.out.println("Warning: Error occurred using JAXP to create a DOM document.");
            return null;
        }
    }

    protected Document createDomDocument(org.dom4j.Document document, DOMImplementation dOMImplementation) throws DocumentException {
        return dOMImplementation.createDocument(null, null, null);
    }

    protected boolean isNamespaceDeclaration(Namespace namespace) {
        String uri;
        return (namespace == null || namespace == Namespace.NO_NAMESPACE || namespace == Namespace.XML_NAMESPACE || (uri = namespace.getURI()) == null || uri.length() <= 0 || this.namespaceStack.contains(namespace)) ? false : true;
    }

    protected void resetNamespaceStack() {
        this.namespaceStack.clear();
        this.namespaceStack.push(Namespace.XML_NAMESPACE);
    }
}
