package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogBigPackageFwDownloadBlackBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnDownload;
    public final Button btnOk;
    public final LinearLayout llBtn;
    private final ShadowLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvContent;

    private ViewDialogBigPackageFwDownloadBlackBinding(ShadowLayout shadowLayout, Button button, Button button2, Button button3, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.btnCancel = button;
        this.btnDownload = button2;
        this.btnOk = button3;
        this.llBtn = linearLayout;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogBigPackageFwDownloadBlackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogBigPackageFwDownloadBlackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_big_package_fw_download_black, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogBigPackageFwDownloadBlackBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_download;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = R.id.btn_ok;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
                    i = R.id.ll_btn;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                    if (linearLayout != null) {
                        i = R.id.tv_code_title;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = R.id.tv_content;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                return new ViewDialogBigPackageFwDownloadBlackBinding((ShadowLayout) view, button, button2, button3, linearLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}