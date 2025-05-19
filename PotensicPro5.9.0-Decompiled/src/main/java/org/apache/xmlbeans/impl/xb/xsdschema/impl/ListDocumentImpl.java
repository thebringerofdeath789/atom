package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;

/* loaded from: classes5.dex */
public class ListDocumentImpl extends XmlComplexContentImpl implements ListDocument {
    private static final QName LIST$0 = new QName("http://www.w3.org/2001/XMLSchema", XmlErrorCodes.LIST);

    public ListDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument
    public ListDocument.List getList() {
        synchronized (monitor()) {
            check_orphaned();
            ListDocument.List list = (ListDocument.List) get_store().find_element_user(LIST$0, 0);
            if (list == null) {
                return null;
            }
            return list;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument
    public void setList(ListDocument.List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LIST$0;
            ListDocument.List list2 = (ListDocument.List) typeStore.find_element_user(qName, 0);
            if (list2 == null) {
                list2 = (ListDocument.List) get_store().add_element_user(qName);
            }
            list2.set(list);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument
    public ListDocument.List addNewList() {
        ListDocument.List list;
        synchronized (monitor()) {
            check_orphaned();
            list = (ListDocument.List) get_store().add_element_user(LIST$0);
        }
        return list;
    }

    public static class ListImpl extends AnnotatedImpl implements ListDocument.List {
        private static final QName SIMPLETYPE$0 = new QName("http://www.w3.org/2001/XMLSchema", "simpleType");
        private static final QName ITEMTYPE$2 = new QName("", "itemType");

        public ListImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public LocalSimpleType getSimpleType() {
            synchronized (monitor()) {
                check_orphaned();
                LocalSimpleType localSimpleType = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$0, 0);
                if (localSimpleType == null) {
                    return null;
                }
                return localSimpleType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public boolean isSetSimpleType() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(SIMPLETYPE$0) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void setSimpleType(LocalSimpleType localSimpleType) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SIMPLETYPE$0;
                LocalSimpleType localSimpleType2 = (LocalSimpleType) typeStore.find_element_user(qName, 0);
                if (localSimpleType2 == null) {
                    localSimpleType2 = (LocalSimpleType) get_store().add_element_user(qName);
                }
                localSimpleType2.set(localSimpleType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public LocalSimpleType addNewSimpleType() {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void unsetSimpleType() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SIMPLETYPE$0, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public QName getItemType() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ITEMTYPE$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getQNameValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public XmlQName xgetItemType() {
            XmlQName xmlQName;
            synchronized (monitor()) {
                check_orphaned();
                xmlQName = (XmlQName) get_store().find_attribute_user(ITEMTYPE$2);
            }
            return xmlQName;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public boolean isSetItemType() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ITEMTYPE$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void setItemType(QName qName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName2 = ITEMTYPE$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
                }
                simpleValue.setQNameValue(qName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void xsetItemType(XmlQName xmlQName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ITEMTYPE$2;
                XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
                if (xmlQName2 == null) {
                    xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
                }
                xmlQName2.set(xmlQName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void unsetItemType() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ITEMTYPE$2);
            }
        }
    }
}
