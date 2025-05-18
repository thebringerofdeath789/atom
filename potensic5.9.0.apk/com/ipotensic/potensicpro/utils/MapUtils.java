package com.ipotensic.potensicpro.utils;

import android.content.Context;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.offline.OfflineManager;
import com.mapbox.mapboxsdk.offline.OfflineRegion;
import com.mapbox.mapboxsdk.offline.OfflineRegionError;
import com.mapbox.mapboxsdk.offline.OfflineRegionStatus;
import com.mapbox.mapboxsdk.offline.OfflineTilePyramidRegionDefinition;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MapUtils {
    public static final String JSON_CHARSET = "UTF-8";
    public static final String JSON_FIELD_REGION_NAME = "FIELD_REGION_NAME";
    private static volatile MapUtils instance;

    public interface OnDownloadListener {
        void onDownloadError(String str);

        void onDownloadFinished();

        void onDownloadProgress(int i);

        void onDownloadStart();

        void onMapboxLimit(long j);
    }

    public interface OnLoadOfflineRegionListener {
        void onLoaded(OfflineRegion[] offlineRegionArr);
    }

    private MapUtils() {
    }

    public static MapUtils get() {
        if (instance == null) {
            synchronized (MapUtils.class) {
                if (instance == null) {
                    MapUtils mapUtils = new MapUtils();
                    instance = mapUtils;
                    return mapUtils;
                }
            }
        }
        return instance;
    }

    public void downloadRegion(Context context, MapboxMap mapboxMap, final String str, final OnDownloadListener onDownloadListener) {
        byte[] bArr;
        String url = mapboxMap.getStyle().getUrl();
        LatLngBounds latLngBounds = mapboxMap.getProjection().getVisibleRegion().latLngBounds;
        double d = mapboxMap.getCameraPosition().zoom;
        OfflineTilePyramidRegionDefinition offlineTilePyramidRegionDefinition = new OfflineTilePyramidRegionDefinition(url, latLngBounds, d, d + 3.0d, context.getResources().getDisplayMetrics().density);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_FIELD_REGION_NAME, str);
            bArr = jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e) {
            DDLog.m1685e("Failed to encode metadata: %s", e.getMessage());
            bArr = null;
        }
        if (onDownloadListener != null) {
            onDownloadListener.onDownloadStart();
        }
        OfflineManager.getInstance(context).createOfflineRegion(offlineTilePyramidRegionDefinition, bArr, new OfflineManager.CreateOfflineRegionCallback() { // from class: com.ipotensic.potensicpro.utils.MapUtils.1
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.CreateOfflineRegionCallback
            public void onCreate(OfflineRegion offlineRegion) {
                DDLog.m1683d("Offline region created: %s", str);
                offlineRegion.setObserver(new OfflineRegion.OfflineRegionObserver() { // from class: com.ipotensic.potensicpro.utils.MapUtils.1.1
                    @Override // com.mapbox.mapboxsdk.offline.OfflineRegion.OfflineRegionObserver
                    public void onStatusChanged(OfflineRegionStatus offlineRegionStatus) {
                        double completedResourceCount = offlineRegionStatus.getRequiredResourceCount() >= 0 ? (offlineRegionStatus.getCompletedResourceCount() * 100.0d) / offlineRegionStatus.getRequiredResourceCount() : 0.0d;
                        if (offlineRegionStatus.isComplete() || completedResourceCount >= 100.0d) {
                            if (onDownloadListener != null) {
                                onDownloadListener.onDownloadFinished();
                            }
                        } else if (onDownloadListener != null) {
                            onDownloadListener.onDownloadProgress((int) (completedResourceCount * 100.0d));
                        }
                    }

                    @Override // com.mapbox.mapboxsdk.offline.OfflineRegion.OfflineRegionObserver
                    public void onError(OfflineRegionError offlineRegionError) {
                        DDLog.m1684e("下载失败:" + offlineRegionError.getMessage());
                    }

                    @Override // com.mapbox.mapboxsdk.offline.OfflineRegion.OfflineRegionObserver
                    public void mapboxTileCountLimitExceeded(long j) {
                        DDLog.m1684e("Mapbox tile count limit exceeded: " + j);
                        if (onDownloadListener != null) {
                            onDownloadListener.onMapboxLimit(j);
                        }
                    }
                });
                offlineRegion.setDownloadState(1);
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.CreateOfflineRegionCallback
            public void onError(String str2) {
                DDLog.m1685e("Error: %s", str2);
                OnDownloadListener onDownloadListener2 = onDownloadListener;
                if (onDownloadListener2 != null) {
                    onDownloadListener2.onDownloadError(str2);
                }
            }
        });
    }

    public void getAllOfflineRegionList(Context context, final OnLoadOfflineRegionListener onLoadOfflineRegionListener) {
        OfflineManager.getInstance(context).listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() { // from class: com.ipotensic.potensicpro.utils.MapUtils.2
            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(OfflineRegion[] offlineRegionArr) {
                OnLoadOfflineRegionListener onLoadOfflineRegionListener2 = onLoadOfflineRegionListener;
                if (onLoadOfflineRegionListener2 != null) {
                    onLoadOfflineRegionListener2.onLoaded(offlineRegionArr);
                }
            }

            @Override // com.mapbox.mapboxsdk.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(String str) {
                DDLog.m1685e("Error: %s", str);
            }
        });
    }

    public void loadOfflineRegion(MapboxMap mapboxMap, OfflineRegion offlineRegion) {
        LatLngBounds bounds = ((OfflineTilePyramidRegionDefinition) offlineRegion.getDefinition()).getBounds();
        mapboxMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(bounds.getCenter()).zoom(((OfflineTilePyramidRegionDefinition) offlineRegion.getDefinition()).getMinZoom()).build()));
    }

    public String getRegionName(OfflineRegion offlineRegion) {
        try {
            return new JSONObject(new String(offlineRegion.getMetadata(), "UTF-8")).getString(JSON_FIELD_REGION_NAME);
        } catch (Exception e) {
            DDLog.m1685e("Failed to decode metadata: %s", e.getMessage());
            return "未命名";
        }
    }

    public void setRegionName(OfflineRegion offlineRegion, String str, final OnResultListener<Boolean> onResultListener) {
        try {
            JSONObject jSONObject = new JSONObject(new String(offlineRegion.getMetadata(), "UTF-8"));
            jSONObject.put(JSON_FIELD_REGION_NAME, str);
            offlineRegion.updateMetadata(jSONObject.toString().getBytes("UTF-8"), new OfflineRegion.OfflineRegionUpdateMetadataCallback() { // from class: com.ipotensic.potensicpro.utils.MapUtils.3
                @Override // com.mapbox.mapboxsdk.offline.OfflineRegion.OfflineRegionUpdateMetadataCallback
                public void onUpdate(byte[] bArr) {
                    OnResultListener onResultListener2 = onResultListener;
                    if (onResultListener2 != null) {
                        onResultListener2.onSuccess(true);
                    }
                }

                @Override // com.mapbox.mapboxsdk.offline.OfflineRegion.OfflineRegionUpdateMetadataCallback
                public void onError(String str2) {
                    OnResultListener onResultListener2 = onResultListener;
                    if (onResultListener2 != null) {
                        onResultListener2.onFailed(new Exception(str2));
                    }
                }
            });
        } catch (Exception e) {
            DDLog.m1684e("命名失败:" + e.getMessage());
        }
    }
}