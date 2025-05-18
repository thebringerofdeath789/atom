package com.baidu.location.p009e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.p006b.C0670x;
import com.baidu.location.p012h.AbstractC0725g;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.baidu.location.e.k */
/* loaded from: classes.dex */
final class C0696k {

    /* renamed from: d */
    private static final String f976d = String.format(Locale.US, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", 3000);

    /* renamed from: e */
    private static final String f977e = String.format(Locale.US, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", 3);

    /* renamed from: b */
    private final SQLiteDatabase f979b;

    /* renamed from: a */
    private String f978a = null;

    /* renamed from: c */
    private final a f980c = new a(this);

    /* renamed from: com.baidu.location.e.k$a */
    private class a extends AbstractC0725g {

        /* renamed from: b */
        private int f982b;

        /* renamed from: c */
        private long f983c;

        /* renamed from: d */
        private String f984d = null;

        /* renamed from: e */
        private boolean f985e = false;

        /* renamed from: f */
        private boolean f986f = false;

        /* renamed from: r */
        private C0696k f987r;

        a(C0696k c0696k) {
            this.f987r = c0696k;
            this.f1292k = new HashMap();
            this.f982b = 0;
            this.f983c = -1L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m864a() {
            if (this.f985e) {
                return;
            }
            this.f984d = this.f987r.m861b();
            long j = this.f983c;
            if (j != -1 && j + 86400000 <= System.currentTimeMillis()) {
                this.f982b = 0;
                this.f983c = -1L;
            }
            if (this.f984d == null || this.f982b >= 2) {
                return;
            }
            this.f985e = true;
            ExecutorService m592c = C0670x.m590a().m592c();
            if (m592c != null) {
                m1129a(m592c, "https://ofloc.map.baidu.com/offline_loc");
            } else {
                m1133e("https://ofloc.map.baidu.com/offline_loc");
            }
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: a */
        public void mo122a(boolean z) {
            this.f986f = false;
            if (z && this.f1291j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f1291j);
                    if (jSONObject.has(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR) && jSONObject.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR) == 161) {
                        this.f986f = true;
                    }
                } catch (Exception unused) {
                }
            }
            if (!this.f986f) {
                this.f982b++;
                this.f983c = System.currentTimeMillis();
            }
            this.f987r.m860a(this.f986f);
            this.f985e = false;
        }

        @Override // com.baidu.location.p012h.AbstractC0725g
        /* renamed from: b */
        public void mo123b() {
            this.f1292k.clear();
            this.f1292k.put("qt", "ofbh");
            this.f1292k.put("req", this.f984d);
            this.f1289h = C0693h.f942a;
        }
    }

    C0696k(SQLiteDatabase sQLiteDatabase) {
        this.f979b = sQLiteDatabase;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m860a(boolean z) {
        String str;
        if (z && (str = this.f978a) != null) {
            String format = String.format("DELETE FROM LOG WHERE timestamp in (%s);", str);
            try {
                if (this.f978a.length() > 0) {
                    this.f979b.execSQL(format);
                }
            } catch (Exception unused) {
            }
        }
        this.f978a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m861b() {
        String str;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        Cursor cursor = null;
        r2 = null;
        r2 = null;
        r2 = null;
        String str2 = null;
        Cursor cursor2 = null;
        try {
            Cursor rawQuery = this.f979b.rawQuery(f977e, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() > 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        rawQuery.moveToFirst();
                        while (!rawQuery.isAfterLast()) {
                            jSONArray.put(rawQuery.getString(1));
                            if (stringBuffer.length() != 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(rawQuery.getLong(0));
                            rawQuery.moveToNext();
                        }
                        try {
                            jSONObject.put("ofloc", jSONArray);
                            str2 = jSONObject.toString();
                        } catch (JSONException unused) {
                        }
                        this.f978a = stringBuffer.toString();
                    }
                } catch (Exception unused2) {
                    str = str2;
                    cursor2 = rawQuery;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return str;
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            }
            if (rawQuery == null) {
                return str2;
            }
            try {
                rawQuery.close();
                return str2;
            } catch (Exception unused5) {
                return str2;
            }
        } catch (Exception unused6) {
            str = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    void m862a() {
        this.f980c.m864a();
    }

    /* renamed from: a */
    void m863a(String str) {
        try {
            this.f979b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", Long.valueOf(System.currentTimeMillis()), Jni.encodeOfflineLocationUpdateRequest(str)));
            this.f979b.execSQL(f976d);
        } catch (Exception unused) {
        }
    }
}