package org.jdom;

import java.util.Map;

/* loaded from: classes5.dex */
public interface JDOMFactory {
    void addContent(Parent parent, Content content);

    void addNamespaceDeclaration(Element element, Namespace namespace);

    Attribute attribute(String str, String str2);

    Attribute attribute(String str, String str2, int i);

    Attribute attribute(String str, String str2, int i, Namespace namespace);

    Attribute attribute(String str, String str2, Namespace namespace);

    CDATA cdata(String str);

    Comment comment(String str);

    DocType docType(String str);

    DocType docType(String str, String str2);

    DocType docType(String str, String str2, String str3);

    Document document(Element element);

    Document document(Element element, DocType docType);

    Document document(Element element, DocType docType, String str);

    Element element(String str);

    Element element(String str, String str2);

    Element element(String str, String str2, String str3);

    Element element(String str, Namespace namespace);

    EntityRef entityRef(String str);

    EntityRef entityRef(String str, String str2);

    EntityRef entityRef(String str, String str2, String str3);

    ProcessingInstruction processingInstruction(String str, String str2);

    ProcessingInstruction processingInstruction(String str, Map map);

    void setAttribute(Element element, Attribute attribute);

    Text text(String str);
}
