package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class PermissionApi {
    private static final PermissionDelegate DELEGATE;

    PermissionApi() {
    }

    static {
        if (AndroidVersion.isAndroid13()) {
            DELEGATE = new PermissionDelegateImplV33();
            return;
        }
        if (AndroidVersion.isAndroid12()) {
            DELEGATE = new PermissionDelegateImplV31();
            return;
        }
        if (AndroidVersion.isAndroid11()) {
            DELEGATE = new PermissionDelegateImplV30();
            return;
        }
        if (AndroidVersion.isAndroid10()) {
            DELEGATE = new PermissionDelegateImplV29();
            return;
        }
        if (AndroidVersion.isAndroid9()) {
            DELEGATE = new PermissionDelegateImplV28();
            return;
        }
        if (AndroidVersion.isAndroid8()) {
            DELEGATE = new PermissionDelegateImplV26();
            return;
        }
        if (AndroidVersion.isAndroid6()) {
            DELEGATE = new PermissionDelegateImplV23();
            return;
        }
        if (AndroidVersion.isAndroid5()) {
            DELEGATE = new PermissionDelegateImplV21();
            return;
        }
        if (AndroidVersion.isAndroid4_4()) {
            DELEGATE = new PermissionDelegateImplV19();
        } else if (AndroidVersion.isAndroid4_3()) {
            DELEGATE = new PermissionDelegateImplV18();
        } else {
            DELEGATE = new PermissionDelegateImplV14();
        }
    }

    static boolean isGrantedPermission(Context context, String str) {
        return DELEGATE.isGrantedPermission(context, str);
    }

    static boolean isPermissionPermanentDenied(Activity activity, String str) {
        return DELEGATE.isPermissionPermanentDenied(activity, str);
    }

    static Intent getPermissionIntent(Context context, String str) {
        return DELEGATE.getPermissionIntent(context, str);
    }

    static boolean isSpecialPermission(String str) {
        return PermissionUtils.isSpecialPermission(str);
    }

    static boolean containsSpecialPermission(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (isSpecialPermission(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isGrantedPermissions(Context context, List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!isGrantedPermission(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    static List<String> getGrantedPermissions(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    static List<String> getDeniedPermissions(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (!isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    static boolean isPermissionPermanentDenied(Activity activity, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (isPermissionPermanentDenied(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    static List<String> getDeniedPermissions(List<String> list, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == -1) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    static List<String> getGrantedPermissions(List<String> list, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }
}
