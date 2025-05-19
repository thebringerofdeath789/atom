package jxl.write.biff;

import common.Logger;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import jxl.CellType;
import jxl.DateCell;
import jxl.biff.DoubleHelper;
import jxl.biff.Type;
import jxl.format.CellFormat;
import jxl.write.DateFormats;
import jxl.write.WritableCellFormat;

/* loaded from: classes4.dex */
public abstract class DateRecord extends CellValue {
    static /* synthetic */ Class class$jxl$write$biff$DateRecord = null;
    static final WritableCellFormat defaultDateFormat;
    private static Logger logger = null;
    private static final long msInADay = 86400000;
    private static final int nonLeapDay = 61;
    private static final int utcOffsetDays = 25569;
    private Date date;
    private boolean time;
    private double value;

    /* JADX INFO: Access modifiers changed from: protected */
    public static final class GMTDate {
    }

    public DateFormat getDateFormat() {
        return null;
    }

    static {
        Class cls = class$jxl$write$biff$DateRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.DateRecord");
            class$jxl$write$biff$DateRecord = cls;
        }
        logger = Logger.getLogger(cls);
        defaultDateFormat = new WritableCellFormat(DateFormats.DEFAULT);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    protected DateRecord(int i, int i2, Date date) {
        this(i, i2, date, (CellFormat) defaultDateFormat, true);
    }

    protected DateRecord(int i, int i2, Date date, GMTDate gMTDate) {
        this(i, i2, date, (CellFormat) defaultDateFormat, false);
    }

    protected DateRecord(int i, int i2, Date date, CellFormat cellFormat) {
        super(Type.NUMBER, i, i2, cellFormat);
        this.date = date;
        calculateValue(true);
    }

    protected DateRecord(int i, int i2, Date date, CellFormat cellFormat, GMTDate gMTDate) {
        super(Type.NUMBER, i, i2, cellFormat);
        this.date = date;
        calculateValue(false);
    }

    protected DateRecord(int i, int i2, Date date, CellFormat cellFormat, boolean z) {
        super(Type.NUMBER, i, i2, cellFormat);
        this.date = date;
        this.time = z;
        calculateValue(false);
    }

    protected DateRecord(DateCell dateCell) {
        super(Type.NUMBER, dateCell);
        this.date = dateCell.getDate();
        this.time = dateCell.isTime();
        calculateValue(false);
    }

    protected DateRecord(int i, int i2, DateRecord dateRecord) {
        super(Type.NUMBER, i, i2, dateRecord);
        this.value = dateRecord.value;
        this.time = dateRecord.time;
        this.date = dateRecord.date;
    }

    private void calculateValue(boolean z) {
        long j;
        long j2 = 0;
        if (z) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.date);
            j2 = calendar.get(15);
            j = calendar.get(16);
        } else {
            j = 0;
        }
        double time = (((this.date.getTime() + j2) + j) / 8.64E7d) + 25569.0d;
        this.value = time;
        boolean z2 = this.time;
        if (!z2 && time < 61.0d) {
            this.value = time - 1.0d;
        }
        if (z2) {
            this.value = this.value - ((int) r0);
        }
    }

    @Override // jxl.Cell
    public CellType getType() {
        return CellType.DATE;
    }

    @Override // jxl.write.biff.CellValue, jxl.biff.WritableRecordData
    public byte[] getData() {
        byte[] data = super.getData();
        byte[] bArr = new byte[data.length + 8];
        System.arraycopy(data, 0, bArr, 0, data.length);
        DoubleHelper.getIEEEBytes(this.value, bArr, data.length);
        return bArr;
    }

    @Override // jxl.Cell
    public String getContents() {
        return this.date.toString();
    }

    protected void setDate(Date date) {
        this.date = date;
        calculateValue(true);
    }

    protected void setDate(Date date, GMTDate gMTDate) {
        this.date = date;
        calculateValue(false);
    }

    public Date getDate() {
        return this.date;
    }

    public boolean isTime() {
        return this.time;
    }
}
