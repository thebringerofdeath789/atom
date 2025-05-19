package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface QualifyingPropertiesType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(QualifyingPropertiesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("qualifyingpropertiestype9e16type");

    public static final class Factory {
        private Factory() {
        }

        public static QualifyingPropertiesType newInstance() {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().newInstance(QualifyingPropertiesType.type, null);
        }

        public static QualifyingPropertiesType newInstance(XmlOptions xmlOptions) {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().newInstance(QualifyingPropertiesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, QualifyingPropertiesType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(File file) throws XmlException, IOException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(file, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(file, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(InputStream inputStream) throws XmlException, IOException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(inputStream, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(inputStream, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(Reader reader) throws XmlException, IOException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(reader, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(reader, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(String str) throws XmlException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(str, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(str, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(URL url) throws XmlException, IOException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(url, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(url, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(Node node) throws XmlException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(node, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesType) XmlBeans.getContextTypeLoader().parse(node, QualifyingPropertiesType.type, xmlOptions);
        }
    }

    SignedPropertiesType addNewSignedProperties();

    UnsignedPropertiesType addNewUnsignedProperties();

    String getId();

    SignedPropertiesType getSignedProperties();

    String getTarget();

    UnsignedPropertiesType getUnsignedProperties();

    boolean isSetId();

    boolean isSetSignedProperties();

    boolean isSetUnsignedProperties();

    void setId(String str);

    void setSignedProperties(SignedPropertiesType signedPropertiesType);

    void setTarget(String str);

    void setUnsignedProperties(UnsignedPropertiesType unsignedPropertiesType);

    void unsetId();

    void unsetSignedProperties();

    void unsetUnsignedProperties();

    XmlID xgetId();

    XmlAnyURI xgetTarget();

    void xsetId(XmlID xmlID);

    void xsetTarget(XmlAnyURI xmlAnyURI);
}
