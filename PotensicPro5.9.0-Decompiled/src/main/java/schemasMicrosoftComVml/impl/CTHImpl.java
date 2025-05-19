package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import schemasMicrosoftComVml.CTH;
import schemasMicrosoftComVml.STTrueFalse;
import schemasMicrosoftComVml.STTrueFalseBlank;
import schemasMicrosoftComVml.STTrueFalseBlank$Enum;

/* loaded from: classes6.dex */
public class CTHImpl extends XmlComplexContentImpl implements CTH {
    private static final QName POSITION$0 = new QName("", "position");
    private static final QName POLAR$2 = new QName("", "polar");
    private static final QName MAP$4 = new QName("", "map");
    private static final QName INVX$6 = new QName("", "invx");
    private static final QName INVY$8 = new QName("", "invy");
    private static final QName SWITCH$10 = new QName("", "switch");
    private static final QName XRANGE$12 = new QName("", "xrange");
    private static final QName YRANGE$14 = new QName("", "yrange");
    private static final QName RADIUSRANGE$16 = new QName("", "radiusrange");

    public CTHImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTH
    public STTrueFalse.Enum getInvx() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(INVX$6);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public STTrueFalse.Enum getInvy() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(INVY$8);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public String getMap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MAP$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public String getPolar() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(POLAR$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public String getPosition() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(POSITION$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public String getRadiusrange() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RADIUSRANGE$16);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public STTrueFalseBlank$Enum getSwitch() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SWITCH$10);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalseBlank$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public String getXrange() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(XRANGE$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public String getYrange() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(YRANGE$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetInvx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INVX$6) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetInvy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INVY$8) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetMap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAP$4) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetPolar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(POLAR$2) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetPosition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(POSITION$0) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetRadiusrange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RADIUSRANGE$16) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetSwitch() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SWITCH$10) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetXrange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(XRANGE$12) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public boolean isSetYrange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(YRANGE$14) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setInvx(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INVX$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setInvy(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INVY$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setMap(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAP$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setPolar(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POLAR$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setPosition(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setRadiusrange(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RADIUSRANGE$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setSwitch(STTrueFalseBlank$Enum sTTrueFalseBlank$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SWITCH$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalseBlank$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setXrange(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XRANGE$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void setYrange(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = YRANGE$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetInvx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INVX$6);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetInvy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INVY$8);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetMap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAP$4);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetPolar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(POLAR$2);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetPosition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(POSITION$0);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetRadiusrange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RADIUSRANGE$16);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetSwitch() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SWITCH$10);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetXrange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(XRANGE$12);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void unsetYrange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(YRANGE$14);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public STTrueFalse xgetInvx() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(INVX$6);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTH
    public STTrueFalse xgetInvy() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(INVY$8);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTH
    public XmlString xgetMap() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(MAP$4);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTH
    public XmlString xgetPolar() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(POLAR$2);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTH
    public XmlString xgetPosition() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(POSITION$0);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTH
    public XmlString xgetRadiusrange() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(RADIUSRANGE$16);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTH
    public STTrueFalseBlank xgetSwitch() {
        STTrueFalseBlank find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(SWITCH$10);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTH
    public XmlString xgetXrange() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(XRANGE$12);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTH
    public XmlString xgetYrange() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(YRANGE$14);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetInvx(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INVX$6;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetInvy(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INVY$8;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetMap(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAP$4;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetPolar(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POLAR$2;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetPosition(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$0;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetRadiusrange(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RADIUSRANGE$16;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetSwitch(STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SWITCH$10;
            STTrueFalseBlank find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalseBlank) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetXrange(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XRANGE$12;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTH
    public void xsetYrange(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = YRANGE$14;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
