package com.ipotensic.kernel.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ViewBindingAdapter;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingControlModel;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import java.util.Objects;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

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
    */
    protected void executeBindings() {
        long j;
        String str;
        OnClickListenerImpl onClickListenerImpl;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
        String str2;
        OnClickListenerImpl2 onClickListenerImpl2;
        String str3;
        OnClickListenerImpl3 onClickListenerImpl3;
        String str4;
        ObservableString observableString;
        CursorEditText.OnInputFinishListener onInputFinishListener;
        CursorEditText.OnInputFinishListener onInputFinishListener2;
        OnClickListenerImpl4 onClickListenerImpl4;
        OnClickListenerImpl5 onClickListenerImpl5;
        OnClickListenerImpl6 onClickListenerImpl6;
        OnClickListenerImpl7 onClickListenerImpl7;
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f;
        int i12;
        float f2;
        float f3;
        float f4;
        int i13;
        int i14;
        float f5;
        float f6;
        float f7;
        int i15;
        int i16;
        int i17;
        int i18;
        float f8;
        OnClickListenerImpl onClickListenerImpl8;
        int i19;
        int i20;
        boolean z4;
        int i21;
        OnClickListenerImpl1 onClickListenerImpl1;
        int i22;
        int i23;
        int i24;
        int i25;
        OnClickListenerImpl5 onClickListenerImpl52;
        OnClickListenerImpl6 onClickListenerImpl62;
        OnClickListenerImpl4 onClickListenerImpl42;
        OnClickListenerImpl onClickListenerImpl9;
        OnClickListenerImpl2 onClickListenerImpl22;
        OnClickListenerImpl3 onClickListenerImpl32;
        CursorEditText.OnInputFinishListener onInputFinishListener3;
        CursorEditText.OnInputFinishListener onInputFinishListener4;
        OnClickListenerImpl7 onClickListenerImpl72;
        OnClickListenerImpl1 onClickListenerImpl12;
        OnClickListenerImpl6 onClickListenerImpl63;
        OnClickListenerImpl4 onClickListenerImpl43;
        OnClickListenerImpl onClickListenerImpl10;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener3;
        String str5;
        String str6;
        long j2;
        int i26;
        int i27;
        int i28;
        String str7;
        int i29;
        int i30;
        int i31;
        int i32;
        String str8;
        int i33;
        String str9;
        int i34;
        int i35;
        ObservableString observableString2;
        boolean z5;
        long j3;
        ObservableString observableString3;
        ObservableBoolean observableBoolean;
        long j4;
        long j5;
        long j6;
        long j7;
        ObservableBoolean observableBoolean2;
        ObservableInt observableInt;
        int i36;
        int i37;
        int i38;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        ObservableInt observableInt2;
        int i39;
        int i40;
        int i41;
        int i42;
        String str10;
        ObservableInt observableInt3;
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener4;
        int i43;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingControlModel settingControlModel = this.mSettingControlModel;
        OnClickListenerImpl1 onClickListenerImpl13 = null;
        if ((255 & j) != 0) {
            long j14 = j & 192;
            if (j14 == 0 || settingControlModel == null) {
                onClickListenerImpl52 = null;
                onClickListenerImpl62 = null;
                onClickListenerImpl42 = null;
                onClickListenerImpl9 = null;
                onClickListenerImpl22 = null;
                onClickListenerImpl32 = null;
                onInputFinishListener3 = null;
                onInputFinishListener4 = null;
                onClickListenerImpl72 = null;
                onClickListenerImpl12 = null;
            } else {
                OnClickListenerImpl onClickListenerImpl11 = this.mSettingControlModelBtnAngel45ClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl11 == null) {
                    onClickListenerImpl11 = new OnClickListenerImpl();
                    this.mSettingControlModelBtnAngel45ClickAndroidViewViewOnClickListener = onClickListenerImpl11;
                }
                onClickListenerImpl9 = onClickListenerImpl11.setValue(settingControlModel);
                OnClickListenerImpl1 onClickListenerImpl14 = this.mSettingControlModelBtnAngel90ClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl14 == null) {
                    onClickListenerImpl14 = new OnClickListenerImpl1();
                    this.mSettingControlModelBtnAngel90ClickAndroidViewViewOnClickListener = onClickListenerImpl14;
                }
                onClickListenerImpl12 = onClickListenerImpl14.setValue(settingControlModel);
                OnClickListenerImpl2 onClickListenerImpl23 = this.mSettingControlModelBtnModeGuideVideoAndroidViewViewOnClickListener;
                if (onClickListenerImpl23 == null) {
                    onClickListenerImpl23 = new OnClickListenerImpl2();
                    this.mSettingControlModelBtnModeGuideVideoAndroidViewViewOnClickListener = onClickListenerImpl23;
                }
                onClickListenerImpl22 = onClickListenerImpl23.setValue(settingControlModel);
                OnClickListenerImpl3 onClickListenerImpl33 = this.mSettingControlModelBtnResetPitchSpeedAndroidViewViewOnClickListener;
                if (onClickListenerImpl33 == null) {
                    onClickListenerImpl33 = new OnClickListenerImpl3();
                    this.mSettingControlModelBtnResetPitchSpeedAndroidViewViewOnClickListener = onClickListenerImpl33;
                }
                onClickListenerImpl32 = onClickListenerImpl33.setValue(settingControlModel);
                onInputFinishListener3 = settingControlModel.fpvSmoothInputListener;
                onInputFinishListener4 = settingControlModel.pitchSpeedInputListener;
                OnClickListenerImpl4 onClickListenerImpl44 = this.mSettingControlModelBtnFpvModeClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl44 == null) {
                    onClickListenerImpl44 = new OnClickListenerImpl4();
                    this.mSettingControlModelBtnFpvModeClickAndroidViewViewOnClickListener = onClickListenerImpl44;
                }
                onClickListenerImpl42 = onClickListenerImpl44.setValue(settingControlModel);
                OnClickListenerImpl5 onClickListenerImpl53 = this.mSettingControlModelBtnAngel0ClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl53 == null) {
                    onClickListenerImpl53 = new OnClickListenerImpl5();
                    this.mSettingControlModelBtnAngel0ClickAndroidViewViewOnClickListener = onClickListenerImpl53;
                }
                onClickListenerImpl52 = onClickListenerImpl53.setValue(settingControlModel);
                OnClickListenerImpl6 onClickListenerImpl64 = this.mSettingControlModelBtnResetFpvSmoothAndroidViewViewOnClickListener;
                if (onClickListenerImpl64 == null) {
                    onClickListenerImpl64 = new OnClickListenerImpl6();
                    this.mSettingControlModelBtnResetFpvSmoothAndroidViewViewOnClickListener = onClickListenerImpl64;
                }
                onClickListenerImpl62 = onClickListenerImpl64.setValue(settingControlModel);
                OnClickListenerImpl7 onClickListenerImpl73 = this.mSettingControlModelBtnStableModeClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl73 == null) {
                    onClickListenerImpl73 = new OnClickListenerImpl7();
                    this.mSettingControlModelBtnStableModeClickAndroidViewViewOnClickListener = onClickListenerImpl73;
                }
                onClickListenerImpl72 = onClickListenerImpl73.setValue(settingControlModel);
            }
            OnClickListenerImpl5 onClickListenerImpl54 = onClickListenerImpl52;
            if ((j & 193) != 0) {
                if (settingControlModel != null) {
                    observableInt3 = settingControlModel.pitchSpeed;
                    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener5 = settingControlModel.pitchSpeedSeekBarChangeListener;
                    Objects.requireNonNull(settingControlModel);
                    Objects.requireNonNull(settingControlModel);
                    i26 = 100;
                    Objects.requireNonNull(settingControlModel);
                    onSeekBarChangeListener4 = onSeekBarChangeListener5;
                    i28 = 10;
                    i43 = 0;
                    i27 = 1;
                } else {
                    observableInt3 = null;
                    onSeekBarChangeListener4 = null;
                    i43 = 0;
                    i26 = 0;
                    i27 = 0;
                    i28 = 0;
                }
                updateRegistration(i43, observableInt3);
                int i44 = observableInt3 != null ? observableInt3.get() : 0;
                str6 = String.valueOf(i44);
                i9 = i44;
                if (j14 != 0) {
                    onClickListenerImpl63 = onClickListenerImpl62;
                    onClickListenerImpl43 = onClickListenerImpl42;
                    onClickListenerImpl10 = onClickListenerImpl9;
                    str5 = this.tvMaxPitch.getResources().getString(R.string.txt_flight_maximum_pitch_speed, Integer.valueOf(i27), Integer.valueOf(i26));
                } else {
                    onClickListenerImpl63 = onClickListenerImpl62;
                    onClickListenerImpl43 = onClickListenerImpl42;
                    onClickListenerImpl10 = onClickListenerImpl9;
                    str5 = null;
                }
                onSeekBarChangeListener3 = onSeekBarChangeListener4;
                j2 = 194;
            } else {
                onClickListenerImpl63 = onClickListenerImpl62;
                onClickListenerImpl43 = onClickListenerImpl42;
                onClickListenerImpl10 = onClickListenerImpl9;
                onSeekBarChangeListener3 = null;
                str5 = null;
                str6 = null;
                j2 = 194;
                i26 = 0;
                i27 = 0;
                i28 = 0;
                i9 = 0;
            }
            if ((j & j2) != 0) {
                if (settingControlModel != null) {
                    Objects.requireNonNull(settingControlModel);
                    Objects.requireNonNull(settingControlModel);
                    Objects.requireNonNull(settingControlModel);
                    onSeekBarChangeListener2 = onSeekBarChangeListener3;
                    observableInt2 = settingControlModel.fpvSmooth;
                    i32 = 10;
                    i40 = 1;
                    onSeekBarChangeListener = settingControlModel.fpvSmoothSeekBarChangeListener;
                    i39 = 5;
                } else {
                    onSeekBarChangeListener2 = onSeekBarChangeListener3;
                    observableInt2 = null;
                    onSeekBarChangeListener = null;
                    i39 = 0;
                    i40 = 1;
                    i32 = 0;
                }
                updateRegistration(i40, observableInt2);
                if (j14 != 0) {
                    str7 = str5;
                    i41 = i39;
                    i42 = 0;
                    i29 = 1;
                    str10 = this.tvRollSmooth.getResources().getString(R.string.txt_flight_roll_smoothness, 0, Integer.valueOf(i32));
                } else {
                    str7 = str5;
                    i41 = i39;
                    i29 = i40;
                    i42 = 0;
                    str10 = null;
                }
                int i45 = observableInt2 != null ? observableInt2.get() : i42;
                str = String.valueOf(i45);
                str8 = str10;
                i31 = i45;
                i30 = i41;
            } else {
                onSeekBarChangeListener2 = onSeekBarChangeListener3;
                str7 = str5;
                i29 = 1;
                i30 = 0;
                i31 = 0;
                i32 = 0;
                str8 = null;
                str = null;
                onSeekBarChangeListener = null;
            }
            long j15 = j & 196;
            if (j15 != 0) {
                if (settingControlModel != null) {
                    Objects.requireNonNull(settingControlModel);
                    ObservableInt observableInt4 = settingControlModel.pitchAngel;
                    Objects.requireNonNull(settingControlModel);
                    Objects.requireNonNull(settingControlModel);
                    i33 = i30;
                    i36 = -90;
                    str9 = str8;
                    i38 = 2;
                    int i46 = i31;
                    observableInt = observableInt4;
                    i37 = -45;
                    i11 = i46;
                } else {
                    i33 = i30;
                    i11 = i31;
                    str9 = str8;
                    observableInt = null;
                    i36 = 0;
                    i37 = 0;
                    i38 = 2;
                }
                updateRegistration(i38, observableInt);
                int i47 = observableInt != null ? observableInt.get() : 0;
                i35 = i47 == i37 ? i29 : 0;
                i2 = i47 == 0 ? i29 : 0;
                i34 = i47 == i36 ? i29 : 0;
                if (j15 != 0) {
                    if (i35 != 0) {
                        j12 = j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        j13 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    } else {
                        j12 = j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                        j13 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    }
                    j = j12 | j13;
                }
                if ((j & 196) != 0) {
                    if (i2 != 0) {
                        j10 = j | 2048;
                        j11 = 32768;
                    } else {
                        j10 = j | 1024;
                        j11 = 16384;
                    }
                    j = j10 | j11;
                }
                if ((j & 196) != 0) {
                    if (i34 != 0) {
                        j8 = j | 131072;
                        j9 = 134217728;
                    } else {
                        j8 = j | 65536;
                        j9 = 67108864;
                    }
                    j = j8 | j9;
                }
            } else {
                i33 = i30;
                i11 = i31;
                str9 = str8;
                i34 = 0;
                i35 = 0;
                i2 = 0;
            }
            if ((j & 200) != 0) {
                if (settingControlModel != null) {
                    observableString2 = settingControlModel.currentAngel;
                    i7 = i34;
                } else {
                    i7 = i34;
                    observableString2 = null;
                }
                updateRegistration(3, observableString2);
            } else {
                i7 = i34;
                observableString2 = null;
            }
            if ((j & 208) != 0) {
                if (settingControlModel != null) {
                    observableBoolean2 = settingControlModel.isConnectFlight;
                    i10 = i35;
                } else {
                    i10 = i35;
                    observableBoolean2 = null;
                }
                updateRegistration(4, observableBoolean2);
                if (observableBoolean2 != null) {
                    z5 = observableBoolean2.get();
                    j3 = j & 224;
                    boolean z6 = z5;
                    if (j3 == 0) {
                        if (settingControlModel != null) {
                            observableBoolean = settingControlModel.stableMode;
                            observableString3 = observableString2;
                        } else {
                            observableString3 = observableString2;
                            observableBoolean = null;
                        }
                        updateRegistration(5, observableBoolean);
                        z = observableBoolean != null ? observableBoolean.get() : false;
                        if (j3 != 0) {
                            if (z) {
                                j6 = j | 512;
                                j7 = 8192;
                            } else {
                                j6 = j | 256;
                                j7 = 4096;
                            }
                            j = j6 | j7;
                        }
                        z2 = !z;
                        if ((j & 224) != 0) {
                            if (z2) {
                                j4 = j | 8388608 | 33554432;
                                j5 = IjkMediaMeta.AV_CH_STEREO_LEFT;
                            } else {
                                j4 = j | 4194304 | 16777216;
                                j5 = 268435456;
                            }
                            j = j4 | j5;
                        }
                        onClickListenerImpl2 = onClickListenerImpl22;
                        onClickListenerImpl3 = onClickListenerImpl32;
                        onInputFinishListener = onInputFinishListener3;
                        onInputFinishListener2 = onInputFinishListener4;
                        onClickListenerImpl7 = onClickListenerImpl72;
                        str4 = str6;
                        onClickListenerImpl13 = onClickListenerImpl12;
                        onClickListenerImpl5 = onClickListenerImpl54;
                        i4 = i26;
                        i3 = i27;
                        i8 = i28;
                        observableString = observableString3;
                        onClickListenerImpl6 = onClickListenerImpl63;
                        onClickListenerImpl4 = onClickListenerImpl43;
                        onClickListenerImpl = onClickListenerImpl10;
                        i5 = i32;
                        str2 = str7;
                        str3 = str9;
                        z3 = z6;
                        i6 = z2 ? 0 : 8;
                        i = i33;
                    } else {
                        ObservableString observableString4 = observableString2;
                        onClickListenerImpl2 = onClickListenerImpl22;
                        onClickListenerImpl3 = onClickListenerImpl32;
                        onInputFinishListener = onInputFinishListener3;
                        onInputFinishListener2 = onInputFinishListener4;
                        onClickListenerImpl7 = onClickListenerImpl72;
                        str4 = str6;
                        onClickListenerImpl13 = onClickListenerImpl12;
                        onClickListenerImpl5 = onClickListenerImpl54;
                        i = i33;
                        i4 = i26;
                        i3 = i27;
                        i8 = i28;
                        observableString = observableString4;
                        onClickListenerImpl6 = onClickListenerImpl63;
                        onClickListenerImpl4 = onClickListenerImpl43;
                        onClickListenerImpl = onClickListenerImpl10;
                        i5 = i32;
                        str2 = str7;
                        str3 = str9;
                        z3 = z6;
                        z = false;
                        z2 = false;
                        i6 = 0;
                    }
                }
            } else {
                i10 = i35;
            }
            z5 = false;
            j3 = j & 224;
            boolean z62 = z5;
            if (j3 == 0) {
            }
        } else {
            str = null;
            onClickListenerImpl = null;
            onSeekBarChangeListener = null;
            onSeekBarChangeListener2 = null;
            str2 = null;
            onClickListenerImpl2 = null;
            str3 = null;
            onClickListenerImpl3 = null;
            str4 = null;
            observableString = null;
            onInputFinishListener = null;
            onInputFinishListener2 = null;
            onClickListenerImpl4 = null;
            onClickListenerImpl5 = null;
            onClickListenerImpl6 = null;
            onClickListenerImpl7 = null;
            z = false;
            z2 = false;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z3 = false;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
        }
        int i48 = ((j & 671646208) == 0 || settingControlModel == null) ? 0 : settingControlModel.COLOR_SELECT;
        if ((j & 10627072) == 0 || settingControlModel == null) {
            f = 0.0f;
        } else {
            Objects.requireNonNull(settingControlModel);
            f = 1.0f;
        }
        if ((j & 335823104) == 0 || settingControlModel == null) {
            i12 = 0;
        } else {
            Objects.requireNonNull(settingControlModel);
            i12 = -1;
        }
        if ((j & 5313536) == 0 || settingControlModel == null) {
            f2 = 0.0f;
        } else {
            Objects.requireNonNull(settingControlModel);
            f2 = 0.5f;
        }
        long j16 = j & 224;
        if (j16 != 0) {
            int i49 = z ? i48 : i12;
            float f9 = z ? f : f2;
            float f10 = z2 ? f : f2;
            i14 = z2 ? i48 : i12;
            f4 = f10;
            f3 = f9;
            i13 = i49;
        } else {
            f3 = 0.0f;
            f4 = 0.0f;
            i13 = 0;
            i14 = 0;
        }
        long j17 = j & 196;
        if (j17 != 0) {
            float f11 = i2 != 0 ? f : f2;
            int i50 = i2 != 0 ? i48 : i12;
            float f12 = i7 != 0 ? f : f2;
            int i51 = i10 != 0 ? i48 : i12;
            if (i10 != 0) {
                f2 = f;
            }
            if (i7 != 0) {
                i12 = i48;
            }
            f5 = f2;
            i15 = i50;
            f7 = f12;
            i16 = i51;
            f6 = f11;
            i17 = i12;
        } else {
            f5 = 0.0f;
            f6 = 0.0f;
            f7 = 0.0f;
            i15 = 0;
            i16 = 0;
            i17 = 0;
        }
        if ((j & 194) != 0) {
            TextViewBindingAdapter.setText(this.edtSmooth, str);
            onClickListenerImpl1 = onClickListenerImpl13;
            onClickListenerImpl8 = onClickListenerImpl;
            f8 = f3;
            i19 = i3;
            i18 = i13;
            i21 = i6;
            i22 = i8;
            i23 = 0;
            i20 = i4;
            i24 = i17;
            z4 = z3;
            ViewBindingAdapter.setSeekbarLimit(this.seekbarSmooth, i5, i, 0, i11, onSeekBarChangeListener);
        } else {
            i18 = i13;
            f8 = f3;
            onClickListenerImpl8 = onClickListenerImpl;
            i19 = i3;
            i20 = i4;
            z4 = z3;
            i21 = i6;
            onClickListenerImpl1 = onClickListenerImpl13;
            i22 = i8;
            i23 = 0;
            i24 = i17;
        }
        if ((192 & j) != 0) {
            ViewBindingAdapter.setEdittextLimit(this.edtSmooth, i5, i, i23, onInputFinishListener);
            i25 = i20;
            ViewBindingAdapter.setEdittextLimit(this.edtSpeed, i25, i22, i19, onInputFinishListener2);
            this.ibGimbalMode.setOnClickListener(onClickListenerImpl2);
            this.layoutPitchAngle45.setOnClickListener(onClickListenerImpl8);
            this.mboundView12.setOnClickListener(onClickListenerImpl7);
            this.mboundView13.setOnClickListener(onClickListenerImpl4);
            this.mboundView15.setOnClickListener(onClickListenerImpl6);
            this.mboundView7.setOnClickListener(onClickListenerImpl5);
            this.mboundView9.setOnClickListener(onClickListenerImpl1);
            this.tvDefault.setOnClickListener(onClickListenerImpl3);
            TextViewBindingAdapter.setText(this.tvMaxPitch, str2);
            TextViewBindingAdapter.setText(this.tvRollSmooth, str3);
        } else {
            i25 = i20;
        }
        if ((193 & j) != 0) {
            TextViewBindingAdapter.setText(this.edtSpeed, str4);
            ViewBindingAdapter.setSeekbarLimit(this.seekbarSpeed, i25, i22, i19, i9, onSeekBarChangeListener2);
        }
        if ((208 & j) != 0) {
            ViewBindingAdapter.setViewEnableWithAlpha(this.layoutPitchAngle, z4);
            ViewBindingAdapter.setViewEnableWithAlpha(this.llGimbalMode, z4);
        }
        if (j17 != 0) {
            ViewBindingAdapter.setBackgroundResource(this.layoutPitchAngle45, i16);
            ViewBindingAdapter.setBackgroundResource(this.mboundView7, i15);
            ViewBindingAdapter.setBackgroundResource(this.mboundView9, i24);
            if (getBuildSdkInt() >= 11) {
                this.layoutPitchAngle45.setAlpha(f5);
                this.mboundView7.setAlpha(f6);
                this.mboundView9.setAlpha(f7);
            }
        }
        if (j16 != 0) {
            int i52 = i21;
            this.layoutRollSmooth.setVisibility(i52);
            ViewBindingAdapter.setBackgroundResource(this.mboundView12, i18);
            ViewBindingAdapter.setBackgroundResource(this.mboundView13, i14);
            this.mboundView15.setVisibility(i52);
            this.spaceGimbal.setVisibility(i52);
            this.tvRollSmooth.setVisibility(i52);
            if (getBuildSdkInt() >= 11) {
                this.mboundView12.setAlpha(f8);
                this.mboundView13.setAlpha(f4);
            }
        }
        if ((j & 200) != 0) {
            ViewBindingAdapter.setText(this.tvCurrentAngleValue, observableString);
        }
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