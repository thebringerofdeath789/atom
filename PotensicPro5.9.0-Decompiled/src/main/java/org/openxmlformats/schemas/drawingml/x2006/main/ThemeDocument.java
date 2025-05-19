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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface ThemeDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(ThemeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("themefd26doctype");

    public static final class Factory {
        private Factory() {
        }

        public static ThemeDocument newInstance() {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().newInstance(ThemeDocument.type, null);
        }

        public static ThemeDocument newInstance(XmlOptions xmlOptions) {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().newInstance(ThemeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ThemeDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(File file) throws XmlException, IOException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(file, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(file, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(Reader reader) throws XmlException, IOException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(reader, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(reader, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(String str) throws XmlException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(str, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(str, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(URL url) throws XmlException, IOException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(url, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(url, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(Node node) throws XmlException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(node, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ThemeDocument) XmlBeans.getContextTypeLoader().parse(node, ThemeDocument.type, xmlOptions);
        }
    }

    CTOfficeStyleSheet addNewTheme();

    CTOfficeStyleSheet getTheme();

    void setTheme(CTOfficeStyleSheet cTOfficeStyleSheet);
}
