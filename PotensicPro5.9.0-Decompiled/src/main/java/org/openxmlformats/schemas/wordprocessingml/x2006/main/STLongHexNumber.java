package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface STLongHexNumber extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLongHexNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlonghexnumberd6batype");

    public static final class Factory {
        private Factory() {
        }

        public static STLongHexNumber newInstance() {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().newInstance(STLongHexNumber.type, null);
        }

        public static STLongHexNumber newInstance(XmlOptions xmlOptions) {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().newInstance(STLongHexNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLongHexNumber.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber newValue(Object obj) {
            return (STLongHexNumber) STLongHexNumber.type.newValue(obj);
        }

        public static STLongHexNumber parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(File file) throws XmlException, IOException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(file, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(file, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(InputStream inputStream) throws XmlException, IOException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(inputStream, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(inputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(Reader reader) throws XmlException, IOException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(reader, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(reader, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(String str) throws XmlException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(str, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(str, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(URL url) throws XmlException, IOException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(url, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(url, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(Node node) throws XmlException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(node, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLongHexNumber) XmlBeans.getContextTypeLoader().parse(node, STLongHexNumber.type, xmlOptions);
        }
    }
}
