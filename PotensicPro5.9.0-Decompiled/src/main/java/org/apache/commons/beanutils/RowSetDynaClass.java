package org.apache.commons.beanutils;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public class RowSetDynaClass extends JDBCDynaClass implements DynaClass, Serializable {
    protected int limit;
    protected List<DynaBean> rows;

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

    public RowSetDynaClass(ResultSet resultSet) throws SQLException {
        this(resultSet, true, -1);
    }

    public RowSetDynaClass(ResultSet resultSet, int i) throws SQLException {
        this(resultSet, true, i);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z) throws SQLException {
        this(resultSet, z, -1);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z, int i) throws SQLException {
        this(resultSet, z, i, false);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z, boolean z2) throws SQLException {
        this(resultSet, z, -1, z2);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z, int i, boolean z2) throws SQLException {
        this.limit = -1;
        this.rows = new ArrayList();
        Objects.requireNonNull(resultSet);
        this.lowerCase = z;
        this.limit = i;
        setUseColumnLabel(z2);
        introspect(resultSet);
        copy(resultSet);
    }

    public List<DynaBean> getRows() {
        return this.rows;
    }

    protected void copy(ResultSet resultSet) throws SQLException {
        int i = 0;
        while (resultSet.next()) {
            int i2 = this.limit;
            if (i2 >= 0) {
                int i3 = i + 1;
                if (i >= i2) {
                    return;
                } else {
                    i = i3;
                }
            }
            DynaBean createDynaBean = createDynaBean();
            for (DynaProperty dynaProperty : this.properties) {
                String name = dynaProperty.getName();
                createDynaBean.set(name, getObject(resultSet, name));
            }
            this.rows.add(createDynaBean);
        }
    }

    protected DynaBean createDynaBean() {
        return new BasicDynaBean(this);
    }
}
