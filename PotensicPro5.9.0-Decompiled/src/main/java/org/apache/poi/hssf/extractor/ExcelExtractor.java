package org.apache.poi.hssf.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.apache.poi.POIOLE2TextExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.HeaderFooter;

/* loaded from: classes4.dex */
public class ExcelExtractor extends POIOLE2TextExtractor implements org.apache.poi.ss.extractor.ExcelExtractor {
    private HSSFDataFormatter _formatter;
    private boolean _includeBlankCells;
    private boolean _includeCellComments;
    private boolean _includeHeadersFooters;
    private boolean _includeSheetNames;
    private boolean _shouldEvaluateFormulas;
    private HSSFWorkbook _wb;

    public ExcelExtractor(HSSFWorkbook hSSFWorkbook) {
        super(hSSFWorkbook);
        this._includeSheetNames = true;
        this._shouldEvaluateFormulas = true;
        this._includeCellComments = false;
        this._includeBlankCells = false;
        this._includeHeadersFooters = true;
        this._wb = hSSFWorkbook;
        this._formatter = new HSSFDataFormatter();
    }

    public ExcelExtractor(POIFSFileSystem pOIFSFileSystem) throws IOException {
        this(pOIFSFileSystem.getRoot());
    }

    @Deprecated
    public ExcelExtractor(DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem) throws IOException {
        this(directoryNode);
    }

    public ExcelExtractor(DirectoryNode directoryNode) throws IOException {
        this(new HSSFWorkbook(directoryNode, true));
    }

    private static final class CommandParseException extends Exception {
        public CommandParseException(String str) {
            super(str);
        }
    }

    private static final class CommandArgs {
        private final boolean _evaluateFormulas;
        private final boolean _headersFooters;
        private final File _inputFile;
        private final boolean _requestHelp;
        private final boolean _showBlankCells;
        private final boolean _showCellComments;
        private final boolean _showSheetNames;

