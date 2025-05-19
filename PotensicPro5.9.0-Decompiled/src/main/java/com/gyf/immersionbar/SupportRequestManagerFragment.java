package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class SupportRequestManagerFragment extends Fragment {
    private ImmersionDelegate mDelegate;

    public ImmersionBar get(Object obj) {
        if (this.mDelegate == null) {
            this.mDelegate = new ImmersionDelegate(obj);
        }
        return this.mDelegate.get();
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        if (this.mDelegate == null) {
            this.mDelegate = new ImmersionDelegate(activity, dialog);
        }
        return this.mDelegate.get();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onDestroy();
            this.mDelegate = null;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onConfigurationChanged(configuration);
        }
    }
}
