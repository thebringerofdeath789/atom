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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTJc extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctjc158ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTJc newInstance() {
            return (CTJc) XmlBeans.getContextTypeLoader().newInstance(CTJc.type, null);
        }

        public static CTJc newInstance(XmlOptions xmlOptions) {
            return (CTJc) XmlBeans.getContextTypeLoader().newInstance(CTJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTJc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTJc.type, xmlOptions);
        }

        public static CTJc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTJc.type, xmlOptions);
        }

        public static CTJc parse(File file) throws XmlException, IOException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(file, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(file, CTJc.type, xmlOptions);
        }

        public static CTJc parse(InputStream inputStream) throws XmlException, IOException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(inputStream, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(inputStream, CTJc.type, xmlOptions);
        }

        public static CTJc parse(Reader reader) throws XmlException, IOException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(reader, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(reader, CTJc.type, xmlOptions);
        }

        public static CTJc parse(String str) throws XmlException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(str, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(str, CTJc.type, xmlOptions);
        }

        public static CTJc parse(URL url) throws XmlException, IOException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(url, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(url, CTJc.type, xmlOptions);
        }

        public static CTJc parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTJc.type, xmlOptions);
        }

        public static CTJc parse(Node node) throws XmlException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(node, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTJc) XmlBeans.getContextTypeLoader().parse(node, CTJc.type, xmlOptions);
        }
    }

    STJc.Enum getVal();

    void setVal(STJc.Enum r1);

    STJc xgetVal();

    void xsetVal(STJc sTJc);
}
