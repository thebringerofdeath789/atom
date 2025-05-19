package org.apache.poi.xssf.streaming;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

/* loaded from: classes5.dex */
public class SheetDataWriter {
    private final File _fd;
    private int _lowestIndexOfFlushedRows;
    private int _numberLastFlushedRow;
    private int _numberOfCellsOfLastFlushedRow;
    private int _numberOfFlushedRows;
    private final Writer _out;
    private int _rownum;
    private SharedStringsTable _sharedStringSource;

    public SheetDataWriter() throws IOException {
        this._numberLastFlushedRow = -1;
        File createTempFile = createTempFile();
        this._fd = createTempFile;
        this._out = createWriter(createTempFile);
    }

    public SheetDataWriter(SharedStringsTable sharedStringsTable) throws IOException {
        this();
        this._sharedStringSource = sharedStringsTable;
    }

    public File createTempFile() throws IOException {
        return TempFile.createTempFile("poi-sxssf-sheet", ".xml");
    }

    public Writer createWriter(File file) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
    }

    public void close() throws IOException {
        this._out.flush();
        this._out.close();
    }

    File getTempFile() {
        return this._fd;
    }

    public InputStream getWorksheetXMLInputStream() throws IOException {
        return new FileInputStream(getTempFile());
    }

    public int getNumberOfFlushedRows() {
        return this._numberOfFlushedRows;
    }

    public int getNumberOfCellsOfLastFlushedRow() {
        return this._numberOfCellsOfLastFlushedRow;
    }

    public int getLowestIndexOfFlushedRows() {
        return this._lowestIndexOfFlushedRows;
    }

    public int getLastFlushedRow() {
        return this._numberLastFlushedRow;
    }

    protected void finalize() throws Throwable {
        this._fd.delete();
        super.finalize();
    }

    public void writeRow(int i, SXSSFRow sXSSFRow) throws IOException {
        if (this._numberOfFlushedRows == 0) {
            this._lowestIndexOfFlushedRows = i;
        }
        this._numberLastFlushedRow = Math.max(i, this._numberLastFlushedRow);
        this._numberOfCellsOfLastFlushedRow = sXSSFRow.getLastCellNum();
        this._numberOfFlushedRows++;
        beginRow(i, sXSSFRow);
        Iterator<Cell> allCellsIterator = sXSSFRow.allCellsIterator();
        int i2 = 0;
        while (allCellsIterator.hasNext()) {
            writeCell(i2, allCellsIterator.next());
            i2++;
        }
        endRow();
    }

    void beginRow(int i, SXSSFRow sXSSFRow) throws IOException {
        this._out.write("<row r=\"" + (i + 1) + "\"");
        if (sXSSFRow.hasCustomHeight()) {
            this._out.write(" customHeight=\"true\"  ht=\"" + sXSSFRow.getHeightInPoints() + "\"");
        }
        if (sXSSFRow.getZeroHeight()) {
            this._out.write(" hidden=\"true\"");
        }
        if (sXSSFRow.isFormatted()) {
            this._out.write(" s=\"" + ((int) sXSSFRow._style) + "\"");
            this._out.write(" customFormat=\"1\"");
        }
        if (sXSSFRow.getOutlineLevel() != 0) {
            this._out.write(" outlineLevel=\"" + sXSSFRow.getOutlineLevel() + "\"");
        }
        if (sXSSFRow.getHidden() != null) {
            this._out.write(" hidden=\"" + (sXSSFRow.getHidden().booleanValue() ? "1" : SessionDescription.SUPPORTED_SDP_VERSION) + "\"");
        }
        if (sXSSFRow.getCollapsed() != null) {
            this._out.write(" collapsed=\"" + (sXSSFRow.getCollapsed().booleanValue() ? "1" : SessionDescription.SUPPORTED_SDP_VERSION) + "\"");
        }
        this._out.write(">\n");
        this._rownum = i;
    }

    void endRow() throws IOException {
        this._out.write("</row>\n");
    }

    public void writeCell(int i, Cell cell) throws IOException {
        if (cell == null) {
            return;
        }
        this._out.write("<c r=\"" + new CellReference(this._rownum, i).formatAsString() + "\"");
        CellStyle cellStyle = cell.getCellStyle();
        if (cellStyle.getIndex() != 0) {
            this._out.write(" s=\"" + ((int) cellStyle.getIndex()) + "\"");
        }
        int cellType = cell.getCellType();
        if (cellType == 0) {
            this._out.write(" t=\"n\">");
            this._out.write("<v>" + cell.getNumericCellValue() + "</v>");
        } else if (cellType != 1) {
            if (cellType == 2) {
                this._out.write(">");
                this._out.write("<f>");
                outputQuotedString(cell.getCellFormula());
                this._out.write("</f>");
                if (cell.getCachedFormulaResultType() == 0) {
                    double numericCellValue = cell.getNumericCellValue();
                    if (!Double.isNaN(numericCellValue)) {
                        this._out.write("<v>" + numericCellValue + "</v>");
                    }
                }
            } else if (cellType == 3) {
                this._out.write(">");
            } else if (cellType == 4) {
                this._out.write(" t=\"b\">");
                this._out.write("<v>" + (cell.getBooleanCellValue() ? "1" : SessionDescription.SUPPORTED_SDP_VERSION) + "</v>");
            } else if (cellType == 5) {
                FormulaError forInt = FormulaError.forInt(cell.getErrorCellValue());
                this._out.write(" t=\"e\">");
                this._out.write("<v>" + forInt.getString() + "</v>");
            } else {
                throw new RuntimeException("Huh?");
            }
        } else if (this._sharedStringSource != null) {
            int addEntry = this._sharedStringSource.addEntry(new XSSFRichTextString(cell.getStringCellValue()).getCTRst());
            this._out.write(" t=\"" + STCellType.S.toString() + "\">");
            this._out.write("<v>");
            this._out.write(String.valueOf(addEntry));
            this._out.write("</v>");
        } else {
            this._out.write(" t=\"inlineStr\">");
            this._out.write("<is><t");
            if (hasLeadingTrailingSpaces(cell.getStringCellValue())) {
                this._out.write(" xml:space=\"preserve\"");
            }
            this._out.write(">");
            outputQuotedString(cell.getStringCellValue());
            this._out.write("</t></is>");
        }
        this._out.write("</c>");
    }

    boolean hasLeadingTrailingSpaces(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return Character.isWhitespace(str.charAt(0)) || Character.isWhitespace(str.charAt(str.length() - 1));
    }

    protected void outputQuotedString(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] charArray = str.toCharArray();
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char c = charArray[i2];
            if (c == '\t') {
                if (i2 > i) {
                    this._out.write(charArray, i, i2 - i);
                }
                this._out.write("&#x9;");
            } else if (c == '\n' || c == '\r') {
                if (i2 > i) {
                    this._out.write(charArray, i, i2 - i);
                }
                this._out.write("&#xa;");
            } else {
                if (c == '\"') {
                    if (i2 > i) {
                        this._out.write(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    this._out.write("&quot;");
                } else if (c == '&') {
                    if (i2 > i) {
                        this._out.write(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    this._out.write("&amp;");
                } else if (c == '<') {
                    if (i2 > i) {
                        this._out.write(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    this._out.write("&lt;");
                } else if (c == '>') {
                    if (i2 > i) {
                        this._out.write(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    this._out.write("&gt;");
                } else if (c == 160) {
                    if (i2 > i) {
                        this._out.write(charArray, i, i2 - i);
                    }
                    this._out.write("&#xa0;");
                } else if (c < ' ' || Character.isLowSurrogate(c) || Character.isHighSurrogate(c) || (65534 <= c && c <= 65535)) {
                    if (i2 > i) {
                        this._out.write(charArray, i, i2 - i);
                    }
                    this._out.write(63);
                } else if (c > 127) {
                    if (i2 > i) {
                        this._out.write(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    this._out.write("&#");
                    this._out.write(String.valueOf((int) c));
                    this._out.write(";");
                }
            }
            i = i2 + 1;
        }
        if (i < length) {
            this._out.write(charArray, i, length - i);
        }
    }

    boolean dispose() {
        try {
            this._out.close();
            return this._fd.delete();
        } catch (IOException unused) {
            return false;
        }
    }
}
