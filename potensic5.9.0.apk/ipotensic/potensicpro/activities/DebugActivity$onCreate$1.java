package com.ipotensic.potensicpro.activities;

import android.view.View;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.potensicpro.view.dialog.AppLogDialog;
import kotlin.Metadata;

/* compiled from: DebugActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/ipotensic/potensicpro/activities/DebugActivity$onCreate$1", "Lcom/ipotensic/baselib/listener/ScaleClickListener;", "click", "", "view", "Landroid/view/View;", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class DebugActivity$onCreate$1 extends ScaleClickListener {
    DebugActivity$onCreate$1() {
    }

    @Override // com.ipotensic.baselib.listener.ScaleClickListener
    public void click(View view) {
        new AppLogDialog(DebugActivity.this).show();
    }
}