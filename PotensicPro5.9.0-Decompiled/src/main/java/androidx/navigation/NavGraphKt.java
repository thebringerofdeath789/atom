package androidx.navigation;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavGraph.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u001a\u0017\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0086\n¨\u0006\f"}, d2 = {"contains", "", "Landroidx/navigation/NavGraph;", TtmlNode.ATTR_ID, "", "get", "Landroidx/navigation/NavDestination;", "minusAssign", "", "node", "plusAssign", "other", "navigation-common-ktx_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class NavGraphKt {
    public static final NavDestination get(NavGraph receiver$0, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        NavDestination findNode = receiver$0.findNode(i);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + i + " was found in " + receiver$0);
    }

    public static final boolean contains(NavGraph receiver$0, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.findNode(i) != null;
    }

    public static final void plusAssign(NavGraph receiver$0, NavDestination node) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(node, "node");
        receiver$0.addDestination(node);
    }

    public static final void plusAssign(NavGraph receiver$0, NavGraph other) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(other, "other");
        receiver$0.addAll(other);
    }

    public static final void minusAssign(NavGraph receiver$0, NavDestination node) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(node, "node");
        receiver$0.remove(node);
    }
}
