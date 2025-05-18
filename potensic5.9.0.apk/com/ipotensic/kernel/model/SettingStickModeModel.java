package com.ipotensic.kernel.model;

import android.content.Context;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.kernel.view.dialog.LandConfirmDialog;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevSettingData;

/* loaded from: classes2.dex */
public class SettingStickModeModel {
    private Context context;
    private GeneralDialog tipsDialog;
    private final long TIPS_SHOW_TIME = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    public ObservableBoolean model1 = new ObservableBoolean(true);
    public ObservableBoolean isShowTips = new ObservableBoolean(false);
    private final Runnable disconnectTipRunnable = new Runnable() { // from class: com.ipotensic.kernel.model.SettingStickModeModel.1
        @Override // java.lang.Runnable
        public void run() {
            SettingStickModeModel.this.isShowTips.set(false);
        }
    };

    public SettingStickModeModel(Context context) {
        this.context = context;
    }

    public void setModel1(boolean z) {
        this.model1.set(z);
    }

    public void btnBackClick(View view) {
        EventDispatcher.get().sendEvent(EventID.EVENT_SETTING_HIDE_STICK_MODE_FRAGMENT);
    }

    public void btnLeftClick(View view) {
        if (this.model1.get()) {
            return;
        }
        if (FlightConfig.isConnectFlight()) {
            dialogSetting(true);
            return;
        }
        this.model1.set(true);
        this.isShowTips.set(true);
        PhoneConfig.mainHandler.removeCallbacks(this.disconnectTipRunnable);
        PhoneConfig.mainHandler.postDelayed(this.disconnectTipRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public void btnRightClick(View view) {
        if (this.model1.get()) {
            if (FlightConfig.isConnectFlight()) {
                dialogSetting(false);
                return;
            }
            this.model1.set(false);
            this.isShowTips.set(true);
            PhoneConfig.mainHandler.removeCallbacks(this.disconnectTipRunnable);
            PhoneConfig.mainHandler.postDelayed(this.disconnectTipRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    public void update(FlightRevSettingData flightRevSettingData) {
        setModel1(flightRevSettingData.isAmericaRockerMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSetting(boolean z) {
        FlightSendData.get().getSendFlightSetData().setRockMode(z);
        DataManager.getInstance().startSendSetting();
    }

    private void dialogSetting(final boolean z) {
        GeneralDialog generalDialog = new GeneralDialog(this.context, new LandConfirmDialog.OnConfirmListener() { // from class: com.ipotensic.kernel.model.SettingStickModeModel.2
            @Override // com.ipotensic.kernel.view.dialog.LandConfirmDialog.OnConfirmListener
            public void onCancel() {
            }

            @Override // com.ipotensic.kernel.view.dialog.LandConfirmDialog.OnConfirmListener
            public void onConfirm() {
                SettingStickModeModel.this.setModel1(z);
                SettingStickModeModel.this.sendSetting(z);
            }
        });
        this.tipsDialog = generalDialog;
        generalDialog.show();
    }

    public void onPause() {
        GeneralDialog generalDialog = this.tipsDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.tipsDialog.dismiss();
        this.tipsDialog = null;
    }
}