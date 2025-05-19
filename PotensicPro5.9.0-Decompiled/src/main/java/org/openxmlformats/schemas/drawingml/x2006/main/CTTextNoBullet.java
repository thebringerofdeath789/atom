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
public interface CTTextNoBullet extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextNoBullet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextnobulleta08btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextNoBullet newInstance() {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().newInstance(CTTextNoBullet.type, null);
        }

        public static CTTextNoBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().newInstance(CTTextNoBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextNoBullet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(File file) throws XmlException, IOException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(file, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(file, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(Reader reader) throws XmlException, IOException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(reader, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(reader, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(String str) throws XmlException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(str, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(str, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(URL url) throws XmlException, IOException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(url, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(url, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(Node node) throws XmlException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(node, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoBullet) XmlBeans.getContextTypeLoader().parse(node, CTTextNoBullet.type, xmlOptions);
        }
    }
}
