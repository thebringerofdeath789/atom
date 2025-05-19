package com.hjq.permissions;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class AndroidManifestInfo {
    ApplicationInfo applicationInfo;
    String packageName;
    UsesSdkInfo usesSdkInfo;
    final List<PermissionInfo> permissionInfoList = new ArrayList();
    final List<ActivityInfo> activityInfoList = new ArrayList();
    final List<ServiceInfo> serviceInfoList = new ArrayList();

    AndroidManifestInfo() {
    }

    static final class UsesSdkInfo {
        public int minSdkVersion;

        UsesSdkInfo() {
        }
    }

    static final class PermissionInfo {
        private static final int REQUESTED_PERMISSION_NEVER_FOR_LOCATION = 65536;
        public int maxSdkVersion;
        public String name;
        public int usesPermissionFlags;

        PermissionInfo() {
        }

        public boolean neverForLocation() {
            return (this.usesPermissionFlags & 65536) != 0;
        }
    }

    static final class ApplicationInfo {
        public String name;
        public boolean requestLegacyExternalStorage;

        ApplicationInfo() {
        }
    }

    static final class ActivityInfo {
        public String name;
        public boolean supportsPictureInPicture;

        ActivityInfo() {
        }
    }

    static final class ServiceInfo {
        public String name;
        public String permission;

        ServiceInfo() {
        }
    }
}
