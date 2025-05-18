package com.ipotensic.kernel.fragment;

import com.ipotensic.baselib.guide.listener.OnPageChangedListener;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutSettingMain1Binding;
import kotlin.Metadata;

/* compiled from: SettingMainView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "onPageChanged"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class SettingMainView$showGuideView$2 implements OnPageChangedListener {
    SettingMainView$showGuideView$2() {
    }

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
}