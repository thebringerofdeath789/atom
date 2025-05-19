package org.dom4j.io;

import java.io.IOException;
import org.dom4j.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes5.dex */
public class SAXValidator {
    private ErrorHandler errorHandler;
    private XMLReader xmlReader;

    public SAXValidator() {
    }

    public SAXValidator(XMLReader xMLReader) {
        this.xmlReader = xMLReader;
    }

    public void validate(Document document) throws SAXException {
        if (document != null) {
            XMLReader xMLReader = getXMLReader();
            ErrorHandler errorHandler = this.errorHandler;
            if (errorHandler != null) {
                xMLReader.setErrorHandler(errorHandler);
            }
            try {
                xMLReader.parse(new DocumentInputSource(document));
            } catch (IOException e) {
                throw new RuntimeException(new StringBuffer().append("Caught and exception that should never happen: ").append(e).toString());
            }
        }
    }

    public XMLReader getXMLReader() throws SAXException {
        if (this.xmlReader == null) {
            this.xmlReader = createXMLReader();
            configureReader();
        }
        return this.xmlReader;
    }

    public void setXMLReader(XMLReader xMLReader) throws SAXException {
        this.xmlReader = xMLReader;
        configureReader();
    }

    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    protected XMLReader createXMLReader() throws SAXException {
        return SAXHelper.createXMLReader(true);
    }

    protected void configureReader() throws SAXException {
        if (this.xmlReader.getContentHandler() == null) {
            this.xmlReader.setContentHandler(new DefaultHandler());
        }
        this.xmlReader.setFeature("http://xml.org/sax/features/validation", true);
        this.xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
        this.xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
    }
}
