package org.apache.xmlbeans.xml.stream;

import java.util.Map;

/* loaded from: classes5.dex */
public interface StartElement extends XMLEvent {
    Attribute getAttributeByName(XMLName xMLName);

    AttributeIterator getAttributes();

    AttributeIterator getAttributesAndNamespaces();

    Map getNamespaceMap();

    String getNamespaceUri(String str);

    AttributeIterator getNamespaces();
}
