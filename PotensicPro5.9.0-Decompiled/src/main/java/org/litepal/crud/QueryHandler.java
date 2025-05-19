package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public class QueryHandler extends DataHandler {
    public QueryHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    public <T> T onFind(Class<T> cls, long j, boolean z) {
        List<T> query = query(cls, null, "id = ?", new String[]{String.valueOf(j)}, null, null, null, null, getForeignKeyAssociations(cls.getName(), z));
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public <T> T onFindFirst(Class<T> cls, boolean z) {
        List<T> query = query(cls, null, null, null, null, null, TtmlNode.ATTR_ID, "1", getForeignKeyAssociations(cls.getName(), z));
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public <T> T onFindLast(Class<T> cls, boolean z) {
        List<T> query = query(cls, null, null, null, null, null, "id desc", "1", getForeignKeyAssociations(cls.getName(), z));
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public <T> List<T> onFindAll(Class<T> cls, boolean z, long... jArr) {
        if (isAffectAllLines(jArr)) {
            return query(cls, null, null, null, null, null, TtmlNode.ATTR_ID, null, getForeignKeyAssociations(cls.getName(), z));
        }
        return query(cls, null, getWhereOfIdsWithOr(jArr), null, null, null, TtmlNode.ATTR_ID, null, getForeignKeyAssociations(cls.getName(), z));
    }

    public <T> List<T> onFind(Class<T> cls, String[] strArr, String[] strArr2, String str, String str2, boolean z) {
        BaseUtility.checkConditionsCorrect(strArr2);
        if (strArr2 != null && strArr2.length > 0) {
            strArr2[0] = DBUtility.convertWhereClauseToColumnName(strArr2[0]);
        }
        return query(cls, strArr, getWhereClause(strArr2), getWhereArgs(strArr2), null, null, DBUtility.convertOrderByClauseToValidName(str), str2, getForeignKeyAssociations(cls.getName(), z));
    }

    public int onCount(String str, String[] strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        return ((Integer) mathQuery(str, new String[]{"count(1)"}, strArr, Integer.TYPE)).intValue();
    }

    public double onAverage(String str, String str2, String[] strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        return ((Double) mathQuery(str, new String[]{"avg(" + str2 + ")"}, strArr, Double.TYPE)).doubleValue();
    }

    public <T> T onMax(String str, String str2, String[] strArr, Class<T> cls) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        return (T) mathQuery(str, new String[]{"max(" + str2 + ")"}, strArr, cls);
    }

    public <T> T onMin(String str, String str2, String[] strArr, Class<T> cls) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        return (T) mathQuery(str, new String[]{"min(" + str2 + ")"}, strArr, cls);
    }

    public <T> T onSum(String str, String str2, String[] strArr, Class<T> cls) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        return (T) mathQuery(str, new String[]{"sum(" + str2 + ")"}, strArr, cls);
    }
}
