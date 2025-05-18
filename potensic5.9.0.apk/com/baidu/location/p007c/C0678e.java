package com.baidu.location.p007c;

import android.content.SharedPreferences;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p011g.ServiceC0717a;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0722d;
import com.baidu.location.p012h.C0723e;
import com.baidu.location.p012h.C0732n;
import com.baidu.location.p012h.C0733o;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONObject;

/* renamed from: com.baidu.location.c.e */
/* loaded from: classes.dex */
public class C0678e {

    /* renamed from: i */
    private static C0678e f798i;

    /* renamed from: l */
    private static final String f799l = C0732n.f1312a + "/conlts.dat";

    /* renamed from: m */
    private static int f800m = -1;

    /* renamed from: n */
    private static int f801n = -1;

    /* renamed from: o */
    private static int f802o = 0;

    /* renamed from: j */
    private a f811j = null;

    /* renamed from: k */
    private long f812k = 604800;

    /* renamed from: a */
    public boolean f803a = true;

    /* renamed from: b */
    public boolean f804b = true;

    /* renamed from: c */
    public boolean f805c = false;

    /* renamed from: d */
    public boolean f806d = true;

    /* renamed from: e */
    public boolean f807e = true;

    /* renamed from: f */
    public boolean f808f = true;

    /* renamed from: g */
    public boolean f809g = true;

    /* renamed from: h */
    public boolean f810h = false;

    /* renamed from: com.baidu.location.c.e$a */
    class a extends AbstractC0725g {

        /* renamed from: a */
        String f813a = null;

        /* renamed from: b */
        boolean f814b = false;

        /* renamed from: c */
        boolean f815c = false;

        public a() {
            this.f1292k = new HashMap();
        }

