package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;

/* loaded from: classes5.dex */
public class AnyDocumentImpl extends XmlComplexContentImpl implements AnyDocument {
    private static final QName ANY$0 = new QName("http://www.w3.org/2001/XMLSchema", "any");

    public AnyDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument
    public AnyDocument.Any getAny() {
        synchronized (monitor()) {
            check_orphaned();
            AnyDocument.Any any = (AnyDocument.Any) get_store().find_element_user(ANY$0, 0);
            if (any == null) {
                return null;
            }
            return any;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument
    public void setAny(AnyDocument.Any any) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANY$0;
            AnyDocument.Any any2 = (AnyDocument.Any) typeStore.find_element_user(qName, 0);
            if (any2 == null) {
                any2 = (AnyDocument.Any) get_store().add_element_user(qName);
            }
            any2.set(any);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument
    public AnyDocument.Any addNewAny() {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().add_element_user(ANY$0);
        }
        return any;
    }

    public static class AnyImpl extends WildcardImpl implements AnyDocument.Any {
        private static final QName MINOCCURS$0 = new QName("", "minOccurs");
        private static final QName MAXOCCURS$2 = new QName("", "maxOccurs");

        public AnyImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public BigInteger getMinOccurs() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MINOCCURS$0;
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public XmlNonNegativeInteger xgetMinOccurs() {
            XmlNonNegativeInteger xmlNonNegativeInteger;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MINOCCURS$0;
                xmlNonNegativeInteger = (XmlNonNegativeInteger) typeStore.find_attribute_user(qName);
                if (xmlNonNegativeInteger == null) {
                    xmlNonNegativeInteger = (XmlNonNegativeInteger) get_default_attribute_value(qName);
                }
            }
            return xmlNonNegativeInteger;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public boolean isSetMinOccurs() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(MINOCCURS$0) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void setMinOccurs(BigInteger bigInteger) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MINOCCURS$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setBigIntegerValue(bigInteger);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MINOCCURS$0;
                XmlNonNegativeInteger xmlNonNegativeInteger2 = (XmlNonNegativeInteger) typeStore.find_attribute_user(qName);
                if (xmlNonNegativeInteger2 == null) {
                    xmlNonNegativeInteger2 = (XmlNonNegativeInteger) get_store().add_attribute_user(qName);
                }
                xmlNonNegativeInteger2.set(xmlNonNegativeInteger);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void unsetMinOccurs() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(MINOCCURS$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public Object getMaxOccurs() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MAXOCCURS$2;
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public AllNNI xgetMaxOccurs() {
            AllNNI allNNI;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MAXOCCURS$2;
                allNNI = (AllNNI) typeStore.find_attribute_user(qName);
                if (allNNI == null) {
                    allNNI = (AllNNI) get_default_attribute_value(qName);
                }
            }
            return allNNI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public boolean isSetMaxOccurs() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(MAXOCCURS$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void setMaxOccurs(Object obj) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MAXOCCURS$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setObjectValue(obj);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void xsetMaxOccurs(AllNNI allNNI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MAXOCCURS$2;
                AllNNI allNNI2 = (AllNNI) typeStore.find_attribute_user(qName);
                if (allNNI2 == null) {
                    allNNI2 = (AllNNI) get_store().add_attribute_user(qName);
                }
                allNNI2.set(allNNI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void unsetMaxOccurs() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(MAXOCCURS$2);
            }
        }
    }
}
