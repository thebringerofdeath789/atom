package jxl.biff.drawing;

import common.Logger;
import jxl.biff.IntegerHelper;

/* loaded from: classes4.dex */
class Sp extends EscherAtom {
    static /* synthetic */ Class class$jxl$biff$drawing$Sp;
    private static Logger logger;
    private byte[] data;
    private int persistenceFlags;
    private int shapeId;
    private int shapeType;

    static {
        Class cls = class$jxl$biff$drawing$Sp;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.Sp");
            class$jxl$biff$drawing$Sp = cls;
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

    public Sp(EscherRecordData escherRecordData) {
        super(escherRecordData);
        this.shapeType = getInstance();
        byte[] bytes = getBytes();
        this.shapeId = IntegerHelper.getInt(bytes[0], bytes[1], bytes[2], bytes[3]);
        this.persistenceFlags = IntegerHelper.getInt(bytes[4], bytes[5], bytes[6], bytes[7]);
    }

    public Sp(ShapeType shapeType, int i, int i2) {
        super(EscherRecordType.SP);
        setVersion(2);
        int value = shapeType.getValue();
        this.shapeType = value;
        this.shapeId = i;
        this.persistenceFlags = i2;
        setInstance(value);
    }

    int getShapeId() {
        return this.shapeId;
    }

    int getShapeType() {
        return this.shapeType;
    }

    @Override // jxl.biff.drawing.EscherAtom, jxl.biff.drawing.EscherRecord
    byte[] getData() {
        byte[] bArr = new byte[8];
        this.data = bArr;
        IntegerHelper.getFourBytes(this.shapeId, bArr, 0);
        IntegerHelper.getFourBytes(this.persistenceFlags, this.data, 4);
        return setHeaderData(this.data);
    }
}
