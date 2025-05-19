package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.Calendar;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDateTime;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

/* loaded from: classes6.dex */
public class CTTrackChangeImpl extends CTMarkupImpl implements CTTrackChange {
    private static final QName AUTHOR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "author");
    private static final QName DATE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "date");

    public CTTrackChangeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public String getAuthor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(AUTHOR$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public Calendar getDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DATE$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public boolean isSetDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DATE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public void setAuthor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTHOR$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public void setDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public void unsetDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DATE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public STString xgetAuthor() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(AUTHOR$0);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public STDateTime xgetDate() {
        STDateTime find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(DATE$2);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public void xsetAuthor(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTHOR$0;
            STString sTString2 = (STString) typeStore.find_attribute_user(qName);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qName);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange
    public void xsetDate(STDateTime sTDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATE$2;
            STDateTime find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STDateTime) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTDateTime);
        }
    }
}
