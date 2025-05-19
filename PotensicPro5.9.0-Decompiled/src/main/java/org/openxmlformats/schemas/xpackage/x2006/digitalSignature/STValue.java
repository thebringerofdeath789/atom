package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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

/* loaded from: classes6.dex */
public interface STValue extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STValue.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("stvalueb6e1type");

    public static final class Factory {
        private Factory() {
        }

        public static STValue newInstance() {
            return (STValue) XmlBeans.getContextTypeLoader().newInstance(STValue.type, null);
        }

        public static STValue newInstance(XmlOptions xmlOptions) {
            return (STValue) XmlBeans.getContextTypeLoader().newInstance(STValue.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STValue.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STValue.type, xmlOptions);
        }

        public static STValue newValue(Object obj) {
            return (STValue) STValue.type.newValue(obj);
        }

        public static STValue parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STValue.type, xmlOptions);
        }

        public static STValue parse(File file) throws XmlException, IOException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(file, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(file, STValue.type, xmlOptions);
        }

        public static STValue parse(InputStream inputStream) throws XmlException, IOException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(inputStream, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(inputStream, STValue.type, xmlOptions);
        }

        public static STValue parse(Reader reader) throws XmlException, IOException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(reader, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(reader, STValue.type, xmlOptions);
        }

        public static STValue parse(String str) throws XmlException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(str, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(str, STValue.type, xmlOptions);
        }

        public static STValue parse(URL url) throws XmlException, IOException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(url, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(url, STValue.type, xmlOptions);
        }

        public static STValue parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STValue.type, xmlOptions);
        }

        public static STValue parse(Node node) throws XmlException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(node, STValue.type, (XmlOptions) null);
        }

        public static STValue parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STValue) XmlBeans.getContextTypeLoader().parse(node, STValue.type, xmlOptions);
        }
    }
}
