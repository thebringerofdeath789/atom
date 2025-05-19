package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface STRef extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stref90a2type");

    public static final class Factory {
        private Factory() {
        }

        public static STRef newInstance() {
            return (STRef) XmlBeans.getContextTypeLoader().newInstance(STRef.type, null);
        }

        public static STRef newInstance(XmlOptions xmlOptions) {
            return (STRef) XmlBeans.getContextTypeLoader().newInstance(STRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STRef.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STRef.type, xmlOptions);
        }

        public static STRef newValue(Object obj) {
            return (STRef) STRef.type.newValue(obj);
        }

        public static STRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STRef.type, xmlOptions);
        }

        public static STRef parse(File file) throws XmlException, IOException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(file, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(file, STRef.type, xmlOptions);
        }

        public static STRef parse(InputStream inputStream) throws XmlException, IOException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(inputStream, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(inputStream, STRef.type, xmlOptions);
        }

        public static STRef parse(Reader reader) throws XmlException, IOException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(reader, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(reader, STRef.type, xmlOptions);
        }

        public static STRef parse(String str) throws XmlException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(str, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(str, STRef.type, xmlOptions);
        }

        public static STRef parse(URL url) throws XmlException, IOException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(url, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(url, STRef.type, xmlOptions);
        }

        public static STRef parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STRef.type, xmlOptions);
        }

        public static STRef parse(Node node) throws XmlException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(node, STRef.type, (XmlOptions) null);
        }

        public static STRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STRef) XmlBeans.getContextTypeLoader().parse(node, STRef.type, xmlOptions);
        }
    }
}
