package com.hjq.permissions;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/* loaded from: classes2.dex */
final class PhoneRomUtils {
    private static final String ROM_NAME_MIUI = "ro.miui.ui.version.name";
    private static final String VERSION_PROPERTY_360 = "ro.build.uiversion";
    private static final String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    private static final String VERSION_PROPERTY_LEECO = "ro.letv.release.version";
    private static final String VERSION_PROPERTY_NUBIA = "ro.build.rom.id";
    private static final String VERSION_PROPERTY_ONEPLUS = "ro.rom.version";
    private static final String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    private static final String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    private static final String VERSION_PROPERTY_ZTE = "ro.build.MiFavor_version";
    private static final String[] ROM_HUAWEI = {"huawei"};
    private static final String[] ROM_VIVO = {"vivo"};
    private static final String[] ROM_XIAOMI = {"xiaomi"};
    private static final String[] ROM_OPPO = {"oppo"};
    private static final String[] ROM_LEECO = {"leeco", "letv"};
    private static final String[] ROM_360 = {"360", "qiku"};
    private static final String[] ROM_ZTE = {"zte"};
    private static final String[] ROM_ONEPLUS = {"oneplus"};
    private static final String[] ROM_NUBIA = {"nubia"};
    private static final String[] ROM_SAMSUNG = {"samsung"};
    private static final String[] ROM_HONOR = {"honor"};
    private static final String[] VERSION_PROPERTY_OPPO = {"ro.build.version.opporom", "ro.build.version.oplusrom.display"};
    private static final String[] VERSION_PROPERTY_MAGIC = {"msc.config.magic.version", "ro.build.version.magic"};

    private PhoneRomUtils() {
    }

    static boolean isEmui() {
        return !TextUtils.isEmpty(getPropertyName(VERSION_PROPERTY_HUAWEI));
    }

    static boolean isMiui() {
        return !TextUtils.isEmpty(getPropertyName(ROM_NAME_MIUI));
    }

    static boolean isColorOs() {
        for (String str : VERSION_PROPERTY_OPPO) {
            if (!TextUtils.isEmpty(getPropertyName(str))) {
                return true;
            }
        }
        return false;
    }

    static boolean isOriginOs() {
        return !TextUtils.isEmpty(getPropertyName(VERSION_PROPERTY_VIVO));
    }

    static boolean isOneUi() {
        return isRightRom(getBrand(), getManufacturer(), ROM_SAMSUNG);
    }

    static boolean isHarmonyOs() {
        if (!AndroidVersion.isAndroid10()) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(String.valueOf(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    static boolean isMagicOs() {
        return isRightRom(getBrand(), getManufacturer(), ROM_HONOR);
    }

    static boolean isMiuiOptimization() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String valueOf = String.valueOf(cls.getMethod("get", String.class, String.class).invoke(cls, "ro.miui.cts", ""));
            Method method = cls.getMethod("getBoolean", String.class, Boolean.TYPE);
            Object[] objArr = new Object[2];
            objArr[0] = "persist.sys.miui_optimization";
            objArr[1] = Boolean.valueOf("1".equals(valueOf) ? false : true);
            return Boolean.parseBoolean(String.valueOf(method.invoke(cls, objArr)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return true;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return true;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return true;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return true;
        }
    }

    static String getRomVersionName() {
        String brand = getBrand();
        String manufacturer = getManufacturer();
        if (isRightRom(brand, manufacturer, ROM_HUAWEI)) {
            String propertyName = getPropertyName(VERSION_PROPERTY_HUAWEI);
            String[] split = propertyName.split("_");
            if (split.length > 1) {
                return split[1];
            }
            return propertyName.contains("EmotionUI") ? propertyName.replaceFirst("EmotionUI\\s*", "") : propertyName;
        }
        if (isRightRom(brand, manufacturer, ROM_VIVO)) {
            return getPropertyName(VERSION_PROPERTY_VIVO);
        }
        if (isRightRom(brand, manufacturer, ROM_XIAOMI)) {
            return getPropertyName(VERSION_PROPERTY_XIAOMI);
        }
        int i = 0;
        if (isRightRom(brand, manufacturer, ROM_OPPO)) {
            String[] strArr = VERSION_PROPERTY_OPPO;
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                String propertyName2 = getPropertyName(str);
                if (!TextUtils.isEmpty(str)) {
                    return propertyName2;
                }
                i++;
            }
            return "";
        }
        if (isRightRom(brand, manufacturer, ROM_LEECO)) {
            return getPropertyName(VERSION_PROPERTY_LEECO);
        }
        if (isRightRom(brand, manufacturer, ROM_360)) {
            return getPropertyName(VERSION_PROPERTY_360);
        }
        if (isRightRom(brand, manufacturer, ROM_ZTE)) {
            return getPropertyName(VERSION_PROPERTY_ZTE);
        }
        if (isRightRom(brand, manufacturer, ROM_ONEPLUS)) {
            return getPropertyName(VERSION_PROPERTY_ONEPLUS);
        }
        if (isRightRom(brand, manufacturer, ROM_NUBIA)) {
            return getPropertyName(VERSION_PROPERTY_NUBIA);
        }
        if (isRightRom(brand, manufacturer, ROM_HONOR)) {
            String[] strArr2 = VERSION_PROPERTY_MAGIC;
            int length2 = strArr2.length;
            while (i < length2) {
                String str2 = strArr2[i];
                String propertyName3 = getPropertyName(str2);
                if (!TextUtils.isEmpty(str2)) {
                    return propertyName3;
                }
                i++;
            }
            return "";
        }
        return getPropertyName("");
    }

    private static boolean isRightRom(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    private static String getBrand() {
        return Build.BRAND.toLowerCase();
    }

    private static String getManufacturer() {
        return Build.MANUFACTURER.toLowerCase();
    }

    private static String getPropertyName(String str) {
        return !TextUtils.isEmpty(str) ? getSystemProperty(str) : "";
    }

    private static String getSystemProperty(String str) {
        String systemPropertyByShell = getSystemPropertyByShell(str);
        if (!TextUtils.isEmpty(systemPropertyByShell)) {
            return systemPropertyByShell;
        }
        String systemPropertyByStream = getSystemPropertyByStream(str);
        return (TextUtils.isEmpty(systemPropertyByStream) && Build.VERSION.SDK_INT < 28) ? getSystemPropertyByReflect(str) : systemPropertyByStream;
    }

    private static String getSystemPropertyByShell(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                    try {
                        readLine = bufferedReader.readLine();
                    } catch (IOException e) {
                        e = e;
                        bufferedReader2 = bufferedReader;
                        e.printStackTrace();
                        if (bufferedReader2 == null) {
                            return "";
                        }
                        bufferedReader2.close();
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
            if (readLine == null) {
                bufferedReader.close();
                return "";
            }
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return readLine;
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private static String getSystemPropertyByStream(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return "";
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
