package com.ipotensic.baselib.mediadataretriever.callback;

import com.ipotensic.baselib.mediadataretriever.entity.LoadTask;
import com.ipotensic.baselib.mediadataretriever.entity.MetadataKey;
import com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener;
import java.util.Map;

/* loaded from: classes2.dex */
public class LoadSuccessMetaDataCallback extends BaseLoadCallback {
    private Map<MetadataKey, String> metaData;

    public LoadSuccessMetaDataCallback(LoadTask loadTask, Map<MetadataKey, String> map) {
        super(loadTask);
        this.metaData = map;
    }

    @Override // com.ipotensic.baselib.mediadataretriever.callback.BaseLoadCallback, java.lang.Runnable
    public void run() {
        OnMediaRetrieverLoadListener mediaRetrieverLoadListener = getMediaRetrieverLoadListener();
        if (mediaRetrieverLoadListener != null) {
            mediaRetrieverLoadListener.onMetaDataGet(this.metaData);
        }
    }
}