package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewCommonSelectionViewBinding implements ViewBinding {
    public final RadioGroup rg;
    private final RelativeLayout rootView;

    private ViewCommonSelectionViewBinding(RelativeLayout relativeLayout, RadioGroup radioGroup) {
        this.rootView = relativeLayout;
        this.rg = radioGroup;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewCommonSelectionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCommonSelectionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_common_selection_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewCommonSelectionViewBinding bind(View view) {
        int i = R.id.rg;
        RadioGroup radioGroup = (RadioGroup) view.findViewById(i);
        if (radioGroup != null) {
            return new ViewCommonSelectionViewBinding((RelativeLayout) view, radioGroup);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}