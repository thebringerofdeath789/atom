package com.ipotensic.potensicpro.view.dialog;

import android.view.View;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.potensicpro.view.dialog.AppLogDialog;
import kotlin.Metadata;

/* compiled from: AppLogDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/ipotensic/potensicpro/view/dialog/AppLogDialog$LogAdapter$onBindViewHolder$1", "Lcom/ipotensic/baselib/listener/ScaleClickListener;", "click", "", "view", "Landroid/view/View;", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AppLogDialog$LogAdapter$onBindViewHolder$1 extends ScaleClickListener {
    final /* synthetic */ AppLogDialog.FileItem $file;
    final /* synthetic */ int $position;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppLogDialog$LogAdapter$onBindViewHolder$1(AppLogDialog.FileItem fileItem, int i, boolean z) {
        super(z);
        fileItem = fileItem;
        position = i;
    }

    @Override // com.ipotensic.baselib.listener.ScaleClickListener
    public void click(View view) {
        if (AppLogDialog.this.isSelectMode) {
            fileItem.setSelect(!r2.isSelect());
            AppLogDialog.LogAdapter.this.notifyItemChanged(position);
        }
    }
}