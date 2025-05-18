package com.ipotensic.baselib.share2;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.permission.PermissionUtil;
import java.io.File;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes2.dex */
public class FileUtil {
    private static final String TAG = "Share";

    public static Uri getFileUri(Context context, String str, File file) {
        Uri uri = null;
        if (context == null) {
            DDLog.m1685e(TAG, "getFileUri current activity is null.");
            return null;
        }
        if (file == null || !file.exists()) {
            DDLog.m1685e(TAG, "getFileUri file is null or not exists.");
            return null;
        }
        if (!PermissionUtil.hasStoragePermission(context)) {
            DDLog.m1685e(TAG, "getFileUri miss WRITE_EXTERNAL_STORAGE permission.");
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.fromFile(file);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = ShareContentType.FILE;
            }
            str.hashCode();
            switch (str) {
                case "audio/*":
                    uri = getAudioContentUri(context, file);
                    break;
                case "*/*":
                    uri = getFileContentUri(context, file);
                    break;
                case "video/*":
                    uri = getVideoContentUri(context, file);
                    break;
                case "image/*":
                    uri = getImageContentUri(context, file);
                    break;
            }
        }
        return uri == null ? forceGetFileUri(file) : uri;
    }

    public static String getFileRealPath(Context context, Uri uri) {
        Uri contentUri;
        if (context == null) {
            DDLog.m1685e(TAG, "getFileRealPath current activity is null.");
            return null;
        }
        if (uri == null) {
            DDLog.m1685e(TAG, "getFileRealPath uri is null.");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (isExternalStorageDocument(uri)) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(split[0])) {
                        return Environment.getExternalStorageDirectory() + InternalZipConstants.ZIP_FILE_SEPARATOR + split[1];
                    }
                } else {
                    if (isDownloadsDocument(uri)) {
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (isMediaDocument(uri)) {
                        String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = split2[0];
                        if ("image".equals(str)) {
                            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(str)) {
                            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if ("audio".equals(str)) {
                            contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            contentUri = MediaStore.Files.getContentUri("external");
                        }
                        return getDataColumn(context, contentUri, "_id=?", new String[]{split2[1]});
                    }
                }
            } else if (StringLookupFactory.KEY_FILE.equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query == null) {
                return null;
            }
            String string = query.moveToFirst() ? query.getString(query.getColumnIndex("_data")) : null;
            query.close();
            return string;
        }
        if (StringLookupFactory.KEY_FILE.equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static Uri forceGetFileUri(File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                StrictMode.class.getDeclaredMethod("disableDeathOnFileUriExposure", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                DDLog.m1685e(TAG, Log.getStackTraceString(e));
            }
        }
        return Uri.parse("file://" + file.getAbsolutePath());
    }

    private static Uri getFileContentUri(Context context, File file) {
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{file.getAbsolutePath()}, null);
        if (query != null) {
            r2 = query.moveToFirst() ? MediaStore.Files.getContentUri("external", query.getInt(query.getColumnIndex("_id"))) : null;
            query.close();
        }
        return r2 == null ? FileProvider.getUriForFile(context, "com.ipotensic.potensicpro.fileprovider", file) : r2;
    }

    private static Uri getImageContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        if (query != null) {
            r1 = query.moveToFirst() ? Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + query.getInt(query.getColumnIndex("_id"))) : null;
            query.close();
        }
        if (r1 != null) {
            return r1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private static Uri getVideoContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        if (query != null) {
            r1 = query.moveToFirst() ? Uri.withAppendedPath(Uri.parse("content://media/external/video/media"), "" + query.getInt(query.getColumnIndex("_id"))) : null;
            query.close();
        }
        if (r1 != null) {
            return r1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private static Uri getAudioContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        if (query != null) {
            r1 = query.moveToFirst() ? Uri.withAppendedPath(Uri.parse("content://media/external/audio/media"), "" + query.getInt(query.getColumnIndex("_id"))) : null;
            query.close();
        }
        if (r1 != null) {
            return r1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("_data"));
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getFileNameNoEx(String str) {
        int lastIndexOf;
        return (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length()) ? str : str.substring(0, lastIndexOf);
    }
}