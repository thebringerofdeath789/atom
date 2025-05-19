package org.litepal.tablemanager.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class TableModel {
    private String className;
    private List<ColumnModel> columnModels = new ArrayList();
    private String tableName;

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void addColumnModel(ColumnModel columnModel) {
        this.columnModels.add(columnModel);
    }

    public List<ColumnModel> getColumnModels() {
        return this.columnModels;
    }

    public ColumnModel getColumnModelByName(String str) {
        for (ColumnModel columnModel : this.columnModels) {
            if (columnModel.getColumnName().equalsIgnoreCase(str)) {
                return columnModel;
            }
        }
        return null;
    }

    public void removeColumnModelByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.columnModels.size()) {
                i = -1;
                break;
            } else if (str.equalsIgnoreCase(this.columnModels.get(i).getColumnName())) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.columnModels.remove(i);
        }
    }

    public boolean containsColumn(String str) {
        for (int i = 0; i < this.columnModels.size(); i++) {
            if (str.equalsIgnoreCase(this.columnModels.get(i).getColumnName())) {
                return true;
            }
        }
        return false;
    }
}
