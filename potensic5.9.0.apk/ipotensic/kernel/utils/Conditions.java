package com.ipotensic.kernel.utils;

import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.enums.VisionError;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.controllers.RightController;
import com.ipotensic.kernel.view.dialog.BatteryInstallSafetyDialog;
import com.ipotensic.kernel.view.dialog.WeakSignalDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;
import com.logan.flight.data.recv.FlightRevGimbalStateData;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class Conditions {

    @interface test {
        int unionWith() default -1;
    }

    public static boolean isRecording() {
        RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
        return rightController != null && rightController.isRecording();
    }

    public static boolean isFlying() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isInit() && flightRevStateData.isFlight();
    }

    public static boolean isGpsMode() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isInit() && flightRevStateData.getMode() == 2;
    }

    public static boolean cannotTakeOff() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        boolean z = flightRevStateData.isIs1BatteryDamaged() || flightRevStateData.isIs2BatteryDamaged() || flightRevStateData.isBatteryJump() || flightRevStateData.isBatteryDiffPressure() || flightRevStateData.isBatteryBelowSevenPercent() || flightRevStateData.isBatteryAbnormalAlarm() || flightRevStateData.isBatteryJumpAbnormal() || flightRevStateData.isBatteryTempLow() || flightRevStateData.isBatteryTempHigh() || flightRevStateData.isBatteryFullAbnormalAlarm() || flightRevStateData.isBatterySettingAbnormal();
        FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
        return z || (flightRevFlightInfoData.getRemainedBattery() != -1 && flightRevFlightInfoData.getRemainedBattery() < 5) || FlightRevData.get().getNoFlyZoneData().getIsLocatedNoFlyZone();
    }

    public static boolean isATTIMode() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isInit() && flightRevStateData.getMode() == 0;
    }

    public static boolean isOptiMode() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isInit() && flightRevStateData.getMode() == 1;
    }

    public static boolean isInShortVideo() {
        RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
        return rightController != null && rightController.isExecutingShortVideo();
    }

    public static boolean isTrackTargetOpen() {
        RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
        return rightController != null && rightController.isTrackTargetOpen();
    }

    public static boolean isVisionTracking() {
        RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
        return rightController != null && rightController.isFollowMode();
    }

    public static boolean isPointFly() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isInit() && flightRevStateData.isPointFly();
    }

    public static boolean isTakingOff() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isInit() && flightRevStateData.isTakeOff();
    }

    public static boolean isReturning() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isInit() && flightRevStateData.isReturning();
    }

    public static boolean isLanding() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isInit() && flightRevStateData.isLanding();
    }

    public static boolean isFlightBelow2m() {
        FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
        return flightRevFlightInfoData != null && flightRevFlightInfoData.getVerticalDistance() <= 2.0d;
    }

    public static boolean isGimbalTooSmooth() {
        FlightRevGimbalStateData gimbalStateData = FlightRevData.get().getGimbalStateData();
        return gimbalStateData != null && gimbalStateData.getControl_pitch() >= -15;
    }

    public static boolean isStableMode() {
        FlightRevGimbalSettingData gimbalSettingData = FlightRevData.get().getGimbalSettingData();
        return gimbalSettingData != null && gimbalSettingData.isInit() && gimbalSettingData.isStableMode();
    }

    public static boolean isNewMagCalSystem() {
        return FlightConfig.is_Atom_Series() && FlightRevData.get().getFlightRevVersionData().isInit() && CommonUtil.hasNewVersion("1.9.6", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion());
    }

    public static boolean isQuickShotTeachVideoPlayed(VisionExecuteType visionExecuteType, boolean z) {
        if (z) {
            return SPHelper.getInstance().isFollowTeachVideoPlayed();
        }
        int i = AnonymousClass1.$SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[visionExecuteType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        if (!SPHelper.getInstance().isSkywardTeachVideoPlayed()) {
                            return false;
                        }
                    } else if (i == 5 && !SPHelper.getInstance().isRecessTeachVideoPlayed()) {
                        return false;
                    }
                } else if (!SPHelper.getInstance().isCometTeachVideoPlayed()) {
                    return false;
                }
            } else if (!SPHelper.getInstance().isScrewTeachVideoPlayed()) {
                return false;
            }
        } else if (!SPHelper.getInstance().isCircleTeachVideoPlayed()) {
            return false;
        }
        return true;
    }

    /* renamed from: com.ipotensic.kernel.utils.Conditions$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType;

        static {
            int[] iArr = new int[VisionExecuteType.values().length];
            $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType = iArr;
            try {
                iArr[VisionExecuteType.TYPE_CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[VisionExecuteType.TYPE_SCREW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[VisionExecuteType.TYPE_COMET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[VisionExecuteType.TYPE_SKYWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[VisionExecuteType.TYPE_RECESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static VisionError checkConditionError(int i) {
        float pitch = FlightRevData.get().getGimbalStateData().isInit() ? r0.getPitch() : 0.0f;
        FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
        float verticalDistance = flightRevFlightInfoData.isInit() ? (float) flightRevFlightInfoData.getVerticalDistance() : 0.0f;
        float f = i == 6 ? 25.0f : 15.0f;
        float f2 = -pitch;
        if (f2 > 75.0f) {
            return VisionError.ERROR_GIMBAL_ANGLE_TOO_BIG;
        }
        if (f2 < f) {
            return VisionError.ERROR_GIMBAL_TOO_SMOOTH;
        }
        float f3 = i == 6 ? 4.0f : 2.0f;
        FlightRevGeoTestData geoTestData = FlightRevData.get().getGeoTestData();
        if (geoTestData.isInit()) {
            float tofHeight = geoTestData.getTofHeight();
            if (geoTestData.getTofPrecision() <= 2000.0f && tofHeight > 0.0f && tofHeight < f3) {
                return VisionError.ERROR_HEIGHT_TOO_LOW;
            }
        }
        if (verticalDistance < f3) {
            return VisionError.ERROR_HEIGHT_TOO_LOW;
        }
        if (((float) (verticalDistance / (Math.tan((f2 * 3.141592653589793d) / 180.0d) + 0.0010000000474974513d))) < 3.0f) {
            return VisionError.ERROR_TARGET_TOO_CLOSE;
        }
        return null;
    }

    public static boolean isShowBatteryInstallSafetyDialog() {
        return (!FlightConfig.is_Atom_Series() || BatteryInstallSafetyDialog.isUserConfirm() || SPHelper.getInstance().getBoolean(SPHelper.KEY_BATTERY_INSTALL_DIALOG_NO_LONGER_SHOW, false)) ? false : true;
    }

    public static boolean isShowWeakSignalDialog() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return (!flightRevStateData.isInit() || !flightRevStateData.isFlight() || flightRevStateData.isReturning() || flightRevStateData.isLanding() || flightRevStateData.isHotCircle() || flightRevStateData.isFollowing() || flightRevStateData.isPointFly() || isInShortVideo() || !FlightConfig.is_Atom_Series() || WeakSignalDialog.isUserConfirm() || SPHelper.getInstance().getBoolean(SPHelper.KEY_WEAK_SIGNAL_DIALOG_NO_LONGER_SHOW, false)) ? false : true;
    }
}