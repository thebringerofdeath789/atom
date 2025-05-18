package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class DialogCommonTwoButtonBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnConfirm;
    private final ShadowLayout rootView;
    public final ScrollView svContent;
    public final TextView tvContent;
    public final TextView tvTitle;

    private DialogCommonTwoButtonBinding(ShadowLayout shadowLayout, TextView textView, TextView textView2, ScrollView scrollView, TextView textView3, TextView textView4) {
        this.rootView = shadowLayout;
        this.btnCancel = textView;
        this.btnConfirm = textView2;
        this.svContent = scrollView;
        this.tvContent = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static DialogCommonTwoButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCommonTwoButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_common_two_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogCommonTwoButtonBinding bind(View view) {
        int i = R.id.btn_cancel;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.btn_confirm;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                i = R.id.sv_content;
                ScrollView scrollView = (ScrollView) view.findViewById(i);
                if (scrollView != null) {
                    i = R.id.tv_content;
                    TextView textView3 = (TextView) view.findViewById(i);
                    if (textView3 != null) {
                        i = R.id.tv_title;
                        TextView textView4 = (TextView) view.findViewById(i);
                        if (textView4 != null) {
                            return new DialogCommonTwoButtonBinding((ShadowLayout) view, textView, textView2, scrollView, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}