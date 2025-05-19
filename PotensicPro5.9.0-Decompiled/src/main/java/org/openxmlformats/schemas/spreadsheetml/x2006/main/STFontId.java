package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STFontId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STFontId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stfontid9d63type");

    public static final class Factory {
        private Factory() {
        }

        public static STFontId newInstance() {
            return (STFontId) XmlBeans.getContextTypeLoader().newInstance(STFontId.type, null);
        }

        public static STFontId newInstance(XmlOptions xmlOptions) {
            return (STFontId) XmlBeans.getContextTypeLoader().newInstance(STFontId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFontId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFontId.type, xmlOptions);
        }

        public static STFontId newValue(Object obj) {
            return (STFontId) STFontId.type.newValue(obj);
        }

        public static STFontId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFontId.type, xmlOptions);
        }

        public static STFontId parse(File file) throws XmlException, IOException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(file, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(file, STFontId.type, xmlOptions);
        }

        public static STFontId parse(InputStream inputStream) throws XmlException, IOException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(inputStream, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(inputStream, STFontId.type, xmlOptions);
        }

        public static STFontId parse(Reader reader) throws XmlException, IOException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(reader, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(reader, STFontId.type, xmlOptions);
        }

        public static STFontId parse(String str) throws XmlException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(str, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(str, STFontId.type, xmlOptions);
        }

        public static STFontId parse(URL url) throws XmlException, IOException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(url, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(url, STFontId.type, xmlOptions);
        }

        public static STFontId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFontId.type, xmlOptions);
        }

        public static STFontId parse(Node node) throws XmlException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(node, STFontId.type, (XmlOptions) null);
        }

        public static STFontId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STFontId) XmlBeans.getContextTypeLoader().parse(node, STFontId.type, xmlOptions);
        }
    }
}
