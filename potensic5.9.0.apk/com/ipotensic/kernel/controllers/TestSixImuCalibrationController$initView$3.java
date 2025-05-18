package com.ipotensic.kernel.controllers;

import android.view.View;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import kotlin.Metadata;

/* compiled from: TestSixImuCalibrationController.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, m2338d2 = {"com/ipotensic/kernel/controllers/TestSixImuCalibrationController$initView$3", "Lcom/ipotensic/baselib/listener/ScaleClickListener;", "click", "", "view", "Landroid/view/View;", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TestSixImuCalibrationController$initView$3 extends ScaleClickListener {
    final /* synthetic */ TestSixImuCalibrationController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestSixImuCalibrationController$initView$3(TestSixImuCalibrationController testSixImuCalibrationController, Integer num) {
        super(num);
        this.this$0 = testSixImuCalibrationController;
    }

    @Override // com.ipotensic.baselib.listener.ScaleClickListener
    public void click(View view) {
        this.this$0.sendStopCalibration(new SimpleResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController$initView$3$click$1
            @Override // com.ipotensic.baselib.listener.SimpleResultListener
            public final void onResult(Boolean bool) {
                TestSixImuCalibrationController$initView$3.this.this$0.isStartCalibration.set(false);
            }
        });
        EventDispatcher.get().sendEvent(EventID.EVENT_HIDE_IMU_CAL_TEST_CONTROLLER);
    }
}