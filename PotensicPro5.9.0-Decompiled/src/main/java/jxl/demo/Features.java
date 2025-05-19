package jxl.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import jxl.Cell;
import jxl.CellFeatures;
import jxl.CellReferenceHelper;
import jxl.Sheet;
import jxl.Workbook;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
public class Features {
    public Features(Workbook workbook, OutputStream outputStream, String str) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, (str == null || !str.equals("UnicodeBig")) ? InternalZipConstants.CHARSET_UTF8 : str));
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheet(i);
                bufferedWriter.write(sheet.getName());
                bufferedWriter.newLine();
                for (int i2 = 0; i2 < sheet.getRows(); i2++) {
                    for (Cell cell : sheet.getRow(i2)) {
                        if (cell.getCellFeatures() != null) {
                            CellFeatures cellFeatures = cell.getCellFeatures();
                            StringBuffer stringBuffer = new StringBuffer();
                            CellReferenceHelper.getCellReference(cell.getColumn(), cell.getRow(), stringBuffer);
                            bufferedWriter.write(new StringBuffer().append("Cell ").append(stringBuffer.toString()).append(" contents:  ").append(cell.getContents()).toString());
                            bufferedWriter.flush();
                            bufferedWriter.write(new StringBuffer().append(" comment: ").append(cellFeatures.getComment()).toString());
                            bufferedWriter.flush();
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }
}
