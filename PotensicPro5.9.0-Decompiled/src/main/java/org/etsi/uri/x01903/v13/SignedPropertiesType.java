package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
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
public interface SignedPropertiesType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SignedPropertiesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("signedpropertiestype163dtype");

    public static final class Factory {
        private Factory() {
        }

        public static SignedPropertiesType newInstance() {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().newInstance(SignedPropertiesType.type, null);
        }

        public static SignedPropertiesType newInstance(XmlOptions xmlOptions) {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().newInstance(SignedPropertiesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignedPropertiesType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(File file) throws XmlException, IOException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(file, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(file, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(InputStream inputStream) throws XmlException, IOException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(inputStream, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(inputStream, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(Reader reader) throws XmlException, IOException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(reader, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(reader, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(String str) throws XmlException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(str, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(str, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(URL url) throws XmlException, IOException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(url, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(url, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(Node node) throws XmlException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(node, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignedPropertiesType) XmlBeans.getContextTypeLoader().parse(node, SignedPropertiesType.type, xmlOptions);
        }
    }

    SignedDataObjectPropertiesType addNewSignedDataObjectProperties();

    SignedSignaturePropertiesType addNewSignedSignatureProperties();

    String getId();

    SignedDataObjectPropertiesType getSignedDataObjectProperties();

    SignedSignaturePropertiesType getSignedSignatureProperties();

    boolean isSetId();

    boolean isSetSignedDataObjectProperties();

    boolean isSetSignedSignatureProperties();

    void setId(String str);

    void setSignedDataObjectProperties(SignedDataObjectPropertiesType signedDataObjectPropertiesType);

    void setSignedSignatureProperties(SignedSignaturePropertiesType signedSignaturePropertiesType);

    void unsetId();

    void unsetSignedDataObjectProperties();

    void unsetSignedSignatureProperties();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
