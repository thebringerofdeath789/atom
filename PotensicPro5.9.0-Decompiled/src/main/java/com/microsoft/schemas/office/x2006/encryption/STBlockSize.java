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
public interface STBlockSize extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STBlockSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("stblocksize2e10type");

    public static final class Factory {
        private Factory() {
        }

        public static STBlockSize newInstance() {
            return (STBlockSize) XmlBeans.getContextTypeLoader().newInstance(STBlockSize.type, null);
        }

        public static STBlockSize newInstance(XmlOptions xmlOptions) {
            return (STBlockSize) XmlBeans.getContextTypeLoader().newInstance(STBlockSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STBlockSize.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize newValue(Object obj) {
            return (STBlockSize) STBlockSize.type.newValue(obj);
        }

        public static STBlockSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(File file) throws XmlException, IOException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(file, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(file, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(InputStream inputStream) throws XmlException, IOException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(inputStream, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(inputStream, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(Reader reader) throws XmlException, IOException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(reader, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(reader, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(String str) throws XmlException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(str, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(str, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(URL url) throws XmlException, IOException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(url, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(url, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(Node node) throws XmlException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(node, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STBlockSize) XmlBeans.getContextTypeLoader().parse(node, STBlockSize.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}
