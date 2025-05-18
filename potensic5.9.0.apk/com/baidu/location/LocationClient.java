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
import com.baidu.location.p005a.C0643a;
import com.baidu.location.p006b.C0645a;
import com.baidu.location.p006b.C0651e;
import com.baidu.location.p006b.C0661o;
import com.baidu.location.p008d.C0684a;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.api.directions.p022v5.models.StepManeuver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.logging.LogFactory;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes.dex */
public final class LocationClient implements C0651e.b {

    /* renamed from: A */
    private static String f332A = null;
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;

    /* renamed from: L */
    private static boolean f333L = false;
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

    /* renamed from: B */
    private boolean f334B;

    /* renamed from: C */
    private boolean f335C;

    /* renamed from: D */
    private Boolean f336D;

    /* renamed from: E */
    private Boolean f337E;

    /* renamed from: F */
    private Boolean f338F;

    /* renamed from: G */
    private boolean f339G;

    /* renamed from: H */
    private C0651e f340H;

    /* renamed from: I */
    private boolean f341I;

    /* renamed from: J */
    private boolean f342J;

    /* renamed from: K */
    private boolean f343K;

    /* renamed from: M */
    private ServiceConnection f344M;

    /* renamed from: a */
    private long f345a;

    /* renamed from: b */
    private String f346b;

    /* renamed from: c */
    private LocationClientOption f347c;

    /* renamed from: d */
    private LocationClientOption f348d;

    /* renamed from: e */
    private boolean f349e;

    /* renamed from: f */
    private Context f350f;

    /* renamed from: g */
    private Messenger f351g;

    /* renamed from: h */
    private HandlerC0638a f352h;

    /* renamed from: i */
    private final Messenger f353i;

    /* renamed from: j */
    private ArrayList<BDLocationListener> f354j;

    /* renamed from: k */
    private ArrayList<BDAbstractLocationListener> f355k;

    /* renamed from: l */
    private BDLocation f356l;

    /* renamed from: m */
    private boolean f357m;

    /* renamed from: n */
    private boolean f358n;

    /* renamed from: o */
    private boolean f359o;

    /* renamed from: p */
    private boolean f360p;

    /* renamed from: q */
    private RunnableC0639b f361q;

    /* renamed from: r */
    private boolean f362r;

    /* renamed from: s */
    private final Object f363s;

    /* renamed from: t */
    private long f364t;

    /* renamed from: u */
    private long f365u;

    /* renamed from: v */
    private long f366v;

    /* renamed from: w */
    private C0684a f367w;

    /* renamed from: x */
    private BDLocationListener f368x;

    /* renamed from: y */
    private String f369y;

    /* renamed from: z */
    private String f370z;

    /* renamed from: com.baidu.location.LocationClient$a */
    private static class HandlerC0638a extends Handler {

        /* renamed from: a */
        private final WeakReference<LocationClient> f371a;

