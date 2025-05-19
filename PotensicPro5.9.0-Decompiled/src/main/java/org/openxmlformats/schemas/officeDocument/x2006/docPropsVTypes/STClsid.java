package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes;

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

/* loaded from: classes2.dex */
public interface STClsid extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STClsid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stclsida7datype");

    public static final class Factory {
        private Factory() {
        }

        public static STClsid newInstance() {
            return (STClsid) XmlBeans.getContextTypeLoader().newInstance(STClsid.type, null);
        }

        public static STClsid newInstance(XmlOptions xmlOptions) {
            return (STClsid) XmlBeans.getContextTypeLoader().newInstance(STClsid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STClsid.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STClsid.type, xmlOptions);
        }

        public static STClsid newValue(Object obj) {
            return (STClsid) STClsid.type.newValue(obj);
        }

        public static STClsid parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STClsid.type, xmlOptions);
        }

        public static STClsid parse(File file) throws XmlException, IOException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(file, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(file, STClsid.type, xmlOptions);
        }

        public static STClsid parse(InputStream inputStream) throws XmlException, IOException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(inputStream, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(inputStream, STClsid.type, xmlOptions);
        }

        public static STClsid parse(Reader reader) throws XmlException, IOException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(reader, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(reader, STClsid.type, xmlOptions);
        }

        public static STClsid parse(String str) throws XmlException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(str, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(str, STClsid.type, xmlOptions);
        }

        public static STClsid parse(URL url) throws XmlException, IOException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(url, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(url, STClsid.type, xmlOptions);
        }

        public static STClsid parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STClsid.type, xmlOptions);
        }

        public static STClsid parse(Node node) throws XmlException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(node, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STClsid) XmlBeans.getContextTypeLoader().parse(node, STClsid.type, xmlOptions);
        }
    }
}
