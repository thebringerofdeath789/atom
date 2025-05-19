package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

/* loaded from: classes6.dex */
public class CTAuthorsImpl extends XmlComplexContentImpl implements CTAuthors {
    private static final QName AUTHOR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "author");

    public CTAuthorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void addAuthor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(AUTHOR$0)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public STXstring addNewAuthor() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().add_element_user(AUTHOR$0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public String getAuthorArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTHOR$0, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public String[] getAuthorArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTHOR$0, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public List<String> getAuthorList() {
        1AuthorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AuthorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void insertAuthor(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(AUTHOR$0, i)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public STXstring insertNewAuthor(int i) {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().insert_element_user(AUTHOR$0, i);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void removeAuthor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTHOR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void setAuthorArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTHOR$0, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void setAuthorArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, AUTHOR$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public int sizeOfAuthorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(AUTHOR$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public STXstring xgetAuthorArray(int i) {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_element_user(AUTHOR$0, i);
            if (sTXstring == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public STXstring[] xgetAuthorArray() {
        STXstring[] sTXstringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTHOR$0, arrayList);
            sTXstringArr = new STXstring[arrayList.size()];
            arrayList.toArray(sTXstringArr);
        }
        return sTXstringArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public List<STXstring> xgetAuthorList() {
        2AuthorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2AuthorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void xsetAuthorArray(int i, STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            STXstring sTXstring2 = (STXstring) get_store().find_element_user(AUTHOR$0, i);
            if (sTXstring2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void xsetAuthorArray(STXstring[] sTXstringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTXstringArr, AUTHOR$0);
        }
    }
}
