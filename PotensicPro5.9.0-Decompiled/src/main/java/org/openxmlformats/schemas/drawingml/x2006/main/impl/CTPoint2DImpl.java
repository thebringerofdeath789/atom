package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;

/* loaded from: classes5.dex */
public class CTPoint2DImpl extends XmlComplexContentImpl implements CTPoint2D {
    private static final QName X$0 = new QName("", "x");
    private static final QName Y$2 = new QName("", "y");

    public CTPoint2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D
    public long getX() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(X$0);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D
    public long getY() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(Y$2);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D
    public void setX(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D
    public void setY(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = Y$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D
    public STCoordinate xgetX() {
        STCoordinate sTCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate = (STCoordinate) get_store().find_attribute_user(X$0);
        }
        return sTCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D
    public STCoordinate xgetY() {
        STCoordinate sTCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate = (STCoordinate) get_store().find_attribute_user(Y$2);
        }
        return sTCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D
    public void xsetX(STCoordinate sTCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X$0;
            STCoordinate sTCoordinate2 = (STCoordinate) typeStore.find_attribute_user(qName);
            if (sTCoordinate2 == null) {
                sTCoordinate2 = (STCoordinate) get_store().add_attribute_user(qName);
            }
            sTCoordinate2.set(sTCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D
    public void xsetY(STCoordinate sTCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = Y$2;
            STCoordinate sTCoordinate2 = (STCoordinate) typeStore.find_attribute_user(qName);
            if (sTCoordinate2 == null) {
                sTCoordinate2 = (STCoordinate) get_store().add_attribute_user(qName);
            }
            sTCoordinate2.set(sTCoordinate);
        }
    }
}
