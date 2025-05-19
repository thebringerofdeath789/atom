package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;
import org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;

/* loaded from: classes5.dex */
public class ElementImpl extends AnnotatedImpl implements Element {
    private static final QName SIMPLETYPE$0 = new QName("http://www.w3.org/2001/XMLSchema", "simpleType");
    private static final QName COMPLEXTYPE$2 = new QName("http://www.w3.org/2001/XMLSchema", "complexType");
    private static final QName UNIQUE$4 = new QName("http://www.w3.org/2001/XMLSchema", "unique");
    private static final QName KEY$6 = new QName("http://www.w3.org/2001/XMLSchema", "key");
    private static final QName KEYREF$8 = new QName("http://www.w3.org/2001/XMLSchema", "keyref");
    private static final QName NAME$10 = new QName("", "name");
    private static final QName REF$12 = new QName("", "ref");
    private static final QName TYPE$14 = new QName("", "type");
    private static final QName SUBSTITUTIONGROUP$16 = new QName("", "substitutionGroup");
    private static final QName MINOCCURS$18 = new QName("", "minOccurs");
    private static final QName MAXOCCURS$20 = new QName("", "maxOccurs");
    private static final QName DEFAULT$22 = new QName("", "default");
    private static final QName FIXED$24 = new QName("", "fixed");
    private static final QName NILLABLE$26 = new QName("", "nillable");
    private static final QName ABSTRACT$28 = new QName("", "abstract");
    private static final QName FINAL$30 = new QName("", "final");
    private static final QName BLOCK$32 = new QName("", "block");
    private static final QName FORM$34 = new QName("", "form");

