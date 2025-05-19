package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob;

/* loaded from: classes2.dex */
public class CTDigSigBlobImpl extends XmlComplexContentImpl implements CTDigSigBlob {
    private static final QName BLOB$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "blob");

    public CTDigSigBlobImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob
    public byte[] getBlob() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BLOB$0, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob
    public void setBlob(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob
    public XmlBase64Binary xgetBlob() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(BLOB$0, 0);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob
    public void xsetBlob(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$0;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qName, 0);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }
}
