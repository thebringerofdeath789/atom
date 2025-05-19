package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTChartsheet extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTChartsheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctchartsheetf68atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTChartsheet newInstance() {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().newInstance(CTChartsheet.type, null);
        }

        public static CTChartsheet newInstance(XmlOptions xmlOptions) {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().newInstance(CTChartsheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTChartsheet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTChartsheet.type, xmlOptions);
        }

        public static CTChartsheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTChartsheet.type, (XmlOptions) null);
        }

        public static CTChartsheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTChartsheet.type, xmlOptions);
        }

        public static CTChartsheet parse(File file) throws XmlException, IOException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(file, CTChartsheet.type, (XmlOptions) null);
        }

        public static CTChartsheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(file, CTChartsheet.type, xmlOptions);
        }

        public static CTChartsheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTChartsheet.type, (XmlOptions) null);
        }

        public static CTChartsheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTChartsheet.type, xmlOptions);
        }

        public static CTChartsheet parse(Reader reader) throws XmlException, IOException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(reader, CTChartsheet.type, (XmlOptions) null);
        }

        public static CTChartsheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(reader, CTChartsheet.type, xmlOptions);
        }

        public static CTChartsheet parse(String str) throws XmlException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(str, CTChartsheet.type, (XmlOptions) null);
        }

        public static CTChartsheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(str, CTChartsheet.type, xmlOptions);
        }

        public static CTChartsheet parse(URL url) throws XmlException, IOException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(url, CTChartsheet.type, (XmlOptions) null);
        }

        public static CTChartsheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(url, CTChartsheet.type, xmlOptions);
        }

        public static CTChartsheet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTChartsheet.type, (XmlOptions) null);
        }

        public static CTChartsheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTChartsheet.type, xmlOptions);
        }

        public static CTChartsheet parse(Node node) throws XmlException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(node, CTChartsheet.type, (XmlOptions) null);
        }

        public static CTChartsheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTChartsheet) XmlBeans.getContextTypeLoader().parse(node, CTChartsheet.type, xmlOptions);
        }
    }

    CTCustomChartsheetViews addNewCustomSheetViews();

    CTDrawing addNewDrawing();

    CTExtensionList addNewExtLst();

    CTHeaderFooter addNewHeaderFooter();

    CTLegacyDrawing addNewLegacyDrawing();

    CTLegacyDrawing addNewLegacyDrawingHF();

    CTPageMargins addNewPageMargins();

    CTCsPageSetup addNewPageSetup();

    CTSheetBackgroundPicture addNewPicture();

    CTChartsheetPr addNewSheetPr();

    CTChartsheetProtection addNewSheetProtection();

    CTChartsheetViews addNewSheetViews();

    CTWebPublishItems addNewWebPublishItems();

    CTCustomChartsheetViews getCustomSheetViews();

    CTDrawing getDrawing();

    CTExtensionList getExtLst();

    CTHeaderFooter getHeaderFooter();

    CTLegacyDrawing getLegacyDrawing();

    CTLegacyDrawing getLegacyDrawingHF();

    CTPageMargins getPageMargins();

    CTCsPageSetup getPageSetup();

    CTSheetBackgroundPicture getPicture();

    CTChartsheetPr getSheetPr();

    CTChartsheetProtection getSheetProtection();

    CTChartsheetViews getSheetViews();

    CTWebPublishItems getWebPublishItems();

    boolean isSetCustomSheetViews();

    boolean isSetExtLst();

    boolean isSetHeaderFooter();

    boolean isSetLegacyDrawing();

    boolean isSetLegacyDrawingHF();

    boolean isSetPageMargins();

    boolean isSetPageSetup();

    boolean isSetPicture();

    boolean isSetSheetPr();

    boolean isSetSheetProtection();

    boolean isSetWebPublishItems();

    void setCustomSheetViews(CTCustomChartsheetViews cTCustomChartsheetViews);

    void setDrawing(CTDrawing cTDrawing);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHeaderFooter(CTHeaderFooter cTHeaderFooter);

    void setLegacyDrawing(CTLegacyDrawing cTLegacyDrawing);

    void setLegacyDrawingHF(CTLegacyDrawing cTLegacyDrawing);

    void setPageMargins(CTPageMargins cTPageMargins);

    void setPageSetup(CTCsPageSetup cTCsPageSetup);

    void setPicture(CTSheetBackgroundPicture cTSheetBackgroundPicture);

    void setSheetPr(CTChartsheetPr cTChartsheetPr);

    void setSheetProtection(CTChartsheetProtection cTChartsheetProtection);

    void setSheetViews(CTChartsheetViews cTChartsheetViews);

    void setWebPublishItems(CTWebPublishItems cTWebPublishItems);

    void unsetCustomSheetViews();

    void unsetExtLst();

    void unsetHeaderFooter();

    void unsetLegacyDrawing();

    void unsetLegacyDrawingHF();

    void unsetPageMargins();

    void unsetPageSetup();

    void unsetPicture();

    void unsetSheetPr();

    void unsetSheetProtection();

    void unsetWebPublishItems();
}
