package com.logan.flight.data;

import com.logan.flight.data.recv.FlightReturnAltitudeTestData;
import com.logan.flight.data.recv.FlightRevBatteryData;
import com.logan.flight.data.recv.FlightRevCalResultData;
import com.logan.flight.data.recv.FlightRevCalibrationFeedbackData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevCtrlData;
import com.logan.flight.data.recv.FlightRevFlightCtrlToAppNormal;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevForceTakeoff;
import com.logan.flight.data.recv.FlightRevFpvData;
import com.logan.flight.data.recv.FlightRevGeneralData;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;
import com.logan.flight.data.recv.FlightRevGimbalStateData;
import com.logan.flight.data.recv.FlightRevGpsSignalTest;
import com.logan.flight.data.recv.FlightRevGpsTestData;
import com.logan.flight.data.recv.FlightRevHomePointData;
import com.logan.flight.data.recv.FlightRevMagCalibrationResultData;
import com.logan.flight.data.recv.FlightRevMiniPairData;
import com.logan.flight.data.recv.FlightRevNoFlyZone;
import com.logan.flight.data.recv.FlightRevP1V1TestData;
import com.logan.flight.data.recv.FlightRevP1V2TestData;
import com.logan.flight.data.recv.FlightRevP1V3TestData;
import com.logan.flight.data.recv.FlightRevPTZFeedbackData;
import com.logan.flight.data.recv.FlightRevRecord;
import com.logan.flight.data.recv.FlightRevRemoteCtrlInfoData;
import com.logan.flight.data.recv.FlightRevRemoteMuteData;
import com.logan.flight.data.recv.FlightRevRemoterBatteryData;
import com.logan.flight.data.recv.FlightRevRemoterCalibrationData;
import com.logan.flight.data.recv.FlightRevRemoterStateData;
import com.logan.flight.data.recv.FlightRevReturnHoverData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.data.recv.FlightRevTestData;
import com.logan.flight.data.recv.FlightRevUpgradeData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.upgrade.local.flight.recv.UpgradeRevFwFileData;
import com.logan.upgrade.local.flight.recv.UpgradeRevFwLengthData;
import com.logan.upgrade.local.flight.recv.UpgradeRevFwRunData;
import com.logan.upgrade.local.flight.recv.UpgradeRevShakeHandData;

/* loaded from: classes.dex */
public class FlightRevData {
    private static volatile FlightRevData instance;
    private FlightRevCalResultData calResultData;
    private FlightRevFlightCtrlToAppNormal flightCtrlToAppNormal;
    private FlightRevRecord flightRecordData;
    private FlightRevBatteryData flightRevBatteryData;
    private FlightRevConnectData flightRevConnectData;
    private FlightRevFlightInfoData flightRevFlightInfoData;
    private FlightRevFpvData flightRevFpvData;
    private FlightRevGpsSignalTest flightRevGpsSignalTest;
    private FlightRevHomePointData flightRevHomePointData;
    private FlightRevRemoteCtrlInfoData flightRevRemoteCtrlInfoData;
    private FlightRevSettingData flightRevSettingData;
    private FlightRevStateData flightRevStateData;
    private FlightRevUpgradeData flightRevUpgradeData;
    private FlightRevVersionData flightRevVersionData;
    private FlightRevForceTakeoff forceTakeoff;
    private FlightRevGeoTestData geoTestData;
    private FlightRevGimbalSettingData gimbalSettingData;
    private FlightRevGimbalStateData gimbalStateData;
    private FlightRevGpsTestData gpsTestData;
    private FlightRevMagCalibrationResultData magCalibrationResultData;
    private FlightRevMiniPairData miniPairData;
    private FlightRevNoFlyZone noFlyZoneData;
    private FlightRevP1V1TestData p1V1TestData;
    private FlightRevP1V2TestData p1V2TestData;
    private FlightRevP1V3TestData p1V3TestData;
    private UpgradeRevFwFileData recFwFileData;
    private FlightRevRemoterCalibrationData remoterCalibrationData;
    private FlightRevRemoteMuteData remoterMuteData;
    private FlightReturnAltitudeTestData returnAltitudeTestData;
    private FlightRevCalibrationFeedbackData revCalibrationFeedbackData;
    private FlightRevCtrlData revCtrlData;
    private UpgradeRevFwLengthData revFwLengthData;
    private UpgradeRevFwRunData revFwRunData;
    private FlightRevGeneralData revGeneralData;
    private FlightRevPTZFeedbackData revPTZFeedbackData;
    private FlightRevRemoterBatteryData revRemoterBatteryData;
    private FlightRevRemoterStateData revRemoterStateData;
    private FlightRevReturnHoverData revReturnHoverData;
    private UpgradeRevShakeHandData revShakeHandData;
    private FlightRevTestData testData;

