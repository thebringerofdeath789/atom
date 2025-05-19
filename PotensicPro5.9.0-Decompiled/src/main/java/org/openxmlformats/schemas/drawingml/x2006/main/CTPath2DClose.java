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
public interface CTPath2DClose extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPath2DClose.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpath2dclose09f2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DClose newInstance() {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().newInstance(CTPath2DClose.type, null);
        }

        public static CTPath2DClose newInstance(XmlOptions xmlOptions) {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().newInstance(CTPath2DClose.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DClose.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(File file) throws XmlException, IOException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(file, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(file, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(String str) throws XmlException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(str, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(str, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(URL url) throws XmlException, IOException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(url, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(url, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(Node node) throws XmlException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(node, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DClose) XmlBeans.getContextTypeLoader().parse(node, CTPath2DClose.type, xmlOptions);
        }
    }
}
