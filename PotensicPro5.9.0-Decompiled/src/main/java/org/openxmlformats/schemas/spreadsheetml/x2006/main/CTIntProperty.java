package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTIntProperty extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTIntProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctintproperty32c3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTIntProperty newInstance() {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().newInstance(CTIntProperty.type, null);
        }

        public static CTIntProperty newInstance(XmlOptions xmlOptions) {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().newInstance(CTIntProperty.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTIntProperty.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(File file) throws XmlException, IOException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(file, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(file, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(InputStream inputStream) throws XmlException, IOException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(inputStream, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(inputStream, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(Reader reader) throws XmlException, IOException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(reader, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(reader, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(String str) throws XmlException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(str, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(str, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(URL url) throws XmlException, IOException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(url, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(url, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTIntProperty.type, xmlOptions);
        }

        public static CTIntProperty parse(Node node) throws XmlException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(node, CTIntProperty.type, (XmlOptions) null);
        }

        public static CTIntProperty parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTIntProperty) XmlBeans.getContextTypeLoader().parse(node, CTIntProperty.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    XmlInt xgetVal();

    void xsetVal(XmlInt xmlInt);
}
