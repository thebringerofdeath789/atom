package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData;

/* loaded from: classes5.dex */
public class CTAnchorClientDataImpl extends XmlComplexContentImpl implements CTAnchorClientData {
    private static final QName FLOCKSWITHSHEET$0 = new QName("", "fLocksWithSheet");
    private static final QName FPRINTSWITHSHEET$2 = new QName("", "fPrintsWithSheet");

    public CTAnchorClientDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public boolean getFLocksWithSheet() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOCKSWITHSHEET$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public boolean getFPrintsWithSheet() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPRINTSWITHSHEET$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public boolean isSetFLocksWithSheet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FLOCKSWITHSHEET$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public boolean isSetFPrintsWithSheet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FPRINTSWITHSHEET$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public void setFLocksWithSheet(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOCKSWITHSHEET$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public void setFPrintsWithSheet(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPRINTSWITHSHEET$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public void unsetFLocksWithSheet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FLOCKSWITHSHEET$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public void unsetFPrintsWithSheet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FPRINTSWITHSHEET$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public XmlBoolean xgetFLocksWithSheet() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOCKSWITHSHEET$0;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public XmlBoolean xgetFPrintsWithSheet() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPRINTSWITHSHEET$2;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public void xsetFLocksWithSheet(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOCKSWITHSHEET$0;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData
    public void xsetFPrintsWithSheet(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPRINTSWITHSHEET$2;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }
}
