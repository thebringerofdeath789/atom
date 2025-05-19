package org.apache.commons.beanutils;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class JDBCDynaClass implements DynaClass, Serializable {
    private Map<String, String> columnNameXref;
    protected boolean lowerCase = true;
    protected DynaProperty[] properties = null;
    protected Map<String, DynaProperty> propertiesMap = new HashMap();
    private boolean useColumnLabel;

    JDBCDynaClass() {
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public String getName() {
        return getClass().getName();
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty getDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        return this.propertiesMap.get(str);
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty[] getDynaProperties() {
        return this.properties;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaBean newInstance() throws IllegalAccessException, InstantiationException {
        throw new UnsupportedOperationException("newInstance() not supported");
    }

    public void setUseColumnLabel(boolean z) {
        this.useColumnLabel = z;
    }

    protected Class<?> loadClass(String str) throws SQLException {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            return Class.forName(str, false, contextClassLoader);
        } catch (Exception e) {
            throw new SQLException("Cannot load column class '" + str + "': " + e);
        }
    }

    protected DynaProperty createDynaProperty(ResultSetMetaData resultSetMetaData, int i) throws SQLException {
        String str = null;
        String columnLabel = this.useColumnLabel ? resultSetMetaData.getColumnLabel(i) : null;
        if (columnLabel == null || columnLabel.trim().length() == 0) {
            columnLabel = resultSetMetaData.getColumnName(i);
        }
        String lowerCase = this.lowerCase ? columnLabel.toLowerCase() : columnLabel;
        if (!lowerCase.equals(columnLabel)) {
            if (this.columnNameXref == null) {
                this.columnNameXref = new HashMap();
            }
            this.columnNameXref.put(lowerCase, columnLabel);
        }
        try {
            switch (resultSetMetaData.getColumnType(i)) {
                case 91:
                    return new DynaProperty(lowerCase, Date.class);
                case 92:
                    return new DynaProperty(lowerCase, Time.class);
                case 93:
                    return new DynaProperty(lowerCase, Timestamp.class);
                default:
                    str = resultSetMetaData.getColumnClassName(i);
                    break;
            }
        } catch (SQLException unused) {
        }
        Class<?> cls = Object.class;
        if (str != null) {
            cls = loadClass(str);
        }
        return new DynaProperty(lowerCase, cls);
    }

    protected void introspect(ResultSet resultSet) throws SQLException {
        ArrayList arrayList = new ArrayList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            DynaProperty createDynaProperty = createDynaProperty(metaData, i);
            if (createDynaProperty != null) {
                arrayList.add(createDynaProperty);
            }
        }
        DynaProperty[] dynaPropertyArr = (DynaProperty[]) arrayList.toArray(new DynaProperty[arrayList.size()]);
        this.properties = dynaPropertyArr;
        for (DynaProperty dynaProperty : dynaPropertyArr) {
            this.propertiesMap.put(dynaProperty.getName(), dynaProperty);
        }
    }

    protected Object getObject(ResultSet resultSet, String str) throws SQLException {
        DynaProperty dynaProperty = getDynaProperty(str);
        if (dynaProperty == null) {
            throw new IllegalArgumentException("Invalid name '" + str + "'");
        }
        String columnName = getColumnName(str);
        Class<?> type = dynaProperty.getType();
        if (type.equals(Date.class)) {
            return resultSet.getDate(columnName);
        }
        if (type.equals(Timestamp.class)) {
            return resultSet.getTimestamp(columnName);
        }
        if (type.equals(Time.class)) {
            return resultSet.getTime(columnName);
        }
        return resultSet.getObject(columnName);
    }

    protected String getColumnName(String str) {
        Map<String, String> map = this.columnNameXref;
        return (map == null || !map.containsKey(str)) ? str : this.columnNameXref.get(str);
    }
}
