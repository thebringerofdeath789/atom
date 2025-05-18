package com.ipotensic.baselib.views;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: TitleView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class TitleView$addRightView$1 implements View.OnClickListener {
    final /* synthetic */ String $tag;

    TitleView$addRightView$1(String str) {
        tag = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<String, Unit> onRightClick = TitleView.this.getOnRightClick();
        if (onRightClick != null) {
            onRightClick.invoke(tag);
        }
    }
}