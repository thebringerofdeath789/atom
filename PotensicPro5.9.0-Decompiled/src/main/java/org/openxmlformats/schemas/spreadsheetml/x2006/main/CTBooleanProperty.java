package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTBooleanProperty extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBooleanProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbooleanproperty1f3ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBooleanProperty newInstance() {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().newInstance(CTBooleanProperty.type, null);
        }

        public static CTBooleanProperty newInstance(XmlOptions xmlOptions) {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().newInstance(CTBooleanProperty.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBooleanProperty.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBooleanProperty.type, xmlOptions);
        }

        public static CTBooleanProperty parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBooleanProperty.type, (XmlOptions) null);
        }

        public static CTBooleanProperty parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBooleanProperty.type, xmlOptions);
        }

        public static CTBooleanProperty parse(File file) throws XmlException, IOException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(file, CTBooleanProperty.type, (XmlOptions) null);
        }

        public static CTBooleanProperty parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(file, CTBooleanProperty.type, xmlOptions);
        }

        public static CTBooleanProperty parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(inputStream, CTBooleanProperty.type, (XmlOptions) null);
        }

        public static CTBooleanProperty parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(inputStream, CTBooleanProperty.type, xmlOptions);
        }

        public static CTBooleanProperty parse(Reader reader) throws XmlException, IOException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(reader, CTBooleanProperty.type, (XmlOptions) null);
        }

        public static CTBooleanProperty parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(reader, CTBooleanProperty.type, xmlOptions);
        }

        public static CTBooleanProperty parse(String str) throws XmlException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(str, CTBooleanProperty.type, (XmlOptions) null);
        }

        public static CTBooleanProperty parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(str, CTBooleanProperty.type, xmlOptions);
        }

        public static CTBooleanProperty parse(URL url) throws XmlException, IOException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(url, CTBooleanProperty.type, (XmlOptions) null);
        }

        public static CTBooleanProperty parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(url, CTBooleanProperty.type, xmlOptions);
        }

        public static CTBooleanProperty parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBooleanProperty.type, (XmlOptions) null);
        }

        public static CTBooleanProperty parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBooleanProperty.type, xmlOptions);
        }

        public static CTBooleanProperty parse(Node node) throws XmlException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(node, CTBooleanProperty.type, (XmlOptions) null);
        }

        public static CTBooleanProperty parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBooleanProperty) XmlBeans.getContextTypeLoader().parse(node, CTBooleanProperty.type, xmlOptions);
        }
    }

    boolean getVal();

    boolean isSetVal();

    void setVal(boolean z);

    void unsetVal();

    XmlBoolean xgetVal();

    void xsetVal(XmlBoolean xmlBoolean);
}
