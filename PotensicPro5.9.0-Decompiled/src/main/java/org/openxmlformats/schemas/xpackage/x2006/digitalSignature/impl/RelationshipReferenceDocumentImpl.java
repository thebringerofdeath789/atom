package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.RelationshipReferenceDocument;

/* loaded from: classes6.dex */
public class RelationshipReferenceDocumentImpl extends XmlComplexContentImpl implements RelationshipReferenceDocument {
    private static final QName RELATIONSHIPREFERENCE$0 = new QName("http://schemas.openxmlformats.org/package/2006/digital-signature", "RelationshipReference");

    public RelationshipReferenceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.RelationshipReferenceDocument
    public CTRelationshipReference addNewRelationshipReference() {
        CTRelationshipReference cTRelationshipReference;
        synchronized (monitor()) {
            check_orphaned();
            cTRelationshipReference = (CTRelationshipReference) get_store().add_element_user(RELATIONSHIPREFERENCE$0);
        }
        return cTRelationshipReference;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.RelationshipReferenceDocument
    public CTRelationshipReference getRelationshipReference() {
        synchronized (monitor()) {
            check_orphaned();
            CTRelationshipReference cTRelationshipReference = (CTRelationshipReference) get_store().find_element_user(RELATIONSHIPREFERENCE$0, 0);
            if (cTRelationshipReference == null) {
                return null;
            }
            return cTRelationshipReference;
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.RelationshipReferenceDocument
    public void setRelationshipReference(CTRelationshipReference cTRelationshipReference) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELATIONSHIPREFERENCE$0;
            CTRelationshipReference cTRelationshipReference2 = (CTRelationshipReference) typeStore.find_element_user(qName, 0);
            if (cTRelationshipReference2 == null) {
                cTRelationshipReference2 = (CTRelationshipReference) get_store().add_element_user(qName);
            }
            cTRelationshipReference2.set(cTRelationshipReference);
        }
    }
}
