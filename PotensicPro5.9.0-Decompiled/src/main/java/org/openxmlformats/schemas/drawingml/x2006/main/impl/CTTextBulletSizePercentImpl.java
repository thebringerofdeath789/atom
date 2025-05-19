package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextBulletSizePercent;

/* loaded from: classes5.dex */
public class CTTextBulletSizePercentImpl extends XmlComplexContentImpl implements CTTextBulletSizePercent {
    private static final QName VAL$0 = new QName("", "val");

    public CTTextBulletSizePercentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public int getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public void setVal(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public STTextBulletSizePercent xgetVal() {
        STTextBulletSizePercent sTTextBulletSizePercent;
        synchronized (monitor()) {
            check_orphaned();
            sTTextBulletSizePercent = (STTextBulletSizePercent) get_store().find_attribute_user(VAL$0);
        }
        return sTTextBulletSizePercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent
    public void xsetVal(STTextBulletSizePercent sTTextBulletSizePercent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTextBulletSizePercent sTTextBulletSizePercent2 = (STTextBulletSizePercent) typeStore.find_attribute_user(qName);
            if (sTTextBulletSizePercent2 == null) {
                sTTextBulletSizePercent2 = (STTextBulletSizePercent) get_store().add_attribute_user(qName);
            }
            sTTextBulletSizePercent2.set(sTTextBulletSizePercent);
        }
    }
}
