package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;

/* loaded from: classes5.dex */
public class CTPath2DArcToImpl extends XmlComplexContentImpl implements CTPath2DArcTo {
    private static final QName WR$0 = new QName("", "wR");
    private static final QName HR$2 = new QName("", "hR");
    private static final QName STANG$4 = new QName("", "stAng");
    private static final QName SWANG$6 = new QName("", "swAng");

    public CTPath2DArcToImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public Object getHR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HR$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public Object getStAng() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STANG$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public Object getSwAng() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SWANG$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public Object getWR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(WR$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void setHR(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void setStAng(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STANG$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void setSwAng(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SWANG$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void setWR(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WR$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public STAdjCoordinate xgetHR() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(HR$2);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public STAdjAngle xgetStAng() {
        STAdjAngle sTAdjAngle;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjAngle = (STAdjAngle) get_store().find_attribute_user(STANG$4);
        }
        return sTAdjAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public STAdjAngle xgetSwAng() {
        STAdjAngle sTAdjAngle;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjAngle = (STAdjAngle) get_store().find_attribute_user(SWANG$6);
        }
        return sTAdjAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public STAdjCoordinate xgetWR() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(WR$0);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void xsetHR(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$2;
            STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qName);
            if (sTAdjCoordinate2 == null) {
                sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qName);
            }
            sTAdjCoordinate2.set(sTAdjCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void xsetStAng(STAdjAngle sTAdjAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STANG$4;
            STAdjAngle sTAdjAngle2 = (STAdjAngle) typeStore.find_attribute_user(qName);
            if (sTAdjAngle2 == null) {
                sTAdjAngle2 = (STAdjAngle) get_store().add_attribute_user(qName);
            }
            sTAdjAngle2.set(sTAdjAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void xsetSwAng(STAdjAngle sTAdjAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SWANG$6;
            STAdjAngle sTAdjAngle2 = (STAdjAngle) typeStore.find_attribute_user(qName);
            if (sTAdjAngle2 == null) {
                sTAdjAngle2 = (STAdjAngle) get_store().add_attribute_user(qName);
            }
            sTAdjAngle2.set(sTAdjAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void xsetWR(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WR$0;
            STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qName);
            if (sTAdjCoordinate2 == null) {
                sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qName);
            }
            sTAdjCoordinate2.set(sTAdjCoordinate);
        }
    }
}
