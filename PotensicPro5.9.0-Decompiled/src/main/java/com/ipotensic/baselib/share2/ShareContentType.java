package com.ipotensic.baselib.share2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface ShareContentType {
    public static final String AUDIO = "audio/*";
    public static final String FILE = "*/*";
    public static final String IMAGE = "image/*";
    public static final String TEXT = "text/plain";
    public static final String VIDEO = "video/*";
}
