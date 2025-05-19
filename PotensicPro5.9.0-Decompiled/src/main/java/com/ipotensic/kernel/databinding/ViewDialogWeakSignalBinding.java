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
public final class ViewDialogWeakSignalBinding implements ViewBinding {
    public final View bgView;
    public final Button btnConfirm;
    public final CheckBox cbNoLonger;
    public final Guideline guideCenter;
    public final ImageView imgLeft;
    public final ImageView imgRight;
    public final ImageView imgTemp;
    public final ConstraintLayout layoutMain;
    private final ConstraintLayout rootView;
    public final RealtimeBlurView viewRealTimeBlur;

    private ViewDialogWeakSignalBinding(ConstraintLayout constraintLayout, View view, Button button, CheckBox checkBox, Guideline guideline, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, RealtimeBlurView realtimeBlurView) {
        this.rootView = constraintLayout;
        this.bgView = view;
        this.btnConfirm = button;
        this.cbNoLonger = checkBox;
        this.guideCenter = guideline;
        this.imgLeft = imageView;
        this.imgRight = imageView2;
        this.imgTemp = imageView3;
        this.layoutMain = constraintLayout2;
        this.viewRealTimeBlur = realtimeBlurView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogWeakSignalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogWeakSignalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_weak_signal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogWeakSignalBinding bind(View view) {
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
                        i = R.id.imgLeft;
                        ImageView imageView = (ImageView) view.findViewById(i);
                        if (imageView != null) {
                            i = R.id.imgRight;
                            ImageView imageView2 = (ImageView) view.findViewById(i);
                            if (imageView2 != null) {
                                i = R.id.img_temp;
                                ImageView imageView3 = (ImageView) view.findViewById(i);
                                if (imageView3 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    i = R.id.view_real_time_blur;
                                    RealtimeBlurView realtimeBlurView = (RealtimeBlurView) view.findViewById(i);
                                    if (realtimeBlurView != null) {
                                        return new ViewDialogWeakSignalBinding(constraintLayout, findViewById, button, checkBox, guideline, imageView, imageView2, imageView3, constraintLayout, realtimeBlurView);
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
