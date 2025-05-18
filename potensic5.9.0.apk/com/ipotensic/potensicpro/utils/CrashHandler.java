package com.ipotensic.potensicpro.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.widget.Constraints;
import com.ipotensic.baselib.DDLog;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static volatile CrashHandler instance;
    private Context context;
    private Map<String, String> infos = new HashMap();
    private SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US);

    private CrashHandler() {
    }

    public void init(Context context) {
        this.context = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static CrashHandler getInstance() {
        if (instance == null) {
            synchronized (CrashHandler.class) {
                if (instance == null) {
                    instance = new CrashHandler();
                }
            }
        }
        return instance;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        collectDeviceInfo(this.context);
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString() + "\n");
        }
        sb.append("\n" + th.toString());
        DDLog.m1687i("savelog1");
        saveMsg(sb.toString());
        DDLog.m1687i("savelog2");
    }

    private void saveMsg(final String str) {
        new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.utils.CrashHandler.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r6 = this;
                    r0 = 500(0x1f4, double:2.47E-321)
                    r2 = 0
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    r3.<init>()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    com.ipotensic.baselib.LocalFileManager r4 = com.ipotensic.baselib.LocalFileManager.getInstance()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.String r4 = r4.getLogDir()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    com.ipotensic.baselib.LocalFileManager r4 = com.ipotensic.baselib.LocalFileManager.getInstance()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.String r4 = r4.getCrashLogNamePeriod()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    com.ipotensic.potensicpro.utils.CrashHandler r4 = com.ipotensic.potensicpro.utils.CrashHandler.this     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.text.SimpleDateFormat r4 = com.ipotensic.potensicpro.utils.CrashHandler.access$000(r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.util.Date r5 = new java.util.Date     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    r5.<init>()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.String r4 = r4.format(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.String r4 = ".log"
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    r4.<init>(r3)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
                    java.lang.String r2 = r2     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L8c
                    byte[] r2 = r2.getBytes()     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L8c
                    r4.write(r2)     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L8c
                    r4.close()     // Catch: java.lang.Exception -> L8b
                    java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L8b
                L57:
                    com.ipotensic.baselib.ActivityHelper r0 = com.ipotensic.baselib.ActivityHelper.getInstance()     // Catch: java.lang.Exception -> L8b
                    r0.exitApp()     // Catch: java.lang.Exception -> L8b
                    goto L8b
                L5f:
                    r2 = move-exception
                    goto L68
                L61:
                    r3 = move-exception
                    r4 = r2
                    r2 = r3
                    goto L8d
                L65:
                    r3 = move-exception
                    r4 = r2
                    r2 = r3
                L68:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
                    r3.<init>()     // Catch: java.lang.Throwable -> L8c
                    java.lang.String r5 = "存储崩溃日志出错："
                    java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> L8c
                    java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L8c
                    java.lang.StringBuilder r2 = r3.append(r2)     // Catch: java.lang.Throwable -> L8c
                    java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8c
                    com.ipotensic.baselib.DDLog.m1684e(r2)     // Catch: java.lang.Throwable -> L8c
                    if (r4 == 0) goto L87
                    r4.close()     // Catch: java.lang.Exception -> L8b
                L87:
                    java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L8b
                    goto L57
                L8b:
                    return
                L8c:
                    r2 = move-exception
                L8d:
                    if (r4 == 0) goto L92
                    r4.close()     // Catch: java.lang.Exception -> L9c
                L92:
                    java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L9c
                    com.ipotensic.baselib.ActivityHelper r0 = com.ipotensic.baselib.ActivityHelper.getInstance()     // Catch: java.lang.Exception -> L9c
                    r0.exitApp()     // Catch: java.lang.Exception -> L9c
                L9c:
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.potensicpro.utils.CrashHandler.RunnableC28371.run():void");
            }
        }).start();
    }

    public void collectDeviceInfo(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                String str2 = packageInfo.versionCode + "";
                this.infos.put("versionName", str);
                this.infos.put("versionCode", str2);
            }
        } catch (PackageManager.NameNotFoundException e) {
            DDLog.m1684e("an error occured when collect package info" + e.getMessage());
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                this.infos.put(field.getName(), field.get(null).toString());
                Log.d(Constraints.TAG, field.getName() + " : " + field.get(null));
            } catch (Exception e2) {
                Log.e(Constraints.TAG, "an error occured when collect crash info", e2);
            }
        }
    }
}