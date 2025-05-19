package com.microsoft.schemas.office.x2006.encryption;

import aavax.xml.stream.XMLStreamReader;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes3.dex */
public interface CTKeyEncryptor extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTKeyEncryptor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctkeyencryptor1205type");

    public static final class Factory {
        private Factory() {
        }

        public static CTKeyEncryptor newInstance() {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().newInstance(CTKeyEncryptor.type, null);
        }

        public static CTKeyEncryptor newInstance(XmlOptions xmlOptions) {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().newInstance(CTKeyEncryptor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTKeyEncryptor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(File file) throws XmlException, IOException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(file, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(file, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(inputStream, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(inputStream, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(Reader reader) throws XmlException, IOException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(reader, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(reader, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(String str) throws XmlException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(str, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(str, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(URL url) throws XmlException, IOException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(url, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(url, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(Node node) throws XmlException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(node, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptor) XmlBeans.getContextTypeLoader().parse(node, CTKeyEncryptor.type, xmlOptions);
        }
    }

    public interface Uri extends XmlToken {
        public static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = 2;
        public static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = 1;
        public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(Uri.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("uribad9attrtype");
        public static final Enum HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = Enum.forString("http://schemas.microsoft.com/office/2006/keyEncryptor/password");
        public static final Enum HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = Enum.forString("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate");

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = 2;
            static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("http://schemas.microsoft.com/office/2006/keyEncryptor/password", 1), new Enum("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate", 2)});

            private Enum(String str, int i) {
                super(str, i);
            }

            public static Enum forInt(int i) {
                return (Enum) table.forInt(i);
            }

            public static Enum forString(String str) {
                return (Enum) table.forString(str);
            }

            private Object readResolve() {
                return forInt(intValue());
            }
        }

        public static final class Factory {
            private Factory() {
            }

            public static Uri newInstance() {
                return (Uri) XmlBeans.getContextTypeLoader().newInstance(Uri.type, null);
            }

            public static Uri newInstance(XmlOptions xmlOptions) {
                return (Uri) XmlBeans.getContextTypeLoader().newInstance(Uri.type, xmlOptions);
            }

            public static Uri newValue(Object obj) {
                return (Uri) Uri.type.newValue(obj);
            }
        }

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);
    }

    CTCertificateKeyEncryptor addNewEncryptedCertificateKey();

    CTPasswordKeyEncryptor addNewEncryptedPasswordKey();

    CTCertificateKeyEncryptor getEncryptedCertificateKey();

    CTPasswordKeyEncryptor getEncryptedPasswordKey();

    Uri.Enum getUri();

    boolean isSetEncryptedCertificateKey();

    boolean isSetEncryptedPasswordKey();

    boolean isSetUri();

    void setEncryptedCertificateKey(CTCertificateKeyEncryptor cTCertificateKeyEncryptor);

    void setEncryptedPasswordKey(CTPasswordKeyEncryptor cTPasswordKeyEncryptor);

    void setUri(Uri.Enum r1);

    void unsetEncryptedCertificateKey();

    void unsetEncryptedPasswordKey();

    void unsetUri();

    Uri xgetUri();

    void xsetUri(Uri uri);
}
