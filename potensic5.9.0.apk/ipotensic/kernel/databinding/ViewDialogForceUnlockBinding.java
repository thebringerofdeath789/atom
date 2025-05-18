package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.github.mmin18.widget.RealtimeBlurView;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogForceUnlockBinding implements ViewBinding {
    public final View bgView;
    public final Button btnConfirm;
    public final CheckBox cbNoLonger;
    public final Guideline guideCenter;
    public final ImageView imgTemp;
    public final ImageView ivAnimGif;
    public final ConstraintLayout layoutMain;
    private final ConstraintLayout rootView;
    public final RealtimeBlurView viewRealTimeBlur;

    private ViewDialogForceUnlockBinding(ConstraintLayout constraintLayout, View view, Button button, CheckBox checkBox, Guideline guideline, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, RealtimeBlurView realtimeBlurView) {
        this.rootView = constraintLayout;
        this.bgView = view;
        this.btnConfirm = button;
        this.cbNoLonger = checkBox;
        this.guideCenter = guideline;
        this.imgTemp = imageView;
        this.ivAnimGif = imageView2;
        this.layoutMain = constraintLayout2;
        this.viewRealTimeBlur = realtimeBlurView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogForceUnlockBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogForceUnlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_force_unlock, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogForceUnlockBinding bind(View view) {
        int i = R.id.bg_view;
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            i = R.id.btn_confirm;
            Button button = (Button) view.findViewById(i);
            if (button != null) {
                i = R.id.cb_no_longer;
                CheckBox checkBox = (CheckBox) view.findViewById(i);
                if (checkBox != null) {
                    i = R.id.guide_center;
                    Guideline guideline = (Guideline) view.findViewById(i);
                    if (guideline != null) {
                        i = R.id.img_temp;
                        ImageView imageView = (ImageView) view.findViewById(i);
                        if (imageView != null) {
                            i = R.id.iv_anim_gif;
                            ImageView imageView2 = (ImageView) view.findViewById(i);
                            if (imageView2 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                i = R.id.view_real_time_blur;
                                RealtimeBlurView realtimeBlurView = (RealtimeBlurView) view.findViewById(i);
                                if (realtimeBlurView != null) {
                                    return new ViewDialogForceUnlockBinding(constraintLayout, findViewById, button, checkBox, guideline, imageView, imageView2, constraintLayout, realtimeBlurView);
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