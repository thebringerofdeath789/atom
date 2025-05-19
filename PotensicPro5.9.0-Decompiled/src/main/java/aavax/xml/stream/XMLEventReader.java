package aavax.xml.stream;

import aavax.xml.stream.events.XMLEvent;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface XMLEventReader extends Iterator {
    void close() throws XMLStreamException;

    String getElementText() throws XMLStreamException;

    Object getProperty(String str) throws IllegalArgumentException;

    @Override // java.util.Iterator
    boolean hasNext();

    XMLEvent nextEvent() throws XMLStreamException;

    XMLEvent nextTag() throws XMLStreamException;

    XMLEvent peek() throws XMLStreamException;
}