    private FlightRevData() {
    }

    public static FlightRevData get() {
        if (instance == null) {
            synchronized (FlightRevData.class) {
                if (instance == null) {
                    FlightRevData flightRevData = new FlightRevData();
                    instance = flightRevData;
                    return flightRevData;
                }
            }
        }
        return instance;
    }

    public FlightRevReturnHoverData getReturnHoverData() {
        if (this.revReturnHoverData == null) {
            this.revReturnHoverData = new FlightRevReturnHoverData();
        }
        return this.revReturnHoverData;
    }

    public FlightRevForceTakeoff getForceTakeoff() {
        if (this.forceTakeoff == null) {
            this.forceTakeoff = new FlightRevForceTakeoff();
        }
        return this.forceTakeoff;
    }

    public FlightRevMiniPairData getMiniPairData() {
        if (this.miniPairData == null) {
            this.miniPairData = new FlightRevMiniPairData();
        }
        return this.miniPairData;
    }

    public FlightRevRemoterCalibrationData getRemoterCalibrationData() {
        if (this.remoterCalibrationData == null) {
            this.remoterCalibrationData = new FlightRevRemoterCalibrationData();
        }
        return this.remoterCalibrationData;
    }

    public FlightReturnAltitudeTestData getReturnAltitudeTestData() {
        if (this.returnAltitudeTestData == null) {
            this.returnAltitudeTestData = new FlightReturnAltitudeTestData();
        }
        return this.returnAltitudeTestData;
    }

    public FlightRevGpsSignalTest getFlightRevGpsSignalTestData() {
        if (this.flightRevGpsSignalTest == null) {
            this.flightRevGpsSignalTest = new FlightRevGpsSignalTest();
        }
        return this.flightRevGpsSignalTest;
    }

    public UpgradeRevFwFileData getRevFwFileData() {
        if (this.recFwFileData == null) {
            this.recFwFileData = new UpgradeRevFwFileData();
        }
        return this.recFwFileData;
    }

    public UpgradeRevFwLengthData getRevFwLengthData() {
        if (this.revFwLengthData == null) {
            this.revFwLengthData = new UpgradeRevFwLengthData();
        }
        return this.revFwLengthData;
    }

    public UpgradeRevFwRunData getRevFwRunData() {
        if (this.revFwRunData == null) {
            this.revFwRunData = new UpgradeRevFwRunData();
        }
        return this.revFwRunData;
    }

    public UpgradeRevShakeHandData getRevShakeHandData() {
        if (this.revShakeHandData == null) {
            this.revShakeHandData = new UpgradeRevShakeHandData();
        }
        return this.revShakeHandData;
    }

    public FlightRevFlightInfoData getFlightRevFlightInfoData() {
        if (this.flightRevFlightInfoData == null) {
            this.flightRevFlightInfoData = new FlightRevFlightInfoData();
        }
        return this.flightRevFlightInfoData;
    }

    public FlightRevSettingData getFlightRevSettingData() {
        if (this.flightRevSettingData == null) {
            this.flightRevSettingData = new FlightRevSettingData();
        }
        return this.flightRevSettingData;
    }

    public FlightRevRemoterStateData getRemoterStateData() {
        if (this.revRemoterStateData == null) {
            this.revRemoterStateData = new FlightRevRemoterStateData();
        }
        return this.revRemoterStateData;
    }

    public FlightRevStateData getFlightRevStateData() {
        if (this.flightRevStateData == null) {
            this.flightRevStateData = new FlightRevStateData();
        }
        return this.flightRevStateData;
    }

    public FlightRevVersionData getFlightRevVersionData() {
        if (this.flightRevVersionData == null) {
            this.flightRevVersionData = new FlightRevVersionData();
        }
        return this.flightRevVersionData;
    }

    public FlightRevBatteryData getFlightRevBatteryData() {
        if (this.flightRevBatteryData == null) {
            this.flightRevBatteryData = new FlightRevBatteryData();
        }
        return this.flightRevBatteryData;
    }

    public FlightRevHomePointData getFlightRevHomePointData() {
        if (this.flightRevHomePointData == null) {
            this.flightRevHomePointData = new FlightRevHomePointData();
        }
        return this.flightRevHomePointData;
    }

    public FlightRevConnectData getFlightRevConnectData() {
        if (this.flightRevConnectData == null) {
            this.flightRevConnectData = new FlightRevConnectData();
        }
        return this.flightRevConnectData;
    }

    public FlightRevFlightCtrlToAppNormal getFlightCtrlToAppNormalData() {
        if (this.flightCtrlToAppNormal == null) {
            this.flightCtrlToAppNormal = new FlightRevFlightCtrlToAppNormal();
        }
        return this.flightCtrlToAppNormal;
    }

