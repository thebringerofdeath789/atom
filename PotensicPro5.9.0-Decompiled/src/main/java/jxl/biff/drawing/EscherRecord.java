package jxl.biff.drawing;

import common.Logger;

/* loaded from: classes4.dex */
abstract class EscherRecord {
    protected static final int HEADER_LENGTH = 8;
    static /* synthetic */ Class class$jxl$biff$drawing$EscherRecord;
    private static Logger logger;
    private EscherRecordData data;

    abstract byte[] getData();

    static {
        Class cls = class$jxl$biff$drawing$EscherRecord;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.EscherRecord");
            class$jxl$biff$drawing$EscherRecord = cls;
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

    protected EscherRecord(EscherRecordData escherRecordData) {
        this.data = escherRecordData;
    }

    protected EscherRecord(EscherRecordType escherRecordType) {
        this.data = new EscherRecordData(escherRecordType);
    }

    protected void setContainer(boolean z) {
        this.data.setContainer(z);
    }

    public int getLength() {
        return this.data.getLength() + 8;
    }

    protected final EscherStream getEscherStream() {
        return this.data.getEscherStream();
    }

    protected final int getPos() {
        return this.data.getPos();
    }

    protected final int getInstance() {
        return this.data.getInstance();
    }

    protected final void setInstance(int i) {
        this.data.setInstance(i);
    }

    protected final void setVersion(int i) {
        this.data.setVersion(i);
    }

    public EscherRecordType getType() {
        return this.data.getType();
    }

    final byte[] setHeaderData(byte[] bArr) {
        return this.data.setHeaderData(bArr);
    }

    byte[] getBytes() {
        return this.data.getBytes();
    }

    protected int getStreamLength() {
        return this.data.getStreamLength();
    }

    protected EscherRecordData getEscherData() {
        return this.data;
    }
}
