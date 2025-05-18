package com.ipotensic.baselib.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.ipotensic.baselib.DDLog;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
public class AppUtils {
    public static boolean isAppInBackground(Context context) {
        boolean z = true;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100) {
                for (String str : runningAppProcessInfo.pkgList) {
                    if (str.equals(context.getPackageName())) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public static long getInstallTime(Context context, String str) {
        try {
            return new File(context.getPackageManager().getApplicationInfo(str, 0).sourceDir).lastModified();
        } catch (Exception e) {
            DDLog.e("\u83b7\u53d6\u5b89\u88c5\u65f6\u95f4\u62a5\u9519:" + e);
            return 0L;
        }
    }

    public static String getProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid() && runningAppProcessInfo.processName != null) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static String getPackageName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}