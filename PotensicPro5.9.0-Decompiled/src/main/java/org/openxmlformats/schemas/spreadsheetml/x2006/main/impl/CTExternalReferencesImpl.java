package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences;

/* loaded from: classes6.dex */
public class CTExternalReferencesImpl extends XmlComplexContentImpl implements CTExternalReferences {
    private static final QName EXTERNALREFERENCE$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalReference");

    public CTExternalReferencesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public CTExternalReference addNewExternalReference() {
        CTExternalReference cTExternalReference;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReference = (CTExternalReference) get_store().add_element_user(EXTERNALREFERENCE$0);
        }
        return cTExternalReference;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public CTExternalReference getExternalReferenceArray(int i) {
        CTExternalReference cTExternalReference;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReference = (CTExternalReference) get_store().find_element_user(EXTERNALREFERENCE$0, i);
            if (cTExternalReference == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExternalReference;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public CTExternalReference[] getExternalReferenceArray() {
        CTExternalReference[] cTExternalReferenceArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXTERNALREFERENCE$0, arrayList);
            cTExternalReferenceArr = new CTExternalReference[arrayList.size()];
            arrayList.toArray(cTExternalReferenceArr);
        }
        return cTExternalReferenceArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public List<CTExternalReference> getExternalReferenceList() {
        1ExternalReferenceList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExternalReferenceList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public CTExternalReference insertNewExternalReference(int i) {
        CTExternalReference cTExternalReference;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReference = (CTExternalReference) get_store().insert_element_user(EXTERNALREFERENCE$0, i);
        }
        return cTExternalReference;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public void removeExternalReference(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTERNALREFERENCE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public void setExternalReferenceArray(int i, CTExternalReference cTExternalReference) {
        synchronized (monitor()) {
            check_orphaned();
            CTExternalReference cTExternalReference2 = (CTExternalReference) get_store().find_element_user(EXTERNALREFERENCE$0, i);
            if (cTExternalReference2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTExternalReference2.set(cTExternalReference);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public void setExternalReferenceArray(CTExternalReference[] cTExternalReferenceArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTExternalReferenceArr, EXTERNALREFERENCE$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public int sizeOfExternalReferenceArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EXTERNALREFERENCE$0);
        }
        return count_elements;
    }
}
