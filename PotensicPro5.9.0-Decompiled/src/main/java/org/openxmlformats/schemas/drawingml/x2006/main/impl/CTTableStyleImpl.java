package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableBackgroundStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

/* loaded from: classes5.dex */
public class CTTableStyleImpl extends XmlComplexContentImpl implements CTTableStyle {
    private static final QName TBLBG$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblBg");
    private static final QName WHOLETBL$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "wholeTbl");
    private static final QName BAND1H$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band1H");
    private static final QName BAND2H$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band2H");
    private static final QName BAND1V$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band1V");
    private static final QName BAND2V$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band2V");
    private static final QName LASTCOL$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lastCol");
    private static final QName FIRSTCOL$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "firstCol");
    private static final QName LASTROW$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lastRow");
    private static final QName SECELL$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "seCell");
    private static final QName SWCELL$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "swCell");
    private static final QName FIRSTROW$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "firstRow");
    private static final QName NECELL$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "neCell");
    private static final QName NWCELL$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "nwCell");
    private static final QName EXTLST$28 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName STYLEID$30 = new QName("", "styleId");
    private static final QName STYLENAME$32 = new QName("", "styleName");

    public CTTableStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand1H() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BAND1H$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand1V() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BAND1V$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand2H() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BAND2H$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand2V() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BAND2V$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$28);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewFirstCol() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FIRSTCOL$14);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewFirstRow() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FIRSTROW$22);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewLastCol() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LASTCOL$12);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewLastRow() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LASTROW$16);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewNeCell() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NECELL$24);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewNwCell() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NWCELL$26);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewSeCell() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SECELL$18);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewSwCell() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SWCELL$20);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTableBackgroundStyle addNewTblBg() {
        CTTableBackgroundStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLBG$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewWholeTbl() {
        CTTablePartStyle add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(WHOLETBL$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand1H() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(BAND1H$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand1V() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(BAND1V$8, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand2H() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(BAND2H$6, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand2V() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(BAND2V$10, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$28, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getFirstCol() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(FIRSTCOL$14, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getFirstRow() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(FIRSTROW$22, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getLastCol() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(LASTCOL$12, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getLastRow() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(LASTROW$16, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getNeCell() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(NECELL$24, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getNwCell() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(NWCELL$26, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getSeCell() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(SECELL$18, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public String getStyleId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLEID$30);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public String getStyleName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLENAME$32);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getSwCell() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(SWCELL$20, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTableBackgroundStyle getTblBg() {
        synchronized (monitor()) {
            check_orphaned();
            CTTableBackgroundStyle find_element_user = get_store().find_element_user(TBLBG$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getWholeTbl() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle find_element_user = get_store().find_element_user(WHOLETBL$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand1H() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAND1H$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand1V() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAND1V$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand2H() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAND2H$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand2V() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAND2V$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetFirstCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FIRSTCOL$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetFirstRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FIRSTROW$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetLastCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LASTCOL$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetLastRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LASTROW$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetNeCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NECELL$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetNwCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NWCELL$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetSeCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SECELL$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetSwCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SWCELL$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetTblBg() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLBG$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetWholeTbl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WHOLETBL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand1H(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAND1H$4;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand1V(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAND1V$8;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand2H(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAND2H$6;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand2V(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAND2V$10;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$28;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setFirstCol(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTCOL$14;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setFirstRow(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTROW$22;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setLastCol(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LASTCOL$12;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setLastRow(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LASTROW$16;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setNeCell(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NECELL$24;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setNwCell(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NWCELL$26;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setSeCell(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SECELL$18;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setStyleId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLEID$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setStyleName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLENAME$32;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setSwCell(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SWCELL$20;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setTblBg(CTTableBackgroundStyle cTTableBackgroundStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLBG$0;
            CTTableBackgroundStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTableBackgroundStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTableBackgroundStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setWholeTbl(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WHOLETBL$2;
            CTTablePartStyle find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand1H() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAND1H$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand1V() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAND1V$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand2H() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAND2H$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand2V() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAND2V$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetFirstCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIRSTCOL$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetFirstRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIRSTROW$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetLastCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LASTCOL$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetLastRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LASTROW$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetNeCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NECELL$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetNwCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NWCELL$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetSeCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SECELL$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetSwCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SWCELL$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetTblBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLBG$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetWholeTbl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WHOLETBL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public STGuid xgetStyleId() {
        STGuid find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(STYLEID$30);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public XmlString xgetStyleName() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STYLENAME$32);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void xsetStyleId(STGuid sTGuid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLEID$30;
            STGuid find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STGuid) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTGuid);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void xsetStyleName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLENAME$32;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
