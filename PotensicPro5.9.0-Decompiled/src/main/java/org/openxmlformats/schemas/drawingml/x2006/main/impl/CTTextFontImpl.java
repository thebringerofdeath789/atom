package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.STPanose;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextTypeface;

/* loaded from: classes5.dex */
public class CTTextFontImpl extends XmlComplexContentImpl implements CTTextFont {
    private static final QName TYPEFACE$0 = new QName("", "typeface");
    private static final QName PANOSE$2 = new QName("", "panose");
    private static final QName PITCHFAMILY$4 = new QName("", "pitchFamily");
    private static final QName CHARSET$6 = new QName("", "charset");

    public CTTextFontImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public byte getCharset() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARSET$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return (byte) 0;
            }
            return simpleValue.getByteValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public byte[] getPanose() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PANOSE$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public byte getPitchFamily() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PITCHFAMILY$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return (byte) 0;
            }
            return simpleValue.getByteValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public String getTypeface() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPEFACE$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public boolean isSetCharset() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHARSET$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public boolean isSetPanose() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PANOSE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public boolean isSetPitchFamily() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PITCHFAMILY$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public boolean isSetTypeface() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPEFACE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void setCharset(byte b) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARSET$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void setPanose(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PANOSE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void setPitchFamily(byte b) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PITCHFAMILY$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void setTypeface(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPEFACE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void unsetCharset() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHARSET$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void unsetPanose() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PANOSE$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void unsetPitchFamily() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PITCHFAMILY$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void unsetTypeface() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPEFACE$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public XmlByte xgetCharset() {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARSET$6;
            xmlByte = (XmlByte) typeStore.find_attribute_user(qName);
            if (xmlByte == null) {
                xmlByte = (XmlByte) get_default_attribute_value(qName);
            }
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public STPanose xgetPanose() {
        STPanose find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(PANOSE$2);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public XmlByte xgetPitchFamily() {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PITCHFAMILY$4;
            xmlByte = (XmlByte) typeStore.find_attribute_user(qName);
            if (xmlByte == null) {
                xmlByte = (XmlByte) get_default_attribute_value(qName);
            }
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public STTextTypeface xgetTypeface() {
        STTextTypeface sTTextTypeface;
        synchronized (monitor()) {
            check_orphaned();
            sTTextTypeface = (STTextTypeface) get_store().find_attribute_user(TYPEFACE$0);
        }
        return sTTextTypeface;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void xsetCharset(XmlByte xmlByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARSET$6;
            XmlByte xmlByte2 = (XmlByte) typeStore.find_attribute_user(qName);
            if (xmlByte2 == null) {
                xmlByte2 = (XmlByte) get_store().add_attribute_user(qName);
            }
            xmlByte2.set(xmlByte);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void xsetPanose(STPanose sTPanose) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PANOSE$2;
            STPanose find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STPanose) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTPanose);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void xsetPitchFamily(XmlByte xmlByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PITCHFAMILY$4;
            XmlByte xmlByte2 = (XmlByte) typeStore.find_attribute_user(qName);
            if (xmlByte2 == null) {
                xmlByte2 = (XmlByte) get_store().add_attribute_user(qName);
            }
            xmlByte2.set(xmlByte);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont
    public void xsetTypeface(STTextTypeface sTTextTypeface) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPEFACE$0;
            STTextTypeface sTTextTypeface2 = (STTextTypeface) typeStore.find_attribute_user(qName);
            if (sTTextTypeface2 == null) {
                sTTextTypeface2 = (STTextTypeface) get_store().add_attribute_user(qName);
            }
            sTTextTypeface2.set(sTTextTypeface);
        }
    }
}
