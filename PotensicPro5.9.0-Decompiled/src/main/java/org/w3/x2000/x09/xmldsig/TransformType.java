package org.w3.x2000.x09.xmldsig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface TransformType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(TransformType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("transformtype550btype");

    public static final class Factory {
        private Factory() {
        }

        public static TransformType newInstance() {
            return (TransformType) XmlBeans.getContextTypeLoader().newInstance(TransformType.type, null);
        }

        public static TransformType newInstance(XmlOptions xmlOptions) {
            return (TransformType) XmlBeans.getContextTypeLoader().newInstance(TransformType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TransformType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TransformType.type, xmlOptions);
        }

        public static TransformType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TransformType.type, xmlOptions);
        }

        public static TransformType parse(File file) throws XmlException, IOException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(file, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(file, TransformType.type, xmlOptions);
        }

        public static TransformType parse(InputStream inputStream) throws XmlException, IOException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(inputStream, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(inputStream, TransformType.type, xmlOptions);
        }

        public static TransformType parse(Reader reader) throws XmlException, IOException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(reader, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(reader, TransformType.type, xmlOptions);
        }

        public static TransformType parse(String str) throws XmlException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(str, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(str, TransformType.type, xmlOptions);
        }

        public static TransformType parse(URL url) throws XmlException, IOException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(url, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(url, TransformType.type, xmlOptions);
        }

        public static TransformType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TransformType.type, xmlOptions);
        }

        public static TransformType parse(Node node) throws XmlException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(node, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TransformType) XmlBeans.getContextTypeLoader().parse(node, TransformType.type, xmlOptions);
        }
    }

    XmlString addNewXPath();

    void addXPath(String str);

    String getAlgorithm();

    String getXPathArray(int i);

    String[] getXPathArray();

    List<String> getXPathList();

    XmlString insertNewXPath(int i);

    void insertXPath(int i, String str);

    void removeXPath(int i);

    void setAlgorithm(String str);

    void setXPathArray(int i, String str);

    void setXPathArray(String[] strArr);

    int sizeOfXPathArray();

    XmlAnyURI xgetAlgorithm();

    XmlString xgetXPathArray(int i);

    XmlString[] xgetXPathArray();

    List<XmlString> xgetXPathList();

    void xsetAlgorithm(XmlAnyURI xmlAnyURI);

    void xsetXPathArray(int i, XmlString xmlString);

    void xsetXPathArray(XmlString[] xmlStringArr);
}
