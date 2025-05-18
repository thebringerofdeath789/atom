package com.microsoft.schemas.office.x2006.encryption;

import aavax.xml.stream.XMLStreamReader;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
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
public interface CTKeyData extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTKeyData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctkeydata6bdbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTKeyData newInstance() {
            return (CTKeyData) XmlBeans.getContextTypeLoader().newInstance(CTKeyData.type, null);
        }

        public static CTKeyData newInstance(XmlOptions xmlOptions) {
            return (CTKeyData) XmlBeans.getContextTypeLoader().newInstance(CTKeyData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTKeyData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(File file) throws XmlException, IOException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(file, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(file, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(inputStream, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(inputStream, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(Reader reader) throws XmlException, IOException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(reader, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(reader, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(String str) throws XmlException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(str, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(str, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(URL url) throws XmlException, IOException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(url, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(url, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(Node node) throws XmlException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(node, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyData) XmlBeans.getContextTypeLoader().parse(node, CTKeyData.type, xmlOptions);
        }
    }

    int getBlockSize();

    STCipherAlgorithm.Enum getCipherAlgorithm();

    STCipherChaining.Enum getCipherChaining();

    STHashAlgorithm.Enum getHashAlgorithm();

    int getHashSize();

    long getKeyBits();

    int getSaltSize();

    byte[] getSaltValue();

    void setBlockSize(int i);

    void setCipherAlgorithm(STCipherAlgorithm.Enum r1);

    void setCipherChaining(STCipherChaining.Enum r1);

    void setHashAlgorithm(STHashAlgorithm.Enum r1);

    void setHashSize(int i);

    void setKeyBits(long j);

    void setSaltSize(int i);

    void setSaltValue(byte[] bArr);

    STBlockSize xgetBlockSize();

    STCipherAlgorithm xgetCipherAlgorithm();

    STCipherChaining xgetCipherChaining();

    STHashAlgorithm xgetHashAlgorithm();

    STHashSize xgetHashSize();

    STKeyBits xgetKeyBits();

    STSaltSize xgetSaltSize();

    XmlBase64Binary xgetSaltValue();

    void xsetBlockSize(STBlockSize sTBlockSize);

    void xsetCipherAlgorithm(STCipherAlgorithm sTCipherAlgorithm);

    void xsetCipherChaining(STCipherChaining sTCipherChaining);

    void xsetHashAlgorithm(STHashAlgorithm sTHashAlgorithm);

    void xsetHashSize(STHashSize sTHashSize);

    void xsetKeyBits(STKeyBits sTKeyBits);

    void xsetSaltSize(STSaltSize sTSaltSize);

    void xsetSaltValue(XmlBase64Binary xmlBase64Binary);
}