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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalAlignRun;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTVerticalAlignRun extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTVerticalAlignRun.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctverticalalignruncb8ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTVerticalAlignRun newInstance() {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().newInstance(CTVerticalAlignRun.type, null);
        }

        public static CTVerticalAlignRun newInstance(XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().newInstance(CTVerticalAlignRun.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVerticalAlignRun.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(File file) throws XmlException, IOException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(file, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(file, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(inputStream, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(inputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(Reader reader) throws XmlException, IOException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(reader, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(reader, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(String str) throws XmlException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(str, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(str, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(URL url) throws XmlException, IOException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(url, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(url, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(Node node) throws XmlException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(node, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignRun) XmlBeans.getContextTypeLoader().parse(node, CTVerticalAlignRun.type, xmlOptions);
        }
    }

    STVerticalAlignRun.Enum getVal();

    void setVal(STVerticalAlignRun.Enum r1);

    STVerticalAlignRun xgetVal();

    void xsetVal(STVerticalAlignRun sTVerticalAlignRun);
}
