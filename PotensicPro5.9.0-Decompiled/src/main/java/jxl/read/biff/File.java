package jxl.read.biff;

import common.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import jxl.WorkbookSettings;
import jxl.biff.BaseCompoundFile;
import jxl.biff.IntegerHelper;
import jxl.biff.Type;

/* loaded from: classes4.dex */
public class File {
    static /* synthetic */ Class class$jxl$read$biff$File;
    private static Logger logger;
    private int arrayGrowSize;
    private CompoundFile compoundFile;
    private byte[] data;
    private int filePos;
    private int initialFileSize;
    private int oldPos;
    private WorkbookSettings workbookSettings;

    public void close() {
    }

    static {
        Class cls = class$jxl$read$biff$File;
        if (cls == null) {
            cls = class$("jxl.read.biff.File");
            class$jxl$read$biff$File = cls;
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

    public File(InputStream inputStream, WorkbookSettings workbookSettings) throws IOException, BiffException {
        this.workbookSettings = workbookSettings;
        this.initialFileSize = workbookSettings.getInitialFileSize();
        this.arrayGrowSize = this.workbookSettings.getArrayGrowSize();
        byte[] bArr = new byte[this.initialFileSize];
        int read = inputStream.read(bArr);
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException();
        }
        int i = read;
        while (read != -1) {
            if (i >= bArr.length) {
                byte[] bArr2 = new byte[bArr.length + this.arrayGrowSize];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
            }
            read = inputStream.read(bArr, i, bArr.length - i);
            i += read;
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
        }
        if (i + 1 == 0) {
            throw new BiffException(BiffException.excelFileNotFound);
        }
        CompoundFile compoundFile = new CompoundFile(bArr, workbookSettings);
        try {
            this.data = compoundFile.getStream("workbook");
        } catch (BiffException unused) {
            this.data = compoundFile.getStream("book");
        }
        if (!this.workbookSettings.getPropertySetsDisabled() && compoundFile.getNumberOfPropertySets() > BaseCompoundFile.STANDARD_PROPERTY_SETS.length) {
            this.compoundFile = compoundFile;
        }
        if (this.workbookSettings.getGCDisabled()) {
            return;
        }
        System.gc();
    }

    public File(byte[] bArr) {
        this.data = bArr;
    }

    Record next() {
        return new Record(this.data, this.filePos, this);
    }

    Record peek() {
        int i = this.filePos;
        Record record = new Record(this.data, this.filePos, this);
        this.filePos = i;
        return record;
    }

    public void skip(int i) {
        this.filePos += i;
    }

    public byte[] read(int i, int i2) {
        byte[] bArr = new byte[i2];
        try {
            System.arraycopy(this.data, i, bArr, 0, i2);
            return bArr;
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error(new StringBuffer().append("Array index out of bounds at position ").append(i).append(" record length ").append(i2).toString());
            throw e;
        }
    }

    public int getPos() {
        return this.filePos;
    }

    public void setPos(int i) {
        this.oldPos = this.filePos;
        this.filePos = i;
    }

    public void restorePos() {
        this.filePos = this.oldPos;
    }

    private void moveToFirstBof() {
        boolean z = false;
        while (!z) {
            byte[] bArr = this.data;
            int i = this.filePos;
            if (IntegerHelper.getInt(bArr[i], bArr[i + 1]) == Type.BOF.value) {
                z = true;
            } else {
                skip(128);
            }
        }
    }

    public void clear() {
        this.data = null;
    }

    public boolean hasNext() {
        return this.filePos < this.data.length + (-4);
    }

    CompoundFile getCompoundFile() {
        return this.compoundFile;
    }
}
