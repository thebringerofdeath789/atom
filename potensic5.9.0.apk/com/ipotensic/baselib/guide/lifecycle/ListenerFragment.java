package com.ipotensic.baselib.guide.lifecycle;

import android.app.Fragment;
import com.ipotensic.baselib.guide.util.LogUtil;

/* loaded from: classes2.dex */
public class ListenerFragment extends Fragment {
    FragmentLifecycle mFragmentLifecycle;

    public void setFragmentLifecycle(FragmentLifecycle fragmentLifecycle) {
        this.mFragmentLifecycle = fragmentLifecycle;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        LogUtil.m1693d("onStart: ");
        FragmentLifecycle fragmentLifecycle = this.mFragmentLifecycle;
        if (fragmentLifecycle != null) {
            fragmentLifecycle.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        FragmentLifecycle fragmentLifecycle = this.mFragmentLifecycle;
        if (fragmentLifecycle != null) {
            fragmentLifecycle.onStop();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentLifecycle fragmentLifecycle = this.mFragmentLifecycle;
        if (fragmentLifecycle != null) {
            fragmentLifecycle.onDestroyView();
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LogUtil.m1693d("onDestroy: ");
        FragmentLifecycle fragmentLifecycle = this.mFragmentLifecycle;
        if (fragmentLifecycle != null) {
            fragmentLifecycle.onDestroy();
        }
    }
}