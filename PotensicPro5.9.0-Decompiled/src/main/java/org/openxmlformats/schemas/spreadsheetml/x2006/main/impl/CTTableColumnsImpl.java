package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;

/* loaded from: classes6.dex */
public class CTTableColumnsImpl extends XmlComplexContentImpl implements CTTableColumns {
    private static final QName TABLECOLUMN$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableColumn");
    private static final QName COUNT$2 = new QName("", "count");

    public CTTableColumnsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public CTTableColumn addNewTableColumn() {
        CTTableColumn cTTableColumn;
        synchronized (monitor()) {
            check_orphaned();
            cTTableColumn = (CTTableColumn) get_store().add_element_user(TABLECOLUMN$0);
        }
        return cTTableColumn;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public CTTableColumn getTableColumnArray(int i) {
        CTTableColumn cTTableColumn;
        synchronized (monitor()) {
            check_orphaned();
            cTTableColumn = (CTTableColumn) get_store().find_element_user(TABLECOLUMN$0, i);
            if (cTTableColumn == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableColumn;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public CTTableColumn[] getTableColumnArray() {
        CTTableColumn[] cTTableColumnArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TABLECOLUMN$0, arrayList);
            cTTableColumnArr = new CTTableColumn[arrayList.size()];
            arrayList.toArray(cTTableColumnArr);
        }
        return cTTableColumnArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public List<CTTableColumn> getTableColumnList() {
        1TableColumnList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TableColumnList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public CTTableColumn insertNewTableColumn(int i) {
        CTTableColumn cTTableColumn;
        synchronized (monitor()) {
            check_orphaned();
            cTTableColumn = (CTTableColumn) get_store().insert_element_user(TABLECOLUMN$0, i);
        }
        return cTTableColumn;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public void removeTableColumn(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLECOLUMN$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public void setTableColumnArray(int i, CTTableColumn cTTableColumn) {
        synchronized (monitor()) {
            check_orphaned();
            CTTableColumn cTTableColumn2 = (CTTableColumn) get_store().find_element_user(TABLECOLUMN$0, i);
            if (cTTableColumn2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTableColumn2.set(cTTableColumn);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public void setTableColumnArray(CTTableColumn[] cTTableColumnArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTableColumnArr, TABLECOLUMN$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public int sizeOfTableColumnArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TABLECOLUMN$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns
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
