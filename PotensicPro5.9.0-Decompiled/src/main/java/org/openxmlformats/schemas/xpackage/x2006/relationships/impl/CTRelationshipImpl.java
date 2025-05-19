package org.openxmlformats.schemas.xpackage.x2006.relationships.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship;
import org.openxmlformats.schemas.xpackage.x2006.relationships.STTargetMode;

/* loaded from: classes6.dex */
public class CTRelationshipImpl extends JavaStringHolderEx implements CTRelationship {
    private static final QName TARGETMODE$0 = new QName("", PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME);
    private static final QName TARGET$2 = new QName("", PackageRelationship.TARGET_ATTRIBUTE_NAME);
    private static final QName TYPE$4 = new QName("", PackageRelationship.TYPE_ATTRIBUTE_NAME);
    private static final QName ID$6 = new QName("", PackageRelationship.ID_ATTRIBUTE_NAME);

    public CTRelationshipImpl(SchemaType schemaType) {
        super(schemaType, true);
    }

    protected CTRelationshipImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
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

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TARGET$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public STTargetMode.Enum getTargetMode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TARGETMODE$0);
            if (simpleValue == null) {
                return null;
            }
            return (STTargetMode.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public String getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public boolean isSetTargetMode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGETMODE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
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

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public void setTargetMode(STTargetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGETMODE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public void setType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public void unsetTargetMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGETMODE$0);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$6);
        }
        return xmlID;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public XmlAnyURI xgetTarget() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(TARGET$2);
        }
        return xmlAnyURI;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public STTargetMode xgetTargetMode() {
        STTargetMode sTTargetMode;
        synchronized (monitor()) {
            check_orphaned();
            sTTargetMode = (STTargetMode) get_store().find_attribute_user(TARGETMODE$0);
        }
        return sTTargetMode;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public XmlAnyURI xgetType() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(TYPE$4);
        }
        return xmlAnyURI;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
            if (xmlID2 == null) {
                xmlID2 = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlID2.set(xmlID);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public void xsetTarget(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$2;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public void xsetTargetMode(STTargetMode sTTargetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGETMODE$0;
            STTargetMode sTTargetMode2 = (STTargetMode) typeStore.find_attribute_user(qName);
            if (sTTargetMode2 == null) {
                sTTargetMode2 = (STTargetMode) get_store().add_attribute_user(qName);
            }
            sTTargetMode2.set(sTTargetMode);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship
    public void xsetType(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }
}
