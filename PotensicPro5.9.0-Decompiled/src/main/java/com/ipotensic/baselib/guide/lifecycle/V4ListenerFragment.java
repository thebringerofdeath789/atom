package com.ipotensic.baselib.guide.lifecycle;

import androidx.fragment.app.Fragment;
import com.ipotensic.baselib.guide.util.LogUtil;

/* loaded from: classes2.dex */
public class V4ListenerFragment extends Fragment {
    FragmentLifecycle mFragmentLifecycle;

    public void setFragmentLifecycle(FragmentLifecycle fragmentLifecycle) {
        this.mFragmentLifecycle = fragmentLifecycle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LogUtil.d("onStart: ");
        FragmentLifecycle fragmentLifecycle = this.mFragmentLifecycle;
        if (fragmentLifecycle != null) {
            fragmentLifecycle.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        FragmentLifecycle fragmentLifecycle = this.mFragmentLifecycle;
        if (fragmentLifecycle != null) {
            fragmentLifecycle.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentLifecycle fragmentLifecycle = this.mFragmentLifecycle;
        if (fragmentLifecycle != null) {
            fragmentLifecycle.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy: ");
        FragmentLifecycle fragmentLifecycle = this.mFragmentLifecycle;
        if (fragmentLifecycle != null) {
            fragmentLifecycle.onDestroy();
        }
    }
}
