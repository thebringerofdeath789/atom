package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLang;

/* loaded from: classes6.dex */
public class CTLanguageImpl extends XmlComplexContentImpl implements CTLanguage {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    private static final QName EASTASIA$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsia");
    private static final QName BIDI$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidi");

    public CTLanguageImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public Object getBidi() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BIDI$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public Object getEastAsia() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EASTASIA$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public Object getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public boolean isSetBidi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BIDI$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public boolean isSetEastAsia() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EASTASIA$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void setBidi(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BIDI$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void setEastAsia(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIA$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void setVal(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void unsetBidi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BIDI$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void unsetEastAsia() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EASTASIA$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public STLang xgetBidi() {
        STLang sTLang;
        synchronized (monitor()) {
            check_orphaned();
            sTLang = (STLang) get_store().find_attribute_user(BIDI$4);
        }
        return sTLang;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public STLang xgetEastAsia() {
        STLang sTLang;
        synchronized (monitor()) {
            check_orphaned();
            sTLang = (STLang) get_store().find_attribute_user(EASTASIA$2);
        }
        return sTLang;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public STLang xgetVal() {
        STLang sTLang;
        synchronized (monitor()) {
            check_orphaned();
            sTLang = (STLang) get_store().find_attribute_user(VAL$0);
        }
        return sTLang;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void xsetBidi(STLang sTLang) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BIDI$4;
            STLang sTLang2 = (STLang) typeStore.find_attribute_user(qName);
            if (sTLang2 == null) {
                sTLang2 = (STLang) get_store().add_attribute_user(qName);
            }
            sTLang2.set(sTLang);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void xsetEastAsia(STLang sTLang) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIA$2;
            STLang sTLang2 = (STLang) typeStore.find_attribute_user(qName);
            if (sTLang2 == null) {
                sTLang2 = (STLang) get_store().add_attribute_user(qName);
            }
            sTLang2.set(sTLang);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage
    public void xsetVal(STLang sTLang) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STLang sTLang2 = (STLang) typeStore.find_attribute_user(qName);
            if (sTLang2 == null) {
                sTLang2 = (STLang) get_store().add_attribute_user(qName);
            }
            sTLang2.set(sTLang);
        }
    }
}
