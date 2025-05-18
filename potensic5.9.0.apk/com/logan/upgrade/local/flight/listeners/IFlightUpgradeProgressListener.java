package com.logan.upgrade.local.flight.listeners;

/* loaded from: classes3.dex */
public interface IFlightUpgradeProgressListener {
    void isFileAccept(boolean z);

    void onRunFwSuccess();

    void onSwitchUpgradeModeSuccess();

    void onUpgradeFailed(Exception exc);

    void onUpgradeSuccess();

    void onUploadEnd();

    void onUploadProgress(int i, int i2);
}