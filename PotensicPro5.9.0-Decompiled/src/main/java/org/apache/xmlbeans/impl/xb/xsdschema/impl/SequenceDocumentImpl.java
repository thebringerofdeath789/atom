package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument;

/* loaded from: classes5.dex */
public class SequenceDocumentImpl extends XmlComplexContentImpl implements SequenceDocument {
    private static final QName SEQUENCE$0 = new QName("http://www.w3.org/2001/XMLSchema", "sequence");

    public SequenceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument
    public ExplicitGroup getSequence() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$0, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument
    public void setSequence(ExplicitGroup explicitGroup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SEQUENCE$0;
            ExplicitGroup explicitGroup2 = (ExplicitGroup) typeStore.find_element_user(qName, 0);
            if (explicitGroup2 == null) {
                explicitGroup2 = (ExplicitGroup) get_store().add_element_user(qName);
            }
            explicitGroup2.set(explicitGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$0);
        }
        return explicitGroup;
    }
}
