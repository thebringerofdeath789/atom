package jxl.biff.drawing;

import com.ipotensic.baselib.configs.UsbConfig;
import common.Assert;
import common.Logger;
import java.io.IOException;
import jxl.biff.IntegerHelper;

/* loaded from: classes4.dex */
class BlipStoreEntry extends EscherAtom {
    private static final int IMAGE_DATA_OFFSET = 61;
    static /* synthetic */ Class class$jxl$biff$drawing$BlipStoreEntry;
    private static Logger logger;
    private byte[] data;
    private int imageDataLength;
    private int referenceCount;
    private BlipType type;
    private boolean write;

    static {
        Class cls = class$jxl$biff$drawing$BlipStoreEntry;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.BlipStoreEntry");
            class$jxl$biff$drawing$BlipStoreEntry = cls;
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

    public BlipStoreEntry(EscherRecordData escherRecordData) {
        super(escherRecordData);
        this.type = BlipType.getType(getInstance());
        this.write = false;
        byte[] bytes = getBytes();
        this.referenceCount = IntegerHelper.getInt(bytes[24], bytes[25], bytes[26], bytes[27]);
    }

    public BlipStoreEntry(Drawing drawing) throws IOException {
        super(EscherRecordType.BSE);
        this.type = BlipType.PNG;
        setVersion(2);
        setInstance(this.type.getValue());
        byte[] imageBytes = drawing.getImageBytes();
        int length = imageBytes.length;
        this.imageDataLength = length;
        byte[] bArr = new byte[length + 61];
        this.data = bArr;
        System.arraycopy(imageBytes, 0, bArr, 61, length);
        this.referenceCount = drawing.getReferenceCount();
        this.write = true;
    }

    public BlipType getBlipType() {
        return this.type;
    }

    @Override // jxl.biff.drawing.EscherAtom, jxl.biff.drawing.EscherRecord
    public byte[] getData() {
        if (this.write) {
            this.data[0] = (byte) this.type.getValue();
            this.data[1] = (byte) this.type.getValue();
            IntegerHelper.getFourBytes(this.imageDataLength + 8 + 17, this.data, 20);
            IntegerHelper.getFourBytes(this.referenceCount, this.data, 24);
            IntegerHelper.getFourBytes(0, this.data, 28);
            byte[] bArr = this.data;
            bArr[32] = 0;
            bArr[33] = 0;
            bArr[34] = UsbConfig.SEND_FUNCTION_CODE_REMOTE_CONTROL;
            bArr[35] = 1;
            bArr[36] = 0;
            bArr[37] = 110;
            IntegerHelper.getTwoBytes(61470, bArr, 38);
            IntegerHelper.getFourBytes(this.imageDataLength + 17, this.data, 40);
        } else {
            this.data = getBytes();
        }
        return setHeaderData(this.data);
    }

    void dereference() {
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        Assert.verify(i >= 0);
    }

    int getReferenceCount() {
        return this.referenceCount;
    }

    byte[] getImageData() {
        byte[] bytes = getBytes();
        int length = bytes.length - 61;
        byte[] bArr = new byte[length];
        System.arraycopy(bytes, 61, bArr, 0, length);
        return bArr;
    }
}
