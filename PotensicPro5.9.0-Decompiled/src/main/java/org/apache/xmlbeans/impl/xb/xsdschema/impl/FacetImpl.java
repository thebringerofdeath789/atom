package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;

/* loaded from: classes5.dex */
public class FacetImpl extends AnnotatedImpl implements Facet {
    private static final QName VALUE$0 = new QName("", "value");
    private static final QName FIXED$2 = new QName("", "fixed");

    public FacetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public XmlAnySimpleType getValue() {
        synchronized (monitor()) {
            check_orphaned();
            XmlAnySimpleType xmlAnySimpleType = (XmlAnySimpleType) get_store().find_attribute_user(VALUE$0);
            if (xmlAnySimpleType == null) {
                return null;
            }
            return xmlAnySimpleType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public void setValue(XmlAnySimpleType xmlAnySimpleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALUE$0;
            XmlAnySimpleType xmlAnySimpleType2 = (XmlAnySimpleType) typeStore.find_attribute_user(qName);
            if (xmlAnySimpleType2 == null) {
                xmlAnySimpleType2 = (XmlAnySimpleType) get_store().add_attribute_user(qName);
            }
            xmlAnySimpleType2.set(xmlAnySimpleType);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public XmlAnySimpleType addNewValue() {
        XmlAnySimpleType xmlAnySimpleType;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnySimpleType = (XmlAnySimpleType) get_store().add_attribute_user(VALUE$0);
        }
        return xmlAnySimpleType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public boolean getFixed() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$2;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public XmlBoolean xgetFixed() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$2;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public boolean isSetFixed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIXED$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public void setFixed(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public void xsetFixed(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$2;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public void unsetFixed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIXED$2);
        }
    }
}
