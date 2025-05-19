package org.etsi.uri.x01903.v13;

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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CertificateValuesType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CertificateValuesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("certificatevaluestype5c75type");

    public static final class Factory {
        private Factory() {
        }

        public static CertificateValuesType newInstance() {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().newInstance(CertificateValuesType.type, null);
        }

        public static CertificateValuesType newInstance(XmlOptions xmlOptions) {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().newInstance(CertificateValuesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CertificateValuesType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CertificateValuesType.type, xmlOptions);
        }

        public static CertificateValuesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CertificateValuesType.type, (XmlOptions) null);
        }

        public static CertificateValuesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CertificateValuesType.type, xmlOptions);
        }

        public static CertificateValuesType parse(File file) throws XmlException, IOException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(file, CertificateValuesType.type, (XmlOptions) null);
        }

        public static CertificateValuesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(file, CertificateValuesType.type, xmlOptions);
        }

        public static CertificateValuesType parse(InputStream inputStream) throws XmlException, IOException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(inputStream, CertificateValuesType.type, (XmlOptions) null);
        }

        public static CertificateValuesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(inputStream, CertificateValuesType.type, xmlOptions);
        }

        public static CertificateValuesType parse(Reader reader) throws XmlException, IOException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(reader, CertificateValuesType.type, (XmlOptions) null);
        }

        public static CertificateValuesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(reader, CertificateValuesType.type, xmlOptions);
        }

        public static CertificateValuesType parse(String str) throws XmlException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(str, CertificateValuesType.type, (XmlOptions) null);
        }

        public static CertificateValuesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(str, CertificateValuesType.type, xmlOptions);
        }

        public static CertificateValuesType parse(URL url) throws XmlException, IOException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(url, CertificateValuesType.type, (XmlOptions) null);
        }

        public static CertificateValuesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(url, CertificateValuesType.type, xmlOptions);
        }

        public static CertificateValuesType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CertificateValuesType.type, (XmlOptions) null);
        }

        public static CertificateValuesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CertificateValuesType.type, xmlOptions);
        }

        public static CertificateValuesType parse(Node node) throws XmlException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(node, CertificateValuesType.type, (XmlOptions) null);
        }

        public static CertificateValuesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CertificateValuesType) XmlBeans.getContextTypeLoader().parse(node, CertificateValuesType.type, xmlOptions);
        }
    }

    EncapsulatedPKIDataType addNewEncapsulatedX509Certificate();

    AnyType addNewOtherCertificate();

    EncapsulatedPKIDataType getEncapsulatedX509CertificateArray(int i);

    EncapsulatedPKIDataType[] getEncapsulatedX509CertificateArray();

    List<EncapsulatedPKIDataType> getEncapsulatedX509CertificateList();

    String getId();

    AnyType getOtherCertificateArray(int i);

    AnyType[] getOtherCertificateArray();

    List<AnyType> getOtherCertificateList();

    EncapsulatedPKIDataType insertNewEncapsulatedX509Certificate(int i);

    AnyType insertNewOtherCertificate(int i);

    boolean isSetId();

    void removeEncapsulatedX509Certificate(int i);

    void removeOtherCertificate(int i);

    void setEncapsulatedX509CertificateArray(int i, EncapsulatedPKIDataType encapsulatedPKIDataType);

    void setEncapsulatedX509CertificateArray(EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr);

    void setId(String str);

    void setOtherCertificateArray(int i, AnyType anyType);

    void setOtherCertificateArray(AnyType[] anyTypeArr);

    int sizeOfEncapsulatedX509CertificateArray();

    int sizeOfOtherCertificateArray();

    void unsetId();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
