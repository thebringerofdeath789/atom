package androidx.navigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m2338d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/view/View;", "navigation-runtime-ktx_release"}, m2339k = 2, m2340mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class ViewKt {
    public static final NavController findNavController(View receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        NavController findNavController = Navigation.findNavController(receiver$0);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavController(this)");
        return findNavController;
    }
}