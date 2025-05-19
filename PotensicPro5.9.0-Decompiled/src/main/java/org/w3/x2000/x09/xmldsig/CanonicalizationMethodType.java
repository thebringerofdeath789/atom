package org.w3.x2000.x09.xmldsig;

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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CanonicalizationMethodType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CanonicalizationMethodType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("canonicalizationmethodtypeec74type");

    public static final class Factory {
        private Factory() {
        }

        public static CanonicalizationMethodType newInstance() {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().newInstance(CanonicalizationMethodType.type, null);
        }

        public static CanonicalizationMethodType newInstance(XmlOptions xmlOptions) {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().newInstance(CanonicalizationMethodType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CanonicalizationMethodType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CanonicalizationMethodType.type, xmlOptions);
        }

        public static CanonicalizationMethodType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CanonicalizationMethodType.type, (XmlOptions) null);
        }

        public static CanonicalizationMethodType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CanonicalizationMethodType.type, xmlOptions);
        }

        public static CanonicalizationMethodType parse(File file) throws XmlException, IOException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(file, CanonicalizationMethodType.type, (XmlOptions) null);
        }

        public static CanonicalizationMethodType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(file, CanonicalizationMethodType.type, xmlOptions);
        }

        public static CanonicalizationMethodType parse(InputStream inputStream) throws XmlException, IOException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(inputStream, CanonicalizationMethodType.type, (XmlOptions) null);
        }

        public static CanonicalizationMethodType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(inputStream, CanonicalizationMethodType.type, xmlOptions);
        }

        public static CanonicalizationMethodType parse(Reader reader) throws XmlException, IOException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(reader, CanonicalizationMethodType.type, (XmlOptions) null);
        }

        public static CanonicalizationMethodType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(reader, CanonicalizationMethodType.type, xmlOptions);
        }

        public static CanonicalizationMethodType parse(String str) throws XmlException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(str, CanonicalizationMethodType.type, (XmlOptions) null);
        }

        public static CanonicalizationMethodType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(str, CanonicalizationMethodType.type, xmlOptions);
        }

        public static CanonicalizationMethodType parse(URL url) throws XmlException, IOException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(url, CanonicalizationMethodType.type, (XmlOptions) null);
        }

        public static CanonicalizationMethodType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(url, CanonicalizationMethodType.type, xmlOptions);
        }

        public static CanonicalizationMethodType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CanonicalizationMethodType.type, (XmlOptions) null);
        }

        public static CanonicalizationMethodType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CanonicalizationMethodType.type, xmlOptions);
        }

        public static CanonicalizationMethodType parse(Node node) throws XmlException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(node, CanonicalizationMethodType.type, (XmlOptions) null);
        }

        public static CanonicalizationMethodType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CanonicalizationMethodType) XmlBeans.getContextTypeLoader().parse(node, CanonicalizationMethodType.type, xmlOptions);
        }
    }

    String getAlgorithm();

    void setAlgorithm(String str);

    XmlAnyURI xgetAlgorithm();

    void xsetAlgorithm(XmlAnyURI xmlAnyURI);
}
