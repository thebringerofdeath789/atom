package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class DialogConnectStateTipBinding implements ViewBinding {
    public final ImageButton btnClose;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvContent;

    private DialogConnectStateTipBinding(ConstraintLayout constraintLayout, ImageButton imageButton, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnClose = imageButton;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogConnectStateTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogConnectStateTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_connect_state_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogConnectStateTipBinding bind(View view) {
        int i = R.id.btn_close;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.tv_code_title;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_content;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new DialogConnectStateTipBinding((ConstraintLayout) view, imageButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
