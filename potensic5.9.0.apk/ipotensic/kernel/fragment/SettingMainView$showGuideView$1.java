package com.ipotensic.kernel.fragment;

import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnGuideChangedListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutSettingMain1Binding;
import kotlin.Metadata;

/* compiled from: SettingMainView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\f"}, d2 = {"com/ipotensic/kernel/fragment/SettingMainView$showGuideView$1", "Lcom/ipotensic/baselib/guide/listener/OnGuideChangedListener;", "onRemoved", "", "controller", "Lcom/ipotensic/baselib/guide/core/Controller;", "isFinish", "", "isShowClick", "isTopMenuDismiss", "dismiss", "onShowed", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SettingMainView$showGuideView$1 implements OnGuideChangedListener {
    @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
    public void onRemoved(Controller controller) {
    }

    @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
    public void onShowed(Controller controller) {
    }

    SettingMainView$showGuideView$1() {
    }

    @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
    public void onRemoved(Controller controller, boolean isFinish, boolean isShowClick, boolean isTopMenuDismiss, boolean dismiss) {
        ViewLayoutSettingMain1Binding viewLayoutSettingMain1Binding;
        SPHelper.getInstance().putBoolean(SPHelper.KEY_FIRST_ENTER_ATOM_SETTINGS, false);
        viewLayoutSettingMain1Binding = SettingMainView.this.binding;
        viewLayoutSettingMain1Binding.rgSetting.check(R.id.tv_security);
    }
}