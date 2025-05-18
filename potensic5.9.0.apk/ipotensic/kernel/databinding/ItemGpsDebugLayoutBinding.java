package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ItemGpsDebugLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView tvCarrierRatio;
    public final TextView tvCarrierRatioValue;

    private ItemGpsDebugLayoutBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.tvCarrierRatio = textView;
        this.tvCarrierRatioValue = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemGpsDebugLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemGpsDebugLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_gps_debug_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemGpsDebugLayoutBinding bind(View view) {
        int i = R.id.tvCarrierRatio;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.tvCarrierRatioValue;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new ItemGpsDebugLayoutBinding((RelativeLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}