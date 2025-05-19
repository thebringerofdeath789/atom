package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.HorizontalWheelView;
import com.ipotensic.kernel.view.ScaleView;

/* loaded from: classes2.dex */
public final class FragmentCameraSettingRightBinding implements ViewBinding {
    public final ImageView ivSplitLineEvManual;
    public final ImageView ivSplitLineIso;
    public final ImageView ivSplitLineSs;
    public final ImageView ivSplitLineWhiteBalance;
    public final LinearLayout llWvEtItemWrapper;
    public final LinearLayout llWvSsItemWrapper;
    private final ConstraintLayout rootView;
    public final SeekBar sbWhiteBalance;
    public final ScaleView svEvValue;
    public final TextView tvAutoWhiteBalance;
    public final TextView tvColorTemperature;
    public final TextView tvEv;
    public final TextView tvIso;
    public final TextView tvSs;
    public final TextView tvWhiteBalance;
    public final View viewCameraSetSplit;
    public final View viewCameraSetSplitEv;
    public final View viewCameraSetSplitIso;
    public final View viewCameraSetSplitSs;
    public final HorizontalWheelView wvIsoItem;
    public final HorizontalWheelView wvSsItem;

    private FragmentCameraSettingRightBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, SeekBar seekBar, ScaleView scaleView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view, View view2, View view3, View view4, HorizontalWheelView horizontalWheelView, HorizontalWheelView horizontalWheelView2) {
        this.rootView = constraintLayout;
        this.ivSplitLineEvManual = imageView;
        this.ivSplitLineIso = imageView2;
        this.ivSplitLineSs = imageView3;
        this.ivSplitLineWhiteBalance = imageView4;
        this.llWvEtItemWrapper = linearLayout;
        this.llWvSsItemWrapper = linearLayout2;
        this.sbWhiteBalance = seekBar;
        this.svEvValue = scaleView;
        this.tvAutoWhiteBalance = textView;
        this.tvColorTemperature = textView2;
        this.tvEv = textView3;
        this.tvIso = textView4;
        this.tvSs = textView5;
        this.tvWhiteBalance = textView6;
        this.viewCameraSetSplit = view;
        this.viewCameraSetSplitEv = view2;
        this.viewCameraSetSplitIso = view3;
        this.viewCameraSetSplitSs = view4;
        this.wvIsoItem = horizontalWheelView;
        this.wvSsItem = horizontalWheelView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCameraSettingRightBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCameraSettingRightBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_camera_setting_right, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentCameraSettingRightBinding bind(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        View findViewById4;
        int i = R.id.iv_split_line_ev_manual;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.iv_split_line_iso;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = R.id.iv_split_line_ss;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = R.id.iv_split_line_white_balance;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        i = R.id.ll_wv_et_item_wrapper;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                        if (linearLayout != null) {
                            i = R.id.ll_wv_ss_item_wrapper;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                            if (linearLayout2 != null) {
                                i = R.id.sb_white_balance;
                                SeekBar seekBar = (SeekBar) view.findViewById(i);
                                if (seekBar != null) {
                                    i = R.id.sv_ev_value;
                                    ScaleView scaleView = (ScaleView) view.findViewById(i);
                                    if (scaleView != null) {
                                        i = R.id.tv_auto_white_balance;
                                        TextView textView = (TextView) view.findViewById(i);
                                        if (textView != null) {
                                            i = R.id.tv_color_temperature;
                                            TextView textView2 = (TextView) view.findViewById(i);
                                            if (textView2 != null) {
                                                i = R.id.tv_ev;
                                                TextView textView3 = (TextView) view.findViewById(i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_iso;
                                                    TextView textView4 = (TextView) view.findViewById(i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_ss;
                                                        TextView textView5 = (TextView) view.findViewById(i);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_white_balance;
                                                            TextView textView6 = (TextView) view.findViewById(i);
                                                            if (textView6 != null && (findViewById = view.findViewById((i = R.id.view_camera_set_split))) != null && (findViewById2 = view.findViewById((i = R.id.view_camera_set_split_ev))) != null && (findViewById3 = view.findViewById((i = R.id.view_camera_set_split_iso))) != null && (findViewById4 = view.findViewById((i = R.id.view_camera_set_split_ss))) != null) {
                                                                i = R.id.wv_iso_item;
                                                                HorizontalWheelView horizontalWheelView = (HorizontalWheelView) view.findViewById(i);
                                                                if (horizontalWheelView != null) {
                                                                    i = R.id.wv_ss_item;
                                                                    HorizontalWheelView horizontalWheelView2 = (HorizontalWheelView) view.findViewById(i);
                                                                    if (horizontalWheelView2 != null) {
                                                                        return new FragmentCameraSettingRightBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, seekBar, scaleView, textView, textView2, textView3, textView4, textView5, textView6, findViewById, findViewById2, findViewById3, findViewById4, horizontalWheelView, horizontalWheelView2);
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