    public FlightRevUpgradeData getFlightRevUpgradeData() {
        if (this.flightRevUpgradeData == null) {
            this.flightRevUpgradeData = new FlightRevUpgradeData();
        }
        return this.flightRevUpgradeData;
    }

    public FlightRevRemoteCtrlInfoData getFlightRevRemoteCtrlInfoData() {
        if (this.flightRevRemoteCtrlInfoData == null) {
            this.flightRevRemoteCtrlInfoData = new FlightRevRemoteCtrlInfoData();
        }
        return this.flightRevRemoteCtrlInfoData;
    }

    public FlightRevGeneralData getRevGeneralData() {
        if (this.revGeneralData == null) {
            this.revGeneralData = new FlightRevGeneralData();
        }
        return this.revGeneralData;
    }

    public FlightRevFpvData getFlightRevFpvData() {
        if (this.flightRevFpvData == null) {
            this.flightRevFpvData = new FlightRevFpvData();
        }
        return this.flightRevFpvData;
    }

    public FlightRevRemoterBatteryData getFlightRemoterBatteryData() {
        if (this.revRemoterBatteryData == null) {
            this.revRemoterBatteryData = new FlightRevRemoterBatteryData();
        }
        return this.revRemoterBatteryData;
    }

    public FlightRevCalibrationFeedbackData getRevCalibrationFeedbackData() {
        if (this.revCalibrationFeedbackData == null) {
            this.revCalibrationFeedbackData = new FlightRevCalibrationFeedbackData();
        }
        return this.revCalibrationFeedbackData;
    }

    public FlightRevMagCalibrationResultData getMagCalibrationResultData() {
        if (this.magCalibrationResultData == null) {
            this.magCalibrationResultData = new FlightRevMagCalibrationResultData();
        }
        return this.magCalibrationResultData;
    }

    public FlightRevPTZFeedbackData getRevPTZFeedbackData() {
        if (this.revPTZFeedbackData == null) {
            this.revPTZFeedbackData = new FlightRevPTZFeedbackData();
        }
        return this.revPTZFeedbackData;
    }

    public FlightRevTestData getTestData() {
        if (this.testData == null) {
            this.testData = new FlightRevTestData();
        }
        return this.testData;
    }

    public FlightRevGeoTestData getGeoTestData() {
        if (this.geoTestData == null) {
            this.geoTestData = new FlightRevGeoTestData();
        }
        return this.geoTestData;
    }

    public FlightRevCalResultData getCalResultData() {
        if (this.calResultData == null) {
            this.calResultData = new FlightRevCalResultData();
        }
        return this.calResultData;
    }

    public FlightRevGpsTestData getGpsTestData() {
        if (this.gpsTestData == null) {
            this.gpsTestData = new FlightRevGpsTestData();
        }
        return this.gpsTestData;
    }

    public FlightRevP1V1TestData getP1V1TestData() {
        if (this.p1V1TestData == null) {
            this.p1V1TestData = new FlightRevP1V1TestData();
        }
        return this.p1V1TestData;
    }

    public FlightRevP1V2TestData getP1V2TestData() {
        if (this.p1V2TestData == null) {
            this.p1V2TestData = new FlightRevP1V2TestData();
        }
        return this.p1V2TestData;
    }

    public FlightRevP1V3TestData getP1V3TestData() {
        if (this.p1V3TestData == null) {
            this.p1V3TestData = new FlightRevP1V3TestData();
        }
        return this.p1V3TestData;
    }

    public FlightRevCtrlData getCtrlData() {
        if (this.revCtrlData == null) {
            this.revCtrlData = new FlightRevCtrlData();
        }
        return this.revCtrlData;
    }

    public FlightRevGimbalSettingData getGimbalSettingData() {
        if (this.gimbalSettingData == null) {
            this.gimbalSettingData = new FlightRevGimbalSettingData();
        }
        return this.gimbalSettingData;
    }

    public FlightRevGimbalStateData getGimbalStateData() {
        if (this.gimbalStateData == null) {
            this.gimbalStateData = new FlightRevGimbalStateData();
        }
        return this.gimbalStateData;
    }

    public FlightRevRemoteMuteData getRemoterMuteData() {
        if (this.remoterMuteData == null) {
            this.remoterMuteData = new FlightRevRemoteMuteData();
        }
        return this.remoterMuteData;
    }

    public FlightRevNoFlyZone getNoFlyZoneData() {
        if (this.noFlyZoneData == null) {
            this.noFlyZoneData = new FlightRevNoFlyZone();
        }
        return this.noFlyZoneData;
    }

    public FlightRevRecord getFlightRecordData() {
        if (this.flightRecordData == null) {
            this.flightRecordData = new FlightRevRecord();
        }
        return this.flightRecordData;
    }

    public void release() {
        instance = null;
    }
}