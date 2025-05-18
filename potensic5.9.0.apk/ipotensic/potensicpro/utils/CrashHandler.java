package com.ipotensic.potensicpro.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.widget.Constraints;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        DDLog.i("savelog1");
        saveMsg(sb.toString());
        DDLog.i("savelog2");
    }

    private void saveMsg(final String str) {
        new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.utils.CrashHandler.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                FileOutputStream fileOutputStream;
                Throwable th;
                Exception e;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(LocalFileManager.getInstance().getLogDir() + File.separator + LocalFileManager.getInstance().getCrashLogNamePeriod() + CrashHandler.this.simpleDateFormat1.format(new Date()) + ".log");
                    } catch (Exception e2) {
                        fileOutputStream = null;
                        e = e2;
                    } catch (Throwable th2) {
                        fileOutputStream = null;
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        Thread.sleep(500L);
                        ActivityHelper.getInstance().exitApp();
                        throw th;
                    }
                    try {
                        try {
                            fileOutputStream.write(str.getBytes());
                            fileOutputStream.close();
                            Thread.sleep(500L);
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                            Thread.sleep(500L);
                            ActivityHelper.getInstance().exitApp();
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        DDLog.e("\u5b58\u50a8\u5d29\u6e83\u65e5\u5fd7\u51fa\u9519\uff1a" + e.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        Thread.sleep(500L);
                        ActivityHelper.getInstance().exitApp();
                    }
                    ActivityHelper.getInstance().exitApp();
                } catch (Exception unused2) {
                }
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
            DDLog.e("an error occured when collect package info" + e.getMessage());
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