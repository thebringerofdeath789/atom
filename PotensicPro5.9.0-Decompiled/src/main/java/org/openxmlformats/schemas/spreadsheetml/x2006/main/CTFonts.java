package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTFonts extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFonts.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfonts6623type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFonts newInstance() {
            return (CTFonts) XmlBeans.getContextTypeLoader().newInstance(CTFonts.type, null);
        }

        public static CTFonts newInstance(XmlOptions xmlOptions) {
            return (CTFonts) XmlBeans.getContextTypeLoader().newInstance(CTFonts.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFonts.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(File file) throws XmlException, IOException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(file, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(file, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(inputStream, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(inputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(Reader reader) throws XmlException, IOException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(reader, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(reader, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(String str) throws XmlException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(str, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(str, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(URL url) throws XmlException, IOException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(url, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(url, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(Node node) throws XmlException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(node, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFonts) XmlBeans.getContextTypeLoader().parse(node, CTFonts.type, xmlOptions);
        }
    }

    CTFont addNewFont();

    long getCount();

    CTFont getFontArray(int i);

    CTFont[] getFontArray();

    List<CTFont> getFontList();

    CTFont insertNewFont(int i);

    boolean isSetCount();

    void removeFont(int i);

    void setCount(long j);

    void setFontArray(int i, CTFont cTFont);

    void setFontArray(CTFont[] cTFontArr);

    int sizeOfFontArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
