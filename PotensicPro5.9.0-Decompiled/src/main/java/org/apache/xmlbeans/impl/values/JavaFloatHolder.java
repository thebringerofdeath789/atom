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
public abstract class JavaFloatHolder extends XmlObjectBase {
    private float _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_FLOAT;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return serialize(this._value);
    }

    public static String serialize(float f) {
        return f == Float.POSITIVE_INFINITY ? "INF" : f == Float.NEGATIVE_INFINITY ? "-INF" : f == Float.NaN ? "NaN" : Float.toString(f);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        set_float(validateLexical(str, _voorVc));
    }

    public static float validateLexical(String str, ValidationContext validationContext) {
        try {
            return XsTypeConverter.lexFloat(str);
        } catch (NumberFormatException unused) {
            validationContext.invalid(XmlErrorCodes.FLOAT, new Object[]{str});
            return Float.NaN;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = 0.0f;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return new BigDecimal(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_double(double d) {
        set_float((float) d);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_float(float f) {
        this._value = f;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_long(long j) {
        set_float(j);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigDecimal(BigDecimal bigDecimal) {
        set_float(bigDecimal.floatValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigInteger(BigInteger bigInteger) {
        set_float(bigInteger.floatValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        return compare(this._value, ((XmlObjectBase) xmlObject).floatValue());
    }

    static int compare(float f, float f2) {
        if (f < f2) {
            return -1;
        }
        if (f > f2) {
            return 1;
        }
        int floatToIntBits = Float.floatToIntBits(f);
        int floatToIntBits2 = Float.floatToIntBits(f2);
        if (floatToIntBits == floatToIntBits2) {
            return 0;
        }
        return floatToIntBits < floatToIntBits2 ? -1 : 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return compare(this._value, ((XmlObjectBase) xmlObject).floatValue()) == 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return Float.floatToIntBits(this._value);
    }
}
