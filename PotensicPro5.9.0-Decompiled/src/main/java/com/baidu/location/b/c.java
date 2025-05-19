package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Base64;
import com.baidu.location.BDLocation;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class c {
    private SharedPreferences a = null;
    private boolean b = false;
    private Deque<String> c = new LinkedList();
    private Deque<String> d = new LinkedList();
    private Deque<String> e = new LinkedList();
    private int f = 5;
    private int g = 5;
    private int h = 1;
    private int i = 1;

    private static class a {
        private static c a = new c();
    }

    public static c a() {
        return a.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(int r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            java.lang.String r1 = ""
            if (r5 != r0) goto L25
            java.util.Deque<java.lang.String> r5 = r4.e
            java.lang.String r5 = r4.c(r5)
            boolean r2 = r1.equals(r5)
            if (r2 != 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "&ll_pre="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r5 = r2.append(r5)
            java.lang.String r5 = r5.toString()
            goto L26
        L25:
            r5 = r1
        L26:
            if (r6 != r0) goto L6e
            java.util.Deque<java.lang.String> r6 = r4.c
            java.lang.String r6 = r4.b(r6)
            boolean r0 = r1.equals(r6)
            if (r0 != 0) goto L4b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r0 = "&cl_pre="
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
        L4b:
            java.util.Deque<java.lang.String> r6 = r4.d
            java.lang.String r6 = r4.b(r6)
            boolean r0 = r1.equals(r6)
            if (r0 != 0) goto L6e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r0 = "&wf_pre="
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
        L6e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.c.a(int, int):java.lang.String");
    }

    private void a(String str, Deque<String> deque) {
        if (str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    private void a(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.g) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = deque.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i != deque.size() - 1) {
                sb.append("|");
            }
            i++;
        }
        try {
            String str = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("ll_pre", str);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    private void a(Deque<String> deque, String str) {
        if (deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.f) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = deque.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i != deque.size() - 1) {
                sb.append("|");
            }
            i++;
        }
        try {
            String str2 = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString(str + "_pre", str2);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    private String b(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String peekFirst = deque.peekFirst();
        if (peekFirst != null) {
            try {
                String[] split = peekFirst.split(",");
                int i = 0;
                for (String str : deque) {
                    if (split.length != 3) {
                        break;
                    }
                    String[] split2 = str.split(",");
                    if (i == 0) {
                        sb.append(peekFirst);
                    } else if (split2.length != 3) {
                        i++;
                    } else {
                        try {
                            sb.append((int) ((Double.parseDouble(split[0]) - Double.parseDouble(split2[0])) * Math.pow(10.0d, 6.0d))).append(",").append((int) (Math.pow(10.0d, 6.0d) * (Double.parseDouble(split[1]) - Double.parseDouble(split2[1])))).append(",").append(Long.parseLong(split[2]) - Long.parseLong(split2[2]));
                        } catch (Exception unused) {
                        }
                    }
                    if (i != deque.size() - 1) {
                        sb.append("|");
                    }
                    i++;
                }
            } catch (Exception unused2) {
            }
        }
        return sb.toString();
    }

    private void b(String str, Deque<String> deque) {
        if (str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0110 A[Catch: Exception -> 0x011b, TRY_LEAVE, TryCatch #1 {Exception -> 0x011b, blocks: (B:11:0x0019, B:12:0x0023, B:14:0x0029, B:16:0x0035, B:40:0x003c, B:25:0x0108, B:27:0x0110, B:18:0x0042), top: B:10:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c(java.util.Deque<java.lang.String> r19) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.c.c(java.util.Deque):java.lang.String");
    }

    public void a(Context context) {
        if (this.a == null) {
            this.a = s.a().a(context);
        }
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || this.b) {
            return;
        }
        try {
            String string = sharedPreferences.getString("cl_pre", "");
            String string2 = this.a.getString("wf_pre", "");
            String string3 = this.a.getString("ll_pre", "");
            a(string, this.c);
            a(string2, this.d);
            b(string3, this.e);
        } catch (Exception unused) {
        }
        this.b = true;
    }

    public synchronized void a(BDLocation bDLocation, String str, Location location) {
        Deque<String> deque;
        String str2;
        if (bDLocation != null) {
            if ("gcj02".equals(str)) {
                String networkLocationType = bDLocation.getNetworkLocationType();
                int locType = bDLocation.getLocType();
                if (locType == 61 || locType == 161) {
                    if (networkLocationType == null) {
                        networkLocationType = "null";
                    }
                    if (networkLocationType.contains("wf") && this.h == 1) {
                        this.d.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.h.o.d(bDLocation.getTime()));
                        deque = this.d;
                        str2 = "wf";
                    } else {
                        if (!networkLocationType.contains("cl") || this.h != 1) {
                            if (locType == 61 && this.i == 1 && location != null) {
                                int radius = (int) bDLocation.getRadius();
                                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                DecimalFormat decimalFormat2 = new DecimalFormat("0.0");
                                DecimalFormat decimalFormat3 = new DecimalFormat("0.000000");
                                this.e.offerFirst(bDLocation.getSatelliteNumber() + "," + radius + "," + decimalFormat.format(bDLocation.getAltitude()) + "," + com.baidu.location.h.o.d(bDLocation.getTime()) + "," + decimalFormat2.format(bDLocation.getSpeed()) + "," + decimalFormat3.format(location.getLongitude()) + "," + decimalFormat3.format(location.getLatitude()));
                                a(this.e);
                            }
                        }
                        this.c.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.h.o.d(bDLocation.getTime()));
                        deque = this.c;
                        str2 = "cl";
                    }
                    a(deque, str2);
                }
            }
        }
    }

    public String b() {
        return a(this.i, this.h);
    }

    public synchronized String c() {
        return a(this.i, this.h);
    }
}
