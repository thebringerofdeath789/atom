package com.ipotensic.kernel.model;

import com.ipotensic.baselib.utils.CancelRunnable;
import com.logan.flight.DataManager;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.enums.CommonMsgType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KernelViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/ipotensic/kernel/model/KernelViewModel$enterSwoopReturn$1$1", "Lcom/ipotensic/baselib/utils/CancelRunnable;", "run", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class KernelViewModel$enterSwoopReturn$1$1 extends CancelRunnable {
    KernelViewModel$enterSwoopReturn$1$1() {
    }

    @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
    public void run() {
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevStateData flightRevStateData = flightRevData.getFlightRevStateData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
        if (flightRevStateData.isSwoopReturn()) {
            KernelViewModel.this.stopSendEnterSwoopData();
            return;
        }
        FlightSendData flightSendData = FlightSendData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
        flightSendData.getSendGeneralData().setDataType(CommonMsgType.ENTER_SWOOP_RETURN);
        DataManager.getInstance().sendGeneralData();
    }
}