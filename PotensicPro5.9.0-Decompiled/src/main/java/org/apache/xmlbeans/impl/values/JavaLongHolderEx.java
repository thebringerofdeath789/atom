package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* loaded from: classes5.dex */
public abstract class JavaLongHolderEx extends JavaLongHolder {
    private SchemaType _schemaType;

    public JavaLongHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        try {
            long lexLong = XsTypeConverter.lexLong(str);
            if (_validateOnSet()) {
                validateValue(lexLong, this._schemaType, _voorVc);
                validateLexical(str, this._schemaType, _voorVc);
            }
            super.set_long(lexLong);
        } catch (Exception unused) {
            throw new XmlValueOutOfRangeException();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_long(long j) {
        if (_validateOnSet()) {
            validateValue(j, this._schemaType, _voorVc);
        }
        super.set_long(j);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.LONG, str, QNameHelper.readable(schemaType)});
    }

    private static void validateValue(long j, SchemaType schemaType, ValidationContext validationContext) {
        XmlAnySimpleType facet = schemaType.getFacet(7);
        if (facet != null) {
            long longValue = getLongValue(facet);
            String l = Long.toString(j);
            int length = l.length();
            if (length > 0 && l.charAt(0) == '-') {
                length--;
            }
            if (length > longValue) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_TOTAL_DIGITS_VALID, new Object[]{new Integer(length), l, new Long(longValue), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(3);
        if (facet2 != null) {
            long longValue2 = getLongValue(facet2);
            if (j <= longValue2) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.LONG, new Long(j), new Long(longValue2), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(4);
        if (facet3 != null) {
            long longValue3 = getLongValue(facet3);
            if (j < longValue3) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.LONG, new Long(j), new Long(longValue3), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            long longValue4 = getLongValue(facet4);
            if (j > longValue4) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.LONG, new Long(j), new Long(longValue4), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet5 = schemaType.getFacet(6);
        if (facet5 != null) {
            long longValue5 = getLongValue(facet5);
            if (j >= longValue5) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.LONG, new Long(j), new Long(longValue5), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                if (j == getLongValue(xmlAnySimpleType)) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.LONG, new Long(j), QNameHelper.readable(schemaType)});
        }
    }

    private static long getLongValue(XmlObject xmlObject) {
        SchemaType schemaType = xmlObject.schemaType();
        int decimalSize = schemaType.getDecimalSize();
        if (decimalSize != 64) {
            switch (decimalSize) {
                case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                    return ((XmlObjectBase) xmlObject).getBigIntegerValue().longValue();
                case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                    return ((XmlObjectBase) xmlObject).getBigDecimalValue().longValue();
                default:
                    throw new IllegalStateException(new StringBuffer().append("Bad facet type: ").append(schemaType).toString());
            }
        }
        return ((XmlObjectBase) xmlObject).getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getLongValue(), schemaType(), validationContext);
    }
}
