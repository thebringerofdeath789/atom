package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;

/* loaded from: classes5.dex */
public class SimpleTypeImpl extends AnnotatedImpl implements SimpleType {
    private static final QName RESTRICTION$0 = new QName("http://www.w3.org/2001/XMLSchema", "restriction");
    private static final QName LIST$2 = new QName("http://www.w3.org/2001/XMLSchema", XmlErrorCodes.LIST);
    private static final QName UNION$4 = new QName("http://www.w3.org/2001/XMLSchema", XmlErrorCodes.UNION);
    private static final QName FINAL$6 = new QName("", "final");
    private static final QName NAME$8 = new QName("", "name");

    public SimpleTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public RestrictionDocument.Restriction getRestriction() {
        synchronized (monitor()) {
            check_orphaned();
            RestrictionDocument.Restriction restriction = (RestrictionDocument.Restriction) get_store().find_element_user(RESTRICTION$0, 0);
            if (restriction == null) {
                return null;
            }
            return restriction;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetRestriction() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RESTRICTION$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setRestriction(RestrictionDocument.Restriction restriction) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RESTRICTION$0;
            RestrictionDocument.Restriction restriction2 = (RestrictionDocument.Restriction) typeStore.find_element_user(qName, 0);
            if (restriction2 == null) {
                restriction2 = (RestrictionDocument.Restriction) get_store().add_element_user(qName);
            }
            restriction2.set(restriction);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public RestrictionDocument.Restriction addNewRestriction() {
        RestrictionDocument.Restriction restriction;
        synchronized (monitor()) {
            check_orphaned();
            restriction = (RestrictionDocument.Restriction) get_store().add_element_user(RESTRICTION$0);
        }
        return restriction;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetRestriction() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RESTRICTION$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public ListDocument.List getList() {
        synchronized (monitor()) {
            check_orphaned();
            ListDocument.List list = (ListDocument.List) get_store().find_element_user(LIST$2, 0);
            if (list == null) {
                return null;
            }
            return list;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetList() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LIST$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setList(ListDocument.List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LIST$2;
            ListDocument.List list2 = (ListDocument.List) typeStore.find_element_user(qName, 0);
            if (list2 == null) {
                list2 = (ListDocument.List) get_store().add_element_user(qName);
            }
            list2.set(list);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public ListDocument.List addNewList() {
        ListDocument.List list;
        synchronized (monitor()) {
            check_orphaned();
            list = (ListDocument.List) get_store().add_element_user(LIST$2);
        }
        return list;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetList() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIST$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public UnionDocument.Union getUnion() {
        synchronized (monitor()) {
            check_orphaned();
            UnionDocument.Union union = (UnionDocument.Union) get_store().find_element_user(UNION$4, 0);
            if (union == null) {
                return null;
            }
            return union;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetUnion() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNION$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setUnion(UnionDocument.Union union) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNION$4;
            UnionDocument.Union union2 = (UnionDocument.Union) typeStore.find_element_user(qName, 0);
            if (union2 == null) {
                union2 = (UnionDocument.Union) get_store().add_element_user(qName);
            }
            union2.set(union);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public UnionDocument.Union addNewUnion() {
        UnionDocument.Union union;
        synchronized (monitor()) {
            check_orphaned();
            union = (UnionDocument.Union) get_store().add_element_user(UNION$4);
        }
        return union;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetUnion() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNION$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public Object getFinal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FINAL$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public SimpleDerivationSet xgetFinal() {
        SimpleDerivationSet simpleDerivationSet;
        synchronized (monitor()) {
            check_orphaned();
            simpleDerivationSet = (SimpleDerivationSet) get_store().find_attribute_user(FINAL$6);
        }
        return simpleDerivationSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetFinal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FINAL$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setFinal(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void xsetFinal(SimpleDerivationSet simpleDerivationSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$6;
            SimpleDerivationSet simpleDerivationSet2 = (SimpleDerivationSet) typeStore.find_attribute_user(qName);
            if (simpleDerivationSet2 == null) {
                simpleDerivationSet2 = (SimpleDerivationSet) get_store().add_attribute_user(qName);
            }
            simpleDerivationSet2.set(simpleDerivationSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetFinal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FINAL$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(NAME$8);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$8;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qName);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCName2.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$8);
        }
    }
}
