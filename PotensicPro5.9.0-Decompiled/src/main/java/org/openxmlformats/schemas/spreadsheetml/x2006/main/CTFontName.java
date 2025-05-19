package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

/* loaded from: classes6.dex */
public interface CTFontName extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFontName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfontname2dc3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontName newInstance() {
            return (CTFontName) XmlBeans.getContextTypeLoader().newInstance(CTFontName.type, null);
        }

        public static CTFontName newInstance(XmlOptions xmlOptions) {
            return (CTFontName) XmlBeans.getContextTypeLoader().newInstance(CTFontName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontName.type, xmlOptions);
        }

        public static CTFontName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontName.type, (XmlOptions) null);
        }

        public static CTFontName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontName.type, xmlOptions);
        }

        public static CTFontName parse(File file) throws XmlException, IOException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(file, CTFontName.type, (XmlOptions) null);
        }

        public static CTFontName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(file, CTFontName.type, xmlOptions);
        }

        public static CTFontName parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontName.type, (XmlOptions) null);
        }

        public static CTFontName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontName.type, xmlOptions);
        }

        public static CTFontName parse(Reader reader) throws XmlException, IOException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(reader, CTFontName.type, (XmlOptions) null);
        }

        public static CTFontName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(reader, CTFontName.type, xmlOptions);
        }

        public static CTFontName parse(String str) throws XmlException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(str, CTFontName.type, (XmlOptions) null);
        }

        public static CTFontName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(str, CTFontName.type, xmlOptions);
        }

        public static CTFontName parse(URL url) throws XmlException, IOException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(url, CTFontName.type, (XmlOptions) null);
        }

        public static CTFontName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(url, CTFontName.type, xmlOptions);
        }

        public static CTFontName parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontName.type, (XmlOptions) null);
        }

        public static CTFontName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontName.type, xmlOptions);
        }

        public static CTFontName parse(Node node) throws XmlException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(node, CTFontName.type, (XmlOptions) null);
        }

        public static CTFontName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFontName) XmlBeans.getContextTypeLoader().parse(node, CTFontName.type, xmlOptions);
        }
    }

    String getVal();

    void setVal(String str);

    STXstring xgetVal();

    void xsetVal(STXstring sTXstring);
}
