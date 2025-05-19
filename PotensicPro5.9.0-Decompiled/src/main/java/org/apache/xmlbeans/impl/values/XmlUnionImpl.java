package org.apache.xmlbeans.impl.values;

import aavax.xml.namespace.QName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;

/* loaded from: classes5.dex */
public class XmlUnionImpl extends XmlObjectBase implements XmlAnySimpleType {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int JAVA_BYTEARRAY = 50;
    private static final int JAVA_CALENDAR = 49;
    private static final int JAVA_DATE = 48;
    private static final int JAVA_LIST = 51;
    private static final int JAVA_NUMBER = 47;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$XmlUnionImpl;
    private SchemaType _schemaType;
    private String _textvalue = "";
    private XmlAnySimpleType _value;

    static boolean lexical_overlap(int i, int i2) {
        if (i != i2 && i != 2 && i2 != 2 && i != 12 && i2 != 12 && i != 6 && i2 != 6) {
            if (i != 3) {
                if (i == 4) {
                    if (i2 != 3 && i2 != 5 && i2 != 13 && i2 != 18) {
                        switch (i2) {
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                                break;
                            default:
                                return false;
                        }
                    }
                    return true;
                }
                if (i == 5) {
                    if (i2 != 3 && i2 != 4 && i2 != 18) {
                        switch (i2) {
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                                break;
                            default:
                                return false;
                        }
                    }
                    return true;
                }
                if (i == 13) {
                    return i2 == 4 || i2 == 7 || i2 == 8;
                }
                if (i != 18) {
                    switch (i) {
                        case 7:
                        case 8:
                            return i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 13;
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                if (i2 != 4 && i2 != 5 && i2 != 18) {
                    switch (i2) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
            }
            if (i2 != 7 && i2 != 8) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return 1;
    }

    static {
        if (class$org$apache$xmlbeans$impl$values$XmlUnionImpl == null) {
            class$org$apache$xmlbeans$impl$values$XmlUnionImpl = class$("org.apache.xmlbeans.impl.values.XmlUnionImpl");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public XmlUnionImpl(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).instanceType();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return this._textvalue;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean is_defaultable_ws(String str) {
        try {
            XmlAnySimpleType xmlAnySimpleType = this._value;
            set_text(str);
            this._value = xmlAnySimpleType;
            return false;
        } catch (XmlValueOutOfRangeException unused) {
            return true;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        boolean z;
        XmlAnySimpleType newValue;
        if (!this._schemaType.matchPatternFacet(str) && _validateOnSet()) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"string", str, QNameHelper.readable(this._schemaType)});
        }
        String str2 = this._textvalue;
        this._textvalue = str;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        if (!$assertionsDisabled && unionConstituentTypes == null) {
            throw new AssertionError();
        }
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        boolean z2 = true;
        while (true) {
            if (!z2) {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                } catch (Throwable th) {
                    if (z) {
                        NamespaceContext.pop();
                    }
                    throw th;
                }
            }
            for (SchemaType schemaType : unionConstituentTypes) {
                try {
                    newValue = ((SchemaTypeImpl) schemaType).newValue(str, z2);
                } catch (XmlValueOutOfRangeException unused) {
                } catch (Exception e) {
                    throw new RuntimeException(new StringBuffer().append("Troublesome union exception caused by unexpected ").append(e).toString(), e);
                }
                if (check(newValue, this._schemaType)) {
                    this._value = newValue;
                    if (z) {
                        NamespaceContext.pop();
                        return;
                    }
                    return;
                }
            }
            if (!z2) {
                break;
            } else {
                z2 = false;
            }
        }
        if (z) {
            NamespaceContext.pop();
        }
        this._textvalue = str2;
        throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$UNION, new Object[]{str, QNameHelper.readable(this._schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
        this._textvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0.0f;
        }
        return ((SimpleValue) xmlAnySimpleType).getFloatValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0.0d;
        }
        return ((SimpleValue) xmlAnySimpleType).getDoubleValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return (byte) 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getByteValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return (short) 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getShortValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getIntValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0L;
        }
        return ((SimpleValue) xmlAnySimpleType).getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return false;
        }
        return ((SimpleValue) xmlAnySimpleType).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getCalendarValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getGDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getGDurationValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getQNameValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List getListValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List xgetListValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).xgetListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getEnumValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return xmlAnySimpleType.getStringValue();
    }

