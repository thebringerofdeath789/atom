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
public interface CTField extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfieldc999type");

    public static final class Factory {
        private Factory() {
        }

        public static CTField newInstance() {
            return (CTField) XmlBeans.getContextTypeLoader().newInstance(CTField.type, null);
        }

        public static CTField newInstance(XmlOptions xmlOptions) {
            return (CTField) XmlBeans.getContextTypeLoader().newInstance(CTField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTField.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTField.type, xmlOptions);
        }

        public static CTField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTField.type, xmlOptions);
        }

        public static CTField parse(File file) throws XmlException, IOException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(file, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(file, CTField.type, xmlOptions);
        }

        public static CTField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(inputStream, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(inputStream, CTField.type, xmlOptions);
        }

        public static CTField parse(Reader reader) throws XmlException, IOException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(reader, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(reader, CTField.type, xmlOptions);
        }

        public static CTField parse(String str) throws XmlException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(str, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(str, CTField.type, xmlOptions);
        }

        public static CTField parse(URL url) throws XmlException, IOException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(url, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(url, CTField.type, xmlOptions);
        }

        public static CTField parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTField.type, xmlOptions);
        }

        public static CTField parse(Node node) throws XmlException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(node, CTField.type, (XmlOptions) null);
        }

        public static CTField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTField) XmlBeans.getContextTypeLoader().parse(node, CTField.type, xmlOptions);
        }
    }

    int getX();

    void setX(int i);

    XmlInt xgetX();

    void xsetX(XmlInt xmlInt);
}