        /* JADX WARN: Code restructure failed: missing block: B:55:0x00f7, code lost:
        
            r13._requestHelp = r1;
            r13._inputFile = r3;
            r13._showSheetNames = r5;
            r13._evaluateFormulas = r6;
            r13._showCellComments = r7;
            r13._showBlankCells = r8;
            r13._headersFooters = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0105, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public CommandArgs(java.lang.String[] r14) throws org.apache.poi.hssf.extractor.ExcelExtractor.CommandParseException {
            /*
                Method dump skipped, instructions count: 262
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.hssf.extractor.ExcelExtractor.CommandArgs.<init>(java.lang.String[]):void");
        }

        private static boolean parseBoolArg(String[] strArr, int i) throws CommandParseException {
            if (i >= strArr.length) {
                throw new CommandParseException("Expected value after '" + strArr[i - 1] + "'");
            }
            String upperCase = strArr[i].toUpperCase();
            if ("Y".equals(upperCase) || "YES".equals(upperCase) || "ON".equals(upperCase) || "TRUE".equals(upperCase)) {
                return true;
            }
            if ("N".equals(upperCase) || "NO".equals(upperCase) || "OFF".equals(upperCase) || "FALSE".equals(upperCase)) {
                return false;
            }
            throw new CommandParseException("Invalid value '" + strArr[i] + "' for '" + strArr[i - 1] + "'. Expected 'Y' or 'N'");
        }

        public boolean isRequestHelp() {
            return this._requestHelp;
        }

        public File getInputFile() {
            return this._inputFile;
        }

        public boolean shouldShowSheetNames() {
            return this._showSheetNames;
        }

        public boolean shouldEvaluateFormulas() {
            return this._evaluateFormulas;
        }

        public boolean shouldShowCellComments() {
            return this._showCellComments;
        }

        public boolean shouldShowBlankCells() {
            return this._showBlankCells;
        }

        public boolean shouldIncludeHeadersFooters() {
            return this._headersFooters;
        }
    }

    private static void printUsageMessage(PrintStream printStream) {
        printStream.println("Use:");
        printStream.println("    " + ExcelExtractor.class.getName() + " [<flag> <value> [<flag> <value> [...]]] [-i <filename.xls>]");
        printStream.println("       -i <filename.xls> specifies input file (default is to use stdin)");
        printStream.println("       Flags can be set on or off by using the values 'Y' or 'N'.");
        printStream.println("       Following are available flags and their default values:");
        printStream.println("       --show-sheet-names  Y");
        printStream.println("       --evaluate-formulas Y");
        printStream.println("       --show-comments     N");
        printStream.println("       --show-blanks       Y");
        printStream.println("       --headers-footers   Y");
    }

    public static void main(String[] strArr) {
        InputStream fileInputStream;
        try {
            CommandArgs commandArgs = new CommandArgs(strArr);
            if (commandArgs.isRequestHelp()) {
                printUsageMessage(System.out);
                return;
            }
            try {
                if (commandArgs.getInputFile() == null) {
                    fileInputStream = System.in;
                } else {
                    fileInputStream = new FileInputStream(commandArgs.getInputFile());
                }
                ExcelExtractor excelExtractor = new ExcelExtractor(new HSSFWorkbook(fileInputStream));
                excelExtractor.setIncludeSheetNames(commandArgs.shouldShowSheetNames());
                excelExtractor.setFormulasNotResults(!commandArgs.shouldEvaluateFormulas());
                excelExtractor.setIncludeCellComments(commandArgs.shouldShowCellComments());
                excelExtractor.setIncludeBlankCells(commandArgs.shouldShowBlankCells());
                excelExtractor.setIncludeHeadersFooters(commandArgs.shouldIncludeHeadersFooters());
                System.out.println(excelExtractor.getText());
                excelExtractor.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        } catch (CommandParseException e2) {
            System.err.println(e2.getMessage());
            printUsageMessage(System.err);
            System.exit(1);
        }
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z) {
        this._includeSheetNames = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z) {
        this._shouldEvaluateFormulas = !z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z) {
        this._includeCellComments = z;
    }

    public void setIncludeBlankCells(boolean z) {
        this._includeBlankCells = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z) {
        this._includeHeadersFooters = z;
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        boolean z;
        String sheetName;
        StringBuffer stringBuffer = new StringBuffer();
        this._wb.setMissingCellPolicy(HSSFRow.RETURN_BLANK_AS_NULL);
        for (int i = 0; i < this._wb.getNumberOfSheets(); i++) {
            HSSFSheet sheetAt = this._wb.getSheetAt(i);
            if (sheetAt != null) {
                if (this._includeSheetNames && (sheetName = this._wb.getSheetName(i)) != null) {
                    stringBuffer.append(sheetName);
                    stringBuffer.append("\n");
                }
                if (this._includeHeadersFooters) {
                    stringBuffer.append(_extractHeaderFooter(sheetAt.getHeader()));
                }
                int lastRowNum = sheetAt.getLastRowNum();
                for (int firstRowNum = sheetAt.getFirstRowNum(); firstRowNum <= lastRowNum; firstRowNum++) {
                    HSSFRow row = sheetAt.getRow(firstRowNum);
                    if (row != null) {
                        int firstCellNum = row.getFirstCellNum();
                        short lastCellNum = row.getLastCellNum();
                        if (this._includeBlankCells) {
                            firstCellNum = 0;
                        }
                        while (firstCellNum < lastCellNum) {
                            HSSFCell cell = row.getCell(firstCellNum);
                            if (cell == null) {
                                z = this._includeBlankCells;
                            } else {
                                int cellType = cell.getCellType();
                                if (cellType == 0) {
                                    stringBuffer.append(this._formatter.formatCellValue(cell));
                                } else if (cellType == 1) {
                                    stringBuffer.append(cell.getRichStringCellValue().getString());
                                } else if (cellType != 2) {
                                    if (cellType == 4) {
                                        stringBuffer.append(cell.getBooleanCellValue());
                                    } else if (cellType == 5) {
                                        stringBuffer.append(ErrorEval.getText(cell.getErrorCellValue()));
                                    } else {
                                        throw new RuntimeException("Unexpected cell type (" + cell.getCellType() + ")");
                                    }
                                } else if (!this._shouldEvaluateFormulas) {
                                    stringBuffer.append(cell.getCellFormula());
                                } else {
                                    int cachedFormulaResultType = cell.getCachedFormulaResultType();
                                    if (cachedFormulaResultType == 0) {
                                        HSSFCellStyle cellStyle = cell.getCellStyle();
                                        if (cellStyle == null) {
                                            stringBuffer.append(cell.getNumericCellValue());
                                        } else {
                                            stringBuffer.append(this._formatter.formatRawCellContents(cell.getNumericCellValue(), cellStyle.getDataFormat(), cellStyle.getDataFormatString()));
                                        }
                                    } else if (cachedFormulaResultType == 1) {
                                        HSSFRichTextString richStringCellValue = cell.getRichStringCellValue();
                                        if (richStringCellValue != null && richStringCellValue.length() > 0) {
                                            stringBuffer.append(richStringCellValue.toString());
                                        }
                                    } else if (cachedFormulaResultType == 4) {
                                        stringBuffer.append(cell.getBooleanCellValue());
                                    } else if (cachedFormulaResultType == 5) {
                                        stringBuffer.append(ErrorEval.getText(cell.getErrorCellValue()));
                                    }
                                }
                                HSSFComment cellComment = cell.getCellComment();
                                if (this._includeCellComments && cellComment != null) {
                                    stringBuffer.append(" Comment by " + cellComment.getAuthor() + ": " + cellComment.getString().getString().replace('\n', ' '));
                                }
                                z = true;
                            }
                            if (z && firstCellNum < lastCellNum - 1) {
                                stringBuffer.append("\t");
                            }
                            firstCellNum++;
                        }
                        stringBuffer.append("\n");
                    }
                }
                if (this._includeHeadersFooters) {
                    stringBuffer.append(_extractHeaderFooter(sheetAt.getFooter()));
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String _extractHeaderFooter(HeaderFooter headerFooter) {
        StringBuffer stringBuffer = new StringBuffer();
        if (headerFooter.getLeft() != null) {
            stringBuffer.append(headerFooter.getLeft());
        }
        if (headerFooter.getCenter() != null) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("\t");
            }
            stringBuffer.append(headerFooter.getCenter());
        }
        if (headerFooter.getRight() != null) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("\t");
            }
            stringBuffer.append(headerFooter.getRight());
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
