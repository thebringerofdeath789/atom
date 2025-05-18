package com.ipotensic.baselib.utils;

import android.os.Environment;
import android.os.StatFs;

/* loaded from: classes2.dex */
public class StorageUtil {
    public static long getTotalStorage() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
    }

    public static long getAvailableStorage() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }
}