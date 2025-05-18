package com.baidu.location.p012h;

import java.util.ArrayList;

/* renamed from: com.baidu.location.h.c */
/* loaded from: classes.dex */
public class C0721c {
    /* renamed from: a */
    public static int m1108a(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).get(2).floatValue() > 0.0f) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static int m1109b(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).get(2).floatValue() >= 15.0f) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static int m1110c(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).get(2).floatValue() >= 20.0f) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: d */
    public static int m1111d(ArrayList<ArrayList<Float>> arrayList) {
        float f = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).get(2).floatValue() > 0.0f) {
                f += arrayList.get(i).get(2).floatValue();
            }
        }
        return Math.round(f);
    }

    /* renamed from: e */
    public static int m1112e(ArrayList<ArrayList<Float>> arrayList) {
        return Math.round(m1111d(arrayList) / m1108a(arrayList));
    }

    /* renamed from: f */
    public static int m1113f(ArrayList<ArrayList<Float>> arrayList) {
        float f = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).get(2).floatValue() > 0.0f) {
                f += arrayList.get(i).get(2).floatValue() * arrayList.get(i).get(1).floatValue();
            }
        }
        return Math.round(f);
    }

    /* renamed from: g */
    public static int m1114g(ArrayList<ArrayList<Float>> arrayList) {
        return Math.round(m1113f(arrayList) / m1108a(arrayList));
    }

    /* renamed from: h */
    public static int m1115h(ArrayList<ArrayList<Float>> arrayList) {
        int i;
        int[] iArr = new int[37];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                if (i3 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i3).get(0).floatValue() < 360.0d) {
                    int ceil = (int) Math.ceil(arrayList.get(i3).get(0).floatValue() / 10.0f);
                    iArr[ceil] = iArr[ceil] + 1;
                }
                i3++;
            } catch (Exception unused) {
                return 0;
            }
        }
        for (i = 1; i <= 36; i++) {
            if (iArr[i] > 0) {
                i2++;
            }
        }
        return Math.round((i2 / 36.0f) * 1000.0f);
    }
}