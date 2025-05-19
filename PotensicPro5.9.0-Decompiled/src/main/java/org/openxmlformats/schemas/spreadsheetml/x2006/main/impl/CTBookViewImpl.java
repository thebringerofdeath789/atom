package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVisibility;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVisibility$Enum;

/* loaded from: classes6.dex */
public class CTBookViewImpl extends XmlComplexContentImpl implements CTBookView {
    private static final QName EXTLST$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName VISIBILITY$2 = new QName("", "visibility");
    private static final QName MINIMIZED$4 = new QName("", "minimized");
    private static final QName SHOWHORIZONTALSCROLL$6 = new QName("", "showHorizontalScroll");
    private static final QName SHOWVERTICALSCROLL$8 = new QName("", "showVerticalScroll");
    private static final QName SHOWSHEETTABS$10 = new QName("", "showSheetTabs");
    private static final QName XWINDOW$12 = new QName("", "xWindow");
    private static final QName YWINDOW$14 = new QName("", "yWindow");
    private static final QName WINDOWWIDTH$16 = new QName("", "windowWidth");
    private static final QName WINDOWHEIGHT$18 = new QName("", "windowHeight");
    private static final QName TABRATIO$20 = new QName("", "tabRatio");
    private static final QName FIRSTSHEET$22 = new QName("", "firstSheet");
    private static final QName ACTIVETAB$24 = new QName("", "activeTab");
    private static final QName AUTOFILTERDATEGROUPING$26 = new QName("", "autoFilterDateGrouping");

    public CTBookViewImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public long getActiveTab() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVETAB$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean getAutoFilterDateGrouping() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOFILTERDATEGROUPING$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public long getFirstSheet() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSHEET$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean getMinimized() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINIMIZED$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean getShowHorizontalScroll() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWHORIZONTALSCROLL$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean getShowSheetTabs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWSHEETTABS$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean getShowVerticalScroll() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVERTICALSCROLL$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public long getTabRatio() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABRATIO$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public STVisibility$Enum getVisibility() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VISIBILITY$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STVisibility$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public long getWindowHeight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(WINDOWHEIGHT$18);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public long getWindowWidth() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(WINDOWWIDTH$16);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public int getXWindow() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(XWINDOW$12);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public int getYWindow() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(YWINDOW$14);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetActiveTab() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ACTIVETAB$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetAutoFilterDateGrouping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AUTOFILTERDATEGROUPING$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetFirstSheet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIRSTSHEET$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetMinimized() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINIMIZED$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetShowHorizontalScroll() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWHORIZONTALSCROLL$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetShowSheetTabs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWSHEETTABS$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetShowVerticalScroll() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWVERTICALSCROLL$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetTabRatio() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TABRATIO$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetVisibility() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VISIBILITY$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetWindowHeight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WINDOWHEIGHT$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetWindowWidth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WINDOWWIDTH$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetXWindow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(XWINDOW$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public boolean isSetYWindow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(YWINDOW$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setActiveTab(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVETAB$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setAutoFilterDateGrouping(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOFILTERDATEGROUPING$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$0;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setFirstSheet(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSHEET$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setMinimized(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINIMIZED$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setShowHorizontalScroll(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWHORIZONTALSCROLL$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setShowSheetTabs(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWSHEETTABS$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setShowVerticalScroll(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVERTICALSCROLL$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setTabRatio(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABRATIO$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setVisibility(STVisibility$Enum sTVisibility$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VISIBILITY$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTVisibility$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setWindowHeight(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WINDOWHEIGHT$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setWindowWidth(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WINDOWWIDTH$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setXWindow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XWINDOW$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void setYWindow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = YWINDOW$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetActiveTab() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ACTIVETAB$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetAutoFilterDateGrouping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AUTOFILTERDATEGROUPING$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetFirstSheet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIRSTSHEET$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetMinimized() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINIMIZED$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetShowHorizontalScroll() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWHORIZONTALSCROLL$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetShowSheetTabs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWSHEETTABS$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetShowVerticalScroll() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWVERTICALSCROLL$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetTabRatio() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TABRATIO$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetVisibility() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VISIBILITY$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetWindowHeight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WINDOWHEIGHT$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetWindowWidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WINDOWWIDTH$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetXWindow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(XWINDOW$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void unsetYWindow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(YWINDOW$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlUnsignedInt xgetActiveTab() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVETAB$24;
            xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt == null) {
                xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlBoolean xgetAutoFilterDateGrouping() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOFILTERDATEGROUPING$26;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlUnsignedInt xgetFirstSheet() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSHEET$22;
            xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt == null) {
                xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlBoolean xgetMinimized() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINIMIZED$4;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlBoolean xgetShowHorizontalScroll() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWHORIZONTALSCROLL$6;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlBoolean xgetShowSheetTabs() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWSHEETTABS$10;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlBoolean xgetShowVerticalScroll() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVERTICALSCROLL$8;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlUnsignedInt xgetTabRatio() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABRATIO$20;
            xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt == null) {
                xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public STVisibility xgetVisibility() {
        STVisibility find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VISIBILITY$2;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STVisibility) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlUnsignedInt xgetWindowHeight() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(WINDOWHEIGHT$18);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlUnsignedInt xgetWindowWidth() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(WINDOWWIDTH$16);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlInt xgetXWindow() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(XWINDOW$12);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public XmlInt xgetYWindow() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(YWINDOW$14);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetActiveTab(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACTIVETAB$24;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetAutoFilterDateGrouping(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOFILTERDATEGROUPING$26;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetFirstSheet(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSHEET$22;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetMinimized(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINIMIZED$4;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetShowHorizontalScroll(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWHORIZONTALSCROLL$6;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetShowSheetTabs(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWSHEETTABS$10;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetShowVerticalScroll(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVERTICALSCROLL$8;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetTabRatio(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABRATIO$20;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetVisibility(STVisibility sTVisibility) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VISIBILITY$2;
            STVisibility find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STVisibility) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTVisibility);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetWindowHeight(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WINDOWHEIGHT$18;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetWindowWidth(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WINDOWWIDTH$16;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetXWindow(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XWINDOW$12;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qName);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView
    public void xsetYWindow(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = YWINDOW$14;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qName);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlInt2.set(xmlInt);
        }
    }
}
