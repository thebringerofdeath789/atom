package org.xml.sax.helpers;

import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: classes6.dex */
public class DefaultHandler implements EntityResolver, DTDHandler, ContentHandler, ErrorHandler {
    public void characters(char[] cArr, int i, int i2) throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
    }

    public void endPrefixMapping(String str) throws SAXException {
    }

    public void error(SAXParseException sAXParseException) throws SAXException {
    }

    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
    }

    public void notationDecl(String str, String str2, String str3) throws SAXException {
    }

    public void processingInstruction(String str, String str2) throws SAXException {
    }

    @Override // org.xml.sax.EntityResolver
    public InputSource resolveEntity(String str, String str2) throws IOException, SAXException {
        return null;
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String str) throws SAXException {
    }

    public void startDocument() throws SAXException {
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
    }

    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
    }

    public void warning(SAXParseException sAXParseException) throws SAXException {
    }
}
