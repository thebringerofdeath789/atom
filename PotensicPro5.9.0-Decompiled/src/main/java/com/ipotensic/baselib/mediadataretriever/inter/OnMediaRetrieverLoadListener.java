package com.ipotensic.baselib.mediadataretriever.inter;

import android.graphics.Bitmap;
import com.ipotensic.baselib.mediadataretriever.entity.MetadataKey;
import java.util.Map;

/* loaded from: classes2.dex */
public interface OnMediaRetrieverLoadListener {
    public static final int CODE_FAILURE_FRAME_GET = 1;
    public static final int CODE_FAILURE_META_DATA_GET = 2;

    void onFrameGet(Bitmap bitmap);

    void onLoadFailure(int i, String str);

    void onLoadStart();

    void onMetaDataGet(Map<MetadataKey, String> map);
}
