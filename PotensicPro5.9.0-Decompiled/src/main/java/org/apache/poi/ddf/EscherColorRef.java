package org.apache.poi.ddf;

import androidx.core.view.MotionEventCompat;
import org.apache.commons.net.telnet.TelnetCommand;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public class EscherColorRef {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int colorRef;
    int opid;
    private static final BitField FLAG_SYS_INDEX = new BitField(268435456);
    private static final BitField FLAG_SCHEME_INDEX = new BitField(134217728);
    private static final BitField FLAG_SYSTEM_RGB = new BitField(67108864);
    private static final BitField FLAG_PALETTE_RGB = new BitField(33554432);
    private static final BitField FLAG_PALETTE_INDEX = new BitField(16777216);
    private static final BitField FLAG_BLUE = new BitField(16711680);
    private static final BitField FLAG_GREEN = new BitField(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    private static final BitField FLAG_RED = new BitField(255);

    public enum SysIndexSource {
        FILL_COLOR(240),
        LINE_OR_FILL_COLOR(TelnetCommand.NOP),
        LINE_COLOR(242),
        SHADOW_COLOR(TelnetCommand.BREAK),
        CURRENT_OR_LAST_COLOR(244),
        FILL_BACKGROUND_COLOR(TelnetCommand.AO),
        LINE_BACKGROUND_COLOR(TelnetCommand.AYT),
        FILL_OR_LINE_COLOR(TelnetCommand.EC);

        int value;

        SysIndexSource(int i) {
            this.value = i;
        }
    }

    public enum SysIndexProcedure {
        DARKEN_COLOR(1),
        LIGHTEN_COLOR(2),
        ADD_GRAY_LEVEL(3),
        SUB_GRAY_LEVEL(4),
        REVERSE_GRAY_LEVEL(5),
        THRESHOLD(6),
        INVERT_AFTER(32),
        INVERT_HIGHBIT_AFTER(64);

        BitField mask;

        SysIndexProcedure(int i) {
            this.mask = new BitField(i);
        }
    }

    public EscherColorRef(int i) {
        this.opid = -1;
        this.colorRef = 0;
        this.colorRef = i;
    }

    public EscherColorRef(byte[] bArr, int i, int i2) {
        this.opid = -1;
        this.colorRef = 0;
        if (i2 == 6) {
            this.opid = LittleEndian.getUShort(bArr, i);
            i += 2;
        }
        this.colorRef = LittleEndian.getInt(bArr, i);
    }

    public boolean hasSysIndexFlag() {
        return FLAG_SYS_INDEX.isSet(this.colorRef);
    }

    public void setSysIndexFlag(boolean z) {
        FLAG_SYS_INDEX.setBoolean(this.colorRef, z);
    }

    public boolean hasSchemeIndexFlag() {
        return FLAG_SCHEME_INDEX.isSet(this.colorRef);
    }

    public void setSchemeIndexFlag(boolean z) {
        FLAG_SCHEME_INDEX.setBoolean(this.colorRef, z);
    }

    public boolean hasSystemRGBFlag() {
        return FLAG_SYSTEM_RGB.isSet(this.colorRef);
    }

    public void setSystemRGBFlag(boolean z) {
        FLAG_SYSTEM_RGB.setBoolean(this.colorRef, z);
    }

    public boolean hasPaletteRGBFlag() {
        return FLAG_PALETTE_RGB.isSet(this.colorRef);
    }

    public void setPaletteRGBFlag(boolean z) {
        FLAG_PALETTE_RGB.setBoolean(this.colorRef, z);
    }

    public boolean hasPaletteIndexFlag() {
        return FLAG_PALETTE_INDEX.isSet(this.colorRef);
    }

    public void setPaletteIndexFlag(boolean z) {
        FLAG_PALETTE_INDEX.setBoolean(this.colorRef, z);
    }

    public int[] getRGB() {
        return new int[]{FLAG_RED.getValue(this.colorRef), FLAG_GREEN.getValue(this.colorRef), FLAG_BLUE.getValue(this.colorRef)};
    }

    public SysIndexSource getSysIndexSource() {
        if (!hasSysIndexFlag()) {
            return null;
        }
        int value = FLAG_RED.getValue(this.colorRef);
        for (SysIndexSource sysIndexSource : SysIndexSource.values()) {
            if (sysIndexSource.value == value) {
                return sysIndexSource;
            }
        }
        return null;
    }

    public SysIndexProcedure getSysIndexProcedure() {
        if (!hasSysIndexFlag()) {
            return null;
        }
        int value = FLAG_RED.getValue(this.colorRef);
        for (SysIndexProcedure sysIndexProcedure : SysIndexProcedure.values()) {
            if (sysIndexProcedure != SysIndexProcedure.INVERT_AFTER && sysIndexProcedure != SysIndexProcedure.INVERT_HIGHBIT_AFTER && sysIndexProcedure.mask.isSet(value)) {
                return sysIndexProcedure;
            }
        }
        return null;
    }

    public int getSysIndexInvert() {
        if (!hasSysIndexFlag()) {
            return 0;
        }
        int value = FLAG_GREEN.getValue(this.colorRef);
        if (SysIndexProcedure.INVERT_AFTER.mask.isSet(value)) {
            return 1;
        }
        return SysIndexProcedure.INVERT_HIGHBIT_AFTER.mask.isSet(value) ? 2 : 0;
    }

    public int getSchemeIndex() {
        if (hasSchemeIndexFlag()) {
            return FLAG_RED.getValue(this.colorRef);
        }
        return -1;
    }

    public int getPaletteIndex() {
        if (hasPaletteIndexFlag()) {
            return (FLAG_GREEN.getValue(this.colorRef) << 8) & FLAG_RED.getValue(this.colorRef);
        }
        return -1;
    }
}
