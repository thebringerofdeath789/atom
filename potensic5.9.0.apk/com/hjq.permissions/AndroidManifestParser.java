package com.hjq.permissions;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.hjq.permissions.AndroidManifestInfo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
final class AndroidManifestParser {
    private static final String ANDROID_MANIFEST_FILE_NAME = "AndroidManifest.xml";
    private static final String ANDROID_NAMESPACE_URI = "http://schemas.android.com/apk/res/android";
    private static final String ATTR_MAX_SDK_VERSION = "maxSdkVersion";
    private static final String ATTR_MIN_SDK_VERSION = "minSdkVersion";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PACKAGE = "package";
    private static final String ATTR_PERMISSION = "permission";
    private static final String ATTR_REQUEST_LEGACY_EXTERNAL_STORAGE = "requestLegacyExternalStorage";
    private static final String ATTR_SUPPORTS_PICTURE_IN_PICTURE = "supportsPictureInPicture";
    private static final String ATTR_USES_PERMISSION_FLAGS = "usesPermissionFlags";
    private static final String TAG_ACTIVITY = "activity";
    private static final String TAG_ACTIVITY_ALIAS = "activity-alias";
    private static final String TAG_APPLICATION = "application";
    private static final String TAG_MANIFEST = "manifest";
    private static final String TAG_SERVICE = "service";
    private static final String TAG_USES_PERMISSION = "uses-permission";
    private static final String TAG_USES_PERMISSION_SDK_23 = "uses-permission-sdk-23";
    private static final String TAG_USES_PERMISSION_SDK_M = "uses-permission-sdk-m";
    private static final String TAG_USES_SDK = "uses-sdk";

    AndroidManifestParser() {
    }

    static AndroidManifestInfo parseAndroidManifest(Context context, int i) throws IOException, XmlPullParserException {
        AndroidManifestInfo androidManifestInfo = new AndroidManifestInfo();
        XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser(i, ANDROID_MANIFEST_FILE_NAME);
        do {
            if (openXmlResourceParser.getEventType() == 2) {
                String name = openXmlResourceParser.getName();
                if (TextUtils.equals(TAG_MANIFEST, name)) {
                    androidManifestInfo.packageName = openXmlResourceParser.getAttributeValue(null, "package");
                }
                if (TextUtils.equals(TAG_USES_SDK, name)) {
                    androidManifestInfo.usesSdkInfo = parseUsesSdkFromXml(openXmlResourceParser);
                }
                if (TextUtils.equals(TAG_USES_PERMISSION, name) || TextUtils.equals(TAG_USES_PERMISSION_SDK_23, name) || TextUtils.equals(TAG_USES_PERMISSION_SDK_M, name)) {
                    androidManifestInfo.permissionInfoList.add(parsePermissionFromXml(openXmlResourceParser));
                }
                if (TextUtils.equals("application", name)) {
                    androidManifestInfo.applicationInfo = parseApplicationFromXml(openXmlResourceParser);
                }
                if (TextUtils.equals(TAG_ACTIVITY, name) || TextUtils.equals(TAG_ACTIVITY_ALIAS, name)) {
                    androidManifestInfo.activityInfoList.add(parseActivityFromXml(openXmlResourceParser));
                }
                if (TextUtils.equals("service", name)) {
                    androidManifestInfo.serviceInfoList.add(parseServerFromXml(openXmlResourceParser));
                }
            }
        } while (openXmlResourceParser.next() != 1);
        openXmlResourceParser.close();
        return androidManifestInfo;
    }

    private static AndroidManifestInfo.UsesSdkInfo parseUsesSdkFromXml(XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.UsesSdkInfo usesSdkInfo = new AndroidManifestInfo.UsesSdkInfo();
        usesSdkInfo.minSdkVersion = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_MIN_SDK_VERSION, 0);
        return usesSdkInfo;
    }

    private static AndroidManifestInfo.PermissionInfo parsePermissionFromXml(XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.PermissionInfo permissionInfo = new AndroidManifestInfo.PermissionInfo();
        permissionInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "name");
        permissionInfo.maxSdkVersion = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_MAX_SDK_VERSION, Integer.MAX_VALUE);
        permissionInfo.usesPermissionFlags = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_USES_PERMISSION_FLAGS, 0);
        return permissionInfo;
    }

    private static AndroidManifestInfo.ApplicationInfo parseApplicationFromXml(XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ApplicationInfo applicationInfo = new AndroidManifestInfo.ApplicationInfo();
        applicationInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "name");
        applicationInfo.requestLegacyExternalStorage = xmlResourceParser.getAttributeBooleanValue(ANDROID_NAMESPACE_URI, ATTR_REQUEST_LEGACY_EXTERNAL_STORAGE, false);
        return applicationInfo;
    }

    private static AndroidManifestInfo.ActivityInfo parseActivityFromXml(XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ActivityInfo activityInfo = new AndroidManifestInfo.ActivityInfo();
        activityInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "name");
        activityInfo.supportsPictureInPicture = xmlResourceParser.getAttributeBooleanValue(ANDROID_NAMESPACE_URI, ATTR_SUPPORTS_PICTURE_IN_PICTURE, false);
        return activityInfo;
    }

    private static AndroidManifestInfo.ServiceInfo parseServerFromXml(XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ServiceInfo serviceInfo = new AndroidManifestInfo.ServiceInfo();
        serviceInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "name");
        serviceInfo.permission = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, ATTR_PERMISSION);
        return serviceInfo;
    }
}