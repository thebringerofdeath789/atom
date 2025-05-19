package io.netty.channel.kqueue;

/* loaded from: classes3.dex */
final class KQueueStaticallyReferencedJniMethods {
    static native short evAdd();

    static native short evClear();

    static native short evDelete();

    static native short evDisable();

    static native short evEOF();

    static native short evEnable();

    static native short evError();

    static native short evfiltRead();

    static native short evfiltSock();

    static native short evfiltUser();

    static native short evfiltWrite();

    static native short noteConnReset();

    static native short noteDisconnected();

    static native short noteReadClosed();

    private KQueueStaticallyReferencedJniMethods() {
    }
}
