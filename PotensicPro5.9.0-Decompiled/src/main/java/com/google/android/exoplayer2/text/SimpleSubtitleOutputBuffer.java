package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;

/* loaded from: classes.dex */
final class SimpleSubtitleOutputBuffer extends SubtitleOutputBuffer {
    private final OutputBuffer.Owner<SubtitleOutputBuffer> owner;

    public SimpleSubtitleOutputBuffer(OutputBuffer.Owner<SubtitleOutputBuffer> owner) {
        this.owner = owner;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public final void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
