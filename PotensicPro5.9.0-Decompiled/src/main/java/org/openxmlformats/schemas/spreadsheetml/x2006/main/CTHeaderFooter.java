package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTHeaderFooter extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHeaderFooter.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctheaderfooter90d1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHeaderFooter newInstance() {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().newInstance(CTHeaderFooter.type, null);
        }

        public static CTHeaderFooter newInstance(XmlOptions xmlOptions) {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().newInstance(CTHeaderFooter.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHeaderFooter.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHeaderFooter.type, xmlOptions);
        }

        public static CTHeaderFooter parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHeaderFooter.type, (XmlOptions) null);
        }

        public static CTHeaderFooter parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHeaderFooter.type, xmlOptions);
        }

        public static CTHeaderFooter parse(File file) throws XmlException, IOException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(file, CTHeaderFooter.type, (XmlOptions) null);
        }

        public static CTHeaderFooter parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(file, CTHeaderFooter.type, xmlOptions);
        }

        public static CTHeaderFooter parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(inputStream, CTHeaderFooter.type, (XmlOptions) null);
        }

        public static CTHeaderFooter parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(inputStream, CTHeaderFooter.type, xmlOptions);
        }

        public static CTHeaderFooter parse(Reader reader) throws XmlException, IOException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(reader, CTHeaderFooter.type, (XmlOptions) null);
        }

        public static CTHeaderFooter parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(reader, CTHeaderFooter.type, xmlOptions);
        }

        public static CTHeaderFooter parse(String str) throws XmlException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(str, CTHeaderFooter.type, (XmlOptions) null);
        }

        public static CTHeaderFooter parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(str, CTHeaderFooter.type, xmlOptions);
        }

        public static CTHeaderFooter parse(URL url) throws XmlException, IOException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(url, CTHeaderFooter.type, (XmlOptions) null);
        }

        public static CTHeaderFooter parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(url, CTHeaderFooter.type, xmlOptions);
        }

        public static CTHeaderFooter parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHeaderFooter.type, (XmlOptions) null);
        }

        public static CTHeaderFooter parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHeaderFooter.type, xmlOptions);
        }

        public static CTHeaderFooter parse(Node node) throws XmlException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(node, CTHeaderFooter.type, (XmlOptions) null);
        }

        public static CTHeaderFooter parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHeaderFooter) XmlBeans.getContextTypeLoader().parse(node, CTHeaderFooter.type, xmlOptions);
        }
    }

    boolean getAlignWithMargins();

    boolean getDifferentFirst();

    boolean getDifferentOddEven();

    String getEvenFooter();

    String getEvenHeader();

    String getFirstFooter();

    String getFirstHeader();

    String getOddFooter();

    String getOddHeader();

    boolean getScaleWithDoc();

    boolean isSetAlignWithMargins();

    boolean isSetDifferentFirst();

    boolean isSetDifferentOddEven();

    boolean isSetEvenFooter();

    boolean isSetEvenHeader();

    boolean isSetFirstFooter();

    boolean isSetFirstHeader();

    boolean isSetOddFooter();

    boolean isSetOddHeader();

    boolean isSetScaleWithDoc();

    void setAlignWithMargins(boolean z);

    void setDifferentFirst(boolean z);

    void setDifferentOddEven(boolean z);

    void setEvenFooter(String str);

    void setEvenHeader(String str);

    void setFirstFooter(String str);

    void setFirstHeader(String str);

    void setOddFooter(String str);

    void setOddHeader(String str);

    void setScaleWithDoc(boolean z);

    void unsetAlignWithMargins();

    void unsetDifferentFirst();

    void unsetDifferentOddEven();

    void unsetEvenFooter();

    void unsetEvenHeader();

    void unsetFirstFooter();

    void unsetFirstHeader();

    void unsetOddFooter();

    void unsetOddHeader();

    void unsetScaleWithDoc();

    XmlBoolean xgetAlignWithMargins();

    XmlBoolean xgetDifferentFirst();

    XmlBoolean xgetDifferentOddEven();

    STXstring xgetEvenFooter();

    STXstring xgetEvenHeader();

    STXstring xgetFirstFooter();

    STXstring xgetFirstHeader();

    STXstring xgetOddFooter();

    STXstring xgetOddHeader();

    XmlBoolean xgetScaleWithDoc();

    void xsetAlignWithMargins(XmlBoolean xmlBoolean);

    void xsetDifferentFirst(XmlBoolean xmlBoolean);

    void xsetDifferentOddEven(XmlBoolean xmlBoolean);

    void xsetEvenFooter(STXstring sTXstring);

    void xsetEvenHeader(STXstring sTXstring);

    void xsetFirstFooter(STXstring sTXstring);

    void xsetFirstHeader(STXstring sTXstring);

    void xsetOddFooter(STXstring sTXstring);

    void xsetOddHeader(STXstring sTXstring);

    void xsetScaleWithDoc(XmlBoolean xmlBoolean);
}
