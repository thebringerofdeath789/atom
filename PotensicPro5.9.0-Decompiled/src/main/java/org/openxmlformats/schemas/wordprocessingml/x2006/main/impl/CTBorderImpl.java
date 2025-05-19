package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STEighthPointMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPointMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUcharHexNumber;

/* loaded from: classes6.dex */
public class CTBorderImpl extends XmlComplexContentImpl implements CTBorder {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    private static final QName COLOR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", TtmlNode.ATTR_TTS_COLOR);
    private static final QName THEMECOLOR$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeColor");
    private static final QName THEMETINT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeTint");
    private static final QName THEMESHADE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeShade");
    private static final QName SZ$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz");
    private static final QName SPACE$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "space");
    private static final QName SHADOW$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow");
    private static final QName FRAME$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "frame");

    public CTBorderImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public Object getColor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLOR$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getObjectValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STOnOff.Enum getFrame() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FRAME$16);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STOnOff.Enum getShadow() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SHADOW$14);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public BigInteger getSpace() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SPACE$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public BigInteger getSz() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SZ$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STThemeColor$Enum getThemeColor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(THEMECOLOR$4);
            if (simpleValue == null) {
                return null;
            }
            return (STThemeColor$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public byte[] getThemeShade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(THEMESHADE$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public byte[] getThemeTint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(THEMETINT$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STBorder.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return null;
            }
            return (STBorder.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetFrame() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FRAME$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetShadow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHADOW$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetSpace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPACE$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SZ$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetThemeColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMECOLOR$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetThemeShade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMESHADE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public boolean isSetThemeTint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMETINT$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setColor(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setFrame(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FRAME$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setShadow(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADOW$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setSpace(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACE$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setSz(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setThemeColor(STThemeColor$Enum sTThemeColor$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMECOLOR$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTThemeColor$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setThemeShade(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMESHADE$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setThemeTint(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMETINT$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void setVal(STBorder.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetFrame() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FRAME$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetShadow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHADOW$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetSpace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPACE$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SZ$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetThemeColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMECOLOR$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetThemeShade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMESHADE$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void unsetThemeTint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMETINT$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STHexColor xgetColor() {
        STHexColor sTHexColor;
        synchronized (monitor()) {
            check_orphaned();
            sTHexColor = (STHexColor) get_store().find_attribute_user(COLOR$2);
        }
        return sTHexColor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STOnOff xgetFrame() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(FRAME$16);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STOnOff xgetShadow() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(SHADOW$14);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STPointMeasure xgetSpace() {
        STPointMeasure sTPointMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTPointMeasure = (STPointMeasure) get_store().find_attribute_user(SPACE$12);
        }
        return sTPointMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STEighthPointMeasure xgetSz() {
        STEighthPointMeasure sTEighthPointMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTEighthPointMeasure = (STEighthPointMeasure) get_store().find_attribute_user(SZ$10);
        }
        return sTEighthPointMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STThemeColor xgetThemeColor() {
        STThemeColor find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(THEMECOLOR$4);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STUcharHexNumber xgetThemeShade() {
        STUcharHexNumber find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(THEMESHADE$8);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STUcharHexNumber xgetThemeTint() {
        STUcharHexNumber find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(THEMETINT$6);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public STBorder xgetVal() {
        STBorder sTBorder;
        synchronized (monitor()) {
            check_orphaned();
            sTBorder = (STBorder) get_store().find_attribute_user(VAL$0);
        }
        return sTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetColor(STHexColor sTHexColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$2;
            STHexColor sTHexColor2 = (STHexColor) typeStore.find_attribute_user(qName);
            if (sTHexColor2 == null) {
                sTHexColor2 = (STHexColor) get_store().add_attribute_user(qName);
            }
            sTHexColor2.set(sTHexColor);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetFrame(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FRAME$16;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetShadow(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADOW$14;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetSpace(STPointMeasure sTPointMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACE$12;
            STPointMeasure sTPointMeasure2 = (STPointMeasure) typeStore.find_attribute_user(qName);
            if (sTPointMeasure2 == null) {
                sTPointMeasure2 = (STPointMeasure) get_store().add_attribute_user(qName);
            }
            sTPointMeasure2.set(sTPointMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetSz(STEighthPointMeasure sTEighthPointMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$10;
            STEighthPointMeasure sTEighthPointMeasure2 = (STEighthPointMeasure) typeStore.find_attribute_user(qName);
            if (sTEighthPointMeasure2 == null) {
                sTEighthPointMeasure2 = (STEighthPointMeasure) get_store().add_attribute_user(qName);
            }
            sTEighthPointMeasure2.set(sTEighthPointMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetThemeColor(STThemeColor sTThemeColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMECOLOR$4;
            STThemeColor find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STThemeColor) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTThemeColor);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetThemeShade(STUcharHexNumber sTUcharHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMESHADE$8;
            STUcharHexNumber find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STUcharHexNumber) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTUcharHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetThemeTint(STUcharHexNumber sTUcharHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMETINT$6;
            STUcharHexNumber find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STUcharHexNumber) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTUcharHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder
    public void xsetVal(STBorder sTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STBorder sTBorder2 = (STBorder) typeStore.find_attribute_user(qName);
            if (sTBorder2 == null) {
                sTBorder2 = (STBorder) get_store().add_attribute_user(qName);
            }
            sTBorder2.set(sTBorder);
        }
    }
}
