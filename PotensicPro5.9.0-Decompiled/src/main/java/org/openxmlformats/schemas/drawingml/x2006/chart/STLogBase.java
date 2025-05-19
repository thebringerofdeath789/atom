package org.openxmlformats.schemas.drawingml.x2006.chart;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface STLogBase extends XmlDouble {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLogBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlogbase11a1type");

    public static final class Factory {
        private Factory() {
        }

        public static STLogBase newInstance() {
            return (STLogBase) XmlBeans.getContextTypeLoader().newInstance(STLogBase.type, null);
        }

        public static STLogBase newInstance(XmlOptions xmlOptions) {
            return (STLogBase) XmlBeans.getContextTypeLoader().newInstance(STLogBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLogBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLogBase.type, xmlOptions);
        }

        public static STLogBase newValue(Object obj) {
            return (STLogBase) STLogBase.type.newValue(obj);
        }

        public static STLogBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(File file) throws XmlException, IOException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(file, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(file, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(InputStream inputStream) throws XmlException, IOException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(inputStream, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(inputStream, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(Reader reader) throws XmlException, IOException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(reader, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(reader, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(String str) throws XmlException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(str, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(str, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(URL url) throws XmlException, IOException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(url, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(url, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(Node node) throws XmlException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(node, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLogBase) XmlBeans.getContextTypeLoader().parse(node, STLogBase.type, xmlOptions);
        }
    }
}
