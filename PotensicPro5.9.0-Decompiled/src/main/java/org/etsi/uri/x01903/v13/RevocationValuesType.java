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
public interface RevocationValuesType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(RevocationValuesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("revocationvaluestype9a6etype");

    public static final class Factory {
        private Factory() {
        }

        public static RevocationValuesType newInstance() {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().newInstance(RevocationValuesType.type, null);
        }

        public static RevocationValuesType newInstance(XmlOptions xmlOptions) {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().newInstance(RevocationValuesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RevocationValuesType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(File file) throws XmlException, IOException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(file, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(file, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(InputStream inputStream) throws XmlException, IOException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(inputStream, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(inputStream, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(Reader reader) throws XmlException, IOException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(reader, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(reader, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(String str) throws XmlException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(str, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(str, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(URL url) throws XmlException, IOException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(url, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(url, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(Node node) throws XmlException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(node, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RevocationValuesType) XmlBeans.getContextTypeLoader().parse(node, RevocationValuesType.type, xmlOptions);
        }
    }

    CRLValuesType addNewCRLValues();

    OCSPValuesType addNewOCSPValues();

    OtherCertStatusValuesType addNewOtherValues();

    CRLValuesType getCRLValues();

    String getId();

    OCSPValuesType getOCSPValues();

    OtherCertStatusValuesType getOtherValues();

    boolean isSetCRLValues();

    boolean isSetId();

    boolean isSetOCSPValues();

    boolean isSetOtherValues();

    void setCRLValues(CRLValuesType cRLValuesType);

    void setId(String str);

    void setOCSPValues(OCSPValuesType oCSPValuesType);

    void setOtherValues(OtherCertStatusValuesType otherCertStatusValuesType);

    void unsetCRLValues();

    void unsetId();

    void unsetOCSPValues();

    void unsetOtherValues();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
