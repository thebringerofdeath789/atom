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
public interface CTTextNoAutofit extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextNoAutofit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextnoautofit1045type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextNoAutofit newInstance() {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().newInstance(CTTextNoAutofit.type, null);
        }

        public static CTTextNoAutofit newInstance(XmlOptions xmlOptions) {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().newInstance(CTTextNoAutofit.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextNoAutofit.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(File file) throws XmlException, IOException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(file, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(file, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(Reader reader) throws XmlException, IOException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(reader, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(reader, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(String str) throws XmlException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(str, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(str, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(URL url) throws XmlException, IOException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(url, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(url, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(Node node) throws XmlException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(node, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoAutofit) XmlBeans.getContextTypeLoader().parse(node, CTTextNoAutofit.type, xmlOptions);
        }
    }
}
