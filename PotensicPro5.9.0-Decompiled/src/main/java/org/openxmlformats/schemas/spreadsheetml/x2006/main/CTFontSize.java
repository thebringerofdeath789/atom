package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTFontSize extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFontSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfontsizeb3b9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontSize newInstance() {
            return (CTFontSize) XmlBeans.getContextTypeLoader().newInstance(CTFontSize.type, null);
        }

        public static CTFontSize newInstance(XmlOptions xmlOptions) {
            return (CTFontSize) XmlBeans.getContextTypeLoader().newInstance(CTFontSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontSize.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontSize.type, xmlOptions);
        }

        public static CTFontSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontSize.type, (XmlOptions) null);
        }

        public static CTFontSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontSize.type, xmlOptions);
        }

        public static CTFontSize parse(File file) throws XmlException, IOException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(file, CTFontSize.type, (XmlOptions) null);
        }

        public static CTFontSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(file, CTFontSize.type, xmlOptions);
        }

        public static CTFontSize parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontSize.type, (XmlOptions) null);
        }

        public static CTFontSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontSize.type, xmlOptions);
        }

        public static CTFontSize parse(Reader reader) throws XmlException, IOException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(reader, CTFontSize.type, (XmlOptions) null);
        }

        public static CTFontSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(reader, CTFontSize.type, xmlOptions);
        }

        public static CTFontSize parse(String str) throws XmlException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(str, CTFontSize.type, (XmlOptions) null);
        }

        public static CTFontSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(str, CTFontSize.type, xmlOptions);
        }

        public static CTFontSize parse(URL url) throws XmlException, IOException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(url, CTFontSize.type, (XmlOptions) null);
        }

        public static CTFontSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(url, CTFontSize.type, xmlOptions);
        }

        public static CTFontSize parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontSize.type, (XmlOptions) null);
        }

        public static CTFontSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontSize.type, xmlOptions);
        }

        public static CTFontSize parse(Node node) throws XmlException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(node, CTFontSize.type, (XmlOptions) null);
        }

        public static CTFontSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFontSize) XmlBeans.getContextTypeLoader().parse(node, CTFontSize.type, xmlOptions);
        }
    }

    double getVal();

    void setVal(double d);

    XmlDouble xgetVal();

    void xsetVal(XmlDouble xmlDouble);
}
