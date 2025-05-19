package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.FontScheme;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument;

/* loaded from: classes5.dex */
public class StylesTable extends POIXMLDocumentPart {
    public static final int FIRST_CUSTOM_STYLE_ID = 165;
    private static final int MAXIMUM_STYLE_ID = SpreadsheetVersion.EXCEL2007.getMaxCellStyles();
    private final List<XSSFCellBorder> borders;
    private StyleSheetDocument doc;
    private final List<CTDxf> dxfs;
    private final List<XSSFCellFill> fills;
    private final List<XSSFFont> fonts;
    private final Map<Integer, String> numberFormats;
    private final List<CTXf> styleXfs;
    private ThemesTable theme;
    private final boolean[] usedNumberFormats;
    private final List<CTXf> xfs;

    public StylesTable() {
        this.numberFormats = new HashMap();
        this.usedNumberFormats = new boolean[SpreadsheetVersion.EXCEL2007.getMaxCellStyles()];
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        StyleSheetDocument newInstance = StyleSheetDocument.Factory.newInstance();
        this.doc = newInstance;
        newInstance.addNewStyleSheet();
        initialize();
    }

    public StylesTable(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        this.numberFormats = new HashMap();
        this.usedNumberFormats = new boolean[SpreadsheetVersion.EXCEL2007.getMaxCellStyles()];
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        readFrom(packagePart.getInputStream());
    }

    public ThemesTable getTheme() {
        return this.theme;
    }

    public void setTheme(ThemesTable themesTable) {
        this.theme = themesTable;
        Iterator<XSSFFont> it = this.fonts.iterator();
        while (it.hasNext()) {
            it.next().setThemesTable(themesTable);
        }
        Iterator<XSSFCellBorder> it2 = this.borders.iterator();
        while (it2.hasNext()) {
            it2.next().setThemesTable(themesTable);
        }
    }

