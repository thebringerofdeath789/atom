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
public interface STColID extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STColID.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stcolidb7f5type");

    public static final class Factory {
        private Factory() {
        }

        public static STColID newInstance() {
            return (STColID) XmlBeans.getContextTypeLoader().newInstance(STColID.type, null);
        }

        public static STColID newInstance(XmlOptions xmlOptions) {
            return (STColID) XmlBeans.getContextTypeLoader().newInstance(STColID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STColID.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STColID.type, xmlOptions);
        }

        public static STColID newValue(Object obj) {
            return (STColID) STColID.type.newValue(obj);
        }

        public static STColID parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STColID.type, (XmlOptions) null);
        }

        public static STColID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STColID.type, xmlOptions);
        }

        public static STColID parse(File file) throws XmlException, IOException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(file, STColID.type, (XmlOptions) null);
        }

        public static STColID parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(file, STColID.type, xmlOptions);
        }

        public static STColID parse(InputStream inputStream) throws XmlException, IOException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(inputStream, STColID.type, (XmlOptions) null);
        }

        public static STColID parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(inputStream, STColID.type, xmlOptions);
        }

        public static STColID parse(Reader reader) throws XmlException, IOException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(reader, STColID.type, (XmlOptions) null);
        }

        public static STColID parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(reader, STColID.type, xmlOptions);
        }

        public static STColID parse(String str) throws XmlException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(str, STColID.type, (XmlOptions) null);
        }

        public static STColID parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(str, STColID.type, xmlOptions);
        }

        public static STColID parse(URL url) throws XmlException, IOException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(url, STColID.type, (XmlOptions) null);
        }

        public static STColID parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(url, STColID.type, xmlOptions);
        }

        public static STColID parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STColID.type, (XmlOptions) null);
        }

        public static STColID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STColID.type, xmlOptions);
        }

        public static STColID parse(Node node) throws XmlException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(node, STColID.type, (XmlOptions) null);
        }

        public static STColID parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STColID) XmlBeans.getContextTypeLoader().parse(node, STColID.type, xmlOptions);
        }
    }
}
