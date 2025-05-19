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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTNumFmt extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNumFmt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnumfmt00e1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumFmt newInstance() {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().newInstance(CTNumFmt.type, null);
        }

        public static CTNumFmt newInstance(XmlOptions xmlOptions) {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().newInstance(CTNumFmt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumFmt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(File file) throws XmlException, IOException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(file, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(file, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(Reader reader) throws XmlException, IOException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(reader, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(reader, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(String str) throws XmlException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(str, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(str, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(URL url) throws XmlException, IOException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(url, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(url, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(Node node) throws XmlException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(node, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmt) XmlBeans.getContextTypeLoader().parse(node, CTNumFmt.type, xmlOptions);
        }
    }

    STNumberFormat.Enum getVal();

    void setVal(STNumberFormat.Enum r1);

    STNumberFormat xgetVal();

    void xsetVal(STNumberFormat sTNumberFormat);
}
