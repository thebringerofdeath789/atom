package com.ipotensic.kernel;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.databinding.ActivityBigPackageBindingImpl;
import com.ipotensic.kernel.databinding.FragmentUpgradeQuestionBindingImpl;
import com.ipotensic.kernel.databinding.ViewBigPackageFwTransferFailBindingImpl;
import com.ipotensic.kernel.databinding.ViewBigPackageUpgradeFinishedBindingImpl;
import com.ipotensic.kernel.databinding.ViewDialogBatteryDisclaimerBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutCompassCalibrationBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutFactoryTestBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutGimbalCalibrationBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutGimbalFineTuningBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutPairDroneAgainBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutRemoterControllerCalibrationBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutRightVisionControllerBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingAboutBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingBatteryBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingCalibrationBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingCameraBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingControlBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingImageTransBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingMain1BindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingMainBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingSecurity1BindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingSecurityBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutSettingStickModeBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutTestBindingImpl;
import com.ipotensic.kernel.databinding.ViewLayoutTestMaintainBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYBIGPACKAGE = 1;
    private static final int LAYOUT_FRAGMENTUPGRADEQUESTION = 2;
    private static final int LAYOUT_VIEWBIGPACKAGEFWTRANSFERFAIL = 3;
    private static final int LAYOUT_VIEWBIGPACKAGEUPGRADEFINISHED = 4;
    private static final int LAYOUT_VIEWDIALOGBATTERYDISCLAIMER = 5;
    private static final int LAYOUT_VIEWLAYOUTCOMPASSCALIBRATION = 6;
    private static final int LAYOUT_VIEWLAYOUTFACTORYTEST = 7;
    private static final int LAYOUT_VIEWLAYOUTGIMBALCALIBRATION = 8;
    private static final int LAYOUT_VIEWLAYOUTGIMBALFINETUNING = 9;
    private static final int LAYOUT_VIEWLAYOUTPAIRDRONEAGAIN = 10;
    private static final int LAYOUT_VIEWLAYOUTREMOTERCONTROLLERCALIBRATION = 11;
    private static final int LAYOUT_VIEWLAYOUTRIGHTVISIONCONTROLLER = 12;
    private static final int LAYOUT_VIEWLAYOUTSETTINGABOUT = 13;
    private static final int LAYOUT_VIEWLAYOUTSETTINGBATTERY = 14;
    private static final int LAYOUT_VIEWLAYOUTSETTINGCALIBRATION = 15;
    private static final int LAYOUT_VIEWLAYOUTSETTINGCAMERA = 16;
    private static final int LAYOUT_VIEWLAYOUTSETTINGCONTROL = 17;
    private static final int LAYOUT_VIEWLAYOUTSETTINGIMAGETRANS = 18;
    private static final int LAYOUT_VIEWLAYOUTSETTINGMAIN = 19;
    private static final int LAYOUT_VIEWLAYOUTSETTINGMAIN1 = 20;
    private static final int LAYOUT_VIEWLAYOUTSETTINGSECURITY = 21;
    private static final int LAYOUT_VIEWLAYOUTSETTINGSECURITY1 = 22;
    private static final int LAYOUT_VIEWLAYOUTSETTINGSTICKMODE = 23;
    private static final int LAYOUT_VIEWLAYOUTTEST = 24;
    private static final int LAYOUT_VIEWLAYOUTTESTMAINTAIN = 25;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(25);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_big_package, 1);
        sparseIntArray.put(R.layout.fragment_upgrade_question, 2);
        sparseIntArray.put(R.layout.view_big_package_fw_transfer_fail, 3);
        sparseIntArray.put(R.layout.view_big_package_upgrade_finished, 4);
        sparseIntArray.put(R.layout.view_dialog_battery_disclaimer, 5);
        sparseIntArray.put(R.layout.view_layout_compass_calibration, 6);
        sparseIntArray.put(R.layout.view_layout_factory_test, 7);
        sparseIntArray.put(R.layout.view_layout_gimbal_calibration, 8);
        sparseIntArray.put(R.layout.view_layout_gimbal_fine_tuning, 9);
        sparseIntArray.put(R.layout.view_layout_pair_drone_again, 10);
        sparseIntArray.put(R.layout.view_layout_remoter_controller_calibration, 11);
        sparseIntArray.put(R.layout.view_layout_right_vision_controller, 12);
        sparseIntArray.put(R.layout.view_layout_setting_about, 13);
        sparseIntArray.put(R.layout.view_layout_setting_battery, 14);
        sparseIntArray.put(R.layout.view_layout_setting_calibration, 15);
        sparseIntArray.put(R.layout.view_layout_setting_camera, 16);
        sparseIntArray.put(R.layout.view_layout_setting_control, 17);
        sparseIntArray.put(R.layout.view_layout_setting_image_trans, 18);
        sparseIntArray.put(R.layout.view_layout_setting_main, 19);
        sparseIntArray.put(R.layout.view_layout_setting_main1, 20);
        sparseIntArray.put(R.layout.view_layout_setting_security, 21);
        sparseIntArray.put(R.layout.view_layout_setting_security1, 22);
        sparseIntArray.put(R.layout.view_layout_setting_stick_mode, 23);
        sparseIntArray.put(R.layout.view_layout_test, 24);
        sparseIntArray.put(R.layout.view_layout_test_maintain, 25);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_big_package_0".equals(tag)) {
                    return new ActivityBigPackageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_big_package is invalid. Received: " + tag);
            case 2:
                if ("layout/fragment_upgrade_question_0".equals(tag)) {
                    return new FragmentUpgradeQuestionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_upgrade_question is invalid. Received: " + tag);
            case 3:
                if ("layout/view_big_package_fw_transfer_fail_0".equals(tag)) {
                    return new ViewBigPackageFwTransferFailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_big_package_fw_transfer_fail is invalid. Received: " + tag);
            case 4:
                if ("layout/view_big_package_upgrade_finished_0".equals(tag)) {
                    return new ViewBigPackageUpgradeFinishedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_big_package_upgrade_finished is invalid. Received: " + tag);
            case 5:
                if ("layout/view_dialog_battery_disclaimer_0".equals(tag)) {
                    return new ViewDialogBatteryDisclaimerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_dialog_battery_disclaimer is invalid. Received: " + tag);
            case 6:
                if ("layout/view_layout_compass_calibration_0".equals(tag)) {
                    return new ViewLayoutCompassCalibrationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_compass_calibration is invalid. Received: " + tag);
            case 7:
                if ("layout/view_layout_factory_test_0".equals(tag)) {
                    return new ViewLayoutFactoryTestBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_factory_test is invalid. Received: " + tag);
            case 8:
                if ("layout/view_layout_gimbal_calibration_0".equals(tag)) {
                    return new ViewLayoutGimbalCalibrationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_gimbal_calibration is invalid. Received: " + tag);
            case 9:
                if ("layout/view_layout_gimbal_fine_tuning_0".equals(tag)) {
                    return new ViewLayoutGimbalFineTuningBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_gimbal_fine_tuning is invalid. Received: " + tag);
            case 10:
                if ("layout/view_layout_pair_drone_again_0".equals(tag)) {
                    return new ViewLayoutPairDroneAgainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_pair_drone_again is invalid. Received: " + tag);
            case 11:
                if ("layout/view_layout_remoter_controller_calibration_0".equals(tag)) {
                    return new ViewLayoutRemoterControllerCalibrationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_remoter_controller_calibration is invalid. Received: " + tag);
            case 12:
                if ("layout/view_layout_right_vision_controller_0".equals(tag)) {
                    return new ViewLayoutRightVisionControllerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_right_vision_controller is invalid. Received: " + tag);
            case 13:
                if ("layout/view_layout_setting_about_0".equals(tag)) {
                    return new ViewLayoutSettingAboutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_about is invalid. Received: " + tag);
            case 14:
                if ("layout/view_layout_setting_battery_0".equals(tag)) {
                    return new ViewLayoutSettingBatteryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_battery is invalid. Received: " + tag);
            case 15:
                if ("layout/view_layout_setting_calibration_0".equals(tag)) {
                    return new ViewLayoutSettingCalibrationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_calibration is invalid. Received: " + tag);
            case 16:
                if ("layout/view_layout_setting_camera_0".equals(tag)) {
                    return new ViewLayoutSettingCameraBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_camera is invalid. Received: " + tag);
            case 17:
                if ("layout/view_layout_setting_control_0".equals(tag)) {
                    return new ViewLayoutSettingControlBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_control is invalid. Received: " + tag);
            case 18:
                if ("layout/view_layout_setting_image_trans_0".equals(tag)) {
                    return new ViewLayoutSettingImageTransBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_image_trans is invalid. Received: " + tag);
            case 19:
                if ("layout/view_layout_setting_main_0".equals(tag)) {
                    return new ViewLayoutSettingMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_main is invalid. Received: " + tag);
            case 20:
                if ("layout/view_layout_setting_main1_0".equals(tag)) {
                    return new ViewLayoutSettingMain1BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_main1 is invalid. Received: " + tag);
            case 21:
                if ("layout/view_layout_setting_security_0".equals(tag)) {
                    return new ViewLayoutSettingSecurityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_security is invalid. Received: " + tag);
            case 22:
                if ("layout/view_layout_setting_security1_0".equals(tag)) {
                    return new ViewLayoutSettingSecurity1BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_security1 is invalid. Received: " + tag);
            case 23:
                if ("layout/view_layout_setting_stick_mode_0".equals(tag)) {
                    return new ViewLayoutSettingStickModeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_setting_stick_mode is invalid. Received: " + tag);
            case 24:
                if ("layout/view_layout_test_0".equals(tag)) {
                    return new ViewLayoutTestBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_test is invalid. Received: " + tag);
            case 25:
                if ("layout/view_layout_test_maintain_0".equals(tag)) {
                    return new ViewLayoutTestMaintainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_layout_test_maintain is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.ipotensic.baselib.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(14);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "bigPackageViewModel");
            sparseArray.put(2, "compassCalibrationModel");
            sparseArray.put(3, "gimbalCalibrationModel");
            sparseArray.put(4, "gimbalFineTuningModel");
            sparseArray.put(5, "model");
            sparseArray.put(6, "pairDroneModel");
            sparseArray.put(7, "remoterControllerModel");
            sparseArray.put(8, "settingAboutModel");
            sparseArray.put(9, "settingCameraModel");
            sparseArray.put(10, "settingControlModel");
            sparseArray.put(11, "settingMainModel");
            sparseArray.put(12, "settingSecurityModel");
            sparseArray.put(13, "settingStickMode");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(25);
            sKeys = hashMap;
            hashMap.put("layout/activity_big_package_0", Integer.valueOf(R.layout.activity_big_package));
            hashMap.put("layout/fragment_upgrade_question_0", Integer.valueOf(R.layout.fragment_upgrade_question));
            hashMap.put("layout/view_big_package_fw_transfer_fail_0", Integer.valueOf(R.layout.view_big_package_fw_transfer_fail));
            hashMap.put("layout/view_big_package_upgrade_finished_0", Integer.valueOf(R.layout.view_big_package_upgrade_finished));
            hashMap.put("layout/view_dialog_battery_disclaimer_0", Integer.valueOf(R.layout.view_dialog_battery_disclaimer));
            hashMap.put("layout/view_layout_compass_calibration_0", Integer.valueOf(R.layout.view_layout_compass_calibration));
            hashMap.put("layout/view_layout_factory_test_0", Integer.valueOf(R.layout.view_layout_factory_test));
            hashMap.put("layout/view_layout_gimbal_calibration_0", Integer.valueOf(R.layout.view_layout_gimbal_calibration));
            hashMap.put("layout/view_layout_gimbal_fine_tuning_0", Integer.valueOf(R.layout.view_layout_gimbal_fine_tuning));
            hashMap.put("layout/view_layout_pair_drone_again_0", Integer.valueOf(R.layout.view_layout_pair_drone_again));
            hashMap.put("layout/view_layout_remoter_controller_calibration_0", Integer.valueOf(R.layout.view_layout_remoter_controller_calibration));
            hashMap.put("layout/view_layout_right_vision_controller_0", Integer.valueOf(R.layout.view_layout_right_vision_controller));
            hashMap.put("layout/view_layout_setting_about_0", Integer.valueOf(R.layout.view_layout_setting_about));
            hashMap.put("layout/view_layout_setting_battery_0", Integer.valueOf(R.layout.view_layout_setting_battery));
            hashMap.put("layout/view_layout_setting_calibration_0", Integer.valueOf(R.layout.view_layout_setting_calibration));
            hashMap.put("layout/view_layout_setting_camera_0", Integer.valueOf(R.layout.view_layout_setting_camera));
            hashMap.put("layout/view_layout_setting_control_0", Integer.valueOf(R.layout.view_layout_setting_control));
            hashMap.put("layout/view_layout_setting_image_trans_0", Integer.valueOf(R.layout.view_layout_setting_image_trans));
            hashMap.put("layout/view_layout_setting_main_0", Integer.valueOf(R.layout.view_layout_setting_main));
            hashMap.put("layout/view_layout_setting_main1_0", Integer.valueOf(R.layout.view_layout_setting_main1));
            hashMap.put("layout/view_layout_setting_security_0", Integer.valueOf(R.layout.view_layout_setting_security));
            hashMap.put("layout/view_layout_setting_security1_0", Integer.valueOf(R.layout.view_layout_setting_security1));
            hashMap.put("layout/view_layout_setting_stick_mode_0", Integer.valueOf(R.layout.view_layout_setting_stick_mode));
            hashMap.put("layout/view_layout_test_0", Integer.valueOf(R.layout.view_layout_test));
            hashMap.put("layout/view_layout_test_maintain_0", Integer.valueOf(R.layout.view_layout_test_maintain));
        }
    }
}
