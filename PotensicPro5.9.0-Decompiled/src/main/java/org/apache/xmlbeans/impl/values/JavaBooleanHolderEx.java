package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* loaded from: classes5.dex */
public abstract class JavaBooleanHolderEx extends JavaBooleanHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaBooleanHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public static boolean validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        boolean validateLexical = JavaBooleanHolder.validateLexical(str, validationContext);
        validatePattern(str, schemaType, validationContext);
        return validateLexical;
    }

    public static void validatePattern(String str, SchemaType schemaType, ValidationContext validationContext) {
        if (schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.BOOLEAN, str, QNameHelper.readable(schemaType)});
    }

    public JavaBooleanHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBooleanHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet()) {
            validatePattern(str, this._schemaType, _voorVc);
        }
        super.set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
    }
}
