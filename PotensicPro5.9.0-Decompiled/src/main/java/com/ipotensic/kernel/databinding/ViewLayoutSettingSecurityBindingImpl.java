package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingSecurityModel;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public class ViewLayoutSettingSecurityBindingImpl extends ViewLayoutSettingSecurityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mSettingSecurityModelBtnBatteryInfoClickAndroidViewViewOnClickListener;
    private final FrameLayout mboundView0;
    private final TextView mboundView5;
    private final CustomSeekbar mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_title, 19);
        sparseIntArray.put(R.id.layout_setting, 20);
        sparseIntArray.put(R.id.base_line_left, 21);
        sparseIntArray.put(R.id.base_line_right, 22);
        sparseIntArray.put(R.id.csv_beginner, 23);
        sparseIntArray.put(R.id.bg_unit, 24);
        sparseIntArray.put(R.id.tv_unit, 25);
        sparseIntArray.put(R.id.csv_unit, 26);
        sparseIntArray.put(R.id.line1, 27);
        sparseIntArray.put(R.id.tv_speed_setting, 28);
        sparseIntArray.put(R.id.space_unit, 29);
        sparseIntArray.put(R.id.crv, 30);
        sparseIntArray.put(R.id.layoutFence, 31);
        sparseIntArray.put(R.id.tvSignalLost, 32);
        sparseIntArray.put(R.id.tv_lost_action_warning, 33);
        sparseIntArray.put(R.id.tvLostChildFunction, 34);
        sparseIntArray.put(R.id.csv_lost, 35);
        sparseIntArray.put(R.id.line2, 36);
        sparseIntArray.put(R.id.iv_play_return_height_video, 37);
        sparseIntArray.put(R.id.line3, 38);
        sparseIntArray.put(R.id.view_silent_return, 39);
        sparseIntArray.put(R.id.constraintlayoutFlightFence, 40);
        sparseIntArray.put(R.id.tv_height_no_limit, 41);
        sparseIntArray.put(R.id.edtDistanceLimit, 42);
        sparseIntArray.put(R.id.seekbarDistanceLimit, 43);
        sparseIntArray.put(R.id.view_fight_tip, 44);
        sparseIntArray.put(R.id.bg_battery, 45);
        sparseIntArray.put(R.id.vs_battery, 46);
        sparseIntArray.put(R.id.tv_speed_change, 47);
    }

    public ViewLayoutSettingSecurityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 48, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingSecurityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (Guideline) objArr[21], (Guideline) objArr[22], (LinearLayout) objArr[45], (View) objArr[24], (ConstraintLayout) objArr[40], (CommonSelectionView) objArr[30], (CommonSwitchView) objArr[23], (CommonSelectionView) objArr[35], (CommonSelectionView) objArr[26], (CursorEditText) objArr[42], (CursorEditText) objArr[11], (CursorEditText) objArr[4], (ImageView) objArr[37], (LinearLayout) objArr[16], (ConstraintLayout) objArr[31], (LinearLayout) objArr[10], (LinearLayout) objArr[3], (ScrollView) objArr[20], (View) objArr[27], (View) objArr[36], (View) objArr[38], (CustomSeekbar) objArr[43], (CustomSeekbar) objArr[13], (View) objArr[29], (SwitchButton) objArr[15], (TextView) objArr[9], (TextView) objArr[18], (TextView) objArr[14], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[41], (TextView) objArr[33], (TextView) objArr[1], (ImageButton) objArr[34], (TextView) objArr[2], (TextView) objArr[32], (TextView) objArr[47], (TextView) objArr[28], (TextView) objArr[25], (TextView) objArr[17], (TextView) objArr[12], (CommonSwitchView) objArr[44], (CommonSwitchView) objArr[39], (CommonTitleView) objArr[19], new ViewStubProxy((ViewStub) objArr[46]));
        this.mDirtyFlags = -1L;
        this.edtHeightLimit.setTag(null);
        this.edtReturnHeight.setTag(null);
        this.layoutDistanceLimit.setTag(null);
        this.layoutFlightFence.setTag(null);
        this.layoutReturnHeight.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        CustomSeekbar customSeekbar = (CustomSeekbar) objArr[6];
        this.mboundView6 = customSeekbar;
        customSeekbar.setTag(null);
        this.seekbarHeightLimit.setTag(null);
        this.switchBtnNoLimit.setTag(null);
        this.tvAltitudeCarefulTips.setTag(null);
        this.tvBatteryInfo.setTag(null);
        this.tvDistanceLimit.setTag(null);
        this.tvFlightFence.setTag(null);
        this.tvHeightLimit.setTag(null);
        this.tvLostChild.setTag(null);
        this.tvReturnHeight.setTag(null);
        this.tvUnitDistanceLimit.setTag(null);
        this.tvUnitHeightLimit.setTag(null);
        this.vsBattery.setContainingBinding(this);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048L;
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

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingSecurityBinding
    public void setSettingSecurityModel(SettingSecurityModel settingSecurityModel) {
        this.mSettingSecurityModel = settingSecurityModel;
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        notifyPropertyChanged(BR.settingSecurityModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSettingSecurityModelBeginnerMode((ObservableBoolean) obj, i2);
            case 1:
                return onChangeSettingSecurityModelInputLimitHeight((ObservableInt) obj, i2);
            case 2:
                return onChangeSettingSecurityModelIsReturningOrLanding((ObservableBoolean) obj, i2);
            case 3:
                return onChangeSettingSecurityModelInputReturnHeight((ObservableInt) obj, i2);
            case 4:
                return onChangeSettingSecurityModelUnitTips((ObservableString) obj, i2);
            case 5:
                return onChangeSettingSecurityModelUnitIsFt((ObservableBoolean) obj, i2);
            case 6:
                return onChangeSettingSecurityModelFlightIsConnect((ObservableBoolean) obj, i2);
            case 7:
                return onChangeSettingSecurityModelMaxHeight((ObservableInt) obj, i2);
            case 8:
                return onChangeSettingSecurityModelWarnMaxHeight((ObservableInt) obj, i2);
            case 9:
                return onChangeSettingSecurityModelLimitDistanceMaxNoUnit((ObservableInt) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSettingSecurityModelBeginnerMode(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelInputLimitHeight(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelIsReturningOrLanding(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelInputReturnHeight(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelUnitTips(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelUnitIsFt(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelFlightIsConnect(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelMaxHeight(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelWarnMaxHeight(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelLimitDistanceMaxNoUnit(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x028b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x060b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0722  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:356:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1852
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutSettingSecurityBindingImpl.executeBindings():void");
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
