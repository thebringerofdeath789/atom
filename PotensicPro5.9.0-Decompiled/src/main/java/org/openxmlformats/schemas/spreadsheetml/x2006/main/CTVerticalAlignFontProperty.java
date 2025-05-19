package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignRun;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTVerticalAlignFontProperty extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTVerticalAlignFontProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctverticalalignfontproperty89f2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVerticalAlignFontProperty newInstance() {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().newInstance(CTVerticalAlignFontProperty.type, null);
        }

        public static CTVerticalAlignFontProperty newInstance(XmlOptions xmlOptions) {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().newInstance(CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVerticalAlignFontProperty.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static CTVerticalAlignFontProperty parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVerticalAlignFontProperty.type, (XmlOptions) null);
        }

        public static CTVerticalAlignFontProperty parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static CTVerticalAlignFontProperty parse(File file) throws XmlException, IOException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(file, CTVerticalAlignFontProperty.type, (XmlOptions) null);
        }

        public static CTVerticalAlignFontProperty parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(file, CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static CTVerticalAlignFontProperty parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(inputStream, CTVerticalAlignFontProperty.type, (XmlOptions) null);
        }

        public static CTVerticalAlignFontProperty parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(inputStream, CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static CTVerticalAlignFontProperty parse(Reader reader) throws XmlException, IOException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(reader, CTVerticalAlignFontProperty.type, (XmlOptions) null);
        }

        public static CTVerticalAlignFontProperty parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(reader, CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static CTVerticalAlignFontProperty parse(String str) throws XmlException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(str, CTVerticalAlignFontProperty.type, (XmlOptions) null);
        }

        public static CTVerticalAlignFontProperty parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(str, CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static CTVerticalAlignFontProperty parse(URL url) throws XmlException, IOException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(url, CTVerticalAlignFontProperty.type, (XmlOptions) null);
        }

        public static CTVerticalAlignFontProperty parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(url, CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static CTVerticalAlignFontProperty parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVerticalAlignFontProperty.type, (XmlOptions) null);
        }

        public static CTVerticalAlignFontProperty parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVerticalAlignFontProperty.type, xmlOptions);
        }

        public static CTVerticalAlignFontProperty parse(Node node) throws XmlException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(node, CTVerticalAlignFontProperty.type, (XmlOptions) null);
        }

        public static CTVerticalAlignFontProperty parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignFontProperty) XmlBeans.getContextTypeLoader().parse(node, CTVerticalAlignFontProperty.type, xmlOptions);
        }
    }

    STVerticalAlignRun.Enum getVal();

    void setVal(STVerticalAlignRun.Enum r1);

    STVerticalAlignRun xgetVal();

    void xsetVal(STVerticalAlignRun sTVerticalAlignRun);
}
