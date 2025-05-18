package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogUpgradeTipsBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final Button btnOk;
    public final ImageView ivImg;
    public final LinearLayout llBtn;
    private final FrameLayout rootView;
    public final ScrollView scrollView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;

    private ViewDialogUpgradeTipsBinding(FrameLayout frameLayout, Button button, Button button2, Button button3, ImageView imageView, LinearLayout linearLayout, ScrollView scrollView, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.btnOk = button3;
        this.ivImg = imageView;
        this.llBtn = linearLayout;
        this.scrollView = scrollView;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogUpgradeTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogUpgradeTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_upgrade_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogUpgradeTipsBinding bind(View view) {
        int i = C1965R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C1965R.id.btn_ok;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
                    i = C1965R.id.iv_img;
                    ImageView imageView = (ImageView) view.findViewById(i);
                    if (imageView != null) {
                        i = C1965R.id.ll_btn;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                        if (linearLayout != null) {
                            i = C1965R.id.scroll_view;
                            ScrollView scrollView = (ScrollView) view.findViewById(i);
                            if (scrollView != null) {
                                i = C1965R.id.tv_dialog_message;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C1965R.id.tv_dialog_title;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        return new ViewDialogUpgradeTipsBinding((FrameLayout) view, button, button2, button3, imageView, linearLayout, scrollView, textView, textView2);
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