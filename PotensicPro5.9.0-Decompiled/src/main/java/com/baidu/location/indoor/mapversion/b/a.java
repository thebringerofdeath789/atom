package com.baidu.location.indoor.mapversion.b;

import android.content.Context;
import android.location.Location;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes.dex */
public class a {
    private static a a;
    private c b;
    private String c;
    private String e;
    private b f;
    private boolean d = false;
    private String g = "gcj02";
    private boolean h = false;
    private d k = null;
    private HashMap<String, d> i = new HashMap<>();
    private HashMap<String, double[][]> j = new HashMap<>();

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$a, reason: collision with other inner class name */
    public static class C0015a {
        public double a;
        public double b;
        public double c;
        public double d;
        public double e;
        public double f;
        public double g;
        public double h;

        public C0015a(String str) {
            a(str);
        }

        public void a(String str) {
            String[] split = str.trim().split("\\|");
            this.a = Double.valueOf(split[0]).doubleValue();
            this.b = Double.valueOf(split[1]).doubleValue();
            this.c = Double.valueOf(split[2]).doubleValue();
            this.d = Double.valueOf(split[3]).doubleValue();
            this.e = Double.valueOf(split[4]).doubleValue();
            this.f = Double.valueOf(split[5]).doubleValue();
            this.g = Double.valueOf(split[6]).doubleValue();
            this.h = Double.valueOf(split[7]).doubleValue();
        }
    }

    private class b extends Thread {
        private String b;
        private String c;

        public b(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0138 A[Catch: Exception -> 0x0142, TRY_LEAVE, TryCatch #0 {Exception -> 0x0142, blocks: (B:3:0x0001, B:5:0x0012, B:7:0x001b, B:10:0x006b, B:12:0x0083, B:13:0x00a3, B:15:0x00a9, B:17:0x00ad, B:19:0x00bd, B:20:0x0130, B:22:0x0138, B:27:0x00d7, B:31:0x00e2, B:34:0x0115, B:35:0x0018), top: B:2:0x0001 }] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 332
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.b.a.b.run():void");
        }
    }

    public interface c {
        void a(boolean z, String str);
    }

    public static class d implements Serializable {
        public String a;
        public String b;
        public C0015a d;
        public C0015a f;
        public short[][] h;
        public String c = "0|3";
        public C0015a e;
        public C0015a g = this.e;
        private String i = "gcj02";

        public d(String str) {
            this.a = str;
        }

        public double a(double d) {
            return (d + this.g.d) * this.g.c;
        }

        public C0015a a() {
            return this.g;
        }

        public void a(String str) {
            C0015a c0015a;
            if (str != null) {
                String lowerCase = str.toLowerCase();
                this.i = lowerCase;
                if (lowerCase.startsWith("wgs84")) {
                    c0015a = this.d;
                } else if (this.i.startsWith("bd09")) {
                    c0015a = this.f;
                } else if (!this.i.startsWith("gcj02")) {
                    return;
                } else {
                    c0015a = this.e;
                }
                this.g = c0015a;
            }
        }

        public double b(double d) {
            return (d + this.g.f) * this.g.e;
        }

        public void b(String str) {
            String[] split = str.split("\\t");
            this.b = split[1];
            this.d = new C0015a(split[2]);
            this.f = new C0015a(split[3]);
            C0015a c0015a = new C0015a(split[4]);
            this.e = c0015a;
            this.g = c0015a;
            this.h = (short[][]) Array.newInstance((Class<?>) short.class, (int) c0015a.g, (int) this.g.h);
            for (int i = 0; i < this.g.g; i++) {
                for (int i2 = 0; i2 < this.g.h; i2++) {
                    this.h[i][i2] = (short) (split[5].charAt((((int) this.g.h) * i) + i2) - '0');
                }
            }
            if (split.length >= 7) {
                this.c = split[6];
            }
        }

        public double c(double d) {
            return (d / this.g.c) - this.g.d;
        }

        public double d(double d) {
            return (d / this.g.e) - this.g.f;
        }
    }

    private static class e implements HostnameVerifier {
        private URL a;

        public e(URL url) {
            this.a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.a.getHost().equals(str);
        }
    }

    private a(Context context) {
        this.e = "rn";
        this.e = new File(context.getCacheDir(), this.e).getAbsolutePath();
    }

