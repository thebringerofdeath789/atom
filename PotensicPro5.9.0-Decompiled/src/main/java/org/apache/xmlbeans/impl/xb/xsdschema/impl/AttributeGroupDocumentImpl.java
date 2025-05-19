package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;

/* loaded from: classes5.dex */
public class AttributeGroupDocumentImpl extends XmlComplexContentImpl implements AttributeGroupDocument {
    private static final QName ATTRIBUTEGROUP$0 = new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup");

    public AttributeGroupDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument
    public NamedAttributeGroup getAttributeGroup() {
        synchronized (monitor()) {
            check_orphaned();
            NamedAttributeGroup namedAttributeGroup = (NamedAttributeGroup) get_store().find_element_user(ATTRIBUTEGROUP$0, 0);
            if (namedAttributeGroup == null) {
                return null;
            }
            return namedAttributeGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument
    public void setAttributeGroup(NamedAttributeGroup namedAttributeGroup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ATTRIBUTEGROUP$0;
            NamedAttributeGroup namedAttributeGroup2 = (NamedAttributeGroup) typeStore.find_element_user(qName, 0);
            if (namedAttributeGroup2 == null) {
                namedAttributeGroup2 = (NamedAttributeGroup) get_store().add_element_user(qName);
            }
            namedAttributeGroup2.set(namedAttributeGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument
    public NamedAttributeGroup addNewAttributeGroup() {
        NamedAttributeGroup namedAttributeGroup;
        synchronized (monitor()) {
            check_orphaned();
            namedAttributeGroup = (NamedAttributeGroup) get_store().add_element_user(ATTRIBUTEGROUP$0);
        }
        return namedAttributeGroup;
    }
}
