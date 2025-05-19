package org.apache.poi.xssf.usermodel;

import aavax.xml.namespace.QName;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.PackageHelper;
import org.apache.poi.xssf.XLSBUnsupportedException;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFFormulaUtils;
import org.apache.poi.xssf.usermodel.helpers.XSSFPaswordHelper;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

/* loaded from: classes5.dex */
public class XSSFWorkbook extends POIXMLDocument implements Workbook, Iterable<XSSFSheet> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float DEFAULT_CHARACTER_WIDTH = 7.0017f;
    private static final int MAX_SENSITIVE_SHEET_NAME_LEN = 31;
    public static final int PICTURE_TYPE_BMP = 11;
    public static final int PICTURE_TYPE_EPS = 10;
    public static final int PICTURE_TYPE_GIF = 8;
    public static final int PICTURE_TYPE_TIFF = 9;
    public static final int PICTURE_TYPE_WPG = 12;
    private XSSFCreationHelper _creationHelper;
    private Row.MissingCellPolicy _missingCellPolicy;
    private IndexedUDFFinder _udfFinder;
    private CalculationChain calcChain;
    private List<ExternalLinksTable> externalLinks;
    private XSSFDataFormat formatter;
    private MapInfo mapInfo;
    private List<XSSFName> namedRanges;
    private List<XSSFPictureData> pictures;
    private List<CTPivotCache> pivotCaches;
    private List<XSSFPivotTable> pivotTables;
    private SharedStringsTable sharedStringSource;
    private List<XSSFSheet> sheets;
    private StylesTable stylesSource;
    private ThemesTable theme;
    private CTWorkbook workbook;
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    private static POILogger logger = POILogFactory.getLogger((Class<?>) XSSFWorkbook.class);

    public XSSFWorkbook() {
        super(newPackage());
        this._udfFinder = new IndexedUDFFinder(UDFFinder.DEFAULT);
        this._missingCellPolicy = Row.RETURN_NULL_AND_BLANK;
        onWorkbookCreate();
    }

    public XSSFWorkbook(OPCPackage oPCPackage) throws IOException {
        super(oPCPackage);
        this._udfFinder = new IndexedUDFFinder(UDFFinder.DEFAULT);
        this._missingCellPolicy = Row.RETURN_NULL_AND_BLANK;
        beforeDocumentRead();
        load(XSSFFactory.getInstance());
        if (this.workbook.isSetBookViews()) {
            return;
        }
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0L);
    }

    public XSSFWorkbook(InputStream inputStream) throws IOException {
        super(PackageHelper.open(inputStream));
        this._udfFinder = new IndexedUDFFinder(UDFFinder.DEFAULT);
        this._missingCellPolicy = Row.RETURN_NULL_AND_BLANK;
        beforeDocumentRead();
        load(XSSFFactory.getInstance());
        if (this.workbook.isSetBookViews()) {
            return;
        }
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0L);
    }

    public XSSFWorkbook(File file) throws IOException, InvalidFormatException {
        this(OPCPackage.open(file));
    }

    public XSSFWorkbook(String str) throws IOException {
        this(openPackage(str));
    }

    protected void beforeDocumentRead() {
        if (getCorePart().getContentType().equals(XSSFRelation.XLSB_BINARY_WORKBOOK.getContentType())) {
            throw new XLSBUnsupportedException();
        }
        this.pivotTables = new ArrayList();
        this.pivotCaches = new ArrayList();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        try {
            this.workbook = WorkbookDocument.Factory.parse(getPackagePart().getInputStream()).getWorkbook();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof SharedStringsTable) {
                    this.sharedStringSource = (SharedStringsTable) pOIXMLDocumentPart;
                } else if (pOIXMLDocumentPart instanceof StylesTable) {
                    this.stylesSource = (StylesTable) pOIXMLDocumentPart;
                } else if (pOIXMLDocumentPart instanceof ThemesTable) {
                    this.theme = (ThemesTable) pOIXMLDocumentPart;
                } else if (pOIXMLDocumentPart instanceof CalculationChain) {
                    this.calcChain = (CalculationChain) pOIXMLDocumentPart;
                } else if (pOIXMLDocumentPart instanceof MapInfo) {
                    this.mapInfo = (MapInfo) pOIXMLDocumentPart;
                } else if (pOIXMLDocumentPart instanceof XSSFSheet) {
                    hashMap.put(pOIXMLDocumentPart.getPackageRelationship().getId(), (XSSFSheet) pOIXMLDocumentPart);
                } else if (pOIXMLDocumentPart instanceof ExternalLinksTable) {
                    hashMap2.put(pOIXMLDocumentPart.getPackageRelationship().getId(), (ExternalLinksTable) pOIXMLDocumentPart);
                }
            }
            boolean z = getPackage().getPackageAccess() == PackageAccess.READ;
            if (this.stylesSource == null) {
                if (z) {
                    this.stylesSource = new StylesTable();
                } else {
                    this.stylesSource = (StylesTable) createRelationship(XSSFRelation.STYLES, XSSFFactory.getInstance());
                }
            }
            this.stylesSource.setTheme(this.theme);
            if (this.sharedStringSource == null) {
                if (z) {
                    this.sharedStringSource = new SharedStringsTable();
                } else {
                    this.sharedStringSource = (SharedStringsTable) createRelationship(XSSFRelation.SHARED_STRINGS, XSSFFactory.getInstance());
                }
            }
            this.sheets = new ArrayList(hashMap.size());
            for (CTSheet cTSheet : this.workbook.getSheets().getSheetArray()) {
                XSSFSheet xSSFSheet = (XSSFSheet) hashMap.get(cTSheet.getId());
                if (xSSFSheet == null) {
                    logger.log(5, "Sheet with name " + cTSheet.getName() + " and r:id " + cTSheet.getId() + " was defined, but didn't exist in package, skipping");
                } else {
                    xSSFSheet.sheet = cTSheet;
                    xSSFSheet.onDocumentRead();
                    this.sheets.add(xSSFSheet);
                }
            }
            this.externalLinks = new ArrayList(hashMap2.size());
            if (this.workbook.isSetExternalReferences()) {
                for (CTExternalReference cTExternalReference : this.workbook.getExternalReferences().getExternalReferenceArray()) {
                    ExternalLinksTable externalLinksTable = (ExternalLinksTable) hashMap2.get(cTExternalReference.getId());
                    if (externalLinksTable == null) {
                        logger.log(5, "ExternalLinksTable with r:id " + cTExternalReference.getId() + " was defined, but didn't exist in package, skipping");
                    } else {
                        this.externalLinks.add(externalLinksTable);
                    }
                }
            }
            reprocessNamedRanges();
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    private void onWorkbookCreate() {
        CTWorkbook newInstance = CTWorkbook.Factory.newInstance();
        this.workbook = newInstance;
        newInstance.addNewWorkbookPr().setDate1904(false);
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0L);
        this.workbook.addNewSheets();
        getProperties().getExtendedProperties().getUnderlyingProperties().setApplication(POIXMLDocument.DOCUMENT_CREATOR);
        this.sharedStringSource = (SharedStringsTable) createRelationship(XSSFRelation.SHARED_STRINGS, XSSFFactory.getInstance());
        this.stylesSource = (StylesTable) createRelationship(XSSFRelation.STYLES, XSSFFactory.getInstance());
        this.namedRanges = new ArrayList();
        this.sheets = new ArrayList();
        this.pivotTables = new ArrayList();
    }

    protected static OPCPackage newPackage() {
        try {
            OPCPackage create = OPCPackage.create(new ByteArrayOutputStream());
            PackagePartName createPartName = PackagingURIHelper.createPartName(XSSFRelation.WORKBOOK.getDefaultFileName());
            create.addRelationship(createPartName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
            create.createPart(createPartName, XSSFRelation.WORKBOOK.getContentType());
            create.getPackageProperties().setCreatorProperty(POIXMLDocument.DOCUMENT_CREATOR);
            return create;
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    @Internal
    public CTWorkbook getCTWorkbook() {
        return this.workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addPicture(byte[] bArr, int i) {
        int size = getAllPictures().size() + 1;
        XSSFPictureData xSSFPictureData = (XSSFPictureData) createRelationship(XSSFPictureData.RELATIONS[i], XSSFFactory.getInstance(), size, true);
        try {
            OutputStream outputStream = xSSFPictureData.getPackagePart().getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            this.pictures.add(xSSFPictureData);
            return size - 1;
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public int addPicture(InputStream inputStream, int i) throws IOException {
        int size = getAllPictures().size() + 1;
        XSSFPictureData xSSFPictureData = (XSSFPictureData) createRelationship(XSSFPictureData.RELATIONS[i], XSSFFactory.getInstance(), size, true);
        OutputStream outputStream = xSSFPictureData.getPackagePart().getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        outputStream.close();
        this.pictures.add(xSSFPictureData);
        return size - 1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet cloneSheet(int i) {
        validateSheetIndex(i);
        XSSFSheet xSSFSheet = this.sheets.get(i);
        XSSFSheet createSheet = createSheet(getUniqueSheetName(xSSFSheet.getSheetName()));
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            xSSFSheet.write(byteArrayOutputStream);
            createSheet.read(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            CTWorksheet cTWorksheet = createSheet.getCTWorksheet();
            if (cTWorksheet.isSetLegacyDrawing()) {
                logger.log(5, "Cloning sheets with comments is not yet supported.");
                cTWorksheet.unsetLegacyDrawing();
            }
            if (cTWorksheet.isSetPageSetup()) {
                logger.log(5, "Cloning sheets with page setup is not yet supported.");
                cTWorksheet.unsetPageSetup();
            }
            createSheet.setSelected(false);
            XSSFDrawing xSSFDrawing = null;
            for (POIXMLDocumentPart pOIXMLDocumentPart : xSSFSheet.getRelations()) {
                if (pOIXMLDocumentPart instanceof XSSFDrawing) {
                    xSSFDrawing = (XSSFDrawing) pOIXMLDocumentPart;
                } else {
                    PackageRelationship packageRelationship = pOIXMLDocumentPart.getPackageRelationship();
                    createSheet.getPackagePart().addRelationship(packageRelationship.getTargetURI(), packageRelationship.getTargetMode(), packageRelationship.getRelationshipType());
                    createSheet.addRelation(packageRelationship.getId(), pOIXMLDocumentPart);
                }
            }
            if (xSSFDrawing != null) {
                if (cTWorksheet.isSetDrawing()) {
                    cTWorksheet.unsetDrawing();
                }
                createSheet.createDrawingPatriarch().getCTDrawing().set(xSSFDrawing.getCTDrawing());
                XSSFDrawing createDrawingPatriarch = createSheet.createDrawingPatriarch();
                for (POIXMLDocumentPart pOIXMLDocumentPart2 : xSSFSheet.createDrawingPatriarch().getRelations()) {
                    PackageRelationship packageRelationship2 = pOIXMLDocumentPart2.getPackageRelationship();
                    createDrawingPatriarch.addRelation(packageRelationship2.getId(), pOIXMLDocumentPart2);
                    createDrawingPatriarch.getPackagePart().addRelationship(packageRelationship2.getTargetURI(), packageRelationship2.getTargetMode(), packageRelationship2.getRelationshipType(), packageRelationship2.getId());
                }
            }
            return createSheet;
        } catch (IOException e) {
            throw new POIXMLException("Failed to clone sheet", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f A[LOOP:0: B:13:0x0032->B:18:0x008f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e A[SYNTHETIC] */
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
            int r5 = r8.getSheetIndex(r4)
            r6 = -1
            if (r5 != r6) goto L8f
            return r4
        L8f:
            r4 = r0
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.xssf.usermodel.XSSFWorkbook.getUniqueSheetName(java.lang.String):java.lang.String");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCellStyle createCellStyle() {
        return this.stylesSource.createCellStyle();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFDataFormat createDataFormat() {
        if (this.formatter == null) {
            this.formatter = new XSSFDataFormat(this.stylesSource);
        }
        return this.formatter;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont createFont() {
        XSSFFont xSSFFont = new XSSFFont();
        xSSFFont.registerTo(this.stylesSource);
        return xSSFFont;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFName createName() {
        CTDefinedName newInstance = CTDefinedName.Factory.newInstance();
        newInstance.setName("");
        XSSFName xSSFName = new XSSFName(newInstance, this);
        this.namedRanges.add(xSSFName);
        return xSSFName;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet createSheet() {
        String str = "Sheet" + this.sheets.size();
        int i = 0;
        while (getSheet(str) != null) {
            str = "Sheet" + i;
            i++;
        }
        return createSheet(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet createSheet(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        if (containsSheet(str, this.sheets.size())) {
            throw new IllegalArgumentException("The workbook already contains a sheet of this name");
        }
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        WorkbookUtil.validateSheetName(str);
        CTSheet addSheet = addSheet(str);
        int i = 1;
        loop0: while (true) {
            Iterator<XSSFSheet> it = this.sheets.iterator();
            while (it.hasNext()) {
                i = (int) Math.max(it.next().sheet.getSheetId() + 1, i);
            }
            String fileName = XSSFRelation.WORKSHEET.getFileName(i);
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart.getPackagePart() == null || !fileName.equals(pOIXMLDocumentPart.getPackagePart().getPartName().getName())) {
                }
            }
            i++;
        }
        XSSFSheet xSSFSheet = (XSSFSheet) createRelationship(XSSFRelation.WORKSHEET, XSSFFactory.getInstance(), i);
        xSSFSheet.sheet = addSheet;
        addSheet.setId(xSSFSheet.getPackageRelationship().getId());
        addSheet.setSheetId(i);
        if (this.sheets.size() == 0) {
            xSSFSheet.setSelected(true);
        }
        this.sheets.add(xSSFSheet);
        return xSSFSheet;
    }

    protected XSSFDialogsheet createDialogsheet(String str, CTDialogsheet cTDialogsheet) {
        return new XSSFDialogsheet(createSheet(str));
    }

    private CTSheet addSheet(String str) {
        CTSheet addNewSheet = this.workbook.getSheets().addNewSheet();
        addNewSheet.setName(str);
        return addNewSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont findFont(short s, short s2, short s3, String str, boolean z, boolean z2, short s4, byte b) {
        return this.stylesSource.findFont(s, s2, s3, str, z, z2, s4, b);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return (int) this.workbook.getBookViews().getWorkbookViewArray(0).getActiveTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<XSSFPictureData> getAllPictures() {
        if (this.pictures == null) {
            List<PackagePart> partsByName = getPackage().getPartsByName(Pattern.compile("/xl/media/.*?"));
            this.pictures = new ArrayList(partsByName.size());
            Iterator<PackagePart> it = partsByName.iterator();
            while (it.hasNext()) {
                this.pictures.add(new XSSFPictureData(it.next(), null));
            }
        }
        return this.pictures;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCellStyle getCellStyleAt(short s) {
        return getCellStyleAt(s & 65535);
    }

    public XSSFCellStyle getCellStyleAt(int i) {
        return this.stylesSource.getStyleAt(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont getFontAt(short s) {
        return this.stylesSource.getFontAt(s);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFName getName(String str) {
        int nameIndex = getNameIndex(str);
        if (nameIndex < 0) {
            return null;
        }
        return this.namedRanges.get(nameIndex);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFName getNameAt(int i) {
        int size = this.namedRanges.size();
        if (size < 1) {
            throw new IllegalStateException("There are no defined names in this workbook");
        }
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("Specified name index " + i + " is outside the allowable range (0.." + (size - 1) + ").");
        }
        return this.namedRanges.get(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNameIndex(String str) {
        Iterator<XSSFName> it = this.namedRanges.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNameName().equals(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumCellStyles() {
        return (short) this.stylesSource.getNumCellStyles();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumberOfFonts() {
        return (short) this.stylesSource.getFonts().size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this.namedRanges.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this.sheets.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i) {
        XSSFName builtInName = getBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i);
        if (builtInName == null) {
            return null;
        }
        return builtInName.getRefersToFormula();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet getSheet(String str) {
        for (XSSFSheet xSSFSheet : this.sheets) {
            if (str.equalsIgnoreCase(xSSFSheet.getSheetName())) {
                return xSSFSheet;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet getSheetAt(int i) {
        validateSheetIndex(i);
        return this.sheets.get(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        for (int i = 0; i < this.sheets.size(); i++) {
            if (str.equalsIgnoreCase(this.sheets.get(i).getSheetName())) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        Iterator<XSSFSheet> it = this.sheets.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() == sheet) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i) {
        validateSheetIndex(i);
        return this.sheets.get(i).getSheetName();
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFSheet> iterator() {
        return this.sheets.iterator();
    }

    public boolean isMacroEnabled() {
        return getPackagePart().getContentType().equals(XSSFRelation.MACROS_WORKBOOK.getContentType());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(int i) {
        this.namedRanges.remove(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(String str) {
        for (int i = 0; i < this.namedRanges.size(); i++) {
            if (this.namedRanges.get(i).getNameName().equalsIgnoreCase(str)) {
                removeName(i);
                return;
            }
        }
        throw new IllegalArgumentException("Named range was not found: " + str);
    }

    void removeName(XSSFName xSSFName) {
        if (!this.namedRanges.remove(xSSFName)) {
            throw new IllegalArgumentException("Name was not found: " + xSSFName);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i) {
        int i2 = 0;
        for (XSSFName xSSFName : this.namedRanges) {
            if (xSSFName.getNameName().equals(XSSFName.BUILTIN_PRINT_AREA) && xSSFName.getSheetIndex() == i) {
                this.namedRanges.remove(i2);
                return;
            }
            i2++;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i) {
        validateSheetIndex(i);
        onSheetDelete(i);
        removeRelation(getSheetAt(i));
        this.sheets.remove(i);
        if (this.sheets.size() == 0) {
            return;
        }
        int size = i >= this.sheets.size() ? this.sheets.size() - 1 : i;
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i) {
            setActiveSheet(size);
        } else if (activeSheetIndex > i) {
            setActiveSheet(activeSheetIndex - 1);
        }
    }

    private void onSheetDelete(int i) {
        this.workbook.getSheets().removeSheet(i);
        CalculationChain calculationChain = this.calcChain;
        if (calculationChain != null) {
            removeRelation(calculationChain);
            this.calcChain = null;
        }
        Iterator<XSSFName> it = this.namedRanges.iterator();
        while (it.hasNext()) {
            CTDefinedName cTName = it.next().getCTName();
            if (cTName.isSetLocalSheetId()) {
                long j = i;
                if (cTName.getLocalSheetId() == j) {
                    it.remove();
                } else if (cTName.getLocalSheetId() > j) {
                    cTName.setLocalSheetId(cTName.getLocalSheetId() - 1);
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this._missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this._missingCellPolicy = missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i) {
        validateSheetIndex(i);
        for (CTBookView cTBookView : this.workbook.getBookViews().getWorkbookViewArray()) {
            cTBookView.setActiveTab(i);
        }
    }

    private void validateSheetIndex(int i) {
        int size = this.sheets.size() - 1;
        if (i < 0 || i > size) {
            String str = "(0.." + size + ")";
            if (size == -1) {
                str = "(no sheets)";
            }
            throw new IllegalArgumentException("Sheet index (" + i + ") is out of range " + str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return (short) this.workbook.getBookViews().getWorkbookViewArray(0).getFirstSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i) {
        this.workbook.getBookViews().getWorkbookViewArray(0).setFirstSheet(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, String str) {
        XSSFName builtInName = getBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i);
        if (builtInName == null) {
            builtInName = createBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i);
        }
        String[] split = COMMA_PATTERN.split(str);
        StringBuffer stringBuffer = new StringBuffer(32);
        for (int i2 = 0; i2 < split.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            SheetNameFormatter.appendFormat(stringBuffer, getSheetName(i));
            stringBuffer.append("!");
            stringBuffer.append(split[i2]);
        }
        builtInName.setRefersToFormula(stringBuffer.toString());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, int i2, int i3, int i4, int i5) {
        setPrintArea(i, getReferencePrintArea(getSheetName(i), i2, i3, i4, i5));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Deprecated
    public void setRepeatingRowsAndColumns(int i, int i2, int i3, int i4, int i5) {
        XSSFSheet sheetAt = getSheetAt(i);
        CellRangeAddress cellRangeAddress = i4 != -1 ? new CellRangeAddress(i4, i5, -1, -1) : null;
        CellRangeAddress cellRangeAddress2 = i2 != -1 ? new CellRangeAddress(-1, -1, i2, i3) : null;
        sheetAt.setRepeatingRows(cellRangeAddress);
        sheetAt.setRepeatingColumns(cellRangeAddress2);
    }

    private static String getReferencePrintArea(String str, int i, int i2, int i3, int i4) {
        CellReference cellReference = new CellReference(str, i3, i, true, true);
        CellReference cellReference2 = new CellReference(str, i4, i2, true, true);
        return "$" + cellReference.getCellRefParts()[2] + "$" + cellReference.getCellRefParts()[1] + ":$" + cellReference2.getCellRefParts()[2] + "$" + cellReference2.getCellRefParts()[1];
    }

    XSSFName getBuiltInName(String str, int i) {
        for (XSSFName xSSFName : this.namedRanges) {
            if (xSSFName.getNameName().equalsIgnoreCase(str) && xSSFName.getSheetIndex() == i) {
                return xSSFName;
            }
        }
        return null;
    }

    XSSFName createBuiltInName(String str, int i) {
        validateSheetIndex(i);
        CTDefinedName addNewDefinedName = (this.workbook.getDefinedNames() == null ? this.workbook.addNewDefinedNames() : this.workbook.getDefinedNames()).addNewDefinedName();
        addNewDefinedName.setName(str);
        addNewDefinedName.setLocalSheetId(i);
        XSSFName xSSFName = new XSSFName(addNewDefinedName, this);
        Iterator<XSSFName> it = this.namedRanges.iterator();
        while (it.hasNext()) {
            if (it.next().equals(xSSFName)) {
                throw new POIXMLException("Builtin (" + str + ") already exists for sheet (" + i + ")");
            }
        }
        this.namedRanges.add(xSSFName);
        return xSSFName;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i) {
        int i2 = 0;
        while (i2 < this.sheets.size()) {
            this.sheets.get(i2).setSelected(i2 == i);
            i2++;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetName(int i, String str) {
        validateSheetIndex(i);
        String sheetName = getSheetName(i);
        if (str != null && str.length() > 31) {
            str = str.substring(0, 31);
        }
        WorkbookUtil.validateSheetName(str);
        if (str.equals(sheetName)) {
            return;
        }
        if (containsSheet(str, i)) {
            throw new IllegalArgumentException("The workbook already contains a sheet of this name");
        }
        new XSSFFormulaUtils(this).updateSheetName(i, sheetName, str);
        this.workbook.getSheets().getSheetArray(i).setName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i) {
        int sheetIndex = getSheetIndex(str);
        List<XSSFSheet> list = this.sheets;
        list.add(i, list.remove(sheetIndex));
        CTSheets sheets = this.workbook.getSheets();
        XmlObject copy = sheets.getSheetArray(sheetIndex).copy();
        this.workbook.getSheets().removeSheet(sheetIndex);
        sheets.insertNewSheet(i).set(copy);
        CTSheet[] sheetArray = sheets.getSheetArray();
        for (int i2 = 0; i2 < sheetArray.length; i2++) {
            this.sheets.get(i2).sheet = sheetArray[i2];
        }
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

    private void saveNamedRanges() {
        if (this.namedRanges.size() > 0) {
            CTDefinedNames newInstance = CTDefinedNames.Factory.newInstance();
            CTDefinedName[] cTDefinedNameArr = new CTDefinedName[this.namedRanges.size()];
            int i = 0;
            Iterator<XSSFName> it = this.namedRanges.iterator();
            while (it.hasNext()) {
                cTDefinedNameArr[i] = it.next().getCTName();
                i++;
            }
            newInstance.setDefinedNameArray(cTDefinedNameArr);
            if (this.workbook.isSetDefinedNames()) {
                this.workbook.unsetDefinedNames();
            }
            this.workbook.setDefinedNames(newInstance);
            reprocessNamedRanges();
            return;
        }
        if (this.workbook.isSetDefinedNames()) {
            this.workbook.unsetDefinedNames();
        }
    }

    private void reprocessNamedRanges() {
        this.namedRanges = new ArrayList();
        if (this.workbook.isSetDefinedNames()) {
            for (CTDefinedName cTDefinedName : this.workbook.getDefinedNames().getDefinedNameArray()) {
                this.namedRanges.add(new XSSFName(cTDefinedName, this));
            }
        }
    }

    private void saveCalculationChain() {
        CalculationChain calculationChain = this.calcChain;
        if (calculationChain == null || calculationChain.getCTCalcChain().sizeOfCArray() != 0) {
            return;
        }
        removeRelation(this.calcChain);
        this.calcChain = null;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        saveNamedRanges();
        saveCalculationChain();
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTWorkbook.type.getName().getNamespaceURI(), "workbook"));
        HashMap hashMap = new HashMap();
        hashMap.put(STRelationshipId.type.getName().getNamespaceURI(), InternalZipConstants.READ_MODE);
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.workbook.save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.POIXMLDocument, org.apache.poi.ss.usermodel.Workbook, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    @Internal
    public SharedStringsTable getSharedStringSource() {
        return this.sharedStringSource;
    }

    public StylesTable getStylesSource() {
        return this.stylesSource;
    }

    public ThemesTable getTheme() {
        return this.theme;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCreationHelper getCreationHelper() {
        if (this._creationHelper == null) {
            this._creationHelper = new XSSFCreationHelper(this);
        }
        return this._creationHelper;
    }

    private boolean containsSheet(String str, int i) {
        CTSheet[] sheetArray = this.workbook.getSheets().getSheetArray();
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        for (int i2 = 0; i2 < sheetArray.length; i2++) {
            String name = sheetArray[i2].getName();
            if (name.length() > 31) {
                name = name.substring(0, 31);
            }
            if (i != i2 && str.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isDate1904() {
        CTWorkbookPr workbookPr = this.workbook.getWorkbookPr();
        return workbookPr != null && workbookPr.getDate1904();
    }

    @Override // org.apache.poi.POIXMLDocument
    public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
        LinkedList linkedList = new LinkedList();
        for (XSSFSheet xSSFSheet : this.sheets) {
            Iterator<PackageRelationship> it = xSSFSheet.getPackagePart().getRelationshipsByType(XSSFRelation.OLEEMBEDDINGS.getRelation()).iterator();
            while (it.hasNext()) {
                linkedList.add(xSSFSheet.getPackagePart().getRelatedPart(it.next()));
            }
            Iterator<PackageRelationship> it2 = xSSFSheet.getPackagePart().getRelationshipsByType(XSSFRelation.PACKEMBEDDINGS.getRelation()).iterator();
            while (it2.hasNext()) {
                linkedList.add(xSSFSheet.getPackagePart().getRelatedPart(it2.next()));
            }
        }
        return linkedList;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isHidden() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setHidden(boolean z) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i) {
        validateSheetIndex(i);
        return this.sheets.get(i).sheet.getState() == STSheetState.HIDDEN;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i) {
        validateSheetIndex(i);
        return this.sheets.get(i).sheet.getState() == STSheetState.VERY_HIDDEN;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, boolean z) {
        setSheetHidden(i, z ? 1 : 0);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, int i2) {
        validateSheetIndex(i);
        WorkbookUtil.validateSheetState(i2);
        this.sheets.get(i).sheet.setState(STSheetState.Enum.forInt(i2 + 1));
    }

    protected void onDeleteFormula(XSSFCell xSSFCell) {
        if (this.calcChain != null) {
            this.calcChain.removeItem((int) xSSFCell.getSheet().sheet.getSheetId(), xSSFCell.getReference());
        }
    }

    @Internal
    public CalculationChain getCalculationChain() {
        return this.calcChain;
    }

    @Internal
    public List<ExternalLinksTable> getExternalLinksTable() {
        return this.externalLinks;
    }

    public Collection<XSSFMap> getCustomXMLMappings() {
        MapInfo mapInfo = this.mapInfo;
        return mapInfo == null ? new ArrayList() : mapInfo.getAllXSSFMaps();
    }

    @Internal
    public MapInfo getMapInfo() {
        return this.mapInfo;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int linkExternalWorkbook(String str, Workbook workbook) {
        throw new RuntimeException("Not Implemented - see bug #57184");
    }

    public boolean isStructureLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockStructure();
    }

    public boolean isWindowsLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockWindows();
    }

    public boolean isRevisionLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockRevision();
    }

    public void lockStructure() {
        safeGetWorkbookProtection().setLockStructure(true);
    }

    public void unLockStructure() {
        safeGetWorkbookProtection().setLockStructure(false);
    }

    public void lockWindows() {
        safeGetWorkbookProtection().setLockWindows(true);
    }

    public void unLockWindows() {
        safeGetWorkbookProtection().setLockWindows(false);
    }

    public void lockRevision() {
        safeGetWorkbookProtection().setLockRevision(true);
    }

    public void unLockRevision() {
        safeGetWorkbookProtection().setLockRevision(false);
    }

    public void setWorkbookPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || workbookProtectionPresent()) {
            XSSFPaswordHelper.setPassword(safeGetWorkbookProtection(), str, hashAlgorithm, "workbook");
        }
    }

    public boolean validateWorkbookPassword(String str) {
        if (workbookProtectionPresent()) {
            return XSSFPaswordHelper.validatePassword(safeGetWorkbookProtection(), str, "workbook");
        }
        return str == null;
    }

    public void setRevisionsPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || workbookProtectionPresent()) {
            XSSFPaswordHelper.setPassword(safeGetWorkbookProtection(), str, hashAlgorithm, "revisions");
        }
    }

    public boolean validateRevisionsPassword(String str) {
        if (workbookProtectionPresent()) {
            return XSSFPaswordHelper.validatePassword(safeGetWorkbookProtection(), str, "revisions");
        }
        return str == null;
    }

    public void unLock() {
        if (workbookProtectionPresent()) {
            this.workbook.unsetWorkbookProtection();
        }
    }

    private boolean workbookProtectionPresent() {
        return this.workbook.isSetWorkbookProtection();
    }

    private CTWorkbookProtection safeGetWorkbookProtection() {
        if (!workbookProtectionPresent()) {
            return this.workbook.addNewWorkbookProtection();
        }
        return this.workbook.getWorkbookProtection();
    }

    UDFFinder getUDFFinder() {
        return this._udfFinder;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        this._udfFinder.add(uDFFinder);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z) {
        CTWorkbook cTWorkbook = getCTWorkbook();
        CTCalcPr calcPr = cTWorkbook.isSetCalcPr() ? cTWorkbook.getCalcPr() : cTWorkbook.addNewCalcPr();
        calcPr.setCalcId(0L);
        if (z && calcPr.getCalcMode() == STCalcMode.MANUAL) {
            calcPr.setCalcMode(STCalcMode.AUTO);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        CTCalcPr calcPr = getCTWorkbook().getCalcPr();
        return (calcPr == null || calcPr.getCalcId() == 0) ? false : true;
    }

    protected CTPivotCache addPivotCache(String str) {
        CTPivotCaches addNewPivotCaches;
        CTWorkbook cTWorkbook = getCTWorkbook();
        if (cTWorkbook.isSetPivotCaches()) {
            addNewPivotCaches = cTWorkbook.getPivotCaches();
        } else {
            addNewPivotCaches = cTWorkbook.addNewPivotCaches();
        }
        CTPivotCache addNewPivotCache = addNewPivotCaches.addNewPivotCache();
        addNewPivotCache.setCacheId(getPivotTables().size() + 1);
        addNewPivotCache.setId(str);
        if (this.pivotCaches == null) {
            this.pivotCaches = new ArrayList();
        }
        this.pivotCaches.add(addNewPivotCache);
        return addNewPivotCache;
    }

    public List<XSSFPivotTable> getPivotTables() {
        return this.pivotTables;
    }

    protected void setPivotTables(List<XSSFPivotTable> list) {
        this.pivotTables = list;
    }
}