    protected void readFrom(InputStream inputStream) throws IOException {
        try {
            StyleSheetDocument parse = StyleSheetDocument.Factory.parse(inputStream);
            this.doc = parse;
            CTStylesheet styleSheet = parse.getStyleSheet();
            CTNumFmts numFmts = styleSheet.getNumFmts();
            if (numFmts != null) {
                for (CTNumFmt cTNumFmt : numFmts.getNumFmtArray()) {
                    int numFmtId = (int) cTNumFmt.getNumFmtId();
                    this.numberFormats.put(Integer.valueOf(numFmtId), cTNumFmt.getFormatCode());
                    this.usedNumberFormats[numFmtId] = true;
                }
            }
            CTFonts fonts = styleSheet.getFonts();
            if (fonts != null) {
                int i = 0;
                for (CTFont cTFont : fonts.getFontArray()) {
                    this.fonts.add(new XSSFFont(cTFont, i));
                    i++;
                }
            }
            CTFills fills = styleSheet.getFills();
            if (fills != null) {
                for (CTFill cTFill : fills.getFillArray()) {
                    this.fills.add(new XSSFCellFill(cTFill));
                }
            }
            CTBorders borders = styleSheet.getBorders();
            if (borders != null) {
                for (CTBorder cTBorder : borders.getBorderArray()) {
                    this.borders.add(new XSSFCellBorder(cTBorder));
                }
            }
            CTCellXfs cellXfs = styleSheet.getCellXfs();
            if (cellXfs != null) {
                this.xfs.addAll(Arrays.asList(cellXfs.getXfArray()));
            }
            CTCellStyleXfs cellStyleXfs = styleSheet.getCellStyleXfs();
            if (cellStyleXfs != null) {
                this.styleXfs.addAll(Arrays.asList(cellStyleXfs.getXfArray()));
            }
            CTDxfs dxfs = styleSheet.getDxfs();
            if (dxfs != null) {
                this.dxfs.addAll(Arrays.asList(dxfs.getDxfArray()));
            }
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public String getNumberFormatAt(int i) {
        return this.numberFormats.get(Integer.valueOf(i));
    }

    public int putNumberFormat(String str) {
        if (this.numberFormats.containsValue(str)) {
            for (Map.Entry<Integer, String> entry : this.numberFormats.entrySet()) {
                if (entry.getValue().equals(str)) {
                    return entry.getKey().intValue();
                }
            }
            throw new IllegalStateException("Found the format, but couldn't figure out where - should never happen!");
        }
        int i = 165;
        while (true) {
            boolean[] zArr = this.usedNumberFormats;
            if (i < zArr.length) {
                if (!zArr[i]) {
                    zArr[i] = true;
                    this.numberFormats.put(Integer.valueOf(i), str);
                    return i;
                }
                i++;
            } else {
                throw new IllegalStateException("The maximum number of Data Formats was exceeded. You can define up to " + this.usedNumberFormats.length + " formats in a .xlsx Workbook");
            }
        }
    }

    public XSSFFont getFontAt(int i) {
        return this.fonts.get(i);
    }

    public int putFont(XSSFFont xSSFFont, boolean z) {
        int indexOf = !z ? this.fonts.indexOf(xSSFFont) : -1;
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.fonts.size();
        this.fonts.add(xSSFFont);
        return size;
    }

    public int putFont(XSSFFont xSSFFont) {
        return putFont(xSSFFont, false);
    }

    public XSSFCellStyle getStyleAt(int i) {
        return new XSSFCellStyle(i, this.xfs.get(i).getXfId() > 0 ? (int) this.xfs.get(i).getXfId() : 0, this, this.theme);
    }

    public int putStyle(XSSFCellStyle xSSFCellStyle) {
        CTXf coreXf = xSSFCellStyle.getCoreXf();
        if (!this.xfs.contains(coreXf)) {
            this.xfs.add(coreXf);
        }
        return this.xfs.indexOf(coreXf);
    }

    public XSSFCellBorder getBorderAt(int i) {
        return this.borders.get(i);
    }

    public int putBorder(XSSFCellBorder xSSFCellBorder) {
        int indexOf = this.borders.indexOf(xSSFCellBorder);
        if (indexOf != -1) {
            return indexOf;
        }
        this.borders.add(xSSFCellBorder);
        xSSFCellBorder.setThemesTable(this.theme);
        return this.borders.size() - 1;
    }

    public XSSFCellFill getFillAt(int i) {
        return this.fills.get(i);
    }

    public List<XSSFCellBorder> getBorders() {
        return this.borders;
    }

    public List<XSSFCellFill> getFills() {
        return this.fills;
    }

    public List<XSSFFont> getFonts() {
        return this.fonts;
    }

    public Map<Integer, String> getNumberFormats() {
        return this.numberFormats;
    }

    public int putFill(XSSFCellFill xSSFCellFill) {
        int indexOf = this.fills.indexOf(xSSFCellFill);
        if (indexOf != -1) {
            return indexOf;
        }
        this.fills.add(xSSFCellFill);
        return this.fills.size() - 1;
    }

    public CTXf getCellXfAt(int i) {
        return this.xfs.get(i);
    }

    public int putCellXf(CTXf cTXf) {
        this.xfs.add(cTXf);
        return this.xfs.size();
    }

    public void replaceCellXfAt(int i, CTXf cTXf) {
        this.xfs.set(i, cTXf);
    }

    public CTXf getCellStyleXfAt(int i) {
        if (i < this.styleXfs.size()) {
            return this.styleXfs.get(i);
        }
        return null;
    }

    public int putCellStyleXf(CTXf cTXf) {
        this.styleXfs.add(cTXf);
        return this.styleXfs.size();
    }

    public void replaceCellStyleXfAt(int i, CTXf cTXf) {
        this.styleXfs.set(i, cTXf);
    }

    public int getNumCellStyles() {
        return this.xfs.size();
    }

    public int _getNumberFormatSize() {
        return this.numberFormats.size();
    }

    public int _getXfsSize() {
        return this.xfs.size();
    }

    public int _getStyleXfsSize() {
        return this.styleXfs.size();
    }

    public CTStylesheet getCTStylesheet() {
        return this.doc.getStyleSheet();
    }

    public int _getDXfsSize() {
        return this.dxfs.size();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        CTStylesheet styleSheet = this.doc.getStyleSheet();
        CTNumFmts newInstance = CTNumFmts.Factory.newInstance();
        newInstance.setCount(this.numberFormats.size());
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.usedNumberFormats;
            if (i2 >= zArr.length) {
                break;
            }
            if (zArr[i2]) {
                CTNumFmt addNewNumFmt = newInstance.addNewNumFmt();
                addNewNumFmt.setNumFmtId(i2);
                addNewNumFmt.setFormatCode(this.numberFormats.get(Integer.valueOf(i2)));
            }
            i2++;
        }
        styleSheet.setNumFmts(newInstance);
        CTFonts fonts = styleSheet.getFonts();
        if (fonts == null) {
            fonts = CTFonts.Factory.newInstance();
        }
        fonts.setCount(this.fonts.size());
        CTFont[] cTFontArr = new CTFont[this.fonts.size()];
        Iterator<XSSFFont> it = this.fonts.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            cTFontArr[i3] = it.next().getCTFont();
            i3++;
        }
        fonts.setFontArray(cTFontArr);
        styleSheet.setFonts(fonts);
        CTFills fills = styleSheet.getFills();
        if (fills == null) {
            fills = CTFills.Factory.newInstance();
        }
        fills.setCount(this.fills.size());
        CTFill[] cTFillArr = new CTFill[this.fills.size()];
        Iterator<XSSFCellFill> it2 = this.fills.iterator();
        int i4 = 0;
        while (it2.hasNext()) {
            cTFillArr[i4] = it2.next().getCTFill();
            i4++;
        }
        fills.setFillArray(cTFillArr);
        styleSheet.setFills(fills);
        CTBorders borders = styleSheet.getBorders();
        if (borders == null) {
            borders = CTBorders.Factory.newInstance();
        }
        borders.setCount(this.borders.size());
        CTBorder[] cTBorderArr = new CTBorder[this.borders.size()];
        Iterator<XSSFCellBorder> it3 = this.borders.iterator();
        while (it3.hasNext()) {
            cTBorderArr[i] = it3.next().getCTBorder();
            i++;
        }
        borders.setBorderArray(cTBorderArr);
        styleSheet.setBorders(borders);
        if (this.xfs.size() > 0) {
            CTCellXfs cellXfs = styleSheet.getCellXfs();
            if (cellXfs == null) {
                cellXfs = CTCellXfs.Factory.newInstance();
            }
            cellXfs.setCount(this.xfs.size());
            List<CTXf> list = this.xfs;
            cellXfs.setXfArray((CTXf[]) list.toArray(new CTXf[list.size()]));
            styleSheet.setCellXfs(cellXfs);
        }
        if (this.styleXfs.size() > 0) {
            CTCellStyleXfs cellStyleXfs = styleSheet.getCellStyleXfs();
            if (cellStyleXfs == null) {
                cellStyleXfs = CTCellStyleXfs.Factory.newInstance();
            }
            cellStyleXfs.setCount(this.styleXfs.size());
            List<CTXf> list2 = this.styleXfs;
            cellStyleXfs.setXfArray((CTXf[]) list2.toArray(new CTXf[list2.size()]));
            styleSheet.setCellStyleXfs(cellStyleXfs);
        }
        if (this.dxfs.size() > 0) {
            CTDxfs dxfs = styleSheet.getDxfs();
            if (dxfs == null) {
                dxfs = CTDxfs.Factory.newInstance();
            }
            dxfs.setCount(this.dxfs.size());
            List<CTDxf> list3 = this.dxfs;
            dxfs.setDxfArray((CTDxf[]) list3.toArray(new CTDxf[list3.size()]));
            styleSheet.setDxfs(dxfs);
        }
        this.doc.save(outputStream, xmlOptions);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    private void initialize() {
        this.fonts.add(createDefaultFont());
        CTFill[] createDefaultFills = createDefaultFills();
        this.fills.add(new XSSFCellFill(createDefaultFills[0]));
        this.fills.add(new XSSFCellFill(createDefaultFills[1]));
        this.borders.add(new XSSFCellBorder(createDefaultBorder()));
        this.styleXfs.add(createDefaultXf());
        CTXf createDefaultXf = createDefaultXf();
        createDefaultXf.setXfId(0L);
        this.xfs.add(createDefaultXf);
    }

    private static CTXf createDefaultXf() {
        CTXf newInstance = CTXf.Factory.newInstance();
        newInstance.setNumFmtId(0L);
        newInstance.setFontId(0L);
        newInstance.setFillId(0L);
        newInstance.setBorderId(0L);
        return newInstance;
    }

    private static CTBorder createDefaultBorder() {
        CTBorder newInstance = CTBorder.Factory.newInstance();
        newInstance.addNewBottom();
        newInstance.addNewTop();
        newInstance.addNewLeft();
        newInstance.addNewRight();
        newInstance.addNewDiagonal();
        return newInstance;
    }

    private static CTFill[] createDefaultFills() {
        CTFill[] cTFillArr = {CTFill.Factory.newInstance(), CTFill.Factory.newInstance()};
        cTFillArr[0].addNewPatternFill().setPatternType(STPatternType.NONE);
        cTFillArr[1].addNewPatternFill().setPatternType(STPatternType.DARK_GRAY);
        return cTFillArr;
    }

    private static XSSFFont createDefaultFont() {
        XSSFFont xSSFFont = new XSSFFont(CTFont.Factory.newInstance(), 0);
        xSSFFont.setFontHeightInPoints((short) 11);
        xSSFFont.setColor(XSSFFont.DEFAULT_FONT_COLOR);
        xSSFFont.setFontName(XSSFFont.DEFAULT_FONT_NAME);
        xSSFFont.setFamily(FontFamily.SWISS);
        xSSFFont.setScheme(FontScheme.MINOR);
        return xSSFFont;
    }

    public CTDxf getDxfAt(int i) {
        return this.dxfs.get(i);
    }

    public int putDxf(CTDxf cTDxf) {
        this.dxfs.add(cTDxf);
        return this.dxfs.size();
    }

    public XSSFCellStyle createCellStyle() {
        int size = this.styleXfs.size();
        int i = MAXIMUM_STYLE_ID;
        if (size > i) {
            throw new IllegalStateException("The maximum number of Cell Styles was exceeded. You can define up to " + i + " style in a .xlsx Workbook");
        }
        CTXf newInstance = CTXf.Factory.newInstance();
        newInstance.setNumFmtId(0L);
        newInstance.setFontId(0L);
        newInstance.setFillId(0L);
        newInstance.setBorderId(0L);
        newInstance.setXfId(0L);
        return new XSSFCellStyle(putCellXf(newInstance) - 1, size - 1, this, this.theme);
    }

    public XSSFFont findFont(short s, short s2, short s3, String str, boolean z, boolean z2, short s4, byte b) {
        for (XSSFFont xSSFFont : this.fonts) {
            if (xSSFFont.getBoldweight() == s && xSSFFont.getColor() == s2 && xSSFFont.getFontHeight() == s3 && xSSFFont.getFontName().equals(str) && xSSFFont.getItalic() == z && xSSFFont.getStrikeout() == z2 && xSSFFont.getTypeOffset() == s4 && xSSFFont.getUnderline() == b) {
                return xSSFFont;
            }
        }
        return null;
    }
}
