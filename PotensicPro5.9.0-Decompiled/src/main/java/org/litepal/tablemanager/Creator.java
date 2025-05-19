package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
class Creator extends AssociationCreator {
    public static final String TAG = "Creator";

    Creator() {
    }

    @Override // org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    protected void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        Iterator<TableModel> it = getAllTableModels().iterator();
        while (it.hasNext()) {
            createOrUpgradeTable(it.next(), sQLiteDatabase, z);
        }
    }

    protected void createOrUpgradeTable(TableModel tableModel, SQLiteDatabase sQLiteDatabase, boolean z) {
        execute(getCreateTableSQLs(tableModel, sQLiteDatabase, z), sQLiteDatabase);
        giveTableSchemaACopy(tableModel.getTableName(), 0, sQLiteDatabase);
    }

    protected List<String> getCreateTableSQLs(TableModel tableModel, SQLiteDatabase sQLiteDatabase, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(generateDropTableSQL(tableModel));
            arrayList.add(generateCreateTableSQL(tableModel));
        } else {
            if (DBUtility.isTableExists(tableModel.getTableName(), sQLiteDatabase)) {
                return null;
            }
            arrayList.add(generateCreateTableSQL(tableModel));
        }
        return arrayList;
    }

    private String generateDropTableSQL(TableModel tableModel) {
        return generateDropTableSQL(tableModel.getTableName());
    }

    String generateCreateTableSQL(TableModel tableModel) {
        return generateCreateTableSQL(tableModel.getTableName(), tableModel.getColumnModels(), true);
    }
}
