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
public interface STHashSize extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STHashSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("sthashsize605btype");

    public static final class Factory {
        private Factory() {
        }

        public static STHashSize newInstance() {
            return (STHashSize) XmlBeans.getContextTypeLoader().newInstance(STHashSize.type, null);
        }

        public static STHashSize newInstance(XmlOptions xmlOptions) {
            return (STHashSize) XmlBeans.getContextTypeLoader().newInstance(STHashSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHashSize.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHashSize.type, xmlOptions);
        }

        public static STHashSize newValue(Object obj) {
            return (STHashSize) STHashSize.type.newValue(obj);
        }

        public static STHashSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(File file) throws XmlException, IOException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(file, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(file, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(InputStream inputStream) throws XmlException, IOException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(inputStream, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(inputStream, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(Reader reader) throws XmlException, IOException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(reader, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(reader, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(String str) throws XmlException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(str, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(str, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(URL url) throws XmlException, IOException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(url, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(url, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(Node node) throws XmlException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(node, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STHashSize) XmlBeans.getContextTypeLoader().parse(node, STHashSize.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}