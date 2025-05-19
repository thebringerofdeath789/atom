package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSdtEndPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSdtEndPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsdtendprbc6etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtEndPr newInstance() {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().newInstance(CTSdtEndPr.type, null);
        }

        public static CTSdtEndPr newInstance(XmlOptions xmlOptions) {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().newInstance(CTSdtEndPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtEndPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtEndPr.type, xmlOptions);
        }

        public static CTSdtEndPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtEndPr.type, (XmlOptions) null);
        }

        public static CTSdtEndPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtEndPr.type, xmlOptions);
        }

        public static CTSdtEndPr parse(File file) throws XmlException, IOException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(file, CTSdtEndPr.type, (XmlOptions) null);
        }

        public static CTSdtEndPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(file, CTSdtEndPr.type, xmlOptions);
        }

        public static CTSdtEndPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtEndPr.type, (XmlOptions) null);
        }

        public static CTSdtEndPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtEndPr.type, xmlOptions);
        }

        public static CTSdtEndPr parse(Reader reader) throws XmlException, IOException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(reader, CTSdtEndPr.type, (XmlOptions) null);
        }

        public static CTSdtEndPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(reader, CTSdtEndPr.type, xmlOptions);
        }

        public static CTSdtEndPr parse(String str) throws XmlException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(str, CTSdtEndPr.type, (XmlOptions) null);
        }

        public static CTSdtEndPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(str, CTSdtEndPr.type, xmlOptions);
        }

        public static CTSdtEndPr parse(URL url) throws XmlException, IOException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(url, CTSdtEndPr.type, (XmlOptions) null);
        }

        public static CTSdtEndPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(url, CTSdtEndPr.type, xmlOptions);
        }

        public static CTSdtEndPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtEndPr.type, (XmlOptions) null);
        }

        public static CTSdtEndPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtEndPr.type, xmlOptions);
        }

        public static CTSdtEndPr parse(Node node) throws XmlException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(node, CTSdtEndPr.type, (XmlOptions) null);
        }

        public static CTSdtEndPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtEndPr) XmlBeans.getContextTypeLoader().parse(node, CTSdtEndPr.type, xmlOptions);
        }
    }

    CTRPr addNewRPr();

    CTRPr getRPrArray(int i);

    CTRPr[] getRPrArray();

    List<CTRPr> getRPrList();

    CTRPr insertNewRPr(int i);

    void removeRPr(int i);

    void setRPrArray(int i, CTRPr cTRPr);

    void setRPrArray(CTRPr[] cTRPrArr);

    int sizeOfRPrArray();
}
