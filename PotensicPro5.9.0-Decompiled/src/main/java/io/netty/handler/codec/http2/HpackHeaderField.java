package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
class HpackHeaderField {
    static final int HEADER_ENTRY_OVERHEAD = 32;
    final CharSequence name;
    final CharSequence value;

    static long sizeOf(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence.length() + charSequence2.length() + 32;
    }

    HpackHeaderField(CharSequence charSequence, CharSequence charSequence2) {
        this.name = (CharSequence) ObjectUtil.checkNotNull(charSequence, "name");
        this.value = (CharSequence) ObjectUtil.checkNotNull(charSequence2, "value");
    }

    final int size() {
        return this.name.length() + this.value.length() + 32;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HpackHeaderField)) {
            return false;
        }
        HpackHeaderField hpackHeaderField = (HpackHeaderField) obj;
        return (HpackUtil.equalsConstantTime(this.value, hpackHeaderField.value) & HpackUtil.equalsConstantTime(this.name, hpackHeaderField.name)) != 0;
    }

    public String toString() {
        return ((Object) this.name) + ": " + ((Object) this.value);
    }
}
