package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlErrorCodes;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.DBUtility;
import org.litepal.util.LogUtil;

/* loaded from: classes5.dex */
public class Upgrader extends AssociationUpdater {
    private boolean hasConstraintChanged;
    protected TableModel mTableModel;
    protected TableModel mTableModelDB;

    @Override // org.litepal.tablemanager.AssociationUpdater, org.litepal.tablemanager.Creator, org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    protected void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.mDb = sQLiteDatabase;
        for (TableModel tableModel : getAllTableModels()) {
            this.mTableModel = tableModel;
            this.mTableModelDB = getTableModelFromDB(tableModel.getTableName());
            LogUtil.d(AssociationUpdater.TAG, "createOrUpgradeTable: model is " + this.mTableModel.getTableName());
            upgradeTable();
        }
    }

    private void upgradeTable() {
        if (hasNewUniqueOrNotNullColumn()) {
            createOrUpgradeTable(this.mTableModel, this.mDb, true);
            for (AssociationsInfo associationsInfo : getAssociationInfo(this.mTableModel.getClassName())) {
                if (associationsInfo.getAssociationType() == 2 || associationsInfo.getAssociationType() == 1) {
                    if (associationsInfo.getClassHoldsForeignKey().equalsIgnoreCase(this.mTableModel.getClassName())) {
                        addForeignKeyColumn(this.mTableModel.getTableName(), DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()), this.mTableModel.getTableName(), this.mDb);
                    }
                }
            }
            return;
        }
        this.hasConstraintChanged = false;
        removeColumns(findColumnsToRemove());
        addColumns(findColumnsToAdd());
        changeColumnsType(findColumnTypesToChange());
        changeColumnsConstraints();
    }

    private boolean hasNewUniqueOrNotNullColumn() {
        for (ColumnModel columnModel : this.mTableModel.getColumnModels()) {
            ColumnModel columnModelByName = this.mTableModelDB.getColumnModelByName(columnModel.getColumnName());
            if (columnModel.isUnique() && (columnModelByName == null || !columnModelByName.isUnique())) {
                return true;
            }
            if (columnModelByName != null && !columnModel.isNullable() && columnModelByName.isNullable()) {
                return true;
            }
        }
        return false;
    }

    private List<ColumnModel> findColumnsToAdd() {
        ArrayList arrayList = new ArrayList();
        for (ColumnModel columnModel : this.mTableModel.getColumnModels()) {
            if (!this.mTableModelDB.containsColumn(columnModel.getColumnName())) {
                arrayList.add(columnModel);
            }
        }
        return arrayList;
    }

    private List<String> findColumnsToRemove() {
        String tableName = this.mTableModel.getTableName();
        ArrayList arrayList = new ArrayList();
        Iterator<ColumnModel> it = this.mTableModelDB.getColumnModels().iterator();
        while (it.hasNext()) {
            String columnName = it.next().getColumnName();
            if (isNeedToRemove(columnName)) {
                arrayList.add(columnName);
            }
        }
        LogUtil.d(AssociationUpdater.TAG, "remove columns from " + tableName + " >> " + arrayList);
        return arrayList;
    }

    private List<ColumnModel> findColumnTypesToChange() {
        ArrayList arrayList = new ArrayList();
        for (ColumnModel columnModel : this.mTableModelDB.getColumnModels()) {
            for (ColumnModel columnModel2 : this.mTableModel.getColumnModels()) {
                if (columnModel.getColumnName().equalsIgnoreCase(columnModel2.getColumnName())) {
                    if (!columnModel.getColumnType().equalsIgnoreCase(columnModel2.getColumnType()) && (!columnModel2.getColumnType().equalsIgnoreCase("blob") || !TextUtils.isEmpty(columnModel.getColumnType()))) {
                        arrayList.add(columnModel2);
                    }
                    if (!this.hasConstraintChanged) {
                        LogUtil.d(AssociationUpdater.TAG, "default value db is:" + columnModel.getDefaultValue() + ", default value is:" + columnModel2.getDefaultValue());
                        if (columnModel.isNullable() != columnModel2.isNullable() || !columnModel.getDefaultValue().equalsIgnoreCase(columnModel2.getDefaultValue()) || (columnModel.isUnique() && !columnModel2.isUnique())) {
                            this.hasConstraintChanged = true;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isNeedToRemove(String str) {
        return (!isRemovedFromClass(str) || isIdColumn(str) || isForeignKeyColumn(this.mTableModel, str)) ? false : true;
    }

    private boolean isRemovedFromClass(String str) {
        return !this.mTableModel.containsColumn(str);
    }

    private String generateAddColumnSQL(ColumnModel columnModel) {
        return generateAddColumnSQL(this.mTableModel.getTableName(), columnModel);
    }

    private List<String> getAddColumnSQLs(List<ColumnModel> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ColumnModel> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(generateAddColumnSQL(it.next()));
        }
        return arrayList;
    }

    private void removeColumns(List<String> list) {
        LogUtil.d(AssociationUpdater.TAG, "do removeColumns " + list);
        removeColumns(list, this.mTableModel.getTableName());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.mTableModelDB.removeColumnModelByName(it.next());
        }
    }

    private void addColumns(List<ColumnModel> list) {
        LogUtil.d(AssociationUpdater.TAG, "do addColumn");
        execute(getAddColumnSQLs(list), this.mDb);
        Iterator<ColumnModel> it = list.iterator();
        while (it.hasNext()) {
            this.mTableModelDB.addColumnModel(it.next());
        }
    }

    private void changeColumnsType(List<ColumnModel> list) {
        LogUtil.d(AssociationUpdater.TAG, "do changeColumnsType");
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<ColumnModel> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getColumnName());
            }
        }
        removeColumns(arrayList);
        addColumns(list);
    }

    private void changeColumnsConstraints() {
        if (this.hasConstraintChanged) {
            LogUtil.d(AssociationUpdater.TAG, "do changeColumnsConstraints");
            execute(getChangeColumnsConstraintsSQL(), this.mDb);
        }
    }

    private List<String> getChangeColumnsConstraintsSQL() {
        String generateAlterToTempTableSQL = generateAlterToTempTableSQL(this.mTableModel.getTableName());
        String generateCreateTableSQL = generateCreateTableSQL(this.mTableModel);
        List<String> generateAddForeignKeySQL = generateAddForeignKeySQL();
        String generateDataMigrationSQL = generateDataMigrationSQL(this.mTableModelDB);
        String generateDropTempTableSQL = generateDropTempTableSQL(this.mTableModel.getTableName());
        ArrayList arrayList = new ArrayList();
        arrayList.add(generateAlterToTempTableSQL);
        arrayList.add(generateCreateTableSQL);
        arrayList.addAll(generateAddForeignKeySQL);
        arrayList.add(generateDataMigrationSQL);
        arrayList.add(generateDropTempTableSQL);
        LogUtil.d(AssociationUpdater.TAG, "generateChangeConstraintSQL >> ");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LogUtil.d(AssociationUpdater.TAG, (String) it.next());
        }
        LogUtil.d(AssociationUpdater.TAG, "<< generateChangeConstraintSQL");
        return arrayList;
    }

    private List<String> generateAddForeignKeySQL() {
        ArrayList arrayList = new ArrayList();
        for (String str : getForeignKeyColumns(this.mTableModel)) {
            if (!this.mTableModel.containsColumn(str)) {
                ColumnModel columnModel = new ColumnModel();
                columnModel.setColumnName(str);
                columnModel.setColumnType(XmlErrorCodes.INTEGER);
                arrayList.add(generateAddColumnSQL(this.mTableModel.getTableName(), columnModel));
            }
        }
        return arrayList;
    }
}
