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
public interface CompleteRevocationRefsType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CompleteRevocationRefsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("completerevocationrefstyped8a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CompleteRevocationRefsType newInstance() {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().newInstance(CompleteRevocationRefsType.type, null);
        }

        public static CompleteRevocationRefsType newInstance(XmlOptions xmlOptions) {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().newInstance(CompleteRevocationRefsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CompleteRevocationRefsType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(File file) throws XmlException, IOException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(file, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(file, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(InputStream inputStream) throws XmlException, IOException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(inputStream, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(inputStream, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(Reader reader) throws XmlException, IOException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(reader, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(reader, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(String str) throws XmlException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(str, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(str, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(URL url) throws XmlException, IOException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(url, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(url, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(Node node) throws XmlException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(node, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CompleteRevocationRefsType) XmlBeans.getContextTypeLoader().parse(node, CompleteRevocationRefsType.type, xmlOptions);
        }
    }

    CRLRefsType addNewCRLRefs();

    OCSPRefsType addNewOCSPRefs();

    OtherCertStatusRefsType addNewOtherRefs();

    CRLRefsType getCRLRefs();

    String getId();

    OCSPRefsType getOCSPRefs();

    OtherCertStatusRefsType getOtherRefs();

    boolean isSetCRLRefs();

    boolean isSetId();

    boolean isSetOCSPRefs();

    boolean isSetOtherRefs();

    void setCRLRefs(CRLRefsType cRLRefsType);

    void setId(String str);

    void setOCSPRefs(OCSPRefsType oCSPRefsType);

    void setOtherRefs(OtherCertStatusRefsType otherCertStatusRefsType);

    void unsetCRLRefs();

    void unsetId();

    void unsetOCSPRefs();

    void unsetOtherRefs();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