    public ElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public LocalSimpleType getSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            LocalSimpleType localSimpleType = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$0, 0);
            if (localSimpleType == null) {
                return null;
            }
            return localSimpleType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetSimpleType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIMPLETYPE$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setSimpleType(LocalSimpleType localSimpleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIMPLETYPE$0;
            LocalSimpleType localSimpleType2 = (LocalSimpleType) typeStore.find_element_user(qName, 0);
            if (localSimpleType2 == null) {
                localSimpleType2 = (LocalSimpleType) get_store().add_element_user(qName);
            }
            localSimpleType2.set(localSimpleType);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public LocalSimpleType addNewSimpleType() {
        LocalSimpleType localSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
        }
        return localSimpleType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIMPLETYPE$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public LocalComplexType getComplexType() {
        synchronized (monitor()) {
            check_orphaned();
            LocalComplexType localComplexType = (LocalComplexType) get_store().find_element_user(COMPLEXTYPE$2, 0);
            if (localComplexType == null) {
                return null;
            }
            return localComplexType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetComplexType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COMPLEXTYPE$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setComplexType(LocalComplexType localComplexType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPLEXTYPE$2;
            LocalComplexType localComplexType2 = (LocalComplexType) typeStore.find_element_user(qName, 0);
            if (localComplexType2 == null) {
                localComplexType2 = (LocalComplexType) get_store().add_element_user(qName);
            }
            localComplexType2.set(localComplexType);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public LocalComplexType addNewComplexType() {
        LocalComplexType localComplexType;
        synchronized (monitor()) {
            check_orphaned();
            localComplexType = (LocalComplexType) get_store().add_element_user(COMPLEXTYPE$2);
        }
        return localComplexType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetComplexType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPLEXTYPE$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase[] getUniqueArray() {
        Keybase[] keybaseArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UNIQUE$4, arrayList);
            keybaseArr = new Keybase[arrayList.size()];
            arrayList.toArray(keybaseArr);
        }
        return keybaseArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase getUniqueArray(int i) {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().find_element_user(UNIQUE$4, i);
            if (keybase == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public int sizeOfUniqueArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(UNIQUE$4);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setUniqueArray(Keybase[] keybaseArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(keybaseArr, UNIQUE$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setUniqueArray(int i, Keybase keybase) {
        synchronized (monitor()) {
            check_orphaned();
            Keybase keybase2 = (Keybase) get_store().find_element_user(UNIQUE$4, i);
            if (keybase2 == null) {
                throw new IndexOutOfBoundsException();
            }
            keybase2.set(keybase);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase insertNewUnique(int i) {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().insert_element_user(UNIQUE$4, i);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase addNewUnique() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(UNIQUE$4);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void removeUnique(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNIQUE$4, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase[] getKeyArray() {
        Keybase[] keybaseArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(KEY$6, arrayList);
            keybaseArr = new Keybase[arrayList.size()];
            arrayList.toArray(keybaseArr);
        }
        return keybaseArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase getKeyArray(int i) {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().find_element_user(KEY$6, i);
            if (keybase == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public int sizeOfKeyArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(KEY$6);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setKeyArray(Keybase[] keybaseArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(keybaseArr, KEY$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setKeyArray(int i, Keybase keybase) {
        synchronized (monitor()) {
            check_orphaned();
            Keybase keybase2 = (Keybase) get_store().find_element_user(KEY$6, i);
            if (keybase2 == null) {
                throw new IndexOutOfBoundsException();
            }
            keybase2.set(keybase);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase insertNewKey(int i) {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().insert_element_user(KEY$6, i);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase addNewKey() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(KEY$6);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void removeKey(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEY$6, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public KeyrefDocument.Keyref[] getKeyrefArray() {
        KeyrefDocument.Keyref[] keyrefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(KEYREF$8, arrayList);
            keyrefArr = new KeyrefDocument.Keyref[arrayList.size()];
            arrayList.toArray(keyrefArr);
        }
        return keyrefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public KeyrefDocument.Keyref getKeyrefArray(int i) {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().find_element_user(KEYREF$8, i);
            if (keyref == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return keyref;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public int sizeOfKeyrefArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(KEYREF$8);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setKeyrefArray(KeyrefDocument.Keyref[] keyrefArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(keyrefArr, KEYREF$8);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setKeyrefArray(int i, KeyrefDocument.Keyref keyref) {
        synchronized (monitor()) {
            check_orphaned();
            KeyrefDocument.Keyref keyref2 = (KeyrefDocument.Keyref) get_store().find_element_user(KEYREF$8, i);
            if (keyref2 == null) {
                throw new IndexOutOfBoundsException();
            }
            keyref2.set(keyref);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public KeyrefDocument.Keyref insertNewKeyref(int i) {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().insert_element_user(KEYREF$8, i);
        }
        return keyref;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public KeyrefDocument.Keyref addNewKeyref() {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().add_element_user(KEYREF$8);
        }
        return keyref;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void removeKeyref(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEYREF$8, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(NAME$10);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$10) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qName);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCName2.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$10);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public QName getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REF$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlQName xgetRef() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(REF$12);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$12) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = REF$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$12;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$12);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public QName getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlQName xgetType() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(TYPE$14);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$14) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setType(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = TYPE$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetType(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$14;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$14);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public QName getSubstitutionGroup() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SUBSTITUTIONGROUP$16);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlQName xgetSubstitutionGroup() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(SUBSTITUTIONGROUP$16);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetSubstitutionGroup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SUBSTITUTIONGROUP$16) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setSubstitutionGroup(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = SUBSTITUTIONGROUP$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetSubstitutionGroup(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUBSTITUTIONGROUP$16;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetSubstitutionGroup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SUBSTITUTIONGROUP$16);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public BigInteger getMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$18;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlNonNegativeInteger xgetMinOccurs() {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$18;
            xmlNonNegativeInteger = (XmlNonNegativeInteger) typeStore.find_attribute_user(qName);
            if (xmlNonNegativeInteger == null) {
                xmlNonNegativeInteger = (XmlNonNegativeInteger) get_default_attribute_value(qName);
            }
        }
        return xmlNonNegativeInteger;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetMinOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINOCCURS$18) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setMinOccurs(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$18;
            XmlNonNegativeInteger xmlNonNegativeInteger2 = (XmlNonNegativeInteger) typeStore.find_attribute_user(qName);
            if (xmlNonNegativeInteger2 == null) {
                xmlNonNegativeInteger2 = (XmlNonNegativeInteger) get_store().add_attribute_user(qName);
            }
            xmlNonNegativeInteger2.set(xmlNonNegativeInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINOCCURS$18);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Object getMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$20;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public AllNNI xgetMaxOccurs() {
        AllNNI allNNI;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$20;
            allNNI = (AllNNI) typeStore.find_attribute_user(qName);
            if (allNNI == null) {
                allNNI = (AllNNI) get_default_attribute_value(qName);
            }
        }
        return allNNI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetMaxOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXOCCURS$20) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setMaxOccurs(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetMaxOccurs(AllNNI allNNI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$20;
            AllNNI allNNI2 = (AllNNI) typeStore.find_attribute_user(qName);
            if (allNNI2 == null) {
                allNNI2 = (AllNNI) get_store().add_attribute_user(qName);
            }
            allNNI2.set(allNNI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXOCCURS$20);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public String getDefault() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFAULT$22);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlString xgetDefault() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(DEFAULT$22);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULT$22) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setDefault(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetDefault(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$22;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULT$22);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public String getFixed() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FIXED$24);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlString xgetFixed() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(FIXED$24);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetFixed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIXED$24) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setFixed(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetFixed(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$24;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetFixed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIXED$24);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean getNillable() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NILLABLE$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlBoolean xgetNillable() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NILLABLE$26;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetNillable() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NILLABLE$26) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setNillable(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NILLABLE$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetNillable(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NILLABLE$26;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetNillable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NILLABLE$26);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean getAbstract() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlBoolean xgetAbstract() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$28;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetAbstract() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ABSTRACT$28) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setAbstract(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetAbstract(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$28;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetAbstract() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ABSTRACT$28);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Object getFinal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FINAL$30);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public DerivationSet xgetFinal() {
        DerivationSet derivationSet;
        synchronized (monitor()) {
            check_orphaned();
            derivationSet = (DerivationSet) get_store().find_attribute_user(FINAL$30);
        }
        return derivationSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetFinal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FINAL$30) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setFinal(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetFinal(DerivationSet derivationSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$30;
            DerivationSet derivationSet2 = (DerivationSet) typeStore.find_attribute_user(qName);
            if (derivationSet2 == null) {
                derivationSet2 = (DerivationSet) get_store().add_attribute_user(qName);
            }
            derivationSet2.set(derivationSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetFinal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FINAL$30);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Object getBlock() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BLOCK$32);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public BlockSet xgetBlock() {
        BlockSet blockSet;
        synchronized (monitor()) {
            check_orphaned();
            blockSet = (BlockSet) get_store().find_attribute_user(BLOCK$32);
        }
        return blockSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetBlock() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BLOCK$32) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setBlock(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCK$32;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetBlock(BlockSet blockSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCK$32;
            BlockSet blockSet2 = (BlockSet) typeStore.find_attribute_user(qName);
            if (blockSet2 == null) {
                blockSet2 = (BlockSet) get_store().add_attribute_user(qName);
            }
            blockSet2.set(blockSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetBlock() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BLOCK$32);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public FormChoice.Enum getForm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FORM$34);
            if (simpleValue == null) {
                return null;
            }
            return (FormChoice.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public FormChoice xgetForm() {
        FormChoice formChoice;
        synchronized (monitor()) {
            check_orphaned();
            formChoice = (FormChoice) get_store().find_attribute_user(FORM$34);
        }
        return formChoice;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetForm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORM$34) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setForm(FormChoice.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORM$34;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetForm(FormChoice formChoice) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORM$34;
            FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qName);
            if (formChoice2 == null) {
                formChoice2 = (FormChoice) get_store().add_attribute_user(qName);
            }
            formChoice2.set(formChoice);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetForm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORM$34);
        }
    }
}
