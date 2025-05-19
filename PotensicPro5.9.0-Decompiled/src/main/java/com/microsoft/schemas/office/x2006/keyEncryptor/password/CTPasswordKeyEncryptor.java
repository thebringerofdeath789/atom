package com.microsoft.schemas.office.x2006.keyEncryptor.password;

import aavax.xml.stream.XMLStreamReader;
import com.microsoft.schemas.office.x2006.encryption.STBlockSize;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STHashSize;
import com.microsoft.schemas.office.x2006.encryption.STKeyBits;
import com.microsoft.schemas.office.x2006.encryption.STSaltSize;
import com.microsoft.schemas.office.x2006.encryption.STSpinCount;
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
public interface CTPasswordKeyEncryptor extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPasswordKeyEncryptor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctpasswordkeyencryptorde24type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPasswordKeyEncryptor newInstance() {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().newInstance(CTPasswordKeyEncryptor.type, null);
        }

        public static CTPasswordKeyEncryptor newInstance(XmlOptions xmlOptions) {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().newInstance(CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPasswordKeyEncryptor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(File file) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(file, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(file, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(inputStream, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(inputStream, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(Reader reader) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(reader, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(reader, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(String str) throws XmlException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(str, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(str, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(URL url) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(url, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(url, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(Node node) throws XmlException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(node, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPasswordKeyEncryptor) XmlBeans.getContextTypeLoader().parse(node, CTPasswordKeyEncryptor.type, xmlOptions);
        }
    }

    int getBlockSize();

    STCipherAlgorithm.Enum getCipherAlgorithm();

    STCipherChaining.Enum getCipherChaining();

    byte[] getEncryptedKeyValue();

    byte[] getEncryptedVerifierHashInput();

    byte[] getEncryptedVerifierHashValue();

    STHashAlgorithm.Enum getHashAlgorithm();

    int getHashSize();

    long getKeyBits();

    int getSaltSize();

    byte[] getSaltValue();

    int getSpinCount();

    void setBlockSize(int i);

    void setCipherAlgorithm(STCipherAlgorithm.Enum r1);

    void setCipherChaining(STCipherChaining.Enum r1);

    void setEncryptedKeyValue(byte[] bArr);

    void setEncryptedVerifierHashInput(byte[] bArr);

    void setEncryptedVerifierHashValue(byte[] bArr);

    void setHashAlgorithm(STHashAlgorithm.Enum r1);

    void setHashSize(int i);

    void setKeyBits(long j);

    void setSaltSize(int i);

    void setSaltValue(byte[] bArr);

    void setSpinCount(int i);

    STBlockSize xgetBlockSize();

    STCipherAlgorithm xgetCipherAlgorithm();

    STCipherChaining xgetCipherChaining();

    XmlBase64Binary xgetEncryptedKeyValue();

    XmlBase64Binary xgetEncryptedVerifierHashInput();

    XmlBase64Binary xgetEncryptedVerifierHashValue();

    STHashAlgorithm xgetHashAlgorithm();

    STHashSize xgetHashSize();

    STKeyBits xgetKeyBits();

    STSaltSize xgetSaltSize();

    XmlBase64Binary xgetSaltValue();

    STSpinCount xgetSpinCount();

    void xsetBlockSize(STBlockSize sTBlockSize);

    void xsetCipherAlgorithm(STCipherAlgorithm sTCipherAlgorithm);

    void xsetCipherChaining(STCipherChaining sTCipherChaining);

    void xsetEncryptedKeyValue(XmlBase64Binary xmlBase64Binary);

    void xsetEncryptedVerifierHashInput(XmlBase64Binary xmlBase64Binary);

    void xsetEncryptedVerifierHashValue(XmlBase64Binary xmlBase64Binary);

    void xsetHashAlgorithm(STHashAlgorithm sTHashAlgorithm);

    void xsetHashSize(STHashSize sTHashSize);

    void xsetKeyBits(STKeyBits sTKeyBits);

    void xsetSaltSize(STSaltSize sTSaltSize);

    void xsetSaltValue(XmlBase64Binary xmlBase64Binary);

    void xsetSpinCount(STSpinCount sTSpinCount);
}
