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
public interface SignaturePolicyIdentifierType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SignaturePolicyIdentifierType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("signaturepolicyidentifiertype80aftype");

    public static final class Factory {
        private Factory() {
        }

        public static SignaturePolicyIdentifierType newInstance() {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().newInstance(SignaturePolicyIdentifierType.type, null);
        }

        public static SignaturePolicyIdentifierType newInstance(XmlOptions xmlOptions) {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().newInstance(SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignaturePolicyIdentifierType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static SignaturePolicyIdentifierType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignaturePolicyIdentifierType.type, (XmlOptions) null);
        }

        public static SignaturePolicyIdentifierType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static SignaturePolicyIdentifierType parse(File file) throws XmlException, IOException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(file, SignaturePolicyIdentifierType.type, (XmlOptions) null);
        }

        public static SignaturePolicyIdentifierType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(file, SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static SignaturePolicyIdentifierType parse(InputStream inputStream) throws XmlException, IOException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(inputStream, SignaturePolicyIdentifierType.type, (XmlOptions) null);
        }

        public static SignaturePolicyIdentifierType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(inputStream, SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static SignaturePolicyIdentifierType parse(Reader reader) throws XmlException, IOException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(reader, SignaturePolicyIdentifierType.type, (XmlOptions) null);
        }

        public static SignaturePolicyIdentifierType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(reader, SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static SignaturePolicyIdentifierType parse(String str) throws XmlException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(str, SignaturePolicyIdentifierType.type, (XmlOptions) null);
        }

        public static SignaturePolicyIdentifierType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(str, SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static SignaturePolicyIdentifierType parse(URL url) throws XmlException, IOException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(url, SignaturePolicyIdentifierType.type, (XmlOptions) null);
        }

        public static SignaturePolicyIdentifierType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(url, SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static SignaturePolicyIdentifierType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignaturePolicyIdentifierType.type, (XmlOptions) null);
        }

        public static SignaturePolicyIdentifierType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignaturePolicyIdentifierType.type, xmlOptions);
        }

        public static SignaturePolicyIdentifierType parse(Node node) throws XmlException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(node, SignaturePolicyIdentifierType.type, (XmlOptions) null);
        }

        public static SignaturePolicyIdentifierType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignaturePolicyIdentifierType) XmlBeans.getContextTypeLoader().parse(node, SignaturePolicyIdentifierType.type, xmlOptions);
        }
    }

    SignaturePolicyIdType addNewSignaturePolicyId();

    XmlObject addNewSignaturePolicyImplied();

    SignaturePolicyIdType getSignaturePolicyId();

    XmlObject getSignaturePolicyImplied();

    boolean isSetSignaturePolicyId();

    boolean isSetSignaturePolicyImplied();

    void setSignaturePolicyId(SignaturePolicyIdType signaturePolicyIdType);

    void setSignaturePolicyImplied(XmlObject xmlObject);

    void unsetSignaturePolicyId();

    void unsetSignaturePolicyImplied();
}
