package com.baidu.location.p006b;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import androidx.core.view.ViewCompat;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p007c.C0677d;
import com.baidu.location.p010f.C0704b;
import com.baidu.location.p010f.C0706d;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0732n;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.net.nntp.NNTPReply;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.h */
/* loaded from: classes.dex */
public class C0654h {

    /* renamed from: f */
    public static String f502f = "0";

    /* renamed from: j */
    private static C0654h f503j;

    /* renamed from: I */
    private Handler f512I;

    /* renamed from: k */
    private int f526k = 1;

    /* renamed from: l */
    private double f527l = 0.699999988079071d;

    /* renamed from: m */
    private String f528m = "3G|4G";

    /* renamed from: n */
    private int f529n = 1;

    /* renamed from: o */
    private int f530o = 307200;

    /* renamed from: p */
    private int f531p = 15;

    /* renamed from: q */
    private int f532q = 1;

    /* renamed from: r */
    private double f533r = 3.5d;

    /* renamed from: s */
    private double f534s = 3.0d;

    /* renamed from: t */
    private double f535t = 0.5d;

    /* renamed from: u */
    private int f536u = 300;

    /* renamed from: v */
    private int f537v = 60;

    /* renamed from: w */
    private int f538w = 0;

    /* renamed from: x */
    private int f539x = 60;

    /* renamed from: y */
    private int f540y = 0;

    /* renamed from: z */
    private long f541z = 0;

    /* renamed from: A */
    private b f504A = null;

    /* renamed from: B */
    private boolean f505B = false;

    /* renamed from: C */
    private boolean f506C = false;

    /* renamed from: D */
    private int f507D = 0;

    /* renamed from: E */
    private float f508E = 0.0f;

    /* renamed from: F */
    private float f509F = 0.0f;

    /* renamed from: G */
    private long f510G = 0;

    /* renamed from: H */
    private int f511H = 500;

    /* renamed from: a */
    long f518a = 0;

    /* renamed from: b */
    Location f519b = null;

    /* renamed from: c */
    Location f520c = null;

    /* renamed from: d */
    StringBuilder f521d = null;

    /* renamed from: e */
    long f522e = 0;

    /* renamed from: J */
    private byte[] f513J = new byte[4];

    /* renamed from: K */
    private byte[] f514K = null;

    /* renamed from: L */
    private int f515L = 0;

    /* renamed from: M */
    private List<Byte> f516M = null;

    /* renamed from: N */
    private boolean f517N = false;

    /* renamed from: g */
    int f523g = 0;

    /* renamed from: h */
    double f524h = 116.22345545d;

    /* renamed from: i */
    double f525i = 40.245667323d;

    /* renamed from: com.baidu.location.b.h$a */
    private static class a implements HostnameVerifier {

        /* renamed from: a */
        private URL f542a;

        public a(URL url) {
            this.f542a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f542a.getHost().equals(str);
        }
    }

    /* renamed from: com.baidu.location.b.h$b */
    class b extends AbstractC0725g {

        /* renamed from: a */
        String f543a = null;

