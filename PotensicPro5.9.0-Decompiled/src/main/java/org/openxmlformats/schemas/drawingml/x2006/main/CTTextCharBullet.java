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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTextCharBullet extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextCharBullet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextcharbullet3c20type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextCharBullet newInstance() {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().newInstance(CTTextCharBullet.type, null);
        }

        public static CTTextCharBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().newInstance(CTTextCharBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextCharBullet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(File file) throws XmlException, IOException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(file, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(file, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(Reader reader) throws XmlException, IOException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(reader, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(reader, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(String str) throws XmlException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(str, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(str, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(URL url) throws XmlException, IOException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(url, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(url, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(Node node) throws XmlException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(node, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharBullet) XmlBeans.getContextTypeLoader().parse(node, CTTextCharBullet.type, xmlOptions);
        }
    }

    String getChar();

    void setChar(String str);

    XmlString xgetChar();

    void xsetChar(XmlString xmlString);
}
