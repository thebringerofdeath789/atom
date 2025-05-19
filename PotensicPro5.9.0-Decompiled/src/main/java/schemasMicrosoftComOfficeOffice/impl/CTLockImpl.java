package schemasMicrosoftComOfficeOffice.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import schemasMicrosoftComOfficeOffice.CTLock;
import schemasMicrosoftComOfficeOffice.STTrueFalse;
import schemasMicrosoftComOfficeOffice.STTrueFalse$Enum;
import schemasMicrosoftComVml.STExt;

/* loaded from: classes6.dex */
public class CTLockImpl extends XmlComplexContentImpl implements CTLock {
    private static final QName EXT$0 = new QName("urn:schemas-microsoft-com:vml", "ext");
    private static final QName POSITION$2 = new QName("", "position");
    private static final QName SELECTION$4 = new QName("", "selection");
    private static final QName GROUPING$6 = new QName("", "grouping");
    private static final QName UNGROUPING$8 = new QName("", "ungrouping");
    private static final QName ROTATION$10 = new QName("", CellUtil.ROTATION);
    private static final QName CROPPING$12 = new QName("", "cropping");
    private static final QName VERTICIES$14 = new QName("", "verticies");
    private static final QName ADJUSTHANDLES$16 = new QName("", "adjusthandles");
    private static final QName TEXT$18 = new QName("", "text");
    private static final QName ASPECTRATIO$20 = new QName("", "aspectratio");
    private static final QName SHAPETYPE$22 = new QName("", "shapetype");

    public CTLockImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getAdjusthandles() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ADJUSTHANDLES$16);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getAspectratio() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ASPECTRATIO$20);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getCropping() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CROPPING$12);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STExt.Enum getExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EXT$0);
            if (simpleValue == null) {
                return null;
            }
            return (STExt.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getGrouping() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(GROUPING$6);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getPosition() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(POSITION$2);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getRotation() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ROTATION$10);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getSelection() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SELECTION$4);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getShapetype() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SHAPETYPE$22);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getText() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TEXT$18);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getUngrouping() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(UNGROUPING$8);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse$Enum getVerticies() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VERTICIES$14);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetAdjusthandles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ADJUSTHANDLES$16) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetAspectratio() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ASPECTRATIO$20) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetCropping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CROPPING$12) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EXT$0) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetGrouping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(GROUPING$6) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetPosition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(POSITION$2) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetRotation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROTATION$10) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetSelection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SELECTION$4) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetShapetype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHAPETYPE$22) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TEXT$18) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetUngrouping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(UNGROUPING$8) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public boolean isSetVerticies() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VERTICIES$14) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setAdjusthandles(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJUSTHANDLES$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setAspectratio(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASPECTRATIO$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setCropping(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CROPPING$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setExt(STExt.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setGrouping(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GROUPING$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setPosition(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setRotation(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTATION$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setSelection(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SELECTION$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setShapetype(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHAPETYPE$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setText(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setUngrouping(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNGROUPING$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void setVerticies(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICIES$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetAdjusthandles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ADJUSTHANDLES$16);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetAspectratio() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ASPECTRATIO$20);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetCropping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CROPPING$12);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EXT$0);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetGrouping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(GROUPING$6);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetPosition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(POSITION$2);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetRotation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROTATION$10);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetSelection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SELECTION$4);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetShapetype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHAPETYPE$22);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TEXT$18);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetUngrouping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(UNGROUPING$8);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void unsetVerticies() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VERTICIES$14);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetAdjusthandles() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ADJUSTHANDLES$16);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetAspectratio() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ASPECTRATIO$20);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetCropping() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(CROPPING$12);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STExt xgetExt() {
        STExt sTExt;
        synchronized (monitor()) {
            check_orphaned();
            sTExt = (STExt) get_store().find_attribute_user(EXT$0);
        }
        return sTExt;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetGrouping() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(GROUPING$6);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetPosition() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(POSITION$2);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetRotation() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ROTATION$10);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetSelection() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(SELECTION$4);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetShapetype() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(SHAPETYPE$22);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetText() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(TEXT$18);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetUngrouping() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(UNGROUPING$8);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public STTrueFalse xgetVerticies() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(VERTICIES$14);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetAdjusthandles(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJUSTHANDLES$16;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetAspectratio(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASPECTRATIO$20;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetCropping(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CROPPING$12;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetExt(STExt sTExt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$0;
            STExt sTExt2 = (STExt) typeStore.find_attribute_user(qName);
            if (sTExt2 == null) {
                sTExt2 = (STExt) get_store().add_attribute_user(qName);
            }
            sTExt2.set(sTExt);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetGrouping(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GROUPING$6;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetPosition(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$2;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetRotation(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTATION$10;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetSelection(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SELECTION$4;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetShapetype(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHAPETYPE$22;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetText(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$18;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetUngrouping(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNGROUPING$8;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTLock
    public void xsetVerticies(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICIES$14;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }
}
