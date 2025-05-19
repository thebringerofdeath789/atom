package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;

/* loaded from: classes6.dex */
public class CTPageBreakImpl extends XmlComplexContentImpl implements CTPageBreak {
    private static final QName BRK$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "brk");
    private static final QName COUNT$2 = new QName("", "count");
    private static final QName MANUALBREAKCOUNT$4 = new QName("", "manualBreakCount");

    public CTPageBreakImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public CTBreak addNewBrk() {
        CTBreak cTBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTBreak = (CTBreak) get_store().add_element_user(BRK$0);
        }
        return cTBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public CTBreak getBrkArray(int i) {
        CTBreak cTBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTBreak = (CTBreak) get_store().find_element_user(BRK$0, i);
            if (cTBreak == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public CTBreak[] getBrkArray() {
        CTBreak[] cTBreakArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BRK$0, arrayList);
            cTBreakArr = new CTBreak[arrayList.size()];
            arrayList.toArray(cTBreakArr);
        }
        return cTBreakArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public List<CTBreak> getBrkList() {
        1BrkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BrkList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public long getManualBreakCount() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANUALBREAKCOUNT$4;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public CTBreak insertNewBrk(int i) {
        CTBreak cTBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTBreak = (CTBreak) get_store().insert_element_user(BRK$0, i);
        }
        return cTBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public boolean isSetManualBreakCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MANUALBREAKCOUNT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public void removeBrk(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BRK$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public void setBrkArray(int i, CTBreak cTBreak) {
        synchronized (monitor()) {
            check_orphaned();
            CTBreak cTBreak2 = (CTBreak) get_store().find_element_user(BRK$0, i);
            if (cTBreak2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBreak2.set(cTBreak);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public void setBrkArray(CTBreak[] cTBreakArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBreakArr, BRK$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public void setManualBreakCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANUALBREAKCOUNT$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public int sizeOfBrkArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BRK$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public void unsetManualBreakCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MANUALBREAKCOUNT$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt == null) {
                xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public XmlUnsignedInt xgetManualBreakCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANUALBREAKCOUNT$4;
            xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt == null) {
                xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak
    public void xsetManualBreakCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANUALBREAKCOUNT$4;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }
}
