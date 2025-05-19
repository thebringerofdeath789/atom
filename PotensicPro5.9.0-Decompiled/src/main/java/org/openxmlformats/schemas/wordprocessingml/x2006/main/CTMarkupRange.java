package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTMarkupRange extends CTMarkup {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMarkupRange.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmarkuprangeba3dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTMarkupRange newInstance() {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().newInstance(CTMarkupRange.type, null);
        }

        public static CTMarkupRange newInstance(XmlOptions xmlOptions) {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().newInstance(CTMarkupRange.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMarkupRange.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(File file) throws XmlException, IOException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(file, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(file, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(inputStream, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(inputStream, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(Reader reader) throws XmlException, IOException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(reader, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(reader, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(String str) throws XmlException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(str, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(str, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(URL url) throws XmlException, IOException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(url, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(url, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(Node node) throws XmlException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(node, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkupRange) XmlBeans.getContextTypeLoader().parse(node, CTMarkupRange.type, xmlOptions);
        }
    }

    STDisplacedByCustomXml$Enum getDisplacedByCustomXml();

    boolean isSetDisplacedByCustomXml();

    void setDisplacedByCustomXml(STDisplacedByCustomXml$Enum sTDisplacedByCustomXml$Enum);

    void unsetDisplacedByCustomXml();

    STDisplacedByCustomXml xgetDisplacedByCustomXml();

    void xsetDisplacedByCustomXml(STDisplacedByCustomXml sTDisplacedByCustomXml);
}
