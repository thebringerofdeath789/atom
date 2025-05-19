package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface SettingsDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SettingsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("settings9dd1doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SettingsDocument newInstance() {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().newInstance(SettingsDocument.type, null);
        }

        public static SettingsDocument newInstance(XmlOptions xmlOptions) {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().newInstance(SettingsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SettingsDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(File file) throws XmlException, IOException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(file, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(file, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(Reader reader) throws XmlException, IOException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(reader, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(reader, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(String str) throws XmlException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(str, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(str, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(URL url) throws XmlException, IOException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(url, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(url, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(Node node) throws XmlException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(node, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SettingsDocument) XmlBeans.getContextTypeLoader().parse(node, SettingsDocument.type, xmlOptions);
        }
    }

    CTSettings addNewSettings();

    CTSettings getSettings();

    void setSettings(CTSettings cTSettings);
}
