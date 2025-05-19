package org.litepal.tablemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.litepal.LitePalApplication;
import org.litepal.parser.LitePalAttr;
import org.litepal.util.SharedUtil;

/* loaded from: classes5.dex */
class LitePalOpenHelper extends SQLiteOpenHelper {
    public static final String TAG = "LitePalHelper";

    LitePalOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    LitePalOpenHelper(String str, int i) {
        this(LitePalApplication.getContext(), str, null, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Generator.create(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Generator.upgrade(sQLiteDatabase);
        SharedUtil.updateVersion(LitePalAttr.getInstance().getExtraKeyName(), i2);
    }
}