        HandlerC0638a(Looper looper, LocationClient locationClient) {
            super(looper);
            this.f371a = new WeakReference<>(locationClient);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LocationClient locationClient = this.f371a.get();
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
                        if (i3 <= 0 || i4 <= 0 || byteArray == null || locationClient.f355k == null) {
                            return;
                        }
                        Iterator it = locationClient.f355k.iterator();
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
                        if (locationClient.f355k != null) {
                            Iterator it2 = locationClient.f355k.iterator();
                            while (it2.hasNext()) {
                                ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i5);
                            }
                            return;
                        }
                        return;
                    }
                    if (i == 701) {
                        locationClient.m247b((BDLocation) message.obj);
                        return;
                    }
                    if (i == 708) {
                        locationClient.m240a((String) message.obj);
                        return;
                    }
                    if (i == 804) {
                        Bundle data3 = message.getData();
                        data3.setClassLoader(BDLocation.class.getClassLoader());
                        BDLocation bDLocation = (BDLocation) data3.getParcelable("vdr_location");
                        if (locationClient.f355k != null) {
                            Iterator it3 = locationClient.f355k.iterator();
                            while (it3.hasNext()) {
                                ((BDAbstractLocationListener) it3.next()).onReceiveVdrLocation(bDLocation);
                            }
                            return;
                        }
                        return;
                    }
                    if (i == 1300) {
                        locationClient.m268f(message);
                        return;
                    }
                    if (i == 1400) {
                        locationClient.m272g(message);
                        return;
                    }
                    i2 = 26;
                    if (i != 26) {
                        if (i == 27) {
                            locationClient.m278i(message);
                            return;
                        }
                        if (i != 54) {
                            z = false;
                            if (i != 55) {
                                if (i == 703) {
                                    Bundle data4 = message.getData();
                                    int i6 = data4.getInt(TtmlNode.ATTR_ID, 0);
                                    if (i6 > 0) {
                                        locationClient.m231a(i6, (Notification) data4.getParcelable(StepManeuver.NOTIFICATION));
                                        return;
                                    }
                                    return;
                                }
                                if (i == 704) {
                                    locationClient.m241a(message.getData().getBoolean("removenotify"));
                                    return;
                                }
                                switch (i) {
                                    case 1:
                                        locationClient.m244b();
                                        break;
                                    case 2:
                                        locationClient.m252c();
                                        break;
                                    case 3:
                                        locationClient.m253c(message);
                                        break;
                                    case 4:
                                        locationClient.m271g();
                                        break;
                                    case 5:
                                        locationClient.m263e(message);
                                        break;
                                    case 6:
                                        locationClient.m275h(message);
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        locationClient.m258d(message);
                                        break;
                                    case 9:
                                        locationClient.m232a(message);
                                        break;
                                    case 10:
                                        locationClient.m246b(message);
                                        break;
                                    case 11:
                                        locationClient.m267f();
                                        break;
                                    case 12:
                                        locationClient.m230a();
                                        break;
                                    default:
                                        super.handleMessage(message);
                                        break;
                                }
                                return;
                            }
                            if (!locationClient.f347c.location_change_notify) {
                                return;
                            }
                        } else if (!locationClient.f347c.location_change_notify) {
                            return;
                        }
                        locationClient.f362r = z;
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            } else {
                Bundle data5 = message.getData();
                data5.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation2 = (BDLocation) data5.getParcelable("locStr");
                if (!locationClient.f342J && locationClient.f341I && bDLocation2.getLocType() == 66) {
                    return;
                }
                if (!locationClient.f342J && locationClient.f341I) {
                    locationClient.f342J = true;
                    return;
                } else if (!locationClient.f342J) {
                    locationClient.f342J = true;
                }
            }
            locationClient.m233a(message, i2);
        }
    }

    /* renamed from: com.baidu.location.LocationClient$b */
    private class RunnableC0639b implements Runnable {
        private RunnableC0639b() {
        }

        /* synthetic */ RunnableC0639b(LocationClient locationClient, ServiceConnectionC0644b serviceConnectionC0644b) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.f363s) {
                LocationClient.this.f360p = false;
                if (LocationClient.this.f351g != null && LocationClient.this.f353i != null) {
                    if ((LocationClient.this.f354j != null && LocationClient.this.f354j.size() >= 1) || (LocationClient.this.f355k != null && LocationClient.this.f355k.size() >= 1)) {
                        if (!LocationClient.this.f358n) {
                            LocationClient.this.f352h.obtainMessage(4).sendToTarget();
                            return;
                        }
                        if (LocationClient.this.f361q == null) {
                            LocationClient.this.f361q = LocationClient.this.new RunnableC0639b();
                        }
                        LocationClient.this.f352h.postDelayed(LocationClient.this.f361q, LocationClient.this.f347c.scanSpan);
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.location.LocationClient$c */
    private class C0640c extends Thread {
        private C0640c() {
        }

        /* synthetic */ C0640c(LocationClient locationClient, ServiceConnectionC0644b serviceConnectionC0644b) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (LocationClient.this.f338F.booleanValue()) {
                    if (LocationClient.this.f340H == null) {
                        LocationClient.this.f340H = new C0651e(LocationClient.this.f350f, LocationClient.this.f348d, LocationClient.this, null);
                    }
                    if (LocationClient.this.f348d.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
                        LocationClient.this.f340H.m401d();
                        LocationClient.this.f340H.m402e();
                    }
                }
                LocationClient.this.f352h.obtainMessage(1).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public LocationClient(Context context) throws Exception {
        this.f345a = 0L;
        this.f346b = null;
        this.f347c = new LocationClientOption();
        this.f348d = new LocationClientOption();
        this.f349e = false;
        this.f350f = null;
        this.f351g = null;
        this.f354j = null;
        this.f355k = null;
        this.f356l = null;
        this.f357m = false;
        this.f358n = false;
        this.f359o = false;
        this.f360p = false;
        this.f361q = null;
        this.f362r = false;
        this.f363s = new Object();
        this.f364t = 0L;
        this.f365u = 0L;
        this.f366v = -1L;
        this.f367w = null;
        this.f368x = null;
        this.f369y = null;
        this.f334B = false;
        this.f335C = true;
        this.f336D = false;
        this.f337E = false;
        this.f338F = true;
        this.f340H = null;
        this.f341I = false;
        this.f342J = false;
        this.f343K = false;
        this.f344M = new ServiceConnectionC0644b(this);
        m257d();
        this.f350f = context;
        this.f347c = new LocationClientOption();
        this.f352h = new HandlerC0638a(Looper.getMainLooper(), this);
        this.f353i = new Messenger(this.f352h);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) throws Exception {
        this.f345a = 0L;
        this.f346b = null;
        this.f347c = new LocationClientOption();
        this.f348d = new LocationClientOption();
        this.f349e = false;
        this.f350f = null;
        this.f351g = null;
        this.f354j = null;
        this.f355k = null;
        this.f356l = null;
        this.f357m = false;
        this.f358n = false;
        this.f359o = false;
        this.f360p = false;
        this.f361q = null;
        this.f362r = false;
        this.f363s = new Object();
        this.f364t = 0L;
        this.f365u = 0L;
        this.f366v = -1L;
        this.f367w = null;
        this.f368x = null;
        this.f369y = null;
        this.f334B = false;
        this.f335C = true;
        this.f336D = false;
        this.f337E = false;
        this.f338F = true;
        this.f340H = null;
        this.f341I = false;
        this.f342J = false;
        this.f343K = false;
        this.f344M = new ServiceConnectionC0644b(this);
        m257d();
        this.f350f = context;
        this.f347c = locationClientOption;
        this.f348d = new LocationClientOption(locationClientOption);
        this.f352h = new HandlerC0638a(Looper.getMainLooper(), this);
        this.f353i = new Messenger(this.f352h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m230a() {
        Message obtain = Message.obtain((Handler) null, 28);
        try {
            obtain.replyTo = this.f353i;
            this.f351g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m231a(int i, Notification notification) {
        try {
            Intent intent = new Intent(this.f350f, (Class<?>) ServiceC0702f.class);
            intent.putExtra(StepManeuver.NOTIFICATION, notification);
            intent.putExtra(TtmlNode.ATTR_ID, i);
            intent.putExtra("command", 1);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f350f.startForegroundService(intent);
            } else {
                this.f350f.startService(intent);
            }
            this.f343K = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m232a(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
        if (this.f367w == null) {
            this.f367w = new C0684a(this.f350f, this);
        }
        this.f367w.m698a(bDNotifyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m233a(Message message, int i) {
        if (this.f349e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                this.f356l = bDLocation;
                if (bDLocation.getLocType() == 61) {
                    this.f364t = System.currentTimeMillis();
                }
                if (this.f356l.getLocType() == 61 || this.f356l.getLocType() == 161) {
                    C0645a.m302a().m307a(this.f356l.getLatitude(), this.f356l.getLongitude(), this.f356l.getCoorType());
                }
                m245b(i);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m234a(BDLocation bDLocation) {
        ArrayList<BDLocationListener> arrayList = this.f354j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.f355k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m240a(String str) {
        ArrayList<BDAbstractLocationListener> arrayList = this.f355k;
        if (arrayList != null) {
            Iterator<BDAbstractLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocString(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m241a(boolean z) {
        try {
            Intent intent = new Intent(this.f350f, (Class<?>) ServiceC0702f.class);
            intent.putExtra("removenotify", z);
            intent.putExtra("command", 2);
            this.f350f.startService(intent);
            this.f343K = true;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private boolean m242a(int i) {
        if (this.f351g != null && this.f349e) {
            try {
                this.f351g.send(Message.obtain((Handler) null, i));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m244b() {
        if (this.f349e) {
            return;
        }
        if (this.f338F.booleanValue()) {
            boolean m1161d = C0733o.m1161d(this.f350f);
            if (this.f348d.isOnceLocation()) {
                m1161d = true;
            }
            if (m1161d) {
                try {
                    new C0673c(this).start();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.f348d.isOnceLocation()) {
            return;
        }
        this.f338F = false;
        this.f346b = this.f350f.getPackageName();
        this.f369y = this.f346b + "_bdls_v2.9";
        Intent intent = new Intent(this.f350f, (Class<?>) ServiceC0702f.class);
        try {
            intent.putExtra("debug_dev", this.f339G);
        } catch (Exception unused2) {
        }
        if (this.f347c == null) {
            this.f347c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.f347c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.f347c.isIgnoreKillProcess);
        intent.putExtra("auth_key", f332A);
        try {
            this.f350f.bindService(intent, this.f344M, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.f349e = false;
        }
    }

    /* renamed from: b */
    private void m245b(int i) {
        if (this.f356l.getCoorType() == null) {
            this.f356l.setCoorType(this.f347c.coorType);
        }
        if (this.f357m || ((this.f347c.location_change_notify && this.f356l.getLocType() == 61) || this.f356l.getLocType() == 66 || this.f356l.getLocType() == 67 || this.f334B || this.f356l.getLocType() == 161)) {
            if (this.f359o || this.f366v == -1 || System.currentTimeMillis() - this.f366v >= getLocOption().getScanSpan() - 300) {
                ArrayList<BDLocationListener> arrayList = this.f354j;
                if (arrayList != null) {
                    Iterator<BDLocationListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onReceiveLocation(this.f356l);
                    }
                }
                ArrayList<BDAbstractLocationListener> arrayList2 = this.f355k;
                if (arrayList2 != null) {
                    Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onReceiveLocation(this.f356l);
                    }
                }
                this.f366v = System.currentTimeMillis();
                if (this.f359o) {
                    this.f359o = false;
                }
            }
            if (this.f356l.getLocType() == 66 || this.f356l.getLocType() == 67) {
                return;
            }
            this.f357m = false;
            this.f365u = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m246b(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
        C0684a c0684a = this.f367w;
        if (c0684a != null) {
            c0684a.m701c(bDNotifyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m247b(BDLocation bDLocation) {
        if (this.f335C) {
            return;
        }
        this.f356l = bDLocation;
        if (!this.f342J && bDLocation.getLocType() == 161) {
            this.f341I = true;
            C0645a.m302a().m307a(bDLocation.getLatitude(), bDLocation.getLongitude(), bDLocation.getCoorType());
        }
        ArrayList<BDLocationListener> arrayList = this.f354j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.f355k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m252c() {
        if (!this.f349e || this.f351g == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.f353i;
        try {
            this.f351g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f350f.unbindService(this.f344M);
            if (this.f343K) {
                try {
                    this.f350f.stopService(new Intent(this.f350f, (Class<?>) ServiceC0702f.class));
                } catch (Exception unused) {
                }
                this.f343K = false;
            }
        } catch (Exception unused2) {
        }
        synchronized (this.f363s) {
            try {
                if (this.f360p) {
                    this.f352h.removeCallbacks(this.f361q);
                    this.f360p = false;
                }
            } catch (Exception unused3) {
            }
        }
        C0684a c0684a = this.f367w;
        if (c0684a != null) {
            c0684a.m699a();
        }
        this.f351g = null;
        this.f358n = false;
        this.f334B = false;
        this.f349e = false;
        this.f341I = false;
        this.f342J = false;
        this.f366v = -1L;
        this.f359o = false;
        this.f338F = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m253c(Message message) {
        this.f358n = false;
        if (message == null || message.obj == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.f347c.optionEquals(locationClientOption)) {
            return;
        }
        ServiceConnectionC0644b serviceConnectionC0644b = null;
        if (this.f347c.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.f363s) {
                    if (this.f360p) {
                        this.f352h.removeCallbacks(this.f361q);
                        this.f360p = false;
                    }
                    if (locationClientOption.scanSpan >= 1000 && !this.f360p) {
                        if (this.f361q == null) {
                            this.f361q = new RunnableC0639b(this, serviceConnectionC0644b);
                        }
                        this.f352h.postDelayed(this.f361q, locationClientOption.scanSpan);
                        this.f360p = true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.f347c = new LocationClientOption(locationClientOption);
        if (this.f351g != null && C0733o.m1168h(this.f350f) >= 1) {
            try {
                Message obtain = Message.obtain((Handler) null, 15);
                obtain.replyTo = this.f353i;
                obtain.setData(m261e());
                this.f351g.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private void m257d() throws Exception {
        if (f333L) {
            return;
        }
        Log.e("baidu_location_Client", "The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
        throw new Exception("The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m258d(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.f368x = (BDLocationListener) message.obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public Bundle m261e() {
        if (this.f347c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.f346b);
        bundle.putString("prodName", this.f347c.prodName);
        bundle.putString("coorType", this.f347c.coorType);
        bundle.putString("addrType", this.f347c.addrType);
        bundle.putBoolean("openGPS", this.f347c.openGps);
        bundle.putBoolean("location_change_notify", this.f347c.location_change_notify);
        bundle.putInt("scanSpan", this.f347c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.f347c.enableSimulateGps);
        bundle.putInt("timeOut", this.f347c.timeOut);
        bundle.putInt(LogFactory.PRIORITY_KEY, this.f347c.priority);
        bundle.putBoolean("map", this.f336D.booleanValue());
        bundle.putBoolean("import", this.f337E.booleanValue());
        bundle.putBoolean("needDirect", this.f347c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.f347c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.f347c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.f347c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.f347c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.f347c.isNeedAltitude);
        bundle.putBoolean("isneednewrgc", this.f347c.isNeedNewVersionRgc);
        bundle.putInt("autoNotifyMaxInterval", this.f347c.m293a());
        bundle.putInt("autoNotifyMinTimeInterval", this.f347c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.f347c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.f347c.m294b());
        bundle.putInt("wifitimeout", this.f347c.wifiCacheTimeOut);
        bundle.putInt("wfnum", C0645a.m302a().f389b);
        bundle.putBoolean("ischeckper", C0645a.m302a().f388a);
        bundle.putFloat("wfsm", (float) C0645a.m302a().f390c);
        bundle.putDouble("gnmcrm", C0645a.m302a().f393f);
        bundle.putInt("gnmcon", C0645a.m302a().f394g);
        bundle.putInt("iupl", C0645a.m302a().f395h);
        bundle.putInt("lpcs", C0645a.m302a().f392e);
        bundle.putInt("hpdts", C0645a.m302a().f402o);
        bundle.putInt("oldts", C0645a.m302a().f403p);
        bundle.putBoolean("isEnableBeidouMode", this.f347c.isEnableBeidouMode);
        bundle.putInt("onic", C0645a.m302a().f404q);
        bundle.putInt("nlcs", C0645a.m302a().f405r);
        bundle.putFloat("ncsr", C0645a.m302a().f406s);
        bundle.putFloat("cscr", C0645a.m302a().f407t);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m263e(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.f354j == null) {
            this.f354j = new ArrayList<>();
        }
        if (this.f354j.contains(bDLocationListener)) {
            return;
        }
        this.f354j.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m267f() {
        if (this.f351g == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 22);
        try {
            obtain.replyTo = this.f353i;
            this.f351g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m268f(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
        if (this.f355k == null) {
            this.f355k = new ArrayList<>();
        }
        if (this.f355k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.f355k.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m271g() {
        int i;
        LocationClientOption locationClientOption;
        if (this.f351g == null) {
            return;
        }
        int m1168h = C0733o.m1168h(this.f350f);
        ServiceConnectionC0644b serviceConnectionC0644b = null;
        if ((System.currentTimeMillis() - this.f364t > 3000 || (!((locationClientOption = this.f347c) == null || locationClientOption.location_change_notify) || this.f358n)) && m1168h == 1) {
            if (!this.f334B || System.currentTimeMillis() - this.f365u > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US || this.f358n) {
                Message obtain = Message.obtain((Handler) null, 22);
                if (this.f358n) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.f358n);
                    this.f358n = false;
                    obtain.setData(bundle);
                }
                try {
                    obtain.replyTo = this.f353i;
                    this.f351g.send(obtain);
                    this.f345a = System.currentTimeMillis();
                    this.f357m = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (m1168h < 1) {
            BDLocation bDLocation = new BDLocation();
            if (m1168h == -1) {
                i = 69;
            } else if (m1168h == -2) {
                i = 70;
            } else {
                if (m1168h == 0) {
                    i = 71;
                }
                m234a(bDLocation);
            }
            bDLocation.setLocType(i);
            m234a(bDLocation);
        }
        synchronized (this.f363s) {
            LocationClientOption locationClientOption2 = this.f347c;
            if (locationClientOption2 != null && locationClientOption2.scanSpan >= 1000 && !this.f360p) {
                if (this.f361q == null) {
                    this.f361q = new RunnableC0639b(this, serviceConnectionC0644b);
                }
                this.f352h.postDelayed(this.f361q, this.f347c.scanSpan);
                this.f360p = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m272g(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
        ArrayList<BDAbstractLocationListener> arrayList = this.f355k;
        if (arrayList == null || !arrayList.contains(bDAbstractLocationListener)) {
            return;
        }
        this.f355k.remove(bDAbstractLocationListener);
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m275h(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        ArrayList<BDLocationListener> arrayList = this.f354j;
        if (arrayList == null || !arrayList.contains(bDLocationListener)) {
            return;
        }
        this.f354j.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m278i(Message message) {
        try {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
            if (this.f368x != null) {
                LocationClientOption locationClientOption = this.f347c;
                if (locationClientOption != null && locationClientOption.isDisableCache() && bDLocation.getLocType() == 65) {
                    return;
                }
                this.f368x.onReceiveLocation(bDLocation);
            }
        } catch (Exception unused) {
        }
    }

    public static void setAgreePrivacy(boolean z) {
        f333L = z;
    }

    public static void setKey(String str) {
        f332A = str;
    }

    public void disableAssistantLocation() {
        C0661o.m476a().m491b();
    }

    public void disableLocInForeground(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", z);
        Message obtainMessage = this.f352h.obtainMessage(704);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public void enableAssistantLocation(WebView webView) {
        C0661o.m476a().m490a(this.f350f, webView, this);
    }

    public void enableLocInForeground(int i, Notification notification) {
        if (i <= 0 || notification == null) {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(TtmlNode.ATTR_ID, i);
        bundle.putParcelable(StepManeuver.NOTIFICATION, notification);
        Message obtainMessage = this.f352h.obtainMessage(IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public String getAccessKey() {
        try {
            String m296b = C0643a.m296b(this.f350f);
            this.f370z = m296b;
            if (TextUtils.isEmpty(m296b)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s", this.f370z);
        } catch (Exception unused) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.f356l;
    }

    public LocationClientOption getLocOption() {
        return this.f347c;
    }

    public String getVersion() {
        return "9.4.0.1";
    }

    public boolean isStarted() {
        return this.f349e;
    }

    public void onReceiveLightLocString(String str) {
        Message obtainMessage = this.f352h.obtainMessage(708);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.location.p006b.C0651e.b
    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.f342J || this.f341I) && bDLocation != null) {
            Message obtainMessage = this.f352h.obtainMessage(701);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.f352h.obtainMessage(1300);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.f352h.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f352h.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f352h.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f352h.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() {
        if (this.f351g != null && this.f349e) {
            try {
                this.f351g.send(Message.obtain((Handler) null, 406));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public int requestLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.f351g == null || this.f353i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.f354j;
        if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.f355k) == null || arrayList.size() < 1)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.f345a < 1000) {
            return 6;
        }
        this.f358n = true;
        this.f359o = true;
        Message obtainMessage = this.f352h.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.f352h.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.f351g == null || this.f353i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.f354j;
        if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.f355k) == null || arrayList.size() < 1)) {
            return 2;
        }
        this.f352h.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void restart() {
        stop();
        this.f335C = false;
        this.f352h.sendEmptyMessageDelayed(1, 1000L);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.m293a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        this.f348d = new LocationClientOption(locationClientOption);
        Message obtainMessage = this.f352h.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.f335C = false;
        if (C0733o.m1152b()) {
            return;
        }
        LBSAuthManager.getInstance(this.f350f.getApplicationContext()).setPrivacyMode(f333L);
        C0645a.m302a().m308a(this.f350f, this.f348d, (String) null);
        new C0640c(this, null).start();
    }

    public boolean startIndoorMode() {
        boolean m242a = m242a(110);
        if (m242a) {
            this.f334B = true;
        }
        return m242a;
    }

    public boolean startVdr(ArrayList<String> arrayList) {
        if (this.f351g == null || !this.f349e || arrayList == null) {
            return false;
        }
        if (arrayList != null) {
            try {
                if (arrayList.size() == 1) {
                    String str = arrayList.get(0);
                    Message obtain = Message.obtain((Handler) null, IMediaPlayer.MEDIA_INFO_METADATA_UPDATE);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("naviLinkList_gz", C0733o.m1149a(str.getBytes("UTF-8")));
                    obtain.setData(bundle);
                    this.f351g.send(obtain);
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public void stop() {
        this.f335C = true;
        this.f352h.obtainMessage(2).sendToTarget();
        this.f340H = null;
    }

    public boolean stopIndoorMode() {
        boolean m242a = m242a(111);
        if (m242a) {
            this.f334B = false;
        }
        return m242a;
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.f352h.obtainMessage(1400);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.f352h.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.f351g == null || this.f353i == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.f351g.send(obtain);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}