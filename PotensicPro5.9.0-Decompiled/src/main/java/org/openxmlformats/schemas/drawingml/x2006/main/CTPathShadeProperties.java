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
import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTPathShadeProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPathShadeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpathshadeproperties7ccctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPathShadeProperties newInstance() {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().newInstance(CTPathShadeProperties.type, null);
        }

        public static CTPathShadeProperties newInstance(XmlOptions xmlOptions) {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().newInstance(CTPathShadeProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPathShadeProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(File file) throws XmlException, IOException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(file, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(file, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(Reader reader) throws XmlException, IOException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(reader, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(reader, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(String str) throws XmlException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(str, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(str, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(URL url) throws XmlException, IOException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(url, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(url, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(Node node) throws XmlException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(node, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPathShadeProperties) XmlBeans.getContextTypeLoader().parse(node, CTPathShadeProperties.type, xmlOptions);
        }
    }

    CTRelativeRect addNewFillToRect();

    CTRelativeRect getFillToRect();

    STPathShadeType.Enum getPath();

    boolean isSetFillToRect();

    boolean isSetPath();

    void setFillToRect(CTRelativeRect cTRelativeRect);

    void setPath(STPathShadeType.Enum r1);

    void unsetFillToRect();

    void unsetPath();

    STPathShadeType xgetPath();

    void xsetPath(STPathShadeType sTPathShadeType);
}
