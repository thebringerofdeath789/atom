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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSdtRun extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSdtRun.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsdtrun5c60type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtRun newInstance() {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().newInstance(CTSdtRun.type, null);
        }

        public static CTSdtRun newInstance(XmlOptions xmlOptions) {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().newInstance(CTSdtRun.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtRun.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(File file) throws XmlException, IOException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(file, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(file, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(Reader reader) throws XmlException, IOException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(reader, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(reader, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(String str) throws XmlException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(str, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(str, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(URL url) throws XmlException, IOException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(url, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(url, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(Node node) throws XmlException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(node, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtRun) XmlBeans.getContextTypeLoader().parse(node, CTSdtRun.type, xmlOptions);
        }
    }

    CTSdtContentRun addNewSdtContent();

    CTSdtEndPr addNewSdtEndPr();

    CTSdtPr addNewSdtPr();

    CTSdtContentRun getSdtContent();

    CTSdtEndPr getSdtEndPr();

    CTSdtPr getSdtPr();

    boolean isSetSdtContent();

    boolean isSetSdtEndPr();

    boolean isSetSdtPr();

    void setSdtContent(CTSdtContentRun cTSdtContentRun);

    void setSdtEndPr(CTSdtEndPr cTSdtEndPr);

    void setSdtPr(CTSdtPr cTSdtPr);

    void unsetSdtContent();

    void unsetSdtEndPr();

    void unsetSdtPr();
}
