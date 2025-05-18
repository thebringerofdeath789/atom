package com.ipotensic.baselib.mediadataretriever.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.ipotensic.baselib.mediadataretriever.entity.MediaData;
import com.ipotensic.baselib.mediadataretriever.entity.MediaTask;
import com.ipotensic.baselib.mediadataretriever.entity.MetaDataHashMap;
import com.ipotensic.baselib.mediadataretriever.entity.MetadataKey;
import com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever;
import com.ipotensic.baselib.mediadataretriever.utils.Utils;
import java.util.Map;

/* loaded from: classes2.dex */
public class MediaMetadataRetrieverLoaderManager {
    private static MediaMetadataRetrieverLoaderManager instance;
    private final String TAG = "LoaderManager";

    public interface OnLoadListener {
        void onFrameGet(Bitmap bitmap);

        void onMetaDataGet(Map<MetadataKey, String> map);
    }

    private MediaMetadataRetrieverLoaderManager() {
    }

    public static MediaMetadataRetrieverLoaderManager get() {
        if (instance == null) {
            synchronized (MediaMetadataRetrieverLoaderManager.class) {
                if (instance == null) {
                    instance = new MediaMetadataRetrieverLoaderManager();
                }
            }
        }
        return instance;
    }

    private boolean isMetaHasData(Map<MetadataKey, String> map) {
        return map != null && map.size() > 0;
    }

    public MediaData getMediaData(MediaTask mediaTask) {
        return getMediaData(mediaTask, null);
    }

    public MediaData getMediaData(MediaTask mediaTask, OnLoadListener onLoadListener) {
        return systemLoadMediaData(mediaTask, onLoadListener);
    }

    private MediaData systemLoadMediaData(MediaTask mediaTask, OnLoadListener onLoadListener) {
        SystemMediaMetadataRetriever systemMediaMetadataRetriever = new SystemMediaMetadataRetriever();
        MediaData loadMediaData = loadMediaData(systemMediaMetadataRetriever, mediaTask, onLoadListener);
        systemMediaMetadataRetriever.release();
        return loadMediaData;
    }

    private MediaData loadMediaData(IMediaMetadataRetriever iMediaMetadataRetriever, MediaTask mediaTask, OnLoadListener onLoadListener) {
        MediaData mediaData = new MediaData();
        Map<String, String> headers = mediaTask.getHeaders();
        String dataSource = mediaTask.getDataSource();
        if (Utils.isLocalFile(dataSource)) {
            iMediaMetadataRetriever.setDataSource(dataSource);
        } else {
            iMediaMetadataRetriever.setDataSource(dataSource, headers);
        }
        if (mediaTask.isLoadFrame()) {
            long time = mediaTask.getTime();
            int option = mediaTask.getOption();
            Bitmap bitmap = null;
            if (mediaTask.getSourceType() == 1) {
                bitmap = iMediaMetadataRetriever.getFrameAtTime(time, option);
            } else {
                byte[] embeddedPicture = iMediaMetadataRetriever.getEmbeddedPicture();
                if (embeddedPicture != null) {
                    bitmap = BitmapFactory.decodeByteArray(embeddedPicture, 0, embeddedPicture.length);
                }
            }
            mediaData.setFrame(bitmap);
            if (onLoadListener != null) {
                onLoadListener.onFrameGet(bitmap);
            }
        }
        if (mediaTask.isNeedLoadMetaData()) {
            Map<MetadataKey, String> attachMetaKeys = attachMetaKeys(iMediaMetadataRetriever, mediaTask.getKeys());
            mediaData.setMetaData(attachMetaKeys);
            if (onLoadListener != null) {
                onLoadListener.onMetaDataGet(attachMetaKeys);
            }
        }
        return mediaData;
    }

    private Map<MetadataKey, String> attachMetaKeys(IMediaMetadataRetriever iMediaMetadataRetriever, MetadataKey[] metadataKeyArr) {
        if (metadataKeyArr == null) {
            return null;
        }
        MetaDataHashMap metaDataHashMap = new MetaDataHashMap();
        for (MetadataKey metadataKey : metadataKeyArr) {
            metaDataHashMap.put(metadataKey, iMediaMetadataRetriever.extractMetadata(metadataKey));
        }
        return metaDataHashMap;
    }
}