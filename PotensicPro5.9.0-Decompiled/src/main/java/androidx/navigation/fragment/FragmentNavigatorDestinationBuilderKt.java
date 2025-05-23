package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: FragmentNavigatorDestinationBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a<\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0086\b¨\u0006\u000b"}, d2 = {"fragment", "", "F", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavGraphBuilder;", TtmlNode.ATTR_ID, "", "builder", "Lkotlin/Function1;", "Landroidx/navigation/fragment/FragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class FragmentNavigatorDestinationBuilderKt {
    private static final <F extends Fragment> void fragment(NavGraphBuilder navGraphBuilder, int i, Function1<? super FragmentNavigatorDestinationBuilder, Unit> function1) {
        Navigator navigator = navGraphBuilder.getProvider().getNavigator((Class<Navigator>) FragmentNavigator.class);
        Intrinsics.checkExpressionValueIsNotNull(navigator, "getNavigator(clazz.java)");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navigator, i, Reflection.getOrCreateKotlinClass(Fragment.class));
        function1.invoke(fragmentNavigatorDestinationBuilder);
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder);
    }

    private static final <F extends Fragment> void fragment(NavGraphBuilder navGraphBuilder, int i) {
        Navigator navigator = navGraphBuilder.getProvider().getNavigator((Class<Navigator>) FragmentNavigator.class);
        Intrinsics.checkExpressionValueIsNotNull(navigator, "getNavigator(clazz.java)");
        Intrinsics.reifiedOperationMarker(4, "F");
        navGraphBuilder.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) navigator, i, Reflection.getOrCreateKotlinClass(Fragment.class)));
    }
}
