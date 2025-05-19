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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STUnsignedDecimalNumber extends XmlUnsignedLong {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STUnsignedDecimalNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stunsigneddecimalnumber74fdtype");

    public static final class Factory {
        private Factory() {
        }

        public static STUnsignedDecimalNumber newInstance() {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().newInstance(STUnsignedDecimalNumber.type, null);
        }

        public static STUnsignedDecimalNumber newInstance(XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().newInstance(STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STUnsignedDecimalNumber.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber newValue(Object obj) {
            return (STUnsignedDecimalNumber) STUnsignedDecimalNumber.type.newValue(obj);
        }

        public static STUnsignedDecimalNumber parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(File file) throws XmlException, IOException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(file, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(file, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(InputStream inputStream) throws XmlException, IOException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(inputStream, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(inputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(Reader reader) throws XmlException, IOException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(reader, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(reader, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(String str) throws XmlException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(str, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(str, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(URL url) throws XmlException, IOException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(url, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(url, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(Node node) throws XmlException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(node, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STUnsignedDecimalNumber) XmlBeans.getContextTypeLoader().parse(node, STUnsignedDecimalNumber.type, xmlOptions);
        }
    }
}
