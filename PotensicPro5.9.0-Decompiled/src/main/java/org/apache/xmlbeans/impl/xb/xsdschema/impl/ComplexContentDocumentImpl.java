package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;

/* loaded from: classes5.dex */
public class ComplexContentDocumentImpl extends XmlComplexContentImpl implements ComplexContentDocument {
    private static final QName COMPLEXCONTENT$0 = new QName("http://www.w3.org/2001/XMLSchema", "complexContent");

    public ComplexContentDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument
    public ComplexContentDocument.ComplexContent getComplexContent() {
        synchronized (monitor()) {
            check_orphaned();
            ComplexContentDocument.ComplexContent complexContent = (ComplexContentDocument.ComplexContent) get_store().find_element_user(COMPLEXCONTENT$0, 0);
            if (complexContent == null) {
                return null;
            }
            return complexContent;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument
    public void setComplexContent(ComplexContentDocument.ComplexContent complexContent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPLEXCONTENT$0;
            ComplexContentDocument.ComplexContent complexContent2 = (ComplexContentDocument.ComplexContent) typeStore.find_element_user(qName, 0);
            if (complexContent2 == null) {
                complexContent2 = (ComplexContentDocument.ComplexContent) get_store().add_element_user(qName);
            }
            complexContent2.set(complexContent);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument
    public ComplexContentDocument.ComplexContent addNewComplexContent() {
        ComplexContentDocument.ComplexContent complexContent;
        synchronized (monitor()) {
            check_orphaned();
            complexContent = (ComplexContentDocument.ComplexContent) get_store().add_element_user(COMPLEXCONTENT$0);
        }
        return complexContent;
    }

    public static class ComplexContentImpl extends AnnotatedImpl implements ComplexContentDocument.ComplexContent {
        private static final QName RESTRICTION$0 = new QName("http://www.w3.org/2001/XMLSchema", "restriction");
        private static final QName EXTENSION$2 = new QName("http://www.w3.org/2001/XMLSchema", "extension");
        private static final QName MIXED$4 = new QName("", "mixed");

        public ComplexContentImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public ComplexRestrictionType getRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                ComplexRestrictionType complexRestrictionType = (ComplexRestrictionType) get_store().find_element_user(RESTRICTION$0, 0);
                if (complexRestrictionType == null) {
                    return null;
                }
                return complexRestrictionType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public boolean isSetRestriction() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(RESTRICTION$0) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void setRestriction(ComplexRestrictionType complexRestrictionType) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RESTRICTION$0;
                ComplexRestrictionType complexRestrictionType2 = (ComplexRestrictionType) typeStore.find_element_user(qName, 0);
                if (complexRestrictionType2 == null) {
                    complexRestrictionType2 = (ComplexRestrictionType) get_store().add_element_user(qName);
                }
                complexRestrictionType2.set(complexRestrictionType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public ComplexRestrictionType addNewRestriction() {
            ComplexRestrictionType complexRestrictionType;
            synchronized (monitor()) {
                check_orphaned();
                complexRestrictionType = (ComplexRestrictionType) get_store().add_element_user(RESTRICTION$0);
            }
            return complexRestrictionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void unsetRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(RESTRICTION$0, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public ExtensionType getExtension() {
            synchronized (monitor()) {
                check_orphaned();
                ExtensionType extensionType = (ExtensionType) get_store().find_element_user(EXTENSION$2, 0);
                if (extensionType == null) {
                    return null;
                }
                return extensionType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public boolean isSetExtension() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(EXTENSION$2) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void setExtension(ExtensionType extensionType) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTENSION$2;
                ExtensionType extensionType2 = (ExtensionType) typeStore.find_element_user(qName, 0);
                if (extensionType2 == null) {
                    extensionType2 = (ExtensionType) get_store().add_element_user(qName);
                }
                extensionType2.set(extensionType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public ExtensionType addNewExtension() {
            ExtensionType extensionType;
            synchronized (monitor()) {
                check_orphaned();
                extensionType = (ExtensionType) get_store().add_element_user(EXTENSION$2);
            }
            return extensionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void unsetExtension() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(EXTENSION$2, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public boolean getMixed() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MIXED$4);
                if (simpleValue == null) {
                    return false;
                }
                return simpleValue.getBooleanValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public XmlBoolean xgetMixed() {
            XmlBoolean xmlBoolean;
            synchronized (monitor()) {
                check_orphaned();
                xmlBoolean = (XmlBoolean) get_store().find_attribute_user(MIXED$4);
            }
            return xmlBoolean;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public boolean isSetMixed() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(MIXED$4) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void setMixed(boolean z) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MIXED$4;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setBooleanValue(z);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void xsetMixed(XmlBoolean xmlBoolean) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MIXED$4;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
                }
                xmlBoolean2.set(xmlBoolean);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void unsetMixed() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(MIXED$4);
            }
        }
    }
}
