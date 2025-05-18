package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.fragment.CameraQuickSettingView;
import com.ipotensic.kernel.view.CaptureAnimImageView;
import com.ipotensic.kernel.view.GimbalScaleView;

/* loaded from: classes2.dex */
public final class ActivityKernelBinding implements ViewBinding {
    public final View baseSmallView;
    public final ViewLayoutBottomControllerBinding bottomController;
    public final FrameLayout flFriendlyTips;
    public final FrameLayout flMainSetting;
    public final FrameLayout flSettingSecondPage;
    public final GimbalScaleView gimbalScaleView;
    public final View guideRight;
    public final CaptureAnimImageView imgAnimCapture;
    public final ViewLayoutCenterTipsBinding layoutCenterTips;
    public final ConstraintLayout layoutGlobal;
    public final ViewLayoutRightVisionControllerBinding layoutRightController;
    public final ViewLayoutTopLeftTipsBinding layoutTopLeftTips;
    public final ViewLayoutTopTipsBinding layoutTopTips;
    public final ViewLayoutLeftControllerBinding leftController;
    public final ViewMapVideoControllerBinding mapVideoController;
    public final ViewCameraParamTips1Binding rightCameraParamView;
    public final View rightControllerTemp;
    public final ViewRightSlideControllerBinding rightSlideController;
    public final ViewRockerTouchControllerBinding rockerTouchController;
    private final ConstraintLayout rootView;
    public final ViewLayoutSecurityTipsControllerBinding securityTipsController;
    public final ViewStub stubCameraSet;
    public final ViewStub stubCancelAction;
    public final ViewStub stubDotLine;
    public final ViewStub stubGridLine;
    public final ViewStub stubPtzCalibration;
    public final ViewStub stubSetting;
    public final ViewLayoutSixImuCalibrationControllerBinding stubSixImu;
    public final ViewLayoutFactoryTestBinding testControllerMode;
    public final LinearLayout tipView;
    public final ViewLayoutTopControllerBinding topController;
    public final ViewControllerModeBinding topControllerMode;
    public final TextView tvFirmwareUpgradeTips;
    public final TextView tvSelectTargetTips;
    public final ViewAtomltLeftIntelligentModeBinding viewAtomLTIntelligentMode;
    public final CameraQuickSettingView viewCameraQuickSetting;
    public final ViewLeftIntelligentModeBinding viewIntelligentMode;
    public final FrameLayout viewPhotoGuide;
    public final ViewWarnBinding viewWarnController;

