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
public final class ViewLayoutSetting3Binding implements ViewBinding {
    public final ImageView ivBack;
    public final ImageView ivLeft;
    public final ImageView ivRight;
    public final LinearLayout llDataChange;
    private final ConstraintLayout rootView;
    public final TextView tvBackward;
    public final TextView tvDataChange;
    public final TextView tvDown;
    public final TextView tvFlightTips;
    public final TextView tvForward;
    public final TextView tvLeft;
    public final TextView tvLeftSide;
    public final TextView tvLeftStick;
    public final TextView tvMode1;
    public final TextView tvMode2;
    public final TextView tvRemoteRightStick;
    public final TextView tvRight;
    public final TextView tvRightSide;
    public final TextView tvSetting;
    public final TextView tvUp;

    private ViewLayoutSetting3Binding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.rootView = constraintLayout;
        this.ivBack = imageView;
        this.ivLeft = imageView2;
        this.ivRight = imageView3;
        this.llDataChange = linearLayout;
        this.tvBackward = textView;
        this.tvDataChange = textView2;
        this.tvDown = textView3;
        this.tvFlightTips = textView4;
        this.tvForward = textView5;
        this.tvLeft = textView6;
        this.tvLeftSide = textView7;
        this.tvLeftStick = textView8;
        this.tvMode1 = textView9;
        this.tvMode2 = textView10;
        this.tvRemoteRightStick = textView11;
        this.tvRight = textView12;
        this.tvRightSide = textView13;
        this.tvSetting = textView14;
        this.tvUp = textView15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_setting_3, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting3Binding bind(View view) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.iv_left;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = R.id.iv_right;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = R.id.ll_data_change;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                    if (linearLayout != null) {
                        i = R.id.tv_backward;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = R.id.tv_data_change;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = R.id.tv_down;
                                TextView textView3 = (TextView) view.findViewById(i);
                                if (textView3 != null) {
                                    i = R.id.tv_flight_tips;
                                    TextView textView4 = (TextView) view.findViewById(i);
                                    if (textView4 != null) {
                                        i = R.id.tv_forward;
                                        TextView textView5 = (TextView) view.findViewById(i);
                                        if (textView5 != null) {
                                            i = R.id.tv_left;
                                            TextView textView6 = (TextView) view.findViewById(i);
                                            if (textView6 != null) {
                                                i = R.id.tv_left_side;
                                                TextView textView7 = (TextView) view.findViewById(i);
                                                if (textView7 != null) {
                                                    i = R.id.tv_left_stick;
                                                    TextView textView8 = (TextView) view.findViewById(i);
                                                    if (textView8 != null) {
                                                        i = R.id.tv_mode_1;
                                                        TextView textView9 = (TextView) view.findViewById(i);
                                                        if (textView9 != null) {
                                                            i = R.id.tv_mode_2;
                                                            TextView textView10 = (TextView) view.findViewById(i);
                                                            if (textView10 != null) {
                                                                i = R.id.tv_remote_right_stick;
                                                                TextView textView11 = (TextView) view.findViewById(i);
                                                                if (textView11 != null) {
                                                                    i = R.id.tv_right;
                                                                    TextView textView12 = (TextView) view.findViewById(i);
                                                                    if (textView12 != null) {
                                                                        i = R.id.tv_right_side;
                                                                        TextView textView13 = (TextView) view.findViewById(i);
                                                                        if (textView13 != null) {
                                                                            i = R.id.tv_setting;
                                                                            TextView textView14 = (TextView) view.findViewById(i);
                                                                            if (textView14 != null) {
                                                                                i = R.id.tv_up;
                                                                                TextView textView15 = (TextView) view.findViewById(i);
                                                                                if (textView15 != null) {
                                                                                    return new ViewLayoutSetting3Binding((ConstraintLayout) view, imageView, imageView2, imageView3, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
