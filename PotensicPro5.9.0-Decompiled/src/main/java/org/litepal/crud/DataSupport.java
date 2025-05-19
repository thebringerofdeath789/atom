package org.litepal.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.litepal.LitePal;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.exceptions.DataSupportException;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

@Deprecated
/* loaded from: classes5.dex */
public class DataSupport extends LitePalSupport {
    @Deprecated
    public static synchronized ClusterQuery select(String... strArr) {
        ClusterQuery clusterQuery;
        synchronized (DataSupport.class) {
            clusterQuery = new ClusterQuery();
            clusterQuery.mColumns = strArr;
        }
        return clusterQuery;
    }

    @Deprecated
    public static synchronized ClusterQuery where(String... strArr) {
        ClusterQuery clusterQuery;
        synchronized (DataSupport.class) {
            clusterQuery = new ClusterQuery();
            clusterQuery.mConditions = strArr;
        }
        return clusterQuery;
    }

    @Deprecated
    public static synchronized ClusterQuery order(String str) {
        ClusterQuery clusterQuery;
        synchronized (DataSupport.class) {
            clusterQuery = new ClusterQuery();
            clusterQuery.mOrderBy = str;
        }
        return clusterQuery;
    }

    @Deprecated
    public static synchronized ClusterQuery limit(int i) {
        ClusterQuery clusterQuery;
        synchronized (DataSupport.class) {
            clusterQuery = new ClusterQuery();
            clusterQuery.mLimit = String.valueOf(i);
        }
        return clusterQuery;
    }

    @Deprecated
    public static synchronized ClusterQuery offset(int i) {
        ClusterQuery clusterQuery;
        synchronized (DataSupport.class) {
            clusterQuery = new ClusterQuery();
            clusterQuery.mOffset = String.valueOf(i);
        }
        return clusterQuery;
    }

