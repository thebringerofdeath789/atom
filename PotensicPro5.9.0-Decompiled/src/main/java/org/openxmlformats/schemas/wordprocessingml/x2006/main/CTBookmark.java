package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTBookmark extends CTBookmarkRange {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBookmark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbookmarkd672type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBookmark newInstance() {
            return (CTBookmark) XmlBeans.getContextTypeLoader().newInstance(CTBookmark.type, null);
        }

        public static CTBookmark newInstance(XmlOptions xmlOptions) {
            return (CTBookmark) XmlBeans.getContextTypeLoader().newInstance(CTBookmark.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBookmark.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(File file) throws XmlException, IOException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(file, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(file, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(inputStream, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(inputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(Reader reader) throws XmlException, IOException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(reader, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(reader, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(String str) throws XmlException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(str, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(str, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(URL url) throws XmlException, IOException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(url, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(url, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(Node node) throws XmlException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(node, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmark) XmlBeans.getContextTypeLoader().parse(node, CTBookmark.type, xmlOptions);
        }
    }

    String getName();

    void setName(String str);

    STString xgetName();

    void xsetName(STString sTString);
}
