package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.HorizontalWheelView;

/* loaded from: classes2.dex */
public final class ViewCameraParamTips1Binding implements ViewBinding {
    public final ImageView divider1;
    public final ImageView divider2;
    public final ImageView ivEvIcon;
    public final ImageView ivHighTemp;
    public final ImageView ivSd;
    public final ImageView ivSplitIsoSs;
    public final ImageView ivSplitLineEv;
    public final ImageView ivSplitSsWb;
    public final LinearLayout llWvEtItemWrapper;
    public final LinearLayout llWvFpsItemWrapper;
    public final LinearLayout llWvResolutionItemWrapper;
    public final RelativeLayout rlFirst;
    private final ConstraintLayout rootView;
    public final StrokeTextView tvEvValue;
    public final StrokeTextView tvIsoValue;
    public final StrokeTextView tvResolutionOrFormat;
    public final StrokeTextView tvSdRemainTime;
    public final StrokeTextView tvSsValue;
    public final StrokeTextView tvWhiteBalanceValue;
    public final View viewMargin;
    public final ImageView viewResolutionFpsSplit;
    public final HorizontalWheelView wvEvItem;
    public final HorizontalWheelView wvFpsItem;
    public final HorizontalWheelView wvResolutionItem;

    private ViewCameraParamTips1Binding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3, StrokeTextView strokeTextView4, StrokeTextView strokeTextView5, StrokeTextView strokeTextView6, View view, ImageView imageView9, HorizontalWheelView horizontalWheelView, HorizontalWheelView horizontalWheelView2, HorizontalWheelView horizontalWheelView3) {
        this.rootView = constraintLayout;
        this.divider1 = imageView;
        this.divider2 = imageView2;
        this.ivEvIcon = imageView3;
        this.ivHighTemp = imageView4;
        this.ivSd = imageView5;
        this.ivSplitIsoSs = imageView6;
        this.ivSplitLineEv = imageView7;
        this.ivSplitSsWb = imageView8;
        this.llWvEtItemWrapper = linearLayout;
        this.llWvFpsItemWrapper = linearLayout2;
        this.llWvResolutionItemWrapper = linearLayout3;
        this.rlFirst = relativeLayout;
        this.tvEvValue = strokeTextView;
        this.tvIsoValue = strokeTextView2;
        this.tvResolutionOrFormat = strokeTextView3;
        this.tvSdRemainTime = strokeTextView4;
        this.tvSsValue = strokeTextView5;
        this.tvWhiteBalanceValue = strokeTextView6;
        this.viewMargin = view;
        this.viewResolutionFpsSplit = imageView9;
        this.wvEvItem = horizontalWheelView;
        this.wvFpsItem = horizontalWheelView2;
        this.wvResolutionItem = horizontalWheelView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCameraParamTips1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCameraParamTips1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_camera_param_tips1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewCameraParamTips1Binding bind(View view) {
        View findViewById;
        int i = R.id.divider1;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.divider2;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = R.id.iv_ev_icon;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = R.id.iv_high_temp;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        i = R.id.iv_sd;
                        ImageView imageView5 = (ImageView) view.findViewById(i);
                        if (imageView5 != null) {
                            i = R.id.iv_split_iso_ss;
                            ImageView imageView6 = (ImageView) view.findViewById(i);
                            if (imageView6 != null) {
                                i = R.id.iv_split_line_ev;
                                ImageView imageView7 = (ImageView) view.findViewById(i);
                                if (imageView7 != null) {
                                    i = R.id.iv_split_ss_wb;
                                    ImageView imageView8 = (ImageView) view.findViewById(i);
                                    if (imageView8 != null) {
                                        i = R.id.ll_wv_et_item_wrapper;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                        if (linearLayout != null) {
                                            i = R.id.ll_wv_fps_item_wrapper;
                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                            if (linearLayout2 != null) {
                                                i = R.id.ll_wv_resolution_item_wrapper;
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.rl_first;
                                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.tv_ev_value;
                                                        StrokeTextView strokeTextView = (StrokeTextView) view.findViewById(i);
                                                        if (strokeTextView != null) {
                                                            i = R.id.tv_iso_value;
                                                            StrokeTextView strokeTextView2 = (StrokeTextView) view.findViewById(i);
                                                            if (strokeTextView2 != null) {
                                                                i = R.id.tv_resolution_or_format;
                                                                StrokeTextView strokeTextView3 = (StrokeTextView) view.findViewById(i);
                                                                if (strokeTextView3 != null) {
                                                                    i = R.id.tv_sd_remain_time;
                                                                    StrokeTextView strokeTextView4 = (StrokeTextView) view.findViewById(i);
                                                                    if (strokeTextView4 != null) {
                                                                        i = R.id.tv_ss_value;
                                                                        StrokeTextView strokeTextView5 = (StrokeTextView) view.findViewById(i);
                                                                        if (strokeTextView5 != null) {
                                                                            i = R.id.tv_white_balance_value;
                                                                            StrokeTextView strokeTextView6 = (StrokeTextView) view.findViewById(i);
                                                                            if (strokeTextView6 != null && (findViewById = view.findViewById((i = R.id.view_margin))) != null) {
                                                                                i = R.id.view_resolution_fps_split;
                                                                                ImageView imageView9 = (ImageView) view.findViewById(i);
                                                                                if (imageView9 != null) {
                                                                                    i = R.id.wv_ev_item;
                                                                                    HorizontalWheelView horizontalWheelView = (HorizontalWheelView) view.findViewById(i);
                                                                                    if (horizontalWheelView != null) {
                                                                                        i = R.id.wv_fps_item;
                                                                                        HorizontalWheelView horizontalWheelView2 = (HorizontalWheelView) view.findViewById(i);
                                                                                        if (horizontalWheelView2 != null) {
                                                                                            i = R.id.wv_resolution_item;
                                                                                            HorizontalWheelView horizontalWheelView3 = (HorizontalWheelView) view.findViewById(i);
                                                                                            if (horizontalWheelView3 != null) {
                                                                                                return new ViewCameraParamTips1Binding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, linearLayout, linearLayout2, linearLayout3, relativeLayout, strokeTextView, strokeTextView2, strokeTextView3, strokeTextView4, strokeTextView5, strokeTextView6, findViewById, imageView9, horizontalWheelView, horizontalWheelView2, horizontalWheelView3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}