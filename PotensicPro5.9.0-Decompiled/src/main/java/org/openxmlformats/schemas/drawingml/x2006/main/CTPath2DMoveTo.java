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
public interface CTPath2DMoveTo extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPath2DMoveTo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpath2dmovetoa01etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DMoveTo newInstance() {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().newInstance(CTPath2DMoveTo.type, null);
        }

        public static CTPath2DMoveTo newInstance(XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().newInstance(CTPath2DMoveTo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DMoveTo.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(File file) throws XmlException, IOException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(file, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(file, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(String str) throws XmlException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(str, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(str, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(URL url) throws XmlException, IOException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(url, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(url, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(Node node) throws XmlException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(node, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DMoveTo) XmlBeans.getContextTypeLoader().parse(node, CTPath2DMoveTo.type, xmlOptions);
        }
    }

    CTAdjPoint2D addNewPt();

    CTAdjPoint2D getPt();

    void setPt(CTAdjPoint2D cTAdjPoint2D);
}
