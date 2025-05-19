package org.apache.poi.hssf.eventusermodel;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingRowDummyRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.MulRKRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.StringRecord;

/* loaded from: classes4.dex */
public final class MissingRecordAwareHSSFListener implements HSSFListener {
    private HSSFListener childListener;
    private int lastCellColumn;
    private int lastCellRow;
    private int lastRowRow;

    public MissingRecordAwareHSSFListener(HSSFListener hSSFListener) {
        resetCounts();
        this.childListener = hSSFListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record record) {
        int row;
        int column;
        NumberRecord[] numberRecordArr = null;
        numberRecordArr = null;
        r2 = null;
        r2 = null;
        r2 = null;
        NumberRecord[] numberRecordArr2 = null;
        if (record instanceof CellValueRecordInterface) {
            CellValueRecordInterface cellValueRecordInterface = (CellValueRecordInterface) record;
            row = cellValueRecordInterface.getRow();
            column = cellValueRecordInterface.getColumn();
        } else {
            if (record instanceof StringRecord) {
                this.childListener.processRecord(record);
                return;
            }
            short sid = record.getSid();
            if (sid != 28) {
                if (sid == 520) {
                    RowRecord rowRecord = (RowRecord) record;
                    if (this.lastRowRow + 1 < rowRecord.getRowNumber()) {
                        int i = this.lastRowRow;
                        while (true) {
                            i++;
                            if (i >= rowRecord.getRowNumber()) {
                                break;
                            } else {
                                this.childListener.processRecord(new MissingRowDummyRecord(i));
                            }
                        }
                    }
                    this.lastRowRow = rowRecord.getRowNumber();
                    this.lastCellColumn = -1;
                } else {
                    if (sid == 1212) {
                        this.childListener.processRecord(record);
                        return;
                    }
                    if (sid == 2057) {
                        BOFRecord bOFRecord = (BOFRecord) record;
                        if (bOFRecord.getType() == 5 || bOFRecord.getType() == 16) {
                            resetCounts();
                        }
                    } else if (sid == 189) {
                        numberRecordArr2 = RecordFactory.convertRKRecords((MulRKRecord) record);
                    } else if (sid == 190) {
                        numberRecordArr2 = RecordFactory.convertBlankRecords((MulBlankRecord) record);
                    }
                }
                column = -1;
                row = -1;
                numberRecordArr = numberRecordArr2;
            } else {
                NoteRecord noteRecord = (NoteRecord) record;
                row = noteRecord.getRow();
                column = noteRecord.getColumn();
            }
        }
        if (numberRecordArr != null && numberRecordArr.length > 0) {
            row = numberRecordArr[0].getRow();
            column = numberRecordArr[0].getColumn();
        }
        int i2 = this.lastCellRow;
        if (row != i2 && row > 0) {
            if (i2 == -1) {
                this.lastCellRow = 0;
            }
            int i3 = this.lastCellRow;
            while (i3 < row) {
                this.childListener.processRecord(new LastCellOfRowDummyRecord(i3, i3 == this.lastCellRow ? this.lastCellColumn : -1));
                i3++;
            }
        }
        if (this.lastCellRow != -1 && this.lastCellColumn != -1 && row == -1) {
            this.childListener.processRecord(new LastCellOfRowDummyRecord(this.lastCellRow, this.lastCellColumn));
            this.lastCellRow = -1;
            this.lastCellColumn = -1;
        }
        if (row != this.lastCellRow) {
            this.lastCellColumn = -1;
        }
        int i4 = this.lastCellColumn;
        if (i4 != column - 1) {
            while (true) {
                i4++;
                if (i4 >= column) {
                    break;
                } else {
                    this.childListener.processRecord(new MissingCellDummyRecord(row, i4));
                }
            }
        }
        if (numberRecordArr != null && numberRecordArr.length > 0) {
            column = numberRecordArr[numberRecordArr.length - 1].getColumn();
        }
        if (column != -1) {
            this.lastCellColumn = column;
            this.lastCellRow = row;
        }
        if (numberRecordArr != null && numberRecordArr.length > 0) {
            for (NumberRecord numberRecord : numberRecordArr) {
                this.childListener.processRecord(numberRecord);
            }
            return;
        }
        this.childListener.processRecord(record);
    }

    private void resetCounts() {
        this.lastRowRow = -1;
        this.lastCellRow = -1;
        this.lastCellColumn = -1;
    }
}
