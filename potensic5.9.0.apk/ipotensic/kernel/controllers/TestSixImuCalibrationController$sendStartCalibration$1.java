package com.ipotensic.kernel.controllers;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.send.SendGeneralData;
import com.logan.flight.enums.CommonMsgType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TestSixImuCalibrationController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class TestSixImuCalibrationController$sendStartCalibration$1 implements Runnable {
    public static final TestSixImuCalibrationController$sendStartCalibration$1 INSTANCE = ;

    TestSixImuCalibrationController$sendStartCalibration$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                if (!FlightConfig.isConnectFlight()) {
                    break;
                }
                FlightSendData flightSendData = FlightSendData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                flightSendData.getSendGeneralData().setDataType(CommonMsgType.STOP_IMU_CALIBRATION);
                DataManager.getInstance().sendGeneralData();
                Thread.sleep(20L);
            } catch (Exception unused) {
                return;
            }
        }
        if (FlightConfig.isConnectFlight()) {
            FlightSendData flightSendData2 = FlightSendData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightSendData2, "FlightSendData.get()");
            flightSendData2.getSendGeneralData().setDataType(CommonMsgType.START_IMU_CALIBRATION);
            DataManager.getInstance().sendGeneralData();
            StringBuilder append = new StringBuilder().append("\u53d1\u9001IMU\u6821\u51c6\u6570\u636e:");
            FlightSendData flightSendData3 = FlightSendData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightSendData3, "FlightSendData.get()");
            SendGeneralData sendGeneralData = flightSendData3.getSendGeneralData();
            Intrinsics.checkExpressionValueIsNotNull(sendGeneralData, "FlightSendData.get().sendGeneralData");
            DDLog.e(append.append(ParseUtil.byteToHexString(sendGeneralData.getBytes())).toString());
        }
    }
}