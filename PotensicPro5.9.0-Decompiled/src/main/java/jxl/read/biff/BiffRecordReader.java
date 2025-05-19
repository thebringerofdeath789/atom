package jxl.read.biff;

/* loaded from: classes4.dex */
public class BiffRecordReader {
    private File file;
    private Record record;

    public BiffRecordReader(File file) {
        this.file = file;
    }

    public boolean hasNext() {
        return this.file.hasNext();
    }

    public Record next() {
        Record next = this.file.next();
        this.record = next;
        return next;
    }

    public int getPos() {
        return (this.file.getPos() - this.record.getLength()) - 4;
    }
}
