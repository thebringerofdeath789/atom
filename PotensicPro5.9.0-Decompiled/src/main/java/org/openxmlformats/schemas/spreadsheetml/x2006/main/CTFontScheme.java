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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontScheme;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTFontScheme extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFontScheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfontschemebf5dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontScheme newInstance() {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().newInstance(CTFontScheme.type, null);
        }

        public static CTFontScheme newInstance(XmlOptions xmlOptions) {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().newInstance(CTFontScheme.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontScheme.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(File file) throws XmlException, IOException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(file, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(file, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(Reader reader) throws XmlException, IOException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(reader, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(reader, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(String str) throws XmlException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(str, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(str, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(URL url) throws XmlException, IOException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(url, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(url, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(Node node) throws XmlException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(node, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFontScheme) XmlBeans.getContextTypeLoader().parse(node, CTFontScheme.type, xmlOptions);
        }
    }

    STFontScheme.Enum getVal();

    void setVal(STFontScheme.Enum r1);

    STFontScheme xgetVal();

    void xsetVal(STFontScheme sTFontScheme);
}
