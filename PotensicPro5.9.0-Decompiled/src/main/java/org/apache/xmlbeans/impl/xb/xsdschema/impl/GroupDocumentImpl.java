package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;

/* loaded from: classes5.dex */
public class GroupDocumentImpl extends XmlComplexContentImpl implements GroupDocument {
    private static final QName GROUP$0 = new QName("http://www.w3.org/2001/XMLSchema", "group");

    public GroupDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public NamedGroup getGroup() {
        synchronized (monitor()) {
            check_orphaned();
            NamedGroup namedGroup = (NamedGroup) get_store().find_element_user(GROUP$0, 0);
            if (namedGroup == null) {
                return null;
            }
            return namedGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public void setGroup(NamedGroup namedGroup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GROUP$0;
            NamedGroup namedGroup2 = (NamedGroup) typeStore.find_element_user(qName, 0);
            if (namedGroup2 == null) {
                namedGroup2 = (NamedGroup) get_store().add_element_user(qName);
            }
            namedGroup2.set(namedGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public NamedGroup addNewGroup() {
        NamedGroup namedGroup;
        synchronized (monitor()) {
            check_orphaned();
            namedGroup = (NamedGroup) get_store().add_element_user(GROUP$0);
        }
        return namedGroup;
    }
}
