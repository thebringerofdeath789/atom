package org.jdom;

import java.util.Map;

/* loaded from: classes5.dex */
public class DefaultJDOMFactory implements JDOMFactory {
    private static final String CVS_ID = "@(#) $RCSfile: DefaultJDOMFactory.java,v $ $Revision: 1.6 $ $Date: 2004/09/01 05:25:38 $ $Name: jdom_1_0 $";

    @Override // org.jdom.JDOMFactory
    public Attribute attribute(String str, String str2, Namespace namespace) {
        return new Attribute(str, str2, namespace);
    }

    @Override // org.jdom.JDOMFactory
    public Attribute attribute(String str, String str2, int i, Namespace namespace) {
        return new Attribute(str, str2, i, namespace);
    }

    @Override // org.jdom.JDOMFactory
    public Attribute attribute(String str, String str2) {
        return new Attribute(str, str2);
    }

    @Override // org.jdom.JDOMFactory
    public Attribute attribute(String str, String str2, int i) {
        return new Attribute(str, str2, i);
    }

    @Override // org.jdom.JDOMFactory
    public CDATA cdata(String str) {
        return new CDATA(str);
    }

    @Override // org.jdom.JDOMFactory
    public Text text(String str) {
        return new Text(str);
    }

    @Override // org.jdom.JDOMFactory
    public Comment comment(String str) {
        return new Comment(str);
    }

    @Override // org.jdom.JDOMFactory
    public DocType docType(String str, String str2, String str3) {
        return new DocType(str, str2, str3);
    }

    @Override // org.jdom.JDOMFactory
    public DocType docType(String str, String str2) {
        return new DocType(str, str2);
    }

    @Override // org.jdom.JDOMFactory
    public DocType docType(String str) {
        return new DocType(str);
    }

    @Override // org.jdom.JDOMFactory
    public Document document(Element element, DocType docType) {
        return new Document(element, docType);
    }

    @Override // org.jdom.JDOMFactory
    public Document document(Element element, DocType docType, String str) {
        return new Document(element, docType, str);
    }

    @Override // org.jdom.JDOMFactory
    public Document document(Element element) {
        return new Document(element);
    }

    @Override // org.jdom.JDOMFactory
    public Element element(String str, Namespace namespace) {
        return new Element(str, namespace);
    }

    @Override // org.jdom.JDOMFactory
    public Element element(String str) {
        return new Element(str);
    }

    @Override // org.jdom.JDOMFactory
    public Element element(String str, String str2) {
        return new Element(str, str2);
    }

    @Override // org.jdom.JDOMFactory
    public Element element(String str, String str2, String str3) {
        return new Element(str, str2, str3);
    }

    @Override // org.jdom.JDOMFactory
    public ProcessingInstruction processingInstruction(String str, Map map) {
        return new ProcessingInstruction(str, map);
    }

    @Override // org.jdom.JDOMFactory
    public ProcessingInstruction processingInstruction(String str, String str2) {
        return new ProcessingInstruction(str, str2);
    }

    @Override // org.jdom.JDOMFactory
    public EntityRef entityRef(String str) {
        return new EntityRef(str);
    }

    @Override // org.jdom.JDOMFactory
    public EntityRef entityRef(String str, String str2, String str3) {
        return new EntityRef(str, str2, str3);
    }

    @Override // org.jdom.JDOMFactory
    public EntityRef entityRef(String str, String str2) {
        return new EntityRef(str, str2);
    }

    @Override // org.jdom.JDOMFactory
    public void addContent(Parent parent, Content content) {
        if (parent instanceof Document) {
            ((Document) parent).addContent(content);
        } else {
            ((Element) parent).addContent(content);
        }
    }

    @Override // org.jdom.JDOMFactory
    public void setAttribute(Element element, Attribute attribute) {
        element.setAttribute(attribute);
    }

    @Override // org.jdom.JDOMFactory
    public void addNamespaceDeclaration(Element element, Namespace namespace) {
        element.addNamespaceDeclaration(namespace);
    }
}
