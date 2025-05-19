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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STBorderId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STBorderId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stborderid1a80type");

    public static final class Factory {
        private Factory() {
        }

        public static STBorderId newInstance() {
            return (STBorderId) XmlBeans.getContextTypeLoader().newInstance(STBorderId.type, null);
        }

        public static STBorderId newInstance(XmlOptions xmlOptions) {
            return (STBorderId) XmlBeans.getContextTypeLoader().newInstance(STBorderId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STBorderId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STBorderId.type, xmlOptions);
        }

        public static STBorderId newValue(Object obj) {
            return (STBorderId) STBorderId.type.newValue(obj);
        }

        public static STBorderId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STBorderId.type, (XmlOptions) null);
        }

        public static STBorderId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STBorderId.type, xmlOptions);
        }

        public static STBorderId parse(File file) throws XmlException, IOException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(file, STBorderId.type, (XmlOptions) null);
        }

        public static STBorderId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(file, STBorderId.type, xmlOptions);
        }

        public static STBorderId parse(InputStream inputStream) throws XmlException, IOException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(inputStream, STBorderId.type, (XmlOptions) null);
        }

        public static STBorderId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(inputStream, STBorderId.type, xmlOptions);
        }

        public static STBorderId parse(Reader reader) throws XmlException, IOException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(reader, STBorderId.type, (XmlOptions) null);
        }

        public static STBorderId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(reader, STBorderId.type, xmlOptions);
        }

        public static STBorderId parse(String str) throws XmlException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(str, STBorderId.type, (XmlOptions) null);
        }

        public static STBorderId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(str, STBorderId.type, xmlOptions);
        }

        public static STBorderId parse(URL url) throws XmlException, IOException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(url, STBorderId.type, (XmlOptions) null);
        }

        public static STBorderId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(url, STBorderId.type, xmlOptions);
        }

        public static STBorderId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STBorderId.type, (XmlOptions) null);
        }

        public static STBorderId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STBorderId.type, xmlOptions);
        }

        public static STBorderId parse(Node node) throws XmlException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(node, STBorderId.type, (XmlOptions) null);
        }

        public static STBorderId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STBorderId) XmlBeans.getContextTypeLoader().parse(node, STBorderId.type, xmlOptions);
        }
    }
}
