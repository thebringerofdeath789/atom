package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityDebugBinding implements ViewBinding {
    public final Button btnAppLog;
    public final ImageButton btnBack;
    private final ConstraintLayout rootView;

    private ActivityDebugBinding(ConstraintLayout constraintLayout, Button button, ImageButton imageButton) {
        this.rootView = constraintLayout;
        this.btnAppLog = button;
        this.btnBack = imageButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDebugBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDebugBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_debug, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDebugBinding bind(View view) {
        int i = R.id.btnAppLog;
        Button button = (Button) view.findViewById(R.id.btnAppLog);
        if (button != null) {
            i = R.id.btnBack;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            if (imageButton != null) {
                return new ActivityDebugBinding((ConstraintLayout) view, button, imageButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}