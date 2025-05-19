package org.w3.x2000.x09.xmldsig;

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

/* loaded from: classes6.dex */
public interface SignedInfoType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SignedInfoType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("signedinfotype54dbtype");

    public static final class Factory {
        private Factory() {
        }

        public static SignedInfoType newInstance() {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().newInstance(SignedInfoType.type, null);
        }

        public static SignedInfoType newInstance(XmlOptions xmlOptions) {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().newInstance(SignedInfoType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignedInfoType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignedInfoType.type, xmlOptions);
        }

        public static SignedInfoType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignedInfoType.type, (XmlOptions) null);
        }

        public static SignedInfoType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignedInfoType.type, xmlOptions);
        }

        public static SignedInfoType parse(File file) throws XmlException, IOException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(file, SignedInfoType.type, (XmlOptions) null);
        }

        public static SignedInfoType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(file, SignedInfoType.type, xmlOptions);
        }

        public static SignedInfoType parse(InputStream inputStream) throws XmlException, IOException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(inputStream, SignedInfoType.type, (XmlOptions) null);
        }

        public static SignedInfoType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(inputStream, SignedInfoType.type, xmlOptions);
        }

        public static SignedInfoType parse(Reader reader) throws XmlException, IOException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(reader, SignedInfoType.type, (XmlOptions) null);
        }

        public static SignedInfoType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(reader, SignedInfoType.type, xmlOptions);
        }

        public static SignedInfoType parse(String str) throws XmlException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(str, SignedInfoType.type, (XmlOptions) null);
        }

        public static SignedInfoType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(str, SignedInfoType.type, xmlOptions);
        }

        public static SignedInfoType parse(URL url) throws XmlException, IOException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(url, SignedInfoType.type, (XmlOptions) null);
        }

        public static SignedInfoType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(url, SignedInfoType.type, xmlOptions);
        }

        public static SignedInfoType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignedInfoType.type, (XmlOptions) null);
        }

        public static SignedInfoType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignedInfoType.type, xmlOptions);
        }

        public static SignedInfoType parse(Node node) throws XmlException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(node, SignedInfoType.type, (XmlOptions) null);
        }

        public static SignedInfoType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignedInfoType) XmlBeans.getContextTypeLoader().parse(node, SignedInfoType.type, xmlOptions);
        }
    }

    CanonicalizationMethodType addNewCanonicalizationMethod();

    ReferenceType addNewReference();

    SignatureMethodType addNewSignatureMethod();

    CanonicalizationMethodType getCanonicalizationMethod();

    String getId();

    ReferenceType getReferenceArray(int i);

    ReferenceType[] getReferenceArray();

    List<ReferenceType> getReferenceList();

    SignatureMethodType getSignatureMethod();

    ReferenceType insertNewReference(int i);

    boolean isSetId();

    void removeReference(int i);

    void setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethodType);

    void setId(String str);

    void setReferenceArray(int i, ReferenceType referenceType);

    void setReferenceArray(ReferenceType[] referenceTypeArr);

    void setSignatureMethod(SignatureMethodType signatureMethodType);

    int sizeOfReferenceArray();

    void unsetId();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
