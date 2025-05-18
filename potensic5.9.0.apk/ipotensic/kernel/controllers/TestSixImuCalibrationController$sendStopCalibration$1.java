package com.ipotensic.kernel.controllers;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.enums.CommonMsgType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TestSixImuCalibrationController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class TestSixImuCalibrationController$sendStopCalibration$1 implements Runnable {
    TestSixImuCalibrationController$sendStopCalibration$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                if (!FlightConfig.isConnectFlight()) {
                    break;
                }
                DDLog.e("\u53d1\u9001imu\u6821\u51c6\u7ed3\u675f");
                FlightSendData flightSendData = FlightSendData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                flightSendData.getSendGeneralData().setDataType(CommonMsgType.STOP_IMU_CALIBRATION);
                DataManager.getInstance().sendGeneralData();
                Thread.sleep(50L);
            } catch (Exception unused) {
                return;
            }
        }
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController$sendStopCalibration$1.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                SimpleResultListener.this.onResult(true);
            }
        });
    }

    /* compiled from: TestSixImuCalibrationController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.ipotensic.kernel.controllers.TestSixImuCalibrationController$sendStopCalibration$1$1 */
    static final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SimpleResultListener.this.onResult(true);
        }
    }
}