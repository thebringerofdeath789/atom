package com.mapbox.android.telemetry;

import android.os.Bundle;

/* loaded from: classes3.dex */
interface EnvironmentResolver {
    void nextChain(EnvironmentResolver environmentResolver);

    ServerInformation obtainServerInformation(Bundle bundle);
}
