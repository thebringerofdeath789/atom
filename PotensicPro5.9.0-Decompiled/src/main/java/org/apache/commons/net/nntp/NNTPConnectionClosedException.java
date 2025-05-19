package org.apache.commons.net.nntp;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class NNTPConnectionClosedException extends IOException {
    private static final long serialVersionUID = 1029785635891040770L;

    public NNTPConnectionClosedException() {
    }

    public NNTPConnectionClosedException(String str) {
        super(str);
    }
}
