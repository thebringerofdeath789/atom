package jxl.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
public class CSV {
    public CSV(Workbook workbook, OutputStream outputStream, String str, boolean z) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, (str == null || !str.equals("UnicodeBig")) ? InternalZipConstants.CHARSET_UTF8 : str));
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheet(i);
                if (!z || !sheet.getSettings().isHidden()) {
                    bufferedWriter.write(new StringBuffer().append("*** ").append(sheet.getName()).append(" ****").toString());
                    bufferedWriter.newLine();
                    for (int i2 = 0; i2 < sheet.getRows(); i2++) {
                        Cell[] row = sheet.getRow(i2);
                        if (row.length > 0) {
                            if (!z || !row[0].isHidden()) {
                                bufferedWriter.write(row[0].getContents());
                            }
                            for (int i3 = 1; i3 < row.length; i3++) {
                                bufferedWriter.write(44);
                                if (!z || !row[i3].isHidden()) {
                                    bufferedWriter.write(row[i3].getContents());
                                }
                            }
                        }
                        bufferedWriter.newLine();
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
