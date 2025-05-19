package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

/* loaded from: classes6.dex */
public interface CTExternalSheetNames extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTExternalSheetNames.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctexternalsheetnames7eddtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalSheetNames newInstance() {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().newInstance(CTExternalSheetNames.type, null);
        }

        public static CTExternalSheetNames newInstance(XmlOptions xmlOptions) {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().newInstance(CTExternalSheetNames.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalSheetNames.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(File file) throws XmlException, IOException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(file, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(file, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(Reader reader) throws XmlException, IOException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(reader, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(reader, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(String str) throws XmlException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(str, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(str, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(URL url) throws XmlException, IOException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(url, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(url, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalSheetNames.type, xmlOptions);
        }

        public static CTExternalSheetNames parse(Node node) throws XmlException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(node, CTExternalSheetNames.type, (XmlOptions) null);
        }

        public static CTExternalSheetNames parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetNames) XmlBeans.getContextTypeLoader().parse(node, CTExternalSheetNames.type, xmlOptions);
        }
    }

    CTExternalSheetName addNewSheetName();

    CTExternalSheetName getSheetNameArray(int i);

    CTExternalSheetName[] getSheetNameArray();

    List<CTExternalSheetName> getSheetNameList();

    CTExternalSheetName insertNewSheetName(int i);

    void removeSheetName(int i);

    void setSheetNameArray(int i, CTExternalSheetName cTExternalSheetName);

    void setSheetNameArray(CTExternalSheetName[] cTExternalSheetNameArr);

    int sizeOfSheetNameArray();
}
