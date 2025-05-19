package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;

/* loaded from: classes5.dex */
public class FieldDocumentImpl extends XmlComplexContentImpl implements FieldDocument {
    private static final QName FIELD$0 = new QName("http://www.w3.org/2001/XMLSchema", JamXmlElements.FIELD);

    public FieldDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument
    public FieldDocument.Field getField() {
        synchronized (monitor()) {
            check_orphaned();
            FieldDocument.Field field = (FieldDocument.Field) get_store().find_element_user(FIELD$0, 0);
            if (field == null) {
                return null;
            }
            return field;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument
    public void setField(FieldDocument.Field field) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIELD$0;
            FieldDocument.Field field2 = (FieldDocument.Field) typeStore.find_element_user(qName, 0);
            if (field2 == null) {
                field2 = (FieldDocument.Field) get_store().add_element_user(qName);
            }
            field2.set(field);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument
    public FieldDocument.Field addNewField() {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().add_element_user(FIELD$0);
        }
        return field;
    }

    public static class FieldImpl extends AnnotatedImpl implements FieldDocument.Field {
        private static final QName XPATH$0 = new QName("", "xpath");

        public FieldImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field
        public String getXpath() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(XPATH$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field
        public FieldDocument.Field.Xpath xgetXpath() {
            FieldDocument.Field.Xpath xpath;
            synchronized (monitor()) {
                check_orphaned();
                xpath = (FieldDocument.Field.Xpath) get_store().find_attribute_user(XPATH$0);
            }
            return xpath;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field
        public void setXpath(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = XPATH$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field
        public void xsetXpath(FieldDocument.Field.Xpath xpath) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = XPATH$0;
                FieldDocument.Field.Xpath xpath2 = (FieldDocument.Field.Xpath) typeStore.find_attribute_user(qName);
                if (xpath2 == null) {
                    xpath2 = (FieldDocument.Field.Xpath) get_store().add_attribute_user(qName);
                }
                xpath2.set(xpath);
            }
        }

        public static class XpathImpl extends JavaStringHolderEx implements FieldDocument.Field.Xpath {
            public XpathImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected XpathImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
