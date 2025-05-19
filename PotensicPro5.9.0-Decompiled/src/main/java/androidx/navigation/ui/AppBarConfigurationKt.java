package androidx.navigation.ui;

import android.view.Menu;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppBarConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\b\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\b\u001a3\u0010\u0000\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\b¨\u0006\u000e"}, d2 = {"AppBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "topLevelMenu", "Landroid/view/Menu;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "fallbackOnNavigateUpListener", "Lkotlin/Function0;", "", "navGraph", "Landroidx/navigation/NavGraph;", "topLevelDestinationIds", "", "", "navigation-ui-ktx_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class AppBarConfigurationKt {
    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(NavGraph navGraph, DrawerLayout drawerLayout, Function0 fallbackOnNavigateUpListener, int i, Object obj) {
        if ((i & 2) != 0) {
            drawerLayout = (DrawerLayout) null;
        }
        if ((i & 4) != 0) {
            fallbackOnNavigateUpListener = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(navGraph, "navGraph");
        Intrinsics.checkParameterIsNotNull(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(navGraph).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static final AppBarConfiguration AppBarConfiguration(NavGraph navGraph, DrawerLayout drawerLayout, Function0<Boolean> fallbackOnNavigateUpListener) {
        Intrinsics.checkParameterIsNotNull(navGraph, "navGraph");
        Intrinsics.checkParameterIsNotNull(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(navGraph).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Menu topLevelMenu, DrawerLayout drawerLayout, Function0 fallbackOnNavigateUpListener, int i, Object obj) {
        if ((i & 2) != 0) {
            drawerLayout = (DrawerLayout) null;
        }
        if ((i & 4) != 0) {
            fallbackOnNavigateUpListener = new Function0<Boolean>() { // from class: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    return false;
                }
            };
        }
        Intrinsics.checkParameterIsNotNull(topLevelMenu, "topLevelMenu");
        Intrinsics.checkParameterIsNotNull(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(topLevelMenu).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static final AppBarConfiguration AppBarConfiguration(Menu topLevelMenu, DrawerLayout drawerLayout, Function0<Boolean> fallbackOnNavigateUpListener) {
        Intrinsics.checkParameterIsNotNull(topLevelMenu, "topLevelMenu");
        Intrinsics.checkParameterIsNotNull(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(topLevelMenu).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Set topLevelDestinationIds, DrawerLayout drawerLayout, Function0 fallbackOnNavigateUpListener, int i, Object obj) {
        if ((i & 2) != 0) {
            drawerLayout = (DrawerLayout) null;
        }
        if ((i & 4) != 0) {
            fallbackOnNavigateUpListener = new Function0<Boolean>() { // from class: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    return false;
                }
            };
        }
        Intrinsics.checkParameterIsNotNull(topLevelDestinationIds, "topLevelDestinationIds");
        Intrinsics.checkParameterIsNotNull(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder((Set<Integer>) topLevelDestinationIds).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static final AppBarConfiguration AppBarConfiguration(Set<Integer> topLevelDestinationIds, DrawerLayout drawerLayout, Function0<Boolean> fallbackOnNavigateUpListener) {
        Intrinsics.checkParameterIsNotNull(topLevelDestinationIds, "topLevelDestinationIds");
        Intrinsics.checkParameterIsNotNull(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(topLevelDestinationIds).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }
}
