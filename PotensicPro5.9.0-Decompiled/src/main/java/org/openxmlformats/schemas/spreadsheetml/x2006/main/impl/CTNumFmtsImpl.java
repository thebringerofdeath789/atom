package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;

/* loaded from: classes6.dex */
public class CTNumFmtsImpl extends XmlComplexContentImpl implements CTNumFmts {
    private static final QName NUMFMT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "numFmt");
    private static final QName COUNT$2 = new QName("", "count");

    public CTNumFmtsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(NUMFMT$0);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public CTNumFmt getNumFmtArray(int i) {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().find_element_user(NUMFMT$0, i);
            if (cTNumFmt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public CTNumFmt[] getNumFmtArray() {
        CTNumFmt[] cTNumFmtArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NUMFMT$0, arrayList);
            cTNumFmtArr = new CTNumFmt[arrayList.size()];
            arrayList.toArray(cTNumFmtArr);
        }
        return cTNumFmtArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public List<CTNumFmt> getNumFmtList() {
        1NumFmtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NumFmtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public CTNumFmt insertNewNumFmt(int i) {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().insert_element_user(NUMFMT$0, i);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void removeNumFmt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void setNumFmtArray(int i, CTNumFmt cTNumFmt) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumFmt cTNumFmt2 = (CTNumFmt) get_store().find_element_user(NUMFMT$0, i);
            if (cTNumFmt2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNumFmt2.set(cTNumFmt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void setNumFmtArray(CTNumFmt[] cTNumFmtArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNumFmtArr, NUMFMT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public int sizeOfNumFmtArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(NUMFMT$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
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
