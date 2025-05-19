package jxl.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import jxl.Cell;
import jxl.CellType;
import jxl.FormulaCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.biff.CellReferenceHelper;
import jxl.biff.formula.FormulaException;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
public class Formulas {
    public Formulas(Workbook workbook, OutputStream outputStream, String str) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, (str == null || !str.equals("UnicodeBig")) ? InternalZipConstants.CHARSET_UTF8 : str));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheet(i);
                bufferedWriter.write(sheet.getName());
                bufferedWriter.newLine();
                for (int i2 = 0; i2 < sheet.getRows(); i2++) {
                    for (Cell cell : sheet.getRow(i2)) {
                        if (cell.getType() == CellType.NUMBER_FORMULA || cell.getType() == CellType.STRING_FORMULA || cell.getType() == CellType.BOOLEAN_FORMULA || cell.getType() == CellType.DATE_FORMULA || cell.getType() == CellType.FORMULA_ERROR) {
                            FormulaCell formulaCell = (FormulaCell) cell;
                            StringBuffer stringBuffer = new StringBuffer();
                            CellReferenceHelper.getCellReference(cell.getColumn(), cell.getRow(), stringBuffer);
                            try {
                                bufferedWriter.write(new StringBuffer().append("Formula in ").append(stringBuffer.toString()).append(" value:  ").append(cell.getContents()).toString());
                                bufferedWriter.flush();
                                bufferedWriter.write(new StringBuffer().append(" formula: ").append(formulaCell.getFormula()).toString());
                                bufferedWriter.flush();
                                bufferedWriter.newLine();
                            } catch (FormulaException e) {
                                bufferedWriter.newLine();
                                arrayList.add(new StringBuffer().append(sheet.getName()).append('!').append(stringBuffer.toString()).append(": ").append(e.getMessage()).toString());
                            }
                        }
                    }
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            if (arrayList.size() > 0) {
                System.err.println();
                System.err.println(new StringBuffer().append("There were ").append(arrayList.size()).append(" errors").toString());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    System.err.println(it.next());
                }
            }
        } catch (UnsupportedEncodingException e2) {
            System.err.println(e2.toString());
        }
    }
}
