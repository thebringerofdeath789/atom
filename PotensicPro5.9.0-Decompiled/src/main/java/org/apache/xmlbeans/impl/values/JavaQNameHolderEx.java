package org.apache.xmlbeans.impl.values;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* loaded from: classes5.dex */
public abstract class JavaQNameHolderEx extends JavaQNameHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaQNameHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        QName validateLexical;
        PrefixResolver current = NamespaceContext.getCurrent();
        if (current == null && has_store()) {
            current = get_store();
        }
        if (_validateOnSet()) {
            validateLexical = validateLexical(str, this._schemaType, _voorVc, current);
            if (validateLexical != null) {
                validateValue(validateLexical, this._schemaType, _voorVc);
            }
        } else {
            validateLexical = JavaQNameHolder.validateLexical(str, _voorVc, current);
        }
        super.set_QName(validateLexical);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_QName(QName qName) {
        if (_validateOnSet()) {
            validateValue(qName, this._schemaType, _voorVc);
        }
        super.set_QName(qName);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        QName validateLexical;
        if (_validateOnSet()) {
            validateLexical = validateLexical(xmlAnySimpleType.getStringValue(), this._schemaType, _voorVc, NamespaceContext.getCurrent());
            if (validateLexical != null) {
                validateValue(validateLexical, this._schemaType, _voorVc);
            }
        } else {
            validateLexical = JavaQNameHolder.validateLexical(xmlAnySimpleType.getStringValue(), _voorVc, NamespaceContext.getCurrent());
        }
        super.set_QName(validateLexical);
    }

    public static QName validateLexical(String str, SchemaType schemaType, ValidationContext validationContext, PrefixResolver prefixResolver) {
        QName validateLexical = JavaQNameHolder.validateLexical(str, validationContext, prefixResolver);
        if (schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.QNAME, str, QNameHelper.readable(schemaType)});
        }
        return validateLexical;
    }

    public static void validateValue(QName qName, SchemaType schemaType, ValidationContext validationContext) {
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (qName.equals(((XmlObjectBase) obj).getQNameValue())) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.QNAME, qName, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateValue(getQNameValue(), schemaType(), validationContext);
    }
}
