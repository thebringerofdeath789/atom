package org.apache.xmlbeans.impl.values;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* loaded from: classes5.dex */
public abstract class JavaBooleanHolder extends XmlObjectBase {
    private boolean _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_BOOLEAN;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return this._value ? BooleanUtils.TRUE : "false";
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        this._value = validateLexical(str, _voorVc);
    }

    public static boolean validateLexical(String str, ValidationContext validationContext) {
        if (str.equals(BooleanUtils.TRUE) || str.equals("1")) {
            return true;
        }
        if (!str.equals("false") && !str.equals(SessionDescription.SUPPORTED_SDP_VERSION)) {
            validationContext.invalid(XmlErrorCodes.BOOLEAN, new Object[]{str});
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_boolean(boolean z) {
        this._value = z;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        return this._value == ((XmlBoolean) xmlObject).getBooleanValue() ? 0 : 2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value == ((XmlBoolean) xmlObject).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value ? 957379554 : 676335975;
    }
}
