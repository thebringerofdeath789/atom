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
public interface STTextSpacingPoint extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextSpacingPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextspacingpointdd05type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextSpacingPoint newInstance() {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().newInstance(STTextSpacingPoint.type, null);
        }

        public static STTextSpacingPoint newInstance(XmlOptions xmlOptions) {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().newInstance(STTextSpacingPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextSpacingPoint.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint newValue(Object obj) {
            return (STTextSpacingPoint) STTextSpacingPoint.type.newValue(obj);
        }

        public static STTextSpacingPoint parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(File file) throws XmlException, IOException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(file, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(file, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(inputStream, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(inputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(Reader reader) throws XmlException, IOException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(reader, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(reader, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(String str) throws XmlException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(str, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(str, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(URL url) throws XmlException, IOException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(url, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(url, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(Node node) throws XmlException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(node, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(node, STTextSpacingPoint.type, xmlOptions);
        }
    }
}
