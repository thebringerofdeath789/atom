package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import androidx.core.view.ViewCompat;
import com.baidu.location.Jni;
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

/* loaded from: classes.dex */
public class h {
    public static String f = "0";
    private static h j;
    private Handler I;
    private int k = 1;
    private double l = 0.699999988079071d;
    private String m = "3G|4G";
    private int n = 1;
    private int o = 307200;
    private int p = 15;
    private int q = 1;
    private double r = 3.5d;
    private double s = 3.0d;
    private double t = 0.5d;
    private int u = 300;
    private int v = 60;
    private int w = 0;
    private int x = 60;
    private int y = 0;
    private long z = 0;
    private b A = null;
    private boolean B = false;
    private boolean C = false;
    private int D = 0;
    private float E = 0.0f;
    private float F = 0.0f;
    private long G = 0;
    private int H = 500;
    long a = 0;
    Location b = null;
    Location c = null;
    StringBuilder d = null;
    long e = 0;
    private byte[] J = new byte[4];
    private byte[] K = null;
    private int L = 0;
    private List<Byte> M = null;
    private boolean N = false;
    int g = 0;
    double h = 116.22345545d;
    double i = 40.245667323d;

    private static class a implements HostnameVerifier {
        private URL a;

        public a(URL url) {
            this.a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.a.getHost().equals(str);
        }
    }

    class b extends com.baidu.location.h.g {
        String a = null;

        public b() {
            this.k = new HashMap();
        }

        public void a(String str) {
            this.a = str;
            e("https://loc.map.baidu.com/cc.php");
        }

        @Override // com.baidu.location.h.g
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    jSONObject.put("prod", com.baidu.location.h.b.e);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    h.this.e(jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }

        @Override // com.baidu.location.h.g
        public void b() {
            this.h = "https://loc.map.baidu.com/cc.php";
            String encode = Jni.encode(this.a);
            this.a = null;
            this.k.put("q", encode);
        }
    }

    private h() {
        this.I = null;
        this.I = new Handler();
    }

