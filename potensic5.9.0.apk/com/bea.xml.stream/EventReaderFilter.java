package com.bea.xml.stream;

import aavax.xml.stream.EventFilter;
import aavax.xml.stream.XMLEventReader;
import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.events.Characters;
import aavax.xml.stream.events.XMLEvent;
import com.bea.xml.stream.filters.TypeFilter;
import java.io.FileReader;

/* loaded from: classes.dex */
public class EventReaderFilter implements XMLEventReader {
    private EventFilter filter;
    private XMLEventReader parent;

    public EventReaderFilter(XMLEventReader xMLEventReader) throws XMLStreamException {
        this.parent = xMLEventReader;
    }

    public EventReaderFilter(XMLEventReader xMLEventReader, EventFilter eventFilter) throws XMLStreamException {
        this.parent = xMLEventReader;
        this.filter = eventFilter;
    }

    public void setFilter(EventFilter eventFilter) {
        this.filter = eventFilter;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            return nextEvent();
        } catch (XMLStreamException unused) {
            return null;
        }
    }

    @Override // aavax.xml.stream.XMLEventReader
    public XMLEvent nextEvent() throws XMLStreamException {
        if (hasNext()) {
            return this.parent.nextEvent();
        }
        return null;
    }

    @Override // aavax.xml.stream.XMLEventReader
    public String getElementText() throws XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer();
        if (!nextEvent().isStartElement()) {
            throw new XMLStreamException("Precondition for readText is nextEvent().getTypeEventType() == START_ELEMENT");
        }
        while (hasNext()) {
            XMLEvent peek = peek();
            if (peek.isStartElement()) {
                throw new XMLStreamException("Unexpected Element start");
            }
            if (peek.isCharacters()) {
                stringBuffer.append(((Characters) peek).getData());
            }
            if (peek.isEndElement()) {
                return stringBuffer.toString();
            }
            nextEvent();
        }
        throw new XMLStreamException("Unexpected end of Document");
    }

    @Override // aavax.xml.stream.XMLEventReader
    public XMLEvent nextTag() throws XMLStreamException {
        while (hasNext()) {
            XMLEvent nextEvent = nextEvent();
            if (nextEvent.isCharacters() && !((Characters) nextEvent).isWhiteSpace()) {
                throw new XMLStreamException("Unexpected text");
            }
            if (nextEvent.isStartElement() || nextEvent.isEndElement()) {
                return nextEvent;
            }
        }
        throw new XMLStreamException("Unexpected end of Document");
    }

    @Override // aavax.xml.stream.XMLEventReader, java.util.Iterator
    public boolean hasNext() {
        while (this.parent.hasNext()) {
            try {
                if (this.filter.accept(this.parent.peek())) {
                    return true;
                }
                this.parent.nextEvent();
            } catch (XMLStreamException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // aavax.xml.stream.XMLEventReader
    public XMLEvent peek() throws XMLStreamException {
        if (hasNext()) {
            return this.parent.peek();
        }
        return null;
    }

    @Override // aavax.xml.stream.XMLEventReader
    public void close() throws XMLStreamException {
        this.parent.close();
    }

    @Override // aavax.xml.stream.XMLEventReader
    public Object getProperty(String str) {
        return this.parent.getProperty(str);
    }

    public static void main(String[] strArr) throws Exception {
        System.setProperty("aavax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
        System.setProperty("aavax.xml.stream.XMLEventFactory", "com.bea.xml.stream.EventFactory");
        XMLInputFactory newInstance = XMLInputFactory.newInstance();
        TypeFilter typeFilter = new TypeFilter();
        typeFilter.addType(1);
        typeFilter.addType(2);
        XMLEventReader createFilteredReader = newInstance.createFilteredReader(newInstance.createXMLEventReader(new FileReader(strArr[0])), typeFilter);
        while (createFilteredReader.hasNext()) {
            System.out.println(createFilteredReader.nextEvent());
        }
    }
}