package org.apache.poi.hssf.usermodel;

import com.ipotensic.baselib.configs.UsbConfig;
import com.logan.upgrade.local.flight.recv.UpgradeRevShakeHandData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import jxl.biff.BaseCompoundFile;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIDocument;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.AbstractEscherHolderRecord;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.RecalcIdRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.poifs.filesystem.FilteringDirectoryNode;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.Configurator;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class HSSFWorkbook extends POIDocument implements Workbook {
    private static final int DEBUG = 1;
    private static final int MAX_STYLES = 4030;
    protected List<HSSFSheet> _sheets;
    private UDFFinder _udfFinder;
    private Hashtable<Short, HSSFFont> fonts;
    private HSSFDataFormat formatter;
    private Row.MissingCellPolicy missingCellPolicy;
    private ArrayList<HSSFName> names;
    private boolean preserveNodes;
    private InternalWorkbook workbook;
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFWorkbook.SheetInitialCapacity", 3);
    private static POILogger log = POILogFactory.getLogger((Class<?>) HSSFWorkbook.class);
    private static final String[] WORKBOOK_DIR_ENTRY_NAMES = {BaseCompoundFile.WORKBOOK_NAME, "WORKBOOK", "BOOK"};

    public static HSSFWorkbook create(InternalWorkbook internalWorkbook) {
        return new HSSFWorkbook(internalWorkbook);
    }

    public HSSFWorkbook() {
        this(InternalWorkbook.createWorkbook());
    }

    private HSSFWorkbook(InternalWorkbook internalWorkbook) {
        super((DirectoryNode) null);
        this.missingCellPolicy = HSSFRow.RETURN_NULL_AND_BLANK;
        this._udfFinder = new IndexedUDFFinder(UDFFinder.DEFAULT);
        this.workbook = internalWorkbook;
        int i = INITIAL_CAPACITY;
        this._sheets = new ArrayList(i);
        this.names = new ArrayList<>(i);
    }

    public HSSFWorkbook(POIFSFileSystem pOIFSFileSystem) throws IOException {
        this(pOIFSFileSystem, true);
    }

    public HSSFWorkbook(POIFSFileSystem pOIFSFileSystem, boolean z) throws IOException {
        this(pOIFSFileSystem.getRoot(), pOIFSFileSystem, z);
    }

    public static String getWorkbookDirEntryName(DirectoryNode directoryNode) {
        int i = 0;
        while (true) {
            String[] strArr = WORKBOOK_DIR_ENTRY_NAMES;
            if (i < strArr.length) {
                String str = strArr[i];
                try {
                    directoryNode.getEntry(str);
                    return str;
                } catch (FileNotFoundException unused) {
                    i++;
                }
            } else {
                try {
                    try {
                        directoryNode.getEntry(Decryptor.DEFAULT_POIFS_ENTRY);
                        throw new EncryptedDocumentException("The supplied spreadsheet seems to be an Encrypted .xlsx file. It must be decrypted before use by XSSF, it cannot be used by HSSF");
                    } catch (FileNotFoundException unused2) {
                        directoryNode.getEntry("Book");
                        throw new OldExcelFormatException("The supplied spreadsheet seems to be Excel 5.0/7.0 (BIFF5) format. POI only supports BIFF8 format (from Excel versions 97/2000/XP/2003)");
                    }
                } catch (FileNotFoundException unused3) {
                    throw new IllegalArgumentException("The supplied POIFSFileSystem does not contain a BIFF8 'Workbook' entry. Is it really an excel file?");
                }
            }
        }
    }

    public HSSFWorkbook(DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem, boolean z) throws IOException {
        this(directoryNode, z);
    }

    public HSSFWorkbook(DirectoryNode directoryNode, boolean z) throws IOException {
        super(directoryNode);
        this.missingCellPolicy = HSSFRow.RETURN_NULL_AND_BLANK;
        this._udfFinder = new IndexedUDFFinder(UDFFinder.DEFAULT);
        String workbookDirEntryName = getWorkbookDirEntryName(directoryNode);
        this.preserveNodes = z;
        if (!z) {
            this.directory = null;
        }
        int i = INITIAL_CAPACITY;
        this._sheets = new ArrayList(i);
        this.names = new ArrayList<>(i);
        List<Record> createRecords = RecordFactory.createRecords(directoryNode.createDocumentInputStream(workbookDirEntryName));
        InternalWorkbook createWorkbook = InternalWorkbook.createWorkbook(createRecords);
        this.workbook = createWorkbook;
        setPropertiesFromWorkbook(createWorkbook);
        int numRecords = this.workbook.getNumRecords();
        convertLabelRecords(createRecords, numRecords);
        RecordStream recordStream = new RecordStream(createRecords, numRecords);
        while (recordStream.hasNext()) {
            try {
                this._sheets.add(new HSSFSheet(this, InternalSheet.createSheet(recordStream)));
            } catch (InternalSheet.UnsupportedBOFType e) {
                log.log(5, "Unsupported BOF found of type " + e.getType());
            }
        }
        for (int i2 = 0; i2 < this.workbook.getNumNames(); i2++) {
            NameRecord nameRecord = this.workbook.getNameRecord(i2);
            this.names.add(new HSSFName(this, nameRecord, this.workbook.getNameCommentRecord(nameRecord)));
        }
    }

    public HSSFWorkbook(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public HSSFWorkbook(InputStream inputStream, boolean z) throws IOException {
        this(new POIFSFileSystem(inputStream), z);
    }

    private void setPropertiesFromWorkbook(InternalWorkbook internalWorkbook) {
        this.workbook = internalWorkbook;
    }

    private void convertLabelRecords(List<Record> list, int i) {
        if (log.check(1)) {
            log.log(1, "convertLabelRecords called");
        }
        while (i < list.size()) {
            Record record = list.get(i);
            if (record.getSid() == 516) {
                LabelRecord labelRecord = (LabelRecord) record;
                list.remove(i);
                LabelSSTRecord labelSSTRecord = new LabelSSTRecord();
                int addSSTString = this.workbook.addSSTString(new UnicodeString(labelRecord.getValue()));
                labelSSTRecord.setRow(labelRecord.getRow());
                labelSSTRecord.setColumn(labelRecord.getColumn());
                labelSSTRecord.setXFIndex(labelRecord.getXFIndex());
                labelSSTRecord.setSSTIndex(addSSTString);
                list.add(i, labelSSTRecord);
            }
            i++;
        }
        if (log.check(1)) {
            log.log(1, "convertLabelRecords exit");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this.missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this.missingCellPolicy = missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i) {
        int sheetIndex = getSheetIndex(str);
        List<HSSFSheet> list = this._sheets;
        list.add(i, list.remove(sheetIndex));
        this.workbook.setSheetOrder(str, i);
        FormulaShifter createForSheetShift = FormulaShifter.createForSheetShift(sheetIndex, i);
        Iterator<HSSFSheet> it = this._sheets.iterator();
        while (it.hasNext()) {
            it.next().getSheet().updateFormulasAfterCellShift(createForSheetShift, -1);
        }
        this.workbook.updateNamesAfterCellShift(createForSheetShift);
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == sheetIndex) {
            setActiveSheet(i);
            return;
        }
        if (activeSheetIndex >= sheetIndex || activeSheetIndex >= i) {
            if (activeSheetIndex <= sheetIndex || activeSheetIndex <= i) {
                if (i > sheetIndex) {
                    setActiveSheet(activeSheetIndex - 1);
                } else {
                    setActiveSheet(activeSheetIndex + 1);
                }
            }
        }
    }

    private void validateSheetIndex(int i) {
        int size = this._sheets.size() - 1;
        if (i < 0 || i > size) {
            String str = "(0.." + size + ")";
            if (size == -1) {
                str = "(no sheets)";
            }
            throw new IllegalArgumentException("Sheet index (" + i + ") is out of range " + str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i) {
        validateSheetIndex(i);
        int size = this._sheets.size();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < size) {
                HSSFSheet sheetAt = getSheetAt(i2);
                if (i2 != i) {
                    z = false;
                }
                sheetAt.setSelected(z);
                i2++;
            } else {
                this.workbook.getWindowOne().setNumSelectedTabs((short) 1);
                return;
            }
        }
    }

    @Deprecated
    public void setSelectedTab(short s) {
        setSelectedTab((int) s);
    }

    public void setSelectedTabs(int[] iArr) {
        boolean z;
        for (int i : iArr) {
            validateSheetIndex(i);
        }
        int size = this._sheets.size();
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= iArr.length) {
                    z = false;
                    break;
                } else {
                    if (iArr[i3] == i2) {
                        z = true;
                        break;
                    }
                    i3++;
                }
            }
            getSheetAt(i2).setSelected(z);
        }
        this.workbook.getWindowOne().setNumSelectedTabs((short) iArr.length);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i) {
        validateSheetIndex(i);
        int size = this._sheets.size();
        int i2 = 0;
        while (i2 < size) {
            getSheetAt(i2).setActive(i2 == i);
            i2++;
        }
        this.workbook.getWindowOne().setActiveSheetIndex(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return this.workbook.getWindowOne().getActiveSheetIndex();
    }

    @Deprecated
    public short getSelectedTab() {
        return (short) getActiveSheetIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i) {
        this.workbook.getWindowOne().setFirstVisibleTab(i);
    }

    @Deprecated
    public void setDisplayedTab(short s) {
        setFirstVisibleTab(s);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return this.workbook.getWindowOne().getFirstVisibleTab();
    }

    @Deprecated
    public short getDisplayedTab() {
        return (short) getFirstVisibleTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetName(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        if (this.workbook.doesContainsSheetName(str, i)) {
            throw new IllegalArgumentException("The workbook already contains a sheet with this name");
        }
        validateSheetIndex(i);
        this.workbook.setSheetName(i, str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i) {
        validateSheetIndex(i);
        return this.workbook.getSheetName(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isHidden() {
        return this.workbook.getWindowOne().getHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setHidden(boolean z) {
        this.workbook.getWindowOne().setHidden(z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i) {
        validateSheetIndex(i);
        return this.workbook.isSheetHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i) {
        validateSheetIndex(i);
        return this.workbook.isSheetVeryHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, boolean z) {
        validateSheetIndex(i);
        this.workbook.setSheetHidden(i, z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, int i2) {
        validateSheetIndex(i);
        WorkbookUtil.validateSheetState(i2);
        this.workbook.setSheetHidden(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        return this.workbook.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        for (int i = 0; i < this._sheets.size(); i++) {
            if (this._sheets.get(i) == sheet) {
                return i;
            }
        }
        return -1;
    }

    @Deprecated
    public int getExternalSheetIndex(int i) {
        return this.workbook.checkExternSheet(i);
    }

    @Deprecated
    public String findSheetNameFromExternSheet(int i) {
        return this.workbook.findSheetFirstNameFromExternSheet(i);
    }

    @Deprecated
    public String resolveNameXText(int i, int i2) {
        return this.workbook.resolveNameXText(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet createSheet() {
        HSSFSheet hSSFSheet = new HSSFSheet(this);
        this._sheets.add(hSSFSheet);
        this.workbook.setSheetName(this._sheets.size() - 1, "Sheet" + (this._sheets.size() - 1));
        boolean z = this._sheets.size() == 1;
        hSSFSheet.setSelected(z);
        hSSFSheet.setActive(z);
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet cloneSheet(int i) {
        validateSheetIndex(i);
        HSSFSheet hSSFSheet = this._sheets.get(i);
        String sheetName = this.workbook.getSheetName(i);
        HSSFSheet cloneSheet = hSSFSheet.cloneSheet(this);
        cloneSheet.setSelected(false);
        cloneSheet.setActive(false);
        String uniqueSheetName = getUniqueSheetName(sheetName);
        int size = this._sheets.size();
        this._sheets.add(cloneSheet);
        this.workbook.setSheetName(size, uniqueSheetName);
        int findExistingBuiltinNameRecordIdx = findExistingBuiltinNameRecordIdx(i, (byte) 13);
        if (findExistingBuiltinNameRecordIdx != -1) {
            this.names.add(new HSSFName(this, this.workbook.cloneFilter(findExistingBuiltinNameRecordIdx, size)));
        }
        return cloneSheet;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091 A[LOOP:0: B:13:0x0032->B:18:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getUniqueSheetName(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 40
            int r0 = r9.lastIndexOf(r0)
            r1 = 0
            java.lang.String r2 = ")"
            r3 = 2
            if (r0 <= 0) goto L31
            boolean r4 = r9.endsWith(r2)
            if (r4 == 0) goto L31
            int r4 = r0 + 1
            int r5 = r9.length()
            int r5 = r5 + (-1)
            java.lang.String r4 = r9.substring(r4, r5)
            java.lang.String r4 = r4.trim()     // Catch: java.lang.NumberFormatException -> L31
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L31
            int r4 = r4 + 1
            java.lang.String r0 = r9.substring(r1, r0)     // Catch: java.lang.NumberFormatException -> L32
            java.lang.String r9 = r0.trim()     // Catch: java.lang.NumberFormatException -> L32
            goto L32
        L31:
            r4 = r3
        L32:
            int r0 = r4 + 1
            java.lang.String r4 = java.lang.Integer.toString(r4)
            int r5 = r9.length()
            int r6 = r4.length()
            int r5 = r5 + r6
            int r5 = r5 + r3
            r6 = 31
            if (r5 >= r6) goto L62
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r6 = " ("
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r4 = r4.toString()
            goto L87
        L62:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r7 = r4.length()
            int r6 = r6 - r7
            int r6 = r6 - r3
            java.lang.String r6 = r9.substring(r1, r6)
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = "("
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r4 = r4.toString()
        L87:
            org.apache.poi.hssf.model.InternalWorkbook r5 = r8.workbook
            int r5 = r5.getSheetIndex(r4)
            r6 = -1
            if (r5 != r6) goto L91
            return r4
        L91:
            r4 = r0
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.hssf.usermodel.HSSFWorkbook.getUniqueSheetName(java.lang.String):java.lang.String");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet createSheet(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        if (this.workbook.doesContainsSheetName(str, this._sheets.size())) {
            throw new IllegalArgumentException("The workbook already contains a sheet of this name");
        }
        HSSFSheet hSSFSheet = new HSSFSheet(this);
        this.workbook.setSheetName(this._sheets.size(), str);
        this._sheets.add(hSSFSheet);
        boolean z = this._sheets.size() == 1;
        hSSFSheet.setSelected(z);
        hSSFSheet.setActive(z);
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this._sheets.size();
    }

    @Deprecated
    public int getSheetIndexFromExternSheetIndex(int i) {
        return this.workbook.getFirstSheetIndexFromExternSheetIndex(i);
    }

    private HSSFSheet[] getSheets() {
        HSSFSheet[] hSSFSheetArr = new HSSFSheet[this._sheets.size()];
        this._sheets.toArray(hSSFSheetArr);
        return hSSFSheetArr;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet getSheetAt(int i) {
        validateSheetIndex(i);
        return this._sheets.get(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet getSheet(String str) {
        HSSFSheet hSSFSheet = null;
        for (int i = 0; i < this._sheets.size(); i++) {
            if (this.workbook.getSheetName(i).equalsIgnoreCase(str)) {
                hSSFSheet = this._sheets.get(i);
            }
        }
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i) {
        validateSheetIndex(i);
        boolean isSelected = getSheetAt(i).isSelected();
        this._sheets.remove(i);
        this.workbook.removeSheet(i);
        int size = this._sheets.size();
        if (size < 1) {
            return;
        }
        int i2 = i >= size ? size - 1 : i;
        if (isSelected) {
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (getSheetAt(i3).isSelected()) {
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                setSelectedTab(i2);
            }
        }
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i) {
            setActiveSheet(i2);
        } else if (activeSheetIndex > i) {
            setActiveSheet(activeSheetIndex - 1);
        }
    }

    public void setBackupFlag(boolean z) {
        this.workbook.getBackupRecord().setBackup(z ? (short) 1 : (short) 0);
    }

    public boolean getBackupFlag() {
        return this.workbook.getBackupRecord().getBackup() != 0;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Deprecated
    public void setRepeatingRowsAndColumns(int i, int i2, int i3, int i4, int i5) {
        HSSFSheet sheetAt = getSheetAt(i);
        CellRangeAddress cellRangeAddress = i4 != -1 ? new CellRangeAddress(i4, i5, -1, -1) : null;
        CellRangeAddress cellRangeAddress2 = i2 != -1 ? new CellRangeAddress(-1, -1, i2, i3) : null;
        sheetAt.setRepeatingRows(cellRangeAddress);
        sheetAt.setRepeatingColumns(cellRangeAddress2);
    }

    int findExistingBuiltinNameRecordIdx(int i, byte b) {
        for (int i2 = 0; i2 < this.names.size(); i2++) {
            NameRecord nameRecord = this.workbook.getNameRecord(i2);
            if (nameRecord == null) {
                throw new RuntimeException("Unable to find all defined names to iterate over");
            }
            if (nameRecord.isBuiltInName() && nameRecord.getBuiltInName() == b && nameRecord.getSheetNumber() - 1 == i) {
                return i2;
            }
        }
        return -1;
    }

    HSSFName createBuiltInName(byte b, int i) {
        HSSFName hSSFName = new HSSFName(this, this.workbook.createBuiltInName(b, i + 1), null);
        this.names.add(hSSFName);
        return hSSFName;
    }

    HSSFName getBuiltInName(byte b, int i) {
        int findExistingBuiltinNameRecordIdx = findExistingBuiltinNameRecordIdx(i, b);
        if (findExistingBuiltinNameRecordIdx < 0) {
            return null;
        }
        return this.names.get(findExistingBuiltinNameRecordIdx);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont createFont() {
        this.workbook.createNewFont();
        short numberOfFonts = (short) (getNumberOfFonts() - 1);
        if (numberOfFonts > 3) {
            numberOfFonts = (short) (numberOfFonts + 1);
        }
        if (numberOfFonts == Short.MAX_VALUE) {
            throw new IllegalArgumentException("Maximum number of fonts was exceeded");
        }
        return getFontAt(numberOfFonts);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont findFont(short s, short s2, short s3, String str, boolean z, boolean z2, short s4, byte b) {
        for (short s5 = 0; s5 <= getNumberOfFonts(); s5 = (short) (s5 + 1)) {
            if (s5 != 4) {
                HSSFFont fontAt = getFontAt(s5);
                if (fontAt.getBoldweight() == s && fontAt.getColor() == s2 && fontAt.getFontHeight() == s3 && fontAt.getFontName().equals(str) && fontAt.getItalic() == z && fontAt.getStrikeout() == z2 && fontAt.getTypeOffset() == s4 && fontAt.getUnderline() == b) {
                    return fontAt;
                }
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumberOfFonts() {
        return (short) this.workbook.getNumberOfFontRecords();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont getFontAt(short s) {
        if (this.fonts == null) {
            this.fonts = new Hashtable<>();
        }
        Short valueOf = Short.valueOf(s);
        if (this.fonts.containsKey(valueOf)) {
            return this.fonts.get(valueOf);
        }
        HSSFFont hSSFFont = new HSSFFont(s, this.workbook.getFontRecordAt(s));
        this.fonts.put(valueOf, hSSFFont);
        return hSSFFont;
    }

    protected void resetFontCache() {
        this.fonts = new Hashtable<>();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCellStyle createCellStyle() {
        if (this.workbook.getNumExFormats() == MAX_STYLES) {
            throw new IllegalStateException("The maximum number of cell styles was exceeded. You can define up to 4000 styles in a .xls workbook");
        }
        return new HSSFCellStyle((short) (getNumCellStyles() - 1), this.workbook.createCellXF(), this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumCellStyles() {
        return (short) this.workbook.getNumExFormats();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCellStyle getCellStyleAt(short s) {
        return new HSSFCellStyle(s, this.workbook.getExFormatAt(s), this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.directory == null || this.directory.getNFileSystem() == null) {
            return;
        }
        this.directory.getNFileSystem().close();
        this.directory = null;
    }

    @Override // org.apache.poi.POIDocument
    public void write(OutputStream outputStream) throws IOException {
        byte[] bytes = getBytes();
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        ArrayList arrayList = new ArrayList(1);
        pOIFSFileSystem.createDocument(new ByteArrayInputStream(bytes), BaseCompoundFile.WORKBOOK_NAME);
        writeProperties(pOIFSFileSystem, arrayList);
        if (this.preserveNodes) {
            arrayList.addAll(Arrays.asList(WORKBOOK_DIR_ENTRY_NAMES));
            EntryUtils.copyNodes(new FilteringDirectoryNode(this.directory, arrayList), new FilteringDirectoryNode(pOIFSFileSystem.getRoot(), arrayList));
            pOIFSFileSystem.getRoot().setStorageClsid(this.directory.getStorageClsid());
        }
        pOIFSFileSystem.writeFilesystem(outputStream);
    }

    private static final class SheetRecordCollector implements RecordAggregate.RecordVisitor {
        private int _totalSize = 0;
        private List<Record> _list = new ArrayList(128);

        public int getTotalSize() {
            return this._totalSize;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._list.add(record);
            this._totalSize += record.getRecordSize();
        }

        public int serialize(int i, byte[] bArr) {
            int size = this._list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i2 += this._list.get(i3).serialize(i + i2, bArr);
            }
            return i2;
        }
    }

    public byte[] getBytes() {
        if (log.check(1)) {
            log.log(1, "HSSFWorkbook.getBytes()");
        }
        HSSFSheet[] sheets = getSheets();
        int length = sheets.length;
        this.workbook.preSerialize();
        for (int i = 0; i < length; i++) {
            sheets[i].getSheet().preSerialize();
            sheets[i].preSerialize();
        }
        int size = this.workbook.getSize();
        SheetRecordCollector[] sheetRecordCollectorArr = new SheetRecordCollector[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.workbook.setSheetBof(i2, size);
            SheetRecordCollector sheetRecordCollector = new SheetRecordCollector();
            sheets[i2].getSheet().visitContainedRecords(sheetRecordCollector, size);
            size += sheetRecordCollector.getTotalSize();
            sheetRecordCollectorArr[i2] = sheetRecordCollector;
        }
        byte[] bArr = new byte[size];
        int serialize = this.workbook.serialize(0, bArr);
        for (int i3 = 0; i3 < length; i3++) {
            SheetRecordCollector sheetRecordCollector2 = sheetRecordCollectorArr[i3];
            int serialize2 = sheetRecordCollector2.serialize(serialize, bArr);
            if (serialize2 != sheetRecordCollector2.getTotalSize()) {
                throw new IllegalStateException("Actual serialized sheet size (" + serialize2 + ") differs from pre-calculated size (" + sheetRecordCollector2.getTotalSize() + ") for sheet (" + i3 + ")");
            }
            serialize += serialize2;
        }
        return bArr;
    }

    @Deprecated
    public int addSSTString(String str) {
        return this.workbook.addSSTString(new UnicodeString(str));
    }

    @Deprecated
    public String getSSTString(int i) {
        return this.workbook.getSSTString(i).getString();
    }

    InternalWorkbook getWorkbook() {
        return this.workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this.names.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFName getName(String str) {
        int nameIndex = getNameIndex(str);
        if (nameIndex < 0) {
            return null;
        }
        return this.names.get(nameIndex);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFName getNameAt(int i) {
        int size = this.names.size();
        if (size < 1) {
            throw new IllegalStateException("There are no defined names in this workbook");
        }
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("Specified name index " + i + " is outside the allowable range (0.." + (size - 1) + ").");
        }
        return this.names.get(i);
    }

    public NameRecord getNameRecord(int i) {
        return getWorkbook().getNameRecord(i);
    }

    public String getNameName(int i) {
        return getNameAt(i).getNameName();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, String str) {
        int i2 = i + 1;
        NameRecord specificBuiltinRecord = this.workbook.getSpecificBuiltinRecord((byte) 6, i2);
        if (specificBuiltinRecord == null) {
            specificBuiltinRecord = this.workbook.createBuiltInName((byte) 6, i2);
        }
        String[] split = COMMA_PATTERN.split(str);
        StringBuffer stringBuffer = new StringBuffer(32);
        for (int i3 = 0; i3 < split.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(",");
            }
            SheetNameFormatter.appendFormat(stringBuffer, getSheetName(i));
            stringBuffer.append("!");
            stringBuffer.append(split[i3]);
        }
        specificBuiltinRecord.setNameDefinition(HSSFFormulaParser.parse(stringBuffer.toString(), this, 4, i));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, int i2, int i3, int i4, int i5) {
        setPrintArea(i, new CellReference(i4, i2, true, true).formatAsString() + ":" + new CellReference(i5, i3, true, true).formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i) {
        NameRecord specificBuiltinRecord = this.workbook.getSpecificBuiltinRecord((byte) 6, i + 1);
        if (specificBuiltinRecord == null) {
            return null;
        }
        return HSSFFormulaParser.toFormulaString(this, specificBuiltinRecord.getNameDefinition());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i) {
        getWorkbook().removeBuiltinRecord((byte) 6, i + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFName createName() {
        HSSFName hSSFName = new HSSFName(this, this.workbook.createName());
        this.names.add(hSSFName);
        return hSSFName;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNameIndex(String str) {
        for (int i = 0; i < this.names.size(); i++) {
            if (getNameName(i).equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    int getNameIndex(HSSFName hSSFName) {
        for (int i = 0; i < this.names.size(); i++) {
            if (hSSFName == this.names.get(i)) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(int i) {
        this.names.remove(i);
        this.workbook.removeName(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFDataFormat createDataFormat() {
        if (this.formatter == null) {
            this.formatter = new HSSFDataFormat(this.workbook);
        }
        return this.formatter;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(String str) {
        removeName(getNameIndex(str));
    }

    void removeName(HSSFName hSSFName) {
        removeName(getNameIndex(hSSFName));
    }

    public HSSFPalette getCustomPalette() {
        return new HSSFPalette(this.workbook.getCustomPalette());
    }

    public void insertChartRecord() {
        this.workbook.getRecords().add(this.workbook.findFirstRecordLocBySid((short) 252), new UnknownRecord(235, new byte[]{15, 0, 0, -16, 82, 0, 0, 0, 0, 0, 6, -16, 24, 0, 0, 0, 1, 8, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, UsbConfig.REV_REMOTER_STATE, 0, 11, -16, 18, 0, 0, 0, -65, 0, 8, 0, 8, 0, -127, 1, 9, 0, 0, 8, -64, 1, 64, 0, 0, 8, 64, 0, 30, UpgradeRevShakeHandData.REV_REQUEST_CODE, 16, 0, 0, 0, 13, 0, 0, 8, 12, 0, 0, 8, 23, 0, 0, 8, -9, 0, 0, 16}));
    }

    public void dumpDrawingGroupRecords(boolean z) {
        DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord) this.workbook.findFirstRecordBySid(DrawingGroupRecord.sid);
        drawingGroupRecord.decode();
        List<EscherRecord> escherRecords = drawingGroupRecord.getEscherRecords();
        PrintWriter printWriter = new PrintWriter(System.out);
        for (EscherRecord escherRecord : escherRecords) {
            if (z) {
                System.out.println(escherRecord.toString());
            } else {
                escherRecord.display(printWriter, 0);
            }
        }
        printWriter.flush();
    }

    void initDrawings() {
        if (this.workbook.findDrawingGroup() != null) {
            for (int i = 0; i < getNumberOfSheets(); i++) {
                getSheetAt(i).getDrawingPatriarch();
            }
            return;
        }
        this.workbook.createDrawingGroup();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005e  */
    @Override // org.apache.poi.ss.usermodel.Workbook
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int addPicture(byte[] r8, int r9) {
        /*
            r7 = this;
            r7.initDrawings()
            byte[] r0 = org.apache.commons.codec.digest.DigestUtils.md5(r8)
            r1 = 2
            r2 = 0
            if (r9 == r1) goto L38
            r3 = 3
            if (r9 == r3) goto L23
            org.apache.poi.ddf.EscherBitmapBlip r3 = new org.apache.poi.ddf.EscherBitmapBlip
            r3.<init>()
            r3.setUID(r0)
            r4 = -1
            r3.setMarker(r4)
            r3.setPictureData(r8)
            int r8 = r8.length
            int r8 = r8 + 25
            r4 = 255(0xff, float:3.57E-43)
            goto L4e
        L23:
            int r3 = org.apache.poi.util.LittleEndian.getInt(r8)
            r4 = -1698247209(0xffffffff9ac6cdd7, float:-8.222343E-23)
            if (r3 != r4) goto L38
            int r3 = r8.length
            r4 = 22
            int r3 = r3 - r4
            byte[] r3 = new byte[r3]
            int r5 = r8.length
            int r5 = r5 - r4
            java.lang.System.arraycopy(r8, r4, r3, r2, r5)
            r8 = r3
        L38:
            org.apache.poi.ddf.EscherMetafileBlip r3 = new org.apache.poi.ddf.EscherMetafileBlip
            r3.<init>()
            r3.setUID(r0)
            r3.setPictureData(r8)
            r8 = -2
            r3.setFilter(r8)
            int r8 = r3.getCompressedSize()
            int r8 = r8 + 58
            r4 = r2
        L4e:
            int r5 = r9 + (-4072)
            short r5 = (short) r5
            r3.setRecordId(r5)
            switch(r9) {
                case 2: goto L76;
                case 3: goto L70;
                case 4: goto L6a;
                case 5: goto L64;
                case 6: goto L5e;
                case 7: goto L58;
                default: goto L57;
            }
        L57:
            goto L7b
        L58:
            r5 = 31360(0x7a80, float:4.3945E-41)
            r3.setOptions(r5)
            goto L7b
        L5e:
            r5 = 28160(0x6e00, float:3.946E-41)
            r3.setOptions(r5)
            goto L7b
        L64:
            r5 = 18080(0x46a0, float:2.5335E-41)
            r3.setOptions(r5)
            goto L7b
        L6a:
            r5 = 21536(0x5420, float:3.0178E-41)
            r3.setOptions(r5)
            goto L7b
        L70:
            r5 = 8544(0x2160, float:1.1973E-41)
            r3.setOptions(r5)
            goto L7b
        L76:
            r5 = 15680(0x3d40, float:2.1972E-41)
            r3.setOptions(r5)
        L7b:
            org.apache.poi.ddf.EscherBSERecord r5 = new org.apache.poi.ddf.EscherBSERecord
            r5.<init>()
            r6 = -4089(0xfffffffffffff007, float:NaN)
            r5.setRecordId(r6)
            int r6 = r9 << 4
            r1 = r1 | r6
            short r1 = (short) r1
            r5.setOptions(r1)
            byte r9 = (byte) r9
            r5.setBlipTypeMacOS(r9)
            r5.setBlipTypeWin32(r9)
            r5.setUid(r0)
            r5.setTag(r4)
            r5.setSize(r8)
            r5.setRef(r2)
            r5.setOffset(r2)
            r5.setBlipRecord(r3)
            org.apache.poi.hssf.model.InternalWorkbook r8 = r7.workbook
            int r8 = r8.addBSERecord(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.hssf.usermodel.HSSFWorkbook.addPicture(byte[], int):int");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<HSSFPictureData> getAllPictures() {
        ArrayList arrayList = new ArrayList();
        for (Record record : this.workbook.getRecords()) {
            if (record instanceof AbstractEscherHolderRecord) {
                AbstractEscherHolderRecord abstractEscherHolderRecord = (AbstractEscherHolderRecord) record;
                abstractEscherHolderRecord.decode();
                searchForPictures(abstractEscherHolderRecord.getEscherRecords(), arrayList);
            }
        }
        return arrayList;
    }

    private void searchForPictures(List<EscherRecord> list, List<HSSFPictureData> list2) {
        EscherBlipRecord blipRecord;
        for (EscherRecord escherRecord : list) {
            if ((escherRecord instanceof EscherBSERecord) && (blipRecord = ((EscherBSERecord) escherRecord).getBlipRecord()) != null) {
                list2.add(new HSSFPictureData(blipRecord));
            }
            searchForPictures(escherRecord.getChildRecords(), list2);
        }
    }

    protected static Map<String, ClassID> getOleMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("PowerPoint Document", ClassID.PPT_SHOW);
        for (String str : WORKBOOK_DIR_ENTRY_NAMES) {
            hashMap.put(str, ClassID.XLS_WORKBOOK);
        }
        return hashMap;
    }

    public int addOlePackage(POIFSFileSystem pOIFSFileSystem, String str, String str2, String str3) throws IOException {
        DirectoryNode root = pOIFSFileSystem.getRoot();
        Iterator<Map.Entry<String, ClassID>> it = getOleMap().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ClassID> next = it.next();
            if (root.hasEntry(next.getKey())) {
                root.setStorageClsid(next.getValue());
                break;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pOIFSFileSystem.writeFilesystem(byteArrayOutputStream);
        return addOlePackage(byteArrayOutputStream.toByteArray(), str, str2, str3);
    }

    public int addOlePackage(byte[] bArr, String str, String str2, String str3) throws IOException {
        if (this.directory == null) {
            this.directory = new POIFSFileSystem().getRoot();
            this.preserveNodes = true;
        }
        int i = 0;
        DirectoryEntry directoryEntry = null;
        do {
            i++;
            String str4 = "MBD" + HexDump.toHex(i);
            if (!this.directory.hasEntry(str4)) {
                directoryEntry = this.directory.createDirectory(str4);
                directoryEntry.setStorageClsid(ClassID.OLE10_PACKAGE);
            }
        } while (directoryEntry == null);
        directoryEntry.createDocument("\u0001Ole", new ByteArrayInputStream(new byte[]{1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        Ole10Native ole10Native = new Ole10Native(str, str2, str3, bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ole10Native.writeOut(byteArrayOutputStream);
        directoryEntry.createDocument(Ole10Native.OLE10_NATIVE, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        return i;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int linkExternalWorkbook(String str, Workbook workbook) {
        return this.workbook.linkExternalWorkbook(str, workbook);
    }

    public boolean isWriteProtected() {
        return this.workbook.isWriteProtected();
    }

    public void writeProtectWorkbook(String str, String str2) {
        this.workbook.writeProtectWorkbook(str, str2);
    }

    public void unwriteProtectWorkbook() {
        this.workbook.unwriteProtectWorkbook();
    }

    public List<HSSFObjectData> getAllEmbeddedObjects() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getNumberOfSheets(); i++) {
            getAllEmbeddedObjects(getSheetAt(i), arrayList);
        }
        return arrayList;
    }

    private void getAllEmbeddedObjects(HSSFSheet hSSFSheet, List<HSSFObjectData> list) {
        HSSFPatriarch drawingPatriarch = hSSFSheet.getDrawingPatriarch();
        if (drawingPatriarch == null) {
            return;
        }
        getAllEmbeddedObjects(drawingPatriarch, list);
    }

    private void getAllEmbeddedObjects(HSSFShapeContainer hSSFShapeContainer, List<HSSFObjectData> list) {
        for (Object obj : hSSFShapeContainer.getChildren()) {
            if (obj instanceof HSSFObjectData) {
                list.add((HSSFObjectData) obj);
            } else if (obj instanceof HSSFShapeContainer) {
                getAllEmbeddedObjects((HSSFShapeContainer) obj, list);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCreationHelper getCreationHelper() {
        return new HSSFCreationHelper(this);
    }

    UDFFinder getUDFFinder() {
        return this._udfFinder;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        ((AggregatingUDFFinder) this._udfFinder).add(uDFFinder);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z) {
        getWorkbook().getRecalcId().setEngineId(0);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        RecalcIdRecord recalcIdRecord = (RecalcIdRecord) getWorkbook().findFirstRecordBySid((short) 449);
        return (recalcIdRecord == null || recalcIdRecord.getEngineId() == 0) ? false : true;
    }

    public boolean changeExternalReference(String str, String str2) {
        return this.workbook.changeExternalReference(str, str2);
    }

    public DirectoryNode getRootDirectory() {
        return this.directory;
    }
}
