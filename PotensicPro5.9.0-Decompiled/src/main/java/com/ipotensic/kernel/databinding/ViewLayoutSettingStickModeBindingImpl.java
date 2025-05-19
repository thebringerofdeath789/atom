package com.ipotensic.kernel.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ViewBindingAdapter;
import com.ipotensic.kernel.model.SettingStickModeModel;

/* loaded from: classes2.dex */
public class ViewLayoutSettingStickModeBindingImpl extends ViewLayoutSettingStickModeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl1 mSettingStickModeBtnLeftClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl mSettingStickModeBtnRightClickAndroidViewViewOnClickListener;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.base_line_left, 10);
        sparseIntArray.put(R.id.base_line_right, 11);
        sparseIntArray.put(R.id.layout_top, 12);
        sparseIntArray.put(R.id.ib_back, 13);
        sparseIntArray.put(R.id.tv_title, 14);
        sparseIntArray.put(R.id.tv_code_title, 15);
        sparseIntArray.put(R.id.btn_exit, 16);
        sparseIntArray.put(R.id.tv_left, 17);
        sparseIntArray.put(R.id.tv_right, 18);
        sparseIntArray.put(R.id.tv_left_stick, 19);
        sparseIntArray.put(R.id.tv_left_side, 20);
        sparseIntArray.put(R.id.tv_right_side, 21);
        sparseIntArray.put(R.id.tv_remote_right_stick, 22);
    }

    public ViewLayoutSettingStickModeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingStickModeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (Guideline) objArr[10], (Guideline) objArr[11], (ImageButton) objArr[16], (ImageButton) objArr[13], (ImageView) objArr[3], (ImageView) objArr[7], (RelativeLayout) objArr[12], (ShadowLayout) objArr[1], (TextView) objArr[9], (TextView) objArr[15], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[17], (TextView) objArr[20], (TextView) objArr[19], (TextView) objArr[2], (TextView) objArr[6], (TextView) objArr[22], (TextView) objArr[18], (TextView) objArr[21], (TextView) objArr[14], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.ivLeft.setTag(null);
        this.ivRight.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.shadowLayout.setTag(null);
        this.tvBackward.setTag(null);
        this.tvDown.setTag(null);
        this.tvForward.setTag(null);
        this.tvMode1.setTag(null);
        this.tvMode2.setTag(null);
        this.tvUp.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        if (BR.settingStickMode != i) {
            return false;
        }
        setSettingStickMode((SettingStickModeModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingStickModeBinding
    public void setSettingStickMode(SettingStickModeModel settingStickModeModel) {
        this.mSettingStickMode = settingStickModeModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.settingStickMode);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeSettingStickModeModel1((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeSettingStickModeIsShowTips((ObservableBoolean) obj, i2);
    }

    private boolean onChangeSettingStickModeModel1(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingStickModeIsShowTips(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        OnClickListenerImpl onClickListenerImpl;
        OnClickListenerImpl1 onClickListenerImpl1;
        int i;
        boolean z;
        int i2;
        int i3;
        int i4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingStickModeModel settingStickModeModel = this.mSettingStickMode;
        if ((15 & j) != 0) {
            long j2 = j & 13;
            if (j2 != 0) {
                ObservableBoolean observableBoolean = settingStickModeModel != null ? settingStickModeModel.model1 : null;
                updateRegistration(0, observableBoolean);
                z = observableBoolean != null ? observableBoolean.get() : false;
                if (j2 != 0) {
                    j = z ? j | 32 | 128 | 512 | 2048 | 8192 | 131072 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : j | 16 | 64 | 256 | 1024 | 4096 | 65536 | PlaybackStateCompat.ACTION_SET_REPEAT_MODE | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                }
                str = this.tvBackward.getResources().getString(z ? R.string.remote_backward : R.string.remote_down);
                str2 = z ? this.tvUp.getResources().getString(R.string.remote_up) : this.tvUp.getResources().getString(R.string.remote_forward);
                str3 = this.tvDown.getResources().getString(z ? R.string.remote_down : R.string.remote_backward);
                str4 = this.tvForward.getResources().getString(z ? R.string.remote_forward : R.string.remote_up);
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                z = false;
            }
            if ((j & 12) == 0 || settingStickModeModel == null) {
                onClickListenerImpl = null;
                onClickListenerImpl1 = null;
            } else {
                OnClickListenerImpl onClickListenerImpl2 = this.mSettingStickModeBtnRightClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl2 == null) {
                    onClickListenerImpl2 = new OnClickListenerImpl();
                    this.mSettingStickModeBtnRightClickAndroidViewViewOnClickListener = onClickListenerImpl2;
                }
                onClickListenerImpl = onClickListenerImpl2.setValue(settingStickModeModel);
                OnClickListenerImpl1 onClickListenerImpl12 = this.mSettingStickModeBtnLeftClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl12 == null) {
                    onClickListenerImpl12 = new OnClickListenerImpl1();
                    this.mSettingStickModeBtnLeftClickAndroidViewViewOnClickListener = onClickListenerImpl12;
                }
                onClickListenerImpl1 = onClickListenerImpl12.setValue(settingStickModeModel);
            }
            long j3 = j & 14;
            if (j3 != 0) {
                ObservableBoolean observableBoolean2 = settingStickModeModel != null ? settingStickModeModel.isShowTips : null;
                updateRegistration(1, observableBoolean2);
                boolean z2 = observableBoolean2 != null ? observableBoolean2.get() : false;
                if (j3 != 0) {
                    j |= z2 ? 32768L : 16384L;
                }
                if (!z2) {
                    i = 8;
                }
            }
            i = 0;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            onClickListenerImpl = null;
            onClickListenerImpl1 = null;
            i = 0;
            z = false;
        }
        int i5 = (j & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0 ? R.drawable.bg_setting_button_select_right : 0;
        int i6 = (j & 512) != 0 ? R.mipmap.icon_virtual_rocker_model1_left : 0;
        int i7 = (j & 131072) != 0 ? R.mipmap.icon_virtual_rocker_model1_right : 0;
        int i8 = (256 & j) != 0 ? R.mipmap.icon_virtual_rocker_model2_left : 0;
        int i9 = (j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0 ? R.drawable.bg_setting_button_select_left : 0;
        int i10 = (j & 65536) != 0 ? R.mipmap.icon_virtual_rocker_model2_right : 0;
        int i11 = (j & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0 ? R.drawable.bg_setting_model_default_left : 0;
        int i12 = (j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0 ? R.drawable.bg_setting_model_default_right : 0;
        long j4 = j & 13;
        if (j4 != 0) {
            if (z) {
                i8 = i6;
            }
            if (!z) {
                i7 = i10;
            }
            if (!z) {
                i12 = i5;
            }
            if (!z) {
                i9 = i11;
            }
            i3 = i9;
            i2 = i7;
            i4 = i12;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i8 = 0;
        }
        if ((j & 12) != 0) {
            this.ivLeft.setOnClickListener(onClickListenerImpl1);
            this.ivRight.setOnClickListener(onClickListenerImpl);
            this.tvMode1.setOnClickListener(onClickListenerImpl1);
            this.tvMode2.setOnClickListener(onClickListenerImpl);
        }
        if (j4 != 0) {
            ViewBindingAdapter.setImageViewResource(this.ivLeft, i8);
            ViewBindingAdapter.setImageViewResource(this.ivRight, i2);
            TextViewBindingAdapter.setText(this.tvBackward, str);
            TextViewBindingAdapter.setText(this.tvDown, str3);
            TextViewBindingAdapter.setText(this.tvForward, str4);
            ViewBindingAdapter.setBackgroundResource(this.tvMode1, i3);
            ViewBindingAdapter.setBackgroundResource(this.tvMode2, i4);
            TextViewBindingAdapter.setText(this.tvUp, str2);
        }
        if ((j & 14) != 0) {
            this.shadowLayout.setVisibility(i);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingStickModeModel value;

        public OnClickListenerImpl setValue(SettingStickModeModel settingStickModeModel) {
            this.value = settingStickModeModel;
            if (settingStickModeModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnRightClick(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private SettingStickModeModel value;

        public OnClickListenerImpl1 setValue(SettingStickModeModel settingStickModeModel) {
            this.value = settingStickModeModel;
            if (settingStickModeModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnLeftClick(view);
        }
    }
}
