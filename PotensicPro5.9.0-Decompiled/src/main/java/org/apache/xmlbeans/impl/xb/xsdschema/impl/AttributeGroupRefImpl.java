package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;

/* loaded from: classes5.dex */
public class AttributeGroupRefImpl extends AttributeGroupImpl implements AttributeGroupRef {
    private static final QName REF$0 = new QName("", "ref");

    public AttributeGroupRefImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public QName getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REF$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public XmlQName xgetRef() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(REF$0);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = REF$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$0;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$0);
        }
    }
}
