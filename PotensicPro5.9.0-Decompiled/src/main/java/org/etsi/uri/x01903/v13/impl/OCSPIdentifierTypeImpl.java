package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import java.util.Calendar;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.OCSPIdentifierType;
import org.etsi.uri.x01903.v13.ResponderIDType;

/* loaded from: classes5.dex */
public class OCSPIdentifierTypeImpl extends XmlComplexContentImpl implements OCSPIdentifierType {
    private static final QName RESPONDERID$0 = new QName(SignatureFacet.XADES_132_NS, "ResponderID");
    private static final QName PRODUCEDAT$2 = new QName(SignatureFacet.XADES_132_NS, "ProducedAt");
    private static final QName URI$4 = new QName("", "URI");

    public OCSPIdentifierTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public ResponderIDType addNewResponderID() {
        ResponderIDType responderIDType;
        synchronized (monitor()) {
            check_orphaned();
            responderIDType = (ResponderIDType) get_store().add_element_user(RESPONDERID$0);
        }
        return responderIDType;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public Calendar getProducedAt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PRODUCEDAT$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getCalendarValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public ResponderIDType getResponderID() {
        synchronized (monitor()) {
            check_orphaned();
            ResponderIDType responderIDType = (ResponderIDType) get_store().find_element_user(RESPONDERID$0, 0);
            if (responderIDType == null) {
                return null;
            }
            return responderIDType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public String getURI() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public boolean isSetURI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$4) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void setProducedAt(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRODUCEDAT$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void setResponderID(ResponderIDType responderIDType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RESPONDERID$0;
            ResponderIDType responderIDType2 = (ResponderIDType) typeStore.find_element_user(qName, 0);
            if (responderIDType2 == null) {
                responderIDType2 = (ResponderIDType) get_store().add_element_user(qName);
            }
            responderIDType2.set(responderIDType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void setURI(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void unsetURI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$4);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public XmlDateTime xgetProducedAt() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_element_user(PRODUCEDAT$2, 0);
        }
        return xmlDateTime;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public XmlAnyURI xgetURI() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(URI$4);
        }
        return xmlAnyURI;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void xsetProducedAt(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRODUCEDAT$2;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_element_user(qName, 0);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void xsetURI(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }
}