    @Deprecated
    public static synchronized int count(Class<?> cls) {
        int count;
        synchronized (DataSupport.class) {
            count = count(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())));
        }
        return count;
    }

    @Deprecated
    public static CountExecutor countAsync(Class<?> cls) {
        return countAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())));
    }

    @Deprecated
    public static synchronized int count(String str) {
        int count;
        synchronized (DataSupport.class) {
            count = new ClusterQuery().count(str);
        }
        return count;
    }

    @Deprecated
    public static CountExecutor countAsync(final String str) {
        final CountExecutor countExecutor = new CountExecutor();
        countExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int count = DataSupport.count(str);
                    if (countExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                countExecutor.getListener().onFinish(count);
                            }
                        });
                    }
                }
            }
        });
        return countExecutor;
    }

    @Deprecated
    public static synchronized double average(Class<?> cls, String str) {
        double average;
        synchronized (DataSupport.class) {
            average = average(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str);
        }
        return average;
    }

    @Deprecated
    public static AverageExecutor averageAsync(Class<?> cls, String str) {
        return averageAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str);
    }

    @Deprecated
    public static synchronized double average(String str, String str2) {
        double average;
        synchronized (DataSupport.class) {
            average = new ClusterQuery().average(str, str2);
        }
        return average;
    }

    @Deprecated
    public static AverageExecutor averageAsync(final String str, final String str2) {
        final AverageExecutor averageExecutor = new AverageExecutor();
        averageExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final double average = DataSupport.average(str, str2);
                    if (averageExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                averageExecutor.getListener().onFinish(average);
                            }
                        });
                    }
                }
            }
        });
        return averageExecutor;
    }

    @Deprecated
    public static synchronized <T> T max(Class<?> cls, String str, Class<T> cls2) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) max(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor maxAsync(Class<?> cls, String str, Class<T> cls2) {
        return maxAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    @Deprecated
    public static synchronized <T> T max(String str, String str2, Class<T> cls) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) new ClusterQuery().max(str, str2, cls);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor maxAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object max = DataSupport.max(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(max);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    @Deprecated
    public static synchronized <T> T min(Class<?> cls, String str, Class<T> cls2) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) min(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor minAsync(Class<?> cls, String str, Class<T> cls2) {
        return minAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    @Deprecated
    public static synchronized <T> T min(String str, String str2, Class<T> cls) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) new ClusterQuery().min(str, str2, cls);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor minAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object min = DataSupport.min(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(min);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    @Deprecated
    public static synchronized <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) sum(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor sumAsync(Class<?> cls, String str, Class<T> cls2) {
        return sumAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    @Deprecated
    public static synchronized <T> T sum(String str, String str2, Class<T> cls) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) new ClusterQuery().sum(str, str2, cls);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor sumAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object sum = DataSupport.sum(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(sum);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    @Deprecated
    public static synchronized <T> T find(Class<T> cls, long j) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) find(cls, j, false);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor findAsync(Class<T> cls, long j) {
        return findAsync(cls, j, false);
    }

    @Deprecated
    public static synchronized <T> T find(Class<T> cls, long j, boolean z) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onFind(cls, j, z);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor findAsync(final Class<T> cls, final long j, final boolean z) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object find = DataSupport.find(cls, j, z);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(find);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    @Deprecated
    public static synchronized <T> T findFirst(Class<T> cls) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) findFirst(cls, false);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor findFirstAsync(Class<T> cls) {
        return findFirstAsync(cls, false);
    }

    @Deprecated
    public static synchronized <T> T findFirst(Class<T> cls, boolean z) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onFindFirst(cls, z);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor findFirstAsync(final Class<T> cls, final boolean z) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object findFirst = DataSupport.findFirst(cls, z);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(findFirst);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    @Deprecated
    public static synchronized <T> T findLast(Class<T> cls) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) findLast(cls, false);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor findLastAsync(Class<T> cls) {
        return findLastAsync(cls, false);
    }

    @Deprecated
    public static synchronized <T> T findLast(Class<T> cls, boolean z) {
        T t;
        synchronized (DataSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onFindLast(cls, z);
        }
        return t;
    }

    @Deprecated
    public static <T> FindExecutor findLastAsync(final Class<T> cls, final boolean z) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.8
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object findLast = DataSupport.findLast(cls, z);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(findLast);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    @Deprecated
    public static synchronized <T> List<T> findAll(Class<T> cls, long... jArr) {
        List<T> findAll;
        synchronized (DataSupport.class) {
            findAll = findAll(cls, false, jArr);
        }
        return findAll;
    }

    @Deprecated
    public static <T> FindMultiExecutor findAllAsync(Class<T> cls, long... jArr) {
        return findAllAsync(cls, false, jArr);
    }

    @Deprecated
    public static synchronized <T> List<T> findAll(Class<T> cls, boolean z, long... jArr) {
        List<T> onFindAll;
        synchronized (DataSupport.class) {
            onFindAll = new QueryHandler(Connector.getDatabase()).onFindAll(cls, z, jArr);
        }
        return onFindAll;
    }

    @Deprecated
    public static <T> FindMultiExecutor findAllAsync(final Class<T> cls, final boolean z, final long... jArr) {
        final FindMultiExecutor findMultiExecutor = new FindMultiExecutor();
        findMultiExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.9
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final List findAll = DataSupport.findAll(cls, z, jArr);
                    if (findMultiExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findMultiExecutor.getListener().onFinish(findAll);
                            }
                        });
                    }
                }
            }
        });
        return findMultiExecutor;
    }

    @Deprecated
    public static synchronized Cursor findBySQL(String... strArr) {
        synchronized (DataSupport.class) {
            BaseUtility.checkConditionsCorrect(strArr);
            String[] strArr2 = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length <= 0) {
                return null;
            }
            if (strArr.length != 1) {
                strArr2 = new String[strArr.length - 1];
                System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
            }
            return Connector.getDatabase().rawQuery(strArr[0], strArr2);
        }
    }

    @Deprecated
    public static synchronized int delete(Class<?> cls, long j) {
        int onDelete;
        synchronized (DataSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                onDelete = new DeleteHandler(database).onDelete(cls, j);
                database.setTransactionSuccessful();
            } finally {
                database.endTransaction();
            }
        }
        return onDelete;
    }

    @Deprecated
    public static UpdateOrDeleteExecutor deleteAsync(final Class<?> cls, final long j) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.10
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int delete = DataSupport.delete(cls, j);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(delete);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Deprecated
    public static synchronized int deleteAll(Class<?> cls, String... strArr) {
        int onDeleteAll;
        synchronized (DataSupport.class) {
            onDeleteAll = new DeleteHandler(Connector.getDatabase()).onDeleteAll(cls, strArr);
        }
        return onDeleteAll;
    }

    @Deprecated
    public static UpdateOrDeleteExecutor deleteAllAsync(final Class<?> cls, final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.11
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int deleteAll = DataSupport.deleteAll((Class<?>) cls, strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(deleteAll);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Deprecated
    public static synchronized int deleteAll(String str, String... strArr) {
        int onDeleteAll;
        synchronized (DataSupport.class) {
            onDeleteAll = new DeleteHandler(Connector.getDatabase()).onDeleteAll(str, strArr);
        }
        return onDeleteAll;
    }

    @Deprecated
    public static UpdateOrDeleteExecutor deleteAllAsync(final String str, final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.12
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int deleteAll = DataSupport.deleteAll(str, strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(deleteAll);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Deprecated
    public static synchronized int update(Class<?> cls, ContentValues contentValues, long j) {
        int onUpdate;
        synchronized (DataSupport.class) {
            onUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(cls, j, contentValues);
        }
        return onUpdate;
    }

    @Deprecated
    public static UpdateOrDeleteExecutor updateAsync(final Class<?> cls, final ContentValues contentValues, final long j) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.13
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int update = DataSupport.update(cls, contentValues, j);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(update);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Deprecated
    public static synchronized int updateAll(Class<?> cls, ContentValues contentValues, String... strArr) {
        int updateAll;
        synchronized (DataSupport.class) {
            updateAll = updateAll(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), contentValues, strArr);
        }
        return updateAll;
    }

    @Deprecated
    public static UpdateOrDeleteExecutor updateAllAsync(Class<?> cls, ContentValues contentValues, String... strArr) {
        return updateAllAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), contentValues, strArr);
    }

    @Deprecated
    public static synchronized int updateAll(String str, ContentValues contentValues, String... strArr) {
        int onUpdateAll;
        synchronized (DataSupport.class) {
            onUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(str, contentValues, strArr);
        }
        return onUpdateAll;
    }

    @Deprecated
    public static UpdateOrDeleteExecutor updateAllAsync(final String str, final ContentValues contentValues, final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.14
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int updateAll = DataSupport.updateAll(str, contentValues, strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(updateAll);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Deprecated
    public static synchronized <T extends DataSupport> void saveAll(Collection<T> collection) {
        synchronized (DataSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                try {
                    new SaveHandler(database).onSaveAll(collection);
                    database.setTransactionSuccessful();
                } catch (Exception e) {
                    throw new DataSupportException(e.getMessage(), e);
                }
            } finally {
                database.endTransaction();
            }
        }
    }

    @Deprecated
    public static <T extends DataSupport> SaveExecutor saveAllAsync(final Collection<T> collection) {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.15
            @Override // java.lang.Runnable
            public void run() {
                final boolean z;
                synchronized (DataSupport.class) {
                    try {
                        DataSupport.saveAll(collection);
                        z = true;
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (saveExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(z);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    @Deprecated
    public static <T extends DataSupport> void markAsDeleted(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            it.next().clearSavedState();
        }
    }

    @Deprecated
    public static <T> boolean isExist(Class<T> cls, String... strArr) {
        return strArr != null && where(strArr).count((Class<?>) cls) > 0;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized int delete() {
        int onDelete;
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        try {
            onDelete = new DeleteHandler(database).onDelete(this);
            this.baseObjId = 0L;
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return onDelete;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public UpdateOrDeleteExecutor deleteAsync() {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.16
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int delete = DataSupport.this.delete();
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(delete);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized int update(long j) {
        int onUpdate;
        try {
            onUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(this, j);
            getFieldsToSetToDefault().clear();
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage(), e);
        }
        return onUpdate;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public UpdateOrDeleteExecutor updateAsync(final long j) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.17
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int update = DataSupport.this.update(j);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(update);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized int updateAll(String... strArr) {
        int onUpdateAll;
        try {
            onUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(this, strArr);
            getFieldsToSetToDefault().clear();
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage(), e);
        }
        return onUpdateAll;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public UpdateOrDeleteExecutor updateAllAsync(final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.18
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int updateAll = DataSupport.this.updateAll(strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(updateAll);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized boolean save() {
        try {
            saveThrows();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public SaveExecutor saveAsync() {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.19
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final boolean save = DataSupport.this.save();
                    if (saveExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(save);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized void saveThrows() {
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        try {
            try {
                new SaveHandler(database).onSave(this);
                clearAssociatedData();
                database.setTransactionSuccessful();
            } catch (Exception e) {
                throw new DataSupportException(e.getMessage(), e);
            }
        } finally {
            database.endTransaction();
        }
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized boolean saveOrUpdate(String... strArr) {
        if (strArr == null) {
            return save();
        }
        List find = where(strArr).find(getClass());
        if (find.isEmpty()) {
            return save();
        }
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        try {
            Iterator it = find.iterator();
            while (it.hasNext()) {
                this.baseObjId = ((DataSupport) it.next()).getBaseObjId();
                new SaveHandler(database).onSave(this);
                clearAssociatedData();
            }
            database.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            database.endTransaction();
        }
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public SaveExecutor saveOrUpdateAsync(final String... strArr) {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() { // from class: org.litepal.crud.DataSupport.20
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final boolean saveOrUpdate = DataSupport.this.saveOrUpdate(strArr);
                    if (saveExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.crud.DataSupport.20.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(saveOrUpdate);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public void clearSavedState() {
        this.baseObjId = 0L;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public void setToDefault(String str) {
        getFieldsToSetToDefault().add(str);
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public void assignBaseObjId(int i) {
        this.baseObjId = i;
    }

    @Deprecated
    protected DataSupport() {
    }
}
