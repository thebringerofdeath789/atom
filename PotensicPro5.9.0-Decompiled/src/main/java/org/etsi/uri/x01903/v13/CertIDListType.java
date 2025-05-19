package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CertIDListType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CertIDListType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("certidlisttype488btype");

    public static final class Factory {
        private Factory() {
        }

        public static CertIDListType newInstance() {
            return (CertIDListType) XmlBeans.getContextTypeLoader().newInstance(CertIDListType.type, null);
        }

        public static CertIDListType newInstance(XmlOptions xmlOptions) {
            return (CertIDListType) XmlBeans.getContextTypeLoader().newInstance(CertIDListType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CertIDListType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(File file) throws XmlException, IOException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(file, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(file, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(InputStream inputStream) throws XmlException, IOException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(inputStream, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(inputStream, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(Reader reader) throws XmlException, IOException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(reader, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(reader, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(String str) throws XmlException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(str, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(str, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(URL url) throws XmlException, IOException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(url, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(url, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(Node node) throws XmlException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(node, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CertIDListType) XmlBeans.getContextTypeLoader().parse(node, CertIDListType.type, xmlOptions);
        }
    }

    CertIDType addNewCert();

    CertIDType getCertArray(int i);

    CertIDType[] getCertArray();

    List<CertIDType> getCertList();

    CertIDType insertNewCert(int i);

    void removeCert(int i);

    void setCertArray(int i, CertIDType certIDType);

    void setCertArray(CertIDType[] certIDTypeArr);

    int sizeOfCertArray();
}
