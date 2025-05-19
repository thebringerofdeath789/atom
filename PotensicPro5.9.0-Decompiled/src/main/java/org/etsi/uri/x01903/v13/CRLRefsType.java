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
public interface CRLRefsType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CRLRefsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("crlrefstype2a59type");

    public static final class Factory {
        private Factory() {
        }

        public static CRLRefsType newInstance() {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().newInstance(CRLRefsType.type, null);
        }

        public static CRLRefsType newInstance(XmlOptions xmlOptions) {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().newInstance(CRLRefsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CRLRefsType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CRLRefsType.type, xmlOptions);
        }

        public static CRLRefsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CRLRefsType.type, (XmlOptions) null);
        }

        public static CRLRefsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CRLRefsType.type, xmlOptions);
        }

        public static CRLRefsType parse(File file) throws XmlException, IOException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(file, CRLRefsType.type, (XmlOptions) null);
        }

        public static CRLRefsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(file, CRLRefsType.type, xmlOptions);
        }

        public static CRLRefsType parse(InputStream inputStream) throws XmlException, IOException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(inputStream, CRLRefsType.type, (XmlOptions) null);
        }

        public static CRLRefsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(inputStream, CRLRefsType.type, xmlOptions);
        }

        public static CRLRefsType parse(Reader reader) throws XmlException, IOException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(reader, CRLRefsType.type, (XmlOptions) null);
        }

        public static CRLRefsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(reader, CRLRefsType.type, xmlOptions);
        }

        public static CRLRefsType parse(String str) throws XmlException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(str, CRLRefsType.type, (XmlOptions) null);
        }

        public static CRLRefsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(str, CRLRefsType.type, xmlOptions);
        }

        public static CRLRefsType parse(URL url) throws XmlException, IOException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(url, CRLRefsType.type, (XmlOptions) null);
        }

        public static CRLRefsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(url, CRLRefsType.type, xmlOptions);
        }

        public static CRLRefsType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CRLRefsType.type, (XmlOptions) null);
        }

        public static CRLRefsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CRLRefsType.type, xmlOptions);
        }

        public static CRLRefsType parse(Node node) throws XmlException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(node, CRLRefsType.type, (XmlOptions) null);
        }

        public static CRLRefsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CRLRefsType) XmlBeans.getContextTypeLoader().parse(node, CRLRefsType.type, xmlOptions);
        }
    }

    CRLRefType addNewCRLRef();

    CRLRefType getCRLRefArray(int i);

    CRLRefType[] getCRLRefArray();

    List<CRLRefType> getCRLRefList();

    CRLRefType insertNewCRLRef(int i);

    void removeCRLRef(int i);

    void setCRLRefArray(int i, CRLRefType cRLRefType);

    void setCRLRefArray(CRLRefType[] cRLRefTypeArr);

    int sizeOfCRLRefArray();
}
