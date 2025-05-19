package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface STName extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stnameadaatype");

    public static final class Factory {
        private Factory() {
        }

        public static STName newInstance() {
            return (STName) XmlBeans.getContextTypeLoader().newInstance(STName.type, null);
        }

        public static STName newInstance(XmlOptions xmlOptions) {
            return (STName) XmlBeans.getContextTypeLoader().newInstance(STName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STName.type, xmlOptions);
        }

        public static STName newValue(Object obj) {
            return (STName) STName.type.newValue(obj);
        }

        public static STName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STName.type, (XmlOptions) null);
        }

        public static STName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STName.type, xmlOptions);
        }

        public static STName parse(File file) throws XmlException, IOException {
            return (STName) XmlBeans.getContextTypeLoader().parse(file, STName.type, (XmlOptions) null);
        }

        public static STName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STName) XmlBeans.getContextTypeLoader().parse(file, STName.type, xmlOptions);
        }

        public static STName parse(InputStream inputStream) throws XmlException, IOException {
            return (STName) XmlBeans.getContextTypeLoader().parse(inputStream, STName.type, (XmlOptions) null);
        }

        public static STName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STName) XmlBeans.getContextTypeLoader().parse(inputStream, STName.type, xmlOptions);
        }

        public static STName parse(Reader reader) throws XmlException, IOException {
            return (STName) XmlBeans.getContextTypeLoader().parse(reader, STName.type, (XmlOptions) null);
        }

        public static STName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STName) XmlBeans.getContextTypeLoader().parse(reader, STName.type, xmlOptions);
        }

        public static STName parse(String str) throws XmlException {
            return (STName) XmlBeans.getContextTypeLoader().parse(str, STName.type, (XmlOptions) null);
        }

        public static STName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STName) XmlBeans.getContextTypeLoader().parse(str, STName.type, xmlOptions);
        }

        public static STName parse(URL url) throws XmlException, IOException {
            return (STName) XmlBeans.getContextTypeLoader().parse(url, STName.type, (XmlOptions) null);
        }

        public static STName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STName) XmlBeans.getContextTypeLoader().parse(url, STName.type, xmlOptions);
        }

        public static STName parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STName.type, (XmlOptions) null);
        }

        public static STName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STName.type, xmlOptions);
        }

        public static STName parse(Node node) throws XmlException {
            return (STName) XmlBeans.getContextTypeLoader().parse(node, STName.type, (XmlOptions) null);
        }

        public static STName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STName) XmlBeans.getContextTypeLoader().parse(node, STName.type, xmlOptions);
        }
    }
}
