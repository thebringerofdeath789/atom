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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTExternalSheetName extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTExternalSheetName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctexternalsheetnamefcdetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalSheetName newInstance() {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().newInstance(CTExternalSheetName.type, null);
        }

        public static CTExternalSheetName newInstance(XmlOptions xmlOptions) {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().newInstance(CTExternalSheetName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalSheetName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(File file) throws XmlException, IOException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(file, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(file, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(Reader reader) throws XmlException, IOException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(reader, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(reader, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(String str) throws XmlException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(str, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(str, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(URL url) throws XmlException, IOException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(url, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(url, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalSheetName.type, xmlOptions);
        }

        public static CTExternalSheetName parse(Node node) throws XmlException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(node, CTExternalSheetName.type, (XmlOptions) null);
        }

        public static CTExternalSheetName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalSheetName) XmlBeans.getContextTypeLoader().parse(node, CTExternalSheetName.type, xmlOptions);
        }
    }

    String getVal();

    boolean isSetVal();

    void setVal(String str);

    void unsetVal();

    STXstring xgetVal();

    void xsetVal(STXstring sTXstring);
}
