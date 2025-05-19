package org.apache.poi.hssf.dev;

import java.io.File;
import java.util.List;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.FuncPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* loaded from: classes4.dex */
public class FormulaViewer {
    private String file;
    private boolean list = false;

    public void run() throws Exception {
        List<Record> createRecords = RecordFactory.createRecords(BiffViewer.getPOIFSInputStream(new File(this.file)));
        for (int i = 0; i < createRecords.size(); i++) {
            Record record = createRecords.get(i);
            if (record.getSid() == 6) {
                if (this.list) {
                    listFormula((FormulaRecord) record);
                } else {
                    parseFormulaRecord((FormulaRecord) record);
                }
            }
        }
    }

    private void listFormula(FormulaRecord formulaRecord) {
        String valueOf;
        Ptg[] parsedExpression = formulaRecord.getParsedExpression();
        int length = parsedExpression.length;
        int i = length - 1;
        Ptg ptg = parsedExpression[i];
        if (ptg instanceof FuncPtg) {
            valueOf = String.valueOf(i);
        } else {
            valueOf = String.valueOf(-1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (ptg instanceof ExpPtg) {
            return;
        }
        stringBuffer.append(((OperationPtg) ptg).toFormulaString());
        stringBuffer.append("~");
        byte ptgClass = ptg.getPtgClass();
        if (ptgClass == 0) {
            stringBuffer.append("REF");
        } else if (ptgClass == 32) {
            stringBuffer.append("VALUE");
        } else if (ptgClass == 64) {
            stringBuffer.append("ARRAY");
        }
        stringBuffer.append("~");
        if (length > 1) {
            byte ptgClass2 = parsedExpression[length - 2].getPtgClass();
            if (ptgClass2 == 0) {
                stringBuffer.append("REF");
            } else if (ptgClass2 == 32) {
                stringBuffer.append("VALUE");
            } else if (ptgClass2 == 64) {
                stringBuffer.append("ARRAY");
            }
        } else {
            stringBuffer.append("VALUE");
        }
        stringBuffer.append("~");
        stringBuffer.append(valueOf);
        System.out.println(stringBuffer.toString());
    }

    public void parseFormulaRecord(FormulaRecord formulaRecord) {
        System.out.println("==============================");
        System.out.print("row = " + formulaRecord.getRow());
        System.out.println(", col = " + ((int) formulaRecord.getColumn()));
        System.out.println("value = " + formulaRecord.getValue());
        System.out.print("xf = " + ((int) formulaRecord.getXFIndex()));
        System.out.print(", number of ptgs = " + formulaRecord.getParsedExpression().length);
        System.out.println(", options = " + ((int) formulaRecord.getOptions()));
        System.out.println("RPN List = " + formulaString(formulaRecord));
        System.out.println("Formula text = " + composeFormula(formulaRecord));
    }

    private String formulaString(FormulaRecord formulaRecord) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Ptg ptg : formulaRecord.getParsedExpression()) {
            stringBuffer.append(ptg.toFormulaString());
            byte ptgClass = ptg.getPtgClass();
            if (ptgClass == 0) {
                stringBuffer.append("(R)");
            } else if (ptgClass == 32) {
                stringBuffer.append("(V)");
            } else if (ptgClass == 64) {
                stringBuffer.append("(A)");
            }
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    private static String composeFormula(FormulaRecord formulaRecord) {
        return HSSFFormulaParser.toFormulaString((HSSFWorkbook) null, formulaRecord.getParsedExpression());
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setList(boolean z) {
        this.list = z;
    }

    public static void main(String[] strArr) {
        if (strArr == null || strArr.length > 2 || strArr[0].equals("--help")) {
            System.out.println("FormulaViewer .8 proof that the devil lies in the details (or just in BIFF8 files in general)");
            System.out.println("usage: Give me a big fat file name");
            return;
        }
        if (strArr[0].equals("--listFunctions")) {
            try {
                FormulaViewer formulaViewer = new FormulaViewer();
                formulaViewer.setFile(strArr[1]);
                formulaViewer.setList(true);
                formulaViewer.run();
                return;
            } catch (Exception e) {
                System.out.println("Whoops!");
                e.printStackTrace();
                return;
            }
        }
        try {
            FormulaViewer formulaViewer2 = new FormulaViewer();
            formulaViewer2.setFile(strArr[0]);
            formulaViewer2.run();
        } catch (Exception e2) {
            System.out.println("Whoops!");
            e2.printStackTrace();
        }
    }
}
