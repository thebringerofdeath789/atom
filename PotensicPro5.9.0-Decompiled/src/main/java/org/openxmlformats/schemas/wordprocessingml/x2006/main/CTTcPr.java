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
public interface CTTcPr extends CTTcPrInner {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTcPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttcpree37type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTcPr newInstance() {
            return (CTTcPr) XmlBeans.getContextTypeLoader().newInstance(CTTcPr.type, null);
        }

        public static CTTcPr newInstance(XmlOptions xmlOptions) {
            return (CTTcPr) XmlBeans.getContextTypeLoader().newInstance(CTTcPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTcPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(File file) throws XmlException, IOException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(file, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(file, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(Reader reader) throws XmlException, IOException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(reader, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(reader, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(String str) throws XmlException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(str, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(str, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(URL url) throws XmlException, IOException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(url, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(url, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(Node node) throws XmlException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(node, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPr) XmlBeans.getContextTypeLoader().parse(node, CTTcPr.type, xmlOptions);
        }
    }

    CTTcPrChange addNewTcPrChange();

    CTTcPrChange getTcPrChange();

    boolean isSetTcPrChange();

    void setTcPrChange(CTTcPrChange cTTcPrChange);

    void unsetTcPrChange();
}
