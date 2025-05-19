package com.ipotensic.baselib.utils.compress;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class FileUtil {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;
    static final String FILES_PATH = "CompressHelper";

    private FileUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static File getFileByPath(String str) {
        if (StringUtil.isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean isFileExists(String str) {
        return isFileExists(getFileByPath(str));
    }

    public static boolean isFileExists(File file) {
        return file != null && file.exists();
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || StringUtil.isSpace(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isDir(File file) {
        return isFileExists(file) && file.isDirectory();
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFile(File file) {
        return isFileExists(file) && file.isFile();
    }

    public static File renameFile(File file, String str) {
        File file2 = new File(file.getParent(), str);
        if (!file2.equals(file)) {
            if (file2.exists() && file2.delete()) {
                Log.d("FileUtil", "Delete old " + str + " file");
            }
            if (file.renameTo(file2)) {
                Log.d("FileUtil", "Rename file to " + str);
            }
        }
        return file2;
    }

    public static File getTempFile(Context context, Uri uri) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        String fileName = getFileName(context, uri);
        String[] splitFileName = splitFileName(fileName);
        File renameFile = renameFile(File.createTempFile(splitFileName[0], splitFileName[1]), fileName);
        renameFile.deleteOnExit();
        try {
            fileOutputStream = new FileOutputStream(renameFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        if (openInputStream != null) {
            copy(openInputStream, fileOutputStream);
            openInputStream.close();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        return renameFile;
    }

    static String[] splitFileName(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf);
            str = substring;
        } else {
            str2 = "";
        }
        return new String[]{str, str2};
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r8 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String getFileName(android.content.Context r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L42
            android.content.ContentResolver r2 = r8.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)
            if (r8 == 0) goto L3d
            boolean r0 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r0 == 0) goto L3d
            java.lang.String r0 = "_display_name"
            int r0 = r8.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.lang.String r0 = r8.getString(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r1 = r0
            goto L3d
        L2e:
            r9 = move-exception
            goto L37
        L30:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L42
            goto L3f
        L37:
            if (r8 == 0) goto L3c
            r8.close()
        L3c:
            throw r9
        L3d:
            if (r8 == 0) goto L42
        L3f:
            r8.close()
        L42:
            if (r1 != 0) goto L57
            java.lang.String r1 = r9.getPath()
            java.lang.String r8 = java.io.File.separator
            int r8 = r1.lastIndexOf(r8)
            r9 = -1
            if (r8 == r9) goto L57
            int r8 = r8 + 1
            java.lang.String r1 = r1.substring(r8)
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.baselib.utils.compress.FileUtil.getFileName(android.content.Context, android.net.Uri):java.lang.String");
    }

    static String getRealPathFromURI(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }

    static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copyLarge(inputStream, outputStream, new byte[4096]);
    }

    static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static String getReadableFileSize(long j) {
        if (j <= 0) {
            return SessionDescription.SUPPORTED_SDP_VERSION;
        }
        double d = j;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, log10)) + StringUtils.SPACE + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }
}
