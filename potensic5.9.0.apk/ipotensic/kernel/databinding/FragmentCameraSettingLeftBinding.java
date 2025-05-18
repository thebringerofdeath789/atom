package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.HorizontalWheelView;

/* loaded from: classes2.dex */
public final class FragmentCameraSettingLeftBinding implements ViewBinding {
    public final Barrier brUnder;
    public final ImageView ivSplitLineEv;
    public final ImageView ivSplitLinePhotoFormat;
    public final ImageView ivSplitLineSdcard;
    public final LinearLayout llWvFpsItemWrapper;
    public final LinearLayout llWvResolutionItemWrapper;
    public final RadioButton rbPhotoFormatJpg;
    public final RadioButton rbPhotoFormatRaw;
    public final RadioButton rbSdcardEstimate;
    public final RadioButton rbSdcardVolume;
    public final RadioGroup rgPhotoFormat;
    public final RadioGroup rgSdcardDisplayItems;
    private final ConstraintLayout rootView;
    public final TextView tvPhotoFormat;
    public final TextView tvSdFormat;
    public final TextView tvSdcardSetting;
    public final View viewCameraSetSplit;
    public final View viewCameraSetSplitSdcard;
    public final ImageView viewResolutionFpsSplit;
    public final HorizontalWheelView wvFpsItem;
    public final HorizontalWheelView wvResolutionItem;

    private FragmentCameraSettingLeftBinding(ConstraintLayout constraintLayout, Barrier barrier, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioGroup radioGroup, RadioGroup radioGroup2, TextView textView, TextView textView2, TextView textView3, View view, View view2, ImageView imageView4, HorizontalWheelView horizontalWheelView, HorizontalWheelView horizontalWheelView2) {
        this.rootView = constraintLayout;
        this.brUnder = barrier;
        this.ivSplitLineEv = imageView;
        this.ivSplitLinePhotoFormat = imageView2;
        this.ivSplitLineSdcard = imageView3;
        this.llWvFpsItemWrapper = linearLayout;
        this.llWvResolutionItemWrapper = linearLayout2;
        this.rbPhotoFormatJpg = radioButton;
        this.rbPhotoFormatRaw = radioButton2;
        this.rbSdcardEstimate = radioButton3;
        this.rbSdcardVolume = radioButton4;
        this.rgPhotoFormat = radioGroup;
        this.rgSdcardDisplayItems = radioGroup2;
        this.tvPhotoFormat = textView;
        this.tvSdFormat = textView2;
        this.tvSdcardSetting = textView3;
        this.viewCameraSetSplit = view;
        this.viewCameraSetSplitSdcard = view2;
        this.viewResolutionFpsSplit = imageView4;
        this.wvFpsItem = horizontalWheelView;
        this.wvResolutionItem = horizontalWheelView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCameraSettingLeftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCameraSettingLeftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_camera_setting_left, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentCameraSettingLeftBinding bind(View view) {
        View findViewById;
        View findViewById2;
        int i = R.id.br_under;
        Barrier barrier = (Barrier) view.findViewById(i);
        if (barrier != null) {
            i = R.id.iv_split_line_ev;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.iv_split_line_photo_format;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = R.id.iv_split_line_sdcard;
                    ImageView imageView3 = (ImageView) view.findViewById(i);
                    if (imageView3 != null) {
                        i = R.id.ll_wv_fps_item_wrapper;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                        if (linearLayout != null) {
                            i = R.id.ll_wv_resolution_item_wrapper;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                            if (linearLayout2 != null) {
                                i = R.id.rb_photo_format_jpg;
                                RadioButton radioButton = (RadioButton) view.findViewById(i);
                                if (radioButton != null) {
                                    i = R.id.rb_photo_format_raw;
                                    RadioButton radioButton2 = (RadioButton) view.findViewById(i);
                                    if (radioButton2 != null) {
                                        i = R.id.rb_sdcard_estimate;
                                        RadioButton radioButton3 = (RadioButton) view.findViewById(i);
                                        if (radioButton3 != null) {
                                            i = R.id.rb_sdcard_volume;
                                            RadioButton radioButton4 = (RadioButton) view.findViewById(i);
                                            if (radioButton4 != null) {
                                                i = R.id.rg_photo_format;
                                                RadioGroup radioGroup = (RadioGroup) view.findViewById(i);
                                                if (radioGroup != null) {
                                                    i = R.id.rg_sdcard_display_items;
                                                    RadioGroup radioGroup2 = (RadioGroup) view.findViewById(i);
                                                    if (radioGroup2 != null) {
                                                        i = R.id.tv_photo_format;
                                                        TextView textView = (TextView) view.findViewById(i);
                                                        if (textView != null) {
                                                            i = R.id.tv_sd_format;
                                                            TextView textView2 = (TextView) view.findViewById(i);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_sdcard_setting;
                                                                TextView textView3 = (TextView) view.findViewById(i);
                                                                if (textView3 != null && (findViewById = view.findViewById((i = R.id.view_camera_set_split))) != null && (findViewById2 = view.findViewById((i = R.id.view_camera_set_split_sdcard))) != null) {
                                                                    i = R.id.view_resolution_fps_split;
                                                                    ImageView imageView4 = (ImageView) view.findViewById(i);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.wv_fps_item;
                                                                        HorizontalWheelView horizontalWheelView = (HorizontalWheelView) view.findViewById(i);
                                                                        if (horizontalWheelView != null) {
                                                                            i = R.id.wv_resolution_item;
                                                                            HorizontalWheelView horizontalWheelView2 = (HorizontalWheelView) view.findViewById(i);
                                                                            if (horizontalWheelView2 != null) {
                                                                                return new FragmentCameraSettingLeftBinding((ConstraintLayout) view, barrier, imageView, imageView2, imageView3, linearLayout, linearLayout2, radioButton, radioButton2, radioButton3, radioButton4, radioGroup, radioGroup2, textView, textView2, textView3, findViewById, findViewById2, imageView4, horizontalWheelView, horizontalWheelView2);
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