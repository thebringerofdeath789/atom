package org.apache.poi.xssf.model;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* loaded from: classes5.dex */
public class ThemesTable extends POIXMLDocumentPart {
    private ThemeDocument theme;

    public ThemesTable(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        try {
            this.theme = ThemeDocument.Factory.parse(packagePart.getInputStream());
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    public ThemesTable(ThemeDocument themeDocument) {
        this.theme = themeDocument;
    }

    public XSSFColor getThemeColor(int i) {
        CTColor lt1;
        byte[] lastClr;
        CTColorScheme clrScheme = this.theme.getTheme().getThemeElements().getClrScheme();
        switch (i) {
            case 0:
                lt1 = clrScheme.getLt1();
                break;
            case 1:
                lt1 = clrScheme.getDk1();
                break;
            case 2:
                lt1 = clrScheme.getLt2();
                break;
            case 3:
                lt1 = clrScheme.getDk2();
                break;
            case 4:
                lt1 = clrScheme.getAccent1();
                break;
            case 5:
                lt1 = clrScheme.getAccent2();
                break;
            case 6:
                lt1 = clrScheme.getAccent3();
                break;
            case 7:
                lt1 = clrScheme.getAccent4();
                break;
            case 8:
                lt1 = clrScheme.getAccent5();
                break;
            case 9:
                lt1 = clrScheme.getAccent6();
                break;
            case 10:
                lt1 = clrScheme.getHlink();
                break;
            case 11:
                lt1 = clrScheme.getFolHlink();
                break;
            default:
                return null;
        }
        if (lt1.isSetSrgbClr()) {
            lastClr = lt1.getSrgbClr().getVal();
        } else {
            if (!lt1.isSetSysClr()) {
                return null;
            }
            lastClr = lt1.getSysClr().getLastClr();
        }
        return new XSSFColor(lastClr);
    }

    public void inheritFromThemeAsRequired(XSSFColor xSSFColor) {
        if (xSSFColor != null && xSSFColor.getCTColor().isSetTheme()) {
            xSSFColor.getCTColor().setRgb(getThemeColor(xSSFColor.getTheme()).getCTColor().getRgb());
        }
    }
}
