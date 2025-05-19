package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedAngle;

/* loaded from: classes5.dex */
public class CTLinearShadePropertiesImpl extends XmlComplexContentImpl implements CTLinearShadeProperties {
    private static final QName ANG$0 = new QName("", "ang");
    private static final QName SCALED$2 = new QName("", "scaled");

    public CTLinearShadePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public int getAng() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ANG$0);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public boolean getScaled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SCALED$2);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public boolean isSetAng() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ANG$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public boolean isSetScaled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SCALED$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void setAng(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANG$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void setScaled(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALED$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void unsetAng() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ANG$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void unsetScaled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SCALED$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public STPositiveFixedAngle xgetAng() {
        STPositiveFixedAngle sTPositiveFixedAngle;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveFixedAngle = (STPositiveFixedAngle) get_store().find_attribute_user(ANG$0);
        }
        return sTPositiveFixedAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public XmlBoolean xgetScaled() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(SCALED$2);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void xsetAng(STPositiveFixedAngle sTPositiveFixedAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANG$0;
            STPositiveFixedAngle sTPositiveFixedAngle2 = (STPositiveFixedAngle) typeStore.find_attribute_user(qName);
            if (sTPositiveFixedAngle2 == null) {
                sTPositiveFixedAngle2 = (STPositiveFixedAngle) get_store().add_attribute_user(qName);
            }
            sTPositiveFixedAngle2.set(sTPositiveFixedAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties
    public void xsetScaled(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALED$2;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }
}
