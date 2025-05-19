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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STTextTypeface extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextTypeface.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttexttypefacea80ftype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextTypeface newInstance() {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().newInstance(STTextTypeface.type, null);
        }

        public static STTextTypeface newInstance(XmlOptions xmlOptions) {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().newInstance(STTextTypeface.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextTypeface.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface newValue(Object obj) {
            return (STTextTypeface) STTextTypeface.type.newValue(obj);
        }

        public static STTextTypeface parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(File file) throws XmlException, IOException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(file, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(file, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(inputStream, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(inputStream, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(Reader reader) throws XmlException, IOException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(reader, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(reader, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(String str) throws XmlException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(str, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(str, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(URL url) throws XmlException, IOException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(url, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(url, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(Node node) throws XmlException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(node, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextTypeface) XmlBeans.getContextTypeLoader().parse(node, STTextTypeface.type, xmlOptions);
        }
    }
}
