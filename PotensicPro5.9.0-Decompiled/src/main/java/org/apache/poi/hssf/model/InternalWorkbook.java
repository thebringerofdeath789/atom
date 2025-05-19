package org.apache.poi.hssf.model;

import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherDggRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSplitMenuColorsRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BackupRecord;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.CodepageRecord;
import org.apache.poi.hssf.record.CountryRecord;
import org.apache.poi.hssf.record.DSFRecord;
import org.apache.poi.hssf.record.DateWindow1904Record;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ExtSSTRecord;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FileSharingRecord;
import org.apache.poi.hssf.record.FnGroupCountRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.HideObjRecord;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.InterfaceEndRecord;
import org.apache.poi.hssf.record.InterfaceHdrRecord;
import org.apache.poi.hssf.record.MMSRecord;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.record.PasswordRecord;
import org.apache.poi.hssf.record.PasswordRev4Record;
import org.apache.poi.hssf.record.PrecisionRecord;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.record.ProtectionRev4Record;
import org.apache.poi.hssf.record.RecalcIdRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RefreshAllRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.record.TabIdRecord;
import org.apache.poi.hssf.record.UseSelFSRecord;
import org.apache.poi.hssf.record.WindowOneRecord;
import org.apache.poi.hssf.record.WindowProtectRecord;
import org.apache.poi.hssf.record.WriteAccessRecord;
import org.apache.poi.hssf.record.WriteProtectRecord;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

@Internal
/* loaded from: classes4.dex */
public final class InternalWorkbook {
    private static final short CODEPAGE = 1200;
    private static final int DEBUG = 1;
    private static final int MAX_SENSITIVE_SHEET_NAME_LEN = 31;
    private static final POILogger log = POILogFactory.getLogger((Class<?>) InternalWorkbook.class);
    private DrawingManager2 drawingManager;
    private FileSharingRecord fileShare;
    private LinkTable linkTable;
    protected SSTRecord sst;
    private WindowOneRecord windowOne;
    private WriteAccessRecord writeAccess;
    private WriteProtectRecord writeProtect;
    private final WorkbookRecordList records = new WorkbookRecordList();
    private final List<BoundSheetRecord> boundsheets = new ArrayList();
    private final List<FormatRecord> formats = new ArrayList();
    private final List<HyperlinkRecord> hyperlinks = new ArrayList();
    private int numxfs = 0;
    private int numfonts = 0;
    private int maxformatid = -1;
    private boolean uses1904datewindowing = false;
    private List<EscherBSERecord> escherBSERecords = new ArrayList();
    private final Map<String, NameCommentRecord> commentRecords = new LinkedHashMap();

    private InternalWorkbook() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x031e, code lost:
    
