package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* loaded from: classes5.dex */
public class AttributeGroupImpl extends AnnotatedImpl implements AttributeGroup {
    private static final QName ATTRIBUTE$0 = new QName("http://www.w3.org/2001/XMLSchema", "attribute");
    private static final QName ATTRIBUTEGROUP$2 = new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup");
    private static final QName ANYATTRIBUTE$4 = new QName("http://www.w3.org/2001/XMLSchema", "anyAttribute");
    private static final QName NAME$6 = new QName("", "name");
    private static final QName REF$8 = new QName("", "ref");

    public AttributeGroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Attribute[] getAttributeArray() {
        Attribute[] attributeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTE$0, arrayList);
            attributeArr = new Attribute[arrayList.size()];
            arrayList.toArray(attributeArr);
        }
        return attributeArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Attribute getAttributeArray(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().find_element_user(ATTRIBUTE$0, i);
            if (attribute == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public int sizeOfAttributeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ATTRIBUTE$0);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAttributeArray(Attribute[] attributeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(attributeArr, ATTRIBUTE$0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAttributeArray(int i, Attribute attribute) {
        synchronized (monitor()) {
            check_orphaned();
            Attribute attribute2 = (Attribute) get_store().find_element_user(ATTRIBUTE$0, i);
            if (attribute2 == null) {
                throw new IndexOutOfBoundsException();
            }
            attribute2.set(attribute);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Attribute insertNewAttribute(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().insert_element_user(ATTRIBUTE$0, i);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Attribute addNewAttribute() {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().add_element_user(ATTRIBUTE$0);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void removeAttribute(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTE$0, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public AttributeGroupRef[] getAttributeGroupArray() {
        AttributeGroupRef[] attributeGroupRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTEGROUP$2, arrayList);
            attributeGroupRefArr = new AttributeGroupRef[arrayList.size()];
            arrayList.toArray(attributeGroupRefArr);
        }
        return attributeGroupRefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public AttributeGroupRef getAttributeGroupArray(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().find_element_user(ATTRIBUTEGROUP$2, i);
            if (attributeGroupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public int sizeOfAttributeGroupArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ATTRIBUTEGROUP$2);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(attributeGroupRefArr, ATTRIBUTEGROUP$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef) {
        synchronized (monitor()) {
            check_orphaned();
            AttributeGroupRef attributeGroupRef2 = (AttributeGroupRef) get_store().find_element_user(ATTRIBUTEGROUP$2, i);
            if (attributeGroupRef2 == null) {
                throw new IndexOutOfBoundsException();
            }
            attributeGroupRef2.set(attributeGroupRef);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public AttributeGroupRef insertNewAttributeGroup(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().insert_element_user(ATTRIBUTEGROUP$2, i);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public AttributeGroupRef addNewAttributeGroup() {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().add_element_user(ATTRIBUTEGROUP$2);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void removeAttributeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEGROUP$2, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Wildcard getAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            Wildcard wildcard = (Wildcard) get_store().find_element_user(ANYATTRIBUTE$4, 0);
            if (wildcard == null) {
                return null;
            }
            return wildcard;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public boolean isSetAnyAttribute() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ANYATTRIBUTE$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAnyAttribute(Wildcard wildcard) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANYATTRIBUTE$4;
            Wildcard wildcard2 = (Wildcard) typeStore.find_element_user(qName, 0);
            if (wildcard2 == null) {
                wildcard2 = (Wildcard) get_store().add_element_user(qName);
            }
            wildcard2.set(wildcard);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(ANYATTRIBUTE$4);
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void unsetAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANYATTRIBUTE$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(NAME$6);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$6;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qName);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCName2.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public QName getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REF$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public XmlQName xgetRef() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(REF$8);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = REF$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$8;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$8);
        }
    }
}
