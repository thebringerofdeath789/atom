package io.netty.channel.epoll;

/* loaded from: classes3.dex */
public final class Epoll {
    private static final Throwable UNAVAILABILITY_CAUSE;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    static {
        /*
            r0 = 0
            io.netty.channel.unix.FileDescriptor r1 = io.netty.channel.epoll.Native.newEpollCreate()     // Catch: java.lang.Throwable -> L17
            io.netty.channel.unix.FileDescriptor r2 = io.netty.channel.epoll.Native.newEventFd()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto Le
            r1.close()     // Catch: java.lang.Exception -> Le
        Le:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.lang.Exception -> L13
        L13:
            r2 = r0
            goto L1e
        L15:
            r2 = move-exception
            goto L19
        L17:
            r2 = move-exception
            r1 = r0
        L19:
            if (r1 == 0) goto L1e
            r1.close()     // Catch: java.lang.Exception -> L1e
        L1e:
            if (r2 == 0) goto L23
            io.netty.channel.epoll.Epoll.UNAVAILABILITY_CAUSE = r2
            goto L37
        L23:
            boolean r1 = io.netty.util.internal.PlatformDependent.hasUnsafe()
            if (r1 == 0) goto L2a
            goto L35
        L2a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.Throwable r1 = io.netty.util.internal.PlatformDependent.getUnsafeUnavailabilityCause()
            java.lang.String r2 = "sun.misc.Unsafe not available"
            r0.<init>(r2, r1)
        L35:
            io.netty.channel.epoll.Epoll.UNAVAILABILITY_CAUSE = r0
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.Epoll.<clinit>():void");
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    private Epoll() {
    }
}
