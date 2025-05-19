package com.baidu.location.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import androidx.core.app.NotificationCompat;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.hjq.permissions.Permission;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a {
    private LocationClient e;
    private Context f;
    private AlarmManager k;
    private C0008a l;
    private b m;
    private boolean n;
    private ArrayList<BDNotifyListener> a = null;
    private float b = Float.MAX_VALUE;
    private BDLocation c = null;
    private long d = 0;
    private int g = 0;
    private long h = 0;
    private boolean i = false;
    private PendingIntent j = null;

    /* renamed from: com.baidu.location.d.a$a, reason: collision with other inner class name */
    public class C0008a extends BroadcastReceiver {
        public C0008a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (a.this.a == null || a.this.a.isEmpty()) {
                return;
            }
            a.this.e.requestNotifyLocation();
        }
    }

    public class b implements BDLocationListener {
        public b() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (a.this.a == null || a.this.a.size() <= 0) {
                return;
            }
            a.this.a(bDLocation);
        }
    }

    public a(Context context, LocationClient locationClient) {
        this.e = null;
        this.f = null;
        this.k = null;
        this.l = null;
        b bVar = new b();
        this.m = bVar;
        this.n = false;
        this.f = context;
        this.e = locationClient;
        locationClient.registerNotifyLocationListener(bVar);
        this.k = (AlarmManager) this.f.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.l = new C0008a();
        this.n = false;
    }

    private void a(long j) {
        try {
            PendingIntent pendingIntent = this.j;
            if (pendingIntent != null) {
                this.k.cancel(pendingIntent);
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), 201326592);
            this.j = broadcast;
            if (broadcast == null) {
                return;
            }
            this.k.set(0, System.currentTimeMillis() + j, this.j);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
        boolean z;
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != 161 && bDLocation.getLocType() != 65) {
            a(120000L);
            return;
        }
        if (System.currentTimeMillis() - this.d < 5000 || this.a == null) {
            return;
        }
        this.c = bDLocation;
        this.d = System.currentTimeMillis();
        float[] fArr = new float[1];
        Iterator<BDNotifyListener> it = this.a.iterator();
        float f = Float.MAX_VALUE;
        while (it.hasNext()) {
            BDNotifyListener next = it.next();
            Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), next.mLatitudeC, next.mLongitudeC, fArr);
            float radius = (fArr[0] - next.mRadius) - bDLocation.getRadius();
            if (radius > 0.0f) {
                if (radius < f) {
                    f = radius;
                }
            } else if (next.Notified < 3) {
                z = true;
                next.Notified++;
                next.onNotify(bDLocation, fArr[0]);
                if (next.Notified < 3) {
                    this.i = true;
                }
            }
            z = true;
        }
        if (f < this.b) {
            this.b = f;
        }
        this.g = 0;
        c();
    }

    private boolean b() {
        ArrayList<BDNotifyListener> arrayList = this.a;
        boolean z = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<BDNotifyListener> it = this.a.iterator();
            while (it.hasNext()) {
                if (it.next().Notified < 3) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (r2 > ((r6.h + r0) - java.lang.System.currentTimeMillis())) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() {
        /*
            r6 = this;
            boolean r0 = r6.b()
            if (r0 != 0) goto L7
            return
        L7:
            float r0 = r6.b
            r1 = 1167867904(0x459c4000, float:5000.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 10000(0x2710, float:1.4013E-41)
            if (r1 <= 0) goto L16
            r0 = 600000(0x927c0, float:8.40779E-40)
            goto L2b
        L16:
            r1 = 1148846080(0x447a0000, float:1000.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L20
            r0 = 120000(0x1d4c0, float:1.68156E-40)
            goto L2b
        L20:
            r1 = 1140457472(0x43fa0000, float:500.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2a
            r0 = 60000(0xea60, float:8.4078E-41)
            goto L2b
        L2a:
            r0 = r2
        L2b:
            boolean r1 = r6.i
            r3 = 0
            if (r1 == 0) goto L33
            r6.i = r3
            goto L34
        L33:
            r2 = r0
        L34:
            int r0 = r6.g
            if (r0 == 0) goto L47
            long r4 = r6.h
            long r0 = (long) r0
            long r4 = r4 + r0
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r0
            long r0 = (long) r2
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L47
            goto L48
        L47:
            r3 = 1
        L48:
            if (r3 == 0) goto L58
            r6.g = r2
            long r0 = java.lang.System.currentTimeMillis()
            r6.h = r0
            int r0 = r6.g
            long r0 = (long) r0
            r6.a(r0)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.a.c():void");
    }

    public int a(BDNotifyListener bDNotifyListener) {
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.n) {
            this.f.registerReceiver(this.l, new IntentFilter("android.com.baidu.location.TIMER.NOTIFY"), Permission.ACCESS_FINE_LOCATION, null);
            this.n = true;
        }
        if (bDNotifyListener.mCoorType == null) {
            return 1;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.c == null || System.currentTimeMillis() - this.d > 30000) {
            this.e.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.c.getLatitude(), this.c.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.c.getRadius();
            if (radius > 0.0f) {
                if (radius < this.b) {
                    this.b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.c, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.i = true;
                }
            }
        }
        c();
        return 1;
    }

    public void a() {
        PendingIntent pendingIntent = this.j;
        if (pendingIntent != null) {
            this.k.cancel(pendingIntent);
        }
        this.c = null;
        this.d = 0L;
        if (this.n) {
            this.f.unregisterReceiver(this.l);
        }
        this.n = false;
    }

    public void b(BDNotifyListener bDNotifyListener) {
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.c == null || System.currentTimeMillis() - this.d > DefaultDrmSessionManager.DEFAULT_SESSION_KEEPALIVE_MS) {
            this.e.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.c.getLatitude(), this.c.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.c.getRadius();
            if (radius > 0.0f) {
                if (radius < this.b) {
                    this.b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.c, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.i = true;
                }
            }
        }
        c();
    }

    public int c(BDNotifyListener bDNotifyListener) {
        PendingIntent pendingIntent;
        ArrayList<BDNotifyListener> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList.contains(bDNotifyListener)) {
            this.a.remove(bDNotifyListener);
        }
        if (this.a.size() != 0 || (pendingIntent = this.j) == null) {
            return 1;
        }
        this.k.cancel(pendingIntent);
        return 1;
    }
}
