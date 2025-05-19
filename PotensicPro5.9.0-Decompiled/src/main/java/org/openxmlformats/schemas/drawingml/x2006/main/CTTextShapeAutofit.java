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
public interface CTTextShapeAutofit extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextShapeAutofit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextshapeautofita009type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextShapeAutofit newInstance() {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().newInstance(CTTextShapeAutofit.type, null);
        }

        public static CTTextShapeAutofit newInstance(XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().newInstance(CTTextShapeAutofit.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextShapeAutofit.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(File file) throws XmlException, IOException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(file, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(file, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(Reader reader) throws XmlException, IOException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(reader, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(reader, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(String str) throws XmlException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(str, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(str, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(URL url) throws XmlException, IOException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(url, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(url, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(Node node) throws XmlException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(node, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextShapeAutofit) XmlBeans.getContextTypeLoader().parse(node, CTTextShapeAutofit.type, xmlOptions);
        }
    }
}
