package com.ipotensic.potensicpro.utils;

import android.graphics.Bitmap;
import com.ipotensic.baselib.LocalFileManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes2.dex */
public class FileUtil {
    public static boolean writeToFile(String str, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveBitmap(String str, Bitmap bitmap) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] fileToByteArray(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
            byte[] bArr = new byte[1000];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0065 A[Catch: IOException -> 0x0061, TRY_LEAVE, TryCatch #3 {IOException -> 0x0061, blocks: (B:44:0x005d, B:37:0x0065), top: B:43:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getStringFromInputStream(java.io.InputStream r5) {
        /*
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L42
            java.lang.String r2 = "utf-8"
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L42
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L3a
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L3a
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L5a
            java.lang.String r3 = ""
            r2.<init>(r3)     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L5a
        L14:
            java.lang.String r3 = r5.readLine()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L5a
            if (r3 == 0) goto L23
            r2.append(r3)     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L5a
            java.lang.String r3 = "\n"
            r2.append(r3)     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L5a
            goto L14
        L23:
            java.lang.String r0 = r2.toString()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L5a
            r1.close()     // Catch: java.io.IOException -> L2e
            r5.close()     // Catch: java.io.IOException -> L2e
            goto L32
        L2e:
            r5 = move-exception
            r5.printStackTrace()
        L32:
            return r0
        L33:
            r2 = move-exception
            goto L45
        L35:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L5b
        L3a:
            r2 = move-exception
            r5 = r0
            goto L45
        L3d:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            goto L5b
        L42:
            r2 = move-exception
            r5 = r0
            r1 = r5
        L45:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L4e
            goto L50
        L4e:
            r5 = move-exception
            goto L56
        L50:
            if (r5 == 0) goto L59
            r5.close()     // Catch: java.io.IOException -> L4e
            goto L59
        L56:
            r5.printStackTrace()
        L59:
            return r0
        L5a:
            r0 = move-exception
        L5b:
            if (r1 == 0) goto L63
            r1.close()     // Catch: java.io.IOException -> L61
            goto L63
        L61:
            r5 = move-exception
            goto L69
        L63:
            if (r5 == 0) goto L6c
            r5.close()     // Catch: java.io.IOException -> L61
            goto L6c
        L69:
            r5.printStackTrace()
        L6c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.potensicpro.utils.FileUtil.getStringFromInputStream(java.io.InputStream):java.lang.String");
    }

    public static void copyFile(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        FileChannel fileChannel3 = null;
        fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = null;
                    fileChannel = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                    fileChannel = null;
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
                fileChannel = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileChannel = null;
            }
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    fileChannel3 = fileOutputStream.getChannel();
                    fileChannel.transferTo(0L, fileChannel.size(), fileChannel3);
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                    }
                    try {
                        fileChannel.close();
                    } catch (Exception unused2) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    fileChannel3.close();
                } catch (IOException e3) {
                    e = e3;
                    fileChannel2 = fileChannel3;
                    fileInputStream2 = fileInputStream;
                    try {
                        e.printStackTrace();
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused4) {
                        }
                        try {
                            fileChannel.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused6) {
                        }
                        fileChannel2.close();
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused7) {
                        }
                        try {
                            fileChannel.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused9) {
                        }
                        try {
                            fileChannel2.close();
                            throw th;
                        } catch (Exception unused10) {
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileChannel2 = fileChannel3;
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    fileChannel.close();
                    fileOutputStream.close();
                    fileChannel2.close();
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                fileChannel = null;
                fileInputStream2 = fileInputStream;
                fileChannel2 = fileChannel;
                e.printStackTrace();
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream.close();
                fileChannel2.close();
            } catch (Throwable th5) {
                th = th5;
                fileChannel = null;
                fileInputStream2 = fileInputStream;
                fileChannel2 = fileChannel;
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream.close();
                fileChannel2.close();
                throw th;
            }
        } catch (Exception unused11) {
        }
    }

    public static String fromBitmapGetFilePath(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (LocalFileManager.getInstance().getCacheDir() == null) {
            LocalFileManager.getInstance().initExternalDir();
            LocalFileManager.getInstance().initMediaDir();
        }
        String str = LocalFileManager.getInstance().getCacheDir() + File.separator + "picture_" + currentTimeMillis + ".jpg";
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
