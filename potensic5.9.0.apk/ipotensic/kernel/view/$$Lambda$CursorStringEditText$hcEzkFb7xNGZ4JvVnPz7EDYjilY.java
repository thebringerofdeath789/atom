package com.ipotensic.kernel.view;

import android.view.KeyEvent;
import android.widget.TextView;
import com.ipotensic.kernel.view.CursorStringEditText;

/* compiled from: lambda */
/* renamed from: com.ipotensic.kernel.view.-$$Lambda$CursorStringEditText$hcEzkFb7xNGZ4JvVnPz7EDYjilY */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$CursorStringEditText$hcEzkFb7xNGZ4JvVnPz7EDYjilY implements TextView.OnEditorActionListener {
    public final /* synthetic */ CursorStringEditText.OnInputFinishListener f$1;

    public /* synthetic */ $$Lambda$CursorStringEditText$hcEzkFb7xNGZ4JvVnPz7EDYjilY(CursorStringEditText.OnInputFinishListener onInputFinishListener) {
        onInputFinishListener = onInputFinishListener;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return CursorStringEditText.this.lambda$setInputFinishListener$0$CursorStringEditText(onInputFinishListener, textView, i, keyEvent);
    }
}