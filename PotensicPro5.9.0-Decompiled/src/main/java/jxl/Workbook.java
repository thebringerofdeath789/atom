package jxl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;
import jxl.read.biff.WorkbookParser;
import jxl.write.WritableWorkbook;
import jxl.write.biff.WritableWorkbookImpl;

/* loaded from: classes4.dex */
public abstract class Workbook {
    private static final String VERSION = "2.6.1";

    public static String getVersion() {
        return VERSION;
    }

    public abstract void close();

    public abstract Range[] findByName(String str);

    public abstract Cell findCellByName(String str);

    public abstract Cell getCell(String str);

    public abstract int getNumberOfSheets();

    public abstract String[] getRangeNames();

    public abstract Sheet getSheet(int i) throws IndexOutOfBoundsException;

    public abstract Sheet getSheet(String str);

    public abstract String[] getSheetNames();

    public abstract Sheet[] getSheets();

    public abstract boolean isProtected();

    protected abstract void parse() throws BiffException, PasswordException;

    protected Workbook() {
    }

    public static Workbook getWorkbook(File file) throws IOException, BiffException {
        return getWorkbook(file, new WorkbookSettings());
    }

    public static Workbook getWorkbook(File file, WorkbookSettings workbookSettings) throws IOException, BiffException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            jxl.read.biff.File file2 = new jxl.read.biff.File(fileInputStream, workbookSettings);
            fileInputStream.close();
            WorkbookParser workbookParser = new WorkbookParser(file2, workbookSettings);
            workbookParser.parse();
            return workbookParser;
        } catch (IOException e) {
            fileInputStream.close();
            throw e;
        } catch (BiffException e2) {
            fileInputStream.close();
            throw e2;
        }
    }

    public static Workbook getWorkbook(InputStream inputStream) throws IOException, BiffException {
        return getWorkbook(inputStream, new WorkbookSettings());
    }

    public static Workbook getWorkbook(InputStream inputStream, WorkbookSettings workbookSettings) throws IOException, BiffException {
        WorkbookParser workbookParser = new WorkbookParser(new jxl.read.biff.File(inputStream, workbookSettings), workbookSettings);
        workbookParser.parse();
        return workbookParser;
    }

    public static WritableWorkbook createWorkbook(File file) throws IOException {
        return createWorkbook(file, new WorkbookSettings());
    }

    public static WritableWorkbook createWorkbook(File file, WorkbookSettings workbookSettings) throws IOException {
        return new WritableWorkbookImpl(new FileOutputStream(file), true, workbookSettings);
    }

    public static WritableWorkbook createWorkbook(File file, Workbook workbook) throws IOException {
        return createWorkbook(file, workbook, new WorkbookSettings());
    }

    public static WritableWorkbook createWorkbook(File file, Workbook workbook, WorkbookSettings workbookSettings) throws IOException {
        return new WritableWorkbookImpl(new FileOutputStream(file), workbook, true, workbookSettings);
    }

    public static WritableWorkbook createWorkbook(OutputStream outputStream, Workbook workbook) throws IOException {
        return createWorkbook(outputStream, workbook, ((WorkbookParser) workbook).getSettings());
    }

    public static WritableWorkbook createWorkbook(OutputStream outputStream, Workbook workbook, WorkbookSettings workbookSettings) throws IOException {
        return new WritableWorkbookImpl(outputStream, workbook, false, workbookSettings);
    }

    public static WritableWorkbook createWorkbook(OutputStream outputStream) throws IOException {
        return createWorkbook(outputStream, new WorkbookSettings());
    }

    public static WritableWorkbook createWorkbook(OutputStream outputStream, WorkbookSettings workbookSettings) throws IOException {
        return new WritableWorkbookImpl(outputStream, false, workbookSettings);
    }
}
