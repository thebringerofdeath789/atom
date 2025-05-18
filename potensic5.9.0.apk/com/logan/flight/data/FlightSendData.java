package com.logan.flight.data;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.CommonUtil;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.send.Send4AxisData;
import com.logan.flight.data.send.SendCalibrationData;
import com.logan.flight.data.send.SendCtrlData;
import com.logan.flight.data.send.SendFlightSetData;
import com.logan.flight.data.send.SendGeneralData;
import com.logan.flight.data.send.SendGimbalSettingData;
import com.logan.flight.data.send.SendGpsData;
import com.logan.flight.data.send.SendHomeRevData;
import com.logan.flight.data.send.SendMiniPairData;
import com.logan.flight.data.send.SendMultiPointData;
import com.logan.flight.data.send.SendOthersData;
import com.logan.flight.data.send.SendPTZData;
import com.logan.flight.data.send.SendReplyTakeoff;
import com.logan.flight.data.send.SendReturnAltitudeData;
import com.logan.flight.data.send.SendReturnHoverData;
import com.logan.flight.enums.CtrlType;
import com.logan.flight.listeners.IGpsController;
import com.logan.upgrade.local.flight.send.SendFwLengthData;
import com.logan.upgrade.local.flight.send.SendFwRunData;
import com.logan.upgrade.local.flight.send.SendShakeHandData;

/* loaded from: classes.dex */
public class FlightSendData implements IGpsController {
    private static final String TAG = "FlightSendData";
    private static volatile FlightSendData instance;
    private SendReturnAltitudeData returnAltitudeData;
    private Send4AxisData send4AxisData;
    private SendCalibrationData sendCalibrationControlData;
    private SendCtrlData sendCtrlData;
    private SendFlightSetData sendFlightSetData;
    private SendFwLengthData sendFwLengthData;
    private SendFwRunData sendFwRunData;
    private SendGeneralData sendGeneralData;
    private SendGimbalSettingData sendGimbalSettingData;
    private SendGpsData sendGpsData;
    private SendHomeRevData sendHomeRevData;
    private SendMiniPairData sendMiniPairData;
    private SendMultiPointData sendMultiPointData;
    private SendOthersData sendOthersData;
    private SendPTZData sendPTZData;
    private SendReplyTakeoff sendReplyTakeoff;
    private SendReturnHoverData sendReturnHoverData;
    private SendShakeHandData sendShakeHandData;

    @Override // com.logan.flight.listeners.IGpsController
    public void setGpsInfo(double d, double d2, short s, short s2, short s3) {
    }

    private FlightSendData() {
    }

    public static FlightSendData get() {
        if (instance == null) {
            synchronized (FlightSendData.class) {
                if (instance == null) {
                    FlightSendData flightSendData = new FlightSendData();
                    instance = flightSendData;
                    return flightSendData;
                }
            }
        }
        return instance;
    }

    public SendReturnHoverData getSendReturnHoverData() {
        if (this.sendReturnHoverData == null) {
            this.sendReturnHoverData = new SendReturnHoverData();
        }
        return this.sendReturnHoverData;
    }

    public SendReplyTakeoff getSendReplyTakeoff() {
        if (this.sendReplyTakeoff == null) {
            this.sendReplyTakeoff = new SendReplyTakeoff();
        }
        return this.sendReplyTakeoff;
    }

    public SendMiniPairData getSendMiniPairData() {
        if (this.sendMiniPairData == null) {
            this.sendMiniPairData = new SendMiniPairData();
        }
        return this.sendMiniPairData;
    }

    public SendReturnAltitudeData getReturnAltitudeData() {
        if (this.returnAltitudeData == null) {
            this.returnAltitudeData = new SendReturnAltitudeData();
        }
        return this.returnAltitudeData;
    }

    public SendFwRunData getSendFwRunData() {
        if (this.sendFwRunData == null) {
            this.sendFwRunData = new SendFwRunData();
        }
        return this.sendFwRunData;
    }

    public SendShakeHandData getSendShakeHandData() {
        SendShakeHandData sendShakeHandData = new SendShakeHandData();
        this.sendShakeHandData = sendShakeHandData;
        return sendShakeHandData;
    }

    public SendFwLengthData getSendFwLengthData() {
        if (this.sendFwLengthData == null) {
            this.sendFwLengthData = new SendFwLengthData();
        }
        return this.sendFwLengthData;
    }

    public Send4AxisData getSend4AxisData() {
        if (this.send4AxisData == null) {
            this.send4AxisData = new Send4AxisData();
        }
        return this.send4AxisData;
    }

    public SendGpsData getSendGpsData() {
        if (this.sendGpsData == null) {
            this.sendGpsData = new SendGpsData();
        }
        return this.sendGpsData;
    }

    public SendHomeRevData getSendHomeRevData() {
        if (this.sendHomeRevData == null) {
            this.sendHomeRevData = new SendHomeRevData();
        }
        return this.sendHomeRevData;
    }

