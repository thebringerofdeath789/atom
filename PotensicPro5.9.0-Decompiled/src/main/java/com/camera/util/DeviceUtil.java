package com.camera.util;

import android.os.Build;

/* loaded from: classes.dex */
public class DeviceUtil {
    private static String[] huaweiRongyao = {"hwH60", "hwPE", "hwH30", "hwHol", "hwG750", "hw7D", "hwChe2"};

    public static String getDeviceInfo() {
        return "手机型号：" + Build.DEVICE + "\n系统版本：" + Build.VERSION.RELEASE + "\nSDK版本：" + Build.VERSION.SDK_INT;
    }

    public static String getDeviceModel() {
        return Build.DEVICE;
    }

    public static boolean isHuaWeiRongyao() {
        int length = huaweiRongyao.length;
        for (int i = 0; i < length; i++) {
            if (huaweiRongyao[i].equals(getDeviceModel())) {
                return true;
            }
        }
        return false;
    }
}
