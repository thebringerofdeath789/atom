package com.baidu.lbsapi.auth;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HttpAsyncTask.java */
/* loaded from: classes.dex */
class e {
    private Context a;
    private HashMap<String, String> b = null;
    private a<String> c = null;

    /* compiled from: HttpAsyncTask.java */
    interface a<Result> {
        void a(Result result);
    }

    protected e(Context context) {
        this.a = context;
    }

    protected void a(HashMap<String, String> hashMap, a<String> aVar) {
        this.b = a(hashMap);
        this.c = aVar;
        new Thread(new f(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
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
        a<String> aVar = this.c;
        if (aVar != null) {
            aVar.a(jSONObject.toString());
        }
    }

    private HashMap<String, String> a(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String str = it.next().toString();
            hashMap2.put(str, hashMap.get(str));
        }
        return hashMap2;
    }
}
