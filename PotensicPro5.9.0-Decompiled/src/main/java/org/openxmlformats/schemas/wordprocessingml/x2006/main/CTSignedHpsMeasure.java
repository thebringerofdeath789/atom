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
public interface CTSignedHpsMeasure extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSignedHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsignedhpsmeasure3099type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSignedHpsMeasure newInstance() {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().newInstance(CTSignedHpsMeasure.type, null);
        }

        public static CTSignedHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().newInstance(CTSignedHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSignedHpsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(File file) throws XmlException, IOException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(file, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(file, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(Reader reader) throws XmlException, IOException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(reader, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(reader, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(String str) throws XmlException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(str, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(str, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(URL url) throws XmlException, IOException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(url, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(url, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(Node node) throws XmlException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(node, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(node, CTSignedHpsMeasure.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STSignedHpsMeasure xgetVal();

    void xsetVal(STSignedHpsMeasure sTSignedHpsMeasure);
}
