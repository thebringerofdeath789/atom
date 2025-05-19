package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STTextFontSize extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextFontSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextfontsizeb3a8type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextFontSize newInstance() {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().newInstance(STTextFontSize.type, null);
        }

        public static STTextFontSize newInstance(XmlOptions xmlOptions) {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().newInstance(STTextFontSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextFontSize.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize newValue(Object obj) {
            return (STTextFontSize) STTextFontSize.type.newValue(obj);
        }

        public static STTextFontSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(File file) throws XmlException, IOException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(file, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(file, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(inputStream, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(inputStream, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(Reader reader) throws XmlException, IOException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(reader, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(reader, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(String str) throws XmlException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(str, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(str, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(URL url) throws XmlException, IOException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(url, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(url, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(Node node) throws XmlException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(node, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontSize) XmlBeans.getContextTypeLoader().parse(node, STTextFontSize.type, xmlOptions);
        }
    }
}
