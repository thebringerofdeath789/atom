package io.netty.channel.kqueue;

import io.netty.util.internal.PlatformDependent;

/* loaded from: classes3.dex */
final class KQueueEventArray {
    private int capacity;
    private long memoryAddress;
    private int size;
    private static final int KQUEUE_EVENT_SIZE = Native.sizeofKEvent();
    private static final int KQUEUE_IDENT_OFFSET = Native.offsetofKEventIdent();
    private static final int KQUEUE_FILTER_OFFSET = Native.offsetofKEventFilter();
    private static final int KQUEUE_FFLAGS_OFFSET = Native.offsetofKEventFFlags();
    private static final int KQUEUE_FLAGS_OFFSET = Native.offsetofKEventFlags();
    private static final int KQUEUE_DATA_OFFSET = Native.offsetofKeventData();

    static native void deleteGlobalRefs(long j, long j2);

    private static native void evSet(long j, AbstractKQueueChannel abstractKQueueChannel, int i, short s, short s2, int i2);

    private static native AbstractKQueueChannel getChannel(long j);

    KQueueEventArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1 but was " + i);
        }
        this.memoryAddress = PlatformDependent.allocateMemory(KQUEUE_EVENT_SIZE * i);
        this.capacity = i;
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    int capacity() {
        return this.capacity;
    }

    int size() {
        return this.size;
    }

    void clear() {
        this.size = 0;
    }

    void evSet(AbstractKQueueChannel abstractKQueueChannel, short s, short s2, int i) {
        checkSize();
        int i2 = this.size;
        this.size = i2 + 1;
        evSet(getKEventOffset(i2), abstractKQueueChannel, abstractKQueueChannel.socket.intValue(), s, s2, i);
    }

    private void checkSize() {
        if (this.size == this.capacity) {
            realloc(true);
        }
    }

    void realloc(boolean z) {
        int i = this.capacity;
        int i2 = i <= 65536 ? i << 1 : (i + i) >> 1;
        long reallocateMemory = PlatformDependent.reallocateMemory(this.memoryAddress, KQUEUE_EVENT_SIZE * i2);
        if (reallocateMemory != 0) {
            this.memoryAddress = reallocateMemory;
            this.capacity = i2;
        } else if (z) {
            throw new OutOfMemoryError("unable to allocate " + i2 + " new bytes! Existing capacity is: " + this.capacity);
        }
    }

    void free() {
        PlatformDependent.freeMemory(this.memoryAddress);
        this.capacity = 0;
        this.size = 0;
        this.memoryAddress = 0;
    }

    long getKEventOffset(int i) {
        return this.memoryAddress + (i * KQUEUE_EVENT_SIZE);
    }

    short flags(int i) {
        return PlatformDependent.getShort(getKEventOffset(i) + KQUEUE_FLAGS_OFFSET);
    }

    short filter(int i) {
        return PlatformDependent.getShort(getKEventOffset(i) + KQUEUE_FILTER_OFFSET);
    }

    short fflags(int i) {
        return PlatformDependent.getShort(getKEventOffset(i) + KQUEUE_FFLAGS_OFFSET);
    }

    int fd(int i) {
        return PlatformDependent.getInt(getKEventOffset(i) + KQUEUE_IDENT_OFFSET);
    }

    long data(int i) {
        return PlatformDependent.getLong(getKEventOffset(i) + KQUEUE_DATA_OFFSET);
    }

    AbstractKQueueChannel channel(int i) {
        return getChannel(getKEventOffset(i));
    }
}