        r0.hyperlinks.add((org.apache.poi.hssf.record.HyperlinkRecord) r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0325, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x032a, code lost:
    
        if (r0.windowOne != null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x032c, code lost:
    
        r0.windowOne = createWindowOne();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0332, code lost:
    
        r10 = org.apache.poi.hssf.model.InternalWorkbook.log;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0338, code lost:
    
        if (r10.check(1) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x033a, code lost:
    
        r10.log(1, "exit create workbook from existing file function");
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x033f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x030d, code lost:
    
        if (r4 >= r10.size()) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x030f, code lost:
    
        r2 = r10.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x031b, code lost:
    
        if (r2.getSid() == 440) goto L97;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.apache.poi.hssf.model.InternalWorkbook createWorkbook(java.util.List<org.apache.poi.hssf.record.Record> r10) {
        /*
            Method dump skipped, instructions count: 906
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.hssf.model.InternalWorkbook.createWorkbook(java.util.List):org.apache.poi.hssf.model.InternalWorkbook");
    }

    public static InternalWorkbook createWorkbook() {
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "creating new workbook from scratch");
        }
        InternalWorkbook internalWorkbook = new InternalWorkbook();
        ArrayList arrayList = new ArrayList(30);
        internalWorkbook.records.setRecords(arrayList);
        List<FormatRecord> list = internalWorkbook.formats;
        arrayList.add(createBOF());
        arrayList.add(new InterfaceHdrRecord(1200));
        arrayList.add(createMMS());
        arrayList.add(InterfaceEndRecord.instance);
        arrayList.add(createWriteAccess());
        arrayList.add(createCodepage());
        arrayList.add(createDSF());
        arrayList.add(createTabId());
        internalWorkbook.records.setTabpos(arrayList.size() - 1);
        arrayList.add(createFnGroupCount());
        arrayList.add(createWindowProtect());
        arrayList.add(createProtect());
        internalWorkbook.records.setProtpos(arrayList.size() - 1);
        arrayList.add(createPassword());
        arrayList.add(createProtectionRev4());
        arrayList.add(createPasswordRev4());
        WindowOneRecord createWindowOne = createWindowOne();
        internalWorkbook.windowOne = createWindowOne;
        arrayList.add(createWindowOne);
        arrayList.add(createBackup());
        internalWorkbook.records.setBackuppos(arrayList.size() - 1);
        arrayList.add(createHideObj());
        arrayList.add(createDateWindow1904());
        arrayList.add(createPrecision());
        arrayList.add(createRefreshAll());
        arrayList.add(createBookBool());
        arrayList.add(createFont());
        arrayList.add(createFont());
        arrayList.add(createFont());
        arrayList.add(createFont());
        internalWorkbook.records.setFontpos(arrayList.size() - 1);
        internalWorkbook.numfonts = 4;
        for (int i = 0; i <= 7; i++) {
            FormatRecord createFormat = createFormat(i);
            internalWorkbook.maxformatid = internalWorkbook.maxformatid >= createFormat.getIndexCode() ? internalWorkbook.maxformatid : createFormat.getIndexCode();
            list.add(createFormat);
            arrayList.add(createFormat);
        }
        for (int i2 = 0; i2 < 21; i2++) {
            arrayList.add(createExtendedFormat(i2));
            internalWorkbook.numxfs++;
        }
        internalWorkbook.records.setXfpos(arrayList.size() - 1);
        for (int i3 = 0; i3 < 6; i3++) {
            arrayList.add(createStyle(i3));
        }
        arrayList.add(createUseSelFS());
        for (int i4 = 0; i4 < 1; i4++) {
            BoundSheetRecord createBoundSheet = createBoundSheet(i4);
            arrayList.add(createBoundSheet);
            internalWorkbook.boundsheets.add(createBoundSheet);
            internalWorkbook.records.setBspos(arrayList.size() - 1);
        }
        arrayList.add(createCountry());
        for (int i5 = 0; i5 < 1; i5++) {
            internalWorkbook.getOrCreateLinkTable().checkExternSheet(i5);
        }
        SSTRecord sSTRecord = new SSTRecord();
        internalWorkbook.sst = sSTRecord;
        arrayList.add(sSTRecord);
        arrayList.add(createExtendedSST());
        arrayList.add(EOFRecord.instance);
        POILogger pOILogger2 = log;
        if (pOILogger2.check(1)) {
            pOILogger2.log(1, "exit create new workbook from scratch");
        }
        return internalWorkbook;
    }

    public NameRecord getSpecificBuiltinRecord(byte b, int i) {
        return getOrCreateLinkTable().getSpecificBuiltinRecord(b, i);
    }

    public void removeBuiltinRecord(byte b, int i) {
        this.linkTable.removeBuiltinRecord(b, i);
    }

    public int getNumRecords() {
        return this.records.size();
    }

    public FontRecord getFontRecordAt(int i) {
        int i2 = i > 4 ? i - 1 : i;
        if (i2 > this.numfonts - 1) {
            throw new ArrayIndexOutOfBoundsException("There are only " + this.numfonts + " font records, you asked for " + i);
        }
        WorkbookRecordList workbookRecordList = this.records;
        return (FontRecord) workbookRecordList.get((workbookRecordList.getFontpos() - (this.numfonts - 1)) + i2);
    }

    public int getFontIndex(FontRecord fontRecord) {
        int i = 0;
        while (i <= this.numfonts) {
            WorkbookRecordList workbookRecordList = this.records;
            if (((FontRecord) workbookRecordList.get((workbookRecordList.getFontpos() - (this.numfonts - 1)) + i)) == fontRecord) {
                return i > 3 ? i + 1 : i;
            }
            i++;
        }
        throw new IllegalArgumentException("Could not find that font!");
    }

    public FontRecord createNewFont() {
        FontRecord createFont = createFont();
        WorkbookRecordList workbookRecordList = this.records;
        workbookRecordList.add(workbookRecordList.getFontpos() + 1, createFont);
        WorkbookRecordList workbookRecordList2 = this.records;
        workbookRecordList2.setFontpos(workbookRecordList2.getFontpos() + 1);
        this.numfonts++;
        return createFont;
    }

    public void removeFontRecord(FontRecord fontRecord) {
        this.records.remove(fontRecord);
        this.numfonts--;
    }

    public int getNumberOfFontRecords() {
        return this.numfonts;
    }

    public void setSheetBof(int i, int i2) {
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "setting bof for sheetnum =", Integer.valueOf(i), " at pos=", Integer.valueOf(i2));
        }
        checkSheets(i);
        getBoundSheetRec(i).setPositionOfBof(i2);
    }

    private BoundSheetRecord getBoundSheetRec(int i) {
        return this.boundsheets.get(i);
    }

    public BackupRecord getBackupRecord() {
        WorkbookRecordList workbookRecordList = this.records;
        return (BackupRecord) workbookRecordList.get(workbookRecordList.getBackuppos());
    }

    public void setSheetName(int i, String str) {
        checkSheets(i);
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        this.boundsheets.get(i).setSheetname(str);
    }

    public boolean doesContainsSheetName(String str, int i) {
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        for (int i2 = 0; i2 < this.boundsheets.size(); i2++) {
            BoundSheetRecord boundSheetRec = getBoundSheetRec(i2);
            if (i != i2) {
                String sheetname = boundSheetRec.getSheetname();
                if (sheetname.length() > 31) {
                    sheetname = sheetname.substring(0, 31);
                }
                if (str.equalsIgnoreCase(sheetname)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setSheetOrder(String str, int i) {
        int sheetIndex = getSheetIndex(str);
        List<BoundSheetRecord> list = this.boundsheets;
        list.add(i, list.remove(sheetIndex));
        int bspos = this.records.getBspos() - (this.boundsheets.size() - 1);
        int i2 = sheetIndex + bspos;
        Record record = this.records.get(i2);
        this.records.remove(i2);
        this.records.add(bspos + i, record);
    }

    public String getSheetName(int i) {
        return getBoundSheetRec(i).getSheetname();
    }

    public boolean isSheetHidden(int i) {
        return getBoundSheetRec(i).isHidden();
    }

    public boolean isSheetVeryHidden(int i) {
        return getBoundSheetRec(i).isVeryHidden();
    }

    public void setSheetHidden(int i, boolean z) {
        getBoundSheetRec(i).setHidden(z);
    }

    public void setSheetHidden(int i, int i2) {
        BoundSheetRecord boundSheetRec = getBoundSheetRec(i);
        boolean z = false;
        boolean z2 = true;
        if (i2 == 0) {
            z2 = false;
        } else if (i2 == 1) {
            z2 = false;
            z = true;
        } else if (i2 != 2) {
            throw new IllegalArgumentException("Invalid hidden flag " + i2 + " given, must be 0, 1 or 2");
        }
        boundSheetRec.setHidden(z);
        boundSheetRec.setVeryHidden(z2);
    }

    public int getSheetIndex(String str) {
        for (int i = 0; i < this.boundsheets.size(); i++) {
            if (getSheetName(i).equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    private void checkSheets(int i) {
        if (this.boundsheets.size() <= i) {
            if (this.boundsheets.size() + 1 <= i) {
                throw new RuntimeException("Sheet number out of bounds!");
            }
            BoundSheetRecord createBoundSheet = createBoundSheet(i);
            WorkbookRecordList workbookRecordList = this.records;
            workbookRecordList.add(workbookRecordList.getBspos() + 1, createBoundSheet);
            WorkbookRecordList workbookRecordList2 = this.records;
            workbookRecordList2.setBspos(workbookRecordList2.getBspos() + 1);
            this.boundsheets.add(createBoundSheet);
            getOrCreateLinkTable().checkExternSheet(i);
            fixTabIdRecord();
        }
    }

    public void removeSheet(int i) {
        if (this.boundsheets.size() > i) {
            WorkbookRecordList workbookRecordList = this.records;
            workbookRecordList.remove((workbookRecordList.getBspos() - (this.boundsheets.size() - 1)) + i);
            this.boundsheets.remove(i);
            fixTabIdRecord();
        }
        int i2 = i + 1;
        for (int i3 = 0; i3 < getNumNames(); i3++) {
            NameRecord nameRecord = getNameRecord(i3);
            if (nameRecord.getSheetNumber() == i2) {
                nameRecord.setSheetNumber(0);
            } else if (nameRecord.getSheetNumber() > i2) {
                nameRecord.setSheetNumber(nameRecord.getSheetNumber() - 1);
            }
        }
        if (this.linkTable != null) {
            while (i2 < getNumSheets() + 1) {
                this.linkTable.removeSheet(i2);
                i2++;
            }
        }
    }

    private int fixTabIdRecord() {
        WorkbookRecordList workbookRecordList = this.records;
        TabIdRecord tabIdRecord = (TabIdRecord) workbookRecordList.get(workbookRecordList.getTabpos());
        int recordSize = tabIdRecord.getRecordSize();
        int size = this.boundsheets.size();
        short[] sArr = new short[size];
        for (short s = 0; s < size; s = (short) (s + 1)) {
            sArr[s] = s;
        }
        tabIdRecord.setTabIdArray(sArr);
        return tabIdRecord.getRecordSize() - recordSize;
    }

    public int getNumSheets() {
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "getNumSheets=", Integer.valueOf(this.boundsheets.size()));
        }
        return this.boundsheets.size();
    }

    public int getNumExFormats() {
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "getXF=", Integer.valueOf(this.numxfs));
        }
        return this.numxfs;
    }

    public ExtendedFormatRecord getExFormatAt(int i) {
        return (ExtendedFormatRecord) this.records.get((this.records.getXfpos() - (this.numxfs - 1)) + i);
    }

    public void removeExFormatRecord(ExtendedFormatRecord extendedFormatRecord) {
        this.records.remove(extendedFormatRecord);
        this.numxfs--;
    }

    public void removeExFormatRecord(int i) {
        this.records.remove((this.records.getXfpos() - (this.numxfs - 1)) + i);
        this.numxfs--;
    }

    public ExtendedFormatRecord createCellXF() {
        ExtendedFormatRecord createExtendedFormat = createExtendedFormat();
        WorkbookRecordList workbookRecordList = this.records;
        workbookRecordList.add(workbookRecordList.getXfpos() + 1, createExtendedFormat);
        WorkbookRecordList workbookRecordList2 = this.records;
        workbookRecordList2.setXfpos(workbookRecordList2.getXfpos() + 1);
        this.numxfs++;
        return createExtendedFormat;
    }

    public StyleRecord getStyleRecord(int i) {
        for (int xfpos = this.records.getXfpos(); xfpos < this.records.size(); xfpos++) {
            Record record = this.records.get(xfpos);
            if (!(record instanceof ExtendedFormatRecord) && (record instanceof StyleRecord)) {
                StyleRecord styleRecord = (StyleRecord) record;
                if (styleRecord.getXFIndex() == i) {
                    return styleRecord;
                }
            }
        }
        return null;
    }

    public StyleRecord createStyleRecord(int i) {
        StyleRecord styleRecord = new StyleRecord();
        styleRecord.setXFIndex(i);
        int i2 = -1;
        for (int xfpos = this.records.getXfpos(); xfpos < this.records.size() && i2 == -1; xfpos++) {
            Record record = this.records.get(xfpos);
            if (!(record instanceof ExtendedFormatRecord) && !(record instanceof StyleRecord)) {
                i2 = xfpos;
            }
        }
        if (i2 == -1) {
            throw new IllegalStateException("No XF Records found!");
        }
        this.records.add(i2, styleRecord);
        return styleRecord;
    }

    public int addSSTString(UnicodeString unicodeString) {
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "insert to sst string='", unicodeString);
        }
        if (this.sst == null) {
            insertSST();
        }
        return this.sst.addString(unicodeString);
    }

    public UnicodeString getSSTString(int i) {
        if (this.sst == null) {
            insertSST();
        }
        UnicodeString string = this.sst.getString(i);
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "Returning SST for index=", Integer.valueOf(i), " String= ", string);
        }
        return string;
    }

    public void insertSST() {
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "creating new SST via insertSST!");
        }
        this.sst = new SSTRecord();
        WorkbookRecordList workbookRecordList = this.records;
        workbookRecordList.add(workbookRecordList.size() - 1, createExtendedSST());
        this.records.add(r0.size() - 2, this.sst);
    }

    public int serialize(int i, byte[] bArr) {
        int serialize;
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "Serializing Workbook with offsets");
        }
        SSTRecord sSTRecord = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        for (int i4 = 0; i4 < this.records.size(); i4++) {
            Record record = this.records.get(i4);
            if (record instanceof SSTRecord) {
                sSTRecord = (SSTRecord) record;
                i3 = i2;
            }
            if (record.getSid() == 255 && sSTRecord != null) {
                record = sSTRecord.createExtSSTRecord(i3 + i);
            }
            if (!(record instanceof BoundSheetRecord)) {
                serialize = record.serialize(i2 + i, bArr);
            } else if (z) {
                serialize = 0;
            } else {
                serialize = 0;
                for (int i5 = 0; i5 < this.boundsheets.size(); i5++) {
                    serialize += getBoundSheetRec(i5).serialize(i2 + i + serialize, bArr);
                }
                z = true;
            }
            i2 += serialize;
        }
        POILogger pOILogger2 = log;
        if (pOILogger2.check(1)) {
            pOILogger2.log(1, "Exiting serialize workbook");
        }
        return i2;
    }

    public void preSerialize() {
        if (this.records.getTabpos() > 0) {
            WorkbookRecordList workbookRecordList = this.records;
            if (((TabIdRecord) workbookRecordList.get(workbookRecordList.getTabpos()))._tabids.length < this.boundsheets.size()) {
                fixTabIdRecord();
            }
        }
    }

    public int getSize() {
        int recordSize;
        SSTRecord sSTRecord = null;
        int i = 0;
        for (int i2 = 0; i2 < this.records.size(); i2++) {
            Record record = this.records.get(i2);
            if (record instanceof SSTRecord) {
                sSTRecord = (SSTRecord) record;
            }
            if (record.getSid() == 255 && sSTRecord != null) {
                recordSize = sSTRecord.calcExtSSTRecordSize();
            } else {
                recordSize = record.getRecordSize();
            }
            i += recordSize;
        }
        return i;
    }

    private static BOFRecord createBOF() {
        BOFRecord bOFRecord = new BOFRecord();
        bOFRecord.setVersion(BOFRecord.VERSION);
        bOFRecord.setType(5);
        bOFRecord.setBuild(BOFRecord.BUILD);
        bOFRecord.setBuildYear(BOFRecord.BUILD_YEAR);
        bOFRecord.setHistoryBitMask(65);
        bOFRecord.setRequiredVersion(6);
        return bOFRecord;
    }

    private static MMSRecord createMMS() {
        MMSRecord mMSRecord = new MMSRecord();
        mMSRecord.setAddMenuCount((byte) 0);
        mMSRecord.setDelMenuCount((byte) 0);
        return mMSRecord;
    }

    private static WriteAccessRecord createWriteAccess() {
        WriteAccessRecord writeAccessRecord = new WriteAccessRecord();
        try {
            String property = System.getProperty("user.name");
            if (property == null) {
                property = "POI";
            }
            writeAccessRecord.setUsername(property);
        } catch (AccessControlException unused) {
            writeAccessRecord.setUsername("POI");
        }
        return writeAccessRecord;
    }

    private static CodepageRecord createCodepage() {
        CodepageRecord codepageRecord = new CodepageRecord();
        codepageRecord.setCodepage((short) 1200);
        return codepageRecord;
    }

    private static DSFRecord createDSF() {
        return new DSFRecord(false);
    }

    private static TabIdRecord createTabId() {
        return new TabIdRecord();
    }

    private static FnGroupCountRecord createFnGroupCount() {
        FnGroupCountRecord fnGroupCountRecord = new FnGroupCountRecord();
        fnGroupCountRecord.setCount((short) 14);
        return fnGroupCountRecord;
    }

    private static WindowProtectRecord createWindowProtect() {
        return new WindowProtectRecord(false);
    }

    private static ProtectRecord createProtect() {
        return new ProtectRecord(false);
    }

    private static PasswordRecord createPassword() {
        return new PasswordRecord(0);
    }

    private static ProtectionRev4Record createProtectionRev4() {
        return new ProtectionRev4Record(false);
    }

    private static PasswordRev4Record createPasswordRev4() {
        return new PasswordRev4Record(0);
    }

    private static WindowOneRecord createWindowOne() {
        WindowOneRecord windowOneRecord = new WindowOneRecord();
        windowOneRecord.setHorizontalHold((short) 360);
        windowOneRecord.setVerticalHold((short) 270);
        windowOneRecord.setWidth((short) 14940);
        windowOneRecord.setHeight((short) 9150);
        windowOneRecord.setOptions((short) 56);
        windowOneRecord.setActiveSheetIndex(0);
        windowOneRecord.setFirstVisibleTab(0);
        windowOneRecord.setNumSelectedTabs((short) 1);
        windowOneRecord.setTabWidthRatio((short) 600);
        return windowOneRecord;
    }

    private static BackupRecord createBackup() {
        BackupRecord backupRecord = new BackupRecord();
        backupRecord.setBackup((short) 0);
        return backupRecord;
    }

    private static HideObjRecord createHideObj() {
        HideObjRecord hideObjRecord = new HideObjRecord();
        hideObjRecord.setHideObj((short) 0);
        return hideObjRecord;
    }

    private static DateWindow1904Record createDateWindow1904() {
        DateWindow1904Record dateWindow1904Record = new DateWindow1904Record();
        dateWindow1904Record.setWindowing((short) 0);
        return dateWindow1904Record;
    }

    private static PrecisionRecord createPrecision() {
        PrecisionRecord precisionRecord = new PrecisionRecord();
        precisionRecord.setFullPrecision(true);
        return precisionRecord;
    }

    private static RefreshAllRecord createRefreshAll() {
        return new RefreshAllRecord(false);
    }

    private static BookBoolRecord createBookBool() {
        BookBoolRecord bookBoolRecord = new BookBoolRecord();
        bookBoolRecord.setSaveLinkValues((short) 0);
        return bookBoolRecord;
    }

    private static FontRecord createFont() {
        FontRecord fontRecord = new FontRecord();
        fontRecord.setFontHeight(EscherAggregate.ST_ACTIONBUTTONMOVIE);
        fontRecord.setAttributes((short) 0);
        fontRecord.setColorPaletteIndex(Short.MAX_VALUE);
        fontRecord.setBoldWeight((short) 400);
        fontRecord.setFontName(HSSFFont.FONT_ARIAL);
        return fontRecord;
    }

    private static FormatRecord createFormat(int i) {
        switch (i) {
            case 0:
                return new FormatRecord(5, BuiltinFormats.getBuiltinFormat(5));
            case 1:
                return new FormatRecord(6, BuiltinFormats.getBuiltinFormat(6));
            case 2:
                return new FormatRecord(7, BuiltinFormats.getBuiltinFormat(7));
            case 3:
                return new FormatRecord(8, BuiltinFormats.getBuiltinFormat(8));
            case 4:
                return new FormatRecord(42, BuiltinFormats.getBuiltinFormat(42));
            case 5:
                return new FormatRecord(41, BuiltinFormats.getBuiltinFormat(41));
            case 6:
                return new FormatRecord(44, BuiltinFormats.getBuiltinFormat(44));
            case 7:
                return new FormatRecord(43, BuiltinFormats.getBuiltinFormat(43));
            default:
                throw new IllegalArgumentException("Unexpected id " + i);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0317, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.apache.poi.hssf.record.ExtendedFormatRecord createExtendedFormat(int r12) {
        /*
            Method dump skipped, instructions count: 848
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.hssf.model.InternalWorkbook.createExtendedFormat(int):org.apache.poi.hssf.record.ExtendedFormatRecord");
    }

    private static ExtendedFormatRecord createExtendedFormat() {
        ExtendedFormatRecord extendedFormatRecord = new ExtendedFormatRecord();
        extendedFormatRecord.setFontIndex((short) 0);
        extendedFormatRecord.setFormatIndex((short) 0);
        extendedFormatRecord.setCellOptions((short) 1);
        extendedFormatRecord.setAlignmentOptions((short) 32);
        extendedFormatRecord.setIndentionOptions((short) 0);
        extendedFormatRecord.setBorderOptions((short) 0);
        extendedFormatRecord.setPaletteOptions((short) 0);
        extendedFormatRecord.setAdtlPaletteOptions((short) 0);
        extendedFormatRecord.setFillPaletteOptions((short) 8384);
        extendedFormatRecord.setTopBorderPaletteIdx((short) 8);
        extendedFormatRecord.setBottomBorderPaletteIdx((short) 8);
        extendedFormatRecord.setLeftBorderPaletteIdx((short) 8);
        extendedFormatRecord.setRightBorderPaletteIdx((short) 8);
        return extendedFormatRecord;
    }

    private static StyleRecord createStyle(int i) {
        StyleRecord styleRecord = new StyleRecord();
        if (i == 0) {
            styleRecord.setXFIndex(16);
            styleRecord.setBuiltinStyle(3);
            styleRecord.setOutlineStyleLevel(-1);
        } else if (i == 1) {
            styleRecord.setXFIndex(17);
            styleRecord.setBuiltinStyle(6);
            styleRecord.setOutlineStyleLevel(-1);
        } else if (i == 2) {
            styleRecord.setXFIndex(18);
            styleRecord.setBuiltinStyle(4);
            styleRecord.setOutlineStyleLevel(-1);
        } else if (i == 3) {
            styleRecord.setXFIndex(19);
            styleRecord.setBuiltinStyle(7);
            styleRecord.setOutlineStyleLevel(-1);
        } else if (i == 4) {
            styleRecord.setXFIndex(0);
            styleRecord.setBuiltinStyle(0);
            styleRecord.setOutlineStyleLevel(-1);
        } else if (i == 5) {
            styleRecord.setXFIndex(20);
            styleRecord.setBuiltinStyle(5);
            styleRecord.setOutlineStyleLevel(-1);
        }
        return styleRecord;
    }

    private static PaletteRecord createPalette() {
        return new PaletteRecord();
    }

    private static UseSelFSRecord createUseSelFS() {
        return new UseSelFSRecord(false);
    }

    private static BoundSheetRecord createBoundSheet(int i) {
        return new BoundSheetRecord("Sheet" + (i + 1));
    }

    private static CountryRecord createCountry() {
        CountryRecord countryRecord = new CountryRecord();
        countryRecord.setDefaultCountry((short) 1);
        if (Locale.getDefault().toString().equals("ru_RU")) {
            countryRecord.setCurrentCountry((short) 7);
        } else {
            countryRecord.setCurrentCountry((short) 1);
        }
        return countryRecord;
    }

    private static ExtSSTRecord createExtendedSST() {
        ExtSSTRecord extSSTRecord = new ExtSSTRecord();
        extSSTRecord.setNumStringsPerBucket((short) 8);
        return extSSTRecord;
    }

    private LinkTable getOrCreateLinkTable() {
        if (this.linkTable == null) {
            this.linkTable = new LinkTable((short) getNumSheets(), this.records);
        }
        return this.linkTable;
    }

    public int linkExternalWorkbook(String str, Workbook workbook) {
        return getOrCreateLinkTable().linkExternalWorkbook(str, workbook);
    }

    public String findSheetFirstNameFromExternSheet(int i) {
        return findSheetNameFromIndex(this.linkTable.getFirstInternalSheetIndexForExtIndex(i));
    }

    public String findSheetLastNameFromExternSheet(int i) {
        return findSheetNameFromIndex(this.linkTable.getLastInternalSheetIndexForExtIndex(i));
    }

    private String findSheetNameFromIndex(int i) {
        return (i >= 0 && i < this.boundsheets.size()) ? getSheetName(i) : "";
    }

    public EvaluationWorkbook.ExternalSheet getExternalSheet(int i) {
        String[] externalBookAndSheetName = this.linkTable.getExternalBookAndSheetName(i);
        if (externalBookAndSheetName == null) {
            return null;
        }
        if (externalBookAndSheetName.length == 2) {
            return new EvaluationWorkbook.ExternalSheet(externalBookAndSheetName[0], externalBookAndSheetName[1]);
        }
        return new EvaluationWorkbook.ExternalSheetRange(externalBookAndSheetName[0], externalBookAndSheetName[1], externalBookAndSheetName[2]);
    }

    public EvaluationWorkbook.ExternalName getExternalName(int i, int i2) {
        String resolveNameXText = this.linkTable.resolveNameXText(i, i2, this);
        if (resolveNameXText == null) {
            return null;
        }
        return new EvaluationWorkbook.ExternalName(resolveNameXText, i2, this.linkTable.resolveNameXIx(i, i2));
    }

    public int getFirstSheetIndexFromExternSheetIndex(int i) {
        return this.linkTable.getFirstInternalSheetIndexForExtIndex(i);
    }

    public int getLastSheetIndexFromExternSheetIndex(int i) {
        return this.linkTable.getLastInternalSheetIndexForExtIndex(i);
    }

    public short checkExternSheet(int i) {
        return (short) getOrCreateLinkTable().checkExternSheet(i);
    }

    public short checkExternSheet(int i, int i2) {
        return (short) getOrCreateLinkTable().checkExternSheet(i, i2);
    }

    public int getExternalSheetIndex(String str, String str2) {
        return getOrCreateLinkTable().getExternalSheetIndex(str, str2, str2);
    }

    public int getExternalSheetIndex(String str, String str2, String str3) {
        return getOrCreateLinkTable().getExternalSheetIndex(str, str2, str3);
    }

    public int getNumNames() {
        LinkTable linkTable = this.linkTable;
        if (linkTable == null) {
            return 0;
        }
        return linkTable.getNumNames();
    }

    public NameRecord getNameRecord(int i) {
        return this.linkTable.getNameRecord(i);
    }

    public NameCommentRecord getNameCommentRecord(NameRecord nameRecord) {
        return this.commentRecords.get(nameRecord.getNameText());
    }

    public NameRecord createName() {
        return addName(new NameRecord());
    }

    public NameRecord addName(NameRecord nameRecord) {
        getOrCreateLinkTable().addName(nameRecord);
        return nameRecord;
    }

    public NameRecord createBuiltInName(byte b, int i) {
        if (i < 0 || i + 1 > 32767) {
            throw new IllegalArgumentException("Sheet number [" + i + "]is not valid ");
        }
        NameRecord nameRecord = new NameRecord(b, i);
        if (this.linkTable.nameAlreadyExists(nameRecord)) {
            throw new RuntimeException("Builtin (" + ((int) b) + ") already exists for sheet (" + i + ")");
        }
        addName(nameRecord);
        return nameRecord;
    }

    public void removeName(int i) {
        if (this.linkTable.getNumNames() > i) {
            this.records.remove(findFirstRecordLocBySid((short) 24) + i);
            this.linkTable.removeName(i);
        }
    }

    public void updateNameCommentRecordCache(NameCommentRecord nameCommentRecord) {
        if (this.commentRecords.containsValue(nameCommentRecord)) {
            Iterator<Map.Entry<String, NameCommentRecord>> it = this.commentRecords.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, NameCommentRecord> next = it.next();
                if (next.getValue().equals(nameCommentRecord)) {
                    this.commentRecords.remove(next.getKey());
                    break;
                }
            }
        }
        this.commentRecords.put(nameCommentRecord.getNameText(), nameCommentRecord);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        return (short) r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public short getFormat(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            java.util.List<org.apache.poi.hssf.record.FormatRecord> r0 = r3.formats
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L22
            java.lang.Object r1 = r0.next()
            org.apache.poi.hssf.record.FormatRecord r1 = (org.apache.poi.hssf.record.FormatRecord) r1
            java.lang.String r2 = r1.getFormatString()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L6
            int r4 = r1.getIndexCode()
        L20:
            short r4 = (short) r4
            return r4
        L22:
            if (r5 == 0) goto L29
            int r4 = r3.createFormat(r4)
            goto L20
        L29:
            r4 = -1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.hssf.model.InternalWorkbook.getFormat(java.lang.String, boolean):short");
    }

    public List<FormatRecord> getFormats() {
        return this.formats;
    }

    public int createFormat(String str) {
        int i = this.maxformatid;
        this.maxformatid = i >= 164 ? i + 1 : 164;
        FormatRecord formatRecord = new FormatRecord(this.maxformatid, str);
        int i2 = 0;
        while (i2 < this.records.size() && this.records.get(i2).getSid() != 1054) {
            i2++;
        }
        int size = i2 + this.formats.size();
        this.formats.add(formatRecord);
        this.records.add(size, formatRecord);
        return this.maxformatid;
    }

    public Record findFirstRecordBySid(short s) {
        Iterator<Record> it = this.records.iterator();
        while (it.hasNext()) {
            Record next = it.next();
            if (next.getSid() == s) {
                return next;
            }
        }
        return null;
    }

    public int findFirstRecordLocBySid(short s) {
        Iterator<Record> it = this.records.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getSid() == s) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public Record findNextRecordBySid(short s, int i) {
        Iterator<Record> it = this.records.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Record next = it.next();
            if (next.getSid() == s) {
                int i3 = i2 + 1;
                if (i2 == i) {
                    return next;
                }
                i2 = i3;
            }
        }
        return null;
    }

    public List<HyperlinkRecord> getHyperlinks() {
        return this.hyperlinks;
    }

    public List<Record> getRecords() {
        return this.records.getRecords();
    }

    public boolean isUsing1904DateWindowing() {
        return this.uses1904datewindowing;
    }

    public PaletteRecord getCustomPalette() {
        int palettepos = this.records.getPalettepos();
        if (palettepos != -1) {
            Record record = this.records.get(palettepos);
            if (record instanceof PaletteRecord) {
                return (PaletteRecord) record;
            }
            throw new RuntimeException("InternalError: Expected PaletteRecord but got a '" + record + "'");
        }
        PaletteRecord createPalette = createPalette();
        this.records.add(1, createPalette);
        this.records.setPalettepos(1);
        return createPalette;
    }

    public DrawingManager2 findDrawingGroup() {
        DrawingManager2 drawingManager2 = this.drawingManager;
        if (drawingManager2 != null) {
            return drawingManager2;
        }
        Iterator<Record> it = this.records.iterator();
        while (true) {
            EscherDggRecord escherDggRecord = null;
            if (it.hasNext()) {
                Record next = it.next();
                if (next instanceof DrawingGroupRecord) {
                    DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord) next;
                    drawingGroupRecord.processChildRecords();
                    EscherContainerRecord escherContainer = drawingGroupRecord.getEscherContainer();
                    if (escherContainer == null) {
                        continue;
                    } else {
                        Iterator<EscherRecord> childIterator = escherContainer.getChildIterator();
                        EscherContainerRecord escherContainerRecord = null;
                        while (childIterator.hasNext()) {
                            EscherRecord next2 = childIterator.next();
                            if (next2 instanceof EscherDggRecord) {
                                escherDggRecord = (EscherDggRecord) next2;
                            } else if (next2.getRecordId() == -4095) {
                                escherContainerRecord = (EscherContainerRecord) next2;
                            }
                        }
                        if (escherDggRecord != null) {
                            this.drawingManager = new DrawingManager2(escherDggRecord);
                            if (escherContainerRecord != null) {
                                for (EscherRecord escherRecord : escherContainerRecord.getChildRecords()) {
                                    if (escherRecord instanceof EscherBSERecord) {
                                        this.escherBSERecords.add((EscherBSERecord) escherRecord);
                                    }
                                }
                            }
                            return this.drawingManager;
                        }
                    }
                }
            } else {
                int findFirstRecordLocBySid = findFirstRecordLocBySid(DrawingGroupRecord.sid);
                if (findFirstRecordLocBySid != -1) {
                    EscherContainerRecord escherContainerRecord2 = null;
                    for (EscherRecord escherRecord2 : ((DrawingGroupRecord) this.records.get(findFirstRecordLocBySid)).getEscherRecords()) {
                        if (escherRecord2 instanceof EscherDggRecord) {
                            escherDggRecord = (EscherDggRecord) escherRecord2;
                        } else if (escherRecord2.getRecordId() == -4095) {
                            escherContainerRecord2 = (EscherContainerRecord) escherRecord2;
                        }
                    }
                    if (escherDggRecord != null) {
                        this.drawingManager = new DrawingManager2(escherDggRecord);
                        if (escherContainerRecord2 != null) {
                            for (EscherRecord escherRecord3 : escherContainerRecord2.getChildRecords()) {
                                if (escherRecord3 instanceof EscherBSERecord) {
                                    this.escherBSERecords.add((EscherBSERecord) escherRecord3);
                                }
                            }
                        }
                    }
                }
                return this.drawingManager;
            }
        }
    }

    public void createDrawingGroup() {
        if (this.drawingManager == null) {
            EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
            EscherDggRecord escherDggRecord = new EscherDggRecord();
            EscherOptRecord escherOptRecord = new EscherOptRecord();
            EscherSplitMenuColorsRecord escherSplitMenuColorsRecord = new EscherSplitMenuColorsRecord();
            escherContainerRecord.setRecordId(EscherContainerRecord.DGG_CONTAINER);
            escherContainerRecord.setOptions((short) 15);
            escherDggRecord.setRecordId(EscherDggRecord.RECORD_ID);
            escherDggRecord.setOptions((short) 0);
            escherDggRecord.setShapeIdMax(1024);
            escherDggRecord.setNumShapesSaved(0);
            escherDggRecord.setDrawingsSaved(0);
            escherDggRecord.setFileIdClusters(new EscherDggRecord.FileIdCluster[0]);
            this.drawingManager = new DrawingManager2(escherDggRecord);
            EscherContainerRecord escherContainerRecord2 = null;
            if (this.escherBSERecords.size() > 0) {
                escherContainerRecord2 = new EscherContainerRecord();
                escherContainerRecord2.setRecordId(EscherContainerRecord.BSTORE_CONTAINER);
                escherContainerRecord2.setOptions((short) (15 | (this.escherBSERecords.size() << 4)));
                Iterator<EscherBSERecord> it = this.escherBSERecords.iterator();
                while (it.hasNext()) {
                    escherContainerRecord2.addChildRecord(it.next());
                }
            }
            escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
            escherOptRecord.setOptions((short) 51);
            escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 191, 524296));
            escherOptRecord.addEscherProperty(new EscherRGBProperty(EscherProperties.FILL__FILLCOLOR, 134217793));
            escherOptRecord.addEscherProperty(new EscherRGBProperty(EscherProperties.LINESTYLE__COLOR, HSSFShape.LINESTYLE__COLOR_DEFAULT));
            escherSplitMenuColorsRecord.setRecordId(EscherSplitMenuColorsRecord.RECORD_ID);
            escherSplitMenuColorsRecord.setOptions((short) 64);
            escherSplitMenuColorsRecord.setColor1(134217741);
            escherSplitMenuColorsRecord.setColor2(134217740);
            escherSplitMenuColorsRecord.setColor3(134217751);
            escherSplitMenuColorsRecord.setColor4(268435703);
            escherContainerRecord.addChildRecord(escherDggRecord);
            if (escherContainerRecord2 != null) {
                escherContainerRecord.addChildRecord(escherContainerRecord2);
            }
            escherContainerRecord.addChildRecord(escherOptRecord);
            escherContainerRecord.addChildRecord(escherSplitMenuColorsRecord);
            int findFirstRecordLocBySid = findFirstRecordLocBySid(DrawingGroupRecord.sid);
            if (findFirstRecordLocBySid == -1) {
                DrawingGroupRecord drawingGroupRecord = new DrawingGroupRecord();
                drawingGroupRecord.addEscherRecord(escherContainerRecord);
                getRecords().add(findFirstRecordLocBySid((short) 140) + 1, drawingGroupRecord);
                return;
            }
            DrawingGroupRecord drawingGroupRecord2 = new DrawingGroupRecord();
            drawingGroupRecord2.addEscherRecord(escherContainerRecord);
            getRecords().set(findFirstRecordLocBySid, drawingGroupRecord2);
        }
    }

    public WindowOneRecord getWindowOne() {
        return this.windowOne;
    }

    public EscherBSERecord getBSERecord(int i) {
        return this.escherBSERecords.get(i - 1);
    }

    public int addBSERecord(EscherBSERecord escherBSERecord) {
        EscherContainerRecord escherContainerRecord;
        createDrawingGroup();
        this.escherBSERecords.add(escherBSERecord);
        EscherContainerRecord escherContainerRecord2 = (EscherContainerRecord) ((DrawingGroupRecord) getRecords().get(findFirstRecordLocBySid(DrawingGroupRecord.sid))).getEscherRecord(0);
        if (escherContainerRecord2.getChild(1).getRecordId() == -4095) {
            escherContainerRecord = (EscherContainerRecord) escherContainerRecord2.getChild(1);
        } else {
            EscherContainerRecord escherContainerRecord3 = new EscherContainerRecord();
            escherContainerRecord3.setRecordId(EscherContainerRecord.BSTORE_CONTAINER);
            List<EscherRecord> childRecords = escherContainerRecord2.getChildRecords();
            childRecords.add(1, escherContainerRecord3);
            escherContainerRecord2.setChildRecords(childRecords);
            escherContainerRecord = escherContainerRecord3;
        }
        escherContainerRecord.setOptions((short) ((this.escherBSERecords.size() << 4) | 15));
        escherContainerRecord.addChildRecord(escherBSERecord);
        return this.escherBSERecords.size();
    }

    public DrawingManager2 getDrawingManager() {
        return this.drawingManager;
    }

    public WriteProtectRecord getWriteProtect() {
        if (this.writeProtect == null) {
            this.writeProtect = new WriteProtectRecord();
            int i = 0;
            while (i < this.records.size() && !(this.records.get(i) instanceof BOFRecord)) {
                i++;
            }
            this.records.add(i + 1, this.writeProtect);
        }
        return this.writeProtect;
    }

    public WriteAccessRecord getWriteAccess() {
        if (this.writeAccess == null) {
            this.writeAccess = createWriteAccess();
            int i = 0;
            while (i < this.records.size() && !(this.records.get(i) instanceof InterfaceEndRecord)) {
                i++;
            }
            this.records.add(i + 1, this.writeAccess);
        }
        return this.writeAccess;
    }

    public FileSharingRecord getFileSharing() {
        if (this.fileShare == null) {
            this.fileShare = new FileSharingRecord();
            int i = 0;
            while (i < this.records.size() && !(this.records.get(i) instanceof WriteAccessRecord)) {
                i++;
            }
            this.records.add(i + 1, this.fileShare);
        }
        return this.fileShare;
    }

    public boolean isWriteProtected() {
        return this.fileShare != null && getFileSharing().getReadOnly() == 1;
    }

    public void writeProtectWorkbook(String str, String str2) {
        FileSharingRecord fileSharing = getFileSharing();
        WriteAccessRecord writeAccess = getWriteAccess();
        getWriteProtect();
        fileSharing.setReadOnly((short) 1);
        fileSharing.setPassword(FileSharingRecord.hashPassword(str));
        fileSharing.setUsername(str2);
        writeAccess.setUsername(str2);
    }

    public void unwriteProtectWorkbook() {
        this.records.remove(this.fileShare);
        this.records.remove(this.writeProtect);
        this.fileShare = null;
        this.writeProtect = null;
    }

    public String resolveNameXText(int i, int i2) {
        return this.linkTable.resolveNameXText(i, i2, this);
    }

    public NameXPtg getNameXPtg(String str, int i, UDFFinder uDFFinder) {
        LinkTable orCreateLinkTable = getOrCreateLinkTable();
        NameXPtg nameXPtg = orCreateLinkTable.getNameXPtg(str, i);
        return (nameXPtg != null || uDFFinder.findFunction(str) == null) ? nameXPtg : orCreateLinkTable.addNameXPtg(str);
    }

    public NameXPtg getNameXPtg(String str, UDFFinder uDFFinder) {
        return getNameXPtg(str, -1, uDFFinder);
    }

    public void cloneDrawings(InternalSheet internalSheet) {
        EscherContainerRecord escherContainer;
        EscherSimpleProperty escherSimpleProperty;
        findDrawingGroup();
        DrawingManager2 drawingManager2 = this.drawingManager;
        if (drawingManager2 == null || internalSheet.aggregateDrawingRecords(drawingManager2, false) == -1 || (escherContainer = ((EscherAggregate) internalSheet.findFirstRecordBySid(EscherAggregate.sid)).getEscherContainer()) == null) {
            return;
        }
        EscherDggRecord dgg = this.drawingManager.getDgg();
        short findNewDrawingGroupId = this.drawingManager.findNewDrawingGroupId();
        dgg.addCluster(findNewDrawingGroupId, 0);
        dgg.setDrawingsSaved(dgg.getDrawingsSaved() + 1);
        EscherDgRecord escherDgRecord = null;
        Iterator<EscherRecord> childIterator = escherContainer.getChildIterator();
        while (childIterator.hasNext()) {
            EscherRecord next = childIterator.next();
            if (next instanceof EscherDgRecord) {
                EscherDgRecord escherDgRecord2 = (EscherDgRecord) next;
                escherDgRecord2.setOptions((short) (findNewDrawingGroupId << 4));
                escherDgRecord = escherDgRecord2;
            } else if (next instanceof EscherContainerRecord) {
                Iterator<EscherRecord> it = ((EscherContainerRecord) next).getChildRecords().iterator();
                while (it.hasNext()) {
                    for (EscherRecord escherRecord : ((EscherContainerRecord) it.next()).getChildRecords()) {
                        short recordId = escherRecord.getRecordId();
                        if (recordId == -4086) {
                            int allocateShapeId = this.drawingManager.allocateShapeId(findNewDrawingGroupId, escherDgRecord);
                            escherDgRecord.setNumShapes(escherDgRecord.getNumShapes() - 1);
                            ((EscherSpRecord) escherRecord).setShapeId(allocateShapeId);
                        } else if (recordId == -4085 && (escherSimpleProperty = (EscherSimpleProperty) ((EscherOptRecord) escherRecord).lookup(260)) != null) {
                            EscherBSERecord bSERecord = getBSERecord(escherSimpleProperty.getPropertyValue());
                            bSERecord.setRef(bSERecord.getRef() + 1);
                        }
                    }
                }
            }
        }
    }

    public NameRecord cloneFilter(int i, int i2) {
        NameRecord nameRecord = getNameRecord(i);
        short checkExternSheet = checkExternSheet(i2);
        Ptg[] nameDefinition = nameRecord.getNameDefinition();
        for (int i3 = 0; i3 < nameDefinition.length; i3++) {
            Ptg ptg = nameDefinition[i3];
            if (ptg instanceof Area3DPtg) {
                Area3DPtg area3DPtg = (Area3DPtg) ((OperandPtg) ptg).copy();
                area3DPtg.setExternSheetIndex(checkExternSheet);
                nameDefinition[i3] = area3DPtg;
            } else if (ptg instanceof Ref3DPtg) {
                Ref3DPtg ref3DPtg = (Ref3DPtg) ((OperandPtg) ptg).copy();
                ref3DPtg.setExternSheetIndex(checkExternSheet);
                nameDefinition[i3] = ref3DPtg;
            }
        }
        NameRecord createBuiltInName = createBuiltInName((byte) 13, i2 + 1);
        createBuiltInName.setNameDefinition(nameDefinition);
        createBuiltInName.setHidden(true);
        return createBuiltInName;
    }

    public void updateNamesAfterCellShift(FormulaShifter formulaShifter) {
        for (int i = 0; i < getNumNames(); i++) {
            NameRecord nameRecord = getNameRecord(i);
            Ptg[] nameDefinition = nameRecord.getNameDefinition();
            if (formulaShifter.adjustFormula(nameDefinition, nameRecord.getSheetNumber())) {
                nameRecord.setNameDefinition(nameDefinition);
            }
        }
    }

    public RecalcIdRecord getRecalcId() {
        RecalcIdRecord recalcIdRecord = (RecalcIdRecord) findFirstRecordBySid((short) 449);
        if (recalcIdRecord != null) {
            return recalcIdRecord;
        }
        RecalcIdRecord recalcIdRecord2 = new RecalcIdRecord();
        this.records.add(findFirstRecordLocBySid((short) 140) + 1, recalcIdRecord2);
        return recalcIdRecord2;
    }

    public boolean changeExternalReference(String str, String str2) {
        return this.linkTable.changeExternalReference(str, str2);
    }
}