        public b() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public void m440a(String str) {
            this.f543a = str;
            m1133e("https://loc.map.baidu.com/cc.php");
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            if (z && this.f1291j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f1291j);
                    jSONObject.put("prod", C0720b.f1244e);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    C0654h.this.m430e(jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            if (this.f1292k != null) {
                this.f1292k.clear();
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            this.f1289h = "https://loc.map.baidu.com/cc.php";
            String encode = Jni.encode(this.f543a);
            this.f543a = null;
            this.f1292k.put("q", encode);
        }
    }

    private C0654h() {
        this.f512I = null;
        this.f512I = new Handler();
    }

    /* renamed from: a */
    public static C0654h m411a() {
        if (f503j == null) {
            f503j = new C0654h();
        }
        return f503j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m413a(File file, String str) {
        String uuid = UUID.randomUUID().toString();
        try {
            HttpsURLConnection.setDefaultSSLSocketFactory(C0733o.m1172k());
            URL url = new URL(str);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Charset", "utf-8");
            httpsURLConnection.setHostnameVerifier(new a(url));
            httpsURLConnection.setRequestProperty(RtspHeaders.CONNECTION, "close");
            httpsURLConnection.setRequestProperty("Content-Type", HttpHeaders.Values.MULTIPART_FORM_DATA + ";boundary=" + uuid);
            if (file == null || !file.exists()) {
                return SessionDescription.SUPPORTED_SDP_VERSION;
            }
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            stringBuffer.append(uuid);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"\r\n");
            stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8\r\n");
            stringBuffer.append("\r\n");
            dataOutputStream.write(stringBuffer.toString().getBytes());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, read);
            }
            fileInputStream.close();
            dataOutputStream.write("\r\n".getBytes());
            dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            outputStream.close();
            httpsURLConnection.disconnect();
            int i = this.f540y + NNTPReply.SERVICE_DISCONTINUED;
            this.f540y = i;
            m423c(i);
            return responseCode == 200 ? "1" : SessionDescription.SUPPORTED_SDP_VERSION;
        } catch (MalformedURLException | IOException unused) {
            return SessionDescription.SUPPORTED_SDP_VERSION;
        } catch (Exception e) {
            e.printStackTrace();
            return SessionDescription.SUPPORTED_SDP_VERSION;
        }
    }

    /* renamed from: a */
    private boolean m416a(String str, Context context) {
        return true;
    }

