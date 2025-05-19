package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingControlModel;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;

/* loaded from: classes2.dex */
public class ViewLayoutSettingControlBindingImpl extends ViewLayoutSettingControlBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl5 mSettingControlModelBtnAngel0ClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl mSettingControlModelBtnAngel45ClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mSettingControlModelBtnAngel90ClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl4 mSettingControlModelBtnFpvModeClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mSettingControlModelBtnModeGuideVideoAndroidViewViewOnClickListener;
    private OnClickListenerImpl6 mSettingControlModelBtnResetFpvSmoothAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mSettingControlModelBtnResetPitchSpeedAndroidViewViewOnClickListener;
    private OnClickListenerImpl7 mSettingControlModelBtnStableModeClickAndroidViewViewOnClickListener;
    private final FrameLayout mboundView0;
    private final TextView mboundView12;
    private final TextView mboundView13;
    private final TextView mboundView15;
    private final RelativeLayout mboundView7;
    private final RelativeLayout mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_title, 20);
        sparseIntArray.put(R.id.layout_setting, 21);
        sparseIntArray.put(R.id.base_line_left, 22);
        sparseIntArray.put(R.id.tv_controller_setting, 23);
        sparseIntArray.put(R.id.tv_stick_mode, 24);
        sparseIntArray.put(R.id.grout_gimbal, 25);
        sparseIntArray.put(R.id.tv_gimbal_setting, 26);
        sparseIntArray.put(R.id.view_gimbal_setting, 27);
        sparseIntArray.put(R.id.layout_max_pitch_speed, 28);
        sparseIntArray.put(R.id.tv_unit_circle_speed, 29);
        sparseIntArray.put(R.id.line1, 30);
        sparseIntArray.put(R.id.tv_current_angle, 31);
        sparseIntArray.put(R.id.line_pitch_angle_45, 32);
        sparseIntArray.put(R.id.line2, 33);
        sparseIntArray.put(R.id.tv_gimbal_mode, 34);
    }

    public ViewLayoutSettingControlBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 35, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (Guideline) objArr[22], (CursorEditText) objArr[17], (CursorEditText) objArr[3], (Group) objArr[25], (ImageButton) objArr[10], (LinearLayout) objArr[28], (LinearLayout) objArr[6], (RelativeLayout) objArr[8], (LinearLayout) objArr[16], (ScrollView) objArr[21], (View) objArr[30], (View) objArr[33], (View) objArr[32], (LinearLayout) objArr[11], (CustomSeekbar) objArr[18], (CustomSeekbar) objArr[4], (View) objArr[19], (TextView) objArr[23], (TextView) objArr[31], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[34], (TextView) objArr[26], (TextView) objArr[1], (TextView) objArr[14], (TextView) objArr[24], (TextView) objArr[29], (View) objArr[27], (CommonTitleView) objArr[20]);
        this.mDirtyFlags = -1L;
        this.edtSmooth.setTag(null);
        this.edtSpeed.setTag(null);
        this.ibGimbalMode.setTag(null);
        this.layoutPitchAngle.setTag(null);
        this.layoutPitchAngle45.setTag(null);
        this.layoutRollSmooth.setTag(null);
        this.llGimbalMode.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.mboundView12 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.mboundView15 = textView3;
        textView3.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[7];
        this.mboundView7 = relativeLayout;
        relativeLayout.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[9];
        this.mboundView9 = relativeLayout2;
        relativeLayout2.setTag(null);
        this.seekbarSmooth.setTag(null);
        this.seekbarSpeed.setTag(null);
        this.spaceGimbal.setTag(null);
        this.tvCurrentAngleValue.setTag(null);
        this.tvDefault.setTag(null);
        this.tvMaxPitch.setTag(null);
        this.tvRollSmooth.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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
        if (BR.settingControlModel != i) {
            return false;
        }
        setSettingControlModel((SettingControlModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingControlBinding
    public void setSettingControlModel(SettingControlModel settingControlModel) {
        this.mSettingControlModel = settingControlModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.settingControlModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeSettingControlModelPitchSpeed((ObservableInt) obj, i2);
        }
        if (i == 1) {
            return onChangeSettingControlModelFpvSmooth((ObservableInt) obj, i2);
        }
        if (i == 2) {
            return onChangeSettingControlModelPitchAngel((ObservableInt) obj, i2);
        }
        if (i == 3) {
            return onChangeSettingControlModelCurrentAngel((ObservableString) obj, i2);
        }
        if (i == 4) {
            return onChangeSettingControlModelIsConnectFlight((ObservableBoolean) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return onChangeSettingControlModelStableMode((ObservableBoolean) obj, i2);
    }

    private boolean onChangeSettingControlModelPitchSpeed(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingControlModelFpvSmooth(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSettingControlModelPitchAngel(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSettingControlModelCurrentAngel(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSettingControlModelIsConnectFlight(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSettingControlModelStableMode(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0328  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutSettingControlBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingControlModel value;

        public OnClickListenerImpl setValue(SettingControlModel settingControlModel) {
            this.value = settingControlModel;
            if (settingControlModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnAngel45Click(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private SettingControlModel value;

        public OnClickListenerImpl1 setValue(SettingControlModel settingControlModel) {
            this.value = settingControlModel;
            if (settingControlModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnAngel90Click(view);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private SettingControlModel value;

        public OnClickListenerImpl2 setValue(SettingControlModel settingControlModel) {
            this.value = settingControlModel;
            if (settingControlModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnModeGuideVideo(view);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private SettingControlModel value;

        public OnClickListenerImpl3 setValue(SettingControlModel settingControlModel) {
            this.value = settingControlModel;
            if (settingControlModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnResetPitchSpeed(view);
        }
    }

    public static class OnClickListenerImpl4 implements View.OnClickListener {
        private SettingControlModel value;

        public OnClickListenerImpl4 setValue(SettingControlModel settingControlModel) {
            this.value = settingControlModel;
            if (settingControlModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnFpvModeClick(view);
        }
    }

    public static class OnClickListenerImpl5 implements View.OnClickListener {
        private SettingControlModel value;

        public OnClickListenerImpl5 setValue(SettingControlModel settingControlModel) {
            this.value = settingControlModel;
            if (settingControlModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnAngel0Click(view);
        }
    }

    public static class OnClickListenerImpl6 implements View.OnClickListener {
        private SettingControlModel value;

        public OnClickListenerImpl6 setValue(SettingControlModel settingControlModel) {
            this.value = settingControlModel;
            if (settingControlModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnResetFpvSmooth(view);
        }
    }

    public static class OnClickListenerImpl7 implements View.OnClickListener {
        private SettingControlModel value;

        public OnClickListenerImpl7 setValue(SettingControlModel settingControlModel) {
            this.value = settingControlModel;
            if (settingControlModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnStableModeClick(view);
        }
    }
}
