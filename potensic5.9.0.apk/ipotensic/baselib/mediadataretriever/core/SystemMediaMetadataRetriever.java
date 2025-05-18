package com.ipotensic.baselib.mediadataretriever.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.ipotensic.baselib.mediadataretriever.entity.MetadataKey;
import com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SystemMediaMetadataRetriever implements IMediaMetadataRetriever {
    private MediaMetadataRetriever mMediaMetadataRetriever = new MediaMetadataRetriever();

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public void setDataSource(String str, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        this.mMediaMetadataRetriever.setDataSource(str, map);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public void setDataSource(String str) {
        this.mMediaMetadataRetriever.setDataSource(str);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public void setDataSource(FileDescriptor fileDescriptor) {
        this.mMediaMetadataRetriever.setDataSource(fileDescriptor);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public void setDataSource(Context context, Uri uri) {
        this.mMediaMetadataRetriever.setDataSource(context, uri);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public void setDataSource(MediaDataSource mediaDataSource) {
        this.mMediaMetadataRetriever.setDataSource(mediaDataSource);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public String extractMetadata(MetadataKey metadataKey) {
        return this.mMediaMetadataRetriever.extractMetadata(metadataKey.keyInt);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public Bitmap getFrameAtTime(long j, int i) {
        if (i == -1) {
            i = 2;
        }
        return this.mMediaMetadataRetriever.getFrameAtTime(j, i);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public Bitmap getFrameAtTime(long j) {
        return getFrameAtTime(j, 2);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public Bitmap getFrameAtTime() {
        return getFrameAtTime(-1L, 2);
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public byte[] getEmbeddedPicture() {
        return this.mMediaMetadataRetriever.getEmbeddedPicture();
    }

    @Override // com.ipotensic.baselib.mediadataretriever.inter.IMediaMetadataRetriever
    public void release() {
        try {
            this.mMediaMetadataRetriever.release();
        } catch (IOException unused) {
        }
    }
}