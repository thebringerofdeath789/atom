package org.litepal.tablemanager;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.litepal.LitePalBase;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;

/* loaded from: classes5.dex */
public abstract class Generator extends LitePalBase {
    public static final String TAG = "Generator";
    private Collection<AssociationsModel> mAllRelationModels;
    private Collection<TableModel> mTableModels;

    protected abstract void addOrUpdateAssociation(SQLiteDatabase sQLiteDatabase, boolean z);

    protected abstract void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z);

    protected Collection<TableModel> getAllTableModels() {
        if (this.mTableModels == null) {
            this.mTableModels = new ArrayList();
        }
        if (!canUseCache()) {
            this.mTableModels.clear();
            Iterator<String> it = LitePalAttr.getInstance().getClassNames().iterator();
            while (it.hasNext()) {
                this.mTableModels.add(getTableModel(it.next()));
            }
        }
        return this.mTableModels;
    }

    protected Collection<AssociationsModel> getAllAssociations() {
        Collection<AssociationsModel> collection = this.mAllRelationModels;
        if (collection == null || collection.isEmpty()) {
            this.mAllRelationModels = getAssociations(LitePalAttr.getInstance().getClassNames());
        }
        return this.mAllRelationModels;
    }

    protected void execute(List<String> list, SQLiteDatabase sQLiteDatabase) {
        String str = "";
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        str = BaseUtility.changeCase(str2);
                        sQLiteDatabase.execSQL(str);
                    }
                }
            } catch (SQLException unused) {
                throw new DatabaseGenerateException(DatabaseGenerateException.SQL_ERROR + str);
            }
        }
    }

    private static void addAssociation(SQLiteDatabase sQLiteDatabase, boolean z) {
        new Creator().addOrUpdateAssociation(sQLiteDatabase, z);
    }

    private static void updateAssociations(SQLiteDatabase sQLiteDatabase) {
        new Upgrader().addOrUpdateAssociation(sQLiteDatabase, false);
    }

    private static void upgradeTables(SQLiteDatabase sQLiteDatabase) {
        new Upgrader().createOrUpgradeTable(sQLiteDatabase, false);
    }

    private static void create(SQLiteDatabase sQLiteDatabase, boolean z) {
        new Creator().createOrUpgradeTable(sQLiteDatabase, z);
    }

    private static void drop(SQLiteDatabase sQLiteDatabase) {
        new Dropper().createOrUpgradeTable(sQLiteDatabase, false);
    }

    private boolean canUseCache() {
        Collection<TableModel> collection = this.mTableModels;
        return collection != null && collection.size() == LitePalAttr.getInstance().getClassNames().size();
    }

    static void create(SQLiteDatabase sQLiteDatabase) {
        create(sQLiteDatabase, true);
        addAssociation(sQLiteDatabase, true);
    }

    static void upgrade(SQLiteDatabase sQLiteDatabase) {
        drop(sQLiteDatabase);
        create(sQLiteDatabase, false);
        updateAssociations(sQLiteDatabase);
        upgradeTables(sQLiteDatabase);
        addAssociation(sQLiteDatabase, false);
    }
}
