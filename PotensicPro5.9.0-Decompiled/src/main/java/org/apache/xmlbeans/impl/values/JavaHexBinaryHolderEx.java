package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* loaded from: classes5.dex */
public abstract class JavaHexBinaryHolderEx extends JavaHexBinaryHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaHexBinaryHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        byte[] lex;
        if (_validateOnSet()) {
            lex = validateLexical(str, schemaType(), _voorVc);
        } else {
            lex = lex(str, _voorVc);
        }
        if (_validateOnSet() && lex != null) {
            validateValue(lex, schemaType(), XmlObjectBase._voorVc);
        }
        super.set_ByteArray(lex);
        this._value = lex;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_ByteArray(byte[] bArr) {
        if (_validateOnSet()) {
            validateValue(bArr, schemaType(), _voorVc);
        }
        super.set_ByteArray(bArr);
    }

    public static void validateValue(byte[] bArr, SchemaType schemaType, ValidationContext validationContext) {
        int intValue;
        int intValue2;
        int intValue3;
        XmlTokenSource facet = schemaType.getFacet(0);
        if (facet != null && (intValue3 = ((XmlObjectBase) facet).bigIntegerValue().intValue()) != bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.HEXBINARY, new Integer(bArr.length), new Integer(intValue3), QNameHelper.readable(schemaType)});
        }
        XmlTokenSource facet2 = schemaType.getFacet(1);
        if (facet2 != null && (intValue2 = ((XmlObjectBase) facet2).bigIntegerValue().intValue()) > bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.HEXBINARY, new Integer(bArr.length), new Integer(intValue2), QNameHelper.readable(schemaType)});
        }
        XmlTokenSource facet3 = schemaType.getFacet(2);
        if (facet3 != null && (intValue = ((XmlObjectBase) facet3).bigIntegerValue().intValue()) < bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.HEXBINARY, new Integer(bArr.length), new Integer(intValue), QNameHelper.readable(schemaType)});
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            int i = 0;
            loop0: while (i < enumerationValues.length) {
                byte[] byteArrayValue = ((XmlObjectBase) enumerationValues[i]).byteArrayValue();
                if (byteArrayValue.length == bArr.length) {
                    for (int i2 = 0; i2 < byteArrayValue.length; i2++) {
                        if (byteArrayValue[i2] != bArr[i2]) {
                            break;
                        }
                    }
                    break loop0;
                }
                i++;
            }
            if (i >= enumerationValues.length) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID$NO_VALUE, new Object[]{XmlErrorCodes.HEXBINARY, QNameHelper.readable(schemaType)});
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(byteArrayValue(), schemaType(), validationContext);
    }
}
