package com.logan.flight.listeners;

import com.logan.flight.data.send.SendMultiPointData;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface IMultiPointController {
    void setMultiPointInfo(ArrayList<SendMultiPointData.LatLng> arrayList);
}