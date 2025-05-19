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
public interface CTMarkup extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMarkup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmarkup2d80type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMarkup newInstance() {
            return (CTMarkup) XmlBeans.getContextTypeLoader().newInstance(CTMarkup.type, null);
        }

        public static CTMarkup newInstance(XmlOptions xmlOptions) {
            return (CTMarkup) XmlBeans.getContextTypeLoader().newInstance(CTMarkup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMarkup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(File file) throws XmlException, IOException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(file, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(file, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(inputStream, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(inputStream, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(Reader reader) throws XmlException, IOException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(reader, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(reader, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(String str) throws XmlException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(str, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(str, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(URL url) throws XmlException, IOException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(url, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(url, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(Node node) throws XmlException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(node, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkup) XmlBeans.getContextTypeLoader().parse(node, CTMarkup.type, xmlOptions);
        }
    }

    BigInteger getId();

    void setId(BigInteger bigInteger);

    STDecimalNumber xgetId();

    void xsetId(STDecimalNumber sTDecimalNumber);
}
