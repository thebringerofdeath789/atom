package com.mapbox.mapboxsdk.offline;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mapbox.mapboxsdk.LibraryLoader;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.TelemetryDefinition;
import com.mapbox.mapboxsdk.net.ConnectivityReceiver;
import com.mapbox.mapboxsdk.storage.FileSource;
import com.mapbox.mapboxsdk.utils.FileUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class OfflineManager {
    private static final String TAG = "Mbgl - OfflineManager";
    private static OfflineManager instance;
    private Context context;
    private final FileSource fileSource;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private long nativePtr;

    public interface CreateOfflineRegionCallback {
        void onCreate(OfflineRegion offlineRegion);

        void onError(String str);
    }

    public interface FileSourceCallback {
        void onError(String str);

        void onSuccess();
    }

    public interface ListOfflineRegionsCallback {
        void onError(String str);

        void onList(OfflineRegion[] offlineRegionArr);
    }

    public interface MergeOfflineRegionsCallback {
        void onError(String str);

        void onMerge(OfflineRegion[] offlineRegionArr);
    }

    public interface PrefetchAmbientCacheCallback {
        void onError(long j, String str);

        void onSuccess(long j);
    }

    private native void createOfflineRegion(FileSource fileSource, OfflineRegionDefinition offlineRegionDefinition, byte[] bArr, CreateOfflineRegionCallback createOfflineRegionCallback);

    private native void initialize(FileSource fileSource);

    private native void listOfflineRegions(FileSource fileSource, ListOfflineRegionsCallback listOfflineRegionsCallback);

    private native void mergeOfflineRegions(FileSource fileSource, String str, MergeOfflineRegionsCallback mergeOfflineRegionsCallback);

    private native void nativeCancelPrefetchAmbientCacheRequest(long j);

    private native void nativeClearAmbientCache(FileSourceCallback fileSourceCallback);

    private native void nativeInvalidateAmbientCache(FileSourceCallback fileSourceCallback);

    private native void nativePackDatabase(FileSourceCallback fileSourceCallback);

    private native long nativePrefetchAmbientCache(CacheAreaDefinition cacheAreaDefinition, PrefetchAmbientCacheCallback prefetchAmbientCacheCallback);

    private native void nativeResetDatabase(FileSourceCallback fileSourceCallback);

    private native void nativeSetMaximumAmbientCacheSize(long j, FileSourceCallback fileSourceCallback);

    protected native void finalize() throws Throwable;

    public native void putResourceWithUrl(String str, byte[] bArr, long j, long j2, String str2, boolean z);

    public native void runPackDatabaseAutomatically(boolean z);

    public native void setOfflineMapboxTileCountLimit(long j);

    static {
        LibraryLoader.load();
    }

    private OfflineManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        FileSource fileSource = FileSource.getInstance(applicationContext);
        this.fileSource = fileSource;
        initialize(fileSource);
        deleteAmbientDatabase(this.context);
    }

    private void deleteAmbientDatabase(Context context) {
        FileUtils.deleteFile(FileSource.getInternalCachePath(context) + File.separator + "mbgl-cache.db");
    }

    public static synchronized OfflineManager getInstance(Context context) {
        OfflineManager offlineManager;
        synchronized (OfflineManager.class) {
            if (instance == null) {
                instance = new OfflineManager(context);
            }
            offlineManager = instance;
        }
        return offlineManager;
    }

    public void listOfflineRegions(final ListOfflineRegionsCallback listOfflineRegionsCallback) {
        this.fileSource.activate();
        listOfflineRegions(this.fileSource, new ListOfflineRegionsCallback() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.1
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(final OfflineRegion[] offlineRegionArr) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        listOfflineRegionsCallback.onList(offlineRegionArr);
                    }
                });
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        listOfflineRegionsCallback.onError(str);
                    }
                });
            }
        });
    }

    public void mergeOfflineRegions(String str, final MergeOfflineRegionsCallback mergeOfflineRegionsCallback) {
        final File file = new File(str);
        new Thread(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.2
            @Override // java.lang.Runnable
            public void run() {
                final String str2 = null;
                if (file.canWrite()) {
                    OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OfflineManager.this.mergeOfflineDatabaseFiles(file, mergeOfflineRegionsCallback, false);
                        }
                    });
                } else if (file.canRead()) {
                    final File file2 = new File(FileSource.getInternalCachePath(OfflineManager.this.context), file.getName());
                    try {
                        OfflineManager.copyTempDatabaseFile(file, file2);
                        OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                OfflineManager.this.mergeOfflineDatabaseFiles(file2, mergeOfflineRegionsCallback, true);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                        str2 = e.getMessage();
                    }
                } else {
                    str2 = "Secondary database needs to be located in a readable path.";
                }
                if (str2 != null) {
                    OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            mergeOfflineRegionsCallback.onError(str2);
                        }
                    });
                }
            }
        }).start();
    }

    public void resetDatabase(final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativeResetDatabase(new FileSourceCallback() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.3
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void packDatabase(final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativePackDatabase(new FileSourceCallback() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.4
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void invalidateAmbientCache(final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativeInvalidateAmbientCache(new FileSourceCallback() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.5
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void clearAmbientCache(final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativeClearAmbientCache(new FileSourceCallback() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.6
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void setMaximumAmbientCacheSize(long j, final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativeSetMaximumAmbientCacheSize(j, new FileSourceCallback() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.7
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.fileSource.activate();
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void copyTempDatabaseFile(java.io.File r9, java.io.File r10) throws java.io.IOException {
        /*
            boolean r0 = r10.exists()
            if (r0 != 0) goto L15
            boolean r0 = r10.createNewFile()
            if (r0 == 0) goto Ld
            goto L15
        Ld:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Unable to copy database file for merge."
            r9.<init>(r10)
            throw r9
        L15:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b
            java.nio.channels.FileChannel r9 = r1.getChannel()     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L43
            r1.<init>(r10)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L43
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L43
            r4 = 0
            long r6 = r9.size()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L43
            r2 = r0
            r3 = r9
            r2.transferFrom(r3, r4, r6)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L43
            if (r9 == 0) goto L38
            r9.close()
        L38:
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return
        L3e:
            r10 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L64
        L43:
            r10 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L4d
        L48:
            r10 = move-exception
            r9 = r0
            goto L64
        L4b:
            r10 = move-exception
            r9 = r0
        L4d:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L63
            java.lang.String r2 = "Unable to copy database file for merge. %s"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L63
            r4 = 0
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L63
            r3[r4] = r10     // Catch: java.lang.Throwable -> L63
            java.lang.String r10 = java.lang.String.format(r2, r3)     // Catch: java.lang.Throwable -> L63
            r1.<init>(r10)     // Catch: java.lang.Throwable -> L63
            throw r1     // Catch: java.lang.Throwable -> L63
        L63:
            r10 = move-exception
        L64:
            if (r0 == 0) goto L69
            r0.close()
        L69:
            if (r9 == 0) goto L6e
            r9.close()
        L6e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mapbox.mapboxsdk.offline.OfflineManager.copyTempDatabaseFile(java.io.File, java.io.File):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOfflineDatabaseFiles(final File file, final MergeOfflineRegionsCallback mergeOfflineRegionsCallback, final boolean z) {
        this.fileSource.activate();
        mergeOfflineRegions(this.fileSource, file.getAbsolutePath(), new MergeOfflineRegionsCallback() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.8
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.MergeOfflineRegionsCallback
            public void onMerge(final OfflineRegion[] offlineRegionArr) {
                if (z) {
                    file.delete();
                }
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        mergeOfflineRegionsCallback.onMerge(offlineRegionArr);
                    }
                });
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.MergeOfflineRegionsCallback
            public void onError(final String str) {
                if (z) {
                    file.delete();
                }
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        mergeOfflineRegionsCallback.onError(str);
                    }
                });
            }
        });
    }

    public void createOfflineRegion(OfflineRegionDefinition offlineRegionDefinition, byte[] bArr, final CreateOfflineRegionCallback createOfflineRegionCallback) {
        ConnectivityReceiver.instance(this.context).activate();
        FileSource.getInstance(this.context).activate();
        createOfflineRegion(this.fileSource, offlineRegionDefinition, bArr, new CreateOfflineRegionCallback() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.9
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.CreateOfflineRegionCallback
            public void onCreate(final OfflineRegion offlineRegion) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectivityReceiver.instance(OfflineManager.this.context).deactivate();
                        FileSource.getInstance(OfflineManager.this.context).deactivate();
                        createOfflineRegionCallback.onCreate(offlineRegion);
                    }
                });
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.CreateOfflineRegionCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.offline.OfflineManager.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectivityReceiver.instance(OfflineManager.this.context).deactivate();
                        FileSource.getInstance(OfflineManager.this.context).deactivate();
                        createOfflineRegionCallback.onError(str);
                    }
                });
            }
        });
        TelemetryDefinition telemetry = Mapbox.getTelemetry();
        if (telemetry != null) {
            offlineRegionDefinition.getBounds();
            telemetry.onCreateOfflineRegion(offlineRegionDefinition);
        }
    }

    public long prefetchAmbientCache(CacheAreaDefinition cacheAreaDefinition, PrefetchAmbientCacheCallback prefetchAmbientCacheCallback) {
        return nativePrefetchAmbientCache(cacheAreaDefinition, prefetchAmbientCacheCallback);
    }

    public void cancelPrefetchAmbientCacheRequest(long j) {
        nativeCancelPrefetchAmbientCacheRequest(j);
    }
}
