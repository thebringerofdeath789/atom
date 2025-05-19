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
public interface CTHeight extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHeight.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctheighta2e1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHeight newInstance() {
            return (CTHeight) XmlBeans.getContextTypeLoader().newInstance(CTHeight.type, null);
        }

        public static CTHeight newInstance(XmlOptions xmlOptions) {
            return (CTHeight) XmlBeans.getContextTypeLoader().newInstance(CTHeight.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHeight.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(File file) throws XmlException, IOException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(file, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(file, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(inputStream, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(inputStream, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(Reader reader) throws XmlException, IOException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(reader, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(reader, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(String str) throws XmlException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(str, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(str, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(URL url) throws XmlException, IOException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(url, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(url, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(Node node) throws XmlException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(node, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHeight) XmlBeans.getContextTypeLoader().parse(node, CTHeight.type, xmlOptions);
        }
    }

    STHeightRule$Enum getHRule();

    BigInteger getVal();

    boolean isSetHRule();

    boolean isSetVal();

    void setHRule(STHeightRule$Enum sTHeightRule$Enum);

    void setVal(BigInteger bigInteger);

    void unsetHRule();

    void unsetVal();

    STHeightRule xgetHRule();

    STTwipsMeasure xgetVal();

    void xsetHRule(STHeightRule sTHeightRule);

    void xsetVal(STTwipsMeasure sTTwipsMeasure);
}
