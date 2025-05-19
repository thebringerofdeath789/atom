package jxl.biff.drawing;

import common.Logger;

/* loaded from: classes4.dex */
class EscherAtom extends EscherRecord {
    static /* synthetic */ Class class$jxl$biff$drawing$EscherAtom;
    private static Logger logger;

    static {
        Class cls = class$jxl$biff$drawing$EscherAtom;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.EscherAtom");
            class$jxl$biff$drawing$EscherAtom = cls;
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

    public EscherAtom(EscherRecordData escherRecordData) {
        super(escherRecordData);
    }

    protected EscherAtom(EscherRecordType escherRecordType) {
        super(escherRecordType);
    }

    @Override // jxl.biff.drawing.EscherRecord
    byte[] getData() {
        logger.warn(new StringBuffer().append("escher atom getData called on object of type ").append(getClass().getName()).append(" code ").append(Integer.toString(getType().getValue(), 16)).toString());
        return null;
    }
}
