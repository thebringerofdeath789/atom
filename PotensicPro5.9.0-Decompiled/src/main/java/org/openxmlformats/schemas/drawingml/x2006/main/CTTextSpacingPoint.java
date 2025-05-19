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
public interface CTTextSpacingPoint extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextSpacingPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextspacingpoint6cf5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextSpacingPoint newInstance() {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().newInstance(CTTextSpacingPoint.type, null);
        }

        public static CTTextSpacingPoint newInstance(XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().newInstance(CTTextSpacingPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPoint.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(File file) throws XmlException, IOException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(file, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(file, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(Reader reader) throws XmlException, IOException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(reader, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(reader, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(String str) throws XmlException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(str, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(str, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(URL url) throws XmlException, IOException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(url, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(url, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(Node node) throws XmlException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(node, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPoint) XmlBeans.getContextTypeLoader().parse(node, CTTextSpacingPoint.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STTextSpacingPoint xgetVal();

    void xsetVal(STTextSpacingPoint sTTextSpacingPoint);
}
