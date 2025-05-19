package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;

/* loaded from: classes5.dex */
public class IncludeDocumentImpl extends XmlComplexContentImpl implements IncludeDocument {
    private static final QName INCLUDE$0 = new QName("http://www.w3.org/2001/XMLSchema", "include");

    public IncludeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument
    public IncludeDocument.Include getInclude() {
        synchronized (monitor()) {
            check_orphaned();
            IncludeDocument.Include include = (IncludeDocument.Include) get_store().find_element_user(INCLUDE$0, 0);
            if (include == null) {
                return null;
            }
            return include;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument
    public void setInclude(IncludeDocument.Include include) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INCLUDE$0;
            IncludeDocument.Include include2 = (IncludeDocument.Include) typeStore.find_element_user(qName, 0);
            if (include2 == null) {
                include2 = (IncludeDocument.Include) get_store().add_element_user(qName);
            }
            include2.set(include);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument
    public IncludeDocument.Include addNewInclude() {
        IncludeDocument.Include include;
        synchronized (monitor()) {
            check_orphaned();
            include = (IncludeDocument.Include) get_store().add_element_user(INCLUDE$0);
        }
        return include;
    }

    public static class IncludeImpl extends AnnotatedImpl implements IncludeDocument.Include {
        private static final QName SCHEMALOCATION$0 = new QName("", "schemaLocation");

        public IncludeImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include
        public String getSchemaLocation() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SCHEMALOCATION$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include
        public XmlAnyURI xgetSchemaLocation() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(SCHEMALOCATION$0);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include
        public void setSchemaLocation(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include
        public void xsetSchemaLocation(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$0;
                XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
                if (xmlAnyURI2 == null) {
                    xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURI2.set(xmlAnyURI);
            }
        }
    }
}
