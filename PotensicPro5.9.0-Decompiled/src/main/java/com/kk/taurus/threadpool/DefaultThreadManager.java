package com.kk.taurus.threadpool;

/* loaded from: classes2.dex */
public class DefaultThreadManager {
    private static DefaultThreadManager instance;
    private DefaultPoolExecutor mDefaultPoolExecutor;

    private DefaultThreadManager() {
        this.mDefaultPoolExecutor = DefaultPoolExecutor.getInstance();
    }

    private DefaultThreadManager(ExecutorSetting executorSetting) {
        this.mDefaultPoolExecutor = DefaultPoolExecutor.getInstance(executorSetting.getCorePoolSize(), executorSetting.getMaximumPoolSize(), executorSetting.getKeepAliveTime(), executorSetting.getUnit());
    }

    public static DefaultThreadManager getInstance() {
        if (instance == null) {
            synchronized (DefaultThreadManager.class) {
                if (instance == null) {
                    instance = new DefaultThreadManager();
                }
            }
        }
        return instance;
    }

    public static DefaultThreadManager getInstance(ExecutorSetting executorSetting) {
        if (instance == null) {
            synchronized (DefaultThreadManager.class) {
                if (instance == null) {
                    instance = new DefaultThreadManager(executorSetting);
                }
            }
        }
        return instance;
    }

    public void execute(Runnable runnable) {
        this.mDefaultPoolExecutor.execute(runnable);
    }
}
