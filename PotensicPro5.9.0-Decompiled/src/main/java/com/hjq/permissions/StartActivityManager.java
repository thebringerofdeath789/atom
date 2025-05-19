package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
final class StartActivityManager {
    private static final String SUB_INTENT_KEY = "sub_intent_key";

    private interface IStartActivityDelegate {
        void startActivity(Intent intent);

        void startActivityForResult(Intent intent, int i);
    }

    StartActivityManager() {
    }

    static Intent getSubIntentInMainIntent(Intent intent) {
        if (AndroidVersion.isAndroid13()) {
            return (Intent) intent.getParcelableExtra(SUB_INTENT_KEY, Intent.class);
        }
        return (Intent) intent.getParcelableExtra(SUB_INTENT_KEY);
    }

    static Intent getDeepSubIntent(Intent intent) {
        Intent subIntentInMainIntent = getSubIntentInMainIntent(intent);
        return subIntentInMainIntent != null ? getDeepSubIntent(subIntentInMainIntent) : intent;
    }

    static Intent addSubIntentToMainIntent(Intent intent, Intent intent2) {
        if (intent == null && intent2 != null) {
            return intent2;
        }
        if (intent2 == null) {
            return intent;
        }
        getDeepSubIntent(intent).putExtra(SUB_INTENT_KEY, intent2);
        return intent;
    }

    static boolean startActivity(Context context, Intent intent) {
        return startActivity(new StartActivityDelegateContextImpl(context), intent);
    }

    static boolean startActivity(Activity activity, Intent intent) {
        return startActivity(new StartActivityDelegateActivityImpl(activity), intent);
    }

    static boolean startActivity(Fragment fragment, Intent intent) {
        return startActivity(new StartActivityDelegateFragmentImpl(fragment), intent);
    }

    static boolean startActivity(androidx.fragment.app.Fragment fragment, Intent intent) {
        return startActivity(new StartActivityDelegateSupportFragmentImpl(fragment), intent);
    }

    static boolean startActivity(IStartActivityDelegate iStartActivityDelegate, Intent intent) {
        try {
            iStartActivityDelegate.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Intent subIntentInMainIntent = getSubIntentInMainIntent(intent);
            if (subIntentInMainIntent == null) {
                return false;
            }
            return startActivity(iStartActivityDelegate, subIntentInMainIntent);
        }
    }

    static boolean startActivityForResult(Activity activity, Intent intent, int i) {
        return startActivityForResult(new StartActivityDelegateActivityImpl(activity), intent, i);
    }

    static boolean startActivityForResult(Fragment fragment, Intent intent, int i) {
        return startActivityForResult(new StartActivityDelegateFragmentImpl(fragment), intent, i);
    }

    static boolean startActivityForResult(androidx.fragment.app.Fragment fragment, Intent intent, int i) {
        return startActivityForResult(new StartActivityDelegateSupportFragmentImpl(fragment), intent, i);
    }

    static boolean startActivityForResult(IStartActivityDelegate iStartActivityDelegate, Intent intent, int i) {
        try {
            iStartActivityDelegate.startActivityForResult(intent, i);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Intent subIntentInMainIntent = getSubIntentInMainIntent(intent);
            if (subIntentInMainIntent == null) {
                return false;
            }
            return startActivityForResult(iStartActivityDelegate, subIntentInMainIntent, i);
        }
    }

    private static class StartActivityDelegateContextImpl implements IStartActivityDelegate {
        private final Context mContext;

        private StartActivityDelegateContextImpl(Context context) {
            this.mContext = context;
        }

        @Override // com.hjq.permissions.StartActivityManager.IStartActivityDelegate
        public void startActivity(Intent intent) {
            this.mContext.startActivity(intent);
        }

        @Override // com.hjq.permissions.StartActivityManager.IStartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            Activity findActivity = PermissionUtils.findActivity(this.mContext);
            if (findActivity != null) {
                findActivity.startActivityForResult(intent, i);
            } else {
                startActivity(intent);
            }
        }
    }

    private static class StartActivityDelegateActivityImpl implements IStartActivityDelegate {
        private final Activity mActivity;

        private StartActivityDelegateActivityImpl(Activity activity) {
            this.mActivity = activity;
        }

        @Override // com.hjq.permissions.StartActivityManager.IStartActivityDelegate
        public void startActivity(Intent intent) {
            this.mActivity.startActivity(intent);
        }

        @Override // com.hjq.permissions.StartActivityManager.IStartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.mActivity.startActivityForResult(intent, i);
        }
    }

    private static class StartActivityDelegateFragmentImpl implements IStartActivityDelegate {
        private final Fragment mFragment;

        private StartActivityDelegateFragmentImpl(Fragment fragment) {
            this.mFragment = fragment;
        }

        @Override // com.hjq.permissions.StartActivityManager.IStartActivityDelegate
        public void startActivity(Intent intent) {
            this.mFragment.startActivity(intent);
        }

        @Override // com.hjq.permissions.StartActivityManager.IStartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.mFragment.startActivityForResult(intent, i);
        }
    }

    private static class StartActivityDelegateSupportFragmentImpl implements IStartActivityDelegate {
        private final androidx.fragment.app.Fragment mFragment;

        private StartActivityDelegateSupportFragmentImpl(androidx.fragment.app.Fragment fragment) {
            this.mFragment = fragment;
        }

        @Override // com.hjq.permissions.StartActivityManager.IStartActivityDelegate
        public void startActivity(Intent intent) {
            this.mFragment.startActivity(intent);
        }

        @Override // com.hjq.permissions.StartActivityManager.IStartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.mFragment.startActivityForResult(intent, i);
        }
    }
}
