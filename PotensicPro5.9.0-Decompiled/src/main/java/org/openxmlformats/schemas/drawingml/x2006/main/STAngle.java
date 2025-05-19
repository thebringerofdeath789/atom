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
public interface STAngle extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STAngle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stangle8074type");

    public static final class Factory {
        private Factory() {
        }

        public static STAngle newInstance() {
            return (STAngle) XmlBeans.getContextTypeLoader().newInstance(STAngle.type, null);
        }

        public static STAngle newInstance(XmlOptions xmlOptions) {
            return (STAngle) XmlBeans.getContextTypeLoader().newInstance(STAngle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAngle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAngle.type, xmlOptions);
        }

        public static STAngle newValue(Object obj) {
            return (STAngle) STAngle.type.newValue(obj);
        }

        public static STAngle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAngle.type, xmlOptions);
        }

        public static STAngle parse(File file) throws XmlException, IOException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(file, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(file, STAngle.type, xmlOptions);
        }

        public static STAngle parse(InputStream inputStream) throws XmlException, IOException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(inputStream, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(inputStream, STAngle.type, xmlOptions);
        }

        public static STAngle parse(Reader reader) throws XmlException, IOException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(reader, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(reader, STAngle.type, xmlOptions);
        }

        public static STAngle parse(String str) throws XmlException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(str, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(str, STAngle.type, xmlOptions);
        }

        public static STAngle parse(URL url) throws XmlException, IOException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(url, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(url, STAngle.type, xmlOptions);
        }

        public static STAngle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAngle.type, xmlOptions);
        }

        public static STAngle parse(Node node) throws XmlException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(node, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STAngle) XmlBeans.getContextTypeLoader().parse(node, STAngle.type, xmlOptions);
        }
    }
}
