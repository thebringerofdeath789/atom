package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.ProgressLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormatSdcardProgressDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/FormatSdcardProgressDialog;", "Lcom/ipotensic/baselib/base/BaseSyncDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "loadingView", "Lcom/ipotensic/kernel/view/ProgressLoadingView;", "getLoadingView", "()Lcom/ipotensic/kernel/view/ProgressLoadingView;", "setLoadingView", "(Lcom/ipotensic/kernel/view/ProgressLoadingView;)V", "tvText", "Landroid/widget/TextView;", "getTvText", "()Landroid/widget/TextView;", "setTvText", "(Landroid/widget/TextView;)V", "initView", "", "onStop", "setResult", "success", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FormatSdcardProgressDialog extends BaseSyncDialog {
    public ProgressLoadingView loadingView;
    public TextView tvText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormatSdcardProgressDialog(Context context) {
        super(context, R.layout.view_dialog_format_progress);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public final ProgressLoadingView getLoadingView() {
        ProgressLoadingView progressLoadingView = this.loadingView;
        if (progressLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        return progressLoadingView;
    }

    public final void setLoadingView(ProgressLoadingView progressLoadingView) {
        Intrinsics.checkParameterIsNotNull(progressLoadingView, "<set-?>");
        this.loadingView = progressLoadingView;
    }

    public final TextView getTvText() {
        TextView textView = this.tvText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvText");
        }
        return textView;
    }

    public final void setTvText(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.tvText = textView;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        View findViewById = findViewById(R.id.tv_text);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.tv_text)");
        this.tvText = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.progress_view);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.progress_view)");
        ProgressLoadingView progressLoadingView = (ProgressLoadingView) findViewById2;
        this.loadingView = progressLoadingView;
        if (progressLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        progressLoadingView.setPadding(0.0f);
        ProgressLoadingView progressLoadingView2 = this.loadingView;
        if (progressLoadingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        progressLoadingView2.setStrokeWidth(UnitUtil.dp2px(2));
        ProgressLoadingView progressLoadingView3 = this.loadingView;
        if (progressLoadingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        progressLoadingView3.setRotateTime(300L);
        ProgressLoadingView progressLoadingView4 = this.loadingView;
        if (progressLoadingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        progressLoadingView4.showProgress();
    }

    public final void setResult(boolean success) {
        if (success) {
            ProgressLoadingView progressLoadingView = this.loadingView;
            if (progressLoadingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            }
            progressLoadingView.hideProgress();
            TextView textView = this.tvText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvText");
            }
            textView.setText(R.string.toast_sd_format);
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        ProgressLoadingView progressLoadingView = this.loadingView;
        if (progressLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        progressLoadingView.hideProgress();
    }
}