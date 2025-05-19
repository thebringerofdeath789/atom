package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;

/* loaded from: classes5.dex */
public class ChoiceDocumentImpl extends XmlComplexContentImpl implements ChoiceDocument {
    private static final QName CHOICE$0 = new QName("http://www.w3.org/2001/XMLSchema", "choice");

    public ChoiceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument
    public ExplicitGroup getChoice() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$0, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument
    public void setChoice(ExplicitGroup explicitGroup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHOICE$0;
            ExplicitGroup explicitGroup2 = (ExplicitGroup) typeStore.find_element_user(qName, 0);
            if (explicitGroup2 == null) {
                explicitGroup2 = (ExplicitGroup) get_store().add_element_user(qName);
            }
            explicitGroup2.set(explicitGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$0);
        }
        return explicitGroup;
    }
}
