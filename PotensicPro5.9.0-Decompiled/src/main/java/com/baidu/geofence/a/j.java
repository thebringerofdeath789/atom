package com.baidu.geofence.a;

import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.b.x;
import com.baidu.location.h.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j extends com.baidu.location.h.g {
    private int a;
    private List<String> b = null;
    private boolean c = false;
    private boolean d = false;
    private ArrayList<StringBuilder> e;
    private a f;

    public interface a {
        void clear();
    }

    public j() {
        this.k = new HashMap();
        this.a = 0;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(ArrayList<StringBuilder> arrayList) {
        this.e = arrayList;
    }

    @Override // com.baidu.location.h.g
    public void a(boolean z) {
        this.d = false;
        if (z && this.j != null) {
            try {
                new JSONObject(this.j);
                a aVar = this.f;
                if (aVar != null) {
                    aVar.clear();
                }
                this.d = true;
            } catch (Exception unused) {
            }
        }
        boolean z2 = this.d;
        if (!z2) {
            this.a++;
        }
        if (z2) {
            this.a = 0;
        }
        this.b.clear();
        this.c = false;
    }

    public boolean a(String[] strArr) {
        if (!this.c && this.a < 10) {
            if (strArr != null) {
                for (String str : strArr) {
                    if (this.b == null) {
                        this.b = new ArrayList();
                    }
                    this.b.add(str);
                }
            }
            List<String> list = this.b;
            if (list != null && list.size() > 0) {
                this.c = true;
                ExecutorService c = x.a().c();
                if (c != null) {
                    a(c, o.d());
                } else {
                    e(o.d());
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.location.h.g
    public void b() {
        Map<String, Object> map;
        StringBuilder sb;
        String str;
        String str2;
        this.k.clear();
        this.k.put("qt", "cltrw");
        this.h = o.d();
        for (int i = 0; i < this.b.size(); i++) {
            ArrayList<StringBuilder> arrayList = this.e;
            if (arrayList == null || arrayList.isEmpty()) {
                map = this.k;
                sb = new StringBuilder();
            } else if (TextUtils.isEmpty(this.e.get(i).toString())) {
                map = this.k;
                sb = new StringBuilder();
            } else {
                map = this.k;
                str2 = "cltr[" + i + "]";
                str = this.b.get(i) + "&" + Jni.encode(this.e.get(i).toString());
                map.put(str2, str);
            }
            str2 = sb.append("cltr[").append(i).append("]").toString();
            str = this.b.get(i);
            map.put(str2, str);
        }
        this.k.put("info", Jni.encode(com.baidu.location.h.b.a().d() + "&isgeofence=1"));
        this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        this.b.clear();
    }
}
