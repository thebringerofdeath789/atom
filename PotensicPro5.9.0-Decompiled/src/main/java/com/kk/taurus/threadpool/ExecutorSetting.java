package com.kk.taurus.threadpool;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ExecutorSetting {
    private int corePoolSize;
    private long keepAliveTime;
    private int maximumPoolSize;
    private TimeUnit unit;

    public ExecutorSetting() {
    }

    public ExecutorSetting(int i, int i2, long j, TimeUnit timeUnit) {
        this.corePoolSize = i;
        this.maximumPoolSize = i2;
        this.keepAliveTime = j;
        this.unit = timeUnit;
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public void setCorePoolSize(int i) {
        this.corePoolSize = i;
    }

    public int getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    public void setMaximumPoolSize(int i) {
        this.maximumPoolSize = i;
    }

    public long getKeepAliveTime() {
        return this.keepAliveTime;
    }

    public void setKeepAliveTime(long j) {
        this.keepAliveTime = j;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public void setUnit(TimeUnit timeUnit) {
        this.unit = timeUnit;
    }
}
