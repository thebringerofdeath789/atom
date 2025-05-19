package io.netty.handler.codec.compression;

/* loaded from: classes.dex */
final class FastLz {
    static final byte BLOCK_TYPE_COMPRESSED = 1;
    static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
    static final byte BLOCK_WITHOUT_CHECKSUM = 0;
    static final byte BLOCK_WITH_CHECKSUM = 16;
    static final int CHECKSUM_OFFSET = 4;
    private static final int HASH_LOG = 13;
    private static final int HASH_MASK = 8191;
    private static final int HASH_SIZE = 8192;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final int LEVEL_AUTO = 0;
    static final int MAGIC_NUMBER = 4607066;
    static final int MAX_CHUNK_LENGTH = 65535;
    private static final int MAX_COPY = 32;
    private static final int MAX_DISTANCE = 8191;
    private static final int MAX_FARDISTANCE = 73725;
    private static final int MAX_LEN = 264;
    static final int MIN_LENGTH_TO_COMPRESSION = 32;
    private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
    static final int OPTIONS_OFFSET = 3;

    static int calculateOutputBufferLength(int i) {
        return Math.max((int) (i * 1.06d), 66);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int compress(byte[] r27, int r28, int r29, byte[] r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 913
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLz.compress(byte[], int, int, byte[], int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int decompress(byte[] r29, int r30, int r31, byte[] r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLz.decompress(byte[], int, int, byte[], int, int):int");
    }

    private static int hashFunction(byte[] bArr, int i) {
        int readU16 = readU16(bArr, i);
        return ((readU16(bArr, i + 1) ^ (readU16 >> 3)) ^ readU16) & 8191;
    }

    private static int readU16(byte[] bArr, int i) {
        int i2 = i + 1;
        if (i2 >= bArr.length) {
            return bArr[i] & 255;
        }
        return (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
    }

    private FastLz() {
    }
}
