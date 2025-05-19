package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTextFont extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextFont.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextfont92b7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextFont newInstance() {
            return (CTTextFont) XmlBeans.getContextTypeLoader().newInstance(CTTextFont.type, null);
        }

        public static CTTextFont newInstance(XmlOptions xmlOptions) {
            return (CTTextFont) XmlBeans.getContextTypeLoader().newInstance(CTTextFont.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextFont.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(File file) throws XmlException, IOException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(file, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(file, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(Reader reader) throws XmlException, IOException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(reader, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(reader, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(String str) throws XmlException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(str, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(str, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(URL url) throws XmlException, IOException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(url, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(url, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(Node node) throws XmlException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(node, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextFont) XmlBeans.getContextTypeLoader().parse(node, CTTextFont.type, xmlOptions);
        }
    }

    byte getCharset();

    byte[] getPanose();

    byte getPitchFamily();

    String getTypeface();

    boolean isSetCharset();

    boolean isSetPanose();

    boolean isSetPitchFamily();

    boolean isSetTypeface();

    void setCharset(byte b);

    void setPanose(byte[] bArr);

    void setPitchFamily(byte b);

    void setTypeface(String str);

    void unsetCharset();

    void unsetPanose();

    void unsetPitchFamily();

    void unsetTypeface();

    XmlByte xgetCharset();

    STPanose xgetPanose();

    XmlByte xgetPitchFamily();

    STTextTypeface xgetTypeface();

    void xsetCharset(XmlByte xmlByte);

    void xsetPanose(STPanose sTPanose);

    void xsetPitchFamily(XmlByte xmlByte);

    void xsetTypeface(STTextTypeface sTTextTypeface);
}
