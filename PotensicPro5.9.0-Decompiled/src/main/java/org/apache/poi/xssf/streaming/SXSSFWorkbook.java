package org.apache.poi.xssf.streaming;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* loaded from: classes5.dex */
public class SXSSFWorkbook implements Workbook {
    public static final int DEFAULT_WINDOW_SIZE = 100;
    private boolean _compressTmpFiles;
    private int _randomAccessWindowSize;
    private SharedStringsTable _sharedStringSource;
    HashMap<SXSSFSheet, XSSFSheet> _sxFromXHash;
    XSSFWorkbook _wb;
    HashMap<XSSFSheet, SXSSFSheet> _xFromSxHash;

    public SXSSFWorkbook() {
        this((XSSFWorkbook) null);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook) {
        this(xSSFWorkbook, 100);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i) {
        this(xSSFWorkbook, i, false);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i, boolean z) {
        this(xSSFWorkbook, i, z, false);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i, boolean z, boolean z2) {
        this._sxFromXHash = new HashMap<>();
        this._xFromSxHash = new HashMap<>();
        this._randomAccessWindowSize = 100;
        this._compressTmpFiles = false;
        this._sharedStringSource = null;
        setRandomAccessWindowSize(i);
        setCompressTempFiles(z);
        if (xSSFWorkbook == null) {
            XSSFWorkbook xSSFWorkbook2 = new XSSFWorkbook();
            this._wb = xSSFWorkbook2;
            if (z2) {
                this._sharedStringSource = xSSFWorkbook2.getSharedStringSource();
                return;
            }
            return;
        }
        this._wb = xSSFWorkbook;
        if (z2) {
            this._sharedStringSource = xSSFWorkbook.getSharedStringSource();
        }
        for (int i2 = 0; i2 < this._wb.getNumberOfSheets(); i2++) {
            createAndRegisterSXSSFSheet(this._wb.getSheetAt(i2));
        }
    }

    public SXSSFWorkbook(int i) {
        this(null, i);
    }

    public int getRandomAccessWindowSize() {
        return this._randomAccessWindowSize;
    }

    private void setRandomAccessWindowSize(int i) {
        if (i == 0 || i < -1) {
            throw new IllegalArgumentException("rowAccessWindowSize must be greater than 0 or -1");
        }
        this._randomAccessWindowSize = i;
    }

    public void setCompressTempFiles(boolean z) {
        this._compressTmpFiles = z;
    }

    SheetDataWriter createSheetDataWriter() throws IOException {
        if (this._compressTmpFiles) {
            return new GZIPSheetDataWriter(this._sharedStringSource);
        }
        return new SheetDataWriter(this._sharedStringSource);
    }

    XSSFSheet getXSSFSheet(SXSSFSheet sXSSFSheet) {
        return this._sxFromXHash.get(sXSSFSheet);
    }

    SXSSFSheet getSXSSFSheet(XSSFSheet xSSFSheet) {
        return this._xFromSxHash.get(xSSFSheet);
    }

    void registerSheetMapping(SXSSFSheet sXSSFSheet, XSSFSheet xSSFSheet) {
        this._sxFromXHash.put(sXSSFSheet, xSSFSheet);
        this._xFromSxHash.put(xSSFSheet, sXSSFSheet);
    }

    void deregisterSheetMapping(XSSFSheet xSSFSheet) {
        SXSSFSheet sXSSFSheet = getSXSSFSheet(xSSFSheet);
        try {
            sXSSFSheet.getSheetDataWriter().close();
        } catch (IOException unused) {
        }
        this._sxFromXHash.remove(sXSSFSheet);
        this._xFromSxHash.remove(xSSFSheet);
    }

    private XSSFSheet getSheetFromZipEntryName(String str) {
        for (XSSFSheet xSSFSheet : this._sxFromXHash.values()) {
            if (str.equals(xSSFSheet.getPackagePart().getPartName().getName().substring(1))) {
                return xSSFSheet;
            }
        }
        return null;
    }

