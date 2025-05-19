package com.mapbox.mapboxsdk.style.sources;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class CustomGeometrySource extends Source {
    public static final int THREAD_POOL_LIMIT = 4;
    public static final String THREAD_PREFIX = "CustomGeom";
    private static final AtomicInteger poolCount = new AtomicInteger();
    private final Map<TileID, GeometryTileRequest> awaitingTasksMap;
    private ThreadPoolExecutor executor;
    private final Lock executorLock;
    private final Map<TileID, AtomicBoolean> inProgressTasksMap;
    private GeometryTileProvider provider;

    private native void nativeInvalidateBounds(LatLngBounds latLngBounds);

    private native void nativeInvalidateTile(int i, int i2, int i3);

    private native void nativeSetTileData(int i, int i2, int i3, FeatureCollection featureCollection);

    private native Feature[] querySourceFeatures(Object[] objArr);

    protected native void finalize() throws Throwable;

    protected native void initialize(String str, Object obj);

    public CustomGeometrySource(String str, GeometryTileProvider geometryTileProvider) {
        this(str, new CustomGeometrySourceOptions(), geometryTileProvider);
    }

    public CustomGeometrySource(String str, CustomGeometrySourceOptions customGeometrySourceOptions, GeometryTileProvider geometryTileProvider) {
        this.executorLock = new ReentrantLock();
        this.awaitingTasksMap = new HashMap();
        this.inProgressTasksMap = new HashMap();
        this.provider = geometryTileProvider;
        initialize(str, customGeometrySourceOptions);
    }

    public void invalidateRegion(LatLngBounds latLngBounds) {
        nativeInvalidateBounds(latLngBounds);
    }

    public void invalidateTile(int i, int i2, int i3) {
        nativeInvalidateTile(i, i2, i3);
    }

    public void setTileData(int i, int i2, int i3, FeatureCollection featureCollection) {
        nativeSetTileData(i, i2, i3, featureCollection);
    }

    public List<Feature> querySourceFeatures(Expression expression) {
        checkThread();
        Feature[] querySourceFeatures = querySourceFeatures(expression != null ? expression.toArray() : null);
        return querySourceFeatures != null ? Arrays.asList(querySourceFeatures) : new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTileData(TileID tileID, FeatureCollection featureCollection) {
        nativeSetTileData(tileID.z, tileID.x, tileID.y, featureCollection);
    }

    private void fetchTile(int i, int i2, int i3) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        TileID tileID = new TileID(i, i2, i3);
        GeometryTileRequest geometryTileRequest = new GeometryTileRequest(tileID, this.provider, this.awaitingTasksMap, this.inProgressTasksMap, this, atomicBoolean);
        synchronized (this.awaitingTasksMap) {
            synchronized (this.inProgressTasksMap) {
                if (this.executor.getQueue().contains(geometryTileRequest)) {
                    this.executor.remove(geometryTileRequest);
                    executeRequest(geometryTileRequest);
                } else if (this.inProgressTasksMap.containsKey(tileID)) {
                    this.awaitingTasksMap.put(tileID, geometryTileRequest);
                } else {
                    executeRequest(geometryTileRequest);
                }
            }
        }
    }

    private void executeRequest(GeometryTileRequest geometryTileRequest) {
        this.executorLock.lock();
        try {
            ThreadPoolExecutor threadPoolExecutor = this.executor;
            if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                this.executor.execute(geometryTileRequest);
            }
        } finally {
            this.executorLock.unlock();
        }
    }

    private void cancelTile(int i, int i2, int i3) {
        TileID tileID = new TileID(i, i2, i3);
        synchronized (this.awaitingTasksMap) {
            synchronized (this.inProgressTasksMap) {
                AtomicBoolean atomicBoolean = this.inProgressTasksMap.get(tileID);
                if (atomicBoolean == null || !atomicBoolean.compareAndSet(false, true)) {
                    if (!this.executor.getQueue().remove(new GeometryTileRequest(tileID, null, null, null, null, null))) {
                        this.awaitingTasksMap.remove(tileID);
                    }
                }
            }
        }
    }

    private void startThreads() {
        this.executorLock.lock();
        try {
            ThreadPoolExecutor threadPoolExecutor = this.executor;
            if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                this.executor.shutdownNow();
            }
            this.executor = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mapbox.mapboxsdk.style.sources.CustomGeometrySource.1
                final AtomicInteger threadCount = new AtomicInteger();
                final int poolId = CustomGeometrySource.poolCount.getAndIncrement();

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, String.format(Locale.US, "%s-%d-%d", CustomGeometrySource.THREAD_PREFIX, Integer.valueOf(this.poolId), Integer.valueOf(this.threadCount.getAndIncrement())));
                }
            });
        } finally {
            this.executorLock.unlock();
        }
    }

    private void releaseThreads() {
        this.executorLock.lock();
        try {
            this.executor.shutdownNow();
        } finally {
            this.executorLock.unlock();
        }
    }

    private boolean isCancelled(int i, int i2, int i3) {
        return this.inProgressTasksMap.get(new TileID(i, i2, i3)).get();
    }

    static class TileID {
        public int x;
        public int y;
        public int z;

        TileID(int i, int i2, int i3) {
            this.z = i;
            this.x = i2;
            this.y = i3;
        }

        public int hashCode() {
            return Arrays.hashCode(new int[]{this.z, this.x, this.y});
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass() || !(obj instanceof TileID)) {
                return false;
            }
            TileID tileID = (TileID) obj;
            return this.z == tileID.z && this.x == tileID.x && this.y == tileID.y;
        }
    }

    static class GeometryTileRequest implements Runnable {
        private final Map<TileID, GeometryTileRequest> awaiting;
        private final AtomicBoolean cancelled;
        private final TileID id;
        private final Map<TileID, AtomicBoolean> inProgress;
        private final GeometryTileProvider provider;
        private final WeakReference<CustomGeometrySource> sourceRef;

        GeometryTileRequest(TileID tileID, GeometryTileProvider geometryTileProvider, Map<TileID, GeometryTileRequest> map, Map<TileID, AtomicBoolean> map2, CustomGeometrySource customGeometrySource, AtomicBoolean atomicBoolean) {
            this.id = tileID;
            this.provider = geometryTileProvider;
            this.awaiting = map;
            this.inProgress = map2;
            this.sourceRef = new WeakReference<>(customGeometrySource);
            this.cancelled = atomicBoolean;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.awaiting) {
                synchronized (this.inProgress) {
                    if (this.inProgress.containsKey(this.id)) {
                        if (!this.awaiting.containsKey(this.id)) {
                            this.awaiting.put(this.id, this);
                        }
                        return;
                    }
                    this.inProgress.put(this.id, this.cancelled);
                    if (!isCancelled().booleanValue()) {
                        FeatureCollection featuresForBounds = this.provider.getFeaturesForBounds(LatLngBounds.from(this.id.z, this.id.x, this.id.y), this.id.z);
                        CustomGeometrySource customGeometrySource = this.sourceRef.get();
                        if (!isCancelled().booleanValue() && customGeometrySource != null && featuresForBounds != null) {
                            customGeometrySource.setTileData(this.id, featuresForBounds);
                        }
                    }
                    synchronized (this.awaiting) {
                        synchronized (this.inProgress) {
                            this.inProgress.remove(this.id);
                            if (this.awaiting.containsKey(this.id)) {
                                GeometryTileRequest geometryTileRequest = this.awaiting.get(this.id);
                                CustomGeometrySource customGeometrySource2 = this.sourceRef.get();
                                if (customGeometrySource2 != null && geometryTileRequest != null) {
                                    customGeometrySource2.executor.execute(geometryTileRequest);
                                }
                                this.awaiting.remove(this.id);
                            }
                        }
                    }
                }
            }
        }

        private Boolean isCancelled() {
            return Boolean.valueOf(this.cancelled.get());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.id.equals(((GeometryTileRequest) obj).id);
        }
    }
}
