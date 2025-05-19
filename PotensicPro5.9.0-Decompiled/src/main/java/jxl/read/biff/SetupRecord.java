package jxl.read.biff;

import jxl.biff.DoubleHelper;
import jxl.biff.IntegerHelper;
import jxl.biff.RecordData;
import jxl.biff.Type;

/* loaded from: classes4.dex */
public class SetupRecord extends RecordData {
    private int copies;
    private byte[] data;
    private int fitHeight;
    private int fitWidth;
    private double footerMargin;
    private double headerMargin;
    private int horizontalPrintResolution;
    private int pageStart;
    private int paperSize;
    private boolean portraitOrientation;
    private int scaleFactor;
    private int verticalPrintResolution;

    SetupRecord(Record record) {
        super(Type.SETUP);
        byte[] data = record.getData();
        this.data = data;
        this.paperSize = IntegerHelper.getInt(data[0], data[1]);
        byte[] bArr = this.data;
        this.scaleFactor = IntegerHelper.getInt(bArr[2], bArr[3]);
        byte[] bArr2 = this.data;
        this.pageStart = IntegerHelper.getInt(bArr2[4], bArr2[5]);
        byte[] bArr3 = this.data;
        this.fitWidth = IntegerHelper.getInt(bArr3[6], bArr3[7]);
        byte[] bArr4 = this.data;
        this.fitHeight = IntegerHelper.getInt(bArr4[8], bArr4[9]);
        byte[] bArr5 = this.data;
        this.horizontalPrintResolution = IntegerHelper.getInt(bArr5[12], bArr5[13]);
        byte[] bArr6 = this.data;
        this.verticalPrintResolution = IntegerHelper.getInt(bArr6[14], bArr6[15]);
        byte[] bArr7 = this.data;
        this.copies = IntegerHelper.getInt(bArr7[32], bArr7[33]);
        this.headerMargin = DoubleHelper.getIEEEDouble(this.data, 16);
        this.footerMargin = DoubleHelper.getIEEEDouble(this.data, 24);
        byte[] bArr8 = this.data;
        this.portraitOrientation = (IntegerHelper.getInt(bArr8[10], bArr8[11]) & 2) != 0;
    }

    public boolean isPortrait() {
        return this.portraitOrientation;
    }

    public double getHeaderMargin() {
        return this.headerMargin;
    }

    public double getFooterMargin() {
        return this.footerMargin;
    }

    public int getPaperSize() {
        return this.paperSize;
    }

    public int getScaleFactor() {
        return this.scaleFactor;
    }

    public int getPageStart() {
        return this.pageStart;
    }

    public int getFitWidth() {
        return this.fitWidth;
    }

    public int getFitHeight() {
        return this.fitHeight;
    }

    public int getHorizontalPrintResolution() {
        return this.horizontalPrintResolution;
    }

    public int getVerticalPrintResolution() {
        return this.verticalPrintResolution;
    }

    public int getCopies() {
        return this.copies;
    }
}
