package com.ipotensic.baselib.views.dailog;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.R;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: PermissionDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/ipotensic/baselib/views/dailog/PermissionDialog;", "Lcom/ipotensic/baselib/base/BaseSyncDialog;", "context", "Landroid/content/Context;", MessageBundle.TITLE_ENTRY, "", "content", "leftStr", "rightStr", "grantListener", "Lcom/ipotensic/baselib/views/dailog/PermissionDialog$OnGrantListener;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ipotensic/baselib/views/dailog/PermissionDialog$OnGrantListener;)V", "(Landroid/content/Context;Lcom/ipotensic/baselib/views/dailog/PermissionDialog$OnGrantListener;)V", "getGrantListener", "()Lcom/ipotensic/baselib/views/dailog/PermissionDialog$OnGrantListener;", "tvAllow", "Landroid/widget/TextView;", "tvNotAllow", "initView", "", "OnGrantListener", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class PermissionDialog extends BaseSyncDialog {
    private final OnGrantListener grantListener;
    private TextView tvAllow;
    private TextView tvNotAllow;

    /* compiled from: PermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/ipotensic/baselib/views/dailog/PermissionDialog$OnGrantListener;", "", "onGrant", "", "isGrant", "", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
    public interface OnGrantListener {
        void onGrant(boolean isGrant);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionDialog(Context context, OnGrantListener grantListener) {
        super(context, R.layout.view_dialog_permission);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(grantListener, "grantListener");
        this.grantListener = grantListener;
        int screenWidth = ScreenUtils.getScreenWidth(getContext());
        ScreenUtils.getScreenHeight(getContext());
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "getContext()");
        Resources resources = context2.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "getContext().resources");
        if (resources.getConfiguration().orientation == 1) {
            setSize((screenWidth * 9) / 10, this.WRAP_CONTENT);
            controlWindow(false);
        } else {
            setSize((screenWidth * 5) / 10, this.WRAP_CONTENT);
        }
        setCanceledOnTouchOutside(false);
    }

    public final OnGrantListener getGrantListener() {
        return this.grantListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PermissionDialog(Context context, String title, String content, String leftStr, String rightStr, OnGrantListener grantListener) {
        this(context, grantListener);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intrinsics.checkParameterIsNotNull(leftStr, "leftStr");
        Intrinsics.checkParameterIsNotNull(rightStr, "rightStr");
        Intrinsics.checkParameterIsNotNull(grantListener, "grantListener");
        View findViewById = findViewById(R.id.tv_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById<TextView>(R.id.tv_title)");
        ((TextView) findViewById).setText(title);
        View findViewById2 = findViewById(R.id.tv_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById<TextView>(R.id.tv_content)");
        ((TextView) findViewById2).setText(content);
        View findViewById3 = findViewById(R.id.tv_not_allow);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById<TextView>(R.id.tv_not_allow)");
        ((TextView) findViewById3).setText(leftStr);
        View findViewById4 = findViewById(R.id.tv_allow);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById<TextView>(R.id.tv_allow)");
        ((TextView) findViewById4).setText(rightStr);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        View findViewById = findViewById(R.id.tv_not_allow);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById<TextView>(R.id.tv_not_allow)");
        TextView textView = (TextView) findViewById;
        this.tvNotAllow = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNotAllow");
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.dailog.PermissionDialog$initView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionDialog.this.getGrantListener().onGrant(false);
                PermissionDialog.this.dismiss();
            }
        });
        View findViewById2 = findViewById(R.id.tv_allow);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById<TextView>(R.id.tv_allow)");
        TextView textView2 = (TextView) findViewById2;
        this.tvAllow = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAllow");
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.dailog.PermissionDialog$initView$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionDialog.this.getGrantListener().onGrant(true);
                PermissionDialog.this.dismiss();
            }
        });
    }
}