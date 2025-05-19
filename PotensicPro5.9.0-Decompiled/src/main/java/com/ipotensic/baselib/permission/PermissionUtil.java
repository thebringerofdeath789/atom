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
        boolean z = Build.VERSION.SDK_INT < 33;
        IS_SDK_VERSION_BELOW_ANDROID13 = z;
        MEDIA_PERMISSION = z ? new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE} : new String[]{Permission.READ_MEDIA_VIDEO, Permission.READ_MEDIA_IMAGES};
        MEDIA_AND_CAMERA_PERMISSION = z ? new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE, Permission.CAMERA} : new String[]{Permission.READ_MEDIA_VIDEO, Permission.READ_MEDIA_IMAGES, Permission.CAMERA};
        MEDIA_AND_RECORD_PERMISSION = z ? new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE, Permission.CAMERA, Permission.RECORD_AUDIO} : new String[]{Permission.READ_MEDIA_VIDEO, Permission.READ_MEDIA_IMAGES, Permission.CAMERA, Permission.RECORD_AUDIO};
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

    private static void requestPermission(final AppCompatActivity appCompatActivity, final OnPermissionListener onPermissionListener, final String... strArr) {
        if (IS_SDK_VERSION_BELOW_ANDROID13) {
            new RxPermissions(appCompatActivity).requestEachCombined(strArr).subscribe(new Consumer() { // from class: com.ipotensic.baselib.permission.-$$Lambda$PermissionUtil$DJ44zYVMRyVKhILhbtyk7LpO1To
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    PermissionUtil.lambda$requestPermission$0(PermissionUtil.OnPermissionListener.this, appCompatActivity, strArr, (com.tbruyelle.rxpermissions3.Permission) obj);
                }
            });
        } else {
            XXPermissions.with(appCompatActivity).permission(strArr).request(new OnPermissionCallback() { // from class: com.ipotensic.baselib.permission.PermissionUtil.1
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
                        XXPermissions.startPermissionActivity((Activity) appCompatActivity);
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

    public static void requestAllPermissionWithDialog(final AppCompatActivity appCompatActivity, final OnPermissionListener onPermissionListener) {
        boolean hasStoragePermission = hasStoragePermission(appCompatActivity);
        boolean hasLocationPermission = hasLocationPermission(appCompatActivity);
        if (hasStoragePermission && hasLocationPermission) {
            if (onPermissionListener != null) {
                onPermissionListener.onGrant();
            }
        } else if (!hasStoragePermission && !hasLocationPermission) {
            new CustomPermissionDialog(appCompatActivity, appCompatActivity.getString(R.string.permission_content), new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.2
                @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
                public void grantPermission() {
                    PermissionUtil.requestLocationPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.2.1
                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDeniedWithNeverAsk(String... strArr) {
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onGrant() {
                            PermissionUtil.requestStoragePermission(AppCompatActivity.this, onPermissionListener);
                        }

                        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                        public void onDenied() {
                            if (onPermissionListener != null) {
                                onPermissionListener.onDenied();
                            }
                        }
                    });
                }
            }).show();
        } else if (!hasStoragePermission(appCompatActivity)) {
            new CustomPermissionDialog(appCompatActivity, appCompatActivity.getString(R.string.android_enter_flight_interface_access_external_storage_tips), new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.3
                @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
                public void grantPermission() {
                    PermissionUtil.requestStoragePermission(AppCompatActivity.this, onPermissionListener);
                }
            }).show();
        } else {
            if (hasLocationPermissionAndGpsEnable(appCompatActivity)) {
                return;
            }
            requestLocationPermissionWithDialog(appCompatActivity, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.baselib.permission.PermissionUtil.4
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

    public static void requestCameraAndStoragePermission(final AppCompatActivity appCompatActivity, final OnPermissionListener onPermissionListener) {
        requestCameraPermission(appCompatActivity, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.5
            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, onPermissionListener);
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
                onPermissionListener.onDenied();
            }
        });
    }

    public static void requestCameraAndAudioAndStoragePermission(final AppCompatActivity appCompatActivity, final OnPermissionListener onPermissionListener) {
        requestCameraPermission(appCompatActivity, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.6
            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                PermissionUtil.requestAudioPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.6.1
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        PermissionUtil.requestStoragePermission(AppCompatActivity.this, onPermissionListener);
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                        onPermissionListener.onDenied();
                    }
                });
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
                onPermissionListener.onDenied();
            }
        });
    }

    public static void requestStoragePermissionWithDialog(final AppCompatActivity appCompatActivity, final OnPermissionListener onPermissionListener) {
        if (!hasPermission(appCompatActivity, MEDIA_PERMISSION)) {
            new PermissionDialog(appCompatActivity, new PermissionDialog.OnGrantListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.7
                @Override // com.ipotensic.baselib.views.dailog.PermissionDialog.OnGrantListener
                public void onGrant(boolean z) {
                    if (z) {
                        PermissionUtil.requestStoragePermission(AppCompatActivity.this, onPermissionListener);
                    }
                }
            }).show();
        } else if (onPermissionListener != null) {
            onPermissionListener.onGrant();
        }
    }

    public static void requestStoragePermissionInDownloadWithDialog(final AppCompatActivity appCompatActivity, final OnPermissionListener onPermissionListener) {
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
            @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
            public void grantPermission() {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, onPermissionListener);
            }
        }).show();
    }

    public static void requestStoragePermissionInShareWithDialog(final AppCompatActivity appCompatActivity, final OnPermissionListener onPermissionListener) {
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
            @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
            public void grantPermission() {
                PermissionUtil.requestStoragePermission(AppCompatActivity.this, onPermissionListener);
            }
        }).show();
    }

    public static boolean isGpsEnable(Context context) {
        return ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
    }

    public static BaseSyncDialog requestLocationPermissionAndGpsEnable(final BaseActivity baseActivity, final SimpleResultListener<Boolean> simpleResultListener) {
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
                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public void onResult(Boolean bool) {
                        if (bool.booleanValue()) {
                            PermissionUtil.requestLocationPermissionWithDialog(BaseActivity.this, simpleResultListener);
                        }
                    }
                });
            }
            if (simpleResultListener == null) {
                return null;
            }
            simpleResultListener.onResult(true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BaseSyncDialog requestLocationPermissionWithDialog(final AppCompatActivity appCompatActivity, final SimpleResultListener<Boolean> simpleResultListener) {
        CustomPermissionDialog customPermissionDialog = new CustomPermissionDialog(appCompatActivity, appCompatActivity.getString(R.string.android_enter_flight_interface_access_location_tips), new CustomPermissionDialog.RequestPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.11
            @Override // com.ipotensic.baselib.views.dailog.CustomPermissionDialog.RequestPermissionListener
            public void grantPermission() {
                PermissionUtil.requestLocationPermission(AppCompatActivity.this, new OnPermissionListener() { // from class: com.ipotensic.baselib.permission.PermissionUtil.11.1
                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDeniedWithNeverAsk(String... strArr) {
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onGrant() {
                        if (simpleResultListener != null) {
                            simpleResultListener.onResult(true);
                        }
                    }

                    @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
                    public void onDenied() {
                        if (simpleResultListener != null) {
                            simpleResultListener.onResult(false);
                        }
                    }
                });
            }
        });
        customPermissionDialog.show();
        return customPermissionDialog;
    }

    public static BaseSyncDialog toLocationSettingWithDialog(final BaseActivity baseActivity, final SimpleResultListener<Boolean> simpleResultListener) {
        if (BaseSyncDialog.isShow) {
            return null;
        }
        ToGpsSettingDialog toGpsSettingDialog = new ToGpsSettingDialog(baseActivity, new ToGpsSettingDialog.ResultListener<Boolean>() { // from class: com.ipotensic.baselib.permission.PermissionUtil.12
            @Override // com.ipotensic.baselib.views.dailog.ToGpsSettingDialog.ResultListener
            public void onResult(final Dialog dialog, Boolean bool) {
                if (bool.booleanValue()) {
                    BaseActivity.this.registerActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), new SimpleResultListener<ActivityResult>() { // from class: com.ipotensic.baselib.permission.PermissionUtil.12.1
                        @Override // com.ipotensic.baselib.listener.SimpleResultListener
                        public void onResult(ActivityResult activityResult) {
                            boolean isGpsEnable = PermissionUtil.isGpsEnable(BaseActivity.this);
                            if (simpleResultListener != null) {
                                simpleResultListener.onResult(Boolean.valueOf(isGpsEnable));
                            }
                            if (isGpsEnable) {
                                dialog.dismiss();
                            }
                        }
                    });
                }
            }
        });
        toGpsSettingDialog.show();
        return toGpsSettingDialog;
    }
}
