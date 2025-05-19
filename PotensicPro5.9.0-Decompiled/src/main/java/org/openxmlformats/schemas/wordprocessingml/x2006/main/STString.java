package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface STString extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STString.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ststringa627type");

    public static final class Factory {
        private Factory() {
        }

        public static STString newInstance() {
            return (STString) XmlBeans.getContextTypeLoader().newInstance(STString.type, null);
        }

        public static STString newInstance(XmlOptions xmlOptions) {
            return (STString) XmlBeans.getContextTypeLoader().newInstance(STString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STString.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STString.type, xmlOptions);
        }

        public static STString newValue(Object obj) {
            return (STString) STString.type.newValue(obj);
        }

        public static STString parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STString.type, (XmlOptions) null);
        }

        public static STString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STString.type, xmlOptions);
        }

        public static STString parse(File file) throws XmlException, IOException {
            return (STString) XmlBeans.getContextTypeLoader().parse(file, STString.type, (XmlOptions) null);
        }

        public static STString parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STString) XmlBeans.getContextTypeLoader().parse(file, STString.type, xmlOptions);
        }

        public static STString parse(InputStream inputStream) throws XmlException, IOException {
            return (STString) XmlBeans.getContextTypeLoader().parse(inputStream, STString.type, (XmlOptions) null);
        }

        public static STString parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STString) XmlBeans.getContextTypeLoader().parse(inputStream, STString.type, xmlOptions);
        }

        public static STString parse(Reader reader) throws XmlException, IOException {
            return (STString) XmlBeans.getContextTypeLoader().parse(reader, STString.type, (XmlOptions) null);
        }

        public static STString parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STString) XmlBeans.getContextTypeLoader().parse(reader, STString.type, xmlOptions);
        }

        public static STString parse(String str) throws XmlException {
            return (STString) XmlBeans.getContextTypeLoader().parse(str, STString.type, (XmlOptions) null);
        }

        public static STString parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STString) XmlBeans.getContextTypeLoader().parse(str, STString.type, xmlOptions);
        }

        public static STString parse(URL url) throws XmlException, IOException {
            return (STString) XmlBeans.getContextTypeLoader().parse(url, STString.type, (XmlOptions) null);
        }

        public static STString parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STString) XmlBeans.getContextTypeLoader().parse(url, STString.type, xmlOptions);
        }

        public static STString parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STString.type, (XmlOptions) null);
        }

        public static STString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STString.type, xmlOptions);
        }

        public static STString parse(Node node) throws XmlException {
            return (STString) XmlBeans.getContextTypeLoader().parse(node, STString.type, (XmlOptions) null);
        }

        public static STString parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STString) XmlBeans.getContextTypeLoader().parse(node, STString.type, xmlOptions);
        }
    }
}
