package io.netty.channel.epoll;

import io.netty.util.internal.PlatformDependent;

/* loaded from: classes3.dex */
final class EpollEventArray {
    private int length;
    private long memoryAddress;
    private static final int EPOLL_EVENT_SIZE = Native.sizeofEpollEvent();
    private static final int EPOLL_DATA_OFFSET = Native.offsetofEpollData();

    EpollEventArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("length must be >= 1 but was " + i);
        }
        this.length = i;
        this.memoryAddress = allocate(i);
    }

    private static long allocate(int i) {
        return PlatformDependent.allocateMemory(i * EPOLL_EVENT_SIZE);
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    int length() {
        return this.length;
    }

    void increase() {
        this.length <<= 1;
        free();
        this.memoryAddress = allocate(this.length);
    }

    void free() {
        PlatformDependent.freeMemory(this.memoryAddress);
    }

    int events(int i) {
        return PlatformDependent.getInt(this.memoryAddress + (i * EPOLL_EVENT_SIZE));
    }

    int fd(int i) {
        return PlatformDependent.getInt(this.memoryAddress + (i * EPOLL_EVENT_SIZE) + EPOLL_DATA_OFFSET);
    }
}
