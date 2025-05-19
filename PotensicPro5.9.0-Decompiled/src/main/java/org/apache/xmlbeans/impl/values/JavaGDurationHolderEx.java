package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* loaded from: classes5.dex */
public abstract class JavaGDurationHolderEx extends XmlObjectBase {
    private SchemaType _schemaType;
    GDuration _value;

    public JavaGDurationHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        GDuration lex;
        if (_validateOnSet()) {
            lex = validateLexical(str, this._schemaType, _voorVc);
        } else {
            lex = lex(str, _voorVc);
        }
        if (_validateOnSet() && lex != null) {
            validateValue(lex, this._schemaType, _voorVc);
        }
        this._value = lex;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDuration(GDurationSpecification gDurationSpecification) {
        if (_validateOnSet()) {
            validateValue(gDurationSpecification, this._schemaType, _voorVc);
        }
        if (gDurationSpecification.isImmutable() && (gDurationSpecification instanceof GDuration)) {
            this._value = (GDuration) gDurationSpecification;
        } else {
            this._value = new GDuration(gDurationSpecification);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        GDuration gDuration = this._value;
        return gDuration == null ? "" : gDuration.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        check_dated();
        GDuration gDuration = this._value;
        if (gDuration == null) {
            return null;
        }
        return gDuration;
    }

    public static GDuration lex(String str, ValidationContext validationContext) {
        try {
            return new GDuration(str);
        } catch (Exception unused) {
            validationContext.invalid("duration", new Object[]{str});
            return null;
        }
    }

    public static GDuration validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        GDuration lex = lex(str, validationContext);
        if (lex != null && schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"duration", str, QNameHelper.readable(schemaType)});
        }
        return lex;
    }

    public static void validateValue(GDurationSpecification gDurationSpecification, SchemaType schemaType, ValidationContext validationContext) {
        XmlTokenSource facet = schemaType.getFacet(3);
        if (facet != null) {
            GDuration gDurationValue = ((XmlObjectBase) facet).gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{"duration", gDurationSpecification, gDurationValue, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            GDuration gDurationValue2 = ((XmlObjectBase) facet2).gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{"duration", gDurationSpecification, gDurationValue2, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(6);
        if (facet3 != null) {
            GDuration gDurationValue3 = ((XmlObjectBase) facet3).gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationValue3) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{"duration", gDurationSpecification, gDurationValue3, QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            GDuration gDurationValue4 = ((XmlObjectBase) facet4).gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationValue4) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{"duration", gDurationSpecification, gDurationValue4, QNameHelper.readable(schemaType)});
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (gDurationSpecification.compareToGDuration(((XmlObjectBase) obj).gDurationValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"duration", gDurationSpecification, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        return this._value.compareToGDuration(((XmlObjectBase) xmlObject).gDurationValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).gDurationValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(gDurationValue(), schemaType(), validationContext);
    }
}
