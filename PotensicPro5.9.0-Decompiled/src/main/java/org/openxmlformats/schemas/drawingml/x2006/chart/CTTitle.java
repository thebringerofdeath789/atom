package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTTitle extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTitle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttitleb54etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTitle newInstance() {
            return (CTTitle) XmlBeans.getContextTypeLoader().newInstance(CTTitle.type, null);
        }

        public static CTTitle newInstance(XmlOptions xmlOptions) {
            return (CTTitle) XmlBeans.getContextTypeLoader().newInstance(CTTitle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTitle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTitle.type, xmlOptions);
        }

        public static CTTitle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTitle.type, (XmlOptions) null);
        }

        public static CTTitle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTitle.type, xmlOptions);
        }

        public static CTTitle parse(File file) throws XmlException, IOException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(file, CTTitle.type, (XmlOptions) null);
        }

        public static CTTitle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(file, CTTitle.type, xmlOptions);
        }

        public static CTTitle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(inputStream, CTTitle.type, (XmlOptions) null);
        }

        public static CTTitle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(inputStream, CTTitle.type, xmlOptions);
        }

        public static CTTitle parse(Reader reader) throws XmlException, IOException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(reader, CTTitle.type, (XmlOptions) null);
        }

        public static CTTitle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(reader, CTTitle.type, xmlOptions);
        }

        public static CTTitle parse(String str) throws XmlException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(str, CTTitle.type, (XmlOptions) null);
        }

        public static CTTitle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(str, CTTitle.type, xmlOptions);
        }

        public static CTTitle parse(URL url) throws XmlException, IOException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(url, CTTitle.type, (XmlOptions) null);
        }

        public static CTTitle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(url, CTTitle.type, xmlOptions);
        }

        public static CTTitle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTitle.type, (XmlOptions) null);
        }

        public static CTTitle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTitle.type, xmlOptions);
        }

        public static CTTitle parse(Node node) throws XmlException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(node, CTTitle.type, (XmlOptions) null);
        }

        public static CTTitle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTitle) XmlBeans.getContextTypeLoader().parse(node, CTTitle.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTLayout addNewLayout();

    CTBoolean addNewOverlay();

    CTShapeProperties addNewSpPr();

    CTTx addNewTx();

    CTTextBody addNewTxPr();

    CTExtensionList getExtLst();

    CTLayout getLayout();

    CTBoolean getOverlay();

    CTShapeProperties getSpPr();

    CTTx getTx();

    CTTextBody getTxPr();

    boolean isSetExtLst();

    boolean isSetLayout();

    boolean isSetOverlay();

    boolean isSetSpPr();

    boolean isSetTx();

    boolean isSetTxPr();

    void setExtLst(CTExtensionList cTExtensionList);

    void setLayout(CTLayout cTLayout);

    void setOverlay(CTBoolean cTBoolean);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTx(CTTx cTTx);

    void setTxPr(CTTextBody cTTextBody);

    void unsetExtLst();

    void unsetLayout();

    void unsetOverlay();

    void unsetSpPr();

    void unsetTx();

    void unsetTxPr();
}
