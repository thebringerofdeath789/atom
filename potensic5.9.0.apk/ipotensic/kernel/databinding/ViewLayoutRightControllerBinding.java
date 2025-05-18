package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutRightControllerBinding implements ViewBinding {
    public final ImageView ivCameraSet;
    public final ImageView ivCapture;
    public final ImageView ivGallery;
    public final ImageView ivRecordRed;
    public final ImageView ivSwitchStatus;
    public final LinearLayout llRecord;
    private final ConstraintLayout rootView;
    public final TextView tvRecordTime;

    private ViewLayoutRightControllerBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.ivCameraSet = imageView;
        this.ivCapture = imageView2;
        this.ivGallery = imageView3;
        this.ivRecordRed = imageView4;
        this.ivSwitchStatus = imageView5;
        this.llRecord = linearLayout;
        this.tvRecordTime = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutRightControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutRightControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_right_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutRightControllerBinding bind(View view) {
        int i = R.id.iv_camera_set;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.iv_capture;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = R.id.iv_gallery;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = R.id.iv_record_red;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        i = R.id.iv_switch_status;
                        ImageView imageView5 = (ImageView) view.findViewById(i);
                        if (imageView5 != null) {
                            i = R.id.ll_record;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                            if (linearLayout != null) {
                                i = R.id.tv_record_time;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    return new ViewLayoutRightControllerBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, linearLayout, textView);
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