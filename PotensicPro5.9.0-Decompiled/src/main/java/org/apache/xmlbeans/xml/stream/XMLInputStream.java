package org.apache.xmlbeans.xml.stream;

/* loaded from: classes5.dex */
public interface XMLInputStream {
    void close() throws XMLStreamException;

    ReferenceResolver getReferenceResolver();

    XMLInputStream getSubStream() throws XMLStreamException;

    boolean hasNext() throws XMLStreamException;

    XMLEvent next() throws XMLStreamException;

    XMLEvent peek() throws XMLStreamException;

    void setReferenceResolver(ReferenceResolver referenceResolver);

    void skip() throws XMLStreamException;

    boolean skip(int i) throws XMLStreamException;

    boolean skip(XMLName xMLName) throws XMLStreamException;

    boolean skip(XMLName xMLName, int i) throws XMLStreamException;

    void skipElement() throws XMLStreamException;
}
