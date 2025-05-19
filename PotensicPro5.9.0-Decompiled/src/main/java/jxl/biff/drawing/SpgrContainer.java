package jxl.biff.drawing;

import common.Logger;

/* loaded from: classes4.dex */
class SpgrContainer extends EscherContainer {
    static /* synthetic */ Class class$jxl$biff$drawing$SpgrContainer;
    private static final Logger logger;

    static {
        Class cls = class$jxl$biff$drawing$SpgrContainer;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.SpgrContainer");
            class$jxl$biff$drawing$SpgrContainer = cls;
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

    public SpgrContainer() {
        super(EscherRecordType.SPGR_CONTAINER);
    }

    public SpgrContainer(EscherRecordData escherRecordData) {
        super(escherRecordData);
    }
}
