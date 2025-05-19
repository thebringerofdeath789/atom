package com.ipotensic.kernel.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public class MediaStoreUtil {
    public static void imageInsertMediaStore(Context context, File file) {
    }

    public static void videoInsertMediaStore(Context context, File file) {
    }

    private static String getMimeType(File file) {
        return URLConnection.getFileNameMap().getContentTypeFor(file.getName());
    }

    public static void refreshAlbum(Activity activity, File file) {
        if (activity == null || file == null) {
            return;
        }
        try {
            if (file.exists()) {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file));
                activity.sendBroadcast(intent);
            }
        } catch (Exception unused) {
        }
    }
}
