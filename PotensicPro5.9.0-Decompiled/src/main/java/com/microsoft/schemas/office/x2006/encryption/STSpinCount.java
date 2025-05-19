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
public interface STSpinCount extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSpinCount.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("stspincount544ftype");

    public static final class Factory {
        private Factory() {
        }

        public static STSpinCount newInstance() {
            return (STSpinCount) XmlBeans.getContextTypeLoader().newInstance(STSpinCount.type, null);
        }

        public static STSpinCount newInstance(XmlOptions xmlOptions) {
            return (STSpinCount) XmlBeans.getContextTypeLoader().newInstance(STSpinCount.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSpinCount.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount newValue(Object obj) {
            return (STSpinCount) STSpinCount.type.newValue(obj);
        }

        public static STSpinCount parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(File file) throws XmlException, IOException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(file, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(file, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(InputStream inputStream) throws XmlException, IOException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(inputStream, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(inputStream, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(Reader reader) throws XmlException, IOException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(reader, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(reader, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(String str) throws XmlException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(str, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(str, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(URL url) throws XmlException, IOException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(url, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(url, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(Node node) throws XmlException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(node, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSpinCount) XmlBeans.getContextTypeLoader().parse(node, STSpinCount.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}
