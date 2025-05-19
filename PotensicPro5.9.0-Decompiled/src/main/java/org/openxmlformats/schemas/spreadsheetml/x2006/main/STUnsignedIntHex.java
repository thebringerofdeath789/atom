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
public interface STUnsignedIntHex extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STUnsignedIntHex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stunsignedinthex27datype");

    public static final class Factory {
        private Factory() {
        }

        public static STUnsignedIntHex newInstance() {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().newInstance(STUnsignedIntHex.type, null);
        }

        public static STUnsignedIntHex newInstance(XmlOptions xmlOptions) {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().newInstance(STUnsignedIntHex.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STUnsignedIntHex.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STUnsignedIntHex.type, xmlOptions);
        }

        public static STUnsignedIntHex newValue(Object obj) {
            return (STUnsignedIntHex) STUnsignedIntHex.type.newValue(obj);
        }

        public static STUnsignedIntHex parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STUnsignedIntHex.type, (XmlOptions) null);
        }

        public static STUnsignedIntHex parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STUnsignedIntHex.type, xmlOptions);
        }

        public static STUnsignedIntHex parse(File file) throws XmlException, IOException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(file, STUnsignedIntHex.type, (XmlOptions) null);
        }

        public static STUnsignedIntHex parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(file, STUnsignedIntHex.type, xmlOptions);
        }

        public static STUnsignedIntHex parse(InputStream inputStream) throws XmlException, IOException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(inputStream, STUnsignedIntHex.type, (XmlOptions) null);
        }

        public static STUnsignedIntHex parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(inputStream, STUnsignedIntHex.type, xmlOptions);
        }

        public static STUnsignedIntHex parse(Reader reader) throws XmlException, IOException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(reader, STUnsignedIntHex.type, (XmlOptions) null);
        }

        public static STUnsignedIntHex parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(reader, STUnsignedIntHex.type, xmlOptions);
        }

        public static STUnsignedIntHex parse(String str) throws XmlException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(str, STUnsignedIntHex.type, (XmlOptions) null);
        }

        public static STUnsignedIntHex parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(str, STUnsignedIntHex.type, xmlOptions);
        }

        public static STUnsignedIntHex parse(URL url) throws XmlException, IOException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(url, STUnsignedIntHex.type, (XmlOptions) null);
        }

        public static STUnsignedIntHex parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(url, STUnsignedIntHex.type, xmlOptions);
        }

        public static STUnsignedIntHex parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STUnsignedIntHex.type, (XmlOptions) null);
        }

        public static STUnsignedIntHex parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STUnsignedIntHex.type, xmlOptions);
        }

        public static STUnsignedIntHex parse(Node node) throws XmlException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(node, STUnsignedIntHex.type, (XmlOptions) null);
        }

        public static STUnsignedIntHex parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedIntHex) XmlBeans.getContextTypeLoader().parse(node, STUnsignedIntHex.type, xmlOptions);
        }
    }
}
