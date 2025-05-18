package com.ipotensic.kernel.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ViewBindingAdapter;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingSecurityModel;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;
import com.logan.flight.FlightConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

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
        sparseIntArray.put(R.id.csw_stop, 44);
        sparseIntArray.put(R.id.bgFlySafety, 45);
        sparseIntArray.put(R.id.view_fight_tip, 46);
        sparseIntArray.put(R.id.layoutUom, 47);
        sparseIntArray.put(R.id.line4, 48);
        sparseIntArray.put(R.id.tvUomExpand, 49);
        sparseIntArray.put(R.id.tvUploadState, 50);
        sparseIntArray.put(R.id.layoutUomExpend, 51);
        sparseIntArray.put(R.id.tvUomTips, 52);
        sparseIntArray.put(R.id.line5, 53);
        sparseIntArray.put(R.id.tvFlightRouteUploadRecord, 54);
        sparseIntArray.put(R.id.bg_battery, 55);
        sparseIntArray.put(R.id.vs_battery, 56);
        sparseIntArray.put(R.id.tv_speed_change, 57);
    }

    public ViewLayoutSettingSecurityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 58, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingSecurityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (Guideline) objArr[21], (Guideline) objArr[22], (LinearLayout) objArr[55], (LinearLayout) objArr[45], (View) objArr[24], (ConstraintLayout) objArr[40], (CommonSelectionView) objArr[30], (CommonSwitchView) objArr[23], (CommonSelectionView) objArr[35], (CommonSelectionView) objArr[26], (CommonSwitchView) objArr[44], (CursorEditText) objArr[42], (CursorEditText) objArr[11], (CursorEditText) objArr[4], (ImageView) objArr[37], (LinearLayout) objArr[16], (ConstraintLayout) objArr[31], (LinearLayout) objArr[10], (LinearLayout) objArr[3], (ScrollView) objArr[20], (LinearLayout) objArr[47], (LinearLayout) objArr[51], (View) objArr[27], (View) objArr[36], (View) objArr[38], (View) objArr[48], (View) objArr[53], (CustomSeekbar) objArr[43], (CustomSeekbar) objArr[13], (View) objArr[29], (SwitchButton) objArr[15], (TextView) objArr[9], (TextView) objArr[18], (TextView) objArr[14], (TextView) objArr[7], (TextView) objArr[54], (TextView) objArr[8], (TextView) objArr[41], (TextView) objArr[33], (TextView) objArr[1], (ImageButton) objArr[34], (TextView) objArr[2], (TextView) objArr[32], (TextView) objArr[57], (TextView) objArr[28], (TextView) objArr[25], (TextView) objArr[17], (TextView) objArr[12], (TextView) objArr[49], (TextView) objArr[52], (TextView) objArr[50], (CommonSwitchView) objArr[46], (CommonSwitchView) objArr[39], (CommonTitleView) objArr[19], new ViewStubProxy((ViewStub) objArr[56]));
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
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        ObservableBoolean observableBoolean;
        ObservableInt observableInt;
        ObservableInt observableInt2;
        CursorEditText.OnInputFinishListener onInputFinishListener;
        ObservableString observableString;
        String str2;
        OnClickListenerImpl onClickListenerImpl;
        ObservableInt observableInt3;
        CursorEditText.OnInputFinishListener onInputFinishListener2;
        ObservableBoolean observableBoolean2;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        boolean z5;
        int i5;
        int i6;
        int i7;
        long j3;
        int i8;
        long j4;
        int i9;
        ObservableInt observableInt4;
        boolean z6;
        int i10;
        int i11;
        int i12;
        long j5;
        int i13;
        int i14;
        long j6;
        int i15;
        int i16;
        int i17;
        long j7;
        int i18;
        int i19;
        int i20;
        long j8;
        int i21;
        int i22;
        int i23;
        ObservableString observableString2;
        boolean z7;
        String str3;
        long j9;
        boolean z8;
        boolean z9;
        long j10;
        boolean z10;
        long j11;
        boolean z11;
        boolean z12;
        String str4;
        String str5;
        OnClickListenerImpl onClickListenerImpl2;
        boolean z13;
        ObservableString observableString3;
        ObservableInt observableInt5;
        ObservableInt observableInt6;
        ObservableBoolean observableBoolean3;
        long j12;
        long j13;
        OnClickListenerImpl onClickListenerImpl3;
        ObservableBoolean observableBoolean4;
        int i24;
        ObservableInt observableInt7;
        ObservableInt observableInt8;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener3;
        int i25;
        ObservableInt observableInt9;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener4;
        int i26;
        String str6;
        ObservableString observableString4;
        OnClickListenerImpl onClickListenerImpl4;
        int i27;
        ObservableInt observableInt10;
        ObservableBoolean observableBoolean5;
        String str7;
        boolean z14;
        int i28;
        int i29;
        long j14;
        ObservableBoolean observableBoolean6;
        boolean z15;
        long j15;
        CursorEditText.OnInputFinishListener onInputFinishListener3;
        int i30;
        boolean z16;
        int i31;
        ObservableInt observableInt11;
        int i32;
        ObservableBoolean observableBoolean7;
        ObservableBoolean observableBoolean8;
        ObservableBoolean observableBoolean9;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingSecurityModel settingSecurityModel = this.mSettingSecurityModel;
        if ((4095 & j) != 0) {
            if ((j & 3072) == 0 || settingSecurityModel == null) {
                onClickListenerImpl3 = null;
            } else {
                OnClickListenerImpl onClickListenerImpl5 = this.mSettingSecurityModelBtnBatteryInfoClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl5 == null) {
                    onClickListenerImpl5 = new OnClickListenerImpl();
                    this.mSettingSecurityModelBtnBatteryInfoClickAndroidViewViewOnClickListener = onClickListenerImpl5;
                }
                onClickListenerImpl3 = onClickListenerImpl5.setValue(settingSecurityModel);
            }
            long j16 = j & 3077;
            if (j16 != 0) {
                observableBoolean4 = settingSecurityModel != null ? settingSecurityModel.beginnerMode : null;
                updateRegistration(0, observableBoolean4);
                z = observableBoolean4 != null ? observableBoolean4.get() : false;
                z3 = !z;
                if (j16 != 0) {
                    j |= z3 ? 131072L : 65536L;
                }
            } else {
                z = false;
                z3 = false;
                observableBoolean4 = null;
            }
            if ((j & 3458) != 0) {
                observableInt7 = settingSecurityModel != null ? settingSecurityModel.inputLimitHeight : null;
                updateRegistration(1, observableInt7);
                i24 = observableInt7 != null ? observableInt7.get() : 0;
            } else {
                i24 = 0;
                observableInt7 = null;
            }
            if ((j & 3202) != 0) {
                if (settingSecurityModel != null) {
                    onSeekBarChangeListener3 = settingSecurityModel.limitHeightSeekbarListener;
                    observableInt8 = settingSecurityModel.maxHeight;
                } else {
                    observableInt8 = null;
                    onSeekBarChangeListener3 = null;
                }
                updateRegistration(7, observableInt8);
                if (observableInt8 != null) {
                    i25 = observableInt8.get();
                    if ((j & 3080) == 0) {
                        if (settingSecurityModel != null) {
                            observableInt9 = settingSecurityModel.inputReturnHeight;
                            onSeekBarChangeListener4 = settingSecurityModel.returnHeightSeekbarListener;
                        } else {
                            observableInt9 = null;
                            onSeekBarChangeListener4 = null;
                        }
                        updateRegistration(3, observableInt9);
                        if (observableInt9 != null) {
                            i26 = observableInt9.get();
                            if ((j & 3632) != 0) {
                                observableString4 = settingSecurityModel != null ? settingSecurityModel.unitTips : null;
                                updateRegistration(4, observableString4);
                                str6 = observableString4 != null ? observableString4.get() : null;
                            } else {
                                str6 = null;
                                observableString4 = null;
                            }
                            if ((j & 3770) != 0) {
                                if (settingSecurityModel != null) {
                                    observableBoolean8 = settingSecurityModel.unitIsFt;
                                    onClickListenerImpl4 = onClickListenerImpl3;
                                } else {
                                    onClickListenerImpl4 = onClickListenerImpl3;
                                    observableBoolean8 = null;
                                }
                                updateRegistration(5, observableBoolean8);
                                boolean z17 = observableBoolean8 != null ? observableBoolean8.get() : false;
                                if ((j & 3128) != 0) {
                                    j |= z17 ? 8192L : 4096L;
                                }
                                if ((j & 3632) != 0) {
                                    j = z17 ? j | 32768 | 137438953472L : j | 16384 | 68719476736L;
                                }
                                if ((j & 3112) != 0) {
                                    j = z17 ? j | 8388608 : j | 4194304;
                                }
                                if ((j & 3234) != 0) {
                                    j = z17 ? j | IjkMediaMeta.AV_CH_STEREO_LEFT | IjkMediaMeta.AV_CH_WIDE_LEFT : j | 268435456 | IjkMediaMeta.AV_CH_STEREO_RIGHT;
                                }
                                if ((j & 3258) != 0) {
                                    j |= z17 ? IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT : IjkMediaMeta.AV_CH_WIDE_RIGHT;
                                }
                                if ((j & 3242) != 0) {
                                    j |= z17 ? IjkMediaMeta.AV_CH_LOW_FREQUENCY_2 : IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
                                }
                                if ((j & 3128) != 0) {
                                    i29 = FlightConfig.getMaxReturnHeight();
                                    if (z17) {
                                        i29 = FlightConfig.get_value(i29);
                                    }
                                } else {
                                    i29 = 0;
                                }
                                if ((j & 3632) != 0) {
                                    i5 = 20;
                                    if (z17) {
                                        i5 = FlightConfig.get_value(20);
                                    }
                                } else {
                                    i5 = 0;
                                }
                                if ((j & 3258) != 0) {
                                    i6 = z17 ? FlightConfig.get_value(10) : 10;
                                    if ((j & 3120) != 0) {
                                        observableBoolean9 = observableBoolean8;
                                        i27 = i25;
                                        observableInt10 = observableInt7;
                                        observableBoolean2 = observableBoolean4;
                                        str8 = this.tvReturnHeight.getResources().getString(R.string.txt_flight_return_height, Integer.valueOf(i6), Integer.valueOf(i29), str6);
                                    } else {
                                        observableBoolean9 = observableBoolean8;
                                        i27 = i25;
                                        observableInt10 = observableInt7;
                                        observableBoolean2 = observableBoolean4;
                                        str8 = null;
                                    }
                                } else {
                                    observableBoolean9 = observableBoolean8;
                                    i27 = i25;
                                    observableInt10 = observableInt7;
                                    observableBoolean2 = observableBoolean4;
                                    str8 = null;
                                    i6 = 0;
                                }
                                if ((j & 3242) != 0) {
                                    i28 = z17 ? FlightConfig.get_value(30) : 30;
                                    z14 = z17;
                                } else {
                                    z14 = z17;
                                    i28 = 0;
                                }
                                str7 = str8;
                                observableBoolean5 = observableBoolean9;
                            } else {
                                onClickListenerImpl4 = onClickListenerImpl3;
                                i27 = i25;
                                observableInt10 = observableInt7;
                                observableBoolean2 = observableBoolean4;
                                observableBoolean5 = null;
                                str7 = null;
                                z14 = false;
                                i28 = 0;
                                i29 = 0;
                                i5 = 0;
                                i6 = 0;
                            }
                            j14 = j & 3173;
                            String str9 = str6;
                            if (j14 != 0) {
                                if (settingSecurityModel != null) {
                                    observableBoolean7 = settingSecurityModel.FlightIsConnect;
                                    observableBoolean6 = observableBoolean5;
                                } else {
                                    observableBoolean6 = observableBoolean5;
                                    observableBoolean7 = null;
                                }
                                updateRegistration(6, observableBoolean7);
                                z15 = observableBoolean7 != null ? observableBoolean7.get() : false;
                                if (j14 != 0) {
                                    j = z15 ? j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                }
                            } else {
                                observableBoolean6 = observableBoolean5;
                                z15 = false;
                            }
                            CursorEditText.OnInputFinishListener onInputFinishListener4 = ((j & 3112) != 0 || settingSecurityModel == null) ? null : settingSecurityModel.returnHeightInputListener;
                            j15 = j & 3330;
                            boolean z18 = z15;
                            if (j15 != 0) {
                                if (settingSecurityModel != null) {
                                    observableInt11 = settingSecurityModel.warnMaxHeight;
                                    onInputFinishListener3 = onInputFinishListener4;
                                } else {
                                    onInputFinishListener3 = onInputFinishListener4;
                                    observableInt11 = null;
                                }
                                updateRegistration(8, observableInt11);
                                if (observableInt11 != null) {
                                    i32 = observableInt11.get();
                                    i30 = i24;
                                } else {
                                    i30 = i24;
                                    i32 = 0;
                                }
                                z16 = i30 > i32;
                                if (j15 != 0) {
                                    j = z16 ? j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE | 33554432 : j | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED | 16777216;
                                }
                                if (!z16) {
                                    i31 = 8;
                                    j2 = 0;
                                    if ((j & 3234) != 0 || settingSecurityModel == null) {
                                        i4 = i30;
                                        i3 = i28;
                                        i8 = i31;
                                        onSeekBarChangeListener = onSeekBarChangeListener3;
                                        observableInt3 = observableInt9;
                                        onSeekBarChangeListener2 = onSeekBarChangeListener4;
                                        onInputFinishListener = null;
                                        onClickListenerImpl = onClickListenerImpl4;
                                        str = str9;
                                        observableInt2 = observableInt10;
                                        z2 = z18;
                                        onInputFinishListener2 = onInputFinishListener3;
                                        j = j;
                                        str2 = str7;
                                        observableInt = observableInt8;
                                        i7 = i26;
                                    } else {
                                        i4 = i30;
                                        i3 = i28;
                                        i8 = i31;
                                        onSeekBarChangeListener = onSeekBarChangeListener3;
                                        observableInt3 = observableInt9;
                                        onSeekBarChangeListener2 = onSeekBarChangeListener4;
                                        onClickListenerImpl = onClickListenerImpl4;
                                        str = str9;
                                        observableInt2 = observableInt10;
                                        z2 = z18;
                                        onInputFinishListener2 = onInputFinishListener3;
                                        onInputFinishListener = settingSecurityModel.limitHeightInputListener;
                                        str2 = str7;
                                        observableInt = observableInt8;
                                        i7 = i26;
                                        j = j;
                                    }
                                    z4 = z14;
                                    observableString = observableString4;
                                    i2 = i29;
                                    i = i27;
                                    j3 = 33554432;
                                    z5 = z16;
                                    observableBoolean = observableBoolean6;
                                }
                            } else {
                                onInputFinishListener3 = onInputFinishListener4;
                                i30 = i24;
                                z16 = false;
                            }
                            i31 = 0;
                            j2 = 0;
                            if ((j & 3234) != 0) {
                            }
                            i4 = i30;
                            i3 = i28;
                            i8 = i31;
                            onSeekBarChangeListener = onSeekBarChangeListener3;
                            observableInt3 = observableInt9;
                            onSeekBarChangeListener2 = onSeekBarChangeListener4;
                            onInputFinishListener = null;
                            onClickListenerImpl = onClickListenerImpl4;
                            str = str9;
                            observableInt2 = observableInt10;
                            z2 = z18;
                            onInputFinishListener2 = onInputFinishListener3;
                            j = j;
                            str2 = str7;
                            observableInt = observableInt8;
                            i7 = i26;
                            z4 = z14;
                            observableString = observableString4;
                            i2 = i29;
                            i = i27;
                            j3 = 33554432;
                            z5 = z16;
                            observableBoolean = observableBoolean6;
                        }
                    } else {
                        observableInt9 = null;
                        onSeekBarChangeListener4 = null;
                    }
                    i26 = 0;
                    if ((j & 3632) != 0) {
                    }
                    if ((j & 3770) != 0) {
                    }
                    j14 = j & 3173;
                    String str92 = str6;
                    if (j14 != 0) {
                    }
                    if ((j & 3112) != 0) {
                    }
                    j15 = j & 3330;
                    boolean z182 = z15;
                    if (j15 != 0) {
                    }
                    i31 = 0;
                    j2 = 0;
                    if ((j & 3234) != 0) {
                    }
                    i4 = i30;
                    i3 = i28;
                    i8 = i31;
                    onSeekBarChangeListener = onSeekBarChangeListener3;
                    observableInt3 = observableInt9;
                    onSeekBarChangeListener2 = onSeekBarChangeListener4;
                    onInputFinishListener = null;
                    onClickListenerImpl = onClickListenerImpl4;
                    str = str92;
                    observableInt2 = observableInt10;
                    z2 = z182;
                    onInputFinishListener2 = onInputFinishListener3;
                    j = j;
                    str2 = str7;
                    observableInt = observableInt8;
                    i7 = i26;
                    z4 = z14;
                    observableString = observableString4;
                    i2 = i29;
                    i = i27;
                    j3 = 33554432;
                    z5 = z16;
                    observableBoolean = observableBoolean6;
                }
            } else {
                observableInt8 = null;
                onSeekBarChangeListener3 = null;
            }
            i25 = 0;
            if ((j & 3080) == 0) {
            }
            i26 = 0;
            if ((j & 3632) != 0) {
            }
            if ((j & 3770) != 0) {
            }
            j14 = j & 3173;
            String str922 = str6;
            if (j14 != 0) {
            }
            if ((j & 3112) != 0) {
            }
            j15 = j & 3330;
            boolean z1822 = z15;
            if (j15 != 0) {
            }
            i31 = 0;
            j2 = 0;
            if ((j & 3234) != 0) {
            }
            i4 = i30;
            i3 = i28;
            i8 = i31;
            onSeekBarChangeListener = onSeekBarChangeListener3;
            observableInt3 = observableInt9;
            onSeekBarChangeListener2 = onSeekBarChangeListener4;
            onInputFinishListener = null;
            onClickListenerImpl = onClickListenerImpl4;
            str = str922;
            observableInt2 = observableInt10;
            z2 = z1822;
            onInputFinishListener2 = onInputFinishListener3;
            j = j;
            str2 = str7;
            observableInt = observableInt8;
            i7 = i26;
            z4 = z14;
            observableString = observableString4;
            i2 = i29;
            i = i27;
            j3 = 33554432;
            z5 = z16;
            observableBoolean = observableBoolean6;
        } else {
            j2 = 0;
            str = null;
            observableBoolean = null;
            observableInt = null;
            observableInt2 = null;
            onInputFinishListener = null;
            observableString = null;
            str2 = null;
            onClickListenerImpl = null;
            observableInt3 = null;
            onInputFinishListener2 = null;
            observableBoolean2 = null;
            onSeekBarChangeListener = null;
            onSeekBarChangeListener2 = null;
            i = 0;
            z = false;
            i2 = 0;
            z2 = false;
            i3 = 0;
            z3 = false;
            i4 = 0;
            z4 = false;
            z5 = false;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            j3 = 33554432;
            i8 = 0;
        }
        if ((j & j3) != j2) {
            i9 = R.color.text_color_setting_red;
            j4 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        } else {
            j4 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            i9 = 0;
        }
        if ((j & j4) != j2) {
            if (settingSecurityModel != null) {
                observableBoolean = settingSecurityModel.unitIsFt;
            }
            observableInt4 = observableInt;
            updateRegistration(5, observableBoolean);
            if (observableBoolean != null) {
                z4 = observableBoolean.get();
            }
            if ((j & 3128) != 0) {
                j |= z4 ? 8192L : 4096L;
            }
            if ((j & 3632) != 0) {
                j = z4 ? j | 32768 | 137438953472L : j | 16384 | 68719476736L;
            }
            if ((j & 3112) != 0) {
                j = z4 ? j | 8388608 : j | 4194304;
            }
            if ((j & 3234) != 0) {
                if (z4) {
                    j12 = j | IjkMediaMeta.AV_CH_STEREO_LEFT;
                    j13 = IjkMediaMeta.AV_CH_WIDE_LEFT;
                } else {
                    j12 = j | 268435456;
                    j13 = IjkMediaMeta.AV_CH_STEREO_RIGHT;
                }
                j = j12 | j13;
            }
            if ((j & 3258) != 0) {
                j |= z4 ? IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT : IjkMediaMeta.AV_CH_WIDE_RIGHT;
            }
            if ((j & 3242) != 0) {
                j |= z4 ? IjkMediaMeta.AV_CH_LOW_FREQUENCY_2 : IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
            }
            z6 = !z4;
        } else {
            observableInt4 = observableInt;
            z6 = false;
        }
        int i33 = (j & 16777216) != 0 ? R.color.text_color_setting_blue : 0;
        long j17 = j & 3173;
        if (j17 != 0) {
            if (!z2) {
                z6 = false;
            }
            if (j17 != 0) {
                j |= z6 ? 549755813888L : 274877906944L;
            }
        } else {
            z6 = false;
        }
        if ((j & 3330) != 0) {
            if (!z5) {
                i9 = i33;
            }
            i10 = i9;
        } else {
            i10 = 0;
        }
        if ((j & 549755813888L) != 0) {
            i11 = i10;
            if (settingSecurityModel != null) {
                observableBoolean3 = settingSecurityModel.beginnerMode;
                i12 = i;
            } else {
                i12 = i;
                observableBoolean3 = observableBoolean2;
            }
            updateRegistration(0, observableBoolean3);
            if (observableBoolean3 != null) {
                z = observableBoolean3.get();
            }
            z3 = !z;
            if ((j & 3077) != 0) {
                j |= z3 ? 131072L : 65536L;
            }
        } else {
            i11 = i10;
            i12 = i;
        }
        boolean z19 = z3;
        if ((805306368 & j) != 0) {
            if (settingSecurityModel != null) {
                observableInt2 = settingSecurityModel.inputLimitHeight;
            }
            updateRegistration(1, observableInt2);
            if (observableInt2 != null) {
                i4 = observableInt2.get();
            }
            j5 = 0;
            if ((j & IjkMediaMeta.AV_CH_STEREO_LEFT) != 0) {
                i14 = FlightConfig.get_value(i4);
                i13 = i4;
                if ((12582912 & j) == j5) {
                    ObservableInt observableInt12 = settingSecurityModel != null ? settingSecurityModel.inputReturnHeight : observableInt3;
                    updateRegistration(3, observableInt12);
                    if (observableInt12 != null) {
                        i7 = observableInt12.get();
                    }
                    j6 = 0;
                    if ((j & 8388608) != 0) {
                        i16 = FlightConfig.get_value(i7);
                        i15 = i7;
                        if ((j & 3221225472L) != j6) {
                            if (settingSecurityModel != null) {
                                observableInt6 = settingSecurityModel.maxHeight;
                                i17 = i14;
                            } else {
                                i17 = i14;
                                observableInt6 = observableInt4;
                            }
                            updateRegistration(7, observableInt6);
                            if (observableInt6 != null) {
                                i12 = observableInt6.get();
                            }
                            j7 = 0;
                            if ((j & IjkMediaMeta.AV_CH_WIDE_LEFT) != 0) {
                                i19 = FlightConfig.get_value(i12);
                                i18 = i12;
                                if ((j & 206158430208L) == j7) {
                                    if (settingSecurityModel != null) {
                                        observableInt5 = settingSecurityModel.limitDistanceMaxNoUnit;
                                        i20 = i19;
                                    } else {
                                        i20 = i19;
                                        observableInt5 = null;
                                    }
                                    updateRegistration(9, observableInt5);
                                    i21 = observableInt5 != null ? observableInt5.get() : 0;
                                    j8 = 0;
                                    if ((j & 137438953472L) != 0) {
                                        i22 = FlightConfig.get_value(i21);
                                        if ((j & 3112) != j8) {
                                            if (!z4) {
                                                i16 = i15;
                                            }
                                            i23 = i16;
                                        } else {
                                            i23 = 0;
                                        }
                                        if ((j & 3234) != j8) {
                                            if (!z4) {
                                                i17 = i13;
                                            }
                                            if (!z4) {
                                                i20 = i18;
                                            }
                                        } else {
                                            i20 = 0;
                                            i17 = 0;
                                        }
                                        if ((j & 3632) != j8) {
                                            if (z4) {
                                                i21 = i22;
                                            }
                                            observableString2 = observableString;
                                            z7 = false;
                                            str3 = this.tvDistanceLimit.getResources().getString(R.string.txt_flight_distance_limit, Integer.valueOf(i5), Integer.valueOf(i21), str);
                                        } else {
                                            observableString2 = observableString;
                                            z7 = false;
                                            str3 = null;
                                        }
                                        j9 = j & 3173;
                                        if (j9 != 0) {
                                            z8 = z6 ? z19 : z7;
                                            if (j9 != 0) {
                                                j |= z8 ? 134217728L : 67108864L;
                                            }
                                        } else {
                                            z8 = z7;
                                        }
                                        if ((134348800 & j) != 0) {
                                            ObservableBoolean observableBoolean10 = settingSecurityModel != null ? settingSecurityModel.isReturningOrLanding : null;
                                            updateRegistration(2, observableBoolean10);
                                            z9 = !(observableBoolean10 != null ? observableBoolean10.get() : z7);
                                        } else {
                                            z9 = z7;
                                        }
                                        j10 = j & 3077;
                                        if (j10 != 0) {
                                            z10 = z19 ? z9 : z7;
                                        } else {
                                            z10 = z7;
                                        }
                                        j11 = j & 3173;
                                        boolean z20 = (j11 == 0 && z8) ? z9 : z7;
                                        if (j11 != 0) {
                                            ViewBindingAdapter.set_input_enable(this.edtHeightLimit, z20);
                                            ViewBindingAdapter.set_input_enable(this.edtReturnHeight, z20);
                                        }
                                        if ((j & 3234) != 0) {
                                            z11 = z10;
                                            ViewBindingAdapter.setEdittextLimit(this.edtHeightLimit, i20, i3, i6, i17, onInputFinishListener);
                                        } else {
                                            z11 = z10;
                                        }
                                        if ((j & 3112) != 0) {
                                            z12 = z19;
                                            str4 = str3;
                                            observableString3 = observableString2;
                                            str5 = str2;
                                            onClickListenerImpl2 = onClickListenerImpl;
                                            z13 = z2;
                                            ViewBindingAdapter.setEdittextLimit(this.edtReturnHeight, i2, i3, i6, i23, onInputFinishListener2);
                                        } else {
                                            z12 = z19;
                                            str4 = str3;
                                            str5 = str2;
                                            onClickListenerImpl2 = onClickListenerImpl;
                                            z13 = z2;
                                            observableString3 = observableString2;
                                        }
                                        if ((3073 & j) != 0) {
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.layoutDistanceLimit, z12);
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.layoutFlightFence, z12);
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.layoutReturnHeight, z12);
                                            ViewBindingAdapter.setSwitchButtonEnable(this.switchBtnNoLimit, z12);
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.switchBtnNoLimit, z12);
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.tvDistanceLimit, z12);
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.tvFlightFence, z12);
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.tvHeightLimit, z12);
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.tvReturnHeight, z12);
                                        }
                                        if ((3088 & j) != 0) {
                                            ViewBindingAdapter.setText(this.mboundView5, observableString3);
                                            ViewBindingAdapter.setText(this.tvUnitDistanceLimit, observableString3);
                                            ViewBindingAdapter.setText(this.tvUnitHeightLimit, observableString3);
                                        }
                                        if (j10 != 0) {
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.mboundView6, z11);
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.seekbarHeightLimit, z11);
                                        }
                                        if ((3080 & j) != 0) {
                                            ViewBindingAdapter.setSeekbarLimit(this.mboundView6, FlightConfig.getMaxReturnHeight(), 30, 10, i15, onSeekBarChangeListener2);
                                        }
                                        if ((j & 3330) != 0) {
                                            ViewBindingAdapter.setProgressColor(this.seekbarHeightLimit, i11);
                                            this.tvAltitudeCarefulTips.setVisibility(i8);
                                        }
                                        if ((3202 & j) != 0) {
                                            ViewBindingAdapter.setSeekbarLimit(this.seekbarHeightLimit, i18, 30, 10, i13, onSeekBarChangeListener);
                                        }
                                        if ((3072 & j) != 0) {
                                            this.tvBatteryInfo.setOnClickListener(onClickListenerImpl2);
                                        }
                                        if ((j & 3632) != 0) {
                                            TextViewBindingAdapter.setText(this.tvDistanceLimit, str4);
                                        }
                                        if ((3136 & j) != 0) {
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.tvLostChild, z13);
                                        }
                                        if ((j & 3120) != 0) {
                                            TextViewBindingAdapter.setText(this.tvReturnHeight, str5);
                                        }
                                        if (this.vsBattery.getBinding() != null) {
                                            executeBindingsOn(this.vsBattery.getBinding());
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    i20 = i19;
                                    j8 = 0;
                                    i21 = 0;
                                }
                                i22 = 0;
                                if ((j & 3112) != j8) {
                                }
                                if ((j & 3234) != j8) {
                                }
                                if ((j & 3632) != j8) {
                                }
                                j9 = j & 3173;
                                if (j9 != 0) {
                                }
                                if ((134348800 & j) != 0) {
                                }
                                j10 = j & 3077;
                                if (j10 != 0) {
                                }
                                j11 = j & 3173;
                                if (j11 == 0) {
                                }
                                if (j11 != 0) {
                                }
                                if ((j & 3234) != 0) {
                                }
                                if ((j & 3112) != 0) {
                                }
                                if ((3073 & j) != 0) {
                                }
                                if ((3088 & j) != 0) {
                                }
                                if (j10 != 0) {
                                }
                                if ((3080 & j) != 0) {
                                }
                                if ((j & 3330) != 0) {
                                }
                                if ((3202 & j) != 0) {
                                }
                                if ((3072 & j) != 0) {
                                }
                                if ((j & 3632) != 0) {
                                }
                                if ((3136 & j) != 0) {
                                }
                                if ((j & 3120) != 0) {
                                }
                                if (this.vsBattery.getBinding() != null) {
                                }
                            }
                        } else {
                            i17 = i14;
                            j7 = 0;
                        }
                        i18 = i12;
                        i19 = 0;
                        if ((j & 206158430208L) == j7) {
                        }
                        i22 = 0;
                        if ((j & 3112) != j8) {
                        }
                        if ((j & 3234) != j8) {
                        }
                        if ((j & 3632) != j8) {
                        }
                        j9 = j & 3173;
                        if (j9 != 0) {
                        }
                        if ((134348800 & j) != 0) {
                        }
                        j10 = j & 3077;
                        if (j10 != 0) {
                        }
                        j11 = j & 3173;
                        if (j11 == 0) {
                        }
                        if (j11 != 0) {
                        }
                        if ((j & 3234) != 0) {
                        }
                        if ((j & 3112) != 0) {
                        }
                        if ((3073 & j) != 0) {
                        }
                        if ((3088 & j) != 0) {
                        }
                        if (j10 != 0) {
                        }
                        if ((3080 & j) != 0) {
                        }
                        if ((j & 3330) != 0) {
                        }
                        if ((3202 & j) != 0) {
                        }
                        if ((3072 & j) != 0) {
                        }
                        if ((j & 3632) != 0) {
                        }
                        if ((3136 & j) != 0) {
                        }
                        if ((j & 3120) != 0) {
                        }
                        if (this.vsBattery.getBinding() != null) {
                        }
                    }
                } else {
                    j6 = 0;
                }
                i15 = i7;
                i16 = 0;
                if ((j & 3221225472L) != j6) {
                }
                i18 = i12;
                i19 = 0;
                if ((j & 206158430208L) == j7) {
                }
                i22 = 0;
                if ((j & 3112) != j8) {
                }
                if ((j & 3234) != j8) {
                }
                if ((j & 3632) != j8) {
                }
                j9 = j & 3173;
                if (j9 != 0) {
                }
                if ((134348800 & j) != 0) {
                }
                j10 = j & 3077;
                if (j10 != 0) {
                }
                j11 = j & 3173;
                if (j11 == 0) {
                }
                if (j11 != 0) {
                }
                if ((j & 3234) != 0) {
                }
                if ((j & 3112) != 0) {
                }
                if ((3073 & j) != 0) {
                }
                if ((3088 & j) != 0) {
                }
                if (j10 != 0) {
                }
                if ((3080 & j) != 0) {
                }
                if ((j & 3330) != 0) {
                }
                if ((3202 & j) != 0) {
                }
                if ((3072 & j) != 0) {
                }
                if ((j & 3632) != 0) {
                }
                if ((3136 & j) != 0) {
                }
                if ((j & 3120) != 0) {
                }
                if (this.vsBattery.getBinding() != null) {
                }
            }
        } else {
            j5 = 0;
        }
        i13 = i4;
        i14 = 0;
        if ((12582912 & j) == j5) {
        }
        i15 = i7;
        i16 = 0;
        if ((j & 3221225472L) != j6) {
        }
        i18 = i12;
        i19 = 0;
        if ((j & 206158430208L) == j7) {
        }
        i22 = 0;
        if ((j & 3112) != j8) {
        }
        if ((j & 3234) != j8) {
        }
        if ((j & 3632) != j8) {
        }
        j9 = j & 3173;
        if (j9 != 0) {
        }
        if ((134348800 & j) != 0) {
        }
        j10 = j & 3077;
        if (j10 != 0) {
        }
        j11 = j & 3173;
        if (j11 == 0) {
        }
        if (j11 != 0) {
        }
        if ((j & 3234) != 0) {
        }
        if ((j & 3112) != 0) {
        }
        if ((3073 & j) != 0) {
        }
        if ((3088 & j) != 0) {
        }
        if (j10 != 0) {
        }
        if ((3080 & j) != 0) {
        }
        if ((j & 3330) != 0) {
        }
        if ((3202 & j) != 0) {
        }
        if ((3072 & j) != 0) {
        }
        if ((j & 3632) != 0) {
        }
        if ((3136 & j) != 0) {
        }
        if ((j & 3120) != 0) {
        }
        if (this.vsBattery.getBinding() != null) {
        }
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