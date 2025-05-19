package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTextSpacingPercent extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextSpacingPercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextspacingpercent322atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextSpacingPercent newInstance() {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().newInstance(CTTextSpacingPercent.type, null);
        }

        public static CTTextSpacingPercent newInstance(XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().newInstance(CTTextSpacingPercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(File file) throws XmlException, IOException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(file, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(file, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(Reader reader) throws XmlException, IOException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(reader, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(reader, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(String str) throws XmlException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(str, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(str, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(URL url) throws XmlException, IOException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(url, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(url, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(Node node) throws XmlException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(node, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(node, CTTextSpacingPercent.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STTextSpacingPercent xgetVal();

    void xsetVal(STTextSpacingPercent sTTextSpacingPercent);
}
