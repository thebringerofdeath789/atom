package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import aavax.xml.namespace.QName;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetlist;

/* loaded from: classes5.dex */
public class QnameconfigImpl extends XmlComplexContentImpl implements Qnameconfig {
    private static final QName NAME$0 = new QName("", "name");
    private static final QName JAVANAME$2 = new QName("", "javaname");
    private static final QName TARGET$4 = new QName("", "target");

    public QnameconfigImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public QName getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public XmlQName xgetName() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(NAME$0);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void setName(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = NAME$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void xsetName(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public String getJavaname() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(JAVANAME$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public XmlString xgetJavaname() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(JAVANAME$2);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public boolean isSetJavaname() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(JAVANAME$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void setJavaname(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JAVANAME$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void xsetJavaname(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JAVANAME$2;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void unsetJavaname() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(JAVANAME$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public List getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getListValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public Qnametargetlist xgetTarget() {
        Qnametargetlist qnametargetlist;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            qnametargetlist = (Qnametargetlist) typeStore.find_attribute_user(qName);
            if (qnametargetlist == null) {
                qnametargetlist = (Qnametargetlist) get_default_attribute_value(qName);
            }
        }
        return qnametargetlist;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void setTarget(List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setListValue(list);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void xsetTarget(Qnametargetlist qnametargetlist) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            Qnametargetlist qnametargetlist2 = (Qnametargetlist) typeStore.find_attribute_user(qName);
            if (qnametargetlist2 == null) {
                qnametargetlist2 = (Qnametargetlist) get_store().add_attribute_user(qName);
            }
            qnametargetlist2.set(qnametargetlist);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$4);
        }
    }
}
