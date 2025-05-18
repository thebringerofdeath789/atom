package com.ipotensic.kernel.utils;

/* loaded from: classes2.dex */
public class WindUtil {
    public static int windGrade(double d) {
        if (d >= 5.5d && d <= 7.9d) {
            return 4;
        }
        if (d >= 8.0d && d <= 10.7d) {
            return 5;
        }
        if (d >= 10.8d && d <= 13.8d) {
            return 6;
        }
        if (d >= 13.9d && d <= 17.1d) {
            return 7;
        }
        if (d >= 17.2d && d <= 20.7d) {
            return 8;
        }
        if (d >= 20.8d && d <= 24.4d) {
            return 9;
        }
        if (d >= 24.5d && d <= 28.4d) {
            return 10;
        }
        if (d >= 28.5d && d <= 32.6d) {
            return 11;
        }
        if (d >= 32.7d && d <= 36.9d) {
            return 12;
        }
        if (d >= 37.0d && d <= 41.4d) {
            return 13;
        }
        if (d >= 41.5d && d <= 46.1d) {
            return 14;
        }
        if (d >= 46.2d && d <= 50.9d) {
            return 15;
        }
        if (d < 51.0d || d > 56.0d) {
            return d >= 56.1d ? 17 : 0;
        }
        return 16;
    }
}