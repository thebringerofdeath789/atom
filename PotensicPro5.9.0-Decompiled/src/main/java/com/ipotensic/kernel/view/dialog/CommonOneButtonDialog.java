package com.ipotensic.kernel.view.dialog;

import android.text.TextUtils;
import android.view.View;
import com.ipotensic.kernel.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonOneButtonDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0014\u001a\u00020\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/CommonOneButtonDialog;", "Lcom/ipotensic/kernel/view/dialog/CommonDialog;", "()V", "autoDismiss", "", "buttonStr", "", "confirmListener", "Lkotlin/Function0;", "", "content", "title", "convertView", "holder", "Lcom/ipotensic/kernel/view/dialog/BaseDialogViewHolder;", "dialog", "Lcom/ipotensic/kernel/view/dialog/BaseDialog;", "initSize", "setAutoDismiss", "setButtonStr", "setConfirmListener", "listener", "setContent", "setTitle", "setUpLayoutId", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CommonOneButtonDialog extends CommonDialog {
    private HashMap _$_findViewCache;
    private boolean autoDismiss = true;
    private String buttonStr;
    private Function0<Unit> confirmListener;
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

    public CommonOneButtonDialog() {
        setOutCancel(false);
    }

    @Override // com.ipotensic.kernel.view.dialog.CommonDialog, com.ipotensic.kernel.view.dialog.BaseDialog
    public int setUpLayoutId() {
        return R.layout.dialog_common_one_button;
    }

    public final CommonOneButtonDialog setTitle(String title) {
        Intrinsics.checkParameterIsNotNull(title, "title");
        this.title = title;
        return this;
    }

    public final CommonOneButtonDialog setContent(String content) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        this.content = content;
        return this;
    }

    public final CommonOneButtonDialog setButtonStr(String buttonStr) {
        if (!TextUtils.isEmpty(buttonStr)) {
            this.buttonStr = buttonStr;
        }
        return this;
    }

    public final CommonOneButtonDialog setConfirmListener(Function0<Unit> listener) {
        this.confirmListener = listener;
        return this;
    }

    public final CommonOneButtonDialog setAutoDismiss(boolean autoDismiss) {
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
        holder.setText(R.id.tv_dialog_title, this.title);
        holder.setText(R.id.tv_content, this.content);
        String str = this.buttonStr;
        if (str != null) {
            holder.setText(R.id.btn_ok, str);
        }
        holder.setOnClickListener(R.id.btn_ok, new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.CommonOneButtonDialog$convertView$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0;
                boolean z;
                function0 = CommonOneButtonDialog.this.confirmListener;
                if (function0 != null) {
                }
                z = CommonOneButtonDialog.this.autoDismiss;
                if (z) {
                    CommonOneButtonDialog.this.dismiss();
                }
            }
        });
    }
}
