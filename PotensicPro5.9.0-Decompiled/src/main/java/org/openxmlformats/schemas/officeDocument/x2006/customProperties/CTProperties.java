package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

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

/* loaded from: classes.dex */
public interface CTProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctproperties2c18type");

    public static final class Factory {
        private Factory() {
        }

        public static CTProperties newInstance() {
            return (CTProperties) XmlBeans.getContextTypeLoader().newInstance(CTProperties.type, null);
        }

        public static CTProperties newInstance(XmlOptions xmlOptions) {
            return (CTProperties) XmlBeans.getContextTypeLoader().newInstance(CTProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(File file) throws XmlException, IOException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(file, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(file, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(Reader reader) throws XmlException, IOException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(reader, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(reader, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(String str) throws XmlException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(str, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(str, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(URL url) throws XmlException, IOException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(url, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(url, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(Node node) throws XmlException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(node, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) XmlBeans.getContextTypeLoader().parse(node, CTProperties.type, xmlOptions);
        }
    }

    CTProperty addNewProperty();

    CTProperty getPropertyArray(int i);

    CTProperty[] getPropertyArray();

    List<CTProperty> getPropertyList();

    CTProperty insertNewProperty(int i);

    void removeProperty(int i);

    void setPropertyArray(int i, CTProperty cTProperty);

    void setPropertyArray(CTProperty[] cTPropertyArr);

    int sizeOfPropertyArray();
}
