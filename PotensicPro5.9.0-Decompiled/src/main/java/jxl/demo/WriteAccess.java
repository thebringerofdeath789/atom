package jxl.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.WorkbookSettings;
import jxl.biff.StringHelper;
import jxl.biff.Type;
import jxl.read.biff.BiffException;
import jxl.read.biff.BiffRecordReader;
import jxl.read.biff.Record;

/* loaded from: classes4.dex */
class WriteAccess {
    private BiffRecordReader reader;

    public WriteAccess(File file) throws IOException, BiffException {
        WorkbookSettings workbookSettings = new WorkbookSettings();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.reader = new BiffRecordReader(new jxl.read.biff.File(fileInputStream, workbookSettings));
        display(workbookSettings);
        fileInputStream.close();
    }

    private void display(WorkbookSettings workbookSettings) throws IOException {
        Record record = null;
        boolean z = false;
        while (this.reader.hasNext() && !z) {
            record = this.reader.next();
            if (record.getType() == Type.WRITEACCESS) {
                z = true;
            }
        }
        if (!z) {
            System.err.println("Warning:  could not find write access record");
            return;
        }
        byte[] data = record.getData();
        System.out.println(StringHelper.getString(data, data.length, 0, workbookSettings));
    }
}
