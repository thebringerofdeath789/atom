package com.ipotensic.baselib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.utils.SPHelper;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes2.dex */
public class ActivityHelper implements Application.ActivityLifecycleCallbacks {
    private static volatile ActivityHelper instance;
    private OnActivityActiveListener activityActiveListener;
    private final Stack<Activity> activityStack = new Stack<>();
    private int activeActivityCount = 0;
    private volatile boolean isAppInForeground = true;
    private SimpleResultListener<Boolean> finishListener = null;

    public interface OnActivityActiveListener {
        void onBackground();

        void onForeground();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private ActivityHelper() {
    }

    public static ActivityHelper getInstance() {
        if (instance == null) {
            synchronized (ActivityHelper.class) {
                if (instance == null) {
                    ActivityHelper activityHelper = new ActivityHelper();
                    instance = activityHelper;
                    return activityHelper;
                }
            }
        }
        return instance;
    }

    public void add(Activity activity) {
        this.activityStack.add(activity);
    }

    public void remove(Activity activity) {
        this.activityStack.remove(activity);
    }

    public void exitApp() {
        SPHelper.getInstance().setCountryCode(null);
        removeAll();
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public void removeAll() {
        Iterator<Activity> it = this.activityStack.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
        this.activityStack.clear();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        add(activity);
        DDLog.m1691w(activity.getClass().getSimpleName() + " onCreated");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.activeActivityCount == 0) {
            this.isAppInForeground = true;
            DDLog.m1684e("进入前台....");
            OnActivityActiveListener onActivityActiveListener = this.activityActiveListener;
            if (onActivityActiveListener != null) {
                onActivityActiveListener.onForeground();
            }
        }
        this.activeActivityCount++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        DDLog.m1691w(activity.getClass().getSimpleName() + " onResumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        DDLog.m1691w(activity.getClass().getSimpleName() + " onPaused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        DDLog.m1691w(activity.getClass().getSimpleName() + " onStop");
        int i = this.activeActivityCount - 1;
        this.activeActivityCount = i;
        if (i == 0) {
            this.isAppInForeground = false;
            DDLog.m1684e("进入后台....");
            OnActivityActiveListener onActivityActiveListener = this.activityActiveListener;
            if (onActivityActiveListener != null) {
                onActivityActiveListener.onBackground();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        remove(activity);
        DDLog.m1691w(activity.getClass().getSimpleName() + " onDestroyed");
        SimpleResultListener<Boolean> simpleResultListener = this.finishListener;
        if (simpleResultListener != null) {
            simpleResultListener.onResult(true);
            this.finishListener = null;
        }
    }

    public boolean isActivityRunning(Class<?> cls) {
        Iterator<Activity> it = this.activityStack.iterator();
        while (it.hasNext()) {
            if (it.next().getClass() == cls) {
                return true;
            }
        }
        return false;
    }

    public void finishAllActivity(Class<?> cls) {
        Iterator<Activity> it = this.activityStack.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass() == cls) {
                DDLog.m1685e("大包", "delete cla: " + next);
                next.finish();
            }
        }
    }

    public void makeActivityOnlyOne(Class<?> cls, SimpleResultListener<Boolean> simpleResultListener) {
        Iterator<Activity> it = this.activityStack.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass() == cls) {
                this.finishListener = simpleResultListener;
                next.finish();
                z = true;
            }
        }
        if (z) {
            return;
        }
        simpleResultListener.onResult(true);
        this.finishListener = null;
    }

    public boolean isAppInForeground() {
        return this.isAppInForeground;
    }

    public void setActivityActiveListener(OnActivityActiveListener onActivityActiveListener) {
        this.activityActiveListener = onActivityActiveListener;
    }
}