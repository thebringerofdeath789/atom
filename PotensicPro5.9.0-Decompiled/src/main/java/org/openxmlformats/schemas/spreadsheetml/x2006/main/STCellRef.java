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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STCellRef extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STCellRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stcellrefe4e0type");

    public static final class Factory {
        private Factory() {
        }

        public static STCellRef newInstance() {
            return (STCellRef) XmlBeans.getContextTypeLoader().newInstance(STCellRef.type, null);
        }

        public static STCellRef newInstance(XmlOptions xmlOptions) {
            return (STCellRef) XmlBeans.getContextTypeLoader().newInstance(STCellRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCellRef.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCellRef.type, xmlOptions);
        }

        public static STCellRef newValue(Object obj) {
            return (STCellRef) STCellRef.type.newValue(obj);
        }

        public static STCellRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCellRef.type, (XmlOptions) null);
        }

        public static STCellRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCellRef.type, xmlOptions);
        }

        public static STCellRef parse(File file) throws XmlException, IOException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(file, STCellRef.type, (XmlOptions) null);
        }

        public static STCellRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(file, STCellRef.type, xmlOptions);
        }

        public static STCellRef parse(InputStream inputStream) throws XmlException, IOException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(inputStream, STCellRef.type, (XmlOptions) null);
        }

        public static STCellRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(inputStream, STCellRef.type, xmlOptions);
        }

        public static STCellRef parse(Reader reader) throws XmlException, IOException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(reader, STCellRef.type, (XmlOptions) null);
        }

        public static STCellRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(reader, STCellRef.type, xmlOptions);
        }

        public static STCellRef parse(String str) throws XmlException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(str, STCellRef.type, (XmlOptions) null);
        }

        public static STCellRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(str, STCellRef.type, xmlOptions);
        }

        public static STCellRef parse(URL url) throws XmlException, IOException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(url, STCellRef.type, (XmlOptions) null);
        }

        public static STCellRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(url, STCellRef.type, xmlOptions);
        }

        public static STCellRef parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCellRef.type, (XmlOptions) null);
        }

        public static STCellRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCellRef.type, xmlOptions);
        }

        public static STCellRef parse(Node node) throws XmlException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(node, STCellRef.type, (XmlOptions) null);
        }

        public static STCellRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STCellRef) XmlBeans.getContextTypeLoader().parse(node, STCellRef.type, xmlOptions);
        }
    }
}
