package org.jdom;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes5.dex */
public class UncheckedJDOMFactory implements JDOMFactory {
    @Override // org.jdom.JDOMFactory
    public Element element(String str, Namespace namespace) {
        Element element = new Element();
        element.name = str;
        if (namespace == null) {
            namespace = Namespace.NO_NAMESPACE;
        }
        element.namespace = namespace;
        return element;
    }

    @Override // org.jdom.JDOMFactory
    public Element element(String str) {
        Element element = new Element();
        element.name = str;
        element.namespace = Namespace.NO_NAMESPACE;
        return element;
    }

    @Override // org.jdom.JDOMFactory
    public Element element(String str, String str2) {
        return element(str, Namespace.getNamespace("", str2));
    }

    @Override // org.jdom.JDOMFactory
    public Element element(String str, String str2, String str3) {
        return element(str, Namespace.getNamespace(str2, str3));
    }

    @Override // org.jdom.JDOMFactory
    public Attribute attribute(String str, String str2, Namespace namespace) {
        Attribute attribute = new Attribute();
        attribute.name = str;
        attribute.value = str2;
        if (namespace == null) {
            namespace = Namespace.NO_NAMESPACE;
        }
        attribute.namespace = namespace;
        return attribute;
    }

    @Override // org.jdom.JDOMFactory
    public Attribute attribute(String str, String str2, int i, Namespace namespace) {
        Attribute attribute = new Attribute();
        attribute.name = str;
        attribute.type = i;
        attribute.value = str2;
        if (namespace == null) {
            namespace = Namespace.NO_NAMESPACE;
        }
        attribute.namespace = namespace;
        return attribute;
    }

    @Override // org.jdom.JDOMFactory
    public Attribute attribute(String str, String str2) {
        Attribute attribute = new Attribute();
        attribute.name = str;
        attribute.value = str2;
        attribute.namespace = Namespace.NO_NAMESPACE;
        return attribute;
    }

    @Override // org.jdom.JDOMFactory
    public Attribute attribute(String str, String str2, int i) {
        Attribute attribute = new Attribute();
        attribute.name = str;
        attribute.type = i;
        attribute.value = str2;
        attribute.namespace = Namespace.NO_NAMESPACE;
        return attribute;
    }

    @Override // org.jdom.JDOMFactory
    public Text text(String str) {
        Text text = new Text();
        text.value = str;
        return text;
    }

    @Override // org.jdom.JDOMFactory
    public CDATA cdata(String str) {
        CDATA cdata = new CDATA();
        cdata.value = str;
        return cdata;
    }

    @Override // org.jdom.JDOMFactory
    public Comment comment(String str) {
        Comment comment = new Comment();
        comment.text = str;
        return comment;
    }

    @Override // org.jdom.JDOMFactory
    public ProcessingInstruction processingInstruction(String str, Map map) {
        ProcessingInstruction processingInstruction = new ProcessingInstruction();
        processingInstruction.target = str;
        processingInstruction.setData(map);
        return processingInstruction;
    }

    @Override // org.jdom.JDOMFactory
    public ProcessingInstruction processingInstruction(String str, String str2) {
        ProcessingInstruction processingInstruction = new ProcessingInstruction();
        processingInstruction.target = str;
        processingInstruction.setData(str2);
        return processingInstruction;
    }

    @Override // org.jdom.JDOMFactory
    public EntityRef entityRef(String str) {
        EntityRef entityRef = new EntityRef();
        entityRef.name = str;
        return entityRef;
    }

    @Override // org.jdom.JDOMFactory
    public EntityRef entityRef(String str, String str2) {
        EntityRef entityRef = new EntityRef();
        entityRef.name = str;
        entityRef.systemID = str2;
        return entityRef;
    }

    @Override // org.jdom.JDOMFactory
    public EntityRef entityRef(String str, String str2, String str3) {
        EntityRef entityRef = new EntityRef();
        entityRef.name = str;
        entityRef.publicID = str2;
        entityRef.systemID = str3;
        return entityRef;
    }

    @Override // org.jdom.JDOMFactory
    public DocType docType(String str, String str2, String str3) {
        DocType docType = new DocType();
        docType.elementName = str;
        docType.publicID = str2;
        docType.systemID = str3;
        return docType;
    }

    @Override // org.jdom.JDOMFactory
    public DocType docType(String str, String str2) {
        return docType(str, null, str2);
    }

    @Override // org.jdom.JDOMFactory
    public DocType docType(String str) {
        return docType(str, null, null);
    }

    @Override // org.jdom.JDOMFactory
    public Document document(Element element, DocType docType, String str) {
        Document document = new Document();
        if (docType != null) {
            addContent(document, docType);
        }
        if (element != null) {
            addContent(document, element);
        }
        if (str != null) {
            document.baseURI = str;
        }
        return document;
    }

    @Override // org.jdom.JDOMFactory
    public Document document(Element element, DocType docType) {
        return document(element, docType, null);
    }

    @Override // org.jdom.JDOMFactory
    public Document document(Element element) {
        return document(element, null, null);
    }

    @Override // org.jdom.JDOMFactory
    public void addContent(Parent parent, Content content) {
        if (parent instanceof Element) {
            ((Element) parent).content.uncheckedAddContent(content);
        } else {
            ((Document) parent).content.uncheckedAddContent(content);
        }
    }

    @Override // org.jdom.JDOMFactory
    public void setAttribute(Element element, Attribute attribute) {
        element.attributes.uncheckedAddAttribute(attribute);
    }

    @Override // org.jdom.JDOMFactory
    public void addNamespaceDeclaration(Element element, Namespace namespace) {
        if (element.additionalNamespaces == null) {
            element.additionalNamespaces = new ArrayList(5);
        }
        element.additionalNamespaces.add(namespace);
    }
}
