package org.w3.x2000.x09.xmldsig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface DigestMethodType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(DigestMethodType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("digestmethodtype5ce0type");

    public static final class Factory {
        private Factory() {
        }

        public static DigestMethodType newInstance() {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().newInstance(DigestMethodType.type, null);
        }

        public static DigestMethodType newInstance(XmlOptions xmlOptions) {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().newInstance(DigestMethodType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DigestMethodType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DigestMethodType.type, xmlOptions);
        }

        public static DigestMethodType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DigestMethodType.type, (XmlOptions) null);
        }

        public static DigestMethodType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DigestMethodType.type, xmlOptions);
        }

        public static DigestMethodType parse(File file) throws XmlException, IOException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(file, DigestMethodType.type, (XmlOptions) null);
        }

        public static DigestMethodType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(file, DigestMethodType.type, xmlOptions);
        }

        public static DigestMethodType parse(InputStream inputStream) throws XmlException, IOException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(inputStream, DigestMethodType.type, (XmlOptions) null);
        }

        public static DigestMethodType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(inputStream, DigestMethodType.type, xmlOptions);
        }

        public static DigestMethodType parse(Reader reader) throws XmlException, IOException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(reader, DigestMethodType.type, (XmlOptions) null);
        }

        public static DigestMethodType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(reader, DigestMethodType.type, xmlOptions);
        }

        public static DigestMethodType parse(String str) throws XmlException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(str, DigestMethodType.type, (XmlOptions) null);
        }

        public static DigestMethodType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(str, DigestMethodType.type, xmlOptions);
        }

        public static DigestMethodType parse(URL url) throws XmlException, IOException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(url, DigestMethodType.type, (XmlOptions) null);
        }

        public static DigestMethodType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(url, DigestMethodType.type, xmlOptions);
        }

        public static DigestMethodType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DigestMethodType.type, (XmlOptions) null);
        }

        public static DigestMethodType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DigestMethodType.type, xmlOptions);
        }

        public static DigestMethodType parse(Node node) throws XmlException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(node, DigestMethodType.type, (XmlOptions) null);
        }

        public static DigestMethodType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DigestMethodType) XmlBeans.getContextTypeLoader().parse(node, DigestMethodType.type, xmlOptions);
        }
    }

    String getAlgorithm();

    void setAlgorithm(String str);

    XmlAnyURI xgetAlgorithm();

    void xsetAlgorithm(XmlAnyURI xmlAnyURI);
}
