package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public abstract class HeaderFooterBase extends StandardRecord {
    private boolean field_2_hasMultibyte;
    private String field_3_text;

    protected HeaderFooterBase(String str) {
        setText(str);
    }

    protected HeaderFooterBase(RecordInputStream recordInputStream) {
        if (recordInputStream.remaining() > 0) {
            short readShort = recordInputStream.readShort();
            boolean z = recordInputStream.readByte() != 0;
            this.field_2_hasMultibyte = z;
            if (z) {
                this.field_3_text = recordInputStream.readUnicodeLEString(readShort);
                return;
            } else {
                this.field_3_text = recordInputStream.readCompressedUnicode(readShort);
                return;
            }
        }
        this.field_3_text = "";
    }

    public final void setText(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text must not be null");
        }
        this.field_2_hasMultibyte = StringUtil.hasMultibyte(str);
        this.field_3_text = str;
        if (getDataSize() > 8224) {
            throw new IllegalArgumentException("Header/Footer string too long (limit is 8224 bytes)");
        }
    }

    private int getTextLength() {
        return this.field_3_text.length();
    }

    public final String getText() {
        return this.field_3_text;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final void serialize(LittleEndianOutput littleEndianOutput) {
        if (getTextLength() > 0) {
            littleEndianOutput.writeShort(getTextLength());
            littleEndianOutput.writeByte(this.field_2_hasMultibyte ? 1 : 0);
            if (this.field_2_hasMultibyte) {
                StringUtil.putUnicodeLE(this.field_3_text, littleEndianOutput);
            } else {
                StringUtil.putCompressedUnicode(this.field_3_text, littleEndianOutput);
            }
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected final int getDataSize() {
        if (getTextLength() < 1) {
            return 0;
        }
        return (getTextLength() * (this.field_2_hasMultibyte ? 2 : 1)) + 3;
    }
}
