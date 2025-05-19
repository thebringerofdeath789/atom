package org.apache.xmlbeans.xml.stream;

/* loaded from: classes5.dex */
public interface ReferenceResolver {
    String getId(String str);

    XMLInputStream resolve(String str) throws XMLStreamException;
}
