package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;

/* loaded from: classes6.dex */
public class CTCellStyleXfsImpl extends XmlComplexContentImpl implements CTCellStyleXfs {
    private static final QName XF$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "xf");
    private static final QName COUNT$2 = new QName("", "count");

    public CTCellStyleXfsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public CTXf addNewXf() {
        CTXf cTXf;
        synchronized (monitor()) {
            check_orphaned();
            cTXf = (CTXf) get_store().add_element_user(XF$0);
        }
        return cTXf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public CTXf getXfArray(int i) {
        CTXf cTXf;
        synchronized (monitor()) {
            check_orphaned();
            cTXf = (CTXf) get_store().find_element_user(XF$0, i);
            if (cTXf == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTXf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public CTXf[] getXfArray() {
        CTXf[] cTXfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(XF$0, arrayList);
            cTXfArr = new CTXf[arrayList.size()];
            arrayList.toArray(cTXfArr);
        }
        return cTXfArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public List<CTXf> getXfList() {
        1XfList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1XfList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public CTXf insertNewXf(int i) {
        CTXf cTXf;
        synchronized (monitor()) {
            check_orphaned();
            cTXf = (CTXf) get_store().insert_element_user(XF$0, i);
        }
        return cTXf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public void removeXf(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(XF$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public void setXfArray(int i, CTXf cTXf) {
        synchronized (monitor()) {
            check_orphaned();
            CTXf cTXf2 = (CTXf) get_store().find_element_user(XF$0, i);
            if (cTXf2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTXf2.set(cTXf);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public void setXfArray(CTXf[] cTXfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTXfArr, XF$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public int sizeOfXfArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(XF$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs
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
