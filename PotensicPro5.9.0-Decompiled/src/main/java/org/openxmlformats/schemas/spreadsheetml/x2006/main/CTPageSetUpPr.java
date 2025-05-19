package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPageSetUpPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPageSetUpPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpagesetuppr24cftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageSetUpPr newInstance() {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().newInstance(CTPageSetUpPr.type, null);
        }

        public static CTPageSetUpPr newInstance(XmlOptions xmlOptions) {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().newInstance(CTPageSetUpPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageSetUpPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageSetUpPr.type, xmlOptions);
        }

        public static CTPageSetUpPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageSetUpPr.type, (XmlOptions) null);
        }

        public static CTPageSetUpPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageSetUpPr.type, xmlOptions);
        }

        public static CTPageSetUpPr parse(File file) throws XmlException, IOException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(file, CTPageSetUpPr.type, (XmlOptions) null);
        }

        public static CTPageSetUpPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(file, CTPageSetUpPr.type, xmlOptions);
        }

        public static CTPageSetUpPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageSetUpPr.type, (XmlOptions) null);
        }

        public static CTPageSetUpPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageSetUpPr.type, xmlOptions);
        }

        public static CTPageSetUpPr parse(Reader reader) throws XmlException, IOException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(reader, CTPageSetUpPr.type, (XmlOptions) null);
        }

        public static CTPageSetUpPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(reader, CTPageSetUpPr.type, xmlOptions);
        }

        public static CTPageSetUpPr parse(String str) throws XmlException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(str, CTPageSetUpPr.type, (XmlOptions) null);
        }

        public static CTPageSetUpPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(str, CTPageSetUpPr.type, xmlOptions);
        }

        public static CTPageSetUpPr parse(URL url) throws XmlException, IOException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(url, CTPageSetUpPr.type, (XmlOptions) null);
        }

        public static CTPageSetUpPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(url, CTPageSetUpPr.type, xmlOptions);
        }

        public static CTPageSetUpPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageSetUpPr.type, (XmlOptions) null);
        }

        public static CTPageSetUpPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageSetUpPr.type, xmlOptions);
        }

        public static CTPageSetUpPr parse(Node node) throws XmlException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(node, CTPageSetUpPr.type, (XmlOptions) null);
        }

        public static CTPageSetUpPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetUpPr) XmlBeans.getContextTypeLoader().parse(node, CTPageSetUpPr.type, xmlOptions);
        }
    }

    boolean getAutoPageBreaks();

    boolean getFitToPage();

    boolean isSetAutoPageBreaks();

    boolean isSetFitToPage();

    void setAutoPageBreaks(boolean z);

    void setFitToPage(boolean z);

    void unsetAutoPageBreaks();

    void unsetFitToPage();

    XmlBoolean xgetAutoPageBreaks();

    XmlBoolean xgetFitToPage();

    void xsetAutoPageBreaks(XmlBoolean xmlBoolean);

    void xsetFitToPage(XmlBoolean xmlBoolean);
}
