package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.C0766y;
import com.baidu.location.p010f.C0709g;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.ipotensic.baselib.netty.Constant;

/* renamed from: com.baidu.location.indoor.o */
/* loaded from: classes.dex */
class C0756o implements C0766y.a {

    /* renamed from: a */
    final /* synthetic */ C0755n f1734a;

    C0756o(C0755n c0755n) {
        this.f1734a = c0755n;
    }

    @Override // com.baidu.location.indoor.C0766y.a
    /* renamed from: a */
    public void mo1430a(BDLocation bDLocation) {
        long j;
        String m1027g;
        long j2;
        if (this.f1734a.m1388f()) {
            if (this.f1734a.f1633af != null && System.currentTimeMillis() - this.f1734a.f1633af.f1687c > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.f1734a.f1633af.f1689e;
                if (currentTimeMillis - j2 < Constant.DELAY_MILLIS) {
                    bDLocation.setLocType(61);
                    bDLocation.setFloor(null);
                    bDLocation.setBuildingID(null);
                    bDLocation.setBuildingName(null);
                }
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (C0709g.m959a().m1031k() && (m1027g = C0709g.m959a().m1027g()) != null) {
                BDLocation bDLocation3 = new BDLocation(m1027g);
                if (bDLocation3.getSatelliteNumber() > 0 && bDLocation3.getSpeed() > 0.0f) {
                    bDLocation2.setLocType(61);
                    bDLocation2.setSatelliteNumber(bDLocation3.getSatelliteNumber());
                    bDLocation2.setSpeed(bDLocation3.getSpeed());
                    bDLocation2.setAltitude(bDLocation3.getAltitude());
                    bDLocation2.setDirection(bDLocation3.getDirection());
                }
            }
            this.f1734a.m1334a(bDLocation2, 29);
            this.f1734a.f1634ag.m1426a(bDLocation);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.f1734a.f1633af == null || currentTimeMillis2 - this.f1734a.f1633af.f1687c <= 30000) {
            return;
        }
        j = this.f1734a.f1633af.f1689e;
        if (currentTimeMillis2 - j > 30000) {
            this.f1734a.m1386d();
        }
    }
}