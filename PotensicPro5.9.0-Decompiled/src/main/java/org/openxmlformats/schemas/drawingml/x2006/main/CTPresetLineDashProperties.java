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
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTPresetLineDashProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPresetLineDashProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpresetlinedashproperties4553type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPresetLineDashProperties newInstance() {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().newInstance(CTPresetLineDashProperties.type, null);
        }

        public static CTPresetLineDashProperties newInstance(XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().newInstance(CTPresetLineDashProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPresetLineDashProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(File file) throws XmlException, IOException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(file, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(file, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(Reader reader) throws XmlException, IOException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(reader, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(reader, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(String str) throws XmlException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(str, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(str, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(URL url) throws XmlException, IOException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(url, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(url, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(Node node) throws XmlException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(node, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetLineDashProperties) XmlBeans.getContextTypeLoader().parse(node, CTPresetLineDashProperties.type, xmlOptions);
        }
    }

    STPresetLineDashVal.Enum getVal();

    boolean isSetVal();

    void setVal(STPresetLineDashVal.Enum r1);

    void unsetVal();

    STPresetLineDashVal xgetVal();

    void xsetVal(STPresetLineDashVal sTPresetLineDashVal);
}
