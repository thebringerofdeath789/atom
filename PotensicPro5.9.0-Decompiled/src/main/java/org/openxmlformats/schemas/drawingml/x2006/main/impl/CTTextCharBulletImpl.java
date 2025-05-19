package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet;

/* loaded from: classes5.dex */
public class CTTextCharBulletImpl extends XmlComplexContentImpl implements CTTextCharBullet {
    private static final QName CHAR$0 = new QName("", "char");

    public CTTextCharBulletImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet
    public String getChar() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CHAR$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet
    public void setChar(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHAR$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet
    public XmlString xgetChar() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(CHAR$0);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet
    public void xsetChar(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHAR$0;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
