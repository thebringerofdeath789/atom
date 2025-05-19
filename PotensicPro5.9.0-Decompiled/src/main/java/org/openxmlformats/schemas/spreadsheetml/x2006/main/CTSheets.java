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
public interface CTSheets extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSheets.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsheets49fdtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheets newInstance() {
            return (CTSheets) XmlBeans.getContextTypeLoader().newInstance(CTSheets.type, null);
        }

        public static CTSheets newInstance(XmlOptions xmlOptions) {
            return (CTSheets) XmlBeans.getContextTypeLoader().newInstance(CTSheets.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheets.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheets.type, xmlOptions);
        }

        public static CTSheets parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheets.type, (XmlOptions) null);
        }

        public static CTSheets parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheets.type, xmlOptions);
        }

        public static CTSheets parse(File file) throws XmlException, IOException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(file, CTSheets.type, (XmlOptions) null);
        }

        public static CTSheets parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(file, CTSheets.type, xmlOptions);
        }

        public static CTSheets parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheets.type, (XmlOptions) null);
        }

        public static CTSheets parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheets.type, xmlOptions);
        }

        public static CTSheets parse(Reader reader) throws XmlException, IOException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(reader, CTSheets.type, (XmlOptions) null);
        }

        public static CTSheets parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(reader, CTSheets.type, xmlOptions);
        }

        public static CTSheets parse(String str) throws XmlException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(str, CTSheets.type, (XmlOptions) null);
        }

        public static CTSheets parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(str, CTSheets.type, xmlOptions);
        }

        public static CTSheets parse(URL url) throws XmlException, IOException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(url, CTSheets.type, (XmlOptions) null);
        }

        public static CTSheets parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(url, CTSheets.type, xmlOptions);
        }

        public static CTSheets parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheets.type, (XmlOptions) null);
        }

        public static CTSheets parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheets.type, xmlOptions);
        }

        public static CTSheets parse(Node node) throws XmlException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(node, CTSheets.type, (XmlOptions) null);
        }

        public static CTSheets parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheets) XmlBeans.getContextTypeLoader().parse(node, CTSheets.type, xmlOptions);
        }
    }

    CTSheet addNewSheet();

    CTSheet getSheetArray(int i);

    CTSheet[] getSheetArray();

    List<CTSheet> getSheetList();

    CTSheet insertNewSheet(int i);

    void removeSheet(int i);

    void setSheetArray(int i, CTSheet cTSheet);

    void setSheetArray(CTSheet[] cTSheetArr);

    int sizeOfSheetArray();
}
