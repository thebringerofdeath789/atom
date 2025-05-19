package com.ipotensic.kernel.services;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;

/* compiled from: ILocationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/ipotensic/kernel/services/ILocationService;", "", "getRotate", "", "init", "", "isStart", "", "reStart", "setOnLocationChangedListener", "listener", "Lcom/ipotensic/kernel/services/OnLocationChangedListener;", TtmlNode.START, "stop", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface ILocationService {
    float getRotate();

    void init();

    boolean isStart();

    void reStart();

    void setOnLocationChangedListener(OnLocationChangedListener listener);

    void start();

    void stop();
}
