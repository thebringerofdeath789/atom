package com.baidu.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.e;
import com.baidu.location.h.o;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.api.directions.v5.models.StepManeuver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.logging.LogFactory;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes.dex */
public final class LocationClient implements e.b {
    private static String A = null;
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    private static boolean L = false;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_FINE_PERMISSION = 10;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_COARSE_FAIL = 11;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    private boolean B;
    private boolean C;
    private Boolean D;
    private Boolean E;
    private Boolean F;
    private boolean G;
    private com.baidu.location.b.e H;
    private boolean I;
    private boolean J;
    private boolean K;
    private ServiceConnection M;
    private long a;
    private String b;
    private LocationClientOption c;
    private LocationClientOption d;
    private boolean e;
    private Context f;
    private Messenger g;
    private a h;
    private final Messenger i;
    private ArrayList<BDLocationListener> j;
    private ArrayList<BDAbstractLocationListener> k;
    private BDLocation l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private b q;
    private boolean r;
    private final Object s;
    private long t;
    private long u;
    private long v;
    private com.baidu.location.d.a w;
    private BDLocationListener x;
    private String y;
    private String z;

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends Handler {
        private final WeakReference<LocationClient> a;

        a(Looper looper, LocationClient locationClient) {
            super(looper);
            this.a = new WeakReference<>(locationClient);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LocationClient locationClient = this.a.get();
            if (locationClient == null) {
                return;
            }
            int i = message.what;
            int i2 = 21;
            boolean z = true;
            if (i != 21) {
                try {
                    if (i == 303) {
                        Bundle data = message.getData();
                        int i3 = data.getInt("loctype");
                        int i4 = data.getInt("diagtype");
                        byte[] byteArray = data.getByteArray("diagmessage");
                        if (i3 <= 0 || i4 <= 0 || byteArray == null || locationClient.k == null) {
                            return;
                        }
                        Iterator it = locationClient.k.iterator();
                        while (it.hasNext()) {
                            ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i3, i4, new String(byteArray, "UTF-8"));
                        }
                        return;
                    }
                    if (i == 406) {
                        Bundle data2 = message.getData();
                        byte[] byteArray2 = data2.getByteArray("mac");
                        String str = byteArray2 != null ? new String(byteArray2, "UTF-8") : null;
                        int i5 = data2.getInt("hotspot", -1);
                        if (locationClient.k != null) {
                            Iterator it2 = locationClient.k.iterator();
                            while (it2.hasNext()) {
                                ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i5);
                            }
                            return;
                        }
                        return;
                    }
                    if (i == 701) {
                        locationClient.b((BDLocation) message.obj);
                        return;
                    }
                    if (i == 708) {
                        locationClient.a((String) message.obj);
                        return;
                    }
                    if (i == 804) {
                        Bundle data3 = message.getData();
                        data3.setClassLoader(BDLocation.class.getClassLoader());
                        BDLocation bDLocation = (BDLocation) data3.getParcelable("vdr_location");
                        if (locationClient.k != null) {
                            Iterator it3 = locationClient.k.iterator();
                            while (it3.hasNext()) {
                                ((BDAbstractLocationListener) it3.next()).onReceiveVdrLocation(bDLocation);
                            }
                            return;
                        }
                        return;
                    }
                    if (i == 1300) {
                        locationClient.f(message);
                        return;
                    }
                    if (i == 1400) {
                        locationClient.g(message);
                        return;
                    }
                    i2 = 26;
                    if (i != 26) {
                        if (i == 27) {
                            locationClient.i(message);
                            return;
                        }
                        if (i != 54) {
                            z = false;
                            if (i != 55) {
                                if (i == 703) {
                                    Bundle data4 = message.getData();
                                    int i6 = data4.getInt(TtmlNode.ATTR_ID, 0);
                                    if (i6 > 0) {
                                        locationClient.a(i6, (Notification) data4.getParcelable(StepManeuver.NOTIFICATION));
                                        return;
                                    }
                                    return;
                                }
                                if (i == 704) {
                                    locationClient.a(message.getData().getBoolean("removenotify"));
                                    return;
                                }
                                switch (i) {
                                    case 1:
                                        locationClient.b();
                                        break;
                                    case 2:
                                        locationClient.c();
                                        break;
                                    case 3:
                                        locationClient.c(message);
                                        break;
                                    case 4:
                                        locationClient.g();
                                        break;
                                    case 5:
                                        locationClient.e(message);
                                        break;
                                    case 6:
                                        locationClient.h(message);
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        locationClient.d(message);
                                        break;
                                    case 9:
                                        locationClient.a(message);
                                        break;
                                    case 10:
                                        locationClient.b(message);
                                        break;
                                    case 11:
                                        locationClient.f();
                                        break;
                                    case 12:
                                        locationClient.a();
                                        break;
                                    default:
                                        super.handleMessage(message);
                                        break;
                                }
                                return;
                            }
                            if (!locationClient.c.location_change_notify) {
                                return;
                            }
                        } else if (!locationClient.c.location_change_notify) {
                            return;
                        }
                        locationClient.r = z;
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            } else {
                Bundle data5 = message.getData();
                data5.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation2 = (BDLocation) data5.getParcelable("locStr");
                if (!locationClient.J && locationClient.I && bDLocation2.getLocType() == 66) {
                    return;
                }
                if (!locationClient.J && locationClient.I) {
                    locationClient.J = true;
                    return;
                } else if (!locationClient.J) {
                    locationClient.J = true;
                }
            }
            locationClient.a(message, i2);
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(LocationClient locationClient, com.baidu.location.b bVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.s) {
                LocationClient.this.p = false;
                if (LocationClient.this.g != null && LocationClient.this.i != null) {
                    if ((LocationClient.this.j != null && LocationClient.this.j.size() >= 1) || (LocationClient.this.k != null && LocationClient.this.k.size() >= 1)) {
                        if (!LocationClient.this.n) {
                            LocationClient.this.h.obtainMessage(4).sendToTarget();
                            return;
                        }
                        if (LocationClient.this.q == null) {
                            LocationClient.this.q = LocationClient.this.new b();
                        }
                        LocationClient.this.h.postDelayed(LocationClient.this.q, LocationClient.this.c.scanSpan);
                    }
                }
            }
        }
    }

