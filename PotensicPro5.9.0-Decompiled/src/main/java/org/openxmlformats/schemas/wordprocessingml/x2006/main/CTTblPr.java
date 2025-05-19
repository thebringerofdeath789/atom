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
public interface CTTblPr extends CTTblPrBase {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTblPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttblpr5b72type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPr newInstance() {
            return (CTTblPr) XmlBeans.getContextTypeLoader().newInstance(CTTblPr.type, null);
        }

        public static CTTblPr newInstance(XmlOptions xmlOptions) {
            return (CTTblPr) XmlBeans.getContextTypeLoader().newInstance(CTTblPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(File file) throws XmlException, IOException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(file, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(file, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(Reader reader) throws XmlException, IOException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(reader, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(reader, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(String str) throws XmlException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(str, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(str, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(URL url) throws XmlException, IOException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(url, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(url, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(Node node) throws XmlException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(node, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPr) XmlBeans.getContextTypeLoader().parse(node, CTTblPr.type, xmlOptions);
        }
    }

    CTTblPrChange addNewTblPrChange();

    CTTblPrChange getTblPrChange();

    boolean isSetTblPrChange();

    void setTblPrChange(CTTblPrChange cTTblPrChange);

    void unsetTblPrChange();
}
