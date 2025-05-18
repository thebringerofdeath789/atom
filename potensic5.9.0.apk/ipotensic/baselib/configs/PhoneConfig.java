package com.ipotensic.baselib.configs;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.enums.NetworkType;
import com.ipotensic.baselib.enums.PackageType;
import com.ipotensic.baselib.utils.CustomHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class PhoneConfig {
    public static final int BRANDE_CODE = 2;
    public static final String CONNECT_IP = "192.168.29";
    public static final String FLIGHT_IP = "192.168.29.1";
    public static Context applicationContext;
    public static Locale curLocal;
    public static String fileProviderAuthority;
    public static Rect smallViewRect;
    public static Typeface typeface;
    public static Token usrToken;
    public static PackageType PACK_TYPE = PackageType.TYPE_RELEASE;
    public static Typeface customTypeface = null;
    public static Typeface sourceHanSansCN = null;
    public static boolean isInChinaHomeland = true;
    public static boolean isDownloadFromChinaMarket = false;
    public static NetworkType networkType = NetworkType.TYPE_NONE;
    public static BaseActivity runningActivity = null;
    public static boolean isKernelActivityRunning = false;
    public static boolean isKernelActivityPause = false;
    public static boolean isMainActivityRunning = false;
    public static boolean isMainActivityPause = false;
    public static boolean isAppDeleteMultiFiles = false;
    public static boolean isFt = false;
    public static Size previewSize = null;
    public static Size showSize = null;
    public static String deviceBrand = Build.BRAND;
    public static String model = Build.MODEL;
    public static boolean isCellularWhenConnectFlightWifi = false;
    public static boolean isUdp = false;
    public static boolean appUpgradeVersion = false;
    public static ExecutorService threadPool = Executors.newCachedThreadPool();
    public static ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor((Runtime.getRuntime().availableProcessors() * 2) + 1, new ThreadFactory() { // from class: com.ipotensic.baselib.configs.PhoneConfig.1
        final AtomicInteger count = new AtomicInteger(1);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MyScheduleThread_" + this.count.getAndIncrement());
        }
    }, new ThreadPoolExecutor.AbortPolicy());
    public static Handler mainHandler = new Handler(Looper.getMainLooper());
    public static final CustomHandlerThread PARSE_HANDLER_THREAD = new CustomHandlerThread("parse_handler_thread", new Handler.Callback() { // from class: com.ipotensic.baselib.configs.PhoneConfig.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return false;
        }

        AnonymousClass2() {
        }
    });

    /* renamed from: com.ipotensic.baselib.configs.PhoneConfig$1 */
    class AnonymousClass1 implements ThreadFactory {
        final AtomicInteger count = new AtomicInteger(1);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MyScheduleThread_" + this.count.getAndIncrement());
        }
    }

    /* renamed from: com.ipotensic.baselib.configs.PhoneConfig$2 */
    class AnonymousClass2 implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return false;
        }

        AnonymousClass2() {
        }
    }

    public static boolean isConnectInternet() {
        return networkType == NetworkType.TYPE_WIFI || networkType == NetworkType.TYPE_234G || networkType == NetworkType.TYPE_OTHERS;
    }

    public static boolean isConnectFlightWifi() {
        return networkType == NetworkType.TYPE_WIFI_FLIGHT;
    }

    public static boolean isAoaAbnormalPhone() {
        String str = Build.MODEL;
        if (str == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("NX667J");
        arrayList.add("NX729J");
        arrayList.add("NX725J");
        arrayList.add("NX769J");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }
}