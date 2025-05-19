package org.apache.commons.beanutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public class ResultSetDynaClass extends JDBCDynaClass implements DynaClass {
    protected ResultSet resultSet;

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ DynaProperty[] getDynaProperties() {
        return super.getDynaProperties();
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ DynaProperty getDynaProperty(String str) {
        return super.getDynaProperty(str);
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ DynaBean newInstance() throws IllegalAccessException, InstantiationException {
        return super.newInstance();
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass
    public /* bridge */ /* synthetic */ void setUseColumnLabel(boolean z) {
        super.setUseColumnLabel(z);
    }

    public ResultSetDynaClass(ResultSet resultSet) throws SQLException {
        this(resultSet, true);
    }

    public ResultSetDynaClass(ResultSet resultSet, boolean z) throws SQLException {
        this(resultSet, z, false);
    }

    public ResultSetDynaClass(ResultSet resultSet, boolean z, boolean z2) throws SQLException {
        this.resultSet = null;
        Objects.requireNonNull(resultSet);
        this.resultSet = resultSet;
        this.lowerCase = z;
        setUseColumnLabel(z2);
        introspect(resultSet);
    }

    public Iterator<DynaBean> iterator() {
        return new ResultSetIterator(this);
    }

    public Object getObjectFromResultSet(String str) throws SQLException {
        return getObject(getResultSet(), str);
    }

    ResultSet getResultSet() {
        return this.resultSet;
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass
    protected Class<?> loadClass(String str) throws SQLException {
        try {
            return getClass().getClassLoader().loadClass(str);
        } catch (Exception e) {
            throw new SQLException("Cannot load column class '" + str + "': " + e);
        }
    }
}
