package org.litepal.tablemanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlErrorCodes;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.util.BaseUtility;
import org.litepal.util.Const;
import org.litepal.util.DBUtility;
import org.litepal.util.LogUtil;

/* loaded from: classes5.dex */
public abstract class AssociationCreator extends Generator {
    @Override // org.litepal.tablemanager.Generator
    protected abstract void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z);

    @Override // org.litepal.tablemanager.Generator
    protected void addOrUpdateAssociation(SQLiteDatabase sQLiteDatabase, boolean z) {
        addAssociations(getAllAssociations(), sQLiteDatabase, z);
    }

    protected String generateCreateTableSQL(String str, List<ColumnModel> list, boolean z) {
        StringBuilder sb = new StringBuilder("create table ");
        sb.append(str).append(" (");
        if (z) {
            sb.append("id integer primary key autoincrement,");
        }
        if (isContainsOnlyIdField(list)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        boolean z2 = false;
        for (ColumnModel columnModel : list) {
            if (!columnModel.isIdColumn()) {
                if (z2) {
                    sb.append(", ");
                }
                sb.append(columnModel.getColumnName()).append(StringUtils.SPACE).append(columnModel.getColumnType());
                if (!columnModel.isNullable()) {
                    sb.append(" not null");
                }
                if (columnModel.isUnique()) {
                    sb.append(" unique");
                }
                String defaultValue = columnModel.getDefaultValue();
                if (!TextUtils.isEmpty(defaultValue)) {
                    sb.append(" default ").append(defaultValue);
                }
                z2 = true;
            }
        }
        sb.append(")");
        LogUtil.d(Generator.TAG, "create table sql is >> " + ((Object) sb));
        return sb.toString();
    }

    protected String generateDropTableSQL(String str) {
        return "drop table if exists " + str;
    }

    protected String generateAddColumnSQL(String str, ColumnModel columnModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("alter table ").append(str);
        sb.append(" add column ").append(columnModel.getColumnName());
        sb.append(StringUtils.SPACE).append(columnModel.getColumnType());
        if (!columnModel.isNullable()) {
            sb.append(" not null");
        }
        if (columnModel.isUnique()) {
            sb.append(" unique");
        }
        String defaultValue = columnModel.getDefaultValue();
        if (!TextUtils.isEmpty(defaultValue)) {
            sb.append(" default ").append(defaultValue);
        } else if (!columnModel.isNullable()) {
            if (XmlErrorCodes.INTEGER.equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = SessionDescription.SUPPORTED_SDP_VERSION;
            } else if ("text".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "''";
            } else if ("real".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "0.0";
            }
            sb.append(" default ").append(defaultValue);
        }
        LogUtil.d(Generator.TAG, "add column sql is >> " + ((Object) sb));
        return sb.toString();
    }

    protected boolean isForeignKeyColumnFormat(String str) {
        return (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.US).endsWith("_id") || str.equalsIgnoreCase("_id")) ? false : true;
    }

    protected void giveTableSchemaACopy(String str, int i, SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("select * from ");
        sb.append(Const.TableSchema.TABLE_NAME);
        LogUtil.d(Generator.TAG, "giveTableSchemaACopy SQL is >> " + ((Object) sb));
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                try {
                    if (isNeedtoGiveACopy(rawQuery, str)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("name", BaseUtility.changeCase(str));
                        contentValues.put("type", Integer.valueOf(i));
                        sQLiteDatabase.insert(Const.TableSchema.TABLE_NAME, null, contentValues);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Exception e) {
                    e = e;
                    cursor = rawQuery;
                    e.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private boolean isNeedtoGiveACopy(Cursor cursor, String str) {
        return (isValueExists(cursor, str) || isSpecialTable(str)) ? false : true;
    }

    private boolean isValueExists(Cursor cursor, String str) {
        if (cursor.moveToFirst()) {
            while (!cursor.getString(cursor.getColumnIndexOrThrow("name")).equalsIgnoreCase(str)) {
                if (!cursor.moveToNext()) {
                }
            }
            return true;
        }
        return false;
    }

    private boolean isSpecialTable(String str) {
        return Const.TableSchema.TABLE_NAME.equalsIgnoreCase(str);
    }

    private void addAssociations(Collection<AssociationsModel> collection, SQLiteDatabase sQLiteDatabase, boolean z) {
        for (AssociationsModel associationsModel : collection) {
            if (2 == associationsModel.getAssociationType() || 1 == associationsModel.getAssociationType()) {
                addForeignKeyColumn(associationsModel.getTableName(), associationsModel.getAssociatedTableName(), associationsModel.getTableHoldsForeignKey(), sQLiteDatabase);
            } else if (3 == associationsModel.getAssociationType()) {
                createIntermediateTable(associationsModel.getTableName(), associationsModel.getAssociatedTableName(), sQLiteDatabase, z);
            }
        }
        Iterator<GenericModel> it = getGenericModels().iterator();
        while (it.hasNext()) {
            createGenericTable(it.next(), sQLiteDatabase, z);
        }
    }

    private void createIntermediateTable(String str, String str2, SQLiteDatabase sQLiteDatabase, boolean z) {
        ArrayList arrayList = new ArrayList();
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(str + "_id");
        columnModel.setColumnType(XmlErrorCodes.INTEGER);
        ColumnModel columnModel2 = new ColumnModel();
        columnModel2.setColumnName(str2 + "_id");
        columnModel2.setColumnType(XmlErrorCodes.INTEGER);
        arrayList.add(columnModel);
        arrayList.add(columnModel2);
        String intermediateTableName = DBUtility.getIntermediateTableName(str, str2);
        ArrayList arrayList2 = new ArrayList();
        if (!DBUtility.isTableExists(intermediateTableName, sQLiteDatabase)) {
            arrayList2.add(generateCreateTableSQL(intermediateTableName, arrayList, false));
        } else if (z) {
            arrayList2.add(generateDropTableSQL(intermediateTableName));
            arrayList2.add(generateCreateTableSQL(intermediateTableName, arrayList, false));
        }
        execute(arrayList2, sQLiteDatabase);
        giveTableSchemaACopy(intermediateTableName, 1, sQLiteDatabase);
    }

    private void createGenericTable(GenericModel genericModel, SQLiteDatabase sQLiteDatabase, boolean z) {
        String tableName = genericModel.getTableName();
        String valueColumnName = genericModel.getValueColumnName();
        String valueColumnType = genericModel.getValueColumnType();
        String valueIdColumnName = genericModel.getValueIdColumnName();
        ArrayList arrayList = new ArrayList();
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(valueColumnName);
        columnModel.setColumnType(valueColumnType);
        ColumnModel columnModel2 = new ColumnModel();
        columnModel2.setColumnName(valueIdColumnName);
        columnModel2.setColumnType(XmlErrorCodes.INTEGER);
        arrayList.add(columnModel);
        arrayList.add(columnModel2);
        ArrayList arrayList2 = new ArrayList();
        if (!DBUtility.isTableExists(tableName, sQLiteDatabase)) {
            arrayList2.add(generateCreateTableSQL(tableName, arrayList, false));
        } else if (z) {
            arrayList2.add(generateDropTableSQL(tableName));
            arrayList2.add(generateCreateTableSQL(tableName, arrayList, false));
        }
        execute(arrayList2, sQLiteDatabase);
        giveTableSchemaACopy(tableName, 2, sQLiteDatabase);
    }

    protected void addForeignKeyColumn(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        if (DBUtility.isTableExists(str, sQLiteDatabase)) {
            if (DBUtility.isTableExists(str2, sQLiteDatabase)) {
                String str4 = null;
                if (str.equals(str3)) {
                    str4 = getForeignKeyColumnName(str2);
                } else if (str2.equals(str3)) {
                    str4 = getForeignKeyColumnName(str);
                }
                if (!DBUtility.isColumnExists(str4, str3, sQLiteDatabase)) {
                    ColumnModel columnModel = new ColumnModel();
                    columnModel.setColumnName(str4);
                    columnModel.setColumnType(XmlErrorCodes.INTEGER);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(generateAddColumnSQL(str3, columnModel));
                    execute(arrayList, sQLiteDatabase);
                    return;
                }
                LogUtil.d(Generator.TAG, "column " + str4 + " is already exist, no need to add one");
                return;
            }
            throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST + str2);
        }
        throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST + str);
    }

    private boolean isContainsOnlyIdField(List<ColumnModel> list) {
        return list.size() == 0 || (list.size() == 1 && isIdColumn(list.get(0).getColumnName())) || (list.size() == 2 && isIdColumn(list.get(0).getColumnName()) && isIdColumn(list.get(1).getColumnName()));
    }
}
