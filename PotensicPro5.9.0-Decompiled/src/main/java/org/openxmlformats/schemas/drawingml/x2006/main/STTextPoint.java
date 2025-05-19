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
public interface STTextPoint extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextpoint4284type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextPoint newInstance() {
            return (STTextPoint) XmlBeans.getContextTypeLoader().newInstance(STTextPoint.type, null);
        }

        public static STTextPoint newInstance(XmlOptions xmlOptions) {
            return (STTextPoint) XmlBeans.getContextTypeLoader().newInstance(STTextPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextPoint.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint newValue(Object obj) {
            return (STTextPoint) STTextPoint.type.newValue(obj);
        }

        public static STTextPoint parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(File file) throws XmlException, IOException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(file, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(file, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(inputStream, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(inputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(Reader reader) throws XmlException, IOException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(reader, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(reader, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(String str) throws XmlException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(str, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(str, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(URL url) throws XmlException, IOException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(url, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(url, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(Node node) throws XmlException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(node, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextPoint) XmlBeans.getContextTypeLoader().parse(node, STTextPoint.type, xmlOptions);
        }
    }
}
