package com.baidu.location.p008d;

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

/* renamed from: com.baidu.location.d.a */
/* loaded from: classes.dex */
public class C0684a {

    /* renamed from: e */
    private LocationClient f840e;

    /* renamed from: f */
    private Context f841f;

    /* renamed from: k */
    private AlarmManager f846k;

    /* renamed from: l */
    private a f847l;

    /* renamed from: m */
    private b f848m;

    /* renamed from: n */
    private boolean f849n;

    /* renamed from: a */
    private ArrayList<BDNotifyListener> f836a = null;

    /* renamed from: b */
    private float f837b = Float.MAX_VALUE;

    /* renamed from: c */
    private BDLocation f838c = null;

    /* renamed from: d */
    private long f839d = 0;

    /* renamed from: g */
    private int f842g = 0;

    /* renamed from: h */
    private long f843h = 0;

    /* renamed from: i */
    private boolean f844i = false;

    /* renamed from: j */
    private PendingIntent f845j = null;

    /* renamed from: com.baidu.location.d.a$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (C0684a.this.f836a == null || C0684a.this.f836a.isEmpty()) {
                return;
            }
            C0684a.this.f840e.requestNotifyLocation();
        }
    }

    /* renamed from: com.baidu.location.d.a$b */
    public class b implements BDLocationListener {
        public b() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (C0684a.this.f836a == null || C0684a.this.f836a.size() <= 0) {
                return;
            }
            C0684a.this.m693a(bDLocation);
        }
    }

    public C0684a(Context context, LocationClient locationClient) {
        this.f840e = null;
        this.f841f = null;
        this.f846k = null;
        this.f847l = null;
        b bVar = new b();
        this.f848m = bVar;
        this.f849n = false;
        this.f841f = context;
        this.f840e = locationClient;
        locationClient.registerNotifyLocationListener(bVar);
        this.f846k = (AlarmManager) this.f841f.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f847l = new a();
        this.f849n = false;
    }

    /* renamed from: a */
    private void m692a(long j) {
        try {
            PendingIntent pendingIntent = this.f845j;
            if (pendingIntent != null) {
                this.f846k.cancel(pendingIntent);
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f841f, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), 201326592);
            this.f845j = broadcast;
            if (broadcast == null) {
                return;
            }
            this.f846k.set(0, System.currentTimeMillis() + j, this.f845j);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m693a(BDLocation bDLocation) {
        boolean z;
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != 161 && bDLocation.getLocType() != 65) {
            m692a(120000L);
            return;
        }
        if (System.currentTimeMillis() - this.f839d < 5000 || this.f836a == null) {
            return;
        }
        this.f838c = bDLocation;
        this.f839d = System.currentTimeMillis();
        float[] fArr = new float[1];
        Iterator<BDNotifyListener> it = this.f836a.iterator();
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
                    this.f844i = true;
                }
            }
            z = true;
        }
        if (f < this.f837b) {
            this.f837b = f;
        }
        this.f842g = 0;
        m697c();
    }

    /* renamed from: b */
    private boolean m696b() {
        ArrayList<BDNotifyListener> arrayList = this.f836a;
        boolean z = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<BDNotifyListener> it = this.f836a.iterator();
            while (it.hasNext()) {
                if (it.next().Notified < 3) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (r2 > ((r6.f843h + r0) - java.lang.System.currentTimeMillis())) goto L25;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m697c() {
        /*
            r6 = this;
            boolean r0 = r6.m696b()
            if (r0 != 0) goto L7
            return
        L7:
            float r0 = r6.f837b
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
            boolean r1 = r6.f844i
            r3 = 0
            if (r1 == 0) goto L33
            r6.f844i = r3
            goto L34
        L33:
            r2 = r0
        L34:
            int r0 = r6.f842g
            if (r0 == 0) goto L47
            long r4 = r6.f843h
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
            r6.f842g = r2
            long r0 = java.lang.System.currentTimeMillis()
            r6.f843h = r0
            int r0 = r6.f842g
            long r0 = (long) r0
            r6.m692a(r0)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p008d.C0684a.m697c():void");
    }

    /* renamed from: a */
    public int m698a(BDNotifyListener bDNotifyListener) {
        if (this.f836a == null) {
            this.f836a = new ArrayList<>();
        }
        this.f836a.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.f849n) {
            this.f841f.registerReceiver(this.f847l, new IntentFilter("android.com.baidu.location.TIMER.NOTIFY"), Permission.ACCESS_FINE_LOCATION, null);
            this.f849n = true;
        }
        if (bDNotifyListener.mCoorType == null) {
            return 1;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.f838c == null || System.currentTimeMillis() - this.f839d > 30000) {
            this.f840e.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f838c.getLatitude(), this.f838c.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f838c.getRadius();
            if (radius > 0.0f) {
                if (radius < this.f837b) {
                    this.f837b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.f838c, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.f844i = true;
                }
            }
        }
        m697c();
        return 1;
    }

    /* renamed from: a */
    public void m699a() {
        PendingIntent pendingIntent = this.f845j;
        if (pendingIntent != null) {
            this.f846k.cancel(pendingIntent);
        }
        this.f838c = null;
        this.f839d = 0L;
        if (this.f849n) {
            this.f841f.unregisterReceiver(this.f847l);
        }
        this.f849n = false;
    }

    /* renamed from: b */
    public void m700b(BDNotifyListener bDNotifyListener) {
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals("gcj02")) {
            double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.f838c == null || System.currentTimeMillis() - this.f839d > DefaultDrmSessionManager.DEFAULT_SESSION_KEEPALIVE_MS) {
            this.f840e.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f838c.getLatitude(), this.f838c.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f838c.getRadius();
            if (radius > 0.0f) {
                if (radius < this.f837b) {
                    this.f837b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.f838c, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.f844i = true;
                }
            }
        }
        m697c();
    }

    /* renamed from: c */
    public int m701c(BDNotifyListener bDNotifyListener) {
        PendingIntent pendingIntent;
        ArrayList<BDNotifyListener> arrayList = this.f836a;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList.contains(bDNotifyListener)) {
            this.f836a.remove(bDNotifyListener);
        }
        if (this.f836a.size() != 0 || (pendingIntent = this.f845j) == null) {
            return 1;
        }
        this.f846k.cancel(pendingIntent);
        return 1;
    }
}