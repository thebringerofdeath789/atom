package com.ipotensic.kernel.view.dialog;

import android.text.TextUtils;
import android.view.View;
import com.ipotensic.kernel.C1965R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: CommonTwoButtonDialog.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\u00002\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u0018\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m2338d2 = {"Lcom/ipotensic/kernel/view/dialog/CommonTwoButtonDialog;", "Lcom/ipotensic/kernel/view/dialog/CommonDialog;", "()V", "autoDismiss", "", "cancelListener", "Lkotlin/Function0;", "", "cancelStr", "", "confirmListener", "confirmStr", "content", MessageBundle.TITLE_ENTRY, "convertView", "holder", "Lcom/ipotensic/kernel/view/dialog/BaseDialogViewHolder;", "dialog", "Lcom/ipotensic/kernel/view/dialog/BaseDialog;", "initSize", "setAutoDismiss", "setCancelListener", "listener", "setCancelStr", "setConfirmListener", "setConfirmStr", "setContent", "setTitle", "setUpLayoutId", "", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CommonTwoButtonDialog extends CommonDialog {
    private HashMap _$_findViewCache;
    private boolean autoDismiss = true;
    private Function0<Unit> cancelListener;
    private String cancelStr;
    private Function0<Unit> confirmListener;
    private String confirmStr;
    private String content;
    private String title;

    @Override // com.ipotensic.kernel.view.dialog.CommonDialog, com.ipotensic.kernel.view.dialog.BaseDialog
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.ipotensic.kernel.view.dialog.CommonDialog, com.ipotensic.kernel.view.dialog.BaseDialog
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.ipotensic.kernel.view.dialog.CommonDialog, com.ipotensic.kernel.view.dialog.BaseDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public CommonTwoButtonDialog() {
        setOutCancel(false);
    }

    @Override // com.ipotensic.kernel.view.dialog.CommonDialog, com.ipotensic.kernel.view.dialog.BaseDialog
    public int setUpLayoutId() {
        return C1965R.layout.dialog_common_two_button;
    }

    public final CommonTwoButtonDialog setTitle(String title) {
        Intrinsics.checkParameterIsNotNull(title, "title");
        this.title = title;
        return this;
    }

    public final CommonTwoButtonDialog setContent(String content) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        this.content = content;
        return this;
    }

    public final CommonTwoButtonDialog setConfirmStr(String confirmStr) {
        if (!TextUtils.isEmpty(confirmStr)) {
            this.confirmStr = confirmStr;
        }
        return this;
    }

    public final CommonTwoButtonDialog setCancelStr(String cancelStr) {
        if (!TextUtils.isEmpty(cancelStr)) {
            this.cancelStr = cancelStr;
        }
        return this;
    }

    public final CommonTwoButtonDialog setConfirmListener(Function0<Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.confirmListener = listener;
        return this;
    }

    public final CommonTwoButtonDialog setCancelListener(Function0<Unit> listener) {
        this.cancelListener = listener;
        return this;
    }

    public final CommonTwoButtonDialog setAutoDismiss(boolean autoDismiss) {
        this.autoDismiss = autoDismiss;
        return this;
    }

    @Override // com.ipotensic.kernel.view.dialog.CommonDialog, com.ipotensic.kernel.view.dialog.BaseDialog
    public void initSize() {
        setSize((int) (BaseDialog.INSTANCE.getScreenWidth(getMContext()) * 0.45d), 0);
    }

    @Override // com.ipotensic.kernel.view.dialog.CommonDialog, com.ipotensic.kernel.view.dialog.BaseDialog
    public void convertView(BaseDialogViewHolder holder, BaseDialog dialog) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        holder.setText(C1965R.id.tv_title, this.title);
        holder.setText(C1965R.id.tv_content, this.content);
        String str = this.cancelStr;
        if (str != null) {
            holder.setText(C1965R.id.btn_cancel, str);
        }
        String str2 = this.confirmStr;
        if (str2 != null) {
            holder.setText(C1965R.id.btn_confirm, str2);
        }
        holder.setOnClickListener(C1965R.id.btn_confirm, new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.CommonTwoButtonDialog$convertView$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0;
                boolean z;
                function0 = CommonTwoButtonDialog.this.confirmListener;
                if (function0 != null) {
                }
                z = CommonTwoButtonDialog.this.autoDismiss;
                if (z) {
                    CommonTwoButtonDialog.this.dismiss();
                }
            }
        });
        holder.setOnClickListener(C1965R.id.btn_cancel, new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.CommonTwoButtonDialog$convertView$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0;
                boolean z;
                function0 = CommonTwoButtonDialog.this.cancelListener;
                if (function0 != null) {
                }
                z = CommonTwoButtonDialog.this.autoDismiss;
                if (z) {
                    CommonTwoButtonDialog.this.dismiss();
                }
            }
        });
    }
}