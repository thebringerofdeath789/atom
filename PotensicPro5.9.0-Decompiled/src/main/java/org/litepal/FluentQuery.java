package org.litepal;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.List;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.QueryHandler;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public class FluentQuery {
    String[] mColumns;
    String[] mConditions;
    String mLimit;
    String mOffset;
    String mOrderBy;

    FluentQuery() {
    }

    public FluentQuery select(String... strArr) {
        this.mColumns = strArr;
        return this;
    }

    public FluentQuery where(String... strArr) {
        this.mConditions = strArr;
        return this;
    }

    public FluentQuery order(String str) {
        this.mOrderBy = str;
        return this;
    }

    public FluentQuery limit(int i) {
        this.mLimit = String.valueOf(i);
        return this;
    }

    public FluentQuery offset(int i) {
        this.mOffset = String.valueOf(i);
        return this;
    }

    public <T> List<T> find(Class<T> cls) {
        return find(cls, false);
    }

    public <T> FindMultiExecutor findAsync(Class<T> cls) {
        return findAsync(cls, false);
    }

    public <T> List<T> find(Class<T> cls, boolean z) {
        String str;
        List<T> onFind;
        synchronized (LitePalSupport.class) {
            QueryHandler queryHandler = new QueryHandler(Connector.getDatabase());
            if (this.mOffset == null) {
                str = this.mLimit;
            } else {
                if (this.mLimit == null) {
                    this.mLimit = SessionDescription.SUPPORTED_SDP_VERSION;
                }
                str = this.mOffset + "," + this.mLimit;
            }
            onFind = queryHandler.onFind(cls, this.mColumns, this.mConditions, this.mOrderBy, str, z);
        }
        return onFind;
    }

    public <T> FindMultiExecutor findAsync(final Class<T> cls, final boolean z) {
        final FindMultiExecutor findMultiExecutor = new FindMultiExecutor();
        findMultiExecutor.submit(new Runnable() { // from class: org.litepal.FluentQuery.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final List find = FluentQuery.this.find(cls, z);
                    if (findMultiExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.FluentQuery.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findMultiExecutor.getListener().onFinish(find);
                            }
                        });
                    }
                }
            }
        });
        return findMultiExecutor;
    }

    public <T> T findFirst(Class<T> cls) {
        return (T) findFirst(cls, false);
    }

    public <T> FindExecutor findFirstAsync(Class<T> cls) {
        return findFirstAsync(cls, false);
    }

    public <T> T findFirst(Class<T> cls, boolean z) {
        synchronized (LitePalSupport.class) {
            List<T> find = find(cls, z);
            if (find.size() <= 0) {
                return null;
            }
            return find.get(0);
        }
    }

    public <T> FindExecutor findFirstAsync(final Class<T> cls, final boolean z) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.FluentQuery.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object findFirst = FluentQuery.this.findFirst(cls, z);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.FluentQuery.2.1
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

    public <T> T findLast(Class<T> cls) {
        return (T) findLast(cls, false);
    }

    public <T> FindExecutor findLastAsync(Class<T> cls) {
        return findLastAsync(cls, false);
    }

    public <T> T findLast(Class<T> cls, boolean z) {
        synchronized (LitePalSupport.class) {
            List<T> find = find(cls, z);
            int size = find.size();
            if (size <= 0) {
                return null;
            }
            return find.get(size - 1);
        }
    }

    public <T> FindExecutor findLastAsync(final Class<T> cls, final boolean z) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.FluentQuery.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object findLast = FluentQuery.this.findLast(cls, z);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.FluentQuery.3.1
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

    public int count(Class<?> cls) {
        return count(BaseUtility.changeCase(cls.getSimpleName()));
    }

    public CountExecutor countAsync(Class<?> cls) {
        return countAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())));
    }

    public int count(String str) {
        int onCount;
        synchronized (LitePalSupport.class) {
            onCount = new QueryHandler(Connector.getDatabase()).onCount(str, this.mConditions);
        }
        return onCount;
    }

    public CountExecutor countAsync(final String str) {
        final CountExecutor countExecutor = new CountExecutor();
        countExecutor.submit(new Runnable() { // from class: org.litepal.FluentQuery.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int count = FluentQuery.this.count(str);
                    if (countExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.FluentQuery.4.1
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

    public double average(Class<?> cls, String str) {
        return average(BaseUtility.changeCase(cls.getSimpleName()), str);
    }

    public AverageExecutor averageAsync(Class<?> cls, String str) {
        return averageAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str);
    }

    public double average(String str, String str2) {
        double onAverage;
        synchronized (LitePalSupport.class) {
            onAverage = new QueryHandler(Connector.getDatabase()).onAverage(str, str2, this.mConditions);
        }
        return onAverage;
    }

    public AverageExecutor averageAsync(final String str, final String str2) {
        final AverageExecutor averageExecutor = new AverageExecutor();
        averageExecutor.submit(new Runnable() { // from class: org.litepal.FluentQuery.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final double average = FluentQuery.this.average(str, str2);
                    if (averageExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.FluentQuery.5.1
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

    public <T> T max(Class<?> cls, String str, Class<T> cls2) {
        return (T) max(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> FindExecutor maxAsync(Class<?> cls, String str, Class<T> cls2) {
        return maxAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public <T> T max(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onMax(str, str2, this.mConditions, cls);
        }
        return t;
    }

    public <T> FindExecutor maxAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.FluentQuery.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object max = FluentQuery.this.max(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.FluentQuery.6.1
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

    public <T> T min(Class<?> cls, String str, Class<T> cls2) {
        return (T) min(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> FindExecutor minAsync(Class<?> cls, String str, Class<T> cls2) {
        return minAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public <T> T min(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onMin(str, str2, this.mConditions, cls);
        }
        return t;
    }

    public <T> FindExecutor minAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.FluentQuery.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object min = FluentQuery.this.min(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.FluentQuery.7.1
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

    public <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        return (T) sum(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> FindExecutor sumAsync(Class<?> cls, String str, Class<T> cls2) {
        return sumAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public <T> T sum(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onSum(str, str2, this.mConditions, cls);
        }
        return t;
    }

    public <T> FindExecutor sumAsync(final String str, final String str2, final Class<T> cls) {
        final FindExecutor findExecutor = new FindExecutor();
        findExecutor.submit(new Runnable() { // from class: org.litepal.FluentQuery.8
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object sum = FluentQuery.this.sum(str, str2, (Class<Object>) cls);
                    if (findExecutor.getListener() != null) {
                        LitePal.getHandler().post(new Runnable() { // from class: org.litepal.FluentQuery.8.1
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
}
