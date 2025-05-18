package com.ipotensic.kernel.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ViewBindingAdapter;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.calibration.SettingCompassCalibrationModel;
import com.logan.flight.FlightConfig;

/* loaded from: classes2.dex */
public class ViewLayoutCompassCalibrationBindingImpl extends ViewLayoutCompassCalibrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_compass_title, 10);
        sparseIntArray.put(R.id.btn_close, 11);
        sparseIntArray.put(R.id.iv_rotating_axis, 12);
        sparseIntArray.put(R.id.img_atom, 13);
        sparseIntArray.put(R.id.tv_mini_geo_step_tips, 14);
        sparseIntArray.put(R.id.tv_fail_notice, 15);
        sparseIntArray.put(R.id.tv_count_down, 16);
    }

    public ViewLayoutCompassCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private ViewLayoutCompassCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageButton) objArr[11], (Button) objArr[5], (ConstraintLayout) objArr[8], (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[1], (ImageView) objArr[13], (ImageView) objArr[9], (ImageView) objArr[7], (ImageView) objArr[12], (ImageView) objArr[2], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[16], (TextView) objArr[15], (TextView) objArr[14]);
        this.mDirtyFlags = -1L;
        this.btnStart.setTag(null);
        this.clCalibrationResult.setTag(null);
        this.clCalibrationStart.setTag(null);
        this.clCompassCalibration.setTag(null);
        this.ivCalibrationResult.setTag(null);
        this.ivMiniGeoStepTips.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.picCompassCalibration.setTag(null);
        this.tvCompassHeightTip.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
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
        if (BR.compassCalibrationModel != i) {
            return false;
        }
        setCompassCalibrationModel((SettingCompassCalibrationModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutCompassCalibrationBinding
    public void setCompassCalibrationModel(SettingCompassCalibrationModel settingCompassCalibrationModel) {
        this.mCompassCalibrationModel = settingCompassCalibrationModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.compassCalibrationModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeCompassCalibrationModelUnitIsFt((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return onChangeCompassCalibrationModelCurrentViewVisible((ObservableInt) obj, i2);
        }
        if (i == 2) {
            return onChangeCompassCalibrationModelCalibrationResultResId((ObservableInt) obj, i2);
        }
        if (i == 3) {
            return onChangeCompassCalibrationModelCompassHeightTips((ObservableString) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeCompassCalibrationModelImageId((ObservableInt) obj, i2);
    }

    private boolean onChangeCompassCalibrationModelUnitIsFt(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeCompassCalibrationModelCurrentViewVisible(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeCompassCalibrationModelCalibrationResultResId(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeCompassCalibrationModelCompassHeightTips(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeCompassCalibrationModelImageId(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0133 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        ScaleClickListener scaleClickListener;
        ObservableString observableString;
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingCompassCalibrationModel settingCompassCalibrationModel = this.mCompassCalibrationModel;
        long j3 = j & 64;
        if (j3 != 0) {
            if (j3 != 0) {
                j |= FlightConfig.isAtomLT() ? 65536L : 32768L;
            }
            if ((j & 64) != 0) {
                j = (FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? j | 4096 : j | 2048;
            }
        }
        if ((127 & j) != 0) {
            long j4 = j & 97;
            if (j4 != 0) {
                ObservableBoolean observableBoolean = settingCompassCalibrationModel != null ? settingCompassCalibrationModel.unitIsFt : null;
                updateRegistration(0, observableBoolean);
                z = observableBoolean != null ? observableBoolean.get() : false;
                if (j4 != 0) {
                    j = z ? j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE : j | 131072;
                }
            } else {
                z = false;
            }
            long j5 = j & 98;
            if (j5 != 0) {
                ObservableInt observableInt = settingCompassCalibrationModel != null ? settingCompassCalibrationModel.currentViewVisible : null;
                updateRegistration(1, observableInt);
                int i9 = observableInt != null ? observableInt.get() : 0;
                boolean z2 = i9 == 0;
                boolean z3 = i9 == 1;
                boolean z4 = i9 == 2;
                if (j5 != 0) {
                    j |= z2 ? 16384L : 8192L;
                }
                if ((j & 98) != 0) {
                    j |= z3 ? 1024L : 512L;
                }
                if ((j & 98) != 0) {
                    j |= z4 ? 256L : 128L;
                }
                i2 = 8;
                i3 = z2 ? 0 : 8;
                i8 = z3 ? 0 : 8;
                if (z4) {
                    i2 = 0;
                }
            } else {
                i2 = 0;
                i3 = 0;
                i8 = 0;
            }
            if ((j & 100) != 0) {
                ObservableInt observableInt2 = settingCompassCalibrationModel != null ? settingCompassCalibrationModel.calibrationResultResId : null;
                updateRegistration(2, observableInt2);
                if (observableInt2 != null) {
                    i = observableInt2.get();
                    if ((j & 104) == 0) {
                        observableString = settingCompassCalibrationModel != null ? settingCompassCalibrationModel.compassHeightTips : null;
                        updateRegistration(3, observableString);
                    } else {
                        observableString = null;
                    }
                    if ((j & 112) != 0) {
                        ObservableInt observableInt3 = settingCompassCalibrationModel != null ? settingCompassCalibrationModel.imageId : null;
                        updateRegistration(4, observableInt3);
                        if (observableInt3 != null) {
                            i4 = observableInt3.get();
                            scaleClickListener = ((j & 96) != 0 || settingCompassCalibrationModel == null) ? null : settingCompassCalibrationModel.startCalibration;
                            i5 = i8;
                            j2 = 2048;
                        }
                    }
                    i4 = 0;
                    if ((j & 96) != 0) {
                    }
                    i5 = i8;
                    j2 = 2048;
                }
            }
            i = 0;
            if ((j & 104) == 0) {
            }
            if ((j & 112) != 0) {
            }
            i4 = 0;
            if ((j & 96) != 0) {
            }
            i5 = i8;
            j2 = 2048;
        } else {
            j2 = 2048;
            scaleClickListener = null;
            observableString = null;
            i = 0;
            i2 = 0;
            z = false;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        int i10 = (j & j2) != 0 ? R.mipmap.pic_compass_calibration : 0;
        int i11 = (j & 131072) != 0 ? R.string.setting_mini_geo_tip : 0;
        int i12 = (j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0 ? R.string.setting_mini_geo_tip1 : 0;
        int i13 = (j & 4096) != 0 ? R.mipmap.pic_compass_calibration_se : 0;
        long j6 = j & 64;
        if (j6 != 0) {
            if (FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) {
                i10 = i13;
            }
            i6 = i10;
        } else {
            i6 = 0;
        }
        long j7 = j & 97;
        if (j7 != 0) {
            if (!z) {
                i12 = i11;
            }
            i7 = i12;
        } else {
            i7 = 0;
        }
        if ((96 & j) != 0) {
            this.btnStart.setOnClickListener(scaleClickListener);
        }
        if ((j & 98) != 0) {
            this.clCalibrationResult.setVisibility(i2);
            this.clCalibrationStart.setVisibility(i5);
            this.clCompassCalibration.setVisibility(i3);
        }
        if ((j & 100) != 0) {
            this.ivCalibrationResult.setImageResource(i);
        }
        if ((j & 112) != 0) {
            this.ivMiniGeoStepTips.setImageResource(i4);
        }
        if (j7 != 0) {
            this.mboundView4.setText(i7);
        }
        if (j6 != 0) {
            ViewBindingAdapter.setImageViewResource(this.picCompassCalibration, i6);
        }
        if ((j & 104) != 0) {
            ViewBindingAdapter.setText(this.tvCompassHeightTip, observableString);
        }
    }
}