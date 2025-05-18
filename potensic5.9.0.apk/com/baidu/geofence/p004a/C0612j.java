package com.baidu.geofence.p004a;

import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p012h.AbstractC0725g;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0733o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.baidu.geofence.a.j */
/* loaded from: classes.dex */
public class C0612j extends AbstractC0725g {

    /* renamed from: a */
    private int f192a;

    /* renamed from: b */
    private List<String> f193b = null;

    /* renamed from: c */
    private boolean f194c = false;

    /* renamed from: d */
    private boolean f195d = false;

    /* renamed from: e */
    private ArrayList<StringBuilder> f196e;

    /* renamed from: f */
    private a f197f;

    /* renamed from: com.baidu.geofence.a.j$a */
    public interface a {
        void clear();
    }

    public C0612j() {
        this.f1292k = new HashMap();
        this.f192a = 0;
    }

    /* renamed from: a */
    public void m138a(a aVar) {
        this.f197f = aVar;
    }

    /* renamed from: a */
    public void m139a(ArrayList<StringBuilder> arrayList) {
        this.f196e = arrayList;
    }

    @Override // com.baidu.location.p012h.AbstractC0725g
    /* renamed from: a */
    public void mo122a(boolean z) {
        this.f195d = false;
        if (z && this.f1291j != null) {
            try {
                new JSONObject(this.f1291j);
                a aVar = this.f197f;
                if (aVar != null) {
                    aVar.clear();
                }
                this.f195d = true;
            } catch (Exception unused) {
            }
        }
        boolean z2 = this.f195d;
        if (!z2) {
            this.f192a++;
        }
        if (z2) {
            this.f192a = 0;
        }
        this.f193b.clear();
        this.f194c = false;
    }

    /* renamed from: a */
    public boolean m140a(String[] strArr) {
        if (!this.f194c && this.f192a < 10) {
            if (strArr != null) {
                for (String str : strArr) {
                    if (this.f193b == null) {
                        this.f193b = new ArrayList();
                    }
                    this.f193b.add(str);
                }
            }
            List<String> list = this.f193b;
            if (list != null && list.size() > 0) {
                this.f194c = true;
                ExecutorService m592c = C0670x.m590a().m592c();
                if (m592c != null) {
                    m1129a(m592c, C0733o.m1160d());
                } else {
                    m1133e(C0733o.m1160d());
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.location.p012h.AbstractC0725g
    /* renamed from: b */
    public void mo123b() {
        Map<String, Object> map;
        StringBuilder sb;
        String str;
        String str2;
        this.f1292k.clear();
        this.f1292k.put("qt", "cltrw");
        this.f1289h = C0733o.m1160d();
        for (int i = 0; i < this.f193b.size(); i++) {
            ArrayList<StringBuilder> arrayList = this.f196e;
            if (arrayList == null || arrayList.isEmpty()) {
                map = this.f1292k;
                sb = new StringBuilder();
            } else if (TextUtils.isEmpty(this.f196e.get(i).toString())) {
                map = this.f1292k;
                sb = new StringBuilder();
            } else {
                map = this.f1292k;
                str2 = "cltr[" + i + "]";
                str = this.f193b.get(i) + "&" + Jni.encode(this.f196e.get(i).toString());
                map.put(str2, str);
            }
            str2 = sb.append("cltr[").append(i).append("]").toString();
            str = this.f193b.get(i);
            map.put(str2, str);
        }
        this.f1292k.put("info", Jni.encode(C0720b.m1100a().m1107d() + "&isgeofence=1"));
        this.f1292k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        this.f193b.clear();
    }
}