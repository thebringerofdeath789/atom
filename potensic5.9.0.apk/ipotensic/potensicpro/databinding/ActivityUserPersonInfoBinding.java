package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityUserPersonInfoBinding implements ViewBinding {
    public final TextView btnConfirm;
    public final EditText etNick;
    private final ConstraintLayout rootView;
    public final TextView tvSkip;
    public final ImageView viewBlank;

    private ActivityUserPersonInfoBinding(ConstraintLayout constraintLayout, TextView textView, EditText editText, TextView textView2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.btnConfirm = textView;
        this.etNick = editText;
        this.tvSkip = textView2;
        this.viewBlank = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUserPersonInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUserPersonInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_user_person_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUserPersonInfoBinding bind(View view) {
        int i = R.id.btn_confirm;
        TextView textView = (TextView) view.findViewById(R.id.btn_confirm);
        if (textView != null) {
            i = R.id.et_nick;
            EditText editText = (EditText) view.findViewById(R.id.et_nick);
            if (editText != null) {
                i = R.id.tv_skip;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_skip);
                if (textView2 != null) {
                    i = R.id.view_blank;
                    ImageView imageView = (ImageView) view.findViewById(R.id.view_blank);
                    if (imageView != null) {
                        return new ActivityUserPersonInfoBinding((ConstraintLayout) view, textView, editText, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}