package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* loaded from: classes.dex */
public final class StorageUtils {
    private static final String INDIVIDUAL_DIR_NAME = "video-cache";

    static File getIndividualCacheDirectory(Context context) {
        return new File(getCacheDirectory(context), INDIVIDUAL_DIR_NAME);
    }

    private static File getCacheDirectory(Context context) {
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        return externalCacheDir == null ? new File("/data/data/" + context.getPackageName() + "/cache/") : externalCacheDir;
    }

    public static boolean deleteFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                return false;
            }
        }
        return true;
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        String[] list = file.list();
        if (list != null) {
            for (String str2 : list) {
                deleteFile(str + File.separator + str2);
            }
        }
        return file.delete();
    }
}
