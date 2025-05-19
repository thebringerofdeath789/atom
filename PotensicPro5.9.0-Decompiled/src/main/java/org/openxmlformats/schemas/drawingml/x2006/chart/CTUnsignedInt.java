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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTUnsignedInt extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTUnsignedInt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctunsignedinte8ectype");

    public static final class Factory {
        private Factory() {
        }

        public static CTUnsignedInt newInstance() {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().newInstance(CTUnsignedInt.type, null);
        }

        public static CTUnsignedInt newInstance(XmlOptions xmlOptions) {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().newInstance(CTUnsignedInt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTUnsignedInt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(File file) throws XmlException, IOException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(file, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(file, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(InputStream inputStream) throws XmlException, IOException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(inputStream, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(inputStream, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(Reader reader) throws XmlException, IOException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(reader, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(reader, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(String str) throws XmlException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(str, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(str, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(URL url) throws XmlException, IOException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(url, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(url, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(Node node) throws XmlException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(node, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTUnsignedInt) XmlBeans.getContextTypeLoader().parse(node, CTUnsignedInt.type, xmlOptions);
        }
    }

    long getVal();

    void setVal(long j);

    XmlUnsignedInt xgetVal();

    void xsetVal(XmlUnsignedInt xmlUnsignedInt);
}
