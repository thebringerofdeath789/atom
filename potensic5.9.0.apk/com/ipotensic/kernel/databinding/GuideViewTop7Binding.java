package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class GuideViewTop7Binding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvGuideReturn;
    public final TextView tvReturn;

    private GuideViewTop7Binding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.tvGuideReturn = textView;
        this.tvReturn = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GuideViewTop7Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GuideViewTop7Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.guide_view_top7, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GuideViewTop7Binding bind(View view) {
        int i = C1965R.id.tv_guide_return;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C1965R.id.tv_return;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new GuideViewTop7Binding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}