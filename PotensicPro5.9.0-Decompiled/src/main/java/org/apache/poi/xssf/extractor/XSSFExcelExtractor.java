package org.apache.poi.xssf.extractor;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;

/* loaded from: classes5.dex */
public class XSSFExcelExtractor extends POIXMLTextExtractor implements ExcelExtractor {
    public static final XSSFRelation[] SUPPORTED_TYPES = {XSSFRelation.WORKBOOK, XSSFRelation.MACRO_TEMPLATE_WORKBOOK, XSSFRelation.MACRO_ADDIN_WORKBOOK, XSSFRelation.TEMPLATE_WORKBOOK, XSSFRelation.MACROS_WORKBOOK};
    private boolean formulasNotResults;
    private boolean includeCellComments;
    private boolean includeHeadersFooters;
    private boolean includeSheetNames;
    private boolean includeTextBoxes;
    private Locale locale;
    private XSSFWorkbook workbook;

    public XSSFExcelExtractor(String str) throws XmlException, OpenXML4JException, IOException {
        this(new XSSFWorkbook(str));
    }

    public XSSFExcelExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        this(new XSSFWorkbook(oPCPackage));
    }

    public XSSFExcelExtractor(XSSFWorkbook xSSFWorkbook) {
        super(xSSFWorkbook);
        this.includeSheetNames = true;
        this.formulasNotResults = false;
        this.includeCellComments = false;
        this.includeHeadersFooters = true;
        this.includeTextBoxes = true;
        this.workbook = xSSFWorkbook;
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XSSFExcelExtractor <filename.xlsx>");
            System.exit(1);
        }
        XSSFExcelExtractor xSSFExcelExtractor = new XSSFExcelExtractor(strArr[0]);
        try {
            System.out.println(xSSFExcelExtractor.getText());
        } finally {
            xSSFExcelExtractor.close();
        }
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z) {
        this.includeSheetNames = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z) {
        this.formulasNotResults = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z) {
        this.includeCellComments = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z) {
        this.includeHeadersFooters = z;
    }

    public void setIncludeTextBoxes(boolean z) {
        this.includeTextBoxes = z;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        DataFormatter dataFormatter;
        XSSFDrawing drawingPatriarch;
        if (this.locale == null) {
            dataFormatter = new DataFormatter();
        } else {
            dataFormatter = new DataFormatter(this.locale);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheetAt = this.workbook.getSheetAt(i);
            if (this.includeSheetNames) {
                stringBuffer.append(this.workbook.getSheetName(i)).append("\n");
            }
            if (this.includeHeadersFooters) {
                stringBuffer.append(extractHeaderFooter(sheetAt.getFirstHeader()));
                stringBuffer.append(extractHeaderFooter(sheetAt.getOddHeader()));
                stringBuffer.append(extractHeaderFooter(sheetAt.getEvenHeader()));
            }
            Iterator<Row> it = sheetAt.iterator();
            while (it.hasNext()) {
                Iterator<Cell> cellIterator = it.next().cellIterator();
                while (cellIterator.hasNext()) {
                    Cell next = cellIterator.next();
                    if (next.getCellType() == 2) {
                        if (this.formulasNotResults) {
                            stringBuffer.append(next.getCellFormula());
                        } else if (next.getCachedFormulaResultType() == 1) {
                            handleStringCell(stringBuffer, next);
                        } else {
                            handleNonStringCell(stringBuffer, next, dataFormatter);
                        }
                    } else if (next.getCellType() == 1) {
                        handleStringCell(stringBuffer, next);
                    } else {
                        handleNonStringCell(stringBuffer, next, dataFormatter);
                    }
                    Comment cellComment = next.getCellComment();
                    if (this.includeCellComments && cellComment != null) {
                        stringBuffer.append(" Comment by ").append(cellComment.getAuthor()).append(": ").append(cellComment.getString().getString().replace('\n', ' '));
                    }
                    if (cellIterator.hasNext()) {
                        stringBuffer.append("\t");
                    }
                }
                stringBuffer.append("\n");
            }
            if (this.includeTextBoxes && (drawingPatriarch = sheetAt.getDrawingPatriarch()) != null) {
                for (XSSFShape xSSFShape : drawingPatriarch.getShapes()) {
                    if (xSSFShape instanceof XSSFSimpleShape) {
                        String text = ((XSSFSimpleShape) xSSFShape).getText();
                        if (text.length() > 0) {
                            stringBuffer.append(text);
                            stringBuffer.append('\n');
                        }
                    }
                }
            }
            if (this.includeHeadersFooters) {
                stringBuffer.append(extractHeaderFooter(sheetAt.getFirstFooter()));
                stringBuffer.append(extractHeaderFooter(sheetAt.getOddFooter()));
                stringBuffer.append(extractHeaderFooter(sheetAt.getEvenFooter()));
            }
        }
        return stringBuffer.toString();
    }

    private void handleStringCell(StringBuffer stringBuffer, Cell cell) {
        stringBuffer.append(cell.getRichStringCellValue().getString());
    }

    private void handleNonStringCell(StringBuffer stringBuffer, Cell cell, DataFormatter dataFormatter) {
        CellStyle cellStyle;
        int cellType = cell.getCellType();
        if (cellType == 2) {
            cellType = cell.getCachedFormulaResultType();
        }
        if (cellType == 0 && (cellStyle = cell.getCellStyle()) != null && cellStyle.getDataFormatString() != null) {
            stringBuffer.append(dataFormatter.formatRawCellContents(cell.getNumericCellValue(), cellStyle.getDataFormat(), cellStyle.getDataFormatString()));
        } else {
            stringBuffer.append(((XSSFCell) cell).getRawValue());
        }
    }

    private String extractHeaderFooter(HeaderFooter headerFooter) {
        return org.apache.poi.hssf.extractor.ExcelExtractor._extractHeaderFooter(headerFooter);
    }
}
