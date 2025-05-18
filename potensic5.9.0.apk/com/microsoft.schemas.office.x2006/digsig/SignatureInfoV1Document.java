package com.microsoft.schemas.office.x2006.digsig;

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

/* loaded from: classes3.dex */
public interface SignatureInfoV1Document extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SignatureInfoV1Document.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("signatureinfov14a6bdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SignatureInfoV1Document newInstance() {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().newInstance(SignatureInfoV1Document.type, null);
        }

        public static SignatureInfoV1Document newInstance(XmlOptions xmlOptions) {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().newInstance(SignatureInfoV1Document.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignatureInfoV1Document.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(File file) throws XmlException, IOException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(file, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(file, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(InputStream inputStream) throws XmlException, IOException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(inputStream, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(inputStream, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(Reader reader) throws XmlException, IOException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(reader, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(reader, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(String str) throws XmlException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(str, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(str, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(URL url) throws XmlException, IOException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(url, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(url, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(Node node) throws XmlException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(node, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignatureInfoV1Document) XmlBeans.getContextTypeLoader().parse(node, SignatureInfoV1Document.type, xmlOptions);
        }
    }

    CTSignatureInfoV1 addNewSignatureInfoV1();

    CTSignatureInfoV1 getSignatureInfoV1();

    void setSignatureInfoV1(CTSignatureInfoV1 cTSignatureInfoV1);
}