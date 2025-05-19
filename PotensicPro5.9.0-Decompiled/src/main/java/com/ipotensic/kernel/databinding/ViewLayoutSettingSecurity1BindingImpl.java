package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingSecurityModel;
import com.ipotensic.kernel.view.BatteryCircleProgressView;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public class ViewLayoutSettingSecurity1BindingImpl extends ViewLayoutSettingSecurity1Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mSettingSecurityModelBtnBatteryInfoClickAndroidViewViewOnClickListener;
    private final FrameLayout mboundView0;
    private final TextView mboundView15;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_title, 16);
        sparseIntArray.put(R.id.layout_setting, 17);
        sparseIntArray.put(R.id.csv_beginner, 18);
        sparseIntArray.put(R.id.rl_unit, 19);
        sparseIntArray.put(R.id.tv_unit, 20);
        sparseIntArray.put(R.id.csv_unit, 21);
        sparseIntArray.put(R.id.line1, 22);
        sparseIntArray.put(R.id.tv_speed_setting, 23);
        sparseIntArray.put(R.id.crv, 24);
        sparseIntArray.put(R.id.rl_lost, 25);
        sparseIntArray.put(R.id.tvSignalLost, 26);
        sparseIntArray.put(R.id.tv_lost_action_warning, 27);
        sparseIntArray.put(R.id.tvLostChildFunction, 28);
        sparseIntArray.put(R.id.tv_lost_child, 29);
        sparseIntArray.put(R.id.csv_lost, 30);
        sparseIntArray.put(R.id.line2, 31);
        sparseIntArray.put(R.id.tv_return_height, 32);
        sparseIntArray.put(R.id.iv_play_return_height_video, 33);
        sparseIntArray.put(R.id.edt_return_height, 34);
        sparseIntArray.put(R.id.line3, 35);
        sparseIntArray.put(R.id.view_silent_return, 36);
        sparseIntArray.put(R.id.constraintlayoutFlightFence, 37);
        sparseIntArray.put(R.id.tv_height_no_limit, 38);
        sparseIntArray.put(R.id.edtDistanceLimit, 39);
        sparseIntArray.put(R.id.seekbarDistanceLimit, 40);
        sparseIntArray.put(R.id.view_fight_tip, 41);
        sparseIntArray.put(R.id.bg_battery, 42);
        sparseIntArray.put(R.id.battery_progress_view, 43);
        sparseIntArray.put(R.id.line4, 44);
        sparseIntArray.put(R.id.tvTemperatureTips, 45);
        sparseIntArray.put(R.id.tvCurrent, 46);
        sparseIntArray.put(R.id.tvVoltageTips, 47);
        sparseIntArray.put(R.id.tvCycleTimeTips, 48);
        sparseIntArray.put(R.id.tv_speed_change, 49);
    }

    public ViewLayoutSettingSecurity1BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 50, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingSecurity1BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (BatteryCircleProgressView) objArr[43], (LinearLayout) objArr[42], (RelativeLayout) objArr[37], (CommonSelectionView) objArr[24], (CommonSwitchView) objArr[18], (CommonSelectionView) objArr[30], (CommonSelectionView) objArr[21], (CursorEditText) objArr[39], (CursorEditText) objArr[4], (CursorEditText) objArr[34], (ImageView) objArr[33], (ConstraintLayout) objArr[11], (ScrollView) objArr[17], (View) objArr[22], (View) objArr[31], (View) objArr[35], (View) objArr[44], (RelativeLayout) objArr[25], (RelativeLayout) objArr[19], (CustomSeekbar) objArr[40], (CustomSeekbar) objArr[6], (SwitchButton) objArr[8], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[46], (TextView) objArr[13], (TextView) objArr[48], (TextView) objArr[7], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[38], (TextView) objArr[27], (TextView) objArr[29], (ImageButton) objArr[28], (TextView) objArr[32], (TextView) objArr[26], (TextView) objArr[49], (TextView) objArr[23], (TextView) objArr[12], (TextView) objArr[45], (TextView) objArr[20], (TextView) objArr[9], (TextView) objArr[5], (TextView) objArr[14], (TextView) objArr[47], (CommonSwitchView) objArr[41], (CommonSwitchView) objArr[36], (CommonTitleView) objArr[16]);
        this.mDirtyFlags = -1L;
        this.edtHeightLimit.setTag(null);
        this.layoutBattery.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[15];
        this.mboundView15 = textView;
        textView.setTag(null);
        this.seekbarHeightLimit.setTag(null);
        this.switchBtnNoLimit.setTag(null);
        this.tvAltitudeCarefulTips.setTag(null);
        this.tvBatteryInfo.setTag(null);
        this.tvCurrentValue.setTag(null);
        this.tvDistanceLimit.setTag(null);
        this.tvFlightFence.setTag(null);
        this.tvHeightLimit.setTag(null);
        this.tvTempValue.setTag(null);
        this.tvUnitDistanceLimit.setTag(null);
        this.tvUnitHeightLimit.setTag(null);
        this.tvVoltage.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8192L;
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
        if (BR.settingSecurityModel != i) {
            return false;
        }
        setSettingSecurityModel((SettingSecurityModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingSecurity1Binding
    public void setSettingSecurityModel(SettingSecurityModel settingSecurityModel) {
        this.mSettingSecurityModel = settingSecurityModel;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(BR.settingSecurityModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSettingSecurityModelCycleTimeValue((ObservableString) obj, i2);
            case 1:
                return onChangeSettingSecurityModelBeginnerMode((ObservableBoolean) obj, i2);
            case 2:
                return onChangeSettingSecurityModelInputLimitHeight((ObservableInt) obj, i2);
            case 3:
                return onChangeSettingSecurityModelIsReturningOrLanding((ObservableBoolean) obj, i2);
            case 4:
                return onChangeSettingSecurityModelTempValue((ObservableString) obj, i2);
            case 5:
                return onChangeSettingSecurityModelUnitTips((ObservableString) obj, i2);
            case 6:
                return onChangeSettingSecurityModelVoltageValue((ObservableString) obj, i2);
            case 7:
                return onChangeSettingSecurityModelUnitIsFt((ObservableBoolean) obj, i2);
            case 8:
                return onChangeSettingSecurityModelCurrentValue((ObservableString) obj, i2);
            case 9:
                return onChangeSettingSecurityModelFlightIsConnect((ObservableBoolean) obj, i2);
            case 10:
                return onChangeSettingSecurityModelShowBatteryInfo((ObservableBoolean) obj, i2);
            case 11:
                return onChangeSettingSecurityModelLimitDistanceMaxNoUnit((ObservableInt) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSettingSecurityModelCycleTimeValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelBeginnerMode(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelInputLimitHeight(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelIsReturningOrLanding(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelTempValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelUnitTips(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelVoltageValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelUnitIsFt(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelCurrentValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelFlightIsConnect(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelShowBatteryInfo(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelLimitDistanceMaxNoUnit(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x056d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:304:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x04c4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutSettingSecurity1BindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingSecurityModel value;

        public OnClickListenerImpl setValue(SettingSecurityModel settingSecurityModel) {
            this.value = settingSecurityModel;
            if (settingSecurityModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnBatteryInfoClick(view);
        }
    }
}
