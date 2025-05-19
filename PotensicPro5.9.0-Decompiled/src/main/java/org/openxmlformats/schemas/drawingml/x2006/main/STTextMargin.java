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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STTextMargin extends STCoordinate32 {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextMargin.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextmargin9666type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextMargin newInstance() {
            return (STTextMargin) XmlBeans.getContextTypeLoader().newInstance(STTextMargin.type, null);
        }

        public static STTextMargin newInstance(XmlOptions xmlOptions) {
            return (STTextMargin) XmlBeans.getContextTypeLoader().newInstance(STTextMargin.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextMargin.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin newValue(Object obj) {
            return (STTextMargin) STTextMargin.type.newValue(obj);
        }

        public static STTextMargin parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(File file) throws XmlException, IOException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(file, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(file, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(inputStream, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(inputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(Reader reader) throws XmlException, IOException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(reader, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(reader, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(String str) throws XmlException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(str, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(str, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(URL url) throws XmlException, IOException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(url, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(url, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(Node node) throws XmlException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(node, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextMargin) XmlBeans.getContextTypeLoader().parse(node, STTextMargin.type, xmlOptions);
        }
    }
}
