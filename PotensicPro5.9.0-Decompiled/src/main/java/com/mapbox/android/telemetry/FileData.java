package com.mapbox.android.telemetry;

import okhttp3.MediaType;

/* loaded from: classes3.dex */
class FileData {
    private final String filePath;
    private final MediaType type;

    FileData(String str, MediaType mediaType) {
        this.filePath = str;
        this.type = mediaType;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public MediaType getType() {
        return this.type;
    }
}
