package com.baidu.location.indoor.mapversion;

import android.util.Log;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class IndoorJni {
    public static boolean a = false;

    static {
        PrintStream printStream;
        String str;
        try {
            System.loadLibrary("indoor");
            a = true;
            if (1 != 0) {
                printStream = System.err;
                str = "load vdr indoor lib success.";
            } else {
                printStream = System.err;
                str = "load vdr indoor lib fail.";
            }
            printStream.println(str);
            Log.i("indoorJNI", "indoor lib loadJniSuccess:" + a);
        } catch (Throwable th) {
            Log.i("indoorJNI", "indoor lib annot load indoor lib:" + th.toString());
            System.err.println("Cannot load indoor lib");
            th.printStackTrace();
            a = false;
        }
    }

    public static native String getBuildingId(long j);

    public static native String getFloor(long j, int i);

    public static native int getInout(long j, int i);

    public static native void initPf();

    public static native float pgo();

    public static native String phs(int i, float f, float f2, float f3, long j);

    public static native void resetPf();

    public static native void setBarometers(float f, long j);

    public static native void setBleLoc4Scenario(double d, double d2, String str, int i, long j, int i2);

    public static native void setGps(double d, double d2, float f, float f2, float f3, double d3, int i, long j);

    public static native double[] setPfBle(double d, double d2, double d3, double d4, String str, String str2, long j, int i, String str3);

    public static native double[] setPfDr(double d, double d2, String str, long j);

    public static native void setPfGeoMap(double[][] dArr, String str, int i, int i2);

    public static native void setPfRdnt(String str, short[][] sArr, double d, double d2, int i, int i2, double d3, double d4, String str2);

    public static native double[] setPfWf(double d, double d2, double d3, long j);

    public static native void startPdr();

    public static native void stopPdr();
}
