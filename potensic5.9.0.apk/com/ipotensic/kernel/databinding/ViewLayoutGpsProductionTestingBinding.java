package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutGpsProductionTestingBinding implements ViewBinding {
    public final Button btnModel;
    public final RelativeLayout layoutDetail;
    public final ConstraintLayout layoutGpsProductionTesting;
    private final ConstraintLayout rootView;
    public final TextView tvState;

    private ViewLayoutGpsProductionTestingBinding(ConstraintLayout constraintLayout, Button button, RelativeLayout relativeLayout, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.btnModel = button;
        this.layoutDetail = relativeLayout;
        this.layoutGpsProductionTesting = constraintLayout2;
        this.tvState = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutGpsProductionTestingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutGpsProductionTestingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_gps_production_testing, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutGpsProductionTestingBinding bind(View view) {
        int i = C1965R.id.btn_model;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.layout_detail;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
            if (relativeLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = C1965R.id.tv_state;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    return new ViewLayoutGpsProductionTestingBinding(constraintLayout, button, relativeLayout, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}