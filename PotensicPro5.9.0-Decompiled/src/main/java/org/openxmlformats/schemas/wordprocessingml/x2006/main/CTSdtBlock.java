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
public interface CTSdtBlock extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSdtBlock.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsdtblock221etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtBlock newInstance() {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().newInstance(CTSdtBlock.type, null);
        }

        public static CTSdtBlock newInstance(XmlOptions xmlOptions) {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().newInstance(CTSdtBlock.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtBlock.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(File file) throws XmlException, IOException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(file, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(file, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(Reader reader) throws XmlException, IOException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(reader, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(reader, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(String str) throws XmlException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(str, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(str, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(URL url) throws XmlException, IOException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(url, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(url, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(Node node) throws XmlException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(node, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtBlock) XmlBeans.getContextTypeLoader().parse(node, CTSdtBlock.type, xmlOptions);
        }
    }

    CTSdtContentBlock addNewSdtContent();

    CTSdtEndPr addNewSdtEndPr();

    CTSdtPr addNewSdtPr();

    CTSdtContentBlock getSdtContent();

    CTSdtEndPr getSdtEndPr();

    CTSdtPr getSdtPr();

    boolean isSetSdtContent();

    boolean isSetSdtEndPr();

    boolean isSetSdtPr();

    void setSdtContent(CTSdtContentBlock cTSdtContentBlock);

    void setSdtEndPr(CTSdtEndPr cTSdtEndPr);

    void setSdtPr(CTSdtPr cTSdtPr);

    void unsetSdtContent();

    void unsetSdtEndPr();

    void unsetSdtPr();
}
