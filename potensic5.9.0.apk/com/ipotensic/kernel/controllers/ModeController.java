package com.ipotensic.kernel.controllers;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.kernel.C1965R;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes2.dex */
public class ModeController extends BaseController {
    private final Runnable dismissRunnable;
    private Boolean isWifiWeak;
    private Boolean remoteControl;
    private TextView tvCurMode;

    public ModeController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.remoteControl = null;
        this.isWifiWeak = null;
        this.dismissRunnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.ModeController.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ModeController.this.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.tvCurMode = (TextView) view.findViewById(C1965R.id.tv_cur_mode);
    }

    public void reset() {
        setVisibility(8);
        PhoneConfig.mainHandler.removeCallbacks(this.dismissRunnable);
        if (this.remoteControl != null) {
            this.remoteControl = null;
        }
        if (this.isWifiWeak != null) {
            this.isWifiWeak = null;
        }
    }

    public void showCurRemoteControlModeTip() {
        if (!FlightConfig.isConnectFlight() || UsbConfig.isUsbConnected) {
            return;
        }
        DDLog.m1684e("remoter1:" + this.remoteControl);
        Boolean bool = this.remoteControl;
        if (bool == null || bool.booleanValue() != FlightRevData.get().getFlightRevStateData().isRemoterConnected()) {
            if (FlightRevData.get().getFlightRevStateData().isRemoterConnected()) {
                this.tvCurMode.setText(getContext().getString(C1965R.string.toast_remote_control_connected));
                this.tvCurMode.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getResources().getDrawable(C1965R.mipmap.icon_top_remote_control_connected), (Drawable) null, (Drawable) null);
            } else {
                this.tvCurMode.setText(getContext().getString(C1965R.string.toast_remote_control_disconnected_describe));
                this.tvCurMode.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getResources().getDrawable(C1965R.mipmap.icon_remote_control_discon), (Drawable) null, (Drawable) null);
            }
            showView();
            this.remoteControl = Boolean.valueOf(FlightRevData.get().getFlightRevStateData().isRemoterConnected());
        }
    }

    public void showWifiWeakTip(int i) {
        if (FlightConfig.isConnectFlight() && UsbConfig.isUsbConnected) {
            if (this.isWifiWeak != null || i > 1) {
                if (i > 1) {
                    DDLog.m1684e("信号值好：" + i);
                    this.isWifiWeak = null;
                    return;
                }
                return;
            }
            this.isWifiWeak = true;
            DDLog.m1684e("信号值差：" + i);
            this.tvCurMode.setText(getContext().getString(C1965R.string.dialog_wifi_weak_content));
            this.tvCurMode.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            showView();
        }
    }

    public void showView() {
        DDLog.m1684e("显示信号值差");
        setVisibility(0);
        PhoneConfig.mainHandler.removeCallbacks(this.dismissRunnable);
        PhoneConfig.mainHandler.postDelayed(this.dismissRunnable, 3000L);
    }
}