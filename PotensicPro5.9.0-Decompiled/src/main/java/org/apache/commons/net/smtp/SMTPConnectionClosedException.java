package org.apache.commons.net.smtp;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class SMTPConnectionClosedException extends IOException {
    private static final long serialVersionUID = 626520434326660627L;

    public SMTPConnectionClosedException() {
    }

    public SMTPConnectionClosedException(String str) {
        super(str);
    }
}