        /* renamed from: a */
        public void m676a(String str, boolean z) {
            if (this.f815c) {
                return;
            }
            this.f815c = true;
            this.f813a = str;
            this.f814b = z;
            ExecutorService m592c = C0670x.m590a().m592c();
            if (z) {
                m1130a(m592c, true, "loc.map.baidu.com");
            } else if (m592c != null) {
                m1129a(m592c, C0722d.f1261d);
            } else {
                m1133e(C0722d.f1261d);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo122a(boolean r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L17
                java.lang.String r2 = r1.f1291j
                if (r2 == 0) goto L17
                boolean r2 = r1.f814b
                if (r2 == 0) goto L12
                com.baidu.location.c.e r2 = com.baidu.location.p007c.C0678e.this
                byte[] r0 = r1.f1294m
                com.baidu.location.p007c.C0678e.m661a(r2, r0)
                goto L1d
            L12:
                com.baidu.location.c.e r2 = com.baidu.location.p007c.C0678e.this
                java.lang.String r0 = r1.f1291j
                goto L1a
            L17:
                com.baidu.location.c.e r2 = com.baidu.location.p007c.C0678e.this
                r0 = 0
            L1a:
                com.baidu.location.p007c.C0678e.m660a(r2, r0)
            L1d:
                java.util.Map<java.lang.String, java.lang.Object> r2 = r1.f1292k
                if (r2 == 0) goto L26
                java.util.Map<java.lang.String, java.lang.Object> r2 = r1.f1292k
                r2.clear()
            L26:
                r2 = 0
                r1.f815c = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p007c.C0678e.a.mo122a(boolean):void");
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            Map<String, Object> map;
            String str;
            this.f1290i = 2;
            String encode = Jni.encode(this.f813a);
            this.f813a = null;
            if (this.f814b) {
                map = this.f1292k;
                str = "grid";
            } else {
                map = this.f1292k;
                str = "conf";
            }
            map.put("qt", str);
            this.f1292k.put("req", encode);
        }
    }

    private C0678e() {
    }

    /* renamed from: a */
    public static C0678e m657a() {
        if (f798i == null) {
            f798i = new C0678e();
        }
        return f798i;
    }

    /* renamed from: a */
    private void m658a(int i) {
        this.f803a = (i & 1) == 1;
        this.f804b = (i & 2) == 2;
        this.f805c = (i & 4) == 4;
        this.f806d = (i & 8) == 8;
        this.f808f = (i & 65536) == 65536;
        this.f809g = (i & 131072) == 131072;
        if ((i & 16) == 16) {
            this.f807e = false;
        }
    }

    /* renamed from: a */
    private void m662a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        boolean z = true;
        try {
            if (jSONObject.has("ipen") && jSONObject.getInt("ipen") == 0) {
                z = false;
            }
            int i = jSONObject.has("ipvt") ? jSONObject.getInt("ipvt") : 14400000;
            int i2 = jSONObject.has("ipvn") ? jSONObject.getInt("ipvn") : 10;
            SharedPreferences.Editor edit = ServiceC0702f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0).edit();
            edit.putBoolean("ipLocInfoUpload", z);
            edit.putInt("ipValidTime", i);
            edit.putInt("ipLocInfoUploadTimesPerDay", i2);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m663a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            try {
                if (bArr.length < 640) {
                    C0733o.f1407w = false;
                    C0733o.f1404t = C0733o.f1402r + 0.025d;
                    C0733o.f1403s = C0733o.f1401q - 0.025d;
                } else {
                    C0733o.f1407w = true;
                    C0733o.f1403s = Double.longBitsToDouble(((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[0] & 255));
                    C0733o.f1404t = Double.longBitsToDouble(((bArr[15] & 255) << 56) | ((bArr[14] & 255) << 48) | ((bArr[13] & 255) << 40) | ((bArr[12] & 255) << 32) | ((bArr[11] & 255) << 24) | ((bArr[10] & 255) << 16) | ((bArr[9] & 255) << 8) | (255 & bArr[8]));
                    C0733o.f1406v = new byte[625];
                    while (i < 625) {
                        C0733o.f1406v[i] = bArr[i + 16];
                        i++;
                    }
                }
                i = 1;
            } catch (Exception unused) {
                return;
            }
        }
        if (i != 0) {
            m669g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[Catch: Exception -> 0x0409, TRY_LEAVE, TryCatch #0 {Exception -> 0x0409, blocks: (B:13:0x0033, B:15:0x0041, B:17:0x0050, B:20:0x005d, B:22:0x006a, B:24:0x006e, B:26:0x0076, B:27:0x007e, B:29:0x0082, B:31:0x008a, B:32:0x0092, B:34:0x0096, B:36:0x009e, B:37:0x00a6, B:39:0x00ab, B:41:0x00b3, B:42:0x00bb, B:44:0x00c0, B:46:0x00c8, B:47:0x00d0, B:49:0x00d5, B:51:0x00dd, B:52:0x00e5, B:54:0x00ea, B:56:0x00f2, B:57:0x00fa, B:59:0x00ff, B:61:0x0107, B:62:0x010f, B:64:0x0115, B:66:0x011d, B:67:0x0125, B:69:0x012b, B:71:0x0133, B:72:0x013b, B:74:0x013f, B:76:0x0147, B:77:0x014f, B:79:0x0155, B:81:0x0161, B:83:0x0165, B:85:0x016d, B:86:0x0175, B:88:0x0179, B:90:0x0181, B:91:0x0189, B:93:0x018e, B:95:0x0196, B:96:0x019e, B:98:0x01a3, B:100:0x01ab, B:101:0x01b3, B:103:0x01b9, B:105:0x01c5, B:107:0x01c9, B:109:0x01d1, B:110:0x01d9, B:112:0x01dd, B:114:0x01e5, B:115:0x01ed, B:117:0x01f2, B:119:0x01fa, B:120:0x0202, B:122:0x0207, B:124:0x020f, B:125:0x0217, B:127:0x021d, B:129:0x0229, B:131:0x022d, B:133:0x0235, B:134:0x023d, B:136:0x0241, B:138:0x0249, B:139:0x0251, B:141:0x0256, B:143:0x025e, B:144:0x0266, B:146:0x026b, B:148:0x0273, B:149:0x027b, B:151:0x0281, B:153:0x028d, B:155:0x0291, B:157:0x0299, B:158:0x02a1, B:160:0x02a5, B:162:0x02ad, B:163:0x02b5, B:165:0x02ba, B:167:0x02c2, B:168:0x02ca, B:170:0x02cf, B:172:0x02d7, B:173:0x02df, B:175:0x02e4, B:177:0x02ec, B:178:0x02f4, B:180:0x02fa, B:182:0x0306, B:184:0x030a, B:186:0x0312, B:188:0x031a, B:189:0x031d, B:190:0x031f, B:192:0x0323, B:194:0x032b, B:196:0x0333, B:197:0x0336, B:198:0x0338, B:200:0x033d, B:202:0x0345, B:203:0x034d, B:205:0x0352, B:207:0x035a, B:208:0x0362, B:210:0x0367, B:212:0x036f, B:214:0x0377, B:215:0x038b, B:216:0x038d, B:218:0x0392, B:220:0x039a, B:221:0x03a2, B:223:0x03a8, B:225:0x03b4, B:227:0x03b8, B:229:0x03c0, B:230:0x03c8, B:232:0x03cc, B:234:0x03d4, B:235:0x03dc, B:237:0x03e1, B:239:0x03e9, B:240:0x03f1, B:242:0x03f9), top: B:12:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m664a(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p007c.C0678e.m664a(java.lang.String):boolean");
    }

    /* renamed from: b */
    private void m665b(int i) {
        File file = new File(f799l);
        if (!file.exists()) {
            m671i();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(4L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.seek((readInt * f802o) + 128);
            byte[] bytes = (C0720b.f1244e + (char) 0).getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i);
            if (readInt2 == f802o) {
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m666b(String str) {
        f801n = -1;
        if (str != null) {
            try {
                if (m664a(str)) {
                    m668f();
                }
            } catch (Exception unused) {
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ctr")) {
                    f801n = Integer.parseInt(jSONObject.getString("ctr"));
                }
            } catch (Exception unused2) {
            }
            try {
                m672j();
                int i = f801n;
                if (i != -1) {
                    m665b(i);
                } else {
                    i = f800m;
                    if (i == -1) {
                        i = -1;
                    }
                }
                if (i != -1) {
                    m658a(i);
                }
            } catch (Exception unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m667e() {
        String str = "&ver=" + C0733o.f1408x + "&usr=" + C0720b.m1100a().m1105b() + "&app=" + C0720b.f1244e + "&prod=" + C0720b.f1245f;
        if (this.f811j == null) {
            this.f811j = new a();
        }
        if (C0733o.m1152b()) {
            return;
        }
        this.f811j.m676a(str, false);
    }

    /* renamed from: f */
    private void m668f() {
        String str = C0732n.f1312a + "/config.dat";
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", Integer.valueOf(C0733o.f1408x), Float.valueOf(C0733o.f1409y), Float.valueOf(C0733o.f1410z), Float.valueOf(C0733o.f1314A), Float.valueOf(C0733o.f1315B), Integer.valueOf(C0733o.f1316C), Integer.valueOf(C0733o.f1317D), Integer.valueOf(C0733o.f1318E), Integer.valueOf(C0733o.f1319F), Integer.valueOf(C0733o.f1320G), Integer.valueOf(C0733o.f1321H), Integer.valueOf(C0733o.f1322I), Float.valueOf(C0733o.f1323J), Float.valueOf(C0733o.f1324K), Float.valueOf(C0733o.f1325L), Float.valueOf(C0733o.f1326M), Integer.valueOf(C0733o.f1327N), Float.valueOf(C0733o.f1329P), Integer.valueOf(C0733o.f1330Q), Float.valueOf(C0733o.f1331R), Float.valueOf(C0733o.f1332S), Float.valueOf(C0733o.f1333T), Integer.valueOf(C0733o.f1334U), Integer.valueOf(C0733o.f1335V), Integer.valueOf(C0733o.f1360aa ? 1 : 0), Integer.valueOf(C0733o.f1361ab ? 1 : 0), Integer.valueOf(C0733o.f1362ac), Integer.valueOf(C0733o.f1364ae), Long.valueOf(C0733o.f1370ak), Integer.valueOf(C0733o.f1373an), Float.valueOf(C0733o.f1377ar), Float.valueOf(C0733o.f1378as), Integer.valueOf(C0733o.f1379at), Integer.valueOf(C0733o.f1380au), Integer.valueOf(C0733o.f1381av), Integer.valueOf(C0733o.f1374ao), Integer.valueOf(C0733o.f1375ap), Float.valueOf(C0733o.f1376aq), Integer.valueOf(C0733o.f1372am)).getBytes();
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(C0732n.f1312a);
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

    /* renamed from: g */
    private void m669g() {
        try {
            File file = new File(C0732n.f1312a + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(C0732n.f1312a);
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
            randomAccessFile2.writeDouble(C0733o.f1403s);
            randomAccessFile2.writeDouble(C0733o.f1404t);
            randomAccessFile2.writeBoolean(C0733o.f1407w);
            if (C0733o.f1407w && C0733o.f1406v != null) {
                randomAccessFile2.write(C0733o.f1406v);
            }
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: h */
    private void m670h() {
        try {
            File file = new File(C0732n.f1312a + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2L);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    m664a(new String(bArr));
                }
                randomAccessFile.seek(1L);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(1024L);
                    C0733o.f1403s = randomAccessFile.readDouble();
                    C0733o.f1404t = randomAccessFile.readDouble();
                    C0733o.f1407w = randomAccessFile.readBoolean();
                    if (C0733o.f1407w) {
                        C0733o.f1406v = new byte[625];
                        randomAccessFile.read(C0733o.f1406v, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
        if (C0733o.f1399o) {
            boolean z = ServiceC0702f.isServing;
        }
    }

    /* renamed from: i */
    private void m671i() {
        try {
            File file = new File(f799l);
            if (file.exists()) {
                return;
            }
            File file2 = new File(C0732n.f1312a);
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

    /* renamed from: j */
    private void m672j() {
        try {
            File file = new File(f799l);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                randomAccessFile.seek(4L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 3000) {
                    randomAccessFile.close();
                    f802o = 0;
                    m671i();
                    return;
                }
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.seek(128L);
                byte[] bArr = new byte[readInt];
                int i = 0;
                while (true) {
                    if (i >= readInt2) {
                        break;
                    }
                    randomAccessFile.seek((readInt * i) + 128);
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 > 0 && readInt3 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt3);
                        int i2 = readInt3 - 1;
                        if (bArr[i2] == 0) {
                            String str = new String(bArr, 0, i2);
                            C0720b.m1100a();
                            if (str.equals(C0720b.f1244e)) {
                                f800m = randomAccessFile.readInt();
                                f802o = i;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (i == readInt2) {
                    f802o = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void m673b() {
        m670h();
    }

    /* renamed from: c */
    public void m674c() {
    }

    /* renamed from: d */
    public void m675d() {
        if (System.currentTimeMillis() - C0723e.m1117a().m1122c() > this.f812k * 1000) {
            C0723e.m1117a().m1121b(System.currentTimeMillis());
            ServiceC0717a.m1087a().postDelayed(new RunnableC0679f(this), 1000L);
        }
    }
}