package aavax.xml.stream.events;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.namespace.QName;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface StartElement extends XMLEvent {
    Attribute getAttributeByName(QName qName);

    Iterator getAttributes();

    QName getName();

    NamespaceContext getNamespaceContext();

    String getNamespaceURI(String str);

    Iterator getNamespaces();
}
