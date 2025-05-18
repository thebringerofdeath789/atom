package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogSettingTipsBinding implements ViewBinding {
    private final ShadowLayout rootView;
    public final TextView tvDialogMessage;

    private ViewDialogSettingTipsBinding(ShadowLayout shadowLayout, TextView textView) {
        this.rootView = shadowLayout;
        this.tvDialogMessage = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogSettingTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogSettingTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_setting_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogSettingTipsBinding bind(View view) {
        int i = C1965R.id.tv_dialog_message;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            return new ViewDialogSettingTipsBinding((ShadowLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}