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
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STDecimalNumber extends XmlInteger {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STDecimalNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stdecimalnumber8d28type");

    public static final class Factory {
        private Factory() {
        }

        public static STDecimalNumber newInstance() {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().newInstance(STDecimalNumber.type, null);
        }

        public static STDecimalNumber newInstance(XmlOptions xmlOptions) {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().newInstance(STDecimalNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDecimalNumber.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber newValue(Object obj) {
            return (STDecimalNumber) STDecimalNumber.type.newValue(obj);
        }

        public static STDecimalNumber parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(File file) throws XmlException, IOException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(file, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(file, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(InputStream inputStream) throws XmlException, IOException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(inputStream, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(inputStream, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(Reader reader) throws XmlException, IOException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(reader, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(reader, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(String str) throws XmlException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(str, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(str, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(URL url) throws XmlException, IOException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(url, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(url, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(Node node) throws XmlException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(node, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STDecimalNumber) XmlBeans.getContextTypeLoader().parse(node, STDecimalNumber.type, xmlOptions);
        }
    }
}
