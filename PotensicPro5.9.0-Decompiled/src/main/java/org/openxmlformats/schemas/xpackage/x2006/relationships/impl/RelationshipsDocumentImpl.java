package org.openxmlformats.schemas.xpackage.x2006.relationships.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships;
import org.openxmlformats.schemas.xpackage.x2006.relationships.RelationshipsDocument;

/* loaded from: classes6.dex */
public class RelationshipsDocumentImpl extends XmlComplexContentImpl implements RelationshipsDocument {
    private static final QName RELATIONSHIPS$0 = new QName(PackageNamespaces.RELATIONSHIPS, PackageRelationship.RELATIONSHIPS_TAG_NAME);

    public RelationshipsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.RelationshipsDocument
    public CTRelationships addNewRelationships() {
        CTRelationships cTRelationships;
        synchronized (monitor()) {
            check_orphaned();
            cTRelationships = (CTRelationships) get_store().add_element_user(RELATIONSHIPS$0);
        }
        return cTRelationships;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.RelationshipsDocument
    public CTRelationships getRelationships() {
        synchronized (monitor()) {
            check_orphaned();
            CTRelationships cTRelationships = (CTRelationships) get_store().find_element_user(RELATIONSHIPS$0, 0);
            if (cTRelationships == null) {
                return null;
            }
            return cTRelationships;
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.RelationshipsDocument
    public void setRelationships(CTRelationships cTRelationships) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELATIONSHIPS$0;
            CTRelationships cTRelationships2 = (CTRelationships) typeStore.find_element_user(qName, 0);
            if (cTRelationships2 == null) {
                cTRelationships2 = (CTRelationships) get_store().add_element_user(qName);
            }
            cTRelationships2.set(cTRelationships);
        }
    }
}
