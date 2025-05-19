package jxl.write.biff;

import common.Assert;
import common.Logger;
import jxl.WorkbookSettings;
import jxl.biff.EncodedURLHelper;
import jxl.biff.IntegerHelper;
import jxl.biff.StringHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class SupbookRecord extends WritableRecordData {
    public static final SupbookType ADDIN;
    public static final SupbookType EXTERNAL;
    public static final SupbookType INTERNAL;
    public static final SupbookType LINK;
    public static final SupbookType UNKNOWN;
    static /* synthetic */ Class class$jxl$write$biff$SupbookRecord;
    private static Logger logger;
    private byte[] data;
    private String fileName;
    private int numSheets;
    private String[] sheetNames;
    private SupbookType type;
    private WorkbookSettings workbookSettings;

    static {
        Class cls = class$jxl$write$biff$SupbookRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.SupbookRecord");
            class$jxl$write$biff$SupbookRecord = cls;
        }
        logger = Logger.getLogger(cls);
        INTERNAL = new SupbookType();
        EXTERNAL = new SupbookType();
        ADDIN = new SupbookType();
        LINK = new SupbookType();
        UNKNOWN = new SupbookType();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class SupbookType {
        private SupbookType() {
        }
    }

    public SupbookRecord() {
        super(Type.SUPBOOK);
        this.type = ADDIN;
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SupbookRecord(int i, WorkbookSettings workbookSettings) {
        super(Type.SUPBOOK);
        this.numSheets = i;
        this.type = INTERNAL;
        this.workbookSettings = workbookSettings;
    }

    public SupbookRecord(String str, WorkbookSettings workbookSettings) {
        super(Type.SUPBOOK);
        this.fileName = str;
        this.numSheets = 1;
        this.sheetNames = new String[0];
        this.workbookSettings = workbookSettings;
        this.type = EXTERNAL;
    }

    public SupbookRecord(jxl.read.biff.SupbookRecord supbookRecord, WorkbookSettings workbookSettings) {
        super(Type.SUPBOOK);
        this.workbookSettings = workbookSettings;
        if (supbookRecord.getType() == jxl.read.biff.SupbookRecord.INTERNAL) {
            this.type = INTERNAL;
            this.numSheets = supbookRecord.getNumberOfSheets();
        } else if (supbookRecord.getType() == jxl.read.biff.SupbookRecord.EXTERNAL) {
            this.type = EXTERNAL;
            this.numSheets = supbookRecord.getNumberOfSheets();
            this.fileName = supbookRecord.getFileName();
            this.sheetNames = new String[this.numSheets];
            for (int i = 0; i < this.numSheets; i++) {
                this.sheetNames[i] = supbookRecord.getSheetName(i);
            }
        }
        if (supbookRecord.getType() == jxl.read.biff.SupbookRecord.ADDIN) {
            logger.warn("Supbook type is addin");
        }
    }

    private void initInternal(jxl.read.biff.SupbookRecord supbookRecord) {
        this.numSheets = supbookRecord.getNumberOfSheets();
        initInternal();
    }

    private void initInternal() {
        byte[] bArr = new byte[4];
        this.data = bArr;
        IntegerHelper.getTwoBytes(this.numSheets, bArr, 0);
        byte[] bArr2 = this.data;
        bArr2[2] = 1;
        bArr2[3] = 4;
        this.type = INTERNAL;
    }

    void adjustInternal(int i) {
        Assert.verify(this.type == INTERNAL);
        this.numSheets = i;
        initInternal();
    }

    private void initExternal() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.numSheets; i3++) {
            i2 += this.sheetNames[i3].length();
        }
        byte[] encodedURL = EncodedURLHelper.getEncodedURL(this.fileName, this.workbookSettings);
        int length = encodedURL.length + 6;
        int i4 = this.numSheets;
        byte[] bArr = new byte[length + (i4 * 3) + (i2 * 2)];
        this.data = bArr;
        IntegerHelper.getTwoBytes(i4, bArr, 0);
        IntegerHelper.getTwoBytes(encodedURL.length + 1, this.data, 2);
        byte[] bArr2 = this.data;
        bArr2[4] = 0;
        bArr2[5] = 1;
        System.arraycopy(encodedURL, 0, bArr2, 6, encodedURL.length);
        int length2 = encodedURL.length + 4 + 2;
        while (true) {
            String[] strArr = this.sheetNames;
            if (i >= strArr.length) {
                return;
            }
            IntegerHelper.getTwoBytes(strArr[i].length(), this.data, length2);
            byte[] bArr3 = this.data;
            bArr3[length2 + 2] = 1;
            StringHelper.getUnicodeBytes(this.sheetNames[i], bArr3, length2 + 3);
            length2 += (this.sheetNames[i].length() * 2) + 3;
            i++;
        }
    }

    private void initAddin() {
        this.data = new byte[]{1, 0, 1, 58};
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        SupbookType supbookType = this.type;
        if (supbookType == INTERNAL) {
            initInternal();
        } else if (supbookType == EXTERNAL) {
            initExternal();
        } else if (supbookType == ADDIN) {
            initAddin();
        } else {
            logger.warn("unsupported supbook type - defaulting to internal");
            initInternal();
        }
        return this.data;
    }

    public SupbookType getType() {
        return this.type;
    }

    public int getNumberOfSheets() {
        return this.numSheets;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getSheetIndex(String str) {
        String[] strArr;
        int i = 0;
        boolean z = false;
        while (true) {
            strArr = this.sheetNames;
            if (i >= strArr.length || z) {
                break;
            }
            if (strArr[i].equals(str)) {
                z = true;
            }
            i++;
        }
        if (z) {
            return 0;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[strArr.length] = str;
        this.sheetNames = strArr2;
        return strArr2.length - 1;
    }

    public String getSheetName(int i) {
        return this.sheetNames[i];
    }
}
