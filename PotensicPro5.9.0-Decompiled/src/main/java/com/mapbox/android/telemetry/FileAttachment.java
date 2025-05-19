package com.mapbox.android.telemetry;

import okhttp3.MediaType;

/* loaded from: classes3.dex */
public class FileAttachment {
    private AttachmentMetadata attachmentMetadata;
    private String filePath;
    private MediaType mediaType;

    FileAttachment(AttachmentMetadata attachmentMetadata, String str, MediaType mediaType) {
        this.attachmentMetadata = attachmentMetadata;
        this.filePath = str;
        this.mediaType = mediaType;
    }

    public AttachmentMetadata getAttachmentMetadata() {
        return this.attachmentMetadata;
    }

    public FileData getFileData() {
        return new FileData(this.filePath, this.mediaType);
    }
}
