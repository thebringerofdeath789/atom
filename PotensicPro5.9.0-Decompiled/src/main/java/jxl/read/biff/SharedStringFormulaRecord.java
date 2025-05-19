package jxl.read.biff;

import common.Assert;
import common.Logger;
import jxl.CellType;
import jxl.LabelCell;
import jxl.StringFormulaCell;
import jxl.WorkbookSettings;
import jxl.biff.FormattingRecords;
import jxl.biff.FormulaData;
import jxl.biff.IntegerHelper;
import jxl.biff.StringHelper;
import jxl.biff.Type;
import jxl.biff.WorkbookMethods;
import jxl.biff.formula.ExternalSheet;
import jxl.biff.formula.FormulaException;
import jxl.biff.formula.FormulaParser;

/* loaded from: classes4.dex */
public class SharedStringFormulaRecord extends BaseSharedFormulaRecord implements LabelCell, FormulaData, StringFormulaCell {
    protected static final EmptyString EMPTY_STRING;
    static /* synthetic */ Class class$jxl$read$biff$SharedStringFormulaRecord;
    private static Logger logger;
    private String value;

    static {
        Class cls = class$jxl$read$biff$SharedStringFormulaRecord;
        if (cls == null) {
            cls = class$("jxl.read.biff.SharedStringFormulaRecord");
            class$jxl$read$biff$SharedStringFormulaRecord = cls;
        }
        logger = Logger.getLogger(cls);
        EMPTY_STRING = new EmptyString();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class EmptyString {
        private EmptyString() {
        }
    }

    public SharedStringFormulaRecord(Record record, File file, FormattingRecords formattingRecords, ExternalSheet externalSheet, WorkbookMethods workbookMethods, SheetImpl sheetImpl, WorkbookSettings workbookSettings) {
        super(record, formattingRecords, externalSheet, workbookMethods, sheetImpl, file.getPos());
        int pos = file.getPos();
        int pos2 = file.getPos();
        Record next = file.next();
        boolean z = false;
        int i = 0;
        while (next.getType() != Type.STRING && i < 4) {
            next = file.next();
            i++;
        }
        Assert.verify(i < 4, new StringBuffer().append(" @ ").append(pos).toString());
        byte[] data = next.getData();
        int i2 = IntegerHelper.getInt(data[0], data[1]);
        int i3 = 3;
        if (data.length == i2 + 2) {
            i3 = 2;
        } else if (data[2] == 1) {
            z = true;
        }
        if (!z) {
            this.value = StringHelper.getString(data, i2, i3, workbookSettings);
        } else {
            this.value = StringHelper.getUnicodeString(data, i2, i3);
        }
        file.setPos(pos2);
    }

    public SharedStringFormulaRecord(Record record, File file, FormattingRecords formattingRecords, ExternalSheet externalSheet, WorkbookMethods workbookMethods, SheetImpl sheetImpl, EmptyString emptyString) {
        super(record, formattingRecords, externalSheet, workbookMethods, sheetImpl, file.getPos());
        this.value = "";
    }

    @Override // jxl.LabelCell
    public String getString() {
        return this.value;
    }

    @Override // jxl.Cell
    public String getContents() {
        return this.value;
    }

    @Override // jxl.Cell
    public CellType getType() {
        return CellType.STRING_FORMULA;
    }

    @Override // jxl.biff.FormulaData
    public byte[] getFormulaData() throws FormulaException {
        if (!getSheet().getWorkbookBof().isBiff8()) {
            throw new FormulaException(FormulaException.BIFF8_SUPPORTED);
        }
        FormulaParser formulaParser = new FormulaParser(getTokens(), this, getExternalSheet(), getNameTable(), getSheet().getWorkbook().getSettings());
        formulaParser.parse();
        byte[] bytes = formulaParser.getBytes();
        int length = bytes.length + 22;
        byte[] bArr = new byte[length];
        IntegerHelper.getTwoBytes(getRow(), bArr, 0);
        IntegerHelper.getTwoBytes(getColumn(), bArr, 2);
        IntegerHelper.getTwoBytes(getXFIndex(), bArr, 4);
        bArr[6] = 0;
        bArr[12] = -1;
        bArr[13] = -1;
        System.arraycopy(bytes, 0, bArr, 22, bytes.length);
        IntegerHelper.getTwoBytes(bytes.length, bArr, 20);
        int i = length - 6;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 6, bArr2, 0, i);
        return bArr2;
    }
}
