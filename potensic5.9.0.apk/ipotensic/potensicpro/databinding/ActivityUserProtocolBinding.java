package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.SmartScrollView;

/* loaded from: classes2.dex */
public final class ActivityUserProtocolBinding implements ViewBinding {
    public final ImageButton btnReturn;
    public final ImageView ivUser;
    private final ConstraintLayout rootView;
    public final SmartScrollView scrollView;
    public final TextView tvCodeTitle;
    public final TextView tvContent;
    public final TextView tvPrivacyPolicy;
    public final TextView tvPrivacyPolicyContent;
    public final TextView tvUser;

    private ActivityUserProtocolBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageView imageView, SmartScrollView smartScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btnReturn = imageButton;
        this.ivUser = imageView;
        this.scrollView = smartScrollView;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
        this.tvPrivacyPolicy = textView3;
        this.tvPrivacyPolicyContent = textView4;
        this.tvUser = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUserProtocolBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUserProtocolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_user_protocol, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUserProtocolBinding bind(View view) {
        int i = R.id.btn_return;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_return);
        if (imageButton != null) {
            i = R.id.iv_user;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_user);
            if (imageView != null) {
                i = R.id.scroll_view;
                SmartScrollView smartScrollView = (SmartScrollView) view.findViewById(R.id.scroll_view);
                if (smartScrollView != null) {
                    i = R.id.tv_code_title;
                    TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                    if (textView != null) {
                        i = R.id.tv_content;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_content);
                        if (textView2 != null) {
                            i = R.id.tv_privacy_policy;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_privacy_policy);
                            if (textView3 != null) {
                                i = R.id.tv_privacy_policy_content;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_privacy_policy_content);
                                if (textView4 != null) {
                                    i = R.id.tv_user;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_user);
                                    if (textView5 != null) {
                                        return new ActivityUserProtocolBinding((ConstraintLayout) view, imageButton, imageView, smartScrollView, textView, textView2, textView3, textView4, textView5);
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