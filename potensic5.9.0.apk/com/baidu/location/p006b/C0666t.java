package com.baidu.location.p006b;

import android.location.GnssNavigationMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.poi.p043ss.usermodel.DateUtil;

/* renamed from: com.baidu.location.b.t */
/* loaded from: classes.dex */
public class C0666t {

    /* renamed from: a */
    private static final double[] f680a = {1999.0d, 8.0d, 22.0d, 0.0d, 0.0d, 0.0d};

    /* renamed from: b */
    private HashMap<String, c> f681b = new HashMap<>();

    /* renamed from: c */
    private HashMap<String, String> f682c = new HashMap<>();

    /* renamed from: com.baidu.location.b.t$a */
    private static class a {

        /* renamed from: a */
        private static C0666t f683a = new C0666t();
    }

    /* renamed from: com.baidu.location.b.t$b */
    private class b {

        /* renamed from: a */
        int f684a = 0;

        /* renamed from: b */
        double f685b = 0.0d;

        public b() {
        }
    }

    /* renamed from: com.baidu.location.b.t$c */
    private class c {

        /* renamed from: b */
        private boolean f688b;

        /* renamed from: c */
        private boolean f689c;

        /* renamed from: d */
        private long f690d;

        /* renamed from: e */
        private int f691e;

        /* renamed from: f */
        private int f692f;

        /* renamed from: g */
        private ArrayList<String> f693g;

        /* renamed from: h */
        private ArrayList<Integer> f694h;

        /* renamed from: i */
        private int f695i;

        /* renamed from: j */
        private double f696j;

        /* renamed from: k */
        private double f697k;

        /* renamed from: l */
        private double f698l;

        /* renamed from: m */
        private int f699m;

        /* renamed from: n */
        private int f700n;

        /* renamed from: o */
        private b f701o;

        public c(int i, int i2) {
            m559a(i, i2);
            this.f695i = 0;
            this.f696j = 0.0d;
            this.f697k = 0.0d;
            this.f698l = 0.0d;
            this.f699m = 0;
            this.f700n = 0;
            this.f701o = C0666t.this.new b();
        }

        /* renamed from: a */
        private b m554a(int i, double d) {
            b m555a = m555a(C0666t.f680a);
            if (d < -1.0E9d || 1.0E9d < d) {
                d = 0.0d;
            }
            int i2 = (int) d;
            m555a.f684a += (i * 604800) + i2;
            m555a.f685b = d - i2;
            return m555a;
        }

        /* renamed from: a */
        private b m555a(double[] dArr) {
            int[] iArr = {1, 32, 60, 91, 121, 152, 182, FTPReply.FILE_STATUS, 244, 274, 305, 335};
            b bVar = C0666t.this.new b();
            int i = 0;
            int i2 = (int) dArr[0];
            int i3 = (int) dArr[1];
            int i4 = (int) dArr[2];
            if (i2 >= 1970 && 2099 >= i2 && i3 >= 1 && 12 >= i3) {
                int i5 = (((((i2 - 1970) * 365) + ((i2 - 1969) / 4)) + iArr[i3 - 1]) + i4) - 2;
                if (i2 % 4 == 0 && i3 >= 3) {
                    i = 1;
                }
                int floor = (int) Math.floor(dArr[5]);
                bVar.f684a = ((i5 + i) * DateUtil.SECONDS_PER_DAY) + (((int) dArr[3]) * 3600) + (((int) dArr[4]) * 60) + floor;
                bVar.f685b = dArr[5] - floor;
            }
            return bVar;
        }

