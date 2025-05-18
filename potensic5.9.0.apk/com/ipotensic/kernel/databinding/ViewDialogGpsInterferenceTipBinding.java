package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogGpsInterferenceTipBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ScrollView scrollView;
    public final TextView tvCodeTitle;
    public final TextView tvContent;
    public final TextView tvOk;

    private ViewDialogGpsInterferenceTipBinding(RelativeLayout relativeLayout, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.scrollView = scrollView;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
        this.tvOk = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogGpsInterferenceTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogGpsInterferenceTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_gps_interference_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogGpsInterferenceTipBinding bind(View view) {
        int i = C1965R.id.scroll_view;
        ScrollView scrollView = (ScrollView) view.findViewById(i);
        if (scrollView != null) {
            i = C1965R.id.tv_code_title;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C1965R.id.tv_content;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = C1965R.id.tv_ok;
                    TextView textView3 = (TextView) view.findViewById(i);
                    if (textView3 != null) {
                        return new ViewDialogGpsInterferenceTipBinding((RelativeLayout) view, scrollView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}