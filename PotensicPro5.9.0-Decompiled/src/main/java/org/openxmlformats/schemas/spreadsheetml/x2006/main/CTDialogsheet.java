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
public interface CTDialogsheet extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDialogsheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdialogsheet6f36type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDialogsheet newInstance() {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().newInstance(CTDialogsheet.type, null);
        }

        public static CTDialogsheet newInstance(XmlOptions xmlOptions) {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().newInstance(CTDialogsheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDialogsheet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDialogsheet.type, xmlOptions);
        }

        public static CTDialogsheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDialogsheet.type, (XmlOptions) null);
        }

        public static CTDialogsheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDialogsheet.type, xmlOptions);
        }

        public static CTDialogsheet parse(File file) throws XmlException, IOException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(file, CTDialogsheet.type, (XmlOptions) null);
        }

        public static CTDialogsheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(file, CTDialogsheet.type, xmlOptions);
        }

        public static CTDialogsheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTDialogsheet.type, (XmlOptions) null);
        }

        public static CTDialogsheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTDialogsheet.type, xmlOptions);
        }

        public static CTDialogsheet parse(Reader reader) throws XmlException, IOException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(reader, CTDialogsheet.type, (XmlOptions) null);
        }

        public static CTDialogsheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(reader, CTDialogsheet.type, xmlOptions);
        }

        public static CTDialogsheet parse(String str) throws XmlException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(str, CTDialogsheet.type, (XmlOptions) null);
        }

        public static CTDialogsheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(str, CTDialogsheet.type, xmlOptions);
        }

        public static CTDialogsheet parse(URL url) throws XmlException, IOException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(url, CTDialogsheet.type, (XmlOptions) null);
        }

        public static CTDialogsheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(url, CTDialogsheet.type, xmlOptions);
        }

        public static CTDialogsheet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDialogsheet.type, (XmlOptions) null);
        }

        public static CTDialogsheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDialogsheet.type, xmlOptions);
        }

        public static CTDialogsheet parse(Node node) throws XmlException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(node, CTDialogsheet.type, (XmlOptions) null);
        }

        public static CTDialogsheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDialogsheet) XmlBeans.getContextTypeLoader().parse(node, CTDialogsheet.type, xmlOptions);
        }
    }

    CTCustomSheetViews addNewCustomSheetViews();

    CTDrawing addNewDrawing();

    CTExtensionList addNewExtLst();

    CTHeaderFooter addNewHeaderFooter();

    CTLegacyDrawing addNewLegacyDrawing();

    CTLegacyDrawing addNewLegacyDrawingHF();

    CTOleObjects addNewOleObjects();

    CTPageMargins addNewPageMargins();

    CTPageSetup addNewPageSetup();

    CTPrintOptions addNewPrintOptions();

    CTSheetFormatPr addNewSheetFormatPr();

    CTSheetPr addNewSheetPr();

    CTSheetProtection addNewSheetProtection();

    CTSheetViews addNewSheetViews();

    CTCustomSheetViews getCustomSheetViews();

    CTDrawing getDrawing();

    CTExtensionList getExtLst();

    CTHeaderFooter getHeaderFooter();

    CTLegacyDrawing getLegacyDrawing();

    CTLegacyDrawing getLegacyDrawingHF();

    CTOleObjects getOleObjects();

    CTPageMargins getPageMargins();

    CTPageSetup getPageSetup();

    CTPrintOptions getPrintOptions();

    CTSheetFormatPr getSheetFormatPr();

    CTSheetPr getSheetPr();

    CTSheetProtection getSheetProtection();

    CTSheetViews getSheetViews();

    boolean isSetCustomSheetViews();

    boolean isSetDrawing();

    boolean isSetExtLst();

    boolean isSetHeaderFooter();

    boolean isSetLegacyDrawing();

    boolean isSetLegacyDrawingHF();

    boolean isSetOleObjects();

    boolean isSetPageMargins();

    boolean isSetPageSetup();

    boolean isSetPrintOptions();

    boolean isSetSheetFormatPr();

    boolean isSetSheetPr();

    boolean isSetSheetProtection();

    boolean isSetSheetViews();

    void setCustomSheetViews(CTCustomSheetViews cTCustomSheetViews);

    void setDrawing(CTDrawing cTDrawing);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHeaderFooter(CTHeaderFooter cTHeaderFooter);

    void setLegacyDrawing(CTLegacyDrawing cTLegacyDrawing);

    void setLegacyDrawingHF(CTLegacyDrawing cTLegacyDrawing);

    void setOleObjects(CTOleObjects cTOleObjects);

    void setPageMargins(CTPageMargins cTPageMargins);

    void setPageSetup(CTPageSetup cTPageSetup);

    void setPrintOptions(CTPrintOptions cTPrintOptions);

    void setSheetFormatPr(CTSheetFormatPr cTSheetFormatPr);

    void setSheetPr(CTSheetPr cTSheetPr);

    void setSheetProtection(CTSheetProtection cTSheetProtection);

    void setSheetViews(CTSheetViews cTSheetViews);

    void unsetCustomSheetViews();

    void unsetDrawing();

    void unsetExtLst();

    void unsetHeaderFooter();

    void unsetLegacyDrawing();

    void unsetLegacyDrawingHF();

    void unsetOleObjects();

    void unsetPageMargins();

    void unsetPageSetup();

    void unsetPrintOptions();

    void unsetSheetFormatPr();

    void unsetSheetPr();

    void unsetSheetProtection();

    void unsetSheetViews();
}
