package com.ipotensic.kernel.model;

import android.content.Intent;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.activitys.CAACUomRegistrationActivity;
import com.ipotensic.kernel.bean.ObservableString;
import com.logan.camera.CameraConfig;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevVersionData;

/* loaded from: classes2.dex */
public class SettingAboutModel {

    /* renamed from: NA */
    private final String f2236NA = "N/A";
    public ObservableString flightSN = new ObservableString("N/A");
    public ObservableString remoteSN = new ObservableString("N/A");
    public ObservableString flightVersion = new ObservableString("N/A");
    public ObservableString gimbalVersion = new ObservableString("N/A");
    public ObservableString remoteVersion = new ObservableString("N/A");
    public ObservableString cameraVersion = new ObservableString("N/A");
    public ObservableString fpvVersion = new ObservableString("N/A");
    public ObservableString batteryVersion = new ObservableString("N/A");
    public ObservableString escVersion = new ObservableString("N/A");
    public ObservableString appVersion = new ObservableString("N/A");
    public ObservableString productStr = new ObservableString("N/A");
    public ObservableBoolean showDeviceModelInfo = new ObservableBoolean(false);
    public ObservableBoolean showVersionInfo = new ObservableBoolean(false);
    public ObservableBoolean showUpgradeView = new ObservableBoolean(false);

    public void onClickToUpgrade(View view) {
    }

    public SettingAboutModel() {
        this.appVersion.set("  V6.9.0");
    }

    public void update() {
        String remoteControllerSN;
        FlightRevVersionData flightRevVersionData = FlightRevData.get().getFlightRevVersionData();
        if (flightRevVersionData.isInit()) {
            String flightSN = flightRevVersionData.getFlightSN();
            if (flightSN != null) {
                this.flightSN.set(flightSN);
            }
            this.flightVersion.set("v" + flightRevVersionData.getFlightControlVersion());
            this.gimbalVersion.set("v" + flightRevVersionData.getGimbalVersion());
            String softVersion = CameraConfig.get().getSoftVersion();
            if (softVersion != null) {
                this.cameraVersion.set(softVersion.replace("V", "v"));
            }
            this.batteryVersion.set("v" + flightRevVersionData.getBatteryVersion());
            String escVersion = flightRevVersionData.getEscVersion();
            if (escVersion != null) {
                this.escVersion.set(escVersion);
            }
            if (FlightConfig.isAtomLT()) {
                this.productStr.set(FlightConfig.TYPE_ATOM_LT.toUpperCase());
            } else if (FlightConfig.is_Atom_SE_Series()) {
                this.productStr.set(FlightConfig.TYPE_ATOM_SE.toUpperCase());
            } else {
                this.productStr.set("Atom".toUpperCase());
            }
        }
        if (FlightRevData.get().getFlightRevRemoteCtrlInfoData().isInit()) {
            this.remoteVersion.set("v" + FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion());
        }
        if (FlightRevData.get().getFlightRevFpvData().isInit()) {
            this.fpvVersion.set("v" + FlightRevData.get().getFlightRevFpvData().getFpvVersion());
        }
        if (!FlightRevData.get().getFlightRevConnectData().isRemoterConnected() || (remoteControllerSN = SPHelper.getInstance().getRemoteControllerSN()) == null) {
            return;
        }
        this.remoteSN.set(remoteControllerSN);
    }

    public void onFlightDisconnect() {
        this.productStr.set("N/A");
        this.flightSN.set("N/A");
        this.flightVersion.set("N/A");
        this.gimbalVersion.set("N/A");
        this.cameraVersion.set("N/A");
        this.escVersion.set("N/A");
        this.batteryVersion.set("N/A");
    }

    public void onRemoterDisconnect() {
        this.fpvVersion.set("N/A");
        this.remoteVersion.set("N/A");
        this.remoteSN.set("N/A");
    }

    public void showDeviceModelInfoClick(View view) {
        this.showDeviceModelInfo.set(!r2.get());
    }

    public void showVersionInfoClick(View view) {
        this.showVersionInfo.set(!r2.get());
    }

    public void goRegisterUom(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) CAACUomRegistrationActivity.class);
        intent.putExtra(CAACUomRegistrationActivity.FLIGHT_TYPE_INTENT_KEY, FlightConfig.curFlight.name());
        intent.putExtra(CAACUomRegistrationActivity.FLIGHT_SN_INTENT_KEY, this.flightSN.get());
        view.getContext().startActivity(intent);
    }
}