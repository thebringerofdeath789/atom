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
public interface STSaltSize extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSaltSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("stsaltsizee7a3type");

    public static final class Factory {
        private Factory() {
        }

        public static STSaltSize newInstance() {
            return (STSaltSize) XmlBeans.getContextTypeLoader().newInstance(STSaltSize.type, null);
        }

        public static STSaltSize newInstance(XmlOptions xmlOptions) {
            return (STSaltSize) XmlBeans.getContextTypeLoader().newInstance(STSaltSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSaltSize.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize newValue(Object obj) {
            return (STSaltSize) STSaltSize.type.newValue(obj);
        }

        public static STSaltSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(File file) throws XmlException, IOException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(file, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(file, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(InputStream inputStream) throws XmlException, IOException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(inputStream, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(inputStream, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(Reader reader) throws XmlException, IOException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(reader, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(reader, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(String str) throws XmlException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(str, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(str, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(URL url) throws XmlException, IOException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(url, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(url, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(Node node) throws XmlException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(node, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSaltSize) XmlBeans.getContextTypeLoader().parse(node, STSaltSize.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}