package com.microsoft.schemas.office.x2006.encryption;

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

/* loaded from: classes3.dex */
public interface CTKeyEncryptors extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTKeyEncryptors.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctkeyencryptorsa09ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTKeyEncryptors newInstance() {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().newInstance(CTKeyEncryptors.type, null);
        }

        public static CTKeyEncryptors newInstance(XmlOptions xmlOptions) {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().newInstance(CTKeyEncryptors.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTKeyEncryptors.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(File file) throws XmlException, IOException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(file, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(file, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(InputStream inputStream) throws XmlException, IOException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(inputStream, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(inputStream, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(Reader reader) throws XmlException, IOException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(reader, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(reader, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(String str) throws XmlException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(str, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(str, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(URL url) throws XmlException, IOException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(url, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(url, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(Node node) throws XmlException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(node, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptors) XmlBeans.getContextTypeLoader().parse(node, CTKeyEncryptors.type, xmlOptions);
        }
    }

    CTKeyEncryptor addNewKeyEncryptor();

    CTKeyEncryptor getKeyEncryptorArray(int i);

    CTKeyEncryptor[] getKeyEncryptorArray();

    List<CTKeyEncryptor> getKeyEncryptorList();

    CTKeyEncryptor insertNewKeyEncryptor(int i);

    void removeKeyEncryptor(int i);

    void setKeyEncryptorArray(int i, CTKeyEncryptor cTKeyEncryptor);

    void setKeyEncryptorArray(CTKeyEncryptor[] cTKeyEncryptorArr);

    int sizeOfKeyEncryptorArray();
}
