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
public interface CTStretchInfoProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTStretchInfoProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctstretchinfopropertiesde57type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStretchInfoProperties newInstance() {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().newInstance(CTStretchInfoProperties.type, null);
        }

        public static CTStretchInfoProperties newInstance(XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().newInstance(CTStretchInfoProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStretchInfoProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(File file) throws XmlException, IOException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(file, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(file, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(Reader reader) throws XmlException, IOException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(reader, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(reader, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(String str) throws XmlException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(str, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(str, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(URL url) throws XmlException, IOException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(url, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(url, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(Node node) throws XmlException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(node, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStretchInfoProperties) XmlBeans.getContextTypeLoader().parse(node, CTStretchInfoProperties.type, xmlOptions);
        }
    }

    CTRelativeRect addNewFillRect();

    CTRelativeRect getFillRect();

    boolean isSetFillRect();

    void setFillRect(CTRelativeRect cTRelativeRect);

    void unsetFillRect();
}
