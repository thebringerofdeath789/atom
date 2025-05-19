package org.apache.poi.xssf.eventusermodel;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes5.dex */
public class XSSFSheetXMLHandler extends DefaultHandler {
    private String cellRef;
    private Queue<CellReference> commentCellRefs;
    private CommentsTable commentsTable;
    private boolean fIsOpen;
    private short formatIndex;
    private String formatString;
    private final DataFormatter formatter;
    private StringBuffer formula;
    private boolean formulasNotResults;
    private StringBuffer headerFooter;
    private boolean hfIsOpen;
    private boolean isIsOpen;
    private xssfDataType nextDataType;
    private int nextRowNum;
    private final SheetContentsHandler output;
    private int rowNum;
    private ReadOnlySharedStringsTable sharedStringsTable;
    private StylesTable stylesTable;
    private boolean vIsOpen;
    private StringBuffer value;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFSheetXMLHandler.class);
    private static final Comparator<CellReference> cellRefComparator = new Comparator<CellReference>() { // from class: org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.1
        public int compare(int i, int i2) {
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public int compare(CellReference cellReference, CellReference cellReference2) {
            int compare = compare(cellReference.getRow(), cellReference2.getRow());
            return compare == 0 ? compare(cellReference.getCol(), cellReference2.getCol()) : compare;
        }
    };

    private enum EmptyCellCommentsCheckType {
        CELL,
        END_OF_ROW,
        END_OF_SHEET_DATA
    }

    public interface SheetContentsHandler {
        void cell(String str, String str2, XSSFComment xSSFComment);

        void endRow(int i);

        void headerFooter(String str, boolean z, String str2);

        void startRow(int i);
    }

    enum xssfDataType {
        BOOLEAN,
        ERROR,
        FORMULA,
        INLINE_STRING,
        SST_STRING,
        NUMBER
    }

    public XSSFSheetXMLHandler(StylesTable stylesTable, CommentsTable commentsTable, ReadOnlySharedStringsTable readOnlySharedStringsTable, SheetContentsHandler sheetContentsHandler, DataFormatter dataFormatter, boolean z) {
        this.value = new StringBuffer();
        this.formula = new StringBuffer();
        this.headerFooter = new StringBuffer();
        this.stylesTable = stylesTable;
        this.commentsTable = commentsTable;
        this.sharedStringsTable = readOnlySharedStringsTable;
        this.output = sheetContentsHandler;
        this.formulasNotResults = z;
        this.nextDataType = xssfDataType.NUMBER;
        this.formatter = dataFormatter;
        init();
    }

    public XSSFSheetXMLHandler(StylesTable stylesTable, ReadOnlySharedStringsTable readOnlySharedStringsTable, SheetContentsHandler sheetContentsHandler, DataFormatter dataFormatter, boolean z) {
        this(stylesTable, null, readOnlySharedStringsTable, sheetContentsHandler, dataFormatter, z);
    }

    public XSSFSheetXMLHandler(StylesTable stylesTable, ReadOnlySharedStringsTable readOnlySharedStringsTable, SheetContentsHandler sheetContentsHandler, boolean z) {
        this(stylesTable, readOnlySharedStringsTable, sheetContentsHandler, new DataFormatter(), z);
    }

    private void init() {
        if (this.commentsTable != null) {
            this.commentCellRefs = new LinkedList();
            for (CTComment cTComment : this.commentsTable.getCTComments().getCommentList().getCommentArray()) {
                this.commentCellRefs.add(new CellReference(cTComment.getRef()));
            }
        }
    }

    private boolean isTextTag(String str) {
        if ("v".equals(str) || "inlineStr".equals(str)) {
            return true;
        }
        return "t".equals(str) && this.isIsOpen;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (isTextTag(str3)) {
            this.vIsOpen = true;
            this.value.setLength(0);
            return;
        }
        if ("is".equals(str3)) {
            this.isIsOpen = true;
            return;
        }
        if ("f".equals(str3)) {
            this.formula.setLength(0);
            if (this.nextDataType == xssfDataType.NUMBER) {
                this.nextDataType = xssfDataType.FORMULA;
            }
            String value = attributes.getValue("t");
            if (value != null && value.equals("shared")) {
                String value2 = attributes.getValue("ref");
                attributes.getValue("si");
                if (value2 != null) {
                    this.fIsOpen = true;
                    return;
                } else {
                    if (this.formulasNotResults) {
                        logger.log(5, "shared formulas not yet supported!");
                        return;
                    }
                    return;
                }
            }
            this.fIsOpen = true;
            return;
        }
        if ("oddHeader".equals(str3) || "evenHeader".equals(str3) || "firstHeader".equals(str3) || "firstFooter".equals(str3) || "oddFooter".equals(str3) || "evenFooter".equals(str3)) {
            this.hfIsOpen = true;
            this.headerFooter.setLength(0);
            return;
        }
        if ("row".equals(str3)) {
            String value3 = attributes.getValue(InternalZipConstants.READ_MODE);
            if (value3 != null) {
                this.rowNum = Integer.parseInt(value3) - 1;
            } else {
                this.rowNum = this.nextRowNum;
            }
            this.output.startRow(this.rowNum);
            return;
        }
        if ("c".equals(str3)) {
            this.nextDataType = xssfDataType.NUMBER;
            this.formatIndex = (short) -1;
            XSSFCellStyle xSSFCellStyle = null;
            this.formatString = null;
            this.cellRef = attributes.getValue(InternalZipConstants.READ_MODE);
            String value4 = attributes.getValue("t");
            String value5 = attributes.getValue("s");
            if ("b".equals(value4)) {
                this.nextDataType = xssfDataType.BOOLEAN;
                return;
            }
            if ("e".equals(value4)) {
                this.nextDataType = xssfDataType.ERROR;
                return;
            }
            if ("inlineStr".equals(value4)) {
                this.nextDataType = xssfDataType.INLINE_STRING;
                return;
            }
            if ("s".equals(value4)) {
                this.nextDataType = xssfDataType.SST_STRING;
                return;
            }
            if ("str".equals(value4)) {
                this.nextDataType = xssfDataType.FORMULA;
                return;
            }
            if (value5 != null) {
                xSSFCellStyle = this.stylesTable.getStyleAt(Integer.parseInt(value5));
            } else if (this.stylesTable.getNumCellStyles() > 0) {
                xSSFCellStyle = this.stylesTable.getStyleAt(0);
            }
            if (xSSFCellStyle != null) {
                this.formatIndex = xSSFCellStyle.getDataFormat();
                String dataFormatString = xSSFCellStyle.getDataFormatString();
                this.formatString = dataFormatString;
                if (dataFormatString == null) {
                    this.formatString = BuiltinFormats.getBuiltinFormat(this.formatIndex);
                }
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        String str4;
        if (isTextTag(str3)) {
            this.vIsOpen = false;
            switch (AnonymousClass2.$SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[this.nextDataType.ordinal()]) {
                case 1:
                    if (this.value.charAt(0) != '0') {
                        str4 = "TRUE";
                        break;
                    } else {
                        str4 = "FALSE";
                        break;
                    }
                case 2:
                    str4 = "ERROR:" + this.value.toString();
                    break;
                case 3:
                    if (this.formulasNotResults) {
                        str4 = this.formula.toString();
                        break;
                    } else {
                        str4 = this.value.toString();
                        if (this.formatString != null) {
                            try {
                                str4 = this.formatter.formatRawCellContents(Double.parseDouble(str4), this.formatIndex, this.formatString);
                                break;
                            } catch (NumberFormatException unused) {
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    str4 = new XSSFRichTextString(this.value.toString()).toString();
                    break;
                case 5:
                    String stringBuffer = this.value.toString();
                    try {
                        str4 = new XSSFRichTextString(this.sharedStringsTable.getEntryAt(Integer.parseInt(stringBuffer))).toString();
                        break;
                    } catch (NumberFormatException e) {
                        logger.log(7, (Object) ("Failed to parse SST index '" + stringBuffer), (Throwable) e);
                        str4 = null;
                        break;
                    }
                case 6:
                    str4 = this.value.toString();
                    if (this.formatString != null && str4.length() > 0) {
                        str4 = this.formatter.formatRawCellContents(Double.parseDouble(str4), this.formatIndex, this.formatString);
                        break;
                    }
                    break;
                default:
                    str4 = "(TODO: Unexpected type: " + this.nextDataType + ")";
                    break;
            }
            checkForEmptyCellComments(EmptyCellCommentsCheckType.CELL);
            CommentsTable commentsTable = this.commentsTable;
            this.output.cell(this.cellRef, str4, commentsTable != null ? commentsTable.findCellComment(this.cellRef) : null);
            return;
        }
        if ("f".equals(str3)) {
            this.fIsOpen = false;
            return;
        }
        if ("is".equals(str3)) {
            this.isIsOpen = false;
            return;
        }
        if ("row".equals(str3)) {
            checkForEmptyCellComments(EmptyCellCommentsCheckType.END_OF_ROW);
            this.output.endRow(this.rowNum);
            this.nextRowNum = this.rowNum + 1;
            return;
        }
        if ("sheetData".equals(str3)) {
            checkForEmptyCellComments(EmptyCellCommentsCheckType.END_OF_SHEET_DATA);
            return;
        }
        if ("oddHeader".equals(str3) || "evenHeader".equals(str3) || "firstHeader".equals(str3)) {
            this.hfIsOpen = false;
            this.output.headerFooter(this.headerFooter.toString(), true, str3);
        } else if ("oddFooter".equals(str3) || "evenFooter".equals(str3) || "firstFooter".equals(str3)) {
            this.hfIsOpen = false;
            this.output.headerFooter(this.headerFooter.toString(), false, str3);
        }
    }

    /* renamed from: org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType;

        static {
            int[] iArr = new int[xssfDataType.values().length];
            $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType = iArr;
            try {
                iArr[xssfDataType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.INLINE_STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.SST_STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.NUMBER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (this.vIsOpen) {
            this.value.append(cArr, i, i2);
        }
        if (this.fIsOpen) {
            this.formula.append(cArr, i, i2);
        }
        if (this.hfIsOpen) {
            this.headerFooter.append(cArr, i, i2);
        }
    }

    private void checkForEmptyCellComments(EmptyCellCommentsCheckType emptyCellCommentsCheckType) {
        CellReference cellReference;
        Queue<CellReference> queue = this.commentCellRefs;
        if (queue == null || queue.isEmpty()) {
            return;
        }
        if (emptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_SHEET_DATA) {
            while (!this.commentCellRefs.isEmpty()) {
                outputEmptyCellComment(this.commentCellRefs.remove());
            }
            return;
        }
        if (this.cellRef == null) {
            if (emptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_ROW) {
                while (!this.commentCellRefs.isEmpty() && this.commentCellRefs.peek().getRow() == this.rowNum) {
                    outputEmptyCellComment(this.commentCellRefs.remove());
                }
                return;
            }
            throw new IllegalStateException("Cell ref should be null only if there are only empty cells in the row; rowNum: " + this.rowNum);
        }
        do {
            CellReference cellReference2 = new CellReference(this.cellRef);
            CellReference peek = this.commentCellRefs.peek();
            if (emptyCellCommentsCheckType == EmptyCellCommentsCheckType.CELL && cellReference2.equals(peek)) {
                this.commentCellRefs.remove();
                return;
            }
            int compare = cellRefComparator.compare(peek, cellReference2);
            if (compare > 0 && emptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_ROW && peek.getRow() <= this.rowNum) {
                cellReference = this.commentCellRefs.remove();
                outputEmptyCellComment(cellReference);
            } else if (compare >= 0 || emptyCellCommentsCheckType != EmptyCellCommentsCheckType.CELL || peek.getRow() > this.rowNum) {
                cellReference = null;
            } else {
                cellReference = this.commentCellRefs.remove();
                outputEmptyCellComment(cellReference);
            }
            if (cellReference == null) {
                return;
            }
        } while (!this.commentCellRefs.isEmpty());
    }

    private void outputEmptyCellComment(CellReference cellReference) {
        String formatAsString = cellReference.formatAsString();
        this.output.cell(formatAsString, null, this.commentsTable.findCellComment(formatAsString));
    }
}
