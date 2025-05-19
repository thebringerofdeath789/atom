package org.apache.xmlbeans.impl.values;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.HexBin;

/* loaded from: classes5.dex */
public abstract class JavaHexBinaryHolder extends XmlObjectBase {
    protected static MessageDigest md5;
    protected byte[] _value;
    protected boolean _hashcached = false;
    protected int hashcode = 0;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_HEX_BINARY;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return new String(HexBin.encode(this._value));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        this._hashcached = false;
        if (_validateOnSet()) {
            this._value = validateLexical(str, schemaType(), _voorVc);
        } else {
            this._value = lex(str, _voorVc);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._hashcached = false;
        this._value = null;
    }

    public static byte[] lex(String str, ValidationContext validationContext) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        byte[] decode = HexBin.decode(bArr);
        if (decode == null) {
            validationContext.invalid(XmlErrorCodes.HEXBINARY, new Object[]{"not encoded properly"});
        }
        return decode;
    }

    public static byte[] validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        byte[] lex = lex(str, validationContext);
        if (lex == null) {
            return null;
        }
        if (schemaType.matchPatternFacet(str)) {
            return lex;
        }
        validationContext.invalid(new StringBuffer().append("Hex encoded data does not match pattern for ").append(QNameHelper.readable(schemaType)).toString());
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        check_dated();
        byte[] bArr = this._value;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_ByteArray(byte[] bArr) {
        this._hashcached = false;
        byte[] bArr2 = new byte[bArr.length];
        this._value = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return Arrays.equals(this._value, ((XmlHexBinary) xmlObject).getByteArrayValue());
    }

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Cannot find MD5 hash Algorithm");
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        if (this._hashcached) {
            return this.hashcode;
        }
        this._hashcached = true;
        byte[] bArr = this._value;
        if (bArr == null) {
            this.hashcode = 0;
            return 0;
        }
        byte[] digest = md5.digest(bArr);
        int i = ((digest[0] << (digest[1] + 24)) << (digest[2] + 16)) << (digest[3] + 8);
        this.hashcode = i;
        return i;
    }
}
