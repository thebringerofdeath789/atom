package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.crashreport.biz.C3335b;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.info.C3338b;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.proguard.C3398u;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d */
    private static BuglyBroadcastReceiver f3027d;

    /* renamed from: b */
    private Context f3029b;

    /* renamed from: c */
    private String f3030c;

    /* renamed from: e */
    private boolean f3031e = true;

    /* renamed from: a */
    private IntentFilter f3028a = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f3027d == null) {
                f3027d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f3027d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f3028a.hasAction(str)) {
            this.f3028a.addAction(str);
        }
        C3401x.m2251c("add action %s", str);
    }

    public synchronized void register(Context context) {
        this.f3029b = context;
        C3403z.m2293a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C3401x.m2245a(BuglyBroadcastReceiver.f3027d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.f3029b.registerReceiver(BuglyBroadcastReceiver.f3027d, BuglyBroadcastReceiver.this.f3028a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            C3401x.m2245a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f3029b = context;
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            m1940a(context, intent);
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private synchronized boolean m1940a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f3031e) {
                    this.f3031e = false;
                    return true;
                }
                String m1903b = C3338b.m1903b(this.f3029b);
                C3401x.m2251c("is Connect BC " + m1903b, new Object[0]);
                C3401x.m2246a("network %s changed to %s", this.f3030c, m1903b);
                if (m1903b == null) {
                    this.f3030c = null;
                    return true;
                }
                String str = this.f3030c;
                this.f3030c = m1903b;
                long currentTimeMillis = System.currentTimeMillis();
                C3340a m1927a = C3340a.m1927a();
                C3398u m2219a = C3398u.m2219a();
                C3337a m1854a = C3337a.m1854a(context);
                if (m1927a != null && m2219a != null && m1854a != null) {
                    if (!m1903b.equals(str)) {
                        if (currentTimeMillis - m2219a.m2226a(C3351c.f3133a) > 30000) {
                            C3401x.m2246a("try to upload crash on network changed.", new Object[0]);
                            C3351c m1990a = C3351c.m1990a();
                            if (m1990a != null) {
                                m1990a.m1995a(0L);
                            }
                        }
                        if (currentTimeMillis - m2219a.m2226a(1001) > 30000) {
                            C3401x.m2246a("try to upload userinfo on network changed.", new Object[0]);
                            C3335b.f2907a.m1822b();
                        }
                    }
                    return true;
                }
                C3401x.m2252d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}