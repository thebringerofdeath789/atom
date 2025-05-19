package org.apache.commons.collections;

import org.apache.commons.collections.buffer.BlockingBuffer;
import org.apache.commons.collections.buffer.BoundedBuffer;
import org.apache.commons.collections.buffer.PredicatedBuffer;
import org.apache.commons.collections.buffer.SynchronizedBuffer;
import org.apache.commons.collections.buffer.TransformedBuffer;
import org.apache.commons.collections.buffer.TypedBuffer;
import org.apache.commons.collections.buffer.UnmodifiableBuffer;

/* loaded from: classes4.dex */
public class BufferUtils {
    public static final Buffer EMPTY_BUFFER = UnmodifiableBuffer.decorate(new ArrayStack(1));

    public static Buffer synchronizedBuffer(Buffer buffer) {
        return SynchronizedBuffer.decorate(buffer);
    }

    public static Buffer blockingBuffer(Buffer buffer) {
        return BlockingBuffer.decorate(buffer);
    }

    public static Buffer blockingBuffer(Buffer buffer, long j) {
        return BlockingBuffer.decorate(buffer, j);
    }

    public static Buffer boundedBuffer(Buffer buffer, int i) {
        return BoundedBuffer.decorate(buffer, i);
    }

    public static Buffer boundedBuffer(Buffer buffer, int i, long j) {
        return BoundedBuffer.decorate(buffer, i, j);
    }

    public static Buffer unmodifiableBuffer(Buffer buffer) {
        return UnmodifiableBuffer.decorate(buffer);
    }

    public static Buffer predicatedBuffer(Buffer buffer, Predicate predicate) {
        return PredicatedBuffer.decorate(buffer, predicate);
    }

    public static Buffer typedBuffer(Buffer buffer, Class cls) {
        return TypedBuffer.decorate(buffer, cls);
    }

    public static Buffer transformedBuffer(Buffer buffer, Transformer transformer) {
        return TransformedBuffer.decorate(buffer, transformer);
    }
}
