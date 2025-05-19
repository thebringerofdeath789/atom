package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;

/* loaded from: classes5.dex */
public class SimpleContentDocumentImpl extends XmlComplexContentImpl implements SimpleContentDocument {
    private static final QName SIMPLECONTENT$0 = new QName("http://www.w3.org/2001/XMLSchema", "simpleContent");

    public SimpleContentDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public SimpleContentDocument.SimpleContent getSimpleContent() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleContentDocument.SimpleContent simpleContent = (SimpleContentDocument.SimpleContent) get_store().find_element_user(SIMPLECONTENT$0, 0);
            if (simpleContent == null) {
                return null;
            }
            return simpleContent;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public void setSimpleContent(SimpleContentDocument.SimpleContent simpleContent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIMPLECONTENT$0;
            SimpleContentDocument.SimpleContent simpleContent2 = (SimpleContentDocument.SimpleContent) typeStore.find_element_user(qName, 0);
            if (simpleContent2 == null) {
                simpleContent2 = (SimpleContentDocument.SimpleContent) get_store().add_element_user(qName);
            }
            simpleContent2.set(simpleContent);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public SimpleContentDocument.SimpleContent addNewSimpleContent() {
        SimpleContentDocument.SimpleContent simpleContent;
        synchronized (monitor()) {
            check_orphaned();
            simpleContent = (SimpleContentDocument.SimpleContent) get_store().add_element_user(SIMPLECONTENT$0);
        }
        return simpleContent;
    }

    public static class SimpleContentImpl extends AnnotatedImpl implements SimpleContentDocument.SimpleContent {
        private static final QName RESTRICTION$0 = new QName("http://www.w3.org/2001/XMLSchema", "restriction");
        private static final QName EXTENSION$2 = new QName("http://www.w3.org/2001/XMLSchema", "extension");

        public SimpleContentImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleRestrictionType getRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleRestrictionType simpleRestrictionType = (SimpleRestrictionType) get_store().find_element_user(RESTRICTION$0, 0);
                if (simpleRestrictionType == null) {
                    return null;
                }
                return simpleRestrictionType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public boolean isSetRestriction() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(RESTRICTION$0) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void setRestriction(SimpleRestrictionType simpleRestrictionType) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RESTRICTION$0;
                SimpleRestrictionType simpleRestrictionType2 = (SimpleRestrictionType) typeStore.find_element_user(qName, 0);
                if (simpleRestrictionType2 == null) {
                    simpleRestrictionType2 = (SimpleRestrictionType) get_store().add_element_user(qName);
                }
                simpleRestrictionType2.set(simpleRestrictionType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleRestrictionType addNewRestriction() {
            SimpleRestrictionType simpleRestrictionType;
            synchronized (monitor()) {
                check_orphaned();
                simpleRestrictionType = (SimpleRestrictionType) get_store().add_element_user(RESTRICTION$0);
            }
            return simpleRestrictionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void unsetRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(RESTRICTION$0, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleExtensionType getExtension() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleExtensionType simpleExtensionType = (SimpleExtensionType) get_store().find_element_user(EXTENSION$2, 0);
                if (simpleExtensionType == null) {
                    return null;
                }
                return simpleExtensionType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public boolean isSetExtension() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(EXTENSION$2) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void setExtension(SimpleExtensionType simpleExtensionType) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTENSION$2;
                SimpleExtensionType simpleExtensionType2 = (SimpleExtensionType) typeStore.find_element_user(qName, 0);
                if (simpleExtensionType2 == null) {
                    simpleExtensionType2 = (SimpleExtensionType) get_store().add_element_user(qName);
                }
                simpleExtensionType2.set(simpleExtensionType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleExtensionType addNewExtension() {
            SimpleExtensionType simpleExtensionType;
            synchronized (monitor()) {
                check_orphaned();
                simpleExtensionType = (SimpleExtensionType) get_store().add_element_user(EXTENSION$2);
            }
            return simpleExtensionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void unsetExtension() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(EXTENSION$2, 0);
            }
        }
    }
}
