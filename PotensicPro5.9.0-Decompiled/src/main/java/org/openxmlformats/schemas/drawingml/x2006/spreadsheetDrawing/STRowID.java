package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STRowID extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STRowID.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("strowidf4cftype");

    public static final class Factory {
        private Factory() {
        }

        public static STRowID newInstance() {
            return (STRowID) XmlBeans.getContextTypeLoader().newInstance(STRowID.type, null);
        }

        public static STRowID newInstance(XmlOptions xmlOptions) {
            return (STRowID) XmlBeans.getContextTypeLoader().newInstance(STRowID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STRowID.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STRowID.type, xmlOptions);
        }

        public static STRowID newValue(Object obj) {
            return (STRowID) STRowID.type.newValue(obj);
        }

        public static STRowID parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STRowID.type, xmlOptions);
        }

        public static STRowID parse(File file) throws XmlException, IOException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(file, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(file, STRowID.type, xmlOptions);
        }

        public static STRowID parse(InputStream inputStream) throws XmlException, IOException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(inputStream, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(inputStream, STRowID.type, xmlOptions);
        }

        public static STRowID parse(Reader reader) throws XmlException, IOException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(reader, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(reader, STRowID.type, xmlOptions);
        }

        public static STRowID parse(String str) throws XmlException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(str, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(str, STRowID.type, xmlOptions);
        }

        public static STRowID parse(URL url) throws XmlException, IOException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(url, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(url, STRowID.type, xmlOptions);
        }

        public static STRowID parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STRowID.type, xmlOptions);
        }

        public static STRowID parse(Node node) throws XmlException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(node, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STRowID) XmlBeans.getContextTypeLoader().parse(node, STRowID.type, xmlOptions);
        }
    }
}
