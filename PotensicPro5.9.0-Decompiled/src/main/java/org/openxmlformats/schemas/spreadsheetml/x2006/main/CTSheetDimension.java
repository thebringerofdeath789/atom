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
public interface CTSheetDimension extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSheetDimension.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsheetdimensiond310type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetDimension newInstance() {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().newInstance(CTSheetDimension.type, null);
        }

        public static CTSheetDimension newInstance(XmlOptions xmlOptions) {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().newInstance(CTSheetDimension.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetDimension.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(File file) throws XmlException, IOException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(file, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(file, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(Reader reader) throws XmlException, IOException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(reader, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(reader, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(String str) throws XmlException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(str, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(str, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(URL url) throws XmlException, IOException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(url, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(url, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetDimension.type, xmlOptions);
        }

        public static CTSheetDimension parse(Node node) throws XmlException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(node, CTSheetDimension.type, (XmlOptions) null);
        }

        public static CTSheetDimension parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetDimension) XmlBeans.getContextTypeLoader().parse(node, CTSheetDimension.type, xmlOptions);
        }
    }

    String getRef();

    void setRef(String str);

    STRef xgetRef();

    void xsetRef(STRef sTRef);
}
