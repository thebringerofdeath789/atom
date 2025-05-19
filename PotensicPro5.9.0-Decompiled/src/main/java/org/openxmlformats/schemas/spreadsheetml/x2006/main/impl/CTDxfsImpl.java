package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;

/* loaded from: classes6.dex */
public class CTDxfsImpl extends XmlComplexContentImpl implements CTDxfs {
    private static final QName DXF$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dxf");
    private static final QName COUNT$2 = new QName("", "count");

    public CTDxfsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public CTDxf addNewDxf() {
        CTDxf cTDxf;
        synchronized (monitor()) {
            check_orphaned();
            cTDxf = (CTDxf) get_store().add_element_user(DXF$0);
        }
        return cTDxf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public CTDxf getDxfArray(int i) {
        CTDxf cTDxf;
        synchronized (monitor()) {
            check_orphaned();
            cTDxf = (CTDxf) get_store().find_element_user(DXF$0, i);
            if (cTDxf == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDxf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public CTDxf[] getDxfArray() {
        CTDxf[] cTDxfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DXF$0, arrayList);
            cTDxfArr = new CTDxf[arrayList.size()];
            arrayList.toArray(cTDxfArr);
        }
        return cTDxfArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public List<CTDxf> getDxfList() {
        1DxfList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DxfList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public CTDxf insertNewDxf(int i) {
        CTDxf cTDxf;
        synchronized (monitor()) {
            check_orphaned();
            cTDxf = (CTDxf) get_store().insert_element_user(DXF$0, i);
        }
        return cTDxf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public void removeDxf(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DXF$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public void setDxfArray(int i, CTDxf cTDxf) {
        synchronized (monitor()) {
            check_orphaned();
            CTDxf cTDxf2 = (CTDxf) get_store().find_element_user(DXF$0, i);
            if (cTDxf2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDxf2.set(cTDxf);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public void setDxfArray(CTDxf[] cTDxfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDxfArr, DXF$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public int sizeOfDxfArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DXF$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
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
