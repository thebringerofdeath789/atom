package com.ipotensic.kernel.view.dialog;

import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/CommonDialog;", "Lcom/ipotensic/kernel/view/dialog/BaseDialog;", "()V", "convertListener", "Lcom/ipotensic/kernel/view/dialog/CommonDialog$ViewConvertListener;", "convertView", "", "holder", "Lcom/ipotensic/kernel/view/dialog/BaseDialogViewHolder;", "dialog", "initSize", "setConvertListener", "setLayoutId", "layoutId", "", "setUpLayoutId", "Companion", "ViewConvertListener", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class CommonDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private HashMap _$_findViewCache;
    private ViewConvertListener convertListener;

    /* compiled from: CommonDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/CommonDialog$ViewConvertListener;", "", "convertView", "", "holder", "Lcom/ipotensic/kernel/view/dialog/BaseDialogViewHolder;", "dialog", "Lcom/ipotensic/kernel/view/dialog/BaseDialog;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public interface ViewConvertListener {
        void convertView(BaseDialogViewHolder holder, BaseDialog dialog);
    }

    @Override // com.ipotensic.kernel.view.dialog.BaseDialog
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.ipotensic.kernel.view.dialog.BaseDialog
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

    @Override // com.ipotensic.kernel.view.dialog.BaseDialog
    public void initSize() {
    }

    @Override // com.ipotensic.kernel.view.dialog.BaseDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* compiled from: CommonDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/CommonDialog$Companion;", "", "()V", "newInstance", "Lcom/ipotensic/kernel/view/dialog/CommonDialog;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommonDialog newInstance() {
            return new CommonDialog();
        }
    }

    public final CommonDialog setConvertListener(ViewConvertListener convertListener) {
        this.convertListener = convertListener;
        return this;
    }

    public final CommonDialog setLayoutId(int layoutId) {
        setMLayoutResId(layoutId);
        return this;
    }

    @Override // com.ipotensic.kernel.view.dialog.BaseDialog
    public int setUpLayoutId() {
        return getMLayoutResId();
    }

    @Override // com.ipotensic.kernel.view.dialog.BaseDialog
    public void convertView(BaseDialogViewHolder holder, BaseDialog dialog) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        ViewConvertListener viewConvertListener = this.convertListener;
        if (viewConvertListener != null) {
            viewConvertListener.convertView(holder, dialog);
        }
    }
}