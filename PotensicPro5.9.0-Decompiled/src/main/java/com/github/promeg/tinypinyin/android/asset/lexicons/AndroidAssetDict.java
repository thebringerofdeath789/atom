package com.github.promeg.tinypinyin.android.asset.lexicons;

import android.content.Context;
import com.github.promeg.pinyinhelper.PinyinMapDict;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AndroidAssetDict extends PinyinMapDict {
    final Context mContext;
    final Map<String, String[]> mDict = new HashMap();

    protected abstract String assetFileName();

    public AndroidAssetDict(Context context) {
        this.mContext = context.getApplicationContext();
        init();
    }

    @Override // com.github.promeg.pinyinhelper.PinyinMapDict
    public Map<String, String[]> mapping() {
        return this.mDict;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void init() {
        /*
            r6 = this;
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            android.content.Context r3 = r6.mContext     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            java.lang.String r4 = r6.assetFileName()     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            java.io.InputStream r3 = r3.open(r4)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
        L19:
            java.lang.String r0 = r1.readLine()     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L5a
            if (r0 == 0) goto L3d
            java.lang.String r2 = "\\s+"
            java.lang.String[] r0 = r0.split(r2)     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L5a
            if (r0 == 0) goto L19
            int r2 = r0.length     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L5a
            r3 = 2
            if (r2 != r3) goto L19
            r2 = 0
            r2 = r0[r2]     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L5a
            java.lang.String r3 = "'"
            java.lang.String[] r2 = r2.split(r3)     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L5a
            java.util.Map<java.lang.String, java.lang.String[]> r3 = r6.mDict     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L5a
            r4 = 1
            r0 = r0[r4]     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L5a
            r3.put(r0, r2)     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L5a
            goto L19
        L3d:
            r1.close()     // Catch: java.io.IOException -> L55
            goto L59
        L41:
            r0 = move-exception
            goto L4c
        L43:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L5b
        L48:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L4c:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r0 = move-exception
            r0.printStackTrace()
        L59:
            return
        L5a:
            r0 = move-exception
        L5b:
            if (r1 == 0) goto L65
            r1.close()     // Catch: java.io.IOException -> L61
            goto L65
        L61:
            r1 = move-exception
            r1.printStackTrace()
        L65:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.promeg.tinypinyin.android.asset.lexicons.AndroidAssetDict.init():void");
    }
}
