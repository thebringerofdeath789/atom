package com.ipotensic.baselib.notchtools.helper;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class DeviceBrandTools {
    private static DeviceBrandTools sDeviceBrandTools;

    public static DeviceBrandTools getInstance() {
        if (sDeviceBrandTools == null) {
            synchronized (DeviceBrandTools.class) {
                if (sDeviceBrandTools == null) {
                    sDeviceBrandTools = new DeviceBrandTools();
                }
            }
        }
        return sDeviceBrandTools;
    }

    public final boolean isHuaWei() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.contains("HUAWEI");
    }

    public final boolean isMiui() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
    }

    public final boolean isOppo() {
        return !TextUtils.isEmpty(getSystemProperty("ro.product.brand"));
    }

    public final boolean isVivo() {
        return !TextUtils.isEmpty(getSystemProperty("ro.vivo.os.name"));
    }

    private String getSystemProperty(String str) {
        return SystemProperties.getInstance().get(str);
    }
}
