package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTBookmarkRange extends CTMarkupRange {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBookmarkRange.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbookmarkranged88btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBookmarkRange newInstance() {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().newInstance(CTBookmarkRange.type, null);
        }

        public static CTBookmarkRange newInstance(XmlOptions xmlOptions) {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().newInstance(CTBookmarkRange.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBookmarkRange.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(File file) throws XmlException, IOException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(file, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(file, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(inputStream, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(inputStream, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(Reader reader) throws XmlException, IOException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(reader, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(reader, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(String str) throws XmlException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(str, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(str, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(URL url) throws XmlException, IOException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(url, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(url, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(Node node) throws XmlException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(node, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBookmarkRange) XmlBeans.getContextTypeLoader().parse(node, CTBookmarkRange.type, xmlOptions);
        }
    }

    BigInteger getColFirst();

    BigInteger getColLast();

    boolean isSetColFirst();

    boolean isSetColLast();

    void setColFirst(BigInteger bigInteger);

    void setColLast(BigInteger bigInteger);

    void unsetColFirst();

    void unsetColLast();

    STDecimalNumber xgetColFirst();

    STDecimalNumber xgetColLast();

    void xsetColFirst(STDecimalNumber sTDecimalNumber);

    void xsetColLast(STDecimalNumber sTDecimalNumber);
}
