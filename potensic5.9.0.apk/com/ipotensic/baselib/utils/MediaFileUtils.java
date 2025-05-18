package com.ipotensic.baselib.utils;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.IntentSenderRequest;
import com.ipotensic.baselib.base.BaseActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class MediaFileUtils {

    public interface OnDeleteResultListener {
        void onResult(boolean z);
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

    public static void deleteImageForAndroid11(BaseActivity baseActivity, ArrayList<String> arrayList, OnDeleteResultListener onDeleteResultListener) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            if (file.exists()) {
                arrayList2.add(getImageContentUri(baseActivity, file));
            }
        }
        if (arrayList2.size() == 0) {
            onDeleteResultListener.onResult(false);
            return;
        }
        PendingIntent createDeleteRequest = MediaStore.createDeleteRequest(baseActivity.getContentResolver(), arrayList2);
        if (createDeleteRequest != null) {
            baseActivity.registerDeleteForResult(new IntentSenderRequest.Builder(createDeleteRequest.getIntentSender()).build(), onDeleteResultListener);
        }
    }

    public static void deleteVideoForAndroid11(BaseActivity baseActivity, ArrayList<String> arrayList, OnDeleteResultListener onDeleteResultListener) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            if (file.exists()) {
                arrayList2.add(getVideoContentUri(baseActivity, file));
            }
        }
        if (arrayList2.size() == 0) {
            onDeleteResultListener.onResult(false);
            return;
        }
        PendingIntent createDeleteRequest = MediaStore.createDeleteRequest(baseActivity.getContentResolver(), arrayList2);
        if (createDeleteRequest != null) {
            baseActivity.registerDeleteForResult(new IntentSenderRequest.Builder(createDeleteRequest.getIntentSender()).build(), onDeleteResultListener);
        } else {
            onDeleteResultListener.onResult(false);
        }
    }
}