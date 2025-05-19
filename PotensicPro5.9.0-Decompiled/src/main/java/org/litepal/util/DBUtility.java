package org.litepal.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;

/* loaded from: classes5.dex */
public class DBUtility {
    private static final String KEYWORDS_COLUMN_SUFFIX = "_lpcolumn";
    private static final String REG_COLLECTION = "\\s+(not\\s+)?(in)\\s*\\(";
    private static final String REG_FUZZY = "\\s+(not\\s+)?(like|between)\\s+";
    private static final String REG_OPERATOR = "\\s*(=|!=|<>|<|>)";
    private static final String SQLITE_KEYWORDS = ",abort,add,after,all,alter,and,as,asc,autoincrement,before,begin,between,by,cascade,check,collate,column,commit,conflict,constraint,create,cross,database,deferrable,deferred,delete,desc,distinct,drop,each,end,escape,except,exclusive,exists,foreign,from,glob,group,having,in,index,inner,insert,intersect,into,is,isnull,join,like,limit,match,natural,not,notnull,null,of,offset,on,or,order,outer,plan,pragma,primary,query,raise,references,regexp,reindex,release,rename,replace,restrict,right,rollback,row,savepoint,select,set,table,temp,temporary,then,to,transaction,trigger,union,unique,update,using,vacuum,values,view,virtual,when,where,";
    private static final String TAG = "DBUtility";

    private DBUtility() {
    }

