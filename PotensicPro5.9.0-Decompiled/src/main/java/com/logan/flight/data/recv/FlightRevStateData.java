package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.FlightConfig;
import com.logan.flight.enums.CtrlType;
import com.mapbox.android.accounts.v1.MapboxAccounts;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class FlightRevStateData extends BaseFlightRevData implements Cloneable {
    public static final int MODE_ATTITUDE = 0;
    public static final int MODE_GPS = 2;
    public static final int MODE_NORMAL_POWER = 0;
    public static final int MODE_ONE_LOW_POWER = 1;
    public static final int MODE_OPTICAL_FLOW = 1;
    public static final int MODE_TWO_LOW_POWER = 2;
    private boolean beyondLimitDistanceFail;
    private boolean beyondLimitHeightFail;
    private int countDown;
    private CtrlType ctrlType;
    private boolean heightLowFollowOpenFail;
    private boolean is1BatteryDamaged;
    private boolean is24gRemoterVersion;
    private boolean is2BatteryDamaged;
    private boolean isAbnormalBatteryTemperature;
    private boolean isAllowShortVideo;
    private boolean isBatteryAbnormal;
    private boolean isBatteryAbnormalAlarm;
    private boolean isBatteryBelowSevenPercent;
    private boolean isBatteryChargingMode;
    private boolean isBatteryDiffPressure;
    private boolean isBatteryDischargeMode;
    private boolean isBatteryFullAbnormalAlarm;
    private boolean isBatteryHighPress;
    private boolean isBatteryJump;
    private boolean isBatteryJumpAbnormal;
    private boolean isBatteryLowTempAlarm;
    private boolean isBatterySettingAbnormal;
    private boolean isBatteryTempHigh;
    private boolean isBatteryTempLow;
    private boolean isEmergencyStop;
    private boolean isEndEscBeep;
    private boolean isEscFourthCheckPaddlesIntact;
    private boolean isEscFourthFault;
    private boolean isEscFourthHighTemp;
    private boolean isEscOneCheckPaddlesIntact;
    private boolean isEscOneFault;
    private boolean isEscOneHighTemp;
    private boolean isEscThirdCheckPaddlesIntact;
    private boolean isEscThirdFault;
    private boolean isEscThirdHighTemp;
    private boolean isEscTwoCheckPaddlesIntact;
    private boolean isEscTwoFault;
    private boolean isEscTwoHighTemp;
    private boolean isEvAddWorked;
    private boolean isEvReduceWorked;
    private boolean isExecutingShortVideo;
    private boolean isExitSmartMode;
    private boolean isFastStopMode;
    private boolean isFindingDrone;
    private boolean isFlight;
    private boolean isFlightControlShutdownNotification;
    private boolean isFlightInNoFlyZone;
    private boolean isFlightInUpgrade;
    private boolean isFlightIncline;
    private boolean isFlightInclineOver35;
    private boolean isFollowing;
    private boolean isGPS;
    private boolean isGeoCalibration;
    private boolean isGeoCalibrationFailureFlag;
    private boolean isGeoTooMuchInterfere;
    private boolean isGeomagneticFault;
    private boolean isGimbalNotReady;
    private boolean isGpsConnectError;
    private boolean isGpsInterference;
    private boolean isGpsLocationValid;
    private boolean isGpsSpeedValid;
    private boolean isGyroscopeCalibrating;
    private boolean isHighSpeedMode;
    private boolean isHotCircle;
    private boolean isImuPreparing;
    private boolean isLanding;
    private boolean isLastCalOver50km;
    private boolean isLowPowerMode;
    private boolean isMagnetometerHorizontalCalibrating;
    private boolean isMagnetometerVerticalCalibrating;
    private boolean isMotorFourthFullPower;
    private boolean isMotorFourthOverCurrent;
    private boolean isMotorFourthStuck;
    private boolean isMotorOneFullPower;
    private boolean isMotorOneOverCurrent;
    private boolean isMotorOneStuck;
    private boolean isMotorThirdFullPower;
    private boolean isMotorThirdOverCurrent;
    private boolean isMotorThirdStuck;
    private boolean isMotorTwoFullPower;
    private boolean isMotorTwoOverCurrent;
    private boolean isMotorTwoStuck;
    private boolean isMpuError;
    private boolean isNeedCalibration;
    private boolean isNetWorkFault;
    private boolean isNewBattery;
    private boolean isNewerMode;
    private boolean isNoHeadMode;
    private boolean isNotAllowTakeOff;
    private boolean isNotEnterFollowMe;
    private boolean isOPTIAllowHighest;
    private boolean isOpticalFlow;
    private boolean isOpticalFlowAbnormal;
    private boolean isOpticalFlowErrorInAtom;
    private boolean isOutdoor;
    private boolean isPTZAttitudeAbnormal;
    private boolean isPTZFlashError;
    private boolean isPTZGyroscopeFault;
    private boolean isPTZMotorAbnormal;
    private boolean isPlaneExceedLimitDistance;
    private boolean isPlaneExceedLimitHigh;
    private boolean isPointFly;
    private boolean isPointFlyFinished;
    private boolean isPreEscBeep;
    private boolean isPressureError;
    private boolean isReceiveGps;
    private boolean isRecord;
    private boolean isRecordCallback;
    private boolean isRemoterConnected;
    private boolean isReturnCountdown;
    private boolean isReturning;
    private boolean isShortVideoBack;
    private boolean isShowLandOrGoHome;
    private boolean isSixCalibrationComplete;
    private boolean isSmartBatteryAbnormal;
    private boolean isSwoopReturn;
    private boolean isTakeOff;
    private boolean isTakePhoto;
    private boolean isTakePhotoCallback;
    private boolean isTofFault;
    private boolean isTofInvalid;
    private boolean isTooWeakGps;
    private boolean isUnLock;
    private boolean newModeBeyondLimitDistance;
    private boolean newModeBeyondLimitHeight;
    private int powerMode;
    private int shortVideoPercent;
    private boolean speedModeNewModeFail;
    private int swoopReturnCountDown;
    private int speedMode = -1;
    private int mode = 2;
    private byte[] flightInfoBytes = new byte[6];

    @Retention(RetentionPolicy.SOURCE)
    public @interface WorkMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface powerMode {
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        byte[] bArr2 = this.flightInfoBytes;
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        byte b = bArr[i];
        this.isUnLock = ParseUtil.getBit(b, 0) == 1;
        this.isFlight = ParseUtil.getBit(b, 1) == 1;
        this.isReceiveGps = ParseUtil.getBit(b, 2) == 1;
        this.isFollowing = ParseUtil.getBit(b, 3) == 1;
        this.isHotCircle = ParseUtil.getBit(b, 4) == 1;
        this.isPointFlyFinished = ParseUtil.getBit(b, 5) == 0 && this.isPointFly;
        this.isPointFly = ParseUtil.getBit(b, 5) == 1;
        this.isReturning = ParseUtil.getBit(b, 6) == 1;
        this.isLanding = ParseUtil.getBit(b, 7) == 1;
        byte b2 = bArr[i + 1];
        this.isGyroscopeCalibrating = ParseUtil.getBit(b2, 0) == 1;
        this.isMagnetometerHorizontalCalibrating = ParseUtil.getBit(b2, 1) == 1;
        this.isMagnetometerVerticalCalibrating = ParseUtil.getBit(b2, 2) == 1;
        this.isRemoterConnected = ParseUtil.getBit(b2, 3) == 1;
        this.isTakeOff = ParseUtil.getBit(b2, 4) == 1;
        this.isTofInvalid = ParseUtil.getBit(b2, 5) == 1;
        this.isNoHeadMode = ParseUtil.getBit(b2, 6) == 1;
        this.isFastStopMode = ParseUtil.getBit(b2, 7) == 1;
        byte b3 = bArr[i + 2];
        this.isNewerMode = ParseUtil.getBit(b3, 2) == 1;
        if (ParseUtil.getBit(b3, 3) == 0 && ParseUtil.getBit(b3, 4) == 0) {
            this.mode = 0;
        } else if (ParseUtil.getBit(b3, 3) == 1 && ParseUtil.getBit(b3, 4) == 0) {
            this.mode = 2;
        } else if (ParseUtil.getBit(b3, 3) == 0 && ParseUtil.getBit(b3, 4) == 1) {
            this.mode = 1;
        }
        this.isSixCalibrationComplete = ParseUtil.getBit(b3, 5) == 1;
        if (FlightConfig.curFlight != null) {
            if (!FlightConfig.isOldProduct()) {
                this.isAbnormalBatteryTemperature = false;
                this.isBatteryHighPress = false;
                String allBit = ParseUtil.getAllBit(b3);
                if (allBit.startsWith(MapboxAccounts.SKU_ID_MAPS_MAUS)) {
                    this.speedMode = 0;
                } else if (allBit.startsWith("01")) {
                    this.speedMode = 1;
                } else if (allBit.startsWith("10")) {
                    this.speedMode = 2;
                }
                if (allBit.endsWith(MapboxAccounts.SKU_ID_MAPS_MAUS)) {
                    this.isLowPowerMode = false;
                    this.powerMode = 0;
                } else if (allBit.endsWith("01")) {
                    this.isLowPowerMode = true;
                    this.powerMode = 1;
                } else if (allBit.endsWith("10")) {
                    this.isLowPowerMode = true;
                    this.powerMode = 2;
                }
            } else {
                this.isHighSpeedMode = ParseUtil.getBit(b3, 0) == 1;
                this.isLowPowerMode = ParseUtil.getBit(b3, 1) == 1;
                this.isAbnormalBatteryTemperature = ParseUtil.getBit(b3, 6) == 1;
                this.isBatteryHighPress = ParseUtil.getBit(b3, 7) == 1;
            }
        }
        byte b4 = bArr[i + 3];
        this.isMpuError = ParseUtil.getBit(b4, 0) == 1;
        this.isPressureError = ParseUtil.getBit(b4, 1) == 1;
        this.isGpsConnectError = ParseUtil.getBit(b4, 2) == 1;
        this.isGeoTooMuchInterfere = ParseUtil.getBit(b4, 3) == 1;
        this.isReturnCountdown = ParseUtil.getBit(b4, 4) == 1;
        if (FlightConfig.curFlight != null) {
            if (FlightConfig.is_Atom_Series()) {
                if (this.mode != 2) {
                    this.isTooWeakGps = false;
                }
            } else {
                this.isTooWeakGps = ParseUtil.getBit(b4, 5) == 1;
            }
        }
        this.isSmartBatteryAbnormal = ParseUtil.getBit(b4, 6) == 1;
        this.isNeedCalibration = ParseUtil.getBit(b4, 7) == 1;
        if (FlightConfig.curFlight != null) {
            byte b5 = bArr[i + 4];
            if (FlightConfig.is_Atom_Series()) {
                this.isOpticalFlowAbnormal = ParseUtil.getBit(b5, 0) == 1;
                this.isOpticalFlowErrorInAtom = ParseUtil.getBit(b5, 1) == 1;
            } else {
                this.isTakePhoto = ParseUtil.getBit(b5, 0) == 1;
                this.isRecord = ParseUtil.getBit(b5, 1) == 1;
                this.isTakePhotoCallback = ParseUtil.getBit(b5, 2) == 1;
                this.isRecordCallback = ParseUtil.getBit(b5, 3) == 1;
                this.isEvAddWorked = ParseUtil.getBit(b5, 4) == 1;
                this.isEvReduceWorked = ParseUtil.getBit(b5, 5) == 1;
                this.isFlightControlShutdownNotification = ParseUtil.getBit(b5, 6) == 1;
                this.is24gRemoterVersion = ParseUtil.getBit(b5, 7) == 1;
            }
        }
        byte b6 = bArr[i + 5];
        this.isGeomagneticFault = ParseUtil.getBit(b6, 0) == 1;
        this.isGeoCalibrationFailureFlag = ParseUtil.getBit(b6, 1) == 1;
        this.isNetWorkFault = ParseUtil.getBit(b6, 2) == 1;
        this.isPlaneExceedLimitDistance = ParseUtil.getBit(b6, 3) == 1;
        this.isPlaneExceedLimitHigh = ParseUtil.getBit(b6, 4) == 1;
        this.isEmergencyStop = ParseUtil.getBit(b6, 5) == 1;
        this.isTofFault = ParseUtil.getBit(b6, 6) == 1;
        this.isOpticalFlow = ParseUtil.getBit(b6, 7) == 1;
        int i2 = i + 8;
        if (bArr.length >= i2) {
            byte b7 = bArr[i + 6];
            this.isPTZMotorAbnormal = ParseUtil.getBit(b7, 0) == 1;
            this.isPTZGyroscopeFault = ParseUtil.getBit(b7, 1) == 1;
            this.isPTZFlashError = ParseUtil.getBit(b7, 2) == 1;
            this.isPTZAttitudeAbnormal = ParseUtil.getBit(b7, 3) == 1;
        }
        int i3 = i + 9;
        if (bArr.length >= i3) {
            byte b8 = bArr[i + 7];
            this.newModeBeyondLimitDistance = ParseUtil.getBit(b8, 0) == 1;
            this.newModeBeyondLimitHeight = ParseUtil.getBit(b8, 1) == 1;
            this.speedModeNewModeFail = ParseUtil.getBit(b8, 2) == 1;
            this.beyondLimitDistanceFail = ParseUtil.getBit(b8, 3) == 1;
            this.beyondLimitHeightFail = ParseUtil.getBit(b8, 4) == 1;
            this.heightLowFollowOpenFail = ParseUtil.getBit(b8, 5) == 1;
            this.isGpsInterference = ParseUtil.getBit(b8, 6) == 1;
            this.isOutdoor = ParseUtil.getBit(b8, 7) == 1;
        }
        int i4 = i + 10;
        if (bArr.length >= i4) {
            byte b9 = bArr[i2];
            this.is1BatteryDamaged = ParseUtil.getBit(b9, 0) == 1;
            this.is2BatteryDamaged = ParseUtil.getBit(b9, 1) == 1;
            this.isBatterySettingAbnormal = ParseUtil.getBit(b9, 2) == 1;
            this.isBatteryDiffPressure = ParseUtil.getBit(b9, 3) == 1;
            this.isBatteryJump = ParseUtil.getBit(b9, 4) == 1;
            this.isBatteryTempLow = ParseUtil.getBit(b9, 5) == 1;
            this.isBatteryTempHigh = ParseUtil.getBit(b9, 6) == 1;
            this.isNewBattery = ParseUtil.getBit(b9, 7) == 1;
        }
        int i5 = i + 11;
        if (bArr.length >= i5) {
            byte b10 = bArr[i3];
            this.isBatteryChargingMode = ParseUtil.getBit(b10, 0) == 1;
            this.isBatteryDischargeMode = ParseUtil.getBit(b10, 1) == 1;
            this.isBatteryBelowSevenPercent = ParseUtil.getBit(b10, 2) == 1;
            this.isBatteryAbnormalAlarm = ParseUtil.getBit(b10, 3) == 1;
            this.isBatteryJumpAbnormal = ParseUtil.getBit(b10, 4) == 1;
            this.isBatteryLowTempAlarm = ParseUtil.getBit(b10, 6) == 1;
            this.isBatteryFullAbnormalAlarm = ParseUtil.getBit(b10, 7) == 1;
        }
        int i6 = i + 12;
        if (bArr.length >= i6) {
            this.shortVideoPercent = ParseUtil.getUnsignedByte(bArr[i4]);
        }
        int i7 = i + 13;
        if (bArr.length >= i7) {
            byte b11 = bArr[i5];
            this.isExitSmartMode = ParseUtil.getBit(b11, 0) == 1;
            this.isNotAllowTakeOff = ParseUtil.getBit(b11, 1) == 1;
            this.isGpsSpeedValid = ParseUtil.getBit(b11, 2) == 1;
            this.isGpsLocationValid = ParseUtil.getBit(b11, 3) == 1;
            this.isNotEnterFollowMe = ParseUtil.getBit(b11, 4) == 1;
            this.isShortVideoBack = ParseUtil.getBit(b11, 5) == 1;
            this.isExecutingShortVideo = ParseUtil.getBit(b11, 6) == 1;
            this.isOPTIAllowHighest = ParseUtil.getBit(b11, 7) == 1;
        }
        int i8 = i + 14;
        if (bArr.length >= i8) {
            byte b12 = bArr[i6];
            this.isShowLandOrGoHome = ParseUtil.getBit(b12, 0) == 1;
            int bit = ParseUtil.getBit(b12, 1);
            int bit2 = ParseUtil.getBit(b12, 2);
            if (bit2 == 0 && bit == 0) {
                this.ctrlType = CtrlType.TYPE_LOST_RETURN_TO_120M;
            } else if (bit2 == 0 && bit == 1) {
                this.ctrlType = CtrlType.TYPE_LOST_HOVER;
            } else if (bit2 == 1 && bit == 0) {
                this.ctrlType = CtrlType.TYPE_LOST_LAND;
            } else {
                this.ctrlType = CtrlType.TYPE_LOST_RETURN;
            }
        }
        int i9 = i + 15;
        if (bArr.length >= i9) {
            byte b13 = bArr[i7];
            this.isBatteryAbnormal = ParseUtil.getBit(b13, 0) == 1;
            this.isGeoCalibration = ParseUtil.getBit(b13, 1) == 1;
            this.isFlightIncline = ParseUtil.getBit(b13, 2) == 1;
            this.isLastCalOver50km = ParseUtil.getBit(b13, 3) == 1;
            this.isGimbalNotReady = ParseUtil.getBit(b13, 4) == 1;
            this.isFlightInclineOver35 = ParseUtil.getBit(b13, 5) == 1;
            this.isFlightInNoFlyZone = ParseUtil.getBit(b13, 6) == 1;
            this.isFlightInUpgrade = ParseUtil.getBit(b13, 7) == 1;
        }
        int i10 = i + 16;
        if (bArr.length >= i10) {
            byte b14 = bArr[i8];
            this.isImuPreparing = ParseUtil.getBit(b14, 0) == 1;
            this.isFindingDrone = ParseUtil.getBit(b14, 7) == 1;
        }
        int i11 = i + 17;
        if (bArr.length >= i11) {
            this.isPreEscBeep = bArr[i9] != 0;
        }
        int i12 = i + 18;
        if (bArr.length >= i12) {
            this.isEndEscBeep = bArr[i10] != 0;
        }
        int i13 = i + 19;
        if (bArr.length >= i13) {
            byte b15 = bArr[i11];
            this.isMotorOneFullPower = ParseUtil.getBit(b15, 0) == 1;
            this.isMotorOneStuck = ParseUtil.getBit(b15, 1) == 1;
            this.isMotorOneOverCurrent = ParseUtil.getBit(b15, 2) == 1;
            this.isEscOneFault = ParseUtil.getBit(b15, 3) == 1;
            this.isEscOneHighTemp = ParseUtil.getBit(b15, 4) == 1;
            this.isEscOneCheckPaddlesIntact = ParseUtil.getBit(b15, 5) == 1;
        }
        int i14 = i + 20;
        if (bArr.length >= i14) {
            byte b16 = bArr[i12];
            this.isMotorTwoFullPower = ParseUtil.getBit(b16, 0) == 1;
            this.isMotorTwoStuck = ParseUtil.getBit(b16, 1) == 1;
            this.isMotorTwoOverCurrent = ParseUtil.getBit(b16, 2) == 1;
            this.isEscTwoFault = ParseUtil.getBit(b16, 3) == 1;
            this.isEscTwoHighTemp = ParseUtil.getBit(b16, 4) == 1;
            this.isEscTwoCheckPaddlesIntact = ParseUtil.getBit(b16, 5) == 1;
        }
        int i15 = i + 21;
        if (bArr.length >= i15) {
            byte b17 = bArr[i13];
            this.isMotorThirdFullPower = ParseUtil.getBit(b17, 0) == 1;
            this.isMotorThirdStuck = ParseUtil.getBit(b17, 1) == 1;
            this.isMotorThirdOverCurrent = ParseUtil.getBit(b17, 2) == 1;
            this.isEscThirdFault = ParseUtil.getBit(b17, 3) == 1;
            this.isEscThirdHighTemp = ParseUtil.getBit(b17, 4) == 1;
            this.isEscThirdCheckPaddlesIntact = ParseUtil.getBit(b17, 5) == 1;
        }
        int i16 = i + 22;
        if (bArr.length >= i16) {
            byte b18 = bArr[i14];
            this.isMotorFourthFullPower = ParseUtil.getBit(b18, 0) == 1;
            this.isMotorFourthStuck = ParseUtil.getBit(b18, 1) == 1;
            this.isMotorFourthOverCurrent = ParseUtil.getBit(b18, 2) == 1;
            this.isEscFourthFault = ParseUtil.getBit(b18, 3) == 1;
            this.isEscFourthHighTemp = ParseUtil.getBit(b18, 4) == 1;
            this.isEscFourthCheckPaddlesIntact = ParseUtil.getBit(b18, 5) == 1;
        }
        if (bArr.length >= i + 23) {
            this.countDown = bArr[i15] & 15;
        }
        if (bArr.length >= i + 24) {
            byte b19 = bArr[i16];
            this.swoopReturnCountDown = b19 & 15;
            this.isSwoopReturn = ParseUtil.getBit(b19, 4) == 1;
            this.isAllowShortVideo = ParseUtil.getBit(b19, 6) == 0;
        }
    }

    public CtrlType getCtrlType() {
        return this.ctrlType;
    }

    public boolean isBatteryAbnormal() {
        return this.isBatteryAbnormal;
    }

    public boolean isGeoCalibration() {
        return this.isGeoCalibration;
    }

    public boolean isFlightIncline() {
        return this.isFlightIncline;
    }

    public boolean isLastCalOver50km() {
        return this.isLastCalOver50km;
    }

    public boolean isGimbalNotReady() {
        return this.isGimbalNotReady;
    }

    public boolean isFlightInclineOver35() {
        return this.isFlightInclineOver35;
    }

    public boolean isFlightInNoFlyZone() {
        return this.isFlightInNoFlyZone;
    }

    public boolean isFlightInUpgrade() {
        return this.isFlightInUpgrade;
    }

    public boolean isShowLandOrGoHome() {
        return this.isShowLandOrGoHome;
    }

    public boolean isOPTIAllowHighest() {
        return this.isOPTIAllowHighest;
    }

    public boolean isExitSmartMode() {
        return this.isExitSmartMode;
    }

    public boolean isNotAllowTakeOff() {
        return this.isNotAllowTakeOff;
    }

    public boolean isGpsSpeedValid() {
        return this.isGpsSpeedValid;
    }

    public boolean isGpsLocationValid() {
        return this.isGpsLocationValid;
    }

    public boolean isNotEnterFollowMe() {
        return this.isNotEnterFollowMe;
    }

    public boolean isImuPreparing() {
        return this.isImuPreparing;
    }

    public boolean isFindingDrone() {
        return this.isFindingDrone;
    }

    public int getPowerMode() {
        return this.powerMode;
    }

    public boolean isLowBattery() {
        int i = this.powerMode;
        return i == 1 || i == 2;
    }

    public boolean isPTZAttitudeAbnormal() {
        return this.isPTZAttitudeAbnormal;
    }

    public boolean isBatteryTempHigh() {
        return this.isBatteryTempHigh;
    }

    public boolean isBatteryTempLow() {
        return this.isBatteryTempLow;
    }

    public boolean isBatteryJumpAbnormal() {
        return this.isBatteryJumpAbnormal;
    }

    public boolean isBatteryLowTempAlarm() {
        return this.isBatteryLowTempAlarm;
    }

    public boolean isBatteryFullAbnormalAlarm() {
        return this.isBatteryFullAbnormalAlarm;
    }

    public boolean isBatteryBelowSevenPercent() {
        return this.isBatteryBelowSevenPercent;
    }

    public boolean isBatterySettingAbnormal() {
        return this.isBatterySettingAbnormal;
    }

    public boolean isBatteryDiffPressure() {
        return this.isBatteryDiffPressure;
    }

    public boolean isGpsInterference() {
        return this.isGpsInterference;
    }

    public boolean isOutdoor() {
        return this.isOutdoor;
    }

    public boolean isBatteryAbnormalAlarm() {
        return this.isBatteryAbnormalAlarm;
    }

    public boolean isSixCalibrationComplete() {
        return this.isSixCalibrationComplete;
    }

    public boolean isNewModeBeyondLimitDistance() {
        return this.newModeBeyondLimitDistance;
    }

    public boolean isNewModeBeyondLimitHeight() {
        return this.newModeBeyondLimitHeight;
    }

    public boolean isSpeedModeNewModeFail() {
        return this.speedModeNewModeFail;
    }

    public boolean isBeyondLimitDistanceFail() {
        return this.beyondLimitDistanceFail;
    }

    public boolean isBeyondLimitHeightFail() {
        return this.beyondLimitHeightFail;
    }

    public boolean isHeightLowFollowOpenFail() {
        return this.heightLowFollowOpenFail;
    }

    public boolean isAbnormalBatteryTemperature() {
        return this.isAbnormalBatteryTemperature;
    }

    public byte[] getFlightInfoBytes() {
        return this.flightInfoBytes;
    }

    public boolean isUnLock() {
        return this.isUnLock;
    }

    public boolean isTakeOff() {
        return this.isTakeOff;
    }

    public boolean isReceiveGps() {
        return this.isReceiveGps;
    }

    public boolean isOpticalFlowAbnormal() {
        return this.isOpticalFlowAbnormal;
    }

    public boolean isFollowing() {
        return this.isFollowing;
    }

    public boolean isHotCircle() {
        return this.isHotCircle;
    }

    public boolean isPointFly() {
        return this.isPointFly;
    }

    public boolean isPointFlyFinished() {
        return this.isPointFlyFinished;
    }

    public boolean isReturning() {
        return this.isReturning;
    }

    public boolean isLanding() {
        return this.isLanding;
    }

    public boolean isGyroscopeCalibrating() {
        return this.isGyroscopeCalibrating;
    }

    public boolean isMagnetometerHorizontalCalibrating() {
        return this.isMagnetometerHorizontalCalibrating;
    }

    public boolean isMagnetometerVerticalCalibrating() {
        return this.isMagnetometerVerticalCalibrating;
    }

    public boolean isRemoterConnected() {
        return this.isRemoterConnected;
    }

    public boolean isNoHeadMode() {
        return this.isNoHeadMode;
    }

    public boolean isFastStopMode() {
        return this.isFastStopMode;
    }

    public int getSpeedMode() {
        return this.speedMode;
    }

    public boolean isHighSpeedMode() {
        return this.isHighSpeedMode;
    }

    public boolean isLowPowerMode() {
        return this.isLowPowerMode;
    }

    public int getPowMode() {
        return this.powerMode;
    }

    public boolean isNewerMode() {
        return this.isNewerMode;
    }

    public boolean isFlight() {
        return this.isFlight;
    }

    public int getMode() {
        return this.mode;
    }

    public boolean isMpuError() {
        return this.isMpuError;
    }

    public boolean isPressureError() {
        return this.isPressureError;
    }

    public boolean isGpsConnectError() {
        return this.isGpsConnectError;
    }

    public boolean isGeoTooMuchInterfere() {
        return this.isGeoTooMuchInterfere;
    }

    public boolean isReturnCountdown() {
        return this.isReturnCountdown;
    }

    public boolean isTooWeakGps() {
        return this.isTooWeakGps;
    }

    public boolean isTakePhoto() {
        return this.isTakePhoto;
    }

    public boolean isRecord() {
        return this.isRecord;
    }

    public boolean isTakePhotoCallback() {
        return this.isTakePhotoCallback;
    }

    public boolean isRecordCallback() {
        return this.isRecordCallback;
    }

    public boolean isEvAddWorked() {
        return this.isEvAddWorked;
    }

    public boolean isEvReduceWorked() {
        return this.isEvReduceWorked;
    }

    public boolean isIs24gRemoterVersion() {
        return this.is24gRemoterVersion;
    }

    public boolean isSmartBatteryAbnormal() {
        return this.isSmartBatteryAbnormal;
    }

    public boolean isFlightControlShutdownNotification() {
        return this.isFlightControlShutdownNotification;
    }

    public boolean isGeomagneticFault() {
        return this.isGeomagneticFault;
    }

    public boolean isGeoCalibrationFailureFlag() {
        return this.isGeoCalibrationFailureFlag;
    }

    public boolean isNetWorkFault() {
        return this.isNetWorkFault;
    }

    public boolean isPlaneExceedLimitDistance() {
        return this.isPlaneExceedLimitDistance;
    }

    public void setPlaneExceedLimitDistance() {
        this.isPlaneExceedLimitDistance = true;
    }

    public void setPlaneExceedLimitHigh() {
        this.isPlaneExceedLimitHigh = true;
    }

    public boolean isPlaneExceedLimitHigh() {
        return this.isPlaneExceedLimitHigh;
    }

    public boolean isNeedCalibration() {
        return this.isNeedCalibration;
    }

    public boolean isEmergencyStop() {
        return this.isEmergencyStop;
    }

    public boolean isTofFault() {
        return this.isTofFault;
    }

    public boolean isOpticalFlow() {
        return this.isOpticalFlow;
    }

    public boolean isBatteryHighPress() {
        return this.isBatteryHighPress;
    }

    public boolean isPTZMotorAbnormal() {
        return this.isPTZMotorAbnormal;
    }

    public boolean isPTZGyroscopeFault() {
        return this.isPTZGyroscopeFault;
    }

    public boolean isPTZFlashError() {
        return this.isPTZFlashError;
    }

    public boolean isTofInvalid() {
        return this.isTofInvalid;
    }

    public boolean isIs1BatteryDamaged() {
        return this.is1BatteryDamaged;
    }

    public boolean isIs2BatteryDamaged() {
        return this.is2BatteryDamaged;
    }

    public boolean isBatteryJump() {
        return this.isBatteryJump;
    }

    public boolean isNewBattery() {
        return this.isNewBattery;
    }

    public int getShortVideoPercent() {
        return this.shortVideoPercent;
    }

    public boolean isShortVideoBack() {
        return this.isShortVideoBack;
    }

    public boolean isFlightExecutingShortVideo() {
        return this.isExecutingShortVideo;
    }

    public boolean isOpticalFlowErrorInAtom() {
        return this.isOpticalFlowErrorInAtom;
    }

    public int getCountDown() {
        return this.countDown;
    }

    public boolean isMotorFullPower() {
        return this.isMotorOneFullPower || this.isMotorTwoFullPower || this.isMotorThirdFullPower || this.isMotorFourthFullPower;
    }

    public boolean isMotorStuck() {
        return this.isMotorOneStuck || this.isMotorTwoStuck || this.isMotorThirdStuck || this.isMotorFourthStuck;
    }

    public boolean isMotorOverCurrent() {
        return this.isMotorOneOverCurrent || this.isMotorTwoOverCurrent || this.isMotorThirdOverCurrent || this.isMotorFourthOverCurrent;
    }

    public boolean isEscFault() {
        return this.isEscOneFault || this.isEscTwoFault || this.isEscThirdFault || this.isEscFourthFault;
    }

    public boolean isEscHighTemp() {
        return this.isEscOneHighTemp || this.isEscTwoHighTemp || this.isEscThirdHighTemp || this.isEscFourthHighTemp;
    }

    public boolean isEscCheckPaddledIntact() {
        return this.isEscOneCheckPaddlesIntact || this.isEscTwoCheckPaddlesIntact || this.isEscThirdCheckPaddlesIntact || this.isEscFourthCheckPaddlesIntact;
    }

    public boolean isEscBeep() {
        return this.isPreEscBeep || this.isEndEscBeep;
    }

    public int getSwoopReturnCountDown() {
        return this.swoopReturnCountDown;
    }

    public boolean isSwoopReturn() {
        return this.isSwoopReturn;
    }

    public boolean isAllowShortVideo() {
        return this.isAllowShortVideo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.isUnLock) {
            sb.append("\n 解锁");
        }
        if (this.isTakeOff) {
            sb.append("\n 起飞中");
        }
        if (this.isReceiveGps) {
            sb.append("\n 收到gps信息");
        }
        if (this.isFollowing) {
            sb.append("\n 跟随模式");
        }
        if (this.isHotCircle) {
            sb.append("\n 环绕模式");
        }
        if (this.isPointFly) {
            sb.append("\n 指点飞行模式");
        }
        if (this.isMagnetometerHorizontalCalibrating) {
            sb.append("\n 磁力计水平校准中");
        }
        if (this.isMagnetometerVerticalCalibrating) {
            sb.append("\n 磁力计垂直校准中");
        }
        if (this.isBatteryHighPress) {
            sb.append("\n 旧电池压差达");
        }
        if (this.isRemoterConnected) {
            sb.append("\n 已连接遥控器");
        }
        if (this.isFlight) {
            sb.append("\n 飞行中");
        }
        if (this.isReturning) {
            sb.append("\n 返航中");
        }
        if (this.isLanding) {
            sb.append("\n 着陆中-降落中");
        }
        if (this.isNoHeadMode) {
            sb.append("\n 无头模式");
        } else {
            sb.append("\n有头模式");
        }
        if (this.isFastStopMode) {
            sb.append("\n 急停模式");
        }
        if (this.isHighSpeedMode) {
            sb.append("\n 高速模式");
        }
        if (this.isNewerMode) {
            sb.append("\n 新手模式");
        }
        if (this.isGPS) {
            sb.append("\n GPS模式");
        }
        if (this.isMpuError) {
            sb.append("\n mpu错误");
        }
        if (this.isPressureError) {
            sb.append("\n 气压计错误");
        }
        if (this.isGpsConnectError) {
            sb.append("\n gps连接错误");
        }
        if (this.isGeoTooMuchInterfere) {
            sb.append("\n 地磁干扰过大");
        }
        if (this.isReturnCountdown) {
            sb.append("\n 低电返航倒计时");
        }
        if (this.countDown > 0) {
            sb.append("\n 返航倒计时=").append(this.countDown);
        }
        if (this.isTooWeakGps) {
            sb.append("\n gps信号弱警告");
        }
        if (this.isSmartBatteryAbnormal) {
            sb.append("\n 电池通讯异常");
        }
        if (this.isMagnetometerHorizontalCalibrating) {
            sb.append("\n 水平校准中");
        }
        if (this.isMagnetometerVerticalCalibrating) {
            sb.append("\n 垂直校准中");
        }
        if (this.isNeedCalibration) {
            sb.append("\n 距离上次磁校准地方超过 50km 提示强制校准");
        }
        if (this.isGeomagneticFault) {
            sb.append("\n 地磁故障");
        }
        if (this.isGeoCalibrationFailureFlag) {
            sb.append("\n 地磁校准失败标志");
        }
        if (this.isNetWorkFault) {
            sb.append("\n 2.4G故障");
        }
        if (this.isPlaneExceedLimitDistance) {
            sb.append("\n 飞机超出限制距离提示");
        }
        if (this.isPlaneExceedLimitHigh) {
            sb.append("\n 飞机超出限制高度提示");
        }
        if (this.isEmergencyStop) {
            sb.append("\n 触发急停");
        }
        if (this.isTofFault) {
            sb.append("\n TOF异常");
        }
        if (this.isOpticalFlow) {
            sb.append("\n 光流故障");
        }
        if (this.isPTZMotorAbnormal) {
            sb.append("\n 云台电机过载");
        }
        if (this.isPTZGyroscopeFault) {
            sb.append("\n 云台陀螺仪故障");
        }
        if (this.isPTZFlashError) {
            sb.append("\n 云台flash读取错误");
        }
        if (this.isPTZAttitudeAbnormal) {
            sb.append("\n 云台姿态收敛异常");
        }
        if (this.is1BatteryDamaged) {
            sb.append("\n 1片电芯异常");
        }
        if (this.is2BatteryDamaged) {
            sb.append("\n 2片电芯异常");
        }
        if (this.isBatteryDiffPressure) {
            sb.append("\n 电池压差异常");
        }
        if (this.isBatteryJump) {
            sb.append("\n 电池容量跳变");
        }
        if (this.isBatteryTempLow) {
            sb.append("\n电池低温报警");
        }
        if (this.isBatteryTempHigh) {
            sb.append("\n电池高温报警");
        }
        if (this.isNewBattery) {
            sb.append("\n 新电池");
        }
        if (this.isBatteryBelowSevenPercent) {
            sb.append("\n 电池容量低于7%");
        }
        if (this.isBatteryAbnormalAlarm) {
            sb.append("\n 电池容量异常");
        }
        if (this.isBatteryJumpAbnormal) {
            sb.append("\n 电池容量骤降异常");
        }
        if (this.isBatteryLowTempAlarm) {
            sb.append("\n 电池低温低电压警报");
        }
        if (this.isBatteryFullAbnormalAlarm) {
            sb.append("\n 电池满充容量异常警报");
        }
        if (this.isLowPowerMode) {
            sb.append("\n 电池低电报警");
        }
        if (this.isGpsInterference) {
            sb.append("\n gps信号干扰过大警告");
        }
        if (this.isAbnormalBatteryTemperature) {
            sb.append("\n 电池温度异常");
        }
        if (isNewModeBeyondLimitDistance()) {
            sb.append("\n 新手模式开启失败, 超出距离限制");
        }
        if (isNewModeBeyondLimitHeight()) {
            sb.append("\n 新手模式开启失败, 超出高度限制");
        }
        if (this.speedModeNewModeFail) {
            sb.append("\n 新手模式调节速度模式不起作用");
        }
        if (this.beyondLimitDistanceFail) {
            sb.append("\n 飞机超出限定距离，距离设置失败");
        }
        if (this.beyondLimitHeightFail) {
            sb.append("\n 飞机超出限定高度，高度设置失败");
        }
        if (this.heightLowFollowOpenFail) {
            sb.append("\n 飞行高度小于5M跟随开启失败");
        }
        if (this.isOutdoor) {
            sb.append("\n 在室外");
        } else {
            sb.append("\n 在室内");
        }
        if (FlightConfig.curFlight != null && FlightConfig.is_Atom_Series()) {
            int i = this.speedMode;
            if (i == 0) {
                sb.append("\n 低速模式");
            } else if (i == 1) {
                sb.append("\n 中速模式");
            } else if (i == 2) {
                sb.append("\n 高速模式");
            }
        }
        int i2 = this.mode;
        if (i2 == 0) {
            sb.append("\n 姿态模式");
        } else if (i2 == 2) {
            sb.append("\n gps模式");
        } else if (i2 == 1) {
            sb.append("\n 光流模式");
        }
        if (this.isExitSmartMode) {
            sb.append("\n 退出跟随/ 环绕/ 航点");
        }
        if (this.isNotAllowTakeOff) {
            sb.append("\n 不能起飞");
        }
        if (this.isGpsSpeedValid) {
            sb.append("\n GPS速度有效");
        }
        if (this.isGpsLocationValid) {
            sb.append("\n GPS位置有效");
        }
        if (this.isNotEnterFollowMe) {
            sb.append("\n 跟随距离不满足要求");
        }
        if (this.isOpticalFlowAbnormal) {
            sb.append("\n 光流异常");
        }
        if (this.isOpticalFlowErrorInAtom) {
            sb.append("\n 光流故障(自研光流)");
        }
        if (this.shortVideoPercent > 0) {
            sb.append("\n 一键短片 进度百分比:" + this.shortVideoPercent);
        }
        if (this.isShortVideoBack) {
            sb.append("\n 一键短片 返回中");
        }
        if (this.isExecutingShortVideo) {
            sb.append("\n 一键短片 执行中");
        }
        if (this.isOPTIAllowHighest) {
            sb.append("\n已达光流最大可用高度");
        }
        if (this.isShowLandOrGoHome) {
            sb.append("\n触发了迫降逻辑");
        }
        if (this.isBatteryAbnormal) {
            sb.append("\n 电池异常");
        }
        if (this.isGeoCalibration) {
            sb.append("\n 处于磁力计校准状态");
        }
        if (this.isFlightIncline) {
            sb.append("\n 飞机倾转");
        }
        if (this.isLastCalOver50km) {
            sb.append("\n 距上次磁校准地点超过50km");
        }
        if (this.isGimbalNotReady) {
            sb.append("\n 云台未准备好");
        }
        if (this.isFlightInclineOver35) {
            sb.append("\n 飞机倾斜角度大于35°");
        }
        if (this.isFlightInNoFlyZone) {
            sb.append("\n 处于禁飞区");
        }
        if (this.isFlightInUpgrade) {
            sb.append("\n 飞机处于升级状态");
        }
        if (this.isImuPreparing) {
            sb.append("\n IMU 准备中");
        }
        if (this.isFindingDrone) {
            sb.append("\n 找飞机中");
        }
        if (this.ctrlType != null) {
            sb.append("\n ctrl type:" + this.ctrlType);
        }
        if (isEscCheckPaddledIntact()) {
            sb.append("\n 请检查桨叶是否完整");
        }
        if (isMotorFullPower()) {
            sb.append("\n 电机动力饱和");
        }
        if (isMotorStuck()) {
            sb.append("\n 电机卡住");
        }
        if (isMotorOverCurrent()) {
            sb.append("\n 电机故障 过流");
        }
        if (isEscFault()) {
            sb.append("\n 电机故障");
        }
        if (isEscHighTemp()) {
            sb.append("\n 电调温度高");
        }
        if (this.swoopReturnCountDown > 0) {
            sb.append("\n 俯冲返航倒计时=").append(this.swoopReturnCountDown);
        }
        if (isSwoopReturn()) {
            sb.append("\n 俯冲返航模式");
        }
        if (!isAllowShortVideo()) {
            sb.append("\n 不允许进入一键短片");
        }
        return sb.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FlightRevStateData m29clone() throws CloneNotSupportedException {
        return (FlightRevStateData) super.clone();
    }
}
