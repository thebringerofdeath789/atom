package jxl.biff.drawing;

import common.Logger;

/* loaded from: classes4.dex */
class ClientData extends EscherAtom {
    static /* synthetic */ Class class$jxl$biff$drawing$ClientData;
    private static Logger logger;
    private byte[] data;

    static {
        Class cls = class$jxl$biff$drawing$ClientData;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.ClientData");
            class$jxl$biff$drawing$ClientData = cls;
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

    public ClientData(EscherRecordData escherRecordData) {
        super(escherRecordData);
    }

    public ClientData() {
        super(EscherRecordType.CLIENT_DATA);
    }

    @Override // jxl.biff.drawing.EscherAtom, jxl.biff.drawing.EscherRecord
    byte[] getData() {
        byte[] bArr = new byte[0];
        this.data = bArr;
        return setHeaderData(bArr);
    }
}
