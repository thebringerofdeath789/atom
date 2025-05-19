package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingAboutModel;
import com.ipotensic.kernel.view.CommonTitleView;

/* loaded from: classes2.dex */
public class ViewLayoutSettingAboutBindingImpl extends ViewLayoutSettingAboutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mSettingAboutModelOnClickToUpgradeAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mSettingAboutModelShowDeviceModelInfoClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mSettingAboutModelShowVersionInfoClickAndroidViewViewOnClickListener;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView10;
    private final TextView mboundView12;
    private final TextView mboundView13;
    private final TextView mboundView14;
    private final TextView mboundView15;
    private final TextView mboundView16;
    private final TextView mboundView18;
    private final TextView mboundView19;
    private final TextView mboundView20;
    private final ImageButton mboundView3;
    private final LinearLayout mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final ImageButton mboundView8;
    private final ConstraintLayout mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_title, 21);
        sparseIntArray.put(R.id.cl_device_model, 22);
        sparseIntArray.put(R.id.tv_device_model, 23);
        sparseIntArray.put(R.id.tv_big_package_version, 24);
        sparseIntArray.put(R.id.ll_drone_sn, 25);
        sparseIntArray.put(R.id.cl_firmware_version, 26);
        sparseIntArray.put(R.id.ll_flight_version, 27);
        sparseIntArray.put(R.id.ll_remote_version, 28);
        sparseIntArray.put(R.id.ll_camera_version, 29);
        sparseIntArray.put(R.id.ll_fpv_version, 30);
        sparseIntArray.put(R.id.ll_battery_version, 31);
        sparseIntArray.put(R.id.rl_version, 32);
    }

    public ViewLayoutSettingAboutBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 33, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingAboutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 14, (ConstraintLayout) objArr[22], (ConstraintLayout) objArr[26], (LinearLayout) objArr[31], (LinearLayout) objArr[29], (LinearLayout) objArr[25], (LinearLayout) objArr[17], (LinearLayout) objArr[27], (LinearLayout) objArr[30], (LinearLayout) objArr[11], (LinearLayout) objArr[28], (RelativeLayout) objArr[1], (RelativeLayout) objArr[7], (RelativeLayout) objArr[32], (TextView) objArr[24], (TextView) objArr[23], (TextView) objArr[2], (CommonTitleView) objArr[21]);
        this.mDirtyFlags = -1L;
        this.llEscVersion.setTag(null);
        this.llGimbalVersion.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.mboundView12 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[13];
        this.mboundView13 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[14];
        this.mboundView14 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[15];
        this.mboundView15 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[16];
        this.mboundView16 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[18];
        this.mboundView18 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[19];
        this.mboundView19 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[20];
        this.mboundView20 = textView9;
        textView9.setTag(null);
        ImageButton imageButton = (ImageButton) objArr[3];
        this.mboundView3 = imageButton;
        imageButton.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[4];
        this.mboundView4 = linearLayout;
        linearLayout.setTag(null);
        TextView textView10 = (TextView) objArr[5];
        this.mboundView5 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[6];
        this.mboundView6 = textView11;
        textView11.setTag(null);
        ImageButton imageButton2 = (ImageButton) objArr[8];
        this.mboundView8 = imageButton2;
        imageButton2.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[9];
        this.mboundView9 = constraintLayout2;
        constraintLayout2.setTag(null);
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

    /* JADX WARN: Removed duplicated region for block: B:104:0x0190 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0174  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1074
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
            this.value.onClickToUpgrade(view);
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
            this.value.showVersionInfoClick(view);
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
            this.value.showDeviceModelInfoClick(view);
        }
    }
}
