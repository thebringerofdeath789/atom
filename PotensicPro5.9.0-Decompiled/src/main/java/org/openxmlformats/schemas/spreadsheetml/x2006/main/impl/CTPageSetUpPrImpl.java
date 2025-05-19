package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr;

/* loaded from: classes6.dex */
public class CTPageSetUpPrImpl extends XmlComplexContentImpl implements CTPageSetUpPr {
    private static final QName AUTOPAGEBREAKS$0 = new QName("", "autoPageBreaks");
    private static final QName FITTOPAGE$2 = new QName("", "fitToPage");

    public CTPageSetUpPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public boolean getAutoPageBreaks() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOPAGEBREAKS$0;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public boolean getFitToPage() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOPAGE$2;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public boolean isSetAutoPageBreaks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AUTOPAGEBREAKS$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public boolean isSetFitToPage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FITTOPAGE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public void setAutoPageBreaks(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOPAGEBREAKS$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public void setFitToPage(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOPAGE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public void unsetAutoPageBreaks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AUTOPAGEBREAKS$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public void unsetFitToPage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FITTOPAGE$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public XmlBoolean xgetAutoPageBreaks() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOPAGEBREAKS$0;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public XmlBoolean xgetFitToPage() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOPAGE$2;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public void xsetAutoPageBreaks(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOPAGEBREAKS$0;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr
    public void xsetFitToPage(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOPAGE$2;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }
}
