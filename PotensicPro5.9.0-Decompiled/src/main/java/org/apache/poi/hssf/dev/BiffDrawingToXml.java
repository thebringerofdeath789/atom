package org.apache.poi.hssf.dev;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* loaded from: classes4.dex */
public class BiffDrawingToXml {
    private static final String EXCLUDE_WORKBOOK_RECORDS = "-exclude-workbook";
    private static final String SHEET_INDEXES_PARAM = "-sheet-indexes";
    private static final String SHEET_NAME_PARAM = "-sheet-name";

    private static int getAttributeIndex(String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (str.equals(strArr[i])) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isExcludeWorkbookRecords(String[] strArr) {
        return -1 != getAttributeIndex(EXCLUDE_WORKBOOK_RECORDS, strArr);
    }

    private static List<Integer> getIndexesByName(String[] strArr, HSSFWorkbook hSSFWorkbook) {
        ArrayList arrayList = new ArrayList();
        int attributeIndex = getAttributeIndex(SHEET_NAME_PARAM, strArr);
        if (-1 != attributeIndex) {
            if (attributeIndex >= strArr.length) {
                throw new IllegalArgumentException("sheet name param value was not specified");
            }
            int sheetIndex = hSSFWorkbook.getSheetIndex(strArr[attributeIndex + 1]);
            if (-1 == sheetIndex) {
                throw new IllegalArgumentException("specified sheet name has not been found in xls file");
            }
            arrayList.add(Integer.valueOf(sheetIndex));
        }
        return arrayList;
    }

    private static List<Integer> getIndexesByIdArray(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        int attributeIndex = getAttributeIndex(SHEET_INDEXES_PARAM, strArr);
        if (-1 != attributeIndex) {
            if (attributeIndex >= strArr.length) {
                throw new IllegalArgumentException("sheet list value was not specified");
            }
            for (String str : strArr[attributeIndex + 1].split(",")) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
        }
        return arrayList;
    }

    private static List<Integer> getSheetsIndexes(String[] strArr, HSSFWorkbook hSSFWorkbook) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getIndexesByIdArray(strArr));
        arrayList.addAll(getIndexesByName(strArr, hSSFWorkbook));
        if (arrayList.size() == 0) {
            int numberOfSheets = hSSFWorkbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    private static String getInputFileName(String[] strArr) {
        return strArr[strArr.length - 1];
    }

    private static String getOutputFileName(String str) {
        if (str.contains("xls")) {
            return str.replace(".xls", ".xml");
        }
        return str + ".xml";
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.out.println("Usage: BiffDrawingToXml [options] inputWorkbook");
            System.out.println("Options:");
            System.out.println("  -exclude-workbook            exclude workbook-level records");
            System.out.println("  -sheet-indexes   <indexes>   output sheets with specified indexes");
            System.out.println("  -sheet-namek  <names>        output sheets with specified name");
            return;
        }
        String inputFileName = getInputFileName(strArr);
        FileInputStream fileInputStream = new FileInputStream(inputFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(getOutputFileName(inputFileName));
        writeToFile(fileOutputStream, fileInputStream, isExcludeWorkbookRecords(strArr), strArr);
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void writeToFile(OutputStream outputStream, InputStream inputStream, boolean z, String[] strArr) throws IOException {
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
        DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord) getInternalWorkbook(hSSFWorkbook).findFirstRecordBySid(DrawingGroupRecord.sid);
        drawingGroupRecord.decode();
        StringBuilder sb = new StringBuilder();
        sb.append("<workbook>\n");
        if (!z) {
            Iterator<EscherRecord> it = drawingGroupRecord.getEscherRecords().iterator();
            while (it.hasNext()) {
                sb.append(it.next().toXml("\t"));
            }
        }
        for (Integer num : getSheetsIndexes(strArr, hSSFWorkbook)) {
            HSSFPatriarch drawingPatriarch = hSSFWorkbook.getSheetAt(num.intValue()).getDrawingPatriarch();
            if (drawingPatriarch != null) {
                sb.append("\t").append("<sheet").append(num).append(">\n");
                sb.append(getHSSFPatriarchBoundAggregate(drawingPatriarch).toXml("\t\t"));
                sb.append("\t").append("</sheet").append(num).append(">\n");
            }
        }
        sb.append("</workbook>\n");
        outputStream.write(sb.toString().getBytes());
        outputStream.close();
    }

    private static EscherAggregate getHSSFPatriarchBoundAggregate(HSSFPatriarch hSSFPatriarch) {
        try {
            Field declaredField = hSSFPatriarch.getClass().getDeclaredField("_boundAggregate");
            declaredField.setAccessible(true);
            return (EscherAggregate) declaredField.get(hSSFPatriarch);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static InternalWorkbook getInternalWorkbook(HSSFWorkbook hSSFWorkbook) {
        try {
            Field declaredField = hSSFWorkbook.getClass().getDeclaredField("workbook");
            declaredField.setAccessible(true);
            return (InternalWorkbook) declaredField.get(hSSFWorkbook);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
