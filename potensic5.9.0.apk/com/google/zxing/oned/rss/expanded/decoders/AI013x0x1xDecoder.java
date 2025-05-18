package com.google.zxing.oned.rss.expanded.decoders;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes2.dex */
final class AI013x0x1xDecoder extends AI01weightDecoder {
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final String dateCode;
    private final String firstAIdigits;

    AI013x0x1xDecoder(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.dateCode = str2;
        this.firstAIdigits = str;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        encodeCompressedGtin(sb, 8);
        encodeCompressedWeight(sb, 48, 20);
        encodeCompressedDate(sb, 68);
        return sb.toString();
    }

    private void encodeCompressedDate(StringBuilder sb, int i) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i, 16);
        if (extractNumericValueFromBitArray == 38400) {
            return;
        }
        sb.append(PropertyUtils.MAPPED_DELIM);
        sb.append(this.dateCode);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        int i2 = extractNumericValueFromBitArray % 32;
        int i3 = extractNumericValueFromBitArray / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder sb, int i) {
        sb.append(PropertyUtils.MAPPED_DELIM);
        sb.append(this.firstAIdigits);
        sb.append(i / AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
        sb.append(PropertyUtils.MAPPED_DELIM2);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i) {
        return i % AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
    }
}