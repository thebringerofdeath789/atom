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
public interface CTDecimalNumber extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDecimalNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdecimalnumbera518type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDecimalNumber newInstance() {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().newInstance(CTDecimalNumber.type, null);
        }

        public static CTDecimalNumber newInstance(XmlOptions xmlOptions) {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().newInstance(CTDecimalNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDecimalNumber.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(File file) throws XmlException, IOException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(file, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(file, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(inputStream, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(inputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(Reader reader) throws XmlException, IOException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(reader, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(reader, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(String str) throws XmlException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(str, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(str, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(URL url) throws XmlException, IOException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(url, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(url, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(Node node) throws XmlException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(node, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDecimalNumber) XmlBeans.getContextTypeLoader().parse(node, CTDecimalNumber.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STDecimalNumber xgetVal();

    void xsetVal(STDecimalNumber sTDecimalNumber);
}
