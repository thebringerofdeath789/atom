package jxl.biff.drawing;

import common.Logger;

/* loaded from: classes4.dex */
class ClientTextBox extends EscherAtom {
    static /* synthetic */ Class class$jxl$biff$drawing$ClientTextBox;
    private static Logger logger;
    private byte[] data;

    static {
        Class cls = class$jxl$biff$drawing$ClientTextBox;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.ClientTextBox");
            class$jxl$biff$drawing$ClientTextBox = cls;
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

    public ClientTextBox(EscherRecordData escherRecordData) {
        super(escherRecordData);
    }

    public ClientTextBox() {
        super(EscherRecordType.CLIENT_TEXT_BOX);
    }

    @Override // jxl.biff.drawing.EscherAtom, jxl.biff.drawing.EscherRecord
    byte[] getData() {
        byte[] bArr = new byte[0];
        this.data = bArr;
        return setHeaderData(bArr);
    }
}
