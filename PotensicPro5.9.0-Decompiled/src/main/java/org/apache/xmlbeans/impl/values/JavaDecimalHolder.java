package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* loaded from: classes5.dex */
public class JavaDecimalHolder extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static BigInteger _maxlong;
    private static BigInteger _minlong;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$JavaDecimalHolder;
    private BigDecimal _value;

    static {
        if (class$org$apache$xmlbeans$impl$values$JavaDecimalHolder == null) {
            class$org$apache$xmlbeans$impl$values$JavaDecimalHolder = class$("org.apache.xmlbeans.impl.values.JavaDecimalHolder");
        }
        $assertionsDisabled = true;
        _maxlong = BigInteger.valueOf(Long.MAX_VALUE);
        _minlong = BigInteger.valueOf(Long.MIN_VALUE);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_DECIMAL;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return XsTypeConverter.printDecimal(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet()) {
            validateLexical(str, _voorVc);
        }
        try {
            set_BigDecimal(new BigDecimal(str));
        } catch (NumberFormatException unused) {
            _voorVc.invalid(XmlErrorCodes.DECIMAL, new Object[]{str});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    public static void validateLexical(String str, ValidationContext validationContext) {
        char charAt;
        int length = str.length();
        boolean z = false;
        boolean z2 = false;
        for (int i = (length <= 0 || !((charAt = str.charAt(0)) == '+' || charAt == '-')) ? 0 : 1; i < length; i++) {
            char charAt2 = str.charAt(i);
            if (charAt2 == '.') {
                if (z2) {
                    validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{new StringBuffer().append("saw '.' more than once: ").append(str).toString()});
                    return;
                }
                z2 = true;
            } else {
                if (charAt2 < '0' || charAt2 > '9') {
                    validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{new StringBuffer().append("unexpected char '").append((int) charAt2).append("'").toString()});
                    return;
                }
                z = true;
            }
        }
        if (z) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{"expected at least one digit"});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigDecimal(BigDecimal bigDecimal) {
        this._value = bigDecimal;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        return this._value.compareTo(((XmlObjectBase) xmlObject).bigDecimalValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.compareTo(((XmlObjectBase) xmlObject).bigDecimalValue()) == 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        if (this._value.scale() > 0 && this._value.setScale(0, 1).compareTo(this._value) != 0) {
            return decimalHashCode();
        }
        BigInteger bigInteger = this._value.toBigInteger();
        if (bigInteger.compareTo(_maxlong) > 0 || bigInteger.compareTo(_minlong) < 0) {
            return bigInteger.hashCode();
        }
        long longValue = bigInteger.longValue();
        return (int) (((longValue >> 32) * 19) + longValue);
    }

    protected int decimalHashCode() {
        if (!$assertionsDisabled && this._value.scale() <= 0) {
            throw new AssertionError();
        }
        String bigDecimal = this._value.toString();
        int length = bigDecimal.length() - 1;
        while (length >= 0 && bigDecimal.charAt(length) == '0') {
            length--;
        }
        if ($assertionsDisabled || bigDecimal.indexOf(46) < length) {
            return bigDecimal.substring(0, length + 1).hashCode();
        }
        throw new AssertionError();
    }
}
