package com.bea.xml.stream;

import aavax.xml.stream.XMLEventReader;
import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.events.Characters;
import aavax.xml.stream.events.XMLEvent;
import aavax.xml.stream.util.XMLEventAllocator;
import aavax.xml.stream.util.XMLEventConsumer;
import com.bea.xml.stream.util.CircularQueue;
import com.bea.xml.stream.util.ElementTypeNames;
import java.io.FileReader;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class XMLEventReaderBase implements XMLEventReader, XMLEventConsumer {
    protected XMLEventAllocator allocator;
    private ConfigurationContextBase configurationContext;
    private CircularQueue elementQ;
    private boolean open;
    private boolean reachedEOF;
    protected XMLStreamReader reader;

    public XMLEventReaderBase(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this(xMLStreamReader, new XMLEventAllocatorBase());
    }

    public XMLEventReaderBase(XMLStreamReader xMLStreamReader, XMLEventAllocator xMLEventAllocator) throws XMLStreamException {
        this.elementQ = new CircularQueue();
        this.open = true;
        this.reachedEOF = false;
        if (xMLStreamReader == null) {
            throw new IllegalArgumentException("XMLStreamReader may not be null");
        }
        if (xMLEventAllocator == null) {
            throw new IllegalArgumentException("XMLEventAllocator may not be null");
        }
        this.reader = xMLStreamReader;
        this.open = true;
        this.allocator = xMLEventAllocator;
        if (xMLStreamReader.getEventType() == 7) {
            XMLEvent allocate = this.allocator.allocate(xMLStreamReader);
            xMLStreamReader.next();
            add(allocate);
        }
    }

    public void setAllocator(XMLEventAllocator xMLEventAllocator) {
        if (xMLEventAllocator == null) {
            throw new IllegalArgumentException("XMLEvent Allocator may not be null");
        }
        this.allocator = xMLEventAllocator;
    }

    @Override // aavax.xml.stream.XMLEventReader
    public String getElementText() throws XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer();
        XMLEvent nextEvent = nextEvent();
        if (!nextEvent.isStartElement()) {
            throw new XMLStreamException(new StringBuffer().append("Precondition for readText is nextEvent().getTypeEventType() == START_ELEMENT (got ").append(nextEvent.getEventType()).append(")").toString());
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
        if (needsMore() && !parseSome()) {
            throw new NoSuchElementException("Attempt to call nextEvent() on a stream with no more elements");
        }
        return get();
    }

    @Override // aavax.xml.stream.XMLEventReader, java.util.Iterator
    public boolean hasNext() {
        if (!this.open) {
            return false;
        }
        if (!this.elementQ.isEmpty()) {
            return true;
        }
        if (this.reader.hasNext()) {
            return true;
        }
        this.open = false;
        return false;
    }

    @Override // aavax.xml.stream.XMLEventReader
    public XMLEvent peek() throws XMLStreamException {
        if (!this.elementQ.isEmpty()) {
            return (XMLEvent) this.elementQ.peek();
        }
        if (parseSome()) {
            return (XMLEvent) this.elementQ.peek();
        }
        return null;
    }

    @Override // aavax.xml.stream.util.XMLEventConsumer
    public void add(XMLEvent xMLEvent) throws XMLStreamException {
        this.elementQ.add(xMLEvent);
    }

    protected boolean needsMore() {
        return this.elementQ.isEmpty();
    }

    protected XMLEvent get() throws XMLStreamException {
        return (XMLEvent) this.elementQ.remove();
    }

    protected boolean isOpen() {
        return !this.reachedEOF;
    }

    protected void internal_close() {
        this.reachedEOF = true;
    }

    @Override // aavax.xml.stream.XMLEventReader
    public void close() throws XMLStreamException {
        internal_close();
    }

    protected boolean parseSome() throws XMLStreamException {
        if (this.reachedEOF) {
            return false;
        }
        this.allocator.allocate(this.reader, this);
        if (this.reader.hasNext()) {
            this.reader.next();
        }
        if (this.reader.getEventType() == 8) {
            this.allocator.allocate(this.reader, this);
            this.reachedEOF = true;
        }
        return !needsMore();
    }

    public void setConfigurationContext(ConfigurationContextBase configurationContextBase) {
        this.configurationContext = configurationContextBase;
    }

    @Override // aavax.xml.stream.XMLEventReader
    public Object getProperty(String str) {
        return this.configurationContext.getProperty(str);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] strArr) throws Exception {
        System.setProperty("aavax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
        System.setProperty("aavax.xml.stream.XMLEventFactory", "com.bea.xml.stream.EventFactory");
        XMLEventReader createXMLEventReader = XMLInputFactory.newInstance().createXMLEventReader(new FileReader(strArr[0]));
        while (createXMLEventReader.hasNext()) {
            XMLEvent nextEvent = createXMLEventReader.nextEvent();
            System.out.println(new StringBuffer().append("[").append(ElementTypeNames.getEventTypeString(nextEvent.getEventType())).append("][").append(nextEvent).append("]").toString());
        }
    }
}