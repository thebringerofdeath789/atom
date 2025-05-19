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
public interface CTTblPrEx extends CTTblPrExBase {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTblPrEx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttblprex863ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPrEx newInstance() {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().newInstance(CTTblPrEx.type, null);
        }

        public static CTTblPrEx newInstance(XmlOptions xmlOptions) {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().newInstance(CTTblPrEx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblPrEx.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(File file) throws XmlException, IOException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(file, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(file, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(Reader reader) throws XmlException, IOException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(reader, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(reader, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(String str) throws XmlException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(str, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(str, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(URL url) throws XmlException, IOException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(url, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(url, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(Node node) throws XmlException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(node, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrEx) XmlBeans.getContextTypeLoader().parse(node, CTTblPrEx.type, xmlOptions);
        }
    }

    CTTblPrExChange addNewTblPrExChange();

    CTTblPrExChange getTblPrExChange();

    boolean isSetTblPrExChange();

    void setTblPrExChange(CTTblPrExChange cTTblPrExChange);

    void unsetTblPrExChange();
}
