package com.microsoft.schemas.office.x2006.encryption;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes3.dex */
public interface CTDataIntegrity extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDataIntegrity.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctdataintegrity6eb5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDataIntegrity newInstance() {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().newInstance(CTDataIntegrity.type, null);
        }

        public static CTDataIntegrity newInstance(XmlOptions xmlOptions) {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().newInstance(CTDataIntegrity.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDataIntegrity.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(File file) throws XmlException, IOException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(file, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(file, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(inputStream, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(inputStream, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(Reader reader) throws XmlException, IOException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(reader, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(reader, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(String str) throws XmlException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(str, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(str, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(URL url) throws XmlException, IOException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(url, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(url, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(Node node) throws XmlException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(node, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDataIntegrity) XmlBeans.getContextTypeLoader().parse(node, CTDataIntegrity.type, xmlOptions);
        }
    }

    byte[] getEncryptedHmacKey();

    byte[] getEncryptedHmacValue();

    void setEncryptedHmacKey(byte[] bArr);

    void setEncryptedHmacValue(byte[] bArr);

    XmlBase64Binary xgetEncryptedHmacKey();

    XmlBase64Binary xgetEncryptedHmacValue();

    void xsetEncryptedHmacKey(XmlBase64Binary xmlBase64Binary);

    void xsetEncryptedHmacValue(XmlBase64Binary xmlBase64Binary);
}
