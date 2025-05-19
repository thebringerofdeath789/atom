package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;

/* loaded from: classes5.dex */
public class KeybaseImpl extends AnnotatedImpl implements Keybase {
    private static final QName SELECTOR$0 = new QName("http://www.w3.org/2001/XMLSchema", "selector");
    private static final QName FIELD$2 = new QName("http://www.w3.org/2001/XMLSchema", JamXmlElements.FIELD);
    private static final QName NAME$4 = new QName("", "name");

    public KeybaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public SelectorDocument.Selector getSelector() {
        synchronized (monitor()) {
            check_orphaned();
            SelectorDocument.Selector selector = (SelectorDocument.Selector) get_store().find_element_user(SELECTOR$0, 0);
            if (selector == null) {
                return null;
            }
            return selector;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setSelector(SelectorDocument.Selector selector) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SELECTOR$0;
            SelectorDocument.Selector selector2 = (SelectorDocument.Selector) typeStore.find_element_user(qName, 0);
            if (selector2 == null) {
                selector2 = (SelectorDocument.Selector) get_store().add_element_user(qName);
            }
            selector2.set(selector);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public SelectorDocument.Selector addNewSelector() {
        SelectorDocument.Selector selector;
        synchronized (monitor()) {
            check_orphaned();
            selector = (SelectorDocument.Selector) get_store().add_element_user(SELECTOR$0);
        }
        return selector;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field[] getFieldArray() {
        FieldDocument.Field[] fieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FIELD$2, arrayList);
            fieldArr = new FieldDocument.Field[arrayList.size()];
            arrayList.toArray(fieldArr);
        }
        return fieldArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field getFieldArray(int i) {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().find_element_user(FIELD$2, i);
            if (field == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public int sizeOfFieldArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FIELD$2);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setFieldArray(FieldDocument.Field[] fieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(fieldArr, FIELD$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setFieldArray(int i, FieldDocument.Field field) {
        synchronized (monitor()) {
            check_orphaned();
            FieldDocument.Field field2 = (FieldDocument.Field) get_store().find_element_user(FIELD$2, i);
            if (field2 == null) {
                throw new IndexOutOfBoundsException();
            }
            field2.set(field);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field insertNewField(int i) {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().insert_element_user(FIELD$2, i);
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field addNewField() {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().add_element_user(FIELD$2);
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void removeField(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIELD$2, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(NAME$4);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$4;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qName);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCName2.set(xmlNCName);
        }
    }
}
