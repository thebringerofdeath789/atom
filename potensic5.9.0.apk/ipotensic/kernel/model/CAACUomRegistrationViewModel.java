package com.ipotensic.kernel.model;

import android.graphics.Bitmap;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.livedata.DataChangedLiveData;
import com.ipotensic.kernel.activitys.CAACUomRegistrationActivity;
import com.logan.flight.type.Flight;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: CAACUomRegistrationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u001bR,\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/ipotensic/kernel/model/CAACUomRegistrationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", CAACUomRegistrationActivity.FLIGHT_SN_INTENT_KEY, "Lcom/ipotensic/baselib/livedata/DataChangedLiveData;", "Lkotlin/Pair;", "Lcom/logan/flight/type/Flight;", "", "getFlightSN", "()Lcom/ipotensic/baselib/livedata/DataChangedLiveData;", "setFlightSN", "(Lcom/ipotensic/baselib/livedata/DataChangedLiveData;)V", "infoQRCodeBitmap", "Landroid/graphics/Bitmap;", "getInfoQRCodeBitmap", "()Landroid/graphics/Bitmap;", "setInfoQRCodeBitmap", "(Landroid/graphics/Bitmap;)V", "isOrder2DetailExpand", "", "()Z", "setOrder2DetailExpand", "(Z)V", "generateQRCode", "Lkotlinx/coroutines/Job;", "content", "resultListener", "Lcom/ipotensic/baselib/listener/SimpleResultListener;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CAACUomRegistrationViewModel extends ViewModel {
    private DataChangedLiveData<Pair<Flight, String>> flightSN = new DataChangedLiveData<>();
    private Bitmap infoQRCodeBitmap;
    private boolean isOrder2DetailExpand;

    /* renamed from: isOrder2DetailExpand, reason: from getter */
    public final boolean getIsOrder2DetailExpand() {
        return this.isOrder2DetailExpand;
    }

    public final void setOrder2DetailExpand(boolean z) {
        this.isOrder2DetailExpand = z;
    }

    public final Bitmap getInfoQRCodeBitmap() {
        return this.infoQRCodeBitmap;
    }

    public final void setInfoQRCodeBitmap(Bitmap bitmap) {
        this.infoQRCodeBitmap = bitmap;
    }

    public final DataChangedLiveData<Pair<Flight, String>> getFlightSN() {
        return this.flightSN;
    }

    public final void setFlightSN(DataChangedLiveData<Pair<Flight, String>> dataChangedLiveData) {
        Intrinsics.checkParameterIsNotNull(dataChangedLiveData, "<set-?>");
        this.flightSN = dataChangedLiveData;
    }

    public final Job generateQRCode(String content, SimpleResultListener<Bitmap> resultListener) {
        Job launch$default;
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intrinsics.checkParameterIsNotNull(resultListener, "resultListener");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new CAACUomRegistrationViewModel$generateQRCode$1(content, resultListener, null), 2, null);
        return launch$default;
    }
}