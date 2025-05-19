package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

/* loaded from: classes6.dex */
public class CTSheetImpl extends XmlComplexContentImpl implements CTSheet {
    private static final QName NAME$0 = new QName("", "name");
    private static final QName SHEETID$2 = new QName("", "sheetId");
    private static final QName STATE$4 = new QName("", "state");
    private static final QName ID$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", TtmlNode.ATTR_ID);

    public CTSheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public long getSheetId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SHEETID$2);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public STSheetState.Enum getState() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATE$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STSheetState.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public boolean isSetState() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STATE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void setSheetId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETID$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void setState(STSheetState.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATE$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void unsetState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STATE$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID$6);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public STXstring xgetName() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(NAME$0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public XmlUnsignedInt xgetSheetId() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(SHEETID$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public STSheetState xgetState() {
        STSheetState sTSheetState;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATE$4;
            sTSheetState = (STSheetState) typeStore.find_attribute_user(qName);
            if (sTSheetState == null) {
                sTSheetState = (STSheetState) get_default_attribute_value(qName);
            }
        }
        return sTSheetState;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void xsetName(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void xsetSheetId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETID$2;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet
    public void xsetState(STSheetState sTSheetState) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATE$4;
            STSheetState sTSheetState2 = (STSheetState) typeStore.find_attribute_user(qName);
            if (sTSheetState2 == null) {
                sTSheetState2 = (STSheetState) get_store().add_attribute_user(qName);
            }
            sTSheetState2.set(sTSheetState);
        }
    }
}
