package com.ipotensic.kernel.fragment;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.core.Builder;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnGuideChangedListener;
import com.ipotensic.baselib.guide.listener.OnPageChangedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutSettingMain1Binding;
import com.ipotensic.kernel.fragment.calibration.SettingCalibrationFragment;
import com.ipotensic.kernel.guide.SettingRelativeGuide;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.logan.flight.FlightConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingMainView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\bH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\bH\u0002J\u0006\u0010)\u001a\u00020!J\u0006\u0010*\u001a\u00020!J\u001a\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\bH\u0016J\u000e\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u0019J\b\u00103\u001a\u00020!H\u0002J\u0006\u00104\u001a\u00020!J\u0010\u00105\u001a\u00020!2\u0006\u0010#\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ipotensic/kernel/fragment/SettingMainView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aboutFragment", "Lcom/ipotensic/kernel/fragment/SettingAboutFragment;", "binding", "Lcom/ipotensic/kernel/databinding/ViewLayoutSettingMain1Binding;", "calibrationFragment", "Lcom/ipotensic/kernel/fragment/calibration/SettingCalibrationFragment;", "cameraFragment", "Lcom/ipotensic/kernel/fragment/SettingCameraFragment;", "controlFragment", "Lcom/ipotensic/kernel/fragment/SettingControlFragment;", "guideController", "Lcom/ipotensic/baselib/guide/core/Controller;", "imageTransFragment", "Lcom/ipotensic/kernel/fragment/SettingImageTransFragment;", "lastFragment", "Landroidx/fragment/app/Fragment;", "manager", "Landroidx/fragment/app/FragmentManager;", "securityFragment", "Lcom/ipotensic/kernel/fragment/SettingSecurityFragment;", "stickModeFragment", "Lcom/ipotensic/kernel/fragment/SettingStickModeFragment;", "checkFirst", "", "getFragmentByPosition", "position", "getGuidePage", "Lcom/ipotensic/baselib/guide/model/GuidePage;", "view", "Landroid/view/View;", "resId", "hideGuideView", "hideStickMode", "onCheckedChanged", "group", "Landroid/widget/RadioGroup;", "checkedId", "setVisibility", "visibility", "showFragment", "fragment", "showGuideView", "showStickMode", "switchFragment", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SettingMainView extends ConstraintLayout implements RadioGroup.OnCheckedChangeListener {
    private HashMap _$_findViewCache;
    private SettingAboutFragment aboutFragment;
    private ViewLayoutSettingMain1Binding binding;
    private SettingCalibrationFragment calibrationFragment;
    private SettingCameraFragment cameraFragment;
    private SettingControlFragment controlFragment;
    private Controller guideController;
    private SettingImageTransFragment imageTransFragment;
    private Fragment lastFragment;
    private FragmentManager manager;
    private SettingSecurityFragment securityFragment;
    private SettingStickModeFragment stickModeFragment;

    public SettingMainView(Context context) {
        this(context, null, 0, 6, null);
    }

    public SettingMainView(Context context, AttributeSet attributeSet) {
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

    public /* synthetic */ SettingMainView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingMainView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_layout_setting_main1, this, true);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(… this,\n        true\n    )");
        this.binding = (ViewLayoutSettingMain1Binding) inflate;
        if (context instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "context.supportFragmentManager");
            this.manager = supportFragmentManager;
            this.binding.rgSetting.setOnCheckedChangeListener(this);
            RadioButton radioButton = this.binding.tvSecurity;
            Intrinsics.checkExpressionValueIsNotNull(radioButton, "binding.tvSecurity");
            radioButton.setChecked(true);
        }
    }

    public final void checkFirst() {
        RadioButton radioButton = this.binding.tvSecurity;
        Intrinsics.checkExpressionValueIsNotNull(radioButton, "binding.tvSecurity");
        radioButton.setChecked(true);
    }

    private final void switchFragment(int position) {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
        }
        fragmentManager.beginTransaction().replace(R.id.fl_content, getFragmentByPosition(position)).commitAllowingStateLoss();
    }

    public final void showStickMode() {
        showFragment(getFragmentByPosition(6));
    }

    public final void hideStickMode() {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
        }
        fragmentManager.beginTransaction().remove(getFragmentByPosition(6)).commitAllowingStateLoss();
        this.stickModeFragment = (SettingStickModeFragment) null;
        showFragment(getFragmentByPosition(2));
    }

    private final Fragment getFragmentByPosition(int position) {
        switch (position) {
            case 0:
                if (this.securityFragment == null) {
                    this.securityFragment = new SettingSecurityFragment();
                }
                SettingSecurityFragment settingSecurityFragment = this.securityFragment;
                if (settingSecurityFragment == null) {
                    Intrinsics.throwNpe();
                }
                return settingSecurityFragment;
            case 1:
                if (this.calibrationFragment == null) {
                    this.calibrationFragment = new SettingCalibrationFragment();
                }
                SettingCalibrationFragment settingCalibrationFragment = this.calibrationFragment;
                if (settingCalibrationFragment == null) {
                    Intrinsics.throwNpe();
                }
                return settingCalibrationFragment;
            case 2:
                if (this.controlFragment == null) {
                    this.controlFragment = new SettingControlFragment();
                }
                SettingControlFragment settingControlFragment = this.controlFragment;
                if (settingControlFragment == null) {
                    Intrinsics.throwNpe();
                }
                return settingControlFragment;
            case 3:
                if (this.cameraFragment == null) {
                    this.cameraFragment = new SettingCameraFragment();
                }
                SettingCameraFragment settingCameraFragment = this.cameraFragment;
                if (settingCameraFragment == null) {
                    Intrinsics.throwNpe();
                }
                return settingCameraFragment;
            case 4:
                if (this.imageTransFragment == null) {
                    this.imageTransFragment = new SettingImageTransFragment();
                }
                SettingImageTransFragment settingImageTransFragment = this.imageTransFragment;
                if (settingImageTransFragment == null) {
                    Intrinsics.throwNpe();
                }
                return settingImageTransFragment;
            case 5:
                if (this.aboutFragment == null) {
                    this.aboutFragment = new SettingAboutFragment();
                }
                SettingAboutFragment settingAboutFragment = this.aboutFragment;
                if (settingAboutFragment == null) {
                    Intrinsics.throwNpe();
                }
                return settingAboutFragment;
            case 6:
                if (this.stickModeFragment == null) {
                    this.stickModeFragment = new SettingStickModeFragment();
                }
                SettingStickModeFragment settingStickModeFragment = this.stickModeFragment;
                if (settingStickModeFragment == null) {
                    Intrinsics.throwNpe();
                }
                return settingStickModeFragment;
            default:
                if (this.securityFragment == null) {
                    this.securityFragment = new SettingSecurityFragment();
                }
                SettingSecurityFragment settingSecurityFragment2 = this.securityFragment;
                if (settingSecurityFragment2 == null) {
                    Intrinsics.throwNpe();
                }
                return settingSecurityFragment2;
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.tv_security) {
            showFragment(getFragmentByPosition(0));
            return;
        }
        if (checkedId == R.id.tv_calibration) {
            showFragment(getFragmentByPosition(1));
            return;
        }
        if (checkedId == R.id.tv_control) {
            showFragment(getFragmentByPosition(2));
            return;
        }
        if (checkedId == R.id.tv_camera) {
            showFragment(getFragmentByPosition(3));
        } else if (checkedId == R.id.tv_image_trans) {
            showFragment(getFragmentByPosition(4));
        } else if (checkedId == R.id.tv_about) {
            showFragment(getFragmentByPosition(5));
        }
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
                beginTransaction.add(R.id.fl_content, fragment).commitAllowingStateLoss();
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == 0) {
            SettingCameraFragment settingCameraFragment = this.cameraFragment;
            if (settingCameraFragment != null) {
                settingCameraFragment.refreshData();
            }
            SettingSecurityFragment settingSecurityFragment = this.securityFragment;
            if (settingSecurityFragment != null) {
                settingSecurityFragment.refreshData();
            }
            if (SPHelper.getInstance().getBoolean(SPHelper.KEY_FIRST_ENTER_ATOM_SETTINGS, true)) {
                showGuideView();
                return;
            }
            return;
        }
        SettingSecurityFragment settingSecurityFragment2 = this.securityFragment;
        if (settingSecurityFragment2 != null) {
            settingSecurityFragment2.updateHeight();
        }
        SettingControlFragment settingControlFragment = this.controlFragment;
        if (settingControlFragment != null) {
            settingControlFragment.updateSpeed();
        }
    }

    public final void hideGuideView() {
        boolean z = SPHelper.getInstance().getBoolean(SPHelper.KEY_FIRST_ENTER_ATOM_SETTINGS, true);
        Controller controller = this.guideController;
        if (controller != null) {
            controller.remove();
        }
        if (z) {
            SPHelper.getInstance().putBoolean(SPHelper.KEY_FIRST_ENTER_ATOM_SETTINGS, true);
        }
    }

    private final void showGuideView() {
        Context context = getContext();
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
        Builder with = NewbieGuide.with((Activity) context);
        RadioButton radioButton = this.binding.tvSecurity;
        Intrinsics.checkExpressionValueIsNotNull(radioButton, "binding.tvSecurity");
        Builder addGuidePage = with.addGuidePage(getGuidePage(radioButton, R.string.guide_settings_safety_tips));
        RadioButton radioButton2 = this.binding.tvCalibration;
        Intrinsics.checkExpressionValueIsNotNull(radioButton2, "binding.tvCalibration");
        Builder addGuidePage2 = addGuidePage.addGuidePage(getGuidePage(radioButton2, R.string.guide_settings_calibration_tips));
        RadioButton radioButton3 = this.binding.tvControl;
        Intrinsics.checkExpressionValueIsNotNull(radioButton3, "binding.tvControl");
        Builder addGuidePage3 = addGuidePage2.addGuidePage(getGuidePage(radioButton3, FlightConfig.isAtomLT() ? R.string.atom_lt_guide_settings_control_tips : R.string.guide_settings_control_tips));
        RadioButton radioButton4 = this.binding.tvCamera;
        Intrinsics.checkExpressionValueIsNotNull(radioButton4, "binding.tvCamera");
        Builder addGuidePage4 = addGuidePage3.addGuidePage(getGuidePage(radioButton4, R.string.guide_settings_camera_tips));
        RadioButton radioButton5 = this.binding.tvAbout;
        Intrinsics.checkExpressionValueIsNotNull(radioButton5, "binding.tvAbout");
        this.guideController = addGuidePage4.addGuidePage(getGuidePage(radioButton5, R.string.guide_settings_about_tips)).setOnGuideChangedListener(new OnGuideChangedListener() { // from class: com.ipotensic.kernel.fragment.SettingMainView$showGuideView$1
            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onRemoved(Controller controller) {
            }

            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onShowed(Controller controller) {
            }

            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onRemoved(Controller controller, boolean isFinish, boolean isShowClick, boolean isTopMenuDismiss, boolean dismiss) {
                ViewLayoutSettingMain1Binding viewLayoutSettingMain1Binding;
                SPHelper.getInstance().putBoolean(SPHelper.KEY_FIRST_ENTER_ATOM_SETTINGS, false);
                viewLayoutSettingMain1Binding = SettingMainView.this.binding;
                viewLayoutSettingMain1Binding.rgSetting.check(R.id.tv_security);
            }
        }).setOnPageChangedListener(new OnPageChangedListener() { // from class: com.ipotensic.kernel.fragment.SettingMainView$showGuideView$2
            @Override // com.ipotensic.baselib.guide.listener.OnPageChangedListener
            public final void onPageChanged(int i) {
                ViewLayoutSettingMain1Binding viewLayoutSettingMain1Binding;
                ViewLayoutSettingMain1Binding viewLayoutSettingMain1Binding2;
                ViewLayoutSettingMain1Binding viewLayoutSettingMain1Binding3;
                ViewLayoutSettingMain1Binding viewLayoutSettingMain1Binding4;
                if (i == 1) {
                    viewLayoutSettingMain1Binding = SettingMainView.this.binding;
                    viewLayoutSettingMain1Binding.rgSetting.check(R.id.tv_calibration);
                    return;
                }
                if (i == 2) {
                    viewLayoutSettingMain1Binding2 = SettingMainView.this.binding;
                    viewLayoutSettingMain1Binding2.rgSetting.check(R.id.tv_control);
                } else if (i == 3) {
                    viewLayoutSettingMain1Binding3 = SettingMainView.this.binding;
                    viewLayoutSettingMain1Binding3.rgSetting.check(R.id.tv_camera);
                } else {
                    if (i != 4) {
                        return;
                    }
                    viewLayoutSettingMain1Binding4 = SettingMainView.this.binding;
                    viewLayoutSettingMain1Binding4.rgSetting.check(R.id.tv_about);
                }
            }
        }).show();
    }

    private final GuidePage getGuidePage(View view, int resId) {
        GuidePage backgroundColor = GuidePage.newInstance().addHighLight(view, new SettingRelativeGuide(R.layout.guide_left_new, 5, 0, 0, 0, 0, 0, Integer.valueOf(resId), 124, null)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setEverywhereCancelable(true).setShowCanClick(false, true, false).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorFiftyPercent));
        Intrinsics.checkExpressionValueIsNotNull(backgroundColor, "GuidePage.newInstance().…color.colorFiftyPercent))");
        return backgroundColor;
    }
}
