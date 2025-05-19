package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;

/* loaded from: classes6.dex */
public class CTFontsImpl extends XmlComplexContentImpl implements CTFonts {
    private static final QName FONT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", CellUtil.FONT);
    private static final QName COUNT$2 = new QName("", "count");

    public CTFontsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public CTFont addNewFont() {
        CTFont cTFont;
        synchronized (monitor()) {
            check_orphaned();
            cTFont = (CTFont) get_store().add_element_user(FONT$0);
        }
        return cTFont;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COUNT$2);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public CTFont getFontArray(int i) {
        CTFont cTFont;
        synchronized (monitor()) {
            check_orphaned();
            cTFont = (CTFont) get_store().find_element_user(FONT$0, i);
            if (cTFont == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFont;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public CTFont[] getFontArray() {
        CTFont[] cTFontArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FONT$0, arrayList);
            cTFontArr = new CTFont[arrayList.size()];
            arrayList.toArray(cTFontArr);
        }
        return cTFontArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public List<CTFont> getFontList() {
        1FontList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FontList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public CTFont insertNewFont(int i) {
        CTFont cTFont;
        synchronized (monitor()) {
            check_orphaned();
            cTFont = (CTFont) get_store().insert_element_user(FONT$0, i);
        }
        return cTFont;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void removeFont(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FONT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void setCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void setFontArray(int i, CTFont cTFont) {
        synchronized (monitor()) {
            check_orphaned();
            CTFont cTFont2 = (CTFont) get_store().find_element_user(FONT$0, i);
            if (cTFont2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFont2.set(cTFont);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void setFontArray(CTFont[] cTFontArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFontArr, FONT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public int sizeOfFontArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FONT$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }
}
