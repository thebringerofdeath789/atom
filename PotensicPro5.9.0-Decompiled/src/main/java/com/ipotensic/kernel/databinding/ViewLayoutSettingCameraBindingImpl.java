package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingCameraModel;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public class ViewLayoutSettingCameraBindingImpl extends ViewLayoutSettingCameraBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl1 mSettingCameraModelBtnFormatSDClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl mSettingCameraModelBtnMwbClickAndroidViewViewOnClickListener;
    private final FrameLayout mboundView0;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_title, 8);
        sparseIntArray.put(R.id.layout_setting, 9);
        sparseIntArray.put(R.id.tv_general_setting, 10);
        sparseIntArray.put(R.id.view_general_settings, 11);
        sparseIntArray.put(R.id.tvWhiteBalanceTip, 12);
        sparseIntArray.put(R.id.line1, 13);
        sparseIntArray.put(R.id.tvAuxLine, 14);
        sparseIntArray.put(R.id.grid_layout, 15);
        sparseIntArray.put(R.id.line2, 16);
        sparseIntArray.put(R.id.tvSeg, 17);
        sparseIntArray.put(R.id.space_general, 18);
        sparseIntArray.put(R.id.seg_rec_layout, 19);
        sparseIntArray.put(R.id.tv_sd_card, 20);
        sparseIntArray.put(R.id.view_sd_card, 21);
        sparseIntArray.put(R.id.tvRemainTips, 22);
        sparseIntArray.put(R.id.line3, 23);
        sparseIntArray.put(R.id.tvSdCardOption, 24);
        sparseIntArray.put(R.id.tv_others, 25);
        sparseIntArray.put(R.id.view_others, 26);
        sparseIntArray.put(R.id.tvWaterMark, 27);
        sparseIntArray.put(R.id.line4, 28);
        sparseIntArray.put(R.id.tvPhotoLocationTips, 29);
    }

    public ViewLayoutSettingCameraBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingCameraBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (CursorEditText) objArr[2], (CommonSelectionView) objArr[15], (ScrollView) objArr[9], (View) objArr[13], (View) objArr[16], (View) objArr[23], (View) objArr[28], (SwitchButton) objArr[6], (CustomSeekbar) objArr[3], (CommonSelectionView) objArr[19], (View) objArr[18], (SwitchButton) objArr[7], (TextView) objArr[1], (TextView) objArr[14], (TextView) objArr[5], (TextView) objArr[10], (TextView) objArr[25], (TextView) objArr[29], (TextView) objArr[22], (TextView) objArr[20], (TextView) objArr[24], (TextView) objArr[17], (TextView) objArr[27], (TextView) objArr[12], (View) objArr[11], (View) objArr[26], (View) objArr[21], (CommonTitleView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.edtWhiteBalance.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.sbWater.setTag(null);
        this.sbWhiteBalance.setTag(null);
        this.switchBtnPhotoGpsLocation.setTag(null);
        this.tvAutoWhiteBalance.setTag(null);
        this.tvFormat.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
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
        if (BR.settingCameraModel != i) {
            return false;
        }
        setSettingCameraModel((SettingCameraModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingCameraBinding
    public void setSettingCameraModel(SettingCameraModel settingCameraModel) {
        this.mSettingCameraModel = settingCameraModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.settingCameraModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSettingCameraModelGpsLocationIsClickable((ObservableBoolean) obj, i2);
            case 1:
                return onChangeSettingCameraModelWbSeekbarProgress((ObservableInt) obj, i2);
            case 2:
                return onChangeSettingCameraModelPhotoGpsIsShow((ObservableBoolean) obj, i2);
            case 3:
                return onChangeSettingCameraModelRemainCapacity((ObservableString) obj, i2);
            case 4:
                return onChangeSettingCameraModelInputWB((ObservableInt) obj, i2);
            case 5:
                return onChangeSettingCameraModelWaterMarkIsShow((ObservableBoolean) obj, i2);
            case 6:
                return onChangeSettingCameraModelWaterMarkIsClickable((ObservableBoolean) obj, i2);
            case 7:
                return onChangeSettingCameraModelWbIsMwb((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSettingCameraModelGpsLocationIsClickable(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelWbSeekbarProgress(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelPhotoGpsIsShow(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelRemainCapacity(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelInputWB(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelWaterMarkIsShow(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelWaterMarkIsClickable(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeSettingCameraModelWbIsMwb(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0151  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutSettingCameraBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingCameraModel value;

        public OnClickListenerImpl setValue(SettingCameraModel settingCameraModel) {
            this.value = settingCameraModel;
            if (settingCameraModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnMwbClick(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private SettingCameraModel value;

        public OnClickListenerImpl1 setValue(SettingCameraModel settingCameraModel) {
            this.value = settingCameraModel;
            if (settingCameraModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnFormatSDClick(view);
        }
    }
}
