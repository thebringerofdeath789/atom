package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hjq.permissions.PermissionFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes2.dex */
public final class PermissionFragment extends Fragment implements Runnable {
    private static final String REQUEST_CODE = "request_code";
    private static final List<Integer> REQUEST_CODE_ARRAY = new ArrayList();
    private static final String REQUEST_PERMISSIONS = "request_permissions";
    private OnPermissionCallback mCallBack;
    private boolean mDangerousRequest;
    private IPermissionInterceptor mInterceptor;
    private boolean mRequestFlag;
    private int mScreenOrientation;
    private boolean mSpecialRequest;

    public static void launch(Activity activity, ArrayList<String> arrayList, IPermissionInterceptor iPermissionInterceptor, OnPermissionCallback onPermissionCallback) {
        int nextInt;
        List<Integer> list;
        PermissionFragment permissionFragment = new PermissionFragment();
        Bundle bundle = new Bundle();
        do {
            nextInt = new Random().nextInt((int) Math.pow(2.0d, 8.0d));
            list = REQUEST_CODE_ARRAY;
        } while (list.contains(Integer.valueOf(nextInt)));
        list.add(Integer.valueOf(nextInt));
        bundle.putInt(REQUEST_CODE, nextInt);
        bundle.putStringArrayList(REQUEST_PERMISSIONS, arrayList);
        permissionFragment.setArguments(bundle);
        permissionFragment.setRetainInstance(true);
        permissionFragment.setRequestFlag(true);
        permissionFragment.setCallBack(onPermissionCallback);
        permissionFragment.setInterceptor(iPermissionInterceptor);
        permissionFragment.attachActivity(activity);
    }

    public void attachActivity(Activity activity) {
        activity.getFragmentManager().beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    public void detachActivity(Activity activity) {
        activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    public void setCallBack(OnPermissionCallback onPermissionCallback) {
        this.mCallBack = onPermissionCallback;
    }

    public void setRequestFlag(boolean z) {
        this.mRequestFlag = z;
    }

    public void setInterceptor(IPermissionInterceptor iPermissionInterceptor) {
        this.mInterceptor = iPermissionInterceptor;
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.mScreenOrientation = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        PermissionUtils.lockActivityOrientation(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity == null || this.mScreenOrientation != -1 || activity.getRequestedOrientation() == -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCallBack = null;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mRequestFlag) {
            detachActivity(getActivity());
        } else {
            if (this.mSpecialRequest) {
                return;
            }
            this.mSpecialRequest = true;
            requestSpecialPermission();
        }
    }

    public void requestSpecialPermission() {
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null) {
            return;
        }
        boolean z = false;
        for (String str : arguments.getStringArrayList(REQUEST_PERMISSIONS)) {
            if (PermissionApi.isSpecialPermission(str) && !PermissionApi.isGrantedPermission(activity, str) && (AndroidVersion.isAndroid11() || !PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE))) {
                StartActivityManager.startActivityForResult(this, PermissionUtils.getSmartPermissionIntent(activity, PermissionUtils.asArrayList(str)), getArguments().getInt(REQUEST_CODE));
                z = true;
            }
        }
        if (z) {
            return;
        }
        requestDangerousPermission();
    }

