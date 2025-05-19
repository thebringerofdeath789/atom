package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.Calendar;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CRLIdentifierType;

/* loaded from: classes5.dex */
public class CRLIdentifierTypeImpl extends XmlComplexContentImpl implements CRLIdentifierType {
    private static final QName ISSUER$0 = new QName(SignatureFacet.XADES_132_NS, "Issuer");
    private static final QName ISSUETIME$2 = new QName(SignatureFacet.XADES_132_NS, "IssueTime");
    private static final QName NUMBER$4 = new QName(SignatureFacet.XADES_132_NS, "Number");
    private static final QName URI$6 = new QName("", "URI");

    public CRLIdentifierTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public Calendar getIssueTime() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ISSUETIME$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getCalendarValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public String getIssuer() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ISSUER$0, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public BigInteger getNumber() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(NUMBER$4, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public String getURI() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public boolean isSetNumber() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMBER$4) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public boolean isSetURI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$6) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void setIssueTime(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUETIME$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void setIssuer(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUER$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void setNumber(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMBER$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void setURI(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void unsetNumber() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMBER$4, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void unsetURI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$6);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public XmlDateTime xgetIssueTime() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_element_user(ISSUETIME$2, 0);
        }
        return xmlDateTime;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public XmlString xgetIssuer() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(ISSUER$0, 0);
        }
        return xmlString;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public XmlInteger xgetNumber() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(NUMBER$4, 0);
        }
        return xmlInteger;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public XmlAnyURI xgetURI() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(URI$6);
        }
        return xmlAnyURI;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void xsetIssueTime(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUETIME$2;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_element_user(qName, 0);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void xsetIssuer(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUER$0;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void xsetNumber(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMBER$4;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_element_user(qName, 0);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_element_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void xsetURI(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$6;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }
}
