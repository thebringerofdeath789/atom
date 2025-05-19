package org.w3.x2000.x09.xmldsig.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.X509IssuerSerialType;

/* loaded from: classes6.dex */
public class X509IssuerSerialTypeImpl extends XmlComplexContentImpl implements X509IssuerSerialType {
    private static final QName X509ISSUERNAME$0 = new QName(SignatureFacet.XML_DIGSIG_NS, "X509IssuerName");
    private static final QName X509SERIALNUMBER$2 = new QName(SignatureFacet.XML_DIGSIG_NS, "X509SerialNumber");

    public X509IssuerSerialTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public String getX509IssuerName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(X509ISSUERNAME$0, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public BigInteger getX509SerialNumber() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(X509SERIALNUMBER$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public void setX509IssuerName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509ISSUERNAME$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public void setX509SerialNumber(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509SERIALNUMBER$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public XmlString xgetX509IssuerName() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(X509ISSUERNAME$0, 0);
        }
        return xmlString;
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public XmlInteger xgetX509SerialNumber() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(X509SERIALNUMBER$2, 0);
        }
        return xmlInteger;
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public void xsetX509IssuerName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509ISSUERNAME$0;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public void xsetX509SerialNumber(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509SERIALNUMBER$2;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_element_user(qName, 0);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_element_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }
}
