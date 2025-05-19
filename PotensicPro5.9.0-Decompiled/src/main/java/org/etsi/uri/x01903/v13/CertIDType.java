package org.etsi.uri.x01903.v13;

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
import org.w3.x2000.x09.xmldsig.X509IssuerSerialType;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CertIDType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CertIDType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("certidtypee64dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CertIDType newInstance() {
            return (CertIDType) XmlBeans.getContextTypeLoader().newInstance(CertIDType.type, null);
        }

        public static CertIDType newInstance(XmlOptions xmlOptions) {
            return (CertIDType) XmlBeans.getContextTypeLoader().newInstance(CertIDType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CertIDType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(File file) throws XmlException, IOException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(file, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(file, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(InputStream inputStream) throws XmlException, IOException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(inputStream, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(inputStream, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(Reader reader) throws XmlException, IOException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(reader, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(reader, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(String str) throws XmlException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(str, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(str, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(URL url) throws XmlException, IOException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(url, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(url, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(Node node) throws XmlException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(node, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CertIDType) XmlBeans.getContextTypeLoader().parse(node, CertIDType.type, xmlOptions);
        }
    }

    DigestAlgAndValueType addNewCertDigest();

    X509IssuerSerialType addNewIssuerSerial();

    DigestAlgAndValueType getCertDigest();

    X509IssuerSerialType getIssuerSerial();

    String getURI();

    boolean isSetURI();

    void setCertDigest(DigestAlgAndValueType digestAlgAndValueType);

    void setIssuerSerial(X509IssuerSerialType x509IssuerSerialType);

    void setURI(String str);

    void unsetURI();

    XmlAnyURI xgetURI();

    void xsetURI(XmlAnyURI xmlAnyURI);
}
