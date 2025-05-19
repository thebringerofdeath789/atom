package org.w3.x2000.x09.xmldsig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface X509IssuerSerialType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(X509IssuerSerialType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("x509issuerserialtype7eb2type");

    public static final class Factory {
        private Factory() {
        }

        public static X509IssuerSerialType newInstance() {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().newInstance(X509IssuerSerialType.type, null);
        }

        public static X509IssuerSerialType newInstance(XmlOptions xmlOptions) {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().newInstance(X509IssuerSerialType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, X509IssuerSerialType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(File file) throws XmlException, IOException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(file, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(file, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(InputStream inputStream) throws XmlException, IOException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(inputStream, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(inputStream, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(Reader reader) throws XmlException, IOException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(reader, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(reader, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(String str) throws XmlException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(str, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(str, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(URL url) throws XmlException, IOException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(url, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(url, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(Node node) throws XmlException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(node, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (X509IssuerSerialType) XmlBeans.getContextTypeLoader().parse(node, X509IssuerSerialType.type, xmlOptions);
        }
    }

    String getX509IssuerName();

    BigInteger getX509SerialNumber();

    void setX509IssuerName(String str);

    void setX509SerialNumber(BigInteger bigInteger);

    XmlString xgetX509IssuerName();

    XmlInteger xgetX509SerialNumber();

    void xsetX509IssuerName(XmlString xmlString);

    void xsetX509SerialNumber(XmlInteger xmlInteger);
}