    private void injectData(File file, OutputStream outputStream) throws IOException {
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    zipOutputStream.putNextEntry(new ZipEntry(nextElement.getName()));
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    XSSFSheet sheetFromZipEntryName = getSheetFromZipEntryName(nextElement.getName());
                    if (sheetFromZipEntryName != null) {
                        InputStream worksheetXMLInputStream = getSXSSFSheet(sheetFromZipEntryName).getWorksheetXMLInputStream();
                        try {
                            copyStreamAndInjectWorksheet(inputStream, zipOutputStream, worksheetXMLInputStream);
                            worksheetXMLInputStream.close();
                        } finally {
                        }
                    } else {
                        copyStream(inputStream, zipOutputStream);
                    }
                    inputStream.close();
                }
            } finally {
                zipOutputStream.close();
            }
        } finally {
            zipFile.close();
        }
    }

    private static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private static void copyStreamAndInjectWorksheet(InputStream inputStream, OutputStream outputStream, InputStream inputStream2) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        int i = 10;
        String str = "<sheetData";
        boolean z = true;
        loop0: while (true) {
            int i2 = 0;
            while (true) {
                int read = inputStreamReader.read();
                if (read != -1) {
                    if (read != str.charAt(i2)) {
                        if (i2 > 0) {
                            outputStreamWriter.write(str, 0, i2);
                        }
                        if (read != str.charAt(0)) {
                            outputStreamWriter.write(read);
                            break;
                        }
                        i2 = 1;
                    } else {
                        i2++;
                        if (i2 != i) {
                            continue;
                        } else {
                            if (!"<sheetData".equals(str)) {
                                break loop0;
                            }
                            int read2 = inputStreamReader.read();
                            if (read2 == -1) {
                                outputStreamWriter.write(str);
                                break loop0;
                            }
                            if (read2 == 62) {
                                outputStreamWriter.write(str);
                                outputStreamWriter.write(read2);
                                i = 12;
                                str = "</sheetData>";
                                i2 = 0;
                                z = false;
                            } else if (read2 == 47) {
                                int read3 = inputStreamReader.read();
                                if (read3 == -1) {
                                    outputStreamWriter.write(str);
                                    break;
                                } else {
                                    if (read3 == 62) {
                                        break;
                                    }
                                    outputStreamWriter.write(str);
                                    outputStreamWriter.write(47);
                                    outputStreamWriter.write(read3);
                                }
                            } else {
                                outputStreamWriter.write(str);
                                outputStreamWriter.write(47);
                                outputStreamWriter.write(read2);
                            }
                        }
                    }
                } else {
                    break loop0;
                }
            }
        }
        outputStreamWriter.flush();
        if (z) {
            outputStreamWriter.write("<sheetData>\n");
            outputStreamWriter.flush();
        }
        copyStream(inputStream2, outputStream);
        outputStreamWriter.write("</sheetData>");
        outputStreamWriter.flush();
        while (true) {
            int read4 = inputStreamReader.read();
            if (read4 != -1) {
                outputStreamWriter.write(read4);
            } else {
                outputStreamWriter.flush();
                return;
            }
        }
    }

    public XSSFWorkbook getXSSFWorkbook() {
        return this._wb;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return this._wb.getActiveSheetIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i) {
        this._wb.setActiveSheet(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return this._wb.getFirstVisibleTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i) {
        this._wb.setFirstVisibleTab(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i) {
        this._wb.setSheetOrder(str, i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i) {
        this._wb.setSelectedTab(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetName(int i, String str) {
        this._wb.setSheetName(i, str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i) {
        return this._wb.getSheetName(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        return this._wb.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        return this._wb.getSheetIndex(getXSSFSheet((SXSSFSheet) sheet));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Sheet createSheet() {
        return createAndRegisterSXSSFSheet(this._wb.createSheet());
    }

    SXSSFSheet createAndRegisterSXSSFSheet(XSSFSheet xSSFSheet) {
        try {
            SXSSFSheet sXSSFSheet = new SXSSFSheet(this, xSSFSheet);
            registerSheetMapping(sXSSFSheet, xSSFSheet);
            return sXSSFSheet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Sheet createSheet(String str) {
        return createAndRegisterSXSSFSheet(this._wb.createSheet(str));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Sheet cloneSheet(int i) {
        throw new RuntimeException("NotImplemented");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this._wb.getNumberOfSheets();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Sheet getSheetAt(int i) {
        return getSXSSFSheet(this._wb.getSheetAt(i));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Sheet getSheet(String str) {
        return getSXSSFSheet(this._wb.getSheet(str));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i) {
        XSSFSheet sheetAt = this._wb.getSheetAt(i);
        SXSSFSheet sXSSFSheet = getSXSSFSheet(sheetAt);
        this._wb.removeSheetAt(i);
        deregisterSheetMapping(sheetAt);
        sXSSFSheet.dispose();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Deprecated
    public void setRepeatingRowsAndColumns(int i, int i2, int i3, int i4, int i5) {
        this._wb.setRepeatingRowsAndColumns(i, i2, i3, i4, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font createFont() {
        return this._wb.createFont();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font findFont(short s, short s2, short s3, String str, boolean z, boolean z2, short s4, byte b) {
        return this._wb.findFont(s, s2, s3, str, z, z2, s4, b);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumberOfFonts() {
        return this._wb.getNumberOfFonts();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font getFontAt(short s) {
        return this._wb.getFontAt(s);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellStyle createCellStyle() {
        return this._wb.createCellStyle();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumCellStyles() {
        return this._wb.getNumCellStyles();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellStyle getCellStyleAt(short s) {
        return this._wb.getCellStyleAt(s);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<SXSSFSheet> it = this._xFromSxHash.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().getSheetDataWriter().close();
            } catch (IOException unused) {
            }
        }
        this._wb.close();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void write(OutputStream outputStream) throws IOException {
        Iterator<SXSSFSheet> it = this._xFromSxHash.values().iterator();
        while (it.hasNext()) {
            it.next().flushRows();
        }
        File createTempFile = TempFile.createTempFile("poi-sxssf-template", ".xlsx");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            try {
                this._wb.write(fileOutputStream);
                fileOutputStream.close();
                injectData(createTempFile, outputStream);
                if (!createTempFile.delete()) {
                    throw new IOException("Could not delete temporary file after processing: " + createTempFile);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            if (!createTempFile.delete()) {
                throw new IOException("Could not delete temporary file after processing: " + createTempFile);
            }
            throw th2;
        }
    }

    public boolean dispose() {
        Iterator<SXSSFSheet> it = this._sxFromXHash.keySet().iterator();
        while (true) {
            boolean z = true;
            while (it.hasNext()) {
                if (!it.next().dispose() || !z) {
                    z = false;
                }
            }
            return z;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this._wb.getNumberOfNames();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Name getName(String str) {
        return this._wb.getName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Name getNameAt(int i) {
        return this._wb.getNameAt(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Name createName() {
        return this._wb.createName();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNameIndex(String str) {
        return this._wb.getNameIndex(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(int i) {
        this._wb.removeName(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(String str) {
        this._wb.removeName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, String str) {
        this._wb.setPrintArea(i, str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, int i2, int i3, int i4, int i5) {
        this._wb.setPrintArea(i, i2, i3, i4, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i) {
        return this._wb.getPrintArea(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i) {
        this._wb.removePrintArea(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this._wb.getMissingCellPolicy();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this._wb.setMissingCellPolicy(missingCellPolicy);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public DataFormat createDataFormat() {
        return this._wb.createDataFormat();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addPicture(byte[] bArr, int i) {
        return this._wb.addPicture(bArr, i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<? extends PictureData> getAllPictures() {
        return this._wb.getAllPictures();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CreationHelper getCreationHelper() {
        return this._wb.getCreationHelper();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isHidden() {
        return this._wb.isHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setHidden(boolean z) {
        this._wb.setHidden(z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i) {
        return this._wb.isSheetHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i) {
        return this._wb.isSheetVeryHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, boolean z) {
        this._wb.setSheetHidden(i, z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, int i2) {
        this._wb.setSheetHidden(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int linkExternalWorkbook(String str, Workbook workbook) {
        throw new RuntimeException("NotImplemented");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        this._wb.addToolPack(uDFFinder);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z) {
        this._wb.setForceFormulaRecalculation(z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        return this._wb.getForceFormulaRecalculation();
    }
}
