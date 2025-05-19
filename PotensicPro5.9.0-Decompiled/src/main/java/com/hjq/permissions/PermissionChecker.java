package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.hjq.permissions.AndroidManifestInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class PermissionChecker {
    PermissionChecker() {
    }

    static boolean checkActivityStatus(Activity activity, boolean z) {
        if (activity == null) {
            if (z) {
                throw new IllegalArgumentException("The instance of the context must be an activity object");
            }
            return false;
        }
        if (activity.isFinishing()) {
            if (z) {
                throw new IllegalStateException("The activity has been finishing, please manually determine the status of the activity");
            }
            return false;
        }
        if (!AndroidVersion.isAndroid4_2() || !activity.isDestroyed()) {
            return true;
        }
        if (z) {
            throw new IllegalStateException("The activity has been destroyed, please manually determine the status of the activity");
        }
        return false;
    }

    static boolean checkPermissionArgument(List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            if (z) {
                throw new IllegalArgumentException("The requested permission cannot be empty");
            }
            return false;
        }
        if (AndroidVersion.getAndroidVersionCode() <= 33 && z) {
            ArrayList arrayList = new ArrayList();
            Field[] declaredFields = Permission.class.getDeclaredFields();
            if (declaredFields.length == 0) {
                return true;
            }
            for (Field field : declaredFields) {
                if (String.class.equals(field.getType())) {
                    try {
                        arrayList.add((String) field.get(null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            for (String str : list) {
                if (!PermissionUtils.containsPermission(arrayList, str)) {
                    throw new IllegalArgumentException("The " + str + " is not a dangerous permission or special permission, please do not request dynamically");
                }
            }
        }
        return true;
    }

    static void checkMediaLocationPermission(Context context, List<String> list) {
        if (PermissionUtils.containsPermission(list, Permission.ACCESS_MEDIA_LOCATION)) {
            for (String str : list) {
                if (!PermissionUtils.equalsPermission(str, Permission.ACCESS_MEDIA_LOCATION) && !PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_IMAGES) && !PermissionUtils.equalsPermission(str, Permission.READ_EXTERNAL_STORAGE) && !PermissionUtils.equalsPermission(str, Permission.WRITE_EXTERNAL_STORAGE) && !PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE)) {
                    throw new IllegalArgumentException("Because it includes access media location permissions, do not apply for permissions unrelated to access media location");
                }
            }
            if (AndroidVersion.getTargetSdkVersionCode(context) >= 33) {
                if (!PermissionUtils.containsPermission(list, Permission.READ_MEDIA_IMAGES) && !PermissionUtils.containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE)) {
                    throw new IllegalArgumentException("You must add android.permission.READ_MEDIA_IMAGES or android.permission.MANAGE_EXTERNAL_STORAGE rights to apply for android.permission.ACCESS_MEDIA_LOCATION rights");
                }
            } else if (!PermissionUtils.containsPermission(list, Permission.READ_EXTERNAL_STORAGE) && !PermissionUtils.containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE)) {
                throw new IllegalArgumentException("You must add android.permission.READ_EXTERNAL_STORAGE or android.permission.MANAGE_EXTERNAL_STORAGE rights to apply for android.permission.ACCESS_MEDIA_LOCATION rights");
            }
        }
    }

    static void checkStoragePermission(Context context, List<String> list, AndroidManifestInfo androidManifestInfo) {
        AndroidManifestInfo.ApplicationInfo applicationInfo;
        if (PermissionUtils.containsPermission(list, Permission.READ_MEDIA_IMAGES) || PermissionUtils.containsPermission(list, Permission.READ_MEDIA_VIDEO) || PermissionUtils.containsPermission(list, Permission.READ_MEDIA_AUDIO) || PermissionUtils.containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE) || PermissionUtils.containsPermission(list, Permission.READ_EXTERNAL_STORAGE) || PermissionUtils.containsPermission(list, Permission.WRITE_EXTERNAL_STORAGE)) {
            if (AndroidVersion.getTargetSdkVersionCode(context) >= 33 && PermissionUtils.containsPermission(list, Permission.READ_EXTERNAL_STORAGE)) {
                throw new IllegalArgumentException("When targetSdkVersion >= 33 should use android.permission.READ_MEDIA_IMAGES, android.permission.READ_MEDIA_VIDEO, android.permission.READ_MEDIA_AUDIO instead of android.permission.READ_EXTERNAL_STORAGE");
            }
            if (PermissionUtils.containsPermission(list, Permission.READ_MEDIA_IMAGES) || PermissionUtils.containsPermission(list, Permission.ACCESS_MEDIA_LOCATION) || androidManifestInfo == null || (applicationInfo = androidManifestInfo.applicationInfo) == null) {
                return;
            }
            boolean isScopedStorage = PermissionUtils.isScopedStorage(context);
            int targetSdkVersionCode = AndroidVersion.getTargetSdkVersionCode(context);
            boolean z = applicationInfo.requestLegacyExternalStorage;
            if (targetSdkVersionCode >= 29 && !z && (PermissionUtils.containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE) || !isScopedStorage)) {
                throw new IllegalStateException("Please register the android:requestLegacyExternalStorage=\"true\" attribute in the AndroidManifest.xml file, otherwise it will cause incompatibility with the old version");
            }
            if (targetSdkVersionCode >= 30 && !PermissionUtils.containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE) && !isScopedStorage) {
                throw new IllegalArgumentException("The storage permission application is abnormal. If you have adapted the scope storage, please register the <meta-data android:name=\"ScopedStorage\" android:value=\"true\" /> attribute in the AndroidManifest.xml file. If there is no adaptation scope storage, please use android.permission.MANAGE_EXTERNAL_STORAGE to apply for permission");
            }
        }
    }

    static void checkBodySensorsPermission(List<String> list) {
        if (PermissionUtils.containsPermission(list, Permission.BODY_SENSORS_BACKGROUND)) {
            if (PermissionUtils.containsPermission(list, Permission.BODY_SENSORS_BACKGROUND) && !PermissionUtils.containsPermission(list, Permission.BODY_SENSORS)) {
                throw new IllegalArgumentException("Applying for background sensor permissions must contain android.permission.BODY_SENSORS");
            }
            for (String str : list) {
                if (PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION)) {
                    throw new IllegalArgumentException("Applying for permissions android.permission.BODY_SENSORS_BACKGROUND and android.permission.ACCESS_BACKGROUND_LOCATION at the same time is not supported");
                }
                if (PermissionUtils.equalsPermission(str, Permission.ACCESS_MEDIA_LOCATION)) {
                    throw new IllegalArgumentException("Applying for permissions android.permission.BODY_SENSORS_BACKGROUND and android.permission.ACCESS_MEDIA_LOCATION at the same time is not supported");
                }
            }
        }
    }

    static void checkLocationPermission(List<String> list) {
        if (PermissionUtils.containsPermission(list, Permission.ACCESS_BACKGROUND_LOCATION)) {
            if (PermissionUtils.containsPermission(list, Permission.ACCESS_COARSE_LOCATION) && !PermissionUtils.containsPermission(list, Permission.ACCESS_FINE_LOCATION)) {
                throw new IllegalArgumentException("Applying for background positioning permissions must include android.permission.ACCESS_FINE_LOCATION");
            }
            for (String str : list) {
                if (!PermissionUtils.equalsPermission(str, Permission.ACCESS_FINE_LOCATION) && !PermissionUtils.equalsPermission(str, Permission.ACCESS_COARSE_LOCATION) && !PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION)) {
                    throw new IllegalArgumentException("Because it includes background location permissions, do not apply for permissions unrelated to location");
                }
            }
        }
    }

    static void checkNearbyDevicesPermission(List<String> list, AndroidManifestInfo androidManifestInfo) {
        if ((!PermissionUtils.containsPermission(list, Permission.BLUETOOTH_SCAN) && !PermissionUtils.containsPermission(list, Permission.NEARBY_WIFI_DEVICES)) || PermissionUtils.containsPermission(list, Permission.ACCESS_FINE_LOCATION) || androidManifestInfo == null) {
            return;
        }
        for (AndroidManifestInfo.PermissionInfo permissionInfo : androidManifestInfo.permissionInfoList) {
            if (PermissionUtils.equalsPermission(permissionInfo.name, Permission.BLUETOOTH_SCAN) || PermissionUtils.equalsPermission(permissionInfo.name, Permission.NEARBY_WIFI_DEVICES)) {
                if (!permissionInfo.neverForLocation()) {
                    String str = permissionInfo.maxSdkVersion != Integer.MAX_VALUE ? "android:maxSdkVersion=\"" + permissionInfo.maxSdkVersion + "\" " : "";
                    throw new IllegalArgumentException("If your app doesn't use " + permissionInfo.name + " to get physical location, please change the <uses-permission android:name=\"" + permissionInfo.name + "\" " + str + "/> node in the manifest file to <uses-permission android:name=\"" + permissionInfo.name + "\" android:usesPermissionFlags=\"neverForLocation\" " + str + "/> node, if your app need use " + permissionInfo.name + " to get physical location, also need to add " + Permission.ACCESS_FINE_LOCATION + " permissions");
                }
            }
        }
    }

    static void checkNotificationListenerPermission(List<String> list, AndroidManifestInfo androidManifestInfo) {
        if (PermissionUtils.containsPermission(list, Permission.BIND_NOTIFICATION_LISTENER_SERVICE) && androidManifestInfo != null) {
            List<AndroidManifestInfo.ServiceInfo> list2 = androidManifestInfo.serviceInfoList;
            for (int i = 0; i < list2.size(); i++) {
                if (TextUtils.equals(list2.get(i).permission, Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
                    return;
                }
            }
            throw new IllegalArgumentException("No service registered permission attribute, please register <service android:permission=\"android.permission.BIND_NOTIFICATION_LISTENER_SERVICE\" > in AndroidManifest.xml");
        }
    }

    static void checkPictureInPicturePermission(Activity activity, List<String> list, AndroidManifestInfo androidManifestInfo) {
        if (PermissionUtils.containsPermission(list, Permission.PICTURE_IN_PICTURE) && androidManifestInfo != null) {
            List<AndroidManifestInfo.ActivityInfo> list2 = androidManifestInfo.activityInfoList;
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).supportsPictureInPicture) {
                    return;
                }
            }
            throw new IllegalArgumentException("No activity registered supportsPictureInPicture attribute, please register \n<activity android:name=\"" + activity.getClass().getName().replace(activity.getPackageName(), "") + "\" android:supportsPictureInPicture=\"true\" > in AndroidManifest.xml");
        }
    }

    static void checkTargetSdkVersion(Context context, List<String> list) {
        int i;
        if (PermissionUtils.containsPermission(list, Permission.POST_NOTIFICATIONS) || PermissionUtils.containsPermission(list, Permission.NEARBY_WIFI_DEVICES) || PermissionUtils.containsPermission(list, Permission.BODY_SENSORS_BACKGROUND) || PermissionUtils.containsPermission(list, Permission.READ_MEDIA_IMAGES) || PermissionUtils.containsPermission(list, Permission.READ_MEDIA_VIDEO) || PermissionUtils.containsPermission(list, Permission.READ_MEDIA_AUDIO)) {
            i = 33;
        } else if (PermissionUtils.containsPermission(list, Permission.BLUETOOTH_SCAN) || PermissionUtils.containsPermission(list, Permission.BLUETOOTH_CONNECT) || PermissionUtils.containsPermission(list, Permission.BLUETOOTH_ADVERTISE) || PermissionUtils.containsPermission(list, Permission.SCHEDULE_EXACT_ALARM)) {
            i = 31;
        } else if (PermissionUtils.containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE)) {
            i = 30;
        } else if (PermissionUtils.containsPermission(list, Permission.ACCESS_BACKGROUND_LOCATION) || PermissionUtils.containsPermission(list, Permission.ACTIVITY_RECOGNITION) || PermissionUtils.containsPermission(list, Permission.ACCESS_MEDIA_LOCATION)) {
            i = 29;
        } else if (PermissionUtils.containsPermission(list, Permission.ACCEPT_HANDOVER)) {
            i = 28;
        } else {
            i = (PermissionUtils.containsPermission(list, Permission.REQUEST_INSTALL_PACKAGES) || PermissionUtils.containsPermission(list, Permission.ANSWER_PHONE_CALLS) || PermissionUtils.containsPermission(list, Permission.READ_PHONE_NUMBERS) || PermissionUtils.containsPermission(list, Permission.PICTURE_IN_PICTURE)) ? 26 : 23;
        }
        if (AndroidVersion.getTargetSdkVersionCode(context) < i) {
            throw new RuntimeException("The targetSdkVersion SDK must be " + i + " or more, if you do not want to upgrade targetSdkVersion, please apply with the old permissions");
        }
    }

    static void checkManifestPermissions(Context context, List<String> list, AndroidManifestInfo androidManifestInfo) {
        int i;
        if (androidManifestInfo == null) {
            return;
        }
        List<AndroidManifestInfo.PermissionInfo> list2 = androidManifestInfo.permissionInfoList;
        if (list2.isEmpty()) {
            throw new IllegalStateException("No permissions are registered in the AndroidManifest.xml file");
        }
        if (AndroidVersion.isAndroid7()) {
            i = context.getApplicationInfo().minSdkVersion;
        } else {
            i = androidManifestInfo.usesSdkInfo != null ? androidManifestInfo.usesSdkInfo.minSdkVersion : 23;
        }
        for (String str : list) {
            if (!PermissionUtils.equalsPermission(str, Permission.NOTIFICATION_SERVICE) && !PermissionUtils.equalsPermission(str, Permission.BIND_NOTIFICATION_LISTENER_SERVICE) && !PermissionUtils.equalsPermission(str, Permission.BIND_VPN_SERVICE) && !PermissionUtils.equalsPermission(str, Permission.PICTURE_IN_PICTURE)) {
                checkManifestPermission(list2, str);
                if (PermissionUtils.equalsPermission(str, Permission.BODY_SENSORS_BACKGROUND)) {
                    checkManifestPermission(list2, Permission.BODY_SENSORS);
                } else if (PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION)) {
                    if (AndroidVersion.getTargetSdkVersionCode(context) >= 31) {
                        checkManifestPermission(list2, Permission.ACCESS_FINE_LOCATION, 30);
                        checkManifestPermission(list2, Permission.ACCESS_COARSE_LOCATION);
                    } else {
                        checkManifestPermission(list2, Permission.ACCESS_FINE_LOCATION);
                    }
                } else {
                    if (i < 33) {
                        if (PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_IMAGES) || PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_VIDEO) || PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_AUDIO)) {
                            checkManifestPermission(list2, Permission.READ_EXTERNAL_STORAGE, 32);
                        } else if (PermissionUtils.equalsPermission(str, Permission.NEARBY_WIFI_DEVICES)) {
                            checkManifestPermission(list2, Permission.ACCESS_FINE_LOCATION, 32);
                        }
                    }
                    if (i < 31) {
                        if (PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_SCAN)) {
                            checkManifestPermission(list2, "android.permission.BLUETOOTH_ADMIN", 30);
                            checkManifestPermission(list2, Permission.ACCESS_FINE_LOCATION, 30);
                        } else if (PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_CONNECT)) {
                            checkManifestPermission(list2, "android.permission.BLUETOOTH", 30);
                        } else if (PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_ADVERTISE)) {
                            checkManifestPermission(list2, "android.permission.BLUETOOTH_ADMIN", 30);
                        }
                    }
                    if (i < 30 && PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE)) {
                        checkManifestPermission(list2, Permission.READ_EXTERNAL_STORAGE, 29);
                        checkManifestPermission(list2, Permission.WRITE_EXTERNAL_STORAGE, 29);
                    } else if (i < 26 && PermissionUtils.equalsPermission(str, Permission.READ_PHONE_NUMBERS)) {
                        checkManifestPermission(list2, Permission.READ_PHONE_STATE, 25);
                    } else if (PermissionUtils.equalsPermission(str, Permission.GET_INSTALLED_APPS)) {
                        checkManifestPermission(list2, "android.permission.QUERY_ALL_PACKAGES");
                    }
                }
            }
        }
    }

    static void checkManifestPermission(List<AndroidManifestInfo.PermissionInfo> list, String str) {
        checkManifestPermission(list, str, Integer.MAX_VALUE);
    }

    static void checkManifestPermission(List<AndroidManifestInfo.PermissionInfo> list, String str, int i) {
        AndroidManifestInfo.PermissionInfo permissionInfo;
        Iterator<AndroidManifestInfo.PermissionInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                permissionInfo = null;
                break;
            } else {
                permissionInfo = it.next();
                if (TextUtils.equals(permissionInfo.name, str)) {
                    break;
                }
            }
        }
        if (permissionInfo == null) {
            throw new IllegalStateException("Please register permissions in the AndroidManifest.xml file <uses-permission android:name=\"" + str + "\" />");
        }
        int i2 = permissionInfo.maxSdkVersion;
        if (i2 < i) {
            throw new IllegalArgumentException("The AndroidManifest.xml file <uses-permission android:name=\"" + str + "\" android:maxSdkVersion=\"" + i2 + "\" /> does not meet the requirements, " + (i != Integer.MAX_VALUE ? new StringBuilder().append("the minimum requirement for maxSdkVersion is ").append(i) : new StringBuilder().append("please delete the android:maxSdkVersion=\"").append(i2).append("\" attribute")).toString());
        }
    }

    static void optimizeDeprecatedPermission(List<String> list) {
        if (!AndroidVersion.isAndroid13()) {
            if (PermissionUtils.containsPermission(list, Permission.POST_NOTIFICATIONS) && !PermissionUtils.containsPermission(list, Permission.NOTIFICATION_SERVICE)) {
                list.add(Permission.NOTIFICATION_SERVICE);
            }
            if (PermissionUtils.containsPermission(list, Permission.NEARBY_WIFI_DEVICES) && !PermissionUtils.containsPermission(list, Permission.ACCESS_FINE_LOCATION)) {
                list.add(Permission.ACCESS_FINE_LOCATION);
            }
            if ((PermissionUtils.containsPermission(list, Permission.READ_MEDIA_IMAGES) || PermissionUtils.containsPermission(list, Permission.READ_MEDIA_VIDEO) || PermissionUtils.containsPermission(list, Permission.READ_MEDIA_AUDIO)) && !PermissionUtils.containsPermission(list, Permission.READ_EXTERNAL_STORAGE)) {
                list.add(Permission.READ_EXTERNAL_STORAGE);
            }
        }
        if (!AndroidVersion.isAndroid12() && PermissionUtils.containsPermission(list, Permission.BLUETOOTH_SCAN) && !PermissionUtils.containsPermission(list, Permission.ACCESS_FINE_LOCATION)) {
            list.add(Permission.ACCESS_FINE_LOCATION);
        }
        if (PermissionUtils.containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE)) {
            if (PermissionUtils.containsPermission(list, Permission.READ_EXTERNAL_STORAGE) || PermissionUtils.containsPermission(list, Permission.WRITE_EXTERNAL_STORAGE)) {
                throw new IllegalArgumentException("If you have applied for MANAGE_EXTERNAL_STORAGE permissions, do not apply for the READ_EXTERNAL_STORAGE and WRITE_EXTERNAL_STORAGE permissions");
            }
            if (!AndroidVersion.isAndroid11()) {
                list.add(Permission.READ_EXTERNAL_STORAGE);
                list.add(Permission.WRITE_EXTERNAL_STORAGE);
            }
        }
        if (!AndroidVersion.isAndroid10() && PermissionUtils.containsPermission(list, Permission.ACTIVITY_RECOGNITION) && !PermissionUtils.containsPermission(list, Permission.BODY_SENSORS)) {
            list.add(Permission.BODY_SENSORS);
        }
        if (AndroidVersion.isAndroid8() || !PermissionUtils.containsPermission(list, Permission.READ_PHONE_NUMBERS) || PermissionUtils.containsPermission(list, Permission.READ_PHONE_STATE)) {
            return;
        }
        list.add(Permission.READ_PHONE_STATE);
    }
}
