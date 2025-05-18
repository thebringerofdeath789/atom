package com.ipotensic.kernel.controllers;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.view.GimbalScaleView;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevGimbalStateData;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class GimbalScaleController extends BaseController {
    private final long GIMBAL_SCALE_SHOW_TIME;
    private final Runnable gimbalScaleDismissRunnable;
    private GimbalScaleView gimbalScaleView;
    private int lastScale;

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
    }

    public GimbalScaleController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.GIMBAL_SCALE_SHOW_TIME = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        this.lastScale = 0;
        this.gimbalScaleDismissRunnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.GimbalScaleController.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GimbalScaleController.this.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        };
        this.gimbalScaleView = (GimbalScaleView) view;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        boolean z = false;
        if (eventID == EventID.FLIGHT_RECEIVE_GIMBAL_STATE_DATA) {
            FlightRevGimbalStateData gimbalStateData = FlightRevData.get().getGimbalStateData();
            int control_pitch = gimbalStateData.getControl_pitch();
            this.lastScale = control_pitch;
            this.gimbalScaleView.setCurrentScale(control_pitch);
            if (gimbalStateData.isIs_pitch_change()) {
                setVisibility(0);
                PhoneConfig.mainHandler.removeCallbacks(this.gimbalScaleDismissRunnable);
                PhoneConfig.mainHandler.postDelayed(this.gimbalScaleDismissRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            }
            return;
        }
        if (eventID == EventID.FLIGHT_CONNECT_STATE_CHANGED) {
            if (FlightConfig.isConnectFlight()) {
                return;
            }
            this.lastScale = 0;
            PhoneConfig.mainHandler.removeCallbacks(this.gimbalScaleDismissRunnable);
            PhoneConfig.mainHandler.post(this.gimbalScaleDismissRunnable);
            return;
        }
        if (eventID == EventID.FLIGHT_RECEIVE_STATE_DATA) {
            FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
            if (flightRevStateData.isInit() && flightRevStateData.getSpeedMode() == 0) {
                z = true;
            }
            if (z != this.gimbalScaleView.isOutRange()) {
                this.gimbalScaleView.setOutRange(z);
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        GimbalScaleView gimbalScaleView = this.gimbalScaleView;
        if (gimbalScaleView != null) {
            gimbalScaleView.deInit();
        }
    }
}