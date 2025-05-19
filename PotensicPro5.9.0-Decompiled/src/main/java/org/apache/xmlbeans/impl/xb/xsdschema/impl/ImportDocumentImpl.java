package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;

/* loaded from: classes5.dex */
public class ImportDocumentImpl extends XmlComplexContentImpl implements ImportDocument {
    private static final QName IMPORT$0 = new QName("http://www.w3.org/2001/XMLSchema", "import");

    public ImportDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument
    public ImportDocument.Import getImport() {
        synchronized (monitor()) {
            check_orphaned();
            ImportDocument.Import r1 = (ImportDocument.Import) get_store().find_element_user(IMPORT$0, 0);
            if (r1 == null) {
                return null;
            }
            return r1;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument
    public void setImport(ImportDocument.Import r5) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMPORT$0;
            ImportDocument.Import r1 = (ImportDocument.Import) typeStore.find_element_user(qName, 0);
            if (r1 == null) {
                r1 = (ImportDocument.Import) get_store().add_element_user(qName);
            }
            r1.set(r5);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument
    public ImportDocument.Import addNewImport() {
        ImportDocument.Import r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = (ImportDocument.Import) get_store().add_element_user(IMPORT$0);
        }
        return r1;
    }

    public static class ImportImpl extends AnnotatedImpl implements ImportDocument.Import {
        private static final QName NAMESPACE$0 = new QName("", "namespace");
        private static final QName SCHEMALOCATION$2 = new QName("", "schemaLocation");

        public ImportImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public String getNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAMESPACE$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public XmlAnyURI xgetNamespace() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(NAMESPACE$0);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public boolean isSetNamespace() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(NAMESPACE$0) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void setNamespace(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAMESPACE$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void xsetNamespace(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAMESPACE$0;
                XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
                if (xmlAnyURI2 == null) {
                    xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURI2.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void unsetNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(NAMESPACE$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public String getSchemaLocation() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SCHEMALOCATION$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public XmlAnyURI xgetSchemaLocation() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(SCHEMALOCATION$2);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public boolean isSetSchemaLocation() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(SCHEMALOCATION$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void setSchemaLocation(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void xsetSchemaLocation(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$2;
                XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
                if (xmlAnyURI2 == null) {
                    xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURI2.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void unsetSchemaLocation() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(SCHEMALOCATION$2);
            }
        }
    }
}
