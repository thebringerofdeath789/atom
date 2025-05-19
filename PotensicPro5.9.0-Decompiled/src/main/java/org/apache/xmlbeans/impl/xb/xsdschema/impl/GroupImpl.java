package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigInteger;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;

/* loaded from: classes5.dex */
public class GroupImpl extends AnnotatedImpl implements Group {
    private static final QName ELEMENT$0 = new QName("http://www.w3.org/2001/XMLSchema", "element");
    private static final QName GROUP$2 = new QName("http://www.w3.org/2001/XMLSchema", "group");
    private static final QName ALL$4 = new QName("http://www.w3.org/2001/XMLSchema", TtmlNode.COMBINE_ALL);
    private static final QName CHOICE$6 = new QName("http://www.w3.org/2001/XMLSchema", "choice");
    private static final QName SEQUENCE$8 = new QName("http://www.w3.org/2001/XMLSchema", "sequence");
    private static final QName ANY$10 = new QName("http://www.w3.org/2001/XMLSchema", "any");
    private static final QName NAME$12 = new QName("", "name");
    private static final QName REF$14 = new QName("", "ref");
    private static final QName MINOCCURS$16 = new QName("", "minOccurs");
    private static final QName MAXOCCURS$18 = new QName("", "maxOccurs");

    public GroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement[] getElementArray() {
        LocalElement[] localElementArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ELEMENT$0, arrayList);
            localElementArr = new LocalElement[arrayList.size()];
            arrayList.toArray(localElementArr);
        }
        return localElementArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement getElementArray(int i) {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().find_element_user(ELEMENT$0, i);
            if (localElement == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfElementArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ELEMENT$0);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setElementArray(LocalElement[] localElementArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(localElementArr, ELEMENT$0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setElementArray(int i, LocalElement localElement) {
        synchronized (monitor()) {
            check_orphaned();
            LocalElement localElement2 = (LocalElement) get_store().find_element_user(ELEMENT$0, i);
            if (localElement2 == null) {
                throw new IndexOutOfBoundsException();
            }
            localElement2.set(localElement);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement insertNewElement(int i) {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().insert_element_user(ELEMENT$0, i);
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement addNewElement() {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().add_element_user(ELEMENT$0);
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeElement(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ELEMENT$0, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef[] getGroupArray() {
        GroupRef[] groupRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUP$2, arrayList);
            groupRefArr = new GroupRef[arrayList.size()];
            arrayList.toArray(groupRefArr);
        }
        return groupRefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef getGroupArray(int i) {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().find_element_user(GROUP$2, i);
            if (groupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfGroupArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GROUP$2);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setGroupArray(GroupRef[] groupRefArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(groupRefArr, GROUP$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setGroupArray(int i, GroupRef groupRef) {
        synchronized (monitor()) {
            check_orphaned();
            GroupRef groupRef2 = (GroupRef) get_store().find_element_user(GROUP$2, i);
            if (groupRef2 == null) {
                throw new IndexOutOfBoundsException();
            }
            groupRef2.set(groupRef);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef insertNewGroup(int i) {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().insert_element_user(GROUP$2, i);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef addNewGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().add_element_user(GROUP$2);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$2, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All[] getAllArray() {
        All[] allArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALL$4, arrayList);
            allArr = new All[arrayList.size()];
            arrayList.toArray(allArr);
        }
        return allArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All getAllArray(int i) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().find_element_user(ALL$4, i);
            if (all == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfAllArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALL$4);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(All[] allArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(allArr, ALL$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(int i, All all) {
        synchronized (monitor()) {
            check_orphaned();
            All all2 = (All) get_store().find_element_user(ALL$4, i);
            if (all2 == null) {
                throw new IndexOutOfBoundsException();
            }
            all2.set(all);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All insertNewAll(int i) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().insert_element_user(ALL$4, i);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$4);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeAll(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALL$4, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getChoiceArray() {
        ExplicitGroup[] explicitGroupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHOICE$6, arrayList);
            explicitGroupArr = new ExplicitGroup[arrayList.size()];
            arrayList.toArray(explicitGroupArr);
        }
        return explicitGroupArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getChoiceArray(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$6, i);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfChoiceArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CHOICE$6);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(ExplicitGroup[] explicitGroupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(explicitGroupArr, CHOICE$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(int i, ExplicitGroup explicitGroup) {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup2 = (ExplicitGroup) get_store().find_element_user(CHOICE$6, i);
            if (explicitGroup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            explicitGroup2.set(explicitGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewChoice(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(CHOICE$6, i);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$6);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeChoice(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHOICE$6, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getSequenceArray() {
        ExplicitGroup[] explicitGroupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SEQUENCE$8, arrayList);
            explicitGroupArr = new ExplicitGroup[arrayList.size()];
            arrayList.toArray(explicitGroupArr);
        }
        return explicitGroupArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getSequenceArray(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$8, i);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfSequenceArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SEQUENCE$8);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(ExplicitGroup[] explicitGroupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(explicitGroupArr, SEQUENCE$8);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(int i, ExplicitGroup explicitGroup) {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup2 = (ExplicitGroup) get_store().find_element_user(SEQUENCE$8, i);
            if (explicitGroup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            explicitGroup2.set(explicitGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewSequence(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(SEQUENCE$8, i);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$8);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeSequence(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEQUENCE$8, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any[] getAnyArray() {
        AnyDocument.Any[] anyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANY$10, arrayList);
            anyArr = new AnyDocument.Any[arrayList.size()];
            arrayList.toArray(anyArr);
        }
        return anyArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any getAnyArray(int i) {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().find_element_user(ANY$10, i);
            if (any == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfAnyArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ANY$10);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAnyArray(AnyDocument.Any[] anyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(anyArr, ANY$10);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAnyArray(int i, AnyDocument.Any any) {
        synchronized (monitor()) {
            check_orphaned();
            AnyDocument.Any any2 = (AnyDocument.Any) get_store().find_element_user(ANY$10, i);
            if (any2 == null) {
                throw new IndexOutOfBoundsException();
            }
            any2.set(any);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any insertNewAny(int i) {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().insert_element_user(ANY$10, i);
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any addNewAny() {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().add_element_user(ANY$10);
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeAny(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANY$10, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(NAME$12);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$12) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$12;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qName);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCName2.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$12);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public QName getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REF$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlQName xgetRef() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(REF$14);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$14) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = REF$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$14;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$14);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public BigInteger getMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlNonNegativeInteger xgetMinOccurs() {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$16;
            xmlNonNegativeInteger = (XmlNonNegativeInteger) typeStore.find_attribute_user(qName);
            if (xmlNonNegativeInteger == null) {
                xmlNonNegativeInteger = (XmlNonNegativeInteger) get_default_attribute_value(qName);
            }
        }
        return xmlNonNegativeInteger;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetMinOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINOCCURS$16) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setMinOccurs(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$16;
            XmlNonNegativeInteger xmlNonNegativeInteger2 = (XmlNonNegativeInteger) typeStore.find_attribute_user(qName);
            if (xmlNonNegativeInteger2 == null) {
                xmlNonNegativeInteger2 = (XmlNonNegativeInteger) get_store().add_attribute_user(qName);
            }
            xmlNonNegativeInteger2.set(xmlNonNegativeInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINOCCURS$16);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public Object getMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AllNNI xgetMaxOccurs() {
        AllNNI allNNI;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$18;
            allNNI = (AllNNI) typeStore.find_attribute_user(qName);
            if (allNNI == null) {
                allNNI = (AllNNI) get_default_attribute_value(qName);
            }
        }
        return allNNI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetMaxOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXOCCURS$18) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setMaxOccurs(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetMaxOccurs(AllNNI allNNI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$18;
            AllNNI allNNI2 = (AllNNI) typeStore.find_attribute_user(qName);
            if (allNNI2 == null) {
                allNNI2 = (AllNNI) get_store().add_attribute_user(qName);
            }
            allNNI2.set(allNNI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXOCCURS$18);
        }
    }
}
