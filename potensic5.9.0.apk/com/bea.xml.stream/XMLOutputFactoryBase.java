package com.bea.xml.stream;

import aavax.xml.stream.XMLEventWriter;
import aavax.xml.stream.XMLOutputFactory;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamWriter;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import javax.xml.transform.Result;

/* loaded from: classes.dex */
public class XMLOutputFactoryBase extends XMLOutputFactory {
    ConfigurationContextBase config = new ConfigurationContextBase();

    @Override // aavax.xml.stream.XMLOutputFactory
    public XMLStreamWriter createXMLStreamWriter(Writer writer) throws XMLStreamException {
        XMLWriterBase xMLWriterBase = new XMLWriterBase(writer);
        xMLWriterBase.setConfigurationContext(this.config);
        return xMLWriterBase;
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream) throws XMLStreamException {
        return createXMLStreamWriter(new BufferedWriter(new OutputStreamWriter(outputStream), 500));
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String str) throws XMLStreamException {
        try {
            return createXMLStreamWriter(new BufferedWriter(new OutputStreamWriter(outputStream, str), 500));
        } catch (UnsupportedEncodingException e) {
            throw new XMLStreamException(new StringBuffer().append("Unsupported encoding ").append(str).toString(), e);
        }
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public XMLEventWriter createXMLEventWriter(OutputStream outputStream) throws XMLStreamException {
        return new XMLEventWriterBase(createXMLStreamWriter(outputStream));
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public XMLEventWriter createXMLEventWriter(Writer writer) throws XMLStreamException {
        return new XMLEventWriterBase(createXMLStreamWriter(writer));
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public XMLEventWriter createXMLEventWriter(OutputStream outputStream, String str) throws XMLStreamException {
        return new XMLEventWriterBase(createXMLStreamWriter(outputStream, str));
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public void setProperty(String str, Object obj) {
        this.config.setProperty(str, obj);
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public Object getProperty(String str) {
        return this.config.getProperty(str);
    }

    public boolean isPrefixDefaulting() {
        return this.config.isPrefixDefaulting();
    }

    public void setPrefixDefaulting(boolean z) {
        this.config.setPrefixDefaulting(z);
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public boolean isPropertySupported(String str) {
        return this.config.isPropertySupported(str);
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public XMLStreamWriter createXMLStreamWriter(Result result) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }

    @Override // aavax.xml.stream.XMLOutputFactory
    public XMLEventWriter createXMLEventWriter(Result result) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }
}