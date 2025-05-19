package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CompleteCertificateRefsType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CompleteCertificateRefsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("completecertificaterefstype07datype");

    public static final class Factory {
        private Factory() {
        }

        public static CompleteCertificateRefsType newInstance() {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().newInstance(CompleteCertificateRefsType.type, null);
        }

        public static CompleteCertificateRefsType newInstance(XmlOptions xmlOptions) {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().newInstance(CompleteCertificateRefsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CompleteCertificateRefsType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CompleteCertificateRefsType.type, xmlOptions);
        }

        public static CompleteCertificateRefsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CompleteCertificateRefsType.type, (XmlOptions) null);
        }

        public static CompleteCertificateRefsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CompleteCertificateRefsType.type, xmlOptions);
        }

        public static CompleteCertificateRefsType parse(File file) throws XmlException, IOException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(file, CompleteCertificateRefsType.type, (XmlOptions) null);
        }

        public static CompleteCertificateRefsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(file, CompleteCertificateRefsType.type, xmlOptions);
        }

        public static CompleteCertificateRefsType parse(InputStream inputStream) throws XmlException, IOException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(inputStream, CompleteCertificateRefsType.type, (XmlOptions) null);
        }

        public static CompleteCertificateRefsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(inputStream, CompleteCertificateRefsType.type, xmlOptions);
        }

        public static CompleteCertificateRefsType parse(Reader reader) throws XmlException, IOException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(reader, CompleteCertificateRefsType.type, (XmlOptions) null);
        }

        public static CompleteCertificateRefsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(reader, CompleteCertificateRefsType.type, xmlOptions);
        }

        public static CompleteCertificateRefsType parse(String str) throws XmlException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(str, CompleteCertificateRefsType.type, (XmlOptions) null);
        }

        public static CompleteCertificateRefsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(str, CompleteCertificateRefsType.type, xmlOptions);
        }

        public static CompleteCertificateRefsType parse(URL url) throws XmlException, IOException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(url, CompleteCertificateRefsType.type, (XmlOptions) null);
        }

        public static CompleteCertificateRefsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(url, CompleteCertificateRefsType.type, xmlOptions);
        }

        public static CompleteCertificateRefsType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CompleteCertificateRefsType.type, (XmlOptions) null);
        }

        public static CompleteCertificateRefsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CompleteCertificateRefsType.type, xmlOptions);
        }

        public static CompleteCertificateRefsType parse(Node node) throws XmlException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(node, CompleteCertificateRefsType.type, (XmlOptions) null);
        }

        public static CompleteCertificateRefsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CompleteCertificateRefsType) XmlBeans.getContextTypeLoader().parse(node, CompleteCertificateRefsType.type, xmlOptions);
        }
    }

    CertIDListType addNewCertRefs();

    CertIDListType getCertRefs();

    String getId();

    boolean isSetId();

    void setCertRefs(CertIDListType certIDListType);

    void setId(String str);

    void unsetId();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
