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
public interface STFormat extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STFormat.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("stformat98d1type");

    public static final class Factory {
        private Factory() {
        }

        public static STFormat newInstance() {
            return (STFormat) XmlBeans.getContextTypeLoader().newInstance(STFormat.type, null);
        }

        public static STFormat newInstance(XmlOptions xmlOptions) {
            return (STFormat) XmlBeans.getContextTypeLoader().newInstance(STFormat.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFormat.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFormat.type, xmlOptions);
        }

        public static STFormat newValue(Object obj) {
            return (STFormat) STFormat.type.newValue(obj);
        }

        public static STFormat parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFormat.type, xmlOptions);
        }

        public static STFormat parse(File file) throws XmlException, IOException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(file, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(file, STFormat.type, xmlOptions);
        }

        public static STFormat parse(InputStream inputStream) throws XmlException, IOException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(inputStream, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(inputStream, STFormat.type, xmlOptions);
        }

        public static STFormat parse(Reader reader) throws XmlException, IOException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(reader, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(reader, STFormat.type, xmlOptions);
        }

        public static STFormat parse(String str) throws XmlException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(str, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(str, STFormat.type, xmlOptions);
        }

        public static STFormat parse(URL url) throws XmlException, IOException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(url, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(url, STFormat.type, xmlOptions);
        }

        public static STFormat parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFormat.type, xmlOptions);
        }

        public static STFormat parse(Node node) throws XmlException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(node, STFormat.type, (XmlOptions) null);
        }

        public static STFormat parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STFormat) XmlBeans.getContextTypeLoader().parse(node, STFormat.type, xmlOptions);
        }
    }
}
