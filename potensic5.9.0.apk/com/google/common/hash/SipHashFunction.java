package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
/* loaded from: classes2.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f1994c;

    /* renamed from: d */
    private final int f1995d;

    /* renamed from: k0 */
    private final long f1996k0;

    /* renamed from: k1 */
    private final long f1997k1;

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    SipHashFunction(int i, int i2, long j, long j2) {
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f1994c = i;
        this.f1995d = i2;
        this.f1996k0 = j;
        this.f1997k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f1994c, this.f1995d, this.f1996k0, this.f1997k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f1994c + "" + this.f1995d + "(" + this.f1996k0 + ", " + this.f1997k1 + ")";
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.f1994c == sipHashFunction.f1994c && this.f1995d == sipHashFunction.f1995d && this.f1996k0 == sipHashFunction.f1996k0 && this.f1997k1 == sipHashFunction.f1997k1;
    }

    public int hashCode() {
        return (int) ((((getClass().hashCode() ^ this.f1994c) ^ this.f1995d) ^ this.f1996k0) ^ this.f1997k1);
    }

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b */
        private long f1998b;

        /* renamed from: c */
        private final int f1999c;

        /* renamed from: d */
        private final int f2000d;
        private long finalM;

        /* renamed from: v0 */
        private long f2001v0;

        /* renamed from: v1 */
        private long f2002v1;

        /* renamed from: v2 */
        private long f2003v2;

        /* renamed from: v3 */
        private long f2004v3;

        SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f2001v0 = 8317987319222330741L;
            this.f2002v1 = 7237128888997146477L;
            this.f2003v2 = 7816392313619706465L;
            this.f2004v3 = 8387220255154660723L;
            this.f1998b = 0L;
            this.finalM = 0L;
            this.f1999c = i;
            this.f2000d = i2;
            this.f2001v0 = 8317987319222330741L ^ j;
            this.f2002v1 = 7237128888997146477L ^ j2;
            this.f2003v2 = 7816392313619706465L ^ j;
            this.f2004v3 = 8387220255154660723L ^ j2;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            this.f1998b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            this.f1998b += byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (byteBuffer.get() & 255) << i;
                i += 8;
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j = this.finalM ^ (this.f1998b << 56);
            this.finalM = j;
            processM(j);
            this.f2003v2 ^= 255;
            sipRound(this.f2000d);
            return HashCode.fromLong(((this.f2001v0 ^ this.f2002v1) ^ this.f2003v2) ^ this.f2004v3);
        }

        private void processM(long j) {
            this.f2004v3 ^= j;
            sipRound(this.f1999c);
            this.f2001v0 = j ^ this.f2001v0;
        }

        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f2001v0;
                long j2 = this.f2002v1;
                this.f2001v0 = j + j2;
                this.f2003v2 += this.f2004v3;
                this.f2002v1 = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.f2004v3, 16);
                this.f2004v3 = rotateLeft;
                long j3 = this.f2002v1;
                long j4 = this.f2001v0;
                this.f2002v1 = j3 ^ j4;
                this.f2004v3 = rotateLeft ^ this.f2003v2;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.f2001v0 = rotateLeft2;
                long j5 = this.f2003v2;
                long j6 = this.f2002v1;
                this.f2003v2 = j5 + j6;
                this.f2001v0 = rotateLeft2 + this.f2004v3;
                this.f2002v1 = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.f2004v3, 21);
                this.f2004v3 = rotateLeft3;
                long j7 = this.f2002v1;
                long j8 = this.f2003v2;
                this.f2002v1 = j7 ^ j8;
                this.f2004v3 = rotateLeft3 ^ this.f2001v0;
                this.f2003v2 = Long.rotateLeft(j8, 32);
            }
        }
    }
}