package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
class RequestManagerRetriever implements Handler.Callback {
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private Handler mHandler;
    private final Map<FragmentManager, RequestManagerFragment> mPendingFragments;
    private final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> mPendingSupportFragments;
    private String mTag;

    private static class Holder {
        private static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();

        private Holder() {
        }
    }

    static RequestManagerRetriever getInstance() {
        return Holder.INSTANCE;
    }

    private RequestManagerRetriever() {
        this.mTag = ImmersionBar.class.getName();
        this.mPendingFragments = new HashMap();
        this.mPendingSupportFragments = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    public ImmersionBar get(Activity activity) {
        checkNotNull(activity, "activity is null");
        if (activity instanceof FragmentActivity) {
            return getSupportFragment(((FragmentActivity) activity).getSupportFragmentManager(), this.mTag + activity.toString()).get(activity);
        }
        return getFragment(activity.getFragmentManager(), this.mTag + activity.toString()).get(activity);
    }

    public ImmersionBar get(Fragment fragment) {
        checkNotNull(fragment, "fragment is null");
        checkNotNull(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            checkNotNull(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        return getSupportFragment(fragment.getChildFragmentManager(), this.mTag + fragment.toString()).get(fragment);
    }

    public ImmersionBar get(android.app.Fragment fragment) {
        checkNotNull(fragment, "fragment is null");
        checkNotNull(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof android.app.DialogFragment) {
            checkNotNull(((android.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        return getFragment(fragment.getChildFragmentManager(), this.mTag + fragment.toString()).get(fragment);
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        checkNotNull(activity, "activity is null");
        checkNotNull(dialog, "dialog is null");
        if (activity instanceof FragmentActivity) {
            return getSupportFragment(((FragmentActivity) activity).getSupportFragmentManager(), this.mTag + dialog.toString()).get(activity, dialog);
        }
        return getFragment(activity.getFragmentManager(), this.mTag + dialog.toString()).get(activity, dialog);
    }

    public void destroy(Activity activity, Dialog dialog) {
        if (activity == null || dialog == null) {
            return;
        }
        if (activity instanceof FragmentActivity) {
            SupportRequestManagerFragment supportFragment = getSupportFragment(((FragmentActivity) activity).getSupportFragmentManager(), this.mTag + dialog.toString(), true);
            if (supportFragment != null) {
                supportFragment.get(activity, dialog).destroy();
                return;
            }
            return;
        }
        RequestManagerFragment fragment = getFragment(activity.getFragmentManager(), this.mTag + dialog.toString(), true);
        if (fragment != null) {
            fragment.get(activity, dialog).destroy();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.mPendingFragments.remove((FragmentManager) message.obj);
            return true;
        }
        if (i != 2) {
            return false;
        }
        this.mPendingSupportFragments.remove((androidx.fragment.app.FragmentManager) message.obj);
        return true;
    }

    private RequestManagerFragment getFragment(FragmentManager fragmentManager, String str) {
        return getFragment(fragmentManager, str, false);
    }

    private RequestManagerFragment getFragment(FragmentManager fragmentManager, String str, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestManagerFragment == null && (requestManagerFragment = this.mPendingFragments.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            requestManagerFragment = new RequestManagerFragment();
            this.mPendingFragments.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, str).commitAllowingStateLoss();
            this.mHandler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z) {
            return requestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(requestManagerFragment).commit();
        return null;
    }

    private SupportRequestManagerFragment getSupportFragment(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return getSupportFragment(fragmentManager, str, false);
    }

    private SupportRequestManagerFragment getSupportFragment(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.mPendingSupportFragments.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            this.mPendingSupportFragments.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, str).commitAllowingStateLoss();
            this.mHandler.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z) {
            return supportRequestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(supportRequestManagerFragment).commit();
        return null;
    }

    private static <T> void checkNotNull(T t, String str) {
        Objects.requireNonNull(t, str);
    }
}
