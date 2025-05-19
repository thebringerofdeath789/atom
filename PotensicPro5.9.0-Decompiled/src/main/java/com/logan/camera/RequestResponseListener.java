package com.logan.camera;

import com.logan.camera.data.BaseData;

/* loaded from: classes2.dex */
public interface RequestResponseListener {
    void onRequestFailed(int i, Exception exc);

    void onRequestSuccess(int i, BaseData baseData);
}
