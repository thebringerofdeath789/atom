package com.mapbox.android.core;

import android.content.Context;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes3.dex */
public final class FileUtils {
    private static final int DEFAULT_BUFFER_SIZE_IN_BYTES = 4096;
    private static final String LOG_TAG = "FileUtils";

    private FileUtils() {
    }

    public static File getFile(Context context, String str) {
        return new File(context.getFilesDir(), str);
    }

    public static String readFromFile(File file) throws FileNotFoundException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        StringWriter stringWriter = new StringWriter();
        try {
            try {
                try {
                    char[] cArr = new char[4096];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    inputStreamReader.close();
                } catch (Throwable th) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, e.toString());
                    }
                    throw th;
                }
            } catch (IOException e2) {
                Log.w(LOG_TAG, e2.toString());
                inputStreamReader.close();
            }
        } catch (IOException e3) {
            Log.e(LOG_TAG, e3.toString());
        }
        return stringWriter.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0019 -> B:6:0x002e). Please report as a decompilation issue!!! */
    public static void writeToFile(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        try {
        } catch (IOException e) {
            Log.e(LOG_TAG, e.toString());
        }
        try {
            try {
                outputStreamWriter.write(str);
                outputStreamWriter.flush();
                outputStreamWriter.close();
            } catch (IOException e2) {
                Log.e(LOG_TAG, e2.toString());
                outputStreamWriter.close();
            }
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (IOException e3) {
                Log.e(LOG_TAG, e3.toString());
            }
            throw th;
        }
    }

    public static void deleteFile(File file) {
        if (file.delete()) {
            return;
        }
        Log.w(LOG_TAG, "Could not delete file: " + file);
    }

    public static File[] listAllFiles(File file) {
        if (file == null) {
            return new File[0];
        }
        File[] listFiles = file.listFiles();
        return listFiles != null ? listFiles : new File[0];
    }

    public static void deleteFirst(File[] fileArr, Comparator<File> comparator, int i) {
        Arrays.sort(fileArr, comparator);
        int min = Math.min(fileArr.length, i);
        for (int i2 = 0; i2 < min; i2++) {
            if (!fileArr[i2].delete()) {
                Log.w(LOG_TAG, "Failed to delete file: " + fileArr[i2]);
            }
        }
    }

    public static final class LastModifiedComparator implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if (lastModified < lastModified2) {
                return -1;
            }
            return lastModified == lastModified2 ? 0 : 1;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
