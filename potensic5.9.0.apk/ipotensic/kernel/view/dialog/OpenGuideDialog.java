package com.ipotensic.kernel.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OpenGuideDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/OpenGuideDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initParams", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class OpenGuideDialog extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenGuideDialog(Context context) {
        super(context, R.style.CustomDialog);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_open_guide);
        ((TextView) findViewById(R.id.tv_content)).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.OpenGuideDialog$onCreate$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenGuideDialog.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        initParams();
    }

    private final void initParams() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.gravity = 17;
        BaseDialog.Companion companion = BaseDialog.INSTANCE;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        attributes.width = (int) (companion.getScreenWidth(context) * 0.538d);
        attributes.height = -2;
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(attributes);
        }
    }
}