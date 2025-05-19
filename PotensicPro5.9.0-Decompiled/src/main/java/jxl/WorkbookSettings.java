package jxl;

import common.Logger;
import java.util.HashMap;
import java.util.Locale;
import jxl.biff.CountryCode;
import jxl.biff.formula.FunctionNames;

/* loaded from: classes4.dex */
public final class WorkbookSettings {
    private static final int DEFAULT_ARRAY_GROW_SIZE = 1048576;
    private static final int DEFAULT_INITIAL_FILE_SIZE = 5242880;
    static /* synthetic */ Class class$jxl$WorkbookSettings;
    private static Logger logger;
    private boolean cellValidationDisabled;
    private int characterSet;
    private boolean drawingsDisabled;
    private String encoding;
    private boolean formulaReferenceAdjustDisabled;
    private FunctionNames functionNames;
    private boolean gcDisabled;
    private boolean ignoreBlankCells;
    private Locale locale;
    private boolean mergedCellCheckingDisabled;
    private boolean namesDisabled;
    private boolean propertySetsDisabled;
    private boolean rationalizationDisabled;
    private int initialFileSize = DEFAULT_INITIAL_FILE_SIZE;
    private int arrayGrowSize = 1048576;
    private HashMap localeFunctionNames = new HashMap();
    private String excelDisplayLanguage = CountryCode.USA.getCode();
    private String excelRegionalSettings = CountryCode.UK.getCode();

