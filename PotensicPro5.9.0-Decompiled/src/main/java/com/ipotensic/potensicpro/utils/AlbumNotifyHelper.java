package com.ipotensic.potensicpro.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.google.android.exoplayer2.util.MimeTypes;
import com.logan.flight.FlightConfig;
import java.io.File;
import org.apache.poi.openxml4j.opc.ContentTypes;

/* loaded from: classes2.dex */
public class AlbumNotifyHelper {
    public static final String TAG = "AlbumNotifyHelper";

    public static void notifyScanDcim(Context context, String str) {
        scanFile(context, str);
    }

    public static void insertImageToMediaStore(Context context, String str, long j) {
        insertImageToMediaStore(context, str, j, 0, 0);
    }

    public static void scanFile(Context context, String str) {
        if (checkFile(str)) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            context.sendBroadcast(intent);
        }
    }

    private static ContentValues initCommonContentValues(String str, long j) {
        ContentValues contentValues = new ContentValues();
        File file = new File(str);
        long timeWrap = getTimeWrap(j);
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("date_modified", Long.valueOf(timeWrap));
        contentValues.put("date_added", Long.valueOf(timeWrap));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    public static void insertImageToMediaStore(Context context, String str, long j, int i, int i2) {
        if (checkFile(str)) {
            long timeWrap = getTimeWrap(j);
            ContentValues initCommonContentValues = initCommonContentValues(str, timeWrap);
            initCommonContentValues.put("datetaken", Long.valueOf(timeWrap));
            initCommonContentValues.put("orientation", (Integer) 0);
            initCommonContentValues.put("orientation", (Integer) 0);
            if (Build.VERSION.SDK_INT > 16) {
                if (i > 0) {
                    initCommonContentValues.put("width", (Integer) 0);
                }
                if (i2 > 0) {
                    initCommonContentValues.put("height", (Integer) 0);
                }
            }
            initCommonContentValues.put("mime_type", getPhotoMimeType(str));
            context.getApplicationContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, initCommonContentValues);
        }
    }

    public static void insertVideoToMediaStore(Context context, String str, long j, int i, int i2, long j2) {
        if (checkFile(str)) {
            long timeWrap = getTimeWrap(j);
            ContentValues initCommonContentValues = initCommonContentValues(str, timeWrap);
            initCommonContentValues.put("datetaken", Long.valueOf(timeWrap));
            if (j2 > 0) {
                initCommonContentValues.put("duration", Long.valueOf(j2));
            }
            if (Build.VERSION.SDK_INT > 16) {
                if (i > 0) {
                    initCommonContentValues.put("width", Integer.valueOf(i));
                }
                if (i2 > 0) {
                    initCommonContentValues.put("height", Integer.valueOf(i2));
                }
            }
            initCommonContentValues.put("mime_type", getVideoMimeType(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, initCommonContentValues);
        }
    }

    private static boolean isSystemDcim(String str) {
        return str.toLowerCase().contains("dcim") || str.toLowerCase().contains(FlightConfig.PRODUCT_CLASS_CAMERA);
    }

    private static String getPhotoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith(ContentTypes.EXTENSION_JPG_1) && !lowerCase.endsWith(ContentTypes.EXTENSION_JPG_2)) {
            if (lowerCase.endsWith(ContentTypes.EXTENSION_PNG)) {
                return ContentTypes.IMAGE_PNG;
            }
            if (lowerCase.endsWith(ContentTypes.EXTENSION_GIF)) {
                return ContentTypes.IMAGE_GIF;
            }
        }
        return "image/jpeg";
    }

    private static String getVideoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? MimeTypes.VIDEO_MP4 : "video/3gp";
    }

    private static long getTimeWrap(long j) {
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    private static boolean checkFile(String str) {
        return new File(str).exists();
    }
}