        /* renamed from: a */
        private String m556a(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            for (byte b : gnssNavigationMessage.getData()) {
                sb.append(String.format("%8s", Integer.toBinaryString(b & 255)).replace(' ', '0'));
            }
            return sb.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m558a() {
            /*
                r5 = this;
                java.util.ArrayList<java.lang.String> r0 = r5.f693g
                int r0 = r0.size()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L29
                r0 = r2
            Lb:
                java.util.ArrayList<java.lang.String> r3 = r5.f693g
                int r3 = r3.size()
                if (r0 >= r3) goto L27
                java.util.ArrayList<java.lang.String> r3 = r5.f693g
                java.lang.Object r3 = r3.get(r0)
                java.lang.String r3 = (java.lang.String) r3
                java.lang.String r4 = "None"
                boolean r3 = r3.contains(r4)
                if (r3 == 0) goto L24
                goto L29
            L24:
                int r0 = r0 + 1
                goto Lb
            L27:
                r0 = r1
                goto L2a
            L29:
                r0 = r2
            L2a:
                if (r0 == 0) goto L2f
                r5.f689c = r1
                goto L31
            L2f:
                r5.f689c = r2
            L31:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0666t.c.m558a():void");
        }

        /* renamed from: a */
        private void m559a(int i, int i2) {
            int i3 = this.f692f;
            int i4 = 5;
            if (i3 != 257 && i3 != 769) {
                i4 = i3 != 1537 ? i3 != 1281 ? i3 != 1282 ? 0 : 10 : 3 : 6;
            }
            ArrayList<String> arrayList = this.f693g;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                this.f693g = new ArrayList<>();
            }
            ArrayList<Integer> arrayList2 = this.f694h;
            if (arrayList2 != null) {
                arrayList2.clear();
            } else {
                this.f694h = new ArrayList<>();
            }
            for (int i5 = 0; i5 < i4; i5++) {
                this.f693g.add("None");
            }
            this.f691e = i;
            this.f692f = i2;
            this.f688b = false;
            this.f689c = false;
            this.f690d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m560a(GnssNavigationMessage gnssNavigationMessage, long j) {
            int type = gnssNavigationMessage.getType();
            int svid = gnssNavigationMessage.getSvid();
            int submessageId = gnssNavigationMessage.getSubmessageId();
            byte[] data = gnssNavigationMessage.getData();
            if (j - this.f690d > 1200 || this.f688b || this.f693g.size() == 0 || type != this.f692f || svid != this.f691e) {
                m559a(svid, type);
            }
            if ((type == 1282 || type == 1281) && !m565b()) {
                m559a(svid, type);
            }
            if (this.f693g.size() == 0) {
                return;
            }
            int i = this.f692f;
            boolean z = true;
            int i2 = i == 1537 ? 0 : 1;
            if (i == 1282) {
                if (submessageId != 1) {
                    return;
                }
                m570e(m563b(gnssNavigationMessage));
                submessageId = this.f699m;
            }
            int i3 = submessageId - i2;
            if (i3 >= this.f693g.size()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append((int) b);
            }
            this.f693g.set(i3, sb.toString());
            if (type == 1281 || type == 1282) {
                this.f694h.add(Integer.valueOf(i3));
            }
            if (this.f692f == 1537) {
                m562a(m556a(gnssNavigationMessage));
            }
            m558a();
            this.f690d = j;
        }

        /* renamed from: a */
        private void m562a(String str) {
            StringBuilder append;
            int i;
            char charAt = str.charAt(0);
            char charAt2 = str.charAt(120);
            if (charAt == '1' && charAt2 == '0') {
                append = new StringBuilder().append(str.substring(2, 18));
                i = FTPReply.SECURITY_DATA_EXCHANGE_COMPLETE;
            } else {
                if (charAt != '0' || charAt2 != '1') {
                    return;
                }
                append = new StringBuilder().append(str.substring(2, 114));
                i = 138;
            }
            String sb = append.append(str.substring(122, i)).toString();
            int parseInt = Integer.parseInt(sb.substring(0, 6), 2);
            if (parseInt == 0) {
                m564b(sb);
            } else if (parseInt == 1) {
                m567c(sb);
            } else if (parseInt == 4) {
                m569d(sb);
            }
        }

        /* renamed from: b */
        private String m563b(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            byte[] data = gnssNavigationMessage.getData();
            int length = data.length;
            for (int i = 0; i < length; i++) {
                String replace = String.format("%8s", Integer.toBinaryString(data[i] & 255)).replace(' ', '0');
                if (i % 4 == 0) {
                    replace = replace.substring(2, 8);
                }
                sb.append(replace);
            }
            return sb.toString();
        }

        /* renamed from: b */
        private void m564b(String str) {
            this.f695i = Integer.parseInt(str.substring(96, 108), 2);
            this.f696j = Long.parseLong(str.substring(108, 128), 2);
        }

        /* renamed from: b */
        private boolean m565b() {
            if (this.f694h == null) {
                return false;
            }
            for (int i = 0; i < this.f694h.size(); i++) {
                if (this.f694h.get(i).intValue() != i) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public String m566c() {
            StringBuilder sb = new StringBuilder();
            if (!this.f689c) {
                return sb.toString();
            }
            if (this.f692f == 1537) {
                m568d();
            }
            sb.append(this.f701o.f684a);
            sb.append('|');
            boolean z = true;
            for (int i = 0; i < this.f693g.size(); i++) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(this.f693g.get(i));
            }
            this.f688b = true;
            return sb.toString();
        }

        /* renamed from: c */
        private void m567c(String str) {
            this.f697k = Long.parseLong(str.substring(16, 30), 2) * 60.0d;
        }

        /* renamed from: d */
        private void m568d() {
            int i;
            b m554a = m554a(this.f695i, this.f696j);
            double d = ((r1.f684a - m554a.f684a) + m554a(this.f695i, this.f697k).f685b) - m554a.f685b;
            if (d <= 302400.0d) {
                if (d < -302400.0d) {
                    i = this.f695i + 1;
                }
                this.f701o = m554a(this.f695i, this.f698l);
                this.f700n = this.f695i + 1024;
            }
            i = this.f695i - 1;
            this.f695i = i;
            this.f701o = m554a(this.f695i, this.f698l);
            this.f700n = this.f695i + 1024;
        }

        /* renamed from: d */
        private void m569d(String str) {
            this.f698l = Long.parseLong(str.substring(54, 68), 2) * 60;
        }

        /* renamed from: e */
        private void m570e(String str) {
            this.f699m = Integer.parseInt(str.substring(42, 46), 2);
        }
    }

    /* renamed from: a */
    public static C0666t m549a() {
        return a.f683a;
    }

    /* renamed from: a */
    public void m551a(GnssNavigationMessage gnssNavigationMessage, long j) {
        HashMap<String, c> hashMap;
        int svid = gnssNavigationMessage.getSvid();
        int type = gnssNavigationMessage.getType();
        String str = (type != 257 ? type != 769 ? type != 1537 ? type != 1281 ? type != 1282 ? "none" : "CT" : "CO" : "E" : "R" : "G") + svid;
        if (str.contains("none") || (hashMap = this.f681b) == null) {
            return;
        }
        if (!hashMap.containsKey(str)) {
            this.f681b.put(str, new c(svid, type));
        }
        this.f681b.get(str).m560a(gnssNavigationMessage, j);
    }

    /* renamed from: b */
    public ArrayList<String> m552b() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, c> entry : this.f681b.entrySet()) {
            String key = entry.getKey();
            String m566c = entry.getValue().m566c();
            if (m566c != null && m566c.length() != 0) {
                if (this.f682c.containsKey(key)) {
                    if (m566c.substring(0, 100).equals(this.f682c.get(key).substring(0, 100))) {
                    }
                } else {
                    this.f682c.put(key, m566c);
                }
                arrayList.add(key + '|' + m566c);
            }
        }
        return arrayList;
    }
}