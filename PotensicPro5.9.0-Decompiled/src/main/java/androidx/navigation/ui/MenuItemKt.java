package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MenuItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"onNavDestinationSelected", "", "Landroid/view/MenuItem;", "navController", "Landroidx/navigation/NavController;", "navigation-ui-ktx_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class MenuItemKt {
    public static final boolean onNavDestinationSelected(MenuItem receiver$0, NavController navController) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        return NavigationUI.onNavDestinationSelected(receiver$0, navController);
    }
}
