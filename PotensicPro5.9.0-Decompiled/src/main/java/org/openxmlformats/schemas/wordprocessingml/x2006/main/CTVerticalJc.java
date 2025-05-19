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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTVerticalJc extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTVerticalJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctverticaljca439type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVerticalJc newInstance() {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().newInstance(CTVerticalJc.type, null);
        }

        public static CTVerticalJc newInstance(XmlOptions xmlOptions) {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().newInstance(CTVerticalJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVerticalJc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(File file) throws XmlException, IOException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(file, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(file, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(inputStream, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(inputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(Reader reader) throws XmlException, IOException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(reader, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(reader, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(String str) throws XmlException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(str, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(str, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(URL url) throws XmlException, IOException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(url, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(url, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(Node node) throws XmlException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(node, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalJc) XmlBeans.getContextTypeLoader().parse(node, CTVerticalJc.type, xmlOptions);
        }
    }

    STVerticalJc.Enum getVal();

    void setVal(STVerticalJc.Enum r1);

    STVerticalJc xgetVal();

    void xsetVal(STVerticalJc sTVerticalJc);
}
