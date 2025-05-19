package org.openxmlformats.schemas.xpackage.x2006.relationships.impl;

import aavax.xml.namespace.QName;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships;

/* loaded from: classes6.dex */
public class CTRelationshipsImpl extends XmlComplexContentImpl implements CTRelationships {
    private static final QName RELATIONSHIP$0 = new QName(PackageNamespaces.RELATIONSHIPS, PackageRelationship.RELATIONSHIP_TAG_NAME);

    public CTRelationshipsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public CTRelationship addNewRelationship() {
        CTRelationship cTRelationship;
        synchronized (monitor()) {
            check_orphaned();
            cTRelationship = (CTRelationship) get_store().add_element_user(RELATIONSHIP$0);
        }
        return cTRelationship;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public CTRelationship getRelationshipArray(int i) {
        CTRelationship cTRelationship;
        synchronized (monitor()) {
            check_orphaned();
            cTRelationship = (CTRelationship) get_store().find_element_user(RELATIONSHIP$0, i);
            if (cTRelationship == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRelationship;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public CTRelationship[] getRelationshipArray() {
        CTRelationship[] cTRelationshipArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RELATIONSHIP$0, arrayList);
            cTRelationshipArr = new CTRelationship[arrayList.size()];
            arrayList.toArray(cTRelationshipArr);
        }
        return cTRelationshipArr;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public List<CTRelationship> getRelationshipList() {
        AbstractList<CTRelationship> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRelationship>() { // from class: org.openxmlformats.schemas.xpackage.x2006.relationships.impl.CTRelationshipsImpl.1RelationshipList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRelationship cTRelationship) {
                    CTRelationshipsImpl.this.insertNewRelationship(i).set(cTRelationship);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRelationship get(int i) {
                    return CTRelationshipsImpl.this.getRelationshipArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRelationship remove(int i) {
                    CTRelationship relationshipArray = CTRelationshipsImpl.this.getRelationshipArray(i);
                    CTRelationshipsImpl.this.removeRelationship(i);
                    return relationshipArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRelationship set(int i, CTRelationship cTRelationship) {
                    CTRelationship relationshipArray = CTRelationshipsImpl.this.getRelationshipArray(i);
                    CTRelationshipsImpl.this.setRelationshipArray(i, cTRelationship);
                    return relationshipArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTRelationshipsImpl.this.sizeOfRelationshipArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public CTRelationship insertNewRelationship(int i) {
        CTRelationship cTRelationship;
        synchronized (monitor()) {
            check_orphaned();
            cTRelationship = (CTRelationship) get_store().insert_element_user(RELATIONSHIP$0, i);
        }
        return cTRelationship;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public void removeRelationship(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RELATIONSHIP$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public void setRelationshipArray(int i, CTRelationship cTRelationship) {
        synchronized (monitor()) {
            check_orphaned();
            CTRelationship cTRelationship2 = (CTRelationship) get_store().find_element_user(RELATIONSHIP$0, i);
            if (cTRelationship2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRelationship2.set(cTRelationship);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public void setRelationshipArray(CTRelationship[] cTRelationshipArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRelationshipArr, RELATIONSHIP$0);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
    public int sizeOfRelationshipArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(RELATIONSHIP$0);
        }
        return count_elements;
    }
}
