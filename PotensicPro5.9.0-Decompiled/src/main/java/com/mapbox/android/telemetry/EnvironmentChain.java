package com.mapbox.android.telemetry;

/* loaded from: classes3.dex */
class EnvironmentChain {
    EnvironmentChain() {
    }

    EnvironmentResolver setup() {
        ComServerInformation comServerInformation = new ComServerInformation();
        StagingServerInformation stagingServerInformation = new StagingServerInformation();
        stagingServerInformation.nextChain(comServerInformation);
        ChinaServerInformation chinaServerInformation = new ChinaServerInformation();
        chinaServerInformation.nextChain(stagingServerInformation);
        return chinaServerInformation;
    }
}
