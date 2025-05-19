package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* loaded from: classes5.dex */
public abstract class JavaIntegerHolder extends XmlObjectBase {
    private static BigInteger _maxlong = BigInteger.valueOf(Long.MAX_VALUE);
    private static BigInteger _minlong = BigInteger.valueOf(Long.MIN_VALUE);
    private BigInteger _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_INTEGER;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return this._value.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        set_BigInteger(lex(str, _voorVc));
    }

    public static BigInteger lex(String str, ValidationContext validationContext) {
        if (str.length() > 0 && str.charAt(0) == '+') {
            str = str.substring(1);
        }
        try {
            return new BigInteger(str);
        } catch (Exception unused) {
            validationContext.invalid(XmlErrorCodes.INTEGER, new Object[]{str});
            return null;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        if (this._value == null) {
            return null;
        }
        return new BigDecimal(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigDecimal(BigDecimal bigDecimal) {
        this._value = bigDecimal.toBigInteger();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigInteger(BigInteger bigInteger) {
        this._value = bigInteger;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        if (((SimpleValue) xmlObject).instanceType().getDecimalSize() > 1000000) {
            return -xmlObject.compareTo(this);
        }
        return this._value.compareTo(((XmlObjectBase) xmlObject).bigIntegerValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        if (((SimpleValue) xmlObject).instanceType().getDecimalSize() > 1000000) {
            return xmlObject.valueEquals(this);
        }
        return this._value.equals(((XmlObjectBase) xmlObject).bigIntegerValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        if (this._value.compareTo(_maxlong) > 0 || this._value.compareTo(_minlong) < 0) {
            return this._value.hashCode();
        }
        long longValue = this._value.longValue();
        return (int) (((longValue >> 32) * 19) + longValue);
    }
}
