package com.microsoft.schemas.office.x2006.encryption.impl;

import aavax.xml.namespace.QName;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* loaded from: classes3.dex */
public class CTKeyEncryptorsImpl extends XmlComplexContentImpl implements CTKeyEncryptors {
    private static final QName KEYENCRYPTOR$0 = new QName("http://schemas.microsoft.com/office/2006/encryption", "keyEncryptor");

    public CTKeyEncryptorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public CTKeyEncryptor addNewKeyEncryptor() {
        CTKeyEncryptor cTKeyEncryptor;
        synchronized (monitor()) {
            check_orphaned();
            cTKeyEncryptor = (CTKeyEncryptor) get_store().add_element_user(KEYENCRYPTOR$0);
        }
        return cTKeyEncryptor;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public CTKeyEncryptor getKeyEncryptorArray(int i) {
        CTKeyEncryptor cTKeyEncryptor;
        synchronized (monitor()) {
            check_orphaned();
            cTKeyEncryptor = (CTKeyEncryptor) get_store().find_element_user(KEYENCRYPTOR$0, i);
            if (cTKeyEncryptor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTKeyEncryptor;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public CTKeyEncryptor[] getKeyEncryptorArray() {
        CTKeyEncryptor[] cTKeyEncryptorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(KEYENCRYPTOR$0, arrayList);
            cTKeyEncryptorArr = new CTKeyEncryptor[arrayList.size()];
            arrayList.toArray(cTKeyEncryptorArr);
        }
        return cTKeyEncryptorArr;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public List<CTKeyEncryptor> getKeyEncryptorList() {
        AbstractList<CTKeyEncryptor> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTKeyEncryptor>() { // from class: com.microsoft.schemas.office.x2006.encryption.impl.CTKeyEncryptorsImpl.1KeyEncryptorList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTKeyEncryptor cTKeyEncryptor) {
                    CTKeyEncryptorsImpl.this.insertNewKeyEncryptor(i).set(cTKeyEncryptor);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTKeyEncryptor get(int i) {
                    return CTKeyEncryptorsImpl.this.getKeyEncryptorArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTKeyEncryptor remove(int i) {
                    CTKeyEncryptor keyEncryptorArray = CTKeyEncryptorsImpl.this.getKeyEncryptorArray(i);
                    CTKeyEncryptorsImpl.this.removeKeyEncryptor(i);
                    return keyEncryptorArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTKeyEncryptor set(int i, CTKeyEncryptor cTKeyEncryptor) {
                    CTKeyEncryptor keyEncryptorArray = CTKeyEncryptorsImpl.this.getKeyEncryptorArray(i);
                    CTKeyEncryptorsImpl.this.setKeyEncryptorArray(i, cTKeyEncryptor);
                    return keyEncryptorArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTKeyEncryptorsImpl.this.sizeOfKeyEncryptorArray();
                }
            };
        }
        return abstractList;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public CTKeyEncryptor insertNewKeyEncryptor(int i) {
        CTKeyEncryptor cTKeyEncryptor;
        synchronized (monitor()) {
            check_orphaned();
            cTKeyEncryptor = (CTKeyEncryptor) get_store().insert_element_user(KEYENCRYPTOR$0, i);
        }
        return cTKeyEncryptor;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public void removeKeyEncryptor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEYENCRYPTOR$0, i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public void setKeyEncryptorArray(int i, CTKeyEncryptor cTKeyEncryptor) {
        synchronized (monitor()) {
            check_orphaned();
            CTKeyEncryptor cTKeyEncryptor2 = (CTKeyEncryptor) get_store().find_element_user(KEYENCRYPTOR$0, i);
            if (cTKeyEncryptor2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTKeyEncryptor2.set(cTKeyEncryptor);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public void setKeyEncryptorArray(CTKeyEncryptor[] cTKeyEncryptorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTKeyEncryptorArr, KEYENCRYPTOR$0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors
    public int sizeOfKeyEncryptorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(KEYENCRYPTOR$0);
        }
        return count_elements;
    }
}
