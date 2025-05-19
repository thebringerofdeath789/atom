package com.ipotensic.kernel.maps;

import com.logan.flight.data.send.SendMultiPointData;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public interface MapInfoListener {
    void mapClick();

    void onLocationInfo(double d, double d2, short s, short s2, short s3);

    void showGoBtn(boolean z);

    void startFlight(ArrayList<SendMultiPointData.LatLng> arrayList);
}
