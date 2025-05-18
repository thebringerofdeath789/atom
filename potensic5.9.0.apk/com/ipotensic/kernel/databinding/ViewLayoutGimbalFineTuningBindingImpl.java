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
import com.ipotensic.kernel.C1964BR;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.calibration.SettingGimbalFineTuningModel;
import com.ipotensic.kernel.view.CursorStringEditText;
import com.logan.opengl.JfGLSurfaceView;

/* loaded from: classes2.dex */
public class ViewLayoutGimbalFineTuningBindingImpl extends ViewLayoutGimbalFineTuningBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    /* renamed from: mGimbalFineTuningModelSetLevelDefaultValueClickAndroidViewViewOnClickListener */
    private OnClickListenerImpl3 f2191x2ddabb8f;
    private OnClickListenerImpl2 mGimbalFineTuningModelSetPlusLevelAndroidViewViewOnClickListener;
    private OnClickListenerImpl4 mGimbalFineTuningModelSetPlusYawAndroidViewViewOnClickListener;

    /* renamed from: mGimbalFineTuningModelSetReduceLevelAndroidViewViewOnClickListener */
    private OnClickListenerImpl5 f2192x2d4469eb;
    private OnClickListenerImpl mGimbalFineTuningModelSetReduceYawAndroidViewViewOnClickListener;

    /* renamed from: mGimbalFineTuningModelSetYawDefaultValueClickAndroidViewViewOnClickListener */
    private OnClickListenerImpl1 f2193xd50a2704;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C1965R.id.view_video, 9);
        sparseIntArray.put(C1965R.id.tv_count_down, 10);
        sparseIntArray.put(C1965R.id.btn_close, 11);
        sparseIntArray.put(C1965R.id.tv_level, 12);
        sparseIntArray.put(C1965R.id.ll_level, 13);
        sparseIntArray.put(C1965R.id.view_line, 14);
        sparseIntArray.put(C1965R.id.tv_yaw, 15);
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
        if (C1964BR.gimbalFineTuningModel != i) {
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
        notifyPropertyChanged(C1964BR.gimbalFineTuningModel);
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
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeGimbalFineTuningModel(SettingGimbalFineTuningModel settingGimbalFineTuningModel, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeGimbalFineTuningModelLevelValue(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeGimbalFineTuningModelYawValue(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeGimbalFineTuningModelIsLevelBtnEnable(ObservableBoolean observableBoolean, int i) {
        if (i != C1964BR._all) {
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutGimbalFineTuningBindingImpl.executeBindings():void");
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