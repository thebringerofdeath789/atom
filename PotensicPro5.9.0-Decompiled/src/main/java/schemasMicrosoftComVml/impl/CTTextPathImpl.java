package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import schemasMicrosoftComVml.CTTextPath;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public class CTTextPathImpl extends XmlComplexContentImpl implements CTTextPath {
    private static final QName ID$0 = new QName("", TtmlNode.ATTR_ID);
    private static final QName STYLE$2 = new QName("", TtmlNode.TAG_STYLE);
    private static final QName ON$4 = new QName("", "on");
    private static final QName FITSHAPE$6 = new QName("", "fitshape");
    private static final QName FITPATH$8 = new QName("", "fitpath");
    private static final QName TRIM$10 = new QName("", "trim");
    private static final QName XSCALE$12 = new QName("", "xscale");
    private static final QName STRING$14 = new QName("", "string");

    public CTTextPathImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse.Enum getFitpath() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FITPATH$8);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse.Enum getFitshape() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FITSHAPE$6);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse.Enum getOn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ON$4);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public String getString() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STRING$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLE$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse.Enum getTrim() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TRIM$10);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse.Enum getXscale() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(XSCALE$12);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public boolean isSetFitpath() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FITPATH$8) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public boolean isSetFitshape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FITSHAPE$6) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public boolean isSetOn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ON$4) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public boolean isSetString() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STRING$14) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$2) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public boolean isSetTrim() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TRIM$10) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public boolean isSetXscale() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(XSCALE$12) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void setFitpath(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITPATH$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void setFitshape(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITSHAPE$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void setOn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void setString(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRING$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void setTrim(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRIM$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void setXscale(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XSCALE$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void unsetFitpath() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FITPATH$8);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void unsetFitshape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FITSHAPE$6);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void unsetOn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ON$4);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void unsetString() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STRING$14);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$2);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void unsetTrim() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TRIM$10);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void unsetXscale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(XSCALE$12);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse xgetFitpath() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(FITPATH$8);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse xgetFitshape() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(FITSHAPE$6);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$0);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse xgetOn() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(ON$4);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public XmlString xgetString() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STRING$14);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public XmlString xgetStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STYLE$2);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse xgetTrim() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(TRIM$10);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public STTrueFalse xgetXscale() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(XSCALE$12);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void xsetFitpath(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITPATH$8;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void xsetFitshape(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITSHAPE$6;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void xsetOn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$4;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void xsetString(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRING$14;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$2;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void xsetTrim(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRIM$10;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextPath
    public void xsetXscale(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XSCALE$12;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }
}
