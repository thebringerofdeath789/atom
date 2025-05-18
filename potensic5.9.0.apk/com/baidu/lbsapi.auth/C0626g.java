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
/* renamed from: com.baidu.lbsapi.auth.g */
/* loaded from: classes.dex */
class C0626g {

    /* renamed from: a */
    private Context f233a;

    /* renamed from: b */
    private List<HashMap<String, String>> f234b = null;

    /* renamed from: c */
    private a<String> f235c = null;

    /* compiled from: HttpSyncTask.java */
    /* renamed from: com.baidu.lbsapi.auth.g$a */
    interface a<Result> {
        /* renamed from: a */
        void mo204a(Result result);
    }

    protected C0626g(Context context) {
        this.f233a = context;
    }

    /* renamed from: a */
    protected void m203a(HashMap<String, String> hashMap, String[] strArr, a<String> aVar) {
        this.f234b = m199a(hashMap, strArr);
        this.f235c = aVar;
        new Thread(new RunnableC0627h(this)).start();
    }

    /* renamed from: a */
    private void m201a(String str) {
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
        a<String> aVar = this.f235c;
        if (aVar != null) {
            aVar.mo204a(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m202a(List<HashMap<String, String>> list) {
        int i;
        C0621b.m177a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            C0621b.m179c("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            C0621b.m177a("syncConnect resuest " + i2 + "  start!!!");
            HashMap<String, String> hashMap = list.get(i2);
            C0628i c0628i = new C0628i(this.f233a);
            if (c0628i.m211a()) {
                String m210a = c0628i.m210a(hashMap);
                if (m210a == null) {
                    m210a = "";
                }
                C0621b.m177a("syncConnect resuest " + i2 + "  result:" + m210a);
                arrayList.add(m210a);
                try {
                    JSONObject jSONObject = new JSONObject(m210a);
                    if (jSONObject.has(NotificationCompat.CATEGORY_STATUS) && jSONObject.getInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                        C0621b.m177a("auth end and break");
                        m201a(m210a);
                        return;
                    }
                } catch (JSONException unused) {
                    C0621b.m177a("continue-------------------------------");
                }
            } else {
                C0621b.m177a("Current network is not available.");
                arrayList.add(ErrorMessage.m150a("Current network is not available."));
            }
            C0621b.m177a("syncConnect end");
            i2++;
        }
        C0621b.m177a("--iiiiii:" + i2 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
        if (list.size() <= 0 || i2 != list.size() || arrayList.size() <= 0 || i2 != arrayList.size() || i2 - 1 <= 0) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i));
            if (!jSONObject2.has(NotificationCompat.CATEGORY_STATUS) || jSONObject2.getInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                return;
            }
            C0621b.m177a("i-1 result is not 0,return first result");
            m201a((String) arrayList.get(0));
        } catch (JSONException e) {
            m201a(ErrorMessage.m150a("JSONException:" + e.getMessage()));
        }
    }

    /* renamed from: a */
    private List<HashMap<String, String>> m199a(HashMap<String, String> hashMap, String[] strArr) {
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