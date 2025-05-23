package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PorterDuff.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0086\b¨\u0006\u0007"}, m2338d2 = {"toColorFilter", "Landroid/graphics/PorterDuffColorFilter;", "Landroid/graphics/PorterDuff$Mode;", TtmlNode.ATTR_TTS_COLOR, "", "toXfermode", "Landroid/graphics/PorterDuffXfermode;", "core-ktx_release"}, m2339k = 2, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class PorterDuffKt {
    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode toXfermode) {
        Intrinsics.checkParameterIsNotNull(toXfermode, "$this$toXfermode");
        return new PorterDuffXfermode(toXfermode);
    }

    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode toColorFilter, int i) {
        Intrinsics.checkParameterIsNotNull(toColorFilter, "$this$toColorFilter");
        return new PorterDuffColorFilter(i, toColorFilter);
    }
}