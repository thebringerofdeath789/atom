package com.logan.camera.listeners;

import java.io.File;

/* loaded from: classes2.dex */
public interface OnFileCallback {
    void onFailed();

    void onFile(File file, boolean z);
}
