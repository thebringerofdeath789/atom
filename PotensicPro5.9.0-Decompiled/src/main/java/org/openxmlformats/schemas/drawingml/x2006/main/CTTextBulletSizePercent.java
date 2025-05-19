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
public interface CTTextBulletSizePercent extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextBulletSizePercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextbulletsizepercent9b26type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBulletSizePercent newInstance() {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().newInstance(CTTextBulletSizePercent.type, null);
        }

        public static CTTextBulletSizePercent newInstance(XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().newInstance(CTTextBulletSizePercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(File file) throws XmlException, IOException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(file, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(file, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(Reader reader) throws XmlException, IOException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(reader, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(reader, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(String str) throws XmlException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(str, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(str, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(URL url) throws XmlException, IOException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(url, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(url, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(Node node) throws XmlException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(node, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(node, CTTextBulletSizePercent.type, xmlOptions);
        }
    }

    int getVal();

    boolean isSetVal();

    void setVal(int i);

    void unsetVal();

    STTextBulletSizePercent xgetVal();

    void xsetVal(STTextBulletSizePercent sTTextBulletSizePercent);
}
