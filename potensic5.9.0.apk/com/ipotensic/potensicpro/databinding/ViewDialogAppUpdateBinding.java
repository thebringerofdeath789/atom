package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewDialogAppUpdateBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnOk;
    public final Button btnUpdate;
    public final ImageView ivTopBg;
    public final LinearLayout llBottom;
    private final ShadowLayout rootView;
    public final ScrollView svContent;
    public final TextView tvContent;
    public final TextView tvVersion;

    private ViewDialogAppUpdateBinding(ShadowLayout shadowLayout, Button button, Button button2, Button button3, ImageView imageView, LinearLayout linearLayout, ScrollView scrollView, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.btnCancel = button;
        this.btnOk = button2;
        this.btnUpdate = button3;
        this.ivTopBg = imageView;
        this.llBottom = linearLayout;
        this.svContent = scrollView;
        this.tvContent = textView;
        this.tvVersion = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogAppUpdateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogAppUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_dialog_app_update, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogAppUpdateBinding bind(View view) {
        int i = C2640R.id.btn_cancel;
        Button button = (Button) view.findViewById(C2640R.id.btn_cancel);
        if (button != null) {
            i = C2640R.id.btn_ok;
            Button button2 = (Button) view.findViewById(C2640R.id.btn_ok);
            if (button2 != null) {
                i = C2640R.id.btn_update;
                Button button3 = (Button) view.findViewById(C2640R.id.btn_update);
                if (button3 != null) {
                    i = C2640R.id.iv_top_bg;
                    ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_top_bg);
                    if (imageView != null) {
                        i = C2640R.id.ll_bottom;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C2640R.id.ll_bottom);
                        if (linearLayout != null) {
                            i = C2640R.id.sv_content;
                            ScrollView scrollView = (ScrollView) view.findViewById(C2640R.id.sv_content);
                            if (scrollView != null) {
                                i = C2640R.id.tv_content;
                                TextView textView = (TextView) view.findViewById(C2640R.id.tv_content);
                                if (textView != null) {
                                    i = C2640R.id.tv_version;
                                    TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_version);
                                    if (textView2 != null) {
                                        return new ViewDialogAppUpdateBinding((ShadowLayout) view, button, button2, button3, imageView, linearLayout, scrollView, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}