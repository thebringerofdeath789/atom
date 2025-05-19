package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.mapbox.mapboxsdk.style.layers.Property;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;

/* loaded from: classes5.dex */
public class DocumentationDocumentImpl extends XmlComplexContentImpl implements DocumentationDocument {
    private static final QName DOCUMENTATION$0 = new QName("http://www.w3.org/2001/XMLSchema", "documentation");

    public DocumentationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public DocumentationDocument.Documentation getDocumentation() {
        synchronized (monitor()) {
            check_orphaned();
            DocumentationDocument.Documentation documentation = (DocumentationDocument.Documentation) get_store().find_element_user(DOCUMENTATION$0, 0);
            if (documentation == null) {
                return null;
            }
            return documentation;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public void setDocumentation(DocumentationDocument.Documentation documentation) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCUMENTATION$0;
            DocumentationDocument.Documentation documentation2 = (DocumentationDocument.Documentation) typeStore.find_element_user(qName, 0);
            if (documentation2 == null) {
                documentation2 = (DocumentationDocument.Documentation) get_store().add_element_user(qName);
            }
            documentation2.set(documentation);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public DocumentationDocument.Documentation addNewDocumentation() {
        DocumentationDocument.Documentation documentation;
        synchronized (monitor()) {
            check_orphaned();
            documentation = (DocumentationDocument.Documentation) get_store().add_element_user(DOCUMENTATION$0);
        }
        return documentation;
    }

    public static class DocumentationImpl extends XmlComplexContentImpl implements DocumentationDocument.Documentation {
        private static final QName SOURCE$0 = new QName("", Property.SYMBOL_Z_ORDER_SOURCE);
        private static final QName LANG$2 = new QName("http://www.w3.org/XML/1998/namespace", "lang");

        public DocumentationImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public String getSource() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SOURCE$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public XmlAnyURI xgetSource() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(SOURCE$0);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public boolean isSetSource() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(SOURCE$0) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void setSource(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SOURCE$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void xsetSource(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SOURCE$0;
                XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
                if (xmlAnyURI2 == null) {
                    xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURI2.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void unsetSource() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(SOURCE$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public String getLang() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LANG$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public XmlLanguage xgetLang() {
            XmlLanguage xmlLanguage;
            synchronized (monitor()) {
                check_orphaned();
                xmlLanguage = (XmlLanguage) get_store().find_attribute_user(LANG$2);
            }
            return xmlLanguage;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public boolean isSetLang() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(LANG$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void setLang(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LANG$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void xsetLang(XmlLanguage xmlLanguage) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LANG$2;
                XmlLanguage xmlLanguage2 = (XmlLanguage) typeStore.find_attribute_user(qName);
                if (xmlLanguage2 == null) {
                    xmlLanguage2 = (XmlLanguage) get_store().add_attribute_user(qName);
                }
                xmlLanguage2.set(xmlLanguage);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void unsetLang() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(LANG$2);
            }
        }
    }
}
