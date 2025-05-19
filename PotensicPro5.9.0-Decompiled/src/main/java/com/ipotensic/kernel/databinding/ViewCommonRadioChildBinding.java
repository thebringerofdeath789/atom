package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewCommonRadioChildBinding implements ViewBinding {
    public final RadioButton rb1;
    private final RadioButton rootView;

    private ViewCommonRadioChildBinding(RadioButton radioButton, RadioButton radioButton2) {
        this.rootView = radioButton;
        this.rb1 = radioButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RadioButton getRoot() {
        return this.rootView;
    }

    public static ViewCommonRadioChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCommonRadioChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_common_radio_child, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewCommonRadioChildBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        RadioButton radioButton = (RadioButton) view;
        return new ViewCommonRadioChildBinding(radioButton, radioButton);
    }
}
