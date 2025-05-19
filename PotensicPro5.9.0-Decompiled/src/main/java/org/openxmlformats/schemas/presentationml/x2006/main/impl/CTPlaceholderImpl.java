package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.STDirection;
import org.openxmlformats.schemas.presentationml.x2006.main.STDirection$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderSize;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderSize$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* loaded from: classes6.dex */
public class CTPlaceholderImpl extends XmlComplexContentImpl implements CTPlaceholder {
    private static final QName EXTLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName TYPE$2 = new QName("", "type");
    private static final QName ORIENT$4 = new QName("", "orient");
    private static final QName SZ$6 = new QName("", "sz");
    private static final QName IDX$8 = new QName("", "idx");
    private static final QName HASCUSTOMPROMPT$10 = new QName("", "hasCustomPrompt");

    public CTPlaceholderImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionListModify find_element_user = get_store().find_element_user(EXTLST$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean getHasCustomPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASCUSTOMPROMPT$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public long getIdx() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STDirection$Enum getOrient() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENT$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STDirection$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderSize$Enum getSz() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STPlaceholderSize$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STPlaceholderType.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetHasCustomPrompt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HASCUSTOMPROMPT$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetIdx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(IDX$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetOrient() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIENT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SZ$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$0;
            CTExtensionListModify find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionListModify) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionListModify);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setHasCustomPrompt(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASCUSTOMPROMPT$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setIdx(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setOrient(STDirection$Enum sTDirection$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENT$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTDirection$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setSz(STPlaceholderSize$Enum sTPlaceholderSize$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTPlaceholderSize$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setType(STPlaceholderType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetHasCustomPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HASCUSTOMPROMPT$10);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetIdx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(IDX$8);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetOrient() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIENT$4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SZ$6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public XmlBoolean xgetHasCustomPrompt() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASCUSTOMPROMPT$10;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public XmlUnsignedInt xgetIdx() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$8;
            xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt == null) {
                xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STDirection xgetOrient() {
        STDirection find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENT$4;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STDirection) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderSize xgetSz() {
        STPlaceholderSize find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$6;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STPlaceholderSize) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderType xgetType() {
        STPlaceholderType sTPlaceholderType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            sTPlaceholderType = (STPlaceholderType) typeStore.find_attribute_user(qName);
            if (sTPlaceholderType == null) {
                sTPlaceholderType = (STPlaceholderType) get_default_attribute_value(qName);
            }
        }
        return sTPlaceholderType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetHasCustomPrompt(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASCUSTOMPROMPT$10;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetIdx(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$8;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetOrient(STDirection sTDirection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENT$4;
            STDirection find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STDirection) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTDirection);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetSz(STPlaceholderSize sTPlaceholderSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$6;
            STPlaceholderSize find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STPlaceholderSize) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTPlaceholderSize);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetType(STPlaceholderType sTPlaceholderType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            STPlaceholderType sTPlaceholderType2 = (STPlaceholderType) typeStore.find_attribute_user(qName);
            if (sTPlaceholderType2 == null) {
                sTPlaceholderType2 = (STPlaceholderType) get_store().add_attribute_user(qName);
            }
            sTPlaceholderType2.set(sTPlaceholderType);
        }
    }
}
