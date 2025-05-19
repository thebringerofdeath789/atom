package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class EMUI3NavigationBarObserver extends ContentObserver {
    private Application mApplication;
    private ArrayList<ImmersionCallback> mCallbacks;
    private Boolean mIsRegister;

    static EMUI3NavigationBarObserver getInstance() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    private EMUI3NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.mIsRegister = false;
    }

    void register(Application application) {
        Application application2;
        Uri uriFor;
        this.mApplication = application;
        if (Build.VERSION.SDK_INT < 17 || (application2 = this.mApplication) == null || application2.getContentResolver() == null || this.mIsRegister.booleanValue() || (uriFor = Settings.System.getUriFor("navigationbar_is_min")) == null) {
            return;
        }
        this.mApplication.getContentResolver().registerContentObserver(uriFor, true, this);
        this.mIsRegister = true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Application application;
        ArrayList<ImmersionCallback> arrayList;
        super.onChange(z);
        if (Build.VERSION.SDK_INT < 17 || (application = this.mApplication) == null || application.getContentResolver() == null || (arrayList = this.mCallbacks) == null || arrayList.isEmpty()) {
            return;
        }
        int i = Settings.System.getInt(this.mApplication.getContentResolver(), "navigationbar_is_min", 0);
        Iterator<ImmersionCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ImmersionCallback next = it.next();
            boolean z2 = true;
            if (i == 1) {
                z2 = false;
            }
            next.onNavigationBarChange(z2);
        }
    }

    void addOnNavigationBarListener(ImmersionCallback immersionCallback) {
        if (immersionCallback == null) {
            return;
        }
        if (this.mCallbacks == null) {
            this.mCallbacks = new ArrayList<>();
        }
        if (this.mCallbacks.contains(immersionCallback)) {
            return;
        }
        this.mCallbacks.add(immersionCallback);
    }

    void removeOnNavigationBarListener(ImmersionCallback immersionCallback) {
        ArrayList<ImmersionCallback> arrayList;
        if (immersionCallback == null || (arrayList = this.mCallbacks) == null) {
            return;
        }
        arrayList.remove(immersionCallback);
    }

    private static class NavigationBarObserverInstance {
        private static final EMUI3NavigationBarObserver INSTANCE = new EMUI3NavigationBarObserver();

        private NavigationBarObserverInstance() {
        }
    }
}