    public static a a() {
        return a;
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    public static String a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(map);
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            fileInputStream.close();
            for (int length = 32 - bigInteger.length(); length > 0; length--) {
                bigInteger = SessionDescription.SUPPORTED_SDP_VERSION + bigInteger;
            }
            return bigInteger;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        return d(str) + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        try {
            File file = new File(this.e + InternalZipConstants.ZIP_FILE_SEPARATOR + a(str, str2));
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        String str = this.c;
        if (str == null) {
            return false;
        }
        File f = f(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!com.baidu.location.indoor.mapversion.b.d.a(f, byteArrayOutputStream)) {
            return false;
        }
        this.i.clear();
        this.j.clear();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.split("\\t")[1].split("_")[0].equals("geo")) {
                    j(readLine);
                } else {
                    d dVar = new d(this.c);
                    dVar.b(readLine);
                    dVar.a(this.g);
                    this.i.put(dVar.b.toLowerCase(), dVar);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        bufferedReader.close();
        return true;
    }

    private String e(String str) {
        File file = new File(this.e);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new com.baidu.location.indoor.mapversion.b.b(this, str));
            if (listFiles != null && listFiles.length == 1) {
                String[] split = listFiles[0].getName().split("_");
                if (split.length < 2) {
                    return null;
                }
                return split[1];
            }
            for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                listFiles[i].delete();
            }
        }
        return null;
    }

    private File f(String str) {
        return new File(this.e + InternalZipConstants.ZIP_FILE_SEPARATOR + a(str, e(str)));
    }

    private boolean g(String str) {
        File f = f(str);
        return f.exists() && f.length() > 0;
    }

    private boolean h(String str) {
        return System.currentTimeMillis() - f(str).lastModified() > 1296000000;
    }

    private ArrayList<Double> i(String str) {
        double d2;
        ArrayList<Double> arrayList = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ',') {
                int i2 = i + 1;
                i += 2;
                d2 = Integer.valueOf(str.substring(i2, i)).intValue();
            } else if (str.charAt(i) == '.') {
                int i3 = i + 1;
                i += 4;
                d2 = Double.valueOf(str.substring(i3, i)).doubleValue();
            } else {
                int i4 = i + 2;
                double intValue = Integer.valueOf(str.substring(i, i4)).intValue();
                i = i4;
                d2 = intValue;
            }
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    private void j(String str) {
        String[] split = str.split("\\t");
        String lowerCase = split[1].split("_")[1].toLowerCase();
        try {
            if (this.i.containsKey(lowerCase)) {
                ArrayList<Double> i = i(split[5]);
                int length = this.i.get(lowerCase).h.length;
                int length2 = this.i.get(lowerCase).h[0].length;
                double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, length, length2);
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    for (int i4 = 0; i4 < length2; i4++) {
                        if (this.i.get(lowerCase).h[i3][i4] <= 0 || this.i.get(lowerCase).h[i3][i4] == 9) {
                            dArr[i3][i4] = 0.0d;
                        } else {
                            dArr[i3][i4] = i.get(i2).doubleValue();
                            i2++;
                        }
                    }
                }
                this.j.put(lowerCase.toLowerCase(), dArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void k(String str) {
        if (this.d) {
            return;
        }
        this.d = true;
        b bVar = new b(str, e(str));
        this.f = bVar;
        bVar.start();
    }

    public void a(double d2, double d3) {
        if (this.k == null) {
            Location.distanceBetween(d3, d2, d3, d2 + 0.01d, new float[2]);
            Location.distanceBetween(d3, d2, d3 + 0.01d, d2, new float[2]);
            d dVar = new d("outdoor");
            this.k = dVar;
            dVar.b = "out";
            this.k.g = new C0015a("0|1.0|" + (r14[0] / 0.01d) + "|" + (-d2) + "|" + (r15[0] / 0.01d) + "|" + (-d3) + "|0|0");
        }
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(String str, c cVar) {
        String str2 = this.c;
        if ((str2 == null || !str.equals(str2)) && !this.h) {
            this.b = cVar;
            if (!g(str) || h(str)) {
                k(str);
                return;
            }
            this.c = str;
            d();
            c cVar2 = this.b;
            if (cVar2 != null) {
                cVar2.a(true, "OK");
            }
        }
    }

    public d b(String str) {
        return this.i.get(str.toLowerCase());
    }

    public void b() {
        this.i.clear();
        this.j.clear();
        this.c = null;
        this.d = false;
    }

    public d c() {
        return this.k;
    }

    public double[][] c(String str) {
        return this.j.get(str.toLowerCase());
    }
}
