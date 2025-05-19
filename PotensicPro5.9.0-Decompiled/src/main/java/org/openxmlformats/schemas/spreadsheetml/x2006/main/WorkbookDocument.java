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
public interface WorkbookDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(WorkbookDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("workbookec17doctype");

    public static final class Factory {
        private Factory() {
        }

        public static WorkbookDocument newInstance() {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().newInstance(WorkbookDocument.type, null);
        }

        public static WorkbookDocument newInstance(XmlOptions xmlOptions) {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().newInstance(WorkbookDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, WorkbookDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(File file) throws XmlException, IOException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(file, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(file, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(inputStream, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(inputStream, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(Reader reader) throws XmlException, IOException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(reader, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(reader, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(String str) throws XmlException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(str, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(str, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(URL url) throws XmlException, IOException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(url, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(url, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, WorkbookDocument.type, xmlOptions);
        }

        public static WorkbookDocument parse(Node node) throws XmlException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(node, WorkbookDocument.type, (XmlOptions) null);
        }

        public static WorkbookDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (WorkbookDocument) XmlBeans.getContextTypeLoader().parse(node, WorkbookDocument.type, xmlOptions);
        }
    }

    CTWorkbook addNewWorkbook();

    CTWorkbook getWorkbook();

    void setWorkbook(CTWorkbook cTWorkbook);
}
