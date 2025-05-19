package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;

/* loaded from: classes5.dex */
public class AttributeImpl extends AnnotatedImpl implements Attribute {
    private static final QName SIMPLETYPE$0 = new QName("http://www.w3.org/2001/XMLSchema", "simpleType");
    private static final QName NAME$2 = new QName("", "name");
    private static final QName REF$4 = new QName("", "ref");
    private static final QName TYPE$6 = new QName("", "type");
    private static final QName USE$8 = new QName("", "use");
    private static final QName DEFAULT$10 = new QName("", "default");
    private static final QName FIXED$12 = new QName("", "fixed");
    private static final QName FORM$14 = new QName("", "form");

    public AttributeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetSimpleType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIMPLETYPE$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public LocalSimpleType addNewSimpleType() {
        LocalSimpleType localSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
        }
        return localSimpleType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIMPLETYPE$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(NAME$2);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qName);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCName2.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public QName getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REF$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlQName xgetRef() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(REF$4);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = REF$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$4;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public QName getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlQName xgetType() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(TYPE$6);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setType(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = TYPE$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetType(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$6;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public Attribute.Use.Enum getUse() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USE$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (Attribute.Use.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public Attribute.Use xgetUse() {
        Attribute.Use use;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USE$8;
            use = (Attribute.Use) typeStore.find_attribute_user(qName);
            if (use == null) {
                use = (Attribute.Use) get_default_attribute_value(qName);
            }
        }
        return use;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetUse() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USE$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setUse(Attribute.Use.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USE$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetUse(Attribute.Use use) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USE$8;
            Attribute.Use use2 = (Attribute.Use) typeStore.find_attribute_user(qName);
            if (use2 == null) {
                use2 = (Attribute.Use) get_store().add_attribute_user(qName);
            }
            use2.set(use);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetUse() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USE$8);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public String getDefault() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFAULT$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlString xgetDefault() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(DEFAULT$10);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULT$10) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setDefault(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetDefault(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$10;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULT$10);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public String getFixed() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FIXED$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlString xgetFixed() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(FIXED$12);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetFixed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIXED$12) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setFixed(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetFixed(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$12;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetFixed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIXED$12);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public FormChoice.Enum getForm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FORM$14);
            if (simpleValue == null) {
                return null;
            }
            return (FormChoice.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public FormChoice xgetForm() {
        FormChoice formChoice;
        synchronized (monitor()) {
            check_orphaned();
            formChoice = (FormChoice) get_store().find_attribute_user(FORM$14);
        }
        return formChoice;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetForm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORM$14) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setForm(FormChoice.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORM$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetForm(FormChoice formChoice) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORM$14;
            FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qName);
            if (formChoice2 == null) {
                formChoice2 = (FormChoice) get_store().add_attribute_user(qName);
            }
            formChoice2.set(formChoice);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetForm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORM$14);
        }
    }

    public static class UseImpl extends JavaStringEnumerationHolderEx implements Attribute.Use {
        public UseImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected UseImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