    static {
        Class cls = class$jxl$WorkbookSettings;
        if (cls == null) {
            cls = class$("jxl.WorkbookSettings");
            class$jxl$WorkbookSettings = cls;
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b3 A[Catch: SecurityException -> 0x00ba, TRY_LEAVE, TryCatch #1 {SecurityException -> 0x00ba, blocks: (B:6:0x008a, B:8:0x0090, B:11:0x0097, B:12:0x00ad, B:14:0x00b3, B:19:0x00a7), top: B:5:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WorkbookSettings() {
        /*
            r6 = this;
            java.lang.String r0 = "jxl.encoding"
            java.lang.String r1 = "jxl.country"
            java.lang.String r2 = "jxl.lang"
            java.lang.String r3 = "Error accessing system properties."
            r6.<init>()
            r4 = 5242880(0x500000, float:7.34684E-39)
            r6.initialFileSize = r4
            r4 = 1048576(0x100000, float:1.469368E-39)
            r6.arrayGrowSize = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r6.localeFunctionNames = r4
            jxl.biff.CountryCode r4 = jxl.biff.CountryCode.USA
            java.lang.String r4 = r4.getCode()
            r6.excelDisplayLanguage = r4
            jxl.biff.CountryCode r4 = jxl.biff.CountryCode.UK
            java.lang.String r4 = r4.getCode()
            r6.excelRegionalSettings = r4
            java.lang.String r4 = "jxl.nowarnings"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.setSuppressWarnings(r4)     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.nodrawings"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.drawingsDisabled = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.nonames"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.namesDisabled = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.nogc"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.gcDisabled = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.norat"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.rationalizationDisabled = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.nomergedcellchecks"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.mergedCellCheckingDisabled = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.noformulaadjust"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.formulaReferenceAdjustDisabled = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.nopropertysets"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.propertySetsDisabled = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.ignoreblanks"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.ignoreBlankCells = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "jxl.nocellvalidation"
            boolean r4 = java.lang.Boolean.getBoolean(r4)     // Catch: java.lang.SecurityException -> L84
            r6.cellValidationDisabled = r4     // Catch: java.lang.SecurityException -> L84
            java.lang.String r4 = "file.encoding"
            java.lang.String r4 = java.lang.System.getProperty(r4)     // Catch: java.lang.SecurityException -> L84
            r6.encoding = r4     // Catch: java.lang.SecurityException -> L84
            goto L8a
        L84:
            r4 = move-exception
            common.Logger r5 = jxl.WorkbookSettings.logger
            r5.warn(r3, r4)
        L8a:
            java.lang.String r4 = java.lang.System.getProperty(r2)     // Catch: java.lang.SecurityException -> Lba
            if (r4 == 0) goto La7
            java.lang.String r4 = java.lang.System.getProperty(r1)     // Catch: java.lang.SecurityException -> Lba
            if (r4 != 0) goto L97
            goto La7
        L97:
            java.util.Locale r4 = new java.util.Locale     // Catch: java.lang.SecurityException -> Lba
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.SecurityException -> Lba
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch: java.lang.SecurityException -> Lba
            r4.<init>(r2, r1)     // Catch: java.lang.SecurityException -> Lba
            r6.locale = r4     // Catch: java.lang.SecurityException -> Lba
            goto Lad
        La7:
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch: java.lang.SecurityException -> Lba
            r6.locale = r1     // Catch: java.lang.SecurityException -> Lba
        Lad:
            java.lang.String r1 = java.lang.System.getProperty(r0)     // Catch: java.lang.SecurityException -> Lba
            if (r1 == 0) goto Lc6
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.SecurityException -> Lba
            r6.encoding = r0     // Catch: java.lang.SecurityException -> Lba
            goto Lc6
        Lba:
            r0 = move-exception
            common.Logger r1 = jxl.WorkbookSettings.logger
            r1.warn(r3, r0)
            java.util.Locale r0 = java.util.Locale.getDefault()
            r6.locale = r0
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.WorkbookSettings.<init>():void");
    }

    public void setArrayGrowSize(int i) {
        this.arrayGrowSize = i;
    }

    public int getArrayGrowSize() {
        return this.arrayGrowSize;
    }

    public void setInitialFileSize(int i) {
        this.initialFileSize = i;
    }

    public int getInitialFileSize() {
        return this.initialFileSize;
    }

    public boolean getDrawingsDisabled() {
        return this.drawingsDisabled;
    }

    public boolean getGCDisabled() {
        return this.gcDisabled;
    }

    public boolean getNamesDisabled() {
        return this.namesDisabled;
    }

    public void setNamesDisabled(boolean z) {
        this.namesDisabled = z;
    }

    public void setDrawingsDisabled(boolean z) {
        this.drawingsDisabled = z;
    }

    public void setRationalization(boolean z) {
        this.rationalizationDisabled = !z;
    }

    public boolean getRationalizationDisabled() {
        return this.rationalizationDisabled;
    }

    public boolean getMergedCellCheckingDisabled() {
        return this.mergedCellCheckingDisabled;
    }

    public void setMergedCellChecking(boolean z) {
        this.mergedCellCheckingDisabled = !z;
    }

    public void setPropertySets(boolean z) {
        this.propertySetsDisabled = !z;
    }

    public boolean getPropertySetsDisabled() {
        return this.propertySetsDisabled;
    }

    public void setSuppressWarnings(boolean z) {
        logger.setSuppressWarnings(z);
    }

    public boolean getFormulaAdjust() {
        return !this.formulaReferenceAdjustDisabled;
    }

    public void setFormulaAdjust(boolean z) {
        this.formulaReferenceAdjustDisabled = !z;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public FunctionNames getFunctionNames() {
        if (this.functionNames == null) {
            FunctionNames functionNames = (FunctionNames) this.localeFunctionNames.get(this.locale);
            this.functionNames = functionNames;
            if (functionNames == null) {
                FunctionNames functionNames2 = new FunctionNames(this.locale);
                this.functionNames = functionNames2;
                this.localeFunctionNames.put(this.locale, functionNames2);
            }
        }
        return this.functionNames;
    }

    public int getCharacterSet() {
        return this.characterSet;
    }

    public void setCharacterSet(int i) {
        this.characterSet = i;
    }

    public void setGCDisabled(boolean z) {
        this.gcDisabled = z;
    }

    public void setIgnoreBlanks(boolean z) {
        this.ignoreBlankCells = z;
    }

    public boolean getIgnoreBlanks() {
        return this.ignoreBlankCells;
    }

    public void setCellValidationDisabled(boolean z) {
        this.cellValidationDisabled = z;
    }

    public boolean getCellValidationDisabled() {
        return this.cellValidationDisabled;
    }

    public String getExcelDisplayLanguage() {
        return this.excelDisplayLanguage;
    }

    public String getExcelRegionalSettings() {
        return this.excelRegionalSettings;
    }

    public void setExcelDisplayLanguage(String str) {
        this.excelDisplayLanguage = str;
    }

    public void setExcelRegionalSettings(String str) {
        this.excelRegionalSettings = str;
    }
}
