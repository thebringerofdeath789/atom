package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.ResponderIDType;

/* loaded from: classes5.dex */
public class ResponderIDTypeImpl extends XmlComplexContentImpl implements ResponderIDType {
    private static final QName BYNAME$0 = new QName(SignatureFacet.XADES_132_NS, "ByName");
    private static final QName BYKEY$2 = new QName(SignatureFacet.XADES_132_NS, "ByKey");

    public ResponderIDTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public byte[] getByKey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BYKEY$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public String getByName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BYNAME$0, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public boolean isSetByKey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BYKEY$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public boolean isSetByName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BYNAME$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void setByKey(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BYKEY$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void setByName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BYNAME$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void unsetByKey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BYKEY$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void unsetByName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BYNAME$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public XmlBase64Binary xgetByKey() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(BYKEY$2, 0);
        }
        return xmlBase64Binary;
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public XmlString xgetByName() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(BYNAME$0, 0);
        }
        return xmlString;
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void xsetByKey(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BYKEY$2;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qName, 0);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void xsetByName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BYNAME$0;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
