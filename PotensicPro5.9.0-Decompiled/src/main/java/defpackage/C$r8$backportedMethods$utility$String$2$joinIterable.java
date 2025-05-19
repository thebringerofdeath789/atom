package defpackage;

import java.util.Iterator;
import java.util.Objects;

/* renamed from: $r8$backportedMethods$utility$String$2$joinIterable, reason: invalid class name */
/* loaded from: classes.dex */
public /* synthetic */ class C$r8$backportedMethods$utility$String$2$joinIterable {
    public static /* synthetic */ String join(CharSequence charSequence, Iterable iterable) {
        Objects.requireNonNull(charSequence, "delimiter");
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append(charSequence);
            }
        }
        return sb.toString();
    }
}
