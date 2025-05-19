package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewRightCameraSetItem3Binding implements ViewBinding {
    public final ConstraintLayout cl;
    public final ImageView ivEvAdjust;
    public final ImageButton ivEvPlus;
    public final ImageButton ivEvSub;
    private final ConstraintLayout rootView;
    public final TextView textCenter;
    public final TextView textLeft1;
    public final TextView textLeft2;
    public final TextView textRight1;
    public final TextView textRight2;
    public final TextView tvEvValue;

    private ViewRightCameraSetItem3Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageButton imageButton, ImageButton imageButton2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.cl = constraintLayout2;
        this.ivEvAdjust = imageView;
        this.ivEvPlus = imageButton;
        this.ivEvSub = imageButton2;
        this.textCenter = textView;
        this.textLeft1 = textView2;
        this.textLeft2 = textView3;
        this.textRight1 = textView4;
        this.textRight2 = textView5;
        this.tvEvValue = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRightCameraSetItem3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRightCameraSetItem3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_right_camera_set_item3, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRightCameraSetItem3Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_ev_adjust;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.iv_ev_plus;
            ImageButton imageButton = (ImageButton) view.findViewById(i);
            if (imageButton != null) {
                i = R.id.iv_ev_sub;
                ImageButton imageButton2 = (ImageButton) view.findViewById(i);
                if (imageButton2 != null) {
                    i = R.id.text_center;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.text_left_1;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = R.id.text_left_2;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                i = R.id.text_right_1;
                                TextView textView4 = (TextView) view.findViewById(i);
                                if (textView4 != null) {
                                    i = R.id.text_right_2;
                                    TextView textView5 = (TextView) view.findViewById(i);
                                    if (textView5 != null) {
                                        i = R.id.tv_ev_value;
                                        TextView textView6 = (TextView) view.findViewById(i);
                                        if (textView6 != null) {
                                            return new ViewRightCameraSetItem3Binding(constraintLayout, constraintLayout, imageView, imageButton, imageButton2, textView, textView2, textView3, textView4, textView5, textView6);
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
