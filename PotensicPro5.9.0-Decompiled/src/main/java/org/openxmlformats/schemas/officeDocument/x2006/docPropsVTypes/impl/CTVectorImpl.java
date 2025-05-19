package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTCf;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STClsid;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STVectorBaseType;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STVectorBaseType$Enum;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes2.dex */
public class CTVectorImpl extends XmlComplexContentImpl implements CTVector {
    private static final QName VARIANT$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "variant");
    private static final QName I1$2 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i1");
    private static final QName I2$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i2");
    private static final QName I4$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i4");
    private static final QName I8$8 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i8");
    private static final QName UI1$10 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui1");
    private static final QName UI2$12 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui2");
    private static final QName UI4$14 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui4");
    private static final QName UI8$16 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui8");
    private static final QName R4$18 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r4");
    private static final QName R8$20 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r8");
    private static final QName LPSTR$22 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpstr");
    private static final QName LPWSTR$24 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpwstr");
    private static final QName BSTR$26 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bstr");
    private static final QName DATE$28 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "date");
    private static final QName FILETIME$30 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "filetime");
    private static final QName BOOL$32 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bool");
    private static final QName CY$34 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cy");
    private static final QName ERROR$36 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
    private static final QName CLSID$38 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "clsid");
    private static final QName CF$40 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cf");
    private static final QName BASETYPE$42 = new QName("", "baseType");
    private static final QName SIZE$44 = new QName("", "size");

    public CTVectorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addBool(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(BOOL$32)).setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addBstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(BSTR$26)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addClsid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(CLSID$38)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addCy(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(CY$34)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DATE$28)).setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addError(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(ERROR$36)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addFiletime(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FILETIME$30)).setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addI1(byte b) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(I1$2)).setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addI2(short s) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(I2$4)).setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addI4(int i) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(I4$6)).setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addI8(long j) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(I8$8)).setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addLpstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(LPSTR$22)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addLpwstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(LPWSTR$24)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlBoolean addNewBool() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().add_element_user(BOOL$32);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString addNewBstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(BSTR$26);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTCf addNewCf() {
        CTCf add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CF$40);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STClsid addNewClsid() {
        STClsid sTClsid;
        synchronized (monitor()) {
            check_orphaned();
            sTClsid = (STClsid) get_store().add_element_user(CLSID$38);
        }
        return sTClsid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STCy addNewCy() {
        STCy add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CY$34);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime addNewDate() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().add_element_user(DATE$28);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STError addNewError() {
        STError add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ERROR$36);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime addNewFiletime() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().add_element_user(FILETIME$30);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlByte addNewI1() {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlByte = (XmlByte) get_store().add_element_user(I1$2);
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlShort addNewI2() {
        XmlShort xmlShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlShort = (XmlShort) get_store().add_element_user(I2$4);
        }
        return xmlShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlInt addNewI4() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().add_element_user(I4$6);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlLong addNewI8() {
        XmlLong xmlLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlLong = (XmlLong) get_store().add_element_user(I8$8);
        }
        return xmlLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString addNewLpstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(LPSTR$22);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString addNewLpwstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(LPWSTR$24);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlFloat addNewR4() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().add_element_user(R4$18);
        }
        return xmlFloat;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDouble addNewR8() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().add_element_user(R8$20);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedByte addNewUi1() {
        XmlUnsignedByte xmlUnsignedByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByte = (XmlUnsignedByte) get_store().add_element_user(UI1$10);
        }
        return xmlUnsignedByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedShort addNewUi2() {
        XmlUnsignedShort xmlUnsignedShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShort = (XmlUnsignedShort) get_store().add_element_user(UI2$12);
        }
        return xmlUnsignedShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt addNewUi4() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().add_element_user(UI4$14);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedLong addNewUi8() {
        XmlUnsignedLong xmlUnsignedLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLong = (XmlUnsignedLong) get_store().add_element_user(UI8$16);
        }
        return xmlUnsignedLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTVariant addNewVariant() {
        CTVariant cTVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVariant = (CTVariant) get_store().add_element_user(VARIANT$0);
        }
        return cTVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addR4(float f) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(R4$18)).setFloatValue(f);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addR8(double d) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(R8$20)).setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addUi1(short s) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(UI1$10)).setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addUi2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(UI2$12)).setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addUi4(long j) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(UI4$14)).setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addUi8(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(UI8$16)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STVectorBaseType$Enum getBaseType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BASETYPE$42);
            if (simpleValue == null) {
                return null;
            }
            return (STVectorBaseType$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public boolean getBoolArray(int i) {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BOOL$32, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            booleanValue = simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public boolean[] getBoolArray() {
        boolean[] zArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOL$32, arrayList);
            zArr = new boolean[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zArr[i] = ((SimpleValue) arrayList.get(i)).getBooleanValue();
            }
        }
        return zArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Boolean> getBoolList() {
        1BoolList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BoolList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getBstrArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BSTR$26, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getBstrArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BSTR$26, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getBstrList() {
        1BstrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BstrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTCf getCfArray(int i) {
        CTCf find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CF$40, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTCf[] getCfArray() {
        CTCf[] cTCfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CF$40, arrayList);
            cTCfArr = new CTCf[arrayList.size()];
            arrayList.toArray(cTCfArr);
        }
        return cTCfArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<CTCf> getCfList() {
        1CfList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CfList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getClsidArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CLSID$38, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getClsidArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLSID$38, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getClsidList() {
        1ClsidList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClsidList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getCyArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CY$34, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getCyArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CY$34, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getCyList() {
        1CyList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CyList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public Calendar getDateArray(int i) {
        Calendar calendarValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DATE$28, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            calendarValue = simpleValue.getCalendarValue();
        }
        return calendarValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public Calendar[] getDateArray() {
        Calendar[] calendarArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DATE$28, arrayList);
            calendarArr = new Calendar[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                calendarArr[i] = ((SimpleValue) arrayList.get(i)).getCalendarValue();
            }
        }
        return calendarArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Calendar> getDateList() {
        1DateList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DateList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getErrorArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ERROR$36, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getErrorArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ERROR$36, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getErrorList() {
        1ErrorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ErrorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public Calendar getFiletimeArray(int i) {
        Calendar calendarValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FILETIME$30, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            calendarValue = simpleValue.getCalendarValue();
        }
        return calendarValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public Calendar[] getFiletimeArray() {
        Calendar[] calendarArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILETIME$30, arrayList);
            calendarArr = new Calendar[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                calendarArr[i] = ((SimpleValue) arrayList.get(i)).getCalendarValue();
            }
        }
        return calendarArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Calendar> getFiletimeList() {
        1FiletimeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FiletimeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public byte getI1Array(int i) {
        byte byteValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I1$2, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            byteValue = simpleValue.getByteValue();
        }
        return byteValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public byte[] getI1Array() {
        byte[] bArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I1$2, arrayList);
            bArr = new byte[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bArr[i] = ((SimpleValue) arrayList.get(i)).getByteValue();
            }
        }
        return bArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Byte> getI1List() {
        1I1List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1I1List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public short getI2Array(int i) {
        short shortValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I2$4, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            shortValue = simpleValue.getShortValue();
        }
        return shortValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public short[] getI2Array() {
        short[] sArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I2$4, arrayList);
            sArr = new short[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sArr[i] = ((SimpleValue) arrayList.get(i)).getShortValue();
            }
        }
        return sArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Short> getI2List() {
        1I2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1I2List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int getI4Array(int i) {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I4$6, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            intValue = simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int[] getI4Array() {
        int[] iArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I4$6, arrayList);
            iArr = new int[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                iArr[i] = ((SimpleValue) arrayList.get(i)).getIntValue();
            }
        }
        return iArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Integer> getI4List() {
        1I4List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1I4List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long getI8Array(int i) {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I8$8, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            longValue = simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long[] getI8Array() {
        long[] jArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I8$8, arrayList);
            jArr = new long[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                jArr[i] = ((SimpleValue) arrayList.get(i)).getLongValue();
            }
        }
        return jArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Long> getI8List() {
        1I8List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1I8List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getLpstrArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LPSTR$22, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getLpstrArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LPSTR$22, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getLpstrList() {
        1LpstrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LpstrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getLpwstrArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LPWSTR$24, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getLpwstrArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LPWSTR$24, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getLpwstrList() {
        1LpwstrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LpwstrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public float getR4Array(int i) {
        float floatValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(R4$18, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            floatValue = simpleValue.getFloatValue();
        }
        return floatValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public float[] getR4Array() {
        float[] fArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R4$18, arrayList);
            fArr = new float[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                fArr[i] = ((SimpleValue) arrayList.get(i)).getFloatValue();
            }
        }
        return fArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Float> getR4List() {
        1R4List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1R4List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public double getR8Array(int i) {
        double doubleValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(R8$20, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            doubleValue = simpleValue.getDoubleValue();
        }
        return doubleValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public double[] getR8Array() {
        double[] dArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R8$20, arrayList);
            dArr = new double[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                dArr[i] = ((SimpleValue) arrayList.get(i)).getDoubleValue();
            }
        }
        return dArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Double> getR8List() {
        1R8List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1R8List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long getSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SIZE$44);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public short getUi1Array(int i) {
        short shortValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI1$10, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            shortValue = simpleValue.getShortValue();
        }
        return shortValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public short[] getUi1Array() {
        short[] sArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UI1$10, arrayList);
            sArr = new short[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sArr[i] = ((SimpleValue) arrayList.get(i)).getShortValue();
            }
        }
        return sArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Short> getUi1List() {
        1Ui1List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Ui1List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int getUi2Array(int i) {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI2$12, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            intValue = simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int[] getUi2Array() {
        int[] iArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UI2$12, arrayList);
            iArr = new int[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                iArr[i] = ((SimpleValue) arrayList.get(i)).getIntValue();
            }
        }
        return iArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Integer> getUi2List() {
        1Ui2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Ui2List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long getUi4Array(int i) {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI4$14, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            longValue = simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long[] getUi4Array() {
        long[] jArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UI4$14, arrayList);
            jArr = new long[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                jArr[i] = ((SimpleValue) arrayList.get(i)).getLongValue();
            }
        }
        return jArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Long> getUi4List() {
        1Ui4List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Ui4List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public BigInteger getUi8Array(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI8$16, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public BigInteger[] getUi8Array() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UI8$16, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<BigInteger> getUi8List() {
        1Ui8List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Ui8List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTVariant getVariantArray(int i) {
        CTVariant cTVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVariant = (CTVariant) get_store().find_element_user(VARIANT$0, i);
            if (cTVariant == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTVariant[] getVariantArray() {
        CTVariant[] cTVariantArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VARIANT$0, arrayList);
            cTVariantArr = new CTVariant[arrayList.size()];
            arrayList.toArray(cTVariantArr);
        }
        return cTVariantArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<CTVariant> getVariantList() {
        1VariantList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1VariantList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertBool(int i, boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(BOOL$32, i)).setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertBstr(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(BSTR$26, i)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertClsid(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(CLSID$38, i)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertCy(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(CY$34, i)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertDate(int i, Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DATE$28, i)).setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertError(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(ERROR$36, i)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertFiletime(int i, Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FILETIME$30, i)).setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertI1(int i, byte b) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(I1$2, i)).setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertI2(int i, short s) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(I2$4, i)).setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertI4(int i, int i2) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(I4$6, i)).setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertI8(int i, long j) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(I8$8, i)).setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertLpstr(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(LPSTR$22, i)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertLpwstr(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(LPWSTR$24, i)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlBoolean insertNewBool(int i) {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().insert_element_user(BOOL$32, i);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString insertNewBstr(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(BSTR$26, i);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTCf insertNewCf(int i) {
        CTCf insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CF$40, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STClsid insertNewClsid(int i) {
        STClsid sTClsid;
        synchronized (monitor()) {
            check_orphaned();
            sTClsid = (STClsid) get_store().insert_element_user(CLSID$38, i);
        }
        return sTClsid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STCy insertNewCy(int i) {
        STCy insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CY$34, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime insertNewDate(int i) {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().insert_element_user(DATE$28, i);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STError insertNewError(int i) {
        STError insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ERROR$36, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime insertNewFiletime(int i) {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().insert_element_user(FILETIME$30, i);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlByte insertNewI1(int i) {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlByte = (XmlByte) get_store().insert_element_user(I1$2, i);
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlShort insertNewI2(int i) {
        XmlShort xmlShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlShort = (XmlShort) get_store().insert_element_user(I2$4, i);
        }
        return xmlShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlInt insertNewI4(int i) {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().insert_element_user(I4$6, i);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlLong insertNewI8(int i) {
        XmlLong xmlLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlLong = (XmlLong) get_store().insert_element_user(I8$8, i);
        }
        return xmlLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString insertNewLpstr(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(LPSTR$22, i);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString insertNewLpwstr(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(LPWSTR$24, i);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlFloat insertNewR4(int i) {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().insert_element_user(R4$18, i);
        }
        return xmlFloat;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDouble insertNewR8(int i) {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().insert_element_user(R8$20, i);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedByte insertNewUi1(int i) {
        XmlUnsignedByte xmlUnsignedByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByte = (XmlUnsignedByte) get_store().insert_element_user(UI1$10, i);
        }
        return xmlUnsignedByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedShort insertNewUi2(int i) {
        XmlUnsignedShort xmlUnsignedShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShort = (XmlUnsignedShort) get_store().insert_element_user(UI2$12, i);
        }
        return xmlUnsignedShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt insertNewUi4(int i) {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().insert_element_user(UI4$14, i);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedLong insertNewUi8(int i) {
        XmlUnsignedLong xmlUnsignedLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLong = (XmlUnsignedLong) get_store().insert_element_user(UI8$16, i);
        }
        return xmlUnsignedLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTVariant insertNewVariant(int i) {
        CTVariant cTVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVariant = (CTVariant) get_store().insert_element_user(VARIANT$0, i);
        }
        return cTVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertR4(int i, float f) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(R4$18, i)).setFloatValue(f);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertR8(int i, double d) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(R8$20, i)).setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertUi1(int i, short s) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(UI1$10, i)).setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertUi2(int i, int i2) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(UI2$12, i)).setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertUi4(int i, long j) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(UI4$14, i)).setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertUi8(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(UI8$16, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeBool(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOL$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeBstr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BSTR$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeCf(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CF$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeClsid(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLSID$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeCy(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CY$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeDate(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATE$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeError(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ERROR$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeFiletime(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILETIME$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeI1(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I1$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeI2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I2$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeI4(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I4$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeI8(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I8$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeLpstr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LPSTR$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeLpwstr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LPWSTR$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeR4(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R4$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeR8(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R8$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeUi1(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI1$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeUi2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI2$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeUi4(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI4$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeUi8(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI8$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeVariant(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VARIANT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBaseType(STVectorBaseType$Enum sTVectorBaseType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASETYPE$42;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTVectorBaseType$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBoolArray(int i, boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BOOL$32, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBoolArray(boolean[] zArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(zArr, BOOL$32);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBstrArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(BSTR$26, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBstrArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, BSTR$26);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setCfArray(int i, CTCf cTCf) {
        synchronized (monitor()) {
            check_orphaned();
            CTCf find_element_user = get_store().find_element_user(CF$40, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCf);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setCfArray(CTCf[] cTCfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCfArr, CF$40);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setClsidArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CLSID$38, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setClsidArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, CLSID$38);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setCyArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CY$34, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setCyArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, CY$34);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setDateArray(int i, Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DATE$28, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setDateArray(Calendar[] calendarArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(calendarArr, DATE$28);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setErrorArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ERROR$36, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setErrorArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, ERROR$36);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setFiletimeArray(int i, Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FILETIME$30, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setFiletimeArray(Calendar[] calendarArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(calendarArr, FILETIME$30);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI1Array(int i, byte b) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I1$2, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI1Array(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bArr, I1$2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI2Array(int i, short s) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I2$4, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI2Array(short[] sArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sArr, I2$4);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI4Array(int i, int i2) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I4$6, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI4Array(int[] iArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(iArr, I4$6);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI8Array(int i, long j) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(I8$8, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI8Array(long[] jArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(jArr, I8$8);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setLpstrArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LPSTR$22, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setLpstrArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, LPSTR$22);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setLpwstrArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LPWSTR$24, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setLpwstrArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, LPWSTR$24);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setR4Array(int i, float f) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(R4$18, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setFloatValue(f);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setR4Array(float[] fArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(fArr, R4$18);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setR8Array(int i, double d) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(R8$20, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setR8Array(double[] dArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(dArr, R8$20);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setSize(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$44;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi1Array(int i, short s) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI1$10, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi1Array(short[] sArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sArr, UI1$10);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi2Array(int i, int i2) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI2$12, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi2Array(int[] iArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(iArr, UI2$12);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi4Array(int i, long j) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI4$14, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi4Array(long[] jArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(jArr, UI4$14);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi8Array(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UI8$16, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi8Array(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, UI8$16);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setVariantArray(int i, CTVariant cTVariant) {
        synchronized (monitor()) {
            check_orphaned();
            CTVariant cTVariant2 = (CTVariant) get_store().find_element_user(VARIANT$0, i);
            if (cTVariant2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTVariant2.set(cTVariant);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setVariantArray(CTVariant[] cTVariantArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTVariantArr, VARIANT$0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfBoolArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOL$32);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfBstrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BSTR$26);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfCfArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CF$40);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfClsidArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLSID$38);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfCyArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CY$34);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfDateArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DATE$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfErrorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ERROR$36);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfFiletimeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FILETIME$30);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfI1Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(I1$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfI2Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(I2$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfI4Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(I4$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfI8Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(I8$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfLpstrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LPSTR$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfLpwstrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LPWSTR$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfR4Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(R4$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfR8Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(R8$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfUi1Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(UI1$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfUi2Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(UI2$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfUi4Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(UI4$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfUi8Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(UI8$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfVariantArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(VARIANT$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STVectorBaseType xgetBaseType() {
        STVectorBaseType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BASETYPE$42);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlBoolean xgetBoolArray(int i) {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_element_user(BOOL$32, i);
            if (xmlBoolean == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlBoolean[] xgetBoolArray() {
        XmlBoolean[] xmlBooleanArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOL$32, arrayList);
            xmlBooleanArr = new XmlBoolean[arrayList.size()];
            arrayList.toArray(xmlBooleanArr);
        }
        return xmlBooleanArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlBoolean> xgetBoolList() {
        2BoolList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2BoolList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString xgetBstrArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(BSTR$26, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString[] xgetBstrArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BSTR$26, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlString> xgetBstrList() {
        2BstrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2BstrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STClsid xgetClsidArray(int i) {
        STClsid sTClsid;
        synchronized (monitor()) {
            check_orphaned();
            sTClsid = (STClsid) get_store().find_element_user(CLSID$38, i);
            if (sTClsid == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTClsid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STClsid[] xgetClsidArray() {
        STClsid[] sTClsidArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLSID$38, arrayList);
            sTClsidArr = new STClsid[arrayList.size()];
            arrayList.toArray(sTClsidArr);
        }
        return sTClsidArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<STClsid> xgetClsidList() {
        2ClsidList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ClsidList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STCy xgetCyArray(int i) {
        STCy find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CY$34, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STCy[] xgetCyArray() {
        STCy[] sTCyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CY$34, arrayList);
            sTCyArr = new STCy[arrayList.size()];
            arrayList.toArray(sTCyArr);
        }
        return sTCyArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<STCy> xgetCyList() {
        2CyList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2CyList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime xgetDateArray(int i) {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_element_user(DATE$28, i);
            if (xmlDateTime == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime[] xgetDateArray() {
        XmlDateTime[] xmlDateTimeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DATE$28, arrayList);
            xmlDateTimeArr = new XmlDateTime[arrayList.size()];
            arrayList.toArray(xmlDateTimeArr);
        }
        return xmlDateTimeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlDateTime> xgetDateList() {
        2DateList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DateList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STError xgetErrorArray(int i) {
        STError find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ERROR$36, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STError[] xgetErrorArray() {
        STError[] sTErrorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ERROR$36, arrayList);
            sTErrorArr = new STError[arrayList.size()];
            arrayList.toArray(sTErrorArr);
        }
        return sTErrorArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<STError> xgetErrorList() {
        2ErrorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ErrorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime xgetFiletimeArray(int i) {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_element_user(FILETIME$30, i);
            if (xmlDateTime == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime[] xgetFiletimeArray() {
        XmlDateTime[] xmlDateTimeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILETIME$30, arrayList);
            xmlDateTimeArr = new XmlDateTime[arrayList.size()];
            arrayList.toArray(xmlDateTimeArr);
        }
        return xmlDateTimeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlDateTime> xgetFiletimeList() {
        2FiletimeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FiletimeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlByte xgetI1Array(int i) {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlByte = (XmlByte) get_store().find_element_user(I1$2, i);
            if (xmlByte == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlByte[] xgetI1Array() {
        XmlByte[] xmlByteArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I1$2, arrayList);
            xmlByteArr = new XmlByte[arrayList.size()];
            arrayList.toArray(xmlByteArr);
        }
        return xmlByteArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlByte> xgetI1List() {
        2I1List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2I1List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlShort xgetI2Array(int i) {
        XmlShort xmlShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlShort = (XmlShort) get_store().find_element_user(I2$4, i);
            if (xmlShort == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlShort[] xgetI2Array() {
        XmlShort[] xmlShortArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I2$4, arrayList);
            xmlShortArr = new XmlShort[arrayList.size()];
            arrayList.toArray(xmlShortArr);
        }
        return xmlShortArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlShort> xgetI2List() {
        2I2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2I2List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlInt xgetI4Array(int i) {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_element_user(I4$6, i);
            if (xmlInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlInt[] xgetI4Array() {
        XmlInt[] xmlIntArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I4$6, arrayList);
            xmlIntArr = new XmlInt[arrayList.size()];
            arrayList.toArray(xmlIntArr);
        }
        return xmlIntArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlInt> xgetI4List() {
        2I4List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2I4List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlLong xgetI8Array(int i) {
        XmlLong xmlLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlLong = (XmlLong) get_store().find_element_user(I8$8, i);
            if (xmlLong == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlLong[] xgetI8Array() {
        XmlLong[] xmlLongArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I8$8, arrayList);
            xmlLongArr = new XmlLong[arrayList.size()];
            arrayList.toArray(xmlLongArr);
        }
        return xmlLongArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlLong> xgetI8List() {
        2I8List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2I8List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString xgetLpstrArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(LPSTR$22, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString[] xgetLpstrArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LPSTR$22, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlString> xgetLpstrList() {
        2LpstrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2LpstrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString xgetLpwstrArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(LPWSTR$24, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString[] xgetLpwstrArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LPWSTR$24, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlString> xgetLpwstrList() {
        2LpwstrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2LpwstrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlFloat xgetR4Array(int i) {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_element_user(R4$18, i);
            if (xmlFloat == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlFloat;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlFloat[] xgetR4Array() {
        XmlFloat[] xmlFloatArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R4$18, arrayList);
            xmlFloatArr = new XmlFloat[arrayList.size()];
            arrayList.toArray(xmlFloatArr);
        }
        return xmlFloatArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlFloat> xgetR4List() {
        2R4List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2R4List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDouble xgetR8Array(int i) {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_element_user(R8$20, i);
            if (xmlDouble == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDouble[] xgetR8Array() {
        XmlDouble[] xmlDoubleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R8$20, arrayList);
            xmlDoubleArr = new XmlDouble[arrayList.size()];
            arrayList.toArray(xmlDoubleArr);
        }
        return xmlDoubleArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlDouble> xgetR8List() {
        2R8List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2R8List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt xgetSize() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(SIZE$44);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedByte xgetUi1Array(int i) {
        XmlUnsignedByte xmlUnsignedByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByte = (XmlUnsignedByte) get_store().find_element_user(UI1$10, i);
            if (xmlUnsignedByte == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlUnsignedByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedByte[] xgetUi1Array() {
        XmlUnsignedByte[] xmlUnsignedByteArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UI1$10, arrayList);
            xmlUnsignedByteArr = new XmlUnsignedByte[arrayList.size()];
            arrayList.toArray(xmlUnsignedByteArr);
        }
        return xmlUnsignedByteArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlUnsignedByte> xgetUi1List() {
        2Ui1List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2Ui1List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedShort xgetUi2Array(int i) {
        XmlUnsignedShort xmlUnsignedShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShort = (XmlUnsignedShort) get_store().find_element_user(UI2$12, i);
            if (xmlUnsignedShort == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlUnsignedShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedShort[] xgetUi2Array() {
        XmlUnsignedShort[] xmlUnsignedShortArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UI2$12, arrayList);
            xmlUnsignedShortArr = new XmlUnsignedShort[arrayList.size()];
            arrayList.toArray(xmlUnsignedShortArr);
        }
        return xmlUnsignedShortArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlUnsignedShort> xgetUi2List() {
        2Ui2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2Ui2List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt xgetUi4Array(int i) {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_element_user(UI4$14, i);
            if (xmlUnsignedInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt[] xgetUi4Array() {
        XmlUnsignedInt[] xmlUnsignedIntArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UI4$14, arrayList);
            xmlUnsignedIntArr = new XmlUnsignedInt[arrayList.size()];
            arrayList.toArray(xmlUnsignedIntArr);
        }
        return xmlUnsignedIntArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlUnsignedInt> xgetUi4List() {
        2Ui4List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2Ui4List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedLong xgetUi8Array(int i) {
        XmlUnsignedLong xmlUnsignedLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLong = (XmlUnsignedLong) get_store().find_element_user(UI8$16, i);
            if (xmlUnsignedLong == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlUnsignedLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedLong[] xgetUi8Array() {
        XmlUnsignedLong[] xmlUnsignedLongArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UI8$16, arrayList);
            xmlUnsignedLongArr = new XmlUnsignedLong[arrayList.size()];
            arrayList.toArray(xmlUnsignedLongArr);
        }
        return xmlUnsignedLongArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlUnsignedLong> xgetUi8List() {
        2Ui8List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2Ui8List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBaseType(STVectorBaseType sTVectorBaseType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASETYPE$42;
            STVectorBaseType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STVectorBaseType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTVectorBaseType);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBoolArray(int i, XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            XmlBoolean xmlBoolean2 = (XmlBoolean) get_store().find_element_user(BOOL$32, i);
            if (xmlBoolean2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBoolArray(XmlBoolean[] xmlBooleanArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlBooleanArr, BOOL$32);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBstrArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(BSTR$26, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBstrArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, BSTR$26);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetClsidArray(int i, STClsid sTClsid) {
        synchronized (monitor()) {
            check_orphaned();
            STClsid sTClsid2 = (STClsid) get_store().find_element_user(CLSID$38, i);
            if (sTClsid2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTClsid2.set(sTClsid);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetClsidArray(STClsid[] sTClsidArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTClsidArr, CLSID$38);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetCyArray(int i, STCy sTCy) {
        synchronized (monitor()) {
            check_orphaned();
            STCy find_element_user = get_store().find_element_user(CY$34, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(sTCy);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetCyArray(STCy[] sTCyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) sTCyArr, CY$34);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetDateArray(int i, XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            XmlDateTime xmlDateTime2 = (XmlDateTime) get_store().find_element_user(DATE$28, i);
            if (xmlDateTime2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetDateArray(XmlDateTime[] xmlDateTimeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlDateTimeArr, DATE$28);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetErrorArray(int i, STError sTError) {
        synchronized (monitor()) {
            check_orphaned();
            STError find_element_user = get_store().find_element_user(ERROR$36, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(sTError);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetErrorArray(STError[] sTErrorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) sTErrorArr, ERROR$36);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetFiletimeArray(int i, XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            XmlDateTime xmlDateTime2 = (XmlDateTime) get_store().find_element_user(FILETIME$30, i);
            if (xmlDateTime2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetFiletimeArray(XmlDateTime[] xmlDateTimeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlDateTimeArr, FILETIME$30);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI1Array(int i, XmlByte xmlByte) {
        synchronized (monitor()) {
            check_orphaned();
            XmlByte xmlByte2 = (XmlByte) get_store().find_element_user(I1$2, i);
            if (xmlByte2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlByte2.set(xmlByte);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI1Array(XmlByte[] xmlByteArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlByteArr, I1$2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI2Array(int i, XmlShort xmlShort) {
        synchronized (monitor()) {
            check_orphaned();
            XmlShort xmlShort2 = (XmlShort) get_store().find_element_user(I2$4, i);
            if (xmlShort2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlShort2.set(xmlShort);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI2Array(XmlShort[] xmlShortArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlShortArr, I2$4);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI4Array(int i, XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInt xmlInt2 = (XmlInt) get_store().find_element_user(I4$6, i);
            if (xmlInt2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI4Array(XmlInt[] xmlIntArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntArr, I4$6);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI8Array(int i, XmlLong xmlLong) {
        synchronized (monitor()) {
            check_orphaned();
            XmlLong xmlLong2 = (XmlLong) get_store().find_element_user(I8$8, i);
            if (xmlLong2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlLong2.set(xmlLong);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI8Array(XmlLong[] xmlLongArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlLongArr, I8$8);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetLpstrArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(LPSTR$22, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetLpstrArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, LPSTR$22);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetLpwstrArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(LPWSTR$24, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetLpwstrArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, LPWSTR$24);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetR4Array(int i, XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            XmlFloat xmlFloat2 = (XmlFloat) get_store().find_element_user(R4$18, i);
            if (xmlFloat2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlFloat2.set(xmlFloat);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetR4Array(XmlFloat[] xmlFloatArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlFloatArr, R4$18);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetR8Array(int i, XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            XmlDouble xmlDouble2 = (XmlDouble) get_store().find_element_user(R8$20, i);
            if (xmlDouble2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetR8Array(XmlDouble[] xmlDoubleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlDoubleArr, R8$20);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetSize(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$44;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi1Array(int i, XmlUnsignedByte xmlUnsignedByte) {
        synchronized (monitor()) {
            check_orphaned();
            XmlUnsignedByte xmlUnsignedByte2 = (XmlUnsignedByte) get_store().find_element_user(UI1$10, i);
            if (xmlUnsignedByte2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlUnsignedByte2.set(xmlUnsignedByte);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi1Array(XmlUnsignedByte[] xmlUnsignedByteArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlUnsignedByteArr, UI1$10);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi2Array(int i, XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            XmlUnsignedShort xmlUnsignedShort2 = (XmlUnsignedShort) get_store().find_element_user(UI2$12, i);
            if (xmlUnsignedShort2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlUnsignedShort2.set(xmlUnsignedShort);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi2Array(XmlUnsignedShort[] xmlUnsignedShortArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlUnsignedShortArr, UI2$12);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi4Array(int i, XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) get_store().find_element_user(UI4$14, i);
            if (xmlUnsignedInt2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi4Array(XmlUnsignedInt[] xmlUnsignedIntArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlUnsignedIntArr, UI4$14);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi8Array(int i, XmlUnsignedLong xmlUnsignedLong) {
        synchronized (monitor()) {
            check_orphaned();
            XmlUnsignedLong xmlUnsignedLong2 = (XmlUnsignedLong) get_store().find_element_user(UI8$16, i);
            if (xmlUnsignedLong2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlUnsignedLong2.set(xmlUnsignedLong);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi8Array(XmlUnsignedLong[] xmlUnsignedLongArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlUnsignedLongArr, UI8$16);
        }
    }
}
