package com.github.promeg.tinypinyin.lexicons.android.cncity;

import android.content.Context;
import com.github.promeg.tinypinyin.android.asset.lexicons.AndroidAssetDict;

/* loaded from: classes.dex */
public final class CnCityDict extends AndroidAssetDict {
    static volatile CnCityDict singleton;

    @Override // com.github.promeg.tinypinyin.android.asset.lexicons.AndroidAssetDict
    protected String assetFileName() {
        return "cncity.txt";
    }

    public CnCityDict(Context context) {
        super(context);
    }

    public static CnCityDict getInstance(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        if (singleton == null) {
            synchronized (CnCityDict.class) {
                if (singleton == null) {
                    singleton = new CnCityDict(context);
                }
            }
        }
        return singleton;
    }
}