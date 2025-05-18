package com.ipotensic.kernel.model;

import androidx.lifecycle.ViewModel;
import com.ipotensic.baselib.livedata.DataChangedLiveData;
import com.logan.uom.UomHandler;
import com.logan.uom.bean.UomUploadState;
import com.logan.uom.enums.UomState;
import com.logan.uom.listeners.OnUomHandleListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UomViewModel.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0012"}, m2338d2 = {"Lcom/ipotensic/kernel/model/UomViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/logan/uom/listeners/OnUomHandleListener;", "()V", "uomState", "Lcom/ipotensic/baselib/livedata/DataChangedLiveData;", "Lcom/logan/uom/enums/UomState;", "getUomState", "()Lcom/ipotensic/baselib/livedata/DataChangedLiveData;", "uomUploadState", "Lcom/logan/uom/bean/UomUploadState;", "getUomUploadState", "onUomStateCallback", "", "state", "onUomUploadStateCallback", "register", "unRegister", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class UomViewModel extends ViewModel implements OnUomHandleListener {
    private final DataChangedLiveData<UomState> uomState = new DataChangedLiveData<>();
    private final DataChangedLiveData<UomUploadState> uomUploadState = new DataChangedLiveData<>();

    public final DataChangedLiveData<UomState> getUomState() {
        return this.uomState;
    }

    public final DataChangedLiveData<UomUploadState> getUomUploadState() {
        return this.uomUploadState;
    }

    public final void register() {
        UomHandler.INSTANCE.getInstance().setUomHandleListener(this);
    }

    public final void unRegister() {
        UomHandler.INSTANCE.getInstance().setUomHandleListener((OnUomHandleListener) null);
    }

    @Override // com.logan.uom.listeners.OnUomHandleListener
    public void onUomStateCallback(UomState state) {
        Intrinsics.checkParameterIsNotNull(state, "state");
        this.uomState.setValue(state);
    }

    @Override // com.logan.uom.listeners.OnUomHandleListener
    public void onUomUploadStateCallback(UomUploadState state) {
        Intrinsics.checkParameterIsNotNull(state, "state");
        this.uomUploadState.setValue(state);
    }
}