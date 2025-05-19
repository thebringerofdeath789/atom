package com.baidu.lbsapi.auth;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HttpSyncTask.java */
/* loaded from: classes.dex */
class g {
    private Context a;
    private List<HashMap<String, String>> b = null;
    private a<String> c = null;

    /* compiled from: HttpSyncTask.java */
    interface a<Result> {
        void a(Result result);
    }

    protected g(Context context) {
        this.a = context;
    }

    protected void a(HashMap<String, String> hashMap, String[] strArr, a<String> aVar) {
        this.b = a(hashMap, strArr);
        this.c = aVar;
        new Thread(new h(this)).start();
    }

    private void a(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<HashMap<String, String>> list) {
        int i;
        b.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            b.c("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            b.a("syncConnect resuest " + i2 + "  start!!!");
            HashMap<String, String> hashMap = list.get(i2);
            i iVar = new i(this.a);
            if (iVar.a()) {
                String a2 = iVar.a(hashMap);
                if (a2 == null) {
                    a2 = "";
                }
                b.a("syncConnect resuest " + i2 + "  result:" + a2);
                arrayList.add(a2);
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (jSONObject.has(NotificationCompat.CATEGORY_STATUS) && jSONObject.getInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                        b.a("auth end and break");
                        a(a2);
                        return;
                    }
                } catch (JSONException unused) {
                    b.a("continue-------------------------------");
                }
            } else {
                b.a("Current network is not available.");
                arrayList.add(ErrorMessage.a("Current network is not available."));
            }
            b.a("syncConnect end");
            i2++;
        }
        b.a("--iiiiii:" + i2 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
        if (list.size() <= 0 || i2 != list.size() || arrayList.size() <= 0 || i2 != arrayList.size() || i2 - 1 <= 0) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i));
            if (!jSONObject2.has(NotificationCompat.CATEGORY_STATUS) || jSONObject2.getInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                return;
            }
            b.a("i-1 result is not 0,return first result");
            a((String) arrayList.get(0));
        } catch (JSONException e) {
            a(ErrorMessage.a("JSONException:" + e.getMessage()));
        }
    }

    private List<HashMap<String, String>> a(HashMap<String, String> hashMap, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                HashMap hashMap2 = new HashMap();
                Iterator<String> it = hashMap.keySet().iterator();
                while (it.hasNext()) {
                    String str2 = it.next().toString();
                    hashMap2.put(str2, hashMap.get(str2));
                }
                hashMap2.put("mcode", str);
                arrayList.add(hashMap2);
            }
        } else {
            HashMap hashMap3 = new HashMap();
            Iterator<String> it2 = hashMap.keySet().iterator();
            while (it2.hasNext()) {
                String str3 = it2.next().toString();
                hashMap3.put(str3, hashMap.get(str3));
            }
            arrayList.add(hashMap3);
        }
        return arrayList;
    }
}
