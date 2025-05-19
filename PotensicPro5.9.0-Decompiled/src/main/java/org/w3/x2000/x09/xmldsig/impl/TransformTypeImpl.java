package org.w3.x2000.x09.xmldsig.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.TransformType;

/* loaded from: classes6.dex */
public class TransformTypeImpl extends XmlComplexContentImpl implements TransformType {
    private static final QName XPATH$0 = new QName(SignatureFacet.XML_DIGSIG_NS, "XPath");
    private static final QName ALGORITHM$2 = new QName("", "Algorithm");

    public TransformTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlString addNewXPath() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(XPATH$0);
        }
        return xmlString;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void addXPath(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(XPATH$0)).setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public String getAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALGORITHM$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public String getXPathArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(XPATH$0, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public String[] getXPathArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(XPATH$0, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public List<String> getXPathList() {
        1XPathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1XPathList(this);
        }
        return r1;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlString insertNewXPath(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(XPATH$0, i);
        }
        return xmlString;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void insertXPath(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(XPATH$0, i)).setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void removeXPath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(XPATH$0, i);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void setAlgorithm(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGORITHM$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void setXPathArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(XPATH$0, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void setXPathArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, XPATH$0);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public int sizeOfXPathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(XPATH$0);
        }
        return count_elements;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlAnyURI xgetAlgorithm() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(ALGORITHM$2);
        }
        return xmlAnyURI;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlString xgetXPathArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(XPATH$0, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlString[] xgetXPathArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(XPATH$0, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public List<XmlString> xgetXPathList() {
        2XPathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2XPathList(this);
        }
        return r1;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void xsetAlgorithm(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGORITHM$2;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void xsetXPathArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(XPATH$0, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void xsetXPathArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, XPATH$0);
        }
    }
}
