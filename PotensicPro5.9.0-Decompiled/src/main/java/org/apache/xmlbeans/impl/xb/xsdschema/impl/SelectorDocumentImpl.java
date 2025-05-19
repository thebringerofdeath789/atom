package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;

/* loaded from: classes5.dex */
public class SelectorDocumentImpl extends XmlComplexContentImpl implements SelectorDocument {
    private static final QName SELECTOR$0 = new QName("http://www.w3.org/2001/XMLSchema", "selector");

    public SelectorDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument
    public SelectorDocument.Selector getSelector() {
        synchronized (monitor()) {
            check_orphaned();
            SelectorDocument.Selector selector = (SelectorDocument.Selector) get_store().find_element_user(SELECTOR$0, 0);
            if (selector == null) {
                return null;
            }
            return selector;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument
    public void setSelector(SelectorDocument.Selector selector) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SELECTOR$0;
            SelectorDocument.Selector selector2 = (SelectorDocument.Selector) typeStore.find_element_user(qName, 0);
            if (selector2 == null) {
                selector2 = (SelectorDocument.Selector) get_store().add_element_user(qName);
            }
            selector2.set(selector);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument
    public SelectorDocument.Selector addNewSelector() {
        SelectorDocument.Selector selector;
        synchronized (monitor()) {
            check_orphaned();
            selector = (SelectorDocument.Selector) get_store().add_element_user(SELECTOR$0);
        }
        return selector;
    }

    public static class SelectorImpl extends AnnotatedImpl implements SelectorDocument.Selector {
        private static final QName XPATH$0 = new QName("", "xpath");

        public SelectorImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector
        public SelectorDocument.Selector.Xpath xgetXpath() {
            SelectorDocument.Selector.Xpath xpath;
            synchronized (monitor()) {
                check_orphaned();
                xpath = (SelectorDocument.Selector.Xpath) get_store().find_attribute_user(XPATH$0);
            }
            return xpath;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector
        public void xsetXpath(SelectorDocument.Selector.Xpath xpath) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = XPATH$0;
                SelectorDocument.Selector.Xpath xpath2 = (SelectorDocument.Selector.Xpath) typeStore.find_attribute_user(qName);
                if (xpath2 == null) {
                    xpath2 = (SelectorDocument.Selector.Xpath) get_store().add_attribute_user(qName);
                }
                xpath2.set(xpath);
            }
        }

        public static class XpathImpl extends JavaStringHolderEx implements SelectorDocument.Selector.Xpath {
            public XpathImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected XpathImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
