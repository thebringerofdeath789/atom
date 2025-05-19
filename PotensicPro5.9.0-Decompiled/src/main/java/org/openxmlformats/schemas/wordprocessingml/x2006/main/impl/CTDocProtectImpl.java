package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgClass;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STCryptProv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

/* loaded from: classes6.dex */
public class CTDocProtectImpl extends XmlComplexContentImpl implements CTDocProtect {
    private static final QName EDIT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "edit");
    private static final QName FORMATTING$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "formatting");
    private static final QName ENFORCEMENT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "enforcement");
    private static final QName CRYPTPROVIDERTYPE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderType");
    private static final QName CRYPTALGORITHMCLASS$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmClass");
    private static final QName CRYPTALGORITHMTYPE$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmType");
    private static final QName CRYPTALGORITHMSID$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmSid");
    private static final QName CRYPTSPINCOUNT$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptSpinCount");
    private static final QName CRYPTPROVIDER$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProvider");
    private static final QName ALGIDEXT$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "algIdExt");
    private static final QName ALGIDEXTSOURCE$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "algIdExtSource");
    private static final QName CRYPTPROVIDERTYPEEXT$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderTypeExt");
    private static final QName CRYPTPROVIDERTYPEEXTSOURCE$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderTypeExtSource");
    private static final QName HASH$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hash");
    private static final QName SALT$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "salt");

    public CTDocProtectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public byte[] getAlgIdExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALGIDEXT$18);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public String getAlgIdExtSource() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALGIDEXTSOURCE$20);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STAlgClass.Enum getCryptAlgorithmClass() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CRYPTALGORITHMCLASS$8);
            if (simpleValue == null) {
                return null;
            }
            return (STAlgClass.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public BigInteger getCryptAlgorithmSid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CRYPTALGORITHMSID$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STAlgType.Enum getCryptAlgorithmType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CRYPTALGORITHMTYPE$10);
            if (simpleValue == null) {
                return null;
            }
            return (STAlgType.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public String getCryptProvider() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CRYPTPROVIDER$16);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STCryptProv.Enum getCryptProviderType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CRYPTPROVIDERTYPE$6);
            if (simpleValue == null) {
                return null;
            }
            return (STCryptProv.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public byte[] getCryptProviderTypeExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public String getCryptProviderTypeExtSource() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public BigInteger getCryptSpinCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CRYPTSPINCOUNT$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STDocProtect.Enum getEdit() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EDIT$0);
            if (simpleValue == null) {
                return null;
            }
            return (STDocProtect.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STOnOff.Enum getEnforcement() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENFORCEMENT$4);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STOnOff.Enum getFormatting() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FORMATTING$2);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public byte[] getHash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HASH$26);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public byte[] getSalt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SALT$28);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetAlgIdExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALGIDEXT$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetAlgIdExtSource() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALGIDEXTSOURCE$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptAlgorithmClass() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTALGORITHMCLASS$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptAlgorithmSid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTALGORITHMSID$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptAlgorithmType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTALGORITHMTYPE$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptProvider() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTPROVIDER$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptProviderType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTPROVIDERTYPE$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptProviderTypeExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptProviderTypeExtSource() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptSpinCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTSPINCOUNT$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetEdit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EDIT$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetEnforcement() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENFORCEMENT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetFormatting() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORMATTING$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetHash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HASH$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetSalt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SALT$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setAlgIdExt(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGIDEXT$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setAlgIdExtSource(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGIDEXTSOURCE$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptAlgorithmClass(STAlgClass.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMCLASS$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptAlgorithmSid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMSID$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptAlgorithmType(STAlgType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMTYPE$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptProvider(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDER$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptProviderType(STCryptProv.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPE$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptProviderTypeExt(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPEEXT$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptProviderTypeExtSource(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPEEXTSOURCE$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptSpinCount(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTSPINCOUNT$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setEdit(STDocProtect.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDIT$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setEnforcement(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENFORCEMENT$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setFormatting(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATTING$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setHash(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASH$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setSalt(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALT$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetAlgIdExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALGIDEXT$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetAlgIdExtSource() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALGIDEXTSOURCE$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptAlgorithmClass() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTALGORITHMCLASS$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptAlgorithmSid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTALGORITHMSID$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptAlgorithmType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTALGORITHMTYPE$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptProvider() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTPROVIDER$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptProviderType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTPROVIDERTYPE$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptProviderTypeExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTPROVIDERTYPEEXT$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptProviderTypeExtSource() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTPROVIDERTYPEEXTSOURCE$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptSpinCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTSPINCOUNT$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetEdit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EDIT$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetEnforcement() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENFORCEMENT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetFormatting() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORMATTING$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetHash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HASH$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetSalt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SALT$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STLongHexNumber xgetAlgIdExt() {
        STLongHexNumber sTLongHexNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumber = (STLongHexNumber) get_store().find_attribute_user(ALGIDEXT$18);
        }
        return sTLongHexNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STString xgetAlgIdExtSource() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(ALGIDEXTSOURCE$20);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STAlgClass xgetCryptAlgorithmClass() {
        STAlgClass sTAlgClass;
        synchronized (monitor()) {
            check_orphaned();
            sTAlgClass = (STAlgClass) get_store().find_attribute_user(CRYPTALGORITHMCLASS$8);
        }
        return sTAlgClass;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STDecimalNumber xgetCryptAlgorithmSid() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(CRYPTALGORITHMSID$12);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STAlgType xgetCryptAlgorithmType() {
        STAlgType sTAlgType;
        synchronized (monitor()) {
            check_orphaned();
            sTAlgType = (STAlgType) get_store().find_attribute_user(CRYPTALGORITHMTYPE$10);
        }
        return sTAlgType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STString xgetCryptProvider() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(CRYPTPROVIDER$16);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STCryptProv xgetCryptProviderType() {
        STCryptProv sTCryptProv;
        synchronized (monitor()) {
            check_orphaned();
            sTCryptProv = (STCryptProv) get_store().find_attribute_user(CRYPTPROVIDERTYPE$6);
        }
        return sTCryptProv;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STLongHexNumber xgetCryptProviderTypeExt() {
        STLongHexNumber sTLongHexNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumber = (STLongHexNumber) get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22);
        }
        return sTLongHexNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STString xgetCryptProviderTypeExtSource() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STDecimalNumber xgetCryptSpinCount() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(CRYPTSPINCOUNT$14);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STDocProtect xgetEdit() {
        STDocProtect sTDocProtect;
        synchronized (monitor()) {
            check_orphaned();
            sTDocProtect = (STDocProtect) get_store().find_attribute_user(EDIT$0);
        }
        return sTDocProtect;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STOnOff xgetEnforcement() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(ENFORCEMENT$4);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STOnOff xgetFormatting() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(FORMATTING$2);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public XmlBase64Binary xgetHash() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(HASH$26);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public XmlBase64Binary xgetSalt() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(SALT$28);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetAlgIdExt(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGIDEXT$18;
            STLongHexNumber sTLongHexNumber2 = (STLongHexNumber) typeStore.find_attribute_user(qName);
            if (sTLongHexNumber2 == null) {
                sTLongHexNumber2 = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumber2.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetAlgIdExtSource(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGIDEXTSOURCE$20;
            STString sTString2 = (STString) typeStore.find_attribute_user(qName);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qName);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptAlgorithmClass(STAlgClass sTAlgClass) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMCLASS$8;
            STAlgClass sTAlgClass2 = (STAlgClass) typeStore.find_attribute_user(qName);
            if (sTAlgClass2 == null) {
                sTAlgClass2 = (STAlgClass) get_store().add_attribute_user(qName);
            }
            sTAlgClass2.set(sTAlgClass);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptAlgorithmSid(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMSID$12;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptAlgorithmType(STAlgType sTAlgType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMTYPE$10;
            STAlgType sTAlgType2 = (STAlgType) typeStore.find_attribute_user(qName);
            if (sTAlgType2 == null) {
                sTAlgType2 = (STAlgType) get_store().add_attribute_user(qName);
            }
            sTAlgType2.set(sTAlgType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptProvider(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDER$16;
            STString sTString2 = (STString) typeStore.find_attribute_user(qName);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qName);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptProviderType(STCryptProv sTCryptProv) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPE$6;
            STCryptProv sTCryptProv2 = (STCryptProv) typeStore.find_attribute_user(qName);
            if (sTCryptProv2 == null) {
                sTCryptProv2 = (STCryptProv) get_store().add_attribute_user(qName);
            }
            sTCryptProv2.set(sTCryptProv);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptProviderTypeExt(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPEEXT$22;
            STLongHexNumber sTLongHexNumber2 = (STLongHexNumber) typeStore.find_attribute_user(qName);
            if (sTLongHexNumber2 == null) {
                sTLongHexNumber2 = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumber2.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptProviderTypeExtSource(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPEEXTSOURCE$24;
            STString sTString2 = (STString) typeStore.find_attribute_user(qName);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qName);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptSpinCount(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTSPINCOUNT$14;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetEdit(STDocProtect sTDocProtect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDIT$0;
            STDocProtect sTDocProtect2 = (STDocProtect) typeStore.find_attribute_user(qName);
            if (sTDocProtect2 == null) {
                sTDocProtect2 = (STDocProtect) get_store().add_attribute_user(qName);
            }
            sTDocProtect2.set(sTDocProtect);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetEnforcement(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENFORCEMENT$4;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetFormatting(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATTING$2;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetHash(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASH$26;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetSalt(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALT$28;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }
}
