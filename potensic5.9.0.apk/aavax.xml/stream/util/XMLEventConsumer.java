package aavax.xml.stream.util;

import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.events.XMLEvent;

/* loaded from: classes.dex */
public interface XMLEventConsumer {
    void add(XMLEvent xMLEvent) throws XMLStreamException;
}