package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.y;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.ipotensic.baselib.netty.Constant;

/* loaded from: classes.dex */
class o implements y.a {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.location.indoor.y.a
    public void a(BDLocation bDLocation) {
        long j;
        String g;
        long j2;
        if (this.a.f()) {
            if (this.a.af != null && System.currentTimeMillis() - this.a.af.c > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.af.e;
                if (currentTimeMillis - j2 < Constant.DELAY_MILLIS) {
                    bDLocation.setLocType(61);
                    bDLocation.setFloor(null);
                    bDLocation.setBuildingID(null);
                    bDLocation.setBuildingName(null);
                }
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (com.baidu.location.f.g.a().k() && (g = com.baidu.location.f.g.a().g()) != null) {
                BDLocation bDLocation3 = new BDLocation(g);
                if (bDLocation3.getSatelliteNumber() > 0 && bDLocation3.getSpeed() > 0.0f) {
                    bDLocation2.setLocType(61);
                    bDLocation2.setSatelliteNumber(bDLocation3.getSatelliteNumber());
                    bDLocation2.setSpeed(bDLocation3.getSpeed());
                    bDLocation2.setAltitude(bDLocation3.getAltitude());
                    bDLocation2.setDirection(bDLocation3.getDirection());
                }
            }
            this.a.a(bDLocation2, 29);
            this.a.ag.a(bDLocation);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.a.af == null || currentTimeMillis2 - this.a.af.c <= 30000) {
            return;
        }
        j = this.a.af.e;
        if (currentTimeMillis2 - j > 30000) {
            this.a.d();
        }
    }
}
