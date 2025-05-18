package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewDialogAppLogBinding implements ViewBinding {
    public final ImageButton btnBack;
    public final Button btnSelect;
    public final Button btnShare;
    public final LinearLayout layoutButton;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private ViewDialogAppLogBinding(ConstraintLayout constraintLayout, ImageButton imageButton, Button button, Button button2, LinearLayout linearLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.btnBack = imageButton;
        this.btnSelect = button;
        this.btnShare = button2;
        this.layoutButton = linearLayout;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogAppLogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogAppLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_dialog_app_log, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogAppLogBinding bind(View view) {
        int i = C2640R.id.btnBack;
        ImageButton imageButton = (ImageButton) view.findViewById(C2640R.id.btnBack);
        if (imageButton != null) {
            i = C2640R.id.btnSelect;
            Button button = (Button) view.findViewById(C2640R.id.btnSelect);
            if (button != null) {
                i = C2640R.id.btnShare;
                Button button2 = (Button) view.findViewById(C2640R.id.btnShare);
                if (button2 != null) {
                    i = C2640R.id.layout_button;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C2640R.id.layout_button);
                    if (linearLayout != null) {
                        i = C2640R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(C2640R.id.recyclerView);
                        if (recyclerView != null) {
                            return new ViewDialogAppLogBinding((ConstraintLayout) view, imageButton, button, button2, linearLayout, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}