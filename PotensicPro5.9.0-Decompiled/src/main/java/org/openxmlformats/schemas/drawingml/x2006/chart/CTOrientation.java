package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.chart.STOrientation;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTOrientation extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTOrientation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctorientationcb16type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOrientation newInstance() {
            return (CTOrientation) XmlBeans.getContextTypeLoader().newInstance(CTOrientation.type, null);
        }

        public static CTOrientation newInstance(XmlOptions xmlOptions) {
            return (CTOrientation) XmlBeans.getContextTypeLoader().newInstance(CTOrientation.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOrientation.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOrientation.type, xmlOptions);
        }

        public static CTOrientation parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOrientation.type, (XmlOptions) null);
        }

        public static CTOrientation parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOrientation.type, xmlOptions);
        }

        public static CTOrientation parse(File file) throws XmlException, IOException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(file, CTOrientation.type, (XmlOptions) null);
        }

        public static CTOrientation parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(file, CTOrientation.type, xmlOptions);
        }

        public static CTOrientation parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(inputStream, CTOrientation.type, (XmlOptions) null);
        }

        public static CTOrientation parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(inputStream, CTOrientation.type, xmlOptions);
        }

        public static CTOrientation parse(Reader reader) throws XmlException, IOException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(reader, CTOrientation.type, (XmlOptions) null);
        }

        public static CTOrientation parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(reader, CTOrientation.type, xmlOptions);
        }

        public static CTOrientation parse(String str) throws XmlException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(str, CTOrientation.type, (XmlOptions) null);
        }

        public static CTOrientation parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(str, CTOrientation.type, xmlOptions);
        }

        public static CTOrientation parse(URL url) throws XmlException, IOException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(url, CTOrientation.type, (XmlOptions) null);
        }

        public static CTOrientation parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(url, CTOrientation.type, xmlOptions);
        }

        public static CTOrientation parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOrientation.type, (XmlOptions) null);
        }

        public static CTOrientation parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOrientation.type, xmlOptions);
        }

        public static CTOrientation parse(Node node) throws XmlException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(node, CTOrientation.type, (XmlOptions) null);
        }

        public static CTOrientation parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOrientation) XmlBeans.getContextTypeLoader().parse(node, CTOrientation.type, xmlOptions);
        }
    }

    STOrientation.Enum getVal();

    boolean isSetVal();

    void setVal(STOrientation.Enum r1);

    void unsetVal();

    STOrientation xgetVal();

    void xsetVal(STOrientation sTOrientation);
}
