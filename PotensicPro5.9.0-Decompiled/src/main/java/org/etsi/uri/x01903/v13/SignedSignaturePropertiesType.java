package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface SignedSignaturePropertiesType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SignedSignaturePropertiesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("signedsignaturepropertiestype06abtype");

    public static final class Factory {
        private Factory() {
        }

        public static SignedSignaturePropertiesType newInstance() {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().newInstance(SignedSignaturePropertiesType.type, null);
        }

        public static SignedSignaturePropertiesType newInstance(XmlOptions xmlOptions) {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().newInstance(SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignedSignaturePropertiesType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(File file) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(file, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(file, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(InputStream inputStream) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(inputStream, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(inputStream, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(Reader reader) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(reader, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(reader, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(String str) throws XmlException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(str, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(str, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(URL url) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(url, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(url, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(Node node) throws XmlException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(node, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignedSignaturePropertiesType) XmlBeans.getContextTypeLoader().parse(node, SignedSignaturePropertiesType.type, xmlOptions);
        }
    }

    SignaturePolicyIdentifierType addNewSignaturePolicyIdentifier();

    SignatureProductionPlaceType addNewSignatureProductionPlace();

    SignerRoleType addNewSignerRole();

    CertIDListType addNewSigningCertificate();

    String getId();

    SignaturePolicyIdentifierType getSignaturePolicyIdentifier();

    SignatureProductionPlaceType getSignatureProductionPlace();

    SignerRoleType getSignerRole();

    CertIDListType getSigningCertificate();

    Calendar getSigningTime();

    boolean isSetId();

    boolean isSetSignaturePolicyIdentifier();

    boolean isSetSignatureProductionPlace();

    boolean isSetSignerRole();

    boolean isSetSigningCertificate();

    boolean isSetSigningTime();

    void setId(String str);

    void setSignaturePolicyIdentifier(SignaturePolicyIdentifierType signaturePolicyIdentifierType);

    void setSignatureProductionPlace(SignatureProductionPlaceType signatureProductionPlaceType);

    void setSignerRole(SignerRoleType signerRoleType);

    void setSigningCertificate(CertIDListType certIDListType);

    void setSigningTime(Calendar calendar);

    void unsetId();

    void unsetSignaturePolicyIdentifier();

    void unsetSignatureProductionPlace();

    void unsetSignerRole();

    void unsetSigningCertificate();

    void unsetSigningTime();

    XmlID xgetId();

    XmlDateTime xgetSigningTime();

    void xsetId(XmlID xmlID);

    void xsetSigningTime(XmlDateTime xmlDateTime);
}