    private ActivityKernelBinding(ConstraintLayout constraintLayout, View view, ViewLayoutBottomControllerBinding viewLayoutBottomControllerBinding, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, GimbalScaleView gimbalScaleView, View view2, CaptureAnimImageView captureAnimImageView, ViewLayoutCenterTipsBinding viewLayoutCenterTipsBinding, ConstraintLayout constraintLayout2, ViewLayoutRightVisionControllerBinding viewLayoutRightVisionControllerBinding, ViewLayoutTopLeftTipsBinding viewLayoutTopLeftTipsBinding, ViewLayoutTopTipsBinding viewLayoutTopTipsBinding, ViewLayoutLeftControllerBinding viewLayoutLeftControllerBinding, ViewMapVideoControllerBinding viewMapVideoControllerBinding, ViewCameraParamTips1Binding viewCameraParamTips1Binding, View view3, ViewRightSlideControllerBinding viewRightSlideControllerBinding, ViewRockerTouchControllerBinding viewRockerTouchControllerBinding, ViewLayoutSecurityTipsControllerBinding viewLayoutSecurityTipsControllerBinding, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, ViewStub viewStub4, ViewStub viewStub5, ViewStub viewStub6, ViewLayoutSixImuCalibrationControllerBinding viewLayoutSixImuCalibrationControllerBinding, ViewLayoutFactoryTestBinding viewLayoutFactoryTestBinding, LinearLayout linearLayout, ViewLayoutTopControllerBinding viewLayoutTopControllerBinding, ViewControllerModeBinding viewControllerModeBinding, TextView textView, TextView textView2, ViewAtomltLeftIntelligentModeBinding viewAtomltLeftIntelligentModeBinding, CameraQuickSettingView cameraQuickSettingView, ViewLeftIntelligentModeBinding viewLeftIntelligentModeBinding, FrameLayout frameLayout4, ViewWarnBinding viewWarnBinding) {
        this.rootView = constraintLayout;
        this.baseSmallView = view;
        this.bottomController = viewLayoutBottomControllerBinding;
        this.flFriendlyTips = frameLayout;
        this.flMainSetting = frameLayout2;
        this.flSettingSecondPage = frameLayout3;
        this.gimbalScaleView = gimbalScaleView;
        this.guideRight = view2;
        this.imgAnimCapture = captureAnimImageView;
        this.layoutCenterTips = viewLayoutCenterTipsBinding;
        this.layoutGlobal = constraintLayout2;
        this.layoutRightController = viewLayoutRightVisionControllerBinding;
        this.layoutTopLeftTips = viewLayoutTopLeftTipsBinding;
        this.layoutTopTips = viewLayoutTopTipsBinding;
        this.leftController = viewLayoutLeftControllerBinding;
        this.mapVideoController = viewMapVideoControllerBinding;
        this.rightCameraParamView = viewCameraParamTips1Binding;
        this.rightControllerTemp = view3;
        this.rightSlideController = viewRightSlideControllerBinding;
        this.rockerTouchController = viewRockerTouchControllerBinding;
        this.securityTipsController = viewLayoutSecurityTipsControllerBinding;
        this.stubCameraSet = viewStub;
        this.stubCancelAction = viewStub2;
        this.stubDotLine = viewStub3;
        this.stubGridLine = viewStub4;
        this.stubPtzCalibration = viewStub5;
        this.stubSetting = viewStub6;
        this.stubSixImu = viewLayoutSixImuCalibrationControllerBinding;
        this.testControllerMode = viewLayoutFactoryTestBinding;
        this.tipView = linearLayout;
        this.topController = viewLayoutTopControllerBinding;
        this.topControllerMode = viewControllerModeBinding;
        this.tvFirmwareUpgradeTips = textView;
        this.tvSelectTargetTips = textView2;
        this.viewAtomLTIntelligentMode = viewAtomltLeftIntelligentModeBinding;
        this.viewCameraQuickSetting = cameraQuickSettingView;
        this.viewIntelligentMode = viewLeftIntelligentModeBinding;
        this.viewPhotoGuide = frameLayout4;
        this.viewWarnController = viewWarnBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityKernelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityKernelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.activity_kernel, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityKernelBinding bind(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        View findViewById4;
        View findViewById5;
        View findViewById6;
        View findViewById7;
        View findViewById8;
        View findViewById9;
        int i = C1965R.id.base_small_view;
        View findViewById10 = view.findViewById(i);
        if (findViewById10 != null && (findViewById = view.findViewById((i = C1965R.id.bottom_controller))) != null) {
            ViewLayoutBottomControllerBinding bind = ViewLayoutBottomControllerBinding.bind(findViewById);
            i = C1965R.id.flFriendlyTips;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
            if (frameLayout != null) {
                i = C1965R.id.fl_main_setting;
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(i);
                if (frameLayout2 != null) {
                    i = C1965R.id.fl_setting_second_page;
                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(i);
                    if (frameLayout3 != null) {
                        i = C1965R.id.gimbal_scale_view;
                        GimbalScaleView gimbalScaleView = (GimbalScaleView) view.findViewById(i);
                        if (gimbalScaleView != null && (findViewById2 = view.findViewById((i = C1965R.id.guide_right))) != null) {
                            i = C1965R.id.img_anim_capture;
                            CaptureAnimImageView captureAnimImageView = (CaptureAnimImageView) view.findViewById(i);
                            if (captureAnimImageView != null && (findViewById3 = view.findViewById((i = C1965R.id.layout_center_tips))) != null) {
                                ViewLayoutCenterTipsBinding bind2 = ViewLayoutCenterTipsBinding.bind(findViewById3);
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                i = C1965R.id.layout_right_controller;
                                View findViewById11 = view.findViewById(i);
                                if (findViewById11 != null) {
                                    ViewLayoutRightVisionControllerBinding bind3 = ViewLayoutRightVisionControllerBinding.bind(findViewById11);
                                    i = C1965R.id.layout_top_left_tips;
                                    View findViewById12 = view.findViewById(i);
                                    if (findViewById12 != null) {
                                        ViewLayoutTopLeftTipsBinding bind4 = ViewLayoutTopLeftTipsBinding.bind(findViewById12);
                                        i = C1965R.id.layout_top_tips;
                                        View findViewById13 = view.findViewById(i);
                                        if (findViewById13 != null) {
                                            ViewLayoutTopTipsBinding bind5 = ViewLayoutTopTipsBinding.bind(findViewById13);
                                            i = C1965R.id.left_controller;
                                            View findViewById14 = view.findViewById(i);
                                            if (findViewById14 != null) {
                                                ViewLayoutLeftControllerBinding bind6 = ViewLayoutLeftControllerBinding.bind(findViewById14);
                                                i = C1965R.id.map_video_controller;
                                                View findViewById15 = view.findViewById(i);
                                                if (findViewById15 != null) {
                                                    ViewMapVideoControllerBinding bind7 = ViewMapVideoControllerBinding.bind(findViewById15);
                                                    i = C1965R.id.right_camera_param_view;
                                                    View findViewById16 = view.findViewById(i);
                                                    if (findViewById16 != null) {
                                                        ViewCameraParamTips1Binding bind8 = ViewCameraParamTips1Binding.bind(findViewById16);
                                                        i = C1965R.id.right_controller_temp;
                                                        View findViewById17 = view.findViewById(i);
                                                        if (findViewById17 != null && (findViewById4 = view.findViewById((i = C1965R.id.right_slide_controller))) != null) {
                                                            ViewRightSlideControllerBinding bind9 = ViewRightSlideControllerBinding.bind(findViewById4);
                                                            i = C1965R.id.rocker_touch_controller;
                                                            View findViewById18 = view.findViewById(i);
                                                            if (findViewById18 != null) {
                                                                ViewRockerTouchControllerBinding bind10 = ViewRockerTouchControllerBinding.bind(findViewById18);
                                                                i = C1965R.id.security_tips_controller;
                                                                View findViewById19 = view.findViewById(i);
                                                                if (findViewById19 != null) {
                                                                    ViewLayoutSecurityTipsControllerBinding bind11 = ViewLayoutSecurityTipsControllerBinding.bind(findViewById19);
                                                                    i = C1965R.id.stub_camera_set;
                                                                    ViewStub viewStub = (ViewStub) view.findViewById(i);
                                                                    if (viewStub != null) {
                                                                        i = C1965R.id.stub_cancel_action;
                                                                        ViewStub viewStub2 = (ViewStub) view.findViewById(i);
                                                                        if (viewStub2 != null) {
                                                                            i = C1965R.id.stub_dot_line;
                                                                            ViewStub viewStub3 = (ViewStub) view.findViewById(i);
                                                                            if (viewStub3 != null) {
                                                                                i = C1965R.id.stub_grid_line;
                                                                                ViewStub viewStub4 = (ViewStub) view.findViewById(i);
                                                                                if (viewStub4 != null) {
                                                                                    i = C1965R.id.stub_ptz_calibration;
                                                                                    ViewStub viewStub5 = (ViewStub) view.findViewById(i);
                                                                                    if (viewStub5 != null) {
                                                                                        i = C1965R.id.stub_setting;
                                                                                        ViewStub viewStub6 = (ViewStub) view.findViewById(i);
                                                                                        if (viewStub6 != null && (findViewById5 = view.findViewById((i = C1965R.id.stub_six_imu))) != null) {
                                                                                            ViewLayoutSixImuCalibrationControllerBinding bind12 = ViewLayoutSixImuCalibrationControllerBinding.bind(findViewById5);
                                                                                            i = C1965R.id.test_controller_mode;
                                                                                            View findViewById20 = view.findViewById(i);
                                                                                            if (findViewById20 != null) {
                                                                                                ViewLayoutFactoryTestBinding bind13 = ViewLayoutFactoryTestBinding.bind(findViewById20);
                                                                                                i = C1965R.id.tip_view;
                                                                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                                                                                if (linearLayout != null && (findViewById6 = view.findViewById((i = C1965R.id.top_controller))) != null) {
                                                                                                    ViewLayoutTopControllerBinding bind14 = ViewLayoutTopControllerBinding.bind(findViewById6);
                                                                                                    i = C1965R.id.top_controller_mode;
                                                                                                    View findViewById21 = view.findViewById(i);
                                                                                                    if (findViewById21 != null) {
                                                                                                        ViewControllerModeBinding bind15 = ViewControllerModeBinding.bind(findViewById21);
                                                                                                        i = C1965R.id.tv_firmware_upgrade_tips;
                                                                                                        TextView textView = (TextView) view.findViewById(i);
                                                                                                        if (textView != null) {
                                                                                                            i = C1965R.id.tv_select_target_tips;
                                                                                                            TextView textView2 = (TextView) view.findViewById(i);
                                                                                                            if (textView2 != null && (findViewById7 = view.findViewById((i = C1965R.id.view_atomLT_intelligent_mode))) != null) {
                                                                                                                ViewAtomltLeftIntelligentModeBinding bind16 = ViewAtomltLeftIntelligentModeBinding.bind(findViewById7);
                                                                                                                i = C1965R.id.view_camera_quick_setting;
                                                                                                                CameraQuickSettingView cameraQuickSettingView = (CameraQuickSettingView) view.findViewById(i);
                                                                                                                if (cameraQuickSettingView != null && (findViewById8 = view.findViewById((i = C1965R.id.view_intelligent_mode))) != null) {
                                                                                                                    ViewLeftIntelligentModeBinding bind17 = ViewLeftIntelligentModeBinding.bind(findViewById8);
                                                                                                                    i = C1965R.id.view_photo_guide;
                                                                                                                    FrameLayout frameLayout4 = (FrameLayout) view.findViewById(i);
                                                                                                                    if (frameLayout4 != null && (findViewById9 = view.findViewById((i = C1965R.id.view_warn_controller))) != null) {
                                                                                                                        return new ActivityKernelBinding(constraintLayout, findViewById10, bind, frameLayout, frameLayout2, frameLayout3, gimbalScaleView, findViewById2, captureAnimImageView, bind2, constraintLayout, bind3, bind4, bind5, bind6, bind7, bind8, findViewById17, bind9, bind10, bind11, viewStub, viewStub2, viewStub3, viewStub4, viewStub5, viewStub6, bind12, bind13, linearLayout, bind14, bind15, textView, textView2, bind16, cameraQuickSettingView, bind17, frameLayout4, ViewWarnBinding.bind(findViewById9));
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}