    private class c extends Thread {
        private c() {
        }

        /* synthetic */ c(LocationClient locationClient, com.baidu.location.b bVar) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (LocationClient.this.F.booleanValue()) {
                    if (LocationClient.this.H == null) {
                        LocationClient.this.H = new com.baidu.location.b.e(LocationClient.this.f, LocationClient.this.d, LocationClient.this, null);
                    }
                    if (LocationClient.this.d.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
                        LocationClient.this.H.d();
                        LocationClient.this.H.e();
                    }
                }
                LocationClient.this.h.obtainMessage(1).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public LocationClient(Context context) throws Exception {
        this.a = 0L;
        this.b = null;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.e = false;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = null;
        this.r = false;
        this.s = new Object();
        this.t = 0L;
        this.u = 0L;
        this.v = -1L;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = true;
        this.H = null;
        this.I = false;
        this.J = false;
        this.K = false;
        this.M = new com.baidu.location.b(this);
        d();
        this.f = context;
        this.c = new LocationClientOption();
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) throws Exception {
        this.a = 0L;
        this.b = null;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.e = false;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = null;
        this.r = false;
        this.s = new Object();
        this.t = 0L;
        this.u = 0L;
        this.v = -1L;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = true;
        this.H = null;
        this.I = false;
        this.J = false;
        this.K = false;
        this.M = new com.baidu.location.b(this);
        d();
        this.f = context;
        this.c = locationClientOption;
        this.d = new LocationClientOption(locationClientOption);
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Message obtain = Message.obtain((Handler) null, 28);
        try {
            obtain.replyTo = this.i;
            this.g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Notification notification) {
        try {
            Intent intent = new Intent(this.f, (Class<?>) f.class);
            intent.putExtra(StepManeuver.NOTIFICATION, notification);
            intent.putExtra(TtmlNode.ATTR_ID, i);
            intent.putExtra("command", 1);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f.startForegroundService(intent);
            } else {
                this.f.startService(intent);
            }
            this.K = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
        if (this.w == null) {
            this.w = new com.baidu.location.d.a(this.f, this);
        }
        this.w.a(bDNotifyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        if (this.e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                this.l = bDLocation;
                if (bDLocation.getLocType() == 61) {
                    this.t = System.currentTimeMillis();
                }
                if (this.l.getLocType() == 61 || this.l.getLocType() == 161) {
                    com.baidu.location.b.a.a().a(this.l.getLatitude(), this.l.getLongitude(), this.l.getCoorType());
                }
                b(i);
            } catch (Exception unused) {
            }
        }
    }

    private void a(BDLocation bDLocation) {
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        ArrayList<BDAbstractLocationListener> arrayList = this.k;
        if (arrayList != null) {
            Iterator<BDAbstractLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocString(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            Intent intent = new Intent(this.f, (Class<?>) f.class);
            intent.putExtra("removenotify", z);
            intent.putExtra("command", 2);
            this.f.startService(intent);
            this.K = true;
        } catch (Exception unused) {
        }
    }

    private boolean a(int i) {
        if (this.g != null && this.e) {
            try {
                this.g.send(Message.obtain((Handler) null, i));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.e) {
            return;
        }
        if (this.F.booleanValue()) {
            boolean d = o.d(this.f);
            if (this.d.isOnceLocation()) {
                d = true;
            }
            if (d) {
                try {
                    new com.baidu.location.c(this).start();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.d.isOnceLocation()) {
            return;
        }
        this.F = false;
        this.b = this.f.getPackageName();
        this.y = this.b + "_bdls_v2.9";
        Intent intent = new Intent(this.f, (Class<?>) f.class);
        try {
            intent.putExtra("debug_dev", this.G);
        } catch (Exception unused2) {
        }
        if (this.c == null) {
            this.c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.c.isIgnoreKillProcess);
        intent.putExtra("auth_key", A);
        try {
            this.f.bindService(intent, this.M, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.e = false;
        }
    }

    private void b(int i) {
        if (this.l.getCoorType() == null) {
            this.l.setCoorType(this.c.coorType);
        }
        if (this.m || ((this.c.location_change_notify && this.l.getLocType() == 61) || this.l.getLocType() == 66 || this.l.getLocType() == 67 || this.B || this.l.getLocType() == 161)) {
            if (this.o || this.v == -1 || System.currentTimeMillis() - this.v >= getLocOption().getScanSpan() - 300) {
                ArrayList<BDLocationListener> arrayList = this.j;
                if (arrayList != null) {
                    Iterator<BDLocationListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onReceiveLocation(this.l);
                    }
                }
                ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
                if (arrayList2 != null) {
                    Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onReceiveLocation(this.l);
                    }
                }
                this.v = System.currentTimeMillis();
                if (this.o) {
                    this.o = false;
                }
            }
            if (this.l.getLocType() == 66 || this.l.getLocType() == 67) {
                return;
            }
            this.m = false;
            this.u = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
        com.baidu.location.d.a aVar = this.w;
        if (aVar != null) {
            aVar.c(bDNotifyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BDLocation bDLocation) {
        if (this.C) {
            return;
        }
        this.l = bDLocation;
        if (!this.J && bDLocation.getLocType() == 161) {
            this.I = true;
            com.baidu.location.b.a.a().a(bDLocation.getLatitude(), bDLocation.getLongitude(), bDLocation.getCoorType());
        }
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.e || this.g == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.i;
        try {
            this.g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f.unbindService(this.M);
            if (this.K) {
                try {
                    this.f.stopService(new Intent(this.f, (Class<?>) f.class));
                } catch (Exception unused) {
                }
                this.K = false;
            }
        } catch (Exception unused2) {
        }
        synchronized (this.s) {
            try {
                if (this.p) {
                    this.h.removeCallbacks(this.q);
                    this.p = false;
                }
            } catch (Exception unused3) {
            }
        }
        com.baidu.location.d.a aVar = this.w;
        if (aVar != null) {
            aVar.a();
        }
        this.g = null;
        this.n = false;
        this.B = false;
        this.e = false;
        this.I = false;
        this.J = false;
        this.v = -1L;
        this.o = false;
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        this.n = false;
        if (message == null || message.obj == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.c.optionEquals(locationClientOption)) {
            return;
        }
        com.baidu.location.b bVar = null;
        if (this.c.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.s) {
                    if (this.p) {
                        this.h.removeCallbacks(this.q);
                        this.p = false;
                    }
                    if (locationClientOption.scanSpan >= 1000 && !this.p) {
                        if (this.q == null) {
                            this.q = new b(this, bVar);
                        }
                        this.h.postDelayed(this.q, locationClientOption.scanSpan);
                        this.p = true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.c = new LocationClientOption(locationClientOption);
        if (this.g != null && o.h(this.f) >= 1) {
            try {
                Message obtain = Message.obtain((Handler) null, 15);
                obtain.replyTo = this.i;
                obtain.setData(e());
                this.g.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void d() throws Exception {
        if (L) {
            return;
        }
        Log.e("baidu_location_Client", "The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
        throw new Exception("The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.x = (BDLocationListener) message.obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle e() {
        if (this.c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.b);
        bundle.putString("prodName", this.c.prodName);
        bundle.putString("coorType", this.c.coorType);
        bundle.putString("addrType", this.c.addrType);
        bundle.putBoolean("openGPS", this.c.openGps);
        bundle.putBoolean("location_change_notify", this.c.location_change_notify);
        bundle.putInt("scanSpan", this.c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.c.enableSimulateGps);
        bundle.putInt("timeOut", this.c.timeOut);
        bundle.putInt(LogFactory.PRIORITY_KEY, this.c.priority);
        bundle.putBoolean("map", this.D.booleanValue());
        bundle.putBoolean("import", this.E.booleanValue());
        bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
        bundle.putBoolean("isneednewrgc", this.c.isNeedNewVersionRgc);
        bundle.putInt("autoNotifyMaxInterval", this.c.a());
        bundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.c.b());
        bundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
        bundle.putInt("wfnum", com.baidu.location.b.a.a().b);
        bundle.putBoolean("ischeckper", com.baidu.location.b.a.a().a);
        bundle.putFloat("wfsm", (float) com.baidu.location.b.a.a().c);
        bundle.putDouble("gnmcrm", com.baidu.location.b.a.a().f);
        bundle.putInt("gnmcon", com.baidu.location.b.a.a().g);
        bundle.putInt("iupl", com.baidu.location.b.a.a().h);
        bundle.putInt("lpcs", com.baidu.location.b.a.a().e);
        bundle.putInt("hpdts", com.baidu.location.b.a.a().o);
        bundle.putInt("oldts", com.baidu.location.b.a.a().p);
        bundle.putBoolean("isEnableBeidouMode", this.c.isEnableBeidouMode);
        bundle.putInt("onic", com.baidu.location.b.a.a().q);
        bundle.putInt("nlcs", com.baidu.location.b.a.a().r);
        bundle.putFloat("ncsr", com.baidu.location.b.a.a().s);
        bundle.putFloat("cscr", com.baidu.location.b.a.a().t);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        if (this.j.contains(bDLocationListener)) {
            return;
        }
        this.j.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.g == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 22);
        try {
            obtain.replyTo = this.i;
            this.g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        if (this.k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i;
        LocationClientOption locationClientOption;
        if (this.g == null) {
            return;
        }
        int h = o.h(this.f);
        com.baidu.location.b bVar = null;
        if ((System.currentTimeMillis() - this.t > 3000 || (!((locationClientOption = this.c) == null || locationClientOption.location_change_notify) || this.n)) && h == 1) {
            if (!this.B || System.currentTimeMillis() - this.u > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US || this.n) {
                Message obtain = Message.obtain((Handler) null, 22);
                if (this.n) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.n);
                    this.n = false;
                    obtain.setData(bundle);
                }
                try {
                    obtain.replyTo = this.i;
                    this.g.send(obtain);
                    this.a = System.currentTimeMillis();
                    this.m = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (h < 1) {
            BDLocation bDLocation = new BDLocation();
            if (h == -1) {
                i = 69;
            } else if (h == -2) {
                i = 70;
            } else {
                if (h == 0) {
                    i = 71;
                }
                a(bDLocation);
            }
            bDLocation.setLocType(i);
            a(bDLocation);
        }
        synchronized (this.s) {
            LocationClientOption locationClientOption2 = this.c;
            if (locationClientOption2 != null && locationClientOption2.scanSpan >= 1000 && !this.p) {
                if (this.q == null) {
                    this.q = new b(this, bVar);
                }
                this.h.postDelayed(this.q, this.c.scanSpan);
                this.p = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
        ArrayList<BDAbstractLocationListener> arrayList = this.k;
        if (arrayList == null || !arrayList.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.remove(bDAbstractLocationListener);
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList == null || !arrayList.contains(bDLocationListener)) {
            return;
        }
        this.j.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Message message) {
        try {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
            if (this.x != null) {
                LocationClientOption locationClientOption = this.c;
                if (locationClientOption != null && locationClientOption.isDisableCache() && bDLocation.getLocType() == 65) {
                    return;
                }
                this.x.onReceiveLocation(bDLocation);
            }
        } catch (Exception unused) {
        }
    }

    public static void setAgreePrivacy(boolean z) {
        L = z;
    }

    public static void setKey(String str) {
        A = str;
    }

    public void disableAssistantLocation() {
        com.baidu.location.b.o.a().b();
    }

    public void disableLocInForeground(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", z);
        Message obtainMessage = this.h.obtainMessage(704);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public void enableAssistantLocation(WebView webView) {
        com.baidu.location.b.o.a().a(this.f, webView, this);
    }

    public void enableLocInForeground(int i, Notification notification) {
        if (i <= 0 || notification == null) {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(TtmlNode.ATTR_ID, i);
        bundle.putParcelable(StepManeuver.NOTIFICATION, notification);
        Message obtainMessage = this.h.obtainMessage(IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public String getAccessKey() {
        try {
            String b2 = com.baidu.location.a.a.b(this.f);
            this.z = b2;
            if (TextUtils.isEmpty(b2)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s", this.z);
        } catch (Exception unused) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.l;
    }

    public LocationClientOption getLocOption() {
        return this.c;
    }

    public String getVersion() {
        return "9.4.0.1";
    }

    public boolean isStarted() {
        return this.e;
    }

    public void onReceiveLightLocString(String str) {
        Message obtainMessage = this.h.obtainMessage(708);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.location.b.e.b
    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.J || this.I) && bDLocation != null) {
            Message obtainMessage = this.h.obtainMessage(701);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(1300);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.h.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.h.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.h.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() {
        if (this.g != null && this.e) {
            try {
                this.g.send(Message.obtain((Handler) null, 406));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public int requestLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.g == null || this.i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.j;
        if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.k) == null || arrayList.size() < 1)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.a < 1000) {
            return 6;
        }
        this.n = true;
        this.o = true;
        Message obtainMessage = this.h.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.h.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.g == null || this.i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.j;
        if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.k) == null || arrayList.size() < 1)) {
            return 2;
        }
        this.h.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void restart() {
        stop();
        this.C = false;
        this.h.sendEmptyMessageDelayed(1, 1000L);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        this.d = new LocationClientOption(locationClientOption);
        Message obtainMessage = this.h.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.C = false;
        if (o.b()) {
            return;
        }
        LBSAuthManager.getInstance(this.f.getApplicationContext()).setPrivacyMode(L);
        com.baidu.location.b.a.a().a(this.f, this.d, (String) null);
        new c(this, null).start();
    }

    public boolean startIndoorMode() {
        boolean a2 = a(110);
        if (a2) {
            this.B = true;
        }
        return a2;
    }

    public boolean startVdr(ArrayList<String> arrayList) {
        if (this.g == null || !this.e || arrayList == null) {
            return false;
        }
        if (arrayList != null) {
            try {
                if (arrayList.size() == 1) {
                    String str = arrayList.get(0);
                    Message obtain = Message.obtain((Handler) null, IMediaPlayer.MEDIA_INFO_METADATA_UPDATE);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("naviLinkList_gz", o.a(str.getBytes("UTF-8")));
                    obtain.setData(bundle);
                    this.g.send(obtain);
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public void stop() {
        this.C = true;
        this.h.obtainMessage(2).sendToTarget();
        this.H = null;
    }

    public boolean stopIndoorMode() {
        boolean a2 = a(111);
        if (a2) {
            this.B = false;
        }
        return a2;
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(1400);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.g == null || this.i == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.g.send(obtain);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
