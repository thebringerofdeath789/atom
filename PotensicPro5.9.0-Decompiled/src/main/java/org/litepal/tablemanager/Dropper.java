package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;

/* loaded from: classes5.dex */
public class Dropper extends AssociationUpdater {
    private Collection<TableModel> mTableModels;

    @Override // org.litepal.tablemanager.AssociationUpdater, org.litepal.tablemanager.Creator, org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    protected void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.mTableModels = getAllTableModels();
        this.mDb = sQLiteDatabase;
        dropTables();
    }

    private void dropTables() {
        List<String> findTablesToDrop = findTablesToDrop();
        dropTables(findTablesToDrop, this.mDb);
        clearCopyInTableSchema(findTablesToDrop);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        if (r1 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> findTablesToDrop() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.mDb     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r3 = "table_schema"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r2 == 0) goto L55
        L1a:
            java.lang.String r2 = "name"
            int r2 = r1.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r3 = "type"
            int r3 = r1.getColumnIndexOrThrow(r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            boolean r3 = r10.shouldDropThisTable(r2, r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r3 == 0) goto L4f
            java.lang.String r3 = "AssociationUpdater"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r4.<init>()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r5 = "need to drop "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.StringBuilder r4 = r4.append(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            org.litepal.util.LogUtil.d(r3, r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r0.add(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
        L4f:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r2 != 0) goto L1a
        L55:
            if (r1 == 0) goto L63
            goto L60
        L58:
            r0 = move-exception
            goto L64
        L5a:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L63
        L60:
            r1.close()
        L63:
            return r0
        L64:
            if (r1 == 0) goto L69
            r1.close()
        L69:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.tablemanager.Dropper.findTablesToDrop():java.util.List");
    }

    private List<String> pickTableNamesFromTableModels() {
        ArrayList arrayList = new ArrayList();
        Iterator<TableModel> it = this.mTableModels.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTableName());
        }
        return arrayList;
    }

    private boolean shouldDropThisTable(String str, int i) {
        return !BaseUtility.containsIgnoreCases(pickTableNamesFromTableModels(), str) && i == 0;
    }
}
