package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ViewBindingAdapter;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.calibration.SettingGimbalFineTuningModel;
import com.ipotensic.kernel.view.CursorStringEditText;
import com.logan.opengl.JfGLSurfaceView;
import java.util.Objects;

/* loaded from: classes2.dex */
public class ViewLayoutGimbalFineTuningBindingImpl extends ViewLayoutGimbalFineTuningBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl3 mGimbalFineTuningModelSetLevelDefaultValueClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mGimbalFineTuningModelSetPlusLevelAndroidViewViewOnClickListener;
    private OnClickListenerImpl4 mGimbalFineTuningModelSetPlusYawAndroidViewViewOnClickListener;
    private OnClickListenerImpl5 mGimbalFineTuningModelSetReduceLevelAndroidViewViewOnClickListener;
    private OnClickListenerImpl mGimbalFineTuningModelSetReduceYawAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mGimbalFineTuningModelSetYawDefaultValueClickAndroidViewViewOnClickListener;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_video, 9);
        sparseIntArray.put(R.id.tv_count_down, 10);
        sparseIntArray.put(R.id.btn_close, 11);
        sparseIntArray.put(R.id.tv_level, 12);
        sparseIntArray.put(R.id.ll_level, 13);
        sparseIntArray.put(R.id.view_line, 14);
        sparseIntArray.put(R.id.tv_yaw, 15);
    }

    public ViewLayoutGimbalFineTuningBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ViewLayoutGimbalFineTuningBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageButton) objArr[11], (ImageButton) objArr[3], (ImageButton) objArr[7], (ImageButton) objArr[1], (ImageButton) objArr[5], (CursorStringEditText) objArr[2], (CursorStringEditText) objArr[6], (LinearLayout) objArr[13], (TextView) objArr[10], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[12], (TextView) objArr[15], (View) objArr[14], (JfGLSurfaceView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.btnPlusLevel.setTag(null);
        this.btnPlusYaw.setTag(null);
        this.btnReduceLevel.setTag(null);
        this.btnReduceYaw.setTag(null);
        this.etLevelValue.setTag(null);
        this.etYawValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvDefaultValueLevel.setTag(null);
        this.tvDefaultValueYaw.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
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
        if (BR.gimbalFineTuningModel != i) {
            return false;
        }
        setGimbalFineTuningModel((SettingGimbalFineTuningModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutGimbalFineTuningBinding
    public void setGimbalFineTuningModel(SettingGimbalFineTuningModel settingGimbalFineTuningModel) {
        updateRegistration(1, settingGimbalFineTuningModel);
        this.mGimbalFineTuningModel = settingGimbalFineTuningModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.gimbalFineTuningModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeGimbalFineTuningModelIsYawBtnEnable((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return onChangeGimbalFineTuningModel((SettingGimbalFineTuningModel) obj, i2);
        }
        if (i == 2) {
            return onChangeGimbalFineTuningModelLevelValue((ObservableString) obj, i2);
        }
        if (i == 3) {
            return onChangeGimbalFineTuningModelYawValue((ObservableString) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeGimbalFineTuningModelIsLevelBtnEnable((ObservableBoolean) obj, i2);
    }

    private boolean onChangeGimbalFineTuningModelIsYawBtnEnable(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeGimbalFineTuningModel(SettingGimbalFineTuningModel settingGimbalFineTuningModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeGimbalFineTuningModelLevelValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeGimbalFineTuningModelYawValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeGimbalFineTuningModelIsLevelBtnEnable(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x014f  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        OnClickListenerImpl3 onClickListenerImpl3;
        String str;
        OnClickListenerImpl onClickListenerImpl;
        CursorStringEditText.OnInputFinishListener onInputFinishListener;
        OnClickListenerImpl2 onClickListenerImpl2;
        String str2;
        OnClickListenerImpl4 onClickListenerImpl4;
        OnClickListenerImpl5 onClickListenerImpl5;
        CursorStringEditText.OnInputFinishListener onInputFinishListener2;
        OnClickListenerImpl1 onClickListenerImpl1;
        int i;
        float f;
        boolean z;
        float f2;
        int i2;
        boolean z2;
        OnClickListenerImpl3 onClickListenerImpl32;
        float f3;
        float f4;
        OnClickListenerImpl1 onClickListenerImpl12;
        int i3;
        boolean z3;
        int i4;
        float f5;
        long j2;
        int i5;
        boolean z4;
        ObservableBoolean observableBoolean;
        OnClickListenerImpl3 onClickListenerImpl33;
        ObservableBoolean observableBoolean2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingGimbalFineTuningModel settingGimbalFineTuningModel = this.mGimbalFineTuningModel;
        String str3 = null;
        if ((63 & j) != 0) {
            if ((j & 34) == 0 || settingGimbalFineTuningModel == null) {
                onClickListenerImpl = null;
                onInputFinishListener = null;
                onClickListenerImpl2 = null;
                onClickListenerImpl4 = null;
                onClickListenerImpl5 = null;
                onInputFinishListener2 = null;
                f3 = 0.0f;
                f4 = 0.0f;
            } else {
                Objects.requireNonNull(settingGimbalFineTuningModel);
                OnClickListenerImpl onClickListenerImpl6 = this.mGimbalFineTuningModelSetReduceYawAndroidViewViewOnClickListener;
                if (onClickListenerImpl6 == null) {
                    onClickListenerImpl6 = new OnClickListenerImpl();
                    this.mGimbalFineTuningModelSetReduceYawAndroidViewViewOnClickListener = onClickListenerImpl6;
                }
                OnClickListenerImpl value = onClickListenerImpl6.setValue(settingGimbalFineTuningModel);
                OnClickListenerImpl2 onClickListenerImpl22 = this.mGimbalFineTuningModelSetPlusLevelAndroidViewViewOnClickListener;
                if (onClickListenerImpl22 == null) {
                    onClickListenerImpl22 = new OnClickListenerImpl2();
                    this.mGimbalFineTuningModelSetPlusLevelAndroidViewViewOnClickListener = onClickListenerImpl22;
                }
                onClickListenerImpl2 = onClickListenerImpl22.setValue(settingGimbalFineTuningModel);
                Objects.requireNonNull(settingGimbalFineTuningModel);
                f4 = 10.0f;
                onInputFinishListener2 = settingGimbalFineTuningModel.yawValueInputListener;
                OnClickListenerImpl4 onClickListenerImpl42 = this.mGimbalFineTuningModelSetPlusYawAndroidViewViewOnClickListener;
                if (onClickListenerImpl42 == null) {
                    onClickListenerImpl42 = new OnClickListenerImpl4();
                    this.mGimbalFineTuningModelSetPlusYawAndroidViewViewOnClickListener = onClickListenerImpl42;
                }
                onClickListenerImpl4 = onClickListenerImpl42.setValue(settingGimbalFineTuningModel);
                Objects.requireNonNull(settingGimbalFineTuningModel);
                OnClickListenerImpl5 onClickListenerImpl52 = this.mGimbalFineTuningModelSetReduceLevelAndroidViewViewOnClickListener;
                if (onClickListenerImpl52 == null) {
                    onClickListenerImpl52 = new OnClickListenerImpl5();
                    this.mGimbalFineTuningModelSetReduceLevelAndroidViewViewOnClickListener = onClickListenerImpl52;
                }
                onClickListenerImpl5 = onClickListenerImpl52.setValue(settingGimbalFineTuningModel);
                onInputFinishListener = settingGimbalFineTuningModel.levelValueInputListener;
                onClickListenerImpl = value;
                f3 = -10.0f;
            }
            long j3 = j & 35;
            if (j3 != 0) {
                if (settingGimbalFineTuningModel != null) {
                    OnClickListenerImpl1 onClickListenerImpl13 = this.mGimbalFineTuningModelSetYawDefaultValueClickAndroidViewViewOnClickListener;
                    if (onClickListenerImpl13 == null) {
                        onClickListenerImpl13 = new OnClickListenerImpl1();
                        this.mGimbalFineTuningModelSetYawDefaultValueClickAndroidViewViewOnClickListener = onClickListenerImpl13;
                    }
                    onClickListenerImpl12 = onClickListenerImpl13.setValue(settingGimbalFineTuningModel);
                    observableBoolean2 = settingGimbalFineTuningModel.isYawBtnEnable;
                } else {
                    onClickListenerImpl12 = null;
                    observableBoolean2 = null;
                }
                updateRegistration(0, observableBoolean2);
                z3 = observableBoolean2 != null ? observableBoolean2.get() : false;
                if (j3 != 0) {
                    j |= z3 ? 128L : 64L;
                }
                i3 = z3 ? getColorFromResource(this.tvDefaultValueYaw, R.color.color_default_value_blue) : getColorFromResource(this.tvDefaultValueYaw, R.color.color_media_text);
            } else {
                onClickListenerImpl12 = null;
                i3 = 0;
                z3 = false;
            }
            long j4 = j & 50;
            if (j4 != 0) {
                if (settingGimbalFineTuningModel != null) {
                    OnClickListenerImpl3 onClickListenerImpl34 = this.mGimbalFineTuningModelSetLevelDefaultValueClickAndroidViewViewOnClickListener;
                    if (onClickListenerImpl34 == null) {
                        onClickListenerImpl34 = new OnClickListenerImpl3();
                        this.mGimbalFineTuningModelSetLevelDefaultValueClickAndroidViewViewOnClickListener = onClickListenerImpl34;
                    }
                    onClickListenerImpl33 = onClickListenerImpl34.setValue(settingGimbalFineTuningModel);
                    i4 = i3;
                    observableBoolean = settingGimbalFineTuningModel.isLevelBtnEnable;
                    f5 = f3;
                } else {
                    i4 = i3;
                    f5 = f3;
                    observableBoolean = null;
                    onClickListenerImpl33 = null;
                }
                updateRegistration(4, observableBoolean);
                z4 = observableBoolean != null ? observableBoolean.get() : false;
                if (j4 != 0) {
                    j |= z4 ? 512L : 256L;
                }
                j2 = 38;
                OnClickListenerImpl3 onClickListenerImpl35 = onClickListenerImpl33;
                i5 = getColorFromResource(this.tvDefaultValueLevel, z4 ? R.color.color_default_value_blue : R.color.color_media_text);
                onClickListenerImpl3 = onClickListenerImpl35;
            } else {
                i4 = i3;
                f5 = f3;
                onClickListenerImpl3 = null;
                j2 = 38;
                i5 = 0;
                z4 = false;
            }
            if ((j & j2) != 0) {
                ObservableString observableString = settingGimbalFineTuningModel != null ? settingGimbalFineTuningModel.levelValue : null;
                updateRegistration(2, observableString);
                if (observableString != null) {
                    str = observableString.get();
                    if ((j & 42) != 0) {
                        ObservableString observableString2 = settingGimbalFineTuningModel != null ? settingGimbalFineTuningModel.yawValue : null;
                        updateRegistration(3, observableString2);
                        if (observableString2 != null) {
                            str3 = observableString2.get();
                        }
                    }
                    i = i5;
                    onClickListenerImpl1 = onClickListenerImpl12;
                    z = z4;
                    str2 = str3;
                    i2 = i4;
                    f = f5;
                    z2 = z3;
                    f2 = f4;
                }
            }
            str = null;
            if ((j & 42) != 0) {
            }
            i = i5;
            onClickListenerImpl1 = onClickListenerImpl12;
            z = z4;
            str2 = str3;
            i2 = i4;
            f = f5;
            z2 = z3;
            f2 = f4;
        } else {
            onClickListenerImpl3 = null;
            str = null;
            onClickListenerImpl = null;
            onInputFinishListener = null;
            onClickListenerImpl2 = null;
            str2 = null;
            onClickListenerImpl4 = null;
            onClickListenerImpl5 = null;
            onInputFinishListener2 = null;
            onClickListenerImpl1 = null;
            i = 0;
            f = 0.0f;
            z = false;
            f2 = 0.0f;
            i2 = 0;
            z2 = false;
        }
        if ((j & 34) != 0) {
            onClickListenerImpl32 = onClickListenerImpl3;
            this.btnPlusLevel.setOnClickListener(onClickListenerImpl2);
            this.btnPlusYaw.setOnClickListener(onClickListenerImpl4);
            this.btnReduceLevel.setOnClickListener(onClickListenerImpl5);
            this.btnReduceYaw.setOnClickListener(onClickListenerImpl);
            ViewBindingAdapter.setStringEdittextLimit(this.etLevelValue, f2, 0.0f, f, onInputFinishListener);
            ViewBindingAdapter.setStringEdittextLimit(this.etYawValue, f2, 0.0f, f, onInputFinishListener2);
        } else {
            onClickListenerImpl32 = onClickListenerImpl3;
        }
        if ((38 & j) != 0) {
            TextViewBindingAdapter.setText(this.etLevelValue, str);
        }
        if ((42 & j) != 0) {
            TextViewBindingAdapter.setText(this.etYawValue, str2);
        }
        if ((50 & j) != 0) {
            this.tvDefaultValueLevel.setEnabled(z);
            this.tvDefaultValueLevel.setTextColor(i);
            androidx.databinding.adapters.ViewBindingAdapter.setOnClick(this.tvDefaultValueLevel, onClickListenerImpl32, z);
        }
        if ((j & 35) != 0) {
            boolean z5 = z2;
            this.tvDefaultValueYaw.setEnabled(z5);
            this.tvDefaultValueYaw.setTextColor(i2);
            androidx.databinding.adapters.ViewBindingAdapter.setOnClick(this.tvDefaultValueYaw, onClickListenerImpl1, z5);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingGimbalFineTuningModel value;

        public OnClickListenerImpl setValue(SettingGimbalFineTuningModel settingGimbalFineTuningModel) {
            this.value = settingGimbalFineTuningModel;
            if (settingGimbalFineTuningModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.setReduceYaw(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private SettingGimbalFineTuningModel value;

        public OnClickListenerImpl1 setValue(SettingGimbalFineTuningModel settingGimbalFineTuningModel) {
            this.value = settingGimbalFineTuningModel;
            if (settingGimbalFineTuningModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.setYawDefaultValueClick(view);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private SettingGimbalFineTuningModel value;

        public OnClickListenerImpl2 setValue(SettingGimbalFineTuningModel settingGimbalFineTuningModel) {
            this.value = settingGimbalFineTuningModel;
            if (settingGimbalFineTuningModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.setPlusLevel(view);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private SettingGimbalFineTuningModel value;

        public OnClickListenerImpl3 setValue(SettingGimbalFineTuningModel settingGimbalFineTuningModel) {
            this.value = settingGimbalFineTuningModel;
            if (settingGimbalFineTuningModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.setLevelDefaultValueClick(view);
        }
    }

    public static class OnClickListenerImpl4 implements View.OnClickListener {
        private SettingGimbalFineTuningModel value;

        public OnClickListenerImpl4 setValue(SettingGimbalFineTuningModel settingGimbalFineTuningModel) {
            this.value = settingGimbalFineTuningModel;
            if (settingGimbalFineTuningModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.setPlusYaw(view);
        }
    }

    public static class OnClickListenerImpl5 implements View.OnClickListener {
        private SettingGimbalFineTuningModel value;

        public OnClickListenerImpl5 setValue(SettingGimbalFineTuningModel settingGimbalFineTuningModel) {
            this.value = settingGimbalFineTuningModel;
            if (settingGimbalFineTuningModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.setReduceLevel(view);
        }
    }
}