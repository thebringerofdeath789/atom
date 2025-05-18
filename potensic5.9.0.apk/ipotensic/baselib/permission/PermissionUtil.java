package com.ipotensic.baselib.permission;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.ipotensic.baselib.R;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.views.dailog.CustomPermissionDialog;
import com.ipotensic.baselib.views.dailog.PermissionDialog;
import com.ipotensic.baselib.views.dailog.ToGpsSettingDialog;
import com.tbruyelle.rxpermissions3.RxPermissions;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;

/* loaded from: classes2.dex */
public class PermissionUtil {
    private static final boolean IS_SDK_VERSION_BELOW_ANDROID13;
    public static final String[] MEDIA_AND_CAMERA_PERMISSION;
    public static final String[] MEDIA_AND_RECORD_PERMISSION;
    public static final String[] MEDIA_PERMISSION;

    public interface OnPermissionListener {
        void onDenied();

        void onDeniedWithNeverAsk(String... strArr);

        void onGrant();
    }

    static {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        boolean z = Build.VERSION.SDK_INT < 33;
        IS_SDK_VERSION_BELOW_ANDROID13 = z;
        if (z) {
            strArr = new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};
        } else {
            strArr = new String[]{Permission.READ_MEDIA_VIDEO, Permission.READ_MEDIA_IMAGES};
        }
        MEDIA_PERMISSION = strArr;
        if (z) {
            strArr2 = new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE, Permission.CAMERA};
        } else {
            strArr2 = new String[]{Permission.READ_MEDIA_VIDEO, Permission.READ_MEDIA_IMAGES, Permission.CAMERA};
        }
        MEDIA_AND_CAMERA_PERMISSION = strArr2;
        if (z) {
            strArr3 = new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE, Permission.CAMERA, Permission.RECORD_AUDIO};
        } else {
            strArr3 = new String[]{Permission.READ_MEDIA_VIDEO, Permission.READ_MEDIA_IMAGES, Permission.CAMERA, Permission.RECORD_AUDIO};
        }
        MEDIA_AND_RECORD_PERMISSION = strArr3;
    }

    public static boolean hasPermission(Context context, String... strArr) {
        return XXPermissions.isGranted(context, strArr);
    }

    public static boolean hasStoragePermission(Context context) {
        return hasPermission(context, MEDIA_PERMISSION);
    }

    public static boolean hasLocationPermission(Context context) {
        return hasPermission(context, Permission.ACCESS_FINE_LOCATION);
    }

    public static boolean hasLocationPermissionAndGpsEnable(AppCompatActivity appCompatActivity) {
        return hasPermission(appCompatActivity, Permission.ACCESS_FINE_LOCATION) && isGpsEnable(appCompatActivity);
    }

    private static void requestPermission(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener, String... strArr) {
        if (IS_SDK_VERSION_BELOW_ANDROID13) {
            new RxPermissions(appCompatActivity).requestEachCombined(strArr).subscribe(new Consumer() { // from class: com.ipotensic.baselib.permission.-$$Lambda$PermissionUtil$DJ44zYVMRyVKhILhbtyk7LpO1To
                public final /* synthetic */ AppCompatActivity f$1;
                public final /* synthetic */ String[] f$2;

                public /* synthetic */ $$Lambda$PermissionUtil$DJ44zYVMRyVKhILhbtyk7LpO1To(AppCompatActivity appCompatActivity2, String[] strArr2) {
                    r2 = appCompatActivity2;
                    r3 = strArr2;
                }

                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    PermissionUtil.lambda$requestPermission$0(PermissionUtil.OnPermissionListener.this, r2, r3, (com.tbruyelle.rxpermissions3.Permission) obj);
                }
            });
        } else {
            XXPermissions.with(appCompatActivity2).permission(strArr2).request(new OnPermissionCallback() { // from class: com.ipotensic.baselib.permission.PermissionUtil.1
                final /* synthetic */ AppCompatActivity val$context;

                AnonymousClass1(AppCompatActivity appCompatActivity2) {
                    r2 = appCompatActivity2;
                }

                @Override // com.hjq.permissions.OnPermissionCallback
                public void onGranted(List<String> list, boolean z) {
                    OnPermissionListener onPermissionListener2 = OnPermissionListener.this;
                    if (onPermissionListener2 != null) {
                        if (z) {
                            onPermissionListener2.onGrant();
                        } else {
                            onPermissionListener2.onDenied();
                        }
                    }
                }

                @Override // com.hjq.permissions.OnPermissionCallback
                public void onDenied(List<String> list, boolean z) {
                    if (z) {
                        XXPermissions.startPermissionActivity((Activity) r2);
                    }
                }
            });
        }
    }

    static /* synthetic */ void lambda$requestPermission$0(OnPermissionListener onPermissionListener, AppCompatActivity appCompatActivity, String[] strArr, com.tbruyelle.rxpermissions3.Permission permission) throws Throwable {
        if (permission.granted) {
            if (onPermissionListener != null) {
                onPermissionListener.onGrant();
            }
        } else if (!permission.shouldShowRequestPermissionRationale) {
            XXPermissions.startPermissionActivity((Activity) appCompatActivity);
            onPermissionListener.onDeniedWithNeverAsk(strArr);
        } else if (onPermissionListener != null) {
            onPermissionListener.onDenied();
        }
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$1 */
    class AnonymousClass1 implements OnPermissionCallback {
        final /* synthetic */ AppCompatActivity val$context;

        AnonymousClass1(AppCompatActivity appCompatActivity2) {
            r2 = appCompatActivity2;
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onGranted(List<String> list, boolean z) {
            OnPermissionListener onPermissionListener2 = OnPermissionListener.this;
            if (onPermissionListener2 != null) {
                if (z) {
                    onPermissionListener2.onGrant();
                } else {
                    onPermissionListener2.onDenied();
                }
            }
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onDenied(List<String> list, boolean z) {
            if (z) {
                XXPermissions.startPermissionActivity((Activity) r2);
            }
        }
    }

    public static void requestStoragePermission(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        requestPermission(appCompatActivity, onPermissionListener, MEDIA_PERMISSION);
    }

    public static void requestLocationPermission(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        requestPermission(appCompatActivity, onPermissionListener, Permission.ACCESS_FINE_LOCATION);
    }

    public static void requestCameraPermission(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        requestPermission(appCompatActivity, onPermissionListener, Permission.CAMERA);
    }

    public static void requestAudioPermission(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        requestPermission(appCompatActivity, onPermissionListener, Permission.RECORD_AUDIO);
    }

    public static void requestAllPermissionWithDialog(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        boolean hasStoragePermission = hasStoragePermission(appCompatActivity);
        boolean hasLocationPermission = hasLocationPermission(appCompatActivity);
        if (hasStoragePermission && hasLocationPermission) {
            if (onPermissionListener != null) {
                onPermissionListener.onGrant();
            }
        } else if (!hasStoragePermission && !hasLocationPermission) {
            new CustomPermissionDialog(appCompatActivity, appCompatActivity.getString(R.string.permission_content), new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.2
                final /* synthetic */ OnPermissionListener val$resultListener;

                AnonymousClass2(OnPermissionListener onPermissionListener2) {
                    r2 = onPermissionListener2;
                }

                /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$2$1 */
                class AnonymousClass1 implements OnPermissionListener {
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    AnonymousClass1() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                        if (r2 != null) {
                            r2.onDenied();
                        }
                    }
                }

                @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
                public void grantPermission() {
                    PermissionUtil.requestLocationPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.2.1
                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDeniedWithNeverAsk(String... strArr) {
                        }

                        AnonymousClass1() {
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onGrant() {
                            PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDenied() {
                            if (r2 != null) {
                                r2.onDenied();
                            }
                        }
                    });
                }
            }).show();
        } else if (!hasStoragePermission(appCompatActivity)) {
            new CustomPermissionDialog(appCompatActivity, appCompatActivity.getString(R.string.android_enter_flight_interface_access_external_storage_tips), new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.3
                final /* synthetic */ OnPermissionListener val$resultListener;

                AnonymousClass3(OnPermissionListener onPermissionListener2) {
                    r2 = onPermissionListener2;
                }

                @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
                public void grantPermission() {
                    PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
                }
            }).show();
        } else {
            if (hasLocationPermissionAndGpsEnable(appCompatActivity)) {
                return;
            }
            requestLocationPermissionWithDialog(appCompatActivity, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.baselib.permission.PermissionUtil.4
                AnonymousClass4() {
                }

                @Override // com.ipotensic.baselib.listener.SimpleResultListener
                public void onResult(Boolean bool) {
                    if (OnPermissionListener.this != null) {
                        if (bool.booleanValue()) {
                            OnPermissionListener.this.onGrant();
                        } else {
                            OnPermissionListener.this.onDenied();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$2 */
    class AnonymousClass2 implements CustomPermissionDialog.RequestPermissionListener {
        final /* synthetic */ OnPermissionListener val$resultListener;

        AnonymousClass2(OnPermissionListener onPermissionListener2) {
            r2 = onPermissionListener2;
        }

        /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$2$1 */
        class AnonymousClass1 implements OnPermissionListener {
            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
                if (r2 != null) {
                    r2.onDenied();
                }
            }
        }

        @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
        public void grantPermission() {
            PermissionUtil.requestLocationPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.2.1
                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDeniedWithNeverAsk(String... strArr) {
                }

                AnonymousClass1() {
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onGrant() {
                    PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDenied() {
                    if (r2 != null) {
                        r2.onDenied();
                    }
                }
            });
        }
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$3 */
    class AnonymousClass3 implements CustomPermissionDialog.RequestPermissionListener {
        final /* synthetic */ OnPermissionListener val$resultListener;

        AnonymousClass3(OnPermissionListener onPermissionListener2) {
            r2 = onPermissionListener2;
        }

        @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
        public void grantPermission() {
            PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
        }
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$4 */
    class AnonymousClass4 implements SimpleResultListener<Boolean> {
        AnonymousClass4() {
        }

        @Override // com.ipotensic.baselib.listener.SimpleResultListener
        public void onResult(Boolean bool) {
            if (OnPermissionListener.this != null) {
                if (bool.booleanValue()) {
                    OnPermissionListener.this.onGrant();
                } else {
                    OnPermissionListener.this.onDenied();
                }
            }
        }
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$5 */
    class AnonymousClass5 implements OnPermissionListener {
        final /* synthetic */ OnPermissionListener val$resultListener;

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDeniedWithNeverAsk(String... strArr) {
        }

        AnonymousClass5(OnPermissionListener onPermissionListener) {
            r2 = onPermissionListener;
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onGrant() {
            PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDenied() {
            r2.onDenied();
        }
    }

    public static void requestCameraAndStoragePermission(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        requestCameraPermission(appCompatActivity, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.5
            final /* synthetic */ OnPermissionListener val$resultListener;

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            AnonymousClass5(OnPermissionListener onPermissionListener2) {
                r2 = onPermissionListener2;
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
                r2.onDenied();
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$6 */
    class AnonymousClass6 implements OnPermissionListener {
        final /* synthetic */ OnPermissionListener val$resultListener;

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDeniedWithNeverAsk(String... strArr) {
        }

        AnonymousClass6(OnPermissionListener onPermissionListener) {
            r2 = onPermissionListener;
        }

        /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$6$1 */
        class AnonymousClass1 implements OnPermissionListener {
            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
                r2.onDenied();
            }
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onGrant() {
            PermissionUtil.requestAudioPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.6.1
                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDeniedWithNeverAsk(String... strArr) {
                }

                AnonymousClass1() {
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onGrant() {
                    PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDenied() {
                    r2.onDenied();
                }
            });
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDenied() {
            r2.onDenied();
        }
    }

    public static void requestCameraAndAudioAndStoragePermission(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        requestCameraPermission(appCompatActivity, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.6
            final /* synthetic */ OnPermissionListener val$resultListener;

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            AnonymousClass6(OnPermissionListener onPermissionListener2) {
                r2 = onPermissionListener2;
            }

            /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$6$1 */
            class AnonymousClass1 implements OnPermissionListener {
                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDeniedWithNeverAsk(String... strArr) {
                }

                AnonymousClass1() {
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onGrant() {
                    PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDenied() {
                    r2.onDenied();
                }
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                PermissionUtil.requestAudioPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.6.1
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    AnonymousClass1() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                        r2.onDenied();
                    }
                });
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
                r2.onDenied();
            }
        });
    }

    public static void requestStoragePermissionWithDialog(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        if (!hasPermission(appCompatActivity, MEDIA_PERMISSION)) {
            new PermissionDialog(appCompatActivity, new PermissionDialog.OnGrantListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.7
                final /* synthetic */ OnPermissionListener val$resultListener;

                AnonymousClass7(OnPermissionListener onPermissionListener2) {
                    r2 = onPermissionListener2;
                }

                @Override // com.ipotensic.baselib.views.dailog.PermissionDialog.OnGrantListener
                public void onGrant(boolean z) {
                    if (z) {
                        PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
                    }
                }
            }).show();
        } else if (onPermissionListener2 != null) {
            onPermissionListener2.onGrant();
        }
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$7 */
    class AnonymousClass7 implements PermissionDialog.OnGrantListener {
        final /* synthetic */ OnPermissionListener val$resultListener;

        AnonymousClass7(OnPermissionListener onPermissionListener2) {
            r2 = onPermissionListener2;
        }

        @Override // com.ipotensic.baselib.views.dailog.PermissionDialog.OnGrantListener
        public void onGrant(boolean z) {
            if (z) {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
            }
        }
    }

    public static void requestStoragePermissionInDownloadWithDialog(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        if (hasStoragePermission(appCompatActivity)) {
            onPermissionListener.onGrant();
            return;
        }
        String string = appCompatActivity.getString(R.string.button_refuse);
        String string2 = appCompatActivity.getString(R.string.button_allow);
        if (!SPHelper.getInstance().getBoolean("key_is_first_camera_and_storage_permission_show", false)) {
            SPHelper.getInstance().putBoolean("key_is_first_camera_and_storage_permission_show", true);
        } else {
            string = appCompatActivity.getString(R.string.dialog_cancel);
            string2 = appCompatActivity.getString(R.string.dialog_location_confirm);
        }
        String string3 = appCompatActivity.getString(R.string.android_manual_download_tips);
        new CustomPermissionDialog(appCompatActivity, null, string3, string, string2, new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.8
            final /* synthetic */ OnPermissionListener val$resultListener;

            AnonymousClass8(OnPermissionListener onPermissionListener2) {
                r2 = onPermissionListener2;
            }

            @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
            public void grantPermission() {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
            }
        }).show();
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$8 */
    class AnonymousClass8 implements CustomPermissionDialog.RequestPermissionListener {
        final /* synthetic */ OnPermissionListener val$resultListener;

        AnonymousClass8(OnPermissionListener onPermissionListener2) {
            r2 = onPermissionListener2;
        }

        @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
        public void grantPermission() {
            PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
        }
    }

    public static void requestStoragePermissionInShareWithDialog(AppCompatActivity appCompatActivity, OnPermissionListener onPermissionListener) {
        if (hasStoragePermission(appCompatActivity)) {
            onPermissionListener.onGrant();
            return;
        }
        String string = appCompatActivity.getString(R.string.button_refuse);
        String string2 = appCompatActivity.getString(R.string.button_allow);
        if (!SPHelper.getInstance().getBoolean("key_is_first_camera_and_storage_permission_show", false)) {
            SPHelper.getInstance().putBoolean("key_is_first_camera_and_storage_permission_show", true);
        } else {
            string = appCompatActivity.getString(R.string.dialog_cancel);
            string2 = appCompatActivity.getString(R.string.dialog_location_confirm);
        }
        String string3 = appCompatActivity.getString(R.string.android_manual_share_tips);
        new CustomPermissionDialog(appCompatActivity, null, string3, string, string2, new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.9
            final /* synthetic */ OnPermissionListener val$resultListener;

            AnonymousClass9(OnPermissionListener onPermissionListener2) {
                r2 = onPermissionListener2;
            }

            @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
            public void grantPermission() {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
            }
        }).show();
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$9 */
    class AnonymousClass9 implements CustomPermissionDialog.RequestPermissionListener {
        final /* synthetic */ OnPermissionListener val$resultListener;

        AnonymousClass9(OnPermissionListener onPermissionListener2) {
            r2 = onPermissionListener2;
        }

        @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
        public void grantPermission() {
            PermissionUtil.requestStoragePermission(AppCompatActivity.this, r2);
        }
    }

    public static boolean isGpsEnable(Context context) {
        return ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
    }

    public static BaseSyncDialog requestLocationPermissionAndGpsEnable(BaseActivity baseActivity, SimpleResultListener<Boolean> simpleResultListener) {
        try {
            boolean isGpsEnable = isGpsEnable(baseActivity);
            boolean hasPermission = hasPermission(baseActivity, Permission.ACCESS_FINE_LOCATION);
            if (!isGpsEnable && hasPermission) {
                return toLocationSettingWithDialog(baseActivity, simpleResultListener);
            }
            if (!hasPermission && isGpsEnable) {
                return requestLocationPermissionWithDialog(baseActivity, simpleResultListener);
            }
            if (!isGpsEnable && !hasPermission) {
                return toLocationSettingWithDialog(baseActivity, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.baselib.permission.PermissionUtil.10
                    final /* synthetic */ SimpleResultListener val$resultListener;

                    AnonymousClass10(SimpleResultListener simpleResultListener2) {
                        r2 = simpleResultListener2;
                    }

                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public void onResult(Boolean bool) {
                        if (bool.booleanValue()) {
                            PermissionUtil.requestLocationPermissionWithDialog(BaseActivity.this, r2);
                        }
                    }
                });
            }
            if (simpleResultListener2 == null) {
                return null;
            }
            simpleResultListener2.onResult(true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$10 */
    class AnonymousClass10 implements SimpleResultListener<Boolean> {
        final /* synthetic */ SimpleResultListener val$resultListener;

        AnonymousClass10(SimpleResultListener simpleResultListener2) {
            r2 = simpleResultListener2;
        }

        @Override // com.ipotensic.baselib.listener.SimpleResultListener
        public void onResult(Boolean bool) {
            if (bool.booleanValue()) {
                PermissionUtil.requestLocationPermissionWithDialog(BaseActivity.this, r2);
            }
        }
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$11 */
    class AnonymousClass11 implements CustomPermissionDialog.RequestPermissionListener {
        final /* synthetic */ SimpleResultListener val$resultListener;

        AnonymousClass11(SimpleResultListener simpleResultListener) {
            r2 = simpleResultListener;
        }

        /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$11$1 */
        class AnonymousClass1 implements OnPermissionListener {
            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                if (r2 != null) {
                    r2.onResult(true);
                }
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
                if (r2 != null) {
                    r2.onResult(false);
                }
            }
        }

        @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
        public void grantPermission() {
            PermissionUtil.requestLocationPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.11.1
                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDeniedWithNeverAsk(String... strArr) {
                }

                AnonymousClass1() {
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onGrant() {
                    if (r2 != null) {
                        r2.onResult(true);
                    }
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDenied() {
                    if (r2 != null) {
                        r2.onResult(false);
                    }
                }
            });
        }
    }

    public static BaseSyncDialog requestLocationPermissionWithDialog(AppCompatActivity appCompatActivity, SimpleResultListener<Boolean> simpleResultListener) {
        CustomPermissionDialog customPermissionDialog = new CustomPermissionDialog(appCompatActivity, appCompatActivity.getString(R.string.android_enter_flight_interface_access_location_tips), new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.11
            final /* synthetic */ SimpleResultListener val$resultListener;

            AnonymousClass11(SimpleResultListener simpleResultListener2) {
                r2 = simpleResultListener2;
            }

            /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$11$1 */
            class AnonymousClass1 implements OnPermissionListener {
                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDeniedWithNeverAsk(String... strArr) {
                }

                AnonymousClass1() {
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onGrant() {
                    if (r2 != null) {
                        r2.onResult(true);
                    }
                }

                @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                public void onDenied() {
                    if (r2 != null) {
                        r2.onResult(false);
                    }
                }
            }

            @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
            public void grantPermission() {
                PermissionUtil.requestLocationPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.11.1
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    AnonymousClass1() {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        if (r2 != null) {
                            r2.onResult(true);
                        }
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                        if (r2 != null) {
                            r2.onResult(false);
                        }
                    }
                });
            }
        });
        customPermissionDialog.show();
        return customPermissionDialog;
    }

    /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$12 */
    class AnonymousClass12 implements ToGpsSettingDialog.ResultListener<Boolean> {
        final /* synthetic */ SimpleResultListener val$resultListener;

        AnonymousClass12(SimpleResultListener simpleResultListener) {
            r2 = simpleResultListener;
        }

        @Override // com.ipotensic.baselib.views.dailog.ToGpsSettingDialog.ResultListener
        public void onResult(Dialog dialog, Boolean bool) {
            if (bool.booleanValue()) {
                BaseActivity.this.registerActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), new SimpleResultListener<ActivityResult>() { // from class: com.ipotensic.baselib.permission.PermissionUtil.12.1
                    final /* synthetic */ Dialog val$dialog;

                    AnonymousClass1(Dialog dialog2) {
                        r2 = dialog2;
                    }

                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public void onResult(ActivityResult activityResult) {
                        boolean isGpsEnable = PermissionUtil.isGpsEnable(BaseActivity.this);
                        if (r2 != null) {
                            r2.onResult(Boolean.valueOf(isGpsEnable));
                        }
                        if (isGpsEnable) {
                            r2.dismiss();
                        }
                    }
                });
            }
        }

        /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$12$1 */
        class AnonymousClass1 implements SimpleResultListener<ActivityResult> {
            final /* synthetic */ Dialog val$dialog;

            AnonymousClass1(Dialog dialog2) {
                r2 = dialog2;
            }

            @Override // com.ipotensic.baselib.listener.SimpleResultListener
            public void onResult(ActivityResult activityResult) {
                boolean isGpsEnable = PermissionUtil.isGpsEnable(BaseActivity.this);
                if (r2 != null) {
                    r2.onResult(Boolean.valueOf(isGpsEnable));
                }
                if (isGpsEnable) {
                    r2.dismiss();
                }
            }
        }
    }

    public static BaseSyncDialog toLocationSettingWithDialog(BaseActivity baseActivity, SimpleResultListener<Boolean> simpleResultListener) {
        if (BaseSyncDialog.isShow) {
            return null;
        }
        ToGpsSettingDialog toGpsSettingDialog = new ToGpsSettingDialog(baseActivity, new ToGpsSettingDialog.ResultListener<Boolean>() { // from class: com.ipotensic.baselib.permission.PermissionUtil.12
            final /* synthetic */ SimpleResultListener val$resultListener;

            AnonymousClass12(SimpleResultListener simpleResultListener2) {
                r2 = simpleResultListener2;
            }

            @Override // com.ipotensic.baselib.views.dailog.ToGpsSettingDialog.ResultListener
            public void onResult(Dialog dialog2, Boolean bool) {
                if (bool.booleanValue()) {
                    BaseActivity.this.registerActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), new SimpleResultListener<ActivityResult>() { // from class: com.ipotensic.baselib.permission.PermissionUtil.12.1
                        final /* synthetic */ Dialog val$dialog;

                        AnonymousClass1(Dialog dialog22) {
                            r2 = dialog22;
                        }

                        @Override // com.ipotensic.baselib.listener.SimpleResultListener
                        public void onResult(ActivityResult activityResult) {
                            boolean isGpsEnable = PermissionUtil.isGpsEnable(BaseActivity.this);
                            if (r2 != null) {
                                r2.onResult(Boolean.valueOf(isGpsEnable));
                            }
                            if (isGpsEnable) {
                                r2.dismiss();
                            }
                        }
                    });
                }
            }

            /* renamed from: com.ipotensic.baselib.permission.PermissionUtil$12$1 */
            class AnonymousClass1 implements SimpleResultListener<ActivityResult> {
                final /* synthetic */ Dialog val$dialog;

                AnonymousClass1(Dialog dialog22) {
                    r2 = dialog22;
                }

                @Override // com.ipotensic.baselib.listener.SimpleResultListener
                public void onResult(ActivityResult activityResult) {
                    boolean isGpsEnable = PermissionUtil.isGpsEnable(BaseActivity.this);
                    if (r2 != null) {
                        r2.onResult(Boolean.valueOf(isGpsEnable));
                    }
                    if (isGpsEnable) {
                        r2.dismiss();
                    }
                }
            }
        });
        toGpsSettingDialog.show();
        return toGpsSettingDialog;
    }
}