package org.w3.x2000.x09.xmldsig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface DigestValueType extends XmlBase64Binary {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(DigestValueType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("digestvaluetype010atype");

    public static final class Factory {
        private Factory() {
        }

        public static DigestValueType newInstance() {
            return (DigestValueType) XmlBeans.getContextTypeLoader().newInstance(DigestValueType.type, null);
        }

        public static DigestValueType newInstance(XmlOptions xmlOptions) {
            return (DigestValueType) XmlBeans.getContextTypeLoader().newInstance(DigestValueType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DigestValueType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DigestValueType.type, xmlOptions);
        }

        public static DigestValueType newValue(Object obj) {
            return (DigestValueType) DigestValueType.type.newValue(obj);
        }

        public static DigestValueType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DigestValueType.type, (XmlOptions) null);
        }

        public static DigestValueType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DigestValueType.type, xmlOptions);
        }

        public static DigestValueType parse(File file) throws XmlException, IOException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(file, DigestValueType.type, (XmlOptions) null);
        }

        public static DigestValueType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(file, DigestValueType.type, xmlOptions);
        }

        public static DigestValueType parse(InputStream inputStream) throws XmlException, IOException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(inputStream, DigestValueType.type, (XmlOptions) null);
        }

        public static DigestValueType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(inputStream, DigestValueType.type, xmlOptions);
        }

        public static DigestValueType parse(Reader reader) throws XmlException, IOException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(reader, DigestValueType.type, (XmlOptions) null);
        }

        public static DigestValueType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(reader, DigestValueType.type, xmlOptions);
        }

        public static DigestValueType parse(String str) throws XmlException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(str, DigestValueType.type, (XmlOptions) null);
        }

        public static DigestValueType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(str, DigestValueType.type, xmlOptions);
        }

        public static DigestValueType parse(URL url) throws XmlException, IOException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(url, DigestValueType.type, (XmlOptions) null);
        }

        public static DigestValueType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(url, DigestValueType.type, xmlOptions);
        }

        public static DigestValueType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DigestValueType.type, (XmlOptions) null);
        }

        public static DigestValueType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DigestValueType.type, xmlOptions);
        }

        public static DigestValueType parse(Node node) throws XmlException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(node, DigestValueType.type, (XmlOptions) null);
        }

        public static DigestValueType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DigestValueType) XmlBeans.getContextTypeLoader().parse(node, DigestValueType.type, xmlOptions);
        }
    }
}
