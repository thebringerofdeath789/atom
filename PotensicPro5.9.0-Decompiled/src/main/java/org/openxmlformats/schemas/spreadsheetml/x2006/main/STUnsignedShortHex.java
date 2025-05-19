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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STUnsignedShortHex extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STUnsignedShortHex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stunsignedshorthex0bedtype");

    public static final class Factory {
        private Factory() {
        }

        public static STUnsignedShortHex newInstance() {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().newInstance(STUnsignedShortHex.type, null);
        }

        public static STUnsignedShortHex newInstance(XmlOptions xmlOptions) {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().newInstance(STUnsignedShortHex.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STUnsignedShortHex.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex newValue(Object obj) {
            return (STUnsignedShortHex) STUnsignedShortHex.type.newValue(obj);
        }

        public static STUnsignedShortHex parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(File file) throws XmlException, IOException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(file, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(file, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(InputStream inputStream) throws XmlException, IOException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(inputStream, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(inputStream, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(Reader reader) throws XmlException, IOException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(reader, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(reader, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(String str) throws XmlException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(str, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(str, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(URL url) throws XmlException, IOException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(url, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(url, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STUnsignedShortHex.type, xmlOptions);
        }

        public static STUnsignedShortHex parse(Node node) throws XmlException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(node, STUnsignedShortHex.type, (XmlOptions) null);
        }

        public static STUnsignedShortHex parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedShortHex) XmlBeans.getContextTypeLoader().parse(node, STUnsignedShortHex.type, xmlOptions);
        }
    }
}
