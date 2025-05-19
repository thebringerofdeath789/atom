package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;

/* loaded from: classes6.dex */
public class CTTablePartsImpl extends XmlComplexContentImpl implements CTTableParts {
    private static final QName TABLEPART$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tablePart");
    private static final QName COUNT$2 = new QName("", "count");

    public CTTablePartsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public CTTablePart addNewTablePart() {
        CTTablePart cTTablePart;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePart = (CTTablePart) get_store().add_element_user(TABLEPART$0);
        }
        return cTTablePart;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public CTTablePart getTablePartArray(int i) {
        CTTablePart cTTablePart;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePart = (CTTablePart) get_store().find_element_user(TABLEPART$0, i);
            if (cTTablePart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTablePart;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public CTTablePart[] getTablePartArray() {
        CTTablePart[] cTTablePartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TABLEPART$0, arrayList);
            cTTablePartArr = new CTTablePart[arrayList.size()];
            arrayList.toArray(cTTablePartArr);
        }
        return cTTablePartArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public List<CTTablePart> getTablePartList() {
        1TablePartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TablePartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public CTTablePart insertNewTablePart(int i) {
        CTTablePart cTTablePart;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePart = (CTTablePart) get_store().insert_element_user(TABLEPART$0, i);
        }
        return cTTablePart;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public void removeTablePart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLEPART$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public void setTablePartArray(int i, CTTablePart cTTablePart) {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePart cTTablePart2 = (CTTablePart) get_store().find_element_user(TABLEPART$0, i);
            if (cTTablePart2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTablePart2.set(cTTablePart);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public void setTablePartArray(CTTablePart[] cTTablePartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTablePartArr, TABLEPART$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public int sizeOfTablePartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TABLEPART$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
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
