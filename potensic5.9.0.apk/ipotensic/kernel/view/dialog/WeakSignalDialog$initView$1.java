package com.ipotensic.kernel.view.dialog;

import android.view.View;
import android.widget.CheckBox;
import com.ipotensic.kernel.view.dialog.WeakSignalDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeakSignalDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class WeakSignalDialog$initView$1 implements View.OnClickListener {
    final /* synthetic */ CheckBox $cbNoLonger;

    WeakSignalDialog$initView$1(CheckBox checkBox) {
        checkBox = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakSignalDialog.OnResultListener resultListener = WeakSignalDialog.this.getResultListener();
        if (resultListener != null) {
            CheckBox cbNoLonger = checkBox;
            Intrinsics.checkExpressionValueIsNotNull(cbNoLonger, "cbNoLonger");
            resultListener.onConfirm(cbNoLonger.isChecked());
        }
        WeakSignalDialog.this.dismiss();
    }
}