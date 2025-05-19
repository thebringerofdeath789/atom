package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSheetView extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSheetView.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsheetview0f43type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetView newInstance() {
            return (CTSheetView) XmlBeans.getContextTypeLoader().newInstance(CTSheetView.type, null);
        }

        public static CTSheetView newInstance(XmlOptions xmlOptions) {
            return (CTSheetView) XmlBeans.getContextTypeLoader().newInstance(CTSheetView.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetView.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetView.type, xmlOptions);
        }

        public static CTSheetView parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetView.type, (XmlOptions) null);
        }

        public static CTSheetView parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetView.type, xmlOptions);
        }

        public static CTSheetView parse(File file) throws XmlException, IOException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(file, CTSheetView.type, (XmlOptions) null);
        }

        public static CTSheetView parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(file, CTSheetView.type, xmlOptions);
        }

        public static CTSheetView parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetView.type, (XmlOptions) null);
        }

        public static CTSheetView parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetView.type, xmlOptions);
        }

        public static CTSheetView parse(Reader reader) throws XmlException, IOException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(reader, CTSheetView.type, (XmlOptions) null);
        }

        public static CTSheetView parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(reader, CTSheetView.type, xmlOptions);
        }

        public static CTSheetView parse(String str) throws XmlException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(str, CTSheetView.type, (XmlOptions) null);
        }

        public static CTSheetView parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(str, CTSheetView.type, xmlOptions);
        }

        public static CTSheetView parse(URL url) throws XmlException, IOException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(url, CTSheetView.type, (XmlOptions) null);
        }

        public static CTSheetView parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(url, CTSheetView.type, xmlOptions);
        }

        public static CTSheetView parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetView.type, (XmlOptions) null);
        }

        public static CTSheetView parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetView.type, xmlOptions);
        }

        public static CTSheetView parse(Node node) throws XmlException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(node, CTSheetView.type, (XmlOptions) null);
        }

        public static CTSheetView parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetView) XmlBeans.getContextTypeLoader().parse(node, CTSheetView.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTPane addNewPane();

    CTPivotSelection addNewPivotSelection();

    CTSelection addNewSelection();

    long getColorId();

    boolean getDefaultGridColor();

    CTExtensionList getExtLst();

    CTPane getPane();

    CTPivotSelection getPivotSelectionArray(int i);

    CTPivotSelection[] getPivotSelectionArray();

    List<CTPivotSelection> getPivotSelectionList();

    boolean getRightToLeft();

    CTSelection getSelectionArray(int i);

    CTSelection[] getSelectionArray();

    List<CTSelection> getSelectionList();

    boolean getShowFormulas();

    boolean getShowGridLines();

    boolean getShowOutlineSymbols();

    boolean getShowRowColHeaders();

    boolean getShowRuler();

    boolean getShowWhiteSpace();

    boolean getShowZeros();

    boolean getTabSelected();

    String getTopLeftCell();

    STSheetViewType$Enum getView();

    boolean getWindowProtection();

    long getWorkbookViewId();

    long getZoomScale();

    long getZoomScaleNormal();

    long getZoomScalePageLayoutView();

    long getZoomScaleSheetLayoutView();

    CTPivotSelection insertNewPivotSelection(int i);

    CTSelection insertNewSelection(int i);

    boolean isSetColorId();

    boolean isSetDefaultGridColor();

    boolean isSetExtLst();

    boolean isSetPane();

    boolean isSetRightToLeft();

    boolean isSetShowFormulas();

    boolean isSetShowGridLines();

    boolean isSetShowOutlineSymbols();

    boolean isSetShowRowColHeaders();

    boolean isSetShowRuler();

    boolean isSetShowWhiteSpace();

    boolean isSetShowZeros();

    boolean isSetTabSelected();

    boolean isSetTopLeftCell();

    boolean isSetView();

    boolean isSetWindowProtection();

    boolean isSetZoomScale();

    boolean isSetZoomScaleNormal();

    boolean isSetZoomScalePageLayoutView();

    boolean isSetZoomScaleSheetLayoutView();

    void removePivotSelection(int i);

    void removeSelection(int i);

    void setColorId(long j);

    void setDefaultGridColor(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setPane(CTPane cTPane);

    void setPivotSelectionArray(int i, CTPivotSelection cTPivotSelection);

    void setPivotSelectionArray(CTPivotSelection[] cTPivotSelectionArr);

    void setRightToLeft(boolean z);

    void setSelectionArray(int i, CTSelection cTSelection);

    void setSelectionArray(CTSelection[] cTSelectionArr);

    void setShowFormulas(boolean z);

    void setShowGridLines(boolean z);

    void setShowOutlineSymbols(boolean z);

    void setShowRowColHeaders(boolean z);

    void setShowRuler(boolean z);

    void setShowWhiteSpace(boolean z);

    void setShowZeros(boolean z);

    void setTabSelected(boolean z);

    void setTopLeftCell(String str);

    void setView(STSheetViewType$Enum sTSheetViewType$Enum);

    void setWindowProtection(boolean z);

    void setWorkbookViewId(long j);

    void setZoomScale(long j);

    void setZoomScaleNormal(long j);

    void setZoomScalePageLayoutView(long j);

    void setZoomScaleSheetLayoutView(long j);

    int sizeOfPivotSelectionArray();

    int sizeOfSelectionArray();

    void unsetColorId();

    void unsetDefaultGridColor();

    void unsetExtLst();

    void unsetPane();

    void unsetRightToLeft();

    void unsetShowFormulas();

    void unsetShowGridLines();

    void unsetShowOutlineSymbols();

    void unsetShowRowColHeaders();

    void unsetShowRuler();

    void unsetShowWhiteSpace();

    void unsetShowZeros();

    void unsetTabSelected();

    void unsetTopLeftCell();

    void unsetView();

    void unsetWindowProtection();

    void unsetZoomScale();

    void unsetZoomScaleNormal();

    void unsetZoomScalePageLayoutView();

    void unsetZoomScaleSheetLayoutView();

    XmlUnsignedInt xgetColorId();

    XmlBoolean xgetDefaultGridColor();

    XmlBoolean xgetRightToLeft();

    XmlBoolean xgetShowFormulas();

    XmlBoolean xgetShowGridLines();

    XmlBoolean xgetShowOutlineSymbols();

    XmlBoolean xgetShowRowColHeaders();

    XmlBoolean xgetShowRuler();

    XmlBoolean xgetShowWhiteSpace();

    XmlBoolean xgetShowZeros();

    XmlBoolean xgetTabSelected();

    STCellRef xgetTopLeftCell();

    STSheetViewType xgetView();

    XmlBoolean xgetWindowProtection();

    XmlUnsignedInt xgetWorkbookViewId();

    XmlUnsignedInt xgetZoomScale();

    XmlUnsignedInt xgetZoomScaleNormal();

    XmlUnsignedInt xgetZoomScalePageLayoutView();

    XmlUnsignedInt xgetZoomScaleSheetLayoutView();

    void xsetColorId(XmlUnsignedInt xmlUnsignedInt);

    void xsetDefaultGridColor(XmlBoolean xmlBoolean);

    void xsetRightToLeft(XmlBoolean xmlBoolean);

    void xsetShowFormulas(XmlBoolean xmlBoolean);

    void xsetShowGridLines(XmlBoolean xmlBoolean);

    void xsetShowOutlineSymbols(XmlBoolean xmlBoolean);

    void xsetShowRowColHeaders(XmlBoolean xmlBoolean);

    void xsetShowRuler(XmlBoolean xmlBoolean);

    void xsetShowWhiteSpace(XmlBoolean xmlBoolean);

    void xsetShowZeros(XmlBoolean xmlBoolean);

    void xsetTabSelected(XmlBoolean xmlBoolean);

    void xsetTopLeftCell(STCellRef sTCellRef);

    void xsetView(STSheetViewType sTSheetViewType);

    void xsetWindowProtection(XmlBoolean xmlBoolean);

    void xsetWorkbookViewId(XmlUnsignedInt xmlUnsignedInt);

    void xsetZoomScale(XmlUnsignedInt xmlUnsignedInt);

    void xsetZoomScaleNormal(XmlUnsignedInt xmlUnsignedInt);

    void xsetZoomScalePageLayoutView(XmlUnsignedInt xmlUnsignedInt);

    void xsetZoomScaleSheetLayoutView(XmlUnsignedInt xmlUnsignedInt);
}
