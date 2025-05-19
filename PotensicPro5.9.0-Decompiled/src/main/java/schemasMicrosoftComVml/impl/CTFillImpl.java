package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigDecimal;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import schemasMicrosoftComOfficeOffice.STTrueFalse$Enum;
import schemasMicrosoftComVml.CTFill;
import schemasMicrosoftComVml.STColorType;
import schemasMicrosoftComVml.STFillMethod;
import schemasMicrosoftComVml.STFillMethod$Enum;
import schemasMicrosoftComVml.STFillType;
import schemasMicrosoftComVml.STFillType$Enum;
import schemasMicrosoftComVml.STImageAspect;
import schemasMicrosoftComVml.STImageAspect$Enum;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public class CTFillImpl extends XmlComplexContentImpl implements CTFill {
    private static final QName FILL$0 = new QName("urn:schemas-microsoft-com:office:office", "fill");
    private static final QName ID$2 = new QName("", TtmlNode.ATTR_ID);
    private static final QName TYPE$4 = new QName("", "type");
    private static final QName ON$6 = new QName("", "on");
    private static final QName COLOR$8 = new QName("", TtmlNode.ATTR_TTS_COLOR);
    private static final QName OPACITY$10 = new QName("", "opacity");
    private static final QName COLOR2$12 = new QName("", "color2");
    private static final QName SRC$14 = new QName("", "src");
    private static final QName HREF$16 = new QName("urn:schemas-microsoft-com:office:office", "href");
    private static final QName ALTHREF$18 = new QName("urn:schemas-microsoft-com:office:office", "althref");
    private static final QName SIZE$20 = new QName("", "size");
    private static final QName ORIGIN$22 = new QName("", "origin");
    private static final QName POSITION$24 = new QName("", "position");
    private static final QName ASPECT$26 = new QName("", "aspect");
    private static final QName COLORS$28 = new QName("", "colors");
    private static final QName ANGLE$30 = new QName("", "angle");
    private static final QName ALIGNSHAPE$32 = new QName("", "alignshape");
    private static final QName FOCUS$34 = new QName("", "focus");
    private static final QName FOCUSSIZE$36 = new QName("", "focussize");
    private static final QName FOCUSPOSITION$38 = new QName("", "focusposition");
    private static final QName METHOD$40 = new QName("", "method");
    private static final QName DETECTMOUSECLICK$42 = new QName("urn:schemas-microsoft-com:office:office", "detectmouseclick");
    private static final QName TITLE$44 = new QName("urn:schemas-microsoft-com:office:office", "title");
    private static final QName OPACITY2$46 = new QName("urn:schemas-microsoft-com:office:office", "opacity2");
    private static final QName RECOLOR$48 = new QName("", "recolor");
    private static final QName ROTATE$50 = new QName("", "rotate");
    private static final QName ID2$52 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", TtmlNode.ATTR_ID);
    private static final QName RELID$54 = new QName("urn:schemas-microsoft-com:office:office", "relid");

    public CTFillImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTFill
    public schemasMicrosoftComOfficeOffice.CTFill addNewFill() {
        schemasMicrosoftComOfficeOffice.CTFill add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FILL$0);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse.Enum getAlignshape() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALIGNSHAPE$32);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getAlthref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALTHREF$18);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public BigDecimal getAngle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ANGLE$30);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigDecimalValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STImageAspect$Enum getAspect() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ASPECT$26);
            if (simpleValue == null) {
                return null;
            }
            return (STImageAspect$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getColor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLOR$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getColor2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLOR2$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getColors() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLORS$28);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse$Enum getDetectmouseclick() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DETECTMOUSECLICK$42);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public schemasMicrosoftComOfficeOffice.CTFill getFill() {
        synchronized (monitor()) {
            check_orphaned();
            schemasMicrosoftComOfficeOffice.CTFill find_element_user = get_store().find_element_user(FILL$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getFocus() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FOCUS$34);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getFocusposition() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FOCUSPOSITION$38);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getFocussize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FOCUSSIZE$36);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HREF$16);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getId2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID2$52);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STFillMethod$Enum getMethod() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(METHOD$40);
            if (simpleValue == null) {
                return null;
            }
            return (STFillMethod$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse.Enum getOn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ON$6);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OPACITY$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getOpacity2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OPACITY2$46);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ORIGIN$22);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getPosition() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(POSITION$24);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse.Enum getRecolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RECOLOR$48);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getRelid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RELID$54);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse.Enum getRotate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ROTATE$50);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SIZE$20);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getSrc() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SRC$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TITLE$44);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STFillType$Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$4);
            if (simpleValue == null) {
                return null;
            }
            return (STFillType$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetAlignshape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALIGNSHAPE$32) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetAlthref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALTHREF$18) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetAngle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ANGLE$30) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetAspect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ASPECT$26) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR$8) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetColor2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR2$12) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLORS$28) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetDetectmouseclick() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DETECTMOUSECLICK$42) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILL$0) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetFocus() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOCUS$34) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetFocusposition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOCUSPOSITION$38) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetFocussize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOCUSSIZE$36) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$16) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetId2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID2$52) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetMethod() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(METHOD$40) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetOn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ON$6) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$10) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetOpacity2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY2$46) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIGIN$22) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetPosition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(POSITION$24) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetRecolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RECOLOR$48) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetRelid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RELID$54) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetRotate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROTATE$50) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SIZE$20) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetSrc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SRC$14) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$44) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$4) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setAlignshape(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNSHAPE$32;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setAlthref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALTHREF$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setAngle(BigDecimal bigDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANGLE$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigDecimalValue(bigDecimal);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setAspect(STImageAspect$Enum sTImageAspect$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASPECT$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTImageAspect$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setColor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setColor2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR2$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setColors(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORS$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setDetectmouseclick(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DETECTMOUSECLICK$42;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setFill(schemasMicrosoftComOfficeOffice.CTFill cTFill) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILL$0;
            schemasMicrosoftComOfficeOffice.CTFill find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (schemasMicrosoftComOfficeOffice.CTFill) get_store().add_element_user(qName);
            }
            find_element_user.set(cTFill);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setFocus(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUS$34;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setFocusposition(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUSPOSITION$38;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setFocussize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUSSIZE$36;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setId2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID2$52;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setMethod(STFillMethod$Enum sTFillMethod$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = METHOD$40;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTFillMethod$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setOn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setOpacity2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY2$46;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setOrigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIGIN$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setPosition(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setRecolor(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RECOLOR$48;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setRelid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELID$54;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setRotate(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTATE$50;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setSize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setSrc(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRC$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$44;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void setType(STFillType$Enum sTFillType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTFillType$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetAlignshape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALIGNSHAPE$32);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetAlthref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALTHREF$18);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetAngle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ANGLE$30);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetAspect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ASPECT$26);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR$8);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetColor2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR2$12);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLORS$28);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetDetectmouseclick() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DETECTMOUSECLICK$42);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$0, 0);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetFocus() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOCUS$34);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetFocusposition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOCUSPOSITION$38);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetFocussize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOCUSSIZE$36);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$16);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetId2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID2$52);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetMethod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(METHOD$40);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetOn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ON$6);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$10);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetOpacity2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY2$46);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIGIN$22);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetPosition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(POSITION$24);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetRecolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RECOLOR$48);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetRelid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RELID$54);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetRotate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROTATE$50);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SIZE$20);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetSrc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SRC$14);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$44);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$4);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse xgetAlignshape() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(ALIGNSHAPE$32);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetAlthref() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ALTHREF$18);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlDecimal xgetAngle() {
        XmlDecimal xmlDecimal;
        synchronized (monitor()) {
            check_orphaned();
            xmlDecimal = (XmlDecimal) get_store().find_attribute_user(ANGLE$30);
        }
        return xmlDecimal;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STImageAspect xgetAspect() {
        STImageAspect find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ASPECT$26);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STColorType xgetColor() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(COLOR$8);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STColorType xgetColor2() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(COLOR2$12);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetColors() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(COLORS$28);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetDetectmouseclick() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(DETECTMOUSECLICK$42);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetFocus() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(FOCUS$34);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetFocusposition() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(FOCUSPOSITION$38);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetFocussize() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(FOCUSSIZE$36);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetHref() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(HREF$16);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$2);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STRelationshipId xgetId2() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID2$52);
        }
        return sTRelationshipId;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STFillMethod xgetMethod() {
        STFillMethod find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(METHOD$40);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse xgetOn() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(ON$6);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetOpacity() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(OPACITY$10);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetOpacity2() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(OPACITY2$46);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetOrigin() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ORIGIN$22);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetPosition() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(POSITION$24);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse xgetRecolor() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(RECOLOR$48);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public schemasMicrosoftComOfficeOffice.STRelationshipId xgetRelid() {
        schemasMicrosoftComOfficeOffice.STRelationshipId find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(RELID$54);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STTrueFalse xgetRotate() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(ROTATE$50);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetSize() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(SIZE$20);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetSrc() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(SRC$14);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public XmlString xgetTitle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TITLE$44);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public STFillType xgetType() {
        STFillType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(TYPE$4);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetAlignshape(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNSHAPE$32;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetAlthref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALTHREF$18;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetAngle(XmlDecimal xmlDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANGLE$30;
            XmlDecimal xmlDecimal2 = (XmlDecimal) typeStore.find_attribute_user(qName);
            if (xmlDecimal2 == null) {
                xmlDecimal2 = (XmlDecimal) get_store().add_attribute_user(qName);
            }
            xmlDecimal2.set(xmlDecimal);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetAspect(STImageAspect sTImageAspect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASPECT$26;
            STImageAspect find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STImageAspect) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTImageAspect);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetColor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$8;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetColor2(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR2$12;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetColors(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORS$28;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetDetectmouseclick(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DETECTMOUSECLICK$42;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetFocus(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUS$34;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetFocusposition(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUSPOSITION$38;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetFocussize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUSSIZE$36;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$16;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetId2(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID2$52;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetMethod(STFillMethod sTFillMethod) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = METHOD$40;
            STFillMethod find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STFillMethod) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTFillMethod);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetOn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$6;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$10;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetOpacity2(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY2$46;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetOrigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIGIN$22;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetPosition(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$24;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetRecolor(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RECOLOR$48;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetRelid(schemasMicrosoftComOfficeOffice.STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELID$54;
            schemasMicrosoftComOfficeOffice.STRelationshipId find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STRelationshipId) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTRelationshipId);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetRotate(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTATE$50;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetSize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$20;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetSrc(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRC$14;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$44;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTFill
    public void xsetType(STFillType sTFillType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            STFillType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STFillType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTFillType);
        }
    }
}
