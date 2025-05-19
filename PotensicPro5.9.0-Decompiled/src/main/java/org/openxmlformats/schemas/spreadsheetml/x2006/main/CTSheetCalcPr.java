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
public interface CTSheetCalcPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSheetCalcPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsheetcalcprc6d5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetCalcPr newInstance() {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().newInstance(CTSheetCalcPr.type, null);
        }

        public static CTSheetCalcPr newInstance(XmlOptions xmlOptions) {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().newInstance(CTSheetCalcPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetCalcPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(File file) throws XmlException, IOException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(file, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(file, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(Reader reader) throws XmlException, IOException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(reader, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(reader, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(String str) throws XmlException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(str, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(str, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(URL url) throws XmlException, IOException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(url, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(url, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetCalcPr.type, xmlOptions);
        }

        public static CTSheetCalcPr parse(Node node) throws XmlException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(node, CTSheetCalcPr.type, (XmlOptions) null);
        }

        public static CTSheetCalcPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetCalcPr) XmlBeans.getContextTypeLoader().parse(node, CTSheetCalcPr.type, xmlOptions);
        }
    }

    boolean getFullCalcOnLoad();

    boolean isSetFullCalcOnLoad();

    void setFullCalcOnLoad(boolean z);

    void unsetFullCalcOnLoad();

    XmlBoolean xgetFullCalcOnLoad();

    void xsetFullCalcOnLoad(XmlBoolean xmlBoolean);
}
