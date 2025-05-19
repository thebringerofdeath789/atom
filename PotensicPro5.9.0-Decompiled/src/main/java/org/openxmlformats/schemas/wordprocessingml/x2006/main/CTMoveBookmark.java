package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTMoveBookmark extends CTBookmark {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMoveBookmark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmovebookmarkf7a1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMoveBookmark newInstance() {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().newInstance(CTMoveBookmark.type, null);
        }

        public static CTMoveBookmark newInstance(XmlOptions xmlOptions) {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().newInstance(CTMoveBookmark.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMoveBookmark.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(File file) throws XmlException, IOException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(file, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(file, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(inputStream, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(inputStream, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(Reader reader) throws XmlException, IOException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(reader, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(reader, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(String str) throws XmlException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(str, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(str, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(URL url) throws XmlException, IOException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(url, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(url, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(Node node) throws XmlException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(node, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMoveBookmark) XmlBeans.getContextTypeLoader().parse(node, CTMoveBookmark.type, xmlOptions);
        }
    }

    String getAuthor();

    Calendar getDate();

    void setAuthor(String str);

    void setDate(Calendar calendar);

    STString xgetAuthor();

    STDateTime xgetDate();

    void xsetAuthor(STString sTString);

    void xsetDate(STDateTime sTDateTime);
}
