package com.ipotensic.kernel.databinding;

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
import com.ipotensic.kernel.C1964BR;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingAboutModel;
import com.ipotensic.kernel.view.CommonTitleView;

/* loaded from: classes2.dex */
public class ViewLayoutSettingAboutBindingImpl extends ViewLayoutSettingAboutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mSettingAboutModelGoRegisterUomAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mSettingAboutModelOnClickToUpgradeAndroidViewViewOnClickListener;

    /* renamed from: mSettingAboutModelShowDeviceModelInfoClickAndroidViewViewOnClickListener */
    private OnClickListenerImpl3 f2194x7090fb07;

    /* renamed from: mSettingAboutModelShowVersionInfoClickAndroidViewViewOnClickListener */
    private OnClickListenerImpl2 f2195xfafd6702;
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
        sparseIntArray.put(C1965R.id.view_title, 23);
        sparseIntArray.put(C1965R.id.cl_device_model, 24);
        sparseIntArray.put(C1965R.id.tv_device_model, 25);
        sparseIntArray.put(C1965R.id.tv_big_package_version, 26);
        sparseIntArray.put(C1965R.id.ll_drone_sn, 27);
        sparseIntArray.put(C1965R.id.layoutUomRegistration, 28);
        sparseIntArray.put(C1965R.id.cl_firmware_version, 29);
        sparseIntArray.put(C1965R.id.ll_flight_version, 30);
        sparseIntArray.put(C1965R.id.ll_remote_version, 31);
        sparseIntArray.put(C1965R.id.ll_camera_version, 32);
        sparseIntArray.put(C1965R.id.ll_fpv_version, 33);
        sparseIntArray.put(C1965R.id.ll_battery_version, 34);
        sparseIntArray.put(C1965R.id.rl_version, 35);
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
        if (C1964BR.settingAboutModel != i) {
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
        notifyPropertyChanged(C1964BR.settingAboutModel);
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
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelShowVersionInfo(ObservableBoolean observableBoolean, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelShowDeviceModelInfo(ObservableBoolean observableBoolean, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelFlightVersion(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelEscVersion(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelShowUpgradeView(ObservableBoolean observableBoolean, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelRemoteSN(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelFpvVersion(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelProductStr(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelRemoteVersion(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelFlightSN(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelBatteryVersion(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelCameraVersion(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeSettingAboutModelAppVersion(ObservableString observableString, int i) {
        if (i != C1964BR._all) {
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1100
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutSettingAboutBindingImpl.executeBindings():void");
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