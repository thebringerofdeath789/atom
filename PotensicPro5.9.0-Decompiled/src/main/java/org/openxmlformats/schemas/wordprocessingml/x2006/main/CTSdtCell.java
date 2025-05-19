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
public interface CTSdtCell extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSdtCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsdtcell626dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtCell newInstance() {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().newInstance(CTSdtCell.type, null);
        }

        public static CTSdtCell newInstance(XmlOptions xmlOptions) {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().newInstance(CTSdtCell.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtCell.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtCell.type, xmlOptions);
        }

        public static CTSdtCell parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtCell.type, (XmlOptions) null);
        }

        public static CTSdtCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtCell.type, xmlOptions);
        }

        public static CTSdtCell parse(File file) throws XmlException, IOException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(file, CTSdtCell.type, (XmlOptions) null);
        }

        public static CTSdtCell parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(file, CTSdtCell.type, xmlOptions);
        }

        public static CTSdtCell parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtCell.type, (XmlOptions) null);
        }

        public static CTSdtCell parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtCell.type, xmlOptions);
        }

        public static CTSdtCell parse(Reader reader) throws XmlException, IOException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(reader, CTSdtCell.type, (XmlOptions) null);
        }

        public static CTSdtCell parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(reader, CTSdtCell.type, xmlOptions);
        }

        public static CTSdtCell parse(String str) throws XmlException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(str, CTSdtCell.type, (XmlOptions) null);
        }

        public static CTSdtCell parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(str, CTSdtCell.type, xmlOptions);
        }

        public static CTSdtCell parse(URL url) throws XmlException, IOException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(url, CTSdtCell.type, (XmlOptions) null);
        }

        public static CTSdtCell parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(url, CTSdtCell.type, xmlOptions);
        }

        public static CTSdtCell parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtCell.type, (XmlOptions) null);
        }

        public static CTSdtCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtCell.type, xmlOptions);
        }

        public static CTSdtCell parse(Node node) throws XmlException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(node, CTSdtCell.type, (XmlOptions) null);
        }

        public static CTSdtCell parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtCell) XmlBeans.getContextTypeLoader().parse(node, CTSdtCell.type, xmlOptions);
        }
    }

    CTSdtContentCell addNewSdtContent();

    CTSdtEndPr addNewSdtEndPr();

    CTSdtPr addNewSdtPr();

    CTSdtContentCell getSdtContent();

    CTSdtEndPr getSdtEndPr();

    CTSdtPr getSdtPr();

    boolean isSetSdtContent();

    boolean isSetSdtEndPr();

    boolean isSetSdtPr();

    void setSdtContent(CTSdtContentCell cTSdtContentCell);

    void setSdtEndPr(CTSdtEndPr cTSdtEndPr);

    void setSdtPr(CTSdtPr cTSdtPr);

    void unsetSdtContent();

    void unsetSdtEndPr();

    void unsetSdtPr();
}
