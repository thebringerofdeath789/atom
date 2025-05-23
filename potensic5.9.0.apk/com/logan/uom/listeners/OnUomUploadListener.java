package com.logan.uom.listeners;

import kotlin.Metadata;

/* compiled from: OnUomUploadListener.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, m2338d2 = {"Lcom/logan/uom/listeners/OnUomUploadListener;", "", "onServerError", "", "serverErrCode", "", "(Ljava/lang/Integer;)V", "onUploadFailed", "exception", "Ljava/lang/Exception;", "onUploadSuccess", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public interface OnUomUploadListener {
    void onServerError(Integer serverErrCode);

    void onUploadFailed(Exception exception);

    void onUploadSuccess();
}