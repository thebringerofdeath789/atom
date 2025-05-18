package com.ipotensic.baselib.mediadataretriever.inter;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.net.Uri;
import com.ipotensic.baselib.mediadataretriever.entity.MetadataKey;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IMediaMetadataRetriever {
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;
    public static final int SOURCE_TYPE_AUDIO = 2;
    public static final int SOURCE_TYPE_VIDEO = 1;

    String extractMetadata(MetadataKey metadataKey);

    byte[] getEmbeddedPicture();

    Bitmap getFrameAtTime();

    Bitmap getFrameAtTime(long j);

    Bitmap getFrameAtTime(long j, int i);

    void release();

    void setDataSource(Context context, Uri uri);

    void setDataSource(MediaDataSource mediaDataSource);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDataSource(String str, Map<String, String> map);
}