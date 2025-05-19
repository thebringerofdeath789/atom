package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* loaded from: classes5.dex */
public class ExtensionTypeImpl extends AnnotatedImpl implements ExtensionType {
    private static final QName GROUP$0 = new QName("http://www.w3.org/2001/XMLSchema", "group");
    private static final QName ALL$2 = new QName("http://www.w3.org/2001/XMLSchema", TtmlNode.COMBINE_ALL);
    private static final QName CHOICE$4 = new QName("http://www.w3.org/2001/XMLSchema", "choice");
    private static final QName SEQUENCE$6 = new QName("http://www.w3.org/2001/XMLSchema", "sequence");
    private static final QName ATTRIBUTE$8 = new QName("http://www.w3.org/2001/XMLSchema", "attribute");
    private static final QName ATTRIBUTEGROUP$10 = new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup");
    private static final QName ANYATTRIBUTE$12 = new QName("http://www.w3.org/2001/XMLSchema", "anyAttribute");
    private static final QName BASE$14 = new QName("", TtmlNode.RUBY_BASE);

    public ExtensionTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public GroupRef getGroup() {
        synchronized (monitor()) {
            check_orphaned();
            GroupRef groupRef = (GroupRef) get_store().find_element_user(GROUP$0, 0);
            if (groupRef == null) {
                return null;
            }
            return groupRef;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetGroup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GROUP$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setGroup(GroupRef groupRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GROUP$0;
            GroupRef groupRef2 = (GroupRef) typeStore.find_element_user(qName, 0);
            if (groupRef2 == null) {
                groupRef2 = (GroupRef) get_store().add_element_user(qName);
            }
            groupRef2.set(groupRef);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public GroupRef addNewGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().add_element_user(GROUP$0);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetGroup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public All getAll() {
        synchronized (monitor()) {
            check_orphaned();
            All all = (All) get_store().find_element_user(ALL$2, 0);
            if (all == null) {
                return null;
            }
            return all;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetAll() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALL$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAll(All all) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALL$2;
            All all2 = (All) typeStore.find_element_user(qName, 0);
            if (all2 == null) {
                all2 = (All) get_store().add_element_user(qName);
            }
            all2.set(all);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$2);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetAll() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALL$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public ExplicitGroup getChoice() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$4, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetChoice() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHOICE$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setChoice(ExplicitGroup explicitGroup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHOICE$4;
            ExplicitGroup explicitGroup2 = (ExplicitGroup) typeStore.find_element_user(qName, 0);
            if (explicitGroup2 == null) {
                explicitGroup2 = (ExplicitGroup) get_store().add_element_user(qName);
            }
            explicitGroup2.set(explicitGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$4);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetChoice() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHOICE$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public ExplicitGroup getSequence() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$6, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetSequence() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SEQUENCE$6) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setSequence(ExplicitGroup explicitGroup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SEQUENCE$6;
            ExplicitGroup explicitGroup2 = (ExplicitGroup) typeStore.find_element_user(qName, 0);
            if (explicitGroup2 == null) {
                explicitGroup2 = (ExplicitGroup) get_store().add_element_user(qName);
            }
            explicitGroup2.set(explicitGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$6);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetSequence() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEQUENCE$6, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Attribute[] getAttributeArray() {
        Attribute[] attributeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTE$8, arrayList);
            attributeArr = new Attribute[arrayList.size()];
            arrayList.toArray(attributeArr);
        }
        return attributeArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Attribute getAttributeArray(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().find_element_user(ATTRIBUTE$8, i);
            if (attribute == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public int sizeOfAttributeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ATTRIBUTE$8);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAttributeArray(Attribute[] attributeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(attributeArr, ATTRIBUTE$8);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAttributeArray(int i, Attribute attribute) {
        synchronized (monitor()) {
            check_orphaned();
            Attribute attribute2 = (Attribute) get_store().find_element_user(ATTRIBUTE$8, i);
            if (attribute2 == null) {
                throw new IndexOutOfBoundsException();
            }
            attribute2.set(attribute);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Attribute insertNewAttribute(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().insert_element_user(ATTRIBUTE$8, i);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Attribute addNewAttribute() {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().add_element_user(ATTRIBUTE$8);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void removeAttribute(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTE$8, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public AttributeGroupRef[] getAttributeGroupArray() {
        AttributeGroupRef[] attributeGroupRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTEGROUP$10, arrayList);
            attributeGroupRefArr = new AttributeGroupRef[arrayList.size()];
            arrayList.toArray(attributeGroupRefArr);
        }
        return attributeGroupRefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public AttributeGroupRef getAttributeGroupArray(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().find_element_user(ATTRIBUTEGROUP$10, i);
            if (attributeGroupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public int sizeOfAttributeGroupArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ATTRIBUTEGROUP$10);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(attributeGroupRefArr, ATTRIBUTEGROUP$10);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef) {
        synchronized (monitor()) {
            check_orphaned();
            AttributeGroupRef attributeGroupRef2 = (AttributeGroupRef) get_store().find_element_user(ATTRIBUTEGROUP$10, i);
            if (attributeGroupRef2 == null) {
                throw new IndexOutOfBoundsException();
            }
            attributeGroupRef2.set(attributeGroupRef);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public AttributeGroupRef insertNewAttributeGroup(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().insert_element_user(ATTRIBUTEGROUP$10, i);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public AttributeGroupRef addNewAttributeGroup() {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().add_element_user(ATTRIBUTEGROUP$10);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void removeAttributeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEGROUP$10, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Wildcard getAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            Wildcard wildcard = (Wildcard) get_store().find_element_user(ANYATTRIBUTE$12, 0);
            if (wildcard == null) {
                return null;
            }
            return wildcard;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetAnyAttribute() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ANYATTRIBUTE$12) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAnyAttribute(Wildcard wildcard) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANYATTRIBUTE$12;
            Wildcard wildcard2 = (Wildcard) typeStore.find_element_user(qName, 0);
            if (wildcard2 == null) {
                wildcard2 = (Wildcard) get_store().add_element_user(qName);
            }
            wildcard2.set(wildcard);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(ANYATTRIBUTE$12);
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANYATTRIBUTE$12, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public QName getBase() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BASE$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public XmlQName xgetBase() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(BASE$14);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setBase(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = BASE$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void xsetBase(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASE$14;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }
}
