package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.JavaNameList;

/* loaded from: classes5.dex */
public class ExtensionconfigImpl extends XmlComplexContentImpl implements Extensionconfig {
    private static final QName INTERFACE$0 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", JamXmlElements.INTERFACE);
    private static final QName PREPOSTSET$2 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "prePostSet");
    private static final QName FOR$4 = new QName("", "for");

    public ExtensionconfigImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.Interface[] getInterfaceArray() {
        Extensionconfig.Interface[] interfaceArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INTERFACE$0, arrayList);
            interfaceArr = new Extensionconfig.Interface[arrayList.size()];
            arrayList.toArray(interfaceArr);
        }
        return interfaceArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.Interface getInterfaceArray(int i) {
        Extensionconfig.Interface r4;
        synchronized (monitor()) {
            check_orphaned();
            r4 = (Extensionconfig.Interface) get_store().find_element_user(INTERFACE$0, i);
            if (r4 == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return r4;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public int sizeOfInterfaceArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INTERFACE$0);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void setInterfaceArray(Extensionconfig.Interface[] interfaceArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(interfaceArr, INTERFACE$0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void setInterfaceArray(int i, Extensionconfig.Interface r5) {
        synchronized (monitor()) {
            check_orphaned();
            Extensionconfig.Interface r4 = (Extensionconfig.Interface) get_store().find_element_user(INTERFACE$0, i);
            if (r4 == null) {
                throw new IndexOutOfBoundsException();
            }
            r4.set(r5);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.Interface insertNewInterface(int i) {
        Extensionconfig.Interface r4;
        synchronized (monitor()) {
            check_orphaned();
            r4 = (Extensionconfig.Interface) get_store().insert_element_user(INTERFACE$0, i);
        }
        return r4;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.Interface addNewInterface() {
        Extensionconfig.Interface r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = (Extensionconfig.Interface) get_store().add_element_user(INTERFACE$0);
        }
        return r1;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void removeInterface(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INTERFACE$0, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.PrePostSet getPrePostSet() {
        synchronized (monitor()) {
            check_orphaned();
            Extensionconfig.PrePostSet prePostSet = (Extensionconfig.PrePostSet) get_store().find_element_user(PREPOSTSET$2, 0);
            if (prePostSet == null) {
                return null;
            }
            return prePostSet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public boolean isSetPrePostSet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PREPOSTSET$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void setPrePostSet(Extensionconfig.PrePostSet prePostSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREPOSTSET$2;
            Extensionconfig.PrePostSet prePostSet2 = (Extensionconfig.PrePostSet) typeStore.find_element_user(qName, 0);
            if (prePostSet2 == null) {
                prePostSet2 = (Extensionconfig.PrePostSet) get_store().add_element_user(qName);
            }
            prePostSet2.set(prePostSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.PrePostSet addNewPrePostSet() {
        Extensionconfig.PrePostSet prePostSet;
        synchronized (monitor()) {
            check_orphaned();
            prePostSet = (Extensionconfig.PrePostSet) get_store().add_element_user(PREPOSTSET$2);
        }
        return prePostSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void unsetPrePostSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PREPOSTSET$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Object getFor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FOR$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public JavaNameList xgetFor() {
        JavaNameList javaNameList;
        synchronized (monitor()) {
            check_orphaned();
            javaNameList = (JavaNameList) get_store().find_attribute_user(FOR$4);
        }
        return javaNameList;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public boolean isSetFor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOR$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void setFor(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOR$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void xsetFor(JavaNameList javaNameList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOR$4;
            JavaNameList javaNameList2 = (JavaNameList) typeStore.find_attribute_user(qName);
            if (javaNameList2 == null) {
                javaNameList2 = (JavaNameList) get_store().add_attribute_user(qName);
            }
            javaNameList2.set(javaNameList);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void unsetFor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOR$4);
        }
    }

    public static class InterfaceImpl extends XmlComplexContentImpl implements Extensionconfig.Interface {
        private static final QName STATICHANDLER$0 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "staticHandler");
        private static final QName NAME$2 = new QName("", "name");

        public InterfaceImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public String getStaticHandler() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(STATICHANDLER$0, 0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public XmlString xgetStaticHandler() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(STATICHANDLER$0, 0);
            }
            return xmlString;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void setStaticHandler(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STATICHANDLER$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void xsetStaticHandler(XmlString xmlString) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STATICHANDLER$0;
                XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_element_user(qName);
                }
                xmlString2.set(xmlString);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public String getName() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public XmlString xgetName() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_attribute_user(NAME$2);
            }
            return xmlString;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public boolean isSetName() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(NAME$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void setName(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void xsetName(XmlString xmlString) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$2;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void unsetName() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(NAME$2);
            }
        }
    }

    public static class PrePostSetImpl extends XmlComplexContentImpl implements Extensionconfig.PrePostSet {
        private static final QName STATICHANDLER$0 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "staticHandler");

        public PrePostSetImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.PrePostSet
        public String getStaticHandler() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(STATICHANDLER$0, 0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.PrePostSet
        public XmlString xgetStaticHandler() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(STATICHANDLER$0, 0);
            }
            return xmlString;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.PrePostSet
        public void setStaticHandler(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STATICHANDLER$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.PrePostSet
        public void xsetStaticHandler(XmlString xmlString) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STATICHANDLER$0;
                XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_element_user(qName);
                }
                xmlString2.set(xmlString);
            }
        }
    }
}
