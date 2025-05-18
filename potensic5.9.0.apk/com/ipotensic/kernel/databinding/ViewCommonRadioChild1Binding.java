package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.DrawableTextView;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewCommonRadioChild1Binding implements ViewBinding {
    private final DrawableTextView rootView;

    private ViewCommonRadioChild1Binding(DrawableTextView drawableTextView) {
        this.rootView = drawableTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public DrawableTextView getRoot() {
        return this.rootView;
    }

    public static ViewCommonRadioChild1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCommonRadioChild1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_common_radio_child1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewCommonRadioChild1Binding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ViewCommonRadioChild1Binding((DrawableTextView) view);
    }
}