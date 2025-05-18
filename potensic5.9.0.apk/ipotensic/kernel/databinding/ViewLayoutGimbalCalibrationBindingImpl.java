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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.calibration.SettingGimbalCalibrationModel;
import com.ipotensic.kernel.view.ProgressLoadingView;
import com.logan.opengl.JfGLSurfaceView;

/* loaded from: classes2.dex */
public class ViewLayoutGimbalCalibrationBindingImpl extends ViewLayoutGimbalCalibrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mGimbalCalibrationModelStartCalibrationAndroidViewViewOnClickListener;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_video, 7);
        sparseIntArray.put(R.id.tv_count_down, 8);
        sparseIntArray.put(R.id.btn_close, 9);
        sparseIntArray.put(R.id.pic_gimbal_calibration, 10);
        sparseIntArray.put(R.id.loadingView, 11);
    }

    public ViewLayoutGimbalCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ViewLayoutGimbalCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (ImageButton) objArr[9], (Button) objArr[3], (ImageView) objArr[5], (ProgressLoadingView) objArr[11], (ImageView) objArr[10], (TextView) objArr[8], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[1], (JfGLSurfaceView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.btnStartGimbalCalibration.setTag(null);
        this.ivGimbalCalibrationSuccess.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvGimbalCalibrationTips1.setTag(null);
        this.tvGimbalCalibrationTips2.setTag(null);
        this.tvGimbalResultTips.setTag(null);
        this.tvGimbalTitle.setTag(null);
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
        if (BR.gimbalCalibrationModel != i) {
            return false;
        }
        setGimbalCalibrationModel((SettingGimbalCalibrationModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutGimbalCalibrationBinding
    public void setGimbalCalibrationModel(SettingGimbalCalibrationModel settingGimbalCalibrationModel) {
        this.mGimbalCalibrationModel = settingGimbalCalibrationModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.gimbalCalibrationModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeGimbalCalibrationModelTitleStr((ObservableString) obj, i2);
            case 1:
                return onChangeGimbalCalibrationModelCalibrationResultResId((ObservableInt) obj, i2);
            case 2:
                return onChangeGimbalCalibrationModelStartBtnVisible((ObservableBoolean) obj, i2);
            case 3:
                return onChangeGimbalCalibrationModelStartBtnStr((ObservableString) obj, i2);
            case 4:
                return onChangeGimbalCalibrationModelResultStr((ObservableString) obj, i2);
            case 5:
                return onChangeGimbalCalibrationModelStepTwoVisible((ObservableBoolean) obj, i2);
            case 6:
                return onChangeGimbalCalibrationModelStepOneVisible((ObservableBoolean) obj, i2);
            case 7:
                return onChangeGimbalCalibrationModelStepThreeVisible((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeGimbalCalibrationModelTitleStr(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelCalibrationResultResId(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStartBtnVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStartBtnStr(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelResultStr(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStepTwoVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStepOneVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStepThreeVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0133  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        OnClickListenerImpl onClickListenerImpl;
        String str3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str4;
        int i7;
        long j2;
        int i8;
        long j3;
        int i9;
        long j4;
        long j5;
        long j6;
        long j7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingGimbalCalibrationModel settingGimbalCalibrationModel = this.mGimbalCalibrationModel;
        if ((1023 & j) != 0) {
            if ((j & 769) != 0) {
                ObservableString observableString = settingGimbalCalibrationModel != null ? settingGimbalCalibrationModel.titleStr : null;
                updateRegistration(0, observableString);
                if (observableString != null) {
                    str4 = observableString.get();
                    if ((j & 770) != 0) {
                        ObservableInt observableInt = settingGimbalCalibrationModel != null ? settingGimbalCalibrationModel.calibrationResultResId : null;
                        updateRegistration(1, observableInt);
                        if (observableInt != null) {
                            i7 = observableInt.get();
                            j2 = j & 772;
                            if (j2 != 0) {
                                ObservableBoolean observableBoolean = settingGimbalCalibrationModel != null ? settingGimbalCalibrationModel.startBtnVisible : null;
                                updateRegistration(2, observableBoolean);
                                boolean z = observableBoolean != null ? observableBoolean.get() : false;
                                if (j2 != 0) {
                                    j |= z ? 8192L : 4096L;
                                }
                                if (!z) {
                                    i8 = 8;
                                    if ((j & 768) != 0 || settingGimbalCalibrationModel == null) {
                                        onClickListenerImpl = null;
                                    } else {
                                        OnClickListenerImpl onClickListenerImpl2 = this.mGimbalCalibrationModelStartCalibrationAndroidViewViewOnClickListener;
                                        if (onClickListenerImpl2 == null) {
                                            onClickListenerImpl2 = new OnClickListenerImpl();
                                            this.mGimbalCalibrationModelStartCalibrationAndroidViewViewOnClickListener = onClickListenerImpl2;
                                        }
                                        onClickListenerImpl = onClickListenerImpl2.setValue(settingGimbalCalibrationModel);
                                    }
                                    if ((j & 776) != 0) {
                                        ObservableString observableString2 = settingGimbalCalibrationModel != null ? settingGimbalCalibrationModel.startBtnStr : null;
                                        updateRegistration(3, observableString2);
                                        if (observableString2 != null) {
                                            str3 = observableString2.get();
                                            if ((j & 784) != 0) {
                                                ObservableString observableString3 = settingGimbalCalibrationModel != null ? settingGimbalCalibrationModel.resultStr : null;
                                                updateRegistration(4, observableString3);
                                                if (observableString3 != null) {
                                                    str = observableString3.get();
                                                    j3 = j & 800;
                                                    if (j3 != 0) {
                                                        ObservableBoolean observableBoolean2 = settingGimbalCalibrationModel != null ? settingGimbalCalibrationModel.stepTwoVisible : null;
                                                        updateRegistration(5, observableBoolean2);
                                                        boolean z2 = observableBoolean2 != null ? observableBoolean2.get() : false;
                                                        if (j3 != 0) {
                                                            j |= z2 ? 131072L : 65536L;
                                                        }
                                                        if (!z2) {
                                                            i9 = 8;
                                                            j4 = j & 832;
                                                            if (j4 != 0) {
                                                                ObservableBoolean observableBoolean3 = settingGimbalCalibrationModel != null ? settingGimbalCalibrationModel.stepOneVisible : null;
                                                                updateRegistration(6, observableBoolean3);
                                                                boolean z3 = observableBoolean3 != null ? observableBoolean3.get() : false;
                                                                if (j4 != 0) {
                                                                    j |= z3 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                                                }
                                                                if (!z3) {
                                                                    i4 = 8;
                                                                    j5 = j & 896;
                                                                    if (j5 == 0) {
                                                                        ObservableBoolean observableBoolean4 = settingGimbalCalibrationModel != null ? settingGimbalCalibrationModel.stepThreeVisible : null;
                                                                        updateRegistration(7, observableBoolean4);
                                                                        boolean z4 = observableBoolean4 != null ? observableBoolean4.get() : false;
                                                                        if (j5 != 0) {
                                                                            if (z4) {
                                                                                j6 = j | 2048;
                                                                                j7 = 32768;
                                                                            } else {
                                                                                j6 = j | 1024;
                                                                                j7 = 16384;
                                                                            }
                                                                            j = j6 | j7;
                                                                        }
                                                                        int i10 = z4 ? 0 : 8;
                                                                        i5 = i9;
                                                                        i3 = i7;
                                                                        i = z4 ? 0 : 4;
                                                                        i6 = i8;
                                                                        str2 = str4;
                                                                        i2 = i10;
                                                                    } else {
                                                                        i5 = i9;
                                                                        i3 = i7;
                                                                        i = 0;
                                                                        i6 = i8;
                                                                        str2 = str4;
                                                                        i2 = 0;
                                                                    }
                                                                }
                                                            }
                                                            i4 = 0;
                                                            j5 = j & 896;
                                                            if (j5 == 0) {
                                                            }
                                                        }
                                                    }
                                                    i9 = 0;
                                                    j4 = j & 832;
                                                    if (j4 != 0) {
                                                    }
                                                    i4 = 0;
                                                    j5 = j & 896;
                                                    if (j5 == 0) {
                                                    }
                                                }
                                            }
                                            str = null;
                                            j3 = j & 800;
                                            if (j3 != 0) {
                                            }
                                            i9 = 0;
                                            j4 = j & 832;
                                            if (j4 != 0) {
                                            }
                                            i4 = 0;
                                            j5 = j & 896;
                                            if (j5 == 0) {
                                            }
                                        }
                                    }
                                    str3 = null;
                                    if ((j & 784) != 0) {
                                    }
                                    str = null;
                                    j3 = j & 800;
                                    if (j3 != 0) {
                                    }
                                    i9 = 0;
                                    j4 = j & 832;
                                    if (j4 != 0) {
                                    }
                                    i4 = 0;
                                    j5 = j & 896;
                                    if (j5 == 0) {
                                    }
                                }
                            }
                            i8 = 0;
                            if ((j & 768) != 0) {
                            }
                            onClickListenerImpl = null;
                            if ((j & 776) != 0) {
                            }
                            str3 = null;
                            if ((j & 784) != 0) {
                            }
                            str = null;
                            j3 = j & 800;
                            if (j3 != 0) {
                            }
                            i9 = 0;
                            j4 = j & 832;
                            if (j4 != 0) {
                            }
                            i4 = 0;
                            j5 = j & 896;
                            if (j5 == 0) {
                            }
                        }
                    }
                    i7 = 0;
                    j2 = j & 772;
                    if (j2 != 0) {
                    }
                    i8 = 0;
                    if ((j & 768) != 0) {
                    }
                    onClickListenerImpl = null;
                    if ((j & 776) != 0) {
                    }
                    str3 = null;
                    if ((j & 784) != 0) {
                    }
                    str = null;
                    j3 = j & 800;
                    if (j3 != 0) {
                    }
                    i9 = 0;
                    j4 = j & 832;
                    if (j4 != 0) {
                    }
                    i4 = 0;
                    j5 = j & 896;
                    if (j5 == 0) {
                    }
                }
            }
            str4 = null;
            if ((j & 770) != 0) {
            }
            i7 = 0;
            j2 = j & 772;
            if (j2 != 0) {
            }
            i8 = 0;
            if ((j & 768) != 0) {
            }
            onClickListenerImpl = null;
            if ((j & 776) != 0) {
            }
            str3 = null;
            if ((j & 784) != 0) {
            }
            str = null;
            j3 = j & 800;
            if (j3 != 0) {
            }
            i9 = 0;
            j4 = j & 832;
            if (j4 != 0) {
            }
            i4 = 0;
            j5 = j & 896;
            if (j5 == 0) {
            }
        } else {
            str = null;
            str2 = null;
            onClickListenerImpl = null;
            str3 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if ((j & 768) != 0) {
            this.btnStartGimbalCalibration.setOnClickListener(onClickListenerImpl);
        }
        if ((j & 776) != 0) {
            TextViewBindingAdapter.setText(this.btnStartGimbalCalibration, str3);
        }
        if ((772 & j) != 0) {
            this.btnStartGimbalCalibration.setVisibility(i6);
        }
        if ((896 & j) != 0) {
            this.ivGimbalCalibrationSuccess.setVisibility(i);
            this.tvGimbalResultTips.setVisibility(i2);
        }
        if ((j & 770) != 0) {
            this.ivGimbalCalibrationSuccess.setImageResource(i3);
        }
        if ((832 & j) != 0) {
            this.tvGimbalCalibrationTips1.setVisibility(i4);
        }
        if ((800 & j) != 0) {
            this.tvGimbalCalibrationTips2.setVisibility(i5);
        }
        if ((784 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvGimbalResultTips, str);
        }
        if ((j & 769) != 0) {
            TextViewBindingAdapter.setText(this.tvGimbalTitle, str2);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingGimbalCalibrationModel value;

        public OnClickListenerImpl setValue(SettingGimbalCalibrationModel settingGimbalCalibrationModel) {
            this.value = settingGimbalCalibrationModel;
            if (settingGimbalCalibrationModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.startCalibration(view);
        }
    }
}