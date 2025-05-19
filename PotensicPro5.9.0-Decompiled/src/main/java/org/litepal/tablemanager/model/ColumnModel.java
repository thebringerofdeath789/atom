package org.litepal.tablemanager.model;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes5.dex */
public class ColumnModel {
    private String columnName;
    private String columnType;
    private boolean isNullable = true;
    private boolean isUnique = false;
    private String defaultValue = "";

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String str) {
        this.columnName = str;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public void setColumnType(String str) {
        this.columnType = str;
    }

    public boolean isNullable() {
        return this.isNullable;
    }

    public void setNullable(boolean z) {
        this.isNullable = z;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public void setUnique(boolean z) {
        this.isUnique = z;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String str) {
        if ("text".equalsIgnoreCase(this.columnType)) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.defaultValue = "'" + str + "'";
            return;
        }
        this.defaultValue = str;
    }

    public boolean isIdColumn() {
        return "_id".equalsIgnoreCase(this.columnName) || TtmlNode.ATTR_ID.equalsIgnoreCase(this.columnName);
    }
}
