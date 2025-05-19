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
public interface STLangCode extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLangCode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlangcode02bdtype");

    public static final class Factory {
        private Factory() {
        }

        public static STLangCode newInstance() {
            return (STLangCode) XmlBeans.getContextTypeLoader().newInstance(STLangCode.type, null);
        }

        public static STLangCode newInstance(XmlOptions xmlOptions) {
            return (STLangCode) XmlBeans.getContextTypeLoader().newInstance(STLangCode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLangCode.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLangCode.type, xmlOptions);
        }

        public static STLangCode newValue(Object obj) {
            return (STLangCode) STLangCode.type.newValue(obj);
        }

        public static STLangCode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(File file) throws XmlException, IOException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(file, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(file, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(InputStream inputStream) throws XmlException, IOException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(inputStream, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(inputStream, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(Reader reader) throws XmlException, IOException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(reader, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(reader, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(String str) throws XmlException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(str, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(str, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(URL url) throws XmlException, IOException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(url, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(url, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLangCode.type, xmlOptions);
        }

        public static STLangCode parse(Node node) throws XmlException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(node, STLangCode.type, (XmlOptions) null);
        }

        public static STLangCode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLangCode) XmlBeans.getContextTypeLoader().parse(node, STLangCode.type, xmlOptions);
        }
    }
}
