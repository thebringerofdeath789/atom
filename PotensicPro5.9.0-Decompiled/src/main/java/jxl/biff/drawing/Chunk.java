package jxl.biff.drawing;

/* loaded from: classes4.dex */
class Chunk {
    private byte[] data;
    private int length;
    private int pos;
    private ChunkType type;

    public Chunk(int i, int i2, ChunkType chunkType, byte[] bArr) {
        this.pos = i;
        this.length = i2;
        this.type = chunkType;
        byte[] bArr2 = new byte[i2];
        this.data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public byte[] getData() {
        return this.data;
    }
}