    public static String getTableNameByClassName(String str) {
        if (TextUtils.isEmpty(str) || '.' == str.charAt(str.length() - 1)) {
            return null;
        }
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static List<String> getTableNameListByClassNameList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getTableNameByClassName(it.next()));
            }
        }
        return arrayList;
    }

    public static String getTableNameByForeignColumn(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.US).endsWith("_id")) {
            return null;
        }
        return str.substring(0, str.length() - 3);
    }

    public static String getIntermediateTableName(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.toLowerCase(Locale.US).compareTo(str2.toLowerCase(Locale.US)) <= 0) {
            return str + "_" + str2;
        }
        return str2 + "_" + str;
    }

    public static String getGenericTableName(String str, String str2) {
        return BaseUtility.changeCase(getTableNameByClassName(str) + "_" + str2);
    }

    public static String getGenericValueIdColumnName(String str) {
        return BaseUtility.changeCase(getTableNameByClassName(str) + "_id");
    }

    public static String getM2MSelfRefColumnName(Field field) {
        return BaseUtility.changeCase(field.getName() + "_id");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        if (r0.getInt(r0.getColumnIndexOrThrow("type")) != 1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isIntermediateTable(java.lang.String r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L60
            java.lang.String r0 = "[0-9a-zA-Z]+_[0-9a-zA-Z]+"
            boolean r0 = r9.matches(r0)
            if (r0 == 0) goto L60
            r0 = 0
            java.lang.String r2 = "table_schema"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            boolean r10 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            if (r10 == 0) goto L4b
        L22:
            java.lang.String r10 = "name"
            int r10 = r0.getColumnIndexOrThrow(r10)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            java.lang.String r10 = r0.getString(r10)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            boolean r10 = r9.equalsIgnoreCase(r10)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            if (r10 == 0) goto L45
            java.lang.String r9 = "type"
            int r9 = r0.getColumnIndexOrThrow(r9)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            int r9 = r0.getInt(r9)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r10 = 1
            if (r9 != r10) goto L4b
            if (r0 == 0) goto L44
            r0.close()
        L44:
            return r10
        L45:
            boolean r10 = r0.moveToNext()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            if (r10 != 0) goto L22
        L4b:
            if (r0 == 0) goto L60
            goto L56
        L4e:
            r9 = move-exception
            goto L5a
        L50:
            r9 = move-exception
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L60
        L56:
            r0.close()
            goto L60
        L5a:
            if (r0 == 0) goto L5f
            r0.close()
        L5f:
            throw r9
        L60:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.util.DBUtility.isIntermediateTable(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        if (r0.getInt(r0.getColumnIndexOrThrow("type")) != 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
    
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isGenericTable(java.lang.String r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L61
            java.lang.String r0 = "[0-9a-zA-Z]+_[0-9a-zA-Z]+"
            boolean r0 = r9.matches(r0)
            if (r0 == 0) goto L61
            r0 = 0
            java.lang.String r2 = "table_schema"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            boolean r10 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r10 == 0) goto L4c
        L22:
            java.lang.String r10 = "name"
            int r10 = r0.getColumnIndexOrThrow(r10)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.String r10 = r0.getString(r10)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            boolean r10 = r9.equalsIgnoreCase(r10)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r10 == 0) goto L46
            java.lang.String r9 = "type"
            int r9 = r0.getColumnIndexOrThrow(r9)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            int r9 = r0.getInt(r9)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r10 = 2
            if (r9 != r10) goto L4c
            r9 = 1
            if (r0 == 0) goto L45
            r0.close()
        L45:
            return r9
        L46:
            boolean r10 = r0.moveToNext()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r10 != 0) goto L22
        L4c:
            if (r0 == 0) goto L61
            goto L57
        L4f:
            r9 = move-exception
            goto L5b
        L51:
            r9 = move-exception
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L61
        L57:
            r0.close()
            goto L61
        L5b:
            if (r0 == 0) goto L60
            r0.close()
        L60:
            throw r9
        L61:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.util.DBUtility.isGenericTable(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static boolean isTableExists(String str, SQLiteDatabase sQLiteDatabase) {
        try {
            return BaseUtility.containsIgnoreCases(findAllTableNames(sQLiteDatabase), str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        if (r0 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isColumnExists(java.lang.String r4, java.lang.String r5, android.database.sqlite.SQLiteDatabase r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 != 0) goto L60
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto Le
            goto L60
        Le:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r2.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r3 = "pragma table_info("
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.StringBuilder r5 = r2.append(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r2 = ")"
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            android.database.Cursor r0 = r6.rawQuery(r5, r0)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            boolean r5 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r5 == 0) goto L4a
        L32:
            java.lang.String r5 = "name"
            int r5 = r0.getColumnIndexOrThrow(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r5 = r0.getString(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            boolean r5 = r4.equalsIgnoreCase(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r5 == 0) goto L44
            r1 = 1
            goto L4a
        L44:
            boolean r5 = r0.moveToNext()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r5 != 0) goto L32
        L4a:
            if (r0 == 0) goto L59
        L4c:
            r0.close()
            goto L59
        L50:
            r4 = move-exception
            goto L5a
        L52:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L59
            goto L4c
        L59:
            return r1
        L5a:
            if (r0 == 0) goto L5f
            r0.close()
        L5f:
            throw r4
        L60:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.util.DBUtility.isColumnExists(java.lang.String, java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static List<String> findAllTableNames(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where type = ?", new String[]{"table"});
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("tbl_name"));
                        if (!arrayList.contains(string)) {
                            arrayList.add(string);
                        }
                    } while (cursor.moveToNext());
                }
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                throw new DatabaseGenerateException(e.getMessage());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static TableModel findPragmaTableInfo(String str, SQLiteDatabase sQLiteDatabase) {
        if (isTableExists(str, sQLiteDatabase)) {
            List<String> findUniqueColumns = findUniqueColumns(str, sQLiteDatabase);
            TableModel tableModel = new TableModel();
            tableModel.setTableName(str);
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("pragma table_info(" + str + ")", null);
                    if (cursor.moveToFirst()) {
                        do {
                            ColumnModel columnModel = new ColumnModel();
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                            boolean z = true;
                            if (cursor.getInt(cursor.getColumnIndexOrThrow("notnull")) == 1) {
                                z = false;
                            }
                            boolean contains = findUniqueColumns.contains(string);
                            String string3 = cursor.getString(cursor.getColumnIndexOrThrow("dflt_value"));
                            columnModel.setColumnName(string);
                            columnModel.setColumnType(string2);
                            columnModel.setNullable(z);
                            columnModel.setUnique(contains);
                            columnModel.setDefaultValue(string3 != null ? string3.replace("'", "") : "");
                            tableModel.addColumnModel(columnModel);
                        } while (cursor.moveToNext());
                    }
                    return tableModel;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new DatabaseGenerateException(e.getMessage());
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST_WHEN_EXECUTING + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> findUniqueColumns(java.lang.String r8, android.database.sqlite.SQLiteDatabase r9) {
        /*
            java.lang.String r0 = "name"
            java.lang.String r1 = ")"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.<init>()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = "pragma index_list("
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.StringBuilder r8 = r4.append(r8)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.StringBuilder r8 = r8.append(r1)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            android.database.Cursor r8 = r9.rawQuery(r8, r3)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            boolean r4 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L88
            if (r4 == 0) goto L79
            r4 = r3
        L2c:
            java.lang.String r5 = "unique"
            int r5 = r8.getColumnIndexOrThrow(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r5 = r8.getInt(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r6 = 1
            if (r5 != r6) goto L6d
            int r5 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r5 = r8.getString(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r6.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r7 = "pragma index_info("
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.StringBuilder r5 = r5.append(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            android.database.Cursor r4 = r9.rawQuery(r5, r3)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r5 == 0) goto L6d
            int r5 = r4.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r2.add(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
        L6d:
            boolean r5 = r8.moveToNext()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r5 != 0) goto L2c
            r3 = r4
            goto L79
        L75:
            r9 = move-exception
            goto L86
        L77:
            r9 = move-exception
            goto L8a
        L79:
            if (r8 == 0) goto L7e
            r8.close()
        L7e:
            if (r3 == 0) goto L83
            r3.close()
        L83:
            return r2
        L84:
            r9 = move-exception
            r4 = r3
        L86:
            r3 = r8
            goto L9f
        L88:
            r9 = move-exception
            r4 = r3
        L8a:
            r3 = r8
            goto L91
        L8c:
            r9 = move-exception
            r4 = r3
            goto L9f
        L8f:
            r9 = move-exception
            r4 = r3
        L91:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L9e
            org.litepal.exceptions.DatabaseGenerateException r8 = new org.litepal.exceptions.DatabaseGenerateException     // Catch: java.lang.Throwable -> L9e
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L9e
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L9e
            throw r8     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
        L9f:
            if (r3 == 0) goto La4
            r3.close()
        La4:
            if (r4 == 0) goto La9
            r4.close()
        La9:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.util.DBUtility.findUniqueColumns(java.lang.String, android.database.sqlite.SQLiteDatabase):java.util.List");
    }

    public static boolean isFieldNameConflictWithSQLiteKeywords(String str) {
        return !TextUtils.isEmpty(str) && SQLITE_KEYWORDS.contains(new StringBuilder().append(",").append(str.toLowerCase(Locale.US)).append(",").toString());
    }

    public static String convertToValidColumnName(String str) {
        return isFieldNameConflictWithSQLiteKeywords(str) ? str + KEYWORDS_COLUMN_SUFFIX : str;
    }

    public static String convertWhereClauseToColumnName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("(\\w+\\s*(=|!=|<>|<|>)|\\w+\\s+(not\\s+)?(like|between)\\s+|\\w+\\s+(not\\s+)?(in)\\s*\\()").matcher(str);
                while (matcher.find()) {
                    String group = matcher.group();
                    String replaceAll = group.replaceAll("(\\s*(=|!=|<>|<|>)|\\s+(not\\s+)?(like|between)\\s+|\\s+(not\\s+)?(in)\\s*\\()", "");
                    matcher.appendReplacement(stringBuffer, convertToValidColumnName(replaceAll) + group.replace(replaceAll, ""));
                }
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String[] convertSelectClauseToValidNames(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = convertToValidColumnName(strArr[i]);
        }
        return strArr2;
    }

    public static String convertOrderByClauseToValidName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.trim().toLowerCase(Locale.US);
        if (lowerCase.contains(",")) {
            String[] split = lowerCase.split(",");
            StringBuilder sb = new StringBuilder();
            int length = split.length;
            int i = 0;
            boolean z = false;
            while (i < length) {
                String str2 = split[i];
                if (z) {
                    sb.append(",");
                }
                sb.append(convertOrderByItem(str2));
                i++;
                z = true;
            }
            return sb.toString();
        }
        return convertOrderByItem(lowerCase);
    }

    private static String convertOrderByItem(String str) {
        String str2 = "";
        if (str.endsWith("asc")) {
            str = str.replace("asc", "").trim();
            str2 = " asc";
        } else if (str.endsWith("desc")) {
            str = str.replace("desc", "").trim();
            str2 = " desc";
        }
        return convertToValidColumnName(str) + str2;
    }
}
