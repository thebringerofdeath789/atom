package org.openxmlformats.schemas.drawingml.x2006.chart;

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

/* loaded from: classes2.dex */
public interface STXstring extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STXstring.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stxstringb8cdtype");

    public static final class Factory {
        private Factory() {
        }

        public static STXstring newInstance() {
            return (STXstring) XmlBeans.getContextTypeLoader().newInstance(STXstring.type, null);
        }

        public static STXstring newInstance(XmlOptions xmlOptions) {
            return (STXstring) XmlBeans.getContextTypeLoader().newInstance(STXstring.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STXstring.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STXstring.type, xmlOptions);
        }

        public static STXstring newValue(Object obj) {
            return (STXstring) STXstring.type.newValue(obj);
        }

        public static STXstring parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STXstring.type, xmlOptions);
        }

        public static STXstring parse(File file) throws XmlException, IOException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(file, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(file, STXstring.type, xmlOptions);
        }

        public static STXstring parse(InputStream inputStream) throws XmlException, IOException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(inputStream, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(inputStream, STXstring.type, xmlOptions);
        }

        public static STXstring parse(Reader reader) throws XmlException, IOException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(reader, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(reader, STXstring.type, xmlOptions);
        }

        public static STXstring parse(String str) throws XmlException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(str, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(str, STXstring.type, xmlOptions);
        }

        public static STXstring parse(URL url) throws XmlException, IOException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(url, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(url, STXstring.type, xmlOptions);
        }

        public static STXstring parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STXstring.type, xmlOptions);
        }

        public static STXstring parse(Node node) throws XmlException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(node, STXstring.type, (XmlOptions) null);
        }

        public static STXstring parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STXstring) XmlBeans.getContextTypeLoader().parse(node, STXstring.type, xmlOptions);
        }
    }
}
