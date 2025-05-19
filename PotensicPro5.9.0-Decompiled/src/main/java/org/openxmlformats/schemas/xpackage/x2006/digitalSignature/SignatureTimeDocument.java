package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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
public interface SignatureTimeDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SignatureTimeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("signaturetime9c91doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SignatureTimeDocument newInstance() {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().newInstance(SignatureTimeDocument.type, null);
        }

        public static SignatureTimeDocument newInstance(XmlOptions xmlOptions) {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().newInstance(SignatureTimeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignatureTimeDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignatureTimeDocument.type, xmlOptions);
        }

        public static SignatureTimeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignatureTimeDocument.type, (XmlOptions) null);
        }

        public static SignatureTimeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignatureTimeDocument.type, xmlOptions);
        }

        public static SignatureTimeDocument parse(File file) throws XmlException, IOException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(file, SignatureTimeDocument.type, (XmlOptions) null);
        }

        public static SignatureTimeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(file, SignatureTimeDocument.type, xmlOptions);
        }

        public static SignatureTimeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SignatureTimeDocument.type, (XmlOptions) null);
        }

        public static SignatureTimeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SignatureTimeDocument.type, xmlOptions);
        }

        public static SignatureTimeDocument parse(Reader reader) throws XmlException, IOException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(reader, SignatureTimeDocument.type, (XmlOptions) null);
        }

        public static SignatureTimeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(reader, SignatureTimeDocument.type, xmlOptions);
        }

        public static SignatureTimeDocument parse(String str) throws XmlException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(str, SignatureTimeDocument.type, (XmlOptions) null);
        }

        public static SignatureTimeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(str, SignatureTimeDocument.type, xmlOptions);
        }

        public static SignatureTimeDocument parse(URL url) throws XmlException, IOException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(url, SignatureTimeDocument.type, (XmlOptions) null);
        }

        public static SignatureTimeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(url, SignatureTimeDocument.type, xmlOptions);
        }

        public static SignatureTimeDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignatureTimeDocument.type, (XmlOptions) null);
        }

        public static SignatureTimeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignatureTimeDocument.type, xmlOptions);
        }

        public static SignatureTimeDocument parse(Node node) throws XmlException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(node, SignatureTimeDocument.type, (XmlOptions) null);
        }

        public static SignatureTimeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignatureTimeDocument) XmlBeans.getContextTypeLoader().parse(node, SignatureTimeDocument.type, xmlOptions);
        }
    }

    CTSignatureTime addNewSignatureTime();

    CTSignatureTime getSignatureTime();

    void setSignatureTime(CTSignatureTime cTSignatureTime);
}