    private static boolean logical_overlap(SchemaType schemaType, int i) {
        boolean z = $assertionsDisabled;
        if (!z && schemaType.getSimpleVariety() == 2) {
            throw new AssertionError();
        }
        if (i <= 46) {
            return schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == i;
        }
        switch (i) {
            case 47:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode = schemaType.getPrimitiveType().getBuiltinTypeCode();
                if (builtinTypeCode != 18 && builtinTypeCode != 20 && builtinTypeCode != 21) {
                    switch (builtinTypeCode) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
            case 48:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode2 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                return builtinTypeCode2 == 14 || builtinTypeCode2 == 16;
            case 49:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return true;
                    default:
                        return false;
                }
            case 50:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode3 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                return builtinTypeCode3 == 4 || builtinTypeCode3 == 5;
            case 51:
                return schemaType.getSimpleVariety() == 3;
            default:
                if (z) {
                    return false;
                }
                throw new AssertionError("missing case");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x007c, code lost:
    
        if (r1 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007e, code lost:
    
        org.apache.xmlbeans.impl.values.NamespaceContext.pop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0099, code lost:
    
        throw new org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException(org.apache.xmlbeans.XmlErrorCodes.DATATYPE_VALID$UNION, new java.lang.Object[]{r10.toString(), org.apache.xmlbeans.impl.common.QNameHelper.readable(r8._schemaType)});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void set_primitive(int r9, java.lang.Object r10) {
        /*
            r8 = this;
            org.apache.xmlbeans.SchemaType r0 = r8._schemaType
            org.apache.xmlbeans.SchemaType[] r0 = r0.getUnionConstituentTypes()
            boolean r1 = org.apache.xmlbeans.impl.values.XmlUnionImpl.$assertionsDisabled
            if (r1 != 0) goto L13
            if (r0 == 0) goto Ld
            goto L13
        Ld:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L13:
            boolean r1 = r8.has_store()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L29
            org.apache.xmlbeans.impl.values.NamespaceContext r1 = new org.apache.xmlbeans.impl.values.NamespaceContext
            org.apache.xmlbeans.impl.values.TypeStore r4 = r8.get_store()
            r1.<init>(r4)
            org.apache.xmlbeans.impl.values.NamespaceContext.push(r1)
            r1 = r2
            goto L2a
        L29:
            r1 = r3
        L2a:
            r4 = r2
        L2b:
            if (r4 != 0) goto L36
            boolean r5 = r8._validateOnSet()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto L7c
            goto L36
        L34:
            r9 = move-exception
            goto L9c
        L36:
            r5 = r3
        L37:
            int r6 = r0.length     // Catch: java.lang.Throwable -> L34
            if (r5 >= r6) goto L7a
            r6 = r0[r5]     // Catch: java.lang.Throwable -> L34
            boolean r6 = logical_overlap(r6, r9)     // Catch: java.lang.Throwable -> L34
            if (r6 == 0) goto L77
            r6 = r0[r5]     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L58 org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException -> L77
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r6 = (org.apache.xmlbeans.impl.schema.SchemaTypeImpl) r6     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L58 org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException -> L77
            org.apache.xmlbeans.XmlAnySimpleType r9 = r6.newValue(r10, r4)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L58 org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException -> L77
            r8._value = r9     // Catch: java.lang.Throwable -> L34
            java.lang.String r9 = r9.stringValue()     // Catch: java.lang.Throwable -> L34
            r8._textvalue = r9     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L57
            org.apache.xmlbeans.impl.values.NamespaceContext.pop()
        L57:
            return
        L58:
            r6 = move-exception
            boolean r7 = org.apache.xmlbeans.impl.values.XmlUnionImpl.$assertionsDisabled     // Catch: java.lang.Throwable -> L34
            if (r7 == 0) goto L5e
            goto L77
        L5e:
            java.lang.AssertionError r9 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L34
            java.lang.StringBuffer r10 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L34
            r10.<init>()     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = "Unexpected "
            java.lang.StringBuffer r10 = r10.append(r0)     // Catch: java.lang.Throwable -> L34
            java.lang.StringBuffer r10 = r10.append(r6)     // Catch: java.lang.Throwable -> L34
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L34
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L34
            throw r9     // Catch: java.lang.Throwable -> L34
        L77:
            int r5 = r5 + 1
            goto L37
        L7a:
            if (r4 != 0) goto L9a
        L7c:
            if (r1 == 0) goto L81
            org.apache.xmlbeans.impl.values.NamespaceContext.pop()
        L81:
            org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException r9 = new org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r10 = r10.toString()
            r0[r3] = r10
            org.apache.xmlbeans.SchemaType r10 = r8._schemaType
            java.lang.String r10 = org.apache.xmlbeans.impl.common.QNameHelper.readable(r10)
            r0[r2] = r10
            java.lang.String r10 = "cvc-datatype-valid.1.2.3"
            r9.<init>(r10, r0)
            throw r9
        L9a:
            r4 = r3
            goto L2b
        L9c:
            if (r1 == 0) goto La1
            org.apache.xmlbeans.impl.values.NamespaceContext.pop()
        La1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.values.XmlUnionImpl.set_primitive(int, java.lang.Object):void");
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_boolean(boolean z) {
        set_primitive(3, new Boolean(z));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_byte(byte b) {
        set_primitive(47, new Byte(b));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_short(short s) {
        set_primitive(47, new Short(s));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_int(int i) {
        set_primitive(47, new Integer(i));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_long(long j) {
        set_primitive(47, new Long(j));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_float(float f) {
        set_primitive(47, new Float(f));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_double(double d) {
        set_primitive(47, new Double(d));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_ByteArray(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_hex(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_b64(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigInteger(BigInteger bigInteger) {
        set_primitive(47, bigInteger);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigDecimal(BigDecimal bigDecimal) {
        set_primitive(47, bigDecimal);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_QName(QName qName) {
        set_primitive(7, qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_Calendar(Calendar calendar) {
        set_primitive(49, calendar);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_Date(Date date) {
        set_primitive(48, date);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDate(GDateSpecification gDateSpecification) {
        int builtinTypeCode = gDateSpecification.getBuiltinTypeCode();
        if (builtinTypeCode <= 0) {
            throw new XmlValueOutOfRangeException();
        }
        set_primitive(builtinTypeCode, gDateSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDuration(GDurationSpecification gDurationSpecification) {
        set_primitive(13, gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        set_primitive(12, stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_list(List list) {
        set_primitive(51, list);
    }

    protected void set_xmlfloat(XmlObject xmlObject) {
        set_primitive(9, xmlObject);
    }

    protected void set_xmldouble(XmlObject xmlObject) {
        set_primitive(10, xmlObject);
    }

    protected void set_xmldecimal(XmlObject xmlObject) {
        set_primitive(11, xmlObject);
    }

    protected void set_xmlduration(XmlObject xmlObject) {
        set_primitive(13, xmlObject);
    }

    protected void set_xmldatetime(XmlObject xmlObject) {
        set_primitive(14, xmlObject);
    }

    protected void set_xmltime(XmlObject xmlObject) {
        set_primitive(15, xmlObject);
    }

    protected void set_xmldate(XmlObject xmlObject) {
        set_primitive(16, xmlObject);
    }

    protected void set_xmlgyearmonth(XmlObject xmlObject) {
        set_primitive(17, xmlObject);
    }

    protected void set_xmlgyear(XmlObject xmlObject) {
        set_primitive(18, xmlObject);
    }

    protected void set_xmlgmonthday(XmlObject xmlObject) {
        set_primitive(19, xmlObject);
    }

    protected void set_xmlgday(XmlObject xmlObject) {
        set_primitive(20, xmlObject);
    }

    protected void set_xmlgmonth(XmlObject xmlObject) {
        set_primitive(21, xmlObject);
    }

    private static boolean check(XmlObject xmlObject, SchemaType schemaType) {
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues == null) {
            return true;
        }
        for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
            if (xmlAnySimpleType.valueEquals(xmlObject)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.valueEquals(xmlObject);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        try {
            check_dated();
            XmlTokenSource xmlTokenSource = this._value;
            if (xmlTokenSource == null) {
                validationContext.invalid(XmlErrorCodes.UNION, new Object[]{new StringBuffer().append("'").append(str).append("' does not match any of the member types for ").append(QNameHelper.readable(schemaType())).toString()});
            } else {
                ((XmlObjectBase) xmlTokenSource).validate_simpleval(str, validationContext);
            }
        } catch (Exception unused) {
            validationContext.invalid(XmlErrorCodes.UNION, new Object[]{new StringBuffer().append("'").append(str).append("' does not match any of the member types for ").append(QNameHelper.readable(schemaType())).toString()});
        }
    }
}
