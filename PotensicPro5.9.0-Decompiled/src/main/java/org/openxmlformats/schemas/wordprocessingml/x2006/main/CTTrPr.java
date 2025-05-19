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
public interface CTTrPr extends CTTrPrBase {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTrPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttrpr2848type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTrPr newInstance() {
            return (CTTrPr) XmlBeans.getContextTypeLoader().newInstance(CTTrPr.type, null);
        }

        public static CTTrPr newInstance(XmlOptions xmlOptions) {
            return (CTTrPr) XmlBeans.getContextTypeLoader().newInstance(CTTrPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTrPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(File file) throws XmlException, IOException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(file, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(file, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(Reader reader) throws XmlException, IOException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(reader, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(reader, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(String str) throws XmlException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(str, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(str, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(URL url) throws XmlException, IOException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(url, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(url, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(Node node) throws XmlException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(node, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPr) XmlBeans.getContextTypeLoader().parse(node, CTTrPr.type, xmlOptions);
        }
    }

    CTTrackChange addNewDel();

    CTTrackChange addNewIns();

    CTTrPrChange addNewTrPrChange();

    CTTrackChange getDel();

    CTTrackChange getIns();

    CTTrPrChange getTrPrChange();

    boolean isSetDel();

    boolean isSetIns();

    boolean isSetTrPrChange();

    void setDel(CTTrackChange cTTrackChange);

    void setIns(CTTrackChange cTTrackChange);

    void setTrPrChange(CTTrPrChange cTTrPrChange);

    void unsetDel();

    void unsetIns();

    void unsetTrPrChange();
}
