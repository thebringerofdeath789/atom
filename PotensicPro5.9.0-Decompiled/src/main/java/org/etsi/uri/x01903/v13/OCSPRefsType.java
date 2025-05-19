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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface OCSPRefsType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(OCSPRefsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ocsprefstypef13ftype");

    public static final class Factory {
        private Factory() {
        }

        public static OCSPRefsType newInstance() {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().newInstance(OCSPRefsType.type, null);
        }

        public static OCSPRefsType newInstance(XmlOptions xmlOptions) {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().newInstance(OCSPRefsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OCSPRefsType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OCSPRefsType.type, xmlOptions);
        }

        public static OCSPRefsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OCSPRefsType.type, (XmlOptions) null);
        }

        public static OCSPRefsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OCSPRefsType.type, xmlOptions);
        }

        public static OCSPRefsType parse(File file) throws XmlException, IOException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(file, OCSPRefsType.type, (XmlOptions) null);
        }

        public static OCSPRefsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(file, OCSPRefsType.type, xmlOptions);
        }

        public static OCSPRefsType parse(InputStream inputStream) throws XmlException, IOException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(inputStream, OCSPRefsType.type, (XmlOptions) null);
        }

        public static OCSPRefsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(inputStream, OCSPRefsType.type, xmlOptions);
        }

        public static OCSPRefsType parse(Reader reader) throws XmlException, IOException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(reader, OCSPRefsType.type, (XmlOptions) null);
        }

        public static OCSPRefsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(reader, OCSPRefsType.type, xmlOptions);
        }

        public static OCSPRefsType parse(String str) throws XmlException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(str, OCSPRefsType.type, (XmlOptions) null);
        }

        public static OCSPRefsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(str, OCSPRefsType.type, xmlOptions);
        }

        public static OCSPRefsType parse(URL url) throws XmlException, IOException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(url, OCSPRefsType.type, (XmlOptions) null);
        }

        public static OCSPRefsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(url, OCSPRefsType.type, xmlOptions);
        }

        public static OCSPRefsType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OCSPRefsType.type, (XmlOptions) null);
        }

        public static OCSPRefsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OCSPRefsType.type, xmlOptions);
        }

        public static OCSPRefsType parse(Node node) throws XmlException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(node, OCSPRefsType.type, (XmlOptions) null);
        }

        public static OCSPRefsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (OCSPRefsType) XmlBeans.getContextTypeLoader().parse(node, OCSPRefsType.type, xmlOptions);
        }
    }

    OCSPRefType addNewOCSPRef();

    OCSPRefType getOCSPRefArray(int i);

    OCSPRefType[] getOCSPRefArray();

    List<OCSPRefType> getOCSPRefList();

    OCSPRefType insertNewOCSPRef(int i);

    void removeOCSPRef(int i);

    void setOCSPRefArray(int i, OCSPRefType oCSPRefType);

    void setOCSPRefArray(OCSPRefType[] oCSPRefTypeArr);

    int sizeOfOCSPRefArray();
}
