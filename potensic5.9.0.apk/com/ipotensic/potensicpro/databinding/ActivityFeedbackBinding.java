package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.view.HorizontalPhotosView;

/* loaded from: classes2.dex */
public final class ActivityFeedbackBinding implements ViewBinding {
    public final Button btnTellUs;
    public final EditText etContent;
    public final ImageView ivBack;
    public final ImageView ivBadgeView;
    public final ImageView ivRecord;
    public final LinearLayout layoutContent;
    public final View line;
    public final HorizontalPhotosView recyclerView;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvBadgeNum;
    public final TextView tvCodeTitle;
    public final TextView tvContactUs;
    public final TextView tvDescription;
    public final TextView tvNumTip;
    public final TextView tvUploadNum;

    private ActivityFeedbackBinding(ConstraintLayout constraintLayout, Button button, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, View view, HorizontalPhotosView horizontalPhotosView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.btnTellUs = button;
        this.etContent = editText;
        this.ivBack = imageView;
        this.ivBadgeView = imageView2;
        this.ivRecord = imageView3;
        this.layoutContent = linearLayout;
        this.line = view;
        this.recyclerView = horizontalPhotosView;
        this.toolbar = toolbar;
        this.tvBadgeNum = textView;
        this.tvCodeTitle = textView2;
        this.tvContactUs = textView3;
        this.tvDescription = textView4;
        this.tvNumTip = textView5;
        this.tvUploadNum = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.activity_feedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityFeedbackBinding bind(View view) {
        int i = C2640R.id.btn_tell_us;
        Button button = (Button) view.findViewById(C2640R.id.btn_tell_us);
        if (button != null) {
            i = C2640R.id.et_content;
            EditText editText = (EditText) view.findViewById(C2640R.id.et_content);
            if (editText != null) {
                i = C2640R.id.iv_back;
                ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_back);
                if (imageView != null) {
                    i = C2640R.id.iv_badge_view;
                    ImageView imageView2 = (ImageView) view.findViewById(C2640R.id.iv_badge_view);
                    if (imageView2 != null) {
                        i = C2640R.id.iv_record;
                        ImageView imageView3 = (ImageView) view.findViewById(C2640R.id.iv_record);
                        if (imageView3 != null) {
                            i = C2640R.id.layout_content;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C2640R.id.layout_content);
                            if (linearLayout != null) {
                                i = C2640R.id.line;
                                View findViewById = view.findViewById(C2640R.id.line);
                                if (findViewById != null) {
                                    i = C2640R.id.recycler_view;
                                    HorizontalPhotosView horizontalPhotosView = (HorizontalPhotosView) view.findViewById(C2640R.id.recycler_view);
                                    if (horizontalPhotosView != null) {
                                        i = C2640R.id.toolbar;
                                        Toolbar toolbar = (Toolbar) view.findViewById(C2640R.id.toolbar);
                                        if (toolbar != null) {
                                            i = C2640R.id.tv_badge_num;
                                            TextView textView = (TextView) view.findViewById(C2640R.id.tv_badge_num);
                                            if (textView != null) {
                                                i = C2640R.id.tv_code_title;
                                                TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_code_title);
                                                if (textView2 != null) {
                                                    i = C2640R.id.tv_contact_us;
                                                    TextView textView3 = (TextView) view.findViewById(C2640R.id.tv_contact_us);
                                                    if (textView3 != null) {
                                                        i = C2640R.id.tv_description;
                                                        TextView textView4 = (TextView) view.findViewById(C2640R.id.tv_description);
                                                        if (textView4 != null) {
                                                            i = C2640R.id.tv_num_tip;
                                                            TextView textView5 = (TextView) view.findViewById(C2640R.id.tv_num_tip);
                                                            if (textView5 != null) {
                                                                i = C2640R.id.tv_upload_num;
                                                                TextView textView6 = (TextView) view.findViewById(C2640R.id.tv_upload_num);
                                                                if (textView6 != null) {
                                                                    return new ActivityFeedbackBinding((ConstraintLayout) view, button, editText, imageView, imageView2, imageView3, linearLayout, findViewById, horizontalPhotosView, toolbar, textView, textView2, textView3, textView4, textView5, textView6);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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