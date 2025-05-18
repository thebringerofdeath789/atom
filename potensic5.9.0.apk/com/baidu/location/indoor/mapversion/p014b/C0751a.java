package com.baidu.location.indoor.mapversion.p014b;

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

/* renamed from: com.baidu.location.indoor.mapversion.b.a */
/* loaded from: classes.dex */
public class C0751a {

    /* renamed from: a */
    private static C0751a f1551a;

    /* renamed from: b */
    private c f1552b;

    /* renamed from: c */
    private String f1553c;

    /* renamed from: e */
    private String f1555e;

    /* renamed from: f */
    private b f1556f;

    /* renamed from: d */
    private boolean f1554d = false;

    /* renamed from: g */
    private String f1557g = "gcj02";

    /* renamed from: h */
    private boolean f1558h = false;

    /* renamed from: k */
    private d f1561k = null;

    /* renamed from: i */
    private HashMap<String, d> f1559i = new HashMap<>();

    /* renamed from: j */
    private HashMap<String, double[][]> f1560j = new HashMap<>();

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$a */
    public static class a {

        /* renamed from: a */
        public double f1562a;

        /* renamed from: b */
        public double f1563b;

        /* renamed from: c */
        public double f1564c;

        /* renamed from: d */
        public double f1565d;

        /* renamed from: e */
        public double f1566e;

        /* renamed from: f */
        public double f1567f;

        /* renamed from: g */
        public double f1568g;

        /* renamed from: h */
        public double f1569h;

        public a(String str) {
            m1304a(str);
        }

        /* renamed from: a */
        public void m1304a(String str) {
            String[] split = str.trim().split("\\|");
            this.f1562a = Double.valueOf(split[0]).doubleValue();
            this.f1563b = Double.valueOf(split[1]).doubleValue();
            this.f1564c = Double.valueOf(split[2]).doubleValue();
            this.f1565d = Double.valueOf(split[3]).doubleValue();
            this.f1566e = Double.valueOf(split[4]).doubleValue();
            this.f1567f = Double.valueOf(split[5]).doubleValue();
            this.f1568g = Double.valueOf(split[6]).doubleValue();
            this.f1569h = Double.valueOf(split[7]).doubleValue();
        }
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$b */
    private class b extends Thread {

        /* renamed from: b */
        private String f1571b;

        /* renamed from: c */
        private String f1572c;

        public b(String str, String str2) {
            this.f1571b = str;
            this.f1572c = str2;
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.p014b.C0751a.b.run():void");
        }
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$c */
    public interface c {
        /* renamed from: a */
        void mo1305a(boolean z, String str);
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$d */
    public static class d implements Serializable {

        /* renamed from: a */
        public String f1573a;

        /* renamed from: b */
        public String f1574b;

        /* renamed from: d */
        public a f1576d;

        /* renamed from: f */
        public a f1578f;

        /* renamed from: h */
        public short[][] f1580h;

        /* renamed from: c */
        public String f1575c = "0|3";

        /* renamed from: e */
        public a f1577e;

        /* renamed from: g */
        public a f1579g = this.f1577e;

        /* renamed from: i */
        private String f1581i = "gcj02";

        public d(String str) {
            this.f1573a = str;
        }

        /* renamed from: a */
        public double m1306a(double d) {
            return (d + this.f1579g.f1565d) * this.f1579g.f1564c;
        }

        /* renamed from: a */
        public a m1307a() {
            return this.f1579g;
        }

        /* renamed from: a */
        public void m1308a(String str) {
            a aVar;
            if (str != null) {
                String lowerCase = str.toLowerCase();
                this.f1581i = lowerCase;
                if (lowerCase.startsWith("wgs84")) {
                    aVar = this.f1576d;
                } else if (this.f1581i.startsWith("bd09")) {
                    aVar = this.f1578f;
                } else if (!this.f1581i.startsWith("gcj02")) {
                    return;
                } else {
                    aVar = this.f1577e;
                }
                this.f1579g = aVar;
            }
        }

        /* renamed from: b */
        public double m1309b(double d) {
            return (d + this.f1579g.f1567f) * this.f1579g.f1566e;
        }

        /* renamed from: b */
        public void m1310b(String str) {
            String[] split = str.split("\\t");
            this.f1574b = split[1];
            this.f1576d = new a(split[2]);
            this.f1578f = new a(split[3]);
            a aVar = new a(split[4]);
            this.f1577e = aVar;
            this.f1579g = aVar;
            this.f1580h = (short[][]) Array.newInstance((Class<?>) short.class, (int) aVar.f1568g, (int) this.f1579g.f1569h);
            for (int i = 0; i < this.f1579g.f1568g; i++) {
                for (int i2 = 0; i2 < this.f1579g.f1569h; i2++) {
                    this.f1580h[i][i2] = (short) (split[5].charAt((((int) this.f1579g.f1569h) * i) + i2) - '0');
                }
            }
            if (split.length >= 7) {
                this.f1575c = split[6];
            }
        }

        /* renamed from: c */
        public double m1311c(double d) {
            return (d / this.f1579g.f1564c) - this.f1579g.f1565d;
        }

        /* renamed from: d */
        public double m1312d(double d) {
            return (d / this.f1579g.f1566e) - this.f1579g.f1567f;
        }
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$e */
    private static class e implements HostnameVerifier {

