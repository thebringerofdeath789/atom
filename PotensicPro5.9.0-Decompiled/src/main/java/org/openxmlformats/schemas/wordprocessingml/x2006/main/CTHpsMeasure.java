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
public interface CTHpsMeasure extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cthpsmeasure3795type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHpsMeasure newInstance() {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().newInstance(CTHpsMeasure.type, null);
        }

        public static CTHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().newInstance(CTHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHpsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(File file) throws XmlException, IOException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(file, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(file, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(Reader reader) throws XmlException, IOException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(reader, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(reader, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(String str) throws XmlException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(str, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(str, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(URL url) throws XmlException, IOException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(url, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(url, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(Node node) throws XmlException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(node, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHpsMeasure) XmlBeans.getContextTypeLoader().parse(node, CTHpsMeasure.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STHpsMeasure xgetVal();

    void xsetVal(STHpsMeasure sTHpsMeasure);
}
