package com.baidu.location.c;

import android.content.SharedPreferences;
import com.baidu.location.Jni;
import com.baidu.location.b.x;
import com.baidu.location.h.n;
import com.baidu.location.h.o;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {
    private static e i;
    private static final String l = n.a + "/conlts.dat";
    private static int m = -1;
    private static int n = -1;
    private static int o = 0;
    private a j = null;
    private long k = 604800;
    public boolean a = true;
    public boolean b = true;
    public boolean c = false;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    public boolean g = true;
    public boolean h = false;

    class a extends com.baidu.location.h.g {
        String a = null;
        boolean b = false;
        boolean c = false;

        public a() {
            this.k = new HashMap();
        }

        public void a(String str, boolean z) {
            if (this.c) {
                return;
            }
            this.c = true;
            this.a = str;
            this.b = z;
            ExecutorService c = x.a().c();
            if (z) {
                a(c, true, "loc.map.baidu.com");
            } else if (c != null) {
                a(c, com.baidu.location.h.d.d);
            } else {
                e(com.baidu.location.h.d.d);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
        @Override // com.baidu.location.h.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(boolean r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L17
                java.lang.String r2 = r1.j
                if (r2 == 0) goto L17
                boolean r2 = r1.b
                if (r2 == 0) goto L12
                com.baidu.location.c.e r2 = com.baidu.location.c.e.this
                byte[] r0 = r1.m
                com.baidu.location.c.e.a(r2, r0)
                goto L1d
            L12:
                com.baidu.location.c.e r2 = com.baidu.location.c.e.this
                java.lang.String r0 = r1.j
                goto L1a
            L17:
                com.baidu.location.c.e r2 = com.baidu.location.c.e.this
                r0 = 0
            L1a:
                com.baidu.location.c.e.a(r2, r0)
            L1d:
                java.util.Map<java.lang.String, java.lang.Object> r2 = r1.k
                if (r2 == 0) goto L26
                java.util.Map<java.lang.String, java.lang.Object> r2 = r1.k
                r2.clear()
            L26:
                r2 = 0
                r1.c = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.e.a.a(boolean):void");
        }

        @Override // com.baidu.location.h.g
        public void b() {
            Map<String, Object> map;
            String str;
            this.i = 2;
            String encode = Jni.encode(this.a);
            this.a = null;
            if (this.b) {
                map = this.k;
                str = "grid";
            } else {
                map = this.k;
                str = "conf";
            }
            map.put("qt", str);
            this.k.put("req", encode);
        }
    }

    private e() {
    }

    public static e a() {
        if (i == null) {
            i = new e();
        }
        return i;
    }

    private void a(int i2) {
        this.a = (i2 & 1) == 1;
        this.b = (i2 & 2) == 2;
        this.c = (i2 & 4) == 4;
        this.d = (i2 & 8) == 8;
        this.f = (i2 & 65536) == 65536;
        this.g = (i2 & 131072) == 131072;
        if ((i2 & 16) == 16) {
            this.e = false;
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        boolean z = true;
        try {
            if (jSONObject.has("ipen") && jSONObject.getInt("ipen") == 0) {
                z = false;
            }
            int i2 = jSONObject.has("ipvt") ? jSONObject.getInt("ipvt") : 14400000;
            int i3 = jSONObject.has("ipvn") ? jSONObject.getInt("ipvn") : 10;
            SharedPreferences.Editor edit = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0).edit();
            edit.putBoolean("ipLocInfoUpload", z);
            edit.putInt("ipValidTime", i2);
            edit.putInt("ipLocInfoUploadTimesPerDay", i3);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        int i2 = 0;
        if (bArr != null) {
            try {
                if (bArr.length < 640) {
                    o.w = false;
                    o.t = o.r + 0.025d;
                    o.s = o.q - 0.025d;
                } else {
                    o.w = true;
                    o.s = Double.longBitsToDouble(((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[0] & 255));
                    o.t = Double.longBitsToDouble(((bArr[15] & 255) << 56) | ((bArr[14] & 255) << 48) | ((bArr[13] & 255) << 40) | ((bArr[12] & 255) << 32) | ((bArr[11] & 255) << 24) | ((bArr[10] & 255) << 16) | ((bArr[9] & 255) << 8) | (255 & bArr[8]));
                    o.v = new byte[625];
                    while (i2 < 625) {
                        o.v[i2] = bArr[i2 + 16];
                        i2++;
                    }
                }
                i2 = 1;
            } catch (Exception unused) {
                return;
            }
        }
        if (i2 != 0) {
            g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[Catch: Exception -> 0x0409, TRY_LEAVE, TryCatch #0 {Exception -> 0x0409, blocks: (B:13:0x0033, B:15:0x0041, B:17:0x0050, B:20:0x005d, B:22:0x006a, B:24:0x006e, B:26:0x0076, B:27:0x007e, B:29:0x0082, B:31:0x008a, B:32:0x0092, B:34:0x0096, B:36:0x009e, B:37:0x00a6, B:39:0x00ab, B:41:0x00b3, B:42:0x00bb, B:44:0x00c0, B:46:0x00c8, B:47:0x00d0, B:49:0x00d5, B:51:0x00dd, B:52:0x00e5, B:54:0x00ea, B:56:0x00f2, B:57:0x00fa, B:59:0x00ff, B:61:0x0107, B:62:0x010f, B:64:0x0115, B:66:0x011d, B:67:0x0125, B:69:0x012b, B:71:0x0133, B:72:0x013b, B:74:0x013f, B:76:0x0147, B:77:0x014f, B:79:0x0155, B:81:0x0161, B:83:0x0165, B:85:0x016d, B:86:0x0175, B:88:0x0179, B:90:0x0181, B:91:0x0189, B:93:0x018e, B:95:0x0196, B:96:0x019e, B:98:0x01a3, B:100:0x01ab, B:101:0x01b3, B:103:0x01b9, B:105:0x01c5, B:107:0x01c9, B:109:0x01d1, B:110:0x01d9, B:112:0x01dd, B:114:0x01e5, B:115:0x01ed, B:117:0x01f2, B:119:0x01fa, B:120:0x0202, B:122:0x0207, B:124:0x020f, B:125:0x0217, B:127:0x021d, B:129:0x0229, B:131:0x022d, B:133:0x0235, B:134:0x023d, B:136:0x0241, B:138:0x0249, B:139:0x0251, B:141:0x0256, B:143:0x025e, B:144:0x0266, B:146:0x026b, B:148:0x0273, B:149:0x027b, B:151:0x0281, B:153:0x028d, B:155:0x0291, B:157:0x0299, B:158:0x02a1, B:160:0x02a5, B:162:0x02ad, B:163:0x02b5, B:165:0x02ba, B:167:0x02c2, B:168:0x02ca, B:170:0x02cf, B:172:0x02d7, B:173:0x02df, B:175:0x02e4, B:177:0x02ec, B:178:0x02f4, B:180:0x02fa, B:182:0x0306, B:184:0x030a, B:186:0x0312, B:188:0x031a, B:189:0x031d, B:190:0x031f, B:192:0x0323, B:194:0x032b, B:196:0x0333, B:197:0x0336, B:198:0x0338, B:200:0x033d, B:202:0x0345, B:203:0x034d, B:205:0x0352, B:207:0x035a, B:208:0x0362, B:210:0x0367, B:212:0x036f, B:214:0x0377, B:215:0x038b, B:216:0x038d, B:218:0x0392, B:220:0x039a, B:221:0x03a2, B:223:0x03a8, B:225:0x03b4, B:227:0x03b8, B:229:0x03c0, B:230:0x03c8, B:232:0x03cc, B:234:0x03d4, B:235:0x03dc, B:237:0x03e1, B:239:0x03e9, B:240:0x03f1, B:242:0x03f9), top: B:12:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.e.a(java.lang.String):boolean");
    }

    private void b(int i2) {
        File file = new File(l);
        if (!file.exists()) {
            i();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(4L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.seek((readInt * o) + 128);
            byte[] bytes = (com.baidu.location.h.b.e + (char) 0).getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i2);
            if (readInt2 == o) {
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        n = -1;
        if (str != null) {
            try {
                if (a(str)) {
                    f();
                }
            } catch (Exception unused) {
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ctr")) {
                    n = Integer.parseInt(jSONObject.getString("ctr"));
                }
            } catch (Exception unused2) {
            }
            try {
                j();
                int i2 = n;
                if (i2 != -1) {
                    b(i2);
                } else {
                    i2 = m;
                    if (i2 == -1) {
                        i2 = -1;
                    }
                }
                if (i2 != -1) {
                    a(i2);
                }
            } catch (Exception unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String str = "&ver=" + o.x + "&usr=" + com.baidu.location.h.b.a().b() + "&app=" + com.baidu.location.h.b.e + "&prod=" + com.baidu.location.h.b.f;
        if (this.j == null) {
            this.j = new a();
        }
        if (o.b()) {
            return;
        }
        this.j.a(str, false);
    }

    private void f() {
        String str = n.a + "/config.dat";
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", Integer.valueOf(o.x), Float.valueOf(o.y), Float.valueOf(o.z), Float.valueOf(o.A), Float.valueOf(o.B), Integer.valueOf(o.C), Integer.valueOf(o.D), Integer.valueOf(o.E), Integer.valueOf(o.F), Integer.valueOf(o.G), Integer.valueOf(o.H), Integer.valueOf(o.I), Float.valueOf(o.J), Float.valueOf(o.K), Float.valueOf(o.L), Float.valueOf(o.M), Integer.valueOf(o.N), Float.valueOf(o.P), Integer.valueOf(o.Q), Float.valueOf(o.R), Float.valueOf(o.S), Float.valueOf(o.T), Integer.valueOf(o.U), Integer.valueOf(o.V), Integer.valueOf(o.aa ? 1 : 0), Integer.valueOf(o.ab ? 1 : 0), Integer.valueOf(o.ac), Integer.valueOf(o.ae), Long.valueOf(o.ak), Integer.valueOf(o.an), Float.valueOf(o.ar), Float.valueOf(o.as), Integer.valueOf(o.at), Integer.valueOf(o.au), Integer.valueOf(o.av), Integer.valueOf(o.ao), Integer.valueOf(o.ap), Float.valueOf(o.aq), Integer.valueOf(o.am)).getBytes();
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(n.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(0L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile2.seek(0L);
            randomAccessFile2.writeBoolean(true);
            randomAccessFile2.seek(2L);
            randomAccessFile2.writeInt(bytes.length);
            randomAccessFile2.write(bytes);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private void g() {
        try {
            File file = new File(n.a + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(n.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(0L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile2.seek(1L);
            randomAccessFile2.writeBoolean(true);
            randomAccessFile2.seek(1024L);
            randomAccessFile2.writeDouble(o.s);
            randomAccessFile2.writeDouble(o.t);
            randomAccessFile2.writeBoolean(o.w);
            if (o.w && o.v != null) {
                randomAccessFile2.write(o.v);
            }
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private void h() {
        try {
            File file = new File(n.a + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2L);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    a(new String(bArr));
                }
                randomAccessFile.seek(1L);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(1024L);
                    o.s = randomAccessFile.readDouble();
                    o.t = randomAccessFile.readDouble();
                    o.w = randomAccessFile.readBoolean();
                    if (o.w) {
                        o.v = new byte[625];
                        randomAccessFile.read(o.v, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
        if (o.o) {
            boolean z = com.baidu.location.f.isServing;
        }
    }

    private void i() {
        try {
            File file = new File(l);
            if (file.exists()) {
                return;
            }
            File file2 = new File(n.a);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(128);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    private void j() {
        try {
            File file = new File(l);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(4L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 3000) {
                    randomAccessFile.close();
                    o = 0;
                    i();
                    return;
                }
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.seek(128L);
                byte[] bArr = new byte[readInt];
                int i2 = 0;
                while (true) {
                    if (i2 >= readInt2) {
                        break;
                    }
                    randomAccessFile.seek((readInt * i2) + 128);
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 > 0 && readInt3 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt3);
                        int i3 = readInt3 - 1;
                        if (bArr[i3] == 0) {
                            String str = new String(bArr, 0, i3);
                            com.baidu.location.h.b.a();
                            if (str.equals(com.baidu.location.h.b.e)) {
                                m = randomAccessFile.readInt();
                                o = i2;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i2++;
                }
                if (i2 == readInt2) {
                    o = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        h();
    }

    public void c() {
    }

    public void d() {
        if (System.currentTimeMillis() - com.baidu.location.h.e.a().c() > this.k * 1000) {
            com.baidu.location.h.e.a().b(System.currentTimeMillis());
            com.baidu.location.g.a.a().postDelayed(new f(this), 1000L);
        }
    }
}
