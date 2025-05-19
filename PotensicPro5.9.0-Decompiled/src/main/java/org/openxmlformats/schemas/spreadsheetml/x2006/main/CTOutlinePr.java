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
public interface CTOutlinePr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTOutlinePr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctoutlineprc483type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOutlinePr newInstance() {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().newInstance(CTOutlinePr.type, null);
        }

        public static CTOutlinePr newInstance(XmlOptions xmlOptions) {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().newInstance(CTOutlinePr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOutlinePr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOutlinePr.type, xmlOptions);
        }

        public static CTOutlinePr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOutlinePr.type, (XmlOptions) null);
        }

        public static CTOutlinePr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOutlinePr.type, xmlOptions);
        }

        public static CTOutlinePr parse(File file) throws XmlException, IOException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(file, CTOutlinePr.type, (XmlOptions) null);
        }

        public static CTOutlinePr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(file, CTOutlinePr.type, xmlOptions);
        }

        public static CTOutlinePr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(inputStream, CTOutlinePr.type, (XmlOptions) null);
        }

        public static CTOutlinePr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(inputStream, CTOutlinePr.type, xmlOptions);
        }

        public static CTOutlinePr parse(Reader reader) throws XmlException, IOException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(reader, CTOutlinePr.type, (XmlOptions) null);
        }

        public static CTOutlinePr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(reader, CTOutlinePr.type, xmlOptions);
        }

        public static CTOutlinePr parse(String str) throws XmlException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(str, CTOutlinePr.type, (XmlOptions) null);
        }

        public static CTOutlinePr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(str, CTOutlinePr.type, xmlOptions);
        }

        public static CTOutlinePr parse(URL url) throws XmlException, IOException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(url, CTOutlinePr.type, (XmlOptions) null);
        }

        public static CTOutlinePr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(url, CTOutlinePr.type, xmlOptions);
        }

        public static CTOutlinePr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOutlinePr.type, (XmlOptions) null);
        }

        public static CTOutlinePr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOutlinePr.type, xmlOptions);
        }

        public static CTOutlinePr parse(Node node) throws XmlException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(node, CTOutlinePr.type, (XmlOptions) null);
        }

        public static CTOutlinePr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOutlinePr) XmlBeans.getContextTypeLoader().parse(node, CTOutlinePr.type, xmlOptions);
        }
    }

    boolean getApplyStyles();

    boolean getShowOutlineSymbols();

    boolean getSummaryBelow();

    boolean getSummaryRight();

    boolean isSetApplyStyles();

    boolean isSetShowOutlineSymbols();

    boolean isSetSummaryBelow();

    boolean isSetSummaryRight();

    void setApplyStyles(boolean z);

    void setShowOutlineSymbols(boolean z);

    void setSummaryBelow(boolean z);

    void setSummaryRight(boolean z);

    void unsetApplyStyles();

    void unsetShowOutlineSymbols();

    void unsetSummaryBelow();

    void unsetSummaryRight();

    XmlBoolean xgetApplyStyles();

    XmlBoolean xgetShowOutlineSymbols();

    XmlBoolean xgetSummaryBelow();

    XmlBoolean xgetSummaryRight();

    void xsetApplyStyles(XmlBoolean xmlBoolean);

    void xsetShowOutlineSymbols(XmlBoolean xmlBoolean);

    void xsetSummaryBelow(XmlBoolean xmlBoolean);

    void xsetSummaryRight(XmlBoolean xmlBoolean);
}