    public SendOthersData getSendOthersData() {
        if (this.sendOthersData == null) {
            this.sendOthersData = new SendOthersData();
        }
        return this.sendOthersData;
    }

    public SendFlightSetData getSendFlightSetData() {
        if (this.sendFlightSetData == null) {
            this.sendFlightSetData = new SendFlightSetData();
        }
        return this.sendFlightSetData;
    }

    public SendMultiPointData getSendMultiPointData() {
        if (this.sendMultiPointData == null) {
            this.sendMultiPointData = new SendMultiPointData();
        }
        return this.sendMultiPointData;
    }

    public SendCalibrationData getSendCalibrationControlData() {
        if (this.sendCalibrationControlData == null) {
            this.sendCalibrationControlData = new SendCalibrationData();
        }
        return this.sendCalibrationControlData;
    }

    public SendPTZData getSendPTZData() {
        if (this.sendPTZData == null) {
            this.sendPTZData = new SendPTZData();
        }
        return this.sendPTZData;
    }

    public SendCtrlData getSendCtrlData() {
        if (this.sendCtrlData == null) {
            this.sendCtrlData = new SendCtrlData();
        }
        return this.sendCtrlData;
    }

    public SendGimbalSettingData getSendGimbalSettingData() {
        if (this.sendGimbalSettingData == null) {
            this.sendGimbalSettingData = new SendGimbalSettingData();
        }
        return this.sendGimbalSettingData;
    }

    public SendGeneralData getSendGeneralData() {
        if (this.sendGeneralData == null) {
            this.sendGeneralData = new SendGeneralData();
        }
        return this.sendGeneralData;
    }

    public boolean isUserCtrlData() {
        String flightControlVersion = FlightRevData.get().getFlightRevVersionData().getFlightControlVersion();
        return FlightConfig.is_Atom_Series() && flightControlVersion != null && CommonUtil.hasNewVersion("1.8.0", flightControlVersion);
    }

    @Override // com.logan.flight.listeners.IGpsController
    public void setFollow() {
        if (isUserCtrlData()) {
            if (FlightRevData.get().getFlightRevStateData().isFollowing()) {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_CANCEL_AUTO_FLY);
                return;
            } else {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_FOLLOW);
                return;
            }
        }
        getSendGpsData().setFollow();
    }

    public void setWorkMode() {
        if (isUserCtrlData()) {
            if (FlightRevData.get().getFlightRevStateData().getMode() == 0) {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_SWITCH_GPS);
                return;
            } else {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_SWITCH_ATTITUDE);
                return;
            }
        }
        getSend4AxisData().setWorkMode();
    }

    public void setReturnMode() {
        if (isUserCtrlData()) {
            if (FlightRevData.get().getFlightRevStateData().isReturning()) {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_CANCEL_AUTO_FLY);
                return;
            } else {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_RETURN);
                return;
            }
        }
        getSend4AxisData().setReturnMode();
    }

    public void setNoHeadMode() {
        if (isUserCtrlData()) {
            if (FlightRevData.get().getFlightRevStateData().isNoHeadMode()) {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_CANCEL_AUTO_FLY);
                return;
            } else {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_NO_HEAD);
                return;
            }
        }
        getSend4AxisData().setNoHeadMode();
    }

    public void setLaunch() {
        CtrlType ctrlType;
        if (isUserCtrlData()) {
            if (FlightRevData.get().getFlightRevStateData().isLanding()) {
                ctrlType = CtrlType.TYPE_CANCEL_LAND;
            } else if (FlightRevData.get().getFlightRevStateData().isFlight()) {
                ctrlType = CtrlType.TYPE_LAND;
            } else {
                ctrlType = CtrlType.TYPE_TAKE_OFF;
            }
            DataManager.getInstance().sendCtrlData(ctrlType);
            return;
        }
        getSend4AxisData().setLaunch();
    }

    public void setUnLock() {
        if (isUserCtrlData()) {
            DataManager.getInstance().sendCtrlData(FlightRevData.get().getFlightRevStateData().isUnLock() ? CtrlType.TYPE_LOCK : CtrlType.TYPE_UNLOCK);
        } else {
            getSend4AxisData().setUnLock();
        }
    }

    public void setCircleFly() {
        if (isUserCtrlData()) {
            if (FlightRevData.get().getFlightRevStateData().isHotCircle()) {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_CANCEL_AUTO_FLY);
                return;
            } else {
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_CIRCLE);
                return;
            }
        }
        getSend4AxisData().setCircleFly();
    }

    public void setPointFly() {
        if (isUserCtrlData()) {
            if (FlightRevData.get().getFlightRevStateData().isPointFly()) {
                DDLog.m1683d(TAG, "setPointFly TYPE_CANCEL_AUTO_FLY");
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_CANCEL_AUTO_FLY);
                return;
            } else {
                DDLog.m1683d(TAG, "setPointFly TYPE_POINT_FLY");
                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_POINT_FLY);
                return;
            }
        }
        getSend4AxisData().setPointFly();
    }

    public void release() {
        instance = null;
    }
}