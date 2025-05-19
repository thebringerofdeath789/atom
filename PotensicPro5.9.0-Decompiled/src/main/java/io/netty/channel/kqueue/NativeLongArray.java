package io.netty.channel.kqueue;

import io.netty.channel.unix.Limits;
import io.netty.util.internal.PlatformDependent;

/* loaded from: classes3.dex */
final class NativeLongArray {
    private int capacity;
    private long memoryAddress;
    private int size;

    NativeLongArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1 but was " + i);
        }
        this.memoryAddress = PlatformDependent.allocateMemory(Limits.SIZEOF_JLONG * i);
        this.capacity = i;
    }

    void add(long j) {
        checkSize();
        int i = this.size;
        this.size = i + 1;
        PlatformDependent.putLong(memoryOffset(i), j);
    }

    void clear() {
        this.size = 0;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    void free() {
        PlatformDependent.freeMemory(this.memoryAddress);
        this.memoryAddress = 0L;
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    long memoryAddressEnd() {
        return memoryOffset(this.size);
    }

    private long memoryOffset(int i) {
        return this.memoryAddress + (i * Limits.SIZEOF_JLONG);
    }

    private void checkSize() {
        if (this.size == this.capacity) {
            realloc();
        }
    }

    private void realloc() {
        int i = this.capacity;
        int i2 = i <= 65536 ? i << 1 : (i + i) >> 1;
        long reallocateMemory = PlatformDependent.reallocateMemory(this.memoryAddress, Limits.SIZEOF_JLONG * i2);
        if (reallocateMemory == 0) {
            throw new OutOfMemoryError("unable to allocate " + i2 + " new bytes! Existing capacity is: " + this.capacity);
        }
        this.memoryAddress = reallocateMemory;
        this.capacity = i2;
    }

    public String toString() {
        return "memoryAddress: " + this.memoryAddress + " capacity: " + this.capacity + " size: " + this.size;
    }
}
