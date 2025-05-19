package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewLayoutTestMapMarkBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView txt;

    private ViewLayoutTestMapMarkBinding(RelativeLayout relativeLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.txt = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutTestMapMarkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutTestMapMarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_test_map_mark, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutTestMapMarkBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.txt);
        if (textView != null) {
            return new ViewLayoutTestMapMarkBinding((RelativeLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.txt)));
    }
}
