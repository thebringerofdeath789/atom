package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields;

/* loaded from: classes6.dex */
public class CTPageFieldsImpl extends XmlComplexContentImpl implements CTPageFields {
    private static final QName PAGEFIELD$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageField");
    private static final QName COUNT$2 = new QName("", "count");

    public CTPageFieldsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public CTPageField addNewPageField() {
        CTPageField cTPageField;
        synchronized (monitor()) {
            check_orphaned();
            cTPageField = (CTPageField) get_store().add_element_user(PAGEFIELD$0);
        }
        return cTPageField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public CTPageField getPageFieldArray(int i) {
        CTPageField cTPageField;
        synchronized (monitor()) {
            check_orphaned();
            cTPageField = (CTPageField) get_store().find_element_user(PAGEFIELD$0, i);
            if (cTPageField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPageField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public CTPageField[] getPageFieldArray() {
        CTPageField[] cTPageFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PAGEFIELD$0, arrayList);
            cTPageFieldArr = new CTPageField[arrayList.size()];
            arrayList.toArray(cTPageFieldArr);
        }
        return cTPageFieldArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public List<CTPageField> getPageFieldList() {
        1PageFieldList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PageFieldList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public CTPageField insertNewPageField(int i) {
        CTPageField cTPageField;
        synchronized (monitor()) {
            check_orphaned();
            cTPageField = (CTPageField) get_store().insert_element_user(PAGEFIELD$0, i);
        }
        return cTPageField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public void removePageField(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGEFIELD$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public void setPageFieldArray(int i, CTPageField cTPageField) {
        synchronized (monitor()) {
            check_orphaned();
            CTPageField cTPageField2 = (CTPageField) get_store().find_element_user(PAGEFIELD$0, i);
            if (cTPageField2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPageField2.set(cTPageField);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public void setPageFieldArray(CTPageField[] cTPageFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPageFieldArr, PAGEFIELD$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public int sizeOfPageFieldArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PAGEFIELD$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
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
