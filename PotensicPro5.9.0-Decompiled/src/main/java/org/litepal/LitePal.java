package org.litepal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.litepal.crud.DeleteHandler;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.QueryHandler;
import org.litepal.crud.SaveHandler;
import org.litepal.crud.UpdateHandler;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.parser.LitePalAttr;
import org.litepal.parser.LitePalParser;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.Const;
import org.litepal.util.DBUtility;
import org.litepal.util.SharedUtil;
import org.litepal.util.cipher.CipherUtil;

/* loaded from: classes5.dex */
public class LitePal {
    private static Handler handler = new Handler(Looper.getMainLooper());

    public static void initialize(Context context) {
        LitePalApplication.sContext = context;
    }

    public static SQLiteDatabase getDatabase() {
        SQLiteDatabase database;
        synchronized (LitePalSupport.class) {
            database = Connector.getDatabase();
        }
        return database;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static void use(LitePalDB litePalDB) {
        synchronized (LitePalSupport.class) {
            LitePalAttr litePalAttr = LitePalAttr.getInstance();
            litePalAttr.setDbName(litePalDB.getDbName());
            litePalAttr.setVersion(litePalDB.getVersion());
            litePalAttr.setStorage(litePalDB.getStorage());
            litePalAttr.setClassNames(litePalDB.getClassNames());
            if (!isDefaultDatabase(litePalDB.getDbName())) {
                litePalAttr.setExtraKeyName(litePalDB.getDbName());
                litePalAttr.setCases(Const.Config.CASES_LOWER);
            }
            Connector.clearLitePalOpenHelperInstance();
        }
    }

    public static void useDefault() {
        synchronized (LitePalSupport.class) {
            LitePalAttr.clearInstance();
            Connector.clearLitePalOpenHelperInstance();
        }
    }

    public static boolean deleteDatabase(String str) {
        synchronized (LitePalSupport.class) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.endsWith(Const.Config.DB_NAME_SUFFIX)) {
                str = str + Const.Config.DB_NAME_SUFFIX;
            }
            File databasePath = LitePalApplication.getContext().getDatabasePath(str);
            if (databasePath.exists()) {
                boolean delete = databasePath.delete();
                if (delete) {
                    removeVersionInSharedPreferences(str);
                    Connector.clearLitePalOpenHelperInstance();
                }
                return delete;
            }
            boolean delete2 = new File((LitePalApplication.getContext().getExternalFilesDir("") + "/databases/") + str).delete();
            if (delete2) {
                removeVersionInSharedPreferences(str);
                Connector.clearLitePalOpenHelperInstance();
            }
            return delete2;
        }
    }

    public static void aesKey(String str) {
        CipherUtil.aesKey = str;
    }

    private static void removeVersionInSharedPreferences(String str) {
        if (isDefaultDatabase(str)) {
            SharedUtil.removeVersion(null);
        } else {
            SharedUtil.removeVersion(str);
        }
    }

    private static boolean isDefaultDatabase(String str) {
        if (!BaseUtility.isLitePalXMLExists()) {
            return false;
        }
        if (!str.endsWith(Const.Config.DB_NAME_SUFFIX)) {
            str = str + Const.Config.DB_NAME_SUFFIX;
        }
        String dbName = LitePalParser.parseLitePalConfiguration().getDbName();
        if (!dbName.endsWith(Const.Config.DB_NAME_SUFFIX)) {
            dbName = dbName + Const.Config.DB_NAME_SUFFIX;
        }
        return str.equalsIgnoreCase(dbName);
    }

    public static FluentQuery select(String... strArr) {
        FluentQuery fluentQuery = new FluentQuery();
        fluentQuery.mColumns = strArr;
        return fluentQuery;
    }

    public static FluentQuery where(String... strArr) {
        FluentQuery fluentQuery = new FluentQuery();
        fluentQuery.mConditions = strArr;
        return fluentQuery;
    }

    public static FluentQuery order(String str) {
        FluentQuery fluentQuery = new FluentQuery();
        fluentQuery.mOrderBy = str;
        return fluentQuery;
    }

    public static FluentQuery limit(int i) {
        FluentQuery fluentQuery = new FluentQuery();
        fluentQuery.mLimit = String.valueOf(i);
        return fluentQuery;
    }

    public static FluentQuery offset(int i) {
        FluentQuery fluentQuery = new FluentQuery();
        fluentQuery.mOffset = String.valueOf(i);
        return fluentQuery;
    }

    public static int count(Class<?> cls) {
        return count(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())));
    }

    public static CountExecutor countAsync(Class<?> cls) {
        return countAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())));
    }

    public static int count(String str) {
        int count;
        synchronized (LitePalSupport.class) {
            count = new FluentQuery().count(str);
        }
        return count;
    }

    public static CountExecutor countAsync(final String str) {
        final CountExecutor countExecutor = new CountExecutor();
        countExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int count = LitePal.count(str);
                    if (countExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.1.1
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

    public static double average(Class<?> cls, String str) {
        return average(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str);
    }

    public static AverageExecutor averageAsync(Class<?> cls, String str) {
        return averageAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str);
    }

    public static double average(String str, String str2) {
        double average;
        synchronized (LitePalSupport.class) {
            average = new FluentQuery().average(str, str2);
        }
        return average;
    }

    public static AverageExecutor averageAsync(final String str, final String str2) {
        final AverageExecutor averageExecutor = new AverageExecutor();
        averageExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final double average = LitePal.average(str, str2);
                    if (averageExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.2.1
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

    public static <T> T max(Class<?> cls, String str, Class<T> cls2) {
        return (T) max(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static <T> FindExecutor maxAsync(Class<?> cls, String str, Class<T> cls2) {
        return maxAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static <T> T max(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new FluentQuery().max(str, str2, cls);
        }
        return t;
    }

    public static <T> FindExecutor maxAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object max = LitePal.max(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.3.1
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

    public static <T> T min(Class<?> cls, String str, Class<T> cls2) {
        return (T) min(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static <T> FindExecutor minAsync(Class<?> cls, String str, Class<T> cls2) {
        return minAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static <T> T min(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new FluentQuery().min(str, str2, cls);
        }
        return t;
    }

    public static <T> FindExecutor minAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object min = LitePal.min(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.4.1
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

    public static <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        return (T) sum(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static <T> FindExecutor sumAsync(Class<?> cls, String str, Class<T> cls2) {
        return sumAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static <T> T sum(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new FluentQuery().sum(str, str2, cls);
        }
        return t;
    }

    public static <T> FindExecutor sumAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object sum = LitePal.sum(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.5.1
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

    public static <T> T find(Class<T> cls, long j) {
        return (T) find(cls, j, false);
    }

    public static <T> FindExecutor findAsync(Class<T> cls, long j) {
        return findAsync(cls, j, false);
    }

    public static <T> T find(Class<T> cls, long j, boolean z) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onFind(cls, j, z);
        }
        return t;
    }

    public static <T> FindExecutor findAsync(final Class<T> cls, final long j, final boolean z) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object find = LitePal.find(cls, j, z);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.6.1
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

    public static <T> T findFirst(Class<T> cls) {
        return (T) findFirst(cls, false);
    }

    public static <T> FindExecutor findFirstAsync(Class<T> cls) {
        return findFirstAsync(cls, false);
    }

    public static <T> T findFirst(Class<T> cls, boolean z) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onFindFirst(cls, z);
        }
        return t;
    }

    public static <T> FindExecutor findFirstAsync(final Class<T> cls, final boolean z) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object findFirst = LitePal.findFirst(cls, z);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.7.1
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

    public static <T> T findLast(Class<T> cls) {
        return (T) findLast(cls, false);
    }

    public static <T> FindExecutor findLastAsync(Class<T> cls) {
        return findLastAsync(cls, false);
    }

    public static <T> T findLast(Class<T> cls, boolean z) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onFindLast(cls, z);
        }
        return t;
    }

    public static <T> FindExecutor findLastAsync(final Class<T> cls, final boolean z) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.8
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object findLast = LitePal.findLast(cls, z);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.8.1
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

    public static <T> List<T> findAll(Class<T> cls, long... jArr) {
        return findAll(cls, false, jArr);
    }

    public static <T> FindMultiExecutor findAllAsync(Class<T> cls, long... jArr) {
        return findAllAsync(cls, false, jArr);
    }

    public static <T> List<T> findAll(Class<T> cls, boolean z, long... jArr) {
        List<T> onFindAll;
        synchronized (LitePalSupport.class) {
            onFindAll = new QueryHandler(Connector.getDatabase()).onFindAll(cls, z, jArr);
        }
        return onFindAll;
    }

    public static <T> FindMultiExecutor findAllAsync(final Class<T> cls, final boolean z, final long... jArr) {
        final FindMultiExecutor findMultiExecutor = new FindMultiExecutor();
        findMultiExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.9
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final List findAll = LitePal.findAll(cls, z, jArr);
                    if (findMultiExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.9.1
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

    public static Cursor findBySQL(String... strArr) {
        synchronized (LitePalSupport.class) {
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

    public static int delete(Class<?> cls, long j) {
        int onDelete;
        synchronized (LitePalSupport.class) {
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

    public static UpdateOrDeleteExecutor deleteAsync(final Class<?> cls, final long j) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.10
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int delete = LitePal.delete(cls, j);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.10.1
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

    public static int deleteAll(Class<?> cls, String... strArr) {
        int onDeleteAll;
        synchronized (LitePalSupport.class) {
            onDeleteAll = new DeleteHandler(Connector.getDatabase()).onDeleteAll(cls, strArr);
        }
        return onDeleteAll;
    }

    public static UpdateOrDeleteExecutor deleteAllAsync(final Class<?> cls, final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.11
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int deleteAll = LitePal.deleteAll((Class<?>) cls, strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.11.1
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

    public static int deleteAll(String str, String... strArr) {
        int onDeleteAll;
        synchronized (LitePalSupport.class) {
            onDeleteAll = new DeleteHandler(Connector.getDatabase()).onDeleteAll(str, strArr);
        }
        return onDeleteAll;
    }

    public static UpdateOrDeleteExecutor deleteAllAsync(final String str, final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.12
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int deleteAll = LitePal.deleteAll(str, strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.12.1
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

    public static int update(Class<?> cls, ContentValues contentValues, long j) {
        int onUpdate;
        synchronized (LitePalSupport.class) {
            onUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(cls, j, contentValues);
        }
        return onUpdate;
    }

    public static UpdateOrDeleteExecutor updateAsync(final Class<?> cls, final ContentValues contentValues, final long j) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.13
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int update = LitePal.update(cls, contentValues, j);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.13.1
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

    public static int updateAll(Class<?> cls, ContentValues contentValues, String... strArr) {
        return updateAll(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), contentValues, strArr);
    }

    public static UpdateOrDeleteExecutor updateAllAsync(Class<?> cls, ContentValues contentValues, String... strArr) {
        return updateAllAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), contentValues, strArr);
    }

    public static int updateAll(String str, ContentValues contentValues, String... strArr) {
        int onUpdateAll;
        synchronized (LitePalSupport.class) {
            onUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(str, contentValues, strArr);
        }
        return onUpdateAll;
    }

    public static UpdateOrDeleteExecutor updateAllAsync(final String str, final ContentValues contentValues, final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.14
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int updateAll = LitePal.updateAll(str, contentValues, strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.14.1
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

    public static <T extends LitePalSupport> void saveAll(Collection<T> collection) {
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                try {
                    new SaveHandler(database).onSaveAll(collection);
                    database.setTransactionSuccessful();
                } catch (Exception e) {
                    throw new LitePalSupportException(e.getMessage(), e);
                }
            } finally {
                database.endTransaction();
            }
        }
    }

    public static <T extends LitePalSupport> SaveExecutor saveAllAsync(final Collection<T> collection) {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() { // from class: org.litepal.LitePal.15
            @Override // java.lang.Runnable
            public void run() {
                final boolean z;
                synchronized (LitePalSupport.class) {
                    try {
                        LitePal.saveAll(collection);
                        z = true;
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (saveExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.LitePal.15.1
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

    public static <T extends LitePalSupport> void markAsDeleted(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            it.next().clearSavedState();
        }
    }

    public static <T> boolean isExist(Class<T> cls, String... strArr) {
        return strArr != null && where(strArr).count((Class<?>) cls) > 0;
    }
}
