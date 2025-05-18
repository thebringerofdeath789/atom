package com.ipotensic.potensicpro.view.dialog;

import android.view.View;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.potensicpro.view.dialog.AppLogDialog;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: AppLogDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/ipotensic/potensicpro/view/dialog/AppLogDialog$onCreate$2", "Lcom/ipotensic/baselib/listener/ScaleClickListener;", "click", "", "view", "Landroid/view/View;", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AppLogDialog$onCreate$2 extends ScaleClickListener {
    AppLogDialog$onCreate$2() {
    }

    @Override // com.ipotensic.baselib.listener.ScaleClickListener
    public void click(View view) {
        AppLogDialog.LogAdapter logAdapter;
        AppLogDialog.this.isSelectMode = !r3.isSelectMode;
        if (!AppLogDialog.this.isSelectMode) {
            Iterator it = AppLogDialog.this.fileItems.iterator();
            while (it.hasNext()) {
                ((AppLogDialog.FileItem) it.next()).setSelect(false);
            }
        }
        logAdapter = AppLogDialog.this.adapter;
        logAdapter.notifyDataSetChanged();
    }
}