package com.logan.upgrade.enums;

import com.baidu.geofence.GeoFence;

/* loaded from: classes3.dex */
public enum BigPackageUploadFailType {
    UPLOAD_FAIL_PARAMS_INVALID(GeoFence.BUNDLE_KEY_CUSTOMID),
    UPLOAD_FAIL_INVALID_OPTION("7"),
    UPLOAD_FAIL_FILE_SYSTEM_ERROR("12"),
    UPLOAD_FAIL_UNKNOWN_ERROR(GeoFence.BUNDLE_KEY_LOCERRORCODE),
    UPLOAD_FAIL_FILE_MD5_ERROR("24"),
    UPLOAD_FAIL_EXIT("8"),
    UPLOAD_FAIL_TIMEOUT("88");

    public String value;

    BigPackageUploadFailType(String str) {
        this.value = str;
    }

    public static BigPackageUploadFailType getByValue(String str) {
        for (BigPackageUploadFailType bigPackageUploadFailType : values()) {
            if (bigPackageUploadFailType.value == str) {
                return bigPackageUploadFailType;
            }
        }
        return null;
    }
}
