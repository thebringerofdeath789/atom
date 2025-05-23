package androidx.savedstate;

import android.view.View;

/* loaded from: classes.dex */
public final class ViewTreeSavedStateRegistryOwner {
    private ViewTreeSavedStateRegistryOwner() {
    }

    public static void set(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        view.setTag(C0496R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }

    public static SavedStateRegistryOwner get(View view) {
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) view.getTag(C0496R.id.view_tree_saved_state_registry_owner);
        if (savedStateRegistryOwner != null) {
            return savedStateRegistryOwner;
        }
        Object parent = view.getParent();
        while (savedStateRegistryOwner == null && (parent instanceof View)) {
            View view2 = (View) parent;
            savedStateRegistryOwner = (SavedStateRegistryOwner) view2.getTag(C0496R.id.view_tree_saved_state_registry_owner);
            parent = view2.getParent();
        }
        return savedStateRegistryOwner;
    }
}