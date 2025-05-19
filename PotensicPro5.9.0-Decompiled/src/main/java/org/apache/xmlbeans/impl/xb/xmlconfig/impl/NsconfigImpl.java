package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import aavax.xml.namespace.QName;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList;
import org.apache.xmlbeans.impl.xb.xmlconfig.NamespacePrefixList;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;

/* loaded from: classes5.dex */
public class NsconfigImpl extends XmlComplexContentImpl implements Nsconfig {
    private static final QName PACKAGE$0 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "package");
    private static final QName PREFIX$2 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "prefix");
    private static final QName SUFFIX$4 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "suffix");
    private static final QName URI$6 = new QName("", "uri");
    private static final QName URIPREFIX$8 = new QName("", "uriprefix");

    public NsconfigImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public String getPackage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PACKAGE$0, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public XmlString xgetPackage() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PACKAGE$0, 0);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetPackage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PACKAGE$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setPackage(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PACKAGE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetPackage(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PACKAGE$0;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetPackage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PACKAGE$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public String getPrefix() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PREFIX$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public XmlString xgetPrefix() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PREFIX$2, 0);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetPrefix() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PREFIX$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setPrefix(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFIX$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetPrefix(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFIX$2;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetPrefix() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PREFIX$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public String getSuffix() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SUFFIX$4, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public XmlString xgetSuffix() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(SUFFIX$4, 0);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetSuffix() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUFFIX$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setSuffix(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUFFIX$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetSuffix(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUFFIX$4;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetSuffix() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUFFIX$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public Object getUri() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public NamespaceList xgetUri() {
        NamespaceList namespaceList;
        synchronized (monitor()) {
            check_orphaned();
            namespaceList = (NamespaceList) get_store().find_attribute_user(URI$6);
        }
        return namespaceList;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetUri() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setUri(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetUri(NamespaceList namespaceList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$6;
            NamespaceList namespaceList2 = (NamespaceList) typeStore.find_attribute_user(qName);
            if (namespaceList2 == null) {
                namespaceList2 = (NamespaceList) get_store().add_attribute_user(qName);
            }
            namespaceList2.set(namespaceList);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetUri() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public List getUriprefix() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URIPREFIX$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getListValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public NamespacePrefixList xgetUriprefix() {
        NamespacePrefixList namespacePrefixList;
        synchronized (monitor()) {
            check_orphaned();
            namespacePrefixList = (NamespacePrefixList) get_store().find_attribute_user(URIPREFIX$8);
        }
        return namespacePrefixList;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetUriprefix() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URIPREFIX$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setUriprefix(List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URIPREFIX$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setListValue(list);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetUriprefix(NamespacePrefixList namespacePrefixList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URIPREFIX$8;
            NamespacePrefixList namespacePrefixList2 = (NamespacePrefixList) typeStore.find_attribute_user(qName);
            if (namespacePrefixList2 == null) {
                namespacePrefixList2 = (NamespacePrefixList) get_store().add_attribute_user(qName);
            }
            namespacePrefixList2.set(namespacePrefixList);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetUriprefix() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URIPREFIX$8);
        }
    }
}
