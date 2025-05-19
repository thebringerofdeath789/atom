package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTLinearShadeProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLinearShadeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlinearshadeproperties7f0ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLinearShadeProperties newInstance() {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().newInstance(CTLinearShadeProperties.type, null);
        }

        public static CTLinearShadeProperties newInstance(XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().newInstance(CTLinearShadeProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLinearShadeProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(File file) throws XmlException, IOException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(file, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(file, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(Reader reader) throws XmlException, IOException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(reader, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(reader, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(String str) throws XmlException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(str, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(str, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(URL url) throws XmlException, IOException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(url, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(url, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(Node node) throws XmlException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(node, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLinearShadeProperties) XmlBeans.getContextTypeLoader().parse(node, CTLinearShadeProperties.type, xmlOptions);
        }
    }

    int getAng();

    boolean getScaled();

    boolean isSetAng();

    boolean isSetScaled();

    void setAng(int i);

    void setScaled(boolean z);

    void unsetAng();

    void unsetScaled();

    STPositiveFixedAngle xgetAng();

    XmlBoolean xgetScaled();

    void xsetAng(STPositiveFixedAngle sTPositiveFixedAngle);

    void xsetScaled(XmlBoolean xmlBoolean);
}
