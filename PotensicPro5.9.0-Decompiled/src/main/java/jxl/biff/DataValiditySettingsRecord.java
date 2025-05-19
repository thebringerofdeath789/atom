package jxl.biff;

import common.Assert;
import common.Logger;
import jxl.WorkbookSettings;
import jxl.biff.formula.ExternalSheet;
import jxl.biff.formula.FormulaException;
import jxl.read.biff.Record;

/* loaded from: classes4.dex */
public class DataValiditySettingsRecord extends WritableRecordData {
    static /* synthetic */ Class class$jxl$biff$DataValiditySettingsRecord;
    private static Logger logger;
    private byte[] data;
    private DataValidation dataValidation;
    private DVParser dvParser;
    private ExternalSheet externalSheet;
    private WorkbookMethods workbook;
    private WorkbookSettings workbookSettings;

    static {
        Class cls = class$jxl$biff$DataValiditySettingsRecord;
        if (cls == null) {
            cls = class$("jxl.biff.DataValiditySettingsRecord");
            class$jxl$biff$DataValiditySettingsRecord = cls;
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

    public DataValiditySettingsRecord(Record record, ExternalSheet externalSheet, WorkbookMethods workbookMethods, WorkbookSettings workbookSettings) {
        super(record);
        this.data = record.getData();
        this.externalSheet = externalSheet;
        this.workbook = workbookMethods;
        this.workbookSettings = workbookSettings;
    }

    DataValiditySettingsRecord(DataValiditySettingsRecord dataValiditySettingsRecord) {
        super(Type.DV);
        this.data = dataValiditySettingsRecord.getData();
    }

    DataValiditySettingsRecord(DataValiditySettingsRecord dataValiditySettingsRecord, ExternalSheet externalSheet, WorkbookMethods workbookMethods, WorkbookSettings workbookSettings) {
        super(Type.DV);
        this.workbook = workbookMethods;
        this.externalSheet = externalSheet;
        this.workbookSettings = workbookSettings;
        Assert.verify(workbookMethods != null);
        Assert.verify(externalSheet != null);
        byte[] bArr = new byte[dataValiditySettingsRecord.data.length];
        this.data = bArr;
        System.arraycopy(dataValiditySettingsRecord.data, 0, bArr, 0, bArr.length);
    }

    public DataValiditySettingsRecord(DVParser dVParser) {
        super(Type.DV);
        this.dvParser = dVParser;
    }

    private void initialize() {
        try {
            if (this.dvParser == null) {
                this.dvParser = new DVParser(this.data, this.externalSheet, this.workbook, this.workbookSettings);
            }
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append("Cannot read drop down range ").append(e.getMessage()).toString());
        }
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        DVParser dVParser = this.dvParser;
        if (dVParser == null) {
            return this.data;
        }
        return dVParser.getData();
    }

    public void insertRow(int i) {
        if (this.dvParser == null) {
            initialize();
        }
        this.dvParser.insertRow(i);
    }

    public void removeRow(int i) {
        if (this.dvParser == null) {
            initialize();
        }
        this.dvParser.removeRow(i);
    }

    public void insertColumn(int i) {
        if (this.dvParser == null) {
            initialize();
        }
        this.dvParser.insertColumn(i);
    }

    public void removeColumn(int i) {
        if (this.dvParser == null) {
            initialize();
        }
        this.dvParser.removeColumn(i);
    }

    public int getFirstColumn() {
        if (this.dvParser == null) {
            initialize();
        }
        return this.dvParser.getFirstColumn();
    }

    public int getLastColumn() {
        if (this.dvParser == null) {
            initialize();
        }
        return this.dvParser.getLastColumn();
    }

    public int getFirstRow() {
        if (this.dvParser == null) {
            initialize();
        }
        return this.dvParser.getFirstRow();
    }

    public int getLastRow() {
        if (this.dvParser == null) {
            initialize();
        }
        return this.dvParser.getLastRow();
    }

    void setDataValidation(DataValidation dataValidation) {
        this.dataValidation = dataValidation;
    }

    DVParser getDVParser() {
        return this.dvParser;
    }

    public String getValidationFormula() {
        try {
            if (this.dvParser == null) {
                initialize();
            }
            return this.dvParser.getValidationFormula();
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append("Cannot read drop down range ").append(e.getMessage()).toString());
            return "";
        }
    }
}
