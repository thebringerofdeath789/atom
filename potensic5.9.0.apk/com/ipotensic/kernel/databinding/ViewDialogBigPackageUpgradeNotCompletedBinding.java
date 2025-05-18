package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogBigPackageUpgradeNotCompletedBinding implements ViewBinding {
    public final Button btnOk;
    private final ShadowLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvContent;

    private ViewDialogBigPackageUpgradeNotCompletedBinding(ShadowLayout shadowLayout, Button button, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.btnOk = button;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogBigPackageUpgradeNotCompletedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogBigPackageUpgradeNotCompletedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_big_package_upgrade_not_completed, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogBigPackageUpgradeNotCompletedBinding bind(View view) {
        int i = C1965R.id.btn_ok;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.tv_code_title;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C1965R.id.tv_content;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new ViewDialogBigPackageUpgradeNotCompletedBinding((ShadowLayout) view, button, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}