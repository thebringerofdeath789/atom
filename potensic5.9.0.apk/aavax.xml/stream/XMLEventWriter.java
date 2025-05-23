package aavax.xml.stream;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.stream.events.XMLEvent;
import aavax.xml.stream.util.XMLEventConsumer;

/* loaded from: classes.dex */
public interface XMLEventWriter extends XMLEventConsumer {
    void add(XMLEventReader xMLEventReader) throws XMLStreamException;

    @Override // aavax.xml.stream.util.XMLEventConsumer
    void add(XMLEvent xMLEvent) throws XMLStreamException;

    void close() throws XMLStreamException;

    void flush() throws XMLStreamException;

    NamespaceContext getNamespaceContext();

    String getPrefix(String str) throws XMLStreamException;

    void setDefaultNamespace(String str) throws XMLStreamException;

    void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException;

    void setPrefix(String str, String str2) throws XMLStreamException;
}