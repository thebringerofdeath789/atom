package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* loaded from: classes5.dex */
public abstract class JavaFloatHolderEx extends JavaFloatHolder {
    private SchemaType _schemaType;

    public JavaFloatHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_float(float f) {
        if (_validateOnSet()) {
            validateValue(f, this._schemaType, _voorVc);
        }
        super.set_float(f);
    }

    public static float validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        float validateLexical = JavaFloatHolder.validateLexical(str, validationContext);
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.FLOAT, str, QNameHelper.readable(schemaType)});
        }
        return validateLexical;
    }

    public static void validateValue(float f, SchemaType schemaType, ValidationContext validationContext) {
        XmlTokenSource facet = schemaType.getFacet(3);
        if (facet != null) {
            float floatValue = ((XmlObjectBase) facet).floatValue();
            if (compare(f, floatValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.FLOAT, new Float(f), new Float(floatValue), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            float floatValue2 = ((XmlObjectBase) facet2).floatValue();
            if (compare(f, floatValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.FLOAT, new Float(f), new Float(floatValue2), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(5);
        if (facet3 != null) {
            float floatValue3 = ((XmlObjectBase) facet3).floatValue();
            if (compare(f, floatValue3) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.FLOAT, new Float(f), new Float(floatValue3), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            float floatValue4 = ((XmlObjectBase) facet4).floatValue();
            if (compare(f, floatValue4) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.FLOAT, new Float(f), new Float(floatValue4), QNameHelper.readable(schemaType)});
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (compare(f, ((XmlObjectBase) obj).floatValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.FLOAT, new Float(f), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(floatValue(), schemaType(), validationContext);
    }
}
