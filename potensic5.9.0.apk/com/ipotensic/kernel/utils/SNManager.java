package com.ipotensic.kernel.utils;

import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.flight.FlightConfig;
import com.logan.user.presenter.UserRequestPresenter;

/* loaded from: classes2.dex */
public class SNManager {
    private String remoteSN;
    private String remoteVersion;

    public void onSNReceived(boolean z) {
        String flightCurVersion = SPHelper.getInstance().getFlightCurVersion();
        String lastProductClass = FlightConfig.getLastProductClass();
        String flightControllerSN = SPHelper.getInstance().getFlightControllerSN();
        String remoteControllerSN = SPHelper.getInstance().getRemoteControllerSN();
        String remoterCurVersion = SPHelper.getInstance().getRemoterCurVersion();
        Token token = PhoneConfig.usrToken;
        if ((!FlightConfig.isBigPackageSeries() || z) && token != null) {
            UserRequestPresenter.getInstance().productStatistics(token, lastProductClass, flightCurVersion, remoterCurVersion, remoteControllerSN, flightControllerSN, 0, z);
        }
    }
}