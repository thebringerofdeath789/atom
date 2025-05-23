package kotlinx.coroutines.internal;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.mapbox.mapboxsdk.style.layers.Property;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArrayCopy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001aI\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"arraycopy", "", "E", Property.SYMBOL_Z_ORDER_SOURCE, "", "srcPos", "", RtspHeaders.Values.DESTINATION, "destinationStart", SessionDescription.ATTR_LENGTH, "([Ljava/lang/Object;I[Ljava/lang/Object;II)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class ArrayCopyKt {
    public static final <E> void arraycopy(E[] source, int i, E[] destination, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        System.arraycopy(source, i, destination, i2, i3);
    }
}
