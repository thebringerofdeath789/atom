package com.ipotensic.potensicpro.utils;

import android.content.Context;
import android.graphics.Typeface;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class FontsUtils {
    public static void setDefaultFont(Context context, String str, Typeface typeface) {
        replaceFont(str, typeface);
    }

    private static void replaceFont(String str, Typeface typeface) {
        try {
            Field declaredField = Typeface.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, typeface);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
}