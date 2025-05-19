package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface STTextLanguageID extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextLanguageID.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextlanguageid806btype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextLanguageID newInstance() {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().newInstance(STTextLanguageID.type, null);
        }

        public static STTextLanguageID newInstance(XmlOptions xmlOptions) {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().newInstance(STTextLanguageID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextLanguageID.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID newValue(Object obj) {
            return (STTextLanguageID) STTextLanguageID.type.newValue(obj);
        }

        public static STTextLanguageID parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(File file) throws XmlException, IOException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(file, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(file, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(inputStream, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(inputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(Reader reader) throws XmlException, IOException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(reader, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(reader, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(String str) throws XmlException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(str, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(str, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(URL url) throws XmlException, IOException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(url, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(url, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(Node node) throws XmlException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(node, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextLanguageID) XmlBeans.getContextTypeLoader().parse(node, STTextLanguageID.type, xmlOptions);
        }
    }
}