    public static h a() {
        if (j == null) {
            j = new h();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(File file, String str) {
        String uuid = UUID.randomUUID().toString();
        try {
            HttpsURLConnection.setDefaultSSLSocketFactory(com.baidu.location.h.o.k());
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
            int i = this.y + NNTPReply.SERVICE_DISCONTINUED;
            this.y = i;
            c(i);
            return responseCode == 200 ? "1" : SessionDescription.SUPPORTED_SDP_VERSION;
        } catch (MalformedURLException | IOException unused) {
            return SessionDescription.SUPPORTED_SDP_VERSION;
        } catch (Exception e) {
            e.printStackTrace();
            return SessionDescription.SUPPORTED_SDP_VERSION;
        }
    }

    private boolean a(String str, Context context) {
        return true;
    }

    private byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & ViewCompat.MEASURED_STATE_MASK) >> 24)};
    }

    private byte[] a(String str) {
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

    private String b(String str) {
        Calendar calendar = Calendar.getInstance();
        return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    private void b(int i) {
        byte[] a2 = a(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.M.add(Byte.valueOf(a2[i2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) {
        c(location);
        h();
    }

    private void c() {
        if (this.N) {
            return;
        }
        this.N = true;
        d(com.baidu.location.h.b.e);
        j();
        d();
    }

    private void c(int i) {
        if (i == 0) {
            return;
        }
        try {
            File file = new File(com.baidu.location.h.n.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.h.n.a);
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
            byte[] bytes2 = (b("%d_%02d_%02d") + ":" + i).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private void c(Location location) {
        if (System.currentTimeMillis() - this.a < this.H || location == null) {
            return;
        }
        if (location != null && location.hasSpeed() && location.getSpeed() > this.E) {
            this.E = location.getSpeed();
        }
        try {
            if (this.M == null) {
                this.M = new ArrayList();
                i();
                d(location);
            } else {
                e(location);
            }
        } catch (Exception unused) {
        }
        this.L++;
    }

    private void c(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.k = jSONObject.getInt("on");
                }
                if (jSONObject.has("bash")) {
                    this.l = jSONObject.getDouble("bash");
                }
                if (jSONObject.has("net")) {
                    this.m = jSONObject.getString("net");
                }
                if (jSONObject.has("tcon")) {
                    this.n = jSONObject.getInt("tcon");
                }
                if (jSONObject.has("tcsh")) {
                    this.o = jSONObject.getInt("tcsh");
                }
                if (jSONObject.has("per")) {
                    this.p = jSONObject.getInt("per");
                }
                if (jSONObject.has("chdron")) {
                    this.q = jSONObject.getInt("chdron");
                }
                if (jSONObject.has("spsh")) {
                    this.r = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.s = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.t = jSONObject.getDouble("stspsh");
                }
                if (jSONObject.has("drstsh")) {
                    this.u = jSONObject.getInt("drstsh");
                }
                if (jSONObject.has("stper")) {
                    this.v = jSONObject.getInt("stper");
                }
                if (jSONObject.has("nondron")) {
                    this.w = jSONObject.getInt("nondron");
                }
                if (jSONObject.has("nondrper")) {
                    this.x = jSONObject.getInt("nondrper");
                }
                if (jSONObject.has("uptime")) {
                    this.z = jSONObject.getLong("uptime");
                }
                k();
            } catch (JSONException unused) {
            }
        }
    }

    private void d() {
        String[] split = "9.4.0.1".split("\\.");
        int length = split.length;
        byte[] bArr = this.J;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.J[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
            } catch (Exception unused) {
            }
        }
        this.K = a(com.baidu.location.h.b.e + ":" + com.baidu.location.h.b.a().c);
    }

    private void d(Location location) {
        this.e = System.currentTimeMillis();
        b((int) (location.getTime() / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        int i = !location.hasBearing() ? 1 : 0;
        int i2 = !location.hasSpeed() ? 1 : 0;
        this.M.add(Byte.valueOf(i > 0 ? (byte) 32 : (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        this.M.add(Byte.valueOf(i2 > 0 ? Byte.MIN_VALUE : (byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        this.b = location;
    }

    private void d(String str) {
        try {
            File file = new File(com.baidu.location.h.n.a + "/grtcf.dat");
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
                    if (str2.contains(b("%d_%02d_%02d")) && str2.contains(":")) {
                        try {
                            String[] split = str2.split(":");
                            if (split.length > 1) {
                                this.y = Integer.valueOf(split[1]).intValue();
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
                            c(str3);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(android.location.Location r22) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.h.e(android.location.Location):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            File file = new File(com.baidu.location.h.n.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.h.n.a);
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
                if (new String(bArr).contains(com.baidu.location.h.b.e)) {
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

    private boolean e() {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        FileLock fileLock = null;
        fileChannel = null;
        RandomAccessFile randomAccessFile2 = null;
        boolean z = false;
        try {
            try {
                File file = new File(com.baidu.location.h.o.f() + File.separator + "gflk.dat");
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

    private boolean f() {
        if (this.B) {
            if (this.C) {
                if (this.E < this.t) {
                    int i = this.D + this.p;
                    this.D = i;
                    if (i > this.u && System.currentTimeMillis() - this.G <= this.v * 1000) {
                        return false;
                    }
                } else {
                    this.D = 0;
                    this.C = false;
                }
            } else if (this.E < this.t) {
                this.C = true;
                this.D = 0;
                this.D = 0 + this.p;
            }
        } else if (this.E >= this.r || this.F >= this.s) {
            this.B = true;
        } else if (this.w != 1 || System.currentTimeMillis() - this.G <= this.x * 1000) {
            return false;
        }
        return true;
    }

    private void g() {
        this.M = null;
        this.e = 0L;
        this.L = 0;
        this.b = null;
        this.c = null;
        this.E = 0.0f;
        this.F = 0.0f;
    }

    private void h() {
        if (this.e == 0 || System.currentTimeMillis() - this.e < this.p * 1000) {
            return;
        }
        if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            g();
            return;
        }
        if (this.n == 1 && !f()) {
            g();
            return;
        }
        if (com.baidu.location.h.b.e.equals("com.ubercab.driver")) {
            if (e()) {
                g();
                return;
            }
        } else if (!a(com.baidu.location.h.b.e, com.baidu.location.f.getServiceContext())) {
            g();
            return;
        }
        List<Byte> list = this.M;
        if (list != null) {
            try {
                int size = list.size();
                this.M.set(0, Byte.valueOf((byte) (size & 255)));
                this.M.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
                this.M.set(3, Byte.valueOf((byte) (this.L & 255)));
                byte[] bArr = new byte[size];
                for (int i = 0; i < size; i++) {
                    bArr[i] = this.M.get(i).byteValue();
                }
                File file = new File(com.baidu.location.h.o.h(), "baidu/tempdata");
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
                        new j(this).start();
                    } catch (Exception unused) {
                    }
                }
                g();
                this.G = System.currentTimeMillis();
            } catch (Exception unused2) {
            }
        }
    }

    private void i() {
        List<Byte> list;
        byte b2;
        this.M.add((byte) 0);
        this.M.add((byte) 0);
        if (f.equals(SessionDescription.SUPPORTED_SDP_VERSION)) {
            list = this.M;
            b2 = -82;
        } else {
            list = this.M;
            b2 = -66;
        }
        list.add(Byte.valueOf(b2));
        this.M.add((byte) 0);
        this.M.add(Byte.valueOf(this.J[0]));
        this.M.add(Byte.valueOf(this.J[1]));
        this.M.add(Byte.valueOf(this.J[2]));
        this.M.add(Byte.valueOf(this.J[3]));
        int length = this.K.length;
        this.M.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.M.add(Byte.valueOf(this.K[i]));
        }
    }

    private void j() {
        if (System.currentTimeMillis() - this.z > 86400000) {
            if (this.A == null) {
                this.A = new b();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(com.baidu.location.h.b.a().a(false));
            stringBuffer.append(com.baidu.location.b.b.a().d());
            this.A.a(stringBuffer.toString());
        }
        k();
    }

    private void k() {
    }

    public void a(Location location) {
        if (!this.N) {
            c();
        }
        boolean z = ((double) com.baidu.location.c.d.a().f()) < this.l * 100.0d;
        if (this.k == 1 && z && this.m.contains(com.baidu.location.f.d.a(com.baidu.location.f.b.a().e()))) {
            if (this.n != 1 || this.y <= this.o) {
                this.I.post(new i(this, location));
            }
        }
    }

    public void b() {
        if (this.N) {
            this.N = false;
            g();
        }
    }
}
