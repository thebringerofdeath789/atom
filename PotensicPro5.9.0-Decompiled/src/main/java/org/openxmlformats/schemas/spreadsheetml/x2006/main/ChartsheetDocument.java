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
public interface ChartsheetDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(ChartsheetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("chartsheet99dedoctype");

    public static final class Factory {
        private Factory() {
        }

        public static ChartsheetDocument newInstance() {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().newInstance(ChartsheetDocument.type, null);
        }

        public static ChartsheetDocument newInstance(XmlOptions xmlOptions) {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().newInstance(ChartsheetDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ChartsheetDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ChartsheetDocument.type, xmlOptions);
        }

        public static ChartsheetDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ChartsheetDocument.type, (XmlOptions) null);
        }

        public static ChartsheetDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ChartsheetDocument.type, xmlOptions);
        }

        public static ChartsheetDocument parse(File file) throws XmlException, IOException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(file, ChartsheetDocument.type, (XmlOptions) null);
        }

        public static ChartsheetDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(file, ChartsheetDocument.type, xmlOptions);
        }

        public static ChartsheetDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ChartsheetDocument.type, (XmlOptions) null);
        }

        public static ChartsheetDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ChartsheetDocument.type, xmlOptions);
        }

        public static ChartsheetDocument parse(Reader reader) throws XmlException, IOException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(reader, ChartsheetDocument.type, (XmlOptions) null);
        }

        public static ChartsheetDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(reader, ChartsheetDocument.type, xmlOptions);
        }

        public static ChartsheetDocument parse(String str) throws XmlException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(str, ChartsheetDocument.type, (XmlOptions) null);
        }

        public static ChartsheetDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(str, ChartsheetDocument.type, xmlOptions);
        }

        public static ChartsheetDocument parse(URL url) throws XmlException, IOException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(url, ChartsheetDocument.type, (XmlOptions) null);
        }

        public static ChartsheetDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(url, ChartsheetDocument.type, xmlOptions);
        }

        public static ChartsheetDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ChartsheetDocument.type, (XmlOptions) null);
        }

        public static ChartsheetDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ChartsheetDocument.type, xmlOptions);
        }

        public static ChartsheetDocument parse(Node node) throws XmlException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(node, ChartsheetDocument.type, (XmlOptions) null);
        }

        public static ChartsheetDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ChartsheetDocument) XmlBeans.getContextTypeLoader().parse(node, ChartsheetDocument.type, xmlOptions);
        }
    }

    CTChartsheet addNewChartsheet();

    CTChartsheet getChartsheet();

    void setChartsheet(CTChartsheet cTChartsheet);
}
