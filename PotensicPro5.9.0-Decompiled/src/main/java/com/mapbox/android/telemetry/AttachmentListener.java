package com.mapbox.android.telemetry;

import java.util.List;

/* loaded from: classes3.dex */
public interface AttachmentListener {
    void onAttachmentFailure(String str, List<String> list);

    void onAttachmentResponse(String str, int i, List<String> list);
}
