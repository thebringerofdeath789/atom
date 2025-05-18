package com.ipotensic.baselib.mediadataretriever.callback;

import android.graphics.Bitmap;
import com.ipotensic.baselib.mediadataretriever.entity.MetadataKey;
import com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener;
import java.util.Map;

/* loaded from: classes2.dex */
public class OnMediaRetrieverTargetViewLoadCallback implements OnMediaRetrieverLoadListener {
    @Override // com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener
    public void onFrameGet(Bitmap bitmap) {
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener
    public void onLoadFailure(int i, String str) {
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener
    public void onLoadStart() {
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener
    public void onMetaDataGet(Map<MetadataKey, String> map) {
    }
}