package com.microsoft.schemas.office.x2006.encryption;

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
public interface EncryptionDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(EncryptionDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("encryptione8b3doctype");

    public static final class Factory {
        private Factory() {
        }

        public static EncryptionDocument newInstance() {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().newInstance(EncryptionDocument.type, null);
        }

        public static EncryptionDocument newInstance(XmlOptions xmlOptions) {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().newInstance(EncryptionDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EncryptionDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(File file) throws XmlException, IOException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(file, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(file, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(inputStream, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(inputStream, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(Reader reader) throws XmlException, IOException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(reader, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(reader, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(String str) throws XmlException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(str, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(str, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(URL url) throws XmlException, IOException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(url, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(url, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(Node node) throws XmlException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(node, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (EncryptionDocument) XmlBeans.getContextTypeLoader().parse(node, EncryptionDocument.type, xmlOptions);
        }
    }

    CTEncryption addNewEncryption();

    CTEncryption getEncryption();

    void setEncryption(CTEncryption cTEncryption);
}
