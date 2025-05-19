package defpackage;

import java.util.Objects;

/* renamed from: $r8$backportedMethods$utility$String$2$joinArray, reason: invalid class name */
/* loaded from: classes.dex */
public /* synthetic */ class C$r8$backportedMethods$utility$String$2$joinArray {
    public static /* synthetic */ String join(CharSequence charSequence, CharSequence[] charSequenceArr) {
        Objects.requireNonNull(charSequence, "delimiter");
        StringBuilder sb = new StringBuilder();
        if (charSequenceArr.length > 0) {
            sb.append(charSequenceArr[0]);
            for (int i = 1; i < charSequenceArr.length; i++) {
                sb.append(charSequence);
                sb.append(charSequenceArr[i]);
            }
        }
        return sb.toString();
    }
}
