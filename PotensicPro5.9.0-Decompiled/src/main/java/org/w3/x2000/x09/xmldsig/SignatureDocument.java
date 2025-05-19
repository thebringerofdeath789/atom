package org.w3.x2000.x09.xmldsig;

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

/* loaded from: classes6.dex */
public interface SignatureDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SignatureDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("signature5269doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SignatureDocument newInstance() {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().newInstance(SignatureDocument.type, null);
        }

        public static SignatureDocument newInstance(XmlOptions xmlOptions) {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().newInstance(SignatureDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignatureDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignatureDocument.type, xmlOptions);
        }

        public static SignatureDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignatureDocument.type, (XmlOptions) null);
        }

        public static SignatureDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignatureDocument.type, xmlOptions);
        }

        public static SignatureDocument parse(File file) throws XmlException, IOException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(file, SignatureDocument.type, (XmlOptions) null);
        }

        public static SignatureDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(file, SignatureDocument.type, xmlOptions);
        }

        public static SignatureDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SignatureDocument.type, (XmlOptions) null);
        }

        public static SignatureDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SignatureDocument.type, xmlOptions);
        }

        public static SignatureDocument parse(Reader reader) throws XmlException, IOException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(reader, SignatureDocument.type, (XmlOptions) null);
        }

        public static SignatureDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(reader, SignatureDocument.type, xmlOptions);
        }

        public static SignatureDocument parse(String str) throws XmlException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(str, SignatureDocument.type, (XmlOptions) null);
        }

        public static SignatureDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(str, SignatureDocument.type, xmlOptions);
        }

        public static SignatureDocument parse(URL url) throws XmlException, IOException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(url, SignatureDocument.type, (XmlOptions) null);
        }

        public static SignatureDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(url, SignatureDocument.type, xmlOptions);
        }

        public static SignatureDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignatureDocument.type, (XmlOptions) null);
        }

        public static SignatureDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignatureDocument.type, xmlOptions);
        }

        public static SignatureDocument parse(Node node) throws XmlException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(node, SignatureDocument.type, (XmlOptions) null);
        }

        public static SignatureDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignatureDocument) XmlBeans.getContextTypeLoader().parse(node, SignatureDocument.type, xmlOptions);
        }
    }

    SignatureType addNewSignature();

    SignatureType getSignature();

    void setSignature(SignatureType signatureType);
}
