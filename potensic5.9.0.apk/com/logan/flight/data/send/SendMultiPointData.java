package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SendMultiPointData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 6;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 0;
    }

    public void setPoints(ArrayList<LatLng> arrayList) {
        int size = arrayList.size();
        this.payload = new byte[(size * 8) + 1];
        this.payload[0] = (byte) size;
        for (int i = 0; i < size; i++) {
            int i2 = (int) (arrayList.get(i).lat * 1.0E7d);
            int i3 = (int) (arrayList.get(i).lng * 1.0E7d);
            int i4 = i * 8;
            ParseUtil.intSmallByteArr(i2, this.payload, i4 + 1);
            ParseUtil.intSmallByteArr(i3, this.payload, i4 + 5);
        }
    }

    public static class LatLng {
        double lat;
        double lng;

        public LatLng(double d, double d2) {
            this.lat = d;
            this.lng = d2;
        }

        public String toString() {
            return "LatLng{lat=" + this.lat + ", lng=" + this.lng + '}';
        }
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public String toString() {
        return getClass().getSimpleName() + " : " + ParseUtil.byteToHexString(getBytes());
    }
}