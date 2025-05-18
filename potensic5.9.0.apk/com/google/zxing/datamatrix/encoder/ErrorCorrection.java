package com.google.zxing.datamatrix.encoder;

import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.nntp.NNTPReply;
import org.apache.commons.net.telnet.TelnetCommand;
import org.apache.poi.hssf.record.UnknownRecord;

/* loaded from: classes2.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, NNTPReply.ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY, TelnetCommand.f4276EL, 116, 255, 110, 61}, new int[]{175, 138, NNTPReply.CLOSING_CONNECTION, 12, 194, 168, 39, TelnetCommand.f4272AO, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, FTPReply.FILE_STATUS, 97, 178, 100, 242}, new int[]{156, 97, 192, TelnetCommand.WONT, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, TelnetCommand.NOP, FTPReply.FILE_STATUS, 109, 129, 94, 254, FTPReply.DATA_CONNECTION_OPEN, 48, 90, 188}, new int[]{15, 195, 244, 9, UnknownRecord.BITMAP_00E9, 71, 168, 2, 188, 160, 153, 145, TelnetCommand.f4274DO, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, NNTPReply.CLOSING_CONNECTION, 109, 39, 176, 21, 155, 197, 251, NNTPReply.ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, NNTPReply.NEW_NEWSGROUP_LIST_FOLLOWS, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, TelnetCommand.f4277GA, 121, 17, 138, 110, FTPReply.FILE_STATUS, 141, 136, 120, 151, UnknownRecord.BITMAP_00E9, 168, 93, 255}, new int[]{TelnetCommand.f4272AO, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, FTPReply.ENTERING_EPSV_MODE, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, FTPReply.DATA_CONNECTION_OPEN, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, TelnetCommand.f4275EC, 105, 122, 2, TelnetCommand.f4272AO, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, TelnetCommand.f4274DO, 57, 54, 101, TelnetCommand.f4276EL, 202, 69, 50, 150, 177, FTPReply.CLOSING_DATA_CONNECTION, 5, 9, 5}, new int[]{TelnetCommand.f4272AO, 132, 172, NNTPReply.ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY, 96, 32, 117, 22, TelnetCommand.ABORT, 133, TelnetCommand.ABORT, NNTPReply.NEW_NEWSGROUP_LIST_FOLLOWS, NNTPReply.CLOSING_CONNECTION, 188, TelnetCommand.SUSP, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, NNTPReply.CLOSING_CONNECTION, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, FTPReply.FILE_STATUS, 92, TelnetCommand.f4274DO, FTPReply.DATA_CONNECTION_OPEN, 19}, new int[]{175, 9, NNTPReply.ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY, TelnetCommand.ABORT, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, FTPReply.NAME_SYSTEM_TYPE, 235, 150, 159, 36, NNTPReply.ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY, 38, 200, 132, 54, 228, 146, 218, FTPReply.SECURITY_DATA_EXCHANGE_COMPLETE, 117, 203, 29, 232, 144, TelnetCommand.ABORT, 22, 150, 201, 117, 62, 207, 164, 13, 137, TelnetCommand.f4272AO, 127, 67, TelnetCommand.f4275EC, 28, 155, 43, 203, 107, UnknownRecord.BITMAP_00E9, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, TelnetCommand.f4272AO, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, FTPReply.FILE_STATUS, 136, TelnetCommand.f4276EL, 180, FTPReply.SECURITY_DATA_EXCHANGE_COMPLETE, 197, 158, 177, 68, 122, 93, FTPReply.FILE_STATUS, 15, 160, FTPReply.ENTERING_PASSIVE_MODE, TelnetCommand.EOF, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, NNTPReply.NEW_NEWSGROUP_LIST_FOLLOWS, 136, NNTPReply.ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY, 239, 181, TelnetCommand.NOP, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String createECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = 0;
                int i6 = i3;
                while (i6 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i6, createECCBlock.charAt(i5));
                    i6 += interleavedBlockCount;
                    i5++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i2 >= iArr.length) {
                i2 = -1;
                break;
            }
            if (iArr[i2] == i) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i)));
        }
        int[] iArr2 = FACTORS[i2];
        char[] cArr = new char[i];
        for (int i3 = 0; i3 < i; i3++) {
            cArr[i3] = 0;
        }
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            int i5 = i - 1;
            int charAt = cArr[i5] ^ charSequence.charAt(i4);
            while (i5 > 0) {
                if (charAt != 0 && iArr2[i5] != 0) {
                    char c = cArr[i5 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i5] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i5]]) % 255]);
                } else {
                    cArr[i5] = cArr[i5 - 1];
                }
                i5--;
            }
            if (charAt != 0 && iArr2[0] != 0) {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i];
        for (int i6 = 0; i6 < i; i6++) {
            cArr2[i6] = cArr[(i - i6) - 1];
        }
        return String.valueOf(cArr2);
    }
}