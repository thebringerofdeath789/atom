package org.litepal.parser;

import javax.xml.transform.OutputKeys;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes5.dex */
public class LitePalContentHandler extends DefaultHandler {
    private LitePalAttr litePalAttr;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        LitePalAttr litePalAttr = LitePalAttr.getInstance();
        this.litePalAttr = litePalAttr;
        litePalAttr.getClassNames().clear();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        int i = 0;
        if ("dbname".equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.litePalAttr.setDbName(attributes.getValue(i).trim());
                }
                i++;
            }
            return;
        }
        if (OutputKeys.VERSION.equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.litePalAttr.setVersion(Integer.parseInt(attributes.getValue(i).trim()));
                }
                i++;
            }
            return;
        }
        if ("mapping".equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if (JamXmlElements.CLASS.equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.litePalAttr.addClassName(attributes.getValue(i).trim());
                }
                i++;
            }
            return;
        }
        if ("cases".equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.litePalAttr.setCases(attributes.getValue(i).trim());
                }
                i++;
            }
            return;
        }
        if ("storage".equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.litePalAttr.setStorage(attributes.getValue(i).trim());
                }
                i++;
            }
        }
    }
}
