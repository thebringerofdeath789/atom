package io.netty.channel.kqueue;

import io.netty.channel.unix.Errors;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Locale;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes3.dex */
final class Native {
    static final short EVFILT_READ;
    static final short EVFILT_SOCK;
    static final short EVFILT_USER;
    static final short EVFILT_WRITE;
    static final short EV_ADD;
    static final short EV_ADD_CLEAR_ENABLE;
    static final short EV_CLEAR;
    static final short EV_DELETE;
    static final short EV_DELETE_DISABLE;
    static final short EV_DISABLE;
    static final short EV_ENABLE;
    static final short EV_EOF;
    static final short EV_ERROR;
    static final int NOTE_CONNRESET;
    static final int NOTE_DISCONNECTED;
    static final int NOTE_RDHUP;
    static final int NOTE_READCLOSED;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Native.class);

    static native int keventAddUserEvent(int i, int i2);

    static native int keventTriggerUserEvent(int i, int i2);

    private static native int keventWait(int i, long j, int i2, long j2, int i3, int i4, int i5);

    private static native int kqueueCreate();

    static native int offsetofKEventFFlags();

    static native int offsetofKEventFilter();

    static native int offsetofKEventFlags();

    static native int offsetofKEventIdent();

    static native int offsetofKeventData();

    static native int sizeofKEvent();

    static {
        try {
            sizeofKEvent();
        } catch (UnsatisfiedLinkError unused) {
            loadNativeLibrary();
        }
        Socket.initialize();
        short evAdd = KQueueStaticallyReferencedJniMethods.evAdd();
        EV_ADD = evAdd;
        short evEnable = KQueueStaticallyReferencedJniMethods.evEnable();
        EV_ENABLE = evEnable;
        short evDisable = KQueueStaticallyReferencedJniMethods.evDisable();
        EV_DISABLE = evDisable;
        short evDelete = KQueueStaticallyReferencedJniMethods.evDelete();
        EV_DELETE = evDelete;
        short evClear = KQueueStaticallyReferencedJniMethods.evClear();
        EV_CLEAR = evClear;
        EV_ERROR = KQueueStaticallyReferencedJniMethods.evError();
        EV_EOF = KQueueStaticallyReferencedJniMethods.evEOF();
        short noteReadClosed = KQueueStaticallyReferencedJniMethods.noteReadClosed();
        NOTE_READCLOSED = noteReadClosed;
        short noteConnReset = KQueueStaticallyReferencedJniMethods.noteConnReset();
        NOTE_CONNRESET = noteConnReset;
        short noteDisconnected = KQueueStaticallyReferencedJniMethods.noteDisconnected();
        NOTE_DISCONNECTED = noteDisconnected;
        NOTE_RDHUP = noteReadClosed | noteConnReset | noteDisconnected;
        EV_ADD_CLEAR_ENABLE = (short) (evAdd | evClear | evEnable);
        EV_DELETE_DISABLE = (short) (evDelete | evDisable);
        EVFILT_READ = KQueueStaticallyReferencedJniMethods.evfiltRead();
        EVFILT_WRITE = KQueueStaticallyReferencedJniMethods.evfiltWrite();
        EVFILT_USER = KQueueStaticallyReferencedJniMethods.evfiltUser();
        EVFILT_SOCK = KQueueStaticallyReferencedJniMethods.evfiltSock();
    }

    static FileDescriptor newKQueue() {
        return new FileDescriptor(kqueueCreate());
    }

    static int keventWait(int i, KQueueEventArray kQueueEventArray, KQueueEventArray kQueueEventArray2, int i2, int i3) throws IOException {
        int keventWait = keventWait(i, kQueueEventArray.memoryAddress(), kQueueEventArray.size(), kQueueEventArray2.memoryAddress(), kQueueEventArray2.capacity(), i2, i3);
        if (keventWait >= 0) {
            return keventWait;
        }
        throw Errors.newIOException("kevent", keventWait);
    }

    private static void loadNativeLibrary() {
        String trim = SystemPropertyUtil.get("os.name").toLowerCase(Locale.UK).trim();
        if (!trim.startsWith("mac") && !trim.contains("bsd") && !trim.startsWith("darwin")) {
            throw new IllegalStateException("Only supported on BSD");
        }
        String str = "netty_transport_native_kqueue" + NameUtil.USCORE + PlatformDependent.normalizedArch();
        ClassLoader classLoader = PlatformDependent.getClassLoader(Native.class);
        try {
            NativeLibraryLoader.load(str, classLoader);
        } catch (UnsatisfiedLinkError e) {
            try {
                NativeLibraryLoader.load("netty_transport_native_kqueue", classLoader);
                logger.debug("Failed to load {}", str, e);
            } catch (UnsatisfiedLinkError e2) {
                ThrowableUtil.addSuppressed(e, e2);
                throw e;
            }
        }
    }

    private Native() {
    }
}
