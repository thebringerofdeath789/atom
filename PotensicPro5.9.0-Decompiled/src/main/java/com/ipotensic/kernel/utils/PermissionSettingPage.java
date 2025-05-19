package com.ipotensic.kernel.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/* loaded from: classes2.dex */
public class PermissionSettingPage {
    private static final String MARK = Build.MANUFACTURER.toLowerCase();
    public static final int REQUEST_CODE_TO_PERMISSION_SETTING = 1001;

    public static void start(Activity activity, boolean z) {
        Intent meizu;
        String str = MARK;
        if (str.contains("huawei")) {
            meizu = huawei(activity);
        } else if (str.contains("xiaomi")) {
            meizu = xiaomi(activity);
        } else if (str.contains("oppo")) {
            meizu = oppo(activity);
        } else if (str.contains("vivo")) {
            meizu = vivo(activity);
        } else {
            meizu = str.contains("meizu") ? meizu(activity) : null;
        }
        if (meizu == null || !hasIntent(activity, meizu)) {
            meizu = google(activity);
        }
        if (z) {
            meizu.addFlags(268435456);
        }
        try {
            activity.startActivityForResult(meizu, 1001);
        } catch (Exception unused) {
            activity.startActivityForResult(google(activity), 1001);
        }
    }

    private static Intent google(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    private static Intent huawei(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.SingleAppActivity"));
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.KernelActivity"));
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
        return intent;
    }

    private static Intent xiaomi(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setPackage("com.miui.securitycenter");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        return intent;
    }

    private static Intent oppo(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        return intent;
    }

    private static Intent vivo(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra("packagename", context.getPackageName());
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
    }

    private static Intent meizu(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    private static boolean hasIntent(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
