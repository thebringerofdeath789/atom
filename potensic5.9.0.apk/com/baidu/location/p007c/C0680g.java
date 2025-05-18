package com.baidu.location.p007c;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.C0719a;
import com.baidu.location.p012h.C0722d;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.Thread;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.baidu.location.c.g */
/* loaded from: classes.dex */
public class C0680g implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static C0680g f818a;

    /* renamed from: b */
    private int f819b = 0;

    private C0680g() {
    }

    /* renamed from: a */
    public static C0680g m677a() {
        if (f818a == null) {
            f818a = new C0680g();
        }
        return f818a;
    }

    /* renamed from: a */
    private String m678a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    /* renamed from: a */
    private void m679a(File file, String str, String str2) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(280L);
            randomAccessFile.writeInt(12346);
            randomAccessFile.seek(300L);
            randomAccessFile.writeLong(System.currentTimeMillis());
            byte[] bytes = str.getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.seek(600L);
            byte[] bytes2 = str2.getBytes();
            randomAccessFile.writeInt(bytes2.length);
            randomAccessFile.write(bytes2, 0, bytes2.length);
            if (!m680a(str, str2)) {
                randomAccessFile.seek(280L);
                randomAccessFile.writeInt(1326);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private boolean m680a(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !C0715m.m1058a().m1077k()) {
            return false;
        }
        try {
            URL url = new URL(C0722d.f1258a);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("e0");
            stringBuffer.append("=");
            stringBuffer.append(str);
            stringBuffer.append("&");
            stringBuffer.append("e1");
            stringBuffer.append("=");
            stringBuffer.append(str2);
            stringBuffer.append("&");
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setConnectTimeout(C0719a.f1223a);
            httpsURLConnection.setReadTimeout(C0719a.f1223a);
            httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            httpsURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception unused) {
        }
        return httpsURLConnection.getResponseCode() == 200;
    }

    /* renamed from: b */
    public void m681b() {
        String str;
        try {
            File file = new File((Environment.getExternalStorageDirectory().getPath() + "/traces") + "/error_fs2.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(280L);
                if (1326 == randomAccessFile.readInt()) {
                    randomAccessFile.seek(308L);
                    int readInt = randomAccessFile.readInt();
                    String str2 = null;
                    if (readInt <= 0 || readInt >= 2048) {
                        str = null;
                    } else {
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        str = new String(bArr, 0, readInt);
                    }
                    randomAccessFile.seek(600L);
                    int readInt2 = randomAccessFile.readInt();
                    if (readInt2 > 0 && readInt2 < 2048) {
                        byte[] bArr2 = new byte[readInt2];
                        randomAccessFile.read(bArr2, 0, readInt2);
                        str2 = new String(bArr2, 0, readInt2);
                    }
                    if (m680a(str, str2)) {
                        randomAccessFile.seek(280L);
                        randomAccessFile.writeInt(12346);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad A[Catch: Exception -> 0x00b9, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b9, blocks: (B:47:0x0080, B:21:0x008a, B:23:0x00ad), top: B:46:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uncaughtException(java.lang.Thread r8, java.lang.Throwable r9) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p007c.C0680g.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}