        /* renamed from: a */
        private URL f1582a;

        public e(URL url) {
            this.f1582a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f1582a.getHost().equals(str);
        }
    }

    private C0751a(Context context) {
        this.f1555e = "rn";
        this.f1555e = new File(context.getCacheDir(), this.f1555e).getAbsolutePath();
    }

    /* renamed from: a */
    public static C0751a m1274a() {
        return f1551a;
    }

    /* renamed from: a */
    public static C0751a m1275a(Context context) {
        if (f1551a == null) {
            f1551a = new C0751a(context);
        }
        return f1551a;
    }

    /* renamed from: a */
    public static String m1279a(File file) {
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
    /* renamed from: a */
    public String m1280a(String str, String str2) {
        return m1288d(str) + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1284b(String str, String str2) {
        try {
            File file = new File(this.f1555e + InternalZipConstants.ZIP_FILE_SEPARATOR + m1280a(str, str2));
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String m1288d(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m1289d() {
        String str = this.f1553c;
        if (str == null) {
            return false;
        }
        File m1291f = m1291f(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!C0754d.m1318a(m1291f, byteArrayOutputStream)) {
            return false;
        }
        this.f1559i.clear();
        this.f1560j.clear();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.split("\\t")[1].split("_")[0].equals("geo")) {
                    m1295j(readLine);
                } else {
                    d dVar = new d(this.f1553c);
                    dVar.m1310b(readLine);
                    dVar.m1308a(this.f1557g);
                    this.f1559i.put(dVar.f1574b.toLowerCase(), dVar);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        bufferedReader.close();
        return true;
    }

    /* renamed from: e */
    private String m1290e(String str) {
        File file = new File(this.f1555e);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new C0752b(this, str));
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

    /* renamed from: f */
    private File m1291f(String str) {
        return new File(this.f1555e + InternalZipConstants.ZIP_FILE_SEPARATOR + m1280a(str, m1290e(str)));
    }

    /* renamed from: g */
    private boolean m1292g(String str) {
        File m1291f = m1291f(str);
        return m1291f.exists() && m1291f.length() > 0;
    }

    /* renamed from: h */
    private boolean m1293h(String str) {
        return System.currentTimeMillis() - m1291f(str).lastModified() > 1296000000;
    }

    /* renamed from: i */
    private ArrayList<Double> m1294i(String str) {
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

    /* renamed from: j */
    private void m1295j(String str) {
        String[] split = str.split("\\t");
        String lowerCase = split[1].split("_")[1].toLowerCase();
        try {
            if (this.f1559i.containsKey(lowerCase)) {
                ArrayList<Double> m1294i = m1294i(split[5]);
                int length = this.f1559i.get(lowerCase).f1580h.length;
                int length2 = this.f1559i.get(lowerCase).f1580h[0].length;
                double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, length, length2);
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    for (int i3 = 0; i3 < length2; i3++) {
                        if (this.f1559i.get(lowerCase).f1580h[i2][i3] <= 0 || this.f1559i.get(lowerCase).f1580h[i2][i3] == 9) {
                            dArr[i2][i3] = 0.0d;
                        } else {
                            dArr[i2][i3] = m1294i.get(i).doubleValue();
                            i++;
                        }
                    }
                }
                this.f1560j.put(lowerCase.toLowerCase(), dArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m1296k(String str) {
        if (this.f1554d) {
            return;
        }
        this.f1554d = true;
        b bVar = new b(str, m1290e(str));
        this.f1556f = bVar;
        bVar.start();
    }

    /* renamed from: a */
    public void m1297a(double d2, double d3) {
        if (this.f1561k == null) {
            Location.distanceBetween(d3, d2, d3, d2 + 0.01d, new float[2]);
            Location.distanceBetween(d3, d2, d3 + 0.01d, d2, new float[2]);
            d dVar = new d("outdoor");
            this.f1561k = dVar;
            dVar.f1574b = "out";
            this.f1561k.f1579g = new a("0|1.0|" + (r14[0] / 0.01d) + "|" + (-d2) + "|" + (r15[0] / 0.01d) + "|" + (-d3) + "|0|0");
        }
    }

    /* renamed from: a */
    public void m1298a(String str) {
        this.f1557g = str;
    }

    /* renamed from: a */
    public void m1299a(String str, c cVar) {
        String str2 = this.f1553c;
        if ((str2 == null || !str.equals(str2)) && !this.f1558h) {
            this.f1552b = cVar;
            if (!m1292g(str) || m1293h(str)) {
                m1296k(str);
                return;
            }
            this.f1553c = str;
            m1289d();
            c cVar2 = this.f1552b;
            if (cVar2 != null) {
                cVar2.mo1305a(true, "OK");
            }
        }
    }

    /* renamed from: b */
    public d m1300b(String str) {
        return this.f1559i.get(str.toLowerCase());
    }

    /* renamed from: b */
    public void m1301b() {
        this.f1559i.clear();
        this.f1560j.clear();
        this.f1553c = null;
        this.f1554d = false;
    }

    /* renamed from: c */
    public d m1302c() {
        return this.f1561k;
    }

    /* renamed from: c */
    public double[][] m1303c(String str) {
        return this.f1560j.get(str.toLowerCase());
    }
}