package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;

@Internal
/* loaded from: classes4.dex */
class IndirectPropertyName {
    private CodePageString _value;

    IndirectPropertyName(byte[] bArr, int i) {
        this._value = new CodePageString(bArr, i);
    }

    int getSize() {
        return this._value.getSize();
    }
}
