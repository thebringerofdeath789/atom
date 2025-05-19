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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTTextAlignment extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextalignment495ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextAlignment newInstance() {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().newInstance(CTTextAlignment.type, null);
        }

        public static CTTextAlignment newInstance(XmlOptions xmlOptions) {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().newInstance(CTTextAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextAlignment.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(File file) throws XmlException, IOException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(file, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(file, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(Reader reader) throws XmlException, IOException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(reader, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(reader, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(String str) throws XmlException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(str, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(str, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(URL url) throws XmlException, IOException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(url, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(url, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(Node node) throws XmlException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(node, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAlignment) XmlBeans.getContextTypeLoader().parse(node, CTTextAlignment.type, xmlOptions);
        }
    }

    STTextAlignment.Enum getVal();

    void setVal(STTextAlignment.Enum r1);

    STTextAlignment xgetVal();

    void xsetVal(STTextAlignment sTTextAlignment);
}
