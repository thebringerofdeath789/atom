package com.microsoft.schemas.office.x2006.encryption;

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

/* loaded from: classes3.dex */
public interface STKeyBits extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STKeyBits.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("stkeybitse527type");

    public static final class Factory {
        private Factory() {
        }

        public static STKeyBits newInstance() {
            return (STKeyBits) XmlBeans.getContextTypeLoader().newInstance(STKeyBits.type, null);
        }

        public static STKeyBits newInstance(XmlOptions xmlOptions) {
            return (STKeyBits) XmlBeans.getContextTypeLoader().newInstance(STKeyBits.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STKeyBits.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits newValue(Object obj) {
            return (STKeyBits) STKeyBits.type.newValue(obj);
        }

        public static STKeyBits parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(File file) throws XmlException, IOException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(file, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(file, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(InputStream inputStream) throws XmlException, IOException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(inputStream, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(inputStream, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(Reader reader) throws XmlException, IOException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(reader, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(reader, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(String str) throws XmlException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(str, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(str, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(URL url) throws XmlException, IOException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(url, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(url, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(Node node) throws XmlException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(node, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STKeyBits) XmlBeans.getContextTypeLoader().parse(node, STKeyBits.type, xmlOptions);
        }
    }
}
