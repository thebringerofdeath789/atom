package org.apache.xmlbeans.impl.values;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* loaded from: classes5.dex */
public abstract class JavaNotationHolderEx extends JavaNotationHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaNotationHolder, org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaNotationHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet()) {
            if (!check(str, this._schemaType)) {
                throw new XmlValueOutOfRangeException();
            }
            if (!this._schemaType.matchPatternFacet(str)) {
                throw new XmlValueOutOfRangeException();
            }
        }
        super.set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_notation(String str) {
        set_text(str);
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
            validateLexical = JavaNotationHolder.validateLexical(xmlAnySimpleType.getStringValue(), _voorVc, NamespaceContext.getCurrent());
        }
        super.set_QName(validateLexical);
    }

    public static QName validateLexical(String str, SchemaType schemaType, ValidationContext validationContext, PrefixResolver prefixResolver) {
        QName validateLexical = JavaQNameHolder.validateLexical(str, validationContext, prefixResolver);
        if (schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"NOTATION", str, QNameHelper.readable(schemaType)});
        }
        check(str, schemaType);
        return validateLexical;
    }

    private static boolean check(String str, SchemaType schemaType) {
        XmlTokenSource facet = schemaType.getFacet(0);
        if (facet != null) {
            if (str.length() == ((XmlObjectBase) facet).getBigIntegerValue().intValue()) {
                return false;
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(1);
        if (facet2 != null) {
            if (str.length() < ((XmlObjectBase) facet2).getBigIntegerValue().intValue()) {
                return false;
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(2);
        if (facet3 != null) {
            if (str.length() > ((XmlObjectBase) facet3).getBigIntegerValue().intValue()) {
                return false;
            }
        }
        return true;
    }

    public static void validateValue(QName qName, SchemaType schemaType, ValidationContext validationContext) {
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (qName.equals(((XmlObjectBase) obj).getQNameValue())) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"NOTATION", qName, QNameHelper.readable(schemaType)});
        }
    }
}
