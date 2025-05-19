package jxl.read.biff;

import common.Assert;
import common.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.biff.CellReferenceHelper;
import jxl.biff.EmptyCell;
import jxl.biff.Fonts;
import jxl.biff.FormattingRecords;
import jxl.biff.RangeImpl;
import jxl.biff.StringHelper;
import jxl.biff.WorkbookMethods;
import jxl.biff.drawing.DrawingGroup;
import jxl.biff.drawing.MsoDrawingGroupRecord;
import jxl.biff.formula.ExternalSheet;
import jxl.read.biff.NameRecord;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public class WorkbookParser extends Workbook implements ExternalSheet, WorkbookMethods {
    static /* synthetic */ Class class$jxl$read$biff$WorkbookParser;
    private static Logger logger;
    private ArrayList addInFunctions;
    private int bofs;
    private ButtonPropertySetRecord buttonPropertySet;
    private CountryRecord countryRecord;
    private DrawingGroup drawingGroup;
    private File excelFile;
    private ExternalSheetRecord externSheet;
    private SheetImpl lastSheet;
    private MsoDrawingGroupRecord msoDrawingGroup;
    private ArrayList nameTable;
    private boolean nineteenFour;
    private WorkbookSettings settings;
    private SSTRecord sharedStrings;
    private BOFRecord workbookBof;
    private ArrayList boundsheets = new ArrayList(10);
    private Fonts fonts = new Fonts();
    private FormattingRecords formattingRecords = new FormattingRecords(this.fonts);
    private ArrayList sheets = new ArrayList(10);
    private ArrayList supbooks = new ArrayList(10);
    private HashMap namedRecords = new HashMap();
    private int lastSheetIndex = -1;
    private boolean wbProtected = false;
    private boolean containsMacros = false;

    @Override // jxl.biff.formula.ExternalSheet
    public int getExternalSheetIndex(String str) {
        return 0;
    }

    @Override // jxl.biff.formula.ExternalSheet
    public int getLastExternalSheetIndex(String str) {
        return 0;
    }

    static {
        Class cls = class$jxl$read$biff$WorkbookParser;
        if (cls == null) {
            cls = class$("jxl.read.biff.WorkbookParser");
            class$jxl$read$biff$WorkbookParser = cls;
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

    public WorkbookParser(File file, WorkbookSettings workbookSettings) {
        this.excelFile = file;
        this.settings = workbookSettings;
    }

    @Override // jxl.Workbook
    public Sheet[] getSheets() {
        return (Sheet[]) this.sheets.toArray(new Sheet[getNumberOfSheets()]);
    }

    @Override // jxl.biff.WorkbookMethods
    public Sheet getReadSheet(int i) {
        return getSheet(i);
    }

    @Override // jxl.Workbook
    public Sheet getSheet(int i) {
        SheetImpl sheetImpl = this.lastSheet;
        if (sheetImpl != null && this.lastSheetIndex == i) {
            return sheetImpl;
        }
        if (sheetImpl != null) {
            sheetImpl.clear();
            if (!this.settings.getGCDisabled()) {
                System.gc();
            }
        }
        SheetImpl sheetImpl2 = (SheetImpl) this.sheets.get(i);
        this.lastSheet = sheetImpl2;
        this.lastSheetIndex = i;
        sheetImpl2.readSheet();
        return this.lastSheet;
    }

    @Override // jxl.Workbook
    public Sheet getSheet(String str) {
        Iterator it = this.boundsheets.iterator();
        boolean z = false;
        int i = 0;
        while (it.hasNext() && !z) {
            if (((BoundsheetRecord) it.next()).getName().equals(str)) {
                z = true;
            } else {
                i++;
            }
        }
        if (z) {
            return getSheet(i);
        }
        return null;
    }

    @Override // jxl.Workbook
    public String[] getSheetNames() {
        int size = this.boundsheets.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((BoundsheetRecord) this.boundsheets.get(i)).getName();
        }
        return strArr;
    }

    @Override // jxl.biff.formula.ExternalSheet
    public int getExternalSheetIndex(int i) {
        if (this.workbookBof.isBiff7()) {
            return i;
        }
        Assert.verify(this.externSheet != null);
        return this.externSheet.getFirstTabIndex(i);
    }

    @Override // jxl.biff.formula.ExternalSheet
    public int getLastExternalSheetIndex(int i) {
        if (this.workbookBof.isBiff7()) {
            return i;
        }
        Assert.verify(this.externSheet != null);
        return this.externSheet.getLastTabIndex(i);
    }

    @Override // jxl.biff.formula.ExternalSheet
    public String getExternalSheetName(int i) {
        if (this.workbookBof.isBiff7()) {
            return ((BoundsheetRecord) this.boundsheets.get(i)).getName();
        }
        SupbookRecord supbookRecord = (SupbookRecord) this.supbooks.get(this.externSheet.getSupbookIndex(i));
        int firstTabIndex = this.externSheet.getFirstTabIndex(i);
        int lastTabIndex = this.externSheet.getLastTabIndex(i);
        if (supbookRecord.getType() == SupbookRecord.INTERNAL) {
            String name = firstTabIndex == 65535 ? "#REF" : ((BoundsheetRecord) this.boundsheets.get(firstTabIndex)).getName();
            String name2 = lastTabIndex != 65535 ? ((BoundsheetRecord) this.boundsheets.get(lastTabIndex)).getName() : "#REF";
            if (firstTabIndex != lastTabIndex) {
                name = new StringBuffer().append(name).append(NameUtil.COLON).append(name2).toString();
            }
            if (name.indexOf(39) != -1) {
                name = StringHelper.replace(name, "'", "''");
            }
            return name.indexOf(32) == -1 ? name : new StringBuffer().append('\'').append(name).append('\'').toString();
        }
        if (supbookRecord.getType() != SupbookRecord.EXTERNAL) {
            return "[UNKNOWN]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        java.io.File file = new java.io.File(supbookRecord.getFileName());
        stringBuffer.append("'");
        stringBuffer.append(file.getAbsolutePath());
        stringBuffer.append("[");
        stringBuffer.append(file.getName());
        stringBuffer.append("]");
        stringBuffer.append(firstTabIndex != 65535 ? supbookRecord.getSheetName(firstTabIndex) : "#REF");
        if (lastTabIndex != firstTabIndex) {
            stringBuffer.append(supbookRecord.getSheetName(lastTabIndex));
        }
        stringBuffer.append("'");
        return stringBuffer.toString();
    }

    public String getLastExternalSheetName(int i) {
        if (this.workbookBof.isBiff7()) {
            return ((BoundsheetRecord) this.boundsheets.get(i)).getName();
        }
        SupbookRecord supbookRecord = (SupbookRecord) this.supbooks.get(this.externSheet.getSupbookIndex(i));
        int lastTabIndex = this.externSheet.getLastTabIndex(i);
        if (supbookRecord.getType() == SupbookRecord.INTERNAL) {
            return lastTabIndex == 65535 ? "#REF" : ((BoundsheetRecord) this.boundsheets.get(lastTabIndex)).getName();
        }
        if (supbookRecord.getType() != SupbookRecord.EXTERNAL) {
            return "[UNKNOWN]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        java.io.File file = new java.io.File(supbookRecord.getFileName());
        stringBuffer.append("'");
        stringBuffer.append(file.getAbsolutePath());
        stringBuffer.append("[");
        stringBuffer.append(file.getName());
        stringBuffer.append("]");
        stringBuffer.append(lastTabIndex != 65535 ? supbookRecord.getSheetName(lastTabIndex) : "#REF");
        stringBuffer.append("'");
        return stringBuffer.toString();
    }

    @Override // jxl.Workbook
    public int getNumberOfSheets() {
        return this.sheets.size();
    }

    @Override // jxl.Workbook
    public void close() {
        SheetImpl sheetImpl = this.lastSheet;
        if (sheetImpl != null) {
            sheetImpl.clear();
        }
        this.excelFile.clear();
        if (this.settings.getGCDisabled()) {
            return;
        }
        System.gc();
    }

    final void addSheet(Sheet sheet) {
        this.sheets.add(sheet);
    }

    /* JADX WARN: Removed duplicated region for block: B:209:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0315 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x036e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:159:0x0315 -> B:132:0x0316). Please report as a decompilation issue!!! */
    @Override // jxl.Workbook
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void parse() throws jxl.read.biff.BiffException, jxl.read.biff.PasswordException {
        /*
            Method dump skipped, instructions count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.read.biff.WorkbookParser.parse():void");
    }

    public FormattingRecords getFormattingRecords() {
        return this.formattingRecords;
    }

    public ExternalSheetRecord getExternalSheetRecord() {
        return this.externSheet;
    }

    public MsoDrawingGroupRecord getMsoDrawingGroupRecord() {
        return this.msoDrawingGroup;
    }

    public SupbookRecord[] getSupbookRecords() {
        return (SupbookRecord[]) this.supbooks.toArray(new SupbookRecord[this.supbooks.size()]);
    }

    public NameRecord[] getNameRecords() {
        return (NameRecord[]) this.nameTable.toArray(new NameRecord[this.nameTable.size()]);
    }

    public Fonts getFonts() {
        return this.fonts;
    }

    @Override // jxl.Workbook
    public Cell getCell(String str) {
        return getSheet(CellReferenceHelper.getSheet(str)).getCell(str);
    }

    @Override // jxl.Workbook
    public Cell findCellByName(String str) {
        NameRecord nameRecord = (NameRecord) this.namedRecords.get(str);
        if (nameRecord == null) {
            return null;
        }
        NameRecord.NameRange[] ranges = nameRecord.getRanges();
        Sheet sheet = getSheet(getExternalSheetIndex(ranges[0].getExternalSheet()));
        int firstColumn = ranges[0].getFirstColumn();
        int firstRow = ranges[0].getFirstRow();
        if (firstColumn > sheet.getColumns() || firstRow > sheet.getRows()) {
            return new EmptyCell(firstColumn, firstRow);
        }
        return sheet.getCell(firstColumn, firstRow);
    }

    @Override // jxl.Workbook
    public Range[] findByName(String str) {
        NameRecord nameRecord = (NameRecord) this.namedRecords.get(str);
        if (nameRecord == null) {
            return null;
        }
        NameRecord.NameRange[] ranges = nameRecord.getRanges();
        Range[] rangeArr = new Range[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            rangeArr[i] = new RangeImpl(this, getExternalSheetIndex(ranges[i].getExternalSheet()), ranges[i].getFirstColumn(), ranges[i].getFirstRow(), getLastExternalSheetIndex(ranges[i].getExternalSheet()), ranges[i].getLastColumn(), ranges[i].getLastRow());
        }
        return rangeArr;
    }

    @Override // jxl.Workbook
    public String[] getRangeNames() {
        Object[] array = this.namedRecords.keySet().toArray();
        String[] strArr = new String[array.length];
        System.arraycopy(array, 0, strArr, 0, array.length);
        return strArr;
    }

    @Override // jxl.biff.formula.ExternalSheet
    public BOFRecord getWorkbookBof() {
        return this.workbookBof;
    }

    @Override // jxl.Workbook
    public boolean isProtected() {
        return this.wbProtected;
    }

    public WorkbookSettings getSettings() {
        return this.settings;
    }

    @Override // jxl.biff.WorkbookMethods
    public String getName(int i) {
        Assert.verify(i >= 0 && i < this.nameTable.size());
        return ((NameRecord) this.nameTable.get(i)).getName();
    }

    @Override // jxl.biff.WorkbookMethods
    public int getNameIndex(String str) {
        NameRecord nameRecord = (NameRecord) this.namedRecords.get(str);
        if (nameRecord != null) {
            return nameRecord.getIndex();
        }
        return 0;
    }

    public DrawingGroup getDrawingGroup() {
        return this.drawingGroup;
    }

    public CompoundFile getCompoundFile() {
        return this.excelFile.getCompoundFile();
    }

    public boolean containsMacros() {
        return this.containsMacros;
    }

    public ButtonPropertySetRecord getButtonPropertySet() {
        return this.buttonPropertySet;
    }

    public CountryRecord getCountryRecord() {
        return this.countryRecord;
    }

    public String[] getAddInFunctionNames() {
        return (String[]) this.addInFunctions.toArray(new String[0]);
    }
}
