package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;
    public final String codecs;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        try {
            parsableByteArray.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i = 0;
            for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                parsableByteArray.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i += readUnsignedShort2 + 4;
                    parsableByteArray.skipBytes(readUnsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i];
            int i4 = 0;
            String str = null;
            for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 127;
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                for (int i6 = 0; i6 < readUnsignedShort3; i6++) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, i4, NalUnitUtil.NAL_START_CODE.length);
                    int length = i4 + NalUnitUtil.NAL_START_CODE.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    if (readUnsignedByte3 == 33 && i6 == 0) {
                        str = CodecSpecificDataUtil.buildHevcCodecStringFromSps(new ParsableNalUnitBitArray(bArr, length, length + readUnsignedShort4));
                    }
                    i4 = length + readUnsignedShort4;
                    parsableByteArray.skipBytes(readUnsignedShort4);
                }
            }
            return new HevcConfig(i == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing HEVC config", e);
        }
    }

    private HevcConfig(List<byte[]> list, int i, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.codecs = str;
    }
}
