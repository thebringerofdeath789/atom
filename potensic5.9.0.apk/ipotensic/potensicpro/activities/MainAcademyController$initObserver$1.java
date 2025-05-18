package com.ipotensic.potensicpro.activities;

import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.ipotensic.baselib.bean.TitleBean;
import kotlin.Metadata;

/* compiled from: MainAcademyController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "t", "Lcom/ipotensic/baselib/bean/TitleBean;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class MainAcademyController$initObserver$1<T> implements Observer<TitleBean> {
    MainAcademyController$initObserver$1() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(TitleBean titleBean) {
        boolean z;
        MainAcademyController mainAcademyController = MainAcademyController.this;
        Integer isHome = titleBean != null ? titleBean.isHome() : null;
        mainAcademyController.isHome = isHome != null && isHome.intValue() == 1;
        ImageView ivBack = MainAcademyController.access$getTitleView$p(MainAcademyController.this).getIvBack();
        z = MainAcademyController.this.isHome;
        ivBack.setVisibility(z ? 4 : 0);
        MainAcademyController.access$getTitleView$p(MainAcademyController.this).setTitle(titleBean);
    }
}