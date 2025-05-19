package org.apache.poi.xssf.usermodel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;

/* loaded from: classes5.dex */
public class XSSFColor implements Color {
    private CTColor ctColor;

    private static byte applyTint(int i, double d) {
        double d2;
        if (d > 0.0d) {
            double d3 = 1.0d - d;
            d2 = (i * d3) + (255.0d - (d3 * 255.0d));
        } else {
            if (d >= 0.0d) {
                return (byte) i;
            }
            d2 = i * (d + 1.0d);
        }
        return (byte) d2;
    }

    public XSSFColor(CTColor cTColor) {
        this.ctColor = cTColor;
    }

    public XSSFColor() {
        this.ctColor = CTColor.Factory.newInstance();
    }

    public XSSFColor(java.awt.Color color) {
        this();
        this.ctColor.setRgb(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
    }

    public XSSFColor(byte[] bArr) {
        this();
        this.ctColor.setRgb(bArr);
    }

    public boolean isAuto() {
        return this.ctColor.getAuto();
    }

    public void setAuto(boolean z) {
        this.ctColor.setAuto(z);
    }

    public short getIndexed() {
        return (short) this.ctColor.getIndexed();
    }

    public void setIndexed(int i) {
        this.ctColor.setIndexed(i);
    }

    public byte[] getRgb() {
        byte[] rGBOrARGB = getRGBOrARGB();
        if (rGBOrARGB == null) {
            return null;
        }
        if (rGBOrARGB.length != 4) {
            return rGBOrARGB;
        }
        byte[] bArr = new byte[3];
        System.arraycopy(rGBOrARGB, 1, bArr, 0, 3);
        return bArr;
    }

    public byte[] getARgb() {
        byte[] rGBOrARGB = getRGBOrARGB();
        if (rGBOrARGB == null) {
            return null;
        }
        if (rGBOrARGB.length != 3) {
            return rGBOrARGB;
        }
        byte[] bArr = new byte[4];
        bArr[0] = -1;
        System.arraycopy(rGBOrARGB, 0, bArr, 1, 3);
        return bArr;
    }

    private byte[] getRGBOrARGB() {
        HSSFColor hSSFColor;
        if (this.ctColor.isSetIndexed() && this.ctColor.getIndexed() > 0 && (hSSFColor = HSSFColor.getIndexHash().get(Integer.valueOf((int) this.ctColor.getIndexed()))) != null) {
            return new byte[]{(byte) hSSFColor.getTriplet()[0], (byte) hSSFColor.getTriplet()[1], (byte) hSSFColor.getTriplet()[2]};
        }
        if (this.ctColor.isSetRgb()) {
            return this.ctColor.getRgb();
        }
        return null;
    }

    public byte[] getRgbWithTint() {
        byte[] rgb = this.ctColor.getRgb();
        if (rgb != null) {
            if (rgb.length == 4) {
                byte[] bArr = new byte[3];
                System.arraycopy(rgb, 1, bArr, 0, 3);
                rgb = bArr;
            }
            for (int i = 0; i < rgb.length; i++) {
                rgb[i] = applyTint(rgb[i] & 255, this.ctColor.getTint());
            }
        }
        return rgb;
    }

    public String getARGBHex() {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] aRgb = getARgb();
        if (aRgb == 0) {
            return null;
        }
        for (int i : aRgb) {
            if (i < 0) {
                i += 256;
            }
            String hexString = Integer.toHexString(i);
            if (hexString.length() == 1) {
                stringBuffer.append('0');
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public void setRgb(byte[] bArr) {
        this.ctColor.setRgb(bArr);
    }

    public int getTheme() {
        return (int) this.ctColor.getTheme();
    }

    public void setTheme(int i) {
        this.ctColor.setTheme(i);
    }

    public double getTint() {
        return this.ctColor.getTint();
    }

    public void setTint(double d) {
        this.ctColor.setTint(d);
    }

    @Internal
    public CTColor getCTColor() {
        return this.ctColor;
    }

    public int hashCode() {
        return this.ctColor.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof XSSFColor)) {
            return false;
        }
        return this.ctColor.toString().equals(((XSSFColor) obj).getCTColor().toString());
    }
}
