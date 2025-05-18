package com.mapbox.mapboxsdk.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import com.mapbox.mapboxsdk.MapStrictMode;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.utils.FileUtils;
import com.mapbox.mapboxsdk.utils.ThreadUtils;
import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class FileSource {
    private static FileSource INSTANCE = null;
    private static final String MAPBOX_SHARED_PREFERENCE_RESOURCES_CACHE_PATH = "fileSourceResourcesCachePath";
    private static final String TAG = "Mbgl-FileSource";
    private static String internalCachePath;
    private static String resourcesCachePath;
    private long nativePtr;
    private static final Lock resourcesCachePathLoaderLock = new ReentrantLock();
    private static final Lock internalCachePathLoaderLock = new ReentrantLock();

    public interface ResourceTransformCallback {
        String onURL(int i, String str);
    }

    public interface ResourcesCachePathChangeCallback {
        void onError(String str);

        void onSuccess(String str);
    }

    private native void initialize(String str, String str2);

    private native void setResourceCachePath(String str, ResourcesCachePathChangeCallback resourcesCachePathChangeCallback);

    public native void activate();

    public native void deactivate();

    protected native void finalize() throws Throwable;

    public native String getAccessToken();

    public native boolean isActivated();

    public native void setAccessToken(String str);

    public native void setApiBaseUrl(String str);

    public native void setResourceTransform(ResourceTransformCallback resourceTransformCallback);

    public static synchronized FileSource getInstance(Context context) {
        FileSource fileSource;
        synchronized (FileSource.class) {
            if (INSTANCE == null) {
                INSTANCE = new FileSource(getResourcesCachePath(context));
            }
            fileSource = INSTANCE;
        }
        return fileSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCachePath(Context context) {
        String string = context.getSharedPreferences("MapboxSharedPreferences", 0).getString(MAPBOX_SHARED_PREFERENCE_RESOURCES_CACHE_PATH, null);
        if (isPathWritable(string)) {
            return string;
        }
        String defaultCachePath = getDefaultCachePath(context);
        context.getSharedPreferences("MapboxSharedPreferences", 0).edit().remove(MAPBOX_SHARED_PREFERENCE_RESOURCES_CACHE_PATH).apply();
        return defaultCachePath;
    }

    private static String getDefaultCachePath(Context context) {
        File externalFilesDir;
        if (isExternalStorageConfiguration(context) && isExternalStorageReadable() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return context.getFilesDir().getAbsolutePath();
    }

    private static boolean isExternalStorageConfiguration(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                return applicationInfo.metaData.getBoolean(MapboxConstants.KEY_META_DATA_SET_STORAGE_EXTERNAL, false);
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m1757e(TAG, "Failed to read the package metadata: ", e);
            MapStrictMode.strictModeViolation(e);
            return false;
        } catch (Exception e2) {
            Logger.m1757e(TAG, "Failed to read the storage key: ", e2);
            MapStrictMode.strictModeViolation(e2);
            return false;
        }
    }

    public static boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
            return true;
        }
        Logger.m1762w(TAG, "External storage was requested but it isn't readable. For API level < 18 make sure you've requested READ_EXTERNAL_STORAGE or WRITE_EXTERNAL_STORAGE permissions in your app Manifest (defaulting to internal storage).");
        return false;
    }

    public static void initializeFileDirsPaths(Context context) {
        ThreadUtils.checkThread(TAG);
        lockPathLoaders();
        if (resourcesCachePath == null || internalCachePath == null) {
            new FileDirsPathsTask().execute(context);
        }
    }

    private static class FileDirsPathsTask extends AsyncTask<Context, Void, String[]> {
        private FileDirsPathsTask() {
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            FileSource.unlockPathLoaders();
        }

        @Override // android.os.AsyncTask
        protected String[] doInBackground(Context... contextArr) {
            return new String[]{FileSource.getCachePath(contextArr[0]), contextArr[0].getCacheDir().getAbsolutePath()};
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(String[] strArr) {
            String unused = FileSource.resourcesCachePath = strArr[0];
            String unused2 = FileSource.internalCachePath = strArr[1];
            FileSource.unlockPathLoaders();
        }
    }

    public static String getResourcesCachePath(Context context) {
        Lock lock = resourcesCachePathLoaderLock;
        lock.lock();
        try {
            if (resourcesCachePath == null) {
                resourcesCachePath = getCachePath(context);
            }
            String str = resourcesCachePath;
            lock.unlock();
            return str;
        } catch (Throwable th) {
            resourcesCachePathLoaderLock.unlock();
            throw th;
        }
    }

    public static String getInternalCachePath(Context context) {
        Lock lock = internalCachePathLoaderLock;
        lock.lock();
        try {
            if (internalCachePath == null) {
                internalCachePath = context.getCacheDir().getAbsolutePath();
            }
            String str = internalCachePath;
            lock.unlock();
            return str;
        } catch (Throwable th) {
            internalCachePathLoaderLock.unlock();
            throw th;
        }
    }

    @Deprecated
    public static void setResourcesCachePath(Context context, String str, ResourcesCachePathChangeCallback resourcesCachePathChangeCallback) {
        setResourcesCachePath(str, resourcesCachePathChangeCallback);
    }

    public static void setResourcesCachePath(final String str, final ResourcesCachePathChangeCallback resourcesCachePathChangeCallback) {
        final Context applicationContext = Mapbox.getApplicationContext();
        getInstance(applicationContext);
        if (str.equals(getResourcesCachePath(applicationContext))) {
            resourcesCachePathChangeCallback.onSuccess(str);
        } else {
            new FileUtils.CheckFileWritePermissionTask(new FileUtils.OnCheckFileWritePermissionListener() { // from class: com.mapbox.mapboxsdk.storage.FileSource.1
                @Override // com.mapbox.mapboxsdk.utils.FileUtils.OnCheckFileWritePermissionListener
                public void onWritePermissionGranted() {
                    SharedPreferences.Editor edit = applicationContext.getSharedPreferences("MapboxSharedPreferences", 0).edit();
                    edit.putString(FileSource.MAPBOX_SHARED_PREFERENCE_RESOURCES_CACHE_PATH, str);
                    edit.apply();
                    FileSource.internalSetResourcesCachePath(applicationContext, str, resourcesCachePathChangeCallback);
                }

                @Override // com.mapbox.mapboxsdk.utils.FileUtils.OnCheckFileWritePermissionListener
                public void onError() {
                    String str2 = "Path is not writable: " + str;
                    Logger.m1756e(FileSource.TAG, str2);
                    resourcesCachePathChangeCallback.onError(str2);
                }
            }).execute(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void internalSetResourcesCachePath(Context context, String str, final ResourcesCachePathChangeCallback resourcesCachePathChangeCallback) {
        final FileSource fileSource = getInstance(context);
        final boolean isActivated = fileSource.isActivated();
        if (!isActivated) {
            fileSource.activate();
        }
        fileSource.setResourceCachePath(str, new ResourcesCachePathChangeCallback() { // from class: com.mapbox.mapboxsdk.storage.FileSource.2
            @Override // com.mapbox.mapboxsdk.storage.FileSource.ResourcesCachePathChangeCallback
            public void onSuccess(String str2) {
                if (!isActivated) {
                    fileSource.deactivate();
                }
                FileSource.resourcesCachePathLoaderLock.lock();
                String unused = FileSource.resourcesCachePath = str2;
                FileSource.resourcesCachePathLoaderLock.unlock();
                resourcesCachePathChangeCallback.onSuccess(str2);
            }

            @Override // com.mapbox.mapboxsdk.storage.FileSource.ResourcesCachePathChangeCallback
            public void onError(String str2) {
                if (!isActivated) {
                    fileSource.deactivate();
                }
                resourcesCachePathChangeCallback.onError(str2);
            }
        });
    }

    private static boolean isPathWritable(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return new File(str).canWrite();
    }

    private static void lockPathLoaders() {
        internalCachePathLoaderLock.lock();
        resourcesCachePathLoaderLock.lock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unlockPathLoaders() {
        resourcesCachePathLoaderLock.unlock();
        internalCachePathLoaderLock.unlock();
    }

    private FileSource(String str) {
        initialize(Mapbox.getAccessToken(), str);
    }
}