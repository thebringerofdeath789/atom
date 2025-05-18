package com.baidu.location.indoor;

import android.bluetooth.le.ScanCallback;

/* renamed from: com.baidu.location.indoor.g */
/* loaded from: classes.dex */
class C0742g extends ScanCallback {

    /* renamed from: a */
    final /* synthetic */ C0741f f1511a;

    C0742g(C0741f c0741f) {
        this.f1511a = c0741f;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
    @Override // android.bluetooth.le.ScanCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScanResult(int r14, android.bluetooth.le.ScanResult r15) {
        /*
            r13 = this;
            com.baidu.location.indoor.f r14 = r13.f1511a
            java.util.concurrent.ConcurrentMap r14 = com.baidu.location.indoor.C0741f.m1213a(r14)
            if (r14 == 0) goto Ld2
            android.bluetooth.BluetoothDevice r14 = r15.getDevice()
            if (r14 == 0) goto Ld2
            android.bluetooth.BluetoothDevice r14 = r15.getDevice()
            java.lang.String r14 = r14.getAddress()
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto Ld2
            com.baidu.location.indoor.f r14 = r13.f1511a
            long r0 = java.lang.System.currentTimeMillis()
            r14.f1484b = r0
            com.baidu.location.indoor.f r14 = r13.f1511a
            java.util.concurrent.ConcurrentMap r14 = com.baidu.location.indoor.C0741f.m1213a(r14)
            android.bluetooth.BluetoothDevice r0 = r15.getDevice()
            java.lang.String r0 = r0.getAddress()
            r14.put(r0, r15)
            long r0 = java.lang.System.currentTimeMillis()
            com.baidu.location.indoor.f r14 = r13.f1511a
            long r2 = com.baidu.location.indoor.C0741f.m1214b(r14)
            long r0 = r0 - r2
            r2 = 800(0x320, double:3.953E-321)
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 > 0) goto L4c
            r2 = -100
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 >= 0) goto Ld2
        L4c:
            com.baidu.location.indoor.f r14 = r13.f1511a
            java.util.concurrent.ConcurrentMap r14 = com.baidu.location.indoor.C0741f.m1213a(r14)
            java.util.Collection r14 = r14.values()
            r14.size()
            com.baidu.location.indoor.f r14 = r13.f1511a
            long r0 = java.lang.System.currentTimeMillis()
            com.baidu.location.indoor.C0741f.m1209a(r14, r0)
            long r14 = r15.getTimestampNanos()
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r14 = r14 / r0
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            r4 = 0
            if (r2 < r3) goto L78
            long r2 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Error -> L78
            long r2 = r2 / r0
            goto L79
        L78:
            r2 = r4
        L79:
            com.baidu.location.indoor.f r6 = r13.f1511a
            java.util.concurrent.ConcurrentMap r6 = com.baidu.location.indoor.C0741f.m1213a(r6)
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L87:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto Lc0
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r7 = r7.getValue()
            android.bluetooth.le.ScanResult r7 = (android.bluetooth.le.ScanResult) r7
            long r8 = r7.getTimestampNanos()
            long r8 = r8 / r0
            long r8 = r14 - r8
            r10 = 0
            r11 = 2500(0x9c4, double:1.235E-320)
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 <= 0) goto Lab
            r6.remove()
            r10 = 1
        Lab:
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L87
            if (r10 != 0) goto L87
            long r7 = r7.getTimestampNanos()
            long r7 = r7 / r0
            long r7 = r2 - r7
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 <= 0) goto L87
            r6.remove()
            goto L87
        Lc0:
            com.baidu.location.indoor.f r14 = r13.f1511a
            java.util.concurrent.ConcurrentMap r14 = com.baidu.location.indoor.C0741f.m1213a(r14)
            java.util.Collection r14 = r14.values()
            r14.size()
            com.baidu.location.indoor.f r14 = r13.f1511a
            com.baidu.location.indoor.C0741f.m1215c(r14)
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C0742g.onScanResult(int, android.bluetooth.le.ScanResult):void");
    }
}