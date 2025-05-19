package org.xml.sax.helpers;

import java.io.IOException;
import java.util.Objects;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

/* loaded from: classes6.dex */
public class XMLFilterImpl implements XMLFilter, EntityResolver, DTDHandler, ContentHandler, ErrorHandler {
    private XMLReader parent = null;
    private Locator locator = null;
    private EntityResolver entityResolver = null;
    private DTDHandler dtdHandler = null;
    private ContentHandler contentHandler = null;
    private ErrorHandler errorHandler = null;

    public XMLFilterImpl() {
    }

    public XMLFilterImpl(XMLReader xMLReader) {
        setParent(xMLReader);
    }

    private void setupParse() {
        XMLReader xMLReader = this.parent;
        Objects.requireNonNull(xMLReader, "No parent for filter");
        xMLReader.setEntityResolver(this);
        this.parent.setDTDHandler(this);
        this.parent.setContentHandler(this);
        this.parent.setErrorHandler(this);
    }

    public void characters(char[] cArr, int i, int i2) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.characters(cArr, i, i2);
        }
    }

    public void endDocument() throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.endDocument();
        }
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.endElement(str, str2, str3);
        }
    }

    public void endPrefixMapping(String str) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.endPrefixMapping(str);
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        ErrorHandler errorHandler = this.errorHandler;
        if (errorHandler != null) {
            errorHandler.error(sAXParseException);
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        ErrorHandler errorHandler = this.errorHandler;
        if (errorHandler != null) {
            errorHandler.fatalError(sAXParseException);
        }
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        XMLReader xMLReader = this.parent;
        if (xMLReader != null) {
            return xMLReader.getFeature(str);
        }
        throw new SAXNotRecognizedException(new StringBuffer().append("Feature: ").append(str).toString());
    }

    @Override // org.xml.sax.XMLFilter
    public XMLReader getParent() {
        return this.parent;
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        XMLReader xMLReader = this.parent;
        if (xMLReader != null) {
            return xMLReader.getProperty(str);
        }
        throw new SAXNotRecognizedException(new StringBuffer().append("Property: ").append(str).toString());
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.ignorableWhitespace(cArr, i, i2);
        }
    }

    public void notationDecl(String str, String str2, String str3) throws SAXException {
        DTDHandler dTDHandler = this.dtdHandler;
        if (dTDHandler != null) {
            dTDHandler.notationDecl(str, str2, str3);
        }
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) throws SAXException, IOException {
        parse(new InputSource(str));
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws SAXException, IOException {
        setupParse();
        this.parent.parse(inputSource);
    }

    public void processingInstruction(String str, String str2) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.processingInstruction(str, str2);
        }
    }

    @Override // org.xml.sax.EntityResolver
    public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
        EntityResolver entityResolver = this.entityResolver;
        if (entityResolver != null) {
            return entityResolver.resolveEntity(str, str2);
        }
        return null;
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        this.dtdHandler = dTDHandler;
    }

    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.setDocumentLocator(locator);
        }
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        XMLReader xMLReader = this.parent;
        if (xMLReader == null) {
            throw new SAXNotRecognizedException(new StringBuffer().append("Feature: ").append(str).toString());
        }
        xMLReader.setFeature(str, z);
    }

    @Override // org.xml.sax.XMLFilter
    public void setParent(XMLReader xMLReader) {
        this.parent = xMLReader;
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        XMLReader xMLReader = this.parent;
        if (xMLReader == null) {
            throw new SAXNotRecognizedException(new StringBuffer().append("Property: ").append(str).toString());
        }
        xMLReader.setProperty(str, obj);
    }

    public void skippedEntity(String str) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.skippedEntity(str);
        }
    }

    public void startDocument() throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.startDocument();
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.startElement(str, str2, str3, attributes);
        }
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.startPrefixMapping(str, str2);
        }
    }

    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
        DTDHandler dTDHandler = this.dtdHandler;
        if (dTDHandler != null) {
            dTDHandler.unparsedEntityDecl(str, str2, str3, str4);
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
        ErrorHandler errorHandler = this.errorHandler;
        if (errorHandler != null) {
            errorHandler.warning(sAXParseException);
        }
    }
}
