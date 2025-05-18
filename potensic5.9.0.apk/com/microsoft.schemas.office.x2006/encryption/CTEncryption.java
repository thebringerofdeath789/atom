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
public interface CTEncryption extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTEncryption.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctencryption365ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEncryption newInstance() {
            return (CTEncryption) XmlBeans.getContextTypeLoader().newInstance(CTEncryption.type, null);
        }

        public static CTEncryption newInstance(XmlOptions xmlOptions) {
            return (CTEncryption) XmlBeans.getContextTypeLoader().newInstance(CTEncryption.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEncryption.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(File file) throws XmlException, IOException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(file, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(file, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(inputStream, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(inputStream, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(Reader reader) throws XmlException, IOException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(reader, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(reader, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(String str) throws XmlException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(str, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(str, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(URL url) throws XmlException, IOException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(url, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(url, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(Node node) throws XmlException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(node, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEncryption) XmlBeans.getContextTypeLoader().parse(node, CTEncryption.type, xmlOptions);
        }
    }

    CTDataIntegrity addNewDataIntegrity();

    CTKeyData addNewKeyData();

    CTKeyEncryptors addNewKeyEncryptors();

    CTDataIntegrity getDataIntegrity();

    CTKeyData getKeyData();

    CTKeyEncryptors getKeyEncryptors();

    void setDataIntegrity(CTDataIntegrity cTDataIntegrity);

    void setKeyData(CTKeyData cTKeyData);

    void setKeyEncryptors(CTKeyEncryptors cTKeyEncryptors);
}