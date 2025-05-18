package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ActivityCompanyContactBinding implements ViewBinding {
    public final CardView cardViewTop;
    public final ImageView ivEmail;
    public final ImageView ivPassWord;
    public final View line;
    private final ConstraintLayout rootView;
    public final TextView tvEmail;
    public final TextView tvEmailContent;
    public final TextView tvWebsite;
    public final TextView tvWebsiteLink;

    private ActivityCompanyContactBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, ImageView imageView2, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.cardViewTop = cardView;
        this.ivEmail = imageView;
        this.ivPassWord = imageView2;
        this.line = view;
        this.tvEmail = textView;
        this.tvEmailContent = textView2;
        this.tvWebsite = textView3;
        this.tvWebsiteLink = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCompanyContactBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCompanyContactBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.activity_company_contact, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCompanyContactBinding bind(View view) {
        int i = C2640R.id.cardView_top;
        CardView cardView = (CardView) view.findViewById(C2640R.id.cardView_top);
        if (cardView != null) {
            i = C2640R.id.iv_email;
            ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_email);
            if (imageView != null) {
                i = C2640R.id.iv_pass_word;
                ImageView imageView2 = (ImageView) view.findViewById(C2640R.id.iv_pass_word);
                if (imageView2 != null) {
                    i = C2640R.id.line;
                    View findViewById = view.findViewById(C2640R.id.line);
                    if (findViewById != null) {
                        i = C2640R.id.tv_email;
                        TextView textView = (TextView) view.findViewById(C2640R.id.tv_email);
                        if (textView != null) {
                            i = C2640R.id.tv_email_content;
                            TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_email_content);
                            if (textView2 != null) {
                                i = C2640R.id.tv_website;
                                TextView textView3 = (TextView) view.findViewById(C2640R.id.tv_website);
                                if (textView3 != null) {
                                    i = C2640R.id.tv_website_link;
                                    TextView textView4 = (TextView) view.findViewById(C2640R.id.tv_website_link);
                                    if (textView4 != null) {
                                        return new ActivityCompanyContactBinding((ConstraintLayout) view, cardView, imageView, imageView2, findViewById, textView, textView2, textView3, textView4);
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