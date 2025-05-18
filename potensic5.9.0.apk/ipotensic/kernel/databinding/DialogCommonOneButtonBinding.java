package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class DialogCommonOneButtonBinding implements ViewBinding {
    public final TextView btnOk;
    private final ShadowLayout rootView;
    public final TextView tvContent;
    public final TextView tvDialogTitle;

    private DialogCommonOneButtonBinding(ShadowLayout shadowLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = shadowLayout;
        this.btnOk = textView;
        this.tvContent = textView2;
        this.tvDialogTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static DialogCommonOneButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCommonOneButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_common_one_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogCommonOneButtonBinding bind(View view) {
        int i = R.id.btn_ok;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.tv_content;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                i = R.id.tv_dialog_title;
                TextView textView3 = (TextView) view.findViewById(i);
                if (textView3 != null) {
                    return new DialogCommonOneButtonBinding((ShadowLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}