package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ViewBindingAdapter;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingCameraModel;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;
import java.util.Objects;

/* loaded from: classes2.dex */
public class ViewLayoutSettingCameraBindingImpl extends ViewLayoutSettingCameraBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl1 mSettingCameraModelBtnFormatSDClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl mSettingCameraModelBtnMwbClickAndroidViewViewOnClickListener;
    private final FrameLayout mboundView0;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_title, 8);
        sparseIntArray.put(R.id.layout_setting, 9);
        sparseIntArray.put(R.id.tv_general_setting, 10);
        sparseIntArray.put(R.id.view_general_settings, 11);
        sparseIntArray.put(R.id.tvWhiteBalanceTip, 12);
        sparseIntArray.put(R.id.line1, 13);
        sparseIntArray.put(R.id.tvAuxLine, 14);
        sparseIntArray.put(R.id.grid_layout, 15);
        sparseIntArray.put(R.id.line2, 16);
        sparseIntArray.put(R.id.tvSeg, 17);
        sparseIntArray.put(R.id.space_general, 18);
        sparseIntArray.put(R.id.seg_rec_layout, 19);
        sparseIntArray.put(R.id.tv_sd_card, 20);
        sparseIntArray.put(R.id.view_sd_card, 21);
        sparseIntArray.put(R.id.tvRemainTips, 22);
        sparseIntArray.put(R.id.line3, 23);
        sparseIntArray.put(R.id.tvSdCardOption, 24);
        sparseIntArray.put(R.id.tv_others, 25);
        sparseIntArray.put(R.id.view_others, 26);
        sparseIntArray.put(R.id.tvWaterMark, 27);
        sparseIntArray.put(R.id.line4, 28);
        sparseIntArray.put(R.id.tvPhotoLocationTips, 29);
    }

    public ViewLayoutSettingCameraBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingCameraBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (CursorEditText) objArr[2], (CommonSelectionView) objArr[15], (ScrollView) objArr[9], (View) objArr[13], (View) objArr[16], (View) objArr[23], (View) objArr[28], (SwitchButton) objArr[6], (CustomSeekbar) objArr[3], (CommonSelectionView) objArr[19], (View) objArr[18], (SwitchButton) objArr[7], (TextView) objArr[1], (TextView) objArr[14], (TextView) objArr[5], (TextView) objArr[10], (TextView) objArr[25], (TextView) objArr[29], (TextView) objArr[22], (TextView) objArr[20], (TextView) objArr[24], (TextView) objArr[17], (TextView) objArr[27], (TextView) objArr[12], (View) objArr[11], (View) objArr[26], (View) objArr[21], (CommonTitleView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.edtWhiteBalance.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.sbWater.setTag(null);
        this.sbWhiteBalance.setTag(null);
        this.switchBtnPhotoGpsLocation.setTag(null);
        this.tvAutoWhiteBalance.setTag(null);
        this.tvFormat.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.settingCameraModel != i) {
            return false;
        }
        setSettingCameraModel((SettingCameraModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingCameraBinding
    public void setSettingCameraModel(SettingCameraModel settingCameraModel) {
        this.mSettingCameraModel = settingCameraModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.settingCameraModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSettingCameraModelGpsLocationIsClickable((ObservableBoolean) obj, i2);
            case 1:
                return onChangeSettingCameraModelWbSeekbarProgress((ObservableInt) obj, i2);
            case 2:
                return onChangeSettingCameraModelPhotoGpsIsShow((ObservableBoolean) obj, i2);
            case 3:
                return onChangeSettingCameraModelRemainCapacity((ObservableString) obj, i2);
            case 4:
                return onChangeSettingCameraModelInputWB((ObservableInt) obj, i2);
            case 5:
                return onChangeSettingCameraModelWaterMarkIsShow((ObservableBoolean) obj, i2);
            case 6:
                return onChangeSettingCameraModelWaterMarkIsClickable((ObservableBoolean) obj, i2);
            case 7:
                return onChangeSettingCameraModelWbIsMwb((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSettingCameraModelGpsLocationIsClickable(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelWbSeekbarProgress(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelPhotoGpsIsShow(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelRemainCapacity(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelInputWB(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelWaterMarkIsShow(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelWaterMarkIsClickable(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelWbIsMwb(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0151  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        SwitchButton.SwitchStateListener switchStateListener;
        OnClickListenerImpl onClickListenerImpl;
        ObservableString observableString;
        String str;
        OnClickListenerImpl1 onClickListenerImpl1;
        CursorEditText.OnInputFinishListener onInputFinishListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        int i7;
        int i8;
        String str2;
        boolean z6;
        boolean z7;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        CursorEditText.OnInputFinishListener onInputFinishListener2;
        boolean z8;
        boolean z9;
        SwitchButton.SwitchStateListener switchStateListener2;
        OnClickListenerImpl onClickListenerImpl2;
        OnClickListenerImpl1 onClickListenerImpl12;
        ObservableString observableString2;
        boolean z10;
        boolean z11;
        long j2;
        boolean z12;
        ObservableBoolean observableBoolean;
        ObservableBoolean observableBoolean2;
        ObservableInt observableInt;
        ObservableInt observableInt2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingCameraModel settingCameraModel = this.mSettingCameraModel;
        String str3 = null;
        if ((1023 & j) != 0) {
            if ((j & 770) != 0) {
                if (settingCameraModel != null) {
                    Objects.requireNonNull(settingCameraModel);
                    observableInt2 = settingCameraModel.wbSeekbarProgress;
                    Objects.requireNonNull(settingCameraModel);
                    Objects.requireNonNull(settingCameraModel);
                    onSeekBarChangeListener = settingCameraModel.wbSeekbarListener;
                    i10 = 80;
                } else {
                    i10 = 0;
                    observableInt2 = null;
                    onSeekBarChangeListener = null;
                }
                updateRegistration(1, observableInt2);
                i9 = observableInt2 != null ? observableInt2.get() : 0;
            } else {
                i9 = 0;
                i10 = 0;
                onSeekBarChangeListener = null;
            }
            if ((j & 784) != 0) {
                if (settingCameraModel != null) {
                    Objects.requireNonNull(settingCameraModel);
                    Objects.requireNonNull(settingCameraModel);
                    observableInt = settingCameraModel.inputWB;
                    Objects.requireNonNull(settingCameraModel);
                    onInputFinishListener2 = settingCameraModel.wbInputListener;
                    i12 = 2000;
                    i13 = 2000;
                    i14 = 10000;
                } else {
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    observableInt = null;
                    onInputFinishListener2 = null;
                }
                updateRegistration(4, observableInt);
                i11 = observableInt != null ? observableInt.get() : 0;
            } else {
                i11 = 0;
                i12 = 0;
                i13 = 0;
                i14 = 0;
                onInputFinishListener2 = null;
            }
            if ((j & 769) != 0) {
                ObservableBoolean observableBoolean3 = settingCameraModel != null ? settingCameraModel.gpsLocationIsClickable : null;
                updateRegistration(0, observableBoolean3);
                if (observableBoolean3 != null) {
                    z8 = observableBoolean3.get();
                    if ((j & 772) != 0) {
                        ObservableBoolean observableBoolean4 = settingCameraModel != null ? settingCameraModel.photoGpsIsShow : null;
                        updateRegistration(2, observableBoolean4);
                        if (observableBoolean4 != null) {
                            z9 = observableBoolean4.get();
                            if ((j & 768) != 0 || settingCameraModel == null) {
                                switchStateListener2 = null;
                                onClickListenerImpl2 = null;
                                onClickListenerImpl12 = null;
                            } else {
                                OnClickListenerImpl onClickListenerImpl3 = this.mSettingCameraModelBtnMwbClickAndroidViewViewOnClickListener;
                                if (onClickListenerImpl3 == null) {
                                    onClickListenerImpl3 = new OnClickListenerImpl();
                                    this.mSettingCameraModelBtnMwbClickAndroidViewViewOnClickListener = onClickListenerImpl3;
                                }
                                onClickListenerImpl2 = onClickListenerImpl3.setValue(settingCameraModel);
                                Objects.requireNonNull(settingCameraModel);
                                OnClickListenerImpl1 onClickListenerImpl13 = this.mSettingCameraModelBtnFormatSDClickAndroidViewViewOnClickListener;
                                if (onClickListenerImpl13 == null) {
                                    onClickListenerImpl13 = new OnClickListenerImpl1();
                                    this.mSettingCameraModelBtnFormatSDClickAndroidViewViewOnClickListener = onClickListenerImpl13;
                                }
                                onClickListenerImpl12 = onClickListenerImpl13.setValue(settingCameraModel);
                                switchStateListener2 = settingCameraModel.gpsLocationStateChangedListener;
                            }
                            if ((j & 776) != 0) {
                                observableString2 = settingCameraModel != null ? settingCameraModel.remainCapacity : null;
                                updateRegistration(3, observableString2);
                            } else {
                                observableString2 = null;
                            }
                            if ((j & 800) != 0) {
                                ObservableBoolean observableBoolean5 = settingCameraModel != null ? settingCameraModel.waterMarkIsShow : null;
                                updateRegistration(5, observableBoolean5);
                                if (observableBoolean5 != null) {
                                    z10 = observableBoolean5.get();
                                    if ((j & 832) == 0) {
                                        if (settingCameraModel != null) {
                                            observableBoolean2 = settingCameraModel.waterMarkIsClickable;
                                            z11 = z10;
                                        } else {
                                            z11 = z10;
                                            observableBoolean2 = null;
                                        }
                                        updateRegistration(6, observableBoolean2);
                                        if (observableBoolean2 != null) {
                                            z2 = observableBoolean2.get();
                                            j2 = j & 896;
                                            if (j2 != 0) {
                                                if (settingCameraModel != null) {
                                                    observableBoolean = settingCameraModel.wbIsMwb;
                                                    z12 = z2;
                                                } else {
                                                    z12 = z2;
                                                    observableBoolean = null;
                                                }
                                                updateRegistration(7, observableBoolean);
                                                z = observableBoolean != null ? observableBoolean.get() : false;
                                                if (j2 != 0) {
                                                    j = z ? j | 2048 | 8192 : j | 1024 | 4096;
                                                }
                                                str3 = z ? "MWB" : "AWB";
                                                z3 = z11;
                                                onInputFinishListener = onInputFinishListener2;
                                                z2 = z12;
                                            } else {
                                                z3 = z11;
                                                onInputFinishListener = onInputFinishListener2;
                                                z = false;
                                            }
                                            int i15 = i14;
                                            i6 = i9;
                                            switchStateListener = switchStateListener2;
                                            observableString = observableString2;
                                            i5 = i11;
                                            i = i10;
                                            str = str3;
                                            z4 = z9;
                                            i2 = i15;
                                            OnClickListenerImpl1 onClickListenerImpl14 = onClickListenerImpl12;
                                            i4 = i12;
                                            onClickListenerImpl = onClickListenerImpl2;
                                            i3 = i13;
                                            z5 = z8;
                                            onClickListenerImpl1 = onClickListenerImpl14;
                                        }
                                    } else {
                                        z11 = z10;
                                    }
                                    z2 = false;
                                    j2 = j & 896;
                                    if (j2 != 0) {
                                    }
                                    int i152 = i14;
                                    i6 = i9;
                                    switchStateListener = switchStateListener2;
                                    observableString = observableString2;
                                    i5 = i11;
                                    i = i10;
                                    str = str3;
                                    z4 = z9;
                                    i2 = i152;
                                    OnClickListenerImpl1 onClickListenerImpl142 = onClickListenerImpl12;
                                    i4 = i12;
                                    onClickListenerImpl = onClickListenerImpl2;
                                    i3 = i13;
                                    z5 = z8;
                                    onClickListenerImpl1 = onClickListenerImpl142;
                                }
                            }
                            z10 = false;
                            if ((j & 832) == 0) {
                            }
                            z2 = false;
                            j2 = j & 896;
                            if (j2 != 0) {
                            }
                            int i1522 = i14;
                            i6 = i9;
                            switchStateListener = switchStateListener2;
                            observableString = observableString2;
                            i5 = i11;
                            i = i10;
                            str = str3;
                            z4 = z9;
                            i2 = i1522;
                            OnClickListenerImpl1 onClickListenerImpl1422 = onClickListenerImpl12;
                            i4 = i12;
                            onClickListenerImpl = onClickListenerImpl2;
                            i3 = i13;
                            z5 = z8;
                            onClickListenerImpl1 = onClickListenerImpl1422;
                        }
                    }
                    z9 = false;
                    if ((j & 768) != 0) {
                    }
                    switchStateListener2 = null;
                    onClickListenerImpl2 = null;
                    onClickListenerImpl12 = null;
                    if ((j & 776) != 0) {
                    }
                    if ((j & 800) != 0) {
                    }
                    z10 = false;
                    if ((j & 832) == 0) {
                    }
                    z2 = false;
                    j2 = j & 896;
                    if (j2 != 0) {
                    }
                    int i15222 = i14;
                    i6 = i9;
                    switchStateListener = switchStateListener2;
                    observableString = observableString2;
                    i5 = i11;
                    i = i10;
                    str = str3;
                    z4 = z9;
                    i2 = i15222;
                    OnClickListenerImpl1 onClickListenerImpl14222 = onClickListenerImpl12;
                    i4 = i12;
                    onClickListenerImpl = onClickListenerImpl2;
                    i3 = i13;
                    z5 = z8;
                    onClickListenerImpl1 = onClickListenerImpl14222;
                }
            }
            z8 = false;
            if ((j & 772) != 0) {
            }
            z9 = false;
            if ((j & 768) != 0) {
            }
            switchStateListener2 = null;
            onClickListenerImpl2 = null;
            onClickListenerImpl12 = null;
            if ((j & 776) != 0) {
            }
            if ((j & 800) != 0) {
            }
            z10 = false;
            if ((j & 832) == 0) {
            }
            z2 = false;
            j2 = j & 896;
            if (j2 != 0) {
            }
            int i152222 = i14;
            i6 = i9;
            switchStateListener = switchStateListener2;
            observableString = observableString2;
            i5 = i11;
            i = i10;
            str = str3;
            z4 = z9;
            i2 = i152222;
            OnClickListenerImpl1 onClickListenerImpl142222 = onClickListenerImpl12;
            i4 = i12;
            onClickListenerImpl = onClickListenerImpl2;
            i3 = i13;
            z5 = z8;
            onClickListenerImpl1 = onClickListenerImpl142222;
        } else {
            switchStateListener = null;
            onClickListenerImpl = null;
            observableString = null;
            str = null;
            onClickListenerImpl1 = null;
            onInputFinishListener = null;
            onSeekBarChangeListener = null;
            z = false;
            z2 = false;
            z3 = false;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            z4 = false;
            z5 = false;
            i6 = 0;
        }
        int i16 = (j & 8192) != 0 ? R.mipmap.seekbar_thumb : 0;
        int i17 = (j & 4096) != 0 ? R.mipmap.seekbar_thumb_disable : 0;
        long j3 = j & 896;
        if (j3 != 0) {
            if (!z) {
                i16 = i17;
            }
            i7 = i16;
        } else {
            i7 = 0;
        }
        if ((j & 768) != 0) {
            i8 = i;
            str2 = str;
            ViewBindingAdapter.set_input_enable(this.edtWhiteBalance, false);
            ViewBindingAdapter.setSwitchButtonListener(this.switchBtnPhotoGpsLocation, switchStateListener);
            this.tvAutoWhiteBalance.setOnClickListener(onClickListenerImpl);
            this.tvFormat.setOnClickListener(onClickListenerImpl1);
        } else {
            i8 = i;
            str2 = str;
        }
        if ((j & 784) != 0) {
            ViewBindingAdapter.setEdittextLimit(this.edtWhiteBalance, i2, i3, i4, i5, onInputFinishListener);
        }
        if ((776 & j) != 0) {
            ViewBindingAdapter.setText(this.mboundView4, observableString);
        }
        if ((832 & j) != 0) {
            ViewBindingAdapter.setSwitchButtonEnable(this.sbWater, z2);
        }
        if ((800 & j) != 0) {
            ViewBindingAdapter.setSwitchButtonChecked(this.sbWater, z3);
        }
        if (j3 != 0) {
            ViewBindingAdapter.setSeekbarThumb(this.sbWhiteBalance, i7);
            TextViewBindingAdapter.setText(this.tvAutoWhiteBalance, str2);
        }
        if ((j & 770) != 0) {
            z6 = z4;
            z7 = z5;
            ViewBindingAdapter.setSeekbarLimit(this.sbWhiteBalance, i8, 0, 0, i6, onSeekBarChangeListener);
        } else {
            z6 = z4;
            z7 = z5;
        }
        if ((j & 769) != 0) {
            ViewBindingAdapter.setSwitchButtonEnable(this.switchBtnPhotoGpsLocation, z7);
        }
        if ((j & 772) != 0) {
            ViewBindingAdapter.setSwitchButtonChecked(this.switchBtnPhotoGpsLocation, z6);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingCameraModel value;

        public OnClickListenerImpl setValue(SettingCameraModel settingCameraModel) {
            this.value = settingCameraModel;
            if (settingCameraModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnMwbClick(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private SettingCameraModel value;

        public OnClickListenerImpl1 setValue(SettingCameraModel settingCameraModel) {
            this.value = settingCameraModel;
            if (settingCameraModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnFormatSDClick(view);
        }
    }
}