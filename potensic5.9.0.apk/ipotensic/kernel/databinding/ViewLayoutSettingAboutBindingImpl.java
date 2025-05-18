package com.ipotensic.kernel.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.ipotensic.kernel.model.SettingAboutModel;
import com.ipotensic.kernel.view.CommonTitleView;
import com.logan.flight.FlightConfig;
import okhttp3.internal.ws.WebSocketProtocol;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class ViewLayoutSettingAboutBindingImpl extends ViewLayoutSettingAboutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mSettingAboutModelGoRegisterUomAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mSettingAboutModelOnClickToUpgradeAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mSettingAboutModelShowDeviceModelInfoClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mSettingAboutModelShowVersionInfoClickAndroidViewViewOnClickListener;
    private final ConstraintLayout mboundView0;
    private final ImageButton mboundView10;
    private final ConstraintLayout mboundView11;
    private final TextView mboundView12;
    private final TextView mboundView14;
    private final TextView mboundView15;
    private final TextView mboundView16;
    private final TextView mboundView17;
    private final TextView mboundView18;
    private final TextView mboundView20;
    private final TextView mboundView21;
    private final TextView mboundView22;
    private final ImageButton mboundView3;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final Button mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_title, 23);
        sparseIntArray.put(R.id.cl_device_model, 24);
        sparseIntArray.put(R.id.tv_device_model, 25);
        sparseIntArray.put(R.id.tv_big_package_version, 26);
        sparseIntArray.put(R.id.ll_drone_sn, 27);
        sparseIntArray.put(R.id.layoutUomRegistration, 28);
        sparseIntArray.put(R.id.cl_firmware_version, 29);
        sparseIntArray.put(R.id.ll_flight_version, 30);
        sparseIntArray.put(R.id.ll_remote_version, 31);
        sparseIntArray.put(R.id.ll_camera_version, 32);
        sparseIntArray.put(R.id.ll_fpv_version, 33);
        sparseIntArray.put(R.id.ll_battery_version, 34);
        sparseIntArray.put(R.id.rl_version, 35);
    }

    public ViewLayoutSettingAboutBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 36, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingAboutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 14, (ConstraintLayout) objArr[24], (ConstraintLayout) objArr[29], (LinearLayout) objArr[28], (LinearLayout) objArr[4], (LinearLayout) objArr[34], (LinearLayout) objArr[32], (LinearLayout) objArr[27], (LinearLayout) objArr[19], (LinearLayout) objArr[30], (LinearLayout) objArr[33], (LinearLayout) objArr[13], (LinearLayout) objArr[31], (RelativeLayout) objArr[1], (RelativeLayout) objArr[9], (RelativeLayout) objArr[35], (TextView) objArr[26], (TextView) objArr[25], (TextView) objArr[2], (CommonTitleView) objArr[23]);
        this.mDirtyFlags = -1L;
        this.layoutVersion.setTag(null);
        this.llEscVersion.setTag(null);
        this.llGimbalVersion.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ImageButton imageButton = (ImageButton) objArr[10];
        this.mboundView10 = imageButton;
        imageButton.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[11];
        this.mboundView11 = constraintLayout2;
        constraintLayout2.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.mboundView12 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[14];
        this.mboundView14 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.mboundView15 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[16];
        this.mboundView16 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[17];
        this.mboundView17 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[18];
        this.mboundView18 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[20];
        this.mboundView20 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[21];
        this.mboundView21 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[22];
        this.mboundView22 = textView9;
        textView9.setTag(null);
        ImageButton imageButton2 = (ImageButton) objArr[3];
        this.mboundView3 = imageButton2;
        imageButton2.setTag(null);
        TextView textView10 = (TextView) objArr[5];
        this.mboundView5 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[6];
        this.mboundView6 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[7];
        this.mboundView7 = textView12;
        textView12.setTag(null);
        Button button = (Button) objArr[8];
        this.mboundView8 = button;
        button.setTag(null);
        this.rlDeviceModel.setTag(null);
        this.rlFirmwareVersion.setTag(null);
        this.tvProduct.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32768L;
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
        if (BR.settingAboutModel != i) {
            return false;
        }
        setSettingAboutModel((SettingAboutModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingAboutBinding
    public void setSettingAboutModel(SettingAboutModel settingAboutModel) {
        this.mSettingAboutModel = settingAboutModel;
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        notifyPropertyChanged(BR.settingAboutModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSettingAboutModelGimbalVersion((ObservableString) obj, i2);
            case 1:
                return onChangeSettingAboutModelShowVersionInfo((ObservableBoolean) obj, i2);
            case 2:
                return onChangeSettingAboutModelShowDeviceModelInfo((ObservableBoolean) obj, i2);
            case 3:
                return onChangeSettingAboutModelFlightVersion((ObservableString) obj, i2);
            case 4:
                return onChangeSettingAboutModelEscVersion((ObservableString) obj, i2);
            case 5:
                return onChangeSettingAboutModelShowUpgradeView((ObservableBoolean) obj, i2);
            case 6:
                return onChangeSettingAboutModelRemoteSN((ObservableString) obj, i2);
            case 7:
                return onChangeSettingAboutModelFpvVersion((ObservableString) obj, i2);
            case 8:
                return onChangeSettingAboutModelProductStr((ObservableString) obj, i2);
            case 9:
                return onChangeSettingAboutModelRemoteVersion((ObservableString) obj, i2);
            case 10:
                return onChangeSettingAboutModelFlightSN((ObservableString) obj, i2);
            case 11:
                return onChangeSettingAboutModelBatteryVersion((ObservableString) obj, i2);
            case 12:
                return onChangeSettingAboutModelCameraVersion((ObservableString) obj, i2);
            case 13:
                return onChangeSettingAboutModelAppVersion((ObservableString) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSettingAboutModelGimbalVersion(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelShowVersionInfo(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelShowDeviceModelInfo(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelFlightVersion(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelEscVersion(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelShowUpgradeView(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelRemoteSN(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelFpvVersion(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelProductStr(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelRemoteVersion(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelFlightSN(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelBatteryVersion(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelCameraVersion(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelAppVersion(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0180  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        OnClickListenerImpl onClickListenerImpl;
        String str5;
        OnClickListenerImpl1 onClickListenerImpl1;
        OnClickListenerImpl2 onClickListenerImpl2;
        OnClickListenerImpl3 onClickListenerImpl3;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        long j2;
        long j3;
        String str12;
        String str13;
        long j4;
        String str14;
        int i5;
        String str15;
        int i6;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        ObservableString observableString;
        ObservableString observableString2;
        ObservableString observableString3;
        ObservableString observableString4;
        ObservableString observableString5;
        ObservableString observableString6;
        ObservableBoolean observableBoolean;
        long j5;
        long j6;
        long j7;
        long j8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingAboutModel settingAboutModel = this.mSettingAboutModel;
        long j9 = j & 32768;
        if (j9 != 0) {
            if (j9 != 0) {
                j |= FlightConfig.isAtomLT() ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            if ((j & 32768) != 0) {
                j |= (FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
        }
        String str27 = null;
        if ((WebSocketProtocol.PAYLOAD_SHORT_MAX & j) != 0) {
            if ((j & 49153) != 0) {
                ObservableString observableString7 = settingAboutModel != null ? settingAboutModel.gimbalVersion : null;
                updateRegistration(0, observableString7);
                if (observableString7 != null) {
                    str5 = observableString7.get();
                    if ((j & 49152) != 0 || settingAboutModel == null) {
                        onClickListenerImpl = null;
                        onClickListenerImpl1 = null;
                        onClickListenerImpl2 = null;
                        onClickListenerImpl3 = null;
                    } else {
                        OnClickListenerImpl onClickListenerImpl4 = this.mSettingAboutModelGoRegisterUomAndroidViewViewOnClickListener;
                        if (onClickListenerImpl4 == null) {
                            onClickListenerImpl4 = new OnClickListenerImpl();
                            this.mSettingAboutModelGoRegisterUomAndroidViewViewOnClickListener = onClickListenerImpl4;
                        }
                        onClickListenerImpl = onClickListenerImpl4.setValue(settingAboutModel);
                        OnClickListenerImpl1 onClickListenerImpl12 = this.mSettingAboutModelOnClickToUpgradeAndroidViewViewOnClickListener;
                        if (onClickListenerImpl12 == null) {
                            onClickListenerImpl12 = new OnClickListenerImpl1();
                            this.mSettingAboutModelOnClickToUpgradeAndroidViewViewOnClickListener = onClickListenerImpl12;
                        }
                        onClickListenerImpl1 = onClickListenerImpl12.setValue(settingAboutModel);
                        OnClickListenerImpl2 onClickListenerImpl22 = this.mSettingAboutModelShowVersionInfoClickAndroidViewViewOnClickListener;
                        if (onClickListenerImpl22 == null) {
                            onClickListenerImpl22 = new OnClickListenerImpl2();
                            this.mSettingAboutModelShowVersionInfoClickAndroidViewViewOnClickListener = onClickListenerImpl22;
                        }
                        onClickListenerImpl2 = onClickListenerImpl22.setValue(settingAboutModel);
                        OnClickListenerImpl3 onClickListenerImpl32 = this.mSettingAboutModelShowDeviceModelInfoClickAndroidViewViewOnClickListener;
                        if (onClickListenerImpl32 == null) {
                            onClickListenerImpl32 = new OnClickListenerImpl3();
                            this.mSettingAboutModelShowDeviceModelInfoClickAndroidViewViewOnClickListener = onClickListenerImpl32;
                        }
                        onClickListenerImpl3 = onClickListenerImpl32.setValue(settingAboutModel);
                    }
                    j2 = j & 49154;
                    if (j2 == 0) {
                        ObservableBoolean observableBoolean2 = settingAboutModel != null ? settingAboutModel.showVersionInfo : null;
                        updateRegistration(1, observableBoolean2);
                        z = observableBoolean2 != null ? observableBoolean2.get() : false;
                        if (j2 != 0) {
                            if (z) {
                                j7 = j | 33554432;
                                j8 = IjkMediaMeta.AV_CH_STEREO_LEFT;
                            } else {
                                j7 = j | 16777216;
                                j8 = 268435456;
                            }
                            j = j7 | j8;
                        }
                        if (!z) {
                            i = 8;
                            j3 = j & 49156;
                            if (j3 != 0) {
                                ObservableBoolean observableBoolean3 = settingAboutModel != null ? settingAboutModel.showDeviceModelInfo : null;
                                updateRegistration(2, observableBoolean3);
                                z2 = observableBoolean3 != null ? observableBoolean3.get() : false;
                                if (j3 != 0) {
                                    if (z2) {
                                        j5 = j | 131072;
                                        j6 = 134217728;
                                    } else {
                                        j5 = j | 65536;
                                        j6 = 67108864;
                                    }
                                    j = j5 | j6;
                                }
                                if (!z2) {
                                    i2 = 8;
                                    if ((j & 49160) != 0) {
                                        ObservableString observableString8 = settingAboutModel != null ? settingAboutModel.flightVersion : null;
                                        updateRegistration(3, observableString8);
                                        if (observableString8 != null) {
                                            str12 = observableString8.get();
                                            if ((j & 49168) != 0) {
                                                ObservableString observableString9 = settingAboutModel != null ? settingAboutModel.escVersion : null;
                                                updateRegistration(4, observableString9);
                                                if (observableString9 != null) {
                                                    str13 = observableString9.get();
                                                    j4 = j & 49184;
                                                    String str28 = str12;
                                                    if (j4 == 0) {
                                                        if (settingAboutModel != null) {
                                                            observableBoolean = settingAboutModel.showUpgradeView;
                                                            str14 = str13;
                                                        } else {
                                                            str14 = str13;
                                                            observableBoolean = null;
                                                        }
                                                        updateRegistration(5, observableBoolean);
                                                        boolean z3 = observableBoolean != null ? observableBoolean.get() : false;
                                                        if (j4 != 0) {
                                                            j |= z3 ? 8388608L : 4194304L;
                                                        }
                                                        if (!z3) {
                                                            i5 = 8;
                                                            if ((j & 49216) != 0) {
                                                                ObservableString observableString10 = settingAboutModel != null ? settingAboutModel.remoteSN : null;
                                                                updateRegistration(6, observableString10);
                                                                if (observableString10 != null) {
                                                                    str15 = observableString10.get();
                                                                    if ((j & 49280) == 0) {
                                                                        if (settingAboutModel != null) {
                                                                            observableString6 = settingAboutModel.fpvVersion;
                                                                            i6 = i5;
                                                                        } else {
                                                                            i6 = i5;
                                                                            observableString6 = null;
                                                                        }
                                                                        updateRegistration(7, observableString6);
                                                                        if (observableString6 != null) {
                                                                            str16 = observableString6.get();
                                                                            if ((j & 49408) != 0) {
                                                                                if (settingAboutModel != null) {
                                                                                    observableString5 = settingAboutModel.productStr;
                                                                                    str17 = str16;
                                                                                } else {
                                                                                    str17 = str16;
                                                                                    observableString5 = null;
                                                                                }
                                                                                updateRegistration(8, observableString5);
                                                                                if (observableString5 != null) {
                                                                                    str18 = observableString5.get();
                                                                                    if ((j & 49664) == 0) {
                                                                                        if (settingAboutModel != null) {
                                                                                            observableString4 = settingAboutModel.remoteVersion;
                                                                                            str19 = str15;
                                                                                        } else {
                                                                                            str19 = str15;
                                                                                            observableString4 = null;
                                                                                        }
                                                                                        updateRegistration(9, observableString4);
                                                                                        if (observableString4 != null) {
                                                                                            str20 = observableString4.get();
                                                                                            if ((j & 50176) != 0) {
                                                                                                if (settingAboutModel != null) {
                                                                                                    observableString3 = settingAboutModel.flightSN;
                                                                                                    str21 = str20;
                                                                                                } else {
                                                                                                    str21 = str20;
                                                                                                    observableString3 = null;
                                                                                                }
                                                                                                updateRegistration(10, observableString3);
                                                                                                if (observableString3 != null) {
                                                                                                    str22 = observableString3.get();
                                                                                                    if ((j & 51200) == 0) {
                                                                                                        if (settingAboutModel != null) {
                                                                                                            observableString2 = settingAboutModel.batteryVersion;
                                                                                                            str23 = str22;
                                                                                                        } else {
                                                                                                            str23 = str22;
                                                                                                            observableString2 = null;
                                                                                                        }
                                                                                                        updateRegistration(11, observableString2);
                                                                                                        if (observableString2 != null) {
                                                                                                            str24 = observableString2.get();
                                                                                                            if ((j & 53248) != 0) {
                                                                                                                if (settingAboutModel != null) {
                                                                                                                    observableString = settingAboutModel.cameraVersion;
                                                                                                                    str25 = str24;
                                                                                                                } else {
                                                                                                                    str25 = str24;
                                                                                                                    observableString = null;
                                                                                                                }
                                                                                                                updateRegistration(12, observableString);
                                                                                                                if (observableString != null) {
                                                                                                                    str26 = observableString.get();
                                                                                                                    if ((j & 57344) != 0) {
                                                                                                                        ObservableString observableString11 = settingAboutModel != null ? settingAboutModel.appVersion : null;
                                                                                                                        updateRegistration(13, observableString11);
                                                                                                                        if (observableString11 != null) {
                                                                                                                            str27 = observableString11.get();
                                                                                                                        }
                                                                                                                    }
                                                                                                                    str11 = str18;
                                                                                                                    str8 = str27;
                                                                                                                    str3 = str28;
                                                                                                                    str7 = str14;
                                                                                                                    str10 = str19;
                                                                                                                    str = str21;
                                                                                                                    str9 = str23;
                                                                                                                    str6 = str25;
                                                                                                                    str4 = str26;
                                                                                                                    str2 = str17;
                                                                                                                    i3 = i6;
                                                                                                                }
                                                                                                            } else {
                                                                                                                str25 = str24;
                                                                                                            }
                                                                                                            str26 = null;
                                                                                                            if ((j & 57344) != 0) {
                                                                                                            }
                                                                                                            str11 = str18;
                                                                                                            str8 = str27;
                                                                                                            str3 = str28;
                                                                                                            str7 = str14;
                                                                                                            str10 = str19;
                                                                                                            str = str21;
                                                                                                            str9 = str23;
                                                                                                            str6 = str25;
                                                                                                            str4 = str26;
                                                                                                            str2 = str17;
                                                                                                            i3 = i6;
                                                                                                        }
                                                                                                    } else {
                                                                                                        str23 = str22;
                                                                                                    }
                                                                                                    str24 = null;
                                                                                                    if ((j & 53248) != 0) {
                                                                                                    }
                                                                                                    str26 = null;
                                                                                                    if ((j & 57344) != 0) {
                                                                                                    }
                                                                                                    str11 = str18;
                                                                                                    str8 = str27;
                                                                                                    str3 = str28;
                                                                                                    str7 = str14;
                                                                                                    str10 = str19;
                                                                                                    str = str21;
                                                                                                    str9 = str23;
                                                                                                    str6 = str25;
                                                                                                    str4 = str26;
                                                                                                    str2 = str17;
                                                                                                    i3 = i6;
                                                                                                }
                                                                                            } else {
                                                                                                str21 = str20;
                                                                                            }
                                                                                            str22 = null;
                                                                                            if ((j & 51200) == 0) {
                                                                                            }
                                                                                            str24 = null;
                                                                                            if ((j & 53248) != 0) {
                                                                                            }
                                                                                            str26 = null;
                                                                                            if ((j & 57344) != 0) {
                                                                                            }
                                                                                            str11 = str18;
                                                                                            str8 = str27;
                                                                                            str3 = str28;
                                                                                            str7 = str14;
                                                                                            str10 = str19;
                                                                                            str = str21;
                                                                                            str9 = str23;
                                                                                            str6 = str25;
                                                                                            str4 = str26;
                                                                                            str2 = str17;
                                                                                            i3 = i6;
                                                                                        }
                                                                                    } else {
                                                                                        str19 = str15;
                                                                                    }
                                                                                    str20 = null;
                                                                                    if ((j & 50176) != 0) {
                                                                                    }
                                                                                    str22 = null;
                                                                                    if ((j & 51200) == 0) {
                                                                                    }
                                                                                    str24 = null;
                                                                                    if ((j & 53248) != 0) {
                                                                                    }
                                                                                    str26 = null;
                                                                                    if ((j & 57344) != 0) {
                                                                                    }
                                                                                    str11 = str18;
                                                                                    str8 = str27;
                                                                                    str3 = str28;
                                                                                    str7 = str14;
                                                                                    str10 = str19;
                                                                                    str = str21;
                                                                                    str9 = str23;
                                                                                    str6 = str25;
                                                                                    str4 = str26;
                                                                                    str2 = str17;
                                                                                    i3 = i6;
                                                                                }
                                                                            } else {
                                                                                str17 = str16;
                                                                            }
                                                                            str18 = null;
                                                                            if ((j & 49664) == 0) {
                                                                            }
                                                                            str20 = null;
                                                                            if ((j & 50176) != 0) {
                                                                            }
                                                                            str22 = null;
                                                                            if ((j & 51200) == 0) {
                                                                            }
                                                                            str24 = null;
                                                                            if ((j & 53248) != 0) {
                                                                            }
                                                                            str26 = null;
                                                                            if ((j & 57344) != 0) {
                                                                            }
                                                                            str11 = str18;
                                                                            str8 = str27;
                                                                            str3 = str28;
                                                                            str7 = str14;
                                                                            str10 = str19;
                                                                            str = str21;
                                                                            str9 = str23;
                                                                            str6 = str25;
                                                                            str4 = str26;
                                                                            str2 = str17;
                                                                            i3 = i6;
                                                                        }
                                                                    } else {
                                                                        i6 = i5;
                                                                    }
                                                                    str16 = null;
                                                                    if ((j & 49408) != 0) {
                                                                    }
                                                                    str18 = null;
                                                                    if ((j & 49664) == 0) {
                                                                    }
                                                                    str20 = null;
                                                                    if ((j & 50176) != 0) {
                                                                    }
                                                                    str22 = null;
                                                                    if ((j & 51200) == 0) {
                                                                    }
                                                                    str24 = null;
                                                                    if ((j & 53248) != 0) {
                                                                    }
                                                                    str26 = null;
                                                                    if ((j & 57344) != 0) {
                                                                    }
                                                                    str11 = str18;
                                                                    str8 = str27;
                                                                    str3 = str28;
                                                                    str7 = str14;
                                                                    str10 = str19;
                                                                    str = str21;
                                                                    str9 = str23;
                                                                    str6 = str25;
                                                                    str4 = str26;
                                                                    str2 = str17;
                                                                    i3 = i6;
                                                                }
                                                            }
                                                            str15 = null;
                                                            if ((j & 49280) == 0) {
                                                            }
                                                            str16 = null;
                                                            if ((j & 49408) != 0) {
                                                            }
                                                            str18 = null;
                                                            if ((j & 49664) == 0) {
                                                            }
                                                            str20 = null;
                                                            if ((j & 50176) != 0) {
                                                            }
                                                            str22 = null;
                                                            if ((j & 51200) == 0) {
                                                            }
                                                            str24 = null;
                                                            if ((j & 53248) != 0) {
                                                            }
                                                            str26 = null;
                                                            if ((j & 57344) != 0) {
                                                            }
                                                            str11 = str18;
                                                            str8 = str27;
                                                            str3 = str28;
                                                            str7 = str14;
                                                            str10 = str19;
                                                            str = str21;
                                                            str9 = str23;
                                                            str6 = str25;
                                                            str4 = str26;
                                                            str2 = str17;
                                                            i3 = i6;
                                                        }
                                                    } else {
                                                        str14 = str13;
                                                    }
                                                    i5 = 0;
                                                    if ((j & 49216) != 0) {
                                                    }
                                                    str15 = null;
                                                    if ((j & 49280) == 0) {
                                                    }
                                                    str16 = null;
                                                    if ((j & 49408) != 0) {
                                                    }
                                                    str18 = null;
                                                    if ((j & 49664) == 0) {
                                                    }
                                                    str20 = null;
                                                    if ((j & 50176) != 0) {
                                                    }
                                                    str22 = null;
                                                    if ((j & 51200) == 0) {
                                                    }
                                                    str24 = null;
                                                    if ((j & 53248) != 0) {
                                                    }
                                                    str26 = null;
                                                    if ((j & 57344) != 0) {
                                                    }
                                                    str11 = str18;
                                                    str8 = str27;
                                                    str3 = str28;
                                                    str7 = str14;
                                                    str10 = str19;
                                                    str = str21;
                                                    str9 = str23;
                                                    str6 = str25;
                                                    str4 = str26;
                                                    str2 = str17;
                                                    i3 = i6;
                                                }
                                            }
                                            str13 = null;
                                            j4 = j & 49184;
                                            String str282 = str12;
                                            if (j4 == 0) {
                                            }
                                            i5 = 0;
                                            if ((j & 49216) != 0) {
                                            }
                                            str15 = null;
                                            if ((j & 49280) == 0) {
                                            }
                                            str16 = null;
                                            if ((j & 49408) != 0) {
                                            }
                                            str18 = null;
                                            if ((j & 49664) == 0) {
                                            }
                                            str20 = null;
                                            if ((j & 50176) != 0) {
                                            }
                                            str22 = null;
                                            if ((j & 51200) == 0) {
                                            }
                                            str24 = null;
                                            if ((j & 53248) != 0) {
                                            }
                                            str26 = null;
                                            if ((j & 57344) != 0) {
                                            }
                                            str11 = str18;
                                            str8 = str27;
                                            str3 = str282;
                                            str7 = str14;
                                            str10 = str19;
                                            str = str21;
                                            str9 = str23;
                                            str6 = str25;
                                            str4 = str26;
                                            str2 = str17;
                                            i3 = i6;
                                        }
                                    }
                                    str12 = null;
                                    if ((j & 49168) != 0) {
                                    }
                                    str13 = null;
                                    j4 = j & 49184;
                                    String str2822 = str12;
                                    if (j4 == 0) {
                                    }
                                    i5 = 0;
                                    if ((j & 49216) != 0) {
                                    }
                                    str15 = null;
                                    if ((j & 49280) == 0) {
                                    }
                                    str16 = null;
                                    if ((j & 49408) != 0) {
                                    }
                                    str18 = null;
                                    if ((j & 49664) == 0) {
                                    }
                                    str20 = null;
                                    if ((j & 50176) != 0) {
                                    }
                                    str22 = null;
                                    if ((j & 51200) == 0) {
                                    }
                                    str24 = null;
                                    if ((j & 53248) != 0) {
                                    }
                                    str26 = null;
                                    if ((j & 57344) != 0) {
                                    }
                                    str11 = str18;
                                    str8 = str27;
                                    str3 = str2822;
                                    str7 = str14;
                                    str10 = str19;
                                    str = str21;
                                    str9 = str23;
                                    str6 = str25;
                                    str4 = str26;
                                    str2 = str17;
                                    i3 = i6;
                                }
                            } else {
                                z2 = false;
                            }
                            i2 = 0;
                            if ((j & 49160) != 0) {
                            }
                            str12 = null;
                            if ((j & 49168) != 0) {
                            }
                            str13 = null;
                            j4 = j & 49184;
                            String str28222 = str12;
                            if (j4 == 0) {
                            }
                            i5 = 0;
                            if ((j & 49216) != 0) {
                            }
                            str15 = null;
                            if ((j & 49280) == 0) {
                            }
                            str16 = null;
                            if ((j & 49408) != 0) {
                            }
                            str18 = null;
                            if ((j & 49664) == 0) {
                            }
                            str20 = null;
                            if ((j & 50176) != 0) {
                            }
                            str22 = null;
                            if ((j & 51200) == 0) {
                            }
                            str24 = null;
                            if ((j & 53248) != 0) {
                            }
                            str26 = null;
                            if ((j & 57344) != 0) {
                            }
                            str11 = str18;
                            str8 = str27;
                            str3 = str28222;
                            str7 = str14;
                            str10 = str19;
                            str = str21;
                            str9 = str23;
                            str6 = str25;
                            str4 = str26;
                            str2 = str17;
                            i3 = i6;
                        }
                    } else {
                        z = false;
                    }
                    i = 0;
                    j3 = j & 49156;
                    if (j3 != 0) {
                    }
                    i2 = 0;
                    if ((j & 49160) != 0) {
                    }
                    str12 = null;
                    if ((j & 49168) != 0) {
                    }
                    str13 = null;
                    j4 = j & 49184;
                    String str282222 = str12;
                    if (j4 == 0) {
                    }
                    i5 = 0;
                    if ((j & 49216) != 0) {
                    }
                    str15 = null;
                    if ((j & 49280) == 0) {
                    }
                    str16 = null;
                    if ((j & 49408) != 0) {
                    }
                    str18 = null;
                    if ((j & 49664) == 0) {
                    }
                    str20 = null;
                    if ((j & 50176) != 0) {
                    }
                    str22 = null;
                    if ((j & 51200) == 0) {
                    }
                    str24 = null;
                    if ((j & 53248) != 0) {
                    }
                    str26 = null;
                    if ((j & 57344) != 0) {
                    }
                    str11 = str18;
                    str8 = str27;
                    str3 = str282222;
                    str7 = str14;
                    str10 = str19;
                    str = str21;
                    str9 = str23;
                    str6 = str25;
                    str4 = str26;
                    str2 = str17;
                    i3 = i6;
                }
            }
            str5 = null;
            if ((j & 49152) != 0) {
            }
            onClickListenerImpl = null;
            onClickListenerImpl1 = null;
            onClickListenerImpl2 = null;
            onClickListenerImpl3 = null;
            j2 = j & 49154;
            if (j2 == 0) {
            }
            i = 0;
            j3 = j & 49156;
            if (j3 != 0) {
            }
            i2 = 0;
            if ((j & 49160) != 0) {
            }
            str12 = null;
            if ((j & 49168) != 0) {
            }
            str13 = null;
            j4 = j & 49184;
            String str2822222 = str12;
            if (j4 == 0) {
            }
            i5 = 0;
            if ((j & 49216) != 0) {
            }
            str15 = null;
            if ((j & 49280) == 0) {
            }
            str16 = null;
            if ((j & 49408) != 0) {
            }
            str18 = null;
            if ((j & 49664) == 0) {
            }
            str20 = null;
            if ((j & 50176) != 0) {
            }
            str22 = null;
            if ((j & 51200) == 0) {
            }
            str24 = null;
            if ((j & 53248) != 0) {
            }
            str26 = null;
            if ((j & 57344) != 0) {
            }
            str11 = str18;
            str8 = str27;
            str3 = str2822222;
            str7 = str14;
            str10 = str19;
            str = str21;
            str9 = str23;
            str6 = str25;
            str4 = str26;
            str2 = str17;
            i3 = i6;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            onClickListenerImpl = null;
            str5 = null;
            onClickListenerImpl1 = null;
            onClickListenerImpl2 = null;
            onClickListenerImpl3 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            z = false;
            i = 0;
            z2 = false;
            i2 = 0;
            i3 = 0;
        }
        int i7 = (j & 33685504) != 0 ? R.mipmap.img_btn_function_close : 0;
        int i8 = (j & 16842752) != 0 ? R.mipmap.img_btn_function_open : 0;
        long j10 = j & 49156;
        int i9 = j10 != 0 ? z2 ? i7 : i8 : 0;
        long j11 = j & 49154;
        if (j11 != 0) {
            if (!z) {
                i7 = i8;
            }
            i4 = i7;
        } else {
            i4 = 0;
        }
        String str29 = str2;
        if (j10 != 0) {
            this.layoutVersion.setVisibility(i2);
            ViewBindingAdapter.setImageViewResource(this.mboundView3, i9);
        }
        if ((32768 & j) != 0) {
            this.llEscVersion.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
            this.llGimbalVersion.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        }
        if ((j & 49152) != 0) {
            this.mboundView10.setOnClickListener(onClickListenerImpl2);
            this.mboundView21.setOnClickListener(onClickListenerImpl1);
            this.mboundView3.setOnClickListener(onClickListenerImpl3);
            this.mboundView8.setOnClickListener(onClickListenerImpl);
            this.rlDeviceModel.setOnClickListener(onClickListenerImpl3);
            this.rlFirmwareVersion.setOnClickListener(onClickListenerImpl2);
        }
        if (j11 != 0) {
            ViewBindingAdapter.setImageViewResource(this.mboundView10, i4);
            this.mboundView11.setVisibility(i);
        }
        if ((j & 49160) != 0) {
            TextViewBindingAdapter.setText(this.mboundView12, str3);
        }
        if ((j & 49153) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str5);
        }
        if ((j & 49664) != 0) {
            TextViewBindingAdapter.setText(this.mboundView15, str);
        }
        if ((53248 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView16, str4);
        }
        if ((j & 49280) != 0) {
            TextViewBindingAdapter.setText(this.mboundView17, str29);
        }
        if ((51200 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView18, str6);
        }
        if ((j & 49168) != 0) {
            TextViewBindingAdapter.setText(this.mboundView20, str7);
        }
        if ((j & 49184) != 0) {
            this.mboundView21.setVisibility(i3);
        }
        if ((57344 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView22, str8);
        }
        if ((50176 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str9);
        }
        if ((j & 49216) != 0) {
            String str30 = str10;
            TextViewBindingAdapter.setText(this.mboundView6, str30);
            TextViewBindingAdapter.setText(this.mboundView7, str30);
        }
        if ((j & 49408) != 0) {
            TextViewBindingAdapter.setText(this.tvProduct, str11);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingAboutModel value;

        public OnClickListenerImpl setValue(SettingAboutModel settingAboutModel) {
            this.value = settingAboutModel;
            if (settingAboutModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.goRegisterUom(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private SettingAboutModel value;

        public OnClickListenerImpl1 setValue(SettingAboutModel settingAboutModel) {
            this.value = settingAboutModel;
            if (settingAboutModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.onClickToUpgrade(view);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private SettingAboutModel value;

        public OnClickListenerImpl2 setValue(SettingAboutModel settingAboutModel) {
            this.value = settingAboutModel;
            if (settingAboutModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.showVersionInfoClick(view);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private SettingAboutModel value;

        public OnClickListenerImpl3 setValue(SettingAboutModel settingAboutModel) {
            this.value = settingAboutModel;
            if (settingAboutModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.showDeviceModelInfoClick(view);
        }
    }
}