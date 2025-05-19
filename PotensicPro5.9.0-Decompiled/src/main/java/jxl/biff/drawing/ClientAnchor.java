package jxl.biff.drawing;

import common.Logger;
import jxl.biff.IntegerHelper;

/* loaded from: classes4.dex */
class ClientAnchor extends EscherAtom {
    static /* synthetic */ Class class$jxl$biff$drawing$ClientAnchor;
    private static final Logger logger;
    private byte[] data;
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    static {
        Class cls = class$jxl$biff$drawing$ClientAnchor;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.ClientAnchor");
            class$jxl$biff$drawing$ClientAnchor = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public ClientAnchor(EscherRecordData escherRecordData) {
        super(escherRecordData);
        byte[] bytes = getBytes();
        this.x1 = IntegerHelper.getInt(bytes[2], bytes[3]) + (IntegerHelper.getInt(bytes[4], bytes[5]) / 1024.0d);
        this.y1 = IntegerHelper.getInt(bytes[6], bytes[7]) + (IntegerHelper.getInt(bytes[8], bytes[9]) / 256.0d);
        this.x2 = IntegerHelper.getInt(bytes[10], bytes[11]) + (IntegerHelper.getInt(bytes[12], bytes[13]) / 1024.0d);
        this.y2 = IntegerHelper.getInt(bytes[14], bytes[15]) + (IntegerHelper.getInt(bytes[16], bytes[17]) / 256.0d);
    }

    public ClientAnchor(double d, double d2, double d3, double d4) {
        super(EscherRecordType.CLIENT_ANCHOR);
        this.x1 = d;
        this.y1 = d2;
        this.x2 = d3;
        this.y2 = d4;
    }

    @Override // jxl.biff.drawing.EscherAtom, jxl.biff.drawing.EscherRecord
    byte[] getData() {
        byte[] bArr = new byte[18];
        this.data = bArr;
        IntegerHelper.getTwoBytes(1, bArr, 0);
        IntegerHelper.getTwoBytes((int) this.x1, this.data, 2);
        IntegerHelper.getTwoBytes((int) ((this.x1 - ((int) r0)) * 1024.0d), this.data, 4);
        IntegerHelper.getTwoBytes((int) this.y1, this.data, 6);
        IntegerHelper.getTwoBytes((int) ((this.y1 - ((int) r0)) * 256.0d), this.data, 8);
        IntegerHelper.getTwoBytes((int) this.x2, this.data, 10);
        IntegerHelper.getTwoBytes((int) ((this.x2 - ((int) r0)) * 1024.0d), this.data, 12);
        IntegerHelper.getTwoBytes((int) this.y2, this.data, 14);
        IntegerHelper.getTwoBytes((int) ((this.y2 - ((int) r0)) * 256.0d), this.data, 16);
        return setHeaderData(this.data);
    }

    double getX1() {
        return this.x1;
    }

    double getY1() {
        return this.y1;
    }

    double getX2() {
        return this.x2;
    }

    double getY2() {
        return this.y2;
    }
}
