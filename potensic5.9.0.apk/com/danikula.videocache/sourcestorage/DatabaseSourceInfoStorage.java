package com.danikula.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.Preconditions;
import com.danikula.videocache.SourceInfo;

/* loaded from: classes.dex */
class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_MIME = "mime";
    private static final String COLUMN_URL = "url";
    private static final String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    private static final String TABLE = "SourceInfo";
    private static final String COLUMN_ID = "_id";
    private static final String[] ALL_COLUMNS = {COLUMN_ID, "url", "length", "mime"};

    DatabaseSourceInfoStorage(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        Preconditions.checkNotNull(context);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Preconditions.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL(CREATE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String str) {
        Throwable th;
        Cursor cursor;
        Preconditions.checkNotNull(str);
        SourceInfo sourceInfo = null;
        try {
            cursor = getReadableDatabase().query(TABLE, ALL_COLUMNS, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        sourceInfo = convert(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return sourceInfo;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
        Preconditions.checkAllNotNull(str, sourceInfo);
        boolean z = get(str) != null;
        ContentValues convert = convert(sourceInfo);
        if (z) {
            getWritableDatabase().update(TABLE, convert, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(TABLE, null, convert);
        }
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public void release() {
        close();
    }

    private SourceInfo convert(Cursor cursor) {
        return new SourceInfo(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    private ContentValues convert(SourceInfo sourceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sourceInfo.url);
        contentValues.put("length", Long.valueOf(sourceInfo.length));
        contentValues.put("mime", sourceInfo.mime);
        return contentValues;
    }
}