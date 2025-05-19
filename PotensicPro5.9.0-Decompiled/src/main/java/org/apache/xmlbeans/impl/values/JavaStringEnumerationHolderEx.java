package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* loaded from: classes5.dex */
public abstract class JavaStringEnumerationHolderEx extends JavaStringHolderEx {
    private StringEnumAbstractBase _val;

    public JavaStringEnumerationHolderEx(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolderEx, org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        StringEnumAbstractBase enumForString = schemaType().enumForString(str);
        if (enumForString == null) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"string", str, QNameHelper.readable(schemaType())});
        }
        super.set_text(str);
        this._val = enumForString;
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaStringHolderEx.validateLexical(str, schemaType, validationContext);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._val = null;
        super.set_nil();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        return this._val;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        Class enumJavaClass = schemaType().getEnumJavaClass();
        if (enumJavaClass != null && !stringEnumAbstractBase.getClass().equals(enumJavaClass)) {
            throw new XmlValueOutOfRangeException();
        }
        super.set_text(stringEnumAbstractBase.toString());
        this._val = stringEnumAbstractBase;
    }
}
