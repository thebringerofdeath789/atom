package org.jdom.output;

import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.DocType;
import org.jdom.Element;
import org.jdom.EntityRef;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.jdom.adapters.DOMAdapter;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class DOMOutputter {
    private static final String CVS_ID = "@(#) $RCSfile: DOMOutputter.java,v $ $Revision: 1.41 $ $Date: 2004/09/03 06:03:42 $ $Name: jdom_1_0 $";
    private static final String DEFAULT_ADAPTER_CLASS = "org.jdom.adapters.XercesDOMAdapter";
    private String adapterClass;

    public DOMOutputter() {
    }

    public DOMOutputter(String str) {
        this.adapterClass = str;
    }

    public Document output(org.jdom.Document document) throws JDOMException {
        NamespaceStack namespaceStack = new NamespaceStack();
        try {
            Document createDOMDocument = createDOMDocument(document.getDocType());
            for (Object obj : document.getContent()) {
                if (obj instanceof Element) {
                    org.w3c.dom.Element output = output((Element) obj, createDOMDocument, namespaceStack);
                    org.w3c.dom.Element documentElement = createDOMDocument.getDocumentElement();
                    if (documentElement == null) {
                        createDOMDocument.appendChild(output);
                    } else {
                        createDOMDocument.replaceChild(output, documentElement);
                    }
                } else if (obj instanceof Comment) {
                    createDOMDocument.appendChild(createDOMDocument.createComment(((Comment) obj).getText()));
                } else if (obj instanceof ProcessingInstruction) {
                    ProcessingInstruction processingInstruction = (ProcessingInstruction) obj;
                    createDOMDocument.appendChild(createDOMDocument.createProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData()));
                } else if (!(obj instanceof DocType)) {
                    throw new JDOMException(new StringBuffer("Document contained top-level content with type:").append(obj.getClass().getName()).toString());
                }
            }
            return createDOMDocument;
        } catch (Throwable th) {
            throw new JDOMException("Exception outputting Document", th);
        }
    }

    private Document createDOMDocument(DocType docType) throws JDOMException {
        String str = this.adapterClass;
        try {
            try {
                if (str != null) {
                    return ((DOMAdapter) Class.forName(str).newInstance()).createDocument(docType);
                }
                return ((DOMAdapter) Class.forName("org.jdom.adapters.JAXPDOMAdapter").newInstance()).createDocument(docType);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
                return ((DOMAdapter) Class.forName(DEFAULT_ADAPTER_CLASS).newInstance()).createDocument(docType);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused2) {
            throw new JDOMException("No JAXP or default parser available");
        }
    }

    private org.w3c.dom.Element output(Element element, Document document, NamespaceStack namespaceStack) throws JDOMException {
        org.w3c.dom.Element createElementNS;
        try {
            int size = namespaceStack.size();
            if (element.getNamespace() == Namespace.NO_NAMESPACE) {
                createElementNS = document.createElement(element.getQualifiedName());
            } else {
                createElementNS = document.createElementNS(element.getNamespaceURI(), element.getQualifiedName());
            }
            Namespace namespace = element.getNamespace();
            if (namespace != Namespace.XML_NAMESPACE && (namespace != Namespace.NO_NAMESPACE || namespaceStack.getURI("") != null)) {
                if (!namespace.getURI().equals(namespaceStack.getURI(namespace.getPrefix()))) {
                    namespaceStack.push(namespace);
                    createElementNS.setAttribute(getXmlnsTagFor(namespace), namespace.getURI());
                }
            }
            for (Namespace namespace2 : element.getAdditionalNamespaces()) {
                if (!namespace2.getURI().equals(namespaceStack.getURI(namespace2.getPrefix()))) {
                    createElementNS.setAttribute(getXmlnsTagFor(namespace2), namespace2.getURI());
                    namespaceStack.push(namespace2);
                }
            }
            for (Attribute attribute : element.getAttributes()) {
                createElementNS.setAttributeNode(output(attribute, document));
                Namespace namespace3 = attribute.getNamespace();
                if (namespace3 != Namespace.NO_NAMESPACE && namespace3 != Namespace.XML_NAMESPACE) {
                    if (!namespace3.getURI().equals(namespaceStack.getURI(namespace3.getPrefix()))) {
                        createElementNS.setAttribute(getXmlnsTagFor(namespace3), namespace3.getURI());
                        namespaceStack.push(namespace3);
                    }
                }
                if (attribute.getNamespace() == Namespace.NO_NAMESPACE) {
                    createElementNS.setAttribute(attribute.getQualifiedName(), attribute.getValue());
                } else {
                    createElementNS.setAttributeNS(attribute.getNamespaceURI(), attribute.getQualifiedName(), attribute.getValue());
                }
            }
            for (Object obj : element.getContent()) {
                if (obj instanceof Element) {
                    createElementNS.appendChild(output((Element) obj, document, namespaceStack));
                } else if (obj instanceof String) {
                    createElementNS.appendChild(document.createTextNode((String) obj));
                } else if (obj instanceof CDATA) {
                    createElementNS.appendChild(document.createCDATASection(((CDATA) obj).getText()));
                } else if (obj instanceof Text) {
                    createElementNS.appendChild(document.createTextNode(((Text) obj).getText()));
                } else if (obj instanceof Comment) {
                    createElementNS.appendChild(document.createComment(((Comment) obj).getText()));
                } else if (obj instanceof ProcessingInstruction) {
                    ProcessingInstruction processingInstruction = (ProcessingInstruction) obj;
                    createElementNS.appendChild(document.createProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData()));
                } else if (obj instanceof EntityRef) {
                    createElementNS.appendChild(document.createEntityReference(((EntityRef) obj).getName()));
                } else {
                    throw new JDOMException(new StringBuffer("Element contained content with type:").append(obj.getClass().getName()).toString());
                }
            }
            while (namespaceStack.size() > size) {
                namespaceStack.pop();
            }
            return createElementNS;
        } catch (Exception e) {
            throw new JDOMException(new StringBuffer("Exception outputting Element ").append(element.getQualifiedName()).toString(), e);
        }
    }

    private Attr output(Attribute attribute, Document document) throws JDOMException {
        Attr createAttributeNS;
        try {
            if (attribute.getNamespace() == Namespace.NO_NAMESPACE) {
                createAttributeNS = document.createAttribute(attribute.getQualifiedName());
            } else {
                createAttributeNS = document.createAttributeNS(attribute.getNamespaceURI(), attribute.getQualifiedName());
            }
            createAttributeNS.setValue(attribute.getValue());
            return createAttributeNS;
        } catch (Exception e) {
            throw new JDOMException(new StringBuffer("Exception outputting Attribute ").append(attribute.getQualifiedName()).toString(), e);
        }
    }

    private static String getXmlnsTagFor(Namespace namespace) {
        return !namespace.getPrefix().equals("") ? new StringBuffer(String.valueOf(new StringBuffer("xmlns").append(":").toString())).append(namespace.getPrefix()).toString() : "xmlns";
    }
}
