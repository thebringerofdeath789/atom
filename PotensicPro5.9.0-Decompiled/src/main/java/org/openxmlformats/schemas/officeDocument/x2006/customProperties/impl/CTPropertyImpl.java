package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

import aavax.xml.namespace.QName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTArray;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTCf;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTEmpty;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTNull;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVstream;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STClsid;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes.dex */
public class CTPropertyImpl extends XmlComplexContentImpl implements CTProperty {
    private static final QName VECTOR$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vector");
    private static final QName ARRAY$2 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "array");
    private static final QName BLOB$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "blob");
    private static final QName OBLOB$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "oblob");
    private static final QName EMPTY$8 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "empty");
    private static final QName NULL$10 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "null");
    private static final QName I1$12 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i1");
    private static final QName I2$14 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i2");
    private static final QName I4$16 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i4");
    private static final QName I8$18 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i8");
    private static final QName INT$20 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", XmlErrorCodes.INT);
    private static final QName UI1$22 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui1");
    private static final QName UI2$24 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui2");
    private static final QName UI4$26 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui4");
    private static final QName UI8$28 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui8");
    private static final QName UINT$30 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "uint");
    private static final QName R4$32 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r4");
    private static final QName R8$34 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r8");
    private static final QName DECIMAL$36 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", XmlErrorCodes.DECIMAL);
    private static final QName LPSTR$38 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpstr");
    private static final QName LPWSTR$40 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpwstr");
    private static final QName BSTR$42 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bstr");
    private static final QName DATE$44 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "date");
    private static final QName FILETIME$46 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "filetime");
    private static final QName BOOL$48 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bool");
    private static final QName CY$50 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cy");
    private static final QName ERROR$52 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
    private static final QName STREAM$54 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "stream");
    private static final QName OSTREAM$56 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ostream");
    private static final QName STORAGE$58 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "storage");
    private static final QName OSTORAGE$60 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ostorage");
    private static final QName VSTREAM$62 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vstream");
    private static final QName CLSID$64 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "clsid");
    private static final QName CF$66 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cf");
    private static final QName FMTID$68 = new QName("", "fmtid");
    private static final QName PID$70 = new QName("", "pid");
    private static final QName NAME$72 = new QName("", "name");
    private static final QName LINKTARGET$74 = new QName("", "linkTarget");

    public CTPropertyImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTArray addNewArray() {
        CTArray add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ARRAY$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTCf addNewCf() {
        CTCf add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CF$66);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTEmpty addNewEmpty() {
        CTEmpty add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EMPTY$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTNull addNewNull() {
        CTNull add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NULL$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTVector addNewVector() {
        CTVector cTVector;
        synchronized (monitor()) {
            check_orphaned();
            cTVector = (CTVector) get_store().add_element_user(VECTOR$0);
        }
        return cTVector;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTVstream addNewVstream() {
        CTVstream add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(VSTREAM$62);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTArray getArray() {
        synchronized (monitor()) {
            check_orphaned();
            CTArray find_element_user = get_store().find_element_user(ARRAY$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getBlob() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BLOB$4, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean getBool() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BOOL$48, 0);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getBstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BSTR$42, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTCf getCf() {
        synchronized (monitor()) {
            check_orphaned();
            CTCf find_element_user = get_store().find_element_user(CF$66, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getClsid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CLSID$64, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getCy() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CY$50, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public Calendar getDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DATE$44, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public BigDecimal getDecimal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DECIMAL$36, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigDecimalValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTEmpty getEmpty() {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty find_element_user = get_store().find_element_user(EMPTY$8, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getError() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ERROR$52, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public Calendar getFiletime() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FILETIME$46, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getFmtid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FMTID$68);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte getI1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I1$12, 0);
            if (simpleValue == null) {
                return (byte) 0;
            }
            return simpleValue.getByteValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public short getI2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I2$14, 0);
            if (simpleValue == null) {
                return (short) 0;
            }
            return simpleValue.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public int getI4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I4$16, 0);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public long getI8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I8$18, 0);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public int getInt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(INT$20, 0);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getLinkTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LINKTARGET$74);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getLpstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LPSTR$38, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getLpwstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LPWSTR$40, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$72);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTNull getNull() {
        synchronized (monitor()) {
            check_orphaned();
            CTNull find_element_user = get_store().find_element_user(NULL$10, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getOblob() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(OBLOB$6, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getOstorage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(OSTORAGE$60, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getOstream() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(OSTREAM$56, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public int getPid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PID$70);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public float getR4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(R4$32, 0);
            if (simpleValue == null) {
                return 0.0f;
            }
            return simpleValue.getFloatValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public double getR8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(R8$34, 0);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getStorage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(STORAGE$58, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getStream() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(STREAM$54, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public short getUi1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI1$22, 0);
            if (simpleValue == null) {
                return (short) 0;
            }
            return simpleValue.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public int getUi2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI2$24, 0);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public long getUi4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI4$26, 0);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public BigInteger getUi8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI8$28, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public long getUint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UINT$30, 0);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTVector getVector() {
        synchronized (monitor()) {
            check_orphaned();
            CTVector cTVector = (CTVector) get_store().find_element_user(VECTOR$0, 0);
            if (cTVector == null) {
                return null;
            }
            return cTVector;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTVstream getVstream() {
        synchronized (monitor()) {
            check_orphaned();
            CTVstream find_element_user = get_store().find_element_user(VSTREAM$62, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetArray() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ARRAY$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetBlob() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLOB$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetBool() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOOL$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetBstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BSTR$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetCf() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CF$66) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetClsid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CLSID$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetCy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CY$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DATE$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetDecimal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DECIMAL$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetEmpty() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMPTY$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetError() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ERROR$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetFiletime() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILETIME$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetI1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I1$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetI2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I2$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetI4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I4$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetI8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I8$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetInt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INT$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetLinkTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LINKTARGET$74) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetLpstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LPSTR$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetLpwstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LPWSTR$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$72) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetNull() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NULL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetOblob() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OBLOB$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetOstorage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OSTORAGE$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetOstream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OSTREAM$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetR4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(R4$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetR8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(R8$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetStorage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STORAGE$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetStream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STREAM$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUi1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI1$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUi2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI2$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUi4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI4$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUi8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI8$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UINT$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetVector() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VECTOR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetVstream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VSTREAM$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setArray(CTArray cTArray) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ARRAY$2;
            CTArray find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTArray) get_store().add_element_user(qName);
            }
            find_element_user.set(cTArray);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setBlob(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setBool(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOL$48;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setBstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BSTR$42;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setCf(CTCf cTCf) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CF$66;
            CTCf find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTCf) get_store().add_element_user(qName);
            }
            find_element_user.set(cTCf);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setClsid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLSID$64;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setCy(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$50;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATE$44;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setDecimal(BigDecimal bigDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DECIMAL$36;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setBigDecimalValue(bigDecimal);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setEmpty(CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMPTY$8;
            CTEmpty find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTEmpty) get_store().add_element_user(qName);
            }
            find_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setError(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERROR$52;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setFiletime(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILETIME$46;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setFmtid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FMTID$68;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setI1(byte b) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I1$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setI2(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I2$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setI4(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I4$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setI8(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I8$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setInt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INT$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setLinkTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINKTARGET$74;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setLpstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPSTR$38;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setLpwstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPWSTR$40;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$72;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setNull(CTNull cTNull) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NULL$10;
            CTNull find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTNull) get_store().add_element_user(qName);
            }
            find_element_user.set(cTNull);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setOblob(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBLOB$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setOstorage(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTORAGE$60;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setOstream(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTREAM$56;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setPid(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PID$70;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setR4(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R4$32;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setFloatValue(f);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setR8(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R8$34;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setStorage(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STORAGE$58;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setStream(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STREAM$54;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUi1(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI1$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUi2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI2$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUi4(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI4$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUi8(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI8$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUint(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UINT$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setVector(CTVector cTVector) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VECTOR$0;
            CTVector cTVector2 = (CTVector) typeStore.find_element_user(qName, 0);
            if (cTVector2 == null) {
                cTVector2 = (CTVector) get_store().add_element_user(qName);
            }
            cTVector2.set(cTVector);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setVstream(CTVstream cTVstream) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VSTREAM$62;
            CTVstream find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTVstream) get_store().add_element_user(qName);
            }
            find_element_user.set(cTVstream);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetArray() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARRAY$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetBlob() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLOB$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetBool() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOL$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetBstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BSTR$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetCf() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CF$66, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetClsid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLSID$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetCy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CY$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATE$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetDecimal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DECIMAL$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetEmpty() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMPTY$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetError() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ERROR$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetFiletime() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILETIME$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetI1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I1$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetI2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I2$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetI4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I4$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetI8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I8$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetInt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INT$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetLinkTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LINKTARGET$74);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetLpstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LPSTR$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetLpwstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LPWSTR$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$72);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetNull() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NULL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetOblob() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OBLOB$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetOstorage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OSTORAGE$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetOstream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OSTREAM$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetR4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R4$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetR8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R8$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetStorage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STORAGE$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetStream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STREAM$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUi1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI1$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUi2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI2$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUi4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI4$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUi8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI8$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UINT$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetVector() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VECTOR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetVstream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VSTREAM$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetBlob() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(BLOB$4, 0);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBoolean xgetBool() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_element_user(BOOL$48, 0);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetBstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(BSTR$42, 0);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public STClsid xgetClsid() {
        STClsid sTClsid;
        synchronized (monitor()) {
            check_orphaned();
            sTClsid = (STClsid) get_store().find_element_user(CLSID$64, 0);
        }
        return sTClsid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public STCy xgetCy() {
        STCy find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CY$50, 0);
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlDateTime xgetDate() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_element_user(DATE$44, 0);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlDecimal xgetDecimal() {
        XmlDecimal xmlDecimal;
        synchronized (monitor()) {
            check_orphaned();
            xmlDecimal = (XmlDecimal) get_store().find_element_user(DECIMAL$36, 0);
        }
        return xmlDecimal;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public STError xgetError() {
        STError find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ERROR$52, 0);
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlDateTime xgetFiletime() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_element_user(FILETIME$46, 0);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public STClsid xgetFmtid() {
        STClsid sTClsid;
        synchronized (monitor()) {
            check_orphaned();
            sTClsid = (STClsid) get_store().find_attribute_user(FMTID$68);
        }
        return sTClsid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlByte xgetI1() {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlByte = (XmlByte) get_store().find_element_user(I1$12, 0);
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlShort xgetI2() {
        XmlShort xmlShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlShort = (XmlShort) get_store().find_element_user(I2$14, 0);
        }
        return xmlShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlInt xgetI4() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_element_user(I4$16, 0);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlLong xgetI8() {
        XmlLong xmlLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlLong = (XmlLong) get_store().find_element_user(I8$18, 0);
        }
        return xmlLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlInt xgetInt() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_element_user(INT$20, 0);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetLinkTarget() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(LINKTARGET$74);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetLpstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(LPSTR$38, 0);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetLpwstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(LPWSTR$40, 0);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetName() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(NAME$72);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetOblob() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(OBLOB$6, 0);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetOstorage() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(OSTORAGE$60, 0);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetOstream() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(OSTREAM$56, 0);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlInt xgetPid() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PID$70);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlFloat xgetR4() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_element_user(R4$32, 0);
        }
        return xmlFloat;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlDouble xgetR8() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_element_user(R8$34, 0);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetStorage() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(STORAGE$58, 0);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetStream() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(STREAM$54, 0);
        }
        return xmlBase64Binary;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedByte xgetUi1() {
        XmlUnsignedByte xmlUnsignedByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByte = (XmlUnsignedByte) get_store().find_element_user(UI1$22, 0);
        }
        return xmlUnsignedByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedShort xgetUi2() {
        XmlUnsignedShort xmlUnsignedShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShort = (XmlUnsignedShort) get_store().find_element_user(UI2$24, 0);
        }
        return xmlUnsignedShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedInt xgetUi4() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_element_user(UI4$26, 0);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedLong xgetUi8() {
        XmlUnsignedLong xmlUnsignedLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLong = (XmlUnsignedLong) get_store().find_element_user(UI8$28, 0);
        }
        return xmlUnsignedLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedInt xgetUint() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_element_user(UINT$30, 0);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetBlob(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$4;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qName, 0);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetBool(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOL$48;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_element_user(qName, 0);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_element_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetBstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BSTR$42;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetClsid(STClsid sTClsid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLSID$64;
            STClsid sTClsid2 = (STClsid) typeStore.find_element_user(qName, 0);
            if (sTClsid2 == null) {
                sTClsid2 = (STClsid) get_store().add_element_user(qName);
            }
            sTClsid2.set(sTClsid);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetCy(STCy sTCy) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$50;
            STCy find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (STCy) get_store().add_element_user(qName);
            }
            find_element_user.set(sTCy);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATE$44;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_element_user(qName, 0);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetDecimal(XmlDecimal xmlDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DECIMAL$36;
            XmlDecimal xmlDecimal2 = (XmlDecimal) typeStore.find_element_user(qName, 0);
            if (xmlDecimal2 == null) {
                xmlDecimal2 = (XmlDecimal) get_store().add_element_user(qName);
            }
            xmlDecimal2.set(xmlDecimal);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetError(STError sTError) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERROR$52;
            STError find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (STError) get_store().add_element_user(qName);
            }
            find_element_user.set(sTError);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetFiletime(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILETIME$46;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_element_user(qName, 0);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetFmtid(STClsid sTClsid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FMTID$68;
            STClsid sTClsid2 = (STClsid) typeStore.find_attribute_user(qName);
            if (sTClsid2 == null) {
                sTClsid2 = (STClsid) get_store().add_attribute_user(qName);
            }
            sTClsid2.set(sTClsid);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetI1(XmlByte xmlByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I1$12;
            XmlByte xmlByte2 = (XmlByte) typeStore.find_element_user(qName, 0);
            if (xmlByte2 == null) {
                xmlByte2 = (XmlByte) get_store().add_element_user(qName);
            }
            xmlByte2.set(xmlByte);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetI2(XmlShort xmlShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I2$14;
            XmlShort xmlShort2 = (XmlShort) typeStore.find_element_user(qName, 0);
            if (xmlShort2 == null) {
                xmlShort2 = (XmlShort) get_store().add_element_user(qName);
            }
            xmlShort2.set(xmlShort);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetI4(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I4$16;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_element_user(qName, 0);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_element_user(qName);
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetI8(XmlLong xmlLong) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I8$18;
            XmlLong xmlLong2 = (XmlLong) typeStore.find_element_user(qName, 0);
            if (xmlLong2 == null) {
                xmlLong2 = (XmlLong) get_store().add_element_user(qName);
            }
            xmlLong2.set(xmlLong);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetInt(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INT$20;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_element_user(qName, 0);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_element_user(qName);
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetLinkTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINKTARGET$74;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetLpstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPSTR$38;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetLpwstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPWSTR$40;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$72;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetOblob(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBLOB$6;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qName, 0);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetOstorage(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTORAGE$60;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qName, 0);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetOstream(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTREAM$56;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qName, 0);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetPid(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PID$70;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qName);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetR4(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R4$32;
            XmlFloat xmlFloat2 = (XmlFloat) typeStore.find_element_user(qName, 0);
            if (xmlFloat2 == null) {
                xmlFloat2 = (XmlFloat) get_store().add_element_user(qName);
            }
            xmlFloat2.set(xmlFloat);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetR8(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R8$34;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_element_user(qName, 0);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_element_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetStorage(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STORAGE$58;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qName, 0);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetStream(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STREAM$54;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qName, 0);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUi1(XmlUnsignedByte xmlUnsignedByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI1$22;
            XmlUnsignedByte xmlUnsignedByte2 = (XmlUnsignedByte) typeStore.find_element_user(qName, 0);
            if (xmlUnsignedByte2 == null) {
                xmlUnsignedByte2 = (XmlUnsignedByte) get_store().add_element_user(qName);
            }
            xmlUnsignedByte2.set(xmlUnsignedByte);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUi2(XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI2$24;
            XmlUnsignedShort xmlUnsignedShort2 = (XmlUnsignedShort) typeStore.find_element_user(qName, 0);
            if (xmlUnsignedShort2 == null) {
                xmlUnsignedShort2 = (XmlUnsignedShort) get_store().add_element_user(qName);
            }
            xmlUnsignedShort2.set(xmlUnsignedShort);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUi4(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI4$26;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_element_user(qName, 0);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_element_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUi8(XmlUnsignedLong xmlUnsignedLong) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI8$28;
            XmlUnsignedLong xmlUnsignedLong2 = (XmlUnsignedLong) typeStore.find_element_user(qName, 0);
            if (xmlUnsignedLong2 == null) {
                xmlUnsignedLong2 = (XmlUnsignedLong) get_store().add_element_user(qName);
            }
            xmlUnsignedLong2.set(xmlUnsignedLong);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUint(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UINT$30;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_element_user(qName, 0);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_element_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }
}
