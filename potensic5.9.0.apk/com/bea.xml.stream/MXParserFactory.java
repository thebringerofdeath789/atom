package com.bea.xml.stream;

import aavax.xml.stream.EventFilter;
import aavax.xml.stream.StreamFilter;
import aavax.xml.stream.XMLEventReader;
import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLReporter;
import aavax.xml.stream.XMLResolver;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.util.XMLEventAllocator;
import java.io.InputStream;
import java.io.Reader;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.InputSource;

/* loaded from: classes.dex */
public class MXParserFactory extends XMLInputFactory {
    ConfigurationContextBase config = new ConfigurationContextBase();

    public static XMLInputFactory newInstance() {
        return XMLInputFactory.newInstance();
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(Source source) throws XMLStreamException {
        if (source instanceof SAXSource) {
            InputSource inputSource = ((SAXSource) source).getInputSource();
            if (inputSource != null) {
                String systemId = inputSource.getSystemId();
                Reader characterStream = inputSource.getCharacterStream();
                if (characterStream != null) {
                    return createXMLStreamReader(systemId, characterStream);
                }
                InputStream byteStream = inputSource.getByteStream();
                if (byteStream != null) {
                    return createXMLStreamReader(systemId, byteStream);
                }
            }
            throw new XMLStreamException("Can only create STaX reader for a SAXSource if Reader or InputStream exposed via getSource(); can not use -- not implemented.");
        }
        boolean z = source instanceof DOMSource;
        throw new UnsupportedOperationException(new StringBuffer().append("XMLInputFactory.createXMLStreamReader(").append(source.getClass().getName()).append(") not yet implemented").toString());
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(InputStream inputStream) throws XMLStreamException {
        MXParser mXParser = new MXParser();
        mXParser.setInput(inputStream);
        mXParser.setConfigurationContext(this.config);
        return mXParser;
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(InputStream inputStream, String str) throws XMLStreamException {
        MXParser mXParser = new MXParser();
        mXParser.setInput(inputStream, str);
        mXParser.setConfigurationContext(this.config);
        return mXParser;
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(String str, InputStream inputStream) throws XMLStreamException {
        return createXMLStreamReader(inputStream);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(String str, Reader reader) throws XMLStreamException {
        return createXMLStreamReader(reader);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(String str, Reader reader) throws XMLStreamException {
        return createXMLEventReader(reader);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(String str, InputStream inputStream) throws XMLStreamException {
        return createXMLEventReader(inputStream);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(Reader reader) throws XMLStreamException {
        return createXMLEventReader(createXMLStreamReader(reader));
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        if (this.config.getEventAllocator() == null) {
            return new XMLEventReaderBase(xMLStreamReader);
        }
        return new XMLEventReaderBase(xMLStreamReader, this.config.getEventAllocator().newInstance());
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(Source source) throws XMLStreamException {
        return createXMLEventReader(createXMLStreamReader(source));
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(InputStream inputStream) throws XMLStreamException {
        return createXMLEventReader(createXMLStreamReader(inputStream));
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventReader createXMLEventReader(InputStream inputStream, String str) throws XMLStreamException {
        return createXMLEventReader(createXMLStreamReader(inputStream, str));
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLResolver getXMLResolver() {
        return this.config.getXMLResolver();
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public void setXMLResolver(XMLResolver xMLResolver) {
        this.config.setXMLResolver(xMLResolver);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLStreamReader createFilteredReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter) throws XMLStreamException {
        return new StreamReaderFilter(xMLStreamReader, streamFilter);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventReader createFilteredReader(XMLEventReader xMLEventReader, EventFilter eventFilter) throws XMLStreamException {
        return new EventReaderFilter(xMLEventReader, eventFilter);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLReporter getXMLReporter() {
        return this.config.getXMLReporter();
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public void setXMLReporter(XMLReporter xMLReporter) {
        this.config.setXMLReporter(xMLReporter);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public void setEventAllocator(XMLEventAllocator xMLEventAllocator) {
        this.config.setEventAllocator(xMLEventAllocator);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLEventAllocator getEventAllocator() {
        return this.config.getEventAllocator();
    }

    public void setCoalescing(boolean z) {
        this.config.setCoalescing(z);
    }

    public boolean isCoalescing() {
        return this.config.isCoalescing();
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public void setProperty(String str, Object obj) throws IllegalArgumentException {
        this.config.setProperty(str, obj);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public Object getProperty(String str) throws IllegalArgumentException {
        return this.config.getProperty(str);
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException {
        MXParser mXParser = new MXParser();
        mXParser.setInput(reader);
        mXParser.setConfigurationContext(this.config);
        return mXParser;
    }

    @Override // aavax.xml.stream.XMLInputFactory
    public boolean isPropertySupported(String str) {
        return this.config.isPropertySupported(str);
    }
}