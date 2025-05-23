package androidx.navigation.ui;

import androidx.navigation.NavController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomNavigationView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"setupWithNavController", "", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "navController", "Landroidx/navigation/NavController;", "navigation-ui-ktx_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class BottomNavigationViewKt {
    public static final void setupWithNavController(BottomNavigationView receiver$0, NavController navController) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        NavigationUI.setupWithNavController(receiver$0, navController);
    }
}
