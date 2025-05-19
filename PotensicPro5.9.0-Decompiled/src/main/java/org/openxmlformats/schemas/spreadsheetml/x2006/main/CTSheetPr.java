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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSheetPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSheetPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsheetpr3ae0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetPr newInstance() {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().newInstance(CTSheetPr.type, null);
        }

        public static CTSheetPr newInstance(XmlOptions xmlOptions) {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().newInstance(CTSheetPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetPr.type, xmlOptions);
        }

        public static CTSheetPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetPr.type, (XmlOptions) null);
        }

        public static CTSheetPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetPr.type, xmlOptions);
        }

        public static CTSheetPr parse(File file) throws XmlException, IOException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(file, CTSheetPr.type, (XmlOptions) null);
        }

        public static CTSheetPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(file, CTSheetPr.type, xmlOptions);
        }

        public static CTSheetPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetPr.type, (XmlOptions) null);
        }

        public static CTSheetPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetPr.type, xmlOptions);
        }

        public static CTSheetPr parse(Reader reader) throws XmlException, IOException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(reader, CTSheetPr.type, (XmlOptions) null);
        }

        public static CTSheetPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(reader, CTSheetPr.type, xmlOptions);
        }

        public static CTSheetPr parse(String str) throws XmlException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(str, CTSheetPr.type, (XmlOptions) null);
        }

        public static CTSheetPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(str, CTSheetPr.type, xmlOptions);
        }

        public static CTSheetPr parse(URL url) throws XmlException, IOException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(url, CTSheetPr.type, (XmlOptions) null);
        }

        public static CTSheetPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(url, CTSheetPr.type, xmlOptions);
        }

        public static CTSheetPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetPr.type, (XmlOptions) null);
        }

        public static CTSheetPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetPr.type, xmlOptions);
        }

        public static CTSheetPr parse(Node node) throws XmlException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(node, CTSheetPr.type, (XmlOptions) null);
        }

        public static CTSheetPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetPr) XmlBeans.getContextTypeLoader().parse(node, CTSheetPr.type, xmlOptions);
        }
    }

    CTOutlinePr addNewOutlinePr();

    CTPageSetUpPr addNewPageSetUpPr();

    CTColor addNewTabColor();

    String getCodeName();

    boolean getEnableFormatConditionsCalculation();

    boolean getFilterMode();

    CTOutlinePr getOutlinePr();

    CTPageSetUpPr getPageSetUpPr();

    boolean getPublished();

    boolean getSyncHorizontal();

    String getSyncRef();

    boolean getSyncVertical();

    CTColor getTabColor();

    boolean getTransitionEntry();

    boolean getTransitionEvaluation();

    boolean isSetCodeName();

    boolean isSetEnableFormatConditionsCalculation();

    boolean isSetFilterMode();

    boolean isSetOutlinePr();

    boolean isSetPageSetUpPr();

    boolean isSetPublished();

    boolean isSetSyncHorizontal();

    boolean isSetSyncRef();

    boolean isSetSyncVertical();

    boolean isSetTabColor();

    boolean isSetTransitionEntry();

    boolean isSetTransitionEvaluation();

    void setCodeName(String str);

    void setEnableFormatConditionsCalculation(boolean z);

    void setFilterMode(boolean z);

    void setOutlinePr(CTOutlinePr cTOutlinePr);

    void setPageSetUpPr(CTPageSetUpPr cTPageSetUpPr);

    void setPublished(boolean z);

    void setSyncHorizontal(boolean z);

    void setSyncRef(String str);

    void setSyncVertical(boolean z);

    void setTabColor(CTColor cTColor);

    void setTransitionEntry(boolean z);

    void setTransitionEvaluation(boolean z);

    void unsetCodeName();

    void unsetEnableFormatConditionsCalculation();

    void unsetFilterMode();

    void unsetOutlinePr();

    void unsetPageSetUpPr();

    void unsetPublished();

    void unsetSyncHorizontal();

    void unsetSyncRef();

    void unsetSyncVertical();

    void unsetTabColor();

    void unsetTransitionEntry();

    void unsetTransitionEvaluation();

    XmlString xgetCodeName();

    XmlBoolean xgetEnableFormatConditionsCalculation();

    XmlBoolean xgetFilterMode();

    XmlBoolean xgetPublished();

    XmlBoolean xgetSyncHorizontal();

    STRef xgetSyncRef();

    XmlBoolean xgetSyncVertical();

    XmlBoolean xgetTransitionEntry();

    XmlBoolean xgetTransitionEvaluation();

    void xsetCodeName(XmlString xmlString);

    void xsetEnableFormatConditionsCalculation(XmlBoolean xmlBoolean);

    void xsetFilterMode(XmlBoolean xmlBoolean);

    void xsetPublished(XmlBoolean xmlBoolean);

    void xsetSyncHorizontal(XmlBoolean xmlBoolean);

    void xsetSyncRef(STRef sTRef);

    void xsetSyncVertical(XmlBoolean xmlBoolean);

    void xsetTransitionEntry(XmlBoolean xmlBoolean);

    void xsetTransitionEvaluation(XmlBoolean xmlBoolean);
}
