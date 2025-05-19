package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* loaded from: classes5.dex */
public abstract class JavaUriHolder extends XmlObjectBase {
    private String _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_ANY_URI;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        String str = this._value;
        return str == null ? "" : str;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet()) {
            validateLexical(str, _voorVc);
        }
        this._value = str;
    }

    public static void validateLexical(String str, ValidationContext validationContext) {
        if (str.startsWith("##")) {
            validationContext.invalid(XmlErrorCodes.ANYURI, new Object[]{str});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlAnyURI) xmlObject).getStringValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }
}
