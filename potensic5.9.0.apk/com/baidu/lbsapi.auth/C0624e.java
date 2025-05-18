package com.baidu.lbsapi.auth;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HttpAsyncTask.java */
/* renamed from: com.baidu.lbsapi.auth.e */
/* loaded from: classes.dex */
class C0624e {

    /* renamed from: a */
    private Context f229a;

    /* renamed from: b */
    private HashMap<String, String> f230b = null;

    /* renamed from: c */
    private a<String> f231c = null;

    /* compiled from: HttpAsyncTask.java */
    /* renamed from: com.baidu.lbsapi.auth.e$a */
    interface a<Result> {
        /* renamed from: a */
        void mo197a(Result result);
    }

    protected C0624e(Context context) {
        this.f229a = context;
    }

    /* renamed from: a */
    protected void m196a(HashMap<String, String> hashMap, a<String> aVar) {
        this.f230b = m192a(hashMap);
        this.f231c = aVar;
        new Thread(new RunnableC0625f(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m194a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, -1);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        a<String> aVar = this.f231c;
        if (aVar != null) {
            aVar.mo197a(jSONObject.toString());
        }
    }

    /* renamed from: a */
    private HashMap<String, String> m192a(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String str = it.next().toString();
            hashMap2.put(str, hashMap.get(str));
        }
        return hashMap2;
    }
}