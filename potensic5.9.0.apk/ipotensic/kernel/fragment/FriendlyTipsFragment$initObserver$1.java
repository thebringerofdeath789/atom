package com.ipotensic.kernel.fragment;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.ipotensic.kernel.bean.DroneNoticeBean;
import com.ipotensic.kernel.databinding.FragmentFriendlyTipsBinding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: FriendlyTipsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "longTipBean", "Lcom/ipotensic/kernel/bean/DroneNoticeBean;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class FriendlyTipsFragment$initObserver$1<T> implements Observer<DroneNoticeBean> {
    FriendlyTipsFragment$initObserver$1() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(DroneNoticeBean droneNoticeBean) {
        FragmentFriendlyTipsBinding mBind;
        FragmentFriendlyTipsBinding mBind2;
        FragmentFriendlyTipsBinding mBind3;
        FragmentFriendlyTipsBinding mBind4;
        if (droneNoticeBean != null) {
            mBind = FriendlyTipsFragment.this.getMBind();
            RelativeLayout relativeLayout = mBind.rlLongTipRoot;
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "mBind.rlLongTipRoot");
            if (relativeLayout.getVisibility() != 0) {
                mBind4 = FriendlyTipsFragment.this.getMBind();
                RelativeLayout relativeLayout2 = mBind4.rlLongTipRoot;
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "mBind.rlLongTipRoot");
                relativeLayout2.setVisibility(0);
            }
            if (!TextUtils.isEmpty(droneNoticeBean.getParam())) {
                mBind3 = FriendlyTipsFragment.this.getMBind();
                TextView textView = mBind3.tvLongTipContent;
                Intrinsics.checkExpressionValueIsNotNull(textView, "mBind.tvLongTipContent");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = FriendlyTipsFragment.this.getString(droneNoticeBean.getErrorCode().getCodeName());
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(it.errorCode.codeName)");
                String format = String.format(string, Arrays.copyOf(new Object[]{droneNoticeBean.getParam()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                textView.setText(format);
                return;
            }
            mBind2 = FriendlyTipsFragment.this.getMBind();
            TextView textView2 = mBind2.tvLongTipContent;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "mBind.tvLongTipContent");
            textView2.setText(FriendlyTipsFragment.this.getString(droneNoticeBean.getErrorCode().getCodeName()));
        }
    }
}