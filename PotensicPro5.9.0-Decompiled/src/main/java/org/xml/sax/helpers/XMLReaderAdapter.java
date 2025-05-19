package org.xml.sax.helpers;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* loaded from: classes6.dex */
public class XMLReaderAdapter implements Parser, ContentHandler {
    DocumentHandler documentHandler;
    AttributesAdapter qAtts;
    XMLReader xmlReader;

    final class AttributesAdapter implements AttributeList {
        private Attributes attributes;

        AttributesAdapter() {
        }

        @Override // org.xml.sax.AttributeList
        public int getLength() {
            return this.attributes.getLength();
        }

        @Override // org.xml.sax.AttributeList
        public String getName(int i) {
            return this.attributes.getQName(i);
        }

        @Override // org.xml.sax.AttributeList
        public String getType(int i) {
            return this.attributes.getType(i);
        }

        @Override // org.xml.sax.AttributeList
        public String getType(String str) {
            return this.attributes.getType(str);
        }

        @Override // org.xml.sax.AttributeList
        public String getValue(int i) {
            return this.attributes.getValue(i);
        }

        @Override // org.xml.sax.AttributeList
        public String getValue(String str) {
            return this.attributes.getValue(str);
        }

        void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }
    }

    public XMLReaderAdapter() throws SAXException {
        setup(XMLReaderFactory.createXMLReader());
    }

    public XMLReaderAdapter(XMLReader xMLReader) {
        setup(xMLReader);
    }

    private void setup(XMLReader xMLReader) {
        Objects.requireNonNull(xMLReader, "XMLReader must not be null");
        this.xmlReader = xMLReader;
        this.qAtts = new AttributesAdapter();
    }

    private void setupXMLReader() throws SAXException {
        this.xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
        try {
            this.xmlReader.setFeature("http://xml.org/sax/features/namespaces", false);
        } catch (SAXException unused) {
        }
        this.xmlReader.setContentHandler(this);
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        DocumentHandler documentHandler = this.documentHandler;
        if (documentHandler != null) {
            documentHandler.characters(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        DocumentHandler documentHandler = this.documentHandler;
        if (documentHandler != null) {
            documentHandler.endDocument();
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        DocumentHandler documentHandler = this.documentHandler;
        if (documentHandler != null) {
            documentHandler.endElement(str3);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) {
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        DocumentHandler documentHandler = this.documentHandler;
        if (documentHandler != null) {
            documentHandler.ignorableWhitespace(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void parse(String str) throws IOException, SAXException {
        parse(new InputSource(str));
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws IOException, SAXException {
        setupXMLReader();
        this.xmlReader.parse(inputSource);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        DocumentHandler documentHandler = this.documentHandler;
        if (documentHandler != null) {
            documentHandler.processingInstruction(str, str2);
        }
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        this.xmlReader.setDTDHandler(dTDHandler);
    }

    @Override // org.xml.sax.Parser
    public void setDocumentHandler(DocumentHandler documentHandler) {
        this.documentHandler = documentHandler;
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        DocumentHandler documentHandler = this.documentHandler;
        if (documentHandler != null) {
            documentHandler.setDocumentLocator(locator);
        }
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        this.xmlReader.setEntityResolver(entityResolver);
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.xmlReader.setErrorHandler(errorHandler);
    }

    @Override // org.xml.sax.Parser
    public void setLocale(Locale locale) throws SAXException {
        throw new SAXNotSupportedException("setLocale not supported");
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        DocumentHandler documentHandler = this.documentHandler;
        if (documentHandler != null) {
            documentHandler.startDocument();
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.documentHandler != null) {
            this.qAtts.setAttributes(attributes);
            this.documentHandler.startElement(str3, this.qAtts);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
    }
}
