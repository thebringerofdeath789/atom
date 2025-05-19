package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.baidu.location.BDLocation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

/* loaded from: classes5.dex */
public class NotationDocumentImpl extends XmlComplexContentImpl implements NotationDocument {
    private static final QName NOTATION$0 = new QName("http://www.w3.org/2001/XMLSchema", "notation");

    public NotationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument
    public NotationDocument.Notation getNotation() {
        synchronized (monitor()) {
            check_orphaned();
            NotationDocument.Notation notation = (NotationDocument.Notation) get_store().find_element_user(NOTATION$0, 0);
            if (notation == null) {
                return null;
            }
            return notation;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument
    public void setNotation(NotationDocument.Notation notation) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOTATION$0;
            NotationDocument.Notation notation2 = (NotationDocument.Notation) typeStore.find_element_user(qName, 0);
            if (notation2 == null) {
                notation2 = (NotationDocument.Notation) get_store().add_element_user(qName);
            }
            notation2.set(notation);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument
    public NotationDocument.Notation addNewNotation() {
        NotationDocument.Notation notation;
        synchronized (monitor()) {
            check_orphaned();
            notation = (NotationDocument.Notation) get_store().add_element_user(NOTATION$0);
        }
        return notation;
    }

    public static class NotationImpl extends AnnotatedImpl implements NotationDocument.Notation {
        private static final QName NAME$0 = new QName("", "name");
        private static final QName PUBLIC$2 = new QName("", "public");
        private static final QName SYSTEM$4 = new QName("", BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM);

        public NotationImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public String getName() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public XmlNCName xgetName() {
            XmlNCName xmlNCName;
            synchronized (monitor()) {
                check_orphaned();
                xmlNCName = (XmlNCName) get_store().find_attribute_user(NAME$0);
            }
            return xmlNCName;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void setName(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void xsetName(XmlNCName xmlNCName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$0;
                XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qName);
                if (xmlNCName2 == null) {
                    xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qName);
                }
                xmlNCName2.set(xmlNCName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public String getPublic() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PUBLIC$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public Public xgetPublic() {
            Public r1;
            synchronized (monitor()) {
                check_orphaned();
                r1 = (Public) get_store().find_attribute_user(PUBLIC$2);
            }
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public boolean isSetPublic() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PUBLIC$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void setPublic(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PUBLIC$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void xsetPublic(Public r4) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PUBLIC$2;
                Public r1 = (Public) typeStore.find_attribute_user(qName);
                if (r1 == null) {
                    r1 = (Public) get_store().add_attribute_user(qName);
                }
                r1.set(r4);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void unsetPublic() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PUBLIC$2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public String getSystem() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SYSTEM$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public XmlAnyURI xgetSystem() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(SYSTEM$4);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public boolean isSetSystem() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(SYSTEM$4) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void setSystem(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SYSTEM$4;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void xsetSystem(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SYSTEM$4;
                XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
                if (xmlAnyURI2 == null) {
                    xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURI2.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void unsetSystem() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(SYSTEM$4);
            }
        }
    }
}