    /* renamed from: a */
    private byte[] m417a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & ViewCompat.MEASURED_STATE_MASK) >> 24)};
    }

    /* renamed from: a */
    private byte[] m418a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new SecureRandom().nextInt(255);
        byte nextInt2 = (byte) new SecureRandom().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2++;
        }
        bArr[i2] = nextInt;
        bArr[i2 + 1] = nextInt2;
        return bArr;
    }

    /* renamed from: b */
    private String m419b(String str) {
        Calendar calendar = Calendar.getInstance();
        return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    /* renamed from: b */
    private void m420b(int i) {
        byte[] m417a = m417a(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.f516M.add(Byte.valueOf(m417a[i2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m421b(Location location) {
        m424c(location);
        m434h();
    }

    /* renamed from: c */
    private void m422c() {
        if (this.f517N) {
            return;
        }
        this.f517N = true;
        m428d(C0720b.f1244e);
        m436j();
        m426d();
    }

    /* renamed from: c */
    private void m423c(int i) {
        if (i == 0) {
            return;
        }
        try {
            File file = new File(C0732n.f1312a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(C0732n.f1312a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile2.seek(8L);
            byte[] bytes2 = (m419b("%d_%02d_%02d") + ":" + i).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private void m424c(Location location) {
        if (System.currentTimeMillis() - this.f518a < this.f511H || location == null) {
            return;
        }
        if (location != null && location.hasSpeed() && location.getSpeed() > this.f508E) {
            this.f508E = location.getSpeed();
        }
        try {
            if (this.f516M == null) {
                this.f516M = new ArrayList();
                m435i();
                m427d(location);
            } else {
                m429e(location);
            }
        } catch (Exception unused) {
        }
        this.f515L++;
    }

    /* renamed from: c */
    private void m425c(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.f526k = jSONObject.getInt("on");
                }
                if (jSONObject.has("bash")) {
                    this.f527l = jSONObject.getDouble("bash");
                }
                if (jSONObject.has("net")) {
                    this.f528m = jSONObject.getString("net");
                }
                if (jSONObject.has("tcon")) {
                    this.f529n = jSONObject.getInt("tcon");
                }
                if (jSONObject.has("tcsh")) {
                    this.f530o = jSONObject.getInt("tcsh");
                }
                if (jSONObject.has("per")) {
                    this.f531p = jSONObject.getInt("per");
                }
                if (jSONObject.has("chdron")) {
                    this.f532q = jSONObject.getInt("chdron");
                }
                if (jSONObject.has("spsh")) {
                    this.f533r = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.f534s = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.f535t = jSONObject.getDouble("stspsh");
                }
                if (jSONObject.has("drstsh")) {
                    this.f536u = jSONObject.getInt("drstsh");
                }
                if (jSONObject.has("stper")) {
                    this.f537v = jSONObject.getInt("stper");
                }
                if (jSONObject.has("nondron")) {
                    this.f538w = jSONObject.getInt("nondron");
                }
                if (jSONObject.has("nondrper")) {
                    this.f539x = jSONObject.getInt("nondrper");
                }
                if (jSONObject.has("uptime")) {
                    this.f541z = jSONObject.getLong("uptime");
                }
                m437k();
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: d */
    private void m426d() {
        String[] split = "9.4.0.1".split("\\.");
        int length = split.length;
        byte[] bArr = this.f513J;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.f513J[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
            } catch (Exception unused) {
            }
        }
        this.f514K = m418a(C0720b.f1244e + ":" + C0720b.m1100a().f1254c);
    }

    /* renamed from: d */
    private void m427d(Location location) {
        this.f522e = System.currentTimeMillis();
        m420b((int) (location.getTime() / 1000));
        m420b((int) (location.getLongitude() * 1000000.0d));
        m420b((int) (location.getLatitude() * 1000000.0d));
        int i = !location.hasBearing() ? 1 : 0;
        int i2 = !location.hasSpeed() ? 1 : 0;
        this.f516M.add(Byte.valueOf(i > 0 ? (byte) 32 : (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        this.f516M.add(Byte.valueOf(i2 > 0 ? Byte.MIN_VALUE : (byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        this.f519b = location;
    }

    /* renamed from: d */
    private void m428d(String str) {
        try {
            File file = new File(C0732n.f1312a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(2L);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.seek(8L);
                int readInt2 = randomAccessFile.readInt();
                int i = 1;
                if (readInt2 < 4096) {
                    byte[] bArr = new byte[readInt2];
                    randomAccessFile.read(bArr, 0, readInt2);
                    String str2 = new String(bArr);
                    if (str2.contains(m419b("%d_%02d_%02d")) && str2.contains(":")) {
                        try {
                            String[] split = str2.split(":");
                            if (split.length > 1) {
                                this.f540y = Integer.valueOf(split[1]).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                while (true) {
                    if (i > readInt) {
                        break;
                    }
                    randomAccessFile.seek(i * 2048);
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 <= 4096) {
                        byte[] bArr2 = new byte[readInt3];
                        randomAccessFile.read(bArr2, 0, readInt3);
                        String str3 = new String(bArr2);
                        if (str != null && str3.contains(str)) {
                            m425c(str3);
                            break;
                        }
                    }
                    i++;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ff, code lost:
    
        if (r8 > 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0117, code lost:
    
        r2 = (byte) (r2 | Byte.MIN_VALUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0115, code lost:
    
        if (r8 > 0) goto L38;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m429e(android.location.Location r22) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0654h.m429e(android.location.Location):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m430e(String str) {
        try {
            File file = new File(C0732n.f1312a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(C0732n.f1312a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile2.seek(2L);
            int readInt = randomAccessFile2.readInt();
            int i = 1;
            while (i <= readInt) {
                randomAccessFile2.seek(i * 2048);
                int readInt2 = randomAccessFile2.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile2.read(bArr, 0, readInt2);
                if (new String(bArr).contains(C0720b.f1244e)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= readInt) {
                randomAccessFile2.seek(2L);
                randomAccessFile2.writeInt(i);
            }
            randomAccessFile2.seek(i * 2048);
            byte[] bytes2 = str.getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    private boolean m431e() {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        FileLock fileLock = null;
        fileChannel = null;
        RandomAccessFile randomAccessFile2 = null;
        boolean z = false;
        try {
            try {
                File file = new File(C0733o.m1164f() + File.separator + "gflk.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
            }
            try {
                channel = randomAccessFile.getChannel();
            } catch (Exception unused2) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                fileLock = channel.tryLock();
            } catch (Exception unused3) {
                z = true;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = channel;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
            if (fileLock != null) {
                fileLock.release();
            }
            if (channel != null) {
                channel.close();
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception unused5) {
        }
        return z;
    }

    /* renamed from: f */
    private boolean m432f() {
        if (this.f505B) {
            if (this.f506C) {
                if (this.f508E < this.f535t) {
                    int i = this.f507D + this.f531p;
                    this.f507D = i;
                    if (i > this.f536u && System.currentTimeMillis() - this.f510G <= this.f537v * 1000) {
                        return false;
                    }
                } else {
                    this.f507D = 0;
                    this.f506C = false;
                }
            } else if (this.f508E < this.f535t) {
                this.f506C = true;
                this.f507D = 0;
                this.f507D = 0 + this.f531p;
            }
        } else if (this.f508E >= this.f533r || this.f509F >= this.f534s) {
            this.f505B = true;
        } else if (this.f538w != 1 || System.currentTimeMillis() - this.f510G <= this.f539x * 1000) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    private void m433g() {
        this.f516M = null;
        this.f522e = 0L;
        this.f515L = 0;
        this.f519b = null;
        this.f520c = null;
        this.f508E = 0.0f;
        this.f509F = 0.0f;
    }

    /* renamed from: h */
    private void m434h() {
        if (this.f522e == 0 || System.currentTimeMillis() - this.f522e < this.f531p * 1000) {
            return;
        }
        if (ServiceC0702f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            m433g();
            return;
        }
        if (this.f529n == 1 && !m432f()) {
            m433g();
            return;
        }
        if (C0720b.f1244e.equals("com.ubercab.driver")) {
            if (m431e()) {
                m433g();
                return;
            }
        } else if (!m416a(C0720b.f1244e, ServiceC0702f.getServiceContext())) {
            m433g();
            return;
        }
        List<Byte> list = this.f516M;
        if (list != null) {
            try {
                int size = list.size();
                this.f516M.set(0, Byte.valueOf((byte) (size & 255)));
                this.f516M.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
                this.f516M.set(3, Byte.valueOf((byte) (this.f515L & 255)));
                byte[] bArr = new byte[size];
                for (int i = 0; i < size; i++) {
                    bArr[i] = this.f516M.get(i).byteValue();
                }
                File file = new File(C0733o.m1169h(), "baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (file.exists()) {
                    File file2 = new File(file, "intime.dat");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        new C0656j(this).start();
                    } catch (Exception unused) {
                    }
                }
                m433g();
                this.f510G = System.currentTimeMillis();
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: i */
    private void m435i() {
        List<Byte> list;
        byte b2;
        this.f516M.add((byte) 0);
        this.f516M.add((byte) 0);
        if (f502f.equals(SessionDescription.SUPPORTED_SDP_VERSION)) {
            list = this.f516M;
            b2 = -82;
        } else {
            list = this.f516M;
            b2 = -66;
        }
        list.add(Byte.valueOf(b2));
        this.f516M.add((byte) 0);
        this.f516M.add(Byte.valueOf(this.f513J[0]));
        this.f516M.add(Byte.valueOf(this.f513J[1]));
        this.f516M.add(Byte.valueOf(this.f513J[2]));
        this.f516M.add(Byte.valueOf(this.f513J[3]));
        int length = this.f514K.length;
        this.f516M.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.f516M.add(Byte.valueOf(this.f514K[i]));
        }
    }

    /* renamed from: j */
    private void m436j() {
        if (System.currentTimeMillis() - this.f541z > 86400000) {
            if (this.f504A == null) {
                this.f504A = new b();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(C0720b.m1100a().m1101a(false));
            stringBuffer.append(C0648b.m321a().m339d());
            this.f504A.m440a(stringBuffer.toString());
        }
        m437k();
    }

    /* renamed from: k */
    private void m437k() {
    }

    /* renamed from: a */
    public void m438a(Location location) {
        if (!this.f517N) {
            m422c();
        }
        boolean z = ((double) C0677d.m647a().m655f()) < this.f527l * 100.0d;
        if (this.f526k == 1 && z && this.f528m.contains(C0706d.m945a(C0704b.m912a().m939e()))) {
            if (this.f529n != 1 || this.f540y <= this.f530o) {
                this.f512I.post(new RunnableC0655i(this, location));
            }
        }
    }

    /* renamed from: b */
    public void m439b() {
        if (this.f517N) {
            this.f517N = false;
            m433g();
        }
    }
}