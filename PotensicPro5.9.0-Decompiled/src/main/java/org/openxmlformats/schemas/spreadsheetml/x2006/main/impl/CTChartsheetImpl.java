package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCsPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomChartsheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetBackgroundPicture;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishItems;

/* loaded from: classes6.dex */
public class CTChartsheetImpl extends XmlComplexContentImpl implements CTChartsheet {
    private static final QName SHEETPR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetPr");
    private static final QName SHEETVIEWS$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetViews");
    private static final QName SHEETPROTECTION$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetProtection");
    private static final QName CUSTOMSHEETVIEWS$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customSheetViews");
    private static final QName PAGEMARGINS$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageMargins");
    private static final QName PAGESETUP$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetup");
    private static final QName HEADERFOOTER$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "headerFooter");
    private static final QName DRAWING$14 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "drawing");
    private static final QName LEGACYDRAWING$16 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawing");
    private static final QName LEGACYDRAWINGHF$18 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawingHF");
    private static final QName PICTURE$20 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "picture");
    private static final QName WEBPUBLISHITEMS$22 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishItems");
    private static final QName EXTLST$24 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTChartsheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTCustomChartsheetViews addNewCustomSheetViews() {
        CTCustomChartsheetViews add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CUSTOMSHEETVIEWS$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTDrawing addNewDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().add_element_user(DRAWING$14);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$24);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTHeaderFooter addNewHeaderFooter() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().add_element_user(HEADERFOOTER$12);
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTLegacyDrawing addNewLegacyDrawing() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(LEGACYDRAWING$16);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTLegacyDrawing addNewLegacyDrawingHF() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(LEGACYDRAWINGHF$18);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTPageMargins addNewPageMargins() {
        CTPageMargins cTPageMargins;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMargins = (CTPageMargins) get_store().add_element_user(PAGEMARGINS$8);
        }
        return cTPageMargins;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTCsPageSetup addNewPageSetup() {
        CTCsPageSetup add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PAGESETUP$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTSheetBackgroundPicture addNewPicture() {
        CTSheetBackgroundPicture add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PICTURE$20);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetPr addNewSheetPr() {
        CTChartsheetPr add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SHEETPR$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetProtection addNewSheetProtection() {
        CTChartsheetProtection add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SHEETPROTECTION$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetViews addNewSheetViews() {
        CTChartsheetViews add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SHEETVIEWS$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTWebPublishItems addNewWebPublishItems() {
        CTWebPublishItems add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(WEBPUBLISHITEMS$22);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTCustomChartsheetViews getCustomSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomChartsheetViews find_element_user = get_store().find_element_user(CUSTOMSHEETVIEWS$6, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTDrawing getDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            CTDrawing cTDrawing = (CTDrawing) get_store().find_element_user(DRAWING$14, 0);
            if (cTDrawing == null) {
                return null;
            }
            return cTDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$24, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTHeaderFooter getHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            CTHeaderFooter cTHeaderFooter = (CTHeaderFooter) get_store().find_element_user(HEADERFOOTER$12, 0);
            if (cTHeaderFooter == null) {
                return null;
            }
            return cTHeaderFooter;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTLegacyDrawing getLegacyDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            CTLegacyDrawing cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(LEGACYDRAWING$16, 0);
            if (cTLegacyDrawing == null) {
                return null;
            }
            return cTLegacyDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTLegacyDrawing getLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            CTLegacyDrawing cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(LEGACYDRAWINGHF$18, 0);
            if (cTLegacyDrawing == null) {
                return null;
            }
            return cTLegacyDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTPageMargins getPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageMargins cTPageMargins = (CTPageMargins) get_store().find_element_user(PAGEMARGINS$8, 0);
            if (cTPageMargins == null) {
                return null;
            }
            return cTPageMargins;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTCsPageSetup getPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            CTCsPageSetup find_element_user = get_store().find_element_user(PAGESETUP$10, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTSheetBackgroundPicture getPicture() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetBackgroundPicture find_element_user = get_store().find_element_user(PICTURE$20, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetPr getSheetPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartsheetPr find_element_user = get_store().find_element_user(SHEETPR$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetProtection getSheetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartsheetProtection find_element_user = get_store().find_element_user(SHEETPROTECTION$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetViews getSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartsheetViews find_element_user = get_store().find_element_user(SHEETVIEWS$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTWebPublishItems getWebPublishItems() {
        synchronized (monitor()) {
            check_orphaned();
            CTWebPublishItems find_element_user = get_store().find_element_user(WEBPUBLISHITEMS$22, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetCustomSheetViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTOMSHEETVIEWS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetHeaderFooter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HEADERFOOTER$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetLegacyDrawing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACYDRAWING$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetLegacyDrawingHF() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACYDRAWINGHF$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetPageMargins() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGEMARGINS$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetPageSetup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGESETUP$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetPicture() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PICTURE$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetSheetPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetSheetProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETPROTECTION$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetWebPublishItems() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WEBPUBLISHITEMS$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setCustomSheetViews(CTCustomChartsheetViews cTCustomChartsheetViews) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMSHEETVIEWS$6;
            CTCustomChartsheetViews find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTCustomChartsheetViews) get_store().add_element_user(qName);
            }
            find_element_user.set(cTCustomChartsheetViews);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setDrawing(CTDrawing cTDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAWING$14;
            CTDrawing cTDrawing2 = (CTDrawing) typeStore.find_element_user(qName, 0);
            if (cTDrawing2 == null) {
                cTDrawing2 = (CTDrawing) get_store().add_element_user(qName);
            }
            cTDrawing2.set(cTDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$24;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setHeaderFooter(CTHeaderFooter cTHeaderFooter) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERFOOTER$12;
            CTHeaderFooter cTHeaderFooter2 = (CTHeaderFooter) typeStore.find_element_user(qName, 0);
            if (cTHeaderFooter2 == null) {
                cTHeaderFooter2 = (CTHeaderFooter) get_store().add_element_user(qName);
            }
            cTHeaderFooter2.set(cTHeaderFooter);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setLegacyDrawing(CTLegacyDrawing cTLegacyDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACYDRAWING$16;
            CTLegacyDrawing cTLegacyDrawing2 = (CTLegacyDrawing) typeStore.find_element_user(qName, 0);
            if (cTLegacyDrawing2 == null) {
                cTLegacyDrawing2 = (CTLegacyDrawing) get_store().add_element_user(qName);
            }
            cTLegacyDrawing2.set(cTLegacyDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setLegacyDrawingHF(CTLegacyDrawing cTLegacyDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACYDRAWINGHF$18;
            CTLegacyDrawing cTLegacyDrawing2 = (CTLegacyDrawing) typeStore.find_element_user(qName, 0);
            if (cTLegacyDrawing2 == null) {
                cTLegacyDrawing2 = (CTLegacyDrawing) get_store().add_element_user(qName);
            }
            cTLegacyDrawing2.set(cTLegacyDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setPageMargins(CTPageMargins cTPageMargins) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEMARGINS$8;
            CTPageMargins cTPageMargins2 = (CTPageMargins) typeStore.find_element_user(qName, 0);
            if (cTPageMargins2 == null) {
                cTPageMargins2 = (CTPageMargins) get_store().add_element_user(qName);
            }
            cTPageMargins2.set(cTPageMargins);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setPageSetup(CTCsPageSetup cTCsPageSetup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGESETUP$10;
            CTCsPageSetup find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTCsPageSetup) get_store().add_element_user(qName);
            }
            find_element_user.set(cTCsPageSetup);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setPicture(CTSheetBackgroundPicture cTSheetBackgroundPicture) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PICTURE$20;
            CTSheetBackgroundPicture find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTSheetBackgroundPicture) get_store().add_element_user(qName);
            }
            find_element_user.set(cTSheetBackgroundPicture);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setSheetPr(CTChartsheetPr cTChartsheetPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETPR$0;
            CTChartsheetPr find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTChartsheetPr) get_store().add_element_user(qName);
            }
            find_element_user.set(cTChartsheetPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setSheetProtection(CTChartsheetProtection cTChartsheetProtection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETPROTECTION$4;
            CTChartsheetProtection find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTChartsheetProtection) get_store().add_element_user(qName);
            }
            find_element_user.set(cTChartsheetProtection);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setSheetViews(CTChartsheetViews cTChartsheetViews) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETVIEWS$2;
            CTChartsheetViews find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTChartsheetViews) get_store().add_element_user(qName);
            }
            find_element_user.set(cTChartsheetViews);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setWebPublishItems(CTWebPublishItems cTWebPublishItems) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEBPUBLISHITEMS$22;
            CTWebPublishItems find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTWebPublishItems) get_store().add_element_user(qName);
            }
            find_element_user.set(cTWebPublishItems);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetCustomSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMSHEETVIEWS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HEADERFOOTER$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetLegacyDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACYDRAWING$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACYDRAWINGHF$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGEMARGINS$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGESETUP$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetPicture() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PICTURE$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetSheetPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetSheetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETPROTECTION$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetWebPublishItems() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WEBPUBLISHITEMS$22, 0);
        }
    }
}
