package com.logan.flight.data.recv;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import com.ipotensic.baselib.netty.ParseUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: FlightRevRemoterStateData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/logan/flight/data/recv/FlightRevRemoterStateData;", "Lcom/logan/flight/data/recv/BaseFlightRevData;", "()V", "isPressRecordButton", "", "()Z", "setPressRecordButton", "(Z)V", "isPressTakePhotoButton", "setPressTakePhotoButton", "isRecordSignal", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "setRecordSignal", "(Landroidx/databinding/ObservableBoolean;)V", "isTakePhotoSignal", "setTakePhotoSignal", "parseData", "", "data", "", "payloadIndex", "", "toString", "", "Companion", "Protocols_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class FlightRevRemoterStateData extends BaseFlightRevData {
    public static final int PRESSED = 1;
    public static final int RELEASE = 0;
    private boolean isPressRecordButton;
    private boolean isPressTakePhotoButton;

    /* renamed from: isRecordSignal, reason: from kotlin metadata and from toString */
    private ObservableBoolean recordSignal = new ObservableBoolean();

    /* renamed from: isTakePhotoSignal, reason: from kotlin metadata and from toString */
    private ObservableBoolean takePhotoSignal = new ObservableBoolean();

    public FlightRevRemoterStateData() {
        this.recordSignal.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.logan.flight.data.recv.FlightRevRemoterStateData.1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                FlightRevRemoterStateData.this.setPressRecordButton(true);
            }
        });
        this.takePhotoSignal.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.logan.flight.data.recv.FlightRevRemoterStateData.2
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                FlightRevRemoterStateData.this.setPressTakePhotoButton(true);
            }
        });
    }

    /* renamed from: isPressRecordButton, reason: from getter */
    public final boolean getIsPressRecordButton() {
        return this.isPressRecordButton;
    }

    public final void setPressRecordButton(boolean z) {
        this.isPressRecordButton = z;
    }

    /* renamed from: isPressTakePhotoButton, reason: from getter */
    public final boolean getIsPressTakePhotoButton() {
        return this.isPressTakePhotoButton;
    }

    public final void setPressTakePhotoButton(boolean z) {
        this.isPressTakePhotoButton = z;
    }

    /* renamed from: isRecordSignal, reason: from getter */
    public final ObservableBoolean getRecordSignal() {
        return this.recordSignal;
    }

    public final void setRecordSignal(ObservableBoolean observableBoolean) {
        Intrinsics.checkParameterIsNotNull(observableBoolean, "<set-?>");
        this.recordSignal = observableBoolean;
    }

    /* renamed from: isTakePhotoSignal, reason: from getter */
    public final ObservableBoolean getTakePhotoSignal() {
        return this.takePhotoSignal;
    }

    public final void setTakePhotoSignal(ObservableBoolean observableBoolean) {
        Intrinsics.checkParameterIsNotNull(observableBoolean, "<set-?>");
        this.takePhotoSignal = observableBoolean;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] data, int payloadIndex) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.isPressRecordButton = false;
        this.isPressTakePhotoButton = false;
        byte b = data[payloadIndex + 1];
        this.recordSignal.set(ParseUtil.getBit(b, 1) == 1);
        this.takePhotoSignal.set(ParseUtil.getBit(b, 2) == 1);
    }

    public String toString() {
        return "FlightRevRemoterStateData(isPressRecordButton=" + this.isPressRecordButton + ", isPressTakePhotoButton=" + this.isPressTakePhotoButton + ", recordSignal=" + this.recordSignal + ", takePhotoSignal=" + this.takePhotoSignal + PropertyUtils.MAPPED_DELIM2;
    }
}
