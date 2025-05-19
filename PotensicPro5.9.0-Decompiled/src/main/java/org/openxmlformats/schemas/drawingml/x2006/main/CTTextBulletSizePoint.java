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
public interface CTTextBulletSizePoint extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextBulletSizePoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextbulletsizepointe4f1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBulletSizePoint newInstance() {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().newInstance(CTTextBulletSizePoint.type, null);
        }

        public static CTTextBulletSizePoint newInstance(XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().newInstance(CTTextBulletSizePoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePoint.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(File file) throws XmlException, IOException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(file, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(file, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(Reader reader) throws XmlException, IOException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(reader, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(reader, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(String str) throws XmlException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(str, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(str, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(URL url) throws XmlException, IOException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(url, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(url, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(Node node) throws XmlException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(node, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePoint) XmlBeans.getContextTypeLoader().parse(node, CTTextBulletSizePoint.type, xmlOptions);
        }
    }

    int getVal();

    boolean isSetVal();

    void setVal(int i);

    void unsetVal();

    STTextFontSize xgetVal();

    void xsetVal(STTextFontSize sTTextFontSize);
}
