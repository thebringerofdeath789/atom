package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

/* loaded from: classes6.dex */
public class CTSymImpl extends XmlComplexContentImpl implements CTSym {
    private static final QName FONT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", CellUtil.FONT);
    private static final QName CHAR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "char");

    public CTSymImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public byte[] getChar() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CHAR$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public String getFont() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FONT$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public boolean isSetChar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHAR$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public boolean isSetFont() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FONT$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void setChar(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHAR$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void setFont(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONT$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void unsetChar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHAR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void unsetFont() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FONT$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public STShortHexNumber xgetChar() {
        STShortHexNumber find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(CHAR$2);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public STString xgetFont() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(FONT$0);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void xsetChar(STShortHexNumber sTShortHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHAR$2;
            STShortHexNumber find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STShortHexNumber) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTShortHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void xsetFont(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONT$0;
            STString sTString2 = (STString) typeStore.find_attribute_user(qName);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qName);
            }
            sTString2.set(sTString);
        }
    }
}
