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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTZoom extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTZoom.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctzoomc275type");

    public static final class Factory {
        private Factory() {
        }

        public static CTZoom newInstance() {
            return (CTZoom) XmlBeans.getContextTypeLoader().newInstance(CTZoom.type, null);
        }

        public static CTZoom newInstance(XmlOptions xmlOptions) {
            return (CTZoom) XmlBeans.getContextTypeLoader().newInstance(CTZoom.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTZoom.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(File file) throws XmlException, IOException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(file, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(file, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(InputStream inputStream) throws XmlException, IOException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(inputStream, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(inputStream, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(Reader reader) throws XmlException, IOException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(reader, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(reader, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(String str) throws XmlException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(str, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(str, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(URL url) throws XmlException, IOException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(url, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(url, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTZoom.type, xmlOptions);
        }

        public static CTZoom parse(Node node) throws XmlException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(node, CTZoom.type, (XmlOptions) null);
        }

        public static CTZoom parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTZoom) XmlBeans.getContextTypeLoader().parse(node, CTZoom.type, xmlOptions);
        }
    }

    BigInteger getPercent();

    STZoom$Enum getVal();

    boolean isSetVal();

    void setPercent(BigInteger bigInteger);

    void setVal(STZoom$Enum sTZoom$Enum);

    void unsetVal();

    STDecimalNumber xgetPercent();

    STZoom xgetVal();

    void xsetPercent(STDecimalNumber sTDecimalNumber);

    void xsetVal(STZoom sTZoom);
}
