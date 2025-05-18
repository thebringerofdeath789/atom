package com.ipotensic.kernel.manager;

import android.media.MediaPlayer;
import com.ipotensic.kernel.manager.TipManager;

/* compiled from: lambda */
/* renamed from: com.ipotensic.kernel.manager.-$$Lambda$TipManager$1$GRyg-CpVZ4Wf247KjXhqDbdcSnw */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$TipManager$1$GRygCpVZ4Wf247KjXhqDbdcSnw implements MediaPlayer.OnCompletionListener {
    public /* synthetic */ $$Lambda$TipManager$1$GRygCpVZ4Wf247KjXhqDbdcSnw() {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        TipManager.AnonymousClass1.this.lambda$handleMessage$0$TipManager$1(mediaPlayer);
    }
}