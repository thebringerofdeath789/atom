package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* loaded from: classes5.dex */
public class CTOfficeArtExtensionListImpl extends XmlComplexContentImpl implements CTOfficeArtExtensionList {
    private static final QName EXT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ext");

    public CTOfficeArtExtensionListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public CTOfficeArtExtension addNewExt() {
        CTOfficeArtExtension cTOfficeArtExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtension = (CTOfficeArtExtension) get_store().add_element_user(EXT$0);
        }
        return cTOfficeArtExtension;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public CTOfficeArtExtension getExtArray(int i) {
        CTOfficeArtExtension cTOfficeArtExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtension = (CTOfficeArtExtension) get_store().find_element_user(EXT$0, i);
            if (cTOfficeArtExtension == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOfficeArtExtension;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public CTOfficeArtExtension[] getExtArray() {
        CTOfficeArtExtension[] cTOfficeArtExtensionArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXT$0, arrayList);
            cTOfficeArtExtensionArr = new CTOfficeArtExtension[arrayList.size()];
            arrayList.toArray(cTOfficeArtExtensionArr);
        }
        return cTOfficeArtExtensionArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public List<CTOfficeArtExtension> getExtList() {
        1ExtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public CTOfficeArtExtension insertNewExt(int i) {
        CTOfficeArtExtension cTOfficeArtExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtension = (CTOfficeArtExtension) get_store().insert_element_user(EXT$0, i);
        }
        return cTOfficeArtExtension;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public void removeExt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public void setExtArray(int i, CTOfficeArtExtension cTOfficeArtExtension) {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtension cTOfficeArtExtension2 = (CTOfficeArtExtension) get_store().find_element_user(EXT$0, i);
            if (cTOfficeArtExtension2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOfficeArtExtension2.set(cTOfficeArtExtension);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public void setExtArray(CTOfficeArtExtension[] cTOfficeArtExtensionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOfficeArtExtensionArr, EXT$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public int sizeOfExtArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EXT$0);
        }
        return count_elements;
    }
}
