package com.logan.uom.listeners;

import com.logan.uom.bean.UomUploadState;
import com.logan.uom.enums.UomState;
import kotlin.Metadata;

/* compiled from: OnUomHandleListener.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¨\u0006\b"}, m2338d2 = {"Lcom/logan/uom/listeners/OnUomHandleListener;", "", "onUomStateCallback", "", "state", "Lcom/logan/uom/enums/UomState;", "onUomUploadStateCallback", "Lcom/logan/uom/bean/UomUploadState;", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public interface OnUomHandleListener {
    void onUomStateCallback(UomState state);

    void onUomUploadStateCallback(UomUploadState state);
}