package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* loaded from: classes5.dex */
public abstract class JavaDoubleHolderEx extends JavaDoubleHolder {
    private SchemaType _schemaType;

    public JavaDoubleHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDoubleHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDoubleHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_double(double d) {
        if (_validateOnSet()) {
            validateValue(d, this._schemaType, _voorVc);
        }
        super.set_double(d);
    }

    public static double validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        double validateLexical = JavaDoubleHolder.validateLexical(str, validationContext);
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.DOUBLE, str, QNameHelper.readable(schemaType)});
        }
        return validateLexical;
    }

    public static void validateValue(double d, SchemaType schemaType, ValidationContext validationContext) {
        XmlTokenSource facet = schemaType.getFacet(3);
        if (facet != null) {
            double doubleValue = ((XmlObjectBase) facet).doubleValue();
            if (compare(d, doubleValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), new Double(doubleValue), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            double doubleValue2 = ((XmlObjectBase) facet2).doubleValue();
            if (compare(d, doubleValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), new Double(doubleValue2), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(5);
        if (facet3 != null) {
            double doubleValue3 = ((XmlObjectBase) facet3).doubleValue();
            if (compare(d, doubleValue3) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), new Double(doubleValue3), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            double doubleValue4 = ((XmlObjectBase) facet4).doubleValue();
            if (compare(d, doubleValue4) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), new Double(doubleValue4), QNameHelper.readable(schemaType)});
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (compare(d, ((XmlObjectBase) obj).doubleValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.DOUBLE, new Double(d), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(doubleValue(), schemaType(), validationContext);
    }
}
