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
public interface WorksheetDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(WorksheetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("worksheetf539doctype");

    public static final class Factory {
        private Factory() {
        }

        public static WorksheetDocument newInstance() {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().newInstance(WorksheetDocument.type, null);
        }

        public static WorksheetDocument newInstance(XmlOptions xmlOptions) {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().newInstance(WorksheetDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, WorksheetDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(File file) throws XmlException, IOException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(file, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(file, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(inputStream, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(inputStream, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(Reader reader) throws XmlException, IOException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(reader, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(reader, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(String str) throws XmlException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(str, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(str, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(URL url) throws XmlException, IOException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(url, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(url, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, WorksheetDocument.type, xmlOptions);
        }

        public static WorksheetDocument parse(Node node) throws XmlException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(node, WorksheetDocument.type, (XmlOptions) null);
        }

        public static WorksheetDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (WorksheetDocument) XmlBeans.getContextTypeLoader().parse(node, WorksheetDocument.type, xmlOptions);
        }
    }

    CTWorksheet addNewWorksheet();

    CTWorksheet getWorksheet();

    void setWorksheet(CTWorksheet cTWorksheet);
}
