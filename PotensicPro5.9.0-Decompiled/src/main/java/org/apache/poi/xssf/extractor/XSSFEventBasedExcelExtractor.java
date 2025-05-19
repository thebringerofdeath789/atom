package org.apache.poi.xssf.extractor;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.xmlbeans.XmlException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: classes5.dex */
public class XSSFEventBasedExcelExtractor extends POIXMLTextExtractor implements ExcelExtractor {
    private OPCPackage container;
    private boolean formulasNotResults;
    private boolean includeCellComments;
    private boolean includeHeadersFooters;
    private boolean includeSheetNames;
    private boolean includeTextBoxes;
    private Locale locale;
    private POIXMLProperties properties;

    public XSSFEventBasedExcelExtractor(String str) throws XmlException, OpenXML4JException, IOException {
        this(OPCPackage.open(str));
    }

    public XSSFEventBasedExcelExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        super(null);
        this.includeTextBoxes = true;
        this.includeSheetNames = true;
        this.includeCellComments = false;
        this.includeHeadersFooters = true;
        this.formulasNotResults = false;
        this.container = oPCPackage;
        this.properties = new POIXMLProperties(oPCPackage);
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XSSFEventBasedExcelExtractor <filename.xlsx>");
            System.exit(1);
        }
        XSSFEventBasedExcelExtractor xSSFEventBasedExcelExtractor = new XSSFEventBasedExcelExtractor(strArr[0]);
        System.out.println(xSSFEventBasedExcelExtractor.getText());
        xSSFEventBasedExcelExtractor.close();
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
    public void setIncludeHeadersFooters(boolean z) {
        this.includeHeadersFooters = z;
    }

    public void setIncludeTextBoxes(boolean z) {
        this.includeTextBoxes = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z) {
        this.includeCellComments = z;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // org.apache.poi.POIXMLTextExtractor
    public OPCPackage getPackage() {
        return this.container;
    }

    @Override // org.apache.poi.POIXMLTextExtractor
    public POIXMLProperties.CoreProperties getCoreProperties() {
        return this.properties.getCoreProperties();
    }

    @Override // org.apache.poi.POIXMLTextExtractor
    public POIXMLProperties.ExtendedProperties getExtendedProperties() {
        return this.properties.getExtendedProperties();
    }

    @Override // org.apache.poi.POIXMLTextExtractor
    public POIXMLProperties.CustomProperties getCustomProperties() {
        return this.properties.getCustomProperties();
    }

    public void processSheet(XSSFSheetXMLHandler.SheetContentsHandler sheetContentsHandler, StylesTable stylesTable, CommentsTable commentsTable, ReadOnlySharedStringsTable readOnlySharedStringsTable, InputStream inputStream) throws IOException, SAXException {
        DataFormatter dataFormatter;
        if (this.locale == null) {
            dataFormatter = new DataFormatter();
        } else {
            dataFormatter = new DataFormatter(this.locale);
        }
        DataFormatter dataFormatter2 = dataFormatter;
        InputSource inputSource = new InputSource(inputStream);
        try {
            XMLReader newXMLReader = SAXHelper.newXMLReader();
            newXMLReader.setContentHandler(new XSSFSheetXMLHandler(stylesTable, commentsTable, readOnlySharedStringsTable, sheetContentsHandler, dataFormatter2, this.formulasNotResults));
            newXMLReader.parse(inputSource);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        try {
            ReadOnlySharedStringsTable readOnlySharedStringsTable = new ReadOnlySharedStringsTable(this.container);
            XSSFReader xSSFReader = new XSSFReader(this.container);
            StylesTable stylesTable = xSSFReader.getStylesTable();
            XSSFReader.SheetIterator sheetIterator = (XSSFReader.SheetIterator) xSSFReader.getSheetsData();
            StringBuffer stringBuffer = new StringBuffer();
            SheetTextExtractor sheetTextExtractor = new SheetTextExtractor();
            while (sheetIterator.hasNext()) {
                InputStream next = sheetIterator.next();
                if (this.includeSheetNames) {
                    stringBuffer.append(sheetIterator.getSheetName());
                    stringBuffer.append('\n');
                }
                processSheet(sheetTextExtractor, stylesTable, this.includeCellComments ? sheetIterator.getSheetComments() : null, readOnlySharedStringsTable, next);
                if (this.includeHeadersFooters) {
                    sheetTextExtractor.appendHeaderText(stringBuffer);
                }
                sheetTextExtractor.appendCellText(stringBuffer);
                if (this.includeTextBoxes) {
                    processShapes(sheetIterator.getShapes(), stringBuffer);
                }
                if (this.includeHeadersFooters) {
                    sheetTextExtractor.appendFooterText(stringBuffer);
                }
                sheetTextExtractor.reset();
                next.close();
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            System.err.println(e);
            return null;
        } catch (OpenXML4JException e2) {
            System.err.println(e2);
            return null;
        } catch (SAXException e3) {
            System.err.println(e3);
            return null;
        }
    }

    private void processShapes(List<XSSFShape> list, StringBuffer stringBuffer) {
        String text;
        if (list == null) {
            return;
        }
        for (XSSFShape xSSFShape : list) {
            if ((xSSFShape instanceof XSSFSimpleShape) && (text = ((XSSFSimpleShape) xSSFShape).getText()) != null && text.length() > 0) {
                stringBuffer.append(text).append('\n');
            }
        }
    }

    @Override // org.apache.poi.POIXMLTextExtractor, org.apache.poi.POITextExtractor, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OPCPackage oPCPackage = this.container;
        if (oPCPackage != null) {
            oPCPackage.close();
            this.container = null;
        }
        super.close();
    }

    protected class SheetTextExtractor implements XSSFSheetXMLHandler.SheetContentsHandler {
        private final Map<String, String> headerFooterMap;
        private final StringBuffer output = new StringBuffer();
        private boolean firstCellOfRow = true;

        protected SheetTextExtractor() {
            this.headerFooterMap = XSSFEventBasedExcelExtractor.this.includeHeadersFooters ? new HashMap() : null;
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void startRow(int i) {
            this.firstCellOfRow = true;
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void endRow(int i) {
            this.output.append('\n');
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void cell(String str, String str2, XSSFComment xSSFComment) {
            if (this.firstCellOfRow) {
                this.firstCellOfRow = false;
            } else {
                this.output.append('\t');
            }
            if (str2 != null) {
                this.output.append(str2);
            }
            if (!XSSFEventBasedExcelExtractor.this.includeCellComments || xSSFComment == null) {
                return;
            }
            String replace = xSSFComment.getString().getString().replace('\n', ' ');
            this.output.append(str2 != null ? " Comment by " : "Comment by ");
            if (replace.startsWith(xSSFComment.getAuthor() + ": ")) {
                this.output.append(replace);
            } else {
                this.output.append(xSSFComment.getAuthor()).append(": ").append(replace);
            }
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void headerFooter(String str, boolean z, String str2) {
            Map<String, String> map = this.headerFooterMap;
            if (map != null) {
                map.put(str2, str);
            }
        }

        private void appendHeaderFooterText(StringBuffer stringBuffer, String str) {
            String str2 = this.headerFooterMap.get(str);
            if (str2 == null || str2.length() <= 0) {
                return;
            }
            stringBuffer.append(handleHeaderFooterDelimiter(handleHeaderFooterDelimiter(handleHeaderFooterDelimiter(str2, "&L"), "&C"), "&R")).append('\n');
        }

        private String handleHeaderFooterDelimiter(String str, String str2) {
            int indexOf = str.indexOf(str2);
            if (indexOf == 0) {
                return str.substring(2);
            }
            return indexOf > 0 ? str.substring(0, indexOf) + "\t" + str.substring(indexOf + 2) : str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendHeaderText(StringBuffer stringBuffer) {
            appendHeaderFooterText(stringBuffer, "firstHeader");
            appendHeaderFooterText(stringBuffer, "oddHeader");
            appendHeaderFooterText(stringBuffer, "evenHeader");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendFooterText(StringBuffer stringBuffer) {
            appendHeaderFooterText(stringBuffer, "firstFooter");
            appendHeaderFooterText(stringBuffer, "oddFooter");
            appendHeaderFooterText(stringBuffer, "evenFooter");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendCellText(StringBuffer stringBuffer) {
            stringBuffer.append(this.output);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.output.setLength(0);
            this.firstCellOfRow = true;
            Map<String, String> map = this.headerFooterMap;
            if (map != null) {
                map.clear();
            }
        }
    }
}
