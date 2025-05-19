package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;

/* loaded from: classes5.dex */
public class UnionDocumentImpl extends XmlComplexContentImpl implements UnionDocument {
    private static final QName UNION$0 = new QName("http://www.w3.org/2001/XMLSchema", XmlErrorCodes.UNION);

    public UnionDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public UnionDocument.Union getUnion() {
        synchronized (monitor()) {
            check_orphaned();
            UnionDocument.Union union = (UnionDocument.Union) get_store().find_element_user(UNION$0, 0);
            if (union == null) {
                return null;
            }
            return union;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public void setUnion(UnionDocument.Union union) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNION$0;
            UnionDocument.Union union2 = (UnionDocument.Union) typeStore.find_element_user(qName, 0);
            if (union2 == null) {
                union2 = (UnionDocument.Union) get_store().add_element_user(qName);
            }
            union2.set(union);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public UnionDocument.Union addNewUnion() {
        UnionDocument.Union union;
        synchronized (monitor()) {
            check_orphaned();
            union = (UnionDocument.Union) get_store().add_element_user(UNION$0);
        }
        return union;
    }

    public static class UnionImpl extends AnnotatedImpl implements UnionDocument.Union {
        private static final QName SIMPLETYPE$0 = new QName("http://www.w3.org/2001/XMLSchema", "simpleType");
        private static final QName MEMBERTYPES$2 = new QName("", "memberTypes");

        public UnionImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType[] getSimpleTypeArray() {
            LocalSimpleType[] localSimpleTypeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(SIMPLETYPE$0, arrayList);
                localSimpleTypeArr = new LocalSimpleType[arrayList.size()];
                arrayList.toArray(localSimpleTypeArr);
            }
            return localSimpleTypeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType getSimpleTypeArray(int i) {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$0, i);
                if (localSimpleType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public int sizeOfSimpleTypeArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(SIMPLETYPE$0);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setSimpleTypeArray(LocalSimpleType[] localSimpleTypeArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(localSimpleTypeArr, SIMPLETYPE$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setSimpleTypeArray(int i, LocalSimpleType localSimpleType) {
            synchronized (monitor()) {
                check_orphaned();
                LocalSimpleType localSimpleType2 = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$0, i);
                if (localSimpleType2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                localSimpleType2.set(localSimpleType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType insertNewSimpleType(int i) {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().insert_element_user(SIMPLETYPE$0, i);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType addNewSimpleType() {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void removeSimpleType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SIMPLETYPE$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public List getMemberTypes() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MEMBERTYPES$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getListValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public UnionDocument.Union.MemberTypes xgetMemberTypes() {
            UnionDocument.Union.MemberTypes memberTypes;
            synchronized (monitor()) {
                check_orphaned();
                memberTypes = (UnionDocument.Union.MemberTypes) get_store().find_attribute_user(MEMBERTYPES$2);
            }
            return memberTypes;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public boolean isSetMemberTypes() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(MEMBERTYPES$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setMemberTypes(List list) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MEMBERTYPES$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setListValue(list);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void xsetMemberTypes(UnionDocument.Union.MemberTypes memberTypes) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MEMBERTYPES$2;
                UnionDocument.Union.MemberTypes memberTypes2 = (UnionDocument.Union.MemberTypes) typeStore.find_attribute_user(qName);
                if (memberTypes2 == null) {
                    memberTypes2 = (UnionDocument.Union.MemberTypes) get_store().add_attribute_user(qName);
                }
                memberTypes2.set(memberTypes);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void unsetMemberTypes() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(MEMBERTYPES$2);
            }
        }

        public static class MemberTypesImpl extends XmlListImpl implements UnionDocument.Union.MemberTypes {
            public MemberTypesImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected MemberTypesImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
