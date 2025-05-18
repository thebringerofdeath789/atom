package com.logan.upgrade.local.flight.listeners;

import com.logan.flight.listeners.OnReceiveListener;
import com.logan.upgrade.local.flight.recv.UpgradeRevFwLengthData;
import com.logan.upgrade.local.flight.recv.UpgradeRevFwRunData;
import com.logan.upgrade.local.flight.recv.UpgradeRevShakeHandData;

/* loaded from: classes3.dex */
public interface IFlightUpgradeView extends OnReceiveListener {
    void onReceiveFwLength(UpgradeRevFwLengthData upgradeRevFwLengthData);

    void onReceiveFwRun(UpgradeRevFwRunData upgradeRevFwRunData);

    void onReceiveShakeHand(UpgradeRevShakeHandData upgradeRevShakeHandData);
}