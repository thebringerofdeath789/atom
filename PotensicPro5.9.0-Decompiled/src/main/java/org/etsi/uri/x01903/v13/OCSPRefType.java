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
public interface OCSPRefType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(OCSPRefType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ocspreftype089etype");

    public static final class Factory {
        private Factory() {
        }

        public static OCSPRefType newInstance() {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().newInstance(OCSPRefType.type, null);
        }

        public static OCSPRefType newInstance(XmlOptions xmlOptions) {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().newInstance(OCSPRefType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OCSPRefType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OCSPRefType.type, xmlOptions);
        }

        public static OCSPRefType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OCSPRefType.type, (XmlOptions) null);
        }

        public static OCSPRefType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OCSPRefType.type, xmlOptions);
        }

        public static OCSPRefType parse(File file) throws XmlException, IOException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(file, OCSPRefType.type, (XmlOptions) null);
        }

        public static OCSPRefType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(file, OCSPRefType.type, xmlOptions);
        }

        public static OCSPRefType parse(InputStream inputStream) throws XmlException, IOException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(inputStream, OCSPRefType.type, (XmlOptions) null);
        }

        public static OCSPRefType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(inputStream, OCSPRefType.type, xmlOptions);
        }

        public static OCSPRefType parse(Reader reader) throws XmlException, IOException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(reader, OCSPRefType.type, (XmlOptions) null);
        }

        public static OCSPRefType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(reader, OCSPRefType.type, xmlOptions);
        }

        public static OCSPRefType parse(String str) throws XmlException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(str, OCSPRefType.type, (XmlOptions) null);
        }

        public static OCSPRefType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(str, OCSPRefType.type, xmlOptions);
        }

        public static OCSPRefType parse(URL url) throws XmlException, IOException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(url, OCSPRefType.type, (XmlOptions) null);
        }

        public static OCSPRefType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(url, OCSPRefType.type, xmlOptions);
        }

        public static OCSPRefType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OCSPRefType.type, (XmlOptions) null);
        }

        public static OCSPRefType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OCSPRefType.type, xmlOptions);
        }

        public static OCSPRefType parse(Node node) throws XmlException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(node, OCSPRefType.type, (XmlOptions) null);
        }

        public static OCSPRefType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (OCSPRefType) XmlBeans.getContextTypeLoader().parse(node, OCSPRefType.type, xmlOptions);
        }
    }

    DigestAlgAndValueType addNewDigestAlgAndValue();

    OCSPIdentifierType addNewOCSPIdentifier();

    DigestAlgAndValueType getDigestAlgAndValue();

    OCSPIdentifierType getOCSPIdentifier();

    boolean isSetDigestAlgAndValue();

    void setDigestAlgAndValue(DigestAlgAndValueType digestAlgAndValueType);

    void setOCSPIdentifier(OCSPIdentifierType oCSPIdentifierType);

    void unsetDigestAlgAndValue();
}
