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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CRLRefType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CRLRefType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("crlreftype4444type");

    public static final class Factory {
        private Factory() {
        }

        public static CRLRefType newInstance() {
            return (CRLRefType) XmlBeans.getContextTypeLoader().newInstance(CRLRefType.type, null);
        }

        public static CRLRefType newInstance(XmlOptions xmlOptions) {
            return (CRLRefType) XmlBeans.getContextTypeLoader().newInstance(CRLRefType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CRLRefType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CRLRefType.type, xmlOptions);
        }

        public static CRLRefType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CRLRefType.type, (XmlOptions) null);
        }

        public static CRLRefType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CRLRefType.type, xmlOptions);
        }

        public static CRLRefType parse(File file) throws XmlException, IOException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(file, CRLRefType.type, (XmlOptions) null);
        }

        public static CRLRefType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(file, CRLRefType.type, xmlOptions);
        }

        public static CRLRefType parse(InputStream inputStream) throws XmlException, IOException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(inputStream, CRLRefType.type, (XmlOptions) null);
        }

        public static CRLRefType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(inputStream, CRLRefType.type, xmlOptions);
        }

        public static CRLRefType parse(Reader reader) throws XmlException, IOException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(reader, CRLRefType.type, (XmlOptions) null);
        }

        public static CRLRefType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(reader, CRLRefType.type, xmlOptions);
        }

        public static CRLRefType parse(String str) throws XmlException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(str, CRLRefType.type, (XmlOptions) null);
        }

        public static CRLRefType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(str, CRLRefType.type, xmlOptions);
        }

        public static CRLRefType parse(URL url) throws XmlException, IOException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(url, CRLRefType.type, (XmlOptions) null);
        }

        public static CRLRefType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(url, CRLRefType.type, xmlOptions);
        }

        public static CRLRefType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CRLRefType.type, (XmlOptions) null);
        }

        public static CRLRefType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CRLRefType.type, xmlOptions);
        }

        public static CRLRefType parse(Node node) throws XmlException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(node, CRLRefType.type, (XmlOptions) null);
        }

        public static CRLRefType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CRLRefType) XmlBeans.getContextTypeLoader().parse(node, CRLRefType.type, xmlOptions);
        }
    }

    CRLIdentifierType addNewCRLIdentifier();

    DigestAlgAndValueType addNewDigestAlgAndValue();

    CRLIdentifierType getCRLIdentifier();

    DigestAlgAndValueType getDigestAlgAndValue();

    boolean isSetCRLIdentifier();

    void setCRLIdentifier(CRLIdentifierType cRLIdentifierType);

    void setDigestAlgAndValue(DigestAlgAndValueType digestAlgAndValueType);

    void unsetCRLIdentifier();
}