    public void requestDangerousPermission() {
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        int i = arguments.getInt(REQUEST_CODE);
        ArrayList<String> stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS);
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            return;
        }
        if (!AndroidVersion.isAndroid6()) {
            int size = stringArrayList.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = PermissionApi.isGrantedPermission(activity, stringArrayList.get(i2)) ? 0 : -1;
            }
            onRequestPermissionsResult(i, (String[]) stringArrayList.toArray(new String[0]), iArr);
            return;
        }
        if (AndroidVersion.isAndroid13() && stringArrayList.size() >= 2 && PermissionUtils.containsPermission(stringArrayList, Permission.BODY_SENSORS_BACKGROUND)) {
            ArrayList<String> arrayList = new ArrayList<>(stringArrayList);
            arrayList.remove(Permission.BODY_SENSORS_BACKGROUND);
            splitTwiceRequestPermission(activity, stringArrayList, arrayList, i);
            return;
        }
        if (AndroidVersion.isAndroid10() && stringArrayList.size() >= 2 && PermissionUtils.containsPermission(stringArrayList, Permission.ACCESS_BACKGROUND_LOCATION)) {
            ArrayList<String> arrayList2 = new ArrayList<>(stringArrayList);
            arrayList2.remove(Permission.ACCESS_BACKGROUND_LOCATION);
            splitTwiceRequestPermission(activity, stringArrayList, arrayList2, i);
        } else {
            if (AndroidVersion.isAndroid10() && PermissionUtils.containsPermission(stringArrayList, Permission.ACCESS_MEDIA_LOCATION) && PermissionUtils.containsPermission(stringArrayList, Permission.READ_EXTERNAL_STORAGE)) {
                ArrayList<String> arrayList3 = new ArrayList<>(stringArrayList);
                arrayList3.remove(Permission.ACCESS_MEDIA_LOCATION);
                splitTwiceRequestPermission(activity, stringArrayList, arrayList3, i);
                return;
            }
            requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), i);
        }
    }

    public void splitTwiceRequestPermission(Activity activity, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i) {
        ArrayList arrayList3 = new ArrayList(arrayList);
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.remove(it.next());
        }
        launch(activity, arrayList2, new IPermissionInterceptor() { // from class: com.hjq.permissions.PermissionFragment.1
        }, new AnonymousClass2(activity, arrayList3, arrayList, i));
    }

    /* renamed from: com.hjq.permissions.PermissionFragment$2, reason: invalid class name */
    class AnonymousClass2 implements OnPermissionCallback {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ ArrayList val$allPermissions;
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ ArrayList val$secondPermissions;

        AnonymousClass2(Activity activity, ArrayList arrayList, ArrayList arrayList2, int i) {
            this.val$activity = activity;
            this.val$secondPermissions = arrayList;
            this.val$allPermissions = arrayList2;
            this.val$requestCode = i;
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onGranted(List<String> list, boolean z) {
            if (z && PermissionFragment.this.isAdded()) {
                long j = AndroidVersion.isAndroid13() ? 150L : 0L;
                final Activity activity = this.val$activity;
                final ArrayList arrayList = this.val$secondPermissions;
                final ArrayList arrayList2 = this.val$allPermissions;
                final int i = this.val$requestCode;
                PermissionUtils.postDelayed(new Runnable() { // from class: com.hjq.permissions.-$$Lambda$PermissionFragment$2$rU54Qh7tptCP6D9FJD1K1VcoZEs
                    @Override // java.lang.Runnable
                    public final void run() {
                        PermissionFragment.AnonymousClass2.this.lambda$onGranted$0$PermissionFragment$2(activity, arrayList, arrayList2, i);
                    }
                }, j);
            }
        }

        public /* synthetic */ void lambda$onGranted$0$PermissionFragment$2(Activity activity, final ArrayList arrayList, final ArrayList arrayList2, final int i) {
            PermissionFragment.launch(activity, arrayList, new IPermissionInterceptor() { // from class: com.hjq.permissions.PermissionFragment.2.1
            }, new OnPermissionCallback() { // from class: com.hjq.permissions.PermissionFragment.2.2
                @Override // com.hjq.permissions.OnPermissionCallback
                public void onGranted(List<String> list, boolean z) {
                    if (z && PermissionFragment.this.isAdded()) {
                        int[] iArr = new int[arrayList2.size()];
                        Arrays.fill(iArr, 0);
                        PermissionFragment.this.onRequestPermissionsResult(i, (String[]) arrayList2.toArray(new String[0]), iArr);
                    }
                }

                @Override // com.hjq.permissions.OnPermissionCallback
                public void onDenied(List<String> list, boolean z) {
                    if (PermissionFragment.this.isAdded()) {
                        int[] iArr = new int[arrayList2.size()];
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            iArr[i2] = PermissionUtils.containsPermission(arrayList, (String) arrayList2.get(i2)) ? -1 : 0;
                        }
                        PermissionFragment.this.onRequestPermissionsResult(i, (String[]) arrayList2.toArray(new String[0]), iArr);
                    }
                }
            });
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onDenied(List<String> list, boolean z) {
            if (PermissionFragment.this.isAdded()) {
                int[] iArr = new int[this.val$allPermissions.size()];
                Arrays.fill(iArr, -1);
                PermissionFragment.this.onRequestPermissionsResult(this.val$requestCode, (String[]) this.val$allPermissions.toArray(new String[0]), iArr);
            }
        }
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr.length == 0 || iArr.length == 0) {
            return;
        }
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (activity == null || arguments == null || this.mInterceptor == null || i != arguments.getInt(REQUEST_CODE)) {
            return;
        }
        OnPermissionCallback onPermissionCallback = this.mCallBack;
        this.mCallBack = null;
        IPermissionInterceptor iPermissionInterceptor = this.mInterceptor;
        this.mInterceptor = null;
        PermissionUtils.optimizePermissionResults(activity, strArr, iArr);
        ArrayList asArrayList = PermissionUtils.asArrayList(strArr);
        REQUEST_CODE_ARRAY.remove(Integer.valueOf(i));
        detachActivity(activity);
        List<String> grantedPermissions = PermissionApi.getGrantedPermissions(asArrayList, iArr);
        if (grantedPermissions.size() == asArrayList.size()) {
            iPermissionInterceptor.grantedPermissionRequest(activity, asArrayList, grantedPermissions, true, onPermissionCallback);
            iPermissionInterceptor.finishPermissionRequest(activity, asArrayList, false, onPermissionCallback);
            return;
        }
        List<String> deniedPermissions = PermissionApi.getDeniedPermissions(asArrayList, iArr);
        iPermissionInterceptor.deniedPermissionRequest(activity, asArrayList, deniedPermissions, PermissionApi.isPermissionPermanentDenied(activity, deniedPermissions), onPermissionCallback);
        if (!grantedPermissions.isEmpty()) {
            iPermissionInterceptor.grantedPermissionRequest(activity, asArrayList, grantedPermissions, false, onPermissionCallback);
        }
        iPermissionInterceptor.finishPermissionRequest(activity, asArrayList, false, onPermissionCallback);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayList;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || this.mDangerousRequest || i != arguments.getInt(REQUEST_CODE) || (stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS)) == null || stringArrayList.isEmpty()) {
            return;
        }
        this.mDangerousRequest = true;
        PermissionUtils.postActivityResult(stringArrayList, this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isAdded()) {
            requestDangerousPermission();
        }
    }
}
