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
public interface TableDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(TableDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("table0b99doctype");

    public static final class Factory {
        private Factory() {
        }

        public static TableDocument newInstance() {
            return (TableDocument) XmlBeans.getContextTypeLoader().newInstance(TableDocument.type, null);
        }

        public static TableDocument newInstance(XmlOptions xmlOptions) {
            return (TableDocument) XmlBeans.getContextTypeLoader().newInstance(TableDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TableDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(File file) throws XmlException, IOException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(file, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(file, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(Reader reader) throws XmlException, IOException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(reader, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(reader, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(String str) throws XmlException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(str, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(str, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(URL url) throws XmlException, IOException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(url, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(url, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TableDocument.type, xmlOptions);
        }

        public static TableDocument parse(Node node) throws XmlException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(node, TableDocument.type, (XmlOptions) null);
        }

        public static TableDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TableDocument) XmlBeans.getContextTypeLoader().parse(node, TableDocument.type, xmlOptions);
        }
    }

    CTTable addNewTable();

    CTTable getTable();

    void setTable(CTTable cTTable);
}
