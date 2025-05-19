package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBoolean;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDateTime;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMissing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumber;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTString;

/* loaded from: classes6.dex */
public class CTSharedItemsImpl extends XmlComplexContentImpl implements CTSharedItems {
    private static final QName M$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "m");
    private static final QName N$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "n");
    private static final QName B$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b");
    private static final QName E$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "e");
    private static final QName S$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "s");
    private static final QName D$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "d");
    private static final QName CONTAINSSEMIMIXEDTYPES$12 = new QName("", "containsSemiMixedTypes");
    private static final QName CONTAINSNONDATE$14 = new QName("", "containsNonDate");
    private static final QName CONTAINSDATE$16 = new QName("", "containsDate");
    private static final QName CONTAINSSTRING$18 = new QName("", "containsString");
    private static final QName CONTAINSBLANK$20 = new QName("", "containsBlank");
    private static final QName CONTAINSMIXEDTYPES$22 = new QName("", "containsMixedTypes");
    private static final QName CONTAINSNUMBER$24 = new QName("", "containsNumber");
    private static final QName CONTAINSINTEGER$26 = new QName("", "containsInteger");
    private static final QName MINVALUE$28 = new QName("", "minValue");
    private static final QName MAXVALUE$30 = new QName("", "maxValue");
    private static final QName MINDATE$32 = new QName("", "minDate");
    private static final QName MAXDATE$34 = new QName("", "maxDate");
    private static final QName COUNT$36 = new QName("", "count");
    private static final QName LONGTEXT$38 = new QName("", "longText");

    public CTSharedItemsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean addNewB() {
        CTBoolean add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(B$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime addNewD() {
        CTDateTime add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(D$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError addNewE() {
        CTError add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(E$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing addNewM() {
        CTMissing add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(M$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber addNewN() {
        CTNumber add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(N$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString addNewS() {
        CTString add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(S$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean getBArray(int i) {
        CTBoolean find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(B$4, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean[] getBArray() {
        CTBoolean[] cTBooleanArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(B$4, arrayList);
            cTBooleanArr = new CTBoolean[arrayList.size()];
            arrayList.toArray(cTBooleanArr);
        }
        return cTBooleanArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTBoolean> getBList() {
        1BList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsBlank() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSBLANK$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsDate() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSDATE$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsInteger() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSINTEGER$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSMIXEDTYPES$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsNonDate() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNONDATE$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsNumber() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNUMBER$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsSemiMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSEMIMIXEDTYPES$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsString() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSTRING$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COUNT$36);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime getDArray(int i) {
        CTDateTime find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(D$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime[] getDArray() {
        CTDateTime[] cTDateTimeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(D$10, arrayList);
            cTDateTimeArr = new CTDateTime[arrayList.size()];
            arrayList.toArray(cTDateTimeArr);
        }
        return cTDateTimeArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTDateTime> getDList() {
        1DList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError getEArray(int i) {
        CTError find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(E$6, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError[] getEArray() {
        CTError[] cTErrorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(E$6, arrayList);
            cTErrorArr = new CTError[arrayList.size()];
            arrayList.toArray(cTErrorArr);
        }
        return cTErrorArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTError> getEList() {
        1EList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getLongText() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LONGTEXT$38;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing getMArray(int i) {
        CTMissing find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(M$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing[] getMArray() {
        CTMissing[] cTMissingArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(M$0, arrayList);
            cTMissingArr = new CTMissing[arrayList.size()];
            arrayList.toArray(cTMissingArr);
        }
        return cTMissingArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTMissing> getMList() {
        1MList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public Calendar getMaxDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MAXDATE$34);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public double getMaxValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MAXVALUE$30);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public Calendar getMinDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MINDATE$32);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public double getMinValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MINVALUE$28);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber getNArray(int i) {
        CTNumber find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(N$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber[] getNArray() {
        CTNumber[] cTNumberArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(N$2, arrayList);
            cTNumberArr = new CTNumber[arrayList.size()];
            arrayList.toArray(cTNumberArr);
        }
        return cTNumberArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTNumber> getNList() {
        1NList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString getSArray(int i) {
        CTString find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(S$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString[] getSArray() {
        CTString[] cTStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(S$8, arrayList);
            cTStringArr = new CTString[arrayList.size()];
            arrayList.toArray(cTStringArr);
        }
        return cTStringArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTString> getSList() {
        1SList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean insertNewB(int i) {
        CTBoolean insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(B$4, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime insertNewD(int i) {
        CTDateTime insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(D$10, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError insertNewE(int i) {
        CTError insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(E$6, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing insertNewM(int i) {
        CTMissing insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(M$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber insertNewN(int i) {
        CTNumber insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(N$2, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString insertNewS(int i) {
        CTString insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(S$8, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsBlank() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSBLANK$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSDATE$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsInteger() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSINTEGER$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsMixedTypes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSMIXEDTYPES$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsNonDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSNONDATE$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsNumber() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSNUMBER$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsSemiMixedTypes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSSEMIMIXEDTYPES$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsString() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSSTRING$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetLongText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LONGTEXT$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMaxDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXDATE$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMaxValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXVALUE$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMinDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINDATE$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMinValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINVALUE$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeB(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(B$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeD(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(D$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeE(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(E$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeM(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(M$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeN(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(N$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeS(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(S$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setBArray(int i, CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean find_element_user = get_store().find_element_user(B$4, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setBArray(CTBoolean[] cTBooleanArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBooleanArr, B$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsBlank(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSBLANK$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsDate(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSDATE$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsInteger(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSINTEGER$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsMixedTypes(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSMIXEDTYPES$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsNonDate(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNONDATE$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsNumber(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNUMBER$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsSemiMixedTypes(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSEMIMIXEDTYPES$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsString(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSTRING$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$36;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setDArray(int i, CTDateTime cTDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            CTDateTime find_element_user = get_store().find_element_user(D$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setDArray(CTDateTime[] cTDateTimeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTDateTimeArr, D$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setEArray(int i, CTError cTError) {
        synchronized (monitor()) {
            check_orphaned();
            CTError find_element_user = get_store().find_element_user(E$6, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTError);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setEArray(CTError[] cTErrorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTErrorArr, E$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setLongText(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LONGTEXT$38;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMArray(int i, CTMissing cTMissing) {
        synchronized (monitor()) {
            check_orphaned();
            CTMissing find_element_user = get_store().find_element_user(M$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTMissing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMArray(CTMissing[] cTMissingArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTMissingArr, M$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMaxDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXDATE$34;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMaxValue(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXVALUE$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMinDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINDATE$32;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMinValue(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINVALUE$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setNArray(int i, CTNumber cTNumber) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumber find_element_user = get_store().find_element_user(N$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTNumber);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setNArray(CTNumber[] cTNumberArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTNumberArr, N$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setSArray(int i, CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            CTString find_element_user = get_store().find_element_user(S$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setSArray(CTString[] cTStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTStringArr, S$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfBArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(B$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfDArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(D$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfEArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(E$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfMArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(M$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfNArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(N$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfSArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(S$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsBlank() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSBLANK$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSDATE$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsInteger() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSINTEGER$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSMIXEDTYPES$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsNonDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSNONDATE$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsNumber() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSNUMBER$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsSemiMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSSEMIMIXEDTYPES$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsString() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSSTRING$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$36);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetLongText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LONGTEXT$38);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMaxDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXDATE$34);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMaxValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXVALUE$30);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMinDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINDATE$32);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMinValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINVALUE$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsBlank() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSBLANK$20;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsDate() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSDATE$16;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsInteger() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSINTEGER$26;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsMixedTypes() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSMIXEDTYPES$22;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsNonDate() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNONDATE$14;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsNumber() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNUMBER$24;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsSemiMixedTypes() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSEMIMIXEDTYPES$12;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsString() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSTRING$18;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(COUNT$36);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetLongText() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LONGTEXT$38;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDateTime xgetMaxDate() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_attribute_user(MAXDATE$34);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDouble xgetMaxValue() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(MAXVALUE$30);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDateTime xgetMinDate() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_attribute_user(MINDATE$32);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDouble xgetMinValue() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(MINVALUE$28);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsBlank(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSBLANK$20;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsDate(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSDATE$16;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsInteger(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSINTEGER$26;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsMixedTypes(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSMIXEDTYPES$22;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsNonDate(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNONDATE$14;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsNumber(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNUMBER$24;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsSemiMixedTypes(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSEMIMIXEDTYPES$12;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsString(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSTRING$18;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$36;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetLongText(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LONGTEXT$38;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMaxDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXDATE$34;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_attribute_user(qName);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_attribute_user(qName);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMaxValue(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXVALUE$30;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMinDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINDATE$32;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_attribute_user(qName);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_attribute_user(qName);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMinValue(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINVALUE$28;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }
}
