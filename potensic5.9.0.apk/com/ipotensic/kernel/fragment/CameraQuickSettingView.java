package com.ipotensic.kernel.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ViewCameraQuickSettingBinding;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraQuickSettingView.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\"\u001a\u00020\u0014J\b\u0010#\u001a\u00020\u0014H\u0002J\u0006\u0010$\u001a\u00020\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m2338d2 = {"Lcom/ipotensic/kernel/fragment/CameraQuickSettingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastFragment", "Landroidx/fragment/app/Fragment;", "leftFragment", "Lcom/ipotensic/kernel/fragment/CameraSettingLeftFragment;", "mBind", "Lcom/ipotensic/kernel/databinding/ViewCameraQuickSettingBinding;", "manager", "Landroidx/fragment/app/FragmentManager;", "rightFragment", "Lcom/ipotensic/kernel/fragment/CameraSettingRightFragment;", "check", "", "leftCheck", "", "getFragment", "isLeft", "setScaleViewValue", "value", "setVisibility", "visibility", "setWhiteBalanceValueFrequency", "whiteBalanceValue", "showFragment", "fragment", "switchFragment", "switchMode", "updateLeftFragmentData", "updateSdcardInfo", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CameraQuickSettingView extends ConstraintLayout {
    private HashMap _$_findViewCache;
    private Fragment lastFragment;
    private CameraSettingLeftFragment leftFragment;
    private ViewCameraQuickSettingBinding mBind;
    private FragmentManager manager;
    private CameraSettingRightFragment rightFragment;

    public CameraQuickSettingView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CameraQuickSettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ CameraQuickSettingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraQuickSettingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        ViewCameraQuickSettingBinding inflate = ViewCameraQuickSettingBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ViewCameraQuickSettingBi…rom(context), this, true)");
        this.mBind = inflate;
        if (context instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "context.supportFragmentManager");
            this.manager = supportFragmentManager;
        }
        this.mBind.rgCamera.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.ipotensic.kernel.fragment.CameraQuickSettingView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                if (i2 == C1965R.id.rb_left) {
                    CameraQuickSettingView.this.switchFragment(true);
                } else {
                    CameraQuickSettingView.this.switchFragment(false);
                }
            }
        });
    }

    public final void showFragment(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        if (!Intrinsics.areEqual(this.lastFragment, fragment)) {
            FragmentManager fragmentManager = this.manager;
            if (fragmentManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
            }
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "manager.beginTransaction()");
            Fragment fragment2 = this.lastFragment;
            if (fragment2 != null) {
                beginTransaction.hide(fragment2);
            }
            this.lastFragment = fragment;
            if (fragment.isAdded()) {
                beginTransaction.show(fragment).commitAllowingStateLoss();
            } else {
                beginTransaction.add(C1965R.id.fl_camera, fragment).commitAllowingStateLoss();
            }
        }
    }

    private final Fragment getFragment(boolean isLeft) {
        if (isLeft) {
            if (this.leftFragment == null) {
                this.leftFragment = new CameraSettingLeftFragment();
            }
            CameraSettingLeftFragment cameraSettingLeftFragment = this.leftFragment;
            if (cameraSettingLeftFragment == null) {
                Intrinsics.throwNpe();
            }
            return cameraSettingLeftFragment;
        }
        if (this.rightFragment == null) {
            this.rightFragment = new CameraSettingRightFragment();
        }
        CameraSettingRightFragment cameraSettingRightFragment = this.rightFragment;
        if (cameraSettingRightFragment == null) {
            Intrinsics.throwNpe();
        }
        return cameraSettingRightFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchFragment(boolean leftCheck) {
        if (leftCheck) {
            RadioButton radioButton = this.mBind.rbLeft;
            Intrinsics.checkExpressionValueIsNotNull(radioButton, "mBind.rbLeft");
            radioButton.setAlpha(1.0f);
            RadioButton radioButton2 = this.mBind.rbRight;
            Intrinsics.checkExpressionValueIsNotNull(radioButton2, "mBind.rbRight");
            radioButton2.setAlpha(0.5f);
            showFragment(getFragment(true));
            updateLeftFragmentData();
            return;
        }
        RadioButton radioButton3 = this.mBind.rbLeft;
        Intrinsics.checkExpressionValueIsNotNull(radioButton3, "mBind.rbLeft");
        radioButton3.setAlpha(0.5f);
        RadioButton radioButton4 = this.mBind.rbRight;
        Intrinsics.checkExpressionValueIsNotNull(radioButton4, "mBind.rbRight");
        radioButton4.setAlpha(1.0f);
        showFragment(getFragment(false));
        CameraSettingRightFragment cameraSettingRightFragment = this.rightFragment;
        if (cameraSettingRightFragment != null) {
            cameraSettingRightFragment.refreshData();
        }
    }

    private final void updateLeftFragmentData() {
        CameraSettingLeftFragment cameraSettingLeftFragment = this.leftFragment;
        if (cameraSettingLeftFragment != null) {
            cameraSettingLeftFragment.switchCameraMode();
            cameraSettingLeftFragment.setPhotoFormat();
            cameraSettingLeftFragment.updateSdcardInfo();
            cameraSettingLeftFragment.updateSdCheckState();
        }
    }

    public final void check(boolean leftCheck) {
        if (leftCheck) {
            RadioGroup radioGroup = this.mBind.rgCamera;
            Intrinsics.checkExpressionValueIsNotNull(radioGroup, "mBind.rgCamera");
            if (radioGroup.getCheckedRadioButtonId() == C1965R.id.rb_left) {
                updateLeftFragmentData();
                return;
            } else {
                this.mBind.rgCamera.check(C1965R.id.rb_left);
                return;
            }
        }
        RadioGroup radioGroup2 = this.mBind.rgCamera;
        Intrinsics.checkExpressionValueIsNotNull(radioGroup2, "mBind.rgCamera");
        if (radioGroup2.getCheckedRadioButtonId() == C1965R.id.rb_right) {
            CameraSettingRightFragment cameraSettingRightFragment = this.rightFragment;
            if (cameraSettingRightFragment != null) {
                cameraSettingRightFragment.refreshData();
                return;
            }
            return;
        }
        this.mBind.rgCamera.check(C1965R.id.rb_right);
    }

    public final void updateSdcardInfo() {
        CameraSettingLeftFragment cameraSettingLeftFragment = this.leftFragment;
        if (cameraSettingLeftFragment != null) {
            cameraSettingLeftFragment.updateSdcardInfo();
        }
    }

    public final void switchMode() {
        CameraSettingLeftFragment cameraSettingLeftFragment = this.leftFragment;
        if (cameraSettingLeftFragment != null) {
            cameraSettingLeftFragment.switchCameraMode();
        }
        CameraSettingRightFragment cameraSettingRightFragment = this.rightFragment;
        if (cameraSettingRightFragment != null) {
            cameraSettingRightFragment.refreshData();
        }
    }

    public final void setWhiteBalanceValueFrequency(int whiteBalanceValue) {
        CameraSettingRightFragment cameraSettingRightFragment = this.rightFragment;
        if (cameraSettingRightFragment != null) {
            cameraSettingRightFragment.setWhiteBalanceValueFrequency(whiteBalanceValue);
        }
    }

    public final void setScaleViewValue(int value) {
        CameraSettingRightFragment cameraSettingRightFragment = this.rightFragment;
        if (cameraSettingRightFragment != null) {
            cameraSettingRightFragment.setScaleViewValue(value);
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        CameraSettingRightFragment cameraSettingRightFragment = this.rightFragment;
        if (cameraSettingRightFragment != null) {
            cameraSettingRightFragment.setHide(visibility == 8);
        }
        CameraSettingLeftFragment cameraSettingLeftFragment = this.leftFragment;
        if (cameraSettingLeftFragment != null) {
            cameraSettingLeftFragment.setHide(visibility == 8);
        }
    }
}