package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;

/* loaded from: classes6.dex */
public class CTBordersImpl extends XmlComplexContentImpl implements CTBorders {
    private static final QName BORDER$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "border");
    private static final QName COUNT$2 = new QName("", "count");

    public CTBordersImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public CTBorder addNewBorder() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(BORDER$0);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public CTBorder getBorderArray(int i) {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().find_element_user(BORDER$0, i);
            if (cTBorder == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public CTBorder[] getBorderArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDER$0, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public List<CTBorder> getBorderList() {
        1BorderList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public CTBorder insertNewBorder(int i) {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().insert_element_user(BORDER$0, i);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public void removeBorder(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDER$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public void setBorderArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder2 = (CTBorder) get_store().find_element_user(BORDER$0, i);
            if (cTBorder2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public void setBorderArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDER$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public int sizeOfBorderArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDER$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders
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
