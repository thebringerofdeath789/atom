package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.dialog.WeakSignalDialog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeakSignalDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/WeakSignalDialog;", "Lcom/ipotensic/baselib/base/BaseSyncDialog;", "context", "Landroid/content/Context;", "resultListener", "Lcom/ipotensic/kernel/view/dialog/WeakSignalDialog$OnResultListener;", "(Landroid/content/Context;Lcom/ipotensic/kernel/view/dialog/WeakSignalDialog$OnResultListener;)V", "getResultListener", "()Lcom/ipotensic/kernel/view/dialog/WeakSignalDialog$OnResultListener;", "setResultListener", "(Lcom/ipotensic/kernel/view/dialog/WeakSignalDialog$OnResultListener;)V", "dismiss", "", "initView", "Companion", "OnResultListener", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class WeakSignalDialog extends BaseSyncDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isUserConfirm;
    private OnResultListener resultListener;

    /* compiled from: WeakSignalDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/WeakSignalDialog$OnResultListener;", "", "onConfirm", "", "isNoLonger", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public interface OnResultListener {
        void onConfirm(boolean isNoLonger);
    }

    public static final boolean isUserConfirm() {
        return isUserConfirm;
    }

    public static final void setUserConfirm(boolean z) {
        isUserConfirm = z;
    }

    /* compiled from: WeakSignalDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/WeakSignalDialog$Companion;", "", "()V", "isUserConfirm", "", "isUserConfirm$annotations", "()Z", "setUserConfirm", "(Z)V", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void isUserConfirm$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isUserConfirm() {
            return WeakSignalDialog.isUserConfirm;
        }

        public final void setUserConfirm(boolean z) {
            WeakSignalDialog.isUserConfirm = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakSignalDialog(Context context, OnResultListener onResultListener) {
        super(context, R.layout.view_dialog_weak_signal);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.resultListener = onResultListener;
    }

    public final OnResultListener getResultListener() {
        return this.resultListener;
    }

    public final void setResultListener(OnResultListener onResultListener) {
        this.resultListener = onResultListener;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setSize(this.MATCH_PARENT, this.MATCH_PARENT);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.cb_no_longer);
        ((Button) findViewById(R.id.btn_confirm)).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.WeakSignalDialog$initView$1
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
        });
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.WeakSignalDialog$dismiss$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Glide.get(WeakSignalDialog.this.getContext()).clearMemory();
                    Glide.get(WeakSignalDialog.this.getContext()).clearDiskCache();
                } catch (Exception unused) {
                }
            }
        });
    }
}
